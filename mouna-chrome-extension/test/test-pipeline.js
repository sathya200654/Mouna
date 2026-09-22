/**
 * Mouna - Pipeline Verification Test Suite
 * Tests SignProcessor, SignMapper, AnimationQueue, and 9-language translation pipeline.
 */

const fs = require('fs');
const path = require('path');

// Mock window for Node testing
global.window = {};

require('../src/sign/sign-processor.js');
require('../src/sign/sign-mapper.js');
require('../src/sign/animation-queue.js');

const SignProcessor = global.window.SignProcessor;
const SignMapper = global.window.SignMapper;
const AnimationQueue = global.window.AnimationQueue;

console.log('====================================================');
console.log('MOUNA SPEECH-TO-SIGN EXTENSION PIPELINE TEST SUITE');
console.log('====================================================\n');

let passCount = 0;
let failCount = 0;

function assert(condition, testName) {
  if (condition) {
    console.log(`[PASS] ${testName}`);
    passCount++;
  } else {
    console.error(`[FAIL] ${testName}`);
    failCount++;
  }
}

// 1. Test SignProcessor
console.log('--- TEST 1: SignProcessor (Text Normalization & Numbers) ---');
const processor = new SignProcessor();

const normalized = processor.normalizeText('Hello! Good morning, we have 125 students here?');
assert(
  JSON.stringify(normalized) === JSON.stringify(['hello', 'good', 'morning', 'we', 'have', '100__', '20__', '5', 'students', 'here']),
  'Normalizes text, strips punctuation, and decomposes 125 into [100__, 20__, 5]'
);

const singleDigits = processor.convertNumberToWords('42');
assert(
  JSON.stringify(singleDigits) === JSON.stringify(['40__', '2']),
  'Converts 42 to [40__, 2]'
);

// 2. Test SignMapper (Core Vocabulary & Synonyms)
console.log('\n--- TEST 2: SignMapper (Core 85 Signs & Phrase Synonyms) ---');
const mapper = new SignMapper();

assert(mapper.hasSign('hello'), 'Has sign for "hello"');
assert(mapper.hasSign('good morning'), 'Has sign for "good morning"');
assert(mapper.hasSign('thank you'), 'Has sign for "thank you"');
assert(mapper.hasSign('tea'), 'Has sign for "tea"');
assert(mapper.hasSign('coffee'), 'Has sign for "coffee"');

const phraseResult = mapper.mapSentenceToSigns(['thank', 'you'], 'en');
assert(
  phraseResult.length === 1 && phraseResult[0].signName === 'happy',
  'Maps two-word phrase "thank you" to "happy" sign via synonym'
);

const greetingResult = mapper.mapSentenceToSigns(['good', 'morning'], 'en');
assert(
  greetingResult.length === 1 && greetingResult[0].signName === 'hello',
  'Maps phrase "good morning" to "hello" sign via synonym'
);

// 3. Test Fingerspelling Fallback
console.log('\n--- TEST 3: Fingerspelling Fallback ---');
const fallbackResult = mapper.mapWordToSigns('school', 'en');
assert(
  fallbackResult.length === 6 &&
  fallbackResult[0].signName === 's' &&
  fallbackResult[1].signName === 'c' &&
  fallbackResult[2].signName === 'h' &&
  fallbackResult[3].signName === 'o' &&
  fallbackResult[4].signName === 'o' &&
  fallbackResult[5].signName === 'l' &&
  fallbackResult.every(s => s.isFingerspelled === true),
  'Fallback: "school" (not in 85 core signs) correctly fingerspelled letter-by-letter (s-c-h-o-o-l)'
);

// 4. Test 9 Indian Languages Translation
console.log('\n--- TEST 4: 9 Supported Indian Languages ---');
const languages = [
  { code: 'hi', name: 'Hindi', word: 'नमस्ते', expectedSign: 'hello' },
  { code: 'hi', name: 'Hindi', word: 'धन्यवाद', expectedSign: 'happy' },
  { code: 'ta', name: 'Tamil', word: 'வணக்கம்', expectedSign: 'hello' },
  { code: 'ta', name: 'Tamil', word: 'நன்றி', expectedSign: 'happy' },
  { code: 'te', name: 'Telugu', word: 'నమస్కారం', expectedSign: 'hello' },
  { code: 'te', name: 'Telugu', word: 'ధన్యవాదాలు', expectedSign: 'happy' },
  { code: 'kn', name: 'Kannada', word: 'ನಮಸ್ಕಾರ', expectedSign: 'hello' },
  { code: 'kn', name: 'Kannada', word: 'ಧನ್ಯವಾದಗಳು', expectedSign: 'happy' },
  { code: 'ml', name: 'Malayalam', word: 'നമസ്കാരം', expectedSign: 'hello' },
  { code: 'ml', name: 'Malayalam', word: 'നന്ദി', expectedSign: 'happy' },
  { code: 'gu', name: 'Gujarati', word: 'નમસ્તે', expectedSign: 'hello' },
  { code: 'gu', name: 'Gujarati', word: 'આભાર', expectedSign: 'happy' },
  { code: 'mr', name: 'Marathi', word: 'नमस्कार', expectedSign: 'hello' },
  { code: 'mr', name: 'Marathi', word: 'धन्यवाद', expectedSign: 'happy' },
  { code: 'pa', name: 'Punjabi', word: 'ਸਤਿ ਸ੍ਰੀ ਅਕਾਲ', expectedSign: 'hello' },
  { code: 'pa', name: 'Punjabi', word: 'ਧੰਨਵਾਦ', expectedSign: 'happy' }
];

languages.forEach(lang => {
  const signs = mapper.mapWordToSigns(lang.word, lang.code);
  const matched = signs.some(s => s.signName === lang.expectedSign);
  assert(matched, `${lang.name} (${lang.code}): "${lang.word}" -> "${lang.expectedSign}" sign`);
});

// 5. Test AnimationQueue Position Tracking
console.log('\n--- TEST 5: AnimationQueue Position Tracking ---');
const queue = new AnimationQueue();

const sentenceSigns = mapper.mapSentenceToSigns(['he', 'have', 'problem', 'happy'], 'en');
queue.enqueueBatch(sentenceSigns);

assert(queue.size() === 4, 'Enqueued 4 signs into queue');
const first = queue.dequeue();
assert(first.position === 'first', 'First sign has position="first"');

const second = queue.dequeue();
assert(second.position === 'internal', 'Second sign has position="internal"');

const third = queue.dequeue();
assert(third.position === 'internal', 'Third sign has position="internal"');

const fourth = queue.dequeue();
assert(fourth.position === 'last', 'Fourth sign has position="last"');

assert(queue.isEmpty(), 'Queue is empty after 4 dequeues');

// 6. Test Single Word Enqueue
const singleQueue = new AnimationQueue();
const singleSigns = mapper.mapSentenceToSigns(['hello'], 'en');
singleQueue.enqueueBatch(singleSigns);
const singleItem = singleQueue.dequeue();
assert(singleItem.position === 'single', 'Single sign in batch has position="single"');

// Summary
console.log('\n====================================================');
console.log(`TEST SUMMARY: ${passCount} Passed, ${failCount} Failed.`);
console.log('====================================================');

if (failCount > 0) {
  process.exit(1);
} else {
  console.log('ALL PIPELINE TESTS PASSED SUCCESSFULLY!\n');
}
