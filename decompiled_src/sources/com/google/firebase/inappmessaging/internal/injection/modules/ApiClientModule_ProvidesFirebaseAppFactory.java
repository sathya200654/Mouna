package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ApiClientModule_ProvidesFirebaseAppFactory implements Factory<FirebaseApp> {
    private final ApiClientModule module;

    public ApiClientModule_ProvidesFirebaseAppFactory(ApiClientModule apiClientModule) {
        this.module = apiClientModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public FirebaseApp m2071get() {
        return providesFirebaseApp(this.module);
    }

    public static ApiClientModule_ProvidesFirebaseAppFactory create(ApiClientModule apiClientModule) {
        return new ApiClientModule_ProvidesFirebaseAppFactory(apiClientModule);
    }

    public static FirebaseApp providesFirebaseApp(ApiClientModule apiClientModule) {
        return (FirebaseApp) Preconditions.checkNotNullFromProvides(apiClientModule.providesFirebaseApp());
    }
}
