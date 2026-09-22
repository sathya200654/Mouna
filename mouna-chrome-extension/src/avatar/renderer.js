/**
 * Mouna - Three.js WebGL Scene Renderer
 * Initializes camera, lights, tone mapping, and continuous render loop matching Mouna's mobile configuration.
 */

class AvatarRenderer {
  /**
   * @param {HTMLCanvasElement} canvas 
   * @param {HTMLElement} [container] 
   */
  constructor(canvas, container = null) {
    this.canvas = canvas;
    this.container = container || (canvas ? canvas.parentElement : null);
    this.scene = null;
    this.camera = null;
    this.renderer = null;
    this.clock = null;
    this.isRunning = false;
    this.animationId = null;
    this.onUpdate = null;

    // Updatables (mixers, controllers)
    this.updatables = [];

    this.init();
  }

  init() {
    if (this.scene) return; // already initialized

    // 1. Scene
    this.scene = new THREE.Scene();

    // 2. Camera matching Mouna's exact parameters
    const width = this.container ? (this.container.clientWidth || 320) : (this.canvas ? this.canvas.clientWidth || 320 : 320);
    const height = this.container ? (this.container.clientHeight || 450) : (this.canvas ? this.canvas.clientHeight || 450 : 450);
    const aspect = width / height;

    this.camera = new THREE.PerspectiveCamera(50, aspect, 1, 1000);
    this.camera.position.set(0, 14.3, 13.3);
    this.camera.lookAt(new THREE.Vector3(0, 11.9, 0));

    // 3. WebGL Renderer with ACES Tone Mapping and transparent background
    this.renderer = new THREE.WebGLRenderer({
      canvas: this.canvas,
      antialias: true,
      alpha: true,
      powerPreference: 'high-performance'
    });

    const pixelRatio = Math.min(window.devicePixelRatio || 1, 2);
    this.renderer.setPixelRatio(pixelRatio);
    this.renderer.setSize(width, height);
    this.renderer.setClearColor(0x000000, 0); // transparent
    this.renderer.toneMapping = THREE.ACESFilmicToneMapping;
    this.renderer.toneMappingExposure = Math.pow(2, -0.8);

    // 4. Lighting matching Mouna's setup
    const directionalLight = new THREE.DirectionalLight(0xffffff, 3.0);
    directionalLight.position.set(0.5, 0, 0.866);
    this.scene.add(directionalLight);

    const ambientLight = new THREE.AmbientLight(0xffffff, 0.6);
    this.scene.add(ambientLight);

    // Subtle rim light for avatar silhouette clarity
    const rimLight = new THREE.PointLight(0x7986cb, 0.8);
    rimLight.position.set(0, 15, -5);
    this.scene.add(rimLight);

    // 5. Clock
    this.clock = new THREE.Clock();
    this.clock.start();

    // Resize observer
    if (this.container && window.ResizeObserver) {
      this.resizeObserver = new ResizeObserver(() => this.onResize());
      this.resizeObserver.observe(this.container);
    }

    // Automatically start the animation loop
    this.start();
  }

  getScene() {
    return this.scene;
  }

  getCamera() {
    return this.camera;
  }

  getRenderer() {
    return this.renderer;
  }

  addUpdatable(obj) {
    if (obj && typeof obj.update === 'function') {
      this.updatables.push(obj);
    }
  }

  removeUpdatable(obj) {
    const idx = this.updatables.indexOf(obj);
    if (idx !== -1) {
      this.updatables.splice(idx, 1);
    }
  }

  onResize() {
    if (!this.renderer || !this.camera) return;
    const width = this.container ? (this.container.clientWidth || 320) : (this.canvas ? this.canvas.clientWidth || 320 : 320);
    const height = this.container ? (this.container.clientHeight || 450) : (this.canvas ? this.canvas.clientHeight || 450 : 450);

    this.camera.aspect = width / height;
    this.camera.updateProjectionMatrix();
    this.renderer.setSize(width, height);
  }

  start() {
    if (this.isRunning) return;
    this.isRunning = true;
    this.animate();
  }

  stop() {
    this.isRunning = false;
    if (this.animationId) {
      cancelAnimationFrame(this.animationId);
      this.animationId = null;
    }
  }

  animate() {
    if (!this.isRunning) return;

    this.animationId = requestAnimationFrame(() => this.animate());

    const delta = this.clock ? this.clock.getDelta() : 0.016;

    if (this.onUpdate) {
      this.onUpdate(delta);
    }

    for (const item of this.updatables) {
      item.update(delta);
    }

    if (this.renderer && this.scene && this.camera) {
      this.renderer.render(this.scene, this.camera);
    }
  }

  destroy() {
    this.stop();
    if (this.resizeObserver) {
      this.resizeObserver.disconnect();
    }
    if (this.renderer) {
      this.renderer.dispose();
    }
  }
}

if (typeof window !== 'undefined') {
  window.AvatarRenderer = AvatarRenderer;
}
