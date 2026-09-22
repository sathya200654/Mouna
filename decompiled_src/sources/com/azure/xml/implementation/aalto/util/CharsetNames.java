package com.azure.xml.implementation.aalto.util;

import java.io.OutputStreamWriter;
import java.io.Writer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class CharsetNames implements XmlConsts {
    public static final String CS_EBCDIC = "EBCDIC";
    public static final String CS_ISO_LATIN1 = "ISO-8859-1";
    public static final String CS_SHIFT_JIS = "Shift_JIS";
    public static final String CS_US_ASCII = "US-ASCII";
    public static final String CS_UTF16 = "UTF-16";
    public static final String CS_UTF16BE = "UTF-16BE";
    public static final String CS_UTF16LE = "UTF-16LE";
    public static final String CS_UTF32 = "UTF-32";
    public static final String CS_UTF32BE = "UTF-32BE";
    public static final String CS_UTF32LE = "UTF-32LE";
    public static final String CS_UTF8 = "UTF-8";
    private static final int EOS = 65536;

    /* JADX WARN: Code duplicated, block: B:119:0x0150  */
    /* JADX WARN: Code duplicated, block: B:121:0x0156 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:122:0x0157  */
    /* JADX WARN: Code duplicated, block: B:123:0x0159  */
    /* JADX WARN: Code duplicated, block: B:125:0x0161 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:126:0x0162  */
    /* JADX WARN: Code duplicated, block: B:128:0x016a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:129:0x016b  */
    /* JADX WARN: Code duplicated, block: B:131:0x0171 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:132:0x0172  */
    /* JADX WARN: Code duplicated, block: B:134:0x0178 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:135:0x0179  */
    /* JADX WARN: Code duplicated, block: B:137:0x017f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:138:0x0180  */
    /* JADX WARN: Code duplicated, block: B:140:0x0186 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:141:0x0187  */
    /* JADX WARN: Code duplicated, block: B:148:0x019e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x007a  */
    /* JADX WARN: Code duplicated, block: B:74:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ef A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:92:0x0105  */
    /* JADX WARN: Code duplicated, block: B:94:0x010d  */
    public static String normalize(String str) {
        char cCharAt;
        char cCharAt2;
        String strSubstring = str;
        if (strSubstring == null || strSubstring.length() < 3) {
            return strSubstring;
        }
        boolean z = false;
        char cCharAt3 = strSubstring.charAt(0);
        if ((cCharAt3 == 'c' || cCharAt3 == 'C') && ((cCharAt = strSubstring.charAt(1)) == 's' || cCharAt == 'S')) {
            strSubstring = strSubstring.substring(2);
            cCharAt3 = strSubstring.charAt(0);
            z = true;
        }
        if (cCharAt3 == 'A') {
            if (!strSubstring.equals("ASCII") || equalEncodings(strSubstring, "ASCII")) {
                return CS_US_ASCII;
            }
        } else {
            if (cCharAt3 != 'C') {
                if (cCharAt3 == 'E') {
                    if (!strSubstring.startsWith(CS_EBCDIC) || strSubstring.startsWith("ebcdic")) {
                        return CS_EBCDIC;
                    }
                } else if (cCharAt3 == 'S') {
                    if (equalEncodings(strSubstring, CS_SHIFT_JIS)) {
                        return CS_SHIFT_JIS;
                    }
                } else if (cCharAt3 == 'U') {
                    if (strSubstring.length() >= 2) {
                        cCharAt2 = strSubstring.charAt(1);
                        if (cCharAt2 == 'C') {
                            if (equalEncodings(strSubstring, "UCS-2")) {
                                return CS_UTF16;
                            }
                            if (equalEncodings(strSubstring, "UCS-4")) {
                                return CS_UTF32;
                            }
                        } else if (cCharAt2 == 'N') {
                            if (z) {
                                if (equalEncodings(strSubstring, "Unicode")) {
                                    return CS_UTF16;
                                }
                                if (equalEncodings(strSubstring, "UnicodeAscii")) {
                                    return CS_ISO_LATIN1;
                                }
                                if (equalEncodings(strSubstring, "UnicodeAscii")) {
                                    return CS_US_ASCII;
                                }
                            }
                        } else if (cCharAt2 != 'c') {
                            if (cCharAt2 != 'n') {
                                if (cCharAt2 == 'S') {
                                    if (equalEncodings(strSubstring, CS_US_ASCII)) {
                                        return CS_US_ASCII;
                                    }
                                } else if (cCharAt2 == 'T') {
                                    if (!strSubstring.equals("UTF-8") || equalEncodings(strSubstring, "UTF-8")) {
                                        return "UTF-8";
                                    }
                                    if (equalEncodings(strSubstring, CS_UTF16BE)) {
                                        return CS_UTF16BE;
                                    }
                                    if (equalEncodings(strSubstring, CS_UTF16LE)) {
                                        return CS_UTF16LE;
                                    }
                                    if (equalEncodings(strSubstring, CS_UTF16)) {
                                        return CS_UTF16;
                                    }
                                    if (equalEncodings(strSubstring, CS_UTF32BE)) {
                                        return CS_UTF32BE;
                                    }
                                    if (equalEncodings(strSubstring, CS_UTF32LE)) {
                                        return CS_UTF32LE;
                                    }
                                    if (equalEncodings(strSubstring, CS_UTF32)) {
                                        return CS_UTF32;
                                    }
                                    if (equalEncodings(strSubstring, "UTF")) {
                                        return CS_UTF16;
                                    }
                                } else if (cCharAt2 != 's') {
                                    if (cCharAt2 == 't') {
                                        if (!strSubstring.equals("UTF-8")) {
                                        }
                                        return "UTF-8";
                                    }
                                } else if (equalEncodings(strSubstring, CS_US_ASCII)) {
                                    return CS_US_ASCII;
                                }
                            } else if (z) {
                                if (equalEncodings(strSubstring, "Unicode")) {
                                    return CS_UTF16;
                                }
                                if (equalEncodings(strSubstring, "UnicodeAscii")) {
                                    return CS_ISO_LATIN1;
                                }
                                if (equalEncodings(strSubstring, "UnicodeAscii")) {
                                    return CS_US_ASCII;
                                }
                            }
                        } else {
                            if (equalEncodings(strSubstring, "UCS-2")) {
                                return CS_UTF16;
                            }
                            if (equalEncodings(strSubstring, "UCS-4")) {
                                return CS_UTF32;
                            }
                        }
                    }
                } else {
                    if (cCharAt3 == 'a') {
                        if (!strSubstring.equals("ASCII")) {
                        }
                        return CS_US_ASCII;
                    }
                    if (cCharAt3 != 'c') {
                        if (cCharAt3 == 'e') {
                            if (!strSubstring.startsWith(CS_EBCDIC)) {
                            }
                            return CS_EBCDIC;
                        }
                        if (cCharAt3 != 's') {
                            if (cCharAt3 != 'u') {
                                if (cCharAt3 == 'I') {
                                    if (!strSubstring.equals(CS_ISO_LATIN1) || equalEncodings(strSubstring, CS_ISO_LATIN1) || equalEncodings(strSubstring, "ISO-Latin1")) {
                                        return CS_ISO_LATIN1;
                                    }
                                    if (encodingStartsWith(strSubstring, "ISO-10646")) {
                                        String strSubstring2 = strSubstring.substring(strSubstring.indexOf("10646") + 5);
                                        if (equalEncodings(strSubstring2, "UCS-Basic")) {
                                            return CS_US_ASCII;
                                        }
                                        if (equalEncodings(strSubstring2, "Unicode-Latin1")) {
                                            return CS_ISO_LATIN1;
                                        }
                                        if (equalEncodings(strSubstring2, "UCS-2")) {
                                            return CS_UTF16;
                                        }
                                        if (equalEncodings(strSubstring2, "UCS-4")) {
                                            return CS_UTF32;
                                        }
                                        if (equalEncodings(strSubstring2, "UTF-1") || equalEncodings(strSubstring2, "J-1") || equalEncodings(strSubstring2, CS_US_ASCII)) {
                                            return CS_US_ASCII;
                                        }
                                    }
                                } else if (cCharAt3 == 'J') {
                                    if (equalEncodings(strSubstring, "JIS_Encoding")) {
                                        return CS_SHIFT_JIS;
                                    }
                                } else {
                                    if (cCharAt3 == 'i') {
                                        if (strSubstring.equals(CS_ISO_LATIN1)) {
                                        }
                                        return CS_ISO_LATIN1;
                                    }
                                    if (cCharAt3 == 'j') {
                                        if (equalEncodings(strSubstring, "JIS_Encoding")) {
                                            return CS_SHIFT_JIS;
                                        }
                                    }
                                }
                            } else if (strSubstring.length() >= 2) {
                                cCharAt2 = strSubstring.charAt(1);
                                if (cCharAt2 == 'C') {
                                    if (equalEncodings(strSubstring, "UCS-2")) {
                                        return CS_UTF16;
                                    }
                                    if (equalEncodings(strSubstring, "UCS-4")) {
                                        return CS_UTF32;
                                    }
                                } else if (cCharAt2 == 'N') {
                                    if (z) {
                                        if (equalEncodings(strSubstring, "Unicode")) {
                                            return CS_UTF16;
                                        }
                                        if (equalEncodings(strSubstring, "UnicodeAscii")) {
                                            return CS_ISO_LATIN1;
                                        }
                                        if (equalEncodings(strSubstring, "UnicodeAscii")) {
                                            return CS_US_ASCII;
                                        }
                                    }
                                } else if (cCharAt2 != 'c') {
                                    if (cCharAt2 != 'n') {
                                        if (cCharAt2 == 'S') {
                                            if (equalEncodings(strSubstring, CS_US_ASCII)) {
                                                return CS_US_ASCII;
                                            }
                                        } else {
                                            if (cCharAt2 == 'T') {
                                                if (!strSubstring.equals("UTF-8")) {
                                                }
                                                return "UTF-8";
                                            }
                                            if (cCharAt2 != 's') {
                                                if (cCharAt2 == 't') {
                                                    if (!strSubstring.equals("UTF-8")) {
                                                    }
                                                    return "UTF-8";
                                                }
                                            } else if (equalEncodings(strSubstring, CS_US_ASCII)) {
                                                return CS_US_ASCII;
                                            }
                                        }
                                    } else if (z) {
                                        if (equalEncodings(strSubstring, "Unicode")) {
                                            return CS_UTF16;
                                        }
                                        if (equalEncodings(strSubstring, "UnicodeAscii")) {
                                            return CS_ISO_LATIN1;
                                        }
                                        if (equalEncodings(strSubstring, "UnicodeAscii")) {
                                            return CS_US_ASCII;
                                        }
                                    }
                                } else {
                                    if (equalEncodings(strSubstring, "UCS-2")) {
                                        return CS_UTF16;
                                    }
                                    if (equalEncodings(strSubstring, "UCS-4")) {
                                        return CS_UTF32;
                                    }
                                }
                            }
                        } else if (equalEncodings(strSubstring, CS_SHIFT_JIS)) {
                            return CS_SHIFT_JIS;
                        }
                    }
                }
            }
            encodingStartsWith(strSubstring, "cs");
            return strSubstring;
        }
        return strSubstring;
    }

    public static String findEncodingFor(Writer writer) {
        if (writer instanceof OutputStreamWriter) {
            return normalize(((OutputStreamWriter) writer).getEncoding());
        }
        return null;
    }

    public static boolean equalEncodings(String str, String str2) {
        int i;
        char cCharAt;
        int i2;
        char cCharAt2;
        int length = str.length();
        int length2 = str2.length();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length && i4 >= length2) {
                return true;
            }
            if (i3 >= length) {
                i = i3;
                cCharAt = 0;
            } else {
                i = i3 + 1;
                cCharAt = str.charAt(i3);
            }
            if (i4 >= length2) {
                i2 = i4;
                cCharAt2 = 0;
            } else {
                i2 = i4 + 1;
                cCharAt2 = str2.charAt(i4);
            }
            if (cCharAt != cCharAt2) {
                while (true) {
                    if (cCharAt > ' ' && cCharAt != '_' && cCharAt != '-') {
                        break;
                    }
                    if (i >= length) {
                        cCharAt = 0;
                    } else {
                        int i5 = i + 1;
                        char cCharAt3 = str.charAt(i);
                        i = i5;
                        cCharAt = cCharAt3;
                    }
                }
                while (true) {
                    if (cCharAt2 > ' ' && cCharAt2 != '_' && cCharAt2 != '-') {
                        break;
                    }
                    if (i2 >= length2) {
                        cCharAt2 = 0;
                    } else {
                        int i6 = i2 + 1;
                        char cCharAt4 = str2.charAt(i2);
                        i2 = i6;
                        cCharAt2 = cCharAt4;
                    }
                }
                if (cCharAt != cCharAt2 && (cCharAt == 0 || cCharAt2 == 0 || Character.toLowerCase(cCharAt) != Character.toLowerCase(cCharAt2))) {
                    return false;
                }
            }
            i3 = i;
            i4 = i2;
        }
    }

    public static boolean encodingStartsWith(String str, String str2) {
        int i;
        char cCharAt;
        int i2;
        char cCharAt2;
        int length = str.length();
        int length2 = str2.length();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length && i4 >= length2) {
                return true;
            }
            if (i3 >= length) {
                i = i3;
                cCharAt = 0;
            } else {
                i = i3 + 1;
                cCharAt = str.charAt(i3);
            }
            if (i4 >= length2) {
                i2 = i4;
                cCharAt2 = 0;
            } else {
                i2 = i4 + 1;
                cCharAt2 = str2.charAt(i4);
            }
            if (cCharAt != cCharAt2) {
                while (true) {
                    if (cCharAt > ' ' && cCharAt != '_' && cCharAt != '-') {
                        break;
                    }
                    if (i >= length) {
                        cCharAt = 0;
                    } else {
                        int i5 = i + 1;
                        char cCharAt3 = str.charAt(i);
                        i = i5;
                        cCharAt = cCharAt3;
                    }
                }
                while (true) {
                    if (cCharAt2 > ' ' && cCharAt2 != '_' && cCharAt2 != '-') {
                        break;
                    }
                    if (i2 >= length2) {
                        cCharAt2 = 0;
                    } else {
                        int i6 = i2 + 1;
                        char cCharAt4 = str2.charAt(i2);
                        i2 = i6;
                        cCharAt2 = cCharAt4;
                    }
                }
                if (cCharAt == cCharAt2) {
                    continue;
                } else {
                    if (cCharAt2 == 0) {
                        return true;
                    }
                    if (cCharAt == 0 || Character.toLowerCase(cCharAt) != Character.toLowerCase(cCharAt2)) {
                        return false;
                    }
                }
            }
            i3 = i;
            i4 = i2;
        }
    }
}
