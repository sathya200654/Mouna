package com.azure.json.implementation.jackson.core;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class JacksonException extends IOException {
    private static final long serialVersionUID = 123;

    public abstract JsonLocation getLocation();

    public abstract Object getProcessor();

    protected JacksonException(String str) {
        super(str);
    }

    protected JacksonException(String str, Throwable th) {
        super(str, th);
    }
}
