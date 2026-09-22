package com.google.common.io;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@ElementTypesAreNonnullByDefault
public interface LineProcessor<T> {
    @ParametricNullness
    T getResult();

    boolean processLine(String line) throws IOException;
}
