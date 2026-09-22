package com.google.firebase.inappmessaging.internal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class SharedPreferencesUtils_Factory implements Factory<SharedPreferencesUtils> {
    private final Provider<FirebaseApp> firebaseAppProvider;

    public SharedPreferencesUtils_Factory(Provider<FirebaseApp> provider) {
        this.firebaseAppProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SharedPreferencesUtils m2047get() {
        return newInstance((FirebaseApp) this.firebaseAppProvider.get());
    }

    public static SharedPreferencesUtils_Factory create(Provider<FirebaseApp> provider) {
        return new SharedPreferencesUtils_Factory(provider);
    }

    public static SharedPreferencesUtils newInstance(FirebaseApp firebaseApp) {
        return new SharedPreferencesUtils(firebaseApp);
    }
}
