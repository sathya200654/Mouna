package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class TestDeviceHelper_Factory implements Factory<TestDeviceHelper> {
    private final Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider;

    public TestDeviceHelper_Factory(Provider<SharedPreferencesUtils> provider) {
        this.sharedPreferencesUtilsProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public TestDeviceHelper m2048get() {
        return newInstance((SharedPreferencesUtils) this.sharedPreferencesUtilsProvider.get());
    }

    public static TestDeviceHelper_Factory create(Provider<SharedPreferencesUtils> provider) {
        return new TestDeviceHelper_Factory(provider);
    }

    public static TestDeviceHelper newInstance(SharedPreferencesUtils sharedPreferencesUtils) {
        return new TestDeviceHelper(sharedPreferencesUtils);
    }
}
