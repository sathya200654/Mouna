package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ToggleConversationSpeakerDetectionUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086B¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/ToggleConversationSpeakerDetectionUseCase;", "", "conversationSettingsRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSettingsRepository;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSettingsRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ToggleConversationSpeakerDetectionUseCase {
    public static final int $stable = 8;
    private final AnalyticsManager analyticsManager;
    private final ConversationSettingsRepository conversationSettingsRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.ToggleConversationSpeakerDetectionUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: ToggleConversationSpeakerDetectionUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.ToggleConversationSpeakerDetectionUseCase", f = "ToggleConversationSpeakerDetectionUseCase.kt", i = {1}, l = {17, 19}, m = "invoke", n = {"currentMode"}, s = {"Z$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ToggleConversationSpeakerDetectionUseCase.this.invoke((Continuation) this);
        }
    }

    @Inject
    public ToggleConversationSpeakerDetectionUseCase(ConversationSettingsRepository conversationSettingsRepository, AnalyticsManager analyticsManager) {
        Intrinsics.checkNotNullParameter(conversationSettingsRepository, "conversationSettingsRepository");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        this.conversationSettingsRepository = conversationSettingsRepository;
        this.analyticsManager = analyticsManager;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(Continuation<? super ResponseResource<Unit>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objFirst = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFirst);
            Flow<Boolean> flowIsSpeakerDetectionEnabled = this.conversationSettingsRepository.isSpeakerDetectionEnabled();
            anonymousClass1.label = 1;
            objFirst = FlowKt.first(flowIsSpeakerDetectionEnabled, anonymousClass1);
            if (objFirst != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z = anonymousClass1.Z$0;
            ResultKt.throwOnFailure(objFirst);
            return objFirst;
        }
        ResultKt.throwOnFailure(objFirst);
        boolean zBooleanValue = ((Boolean) objFirst).booleanValue();
        this.analyticsManager.logEvent(new AnalyticsEvent.SpeakerDetection(String.valueOf(!zBooleanValue)));
        ConversationSettingsRepository conversationSettingsRepository = this.conversationSettingsRepository;
        anonymousClass1.Z$0 = zBooleanValue;
        anonymousClass1.label = 2;
        Object obj = conversationSettingsRepository.toggleSpeakerDetection(anonymousClass1);
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }
}
