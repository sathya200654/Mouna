package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository;

import android.content.Context;
import android.util.Log;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import androidx.wear.compose.foundation.SwipeToRevealKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.AppDataStoreKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationUsageApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.usage.ConversationUsageRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.usage.ConversationUsageResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.Calendar;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u0000 62\u00020\u0001:\u000523456B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u0016J4\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u0016J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010$\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010%J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0096@¢\u0006\u0002\u0010'J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0096@¢\u0006\u0002\u0010'J\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0096@¢\u0006\u0002\u0010'J\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0096@¢\u0006\u0002\u0010'J\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0096@¢\u0006\u0002\u0010'J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002J\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0096@¢\u0006\u0002\u0010'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/repository/ConversationUsageRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationUsageRepository;", "context", "Landroid/content/Context;", "conversationUsageApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationUsageApi;", "<init>", "(Landroid/content/Context;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationUsageApi;)V", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "getAllowedTranscriptionMsLimit", "Lkotlinx/coroutines/flow/Flow;", "", "getAllowedConversationSummaryLimit", "", "getAllowedArticleSummaryLimit", "getAllowedScanLimit", "getAllowedTtsLimit", "getAllowedTypedInterpretationLimit", "syncAllowedLimitsWithNetwork", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "deviceId", "", "gmailId", "customerId", "token", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentTranscriptionMs", "getCurrentConversationSummary", "getCurrentArticleSummary", "getCurrentScan", "getCurrentTts", "getCurrentTypedInterpretation", "incrementTranscriptionMs", "usedMs", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementConversationSummary", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementArticleSummary", "incrementScan", "incrementTts", "incrementTypedInterpretation", "isSameDay", "", "time1", "", "time2", "checkAndResetDailyUsageIfNeeded", "AllowedKeys", "CurrentUsageKeys", "Defaults", "InternalKeys", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationUsageRepositoryImpl implements ConversationUsageRepository {
    private static final String TAG = "ConversationUsageRepositoryImpl";
    private final ConversationUsageApi conversationUsageApi;
    private final DataStore<Preferences> dataStore;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @Inject
    public ConversationUsageRepositoryImpl(@ApplicationContext Context context, ConversationUsageApi conversationUsageApi) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(conversationUsageApi, "conversationUsageApi");
        this.conversationUsageApi = conversationUsageApi;
        this.dataStore = AppDataStoreKt.getConversationUsageDataStore(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/repository/ConversationUsageRepositoryImpl$AllowedKeys;", "", "<init>", "()V", "TRANSCRIPTION_MS", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getTRANSCRIPTION_MS", "()Landroidx/datastore/preferences/core/Preferences$Key;", "CONVERSATION_SUMMARY", "", "getCONVERSATION_SUMMARY", "ARTICLE_SUMMARY", "getARTICLE_SUMMARY", "SCAN", "getSCAN", "TTS", "getTTS", "TYPED_INTERPRETATION", "getTYPED_INTERPRETATION", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class AllowedKeys {
        public static final AllowedKeys INSTANCE = new AllowedKeys();
        private static final Preferences.Key<Float> TRANSCRIPTION_MS = PreferencesKeys.floatKey("allowed_transcription_ms");
        private static final Preferences.Key<Integer> CONVERSATION_SUMMARY = PreferencesKeys.intKey("allowed_conversation_summary");
        private static final Preferences.Key<Integer> ARTICLE_SUMMARY = PreferencesKeys.intKey("allowed_article_summary");
        private static final Preferences.Key<Integer> SCAN = PreferencesKeys.intKey("allowed_scan");
        private static final Preferences.Key<Integer> TTS = PreferencesKeys.intKey("allowed_tts");
        private static final Preferences.Key<Integer> TYPED_INTERPRETATION = PreferencesKeys.intKey("allowed_typed_interpretation");

        private AllowedKeys() {
        }

        public final Preferences.Key<Float> getTRANSCRIPTION_MS() {
            return TRANSCRIPTION_MS;
        }

        public final Preferences.Key<Integer> getCONVERSATION_SUMMARY() {
            return CONVERSATION_SUMMARY;
        }

        public final Preferences.Key<Integer> getARTICLE_SUMMARY() {
            return ARTICLE_SUMMARY;
        }

        public final Preferences.Key<Integer> getSCAN() {
            return SCAN;
        }

        public final Preferences.Key<Integer> getTTS() {
            return TTS;
        }

        public final Preferences.Key<Integer> getTYPED_INTERPRETATION() {
            return TYPED_INTERPRETATION;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/repository/ConversationUsageRepositoryImpl$CurrentUsageKeys;", "", "<init>", "()V", "TRANSCRIPTION_MS", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getTRANSCRIPTION_MS", "()Landroidx/datastore/preferences/core/Preferences$Key;", "CONVERSATION_SUMMARY", "", "getCONVERSATION_SUMMARY", "ARTICLE_SUMMARY", "getARTICLE_SUMMARY", "SCAN", "getSCAN", "TTS", "getTTS", "TYPED_INTERPRETATION", "getTYPED_INTERPRETATION", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class CurrentUsageKeys {
        public static final CurrentUsageKeys INSTANCE = new CurrentUsageKeys();
        private static final Preferences.Key<Float> TRANSCRIPTION_MS = PreferencesKeys.floatKey("current_transcription_ms");
        private static final Preferences.Key<Integer> CONVERSATION_SUMMARY = PreferencesKeys.intKey("current_conversation_summary");
        private static final Preferences.Key<Integer> ARTICLE_SUMMARY = PreferencesKeys.intKey("current_article_summary");
        private static final Preferences.Key<Integer> SCAN = PreferencesKeys.intKey("current_scan");
        private static final Preferences.Key<Integer> TTS = PreferencesKeys.intKey("current_tts");
        private static final Preferences.Key<Integer> TYPED_INTERPRETATION = PreferencesKeys.intKey("current_typed_interpretation");

        private CurrentUsageKeys() {
        }

        public final Preferences.Key<Float> getTRANSCRIPTION_MS() {
            return TRANSCRIPTION_MS;
        }

        public final Preferences.Key<Integer> getCONVERSATION_SUMMARY() {
            return CONVERSATION_SUMMARY;
        }

        public final Preferences.Key<Integer> getARTICLE_SUMMARY() {
            return ARTICLE_SUMMARY;
        }

        public final Preferences.Key<Integer> getSCAN() {
            return SCAN;
        }

        public final Preferences.Key<Integer> getTTS() {
            return TTS;
        }

        public final Preferences.Key<Integer> getTYPED_INTERPRETATION() {
            return TYPED_INTERPRETATION;
        }
    }

    /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/repository/ConversationUsageRepositoryImpl$Defaults;", "", "<init>", "()V", "TRANSCRIPTION_MS", "", "CONVERSATION_SUMMARY", "", "ARTICLE_SUMMARY", "SCAN", "TTS", "TYPED_INTERPRETATION", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Defaults {
        public static final int ARTICLE_SUMMARY = 5;
        public static final int CONVERSATION_SUMMARY = 5;
        public static final Defaults INSTANCE = new Defaults();
        public static final int SCAN = 5;
        public static final float TRANSCRIPTION_MS = 1.44E7f;
        public static final int TTS = 25;
        public static final int TYPED_INTERPRETATION = 25;

        private Defaults() {
        }
    }

    /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/repository/ConversationUsageRepositoryImpl$InternalKeys;", "", "<init>", "()V", "LAST_RESET_TIMESTAMP", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getLAST_RESET_TIMESTAMP", "()Landroidx/datastore/preferences/core/Preferences$Key;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class InternalKeys {
        public static final InternalKeys INSTANCE = new InternalKeys();
        private static final Preferences.Key<Long> LAST_RESET_TIMESTAMP = PreferencesKeys.longKey("last_reset_timestamp");

        private InternalKeys() {
        }

        public final Preferences.Key<Long> getLAST_RESET_TIMESTAMP() {
            return LAST_RESET_TIMESTAMP;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Flow<Float> getAllowedTranscriptionMsLimit() {
        final Flow data = this.dataStore.getData();
        return new Flow<Float>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedTranscriptionMsLimit$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedTranscriptionMsLimit$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedTranscriptionMsLimit$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedTranscriptionMsLimit$$inlined$map$1$2", f = "ConversationUsageRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Float f = (Float) ((Preferences) obj).get(ConversationUsageRepositoryImpl.AllowedKeys.INSTANCE.getTRANSCRIPTION_MS());
                        Float fBoxFloat = Boxing.boxFloat(f != null ? f.floatValue() : 1.44E7f);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(fBoxFloat, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Flow<Integer> getAllowedConversationSummaryLimit() {
        final Flow data = this.dataStore.getData();
        return new Flow<Integer>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedConversationSummaryLimit$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedConversationSummaryLimit$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedConversationSummaryLimit$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedConversationSummaryLimit$$inlined$map$1$2", f = "ConversationUsageRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Integer num = (Integer) ((Preferences) obj).get(ConversationUsageRepositoryImpl.AllowedKeys.INSTANCE.getCONVERSATION_SUMMARY());
                        Integer numBoxInt = Boxing.boxInt(num != null ? num.intValue() : 5);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(numBoxInt, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Flow<Integer> getAllowedArticleSummaryLimit() {
        final Flow data = this.dataStore.getData();
        return new Flow<Integer>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedArticleSummaryLimit$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedArticleSummaryLimit$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedArticleSummaryLimit$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedArticleSummaryLimit$$inlined$map$1$2", f = "ConversationUsageRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Integer num = (Integer) ((Preferences) obj).get(ConversationUsageRepositoryImpl.AllowedKeys.INSTANCE.getARTICLE_SUMMARY());
                        Integer numBoxInt = Boxing.boxInt(num != null ? num.intValue() : 5);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(numBoxInt, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Flow<Integer> getAllowedScanLimit() {
        final Flow data = this.dataStore.getData();
        return new Flow<Integer>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedScanLimit$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedScanLimit$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedScanLimit$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedScanLimit$$inlined$map$1$2", f = "ConversationUsageRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Integer num = (Integer) ((Preferences) obj).get(ConversationUsageRepositoryImpl.AllowedKeys.INSTANCE.getSCAN());
                        Integer numBoxInt = Boxing.boxInt(num != null ? num.intValue() : 5);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(numBoxInt, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Flow<Integer> getAllowedTtsLimit() {
        final Flow data = this.dataStore.getData();
        return new Flow<Integer>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedTtsLimit$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedTtsLimit$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedTtsLimit$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedTtsLimit$$inlined$map$1$2", f = "ConversationUsageRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Integer num = (Integer) ((Preferences) obj).get(ConversationUsageRepositoryImpl.AllowedKeys.INSTANCE.getTTS());
                        Integer numBoxInt = Boxing.boxInt(num != null ? num.intValue() : 25);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(numBoxInt, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Flow<Integer> getAllowedTypedInterpretationLimit() {
        final Flow data = this.dataStore.getData();
        return new Flow<Integer>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedTypedInterpretationLimit$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedTypedInterpretationLimit$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedTypedInterpretationLimit$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getAllowedTypedInterpretationLimit$$inlined$map$1$2", f = "ConversationUsageRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Integer num = (Integer) ((Preferences) obj).get(ConversationUsageRepositoryImpl.AllowedKeys.INSTANCE.getTYPED_INTERPRETATION());
                        Integer numBoxInt = Boxing.boxInt(num != null ? num.intValue() : 25);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(numBoxInt, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Object syncAllowedLimitsWithNetwork(String str, String str2, String str3, String str4, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.api$default(SafeCall.INSTANCE, TAG, null, new C02322(str, str2, str3, str4, null), new AnonymousClass3(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$syncAllowedLimitsWithNetwork$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/usage/ConversationUsageResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$syncAllowedLimitsWithNetwork$2", f = "ConversationUsageRepositoryImpl.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    static final class C02322 extends SuspendLambda implements Function1<Continuation<? super ConversationUsageResponse>, Object> {
        final /* synthetic */ String $customerId;
        final /* synthetic */ String $deviceId;
        final /* synthetic */ String $gmailId;
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02322(String str, String str2, String str3, String str4, Continuation<? super C02322> continuation) {
            super(1, continuation);
            this.$deviceId = str;
            this.$gmailId = str2;
            this.$customerId = str3;
            this.$token = str4;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationUsageRepositoryImpl.this.new C02322(this.$deviceId, this.$gmailId, this.$customerId, this.$token, continuation);
        }

        public final Object invoke(Continuation<? super ConversationUsageResponse> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objFetchUsageLimits = ConversationUsageRepositoryImpl.this.conversationUsageApi.fetchUsageLimits(new ConversationUsageRequest(this.$deviceId, this.$gmailId, this.$customerId, this.$token), (Continuation) this);
            return objFetchUsageLimits == coroutine_suspended ? coroutine_suspended : objFetchUsageLimits;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$syncAllowedLimitsWithNetwork$3, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "response", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/usage/ConversationUsageResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$syncAllowedLimitsWithNetwork$3", f = "ConversationUsageRepositoryImpl.kt", i = {0, 0}, l = {100}, m = "invokeSuspend", n = {"response", "transcriptionMs"}, s = {"L$0", "F$0"})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<ConversationUsageResponse, Continuation<? super Unit>, Object> {
        float F$0;
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass3 = ConversationUsageRepositoryImpl.this.new AnonymousClass3(continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        public final Object invoke(ConversationUsageResponse conversationUsageResponse, Continuation<? super Unit> continuation) {
            return create(conversationUsageResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            ConversationUsageResponse conversationUsageResponse = (ConversationUsageResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float f = 60;
                float sessionTimeHours = conversationUsageResponse.getSessionTimeHours() * f * f * 1000;
                this.L$0 = SpillingKt.nullOutSpilledVariable(conversationUsageResponse);
                this.F$0 = sessionTimeHours;
                this.label = 1;
                if (PreferencesKt.edit(ConversationUsageRepositoryImpl.this.dataStore, new AnonymousClass1(sessionTimeHours, conversationUsageResponse, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$syncAllowedLimitsWithNetwork$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$syncAllowedLimitsWithNetwork$3$1", f = "ConversationUsageRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ ConversationUsageResponse $response;
            final /* synthetic */ float $transcriptionMs;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(float f, ConversationUsageResponse conversationUsageResponse, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$transcriptionMs = f;
                this.$response = conversationUsageResponse;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$transcriptionMs, this.$response, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
                return create(mutablePreferences, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(AllowedKeys.INSTANCE.getTRANSCRIPTION_MS(), Boxing.boxFloat(this.$transcriptionMs));
                mutablePreferences.set(AllowedKeys.INSTANCE.getCONVERSATION_SUMMARY(), Boxing.boxInt(this.$response.getSummaryLimit()));
                mutablePreferences.set(AllowedKeys.INSTANCE.getARTICLE_SUMMARY(), Boxing.boxInt(this.$response.getArticleSummaryLimit()));
                mutablePreferences.set(AllowedKeys.INSTANCE.getSCAN(), Boxing.boxInt(this.$response.getScanLimit()));
                mutablePreferences.set(AllowedKeys.INSTANCE.getTTS(), Boxing.boxInt(this.$response.getTtsLimit()));
                mutablePreferences.set(AllowedKeys.INSTANCE.getTYPED_INTERPRETATION(), Boxing.boxInt(this.$response.getTypedInterpretationLimit()));
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Flow<Float> getCurrentTranscriptionMs() {
        final Flow data = this.dataStore.getData();
        return new Flow<Float>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentTranscriptionMs$$inlined$map$1
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentTranscriptionMs$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentTranscriptionMs$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentTranscriptionMs$$inlined$map$1$2", f = "ConversationUsageRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Float f = (Float) ((Preferences) obj).get(ConversationUsageRepositoryImpl.CurrentUsageKeys.INSTANCE.getTRANSCRIPTION_MS());
                        Float fBoxFloat = Boxing.boxFloat(f != null ? f.floatValue() : 0.0f);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(fBoxFloat, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Flow<Integer> getCurrentConversationSummary() {
        final Flow data = this.dataStore.getData();
        return new Flow<Integer>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentConversationSummary$$inlined$map$1
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentConversationSummary$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentConversationSummary$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentConversationSummary$$inlined$map$1$2", f = "ConversationUsageRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Integer num = (Integer) ((Preferences) obj).get(ConversationUsageRepositoryImpl.CurrentUsageKeys.INSTANCE.getCONVERSATION_SUMMARY());
                        Integer numBoxInt = Boxing.boxInt(num != null ? num.intValue() : 0);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(numBoxInt, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Flow<Integer> getCurrentArticleSummary() {
        final Flow data = this.dataStore.getData();
        return new Flow<Integer>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentArticleSummary$$inlined$map$1
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentArticleSummary$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentArticleSummary$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentArticleSummary$$inlined$map$1$2", f = "ConversationUsageRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Integer num = (Integer) ((Preferences) obj).get(ConversationUsageRepositoryImpl.CurrentUsageKeys.INSTANCE.getARTICLE_SUMMARY());
                        Integer numBoxInt = Boxing.boxInt(num != null ? num.intValue() : 0);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(numBoxInt, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Flow<Integer> getCurrentScan() {
        final Flow data = this.dataStore.getData();
        return new Flow<Integer>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentScan$$inlined$map$1
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentScan$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentScan$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentScan$$inlined$map$1$2", f = "ConversationUsageRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Integer num = (Integer) ((Preferences) obj).get(ConversationUsageRepositoryImpl.CurrentUsageKeys.INSTANCE.getSCAN());
                        Integer numBoxInt = Boxing.boxInt(num != null ? num.intValue() : 0);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(numBoxInt, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Flow<Integer> getCurrentTts() {
        final Flow data = this.dataStore.getData();
        return new Flow<Integer>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentTts$$inlined$map$1
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentTts$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentTts$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentTts$$inlined$map$1$2", f = "ConversationUsageRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Integer num = (Integer) ((Preferences) obj).get(ConversationUsageRepositoryImpl.CurrentUsageKeys.INSTANCE.getTTS());
                        Integer numBoxInt = Boxing.boxInt(num != null ? num.intValue() : 0);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(numBoxInt, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Flow<Integer> getCurrentTypedInterpretation() {
        final Flow data = this.dataStore.getData();
        return new Flow<Integer>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentTypedInterpretation$$inlined$map$1
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentTypedInterpretation$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentTypedInterpretation$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$getCurrentTypedInterpretation$$inlined$map$1$2", f = "ConversationUsageRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Integer num = (Integer) ((Preferences) obj).get(ConversationUsageRepositoryImpl.CurrentUsageKeys.INSTANCE.getTYPED_INTERPRETATION());
                        Integer numBoxInt = Boxing.boxInt(num != null ? num.intValue() : 0);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(numBoxInt, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        };
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementTranscriptionMs$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementTranscriptionMs$2", f = "ConversationUsageRepositoryImpl.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, s = {})
    static final class C02292 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ float $usedMs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02292(float f, Continuation<? super C02292> continuation) {
            super(1, continuation);
            this.$usedMs = f;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationUsageRepositoryImpl.this.new C02292(this.$usedMs, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementTranscriptionMs$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementTranscriptionMs$2$1", f = "ConversationUsageRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ float $usedMs;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(float f, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$usedMs = f;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$usedMs, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
                return create(mutablePreferences, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Float f = (Float) mutablePreferences.get(CurrentUsageKeys.INSTANCE.getTRANSCRIPTION_MS());
                mutablePreferences.set(CurrentUsageKeys.INSTANCE.getTRANSCRIPTION_MS(), Boxing.boxFloat((f != null ? f.floatValue() : 0.0f) + this.$usedMs));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(ConversationUsageRepositoryImpl.this.dataStore, new AnonymousClass1(this.$usedMs, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Object incrementTranscriptionMs(float f, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02292(f, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementConversationSummary$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementConversationSummary$2", f = "ConversationUsageRepositoryImpl.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
    static final class C02272 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C02272(Continuation<? super C02272> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationUsageRepositoryImpl.this.new C02272(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementConversationSummary$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementConversationSummary$2$1", f = "ConversationUsageRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
                return create(mutablePreferences, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Integer num = (Integer) mutablePreferences.get(CurrentUsageKeys.INSTANCE.getCONVERSATION_SUMMARY());
                mutablePreferences.set(CurrentUsageKeys.INSTANCE.getCONVERSATION_SUMMARY(), Boxing.boxInt((num != null ? num.intValue() : 0) + 1));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(ConversationUsageRepositoryImpl.this.dataStore, new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Object incrementConversationSummary(Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02272(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementArticleSummary$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementArticleSummary$2", f = "ConversationUsageRepositoryImpl.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
    static final class C02262 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C02262(Continuation<? super C02262> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationUsageRepositoryImpl.this.new C02262(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementArticleSummary$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementArticleSummary$2$1", f = "ConversationUsageRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
                return create(mutablePreferences, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Integer num = (Integer) mutablePreferences.get(CurrentUsageKeys.INSTANCE.getARTICLE_SUMMARY());
                mutablePreferences.set(CurrentUsageKeys.INSTANCE.getARTICLE_SUMMARY(), Boxing.boxInt((num != null ? num.intValue() : 0) + 1));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(ConversationUsageRepositoryImpl.this.dataStore, new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Object incrementArticleSummary(Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02262(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementScan$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementScan$2", f = "ConversationUsageRepositoryImpl.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
    static final class C02282 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C02282(Continuation<? super C02282> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationUsageRepositoryImpl.this.new C02282(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementScan$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementScan$2$1", f = "ConversationUsageRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
                return create(mutablePreferences, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Integer num = (Integer) mutablePreferences.get(CurrentUsageKeys.INSTANCE.getSCAN());
                mutablePreferences.set(CurrentUsageKeys.INSTANCE.getSCAN(), Boxing.boxInt((num != null ? num.intValue() : 0) + 1));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(ConversationUsageRepositoryImpl.this.dataStore, new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Object incrementScan(Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02282(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementTts$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementTts$2", f = "ConversationUsageRepositoryImpl.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
    static final class C02302 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C02302(Continuation<? super C02302> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationUsageRepositoryImpl.this.new C02302(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementTts$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementTts$2$1", f = "ConversationUsageRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
                return create(mutablePreferences, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Integer num = (Integer) mutablePreferences.get(CurrentUsageKeys.INSTANCE.getTTS());
                mutablePreferences.set(CurrentUsageKeys.INSTANCE.getTTS(), Boxing.boxInt((num != null ? num.intValue() : 0) + 1));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(ConversationUsageRepositoryImpl.this.dataStore, new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Object incrementTts(Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02302(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementTypedInterpretation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementTypedInterpretation$2", f = "ConversationUsageRepositoryImpl.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
    static final class C02312 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C02312(Continuation<? super C02312> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationUsageRepositoryImpl.this.new C02312(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementTypedInterpretation$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$incrementTypedInterpretation$2$1", f = "ConversationUsageRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
                return create(mutablePreferences, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Integer num = (Integer) mutablePreferences.get(CurrentUsageKeys.INSTANCE.getTYPED_INTERPRETATION());
                mutablePreferences.set(CurrentUsageKeys.INSTANCE.getTYPED_INTERPRETATION(), Boxing.boxInt((num != null ? num.intValue() : 0) + 1));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(ConversationUsageRepositoryImpl.this.dataStore, new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Object incrementTypedInterpretation(Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02312(null), continuation, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSameDay(long time1, long time2) {
        if (time1 == 0) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(time2);
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$checkAndResetDailyUsageIfNeeded$2, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$checkAndResetDailyUsageIfNeeded$2", f = "ConversationUsageRepositoryImpl.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationUsageRepositoryImpl.this.new AnonymousClass2(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$checkAndResetDailyUsageIfNeeded$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl$checkAndResetDailyUsageIfNeeded$2$1", f = "ConversationUsageRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ConversationUsageRepositoryImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ConversationUsageRepositoryImpl conversationUsageRepositoryImpl, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = conversationUsageRepositoryImpl;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
                return create(mutablePreferences, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Long l = (Long) mutablePreferences.get(InternalKeys.INSTANCE.getLAST_RESET_TIMESTAMP());
                long jLongValue = l != null ? l.longValue() : 0L;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (!this.this$0.isSameDay(jLongValue, jCurrentTimeMillis)) {
                    mutablePreferences.set(CurrentUsageKeys.INSTANCE.getTRANSCRIPTION_MS(), Boxing.boxFloat(0.0f));
                    mutablePreferences.set(CurrentUsageKeys.INSTANCE.getCONVERSATION_SUMMARY(), Boxing.boxInt(0));
                    mutablePreferences.set(CurrentUsageKeys.INSTANCE.getARTICLE_SUMMARY(), Boxing.boxInt(0));
                    mutablePreferences.set(CurrentUsageKeys.INSTANCE.getSCAN(), Boxing.boxInt(0));
                    mutablePreferences.set(CurrentUsageKeys.INSTANCE.getTTS(), Boxing.boxInt(0));
                    mutablePreferences.set(CurrentUsageKeys.INSTANCE.getTYPED_INTERPRETATION(), Boxing.boxInt(0));
                    mutablePreferences.set(InternalKeys.INSTANCE.getLAST_RESET_TIMESTAMP(), Boxing.boxLong(jCurrentTimeMillis));
                    Log.d(ConversationUsageRepositoryImpl.TAG, "Daily limits have been reset.");
                }
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(ConversationUsageRepositoryImpl.this.dataStore, new AnonymousClass1(ConversationUsageRepositoryImpl.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository
    public Object checkAndResetDailyUsageIfNeeded(Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new AnonymousClass2(null), continuation, 2, null);
    }

    /* JADX INFO: compiled from: ConversationUsageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/repository/ConversationUsageRepositoryImpl$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
