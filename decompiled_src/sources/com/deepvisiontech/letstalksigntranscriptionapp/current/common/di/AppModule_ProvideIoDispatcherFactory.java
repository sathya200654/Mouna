package com.deepvisiontech.letstalksigntranscriptionapp.current.common.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AppModule_ProvideIoDispatcherFactory implements Factory<CoroutineDispatcher> {
    public CoroutineDispatcher get() {
        return provideIoDispatcher();
    }

    public static AppModule_ProvideIoDispatcherFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CoroutineDispatcher provideIoDispatcher() {
        return (CoroutineDispatcher) Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideIoDispatcher());
    }

    private static final class InstanceHolder {
        static final AppModule_ProvideIoDispatcherFactory INSTANCE = new AppModule_ProvideIoDispatcherFactory();

        private InstanceHolder() {
        }
    }
}
