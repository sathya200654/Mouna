package com.fasterxml.jackson.core.internal.shaded.fdp.v2_18_4_1;

import com.azure.xml.implementation.aalto.util.XmlConsts;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.NavigableMap;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class JavaBigDecimalFromCharArray extends AbstractBigDecimalParser {
    public BigDecimal parseBigDecimalString(char[] cArr, int i, int i2) {
        boolean z;
        int i3;
        long j;
        int i4;
        int i5;
        long j2;
        int iTryToParseFourDigits;
        int i6 = i;
        try {
            int iCheckBounds = checkBounds(cArr.length, i6, i2);
            if (hasManyDigits(i2)) {
                return parseBigDecimalStringWithManyDigits(cArr, i, i2);
            }
            char cCharAt = charAt(cArr, i6, iCheckBounds);
            boolean z2 = cCharAt == '-';
            if (z2 || cCharAt == '+') {
                i6++;
                cCharAt = charAt(cArr, i6, iCheckBounds);
                if (cCharAt == 0) {
                    throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
                }
            }
            char c = cCharAt;
            int i7 = i6;
            char c2 = c;
            int i8 = -1;
            int i9 = i7;
            long j3 = 0;
            boolean z3 = false;
            while (true) {
                if (i9 >= iCheckBounds) {
                    z = true;
                    break;
                }
                c2 = cArr[i9];
                z = true;
                char c3 = (char) (c2 - '0');
                if (c3 >= '\n') {
                    if (c2 != '.') {
                        break;
                    }
                    z3 |= i8 >= 0;
                    int i10 = i9;
                    while (i10 < iCheckBounds - 4 && (iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(cArr, i10 + 1)) >= 0) {
                        j3 = (j3 * 10000) + ((long) iTryToParseFourDigits);
                        i10 += 4;
                    }
                    i8 = i9;
                    i9 = i10;
                } else {
                    j3 = (j3 * 10) + ((long) c3);
                }
                i9++;
            }
            if (i8 < 0) {
                i3 = i9 - i7;
                i4 = i9;
                j = 0;
            } else {
                i3 = (i9 - i7) - 1;
                j = (i8 - i9) + 1;
                i4 = i8;
            }
            if ((c2 | XmlConsts.CHAR_SPACE) == 101) {
                int i11 = i9 + 1;
                char cCharAt2 = charAt(cArr, i11, iCheckBounds);
                boolean z4 = cCharAt2 == '-' ? z : false;
                if (z4 || cCharAt2 == '+') {
                    i11 = i9 + 2;
                    cCharAt2 = charAt(cArr, i11, iCheckBounds);
                }
                char c4 = (char) (cCharAt2 - '0');
                z3 |= c4 >= '\n' ? z : false;
                long j4 = 0;
                while (true) {
                    if (j4 < 2147483647L) {
                        j4 = (j4 * 10) + ((long) c4);
                    }
                    j2 = j4;
                    i11++;
                    char cCharAt3 = (char) (charAt(cArr, i11, iCheckBounds) - '0');
                    if (cCharAt3 >= '\n') {
                        break;
                    }
                    j4 = j2;
                    c4 = cCharAt3;
                }
                if (z4) {
                    j2 = -j2;
                }
                j += j2;
                i5 = i11;
            } else {
                i5 = i9;
                i9 = iCheckBounds;
            }
            long j5 = j;
            if (i3 != 0) {
                z = false;
            }
            checkParsedBigDecimalBounds(z3 | z, i5, iCheckBounds, i3, j5);
            if (i3 < 19) {
                if (z2) {
                    j3 = -j3;
                }
                return new BigDecimal(j3).scaleByPowerOfTen((int) j5);
            }
            return valueOfBigDecimalString(cArr, i7, i4, i4 + 1, i9, z2, (int) j5);
        } catch (ArithmeticException e) {
            NumberFormatException numberFormatException = new NumberFormatException(AbstractNumberParser.VALUE_EXCEEDS_LIMITS);
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    /* JADX WARN: Failed to calculate best type for var: r2v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v7 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v0 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    java.math.BigDecimal parseBigDecimalStringWithManyDigits(char[] r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.internal.shaded.fdp.v2_18_4_1.JavaBigDecimalFromCharArray.parseBigDecimalStringWithManyDigits(char[], int, int):java.math.BigDecimal");
    }

    BigDecimal valueOfBigDecimalString(char[] cArr, int i, int i2, int i3, int i4, boolean z, int i5) {
        BigInteger bigIntegerNegate;
        BigInteger digitsIterative;
        int i6 = (i4 - i2) - 1;
        int i7 = i4 - i3;
        int i8 = i2 - i;
        NavigableMap<Integer, BigInteger> navigableMapCreatePowersOfTenFloor16Map = null;
        if (i8 <= 0) {
            bigIntegerNegate = BigInteger.ZERO;
        } else if (i8 > 400) {
            navigableMapCreatePowersOfTenFloor16Map = FastIntegerMath.createPowersOfTenFloor16Map();
            FastIntegerMath.fillPowersOfNFloor16Recursive(navigableMapCreatePowersOfTenFloor16Map, i, i2);
            bigIntegerNegate = ParseDigitsTaskCharArray.parseDigitsRecursive(cArr, i, i2, navigableMapCreatePowersOfTenFloor16Map, 400);
        } else {
            bigIntegerNegate = ParseDigitsTaskCharArray.parseDigitsIterative(cArr, i, i2);
        }
        if (i6 > 0) {
            if (i7 > 400) {
                if (navigableMapCreatePowersOfTenFloor16Map == null) {
                    navigableMapCreatePowersOfTenFloor16Map = FastIntegerMath.createPowersOfTenFloor16Map();
                }
                FastIntegerMath.fillPowersOfNFloor16Recursive(navigableMapCreatePowersOfTenFloor16Map, i3, i4);
                digitsIterative = ParseDigitsTaskCharArray.parseDigitsRecursive(cArr, i3, i4, navigableMapCreatePowersOfTenFloor16Map, 400);
            } else {
                digitsIterative = ParseDigitsTaskCharArray.parseDigitsIterative(cArr, i3, i4);
            }
            bigIntegerNegate = bigIntegerNegate.signum() == 0 ? digitsIterative : FftMultiplier.multiply(bigIntegerNegate, FastIntegerMath.computePowerOfTen(navigableMapCreatePowersOfTenFloor16Map, i6)).add(digitsIterative);
        }
        if (z) {
            bigIntegerNegate = bigIntegerNegate.negate();
        }
        return new BigDecimal(bigIntegerNegate, -i5);
    }
}
