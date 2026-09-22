package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory implements Factory<UuidGenerator> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public UuidGenerator m2179get() {
        return uuidGenerator();
    }

    public static FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static UuidGenerator uuidGenerator() {
        return (UuidGenerator) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.INSTANCE.uuidGenerator());
    }

    private static final class InstanceHolder {
        private static final FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory INSTANCE = new FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory();

        private InstanceHolder() {
        }
    }
}
