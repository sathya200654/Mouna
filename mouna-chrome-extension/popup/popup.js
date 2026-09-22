/**
 * Mouna - Streamlined Extension Popup Logic
 * Focused strictly on 3D avatar rendering, live transcription, and single ON / OFF control.
 */

document.addEventListener('DOMContentLoaded', async () => {
  const masterPowerBtn = document.getElementById('master-power-btn');
  const masterPowerText = document.getElementById('master-power-text');
  const transcriptDisplay = document.getElementById('transcript-display');
  const statusDot = document.getElementById('status-indicator-dot');
  const statusText = document.getElementById('status-indicator-text');
  const signBadge = document.getElementById('popup-sign-badge');
  const loadingOverlay = document.getElementById('popup-loading');
  const loadingStatus = document.getElementById('loading-status');

  let isActive = false;

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

  renderer.onUpdate = (delta) => {
    animationController.update(delta);
  };

  animationController.onSignStart = (signData) => {
    const name = signData.originalWord || signData.signName || signData.clipName;
    signBadge.textContent = `Signing: ${name}`;
    signBadge.style.display = 'block';
    updateStatus('signing', `Signing: ${name}`);
  };

  animationController.onQueueEmpty = () => {
    signBadge.style.display = 'none';
    if (isActive) {
      updateStatus('listening', 'Listening');
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

  // Load 3D Model
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
      loadingOverlay.style.opacity = '0';
      setTimeout(() => { loadingOverlay.style.display = 'none'; }, 250);
      updateStatus('idle', 'Ready');
    },
    (err) => {
      console.error('[Mouna Popup] Error loading avatar:', err);
      loadingStatus.textContent = 'Avatar load error. Please reopen.';
    }
  );

  function signText(text) {
    if (!text || !text.trim()) return;
    transcriptDisplay.textContent = text;

    const words = signProcessor.normalizeText(text);
    const signs = signMapper.mapSentenceToSigns(words, 'en');

    if (signs.length > 0) {
      animationQueue.enqueueBatch(signs);
      animationController.start();
    }
  }

  function setPowerUI(active) {
    isActive = active;
    if (isActive) {
      masterPowerBtn.classList.add('active');
      masterPowerText.textContent = 'TURN OFF';
      updateStatus('listening', 'Listening');
    } else {
      masterPowerBtn.classList.remove('active');
      masterPowerText.textContent = 'TURN ON';
      updateStatus('idle', 'Standby');
      animationQueue.clear();
      animationController.stop();
      signBadge.style.display = 'none';
    }
  }

  // Read initial state from background
  chrome.runtime.sendMessage({ action: 'GET_STATE' }, (response) => {
    if (response && response.state) {
      setPowerUI(!!response.state.isActive);
      if (response.state.latestTranscript) {
        transcriptDisplay.textContent = response.state.latestTranscript;
      }
    }
  });

  // Toggle Button Click
  masterPowerBtn.addEventListener('click', () => {
    isActive = !isActive;
    setPowerUI(isActive);

    chrome.runtime.sendMessage({
      action: 'SET_STATE',
      payload: { isActive }
    });
  });

  // Listen for transcript updates broadcasted from content script or background
  chrome.storage.onChanged.addListener((changes, areaName) => {
    if (areaName === 'local') {
      if (changes.latestTranscript && changes.latestTranscript.newValue) {
        const text = changes.latestTranscript.newValue;
        transcriptDisplay.textContent = text;
        if (isActive) {
          signText(text);
        }
      }
      if (changes.isActive) {
        setPowerUI(changes.isActive.newValue);
      }
    }
  });
});
