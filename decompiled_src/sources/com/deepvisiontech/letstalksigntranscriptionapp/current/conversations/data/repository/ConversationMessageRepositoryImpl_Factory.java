package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationSummaryApi;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationMessageRepositoryImpl_Factory implements Factory<ConversationMessageRepositoryImpl> {
    private final Provider<ConversationMessageDao> conversationMessageDaoProvider;
    private final Provider<ConversationSummaryApi> conversationSummaryApiProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;

    private ConversationMessageRepositoryImpl_Factory(Provider<ConversationMessageDao> conversationMessageDaoProvider, Provider<ConversationSummaryApi> conversationSummaryApiProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.conversationMessageDaoProvider = conversationMessageDaoProvider;
        this.conversationSummaryApiProvider = conversationSummaryApiProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationMessageRepositoryImpl m1463get() {
        return newInstance((ConversationMessageDao) this.conversationMessageDaoProvider.get(), (ConversationSummaryApi) this.conversationSummaryApiProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get());
    }

    public static ConversationMessageRepositoryImpl_Factory create(Provider<ConversationMessageDao> conversationMessageDaoProvider, Provider<ConversationSummaryApi> conversationSummaryApiProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new ConversationMessageRepositoryImpl_Factory(conversationMessageDaoProvider, conversationSummaryApiProvider, ioDispatcherProvider);
    }

    public static ConversationMessageRepositoryImpl newInstance(ConversationMessageDao conversationMessageDao, ConversationSummaryApi conversationSummaryApi, CoroutineDispatcher ioDispatcher) {
        return new ConversationMessageRepositoryImpl(conversationMessageDao, conversationSummaryApi, ioDispatcher);
    }
}
