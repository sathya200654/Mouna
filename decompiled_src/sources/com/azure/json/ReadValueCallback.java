package com.azure.json;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@FunctionalInterface
public interface ReadValueCallback<T, R> {
    R read(T t) throws IOException;
}
