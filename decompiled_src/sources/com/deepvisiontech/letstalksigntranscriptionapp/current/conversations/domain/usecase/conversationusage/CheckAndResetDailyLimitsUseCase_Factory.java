package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationusage;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class CheckAndResetDailyLimitsUseCase_Factory implements Factory<CheckAndResetDailyLimitsUseCase> {
    private final Provider<ConversationUsageRepository> conversationUsageRepositoryProvider;

    private CheckAndResetDailyLimitsUseCase_Factory(Provider<ConversationUsageRepository> conversationUsageRepositoryProvider) {
        this.conversationUsageRepositoryProvider = conversationUsageRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public CheckAndResetDailyLimitsUseCase m1520get() {
        return newInstance((ConversationUsageRepository) this.conversationUsageRepositoryProvider.get());
    }

    public static CheckAndResetDailyLimitsUseCase_Factory create(Provider<ConversationUsageRepository> conversationUsageRepositoryProvider) {
        return new CheckAndResetDailyLimitsUseCase_Factory(conversationUsageRepositoryProvider);
    }

    public static CheckAndResetDailyLimitsUseCase newInstance(ConversationUsageRepository conversationUsageRepository) {
        return new CheckAndResetDailyLimitsUseCase(conversationUsageRepository);
    }
}
