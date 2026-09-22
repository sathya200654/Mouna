/**
 * Mouna - Sign Mapper
 * Maps words and phrases to 3D avatar animations, with Indian language gloss translation
 * and fingerspelling fallback for out-of-vocabulary terms.
 */

class SignMapper {
  constructor() {
    // 85 core animation clips extracted from arya-signs.glb
    this.coreVocabulary = new Set([
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
      '20__', '30__', '40__', '50__', '60__', '70__', '80__', '90__', '100__', '1000__',
      'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
      'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
      'after', 'and', 'angry', 'arya', 'before', 'coffee', 'endOfSentence',
      'happy', 'have', 'he', 'hello', 'here', 'him', 'his', 'how', 'i',
      'interpret', 'many', 'me', 'my', 'name', 'oh', 'problem', 'sad', 'she',
      'small__pause__word', 'some', 'tea', 'their', 'there', 'they', 'this__',
      'us', 'we', 'what', 'when', 'where', 'who', 'why', 'you'
    ]);

    // Phrase synonyms to core animations
    this.phraseSynonyms = {
      'good morning': ['hello'],
      'good afternoon': ['hello'],
      'good evening': ['hello'],
      'good night': ['hello'],
      'welcome': ['hello'],
      'hi': ['hello'],
      'hey': ['hello'],
      'thank you': ['happy'],
      'thanks': ['happy'],
      'fine': ['happy'],
      'good': ['happy'],
      'great': ['happy'],
      'bad': ['sad'],
      'sorry': ['sad'],
      'issue': ['problem'],
      'trouble': ['problem'],
      'cup of tea': ['tea'],
      'cup of coffee': ['coffee'],
      'this': ['this__'],
      'everybody': ['we', 'all'],
      'everyone': ['we', 'all']
    };

    // Dictionary mappings for all 9 Indian Languages to English Sign Glosses
    this.indianLanguageDict = {
      // HINDI (hi-IN)
      'hi': {
        'नमस्ते': 'hello', 'नमस्कार': 'hello', 'प्रणाम': 'hello',
        'आप': 'you', 'तुम': 'you', 'तू': 'you',
        'कैसा': 'how', 'कैसे': 'how', 'कैसी': 'how',
        'मैं': 'i', 'मुझे': 'me', 'मेरा': 'my', 'मेरी': 'my', 'मेरे': 'my',
        'नाम': 'name',
        'आर्या': 'arya', 'आर्य': 'arya',
        'चाय': 'tea', 'कॉफी': 'coffee', 'कॉफ़ी': 'coffee',
        'खुश': 'happy', 'प्रसन्न': 'happy', 'अच्छा': 'happy',
        'दुखी': 'sad', 'उदास': 'sad',
        'समस्या': 'problem', 'दिक्कत': 'problem', 'परेशानी': 'problem',
        'कौन': 'who', 'क्या': 'what', 'कब': 'when', 'कहाँ': 'where', 'कहा': 'where', 'क्यों': 'why',
        'यहाँ': 'here', 'वहाँ': 'there',
        'और': 'and', 'पहले': 'before', 'बाद': 'after',
        'हम': 'we', 'हमे': 'us', 'हमें': 'us',
        'वह': 'he', 'वे': 'they', 'उनका': 'their',
        'धन्यवाद': 'happy', 'शुक्रिया': 'happy'
      },
      // TAMIL (ta-IN)
      'ta': {
        'வணக்கம்': 'hello',
        'நீங்கள்': 'you', 'நீ': 'you',
        'எப்படி': 'how',
        'நான்': 'i', 'என்னை': 'me', 'என்': 'my', 'எனது': 'my',
        'பெயர்': 'name',
        'ஆர்யா': 'arya',
        'தேநீர்': 'tea', 'காபி': 'coffee',
        'மகிழ்ச்சி': 'happy', 'நன்று': 'happy', 'நல்ல': 'happy',
        'வருத்தம்': 'sad', 'சோகம்': 'sad',
        'பிரச்சனை': 'problem',
        'யார்': 'who', 'என்ன': 'what', 'எப்போது': 'when', 'எங்கே': 'where', 'ஏன்': 'why',
        'இங்கே': 'here', 'அங்கே': 'there',
        'மற்றும்': 'and', 'முன்பு': 'before', 'பிறகு': 'after',
        'நாம்': 'we', 'நாங்கள்': 'we',
        'அவர்': 'he', 'அவர்கள்': 'they',
        'நன்றி': 'happy'
      },
      // TELUGU (te-IN)
      'te': {
        'నమస్కారం': 'hello', 'నమస్తే': 'hello',
        'మీరు': 'you', 'నువ్వు': 'you',
        'ఎలా': 'how',
        'నేను': 'i', 'నన్ను': 'me', 'నా': 'my', 'నాది': 'my',
        'పేరు': 'name',
        'ఆర్య': 'arya',
        'టీ': 'tea', 'కాఫీ': 'coffee',
        'సంతోషం': 'happy', 'మంచి': 'happy',
        'బాధ': 'sad',
        'సమస్య': 'problem',
        'ఎవరు': 'who', 'ఏమిటి': 'what', 'ఎప్పుడు': 'when', 'ఎక్కడ': 'where', 'ఎందుకు': 'why',
        'ఇక్కడ': 'here', 'అక్కడ': 'there',
        'మరియు': 'and', 'ముందు': 'before', 'తర్వాత': 'after',
        'మేము': 'we', 'మనము': 'we',
        'అతను': 'he', 'వారు': 'they',
        'ధన్యవాదాలు': 'happy'
      },
      // KANNADA (kn-IN)
      'kn': {
        'ನಮಸ್ಕಾರ': 'hello',
        'ನೀವು': 'you', 'ನೀನು': 'you',
        'ಹೇಗೆ': 'how',
        'ನಾನು': 'i', 'ನನ್ನ': 'my',
        'ಹೆಸರು': 'name',
        'ಆರ್ಯ': 'arya',
        'ಚಹಾ': 'tea', 'ಕಾಫಿ': 'coffee',
        'ಸಂತೋಷ': 'happy', 'ಒಳ್ಳೆಯದು': 'happy',
        'ದುಃಖ': 'sad',
        'ಸಮಸ್ಯೆ': 'problem',
        'ಯಾರು': 'who', 'ಏನು': 'what', 'ಯಾವಾಗ': 'when', 'ಎಲ್ಲಿ': 'where', 'ಏಕೆ': 'why',
        'ಇಲ್ಲಿ': 'here', 'ಅಲ್ಲಿ': 'there',
        'ಮತ್ತು': 'and', 'ಮೊದಲು': 'before', 'ನಂತರ': 'after',
        'ನಾವು': 'we',
        'ಅವನು': 'he', 'ಅವರು': 'they',
        'ಧನ್ಯವಾದಗಳು': 'happy'
      },
      // MALAYALAM (ml-IN)
      'ml': {
        'നമസ്കാരം': 'hello',
        'നിങ്ങൾ': 'you', 'നീ': 'you',
        'എങ്ങനെ': 'how',
        'ഞാൻ': 'i', 'എന്റെ': 'my',
        'പേര്': 'name',
        'ആര്യ': 'arya',
        'ചായ': 'tea', 'കോഫി': 'coffee',
        'സന്തോഷം': 'happy', 'നല്ലത്': 'happy',
        'സങ്കടം': 'sad',
        'പ്രശ്നം': 'problem',
        'ആര്': 'who', 'എന്ത്': 'what', 'എപ്പോൾ': 'when', 'എവിടെ': 'where', 'എന്തുകൊണ്ട്': 'why',
        'ഇവിടെ': 'here', 'അവിടെ': 'there',
        'കൂടാതെ': 'and', 'മുമ്പ്': 'before', 'ശേഷം': 'after',
        'ഞങ്ങൾ': 'we',
        'അവൻ': 'he', 'അവർ': 'they',
        'നന്ദി': 'happy'
      },
      // GUJARATI (gu-IN)
      'gu': {
        'નમસ્તે': 'hello', 'નમસ્કાર': 'hello',
        'તમે': 'you', 'તું': 'you',
        'કેમ': 'how',
        'હું': 'i', 'મારું': 'my',
        'નામ': 'name',
        'આર્યા': 'arya',
        'ચા': 'tea', 'કોફી': 'coffee',
        'ખુશ': 'happy', 'સારું': 'happy',
        'દુઃખી': 'sad',
        'સમસ્યા': 'problem',
        'કોણ': 'who', 'શું': 'what', 'ક્યારે': 'when', 'ક્યાં': 'where', 'કેમ': 'why',
        'અહીં': 'here', 'ત્યાં': 'there',
        'અને': 'and', 'પહેલાં': 'before', 'પછી': 'after',
        'અમે': 'we',
        'તે': 'he', 'તેઓ': 'they',
        'આભાર': 'happy'
      },
      // MARATHI (mr-IN)
      'mr': {
        'नमस्कार': 'hello',
        'तुम्ही': 'you', 'तू': 'you',
        'कसे': 'how', 'कसा': 'how', 'कशी': 'how',
        'मी': 'i', 'माझे': 'my', 'माझा': 'my',
        'नाव': 'name',
        'आर्या': 'arya',
        'चहा': 'tea', 'कॉफी': 'coffee',
        'आनंदी': 'happy', 'चांगले': 'happy',
        'दुःखी': 'sad',
        'समस्या': 'problem', 'अडचण': 'problem',
        'कोण': 'who', 'काय': 'what', 'केव्हा': 'when', 'कुठे': 'where', 'का': 'why',
        'येथे': 'here', 'तेथे': 'there',
        'आणि': 'and', 'आधी': 'before', 'नंतर': 'after',
        'आम्ही': 'we',
        'तो': 'he', 'ते': 'they',
        'धन्यवाद': 'happy'
      },
      // PUNJABI (pa-IN)
      'pa': {
        'ਸਤਿ ਸ੍ਰੀ ਅਕਾਲ': 'hello', 'ਨਮਸਤੇ': 'hello',
        'ਤੁਸੀਂ': 'you', 'ਤੂੰ': 'you',
        'ਕਿਵੇਂ': 'how',
        'ਮੈਂ': 'i', 'ਮੇਰਾ': 'my',
        'ਨਾਮ': 'name',
        'ਆਰਿਆ': 'arya',
        'ਚਾਹ': 'tea', 'ਕੌਫ਼ੀ': 'coffee',
        'ਖੁਸ਼': 'happy', 'ਚੰਗਾ': 'happy',
        'ਉਦਾਸ': 'sad',
        'ਮੁਸ਼ਕਲ': 'problem', 'ਸਮੱਸਿਆ': 'problem',
        'ਕੌਣ': 'who', 'ਕੀ': 'what', 'ਕਦੋਂ': 'when', 'ਕਿੱਥੇ': 'where', 'ਕਿਉਂ': 'why',
        'ਇੱਥੇ': 'here', 'ਉੱਥੇ': 'there',
        'ਅਤੇ': 'and', 'ਪਹਿਲਾਂ': 'before', 'ਬਾਅਦ': 'after',
        'ਅਸੀਂ': 'we',
        'ਉਹ': 'he',
        'ਧੰਨਵਾਦ': 'happy'
      }
    };
  }

