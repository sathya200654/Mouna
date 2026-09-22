package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationRepositoryImpl_Factory implements Factory<ConversationRepositoryImpl> {
    private final Provider<ConversationDao> conversationDaoProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;

    private ConversationRepositoryImpl_Factory(Provider<ConversationDao> conversationDaoProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.conversationDaoProvider = conversationDaoProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationRepositoryImpl m1464get() {
        return newInstance((ConversationDao) this.conversationDaoProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get());
    }

    public static ConversationRepositoryImpl_Factory create(Provider<ConversationDao> conversationDaoProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new ConversationRepositoryImpl_Factory(conversationDaoProvider, ioDispatcherProvider);
    }

    public static ConversationRepositoryImpl newInstance(ConversationDao conversationDao, CoroutineDispatcher ioDispatcher) {
        return new ConversationRepositoryImpl(conversationDao, ioDispatcher);
    }
}
