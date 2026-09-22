package com.azure.core.util;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class Base64Url {
    private final byte[] bytes;

    public Base64Url(String str) {
        if (str == null) {
            this.bytes = null;
        } else {
            this.bytes = unquote(str).getBytes(StandardCharsets.UTF_8);
        }
    }

    public Base64Url(byte[] bArr) {
        this.bytes = unquote(bArr);
    }

    private static byte[] unquote(byte[] bArr) {
        if (bArr == null || bArr.length <= 1) {
            return bArr;
        }
        byte b = bArr[0];
        return ((b == 34 || b == 39) && bArr[bArr.length - 1] == b) ? Arrays.copyOfRange(bArr, 1, bArr.length - 1) : bArr;
    }

    private static String unquote(String str) {
        if (CoreUtils.isNullOrEmpty(str)) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt != '\"' && cCharAt != '\'') {
            return str;
        }
        int length = str.length() - 1;
        return str.charAt(length) == cCharAt ? str.substring(1, length) : str;
    }

    public static Base64Url encode(byte[] bArr) {
        if (bArr == null) {
            return new Base64Url((String) null);
        }
        return new Base64Url(Base64Util.encodeURLWithoutPadding(bArr));
    }

    public byte[] encodedBytes() {
        return CoreUtils.clone(this.bytes);
    }

    public byte[] decodedBytes() {
        byte[] bArr = this.bytes;
        if (bArr == null) {
            return null;
        }
        return Base64Util.decodeURL(bArr);
    }

    public String toString() {
        return this.bytes == null ? "" : new String(this.bytes, StandardCharsets.UTF_8);
    }

    public int hashCode() {
        return Arrays.hashCode(this.bytes);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Base64Url) {
            return Arrays.equals(this.bytes, ((Base64Url) obj).encodedBytes());
        }
        return false;
    }
}
