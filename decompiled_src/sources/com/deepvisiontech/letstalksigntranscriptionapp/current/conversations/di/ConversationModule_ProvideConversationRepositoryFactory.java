package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.di;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationModule_ProvideConversationRepositoryFactory implements Factory<ConversationRepository> {
    private final Provider<Context> contextProvider;
    private final Provider<ConversationDao> conversationDaoProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;

    private ConversationModule_ProvideConversationRepositoryFactory(Provider<ConversationDao> conversationDaoProvider, Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
        this.conversationDaoProvider = conversationDaoProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationRepository m1475get() {
        return provideConversationRepository((ConversationDao) this.conversationDaoProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get(), (Context) this.contextProvider.get());
    }

    public static ConversationModule_ProvideConversationRepositoryFactory create(Provider<ConversationDao> conversationDaoProvider, Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
        return new ConversationModule_ProvideConversationRepositoryFactory(conversationDaoProvider, ioDispatcherProvider, contextProvider);
    }

    public static ConversationRepository provideConversationRepository(ConversationDao conversationDao, CoroutineDispatcher ioDispatcher, Context context) {
        return (ConversationRepository) Preconditions.checkNotNullFromProvides(ConversationModule.INSTANCE.provideConversationRepository(conversationDao, ioDispatcher, context));
    }
}
