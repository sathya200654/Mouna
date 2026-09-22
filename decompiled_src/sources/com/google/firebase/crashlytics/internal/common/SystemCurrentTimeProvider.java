package com.google.firebase.crashlytics.internal.common;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class SystemCurrentTimeProvider implements CurrentTimeProvider {
    @Override // com.google.firebase.crashlytics.internal.common.CurrentTimeProvider
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
