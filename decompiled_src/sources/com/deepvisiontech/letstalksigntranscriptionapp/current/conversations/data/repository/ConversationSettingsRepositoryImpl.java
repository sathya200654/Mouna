package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository;

import android.content.Context;
import android.util.Log;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import androidx.datastore.preferences.core.PreferencesKt;
import androidx.wear.compose.foundation.SwipeToRevealKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.AppDataStoreKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 52\u00020\u0001:\u000256B\u001d\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010&J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010&J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010)\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010*J\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020$0#H\u0096@¢\u0006\u0002\u0010,J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010.\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010/J\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020$0#H\u0096@¢\u0006\u0002\u0010,J\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020$0#H\u0096@¢\u0006\u0002\u0010,J\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u00103\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u00104R\u0016\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u001c\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013¨\u00067"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/repository/ConversationSettingsRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSettingsRepository;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "context", "Landroid/content/Context;", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Landroid/content/Context;)V", "getIoDispatcher$annotations", "()V", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "_sessionTargetLanguage", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "userLanguage", "Lkotlinx/coroutines/flow/Flow;", "getUserLanguage", "()Lkotlinx/coroutines/flow/Flow;", "speakerLanguage", "getSpeakerLanguage", "conversationMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "getConversationMode", "isSpeakerDetectionEnabled", "", "ttsVoice", "", "getTtsVoice", "conversationTranscriptFontSize", "", "getConversationTranscriptFontSize", "isCorrectionSuggestionsEnabled", "setUserLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "lang", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSpeakerLanguage", "setConversationMode", "mode", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleCorrectionSuggestion", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSelectedVoice", "voiceName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearSelectedVoice", "toggleSpeakerDetection", "setConversationTranscriptFontSize", "size", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "PreferencesKeys", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationSettingsRepositoryImpl implements ConversationSettingsRepository {

    @Deprecated
    public static final String TAG = "ConversationSettingsRepositoryImpl";
    private final MutableStateFlow<LanguageEnum> _sessionTargetLanguage;
    private final Flow<ConversationMode> conversationMode;
    private final Flow<Float> conversationTranscriptFontSize;
    private final DataStore<Preferences> dataStore;
    private final CoroutineDispatcher ioDispatcher;
    private final Flow<Boolean> isCorrectionSuggestionsEnabled;
    private final Flow<Boolean> isSpeakerDetectionEnabled;
    private final Flow<LanguageEnum> speakerLanguage;
    private final Flow<String> ttsVoice;
    private final Flow<LanguageEnum> userLanguage;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private static /* synthetic */ void getIoDispatcher$annotations() {
    }

    @Inject
    public ConversationSettingsRepositoryImpl(CoroutineDispatcher coroutineDispatcher, @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(context, "context");
        this.ioDispatcher = coroutineDispatcher;
        DataStore<Preferences> conversationDataStore = AppDataStoreKt.getConversationDataStore(context);
        this.dataStore = conversationDataStore;
        Flow flowMutableStateFlow = StateFlowKt.MutableStateFlow((Object) null);
        this._sessionTargetLanguage = flowMutableStateFlow;
        final Flow flowCatch = FlowKt.catch(conversationDataStore.getData(), new ConversationSettingsRepositoryImpl$userLanguage$1(null));
        this.userLanguage = FlowKt.flowOn(new Flow<LanguageEnum>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$1$2", f = "ConversationSettingsRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        String str = (String) ((Preferences) obj).get(ConversationSettingsRepositoryImpl.PreferencesKeys.INSTANCE.getINPUT_LANGUAGE());
                        if (str == null) {
                            str = "ENGLISH";
                        }
                        LanguageEnum languageEnumValueOf = LanguageEnum.valueOf(str);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(languageEnumValueOf, anonymousClass1) == coroutine_suspended) {
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
                Object objCollect = flowCatch.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, (CoroutineContext) coroutineDispatcher);
        this.speakerLanguage = FlowKt.flowOn(FlowKt.flowCombine(getUserLanguage(), flowMutableStateFlow, new ConversationSettingsRepositoryImpl$speakerLanguage$1(null)), (CoroutineContext) coroutineDispatcher);
        final Flow flowCatch2 = FlowKt.catch(conversationDataStore.getData(), new ConversationSettingsRepositoryImpl$conversationMode$1(null));
        this.conversationMode = FlowKt.flowOn(new Flow<ConversationMode>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$2

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$2$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$2$2", f = "ConversationSettingsRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        String str = (String) ((Preferences) obj).get(ConversationSettingsRepositoryImpl.PreferencesKeys.INSTANCE.getCONVERSATION_MODE());
                        if (str == null) {
                            str = "ONE_TO_ONE";
                        }
                        ConversationMode conversationModeValueOf = ConversationMode.valueOf(str);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(conversationModeValueOf, anonymousClass1) == coroutine_suspended) {
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
                Object objCollect = flowCatch2.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, (CoroutineContext) coroutineDispatcher);
        final Flow flowCatch3 = FlowKt.catch(conversationDataStore.getData(), new C02091(null));
        this.isSpeakerDetectionEnabled = FlowKt.flowOn(new Flow<Boolean>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$3

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$3$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$3$2", f = "ConversationSettingsRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        Boolean bool = (Boolean) ((Preferences) obj).get(ConversationSettingsRepositoryImpl.PreferencesKeys.INSTANCE.getSPEAKER_DETECTION_STATE());
                        Boolean boolBoxBoolean = Boxing.boxBoolean(bool != null ? bool.booleanValue() : false);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(boolBoxBoolean, anonymousClass1) == coroutine_suspended) {
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
                Object objCollect = flowCatch3.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, (CoroutineContext) coroutineDispatcher);
        final Flow flowCatch4 = FlowKt.catch(conversationDataStore.getData(), new ConversationSettingsRepositoryImpl$ttsVoice$1(null));
        this.ttsVoice = FlowKt.flowOn(new Flow<String>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$4

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$4$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$4$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$4$2", f = "ConversationSettingsRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        Object obj3 = ((Preferences) obj).get(ConversationSettingsRepositoryImpl.PreferencesKeys.INSTANCE.getTTS_VOICE());
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(obj3, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj4 = anonymousClass1.L$2;
                        Object obj5 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowCatch4.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, (CoroutineContext) coroutineDispatcher);
        final Flow flowCatch5 = FlowKt.catch(conversationDataStore.getData(), new ConversationSettingsRepositoryImpl$conversationTranscriptFontSize$1(null));
        this.conversationTranscriptFontSize = FlowKt.flowOn(new Flow<Float>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$5

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$5$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$5$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$5$2", f = "ConversationSettingsRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        Float f = (Float) ((Preferences) obj).get(ConversationSettingsRepositoryImpl.PreferencesKeys.INSTANCE.getCONVERSATION_TRANSCRIPTION_FONT_SIZE());
                        Float fBoxFloat = Boxing.boxFloat(f != null ? f.floatValue() : 16.0f);
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
                Object objCollect = flowCatch5.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, (CoroutineContext) coroutineDispatcher);
        final Flow flowCatch6 = FlowKt.catch(conversationDataStore.getData(), new AnonymousClass1(null));
        this.isCorrectionSuggestionsEnabled = FlowKt.flowOn(new Flow<Boolean>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$6

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$6$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$6$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$special$$inlined$map$6$2", f = "ConversationSettingsRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        Boolean bool = (Boolean) ((Preferences) obj).get(ConversationSettingsRepositoryImpl.PreferencesKeys.INSTANCE.getCORRECTION_SUGGESTION_STATE());
                        Boolean boolBoxBoolean = Boxing.boxBoolean(bool != null ? bool.booleanValue() : true);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(boolBoxBoolean, anonymousClass1) == coroutine_suspended) {
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
                Object objCollect = flowCatch6.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, (CoroutineContext) coroutineDispatcher);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository
    public Flow<LanguageEnum> getUserLanguage() {
        return this.userLanguage;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository
    public Flow<LanguageEnum> getSpeakerLanguage() {
        return this.speakerLanguage;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository
    public Flow<ConversationMode> getConversationMode() {
        return this.conversationMode;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$isSpeakerDetectionEnabled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/datastore/preferences/core/Preferences;", "exception", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$isSpeakerDetectionEnabled$1", f = "ConversationSettingsRepositoryImpl.kt", i = {0, 0}, l = {66}, m = "invokeSuspend", n = {"$this$catch", "exception"}, s = {"L$0", "L$1"})
    static final class C02091 extends SuspendLambda implements Function3<FlowCollector<? super Preferences>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        C02091(Continuation<? super C02091> continuation) {
            super(3, continuation);
        }

        public final Object invoke(FlowCollector<? super Preferences> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            C02091 c02091 = new C02091(continuation);
            c02091.L$0 = flowCollector;
            c02091.L$1 = th;
            return c02091.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Log.e(ConversationSettingsRepositoryImpl.TAG, "Error reading conversation detection flow.", th);
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.L$1 = SpillingKt.nullOutSpilledVariable(th);
                this.label = 1;
                if (flowCollector.emit(PreferencesFactory.createEmpty(), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository
    public Flow<Boolean> isSpeakerDetectionEnabled() {
        return this.isSpeakerDetectionEnabled;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository
    public Flow<String> getTtsVoice() {
        return this.ttsVoice;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository
    public Flow<Float> getConversationTranscriptFontSize() {
        return this.conversationTranscriptFontSize;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$isCorrectionSuggestionsEnabled$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/datastore/preferences/core/Preferences;", "exception", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$isCorrectionSuggestionsEnabled$1", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super Preferences>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
        }

        public final Object invoke(FlowCollector<? super Preferences> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = th;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Throwable th = (Throwable) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Log.e(ConversationSettingsRepositoryImpl.TAG, "Error reading suggestion state.", th);
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository
    public Flow<Boolean> isCorrectionSuggestionsEnabled() {
        return this.isCorrectionSuggestionsEnabled;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setUserLanguage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setUserLanguage$2", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {96, 97}, m = "invokeSuspend", n = {}, s = {})
    static final class C02142 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LanguageEnum $lang;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02142(LanguageEnum languageEnum, Continuation<? super C02142> continuation) {
            super(1, continuation);
            this.$lang = languageEnum;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationSettingsRepositoryImpl.this.new C02142(this.$lang, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
        
            if (androidx.datastore.preferences.core.PreferencesKt.edit(r5.this$0.dataStore, new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl.C02142.AnonymousClass1(r5.$lang, null), (kotlin.coroutines.Continuation) r5) == r0) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L1f
                if (r1 == r4) goto L1b
                if (r1 != r3) goto L13
                kotlin.ResultKt.throwOnFailure(r6)
                goto L4f
            L13:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1b:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L34
            L1f:
                kotlin.ResultKt.throwOnFailure(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl.this
                kotlinx.coroutines.flow.MutableStateFlow r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl.access$get_sessionTargetLanguage$p(r6)
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r4
                java.lang.Object r6 = r6.emit(r2, r1)
                if (r6 != r0) goto L34
                goto L4e
            L34:
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl.this
                androidx.datastore.core.DataStore r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl.access$getDataStore$p(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setUserLanguage$2$1 r1 = new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setUserLanguage$2$1
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum r4 = r5.$lang
                r1.<init>(r4, r2)
                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                r2 = r5
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r5.label = r3
                java.lang.Object r5 = androidx.datastore.preferences.core.PreferencesKt.edit(r6, r1, r2)
                if (r5 != r0) goto L4f
            L4e:
                return r0
            L4f:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl.C02142.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setUserLanguage$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setUserLanguage$2$1", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ LanguageEnum $lang;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(LanguageEnum languageEnum, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$lang = languageEnum;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$lang, continuation);
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
                mutablePreferences.set(PreferencesKeys.INSTANCE.getINPUT_LANGUAGE(), this.$lang.name());
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository
    public Object setUserLanguage(LanguageEnum languageEnum, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02142(languageEnum, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setSpeakerLanguage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setSpeakerLanguage$2", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    static final class C02132 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LanguageEnum $lang;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02132(LanguageEnum languageEnum, Continuation<? super C02132> continuation) {
            super(1, continuation);
            this.$lang = languageEnum;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationSettingsRepositoryImpl.this.new C02132(this.$lang, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ConversationSettingsRepositoryImpl.this._sessionTargetLanguage.emit(this.$lang, (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository
    public Object setSpeakerLanguage(LanguageEnum languageEnum, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02132(languageEnum, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setConversationMode$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setConversationMode$2", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
    static final class C02102 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationMode $mode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02102(ConversationMode conversationMode, Continuation<? super C02102> continuation) {
            super(1, continuation);
            this.$mode = conversationMode;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationSettingsRepositoryImpl.this.new C02102(this.$mode, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setConversationMode$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setConversationMode$2$1", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ ConversationMode $mode;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ConversationMode conversationMode, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$mode = conversationMode;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$mode, continuation);
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
                mutablePreferences.set(PreferencesKeys.INSTANCE.getCONVERSATION_MODE(), this.$mode.name());
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(ConversationSettingsRepositoryImpl.this.dataStore, new AnonymousClass1(this.$mode, null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository
    public Object setConversationMode(ConversationMode conversationMode, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02102(conversationMode, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$toggleCorrectionSuggestion$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$toggleCorrectionSuggestion$2", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
    static final class C02152 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C02152(Continuation<? super C02152> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationSettingsRepositoryImpl.this.new C02152(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$toggleCorrectionSuggestion$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$toggleCorrectionSuggestion$2$1", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
                Boolean bool = (Boolean) mutablePreferences.get(PreferencesKeys.INSTANCE.getCORRECTION_SUGGESTION_STATE());
                mutablePreferences.set(PreferencesKeys.INSTANCE.getCORRECTION_SUGGESTION_STATE(), Boxing.boxBoolean(!(bool != null ? bool.booleanValue() : true)));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(ConversationSettingsRepositoryImpl.this.dataStore, new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository
    public Object toggleCorrectionSuggestion(Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02152(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setSelectedVoice$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setSelectedVoice$2", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
    static final class C02122 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $voiceName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02122(String str, Continuation<? super C02122> continuation) {
            super(1, continuation);
            this.$voiceName = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationSettingsRepositoryImpl.this.new C02122(this.$voiceName, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setSelectedVoice$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setSelectedVoice$2$1", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $voiceName;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$voiceName = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$voiceName, continuation);
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
                mutablePreferences.set(PreferencesKeys.INSTANCE.getTTS_VOICE(), this.$voiceName);
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(ConversationSettingsRepositoryImpl.this.dataStore, new AnonymousClass1(this.$voiceName, null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository
    public Object setSelectedVoice(String str, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02122(str, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$clearSelectedVoice$2, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$clearSelectedVoice$2", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationSettingsRepositoryImpl.this.new AnonymousClass2(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$clearSelectedVoice$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$clearSelectedVoice$2$1", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
                mutablePreferences.remove(PreferencesKeys.INSTANCE.getTTS_VOICE());
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(ConversationSettingsRepositoryImpl.this.dataStore, new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository
    public Object clearSelectedVoice(Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new AnonymousClass2(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$toggleSpeakerDetection$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$toggleSpeakerDetection$2", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
    static final class C02162 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C02162(Continuation<? super C02162> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationSettingsRepositoryImpl.this.new C02162(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$toggleSpeakerDetection$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$toggleSpeakerDetection$2$1", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
                Boolean bool = (Boolean) mutablePreferences.get(PreferencesKeys.INSTANCE.getSPEAKER_DETECTION_STATE());
                mutablePreferences.set(PreferencesKeys.INSTANCE.getSPEAKER_DETECTION_STATE(), Boxing.boxBoolean(!(bool != null ? bool.booleanValue() : false)));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(ConversationSettingsRepositoryImpl.this.dataStore, new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository
    public Object toggleSpeakerDetection(Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02162(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setConversationTranscriptFontSize$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setConversationTranscriptFontSize$2", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
    static final class C02112 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ float $size;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02112(float f, Continuation<? super C02112> continuation) {
            super(1, continuation);
            this.$size = f;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationSettingsRepositoryImpl.this.new C02112(this.$size, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setConversationTranscriptFontSize$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$setConversationTranscriptFontSize$2$1", f = "ConversationSettingsRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ float $size;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(float f, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$size = f;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$size, continuation);
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
                mutablePreferences.set(PreferencesKeys.INSTANCE.getCONVERSATION_TRANSCRIPTION_FONT_SIZE(), Boxing.boxFloat(this.$size));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(ConversationSettingsRepositoryImpl.this.dataStore, new AnonymousClass1(this.$size, null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository
    public Object setConversationTranscriptFontSize(float f, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02112(f, null), continuation, 2, null);
    }

    /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/repository/ConversationSettingsRepositoryImpl$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/repository/ConversationSettingsRepositoryImpl$PreferencesKeys;", "", "<init>", "()V", "INPUT_LANGUAGE", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getINPUT_LANGUAGE", "()Landroidx/datastore/preferences/core/Preferences$Key;", "CONVERSATION_MODE", "getCONVERSATION_MODE", "CONVERSATION_TRANSCRIPTION_FONT_SIZE", "", "getCONVERSATION_TRANSCRIPTION_FONT_SIZE", "SPEAKER_DETECTION_STATE", "", "getSPEAKER_DETECTION_STATE", "CORRECTION_SUGGESTION_STATE", "getCORRECTION_SUGGESTION_STATE", "TTS_VOICE", "getTTS_VOICE", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class PreferencesKeys {
        public static final PreferencesKeys INSTANCE = new PreferencesKeys();
        private static final Preferences.Key<String> INPUT_LANGUAGE = androidx.datastore.preferences.core.PreferencesKeys.stringKey("input_language");
        private static final Preferences.Key<String> CONVERSATION_MODE = androidx.datastore.preferences.core.PreferencesKeys.stringKey("conversation_mode");
        private static final Preferences.Key<Float> CONVERSATION_TRANSCRIPTION_FONT_SIZE = androidx.datastore.preferences.core.PreferencesKeys.floatKey("conversation_transcription_font_size");
        private static final Preferences.Key<Boolean> SPEAKER_DETECTION_STATE = androidx.datastore.preferences.core.PreferencesKeys.booleanKey("speaker_detection_sate");
        private static final Preferences.Key<Boolean> CORRECTION_SUGGESTION_STATE = androidx.datastore.preferences.core.PreferencesKeys.booleanKey("correction_suggestion_state");
        private static final Preferences.Key<String> TTS_VOICE = androidx.datastore.preferences.core.PreferencesKeys.stringKey("tts_voice");

        private PreferencesKeys() {
        }

        public final Preferences.Key<String> getINPUT_LANGUAGE() {
            return INPUT_LANGUAGE;
        }

        public final Preferences.Key<String> getCONVERSATION_MODE() {
            return CONVERSATION_MODE;
        }

        public final Preferences.Key<Float> getCONVERSATION_TRANSCRIPTION_FONT_SIZE() {
            return CONVERSATION_TRANSCRIPTION_FONT_SIZE;
        }

        public final Preferences.Key<Boolean> getSPEAKER_DETECTION_STATE() {
            return SPEAKER_DETECTION_STATE;
        }

        public final Preferences.Key<Boolean> getCORRECTION_SUGGESTION_STATE() {
            return CORRECTION_SUGGESTION_STATE;
        }

        public final Preferences.Key<String> getTTS_VOICE() {
            return TTS_VOICE;
        }
    }
}
