package com.google.firebase.perf.injection.modules;

import com.google.firebase.inject.Provider;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory implements Factory<Provider<RemoteConfigComponent>> {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Provider<RemoteConfigComponent> m2136get() {
        return providesRemoteConfigComponent(this.module);
    }

    public static FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory(firebasePerformanceModule);
    }

    public static Provider<RemoteConfigComponent> providesRemoteConfigComponent(FirebasePerformanceModule firebasePerformanceModule) {
        return (Provider) Preconditions.checkNotNullFromProvides(firebasePerformanceModule.providesRemoteConfigComponent());
    }
}
