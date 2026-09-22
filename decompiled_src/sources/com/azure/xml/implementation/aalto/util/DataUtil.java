package com.azure.xml.implementation.aalto.util;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class DataUtil {
    private DataUtil() {
    }

    public static int[] growArrayBy(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        int[] iArr2 = new int[i + length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    public static char[] growArrayBy(char[] cArr, int i) {
        if (cArr == null) {
            return new char[i];
        }
        int length = cArr.length;
        char[] cArr2 = new char[i + length];
        System.arraycopy(cArr, 0, cArr2, 0, length);
        return cArr2;
    }

    public static Object growAnyArrayBy(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("Null array");
        }
        int length = Array.getLength(obj);
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), i + length);
        System.arraycopy(obj, 0, objNewInstance, 0, length);
        return objNewInstance;
    }
}
