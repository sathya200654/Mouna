package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NotificationModule_ProvideApplicationScopeFactory implements Factory<CoroutineScope> {
    public CoroutineScope get() {
        return provideApplicationScope();
    }

    public static NotificationModule_ProvideApplicationScopeFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CoroutineScope provideApplicationScope() {
        return (CoroutineScope) Preconditions.checkNotNullFromProvides(NotificationModule.INSTANCE.provideApplicationScope());
    }

    private static final class InstanceHolder {
        static final NotificationModule_ProvideApplicationScopeFactory INSTANCE = new NotificationModule_ProvideApplicationScopeFactory();

        private InstanceHolder() {
        }
    }
}
