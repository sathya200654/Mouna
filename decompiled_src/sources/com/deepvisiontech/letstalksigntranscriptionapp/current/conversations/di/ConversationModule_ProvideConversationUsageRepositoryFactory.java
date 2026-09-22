package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.di;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationUsageApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationModule_ProvideConversationUsageRepositoryFactory implements Factory<ConversationUsageRepository> {
    private final Provider<Context> contextProvider;
    private final Provider<ConversationUsageApi> conversationUsageApiProvider;

    private ConversationModule_ProvideConversationUsageRepositoryFactory(Provider<Context> contextProvider, Provider<ConversationUsageApi> conversationUsageApiProvider) {
        this.contextProvider = contextProvider;
        this.conversationUsageApiProvider = conversationUsageApiProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationUsageRepository m1482get() {
        return provideConversationUsageRepository((Context) this.contextProvider.get(), (ConversationUsageApi) this.conversationUsageApiProvider.get());
    }

    public static ConversationModule_ProvideConversationUsageRepositoryFactory create(Provider<Context> contextProvider, Provider<ConversationUsageApi> conversationUsageApiProvider) {
        return new ConversationModule_ProvideConversationUsageRepositoryFactory(contextProvider, conversationUsageApiProvider);
    }

    public static ConversationUsageRepository provideConversationUsageRepository(Context context, ConversationUsageApi conversationUsageApi) {
        return (ConversationUsageRepository) Preconditions.checkNotNullFromProvides(ConversationModule.INSTANCE.provideConversationUsageRepository(context, conversationUsageApi));
    }
}
