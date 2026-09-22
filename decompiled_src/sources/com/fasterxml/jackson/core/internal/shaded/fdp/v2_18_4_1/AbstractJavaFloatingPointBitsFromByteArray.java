package com.fasterxml.jackson.core.internal.shaded.fdp.v2_18_4_1;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
abstract class AbstractJavaFloatingPointBitsFromByteArray extends AbstractFloatValueParser {
    abstract long nan();

    abstract long negativeInfinity();

    abstract long positiveInfinity();

    abstract long valueOfFloatLiteral(byte[] bArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);

    abstract long valueOfHexLiteral(byte[] bArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);

    AbstractJavaFloatingPointBitsFromByteArray() {
    }

    private static int skipWhitespace(byte[] bArr, int i, int i2) {
        while (i < i2 && (bArr[i] & UnsignedBytes.MAX_VALUE) <= 32) {
            i++;
        }
        return i;
    }

    private long parseDecFloatLiteral(byte[] bArr, int i, int i2, int i3, boolean z, boolean z2) {
        long j;
        int i4;
        int i5;
        int i6;
        int i7;
        long j2;
        boolean z3;
        int i8;
        long j3;
        byte bCharAt;
        int iTryToParseFourDigits;
        int i9 = -1;
        int i10 = i;
        long j4 = 0;
        byte b = 0;
        boolean z4 = false;
        while (true) {
            j = 10;
            if (i10 >= i3) {
                break;
            }
            b = bArr[i10];
            char c = (char) (b - 48);
            if (c >= '\n') {
                if (b != 46) {
                    break;
                }
                z4 |= i9 >= 0;
                int i11 = i10;
                while (i11 < i3 - 4 && (iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(bArr, i11 + 1)) >= 0) {
                    j4 = (j4 * 10000) + ((long) iTryToParseFourDigits);
                    i11 += 4;
                }
                int i12 = i10;
                i10 = i11;
                i9 = i12;
            } else {
                j4 = (j4 * 10) + ((long) c);
            }
            i10++;
        }
        if (i9 < 0) {
            i4 = i10 - i;
            i9 = i10;
            i5 = 0;
        } else {
            i4 = (i10 - i) - 1;
            i5 = (i9 - i10) + 1;
        }
        if ((b | 32) == 101) {
            i6 = i10 + 1;
            byte bCharAt2 = charAt(bArr, i6, i3);
            boolean z5 = bCharAt2 == 45;
            if (z5 || bCharAt2 == 43) {
                i6 = i10 + 2;
                bCharAt2 = charAt(bArr, i6, i3);
            }
            char c2 = (char) (bCharAt2 - 48);
            boolean z6 = z4 | (c2 >= '\n');
            int i13 = 0;
            while (true) {
                if (i13 < 1024) {
                    i13 = (i13 * 10) + c2;
                }
                i6++;
                bCharAt = charAt(bArr, i6, i3);
                char c3 = (char) (bCharAt - 48);
                if (c3 >= '\n') {
                    break;
                }
                c2 = c3;
            }
            if (z5) {
                i13 = -i13;
            }
            i5 += i13;
            int i14 = i13;
            b = bCharAt;
            i7 = i14;
            z4 = z6;
        } else {
            i6 = i10;
            i7 = 0;
        }
        if ((b | 34) == 102) {
            i6++;
        }
        int iSkipWhitespace = skipWhitespace(bArr, i6, i3);
        if (z4 || iSkipWhitespace < i3 || (!z2 && i4 == 0)) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (i4 > 19) {
            int i15 = i;
            int i16 = 0;
            long j5 = 0;
            while (i15 < i10) {
                byte b2 = bArr[i15];
                if (b2 != 46) {
                    j3 = j;
                    if (Long.compareUnsigned(j5, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j5 = ((j5 * j3) + ((long) b2)) - 48;
                } else {
                    i16++;
                    j3 = j;
                }
                i15++;
                j = j3;
            }
            i8 = (i9 - i15) + i16 + i7;
            j2 = j5;
            z3 = i15 < i10;
        } else {
            j2 = j4;
            z3 = false;
            i8 = 0;
        }
        return valueOfFloatLiteral(bArr, i2, i3, z, j2, i5, z3, i8);
    }

    public long parseFloatingPointLiteral(byte[] bArr, int i, int i2) {
        int i3;
        int iCheckBounds = checkBounds(bArr.length, i, i2);
        int iSkipWhitespace = skipWhitespace(bArr, i, iCheckBounds);
        if (iSkipWhitespace == iCheckBounds) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        byte bCharAt = bArr[iSkipWhitespace];
        boolean z = bCharAt == 45;
        if ((z || bCharAt == 43) && (bCharAt = charAt(bArr, (iSkipWhitespace = iSkipWhitespace + 1), iCheckBounds)) == 0) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (bCharAt >= 73) {
            return parseNaNOrInfinity(bArr, iSkipWhitespace, iCheckBounds, z);
        }
        boolean z2 = bCharAt == 48;
        if (z2) {
            int i4 = iSkipWhitespace + 1;
            if ((charAt(bArr, i4, iCheckBounds) | 32) == 120) {
                return parseHexFloatingPointLiteral(bArr, iSkipWhitespace + 2, i, iCheckBounds, z);
            }
            i3 = i4;
        } else {
            i3 = iSkipWhitespace;
        }
        return parseDecFloatLiteral(bArr, i3, i, iCheckBounds, z, z2);
    }

    private long parseHexFloatingPointLiteral(byte[] bArr, int i, int i2, int i3, boolean z) {
        char c;
        int i4;
        int iMin;
        char c2;
        int i5;
        int i6;
        long j;
        int i7;
        boolean z2;
        byte bCharAt;
        int i8 = -1;
        int i9 = i;
        long j2 = 0;
        byte b = 0;
        boolean z3 = false;
        while (true) {
            c = 4;
            if (i9 >= i3) {
                break;
            }
            b = bArr[i9];
            int iLookupHex = lookupHex(b);
            if (iLookupHex < 0) {
                if (iLookupHex != -4) {
                    break;
                }
                z3 |= i8 >= 0;
                i8 = i9;
            } else {
                j2 = (j2 << 4) | ((long) iLookupHex);
            }
            i9++;
        }
        if (i8 < 0) {
            i4 = i9 - i;
            i8 = i9;
            iMin = 0;
        } else {
            i4 = (i9 - i) - 1;
            iMin = Math.min((i8 - i9) + 1, UserMetadata.MAX_ATTRIBUTE_SIZE) * 4;
        }
        boolean z4 = (b | 32) == 112;
        if (z4) {
            i5 = i9 + 1;
            byte bCharAt2 = charAt(bArr, i5, i3);
            boolean z5 = bCharAt2 == 45;
            if (z5 || bCharAt2 == 43) {
                i5 = i9 + 2;
                bCharAt2 = charAt(bArr, i5, i3);
            }
            char c3 = (char) (bCharAt2 - 48);
            boolean z6 = z3 | (c3 >= '\n');
            int i10 = 0;
            while (true) {
                if (i10 < 1024) {
                    i10 = (i10 * 10) + c3;
                }
                i5++;
                bCharAt = charAt(bArr, i5, i3);
                c2 = c;
                char c4 = (char) (bCharAt - 48);
                if (c4 >= '\n') {
                    break;
                }
                c3 = c4;
                c = c2;
            }
            if (z5) {
                i10 = -i10;
            }
            iMin += i10;
            b = bCharAt;
            i6 = i10;
            z3 = z6;
        } else {
            c2 = 4;
            i5 = i9;
            i6 = 0;
        }
        if ((b | 34) == 102) {
            i5++;
        }
        int iSkipWhitespace = skipWhitespace(bArr, i5, i3);
        if (z3 || iSkipWhitespace < i3 || i4 == 0 || !z4) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (i4 > 16) {
            int i11 = i;
            int i12 = 0;
            long j3 = 0;
            while (i11 < i9) {
                int iLookupHex2 = lookupHex(bArr[i11]);
                if (iLookupHex2 < 0) {
                    i12++;
                } else {
                    if (Long.compareUnsigned(j3, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j3 = (j3 << c2) | ((long) iLookupHex2);
                }
                i11++;
            }
            boolean z7 = i11 < i9;
            int i13 = i12;
            iSkipWhitespace = i11;
            i7 = i13;
            j = j3;
            z2 = z7;
        } else {
            j = j2;
            i7 = 0;
            z2 = false;
        }
        return valueOfHexLiteral(bArr, i2, i3, z, j, iMin, z2, (((i8 - iSkipWhitespace) + i7) * 4) + i6);
    }

    private long parseNaNOrInfinity(byte[] bArr, int i, int i2, boolean z) {
        if (bArr[i] == 78) {
            int i3 = i + 2;
            if (i3 < i2 && bArr[i + 1] == 97 && bArr[i3] == 78 && skipWhitespace(bArr, i + 3, i2) == i2) {
                return nan();
            }
        } else if (i + 7 < i2 && FastDoubleSwar.readLongLE(bArr, i) == 8751735898823355977L && skipWhitespace(bArr, i + 8, i2) == i2) {
            return z ? negativeInfinity() : positiveInfinity();
        }
        throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
    }
}