  /**
   * Resolves a token or word into sign animation sequence.
   * @param {string} word - The token to map
   * @param {string} langCode - The 2-letter language code (e.g. 'en', 'hi', 'ta')
   * @returns {Array<{type: string, sign: string, displayName: string}>}
   */
  mapWordToSigns(word, langCode = 'en') {
    if (!word) return [];

    let clean = word.toLowerCase().trim();
    let mappedWord = clean;

    // 1. Check Indian language gloss dictionary if not English
    const shortLang = (langCode || 'en').split('-')[0].toLowerCase();
    if (shortLang !== 'en' && this.indianLanguageDict[shortLang]) {
      const dict = this.indianLanguageDict[shortLang];
      if (dict[word]) {
        mappedWord = dict[word];
      } else if (dict[clean]) {
        mappedWord = dict[clean];
      }
    }

    // 2. Check phrase synonyms (e.g. 'good morning' -> 'hello')
    if (this.phraseSynonyms[mappedWord]) {
      const synList = this.phraseSynonyms[mappedWord];
      const results = [];
      for (const syn of synList) {
        results.push(...this.mapWordToSigns(syn, 'en'));
      }
      return results;
    }

    // 3. Check if word exists directly in 85 core animation vocabulary
    if (this.coreVocabulary.has(mappedWord)) {
      return [{
        type: 'word',
        sign: mappedWord,
        signName: mappedWord,
        originalWord: word,
        displayName: word,
        isFingerspelled: false
      }];
    }

    // 4. Also check numeric special tokens (e.g. '100__', '20__')
    if (this.coreVocabulary.has(mappedWord + '__')) {
      return [{
        type: 'word',
        sign: mappedWord + '__',
        signName: mappedWord + '__',
        originalWord: word,
        displayName: word,
        isFingerspelled: false
      }];
    }

    // 5. Fallback: Fingerspell the word letter-by-letter using A-Z clips
    const letters = mappedWord.split('');
    const fingerspelled = [];

    for (const char of letters) {
      const lower = char.toLowerCase();
      if (this.coreVocabulary.has(lower)) {
        fingerspelled.push({
          type: 'alphabet',
          sign: lower,
          signName: lower,
          originalWord: word,
          displayName: `${word} (${char.toUpperCase()})`,
          isFingerspelled: true
        });
      }
    }

    return fingerspelled;
  }

