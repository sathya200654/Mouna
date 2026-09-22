package com.deepvisiontech.letstalksigntranscriptionapp.current;

import android.app.Application;
import dagger.hilt.android.internal.managers.ApplicationComponentManager;
import dagger.hilt.android.internal.managers.ComponentSupplier;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class Hilt_MyApp extends Application implements GeneratedComponentManagerHolder {
    private boolean injected = false;
    private final ApplicationComponentManager componentManager = new ApplicationComponentManager(new ComponentSupplier() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.Hilt_MyApp.1
        @Override // dagger.hilt.android.internal.managers.ComponentSupplier
        public Object get() {
            return DaggerMyApp_HiltComponents_SingletonC.builder().applicationContextModule(new ApplicationContextModule(Hilt_MyApp.this)).build();
        }
    });

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    public final ApplicationComponentManager componentManager() {
        return this.componentManager;
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    @Override // android.app.Application
    public void onCreate() {
        hiltInternalInject();
        super.onCreate();
    }

    protected void hiltInternalInject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((MyApp_GeneratedInjector) generatedComponent()).injectMyApp((MyApp) UnsafeCasts.unsafeCast(this));
    }
}
