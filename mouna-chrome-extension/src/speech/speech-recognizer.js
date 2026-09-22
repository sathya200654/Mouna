/**
 * Mouna - Speech Recognizer
 * Continuous real-time speech recognition supporting 9 Indian languages via Web Speech API.
 */

class SpeechRecognizer {
  constructor() {
    this.recognition = null;
    this.isListening = false;
    this.currentLanguage = 'en-IN';
    this.shouldRestart = false;

    // Supported 9 Indian Languages
    this.languages = [
      { code: 'en-IN', name: 'English (India)', nativeName: 'English' },
      { code: 'hi-IN', name: 'Hindi', nativeName: 'हिंदी' },
      { code: 'ta-IN', name: 'Tamil', nativeName: 'தமிழ்' },
      { code: 'te-IN', name: 'Telugu', nativeName: 'తెలుగు' },
      { code: 'kn-IN', name: 'Kannada', nativeName: 'ಕನ್ನಡ' },
      { code: 'ml-IN', name: 'Malayalam', nativeName: 'മലയാളം' },
      { code: 'gu-IN', name: 'Gujarati', nativeName: 'ગુજરાતી' },
      { code: 'mr-IN', name: 'Marathi', nativeName: 'मराठी' },
      { code: 'pa-IN', name: 'Punjabi', nativeName: 'ਪੰਜਾਬੀ' }
    ];

    // Callbacks (supporting both onTranscript and onResult interfaces)
    this.onResult = null;       // (transcript, isFinal, language)
    this.onTranscript = null;   // (transcript, isFinal)
    this.onError = null;        // (errorMessage, errorType)
    this.onStatusChange = null; // (isListening)
    this.onStateChange = null;  // ({ isListening })

    this.init();
  }

  init() {
    const SpeechAPI = window.SpeechRecognition || window.webkitSpeechRecognition;

    if (!SpeechAPI) {
      console.warn('[Mouna SpeechRecognizer] Web Speech API not supported in this environment.');
      return;
    }

    this.recognition = new SpeechAPI();
    this.recognition.continuous = true;
    this.recognition.interimResults = true;
    this.recognition.maxAlternatives = 1;
    this.recognition.lang = this.currentLanguage;

    this.recognition.onstart = () => {
      this.isListening = true;
      if (this.onStatusChange) this.onStatusChange(true);
      if (this.onStateChange) this.onStateChange({ isListening: true });
    };

    this.recognition.onresult = (event) => {
      let interimTranscript = '';
      let finalTranscript = '';

      for (let i = event.resultIndex; i < event.results.length; ++i) {
        const res = event.results[i];
        const text = res[0].transcript;

        if (res.isFinal) {
          finalTranscript += text + ' ';
        } else {
          interimTranscript += text;
        }
      }

      const finalText = finalTranscript.trim();
      const interimText = interimTranscript.trim();

      if (finalText.length > 0) {
        if (this.onResult) this.onResult(finalText, true, this.currentLanguage);
        if (this.onTranscript) this.onTranscript(finalText, true);
      } else if (interimText.length > 0) {
        if (this.onResult) this.onResult(interimText, false, this.currentLanguage);
        if (this.onTranscript) this.onTranscript(interimText, false);
      }
    };

    this.recognition.onerror = (event) => {
      console.error('[Mouna SpeechRecognizer] Recognition error:', event.error);
      let userMsg = `Speech recognition error: ${event.error}`;

      if (event.error === 'not-allowed') {
        userMsg = 'Microphone access denied. Please allow microphone access in Chrome.';
      } else if (event.error === 'no-speech') {
        return;
      } else if (event.error === 'network') {
        userMsg = 'Network error during speech recognition.';
      }

      if (this.onError) {
        this.onError(userMsg, event.error);
      }
    };

    this.recognition.onend = () => {
      this.isListening = false;
      if (this.onStatusChange) this.onStatusChange(false);
      if (this.onStateChange) this.onStateChange({ isListening: false });

      // Auto-restart if user still has speech recognition enabled
      if (this.shouldRestart) {
        try {
          this.recognition.start();
        } catch (err) {
          // Will retry on next tick
          setTimeout(() => {
            if (this.shouldRestart && !this.isListening) {
              try { this.recognition.start(); } catch (e) {}
            }
          }, 300);
        }
      }
    };
  }

  /**
   * Sets the recognition language code.
   * @param {string} langCode - e.g. 'hi-IN', 'ta-IN', 'en-IN'
   */
  setLanguage(langCode) {
    this.currentLanguage = langCode || 'en-IN';
    if (this.recognition) {
      this.recognition.lang = this.currentLanguage;
      if (this.isListening) {
        // Restart with new language
        this.stop();
        setTimeout(() => this.start(), 300);
      }
    }
  }

  /**
   * Starts speech recognition.
   */
  start() {
    if (!this.recognition) {
      this.init();
    }
    if (!this.recognition) {
      if (this.onError) {
        this.onError('Speech Recognition API is not supported in this browser.', 'unsupported');
      }
      return;
    }

    this.shouldRestart = true;
    if (!this.isListening) {
      try {
        this.recognition.lang = this.currentLanguage;
        this.recognition.start();
      } catch (err) {
        console.warn('[Mouna SpeechRecognizer] Error starting recognition:', err);
      }
    }
  }

  /**
   * Stops speech recognition.
   */
  stop() {
    this.shouldRestart = false;
    this.isListening = false;
    if (this.recognition) {
      try {
        this.recognition.stop();
      } catch (err) {
        // Already stopped
      }
    }
  }
}

if (typeof window !== 'undefined') {
  window.SpeechRecognizer = SpeechRecognizer;
}
