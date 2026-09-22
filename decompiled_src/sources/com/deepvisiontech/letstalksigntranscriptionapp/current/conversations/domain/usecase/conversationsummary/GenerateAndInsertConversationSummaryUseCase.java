package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsummary;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.LtsTranslationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository;
import com.google.protobuf.DescriptorProtos;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GenerateAndInsertConversationSummaryUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ2\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0086B¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsummary/GenerateAndInsertConversationSummaryUseCase;", "", "conversationMessageRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationMessageRepository;", "conversationUsageRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationUsageRepository;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "ltsTranslationRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/LtsTranslationRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationMessageRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationUsageRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/LtsTranslationRepository;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "conversationId", "", "messages", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "targetLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "(JLjava/util/List;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GenerateAndInsertConversationSummaryUseCase {
    public static final int $stable = AnalyticsManager.$stable;
    private final AnalyticsManager analyticsManager;
    private final ConversationMessageRepository conversationMessageRepository;
    private final ConversationUsageRepository conversationUsageRepository;
    private final LtsTranslationRepository ltsTranslationRepository;
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsummary.GenerateAndInsertConversationSummaryUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GenerateAndInsertConversationSummaryUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsummary.GenerateAndInsertConversationSummaryUseCase", f = "GenerateAndInsertConversationSummaryUseCase.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}, l = {33, DescriptorProtos.MethodOptions.IDEMPOTENCY_LEVEL_FIELD_NUMBER, 47, 48, 49, 51, 59, 66, 89}, m = "invoke", n = {"messages", "targetLanguage", "conversationId", "messages", "targetLanguage", "conversationId", "limit", "messages", "targetLanguage", "messageString", "customerId", "conversationId", "limit", "current", "messages", "targetLanguage", "messageString", "customerId", "deviceId", "conversationId", "limit", "current", "messages", "targetLanguage", "messageString", "customerId", "deviceId", "gmailId", "conversationId", "limit", "current", "messages", "targetLanguage", "messageString", "customerId", "deviceId", "gmailId", "token", "conversationId", "limit", "current", "messages", "targetLanguage", "messageString", "customerId", "deviceId", "gmailId", "token", "summaryText", "conversationId", "limit", "current", "messages", "targetLanguage", "messageString", "customerId", "deviceId", "gmailId", "token", "summaryText", "conversationId", "limit", "current", "messages", "targetLanguage", "messageString", "customerId", "deviceId", "gmailId", "token", "summaryText", "finalMessageText", "summaryMessage", "conversationId", "limit", "current"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "J$0", "I$0", "I$1"})
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
            return GenerateAndInsertConversationSummaryUseCase.this.invoke(0L, null, null, (Continuation) this);
        }
    }

    @Inject
    public GenerateAndInsertConversationSummaryUseCase(ConversationMessageRepository conversationMessageRepository, ConversationUsageRepository conversationUsageRepository, SessionRepository sessionRepository, AnalyticsManager analyticsManager, LtsTranslationRepository ltsTranslationRepository) {
        Intrinsics.checkNotNullParameter(conversationMessageRepository, "conversationMessageRepository");
        Intrinsics.checkNotNullParameter(conversationUsageRepository, "conversationUsageRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        Intrinsics.checkNotNullParameter(ltsTranslationRepository, "ltsTranslationRepository");
        this.conversationMessageRepository = conversationMessageRepository;
        this.conversationUsageRepository = conversationUsageRepository;
        this.sessionRepository = sessionRepository;
        this.analyticsManager = analyticsManager;
        this.ltsTranslationRepository = ltsTranslationRepository;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x049d  */
    /* JADX WARN: Code duplicated, block: B:102:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:104:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:106:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:108:0x04b4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:109:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:111:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:113:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:115:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:117:0x04cc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:118:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:120:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:122:0x04da  */
    /* JADX WARN: Code duplicated, block: B:124:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:126:0x04e4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:127:0x04e5  */
    /* JADX WARN: Code duplicated, block: B:129:0x04ed  */
    /* JADX WARN: Code duplicated, block: B:131:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:133:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:135:0x04fc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:136:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:138:0x0505  */
    /* JADX WARN: Code duplicated, block: B:140:0x050a  */
    /* JADX WARN: Code duplicated, block: B:142:0x0510  */
    /* JADX WARN: Code duplicated, block: B:144:0x0514 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:145:0x0515  */
    /* JADX WARN: Code duplicated, block: B:147:0x051d  */
    /* JADX WARN: Code duplicated, block: B:149:0x0522  */
    /* JADX WARN: Code duplicated, block: B:151:0x0528  */
    /* JADX WARN: Code duplicated, block: B:153:0x052c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:154:0x052d  */
    /* JADX WARN: Code duplicated, block: B:156:0x0535  */
    /* JADX WARN: Code duplicated, block: B:158:0x053a  */
    /* JADX WARN: Code duplicated, block: B:30:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:33:0x01de  */
    /* JADX WARN: Code duplicated, block: B:35:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:37:0x020b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0215  */
    /* JADX WARN: Code duplicated, block: B:41:0x021f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0246  */
    /* JADX WARN: Code duplicated, block: B:47:0x0252  */
    /* JADX WARN: Code duplicated, block: B:50:0x027b  */
    /* JADX WARN: Code duplicated, block: B:53:0x028c  */
    /* JADX WARN: Code duplicated, block: B:56:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:59:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:62:0x0305  */
    /* JADX WARN: Code duplicated, block: B:65:0x0317  */
    /* JADX WARN: Code duplicated, block: B:68:0x034c  */
    /* JADX WARN: Code duplicated, block: B:71:0x0362  */
    /* JADX WARN: Code duplicated, block: B:73:0x037d  */
    /* JADX WARN: Code duplicated, block: B:74:0x038d  */
    /* JADX WARN: Code duplicated, block: B:77:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:97:0x0498  */
    /* JADX WARN: Code duplicated, block: B:99:0x049c A[RETURN] */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x046a, code lost:
    
        if (r1 == r2) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(long r35, java.util.List<com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage> r37, com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum r38, kotlin.coroutines.Continuation<? super com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource<kotlin.Unit>> r39) {
        /*
            Method dump skipped, instruction units count: 1368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsummary.GenerateAndInsertConversationSummaryUseCase.invoke(long, java.util.List, com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence invoke$lambda$0(ConversationMessage conversationMessage) {
        Intrinsics.checkNotNullParameter(conversationMessage, "it");
        return conversationMessage.getUserName() + " " + conversationMessage.getProcessedMessage();
    }
}
