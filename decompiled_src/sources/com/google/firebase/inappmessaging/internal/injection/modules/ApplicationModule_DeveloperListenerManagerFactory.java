package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ApplicationModule_DeveloperListenerManagerFactory implements Factory<DeveloperListenerManager> {
    private final Provider<Executor> backgroundExecutorProvider;
    private final ApplicationModule module;

    public ApplicationModule_DeveloperListenerManagerFactory(ApplicationModule applicationModule, Provider<Executor> provider) {
        this.module = applicationModule;
        this.backgroundExecutorProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DeveloperListenerManager m2077get() {
        return developerListenerManager(this.module, (Executor) this.backgroundExecutorProvider.get());
    }

    public static ApplicationModule_DeveloperListenerManagerFactory create(ApplicationModule applicationModule, Provider<Executor> provider) {
        return new ApplicationModule_DeveloperListenerManagerFactory(applicationModule, provider);
    }

    public static DeveloperListenerManager developerListenerManager(ApplicationModule applicationModule, Executor executor) {
        return (DeveloperListenerManager) Preconditions.checkNotNullFromProvides(applicationModule.developerListenerManager(executor));
    }
}
