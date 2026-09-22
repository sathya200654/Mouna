package com.fasterxml.jackson.core.io;

import com.azure.core.implementation.ImplUtils;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_18_4_1.JavaDoubleParser;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_18_4_1.JavaFloatParser;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NumberInput {
    static final long L_BILLION = 1000000000;

    @Deprecated
    public static final String NASTY_SMALL_DOUBLE = "2.2250738585072012e-308";
    static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
    static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);
    private static final Pattern PATTERN_FLOAT = Pattern.compile("[+-]?[0-9]*[\\.]?[0-9]+([eE][+-]?[0-9]+)?");
    private static final Pattern PATTERN_FLOAT_TRAILING_DOT = Pattern.compile("[+-]?[0-9]+[\\.]");

    public static int parseInt(char[] cArr, int i, int i2) {
        if (i2 > 0 && cArr[i] == '+') {
            i++;
            i2--;
        }
        int i3 = cArr[(i + i2) - 1] - '0';
        switch (i2) {
            case 9:
                i3 += (cArr[i] - '0') * 100000000;
                i++;
            case 8:
                i3 += (cArr[i] - '0') * 10000000;
                i++;
            case 7:
                i3 += (cArr[i] - '0') * 1000000;
                i++;
            case 6:
                i3 += (cArr[i] - '0') * 100000;
                i++;
            case 5:
                i3 += (cArr[i] - '0') * ImplUtils.MAX_CACHE_SIZE;
                i++;
            case 4:
                i3 += (cArr[i] - '0') * 1000;
                i++;
            case 3:
                i3 += (cArr[i] - '0') * 100;
                i++;
            case 2:
                return i3 + ((cArr[i] - '0') * 10);
            default:
                return i3;
        }
    }

    public static int parseInt(String str) {
        char cCharAt = str.charAt(0);
        int length = str.length();
        int i = 1;
        boolean z = cCharAt == '-';
        if (z) {
            if (length == 1 || length > 10) {
                return Integer.parseInt(str);
            }
            cCharAt = str.charAt(1);
            i = 2;
        } else if (length > 9) {
            return Integer.parseInt(str);
        }
        if (cCharAt > '9' || cCharAt < '0') {
            return Integer.parseInt(str);
        }
        int i2 = cCharAt - '0';
        if (i < length) {
            int i3 = i + 1;
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                return Integer.parseInt(str);
            }
            i2 = (i2 * 10) + (cCharAt2 - '0');
            if (i3 < length) {
                int i4 = i + 2;
                char cCharAt3 = str.charAt(i3);
                if (cCharAt3 > '9' || cCharAt3 < '0') {
                    return Integer.parseInt(str);
                }
                i2 = (i2 * 10) + (cCharAt3 - '0');
                if (i4 < length) {
                    while (true) {
                        int i5 = i4 + 1;
                        char cCharAt4 = str.charAt(i4);
                        if (cCharAt4 > '9' || cCharAt4 < '0') {
                            break;
                        }
                        i2 = (i2 * 10) + (cCharAt4 - '0');
                        if (i5 < length) {
                            i4 = i5;
                        }
                    }
                    return Integer.parseInt(str);
                }
            }
        }
        return z ? -i2 : i2;
    }

    public static long parseLong(char[] cArr, int i, int i2) {
        int i3 = i2 - 9;
        return (((long) parseInt(cArr, i, i3)) * 1000000000) + ((long) parseInt(cArr, i + i3, 9));
    }

    public static long parseLong19(char[] cArr, int i, boolean z) {
        long j = 0;
        for (int i2 = 0; i2 < 19; i2++) {
            j = (j * 10) + ((long) (cArr[i + i2] - '0'));
        }
        return z ? -j : j;
    }

    public static long parseLong(String str) {
        if (str.length() <= 9) {
            return parseInt(str);
        }
        return Long.parseLong(str);
    }

    public static boolean inLongRange(char[] cArr, int i, int i2, boolean z) {
        String str = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str.length();
        if (i2 < length) {
            return true;
        }
        if (i2 > length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            int iCharAt = cArr[i + i3] - str.charAt(i3);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    public static boolean inLongRange(String str, boolean z) {
        String str2 = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int iCharAt = str.charAt(i) - str2.charAt(i);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    public static int parseAsInt(String str, int i) {
        String strTrim;
        int length;
        if (str == null || (length = (strTrim = str.trim()).length()) == 0) {
            return i;
        }
        int i2 = 0;
        char cCharAt = strTrim.charAt(0);
        if (cCharAt == '+') {
            strTrim = strTrim.substring(1);
            length = strTrim.length();
        } else if (cCharAt == '-') {
            i2 = 1;
        }
        while (i2 < length) {
            char cCharAt2 = strTrim.charAt(i2);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                try {
                    return (int) parseDouble(strTrim, true);
                } catch (NumberFormatException unused) {
                    return i;
                }
            }
            i2++;
        }
        try {
            return Integer.parseInt(strTrim);
        } catch (NumberFormatException unused2) {
            return i;
        }
    }

    public static long parseAsLong(String str, long j) {
        String strTrim;
        int length;
        if (str == null || (length = (strTrim = str.trim()).length()) == 0) {
            return j;
        }
        int i = 0;
        char cCharAt = strTrim.charAt(0);
        if (cCharAt == '+') {
            strTrim = strTrim.substring(1);
            length = strTrim.length();
        } else if (cCharAt == '-') {
            i = 1;
        }
        while (i < length) {
            char cCharAt2 = strTrim.charAt(i);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                try {
                    return (long) parseDouble(strTrim, true);
                } catch (NumberFormatException unused) {
                    return j;
                }
            }
            i++;
        }
        try {
            return Long.parseLong(strTrim);
        } catch (NumberFormatException unused2) {
            return j;
        }
    }

    public static double parseAsDouble(String str, double d) {
        return parseAsDouble(str, d, false);
    }

    public static double parseAsDouble(String str, double d, boolean z) {
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                try {
                    return parseDouble(strTrim, z);
                } catch (NumberFormatException unused) {
                    return d;
                }
            }
        }
        return d;
    }

    @Deprecated
    public static double parseDouble(String str) throws NumberFormatException {
        return parseDouble(str, false);
    }

    public static double parseDouble(String str, boolean z) throws NumberFormatException {
        return z ? JavaDoubleParser.parseDouble(str) : Double.parseDouble(str);
    }

    public static double parseDouble(char[] cArr, boolean z) throws NumberFormatException {
        return parseDouble(cArr, 0, cArr.length, z);
    }

    public static double parseDouble(char[] cArr, int i, int i2, boolean z) throws NumberFormatException {
        if (z) {
            return JavaDoubleParser.parseDouble(cArr, i, i2);
        }
        return Double.parseDouble(new String(cArr, i, i2));
    }

    @Deprecated
    public static float parseFloat(String str) throws NumberFormatException {
        return parseFloat(str, false);
    }

    public static float parseFloat(String str, boolean z) throws NumberFormatException {
        if (z) {
            return JavaFloatParser.parseFloat(str);
        }
        return Float.parseFloat(str);
    }

    public static float parseFloat(char[] cArr, boolean z) throws NumberFormatException {
        return parseFloat(cArr, 0, cArr.length, z);
    }

    public static float parseFloat(char[] cArr, int i, int i2, boolean z) throws NumberFormatException {
        if (z) {
            return JavaFloatParser.parseFloat(cArr, i, i2);
        }
        return Float.parseFloat(new String(cArr, i, i2));
    }

    @Deprecated
    public static BigDecimal parseBigDecimal(String str) throws NumberFormatException {
        return parseBigDecimal(str, false);
    }

    public static BigDecimal parseBigDecimal(String str, boolean z) throws NumberFormatException {
        if (z) {
            return BigDecimalParser.parseWithFastParser(str);
        }
        return BigDecimalParser.parse(str);
    }

    @Deprecated
    public static BigDecimal parseBigDecimal(char[] cArr, int i, int i2) throws NumberFormatException {
        return BigDecimalParser.parse(cArr, i, i2);
    }

    public static BigDecimal parseBigDecimal(char[] cArr, int i, int i2, boolean z) throws NumberFormatException {
        if (z) {
            return BigDecimalParser.parseWithFastParser(cArr, i, i2);
        }
        return BigDecimalParser.parse(cArr, i, i2);
    }

    @Deprecated
    public static BigDecimal parseBigDecimal(char[] cArr) throws NumberFormatException {
        return BigDecimalParser.parse(cArr);
    }

    public static BigDecimal parseBigDecimal(char[] cArr, boolean z) throws NumberFormatException {
        if (z) {
            return BigDecimalParser.parseWithFastParser(cArr, 0, cArr.length);
        }
        return BigDecimalParser.parse(cArr);
    }

    @Deprecated
    public static BigInteger parseBigInteger(String str) throws NumberFormatException {
        return parseBigInteger(str, false);
    }

    public static BigInteger parseBigInteger(String str, boolean z) throws NumberFormatException {
        if (z) {
            return BigIntegerParser.parseWithFastParser(str);
        }
        return new BigInteger(str);
    }

    public static BigInteger parseBigIntegerWithRadix(String str, int i, boolean z) throws NumberFormatException {
        if (z) {
            return BigIntegerParser.parseWithFastParser(str, i);
        }
        return new BigInteger(str, i);
    }

    public static boolean looksLikeValidNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        if (str.length() != 1) {
            return PATTERN_FLOAT.matcher(str).matches() || PATTERN_FLOAT_TRAILING_DOT.matcher(str).matches();
        }
        char cCharAt = str.charAt(0);
        return cCharAt <= '9' && cCharAt >= '0';
    }
}
