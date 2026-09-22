package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.config.ConfigResolver;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class FirebasePerformanceModule_ProvidesConfigResolverFactory implements Factory<ConfigResolver> {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesConfigResolverFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConfigResolver m2133get() {
        return providesConfigResolver(this.module);
    }

    public static FirebasePerformanceModule_ProvidesConfigResolverFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesConfigResolverFactory(firebasePerformanceModule);
    }

    public static ConfigResolver providesConfigResolver(FirebasePerformanceModule firebasePerformanceModule) {
        return (ConfigResolver) Preconditions.checkNotNullFromProvides(firebasePerformanceModule.providesConfigResolver());
    }
}
