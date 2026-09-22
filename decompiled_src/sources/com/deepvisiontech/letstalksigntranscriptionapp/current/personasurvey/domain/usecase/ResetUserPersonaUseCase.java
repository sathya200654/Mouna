package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResetUserPersonaUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086B¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/usecase/ResetUserPersonaUseCase;", "", "personaSurveyRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/repository/PersonaSurveyRepository;", "engagementRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/repository/PersonaSurveyRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ResetUserPersonaUseCase {
    public static final int $stable = 0;
    private final EngagementRepository engagementRepository;
    private final PersonaSurveyRepository personaSurveyRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase.ResetUserPersonaUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: ResetUserPersonaUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase.ResetUserPersonaUseCase", f = "ResetUserPersonaUseCase.kt", i = {}, l = {13, 14}, m = "invoke", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResetUserPersonaUseCase.this.invoke((Continuation) this);
        }
    }

    @Inject
    public ResetUserPersonaUseCase(PersonaSurveyRepository personaSurveyRepository, EngagementRepository engagementRepository) {
        Intrinsics.checkNotNullParameter(personaSurveyRepository, "personaSurveyRepository");
        Intrinsics.checkNotNullParameter(engagementRepository, "engagementRepository");
        this.personaSurveyRepository = personaSurveyRepository;
        this.engagementRepository = engagementRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
    
        if (r5.setOnboardingShownState(false, r0) == r1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(kotlin.coroutines.Continuation<? super com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource<kotlin.Unit>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase.ResetUserPersonaUseCase.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase.ResetUserPersonaUseCase$invoke$1 r0 = (com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase.ResetUserPersonaUseCase.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase.ResetUserPersonaUseCase$invoke$1 r0 = new com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase.ResetUserPersonaUseCase$invoke$1
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
            goto L53
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L47
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository r6 = r5.personaSurveyRepository
            r0.label = r4
            java.lang.Object r6 = r6.resetUserPersonaData(r0)
            if (r6 != r1) goto L47
            goto L52
        L47:
            com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository r5 = r5.engagementRepository
            r0.label = r3
            r6 = 0
            java.lang.Object r5 = r5.setOnboardingShownState(r6, r0)
            if (r5 != r1) goto L53
        L52:
            return r1
        L53:
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Success r5 = new com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Success
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r5.<init>(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase.ResetUserPersonaUseCase.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
