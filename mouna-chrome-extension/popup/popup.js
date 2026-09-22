/**
 * Mouna - Streamlined Extension Popup Logic
 * Focused strictly on 3D avatar rendering, live audio transcription,
 * dedicated current-sign display box, and single ON / OFF control.
 */

document.addEventListener('DOMContentLoaded', async () => {
  const masterPowerBtn = document.getElementById('master-power-btn');
  const masterPowerText = document.getElementById('master-power-text');
  const transcriptDisplay = document.getElementById('transcript-display');
  const statusDot = document.getElementById('status-indicator-dot');
  const statusText = document.getElementById('status-indicator-text');
  const currentSignBox = document.getElementById('current-sign-box');
  const currentSignWord = document.getElementById('current-sign-word');
  const currentSignChar = document.getElementById('current-sign-char');
  const loadingOverlay = document.getElementById('popup-loading');
  const loadingStatus = document.getElementById('loading-status');

  let isActive = false;
  let isAvatarReady = false;

  // Sign & Avatar Systems
  const signProcessor = new window.SignProcessor();
  const signMapper = new window.SignMapper();
  const animationQueue = new window.AnimationQueue();

  // Setup Three.js WebGL Scene for Popup Avatar
  const canvas = document.getElementById('popup-avatar-canvas');
  const renderer = new window.AvatarRenderer(canvas);
  renderer.init();

  const avatarLoader = new window.AvatarLoader(renderer.getScene());
  const animationController = new window.AnimationController(renderer.getScene(), animationQueue);

  // Audio & Speech Recognition Systems in Popup
  const speechRecognizer = new window.SpeechRecognizer();
  const audioManager = new window.AudioManager();

  renderer.onUpdate = (delta) => {
    animationController.update(delta);
  };

  // When a sign starts playing, highlight the exact word and letter in the box below the avatar
  animationController.onSignStart = (signData) => {
    const rawWord = signData.originalWord || signData.signName || signData.clipName || '';
    const wordUpper = rawWord.toUpperCase();

    currentSignWord.textContent = wordUpper;

    if (signData.isFingerspelled && signData.sign) {
      currentSignChar.textContent = `[ ${signData.sign.toUpperCase()} ]`;
      currentSignChar.style.display = 'inline-block';
    } else {
      currentSignChar.style.display = 'none';
    }

    currentSignBox.classList.add('pulse');
    setTimeout(() => currentSignBox.classList.remove('pulse'), 300);

    updateStatus('signing', `Signing: ${wordUpper}`);
  };

  animationController.onQueueEmpty = () => {
    currentSignWord.textContent = '—';
    currentSignChar.style.display = 'none';

    if (isActive) {
      updateStatus('listening', 'Listening to Audio');
    } else {
      updateStatus('idle', 'Standby');
    }
  };

  function updateStatus(statusKey, label) {
    statusDot.className = 'status-dot';
    if (statusKey === 'active' || statusKey === 'listening') statusDot.classList.add('active');
    else if (statusKey === 'signing') statusDot.classList.add('signing');
    statusText.textContent = label;
  }

  // Load 3D Avatar Model
  const modelUrl = chrome.runtime.getURL('assets/models/arya-signs.glb');
  avatarLoader.load(
    modelUrl,
    (loaded, total) => {
      if (total > 0) {
        const pct = Math.round((loaded / total) * 100);
        loadingStatus.textContent = `Loading Avatar: ${pct}%`;
      }
    },
    (model, clips) => {
      console.log(`[Mouna Popup] Loaded ${clips.length} sign animations.`);
      animationController.init(model, clips);
      isAvatarReady = true;
      loadingOverlay.style.opacity = '0';
      setTimeout(() => { loadingOverlay.style.display = 'none'; }, 250);
      updateStatus('idle', 'Ready');
    },
    (err) => {
      console.error('[Mouna Popup] Error loading avatar:', err);
      loadingStatus.textContent = 'Avatar load error. Please reopen.';
    }
  );

  /**
   * Processes transcribed text and plays 3D signs
   */
  function signText(text) {
    if (!text || !text.trim()) return;

    transcriptDisplay.textContent = text;

    const words = signProcessor.normalizeText(text);
    if (!words || words.length === 0) return;

    const signs = signMapper.mapSentenceToSigns(words, 'en');
    if (signs.length > 0) {
      animationQueue.enqueueBatch(signs);
      animationController.start();
    }
  }

  // Speech Recognizer Handlers
  speechRecognizer.onTranscript = (transcript, isFinal) => {
    if (!isActive) return;
    console.log('[Mouna Popup Speech]', transcript, isFinal ? '(final)' : '(interim)');

    transcriptDisplay.textContent = transcript;
    signText(transcript);

    // Broadcast transcript to background & open tabs
    try {
      chrome.runtime.sendMessage({
        action: 'TRANSCRIPT_BROADCAST',
        payload: { transcript, isFinal }
      });
    } catch (e) {}
  };

  speechRecognizer.onResult = (transcript, isFinal) => {
    if (!isActive) return;
    transcriptDisplay.textContent = transcript;
    signText(transcript);
  };

  speechRecognizer.onError = (msg, errorType) => {
    console.warn('[Mouna Popup Speech Error]', msg, errorType);
    if (errorType === 'not-allowed') {
      updateStatus('idle', 'Mic Permission Needed');
    }
  };

  // Request Microphone permission safely
  async function requestMicrophoneAccess() {
    try {
      const stream = await navigator.mediaDevices.getUserMedia({ audio: true });
      stream.getTracks().forEach(t => t.stop());
      return true;
    } catch (err) {
      console.warn('[Mouna Popup] Mic access not yet allowed:', err);
      return false;
    }
  }

  async function startListening() {
    updateStatus('listening', 'Starting Audio Listen...');
    transcriptDisplay.textContent = 'Listening to laptop audio and speech...';

    // 1. Request microphone access for laptop audio input
    await requestMicrophoneAccess();

    // 2. Start speech recognizer (listens to laptop speakers / microphone with low latency)
    try {
      speechRecognizer.start();
    } catch (e) {
      console.warn('[Mouna Popup] Speech recognizer start:', e);
    }

    // 3. Attempt Tab Audio Capture (keeps sound playing through laptop speakers)
    try {
      await audioManager.startTabCapture({ loopbackToSpeakers: true });
    } catch (e) {
      console.log('[Mouna Popup] Tab capture info:', e.message);
    }

    animationController.start();
    updateStatus('listening', 'Listening to Audio');
  }

  function stopListening() {
    try {
      speechRecognizer.stop();
    } catch (e) {}

    try {
      audioManager.stop();
    } catch (e) {}

    animationQueue.clear();
    animationController.stop();
    currentSignWord.textContent = '—';
    currentSignChar.style.display = 'none';
    updateStatus('idle', 'Standby');
  }

  function setPowerUI(active) {
    isActive = active;
    if (isActive) {
      masterPowerBtn.classList.add('active');
      masterPowerText.textContent = 'TURN OFF';
      startListening();
    } else {
      masterPowerBtn.classList.remove('active');
      masterPowerText.textContent = 'TURN ON';
      stopListening();
    }
  }

  // Toggle Button Click Handler
  masterPowerBtn.addEventListener('click', async () => {
    const nextActive = !isActive;
    setPowerUI(nextActive);

    chrome.runtime.sendMessage({
      action: 'SET_STATE',
      payload: { isActive: nextActive }
    });
  });

  // Read initial state from background
  chrome.runtime.sendMessage({ action: 'GET_STATE' }, (response) => {
    if (response && response.state) {
      if (response.state.isActive) {
        setPowerUI(true);
      }
      if (response.state.latestTranscript) {
        transcriptDisplay.textContent = response.state.latestTranscript;
      }
    }
  });

  // Direct Low-Latency Runtime Message Receiver
  // Handles immediate transcripts from YouTube captions, video tracks, or content scripts
  chrome.runtime.onMessage.addListener((request, sender, sendResponse) => {
    if (request.action === 'TRANSCRIPT_BROADCAST' || request.action === 'TRANSCRIPT_UPDATE') {
      const text = request.payload ? request.payload.transcript : '';
      if (text && text.trim()) {
        console.log('[Mouna Popup] Received live caption/transcript:', text);
        transcriptDisplay.textContent = text;
        if (isActive) {
          signText(text);
        }
      }
      sendResponse({ status: 'ok' });
      return false;
    }

    if (request.action === 'STATE_CHANGED' && request.payload) {
      if (typeof request.payload.isActive === 'boolean' && request.payload.isActive !== isActive) {
        setPowerUI(request.payload.isActive);
      }
    }
  });

  // Also listen for storage changes as fallback
  chrome.storage.onChanged.addListener((changes, areaName) => {
    if (areaName === 'local') {
      if (changes.latestTranscript && changes.latestTranscript.newValue) {
        const text = changes.latestTranscript.newValue;
        transcriptDisplay.textContent = text;
        if (isActive) {
          signText(text);
        }
      }
    }
  });
});
