package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.di;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSessionRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationModule_ProvideConversationSessionRepositoryFactory implements Factory<ConversationSessionRepository> {
    private final Provider<Context> contextProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;

    private ConversationModule_ProvideConversationSessionRepositoryFactory(Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
        this.ioDispatcherProvider = ioDispatcherProvider;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationSessionRepository m1476get() {
        return provideConversationSessionRepository((CoroutineDispatcher) this.ioDispatcherProvider.get(), (Context) this.contextProvider.get());
    }

    public static ConversationModule_ProvideConversationSessionRepositoryFactory create(Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
        return new ConversationModule_ProvideConversationSessionRepositoryFactory(ioDispatcherProvider, contextProvider);
    }

    public static ConversationSessionRepository provideConversationSessionRepository(CoroutineDispatcher ioDispatcher, Context context) {
        return (ConversationSessionRepository) Preconditions.checkNotNullFromProvides(ConversationModule.INSTANCE.provideConversationSessionRepository(ioDispatcher, context));
    }
}
