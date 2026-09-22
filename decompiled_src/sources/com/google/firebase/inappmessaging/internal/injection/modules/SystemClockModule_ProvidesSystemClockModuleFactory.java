package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.time.Clock;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class SystemClockModule_ProvidesSystemClockModuleFactory implements Factory<Clock> {
    private final SystemClockModule module;

    public SystemClockModule_ProvidesSystemClockModuleFactory(SystemClockModule systemClockModule) {
        this.module = systemClockModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Clock m2097get() {
        return providesSystemClockModule(this.module);
    }

    public static SystemClockModule_ProvidesSystemClockModuleFactory create(SystemClockModule systemClockModule) {
        return new SystemClockModule_ProvidesSystemClockModuleFactory(systemClockModule);
    }

    public static Clock providesSystemClockModule(SystemClockModule systemClockModule) {
        return (Clock) Preconditions.checkNotNullFromProvides(systemClockModule.providesSystemClockModule());
    }
}
