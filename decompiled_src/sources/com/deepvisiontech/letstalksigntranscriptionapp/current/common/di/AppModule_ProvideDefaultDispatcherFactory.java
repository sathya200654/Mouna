package com.deepvisiontech.letstalksigntranscriptionapp.current.common.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AppModule_ProvideDefaultDispatcherFactory implements Factory<CoroutineDispatcher> {
    public CoroutineDispatcher get() {
        return provideDefaultDispatcher();
    }

    public static AppModule_ProvideDefaultDispatcherFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CoroutineDispatcher provideDefaultDispatcher() {
        return (CoroutineDispatcher) Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideDefaultDispatcher());
    }

    private static final class InstanceHolder {
        static final AppModule_ProvideDefaultDispatcherFactory INSTANCE = new AppModule_ProvideDefaultDispatcherFactory();

        private InstanceHolder() {
        }
    }
}
