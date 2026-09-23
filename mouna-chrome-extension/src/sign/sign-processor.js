/**
 * Mouna - Sign Processor
 * Reuses text processing, number-to-sign conversion (inWords), and sentence segmentation
 * from the original Mouna mobile application.
 */

class SignProcessor {
  constructor() {
    this.verbsList = ['run', 'walk', 'speak', 'write', 'read', 'see', 'listen', 'come', 'go', 'eat', 'drink'];
  }

  /**
   * Normalizes incoming raw speech/text input into clean signable words.
   * @param {string} text - Raw input string
   * @returns {string[]} Array of normalized word tokens
   */
  normalizeText(text) {
    if (!text || typeof text !== 'string') return [];

    // Replace common symbols & contractions, preserving all Unicode letters & marks (Indic scripts)
    let cleaned = text
      .trim()
      .replace(/[`’]/g, "'")
      .replace(/([!?]){2,}/g, '$1')
      .replace(/\.{2,}/g, '.')
      .replace(/\r?\n|\r/g, ' ')
      .replace(/[^\p{L}\p{M}\p{N}\s.'-]/gu, ' ')
      .replace(/\s+/g, ' ');

    if (!cleaned) return [];

    const rawWords = cleaned.split(' ').filter(w => w.length > 0);
    const resultWords = [];

    for (const raw of rawWords) {
      let word = raw.toLowerCase().trim();

      // Check if it's a numeric sequence
      if (/^\d+(\.\d+)?$/.test(word)) {
        const numberWords = this.convertNumberToWords(word);
        resultWords.push(...numberWords);
      } else {
        // Strip leading & trailing punctuation from individual words (including Indic danda)
        word = word.replace(/^[.,!?:;।॥'"()\-]+|[.,!?:;।॥'"()\-]+$/gu, '');
        if (word.length > 0) {
          resultWords.push(word);
        }
      }
    }

    return resultWords;
  }

  /**
   * Converts a numeric string into signable words/tokens according to Mouna conventions.
   * Produces tokens such as '100__', '20__', '5', 'dot', etc.
   * @param {string} numStr 
   * @returns {string[]}
   */
  convertNumberToWords(numStr) {
    const parts = numStr.split('.');
    const integerPart = parts[0];
    const decimalPart = parts[1] || null;

    const tokens = [];

    if (integerPart) {
      const intVal = parseInt(integerPart, 10);
      if (intVal === 0) {
        tokens.push('0');
      } else {
        tokens.push(...this.breakDownInteger(intVal));
      }
    }

    if (decimalPart) {
      tokens.push('dot');
      for (const ch of decimalPart) {
        tokens.push(ch);
      }
    }

    return tokens;
  }

  /**
   * Decomposes an integer into standard Mouna sign clip tokens:
   * e.g. 125 -> ['100__', '20__', '5']
   */
  breakDownInteger(val) {
    if (val < 0) return ['0'];
    const tokens = [];

    // Crores (10,000,000)
    if (val >= 10000000) {
      const croreCount = Math.floor(val / 10000000);
      tokens.push(...this.breakDownInteger(croreCount));
      tokens.push('crore');
      val %= 10000000;
    }

    // Lakhs (100,000)
    if (val >= 100000) {
      const lakhCount = Math.floor(val / 100000);
      tokens.push(...this.breakDownInteger(lakhCount));
      tokens.push('lakh');
      val %= 100000;
    }

    // Thousands (1,000)
    if (val >= 1000) {
      const thousandCount = Math.floor(val / 1000);
      tokens.push(...this.breakDownInteger(thousandCount));
      tokens.push('1000__');
      val %= 1000;
    }

    // Hundreds (100)
    if (val >= 100) {
      const hundredCount = Math.floor(val / 100);
      if (hundredCount > 1) {
        tokens.push(String(hundredCount));
      }
      tokens.push('100__');
      val %= 100;
    }

    // Tens (20-99)
    if (val >= 20) {
      const tensDigit = Math.floor(val / 10) * 10;
      tokens.push(`${tensDigit}__`);
      val %= 10;
    }

    // Units / Teens (1-19)
    if (val > 0) {
      tokens.push(String(val));
    }

    return tokens;
  }
}

if (typeof window !== 'undefined') {
  window.SignProcessor = SignProcessor;
}

if (typeof module !== 'undefined' && module.exports) {
  module.exports = SignProcessor;
}

