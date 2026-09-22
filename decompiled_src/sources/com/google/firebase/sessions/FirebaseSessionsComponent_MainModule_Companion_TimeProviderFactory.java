package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory implements Factory<TimeProvider> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public TimeProvider m2178get() {
        return timeProvider();
    }

    public static FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TimeProvider timeProvider() {
        return (TimeProvider) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.INSTANCE.timeProvider());
    }

    private static final class InstanceHolder {
        private static final FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory INSTANCE = new FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory();

        private InstanceHolder() {
        }
    }
}
