package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationSessionRepositoryImpl_Factory implements Factory<ConversationSessionRepositoryImpl> {
    private final Provider<Context> contextProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;

    private ConversationSessionRepositoryImpl_Factory(Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
        this.ioDispatcherProvider = ioDispatcherProvider;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationSessionRepositoryImpl m1465get() {
        return newInstance((CoroutineDispatcher) this.ioDispatcherProvider.get(), (Context) this.contextProvider.get());
    }

    public static ConversationSessionRepositoryImpl_Factory create(Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
        return new ConversationSessionRepositoryImpl_Factory(ioDispatcherProvider, contextProvider);
    }

    public static ConversationSessionRepositoryImpl newInstance(CoroutineDispatcher ioDispatcher, Context context) {
        return new ConversationSessionRepositoryImpl(ioDispatcher, context);
    }
}
