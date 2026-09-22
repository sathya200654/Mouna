package com.azure.json;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@FunctionalInterface
public interface WriteValueCallback<T, U> {
    void write(T t, U u) throws IOException;
}
