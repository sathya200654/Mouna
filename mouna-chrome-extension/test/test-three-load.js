/**
 * Test GLTF loading in Node using the exact libraries in lib/
 */
const fs = require('fs');
const path = require('path');

// Setup Node globals to simulate browser environment for Three.js and GLTFLoader
global.self = global;
global.window = global;

const THREE = require('../lib/three.min.js');
global.THREE = THREE;

const MeshoptDecoder = require('../lib/meshopt_decoder.js');
global.MeshoptDecoder = MeshoptDecoder;

require('../lib/GLTFLoader.js');

console.log('Testing Three.js version:', THREE.REVISION);
console.log('Testing MeshoptDecoder ready:', !!MeshoptDecoder);

async function testLoad() {
  await MeshoptDecoder.ready;
  console.log('MeshoptDecoder is ready!');

  const glbPath = path.join(__dirname, '../assets/models/arya-signs.glb');
  const buffer = fs.readFileSync(glbPath);
  console.log(`Read GLB buffer: ${(buffer.length / 1024 / 1024).toFixed(2)} MB`);

  const arrayBuffer = buffer.buffer.slice(buffer.byteOffset, buffer.byteOffset + buffer.byteLength);

  const loader = new THREE.GLTFLoader();
  loader.setMeshoptDecoder(MeshoptDecoder);

  console.log('Parsing GLB arraybuffer with GLTFLoader...');
  const startTime = Date.now();

  loader.parse(
    arrayBuffer,
    '',
    (gltf) => {
      const elapsed = Date.now() - startTime;
      console.log(`[SUCCESS] GLTF parsed in ${elapsed}ms!`);
      console.log(`- Scene children: ${gltf.scene.children.length}`);
      console.log(`- Animations: ${gltf.animations.length}`);
      if (gltf.animations.length > 0) {
        console.log(`- Sample clip: ${gltf.animations[0].name}, duration: ${gltf.animations[0].duration}`);
      }
    },
    (err) => {
      console.error('[ERROR] loader.parse failed:', err);
    }
  );
}

testLoad().catch(err => console.error('testLoad error:', err));
