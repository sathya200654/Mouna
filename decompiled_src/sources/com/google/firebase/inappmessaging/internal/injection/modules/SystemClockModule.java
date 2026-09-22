package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.internal.time.SystemClock;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Module
public class SystemClockModule {
    @Provides
    public Clock providesSystemClockModule() {
        return new SystemClock();
    }
}
