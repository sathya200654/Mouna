/**
 * Mouna - Animation Controller
 * Executes sequential sign animations with smooth crossfades, speed scaling,
 * subclip frame slicing, and idle management on the Three.js AnimationMixer.
 */

class AnimationController {
  /**
   * Supports both (scene, queue) and (model, clipMap, queue) constructor signatures.
   */
  constructor(arg1, arg2, arg3) {
    this.scene = null;
    this.model = null;
    this.clipMap = new Map();
    this.queue = null;
    this.mixer = null;

    // Determine parameter style
    if (arg1 && typeof arg1.add === 'function') {
      // (scene, queue) signature
      this.scene = arg1;
      this.queue = arg2;
    } else {
      // (model, clipMap, queue) signature
      this.model = arg1;
      this.clipMap = arg2 instanceof Map ? arg2 : new Map();
      this.queue = arg3;
      if (this.model) {
        this.mixer = new THREE.AnimationMixer(this.model);
      }
    }

    this.currentAction = null;
    this.previousAction = null;
    this.currentSignItem = null;
    this.playbackSpeed = 1.0;
    this.isIdle = true;
    this.isPlaying = false;
    this.idleTimer = null;

    // Callbacks
    this.onSignStart = null;
    this.onSignStarted = null;
    this.onSignEnd = null;
    this.onSignFinished = null;
    this.onQueueEmpty = null;
    this.onAllFinished = null;

    // Bind mixer finished event handler
    this.onFinished = this.onFinished.bind(this);
  }

  /**
   * Initializes or re-initializes controller with model and animation clips.
   * @param {THREE.Group} model - The 3D avatar character scene
   * @param {THREE.AnimationClip[]} clips - Array of animation clips
   */
  init(model, clips) {
    this.model = model;
    this.clips = clips || [];
    this.clipMap = new Map();

    for (const clip of this.clips) {
      const baseName = clip.name.split('-')[0].trim().toLowerCase();
      this.clipMap.set(baseName, clip);
      this.clipMap.set(clip.name, clip);
    }

    // Ensure model is attached to scene if scene was provided
    if (this.scene && this.model && !this.scene.children.includes(this.model)) {
      this.scene.add(this.model);
    }

    if (this.mixer) {
      this.mixer.stopAllAction();
      this.mixer.removeEventListener('finished', this.onFinished);
    }

    this.mixer = new THREE.AnimationMixer(this.model);
    this.mixer.addEventListener('finished', this.onFinished);
    this.mixer.timeScale = this.playbackSpeed;

    console.log(`[Mouna AnimationController] Initialized mixer with ${this.clipMap.size} animation clips.`);

    // Check if idle or neutral sign exists (e.g. 'small__pause__word' or first frame)
    const idleClip = this.clipMap.get('small__pause__word') || this.clips[0];
    if (idleClip) {
      const idleAction = this.mixer.clipAction(idleClip);
      idleAction.setLoop(THREE.LoopOnce, 1);
      idleAction.clampWhenFinished = true;
      idleAction.play();
      this.currentAction = idleAction;
    }
  }

  /**
   * Updates mixer delta time in the render loop.
   * @param {number} delta 
   */
  update(delta) {
    if (this.mixer) {
      this.mixer.update(delta);
    }
  }

  /**
   * Sets playback speed scale (e.g. 0.8, 1.0, 1.25, 1.5).
   * @param {number|string} speed 
   */
  setSpeed(speed) {
    const num = parseFloat(speed) || 1.0;
    this.playbackSpeed = Math.max(0.5, Math.min(3.0, num));
    if (this.mixer) {
      this.mixer.timeScale = this.playbackSpeed;
    }
    if (this.currentAction) {
      this.currentAction.setEffectiveTimeScale(this.playbackSpeed);
    }
  }

  /**
   * Begins or resumes playing signs from the queue.
   */
  start() {
    this.play();
  }

  play() {
    this.isPlaying = true;
    this.isIdle = false;

    // If no action is actively running, kick off the next sign
    if (!this.currentAction || !this.currentAction.isRunning()) {
      this.playNextSign();
    }
  }

