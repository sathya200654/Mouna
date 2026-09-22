package com.google.firebase.inappmessaging.internal.time;

import javax.inject.Inject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class SystemClock implements Clock {
    @Inject
    public SystemClock() {
    }

    @Override // com.google.firebase.inappmessaging.internal.time.Clock
    public long now() {
        return System.currentTimeMillis();
    }
}
