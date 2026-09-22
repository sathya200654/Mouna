package com.azure.core.implementation.http.rest;

import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import java.util.Arrays;
import java.util.function.IntConsumer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class PercentEscaper {
    private static final char[] HEX_CHARACTERS = "0123456789ABCDEF".toCharArray();
    private static final ClientLogger LOGGER;
    private static final boolean[] SAFE_CHARACTERS;
    private final boolean[] safeCharacterPoints;
    private final boolean usePlusForSpace;

    static {
        boolean[] zArr = new boolean[256];
        SAFE_CHARACTERS = zArr;
        Arrays.fill(zArr, 97, 123, true);
        Arrays.fill(zArr, 65, 91, true);
        Arrays.fill(zArr, 48, 58, true);
        LOGGER = new ClientLogger((Class<?>) PercentEscaper.class);
    }

    public PercentEscaper(String str, boolean z) {
        this.usePlusForSpace = z;
        if (z && str != null && str.contains(" ")) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("' ' as a safe character with 'usePlusForSpace = true' is an invalid configuration."));
        }
        this.safeCharacterPoints = Arrays.copyOf(SAFE_CHARACTERS, 256);
        if (CoreUtils.isNullOrEmpty(str)) {
            return;
        }
        str.codePoints().forEach(new IntConsumer() { // from class: com.azure.core.implementation.http.rest.PercentEscaper$$ExternalSyntheticLambda0
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.m1190xd820a78c(i);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$0$com-azure-core-implementation-http-rest-PercentEscaper, reason: not valid java name */
    /* synthetic */ void m1190xd820a78c(int i) {
        this.safeCharacterPoints[i] = true;
    }

    public String escape(String str) {
        if (!CoreUtils.isNullOrEmpty(str)) {
            int length = str.length();
            int i = 12;
            char[] cArr = new char[12];
            StringBuilder sb = null;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int codePoint = getCodePoint(str, i2, length);
                if (codePoint >= 256 || !this.safeCharacterPoints[codePoint]) {
                    int i4 = (Character.isSupplementaryCodePoint(codePoint) ? 2 : 1) + i2;
                    if (sb == null) {
                        sb = new StringBuilder((int) Math.ceil(((double) str.length()) * 1.5d));
                    }
                    sb.append((CharSequence) str, i3, i2);
                    if (this.usePlusForSpace && codePoint == 32) {
                        sb.append('+');
                    } else if (codePoint <= 127) {
                        sb.append('%');
                        char[] cArr2 = HEX_CHARACTERS;
                        sb.append(cArr2[codePoint >>> 4]);
                        sb.append(cArr2[codePoint & 15]);
                    } else if (codePoint <= 2047) {
                        cArr[0] = '%';
                        cArr[3] = '%';
                        char[] cArr3 = HEX_CHARACTERS;
                        cArr[5] = cArr3[codePoint & 15];
                        cArr[4] = cArr3[((codePoint >>> 4) & 3) | 8];
                        cArr[2] = cArr3[(codePoint >>> 6) & 15];
                        cArr[1] = cArr3[(codePoint >>> 10) | i];
                        sb.append(cArr, 0, 6);
                    } else if (codePoint <= 65535) {
                        cArr[0] = '%';
                        cArr[1] = 'E';
                        cArr[3] = '%';
                        cArr[6] = '%';
                        char[] cArr4 = HEX_CHARACTERS;
                        cArr[8] = cArr4[codePoint & 15];
                        cArr[7] = cArr4[((codePoint >>> 4) & 3) | 8];
                        cArr[5] = cArr4[(codePoint >>> 6) & 15];
                        cArr[4] = cArr4[((codePoint >>> 10) & 3) | 8];
                        cArr[2] = cArr4[(codePoint >>> 12) & 15];
                        sb.append(cArr, 0, 9);
                    } else if (codePoint <= 1114111) {
                        cArr[0] = '%';
                        cArr[1] = 'F';
                        cArr[3] = '%';
                        cArr[6] = '%';
                        cArr[9] = '%';
                        char[] cArr5 = HEX_CHARACTERS;
                        cArr[11] = cArr5[codePoint & 15];
                        cArr[10] = cArr5[((codePoint >>> 4) & 3) | 8];
                        cArr[8] = cArr5[(codePoint >>> 6) & 15];
                        cArr[7] = cArr5[((codePoint >>> 10) & 3) | 8];
                        cArr[5] = cArr5[(codePoint >>> 12) & 15];
                        cArr[4] = cArr5[((codePoint >>> 16) & 3) | 8];
                        cArr[2] = cArr5[(codePoint >>> 18) & 7];
                        sb.append(cArr);
                    }
                    i2 = i4;
                    i3 = i2;
                    i = 12;
                } else {
                    i2++;
                }
            }
            if (sb != null) {
                if (i3 < length) {
                    sb.append((CharSequence) str, i3, length);
                }
                return sb.toString();
            }
        }
        return str;
    }

    private static int getCodePoint(String str, int i, int i2) {
        int i3 = i + 1;
        char cCharAt = str.charAt(i);
        if (!Character.isSurrogate(cCharAt)) {
            return cCharAt;
        }
        if (!Character.isHighSurrogate(cCharAt)) {
            throw LOGGER.logExceptionAsError(new IllegalStateException("String contains low surrogate without leading high surrogate."));
        }
        if (i3 == i2) {
            throw LOGGER.logExceptionAsError(new IllegalStateException("String contains trailing high surrogate without paired low surrogate."));
        }
        char cCharAt2 = str.charAt(i3);
        if (Character.isLowSurrogate(cCharAt2)) {
            return Character.toCodePoint(cCharAt, cCharAt2);
        }
        throw LOGGER.logExceptionAsError(new IllegalStateException("String contains high surrogate without trailing low surrogate."));
    }
}
