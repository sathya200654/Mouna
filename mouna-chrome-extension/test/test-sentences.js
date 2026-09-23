const SignProcessor = require('../src/sign/sign-processor.js');
const SignMapper = require('../src/sign/sign-mapper.js');
const AnimationQueue = require('../src/sign/animation-queue.js');

const sp = new SignProcessor();
const sm = new SignMapper();
const queue = new AnimationQueue();

console.log('================================================================');
console.log('MOUNA MULTI-SENTENCE & MULTI-LANGUAGE TEST SUITE');
console.log('================================================================\n');

const testCases = [
  // 1. Core English Conversation
  { text: 'Hello, how are you?', lang: 'en', category: 'Core Greeting' },
  { text: 'Good morning everyone, welcome to our class.', lang: 'en', category: 'Phrasal Synonyms' },
  { text: 'I am fine, thank you very much.', lang: 'en', category: 'Dialogue Response' },
  { text: 'Do you have any problem with this?', lang: 'en', category: 'Core Vocabulary' },
  { text: 'Would you like some tea or coffee?', lang: 'en', category: 'Beverages' },
  { text: 'My name is Arya.', lang: 'en', category: 'Self Introduction' },

  // 2. Numbers and Amounts
  { text: 'We have 125 books.', lang: 'en', category: 'Compound Numbers' },
  { text: 'There are 50 students in 2 classes.', lang: 'en', category: 'Numerical Counts' },

  // 3. Indian Languages
  { text: 'नमस्ते, आप कैसे हैं?', lang: 'hi', category: 'Hindi Greeting' },
  { text: 'बहुत धन्यवाद, मुझे कोई समस्या नहीं है।', lang: 'hi', category: 'Hindi Dialogue' },
  { text: 'வணக்கம், நீங்கள் எப்படி இருக்கிறீர்கள்?', lang: 'ta', category: 'Tamil Greeting' },
  { text: 'நன்றி, நான் நலமாக இருக்கிறேன்.', lang: 'ta', category: 'Tamil Dialogue' },
  { text: 'నమస్కారం, మీరు ఎలా ఉన్నారు?', lang: 'te', category: 'Telugu Greeting' },
  { text: 'ధన్యవాదాలు.', lang: 'te', category: 'Telugu Dialogue' },
  { text: 'ನಮಸ್ಕಾರ, ನೀವು ಹೇಗಿದ್ದೀರಿ?', lang: 'kn', category: 'Kannada Greeting' },
  { text: 'നമസ്കാരം, സുഖമാണോ?', lang: 'ml', category: 'Malayalam Greeting' },
  { text: 'નમસ્તે, તમે કેમ છો?', lang: 'gu', category: 'Gujarati Greeting' },
  { text: 'नमस्कार, तुम्ही कसे आहात?', lang: 'mr', category: 'Marathi Greeting' },
  { text: 'ਸਤਿ ਸ੍ਰੀ ਅਕਾਲ, ਤੁਸੀਂ ਕਿਵੇਂ ਹੋ?', lang: 'pa', category: 'Punjabi Greeting' },

  // 4. Out-of-Vocabulary Fingerspelling
  { text: 'Please sign this document.', lang: 'en', category: 'Fingerspelling Test' },
  { text: 'Sathya is learning Indian Sign Language.', lang: 'en', category: 'Names & Advanced Words' }
];

let totalSignsGenerated = 0;
let passed = 0;

for (const tc of testCases) {
  const words = sp.normalizeText(tc.text);
  const signs = sm.mapSentenceToSigns(words, 'auto'); // Tests automatic language detection
  
  if (signs.length === 0) {
    console.error(`[FAIL] ${tc.category}: "${tc.text}" generated 0 signs!`);
  } else {
    passed++;
    totalSignsGenerated += signs.length;
    console.log(`[PASS] [${tc.category}] [Auto-Detected: ${sm.detectLanguage(words).toUpperCase()}]`);
    console.log(`  Input:  "${tc.text}"`);
    console.log(`  Signs:  (${signs.length}) ${signs.map(s => s.displayName || s.sign).join(' → ')}`);
    console.log('');
    
    // Test queue enqueue
    queue.enqueueBatch(signs);
  }
}

console.log('================================================================');
console.log(`RESULTS: ${passed}/${testCases.length} Tests Passed!`);
console.log(`Total Animated Sign Clips Generated: ${totalSignsGenerated}`);
console.log(`Animation Queue Processed: ${queue.length} items`);
console.log('================================================================\n');

if (passed === testCases.length) {
  process.exit(0);
} else {
  process.exit(1);
}
