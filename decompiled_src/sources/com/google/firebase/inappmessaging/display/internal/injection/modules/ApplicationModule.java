package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.display.dagger.Module;
import com.google.firebase.inappmessaging.display.dagger.Provides;
import javax.inject.Singleton;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public Application providesApplication() {
        return this.application;
    }
}
