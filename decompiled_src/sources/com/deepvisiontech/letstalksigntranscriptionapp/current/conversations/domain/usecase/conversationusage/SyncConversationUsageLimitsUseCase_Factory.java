package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationusage;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SyncConversationUsageLimitsUseCase_Factory implements Factory<SyncConversationUsageLimitsUseCase> {
    private final Provider<ConversationUsageRepository> conversationUsageRepositoryProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;

    private SyncConversationUsageLimitsUseCase_Factory(Provider<ConversationUsageRepository> conversationUsageRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider) {
        this.conversationUsageRepositoryProvider = conversationUsageRepositoryProvider;
        this.sessionRepositoryProvider = sessionRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SyncConversationUsageLimitsUseCase m1521get() {
        return newInstance((ConversationUsageRepository) this.conversationUsageRepositoryProvider.get(), (SessionRepository) this.sessionRepositoryProvider.get());
    }

    public static SyncConversationUsageLimitsUseCase_Factory create(Provider<ConversationUsageRepository> conversationUsageRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider) {
        return new SyncConversationUsageLimitsUseCase_Factory(conversationUsageRepositoryProvider, sessionRepositoryProvider);
    }

    public static SyncConversationUsageLimitsUseCase newInstance(ConversationUsageRepository conversationUsageRepository, SessionRepository sessionRepository) {
        return new SyncConversationUsageLimitsUseCase(conversationUsageRepository, sessionRepository);
    }
}
