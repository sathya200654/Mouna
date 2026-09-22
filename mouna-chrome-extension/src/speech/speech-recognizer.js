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

    // Callbacks
    this.onResult = null;       // (transcript, isFinal, language)
    this.onError = null;        // (errorMessage, errorType)
    this.onStatusChange = null; // (isListening)

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
      if (this.onStatusChange) {
        this.onStatusChange(true);
      }
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

      if (this.onResult) {
        if (finalTranscript.trim().length > 0) {
          this.onResult(finalTranscript.trim(), true, this.currentLanguage);
        } else if (interimTranscript.trim().length > 0) {
          this.onResult(interimTranscript.trim(), false, this.currentLanguage);
        }
      }
    };

    this.recognition.onerror = (event) => {
      console.error('[Mouna SpeechRecognizer] Recognition error:', event.error);
      let userMsg = `Speech recognition error: ${event.error}`;

      if (event.error === 'not-allowed') {
        userMsg = 'Microphone access denied. Please click the microphone icon in Chrome URL bar and allow access.';
      } else if (event.error === 'no-speech') {
        // Normal when user pauses speaking, continue
        return;
      } else if (event.error === 'network') {
        userMsg = 'Network error occurred during speech recognition.';
      }

      if (this.onError) {
        this.onError(userMsg, event.error);
      }
    };

    this.recognition.onend = () => {
      this.isListening = false;
      if (this.onStatusChange) {
        this.onStatusChange(false);
      }

      // Auto-restart if user still has speech recognition enabled
      if (this.shouldRestart) {
        try {
          this.recognition.start();
        } catch (err) {
          // Will retry on user interaction
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
