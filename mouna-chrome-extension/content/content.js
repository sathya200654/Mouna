/**
 * Mouna - Content Script Main Coordinator
 * Integrates 3D Avatar Rendering, Sign Processing Pipeline, 9-Language Mapping,
 * Continuous Speech Recognition, and the Floating In-Page Overlay.
 */

(function () {
  // Prevent duplicate injection or running inside nested ad iframes
  if (window !== window.top) return;
  if (window.__mouna_initialized) return;
  window.__mouna_initialized = true;

  console.log('[Mouna] Initializing in-page Speech-to-Sign Language assistant...');

  // State
  let isActive = false;
  let currentLanguage = 'en';
  let currentSpeed = 1.0;
  let isAvatarReady = false;
  let lastProcessedWordCount = 0;

  // Components
  const signProcessor = new window.SignProcessor();
  const signMapper = new window.SignMapper();
  const animationQueue = new window.AnimationQueue();
  const overlay = new window.MounaOverlay();
  const speechRecognizer = new window.SpeechRecognizer();

  // Mount Overlay DOM
  overlay.mount();

  // Setup Three.js WebGL Scene
  const canvas = overlay.getCanvas();
  const renderer = new window.AvatarRenderer(canvas);
  renderer.init();

  const avatarLoader = new window.AvatarLoader(renderer.getScene());
  const animationController = new window.AnimationController(renderer.getScene(), animationQueue);

  // Link Renderer loop with AnimationController updates
  renderer.onUpdate = (delta) => {
    animationController.update(delta);
  };

  // Load extracted 3D Arya model (GLB with 85 skeletal sign animations)
  const modelUrl = chrome.runtime.getURL('assets/models/arya-signs.glb');
  overlay.setLoading(true, 'Loading Arya 3D Avatar (85 ISL Signs)...');

  avatarLoader.load(
    modelUrl,
    (loaded, total) => {
      if (total > 0) {
        const pct = Math.round((loaded / total) * 100);
        overlay.setLoading(true, `Loading Arya Avatar: ${pct}%`);
      }
    },
    (model, clips) => {
      console.log(`[Mouna] 3D Avatar loaded successfully. ${clips.length} animation clips registered.`);
      animationController.init(model, clips);
      isAvatarReady = true;
      overlay.setLoading(false);
      overlay.setStatus('idle', 'Ready');
    },
    (error) => {
      console.error('[Mouna] Failed to load 3D Avatar model:', error);
      overlay.setLoading(true, 'Error loading 3D avatar. Please reload page.');
      overlay.setStatus('idle', 'Avatar Load Error');
    }
  );

  // Animation Controller Event Handlers
  animationController.onSignStart = (signData) => {
    const displayName = signData.originalWord || signData.signName || signData.clipName;
    overlay.setCurrentSign(displayName);
    overlay.setStatus('signing', `Signing: ${displayName}`);
  };

  animationController.onQueueEmpty = () => {
    overlay.setCurrentSign(null);
    if (isActive) {
      overlay.setStatus('listening', 'Listening');
    } else {
      overlay.setStatus('idle', 'Standby');
    }
  };

  /**
   * Processes a chunk of text through normalization, sign mapping, and enqueueing
   * @param {string} text - Text to sign
   */
  function signText(text) {
    if (!text || !text.trim()) return;
    if (!isAvatarReady) {
      console.warn('[Mouna] Avatar is still loading, queuing after load...');
      return;
    }

    const words = signProcessor.normalizeText(text);
    if (words.length === 0) return;

    const signs = signMapper.mapSentenceToSigns(words, currentLanguage);
    if (signs.length === 0) return;

    console.log(`[Mouna] Queuing ${signs.length} signs for text: "${text}"`, signs);
    animationQueue.enqueueBatch(signs);

    // If controller is paused or idle, kick off playback
    animationController.start();
  }

  // Speech Recognition Callbacks
  const handleSpeechTranscript = (transcript, isFinal) => {
    overlay.setTranscript(transcript, isFinal);

    // Forward transcript update to storage/popup
    try {
      chrome.runtime.sendMessage({
        action: 'TRANSCRIPT_BROADCAST',
        payload: { transcript, isFinal }
      });
    } catch (e) {}

    // Progressive real-time speech tokenization
    const allWords = signProcessor.normalizeText(transcript);

    if (allWords.length > lastProcessedWordCount) {
      const newWords = allWords.slice(lastProcessedWordCount);
      lastProcessedWordCount = allWords.length;

      const newSigns = signMapper.mapSentenceToSigns(newWords, currentLanguage);
      if (newSigns.length > 0) {
        animationQueue.enqueueBatch(newSigns);
        animationController.start();
      }
    }

    if (isFinal) {
      // Sentence complete, reset token offset for next phrase
      lastProcessedWordCount = 0;
    }
  };

  speechRecognizer.onTranscript = handleSpeechTranscript;
  speechRecognizer.onResult = (transcript, isFinal) => handleSpeechTranscript(transcript, isFinal);

  const handleStateChange = (state) => {
    const isListening = typeof state === 'boolean' ? state : (state && state.isListening);
    if (isListening) {
      overlay.setStatus('listening', 'Listening');
    } else if (isActive) {
      overlay.setStatus('listening', 'Reconnecting Mic...');
    } else {
      overlay.setStatus('idle', 'Standby');
    }
  };

  speechRecognizer.onStateChange = handleStateChange;
  speechRecognizer.onStatusChange = (isListening) => handleStateChange({ isListening });

  speechRecognizer.onError = (error) => {
    console.warn('[Mouna] Speech recognition warning:', error);
    if (error === 'not-allowed') {
      overlay.setStatus('idle', 'Mic Permission Denied');
    } else if (error === 'no-speech') {
      // Natural silence, remain listening
    } else {
      overlay.setStatus('idle', `Speech: ${error}`);
    }
  };

  // Overlay UI User Interactions
  overlay.onTogglePower = (active) => {
    setActiveState(active);
    chrome.runtime.sendMessage({
      action: 'SET_STATE',
      payload: { isActive: active }
    });
  };

  overlay.onLanguageChange = (lang) => {
    currentLanguage = lang;
    speechRecognizer.setLanguage(lang);
    lastProcessedWordCount = 0;
    chrome.runtime.sendMessage({
      action: 'SET_STATE',
      payload: { selectedLanguage: lang }
    });
  };

  overlay.onSpeedChange = (speed) => {
    currentSpeed = speed;
    animationController.setSpeed(speed);
    chrome.runtime.sendMessage({
      action: 'SET_STATE',
      payload: { speed: speed }
    });
  };

  overlay.onSendText = (text) => {
    overlay.setTranscript(text, true);
    signText(text);
  };

  overlay.onClose = () => {
    chrome.runtime.sendMessage({
      action: 'SET_STATE',
      payload: { overlayVisible: false }
    });
  };

  /**
   * Sets active/inactive state of speech recognition and signing
   */
  function setActiveState(active) {
    isActive = active;
    overlay.setPowerState(active);

    if (active) {
      lastProcessedWordCount = 0;
      try {
        speechRecognizer.start();
      } catch (e) {
        console.warn('[Mouna] Could not start speech recognizer:', e);
      }
      startVideoCaptionObserver();
      animationController.start();
      overlay.setStatus('listening', 'Listening');
    } else {
      try {
        speechRecognizer.stop();
      } catch (e) {}
      stopVideoCaptionObserver();
      animationQueue.clear();
      animationController.stop();
      overlay.setStatus('idle', 'Standby');
      overlay.setCurrentSign(null);
    }
  }

  // Live Video & YouTube Captions Observer
  let captionObserver = null;
  let captionPollInterval = null;
  let lastCaptionText = '';

  function enableYouTubeCaptions() {
    if (!window.location.hostname.includes('youtube.com')) return;

    // 1. YouTube Player Subtitles Button
    const subBtn = document.querySelector('.ytp-subtitles-button');
    if (subBtn && subBtn.getAttribute('aria-pressed') === 'false') {
      console.log('[Mouna] Enabling YouTube subtitles for sign translation...');
      subBtn.click();
      return;
    }

    // 2. YouTube Movie Player API
    const player = document.getElementById('movie_player') || document.querySelector('.html5-video-player');
    if (player && typeof player.isSubtitlesOn === 'function' && !player.isSubtitlesOn()) {
      if (typeof player.toggleSubtitlesOn === 'function') {
        player.toggleSubtitlesOn();
      }
    }
  }

  function startVideoCaptionObserver() {
    if (captionObserver) return;

    enableYouTubeCaptions();

    const checkCaptions = () => {
      if (!isActive) return;

      // Re-check YouTube CC status
      if (window.location.hostname.includes('youtube.com')) {
        const subBtn = document.querySelector('.ytp-subtitles-button');
        if (subBtn && subBtn.getAttribute('aria-pressed') === 'false') {
          subBtn.click();
        }
      }

      // 1. YouTube Player Caption Segments
      const ytSegments = document.querySelectorAll('.ytp-caption-segment, .caption-visual-line, .ytp-caption-window-rollup');
      if (ytSegments && ytSegments.length > 0) {
        const fullCaption = Array.from(ytSegments).map(s => s.textContent.trim()).filter(Boolean).join(' ');
        if (fullCaption && fullCaption !== lastCaptionText) {
          lastCaptionText = fullCaption;
          console.log('[Mouna] Captured YouTube caption:', fullCaption);
          handleCaptionTranscript(fullCaption);
          return;
        }
      }

      // 2. Standard HTML5 Video textTracks
      const videos = document.querySelectorAll('video');
      videos.forEach(video => {
        if (video.textTracks && video.textTracks.length > 0) {
          for (let i = 0; i < video.textTracks.length; i++) {
            const track = video.textTracks[i];
            if (track.activeCues && track.activeCues.length > 0) {
              const cueText = Array.from(track.activeCues).map(c => c.text).filter(Boolean).join(' ');
              if (cueText && cueText !== lastCaptionText) {
                lastCaptionText = cueText;
                console.log('[Mouna] Captured HTML5 video cue:', cueText);
                handleCaptionTranscript(cueText);
                return;
              }
            }
          }
        }
      });
    };

    captionObserver = new MutationObserver(() => {
      checkCaptions();
    });

    captionObserver.observe(document.body, {
      childList: true,
      subtree: true,
      characterData: true
    });

    captionPollInterval = setInterval(checkCaptions, 120);
  }

  function stopVideoCaptionObserver() {
    if (captionObserver) {
      captionObserver.disconnect();
      captionObserver = null;
    }
    if (captionPollInterval) {
      clearInterval(captionPollInterval);
      captionPollInterval = null;
    }
    lastCaptionText = '';
  }

  function handleCaptionTranscript(captionText) {
    overlay.setTranscript(captionText, true);

    try {
      chrome.runtime.sendMessage({
        action: 'TRANSCRIPT_BROADCAST',
        payload: { transcript: captionText, isFinal: true }
      });
    } catch (e) {}

    signText(captionText);
  }

  // Ensure video events re-trigger caption observer on YouTube SPA
  window.addEventListener('yt-navigate-finish', () => {
    if (isActive) {
      setTimeout(enableYouTubeCaptions, 600);
      setTimeout(enableYouTubeCaptions, 1600);
    }
  });

  document.addEventListener('play', (e) => {
    if (e.target && e.target.tagName === 'VIDEO' && isActive) {
      setTimeout(enableYouTubeCaptions, 500);
    }
  }, true);

  // Sync initial state from background storage
  chrome.runtime.sendMessage({ action: 'GET_STATE' }, (response) => {
    if (response && response.state) {
      applyState(response.state);
    }
  });

  function applyState(state) {
    if (typeof state.selectedLanguage === 'string') {
      currentLanguage = state.selectedLanguage;
      overlay.setLanguage(currentLanguage);
      speechRecognizer.setLanguage(currentLanguage);
    }

    if (typeof state.speed === 'number') {
      currentSpeed = state.speed;
      overlay.setSpeed(currentSpeed);
      animationController.setSpeed(currentSpeed);
    }

    if (typeof state.overlayVisible === 'boolean') {
      if (state.overlayVisible) overlay.show();
      else overlay.hide();
    }

    if (typeof state.isActive === 'boolean' && state.isActive !== isActive) {
      setActiveState(state.isActive);
    }
  }

  // Listen for messages from background service worker or popup
  chrome.runtime.onMessage.addListener((request, sender, sendResponse) => {
    const { action, payload } = request;

    if (action === 'STATE_CHANGED') {
      applyState(payload);
      sendResponse({ status: 'ok' });
      return false;
    }

    if (action === 'SIGN_TEXT') {
      if (payload && payload.text) {
        overlay.show();
        overlay.setTranscript(payload.text, true);
        signText(payload.text);
      }
      sendResponse({ status: 'ok' });
      return false;
    }

    if (action === 'TOGGLE_OVERLAY') {
      overlay.toggle();
      sendResponse({ status: 'ok' });
      return false;
    }
  });
})();
