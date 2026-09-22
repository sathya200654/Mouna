package com.google.firebase.inappmessaging.display.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class BindingWrapperFactory_Factory implements Factory<BindingWrapperFactory> {
    private final Provider<Application> applicationProvider;

    public BindingWrapperFactory_Factory(Provider<Application> provider) {
        this.applicationProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public BindingWrapperFactory m1962get() {
        return newInstance((Application) this.applicationProvider.get());
    }

    public static BindingWrapperFactory_Factory create(Provider<Application> provider) {
        return new BindingWrapperFactory_Factory(provider);
    }

    public static BindingWrapperFactory newInstance(Application application) {
        return new BindingWrapperFactory(application);
    }
}
