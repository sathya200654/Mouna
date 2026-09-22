package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.installations.FirebaseInstallationsApi;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ApiClientModule_ProvidesFirebaseInstallationsFactory implements Factory<FirebaseInstallationsApi> {
    private final ApiClientModule module;

    public ApiClientModule_ProvidesFirebaseInstallationsFactory(ApiClientModule apiClientModule) {
        this.module = apiClientModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public FirebaseInstallationsApi m2072get() {
        return providesFirebaseInstallations(this.module);
    }

    public static ApiClientModule_ProvidesFirebaseInstallationsFactory create(ApiClientModule apiClientModule) {
        return new ApiClientModule_ProvidesFirebaseInstallationsFactory(apiClientModule);
    }

    public static FirebaseInstallationsApi providesFirebaseInstallations(ApiClientModule apiClientModule) {
        return (FirebaseInstallationsApi) Preconditions.checkNotNullFromProvides(apiClientModule.providesFirebaseInstallations());
    }
}
