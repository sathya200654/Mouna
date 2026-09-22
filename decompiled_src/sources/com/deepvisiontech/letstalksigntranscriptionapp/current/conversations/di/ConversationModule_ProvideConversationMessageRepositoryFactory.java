package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationSummaryApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationModule_ProvideConversationMessageRepositoryFactory implements Factory<ConversationMessageRepository> {
    private final Provider<ConversationMessageDao> conversationMessageDaoProvider;
    private final Provider<ConversationSummaryApi> conversationSummaryApiProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;

    private ConversationModule_ProvideConversationMessageRepositoryFactory(Provider<ConversationMessageDao> conversationMessageDaoProvider, Provider<ConversationSummaryApi> conversationSummaryApiProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.conversationMessageDaoProvider = conversationMessageDaoProvider;
        this.conversationSummaryApiProvider = conversationSummaryApiProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationMessageRepository m1473get() {
        return provideConversationMessageRepository((ConversationMessageDao) this.conversationMessageDaoProvider.get(), (ConversationSummaryApi) this.conversationSummaryApiProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get());
    }

    public static ConversationModule_ProvideConversationMessageRepositoryFactory create(Provider<ConversationMessageDao> conversationMessageDaoProvider, Provider<ConversationSummaryApi> conversationSummaryApiProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new ConversationModule_ProvideConversationMessageRepositoryFactory(conversationMessageDaoProvider, conversationSummaryApiProvider, ioDispatcherProvider);
    }

    public static ConversationMessageRepository provideConversationMessageRepository(ConversationMessageDao conversationMessageDao, ConversationSummaryApi conversationSummaryApi, CoroutineDispatcher ioDispatcher) {
        return (ConversationMessageRepository) Preconditions.checkNotNullFromProvides(ConversationModule.INSTANCE.provideConversationMessageRepository(conversationMessageDao, conversationSummaryApi, ioDispatcher));
    }
}
