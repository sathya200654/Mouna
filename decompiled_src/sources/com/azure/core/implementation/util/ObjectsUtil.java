package com.azure.core.implementation.util;

import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ObjectsUtil {
    private ObjectsUtil() {
    }

    public static <T> T requireNonNullElse(T t, T t2) {
        return t != null ? t : (T) Objects.requireNonNull(t2, "defaultObj");
    }
}
