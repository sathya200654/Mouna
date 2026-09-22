package com.azure.core.util;

import java.util.Base64;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class Base64Util {
    public static byte[] encode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.getEncoder().encode(bArr);
    }

    public static byte[] encodeURLWithoutPadding(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.getUrlEncoder().withoutPadding().encode(bArr);
    }

    public static String encodeToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(bArr);
    }

    public static byte[] decode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.getDecoder().decode(bArr);
    }

    public static byte[] decodeURL(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.getUrlDecoder().decode(bArr);
    }

    public static byte[] decodeString(String str) {
        if (str == null) {
            return null;
        }
        return Base64.getDecoder().decode(str);
    }

    private Base64Util() {
    }
}
