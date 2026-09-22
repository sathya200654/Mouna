/**
 * Mouna - Avatar Loader
 * Robust loader for 3D character GLB with Meshopt compression.
 * Supports both callback (.load) and Promise (.loadAvatar) APIs,
 * ensures WebAssembly MeshoptDecoder is initialized, and registers all 85 animations.
 */

class AvatarLoader {
  /**
   * @param {THREE.Scene} [scene] - Optional Three.js scene to automatically attach loaded model to
   */
  constructor(scene = null) {
    this.scene = scene;
    this.model = null;
    this.clips = [];
    this.clipMap = new Map();
    this.fundamentalsClips = [];
    this.wordClips = [];
    this.cachedResult = null;
    this.isLoading = false;
  }

  /**
   * Standard loader callback API used by content script, popup, and test harness.
   * @param {string} modelUrl - URL to arya-signs.glb
   * @param {function} [onProgress] - Progress callback (loaded, total)
   * @param {function} [onLoad] - Success callback (model, clips, clipMap)
   * @param {function} [onError] - Error callback (error)
   */
  async load(modelUrl, onProgress = null, onLoad = null, onError = null) {
    try {
      console.log('[Mouna AvatarLoader] Starting 3D model load from:', modelUrl);
      this.isLoading = true;

      // 1. Wait for MeshoptDecoder WebAssembly initialization if present
      if (typeof MeshoptDecoder !== 'undefined') {
        if (MeshoptDecoder.ready && typeof MeshoptDecoder.ready.then === 'function') {
          console.log('[Mouna AvatarLoader] Awaiting MeshoptDecoder WebAssembly ready...');
          await MeshoptDecoder.ready;
          console.log('[Mouna AvatarLoader] MeshoptDecoder ready.');
        }
      } else {
        console.warn('[Mouna AvatarLoader] MeshoptDecoder is not defined in global scope.');
      }

      // 2. Initialize Three.js GLTFLoader
      if (typeof THREE === 'undefined' || !THREE.GLTFLoader) {
        throw new Error('THREE.GLTFLoader is not available.');
      }

      const loader = new THREE.GLTFLoader();
      if (typeof MeshoptDecoder !== 'undefined') {
        loader.setMeshoptDecoder(MeshoptDecoder);
      }

      // 3. Load GLB
      loader.load(
        modelUrl,
        (gltf) => {
          try {
            console.log('[Mouna AvatarLoader] GLB binary parsed successfully.');
            const model = gltf.scene;

            // Character transform matching Mouna's exact positioning
            model.position.set(0, 0.2, 0);
            model.scale.set(1.6, 1, 1);

            // Enable smooth shading & shadows
            model.traverse((child) => {
              if (child.isMesh) {
                child.castShadow = true;
                child.receiveShadow = true;
                if (child.material) {
                  child.material.roughness = 0.6;
                  child.material.metalness = 0.1;
                }
              }
            });

            // Automatically attach to scene if scene was provided
            if (this.scene && !this.scene.children.includes(model)) {
              this.scene.add(model);
            }

            this.model = model;
            this.clips = gltf.animations || [];
            this.clipMap = new Map();
            this.fundamentalsClips = [];
            this.wordClips = [];

            const alphabetSet = new Set('abcdefghijklmnopqrstuvwxyz'.split(''));

            for (const clip of this.clips) {
              const baseName = clip.name.split('-')[0].trim().toLowerCase();
              clip.baseName = baseName;
              this.clipMap.set(baseName, clip);
              this.clipMap.set(clip.name, clip);

              if (alphabetSet.has(baseName)) {
                this.fundamentalsClips.push(clip);
              } else {
                this.wordClips.push(clip);
              }
            }

            console.log(`[Mouna AvatarLoader] Loaded model Arya with ${this.clips.length} animation clips (${this.fundamentalsClips.length} letters, ${this.wordClips.length} words).`);

            this.cachedResult = {
              model: this.model,
              clips: this.clips,
              clipMap: this.clipMap,
              fundamentalsClips: this.fundamentalsClips,
              wordClips: this.wordClips
            };

            this.isLoading = false;

            if (onLoad) {
              onLoad(this.model, this.clips, this.clipMap);
            }
          } catch (processError) {
            console.error('[Mouna AvatarLoader] Error processing loaded GLB scene:', processError);
            this.isLoading = false;
            if (onError) onError(processError);
          }
        },
        (xhr) => {
          if (onProgress) {
            onProgress(xhr.loaded, xhr.total || 39066124);
          }
        },
        (xhrError) => {
          console.error('[Mouna AvatarLoader] GLTFLoader error while fetching model:', xhrError);
          this.isLoading = false;
          if (onError) onError(xhrError);
        }
      );
    } catch (err) {
      console.error('[Mouna AvatarLoader] Exception in load():', err);
      this.isLoading = false;
      if (onError) onError(err);
    }
  }

  /**
   * Promise-based loader API
   */
  async loadAvatar(customModelUrl = null, onProgress = null) {
    if (this.cachedResult) {
      return this.cachedResult;
    }

    let modelUrl = customModelUrl;
    if (!modelUrl) {
      if (typeof chrome !== 'undefined' && chrome.runtime && chrome.runtime.getURL) {
        modelUrl = chrome.runtime.getURL('assets/models/arya-signs.glb');
      } else {
        modelUrl = '../assets/models/arya-signs.glb';
      }
    }

    return new Promise((resolve, reject) => {
      this.load(
        modelUrl,
        (loaded, total) => {
          if (onProgress && total > 0) {
            onProgress(Math.round((loaded / total) * 100));
          }
        },
        (model, clips, clipMap) => {
          resolve(this.cachedResult);
        },
        (error) => {
          reject(error);
        }
      );
    });
  }

  getModel() {
    return this.model;
  }

  getClips() {
    return this.clips;
  }

  getClipMap() {
    return this.clipMap;
  }
}

if (typeof window !== 'undefined') {
  window.AvatarLoader = AvatarLoader;
}
if (typeof module !== 'undefined' && module.exports) {
  module.exports = AvatarLoader;
}
