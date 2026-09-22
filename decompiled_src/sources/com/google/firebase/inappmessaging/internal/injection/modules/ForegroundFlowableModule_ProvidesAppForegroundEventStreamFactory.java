package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory implements Factory<ConnectableFlowable<String>> {
    private final Provider<Application> applicationProvider;
    private final ForegroundFlowableModule module;

    public ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory(ForegroundFlowableModule foregroundFlowableModule, Provider<Application> provider) {
        this.module = foregroundFlowableModule;
        this.applicationProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConnectableFlowable<String> m2082get() {
        return providesAppForegroundEventStream(this.module, (Application) this.applicationProvider.get());
    }

    public static ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory create(ForegroundFlowableModule foregroundFlowableModule, Provider<Application> provider) {
        return new ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory(foregroundFlowableModule, provider);
    }

    public static ConnectableFlowable<String> providesAppForegroundEventStream(ForegroundFlowableModule foregroundFlowableModule, Application application) {
        return (ConnectableFlowable) Preconditions.checkNotNullFromProvides(foregroundFlowableModule.providesAppForegroundEventStream(application));
    }
}
