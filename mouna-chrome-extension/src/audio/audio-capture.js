/**
 * Mouna - Audio Manager & Tab Audio Capture
 * Manages browser tab audio capturing via Chrome TabCapture API,
 * maintains Web Audio routing to prevent muting, and calculates live volume/VU metering.
 */

class AudioManager {
  constructor() {
    this.stream = null;
    this.audioContext = null;
    this.sourceNode = null;
    this.analyserNode = null;
    this.isCapturing = false;
    this.meterInterval = null;
    this.onVolumeChange = null;
    this.onError = null;
    this.onStateChange = null;
  }

  /**
   * Starts capturing the current tab's audio.
   * Note: chrome.tabCapture must be initiated from a user gesture in popup or extension page.
   * @param {Object} options
   * @param {boolean} options.loopbackToSpeakers - If true, pipes tab audio back to speaker output
   * @returns {Promise<MediaStream>}
   */
  async startTabCapture(options = { loopbackToSpeakers: true }) {
    if (this.isCapturing) {
      console.warn('[Mouna AudioManager] Tab capture is already active.');
      return this.stream;
    }

    return new Promise((resolve, reject) => {
      if (typeof chrome === 'undefined' || !chrome.tabCapture || !chrome.tabCapture.capture) {
        const err = new Error('Chrome tabCapture API is not available in this context.');
        if (this.onError) this.onError(err);
        return reject(err);
      }

      chrome.tabCapture.capture({ audio: true, video: false }, (stream) => {
        if (chrome.runtime.lastError || !stream) {
          const errMsg = chrome.runtime.lastError ? chrome.runtime.lastError.message : 'Failed to capture tab audio stream.';
          const error = new Error(errMsg);
          console.error('[Mouna AudioManager] Tab capture error:', error);
          if (this.onError) this.onError(error);
          return reject(error);
        }

        this.stream = stream;
        this.isCapturing = true;

        try {
          const AudioContextClass = window.AudioContext || window.webkitAudioContext;
          this.audioContext = new AudioContextClass();
          this.sourceNode = this.audioContext.createMediaStreamSource(stream);

          // Connect to analyser for volume metering
          this.analyserNode = this.audioContext.createAnalyser();
          this.analyserNode.fftSize = 256;
          this.sourceNode.connect(this.analyserNode);

          // Connect back to destination so tab audio continues to play aloud for user
          if (options.loopbackToSpeakers) {
            this.sourceNode.connect(this.audioContext.destination);
          }

          this._startVolumeMeter();

          if (this.onStateChange) {
            this.onStateChange({ isCapturing: true, stream: this.stream });
          }

          resolve(this.stream);
        } catch (e) {
          console.error('[Mouna AudioManager] Web Audio setup error:', e);
          this.stop();
          if (this.onError) this.onError(e);
          reject(e);
        }
      });
    });
  }

  /**
   * Computes RMS volume for visual audio activity indication (VU meter)
   */
  _startVolumeMeter() {
    if (!this.analyserNode) return;
    const dataArray = new Uint8Array(this.analyserNode.frequencyBinCount);

    this.meterInterval = setInterval(() => {
      if (!this.analyserNode || !this.isCapturing) return;
      this.analyserNode.getByteFrequencyData(dataArray);

      let sum = 0;
      for (let i = 0; i < dataArray.length; i++) {
        sum += dataArray[i];
      }
      const avg = sum / dataArray.length;
      const normalizedVolume = Math.min(1, avg / 128); // 0.0 to 1.0

      if (this.onVolumeChange) {
        this.onVolumeChange(normalizedVolume);
      }
    }, 100);
  }

  /**
   * Stops tab capture and releases all audio tracks & contexts
   */
  stop() {
    if (this.meterInterval) {
      clearInterval(this.meterInterval);
      this.meterInterval = null;
    }

    if (this.stream) {
      this.stream.getTracks().forEach(track => {
        try { track.stop(); } catch (e) {}
      });
      this.stream = null;
    }

    if (this.audioContext) {
      try {
        this.audioContext.close();
      } catch (e) {}
      this.audioContext = null;
    }

    this.sourceNode = null;
    this.analyserNode = null;
    this.isCapturing = false;

    if (this.onStateChange) {
      this.onStateChange({ isCapturing: false, stream: null });
    }
  }
}

if (typeof window !== 'undefined') {
  window.AudioManager = AudioManager;
}
if (typeof module !== 'undefined' && module.exports) {
  module.exports = AudioManager;
}
