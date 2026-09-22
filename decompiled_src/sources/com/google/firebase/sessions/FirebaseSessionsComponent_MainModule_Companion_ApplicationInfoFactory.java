package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory implements Factory<ApplicationInfo> {
    private final Provider<FirebaseApp> firebaseAppProvider;

    public FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory(Provider<FirebaseApp> provider) {
        this.firebaseAppProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ApplicationInfo m2175get() {
        return applicationInfo((FirebaseApp) this.firebaseAppProvider.get());
    }

    public static FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory create(Provider<FirebaseApp> provider) {
        return new FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory(provider);
    }

    public static ApplicationInfo applicationInfo(FirebaseApp firebaseApp) {
        return (ApplicationInfo) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.INSTANCE.applicationInfo(firebaseApp));
    }
}
