package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.di;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationModule_ProvideConversationSettingsRepositoryFactory implements Factory<ConversationSettingsRepository> {
    private final Provider<Context> contextProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;

    private ConversationModule_ProvideConversationSettingsRepositoryFactory(Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
        this.ioDispatcherProvider = ioDispatcherProvider;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationSettingsRepository m1477get() {
        return provideConversationSettingsRepository((CoroutineDispatcher) this.ioDispatcherProvider.get(), (Context) this.contextProvider.get());
    }

    public static ConversationModule_ProvideConversationSettingsRepositoryFactory create(Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
        return new ConversationModule_ProvideConversationSettingsRepositoryFactory(ioDispatcherProvider, contextProvider);
    }

    public static ConversationSettingsRepository provideConversationSettingsRepository(CoroutineDispatcher ioDispatcher, Context context) {
        return (ConversationSettingsRepository) Preconditions.checkNotNullFromProvides(ConversationModule.INSTANCE.provideConversationSettingsRepository(ioDispatcher, context));
    }
}
