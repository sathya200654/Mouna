/**
 * Mouna - 3D GLB Binary Asset Verification
 * Verifies the extracted arya-signs.glb header, chunk sizes, and animation JSON descriptors.
 */

const fs = require('fs');
const path = require('path');

const glbPath = path.join(__dirname, '../assets/models/arya-signs.glb');

console.log('Verifying 3D Asset:', glbPath);

if (!fs.existsSync(glbPath)) {
  console.error('[ERROR] arya-signs.glb not found!');
  process.exit(1);
}

const stats = fs.statSync(glbPath);
console.log(`File Size: ${(stats.size / (1024 * 1024)).toFixed(2)} MB (${stats.size} bytes)`);

// Read GLB Header (12 bytes: magic uint32, version uint32, length uint32)
const fd = fs.openSync(glbPath, 'r');
const headerBuf = Buffer.alloc(12);
fs.readSync(fd, headerBuf, 0, 12, 0);

const magic = headerBuf.readUInt32LE(0);
const version = headerBuf.readUInt32LE(4);
const length = headerBuf.readUInt32LE(8);

const magicStr = headerBuf.subarray(0, 4).toString('ascii');
console.log(`GLB Magic: "${magicStr}" (0x${magic.toString(16)}) - ${magicStr === 'glTF' ? 'VALID' : 'INVALID'}`);
console.log(`GLB Version: ${version}`);
console.log(`GLB Header Total Length: ${length} bytes - Matches File Size: ${length === stats.size}`);

// Read First Chunk (JSON Chunk: chunkLength uint32, chunkType uint32)
const chunkHeader = Buffer.alloc(8);
fs.readSync(fd, chunkHeader, 0, 8, 12);
const jsonChunkLength = chunkHeader.readUInt32LE(0);
const jsonChunkType = chunkHeader.readUInt32LE(4);
const jsonChunkTypeStr = chunkHeader.subarray(4, 8).toString('ascii');

console.log(`Chunk 0 Type: "${jsonChunkTypeStr}" (${jsonChunkLength} bytes)`);

if (jsonChunkTypeStr === 'JSON') {
  const jsonBuf = Buffer.alloc(jsonChunkLength);
  fs.readSync(fd, jsonBuf, 0, jsonChunkLength, 20);
  const gltf = JSON.parse(jsonBuf.toString('utf8'));

  console.log(`\nGLTF Metadata:`);
  console.log(`- Generator: ${gltf.asset ? gltf.asset.generator : 'N/A'}`);
  console.log(`- Mesh Count: ${gltf.meshes ? gltf.meshes.length : 0}`);
  console.log(`- Node Count: ${gltf.nodes ? gltf.nodes.length : 0}`);
  console.log(`- Skin Count: ${gltf.skins ? gltf.skins.length : 0}`);
  console.log(`- Extensions Used: ${JSON.stringify(gltf.extensionsUsed || [])}`);
  console.log(`- Extensions Required: ${JSON.stringify(gltf.extensionsRequired || [])}`);

  if (gltf.animations) {
    console.log(`\n- Animation Count: ${gltf.animations.length} clips`);
    const animNames = gltf.animations.map(a => a.name);
    console.log(`- Sample Animations: ${animNames.slice(0, 10).join(', ')} ...`);
    console.log(`- Has 'hello' clip: ${animNames.some(n => n.startsWith('hello-'))}`);
    console.log(`- Has 'happy' clip: ${animNames.some(n => n.startsWith('happy-'))}`);
    console.log(`- Has 'a-22' clip: ${animNames.includes('a-22')}`);
    console.log(`- Has 'z-22' clip: ${animNames.includes('z-22')}`);

    if (animNames.length === 85) {
      console.log('\n[SUCCESS] Exact 85 ISL skeletal animation clips verified!');
    } else {
      console.log(`\n[INFO] Found ${animNames.length} animation clips.`);
    }
  }
}

fs.closeSync(fd);
console.log('\n=============================================');
console.log('3D ASSET VALIDATION COMPLETE');
console.log('=============================================\n');
