package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import com.bumptech.glide.RequestManager;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class GlideModule_ProvidesGlideRequestManagerFactory implements Factory<RequestManager> {
    private final Provider<Application> applicationProvider;
    private final GlideModule module;

    public GlideModule_ProvidesGlideRequestManagerFactory(GlideModule glideModule, Provider<Application> provider) {
        this.module = glideModule;
        this.applicationProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public RequestManager m1976get() {
        return providesGlideRequestManager(this.module, (Application) this.applicationProvider.get());
    }

    public static GlideModule_ProvidesGlideRequestManagerFactory create(GlideModule glideModule, Provider<Application> provider) {
        return new GlideModule_ProvidesGlideRequestManagerFactory(glideModule, provider);
    }

    public static RequestManager providesGlideRequestManager(GlideModule glideModule, Application application) {
        return (RequestManager) Preconditions.checkNotNullFromProvides(glideModule.providesGlideRequestManager(application));
    }
}
