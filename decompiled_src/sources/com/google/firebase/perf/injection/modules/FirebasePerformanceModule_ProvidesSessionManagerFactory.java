package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.session.SessionManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class FirebasePerformanceModule_ProvidesSessionManagerFactory implements Factory<SessionManager> {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesSessionManagerFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SessionManager m2138get() {
        return providesSessionManager(this.module);
    }

    public static FirebasePerformanceModule_ProvidesSessionManagerFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesSessionManagerFactory(firebasePerformanceModule);
    }

    public static SessionManager providesSessionManager(FirebasePerformanceModule firebasePerformanceModule) {
        return (SessionManager) Preconditions.checkNotNullFromProvides(firebasePerformanceModule.providesSessionManager());
    }
}
