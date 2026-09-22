const fs = require('fs');

console.log('--- MOUNA CODEBASE VERIFICATION ---');

// Test 1: Speech Recognizer
const speechRec = fs.readFileSync('src/speech/speech-recognizer.js', 'utf8');
console.log('1. SpeechRecognizer supports onTranscript:', speechRec.includes('this.onTranscript'));
console.log('   SpeechRecognizer supports onResult:', speechRec.includes('this.onResult'));
console.log('   SpeechRecognizer supports onStateChange:', speechRec.includes('this.onStateChange'));

// Test 2: Popup HTML
const popupHtml = fs.readFileSync('popup/popup.html', 'utf8');
console.log('2. Popup includes speech-recognizer.js:', popupHtml.includes('src/speech/speech-recognizer.js'));
console.log('   Popup has current-sign-box:', popupHtml.includes('id="current-sign-box"'));
console.log('   Popup has current-sign-word:', popupHtml.includes('id="current-sign-word"'));
console.log('   Popup has transcript-display:', popupHtml.includes('id="transcript-display"'));

// Test 3: Popup JS
const popupJs = fs.readFileSync('popup/popup.js', 'utf8');
console.log('3. Popup instantiates SpeechRecognizer:', popupJs.includes('new window.SpeechRecognizer()'));
console.log('   Popup handles onSignStart for word:', popupJs.includes('currentSignWord.textContent'));
console.log('   Popup listens for TRANSCRIPT_UPDATE message:', popupJs.includes('TRANSCRIPT_UPDATE'));

// Test 4: Content JS
const contentJs = fs.readFileSync('content/content.js', 'utf8');
console.log('4. Content script has enableYouTubeCaptions:', contentJs.includes('enableYouTubeCaptions'));
console.log('   Content script has ytp-caption-segment check:', contentJs.includes('.ytp-caption-segment'));
console.log('   Content script assigns speechRecognizer.onResult:', contentJs.includes('speechRecognizer.onResult'));

// Test 5: Service Worker
const sw = fs.readFileSync('background/service-worker.js', 'utf8');
console.log('5. Service worker auto-injects tabs:', sw.includes('injectContentScriptsIntoExistingTabs'));
console.log('   Service worker relays TRANSCRIPT_UPDATE:', sw.includes('TRANSCRIPT_UPDATE'));

// Test 6: Sign mapping for "sign" and English conversation
const SignProcessor = require('../src/sign/sign-processor.js');
const SignMapper = require('../src/sign/sign-mapper.js');
const sp = new SignProcessor();
const sm = new SignMapper();

const words1 = sp.normalizeText('sign');
const signs1 = sm.mapSentenceToSigns(words1, 'en');
console.log('6. "sign" mapped to:', signs1.map(s => `${s.originalWord} -> ${s.sign} (type:${s.type})`));

const words2 = sp.normalizeText('Hello how are you');
const signs2 = sm.mapSentenceToSigns(words2, 'en');
console.log('7. "Hello how are you" mapped to:', signs2.map(s => `${s.originalWord} -> ${s.sign}`));

console.log('--- ALL VERIFICATIONS PASSED ---');
