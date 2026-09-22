package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository;
import com.google.protobuf.DescriptorProtos;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FetchCorrectionSuggestionUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ*\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086B¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/FetchCorrectionSuggestionUseCase;", "", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "conversationSuggestionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/conversationsuggestion/ConversationSuggestionRepository;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/conversationsuggestion/ConversationSuggestionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;", "inputLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "sentence", "", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FetchCorrectionSuggestionUseCase {
    private static final String TAG = "FetchCorrectionSuggestionUseCase";
    private final AnalyticsManager analyticsManager;
    private final ConversationSuggestionRepository conversationSuggestionRepository;
    private final SessionRepository sessionRepository;
    public static final int $stable = AnalyticsManager.$stable;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.FetchCorrectionSuggestionUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: FetchCorrectionSuggestionUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.FetchCorrectionSuggestionUseCase", f = "FetchCorrectionSuggestionUseCase.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER, 28, 29, DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER}, m = "invoke", n = {"inputLanguage", "sentence", "customerId", "inputLanguage", "sentence", "customerId", "deviceId", "inputLanguage", "sentence", "customerId", "deviceId", "gmailId", "inputLanguage", "sentence", "customerId", "deviceId", "gmailId", "token"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FetchCorrectionSuggestionUseCase.this.invoke(null, null, (Continuation) this);
        }
    }

    @Inject
    public FetchCorrectionSuggestionUseCase(SessionRepository sessionRepository, ConversationSuggestionRepository conversationSuggestionRepository, AnalyticsManager analyticsManager) {
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(conversationSuggestionRepository, "conversationSuggestionRepository");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        this.sessionRepository = sessionRepository;
        this.conversationSuggestionRepository = conversationSuggestionRepository;
        this.analyticsManager = analyticsManager;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0107  */
    /* JADX WARN: Code duplicated, block: B:41:0x0124  */
    /* JADX WARN: Code duplicated, block: B:44:0x0130  */
    /* JADX WARN: Code duplicated, block: B:49:0x0175  */
    /* JADX WARN: Code duplicated, block: B:51:0x0179 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x017a  */
    /* JADX WARN: Code duplicated, block: B:54:0x0182  */
    /* JADX WARN: Code duplicated, block: B:56:0x0187  */
    /* JADX WARN: Code duplicated, block: B:58:0x018d  */
    /* JADX WARN: Code duplicated, block: B:60:0x0191 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:61:0x0192  */
    /* JADX WARN: Code duplicated, block: B:63:0x019a  */
    /* JADX WARN: Code duplicated, block: B:65:0x019f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0166, code lost:
    
        if (r13 == r0) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum r11, java.lang.String r12, kotlin.coroutines.Continuation<? super com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource<? extends java.util.List<com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.CorrectionSuggestion>>> r13) {
        /*
            Method dump skipped, instruction units count: 469
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.FetchCorrectionSuggestionUseCase.invoke(com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
