package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationusage;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckAndResetDailyLimitsUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086B¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationusage/CheckAndResetDailyLimitsUseCase;", "", "conversationUsageRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationUsageRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationUsageRepository;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CheckAndResetDailyLimitsUseCase {
    public static final int $stable = 8;
    private final ConversationUsageRepository conversationUsageRepository;

    @Inject
    public CheckAndResetDailyLimitsUseCase(ConversationUsageRepository conversationUsageRepository) {
        Intrinsics.checkNotNullParameter(conversationUsageRepository, "conversationUsageRepository");
        this.conversationUsageRepository = conversationUsageRepository;
    }

    public final Object invoke(Continuation<? super ResponseResource<Unit>> continuation) {
        return this.conversationUsageRepository.checkAndResetDailyUsageIfNeeded(continuation);
    }
}
