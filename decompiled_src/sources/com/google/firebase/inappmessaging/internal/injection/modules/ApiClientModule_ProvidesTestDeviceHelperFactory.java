package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ApiClientModule_ProvidesTestDeviceHelperFactory implements Factory<TestDeviceHelper> {
    private final ApiClientModule module;
    private final Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider;

    public ApiClientModule_ProvidesTestDeviceHelperFactory(ApiClientModule apiClientModule, Provider<SharedPreferencesUtils> provider) {
        this.module = apiClientModule;
        this.sharedPreferencesUtilsProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public TestDeviceHelper m2074get() {
        return providesTestDeviceHelper(this.module, (SharedPreferencesUtils) this.sharedPreferencesUtilsProvider.get());
    }

    public static ApiClientModule_ProvidesTestDeviceHelperFactory create(ApiClientModule apiClientModule, Provider<SharedPreferencesUtils> provider) {
        return new ApiClientModule_ProvidesTestDeviceHelperFactory(apiClientModule, provider);
    }

    public static TestDeviceHelper providesTestDeviceHelper(ApiClientModule apiClientModule, SharedPreferencesUtils sharedPreferencesUtils) {
        return (TestDeviceHelper) Preconditions.checkNotNullFromProvides(apiClientModule.providesTestDeviceHelper(sharedPreferencesUtils));
    }
}
