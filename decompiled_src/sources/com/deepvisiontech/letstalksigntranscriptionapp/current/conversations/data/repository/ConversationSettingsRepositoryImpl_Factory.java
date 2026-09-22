package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationSettingsRepositoryImpl_Factory implements Factory<ConversationSettingsRepositoryImpl> {
    private final Provider<Context> contextProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;

    private ConversationSettingsRepositoryImpl_Factory(Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
        this.ioDispatcherProvider = ioDispatcherProvider;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationSettingsRepositoryImpl m1466get() {
        return newInstance((CoroutineDispatcher) this.ioDispatcherProvider.get(), (Context) this.contextProvider.get());
    }

    public static ConversationSettingsRepositoryImpl_Factory create(Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
        return new ConversationSettingsRepositoryImpl_Factory(ioDispatcherProvider, contextProvider);
    }

    public static ConversationSettingsRepositoryImpl newInstance(CoroutineDispatcher ioDispatcher, Context context) {
        return new ConversationSettingsRepositoryImpl(ioDispatcher, context);
    }
}
