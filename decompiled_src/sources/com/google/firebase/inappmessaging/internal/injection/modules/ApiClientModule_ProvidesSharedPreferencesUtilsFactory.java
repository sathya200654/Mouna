package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ApiClientModule_ProvidesSharedPreferencesUtilsFactory implements Factory<SharedPreferencesUtils> {
    private final ApiClientModule module;

    public ApiClientModule_ProvidesSharedPreferencesUtilsFactory(ApiClientModule apiClientModule) {
        this.module = apiClientModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SharedPreferencesUtils m2073get() {
        return providesSharedPreferencesUtils(this.module);
    }

    public static ApiClientModule_ProvidesSharedPreferencesUtilsFactory create(ApiClientModule apiClientModule) {
        return new ApiClientModule_ProvidesSharedPreferencesUtilsFactory(apiClientModule);
    }

    public static SharedPreferencesUtils providesSharedPreferencesUtils(ApiClientModule apiClientModule) {
        return (SharedPreferencesUtils) Preconditions.checkNotNullFromProvides(apiClientModule.providesSharedPreferencesUtils());
    }
}
