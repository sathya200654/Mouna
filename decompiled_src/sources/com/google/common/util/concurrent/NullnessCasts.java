package com.google.common.util.concurrent;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@ElementTypesAreNonnullByDefault
final class NullnessCasts {
    @ParametricNullness
    static <T> T uncheckedCastNullableTToT(@CheckForNull T t) {
        return t;
    }

    @ParametricNullness
    static <T> T uncheckedNull() {
        return null;
    }

    private NullnessCasts() {
    }
}
