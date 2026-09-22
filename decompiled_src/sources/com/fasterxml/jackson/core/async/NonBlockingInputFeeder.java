package com.fasterxml.jackson.core.async;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface NonBlockingInputFeeder {
    void endOfInput();

    boolean needMoreInput();
}
