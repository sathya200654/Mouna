package com.azure.json.implementation;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class JsonUtils {
    public static Number parseNumber(String str) {
        int length = str.length();
        if (length == 3 && "NaN".equals(str)) {
            return Double.valueOf(Double.NaN);
        }
        if (length == 8 && "Infinity".equals(str)) {
            return Double.valueOf(Double.POSITIVE_INFINITY);
        }
        if (length == 9) {
            if ("+Infinity".equals(str)) {
                return Double.valueOf(Double.POSITIVE_INFINITY);
            }
            if ("-Infinity".equals(str)) {
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            }
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '.' || cCharAt == 'e' || cCharAt == 'E') {
                return handleFloatingPoint(str);
            }
        }
        return handleInteger(str);
    }

    private static Number handleFloatingPoint(String str) {
        double d = Double.parseDouble(str);
        if (!Double.isInfinite(d)) {
            return Double.valueOf(d);
        }
        return new BigDecimal(str);
    }

    private static Number handleInteger(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException e2) {
                e2.addSuppressed(e);
                try {
                    return new BigInteger(str);
                } catch (NumberFormatException e3) {
                    e3.addSuppressed(e2);
                    throw e3;
                }
            }
        }
    }
}
