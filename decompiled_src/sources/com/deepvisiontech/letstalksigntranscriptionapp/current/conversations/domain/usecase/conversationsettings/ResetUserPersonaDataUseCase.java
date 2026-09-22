package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResetUserPersonaDataUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0086B¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/ResetUserPersonaDataUseCase;", "", "personaSurveyRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/repository/PersonaSurveyRepository;", "engagementRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/repository/PersonaSurveyRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ResetUserPersonaDataUseCase {
    public static final int $stable = 8;
    private final AnalyticsManager analyticsManager;
    private final EngagementRepository engagementRepository;
    private final PersonaSurveyRepository personaSurveyRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.ResetUserPersonaDataUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: ResetUserPersonaDataUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.ResetUserPersonaDataUseCase", f = "ResetUserPersonaDataUseCase.kt", i = {}, l = {18, 19}, m = "invoke", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResetUserPersonaDataUseCase.this.invoke((Continuation) this);
        }
    }

    @Inject
    public ResetUserPersonaDataUseCase(PersonaSurveyRepository personaSurveyRepository, EngagementRepository engagementRepository, AnalyticsManager analyticsManager) {
        Intrinsics.checkNotNullParameter(personaSurveyRepository, "personaSurveyRepository");
        Intrinsics.checkNotNullParameter(engagementRepository, "engagementRepository");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        this.personaSurveyRepository = personaSurveyRepository;
        this.engagementRepository = engagementRepository;
        this.analyticsManager = analyticsManager;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0064, code lost:
    
        if (r6 == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(kotlin.coroutines.Continuation<? super com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource<kotlin.Unit>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.ResetUserPersonaDataUseCase.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.ResetUserPersonaDataUseCase$invoke$1 r0 = (com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.ResetUserPersonaDataUseCase.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.ResetUserPersonaDataUseCase$invoke$1 r0 = new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.ResetUserPersonaDataUseCase$invoke$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L67
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L50
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager r6 = r5.analyticsManager
            com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent$PersonaChangeClicked r2 = com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent.PersonaChangeClicked.INSTANCE
            com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent r2 = (com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent) r2
            r6.logEvent(r2)
            com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository r6 = r5.personaSurveyRepository
            r0.label = r4
            java.lang.Object r6 = r6.resetUserPersonaData(r0)
            if (r6 != r1) goto L50
            goto L66
        L50:
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r6
            boolean r2 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success
            if (r2 == 0) goto L92
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Success r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success) r6
            r6.getData()
            com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository r5 = r5.engagementRepository
            r0.label = r3
            r6 = 0
            java.lang.Object r6 = r5.setOnboardingShownState(r6, r0)
            if (r6 != r1) goto L67
        L66:
            return r1
        L67:
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r6
            boolean r5 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success
            if (r5 == 0) goto L7a
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Success r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success) r6
            r6.getData()
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Success r5 = new com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Success
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r5.<init>(r6)
            return r5
        L7a:
            boolean r5 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
            if (r5 == 0) goto L7f
            return r6
        L7f:
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Loading r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading.INSTANCE
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r5)
            if (r5 == 0) goto L8c
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Loading r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading.INSTANCE
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r5 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r5
            return r5
        L8c:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L92:
            boolean r5 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
            if (r5 == 0) goto L97
            return r6
        L97:
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Loading r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading.INSTANCE
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r5)
            if (r5 == 0) goto La4
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Loading r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading.INSTANCE
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r5 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r5
            return r5
        La4:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.ResetUserPersonaDataUseCase.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
