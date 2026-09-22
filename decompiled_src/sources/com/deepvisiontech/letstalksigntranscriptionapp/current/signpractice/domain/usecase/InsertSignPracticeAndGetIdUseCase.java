package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_18_4_1.FastDoubleMath;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InsertSignPracticeAndGetIdUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJL\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0086B¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/InsertSignPracticeAndGetIdUseCase;", "", "signPracticeRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/repository/SignPracticeRepository;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "textToSpeechManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManager;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/repository/SignPracticeRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManager;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "practiceName", "", "topic", "domain", "complexity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeComplexity;", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeType;", "wordCount", "", "language", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeComplexity;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeType;ILcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InsertSignPracticeAndGetIdUseCase {
    private static final long SYNTHESIS_TIMEOUT_MS = 15000;
    private static final String TAG = "InsertSignPracticeUseCase";
    private final AnalyticsManager analyticsManager;
    private final SessionRepository sessionRepository;
    private final SignPracticeRepository signPracticeRepository;
    private final TextToSpeechManager textToSpeechManager;
    public static final int $stable = TextToSpeechManager.$stable | AnalyticsManager.$stable;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.InsertSignPracticeAndGetIdUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: InsertSignPracticeAndGetIdUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.InsertSignPracticeAndGetIdUseCase", f = "InsertSignPracticeAndGetIdUseCase.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {47, 48, 49, FastDoubleMath.DOUBLE_SIGNIFICAND_WIDTH, 76, 126}, m = "invoke", n = {"practiceName", "topic", "domain", "complexity", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "language", "customerId", "wordCount", "practiceName", "topic", "domain", "complexity", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "language", "customerId", "deviceId", "wordCount", "practiceName", "topic", "domain", "complexity", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "language", "customerId", "deviceId", "gmailId", "wordCount", "practiceName", "topic", "domain", "complexity", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "language", "customerId", "deviceId", "gmailId", "token", "wordCount", "practiceName", "topic", "domain", "complexity", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "language", "customerId", "deviceId", "gmailId", "token", "generateResult", "practiceEssay", "content", "utteranceId", "wordCount", "practiceName", "topic", "domain", "complexity", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "language", "customerId", "deviceId", "gmailId", "token", "generateResult", "practiceEssay", "content", "utteranceId", "synthesisResult", "resultUri", "newSignPractice", "wordCount"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InsertSignPracticeAndGetIdUseCase.this.invoke(null, null, null, null, null, 0, null, (Continuation) this);
        }
    }

    @Inject
    public InsertSignPracticeAndGetIdUseCase(SignPracticeRepository signPracticeRepository, SessionRepository sessionRepository, AnalyticsManager analyticsManager, TextToSpeechManager textToSpeechManager) {
        Intrinsics.checkNotNullParameter(signPracticeRepository, "signPracticeRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        Intrinsics.checkNotNullParameter(textToSpeechManager, "textToSpeechManager");
        this.signPracticeRepository = signPracticeRepository;
        this.sessionRepository = sessionRepository;
        this.analyticsManager = analyticsManager;
        this.textToSpeechManager = textToSpeechManager;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:104:0x04ff A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:105:0x0500  */
    /* JADX WARN: Code duplicated, block: B:107:0x0504  */
    /* JADX WARN: Code duplicated, block: B:109:0x0507  */
    /* JADX WARN: Code duplicated, block: B:111:0x050d  */
    /* JADX WARN: Code duplicated, block: B:113:0x0511 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:114:0x0512  */
    /* JADX WARN: Code duplicated, block: B:116:0x0516  */
    /* JADX WARN: Code duplicated, block: B:118:0x0519  */
    /* JADX WARN: Code duplicated, block: B:120:0x051f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0523 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:123:0x0524  */
    /* JADX WARN: Code duplicated, block: B:125:0x052c  */
    /* JADX WARN: Code duplicated, block: B:127:0x0531  */
    /* JADX WARN: Code duplicated, block: B:129:0x0537  */
    /* JADX WARN: Code duplicated, block: B:131:0x053b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:132:0x053c  */
    /* JADX WARN: Code duplicated, block: B:134:0x0544  */
    /* JADX WARN: Code duplicated, block: B:136:0x0549  */
    /* JADX WARN: Code duplicated, block: B:138:0x054f  */
    /* JADX WARN: Code duplicated, block: B:140:0x0553 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:141:0x0554  */
    /* JADX WARN: Code duplicated, block: B:143:0x055c  */
    /* JADX WARN: Code duplicated, block: B:145:0x0561  */
    /* JADX WARN: Code duplicated, block: B:32:0x0224  */
    /* JADX WARN: Code duplicated, block: B:35:0x024b  */
    /* JADX WARN: Code duplicated, block: B:38:0x025c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0287  */
    /* JADX WARN: Code duplicated, block: B:44:0x029a  */
    /* JADX WARN: Code duplicated, block: B:47:0x0303  */
    /* JADX WARN: Code duplicated, block: B:50:0x0315  */
    /* JADX WARN: Code duplicated, block: B:62:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:65:0x03b7 A[Catch: Exception -> 0x03cd, TRY_LEAVE, TryCatch #4 {Exception -> 0x03cd, blocks: (B:63:0x03b3, B:65:0x03b7), top: B:167:0x03b3 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x0429  */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x04ba, code lost:
    
        if (r0 == r2) goto L86;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(java.lang.String r34, java.lang.String r35, java.lang.String r36, com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeComplexity r37, com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeType r38, int r39, com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum r40, kotlin.coroutines.Continuation<? super com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource<java.lang.Long>> r41) {
        /*
            Method dump skipped, instruction units count: 1426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.InsertSignPracticeAndGetIdUseCase.invoke(java.lang.String, java.lang.String, java.lang.String, com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeComplexity, com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeType, int, com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
