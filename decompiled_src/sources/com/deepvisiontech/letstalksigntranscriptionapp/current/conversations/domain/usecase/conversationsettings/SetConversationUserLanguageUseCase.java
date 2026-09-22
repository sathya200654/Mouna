package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SetConversationUserLanguageUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0086B¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetConversationUserLanguageUseCase;", "", "conversationSettingsRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSettingsRepository;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSettingsRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "inputLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SetConversationUserLanguageUseCase {
    public static final int $stable = 8;
    private final AnalyticsManager analyticsManager;
    private final ConversationSettingsRepository conversationSettingsRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetConversationUserLanguageUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: SetConversationUserLanguageUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetConversationUserLanguageUseCase", f = "SetConversationUserLanguageUseCase.kt", i = {0, 1}, l = {16, 17}, m = "invoke", n = {"inputLanguage", "inputLanguage"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SetConversationUserLanguageUseCase.this.invoke(null, (Continuation) this);
        }
    }

    @Inject
    public SetConversationUserLanguageUseCase(ConversationSettingsRepository conversationSettingsRepository, AnalyticsManager analyticsManager) {
        Intrinsics.checkNotNullParameter(conversationSettingsRepository, "conversationSettingsRepository");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        this.conversationSettingsRepository = conversationSettingsRepository;
        this.analyticsManager = analyticsManager;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        if (r7 == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum r6, kotlin.coroutines.Continuation<? super com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource<kotlin.Unit>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetConversationUserLanguageUseCase.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetConversationUserLanguageUseCase$invoke$1 r0 = (com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetConversationUserLanguageUseCase.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetConversationUserLanguageUseCase$invoke$1 r0 = new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetConversationUserLanguageUseCase$invoke$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$0
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L69
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            java.lang.Object r6 = r0.L$0
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L51
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository r7 = r5.conversationSettingsRepository
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.clearSelectedVoice(r0)
            if (r7 != r1) goto L51
            goto L68
        L51:
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r7 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r7
            boolean r2 = r7 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success
            if (r2 == 0) goto La4
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Success r7 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success) r7
            r7.getData()
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository r7 = r5.conversationSettingsRepository
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.setUserLanguage(r6, r0)
            if (r7 != r1) goto L69
        L68:
            return r1
        L69:
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r7 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r7
            boolean r0 = r7 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success
            if (r0 == 0) goto L8c
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Success r7 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success) r7
            r7.getData()
            com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager r5 = r5.analyticsManager
            com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent$GlobalLanguageChanged r7 = new com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent$GlobalLanguageChanged
            java.lang.String r6 = r6.name()
            r7.<init>(r6)
            com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent r7 = (com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent) r7
            r5.logEvent(r7)
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Success r5 = new com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Success
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r5.<init>(r6)
            return r5
        L8c:
            boolean r5 = r7 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
            if (r5 == 0) goto L91
            return r7
        L91:
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Loading r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading.INSTANCE
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r5)
            if (r5 == 0) goto L9e
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Loading r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading.INSTANCE
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r5 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r5
            return r5
        L9e:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        La4:
            boolean r5 = r7 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
            if (r5 == 0) goto La9
            return r7
        La9:
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Loading r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading.INSTANCE
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r5)
            if (r5 == 0) goto Lb6
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Loading r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading.INSTANCE
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r5 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r5
            return r5
        Lb6:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetConversationUserLanguageUseCase.invoke(com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
