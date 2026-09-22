package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ApplicationModule_ProvidesApplicationFactory implements Factory<Application> {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesApplicationFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Application m1975get() {
        return providesApplication(this.module);
    }

    public static ApplicationModule_ProvidesApplicationFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesApplicationFactory(applicationModule);
    }

    public static Application providesApplication(ApplicationModule applicationModule) {
        return (Application) Preconditions.checkNotNullFromProvides(applicationModule.providesApplication());
    }
}