  /**
   * Processes a sequence of normalized words into a complete array of sign animations.
   * @param {string[]} words 
   * @param {string} langCode 
   * @returns {Array<{type: string, sign: string, displayName: string}>}
   */
  mapSentenceToSigns(words, langCode = 'en') {
    if (!words || !words.length) return [];

    const sentenceSigns = [];
    const textJoined = words.join(' ').toLowerCase();

    // Check multi-word phrase synonyms first (e.g. 'thank you', 'good morning')
    for (const phrase in this.phraseSynonyms) {
      if (textJoined.includes(phrase)) {
        // Multi-word phrase detected
      }
    }

    for (let i = 0; i < words.length; i++) {
      // Check two-word pairs for phrase match (e.g. 'thank you', 'good morning')
      if (i < words.length - 1) {
        const twoWords = `${words[i]} ${words[i+1]}`.toLowerCase();
        if (this.phraseSynonyms[twoWords]) {
          const signs = this.phraseSynonyms[twoWords].flatMap(s => this.mapWordToSigns(s, 'en'));
          sentenceSigns.push(...signs);
          i++; // skip next word
          continue;
        }
      }

      const signs = this.mapWordToSigns(words[i], langCode);
      sentenceSigns.push(...signs);
    }

    return sentenceSigns;
  }

  /**
   * Checks if a word or phrase has a direct sign or synonym in the vocabulary.
   * @param {string} name
   * @returns {boolean}
   */
  hasSign(name) {
    if (!name) return false;
    const clean = name.toLowerCase().trim();
    return this.coreVocabulary.has(clean) || !!this.phraseSynonyms[clean];
  }
}

if (typeof window !== 'undefined') {
  window.SignMapper = SignMapper;
}

if (typeof module !== 'undefined' && module.exports) {
  module.exports = SignMapper;
}

