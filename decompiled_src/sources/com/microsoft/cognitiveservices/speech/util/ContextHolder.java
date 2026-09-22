package com.microsoft.cognitiveservices.speech.util;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ContextHolder {
    private static volatile ContextHolder instance;
    private Context appContext;

    private ContextHolder() {
    }

    public static synchronized ContextHolder getInstance() {
        if (instance == null) {
            instance = new ContextHolder();
        }
        return instance;
    }

    public Context getContext() {
        return this.appContext;
    }

    public void setContext(Context context) {
        this.appContext = context != null ? context.getApplicationContext() : null;
    }
}
