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
        'आप': 'you', 'तुम': 'you', 'तू': 'you', 'आपका': 'your', 'आपकी': 'your', 'आपके': 'your',
        'कैसा': 'how', 'कैसे': 'how', 'कैसी': 'how',
        'मैं': 'i', 'मुझे': 'me', 'मेरा': 'my', 'मेरी': 'my', 'मेरे': 'my',
        'नाम': 'name',
        'आर्या': 'arya', 'आर्य': 'arya',
        'चाय': 'tea', 'कॉफी': 'coffee', 'कॉफ़ी': 'coffee',
        'खुश': 'happy', 'प्रसन्न': 'happy', 'अच्छा': 'happy', 'अच्छी': 'happy', 'अच्छे': 'happy', 'बढ़िया': 'happy',
        'दुखी': 'sad', 'उदास': 'sad', 'परेशान': 'sad',
        'समस्या': 'problem', 'दिक्कत': 'problem', 'परेशानी': 'problem',
        'कौन': 'who', 'क्या': 'what', 'कब': 'when', 'कहाँ': 'where', 'कहा': 'where', 'क्यों': 'why',
        'यहाँ': 'here', 'वहाँ': 'there', 'इधर': 'here', 'उधर': 'there',
        'और': 'and', 'पहले': 'before', 'बाद': 'after',
        'हम': 'we', 'हमे': 'us', 'हमें': 'us', 'हमारा': 'our', 'हमारी': 'our',
        'वह': 'he', 'वे': 'they', 'उनका': 'their',
        'धन्यवाद': 'happy', 'शुक्रिया': 'happy',
        'बहुत': 'many', 'ज्यादा': 'many', 'कुछ': 'some', 'थोड़ा': 'some',
        'यह': 'this__', 'ये': 'this__', 'कोई': 'some'
      },
      // TAMIL (ta-IN)
      'ta': {
        'வணக்கம்': 'hello', 'வந்தனம்': 'hello',
        'நீங்கள்': 'you', 'நீ': 'you', 'உங்களுக்கு': 'you', 'உங்கள்': 'your',
        'எப்படி': 'how',
        'நான்': 'i', 'என்னை': 'me', 'என்': 'my', 'எனது': 'my',
        'பெயர்': 'name',
        'ஆர்யா': 'arya',
        'தேநீர்': 'tea', 'காபி': 'coffee',
        'மகிழ்ச்சி': 'happy', 'நன்று': 'happy', 'நல்ல': 'happy', 'நலம்': 'happy', 'நலமாக': 'happy',
        'வருத்தம்': 'sad', 'சோகம்': 'sad',
        'பிரச்சனை': 'problem', 'சிக்கல்': 'problem',
        'யார்': 'who', 'என்ன': 'what', 'எப்போது': 'when', 'எங்கே': 'where', 'ஏன்': 'why',
        'இங்கே': 'here', 'அங்கே': 'there',
        'மற்றும்': 'and', 'முன்பு': 'before', 'பிறகு': 'after',
        'நாம்': 'we', 'நாங்கள்': 'we',
        'அவர்': 'he', 'அவர்கள்': 'they',
        'நன்றி': 'happy',
        'பல': 'many', 'அதிக': 'many', 'சில': 'some',
        'இருக்கிறீர்கள்': 'you', 'இருக்கிறேன்': 'i', 'இருக்கிறது': 'this__'
      },
      // TELUGU (te-IN)
      'te': {
        'నమస్కారం': 'hello', 'నమస్తే': 'hello',
        'మీరు': 'you', 'నువ్వు': 'you', 'మీ': 'your',
        'ఎలా': 'how',
        'నేను': 'i', 'నన్ను': 'me', 'నా': 'my', 'నాది': 'my',
        'పేరు': 'name',
        'ఆర్య': 'arya',
        'టీ': 'tea', 'కాఫీ': 'coffee',
        'సంతోషం': 'happy', 'మంచి': 'happy', 'బాగుంది': 'happy', 'బాగున్నాను': 'happy',
        'బాధ': 'sad',
        'సమస్య': 'problem',
        'ఎవరు': 'who', 'ఏమిటి': 'what', 'ఏంటి': 'what', 'ఎప్పుడు': 'when', 'ఎక్కడ': 'where', 'ఎందుకు': 'why',
        'ఇక్కడ': 'here', 'అక్కడ': 'there',
        'మరియు': 'and', 'ముందు': 'before', 'తర్వాత': 'after',
        'మేము': 'we', 'మనము': 'we',
        'అతను': 'he', 'వారు': 'they',
        'ధన్యవాదాలు': 'happy',
        'చాలా': 'many', 'కొన్ని': 'some',
        'ఉన్నారు': 'you', 'ఉన్నాను': 'i'
      },
      // KANNADA (kn-IN)
      'kn': {
        'ನಮಸ್ಕಾರ': 'hello',
        'ನೀವು': 'you', 'ನೀನು': 'you', 'ನಿಮ್ಮ': 'your',
        'ಹೇಗೆ': 'how', 'ಹೇಗಿದ್ದೀರಿ': 'how',
        'ನಾನು': 'i', 'ನನ್ನ': 'my',
        'ಹೆಸರು': 'name',
        'ಆರ್ಯ': 'arya',
        'ಚಹಾ': 'tea', 'ಕಾಫಿ': 'coffee',
        'ಸಂತೋಷ': 'happy', 'ಒಳ್ಳೆಯದು': 'happy', 'ಚೆನ್ನಾಗಿದೆ': 'happy',
        'ದುಃಖ': 'sad',
        'ಸಮಸ್ಯೆ': 'problem',
        'ಯಾರು': 'who', 'ಏನು': 'what', 'ಯಾವಾಗ': 'when', 'ಎಲ್ಲಿ': 'where', 'ಏಕೆ': 'why',
        'ಇಲ್ಲಿ': 'here', 'ಅಲ್ಲಿ': 'there',
        'ಮತ್ತು': 'and', 'ಮೊದಲು': 'before', 'ನಂತರ': 'after',
        'ನಾವು': 'we',
        'ಅವನು': 'he', 'ಅವರು': 'they',
        'ಧನ್ಯವಾದಗಳು': 'happy',
        'ತುಂಬಾ': 'many', 'ಕೆಲವು': 'some'
      },
      // MALAYALAM (ml-IN)
      'ml': {
        'നമസ്കാരം': 'hello',
        'നിങ്ങൾ': 'you', 'നീ': 'you', 'നിങ്ങളുടെ': 'your',
        'എങ്ങനെ': 'how', 'സുഖമാണോ': 'happy',
        'ഞാൻ': 'i', 'എന്റെ': 'my',
        'പേര്': 'name',
        'ആര്യ': 'arya',
        'ചായ': 'tea', 'കോഫി': 'coffee',
        'സന്തോഷം': 'happy', 'നല്ലത്': 'happy', 'സുഖം': 'happy',
        'സങ്കടം': 'sad',
        'പ്രശ്നം': 'problem',
        'ആര്': 'who', 'എന്ത്': 'what', 'എപ്പോൾ': 'when', 'എവിടെ': 'where', 'എന്തുകൊണ്ട്': 'why',
        'ഇവിടെ': 'here', 'അവിടെ': 'there',
        'കൂടാതെ': 'and', 'മുമ്പ്': 'before', 'ശേഷം': 'after',
        'ഞങ്ങൾ': 'we',
        'അവൻ': 'he', 'അവർ': 'they',
        'നന്ദി': 'happy',
        'വളരെ': 'many', 'കുറച്ച്': 'some'
      },
      // GUJARATI (gu-IN)
      'gu': {
        'નમસ્તે': 'hello', 'નમસ્કાર': 'hello',
        'તમે': 'you', 'તું': 'you', 'તમારું': 'your',
        'કેમ': 'how', 'કેવી રીતે': 'how',
        'હું': 'i', 'મને': 'me', 'મારું': 'my',
        'નામ': 'name',
        'આર્યા': 'arya',
        'ચા': 'tea', 'કોફી': 'coffee',
        'ખુશ': 'happy', 'સારું': 'happy', 'મજા': 'happy',
        'દુઃખી': 'sad',
        'સમસ્યા': 'problem',
        'કોણ': 'who', 'શું': 'what', 'ક્યારે': 'when', 'ક્યાં': 'where',
        'અહીં': 'here', 'ત્યાં': 'there',
        'અને': 'and', 'પહેલાં': 'before', 'પછી': 'after',
        'અમે': 'we',
        'તે': 'he', 'તેઓ': 'they',
        'આભાર': 'happy',
        'ઘણા': 'many', 'બહુ': 'many', 'થોડું': 'some',
        'છો': 'you', 'છું': 'i'
      },
      // MARATHI (mr-IN)
      'mr': {
        'नमस्कार': 'hello',
        'तुम्ही': 'you', 'तू': 'you', 'तुमचे': 'your',
        'कसे': 'how', 'कसा': 'how', 'कशी': 'how',
        'मी': 'i', 'मला': 'me', 'माझे': 'my', 'माझा': 'my',
        'नाव': 'name',
        'आर्या': 'arya',
        'चहा': 'tea', 'कॉफी': 'coffee',
        'आनंदी': 'happy', 'चांगले': 'happy', 'छान': 'happy',
        'दुःखी': 'sad',
        'समस्या': 'problem', 'अडचण': 'problem',
        'कोण': 'who', 'काय': 'what', 'केव्हा': 'when', 'कुठे': 'where', 'का': 'why',
        'येथे': 'here', 'तेथे': 'there',
        'आणि': 'and', 'आधी': 'before', 'नंतर': 'after',
        'आम्ही': 'we',
        'तो': 'he', 'ते': 'they',
        'धन्यवाद': 'happy', 'आभार': 'happy',
        'खूप': 'many', 'काही': 'some',
        'आहात': 'you', 'आहे': 'i'
      },
      // PUNJABI (pa-IN)
      'pa': {
        'ਸਤਿ ਸ੍ਰੀ ਅਕਾਲ': 'hello', 'ਸਤਿ': 'hello', 'ਨਮਸਤੇ': 'hello',
        'ਤੁਸੀਂ': 'you', 'ਤੂੰ': 'you', 'ਤੁਹਾਡਾ': 'your',
        'ਕਿਵੇਂ': 'how',
        'ਮੈਂ': 'i', 'ਮੈਨੂੰ': 'me', 'ਮੇਰਾ': 'my',
        'ਨਾਮ': 'name',
        'ਆਰਿਆ': 'arya',
        'ਚਾਹ': 'tea', 'ਕੌਫ਼ੀ': 'coffee',
        'ਖੁਸ਼': 'happy', 'ਚੰਗਾ': 'happy', 'ਵਧੀਆ': 'happy',
        'ਉਦਾਸ': 'sad',
        'ਮੁਸ਼ਕਲ': 'problem', 'ਸਮੱਸਿਆ': 'problem',
        'ਕੌਣ': 'who', 'ਕੀ': 'what', 'ਕਦੋਂ': 'when', 'ਕਿੱਥੇ': 'where', 'ਕਿਉਂ': 'why',
        'ਇੱਥੇ': 'here', 'ਉੱਥੇ': 'there',
        'ਅਤੇ': 'and', 'ਪਹਿਲਾਂ': 'before', 'ਬਾਅਦ': 'after',
        'ਅਸੀਂ': 'we',
        'ਉਹ': 'he',
        'ਧੰਨਵਾਦ': 'happy',
        'ਬਹੁਤ': 'many', 'ਕੁਝ': 'some',
        'ਹੋ': 'you', 'ਹਾਂ': 'i'
      }
    };
  }

  /**
   * Transliterates an Indic word into approximate Latin letters for A-Z fingerspelling fallback.
   * Exploits the uniform offset mapping of Brahmic scripts in Unicode (Devanagari, Bengali, Gurmukhi,
   * Gujarati, Tamil, Telugu, Kannada, Malayalam).
   * @param {string} text 
   * @returns {string} Latin phonetic representation
   */
  transliterateIndic(text) {
    if (!text) return '';
    let out = '';
    for (let i = 0; i < text.length; i++) {
      const code = text.charCodeAt(i);
      // Check if in Indic blocks (U+0900 to U+0D7F)
      if (code >= 0x0900 && code <= 0x0D7F) {
        const offset = code & 0x7F; // standard Brahmic relative offset
        switch (offset) {
          case 0x05: out += 'a'; break;
          case 0x06: out += 'a'; break;
          case 0x07: out += 'i'; break;
          case 0x08: out += 'i'; break;
          case 0x09: out += 'u'; break;
          case 0x0A: out += 'u'; break;
          case 0x0E: case 0x0F: out += 'e'; break;
          case 0x10: out += 'ai'; break;
          case 0x12: case 0x13: out += 'o'; break;
          case 0x14: out += 'au'; break;
          case 0x15: out += 'k'; break;
          case 0x16: out += 'kh'; break;
          case 0x17: out += 'g'; break;
          case 0x18: out += 'gh'; break;
          case 0x1A: out += 'ch'; break;
          case 0x1B: out += 'chh'; break;
          case 0x1C: out += 'j'; break;
          case 0x1D: out += 'jh'; break;
          case 0x1F: out += 't'; break;
          case 0x20: out += 'th'; break;
          case 0x21: out += 'd'; break;
          case 0x22: out += 'dh'; break;
          case 0x23: out += 'n'; break;
          case 0x24: out += 't'; break;
          case 0x25: out += 'th'; break;
          case 0x26: out += 'd'; break;
          case 0x27: out += 'dh'; break;
          case 0x28: out += 'n'; break;
          case 0x2A: out += 'p'; break;
          case 0x2B: out += 'ph'; break;
          case 0x2C: out += 'b'; break;
          case 0x2D: out += 'bh'; break;
          case 0x2E: out += 'm'; break;
          case 0x2F: out += 'y'; break;
          case 0x30: out += 'r'; break;
          case 0x32: out += 'l'; break;
          case 0x35: out += 'v'; break;
          case 0x36: case 0x37: out += 'sh'; break;
          case 0x38: out += 's'; break;
          case 0x39: out += 'h'; break;
          case 0x3E: out += 'a'; break;
          case 0x3F: case 0x40: out += 'i'; break;
          case 0x41: case 0x42: out += 'u'; break;
          case 0x46: case 0x47: out += 'e'; break;
          case 0x48: out += 'ai'; break;
          case 0x4A: case 0x4B: out += 'o'; break;
          case 0x4C: out += 'au'; break;
          default: break;
        }
      } else {
        out += text[i];
      }
    }
    return out.toLowerCase();
  }

  /**
   * Auto-detects whether text or words belong to an Indian language script or English.
   * @param {string|string[]} textOrWords 
   * @returns {string} 2-letter language code ('en', 'hi', 'ta', 'te', 'kn', 'ml', 'gu', 'pa')
   */
  detectLanguage(textOrWords) {
    const joined = Array.isArray(textOrWords) ? textOrWords.join('') : String(textOrWords || '');
    if (/[\u0900-\u097F]/.test(joined)) return 'hi';
    if (/[\u0B80-\u0BFF]/.test(joined)) return 'ta';
    if (/[\u0C00-\u0C7F]/.test(joined)) return 'te';
    if (/[\u0C80-\u0CFF]/.test(joined)) return 'kn';
    if (/[\u0D00-\u0D7F]/.test(joined)) return 'ml';
    if (/[\u0A80-\u0AFF]/.test(joined)) return 'gu';
    if (/[\u0A00-\u0A7F]/.test(joined)) return 'pa';
    return 'en';
  }

  /**
   * Resolves a token or word into sign animation sequence.
   * @param {string} word - The token to map
   * @param {string} langCode - The 2-letter language code or 'auto'
   * @returns {Array<{type: string, sign: string, displayName: string}>}
   */
  mapWordToSigns(word, langCode = 'auto') {
    if (!word) return [];

    let activeLang = langCode;
    if (!activeLang || activeLang === 'auto' || (activeLang === 'en' && /[\u0900-\u0D7F]/.test(word))) {
      activeLang = this.detectLanguage(word);
    }

    let clean = word.toLowerCase().trim();
    let mappedWord = clean;

    // 1. Check Indian language gloss dictionary if not English
    const shortLang = activeLang.split('-')[0].toLowerCase();
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

    // 5. Transliterate Indic characters to Latin if still non-ASCII
    let wordToSpell = mappedWord;
    if (/[\u0900-\u0D7F]/.test(mappedWord)) {
      wordToSpell = this.transliterateIndic(mappedWord);
    }

    // 6. Fallback: Fingerspell the word letter-by-letter using A-Z clips
    const letters = wordToSpell.split('');
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
   * Supports 3-word, 2-word, and 1-word tokens for both English and Indian languages.
   * @param {string[]} words 
   * @param {string} langCode 
   * @returns {Array<{type: string, sign: string, displayName: string}>}
   */
  mapSentenceToSigns(words, langCode = 'auto') {
    if (!words || !words.length) return [];

    let activeLang = langCode;
    if (!activeLang || activeLang === 'auto' || (activeLang === 'en' && /[\u0900-\u0D7F]/.test(words.join('')))) {
      activeLang = this.detectLanguage(words);
    }

    const sentenceSigns = [];
    const shortLang = activeLang.split('-')[0].toLowerCase();
    const dict = shortLang !== 'en' ? (this.indianLanguageDict[shortLang] || null) : null;

    for (let i = 0; i < words.length; i++) {
      // 1. Check three-word phrase in phraseSynonyms or Indian language dictionary
      if (i < words.length - 2) {
        const threeWords = `${words[i]} ${words[i+1]} ${words[i+2]}`.toLowerCase();
        if (this.phraseSynonyms[threeWords]) {
          const signs = this.phraseSynonyms[threeWords].flatMap(s => this.mapWordToSigns(s, 'en'));
          sentenceSigns.push(...signs);
          i += 2;
          continue;
        }
        if (dict && dict[threeWords]) {
          const mapped = dict[threeWords];
          const signs = this.mapWordToSigns(mapped, 'en');
          sentenceSigns.push(...signs);
          i += 2;
          continue;
        }
      }

      // 2. Check two-word phrase in phraseSynonyms or Indian language dictionary
      if (i < words.length - 1) {
        const twoWords = `${words[i]} ${words[i+1]}`.toLowerCase();
        if (this.phraseSynonyms[twoWords]) {
          const signs = this.phraseSynonyms[twoWords].flatMap(s => this.mapWordToSigns(s, 'en'));
          sentenceSigns.push(...signs);
          i += 1;
          continue;
        }
        if (dict && dict[twoWords]) {
          const mapped = dict[twoWords];
          const signs = this.mapWordToSigns(mapped, 'en');
          sentenceSigns.push(...signs);
          i += 1;
          continue;
        }
      }

      // 3. Single word lookup
      const signs = this.mapWordToSigns(words[i], activeLang);
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

