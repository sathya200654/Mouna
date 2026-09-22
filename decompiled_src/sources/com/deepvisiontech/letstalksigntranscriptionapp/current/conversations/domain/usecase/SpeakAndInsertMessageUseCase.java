package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import android.speech.tts.Voice;
import android.util.Log;
import androidx.wear.compose.foundation.SwipeToRevealKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.mappers.LanguageMapper;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.LtsTranslationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.utils.LangaugeUtilsKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.MessageInputType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.MessageType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManager;
import com.google.protobuf.DescriptorProtos;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: SpeakAndInsertMessageUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ>\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0086B¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/SpeakAndInsertMessageUseCase;", "", "conversationMessageRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationMessageRepository;", "conversationUsageRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationUsageRepository;", "textToSpeechManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManager;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "ltsTranslationRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/LtsTranslationRepository;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationMessageRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationUsageRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/LtsTranslationRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "inputText", "", "conversationId", "", "speakerLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "userLanguage", "voice", "Landroid/speech/tts/Voice;", "(Ljava/lang/String;JLcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Landroid/speech/tts/Voice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SpeakAndInsertMessageUseCase {
    private static final String TAG = "SpeakAndInsertMessageUseCase";
    private final AnalyticsManager analyticsManager;
    private final ConversationMessageRepository conversationMessageRepository;
    private final ConversationUsageRepository conversationUsageRepository;
    private final LtsTranslationRepository ltsTranslationRepository;
    private final SessionRepository sessionRepository;
    private final TextToSpeechManager textToSpeechManager;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = AnalyticsManager.$stable | TextToSpeechManager.$stable;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.SpeakAndInsertMessageUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: SpeakAndInsertMessageUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.SpeakAndInsertMessageUseCase", f = "SpeakAndInsertMessageUseCase.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {40, DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER, SwipeToRevealKt.SHORT_ANIMATION, 51, 52, 61, 95, 96}, m = "invoke", n = {"inputText", "speakerLanguage", "userLanguage", "voice", "conversationId", "inputText", "speakerLanguage", "userLanguage", "voice", "conversationId", "limit", "inputText", "speakerLanguage", "userLanguage", "voice", "customerId", "conversationId", "limit", "current", "inputText", "speakerLanguage", "userLanguage", "voice", "customerId", "deviceId", "conversationId", "limit", "current", "inputText", "speakerLanguage", "userLanguage", "voice", "customerId", "deviceId", "gmailId", "conversationId", "limit", "current", "inputText", "speakerLanguage", "userLanguage", "voice", "customerId", "deviceId", "gmailId", "token", "textToSpeak", "conversationId", "limit", "current", "inputText", "speakerLanguage", "userLanguage", "voice", "customerId", "deviceId", "gmailId", "token", "textToSpeak", "conversationMessage", "conversationId", "limit", "current", "inputText", "speakerLanguage", "userLanguage", "voice", "customerId", "deviceId", "gmailId", "token", "textToSpeak", "conversationMessage", "conversationId", "limit", "current"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "J$0", "I$0", "I$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
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
            return SpeakAndInsertMessageUseCase.this.invoke(null, 0L, null, null, null, (Continuation) this);
        }
    }

    @Inject
    public SpeakAndInsertMessageUseCase(ConversationMessageRepository conversationMessageRepository, ConversationUsageRepository conversationUsageRepository, TextToSpeechManager textToSpeechManager, AnalyticsManager analyticsManager, LtsTranslationRepository ltsTranslationRepository, SessionRepository sessionRepository) {
        Intrinsics.checkNotNullParameter(conversationMessageRepository, "conversationMessageRepository");
        Intrinsics.checkNotNullParameter(conversationUsageRepository, "conversationUsageRepository");
        Intrinsics.checkNotNullParameter(textToSpeechManager, "textToSpeechManager");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        Intrinsics.checkNotNullParameter(ltsTranslationRepository, "ltsTranslationRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        this.conversationMessageRepository = conversationMessageRepository;
        this.conversationUsageRepository = conversationUsageRepository;
        this.textToSpeechManager = textToSpeechManager;
        this.analyticsManager = analyticsManager;
        this.ltsTranslationRepository = ltsTranslationRepository;
        this.sessionRepository = sessionRepository;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x047d A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x0481 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:105:0x0482 A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x048a A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x048f A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0495 A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0499 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:114:0x049a A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x04a2 A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x04a7 A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x04ad A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x04b1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:123:0x04b2 A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x04ba A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x04bf A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x04c5 A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x04c9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:132:0x04ca A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x04d2 A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x04d7 A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:45:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:48:0x020b A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0215 A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x021f A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0242  */
    /* JADX WARN: Code duplicated, block: B:55:0x0244  */
    /* JADX WARN: Code duplicated, block: B:58:0x0253 A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0278  */
    /* JADX WARN: Code duplicated, block: B:61:0x027a  */
    /* JADX WARN: Code duplicated, block: B:64:0x028a A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:67:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:70:0x02c8 A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x02d7 A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x02e1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x02e3 A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x031f  */
    /* JADX WARN: Code duplicated, block: B:78:0x0321  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x033d A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0356 A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x035a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:85:0x035b A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0363 A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0368 A[Catch: Exception -> 0x04dd, TryCatch #0 {Exception -> 0x04dd, blocks: (B:13:0x005f, B:100:0x0461, B:16:0x0096, B:96:0x0417, B:19:0x00d1, B:79:0x0335, B:81:0x033d, B:92:0x037e, B:82:0x0356, B:85:0x035b, B:87:0x0363, B:89:0x0368, B:90:0x036d, B:22:0x0100, B:68:0x02c2, B:70:0x02c8, B:72:0x02d7, B:75:0x02e3, B:102:0x047d, B:105:0x0482, B:107:0x048a, B:109:0x048f, B:110:0x0494, B:26:0x0130, B:62:0x0284, B:64:0x028a, B:111:0x0495, B:114:0x049a, B:116:0x04a2, B:118:0x04a7, B:119:0x04ac, B:29:0x015a, B:56:0x024d, B:58:0x0253, B:120:0x04ad, B:123:0x04b2, B:125:0x04ba, B:127:0x04bf, B:128:0x04c4, B:32:0x017d, B:46:0x0203, B:48:0x020b, B:50:0x0215, B:52:0x021f, B:129:0x04c5, B:132:0x04ca, B:134:0x04d2, B:136:0x04d7, B:137:0x04dc, B:35:0x019c, B:42:0x01d7, B:38:0x01ad), top: B:141:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x036e  */
    /* JADX WARN: Code duplicated, block: B:94:0x040c  */
    /* JADX WARN: Code duplicated, block: B:95:0x040d  */
    /* JADX WARN: Code duplicated, block: B:99:0x0460  */
    public final Object invoke(String str, long j, LanguageEnum languageEnum, LanguageEnum languageEnum2, Voice voice, Continuation<? super ResponseResource<Unit>> continuation) {
        AnonymousClass1 anonymousClass1;
        String str2;
        LanguageEnum languageEnum3;
        LanguageEnum languageEnum4;
        long j2;
        Object obj;
        Voice voice2;
        int iIntValue;
        Object objFirst;
        String str3;
        Voice voice3;
        Object obj2;
        LanguageEnum languageEnum5;
        long j3;
        LanguageEnum languageEnum6;
        int iIntValue2;
        ResponseResource<String> customerId;
        String str4;
        Object deviceId;
        int i;
        Object obj3;
        String str5;
        LanguageEnum languageEnum7;
        Voice voice4;
        long j4;
        ResponseResource responseResource;
        String str6;
        Object gmailId;
        String str7;
        Object obj4;
        String str8;
        LanguageEnum languageEnum8;
        LanguageEnum languageEnum9;
        Voice voice5;
        String str9;
        ResponseResource responseResource2;
        String str10;
        Object token;
        String str11;
        Object obj5;
        long j5;
        String str12;
        LanguageEnum languageEnum10;
        LanguageEnum languageEnum11;
        int i2;
        Voice voice6;
        String str13;
        int i3;
        String str14;
        ResponseResource responseResource3;
        String str15;
        String str16;
        String str17;
        String str18;
        LanguageEnum languageEnum12;
        LanguageEnum languageEnum13;
        int i4;
        long j6;
        String str19;
        String str20;
        String str21;
        Voice voice7;
        Object objTranslateBhashini;
        String str22;
        String str23;
        Voice voice8;
        Object obj6;
        int i5;
        LanguageEnum languageEnum14;
        String str24;
        long j7;
        String str25;
        LanguageEnum languageEnum15;
        ConversationMessage conversationMessage;
        long j8;
        LanguageEnum languageEnum16;
        String str26;
        ConversationMessageRepository conversationMessageRepository;
        String str27;
        String str28;
        ConversationMessage conversationMessage2;
        String str29;
        Voice voice9;
        LanguageEnum languageEnum17;
        String str30;
        String str31;
        ResponseResource responseResource4;
        int i6;
        ConversationUsageRepository conversationUsageRepository;
        String str32;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj7 = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (anonymousClass2.label) {
                case 0:
                    ResultKt.throwOnFailure(obj7);
                    Flow<Integer> allowedTtsLimit = this.conversationUsageRepository.getAllowedTtsLimit();
                    str2 = str;
                    anonymousClass2.L$0 = str2;
                    languageEnum3 = languageEnum;
                    anonymousClass2.L$1 = languageEnum3;
                    languageEnum4 = languageEnum2;
                    anonymousClass2.L$2 = languageEnum4;
                    anonymousClass2.L$3 = voice;
                    j2 = j;
                    anonymousClass2.J$0 = j2;
                    anonymousClass2.label = 1;
                    Object objFirst2 = FlowKt.first(allowedTtsLimit, anonymousClass2);
                    if (objFirst2 != coroutine_suspended) {
                        obj = objFirst2;
                        voice2 = voice;
                        iIntValue = ((Number) obj).intValue();
                        Flow<Integer> currentTts = this.conversationUsageRepository.getCurrentTts();
                        anonymousClass2.L$0 = str2;
                        anonymousClass2.L$1 = languageEnum3;
                        anonymousClass2.L$2 = languageEnum4;
                        anonymousClass2.L$3 = voice2;
                        anonymousClass2.J$0 = j2;
                        anonymousClass2.I$0 = iIntValue;
                        anonymousClass2.label = 2;
                        objFirst = FlowKt.first(currentTts, anonymousClass2);
                        if (objFirst == coroutine_suspended) {
                            str3 = str2;
                            LanguageEnum languageEnum18 = languageEnum4;
                            voice3 = voice2;
                            obj2 = objFirst;
                            languageEnum5 = languageEnum3;
                            j3 = j2;
                            languageEnum6 = languageEnum18;
                            iIntValue2 = ((Number) obj2).intValue();
                            if (iIntValue2 >= iIntValue) {
                                return new ResponseResource.Error(AppError.QuotaExceeded.INSTANCE);
                            }
                            customerId = this.sessionRepository.getCustomerId();
                            if (!(customerId instanceof ResponseResource.Success)) {
                                if (customerId instanceof ResponseResource.Error) {
                                    return customerId;
                                }
                                if (Intrinsics.areEqual(customerId, ResponseResource.Loading.INSTANCE)) {
                                    return ResponseResource.Loading.INSTANCE;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            str4 = (String) ((ResponseResource.Success) customerId).getData();
                            SessionRepository sessionRepository = this.sessionRepository;
                            anonymousClass2.L$0 = str3;
                            anonymousClass2.L$1 = languageEnum5;
                            anonymousClass2.L$2 = languageEnum6;
                            anonymousClass2.L$3 = voice3;
                            anonymousClass2.L$4 = str4;
                            anonymousClass2.J$0 = j3;
                            anonymousClass2.I$0 = iIntValue;
                            anonymousClass2.I$1 = iIntValue2;
                            anonymousClass2.label = 3;
                            deviceId = sessionRepository.getDeviceId(anonymousClass2);
                            if (deviceId != coroutine_suspended) {
                                long j9 = j3;
                                i = iIntValue2;
                                obj3 = deviceId;
                                str5 = str3;
                                languageEnum7 = languageEnum5;
                                voice4 = voice3;
                                j4 = j9;
                                responseResource = (ResponseResource) obj3;
                                if (responseResource instanceof ResponseResource.Success) {
                                    if (responseResource instanceof ResponseResource.Error) {
                                        return responseResource;
                                    }
                                    if (Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
                                        return ResponseResource.Loading.INSTANCE;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                                str6 = (String) ((ResponseResource.Success) responseResource).getData();
                                SessionRepository sessionRepository2 = this.sessionRepository;
                                anonymousClass2.L$0 = str5;
                                anonymousClass2.L$1 = languageEnum7;
                                anonymousClass2.L$2 = languageEnum6;
                                anonymousClass2.L$3 = voice4;
                                anonymousClass2.L$4 = str4;
                                anonymousClass2.L$5 = str6;
                                anonymousClass2.J$0 = j4;
                                anonymousClass2.I$0 = iIntValue;
                                anonymousClass2.I$1 = i;
                                anonymousClass2.label = 4;
                                gmailId = sessionRepository2.getGmailId(anonymousClass2);
                                if (gmailId == coroutine_suspended) {
                                    String str33 = str4;
                                    str7 = str6;
                                    obj4 = gmailId;
                                    str8 = str5;
                                    languageEnum8 = languageEnum7;
                                    languageEnum9 = languageEnum6;
                                    voice5 = voice4;
                                    str9 = str33;
                                    responseResource2 = (ResponseResource) obj4;
                                    if (!(responseResource2 instanceof ResponseResource.Success)) {
                                        if (responseResource2 instanceof ResponseResource.Error) {
                                            return responseResource2;
                                        }
                                        if (Intrinsics.areEqual(responseResource2, ResponseResource.Loading.INSTANCE)) {
                                            return ResponseResource.Loading.INSTANCE;
                                        }
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    str10 = (String) ((ResponseResource.Success) responseResource2).getData();
                                    SessionRepository sessionRepository3 = this.sessionRepository;
                                    anonymousClass2.L$0 = str8;
                                    anonymousClass2.L$1 = languageEnum8;
                                    anonymousClass2.L$2 = languageEnum9;
                                    anonymousClass2.L$3 = voice5;
                                    anonymousClass2.L$4 = str9;
                                    anonymousClass2.L$5 = str7;
                                    anonymousClass2.L$6 = str10;
                                    anonymousClass2.J$0 = j4;
                                    anonymousClass2.I$0 = iIntValue;
                                    anonymousClass2.I$1 = i;
                                    anonymousClass2.label = 5;
                                    token = sessionRepository3.getToken(anonymousClass2);
                                    if (token != coroutine_suspended) {
                                        int i7 = iIntValue;
                                        str11 = str10;
                                        obj5 = token;
                                        j5 = j4;
                                        str12 = str9;
                                        languageEnum10 = languageEnum9;
                                        languageEnum11 = languageEnum8;
                                        i2 = i;
                                        voice6 = voice5;
                                        str13 = str8;
                                        i3 = i7;
                                        str14 = str7;
                                        responseResource3 = (ResponseResource) obj5;
                                        if (responseResource3 instanceof ResponseResource.Success) {
                                            if (responseResource3 instanceof ResponseResource.Error) {
                                                return responseResource3;
                                            }
                                            if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                                                return ResponseResource.Loading.INSTANCE;
                                            }
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        str15 = (String) ((ResponseResource.Success) responseResource3).getData();
                                        if (!LangaugeUtilsKt.isTextInLanguage(str13, languageEnum10)) {
                                            return new ResponseResource.Error(AppError.LanguageError.INSTANCE);
                                        }
                                        if (languageEnum10 != languageEnum11) {
                                            LtsTranslationRepository ltsTranslationRepository = this.ltsTranslationRepository;
                                            anonymousClass2.L$0 = str13;
                                            anonymousClass2.L$1 = languageEnum11;
                                            anonymousClass2.L$2 = languageEnum10;
                                            anonymousClass2.L$3 = voice6;
                                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str12);
                                            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str14);
                                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str11);
                                            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str15);
                                            anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str13);
                                            anonymousClass2.J$0 = j5;
                                            anonymousClass2.I$0 = i3;
                                            anonymousClass2.I$1 = i2;
                                            anonymousClass2.label = 6;
                                            voice7 = voice6;
                                            objTranslateBhashini = ltsTranslationRepository.translateBhashini(str12, str14, str11, str15, str13, languageEnum10, languageEnum11, anonymousClass2);
                                            if (objTranslateBhashini == coroutine_suspended) {
                                                str22 = str11;
                                                str23 = str15;
                                                LanguageEnum languageEnum19 = languageEnum11;
                                                voice8 = voice7;
                                                obj6 = objTranslateBhashini;
                                                i5 = i3;
                                                languageEnum14 = languageEnum10;
                                                str24 = str12;
                                                String str34 = str13;
                                                str19 = str14;
                                                j7 = j5;
                                                str25 = str34;
                                                languageEnum15 = languageEnum19;
                                                responseResource4 = (ResponseResource) obj6;
                                                i6 = i5;
                                                if (!(responseResource4 instanceof ResponseResource.Success)) {
                                                    if (responseResource4 instanceof ResponseResource.Error) {
                                                        return responseResource4;
                                                    }
                                                    if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                                        return ResponseResource.Loading.INSTANCE;
                                                    }
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                                str18 = (String) ((ResponseResource.Success) responseResource4).getData();
                                                j6 = j7;
                                                str16 = str24;
                                                voice6 = voice8;
                                                languageEnum12 = languageEnum14;
                                                languageEnum13 = languageEnum15;
                                                str17 = str25;
                                                i4 = i6;
                                                str21 = str23;
                                                str20 = str22;
                                                conversationMessage = new ConversationMessage(0L, j6, "User", str17, str18, languageEnum13, null, 0, languageEnum12, MessageInputType.TYPED, MessageType.TEXT_TO_SPEECH, true, false, System.currentTimeMillis(), 4289, null);
                                                j8 = j6;
                                                languageEnum16 = languageEnum13;
                                                this.textToSpeechManager.stopSpeaking();
                                                str26 = str18;
                                                TextToSpeechManager.speakText$default(this.textToSpeechManager, str26, LanguageMapper.INSTANCE.toTranscriptionLang(languageEnum16), voice6, 0, 8, null);
                                                conversationMessageRepository = this.conversationMessageRepository;
                                                str27 = str16;
                                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                                                anonymousClass2.L$1 = languageEnum16;
                                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice6);
                                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                                                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str19);
                                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                                anonymousClass2.L$8 = str26;
                                                anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage);
                                                anonymousClass2.J$0 = j8;
                                                anonymousClass2.I$0 = i4;
                                                anonymousClass2.I$1 = i2;
                                                anonymousClass2.label = 7;
                                                if (conversationMessageRepository.insertConversationMessageWithNextSequenceIdAndGetWithId(conversationMessage, anonymousClass2) != coroutine_suspended) {
                                                    String str35 = str19;
                                                    str28 = str26;
                                                    conversationMessage2 = conversationMessage;
                                                    str29 = str35;
                                                    voice9 = voice6;
                                                    languageEnum17 = languageEnum16;
                                                    str30 = str27;
                                                    str31 = str17;
                                                    conversationUsageRepository = this.conversationUsageRepository;
                                                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str31);
                                                    anonymousClass2.L$1 = languageEnum17;
                                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice9);
                                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str30);
                                                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str29);
                                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                                    anonymousClass2.L$8 = str28;
                                                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage2);
                                                    anonymousClass2.J$0 = j8;
                                                    anonymousClass2.I$0 = i4;
                                                    anonymousClass2.I$1 = i2;
                                                    anonymousClass2.label = 8;
                                                    if (conversationUsageRepository.incrementTts(anonymousClass2) != coroutine_suspended) {
                                                        str32 = str28;
                                                        this.analyticsManager.logEvent(new AnalyticsEvent.TtsUsed(languageEnum17.name(), str32.length()));
                                                        return new ResponseResource.Success(Unit.INSTANCE);
                                                    }
                                                }
                                            }
                                        } else {
                                            str16 = str12;
                                            str17 = str13;
                                            str18 = str17;
                                            languageEnum12 = languageEnum10;
                                            languageEnum13 = languageEnum11;
                                            i4 = i3;
                                            j6 = j5;
                                            str19 = str14;
                                            str20 = str11;
                                            str21 = str15;
                                            conversationMessage = new ConversationMessage(0L, j6, "User", str17, str18, languageEnum13, null, 0, languageEnum12, MessageInputType.TYPED, MessageType.TEXT_TO_SPEECH, true, false, System.currentTimeMillis(), 4289, null);
                                            j8 = j6;
                                            languageEnum16 = languageEnum13;
                                            this.textToSpeechManager.stopSpeaking();
                                            str26 = str18;
                                            TextToSpeechManager.speakText$default(this.textToSpeechManager, str26, LanguageMapper.INSTANCE.toTranscriptionLang(languageEnum16), voice6, 0, 8, null);
                                            conversationMessageRepository = this.conversationMessageRepository;
                                            str27 = str16;
                                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                                            anonymousClass2.L$1 = languageEnum16;
                                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice6);
                                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                                            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str19);
                                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                            anonymousClass2.L$8 = str26;
                                            anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage);
                                            anonymousClass2.J$0 = j8;
                                            anonymousClass2.I$0 = i4;
                                            anonymousClass2.I$1 = i2;
                                            anonymousClass2.label = 7;
                                            if (conversationMessageRepository.insertConversationMessageWithNextSequenceIdAndGetWithId(conversationMessage, anonymousClass2) != coroutine_suspended) {
                                                String str36 = str19;
                                                str28 = str26;
                                                conversationMessage2 = conversationMessage;
                                                str29 = str36;
                                                voice9 = voice6;
                                                languageEnum17 = languageEnum16;
                                                str30 = str27;
                                                str31 = str17;
                                                conversationUsageRepository = this.conversationUsageRepository;
                                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str31);
                                                anonymousClass2.L$1 = languageEnum17;
                                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice9);
                                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str30);
                                                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str29);
                                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                                anonymousClass2.L$8 = str28;
                                                anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage2);
                                                anonymousClass2.J$0 = j8;
                                                anonymousClass2.I$0 = i4;
                                                anonymousClass2.I$1 = i2;
                                                anonymousClass2.label = 8;
                                                if (conversationUsageRepository.incrementTts(anonymousClass2) != coroutine_suspended) {
                                                    str32 = str28;
                                                    this.analyticsManager.logEvent(new AnalyticsEvent.TtsUsed(languageEnum17.name(), str32.length()));
                                                    return new ResponseResource.Success(Unit.INSTANCE);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                case 1:
                    long j10 = anonymousClass2.J$0;
                    voice2 = (Voice) anonymousClass2.L$3;
                    languageEnum4 = (LanguageEnum) anonymousClass2.L$2;
                    LanguageEnum languageEnum20 = (LanguageEnum) anonymousClass2.L$1;
                    String str37 = (String) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj7);
                    str2 = str37;
                    j2 = j10;
                    languageEnum3 = languageEnum20;
                    obj = obj7;
                    iIntValue = ((Number) obj).intValue();
                    Flow<Integer> currentTts2 = this.conversationUsageRepository.getCurrentTts();
                    anonymousClass2.L$0 = str2;
                    anonymousClass2.L$1 = languageEnum3;
                    anonymousClass2.L$2 = languageEnum4;
                    anonymousClass2.L$3 = voice2;
                    anonymousClass2.J$0 = j2;
                    anonymousClass2.I$0 = iIntValue;
                    anonymousClass2.label = 2;
                    objFirst = FlowKt.first(currentTts2, anonymousClass2);
                    if (objFirst == coroutine_suspended) {
                        str3 = str2;
                        LanguageEnum languageEnum110 = languageEnum4;
                        voice3 = voice2;
                        obj2 = objFirst;
                        languageEnum5 = languageEnum3;
                        j3 = j2;
                        languageEnum6 = languageEnum110;
                        iIntValue2 = ((Number) obj2).intValue();
                        if (iIntValue2 >= iIntValue) {
                            return new ResponseResource.Error(AppError.QuotaExceeded.INSTANCE);
                        }
                        customerId = this.sessionRepository.getCustomerId();
                        if (!(customerId instanceof ResponseResource.Success)) {
                            if (customerId instanceof ResponseResource.Error) {
                                return customerId;
                            }
                            if (Intrinsics.areEqual(customerId, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        str4 = (String) ((ResponseResource.Success) customerId).getData();
                        SessionRepository sessionRepository4 = this.sessionRepository;
                        anonymousClass2.L$0 = str3;
                        anonymousClass2.L$1 = languageEnum5;
                        anonymousClass2.L$2 = languageEnum6;
                        anonymousClass2.L$3 = voice3;
                        anonymousClass2.L$4 = str4;
                        anonymousClass2.J$0 = j3;
                        anonymousClass2.I$0 = iIntValue;
                        anonymousClass2.I$1 = iIntValue2;
                        anonymousClass2.label = 3;
                        deviceId = sessionRepository4.getDeviceId(anonymousClass2);
                        if (deviceId != coroutine_suspended) {
                            long j11 = j3;
                            i = iIntValue2;
                            obj3 = deviceId;
                            str5 = str3;
                            languageEnum7 = languageEnum5;
                            voice4 = voice3;
                            j4 = j11;
                            responseResource = (ResponseResource) obj3;
                            if (responseResource instanceof ResponseResource.Success) {
                                if (responseResource instanceof ResponseResource.Error) {
                                    return responseResource;
                                }
                                if (Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
                                    return ResponseResource.Loading.INSTANCE;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            str6 = (String) ((ResponseResource.Success) responseResource).getData();
                            SessionRepository sessionRepository5 = this.sessionRepository;
                            anonymousClass2.L$0 = str5;
                            anonymousClass2.L$1 = languageEnum7;
                            anonymousClass2.L$2 = languageEnum6;
                            anonymousClass2.L$3 = voice4;
                            anonymousClass2.L$4 = str4;
                            anonymousClass2.L$5 = str6;
                            anonymousClass2.J$0 = j4;
                            anonymousClass2.I$0 = iIntValue;
                            anonymousClass2.I$1 = i;
                            anonymousClass2.label = 4;
                            gmailId = sessionRepository5.getGmailId(anonymousClass2);
                            if (gmailId == coroutine_suspended) {
                                String str38 = str4;
                                str7 = str6;
                                obj4 = gmailId;
                                str8 = str5;
                                languageEnum8 = languageEnum7;
                                languageEnum9 = languageEnum6;
                                voice5 = voice4;
                                str9 = str38;
                                responseResource2 = (ResponseResource) obj4;
                                if (!(responseResource2 instanceof ResponseResource.Success)) {
                                    if (responseResource2 instanceof ResponseResource.Error) {
                                        return responseResource2;
                                    }
                                    if (Intrinsics.areEqual(responseResource2, ResponseResource.Loading.INSTANCE)) {
                                        return ResponseResource.Loading.INSTANCE;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                                str10 = (String) ((ResponseResource.Success) responseResource2).getData();
                                SessionRepository sessionRepository6 = this.sessionRepository;
                                anonymousClass2.L$0 = str8;
                                anonymousClass2.L$1 = languageEnum8;
                                anonymousClass2.L$2 = languageEnum9;
                                anonymousClass2.L$3 = voice5;
                                anonymousClass2.L$4 = str9;
                                anonymousClass2.L$5 = str7;
                                anonymousClass2.L$6 = str10;
                                anonymousClass2.J$0 = j4;
                                anonymousClass2.I$0 = iIntValue;
                                anonymousClass2.I$1 = i;
                                anonymousClass2.label = 5;
                                token = sessionRepository6.getToken(anonymousClass2);
                                if (token != coroutine_suspended) {
                                    int i8 = iIntValue;
                                    str11 = str10;
                                    obj5 = token;
                                    j5 = j4;
                                    str12 = str9;
                                    languageEnum10 = languageEnum9;
                                    languageEnum11 = languageEnum8;
                                    i2 = i;
                                    voice6 = voice5;
                                    str13 = str8;
                                    i3 = i8;
                                    str14 = str7;
                                    responseResource3 = (ResponseResource) obj5;
                                    if (responseResource3 instanceof ResponseResource.Success) {
                                        if (responseResource3 instanceof ResponseResource.Error) {
                                            return responseResource3;
                                        }
                                        if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                                            return ResponseResource.Loading.INSTANCE;
                                        }
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    str15 = (String) ((ResponseResource.Success) responseResource3).getData();
                                    if (!LangaugeUtilsKt.isTextInLanguage(str13, languageEnum10)) {
                                        return new ResponseResource.Error(AppError.LanguageError.INSTANCE);
                                    }
                                    if (languageEnum10 != languageEnum11) {
                                        LtsTranslationRepository ltsTranslationRepository2 = this.ltsTranslationRepository;
                                        anonymousClass2.L$0 = str13;
                                        anonymousClass2.L$1 = languageEnum11;
                                        anonymousClass2.L$2 = languageEnum10;
                                        anonymousClass2.L$3 = voice6;
                                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str12);
                                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str14);
                                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str11);
                                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str15);
                                        anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str13);
                                        anonymousClass2.J$0 = j5;
                                        anonymousClass2.I$0 = i3;
                                        anonymousClass2.I$1 = i2;
                                        anonymousClass2.label = 6;
                                        voice7 = voice6;
                                        objTranslateBhashini = ltsTranslationRepository2.translateBhashini(str12, str14, str11, str15, str13, languageEnum10, languageEnum11, anonymousClass2);
                                        if (objTranslateBhashini == coroutine_suspended) {
                                            str22 = str11;
                                            str23 = str15;
                                            LanguageEnum languageEnum111 = languageEnum11;
                                            voice8 = voice7;
                                            obj6 = objTranslateBhashini;
                                            i5 = i3;
                                            languageEnum14 = languageEnum10;
                                            str24 = str12;
                                            String str39 = str13;
                                            str19 = str14;
                                            j7 = j5;
                                            str25 = str39;
                                            languageEnum15 = languageEnum111;
                                            responseResource4 = (ResponseResource) obj6;
                                            i6 = i5;
                                            if (!(responseResource4 instanceof ResponseResource.Success)) {
                                                if (responseResource4 instanceof ResponseResource.Error) {
                                                    return responseResource4;
                                                }
                                                if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                                    return ResponseResource.Loading.INSTANCE;
                                                }
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            str18 = (String) ((ResponseResource.Success) responseResource4).getData();
                                            j6 = j7;
                                            str16 = str24;
                                            voice6 = voice8;
                                            languageEnum12 = languageEnum14;
                                            languageEnum13 = languageEnum15;
                                            str17 = str25;
                                            i4 = i6;
                                            str21 = str23;
                                            str20 = str22;
                                            conversationMessage = new ConversationMessage(0L, j6, "User", str17, str18, languageEnum13, null, 0, languageEnum12, MessageInputType.TYPED, MessageType.TEXT_TO_SPEECH, true, false, System.currentTimeMillis(), 4289, null);
                                            j8 = j6;
                                            languageEnum16 = languageEnum13;
                                            this.textToSpeechManager.stopSpeaking();
                                            str26 = str18;
                                            TextToSpeechManager.speakText$default(this.textToSpeechManager, str26, LanguageMapper.INSTANCE.toTranscriptionLang(languageEnum16), voice6, 0, 8, null);
                                            conversationMessageRepository = this.conversationMessageRepository;
                                            str27 = str16;
                                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                                            anonymousClass2.L$1 = languageEnum16;
                                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice6);
                                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                                            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str19);
                                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                            anonymousClass2.L$8 = str26;
                                            anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage);
                                            anonymousClass2.J$0 = j8;
                                            anonymousClass2.I$0 = i4;
                                            anonymousClass2.I$1 = i2;
                                            anonymousClass2.label = 7;
                                            if (conversationMessageRepository.insertConversationMessageWithNextSequenceIdAndGetWithId(conversationMessage, anonymousClass2) != coroutine_suspended) {
                                                String str310 = str19;
                                                str28 = str26;
                                                conversationMessage2 = conversationMessage;
                                                str29 = str310;
                                                voice9 = voice6;
                                                languageEnum17 = languageEnum16;
                                                str30 = str27;
                                                str31 = str17;
                                                conversationUsageRepository = this.conversationUsageRepository;
                                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str31);
                                                anonymousClass2.L$1 = languageEnum17;
                                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice9);
                                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str30);
                                                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str29);
                                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                                anonymousClass2.L$8 = str28;
                                                anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage2);
                                                anonymousClass2.J$0 = j8;
                                                anonymousClass2.I$0 = i4;
                                                anonymousClass2.I$1 = i2;
                                                anonymousClass2.label = 8;
                                                if (conversationUsageRepository.incrementTts(anonymousClass2) != coroutine_suspended) {
                                                    str32 = str28;
                                                    this.analyticsManager.logEvent(new AnalyticsEvent.TtsUsed(languageEnum17.name(), str32.length()));
                                                    return new ResponseResource.Success(Unit.INSTANCE);
                                                }
                                            }
                                        }
                                    } else {
                                        str16 = str12;
                                        str17 = str13;
                                        str18 = str17;
                                        languageEnum12 = languageEnum10;
                                        languageEnum13 = languageEnum11;
                                        i4 = i3;
                                        j6 = j5;
                                        str19 = str14;
                                        str20 = str11;
                                        str21 = str15;
                                        conversationMessage = new ConversationMessage(0L, j6, "User", str17, str18, languageEnum13, null, 0, languageEnum12, MessageInputType.TYPED, MessageType.TEXT_TO_SPEECH, true, false, System.currentTimeMillis(), 4289, null);
                                        j8 = j6;
                                        languageEnum16 = languageEnum13;
                                        this.textToSpeechManager.stopSpeaking();
                                        str26 = str18;
                                        TextToSpeechManager.speakText$default(this.textToSpeechManager, str26, LanguageMapper.INSTANCE.toTranscriptionLang(languageEnum16), voice6, 0, 8, null);
                                        conversationMessageRepository = this.conversationMessageRepository;
                                        str27 = str16;
                                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                                        anonymousClass2.L$1 = languageEnum16;
                                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice6);
                                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str19);
                                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                        anonymousClass2.L$8 = str26;
                                        anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage);
                                        anonymousClass2.J$0 = j8;
                                        anonymousClass2.I$0 = i4;
                                        anonymousClass2.I$1 = i2;
                                        anonymousClass2.label = 7;
                                        if (conversationMessageRepository.insertConversationMessageWithNextSequenceIdAndGetWithId(conversationMessage, anonymousClass2) != coroutine_suspended) {
                                            String str311 = str19;
                                            str28 = str26;
                                            conversationMessage2 = conversationMessage;
                                            str29 = str311;
                                            voice9 = voice6;
                                            languageEnum17 = languageEnum16;
                                            str30 = str27;
                                            str31 = str17;
                                            conversationUsageRepository = this.conversationUsageRepository;
                                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str31);
                                            anonymousClass2.L$1 = languageEnum17;
                                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice9);
                                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str30);
                                            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str29);
                                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                            anonymousClass2.L$8 = str28;
                                            anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage2);
                                            anonymousClass2.J$0 = j8;
                                            anonymousClass2.I$0 = i4;
                                            anonymousClass2.I$1 = i2;
                                            anonymousClass2.label = 8;
                                            if (conversationUsageRepository.incrementTts(anonymousClass2) != coroutine_suspended) {
                                                str32 = str28;
                                                this.analyticsManager.logEvent(new AnalyticsEvent.TtsUsed(languageEnum17.name(), str32.length()));
                                                return new ResponseResource.Success(Unit.INSTANCE);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                case 2:
                    int i9 = anonymousClass2.I$0;
                    j3 = anonymousClass2.J$0;
                    voice3 = (Voice) anonymousClass2.L$3;
                    LanguageEnum languageEnum21 = (LanguageEnum) anonymousClass2.L$2;
                    LanguageEnum languageEnum22 = (LanguageEnum) anonymousClass2.L$1;
                    String str40 = (String) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj7);
                    languageEnum5 = languageEnum22;
                    str3 = str40;
                    languageEnum6 = languageEnum21;
                    iIntValue = i9;
                    obj2 = obj7;
                    iIntValue2 = ((Number) obj2).intValue();
                    if (iIntValue2 >= iIntValue) {
                        return new ResponseResource.Error(AppError.QuotaExceeded.INSTANCE);
                    }
                    customerId = this.sessionRepository.getCustomerId();
                    if (!(customerId instanceof ResponseResource.Success)) {
                        if (customerId instanceof ResponseResource.Error) {
                            return customerId;
                        }
                        if (Intrinsics.areEqual(customerId, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str4 = (String) ((ResponseResource.Success) customerId).getData();
                    SessionRepository sessionRepository7 = this.sessionRepository;
                    anonymousClass2.L$0 = str3;
                    anonymousClass2.L$1 = languageEnum5;
                    anonymousClass2.L$2 = languageEnum6;
                    anonymousClass2.L$3 = voice3;
                    anonymousClass2.L$4 = str4;
                    anonymousClass2.J$0 = j3;
                    anonymousClass2.I$0 = iIntValue;
                    anonymousClass2.I$1 = iIntValue2;
                    anonymousClass2.label = 3;
                    deviceId = sessionRepository7.getDeviceId(anonymousClass2);
                    if (deviceId != coroutine_suspended) {
                        long j12 = j3;
                        i = iIntValue2;
                        obj3 = deviceId;
                        str5 = str3;
                        languageEnum7 = languageEnum5;
                        voice4 = voice3;
                        j4 = j12;
                        responseResource = (ResponseResource) obj3;
                        if (responseResource instanceof ResponseResource.Success) {
                            if (responseResource instanceof ResponseResource.Error) {
                                return responseResource;
                            }
                            if (Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        str6 = (String) ((ResponseResource.Success) responseResource).getData();
                        SessionRepository sessionRepository8 = this.sessionRepository;
                        anonymousClass2.L$0 = str5;
                        anonymousClass2.L$1 = languageEnum7;
                        anonymousClass2.L$2 = languageEnum6;
                        anonymousClass2.L$3 = voice4;
                        anonymousClass2.L$4 = str4;
                        anonymousClass2.L$5 = str6;
                        anonymousClass2.J$0 = j4;
                        anonymousClass2.I$0 = iIntValue;
                        anonymousClass2.I$1 = i;
                        anonymousClass2.label = 4;
                        gmailId = sessionRepository8.getGmailId(anonymousClass2);
                        if (gmailId == coroutine_suspended) {
                            String str312 = str4;
                            str7 = str6;
                            obj4 = gmailId;
                            str8 = str5;
                            languageEnum8 = languageEnum7;
                            languageEnum9 = languageEnum6;
                            voice5 = voice4;
                            str9 = str312;
                            responseResource2 = (ResponseResource) obj4;
                            if (!(responseResource2 instanceof ResponseResource.Success)) {
                                if (responseResource2 instanceof ResponseResource.Error) {
                                    return responseResource2;
                                }
                                if (Intrinsics.areEqual(responseResource2, ResponseResource.Loading.INSTANCE)) {
                                    return ResponseResource.Loading.INSTANCE;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            str10 = (String) ((ResponseResource.Success) responseResource2).getData();
                            SessionRepository sessionRepository9 = this.sessionRepository;
                            anonymousClass2.L$0 = str8;
                            anonymousClass2.L$1 = languageEnum8;
                            anonymousClass2.L$2 = languageEnum9;
                            anonymousClass2.L$3 = voice5;
                            anonymousClass2.L$4 = str9;
                            anonymousClass2.L$5 = str7;
                            anonymousClass2.L$6 = str10;
                            anonymousClass2.J$0 = j4;
                            anonymousClass2.I$0 = iIntValue;
                            anonymousClass2.I$1 = i;
                            anonymousClass2.label = 5;
                            token = sessionRepository9.getToken(anonymousClass2);
                            if (token != coroutine_suspended) {
                                int i10 = iIntValue;
                                str11 = str10;
                                obj5 = token;
                                j5 = j4;
                                str12 = str9;
                                languageEnum10 = languageEnum9;
                                languageEnum11 = languageEnum8;
                                i2 = i;
                                voice6 = voice5;
                                str13 = str8;
                                i3 = i10;
                                str14 = str7;
                                responseResource3 = (ResponseResource) obj5;
                                if (responseResource3 instanceof ResponseResource.Success) {
                                    if (responseResource3 instanceof ResponseResource.Error) {
                                        return responseResource3;
                                    }
                                    if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                                        return ResponseResource.Loading.INSTANCE;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                                str15 = (String) ((ResponseResource.Success) responseResource3).getData();
                                if (!LangaugeUtilsKt.isTextInLanguage(str13, languageEnum10)) {
                                    return new ResponseResource.Error(AppError.LanguageError.INSTANCE);
                                }
                                if (languageEnum10 != languageEnum11) {
                                    LtsTranslationRepository ltsTranslationRepository3 = this.ltsTranslationRepository;
                                    anonymousClass2.L$0 = str13;
                                    anonymousClass2.L$1 = languageEnum11;
                                    anonymousClass2.L$2 = languageEnum10;
                                    anonymousClass2.L$3 = voice6;
                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str12);
                                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str14);
                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str11);
                                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str15);
                                    anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str13);
                                    anonymousClass2.J$0 = j5;
                                    anonymousClass2.I$0 = i3;
                                    anonymousClass2.I$1 = i2;
                                    anonymousClass2.label = 6;
                                    voice7 = voice6;
                                    objTranslateBhashini = ltsTranslationRepository3.translateBhashini(str12, str14, str11, str15, str13, languageEnum10, languageEnum11, anonymousClass2);
                                    if (objTranslateBhashini == coroutine_suspended) {
                                        str22 = str11;
                                        str23 = str15;
                                        LanguageEnum languageEnum112 = languageEnum11;
                                        voice8 = voice7;
                                        obj6 = objTranslateBhashini;
                                        i5 = i3;
                                        languageEnum14 = languageEnum10;
                                        str24 = str12;
                                        String str313 = str13;
                                        str19 = str14;
                                        j7 = j5;
                                        str25 = str313;
                                        languageEnum15 = languageEnum112;
                                        responseResource4 = (ResponseResource) obj6;
                                        i6 = i5;
                                        if (!(responseResource4 instanceof ResponseResource.Success)) {
                                            if (responseResource4 instanceof ResponseResource.Error) {
                                                return responseResource4;
                                            }
                                            if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                                return ResponseResource.Loading.INSTANCE;
                                            }
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        str18 = (String) ((ResponseResource.Success) responseResource4).getData();
                                        j6 = j7;
                                        str16 = str24;
                                        voice6 = voice8;
                                        languageEnum12 = languageEnum14;
                                        languageEnum13 = languageEnum15;
                                        str17 = str25;
                                        i4 = i6;
                                        str21 = str23;
                                        str20 = str22;
                                        conversationMessage = new ConversationMessage(0L, j6, "User", str17, str18, languageEnum13, null, 0, languageEnum12, MessageInputType.TYPED, MessageType.TEXT_TO_SPEECH, true, false, System.currentTimeMillis(), 4289, null);
                                        j8 = j6;
                                        languageEnum16 = languageEnum13;
                                        this.textToSpeechManager.stopSpeaking();
                                        str26 = str18;
                                        TextToSpeechManager.speakText$default(this.textToSpeechManager, str26, LanguageMapper.INSTANCE.toTranscriptionLang(languageEnum16), voice6, 0, 8, null);
                                        conversationMessageRepository = this.conversationMessageRepository;
                                        str27 = str16;
                                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                                        anonymousClass2.L$1 = languageEnum16;
                                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice6);
                                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str19);
                                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                        anonymousClass2.L$8 = str26;
                                        anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage);
                                        anonymousClass2.J$0 = j8;
                                        anonymousClass2.I$0 = i4;
                                        anonymousClass2.I$1 = i2;
                                        anonymousClass2.label = 7;
                                        if (conversationMessageRepository.insertConversationMessageWithNextSequenceIdAndGetWithId(conversationMessage, anonymousClass2) != coroutine_suspended) {
                                            String str314 = str19;
                                            str28 = str26;
                                            conversationMessage2 = conversationMessage;
                                            str29 = str314;
                                            voice9 = voice6;
                                            languageEnum17 = languageEnum16;
                                            str30 = str27;
                                            str31 = str17;
                                            conversationUsageRepository = this.conversationUsageRepository;
                                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str31);
                                            anonymousClass2.L$1 = languageEnum17;
                                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice9);
                                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str30);
                                            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str29);
                                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                            anonymousClass2.L$8 = str28;
                                            anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage2);
                                            anonymousClass2.J$0 = j8;
                                            anonymousClass2.I$0 = i4;
                                            anonymousClass2.I$1 = i2;
                                            anonymousClass2.label = 8;
                                            if (conversationUsageRepository.incrementTts(anonymousClass2) != coroutine_suspended) {
                                                str32 = str28;
                                                this.analyticsManager.logEvent(new AnalyticsEvent.TtsUsed(languageEnum17.name(), str32.length()));
                                                return new ResponseResource.Success(Unit.INSTANCE);
                                            }
                                        }
                                    }
                                } else {
                                    str16 = str12;
                                    str17 = str13;
                                    str18 = str17;
                                    languageEnum12 = languageEnum10;
                                    languageEnum13 = languageEnum11;
                                    i4 = i3;
                                    j6 = j5;
                                    str19 = str14;
                                    str20 = str11;
                                    str21 = str15;
                                    conversationMessage = new ConversationMessage(0L, j6, "User", str17, str18, languageEnum13, null, 0, languageEnum12, MessageInputType.TYPED, MessageType.TEXT_TO_SPEECH, true, false, System.currentTimeMillis(), 4289, null);
                                    j8 = j6;
                                    languageEnum16 = languageEnum13;
                                    this.textToSpeechManager.stopSpeaking();
                                    str26 = str18;
                                    TextToSpeechManager.speakText$default(this.textToSpeechManager, str26, LanguageMapper.INSTANCE.toTranscriptionLang(languageEnum16), voice6, 0, 8, null);
                                    conversationMessageRepository = this.conversationMessageRepository;
                                    str27 = str16;
                                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                                    anonymousClass2.L$1 = languageEnum16;
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice6);
                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str19);
                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                    anonymousClass2.L$8 = str26;
                                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage);
                                    anonymousClass2.J$0 = j8;
                                    anonymousClass2.I$0 = i4;
                                    anonymousClass2.I$1 = i2;
                                    anonymousClass2.label = 7;
                                    if (conversationMessageRepository.insertConversationMessageWithNextSequenceIdAndGetWithId(conversationMessage, anonymousClass2) != coroutine_suspended) {
                                        String str315 = str19;
                                        str28 = str26;
                                        conversationMessage2 = conversationMessage;
                                        str29 = str315;
                                        voice9 = voice6;
                                        languageEnum17 = languageEnum16;
                                        str30 = str27;
                                        str31 = str17;
                                        conversationUsageRepository = this.conversationUsageRepository;
                                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str31);
                                        anonymousClass2.L$1 = languageEnum17;
                                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice9);
                                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str30);
                                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str29);
                                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                        anonymousClass2.L$8 = str28;
                                        anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage2);
                                        anonymousClass2.J$0 = j8;
                                        anonymousClass2.I$0 = i4;
                                        anonymousClass2.I$1 = i2;
                                        anonymousClass2.label = 8;
                                        if (conversationUsageRepository.incrementTts(anonymousClass2) != coroutine_suspended) {
                                            str32 = str28;
                                            this.analyticsManager.logEvent(new AnalyticsEvent.TtsUsed(languageEnum17.name(), str32.length()));
                                            return new ResponseResource.Success(Unit.INSTANCE);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                case 3:
                    int i11 = anonymousClass2.I$1;
                    int i12 = anonymousClass2.I$0;
                    j4 = anonymousClass2.J$0;
                    String str41 = (String) anonymousClass2.L$4;
                    Voice voice10 = (Voice) anonymousClass2.L$3;
                    languageEnum6 = (LanguageEnum) anonymousClass2.L$2;
                    LanguageEnum languageEnum23 = (LanguageEnum) anonymousClass2.L$1;
                    String str42 = (String) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj7);
                    str5 = str42;
                    languageEnum7 = languageEnum23;
                    voice4 = voice10;
                    str4 = str41;
                    iIntValue = i12;
                    i = i11;
                    obj3 = obj7;
                    responseResource = (ResponseResource) obj3;
                    if (responseResource instanceof ResponseResource.Success) {
                        if (responseResource instanceof ResponseResource.Error) {
                            return responseResource;
                        }
                        if (Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str6 = (String) ((ResponseResource.Success) responseResource).getData();
                    SessionRepository sessionRepository10 = this.sessionRepository;
                    anonymousClass2.L$0 = str5;
                    anonymousClass2.L$1 = languageEnum7;
                    anonymousClass2.L$2 = languageEnum6;
                    anonymousClass2.L$3 = voice4;
                    anonymousClass2.L$4 = str4;
                    anonymousClass2.L$5 = str6;
                    anonymousClass2.J$0 = j4;
                    anonymousClass2.I$0 = iIntValue;
                    anonymousClass2.I$1 = i;
                    anonymousClass2.label = 4;
                    gmailId = sessionRepository10.getGmailId(anonymousClass2);
                    if (gmailId == coroutine_suspended) {
                        String str316 = str4;
                        str7 = str6;
                        obj4 = gmailId;
                        str8 = str5;
                        languageEnum8 = languageEnum7;
                        languageEnum9 = languageEnum6;
                        voice5 = voice4;
                        str9 = str316;
                        responseResource2 = (ResponseResource) obj4;
                        if (!(responseResource2 instanceof ResponseResource.Success)) {
                            if (responseResource2 instanceof ResponseResource.Error) {
                                return responseResource2;
                            }
                            if (Intrinsics.areEqual(responseResource2, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        str10 = (String) ((ResponseResource.Success) responseResource2).getData();
                        SessionRepository sessionRepository11 = this.sessionRepository;
                        anonymousClass2.L$0 = str8;
                        anonymousClass2.L$1 = languageEnum8;
                        anonymousClass2.L$2 = languageEnum9;
                        anonymousClass2.L$3 = voice5;
                        anonymousClass2.L$4 = str9;
                        anonymousClass2.L$5 = str7;
                        anonymousClass2.L$6 = str10;
                        anonymousClass2.J$0 = j4;
                        anonymousClass2.I$0 = iIntValue;
                        anonymousClass2.I$1 = i;
                        anonymousClass2.label = 5;
                        token = sessionRepository11.getToken(anonymousClass2);
                        if (token != coroutine_suspended) {
                            int i13 = iIntValue;
                            str11 = str10;
                            obj5 = token;
                            j5 = j4;
                            str12 = str9;
                            languageEnum10 = languageEnum9;
                            languageEnum11 = languageEnum8;
                            i2 = i;
                            voice6 = voice5;
                            str13 = str8;
                            i3 = i13;
                            str14 = str7;
                            responseResource3 = (ResponseResource) obj5;
                            if (responseResource3 instanceof ResponseResource.Success) {
                                if (responseResource3 instanceof ResponseResource.Error) {
                                    return responseResource3;
                                }
                                if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                                    return ResponseResource.Loading.INSTANCE;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            str15 = (String) ((ResponseResource.Success) responseResource3).getData();
                            if (!LangaugeUtilsKt.isTextInLanguage(str13, languageEnum10)) {
                                return new ResponseResource.Error(AppError.LanguageError.INSTANCE);
                            }
                            if (languageEnum10 != languageEnum11) {
                                LtsTranslationRepository ltsTranslationRepository4 = this.ltsTranslationRepository;
                                anonymousClass2.L$0 = str13;
                                anonymousClass2.L$1 = languageEnum11;
                                anonymousClass2.L$2 = languageEnum10;
                                anonymousClass2.L$3 = voice6;
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str12);
                                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str14);
                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str11);
                                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str15);
                                anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str13);
                                anonymousClass2.J$0 = j5;
                                anonymousClass2.I$0 = i3;
                                anonymousClass2.I$1 = i2;
                                anonymousClass2.label = 6;
                                voice7 = voice6;
                                objTranslateBhashini = ltsTranslationRepository4.translateBhashini(str12, str14, str11, str15, str13, languageEnum10, languageEnum11, anonymousClass2);
                                if (objTranslateBhashini == coroutine_suspended) {
                                    str22 = str11;
                                    str23 = str15;
                                    LanguageEnum languageEnum113 = languageEnum11;
                                    voice8 = voice7;
                                    obj6 = objTranslateBhashini;
                                    i5 = i3;
                                    languageEnum14 = languageEnum10;
                                    str24 = str12;
                                    String str317 = str13;
                                    str19 = str14;
                                    j7 = j5;
                                    str25 = str317;
                                    languageEnum15 = languageEnum113;
                                    responseResource4 = (ResponseResource) obj6;
                                    i6 = i5;
                                    if (!(responseResource4 instanceof ResponseResource.Success)) {
                                        if (responseResource4 instanceof ResponseResource.Error) {
                                            return responseResource4;
                                        }
                                        if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                            return ResponseResource.Loading.INSTANCE;
                                        }
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    str18 = (String) ((ResponseResource.Success) responseResource4).getData();
                                    j6 = j7;
                                    str16 = str24;
                                    voice6 = voice8;
                                    languageEnum12 = languageEnum14;
                                    languageEnum13 = languageEnum15;
                                    str17 = str25;
                                    i4 = i6;
                                    str21 = str23;
                                    str20 = str22;
                                    conversationMessage = new ConversationMessage(0L, j6, "User", str17, str18, languageEnum13, null, 0, languageEnum12, MessageInputType.TYPED, MessageType.TEXT_TO_SPEECH, true, false, System.currentTimeMillis(), 4289, null);
                                    j8 = j6;
                                    languageEnum16 = languageEnum13;
                                    this.textToSpeechManager.stopSpeaking();
                                    str26 = str18;
                                    TextToSpeechManager.speakText$default(this.textToSpeechManager, str26, LanguageMapper.INSTANCE.toTranscriptionLang(languageEnum16), voice6, 0, 8, null);
                                    conversationMessageRepository = this.conversationMessageRepository;
                                    str27 = str16;
                                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                                    anonymousClass2.L$1 = languageEnum16;
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice6);
                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str19);
                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                    anonymousClass2.L$8 = str26;
                                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage);
                                    anonymousClass2.J$0 = j8;
                                    anonymousClass2.I$0 = i4;
                                    anonymousClass2.I$1 = i2;
                                    anonymousClass2.label = 7;
                                    if (conversationMessageRepository.insertConversationMessageWithNextSequenceIdAndGetWithId(conversationMessage, anonymousClass2) != coroutine_suspended) {
                                        String str318 = str19;
                                        str28 = str26;
                                        conversationMessage2 = conversationMessage;
                                        str29 = str318;
                                        voice9 = voice6;
                                        languageEnum17 = languageEnum16;
                                        str30 = str27;
                                        str31 = str17;
                                        conversationUsageRepository = this.conversationUsageRepository;
                                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str31);
                                        anonymousClass2.L$1 = languageEnum17;
                                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice9);
                                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str30);
                                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str29);
                                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                        anonymousClass2.L$8 = str28;
                                        anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage2);
                                        anonymousClass2.J$0 = j8;
                                        anonymousClass2.I$0 = i4;
                                        anonymousClass2.I$1 = i2;
                                        anonymousClass2.label = 8;
                                        if (conversationUsageRepository.incrementTts(anonymousClass2) != coroutine_suspended) {
                                            str32 = str28;
                                            this.analyticsManager.logEvent(new AnalyticsEvent.TtsUsed(languageEnum17.name(), str32.length()));
                                            return new ResponseResource.Success(Unit.INSTANCE);
                                        }
                                    }
                                }
                            } else {
                                str16 = str12;
                                str17 = str13;
                                str18 = str17;
                                languageEnum12 = languageEnum10;
                                languageEnum13 = languageEnum11;
                                i4 = i3;
                                j6 = j5;
                                str19 = str14;
                                str20 = str11;
                                str21 = str15;
                                conversationMessage = new ConversationMessage(0L, j6, "User", str17, str18, languageEnum13, null, 0, languageEnum12, MessageInputType.TYPED, MessageType.TEXT_TO_SPEECH, true, false, System.currentTimeMillis(), 4289, null);
                                j8 = j6;
                                languageEnum16 = languageEnum13;
                                this.textToSpeechManager.stopSpeaking();
                                str26 = str18;
                                TextToSpeechManager.speakText$default(this.textToSpeechManager, str26, LanguageMapper.INSTANCE.toTranscriptionLang(languageEnum16), voice6, 0, 8, null);
                                conversationMessageRepository = this.conversationMessageRepository;
                                str27 = str16;
                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                                anonymousClass2.L$1 = languageEnum16;
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice6);
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str19);
                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                anonymousClass2.L$8 = str26;
                                anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage);
                                anonymousClass2.J$0 = j8;
                                anonymousClass2.I$0 = i4;
                                anonymousClass2.I$1 = i2;
                                anonymousClass2.label = 7;
                                if (conversationMessageRepository.insertConversationMessageWithNextSequenceIdAndGetWithId(conversationMessage, anonymousClass2) != coroutine_suspended) {
                                    String str319 = str19;
                                    str28 = str26;
                                    conversationMessage2 = conversationMessage;
                                    str29 = str319;
                                    voice9 = voice6;
                                    languageEnum17 = languageEnum16;
                                    str30 = str27;
                                    str31 = str17;
                                    conversationUsageRepository = this.conversationUsageRepository;
                                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str31);
                                    anonymousClass2.L$1 = languageEnum17;
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice9);
                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str30);
                                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str29);
                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                    anonymousClass2.L$8 = str28;
                                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage2);
                                    anonymousClass2.J$0 = j8;
                                    anonymousClass2.I$0 = i4;
                                    anonymousClass2.I$1 = i2;
                                    anonymousClass2.label = 8;
                                    if (conversationUsageRepository.incrementTts(anonymousClass2) != coroutine_suspended) {
                                        str32 = str28;
                                        this.analyticsManager.logEvent(new AnalyticsEvent.TtsUsed(languageEnum17.name(), str32.length()));
                                        return new ResponseResource.Success(Unit.INSTANCE);
                                    }
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                case 4:
                    int i14 = anonymousClass2.I$1;
                    int i15 = anonymousClass2.I$0;
                    j4 = anonymousClass2.J$0;
                    String str43 = (String) anonymousClass2.L$5;
                    String str44 = (String) anonymousClass2.L$4;
                    voice5 = (Voice) anonymousClass2.L$3;
                    LanguageEnum languageEnum24 = (LanguageEnum) anonymousClass2.L$2;
                    LanguageEnum languageEnum25 = (LanguageEnum) anonymousClass2.L$1;
                    String str45 = (String) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj7);
                    str8 = str45;
                    languageEnum8 = languageEnum25;
                    languageEnum9 = languageEnum24;
                    str9 = str44;
                    str7 = str43;
                    iIntValue = i15;
                    i = i14;
                    obj4 = obj7;
                    responseResource2 = (ResponseResource) obj4;
                    if (!(responseResource2 instanceof ResponseResource.Success)) {
                        if (responseResource2 instanceof ResponseResource.Error) {
                            return responseResource2;
                        }
                        if (Intrinsics.areEqual(responseResource2, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str10 = (String) ((ResponseResource.Success) responseResource2).getData();
                    SessionRepository sessionRepository12 = this.sessionRepository;
                    anonymousClass2.L$0 = str8;
                    anonymousClass2.L$1 = languageEnum8;
                    anonymousClass2.L$2 = languageEnum9;
                    anonymousClass2.L$3 = voice5;
                    anonymousClass2.L$4 = str9;
                    anonymousClass2.L$5 = str7;
                    anonymousClass2.L$6 = str10;
                    anonymousClass2.J$0 = j4;
                    anonymousClass2.I$0 = iIntValue;
                    anonymousClass2.I$1 = i;
                    anonymousClass2.label = 5;
                    token = sessionRepository12.getToken(anonymousClass2);
                    if (token != coroutine_suspended) {
                        int i16 = iIntValue;
                        str11 = str10;
                        obj5 = token;
                        j5 = j4;
                        str12 = str9;
                        languageEnum10 = languageEnum9;
                        languageEnum11 = languageEnum8;
                        i2 = i;
                        voice6 = voice5;
                        str13 = str8;
                        i3 = i16;
                        str14 = str7;
                        responseResource3 = (ResponseResource) obj5;
                        if (responseResource3 instanceof ResponseResource.Success) {
                            if (responseResource3 instanceof ResponseResource.Error) {
                                return responseResource3;
                            }
                            if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        str15 = (String) ((ResponseResource.Success) responseResource3).getData();
                        if (!LangaugeUtilsKt.isTextInLanguage(str13, languageEnum10)) {
                            return new ResponseResource.Error(AppError.LanguageError.INSTANCE);
                        }
                        if (languageEnum10 != languageEnum11) {
                            LtsTranslationRepository ltsTranslationRepository5 = this.ltsTranslationRepository;
                            anonymousClass2.L$0 = str13;
                            anonymousClass2.L$1 = languageEnum11;
                            anonymousClass2.L$2 = languageEnum10;
                            anonymousClass2.L$3 = voice6;
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str12);
                            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str14);
                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str11);
                            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str15);
                            anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str13);
                            anonymousClass2.J$0 = j5;
                            anonymousClass2.I$0 = i3;
                            anonymousClass2.I$1 = i2;
                            anonymousClass2.label = 6;
                            voice7 = voice6;
                            objTranslateBhashini = ltsTranslationRepository5.translateBhashini(str12, str14, str11, str15, str13, languageEnum10, languageEnum11, anonymousClass2);
                            if (objTranslateBhashini == coroutine_suspended) {
                                str22 = str11;
                                str23 = str15;
                                LanguageEnum languageEnum114 = languageEnum11;
                                voice8 = voice7;
                                obj6 = objTranslateBhashini;
                                i5 = i3;
                                languageEnum14 = languageEnum10;
                                str24 = str12;
                                String str3110 = str13;
                                str19 = str14;
                                j7 = j5;
                                str25 = str3110;
                                languageEnum15 = languageEnum114;
                                responseResource4 = (ResponseResource) obj6;
                                i6 = i5;
                                if (!(responseResource4 instanceof ResponseResource.Success)) {
                                    if (responseResource4 instanceof ResponseResource.Error) {
                                        return responseResource4;
                                    }
                                    if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                        return ResponseResource.Loading.INSTANCE;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                                str18 = (String) ((ResponseResource.Success) responseResource4).getData();
                                j6 = j7;
                                str16 = str24;
                                voice6 = voice8;
                                languageEnum12 = languageEnum14;
                                languageEnum13 = languageEnum15;
                                str17 = str25;
                                i4 = i6;
                                str21 = str23;
                                str20 = str22;
                                conversationMessage = new ConversationMessage(0L, j6, "User", str17, str18, languageEnum13, null, 0, languageEnum12, MessageInputType.TYPED, MessageType.TEXT_TO_SPEECH, true, false, System.currentTimeMillis(), 4289, null);
                                j8 = j6;
                                languageEnum16 = languageEnum13;
                                this.textToSpeechManager.stopSpeaking();
                                str26 = str18;
                                TextToSpeechManager.speakText$default(this.textToSpeechManager, str26, LanguageMapper.INSTANCE.toTranscriptionLang(languageEnum16), voice6, 0, 8, null);
                                conversationMessageRepository = this.conversationMessageRepository;
                                str27 = str16;
                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                                anonymousClass2.L$1 = languageEnum16;
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice6);
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str19);
                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                anonymousClass2.L$8 = str26;
                                anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage);
                                anonymousClass2.J$0 = j8;
                                anonymousClass2.I$0 = i4;
                                anonymousClass2.I$1 = i2;
                                anonymousClass2.label = 7;
                                if (conversationMessageRepository.insertConversationMessageWithNextSequenceIdAndGetWithId(conversationMessage, anonymousClass2) != coroutine_suspended) {
                                    String str3111 = str19;
                                    str28 = str26;
                                    conversationMessage2 = conversationMessage;
                                    str29 = str3111;
                                    voice9 = voice6;
                                    languageEnum17 = languageEnum16;
                                    str30 = str27;
                                    str31 = str17;
                                    conversationUsageRepository = this.conversationUsageRepository;
                                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str31);
                                    anonymousClass2.L$1 = languageEnum17;
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice9);
                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str30);
                                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str29);
                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                    anonymousClass2.L$8 = str28;
                                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage2);
                                    anonymousClass2.J$0 = j8;
                                    anonymousClass2.I$0 = i4;
                                    anonymousClass2.I$1 = i2;
                                    anonymousClass2.label = 8;
                                    if (conversationUsageRepository.incrementTts(anonymousClass2) != coroutine_suspended) {
                                        str32 = str28;
                                        this.analyticsManager.logEvent(new AnalyticsEvent.TtsUsed(languageEnum17.name(), str32.length()));
                                        return new ResponseResource.Success(Unit.INSTANCE);
                                    }
                                }
                            }
                        } else {
                            str16 = str12;
                            str17 = str13;
                            str18 = str17;
                            languageEnum12 = languageEnum10;
                            languageEnum13 = languageEnum11;
                            i4 = i3;
                            j6 = j5;
                            str19 = str14;
                            str20 = str11;
                            str21 = str15;
                            conversationMessage = new ConversationMessage(0L, j6, "User", str17, str18, languageEnum13, null, 0, languageEnum12, MessageInputType.TYPED, MessageType.TEXT_TO_SPEECH, true, false, System.currentTimeMillis(), 4289, null);
                            j8 = j6;
                            languageEnum16 = languageEnum13;
                            this.textToSpeechManager.stopSpeaking();
                            str26 = str18;
                            TextToSpeechManager.speakText$default(this.textToSpeechManager, str26, LanguageMapper.INSTANCE.toTranscriptionLang(languageEnum16), voice6, 0, 8, null);
                            conversationMessageRepository = this.conversationMessageRepository;
                            str27 = str16;
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                            anonymousClass2.L$1 = languageEnum16;
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice6);
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str19);
                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                            anonymousClass2.L$8 = str26;
                            anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage);
                            anonymousClass2.J$0 = j8;
                            anonymousClass2.I$0 = i4;
                            anonymousClass2.I$1 = i2;
                            anonymousClass2.label = 7;
                            if (conversationMessageRepository.insertConversationMessageWithNextSequenceIdAndGetWithId(conversationMessage, anonymousClass2) != coroutine_suspended) {
                                String str3112 = str19;
                                str28 = str26;
                                conversationMessage2 = conversationMessage;
                                str29 = str3112;
                                voice9 = voice6;
                                languageEnum17 = languageEnum16;
                                str30 = str27;
                                str31 = str17;
                                conversationUsageRepository = this.conversationUsageRepository;
                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str31);
                                anonymousClass2.L$1 = languageEnum17;
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice9);
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str30);
                                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str29);
                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                anonymousClass2.L$8 = str28;
                                anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage2);
                                anonymousClass2.J$0 = j8;
                                anonymousClass2.I$0 = i4;
                                anonymousClass2.I$1 = i2;
                                anonymousClass2.label = 8;
                                if (conversationUsageRepository.incrementTts(anonymousClass2) != coroutine_suspended) {
                                    str32 = str28;
                                    this.analyticsManager.logEvent(new AnalyticsEvent.TtsUsed(languageEnum17.name(), str32.length()));
                                    return new ResponseResource.Success(Unit.INSTANCE);
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                case 5:
                    int i17 = anonymousClass2.I$1;
                    int i18 = anonymousClass2.I$0;
                    long j13 = anonymousClass2.J$0;
                    str11 = (String) anonymousClass2.L$6;
                    str7 = (String) anonymousClass2.L$5;
                    String str46 = (String) anonymousClass2.L$4;
                    Voice voice11 = (Voice) anonymousClass2.L$3;
                    LanguageEnum languageEnum26 = (LanguageEnum) anonymousClass2.L$2;
                    LanguageEnum languageEnum27 = (LanguageEnum) anonymousClass2.L$1;
                    String str47 = (String) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj7);
                    j5 = j13;
                    str12 = str46;
                    str13 = str47;
                    i3 = i18;
                    voice6 = voice11;
                    languageEnum10 = languageEnum26;
                    languageEnum11 = languageEnum27;
                    i2 = i17;
                    obj5 = obj7;
                    str14 = str7;
                    responseResource3 = (ResponseResource) obj5;
                    if (responseResource3 instanceof ResponseResource.Success) {
                        if (responseResource3 instanceof ResponseResource.Error) {
                            return responseResource3;
                        }
                        if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str15 = (String) ((ResponseResource.Success) responseResource3).getData();
                    if (!LangaugeUtilsKt.isTextInLanguage(str13, languageEnum10)) {
                        return new ResponseResource.Error(AppError.LanguageError.INSTANCE);
                    }
                    if (languageEnum10 != languageEnum11) {
                        LtsTranslationRepository ltsTranslationRepository6 = this.ltsTranslationRepository;
                        anonymousClass2.L$0 = str13;
                        anonymousClass2.L$1 = languageEnum11;
                        anonymousClass2.L$2 = languageEnum10;
                        anonymousClass2.L$3 = voice6;
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str12);
                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str14);
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str11);
                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str15);
                        anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str13);
                        anonymousClass2.J$0 = j5;
                        anonymousClass2.I$0 = i3;
                        anonymousClass2.I$1 = i2;
                        anonymousClass2.label = 6;
                        voice7 = voice6;
                        objTranslateBhashini = ltsTranslationRepository6.translateBhashini(str12, str14, str11, str15, str13, languageEnum10, languageEnum11, anonymousClass2);
                        if (objTranslateBhashini == coroutine_suspended) {
                            str22 = str11;
                            str23 = str15;
                            LanguageEnum languageEnum115 = languageEnum11;
                            voice8 = voice7;
                            obj6 = objTranslateBhashini;
                            i5 = i3;
                            languageEnum14 = languageEnum10;
                            str24 = str12;
                            String str3113 = str13;
                            str19 = str14;
                            j7 = j5;
                            str25 = str3113;
                            languageEnum15 = languageEnum115;
                            responseResource4 = (ResponseResource) obj6;
                            i6 = i5;
                            if (!(responseResource4 instanceof ResponseResource.Success)) {
                                if (responseResource4 instanceof ResponseResource.Error) {
                                    return responseResource4;
                                }
                                if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                    return ResponseResource.Loading.INSTANCE;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            str18 = (String) ((ResponseResource.Success) responseResource4).getData();
                            j6 = j7;
                            str16 = str24;
                            voice6 = voice8;
                            languageEnum12 = languageEnum14;
                            languageEnum13 = languageEnum15;
                            str17 = str25;
                            i4 = i6;
                            str21 = str23;
                            str20 = str22;
                            conversationMessage = new ConversationMessage(0L, j6, "User", str17, str18, languageEnum13, null, 0, languageEnum12, MessageInputType.TYPED, MessageType.TEXT_TO_SPEECH, true, false, System.currentTimeMillis(), 4289, null);
                            j8 = j6;
                            languageEnum16 = languageEnum13;
                            this.textToSpeechManager.stopSpeaking();
                            str26 = str18;
                            TextToSpeechManager.speakText$default(this.textToSpeechManager, str26, LanguageMapper.INSTANCE.toTranscriptionLang(languageEnum16), voice6, 0, 8, null);
                            conversationMessageRepository = this.conversationMessageRepository;
                            str27 = str16;
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                            anonymousClass2.L$1 = languageEnum16;
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice6);
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str19);
                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                            anonymousClass2.L$8 = str26;
                            anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage);
                            anonymousClass2.J$0 = j8;
                            anonymousClass2.I$0 = i4;
                            anonymousClass2.I$1 = i2;
                            anonymousClass2.label = 7;
                            if (conversationMessageRepository.insertConversationMessageWithNextSequenceIdAndGetWithId(conversationMessage, anonymousClass2) != coroutine_suspended) {
                                String str3114 = str19;
                                str28 = str26;
                                conversationMessage2 = conversationMessage;
                                str29 = str3114;
                                voice9 = voice6;
                                languageEnum17 = languageEnum16;
                                str30 = str27;
                                str31 = str17;
                                conversationUsageRepository = this.conversationUsageRepository;
                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str31);
                                anonymousClass2.L$1 = languageEnum17;
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice9);
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str30);
                                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str29);
                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                                anonymousClass2.L$8 = str28;
                                anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage2);
                                anonymousClass2.J$0 = j8;
                                anonymousClass2.I$0 = i4;
                                anonymousClass2.I$1 = i2;
                                anonymousClass2.label = 8;
                                if (conversationUsageRepository.incrementTts(anonymousClass2) != coroutine_suspended) {
                                    str32 = str28;
                                    this.analyticsManager.logEvent(new AnalyticsEvent.TtsUsed(languageEnum17.name(), str32.length()));
                                    return new ResponseResource.Success(Unit.INSTANCE);
                                }
                            }
                        }
                    } else {
                        str16 = str12;
                        str17 = str13;
                        str18 = str17;
                        languageEnum12 = languageEnum10;
                        languageEnum13 = languageEnum11;
                        i4 = i3;
                        j6 = j5;
                        str19 = str14;
                        str20 = str11;
                        str21 = str15;
                        conversationMessage = new ConversationMessage(0L, j6, "User", str17, str18, languageEnum13, null, 0, languageEnum12, MessageInputType.TYPED, MessageType.TEXT_TO_SPEECH, true, false, System.currentTimeMillis(), 4289, null);
                        j8 = j6;
                        languageEnum16 = languageEnum13;
                        this.textToSpeechManager.stopSpeaking();
                        str26 = str18;
                        TextToSpeechManager.speakText$default(this.textToSpeechManager, str26, LanguageMapper.INSTANCE.toTranscriptionLang(languageEnum16), voice6, 0, 8, null);
                        conversationMessageRepository = this.conversationMessageRepository;
                        str27 = str16;
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                        anonymousClass2.L$1 = languageEnum16;
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice6);
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str19);
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                        anonymousClass2.L$8 = str26;
                        anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage);
                        anonymousClass2.J$0 = j8;
                        anonymousClass2.I$0 = i4;
                        anonymousClass2.I$1 = i2;
                        anonymousClass2.label = 7;
                        if (conversationMessageRepository.insertConversationMessageWithNextSequenceIdAndGetWithId(conversationMessage, anonymousClass2) != coroutine_suspended) {
                            String str3115 = str19;
                            str28 = str26;
                            conversationMessage2 = conversationMessage;
                            str29 = str3115;
                            voice9 = voice6;
                            languageEnum17 = languageEnum16;
                            str30 = str27;
                            str31 = str17;
                            conversationUsageRepository = this.conversationUsageRepository;
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str31);
                            anonymousClass2.L$1 = languageEnum17;
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice9);
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str30);
                            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str29);
                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                            anonymousClass2.L$8 = str28;
                            anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage2);
                            anonymousClass2.J$0 = j8;
                            anonymousClass2.I$0 = i4;
                            anonymousClass2.I$1 = i2;
                            anonymousClass2.label = 8;
                            if (conversationUsageRepository.incrementTts(anonymousClass2) != coroutine_suspended) {
                                str32 = str28;
                                this.analyticsManager.logEvent(new AnalyticsEvent.TtsUsed(languageEnum17.name(), str32.length()));
                                return new ResponseResource.Success(Unit.INSTANCE);
                            }
                        }
                    }
                    return coroutine_suspended;
                case 6:
                    int i19 = anonymousClass2.I$1;
                    i5 = anonymousClass2.I$0;
                    j7 = anonymousClass2.J$0;
                    str23 = (String) anonymousClass2.L$7;
                    str22 = (String) anonymousClass2.L$6;
                    str19 = (String) anonymousClass2.L$5;
                    str24 = (String) anonymousClass2.L$4;
                    voice8 = (Voice) anonymousClass2.L$3;
                    LanguageEnum languageEnum28 = (LanguageEnum) anonymousClass2.L$2;
                    LanguageEnum languageEnum29 = (LanguageEnum) anonymousClass2.L$1;
                    String str48 = (String) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj7);
                    str25 = str48;
                    languageEnum15 = languageEnum29;
                    languageEnum14 = languageEnum28;
                    i2 = i19;
                    obj6 = obj7;
                    responseResource4 = (ResponseResource) obj6;
                    i6 = i5;
                    if (!(responseResource4 instanceof ResponseResource.Success)) {
                        if (responseResource4 instanceof ResponseResource.Error) {
                            return responseResource4;
                        }
                        if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str18 = (String) ((ResponseResource.Success) responseResource4).getData();
                    j6 = j7;
                    str16 = str24;
                    voice6 = voice8;
                    languageEnum12 = languageEnum14;
                    languageEnum13 = languageEnum15;
                    str17 = str25;
                    i4 = i6;
                    str21 = str23;
                    str20 = str22;
                    conversationMessage = new ConversationMessage(0L, j6, "User", str17, str18, languageEnum13, null, 0, languageEnum12, MessageInputType.TYPED, MessageType.TEXT_TO_SPEECH, true, false, System.currentTimeMillis(), 4289, null);
                    j8 = j6;
                    languageEnum16 = languageEnum13;
                    this.textToSpeechManager.stopSpeaking();
                    str26 = str18;
                    TextToSpeechManager.speakText$default(this.textToSpeechManager, str26, LanguageMapper.INSTANCE.toTranscriptionLang(languageEnum16), voice6, 0, 8, null);
                    conversationMessageRepository = this.conversationMessageRepository;
                    str27 = str16;
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                    anonymousClass2.L$1 = languageEnum16;
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice6);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str19);
                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                    anonymousClass2.L$8 = str26;
                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage);
                    anonymousClass2.J$0 = j8;
                    anonymousClass2.I$0 = i4;
                    anonymousClass2.I$1 = i2;
                    anonymousClass2.label = 7;
                    if (conversationMessageRepository.insertConversationMessageWithNextSequenceIdAndGetWithId(conversationMessage, anonymousClass2) != coroutine_suspended) {
                        String str3116 = str19;
                        str28 = str26;
                        conversationMessage2 = conversationMessage;
                        str29 = str3116;
                        voice9 = voice6;
                        languageEnum17 = languageEnum16;
                        str30 = str27;
                        str31 = str17;
                        conversationUsageRepository = this.conversationUsageRepository;
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str31);
                        anonymousClass2.L$1 = languageEnum17;
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice9);
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str30);
                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str29);
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                        anonymousClass2.L$8 = str28;
                        anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage2);
                        anonymousClass2.J$0 = j8;
                        anonymousClass2.I$0 = i4;
                        anonymousClass2.I$1 = i2;
                        anonymousClass2.label = 8;
                        if (conversationUsageRepository.incrementTts(anonymousClass2) != coroutine_suspended) {
                            str32 = str28;
                            this.analyticsManager.logEvent(new AnalyticsEvent.TtsUsed(languageEnum17.name(), str32.length()));
                            return new ResponseResource.Success(Unit.INSTANCE);
                        }
                    }
                    return coroutine_suspended;
                case 7:
                    int i20 = anonymousClass2.I$1;
                    i4 = anonymousClass2.I$0;
                    j8 = anonymousClass2.J$0;
                    conversationMessage2 = (ConversationMessage) anonymousClass2.L$9;
                    str28 = (String) anonymousClass2.L$8;
                    str21 = (String) anonymousClass2.L$7;
                    str20 = (String) anonymousClass2.L$6;
                    String str49 = (String) anonymousClass2.L$5;
                    String str50 = (String) anonymousClass2.L$4;
                    Voice voice12 = (Voice) anonymousClass2.L$3;
                    LanguageEnum languageEnum30 = (LanguageEnum) anonymousClass2.L$2;
                    LanguageEnum languageEnum31 = (LanguageEnum) anonymousClass2.L$1;
                    String str51 = (String) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj7);
                    languageEnum12 = languageEnum30;
                    voice9 = voice12;
                    str30 = str50;
                    str29 = str49;
                    i2 = i20;
                    languageEnum17 = languageEnum31;
                    str31 = str51;
                    conversationUsageRepository = this.conversationUsageRepository;
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str31);
                    anonymousClass2.L$1 = languageEnum17;
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(languageEnum12);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(voice9);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str30);
                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str29);
                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                    anonymousClass2.L$8 = str28;
                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(conversationMessage2);
                    anonymousClass2.J$0 = j8;
                    anonymousClass2.I$0 = i4;
                    anonymousClass2.I$1 = i2;
                    anonymousClass2.label = 8;
                    if (conversationUsageRepository.incrementTts(anonymousClass2) != coroutine_suspended) {
                        str32 = str28;
                        this.analyticsManager.logEvent(new AnalyticsEvent.TtsUsed(languageEnum17.name(), str32.length()));
                        return new ResponseResource.Success(Unit.INSTANCE);
                    }
                    return coroutine_suspended;
                case 8:
                    int i21 = anonymousClass2.I$1;
                    int i22 = anonymousClass2.I$0;
                    long j14 = anonymousClass2.J$0;
                    str32 = (String) anonymousClass2.L$8;
                    languageEnum17 = (LanguageEnum) anonymousClass2.L$1;
                    ResultKt.throwOnFailure(obj7);
                    this.analyticsManager.logEvent(new AnalyticsEvent.TtsUsed(languageEnum17.name(), str32.length()));
                    return new ResponseResource.Success(Unit.INSTANCE);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e) {
            Log.e(TAG, "Speak message failed", e);
            this.textToSpeechManager.stopSpeaking();
            return new ResponseResource.Error(AppError.UnknownError.INSTANCE);
        }
    }

    /* JADX INFO: compiled from: SpeakAndInsertMessageUseCase.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/SpeakAndInsertMessageUseCase$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
