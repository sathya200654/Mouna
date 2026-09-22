package com.google.firebase.encoders;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface Encoder<TValue, TContext> {
    void encode(TValue tvalue, TContext tcontext) throws IOException;
}
