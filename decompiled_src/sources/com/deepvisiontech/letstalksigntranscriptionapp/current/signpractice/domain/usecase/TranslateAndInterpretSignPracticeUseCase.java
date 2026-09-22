package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.LtsTranslationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import com.google.protobuf.DescriptorProtos;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TranslateAndInterpretSignPracticeUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086B¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/TranslateAndInterpretSignPracticeUseCase;", "", "webViewManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "ltsTranslationRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/LtsTranslationRepository;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/LtsTranslationRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "signPractice", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "splitEssayInToSentences", "", "", "essay", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TranslateAndInterpretSignPracticeUseCase {
    private static final String TAG = "TranslateAndInterpretSignPracticeUseCase";
    private final AnalyticsManager analyticsManager;
    private final LtsTranslationRepository ltsTranslationRepository;
    private final SessionRepository sessionRepository;
    private final WebViewManager webViewManager;
    public static final int $stable = AnalyticsManager.$stable;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.TranslateAndInterpretSignPracticeUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: TranslateAndInterpretSignPracticeUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.TranslateAndInterpretSignPracticeUseCase", f = "TranslateAndInterpretSignPracticeUseCase.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER, 40, DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER, 43}, m = "invoke", n = {"signPractice", "content", "inputLang", "customerId", "signPractice", "content", "inputLang", "customerId", "deviceId", "signPractice", "content", "inputLang", "customerId", "deviceId", "gmailId", "signPractice", "content", "inputLang", "customerId", "deviceId", "gmailId", "token"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TranslateAndInterpretSignPracticeUseCase.this.invoke(null, (Continuation) this);
        }
    }

    @Inject
    public TranslateAndInterpretSignPracticeUseCase(WebViewManager webViewManager, SessionRepository sessionRepository, LtsTranslationRepository ltsTranslationRepository, AnalyticsManager analyticsManager) {
        Intrinsics.checkNotNullParameter(webViewManager, "webViewManager");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(ltsTranslationRepository, "ltsTranslationRepository");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        this.webViewManager = webViewManager;
        this.sessionRepository = sessionRepository;
        this.ltsTranslationRepository = ltsTranslationRepository;
        this.analyticsManager = analyticsManager;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:47:0x0154 A[Catch: Exception -> 0x0289, TryCatch #0 {Exception -> 0x0289, blocks: (B:15:0x0050, B:56:0x01cb, B:58:0x01d1, B:60:0x01f1, B:62:0x01f5, B:64:0x021a, B:66:0x021e, B:68:0x0223, B:69:0x0228, B:20:0x0075, B:51:0x0181, B:53:0x0187, B:70:0x0229, B:73:0x022e, B:75:0x0236, B:77:0x023b, B:78:0x0240, B:23:0x0097, B:45:0x014e, B:47:0x0154, B:79:0x0241, B:82:0x0246, B:84:0x024e, B:86:0x0253, B:87:0x0258, B:26:0x00b0, B:39:0x0121, B:41:0x0127, B:88:0x0259, B:91:0x025e, B:93:0x0266, B:95:0x026b, B:96:0x0270, B:29:0x00ba, B:31:0x00d5, B:33:0x00eb, B:35:0x00fe, B:97:0x0271, B:100:0x0276, B:102:0x027e, B:104:0x0283, B:105:0x0288), top: B:109:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0176  */
    /* JADX WARN: Code duplicated, block: B:50:0x0177  */
    /* JADX WARN: Code duplicated, block: B:53:0x0187 A[Catch: Exception -> 0x0289, TryCatch #0 {Exception -> 0x0289, blocks: (B:15:0x0050, B:56:0x01cb, B:58:0x01d1, B:60:0x01f1, B:62:0x01f5, B:64:0x021a, B:66:0x021e, B:68:0x0223, B:69:0x0228, B:20:0x0075, B:51:0x0181, B:53:0x0187, B:70:0x0229, B:73:0x022e, B:75:0x0236, B:77:0x023b, B:78:0x0240, B:23:0x0097, B:45:0x014e, B:47:0x0154, B:79:0x0241, B:82:0x0246, B:84:0x024e, B:86:0x0253, B:87:0x0258, B:26:0x00b0, B:39:0x0121, B:41:0x0127, B:88:0x0259, B:91:0x025e, B:93:0x0266, B:95:0x026b, B:96:0x0270, B:29:0x00ba, B:31:0x00d5, B:33:0x00eb, B:35:0x00fe, B:97:0x0271, B:100:0x0276, B:102:0x027e, B:104:0x0283, B:105:0x0288), top: B:109:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0229 A[Catch: Exception -> 0x0289, TryCatch #0 {Exception -> 0x0289, blocks: (B:15:0x0050, B:56:0x01cb, B:58:0x01d1, B:60:0x01f1, B:62:0x01f5, B:64:0x021a, B:66:0x021e, B:68:0x0223, B:69:0x0228, B:20:0x0075, B:51:0x0181, B:53:0x0187, B:70:0x0229, B:73:0x022e, B:75:0x0236, B:77:0x023b, B:78:0x0240, B:23:0x0097, B:45:0x014e, B:47:0x0154, B:79:0x0241, B:82:0x0246, B:84:0x024e, B:86:0x0253, B:87:0x0258, B:26:0x00b0, B:39:0x0121, B:41:0x0127, B:88:0x0259, B:91:0x025e, B:93:0x0266, B:95:0x026b, B:96:0x0270, B:29:0x00ba, B:31:0x00d5, B:33:0x00eb, B:35:0x00fe, B:97:0x0271, B:100:0x0276, B:102:0x027e, B:104:0x0283, B:105:0x0288), top: B:109:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:72:0x022d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x022e A[Catch: Exception -> 0x0289, TryCatch #0 {Exception -> 0x0289, blocks: (B:15:0x0050, B:56:0x01cb, B:58:0x01d1, B:60:0x01f1, B:62:0x01f5, B:64:0x021a, B:66:0x021e, B:68:0x0223, B:69:0x0228, B:20:0x0075, B:51:0x0181, B:53:0x0187, B:70:0x0229, B:73:0x022e, B:75:0x0236, B:77:0x023b, B:78:0x0240, B:23:0x0097, B:45:0x014e, B:47:0x0154, B:79:0x0241, B:82:0x0246, B:84:0x024e, B:86:0x0253, B:87:0x0258, B:26:0x00b0, B:39:0x0121, B:41:0x0127, B:88:0x0259, B:91:0x025e, B:93:0x0266, B:95:0x026b, B:96:0x0270, B:29:0x00ba, B:31:0x00d5, B:33:0x00eb, B:35:0x00fe, B:97:0x0271, B:100:0x0276, B:102:0x027e, B:104:0x0283, B:105:0x0288), top: B:109:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0236 A[Catch: Exception -> 0x0289, TryCatch #0 {Exception -> 0x0289, blocks: (B:15:0x0050, B:56:0x01cb, B:58:0x01d1, B:60:0x01f1, B:62:0x01f5, B:64:0x021a, B:66:0x021e, B:68:0x0223, B:69:0x0228, B:20:0x0075, B:51:0x0181, B:53:0x0187, B:70:0x0229, B:73:0x022e, B:75:0x0236, B:77:0x023b, B:78:0x0240, B:23:0x0097, B:45:0x014e, B:47:0x0154, B:79:0x0241, B:82:0x0246, B:84:0x024e, B:86:0x0253, B:87:0x0258, B:26:0x00b0, B:39:0x0121, B:41:0x0127, B:88:0x0259, B:91:0x025e, B:93:0x0266, B:95:0x026b, B:96:0x0270, B:29:0x00ba, B:31:0x00d5, B:33:0x00eb, B:35:0x00fe, B:97:0x0271, B:100:0x0276, B:102:0x027e, B:104:0x0283, B:105:0x0288), top: B:109:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:77:0x023b A[Catch: Exception -> 0x0289, TryCatch #0 {Exception -> 0x0289, blocks: (B:15:0x0050, B:56:0x01cb, B:58:0x01d1, B:60:0x01f1, B:62:0x01f5, B:64:0x021a, B:66:0x021e, B:68:0x0223, B:69:0x0228, B:20:0x0075, B:51:0x0181, B:53:0x0187, B:70:0x0229, B:73:0x022e, B:75:0x0236, B:77:0x023b, B:78:0x0240, B:23:0x0097, B:45:0x014e, B:47:0x0154, B:79:0x0241, B:82:0x0246, B:84:0x024e, B:86:0x0253, B:87:0x0258, B:26:0x00b0, B:39:0x0121, B:41:0x0127, B:88:0x0259, B:91:0x025e, B:93:0x0266, B:95:0x026b, B:96:0x0270, B:29:0x00ba, B:31:0x00d5, B:33:0x00eb, B:35:0x00fe, B:97:0x0271, B:100:0x0276, B:102:0x027e, B:104:0x0283, B:105:0x0288), top: B:109:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0241 A[Catch: Exception -> 0x0289, TryCatch #0 {Exception -> 0x0289, blocks: (B:15:0x0050, B:56:0x01cb, B:58:0x01d1, B:60:0x01f1, B:62:0x01f5, B:64:0x021a, B:66:0x021e, B:68:0x0223, B:69:0x0228, B:20:0x0075, B:51:0x0181, B:53:0x0187, B:70:0x0229, B:73:0x022e, B:75:0x0236, B:77:0x023b, B:78:0x0240, B:23:0x0097, B:45:0x014e, B:47:0x0154, B:79:0x0241, B:82:0x0246, B:84:0x024e, B:86:0x0253, B:87:0x0258, B:26:0x00b0, B:39:0x0121, B:41:0x0127, B:88:0x0259, B:91:0x025e, B:93:0x0266, B:95:0x026b, B:96:0x0270, B:29:0x00ba, B:31:0x00d5, B:33:0x00eb, B:35:0x00fe, B:97:0x0271, B:100:0x0276, B:102:0x027e, B:104:0x0283, B:105:0x0288), top: B:109:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code duplicated, block: B:81:0x0245 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x0246 A[Catch: Exception -> 0x0289, TryCatch #0 {Exception -> 0x0289, blocks: (B:15:0x0050, B:56:0x01cb, B:58:0x01d1, B:60:0x01f1, B:62:0x01f5, B:64:0x021a, B:66:0x021e, B:68:0x0223, B:69:0x0228, B:20:0x0075, B:51:0x0181, B:53:0x0187, B:70:0x0229, B:73:0x022e, B:75:0x0236, B:77:0x023b, B:78:0x0240, B:23:0x0097, B:45:0x014e, B:47:0x0154, B:79:0x0241, B:82:0x0246, B:84:0x024e, B:86:0x0253, B:87:0x0258, B:26:0x00b0, B:39:0x0121, B:41:0x0127, B:88:0x0259, B:91:0x025e, B:93:0x0266, B:95:0x026b, B:96:0x0270, B:29:0x00ba, B:31:0x00d5, B:33:0x00eb, B:35:0x00fe, B:97:0x0271, B:100:0x0276, B:102:0x027e, B:104:0x0283, B:105:0x0288), top: B:109:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:84:0x024e A[Catch: Exception -> 0x0289, TryCatch #0 {Exception -> 0x0289, blocks: (B:15:0x0050, B:56:0x01cb, B:58:0x01d1, B:60:0x01f1, B:62:0x01f5, B:64:0x021a, B:66:0x021e, B:68:0x0223, B:69:0x0228, B:20:0x0075, B:51:0x0181, B:53:0x0187, B:70:0x0229, B:73:0x022e, B:75:0x0236, B:77:0x023b, B:78:0x0240, B:23:0x0097, B:45:0x014e, B:47:0x0154, B:79:0x0241, B:82:0x0246, B:84:0x024e, B:86:0x0253, B:87:0x0258, B:26:0x00b0, B:39:0x0121, B:41:0x0127, B:88:0x0259, B:91:0x025e, B:93:0x0266, B:95:0x026b, B:96:0x0270, B:29:0x00ba, B:31:0x00d5, B:33:0x00eb, B:35:0x00fe, B:97:0x0271, B:100:0x0276, B:102:0x027e, B:104:0x0283, B:105:0x0288), top: B:109:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0253 A[Catch: Exception -> 0x0289, TryCatch #0 {Exception -> 0x0289, blocks: (B:15:0x0050, B:56:0x01cb, B:58:0x01d1, B:60:0x01f1, B:62:0x01f5, B:64:0x021a, B:66:0x021e, B:68:0x0223, B:69:0x0228, B:20:0x0075, B:51:0x0181, B:53:0x0187, B:70:0x0229, B:73:0x022e, B:75:0x0236, B:77:0x023b, B:78:0x0240, B:23:0x0097, B:45:0x014e, B:47:0x0154, B:79:0x0241, B:82:0x0246, B:84:0x024e, B:86:0x0253, B:87:0x0258, B:26:0x00b0, B:39:0x0121, B:41:0x0127, B:88:0x0259, B:91:0x025e, B:93:0x0266, B:95:0x026b, B:96:0x0270, B:29:0x00ba, B:31:0x00d5, B:33:0x00eb, B:35:0x00fe, B:97:0x0271, B:100:0x0276, B:102:0x027e, B:104:0x0283, B:105:0x0288), top: B:109:0x002a }] */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01c8, code lost:
    
        if (r15 == r1) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice r14, kotlin.coroutines.Continuation<? super com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource<kotlin.Unit>> r15) throws kotlin.NoWhenBranchMatchedException {
        /*
            Method dump skipped, instruction units count: 687
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.TranslateAndInterpretSignPracticeUseCase.invoke(com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final List<String> splitEssayInToSentences(String essay) {
        return StringsKt.split$default(essay, new String[]{"."}, false, 0, 6, (Object) null);
    }
}