  /**
   * Stops playback and resets active animations.
   */
  stop() {
    this.isPlaying = false;
    this.isIdle = true;
    if (this.mixer) {
      this.mixer.stopAllAction();
    }
    this.currentAction = null;
    this.previousAction = null;
    this.currentSignItem = null;
  }

  /**
   * Plays the next sign in the queue with smooth transitions and subclip framing.
   */
  playNextSign() {
    if (!this.queue || !this.mixer) return;

    const item = this.queue.dequeue();
    if (!item) {
      this.isPlaying = false;
      this.isIdle = true;
      this.currentSignItem = null;

      if (this.onQueueEmpty) this.onQueueEmpty();
      if (this.onAllFinished) this.onAllFinished();
      return;
    }

    this.currentSignItem = item;
    const signKey = (item.sign || item.signName || '').toLowerCase().trim();
    const rawClip = this.clipMap.get(signKey);

    if (!rawClip) {
      console.warn(`[Mouna AnimationController] Clip not found for sign: "${signKey}". Skipping.`);
      // Gracefully advance to next available sign
      this.playNextSign();
      return;
    }

    try {
      // 1. Calculate subclip frame bounds according to Mouna rules
      const frameCount = parseInt(rawClip.name.split('-')[1], 10) || 24;
      const startPad = Math.min(5, Math.floor(frameCount * 0.08));
      const endPad = Math.min(4, Math.floor(frameCount * 0.05));

      let startFrame = 0;
      let endFrame = frameCount;

      const pos = item.position || item.positionType || 'single';

      switch (pos) {
        case 'first':
          startFrame = 0;
          endFrame = Math.max(1, frameCount - endPad);
          break;
        case 'internal':
          startFrame = startPad;
          endFrame = Math.max(startPad + 1, frameCount - endPad);
          break;
        case 'last':
          startFrame = startPad;
          endFrame = frameCount;
          break;
        case 'single':
        default:
          startFrame = 0;
          endFrame = frameCount;
          break;
      }

      // 2. Slice subclip
      const subclipName = `${rawClip.name}_sub_${startFrame}_${endFrame}_${Date.now()}`;
      const subclip = THREE.AnimationUtils.subclip(rawClip, subclipName, startFrame, endFrame, 24);

      // 3. Configure Action
      const nextAction = this.mixer.clipAction(subclip);
      nextAction.setLoop(THREE.LoopOnce, 1);
      nextAction.clampWhenFinished = true;
      nextAction.setEffectiveTimeScale(this.playbackSpeed);

      // 4. Smooth Crossfade Transition
      const crossfadeDuration = Math.min(0.25, 0.3 / this.playbackSpeed);

      if (this.currentAction && this.currentAction !== nextAction) {
        this.previousAction = this.currentAction;
        nextAction.reset();
        this.currentAction.crossFadeTo(nextAction, crossfadeDuration, true);
        nextAction.play();
      } else {
        nextAction.reset();
        nextAction.play();
      }

      this.currentAction = nextAction;

      // 5. Fire Sign Start Callbacks
      const callbackPayload = {
        ...item,
        clipName: rawClip.name,
        frameCount,
        startFrame,
        endFrame
      };

      if (this.onSignStart) this.onSignStart(callbackPayload);
      if (this.onSignStarted) this.onSignStarted(callbackPayload);

    } catch (e) {
      console.error('[Mouna AnimationController] Error playing sign clip:', e);
      this.playNextSign();
    }
  }

  /**
   * Three.js mixer finished event handler.
   */
  onFinished(event) {
    if (this.currentSignItem) {
      if (this.onSignEnd) this.onSignEnd(this.currentSignItem);
      if (this.onSignFinished) this.onSignFinished(this.currentSignItem);
    }

    // Immediately play next sign if queue has more items
    if (this.queue && this.queue.size && this.queue.size() > 0) {
      this.playNextSign();
    } else if (this.queue && !this.queue.isEmpty()) {
      this.playNextSign();
    } else {
      this.isPlaying = false;
      this.isIdle = true;
      this.currentSignItem = null;

      if (this.onQueueEmpty) this.onQueueEmpty();
      if (this.onAllFinished) this.onAllFinished();
    }
  }
}

if (typeof window !== 'undefined') {
  window.AnimationController = AnimationController;
}
if (typeof module !== 'undefined' && module.exports) {
  module.exports = AnimationController;
}
