package com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository;

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
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationSpeed;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: SettingsRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0019\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001c\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u001dR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006 "}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/repository/SettingsRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/SettingsRepository;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "interpretationMode", "Lkotlinx/coroutines/flow/Flow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;", "getInterpretationMode", "()Lkotlinx/coroutines/flow/Flow;", "interpretationSpeed", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationSpeed;", "getInterpretationSpeed", "isEnvSoundRecognizerEnabled", "", "setInterpretationMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "mode", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setInterpretationSpeed", "speed", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationSpeed;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEnvironmentStateRecognizerState", RemoteConfigConstants.ResponseFieldKey.STATE, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PreferencesKeys", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SettingsRepositoryImpl implements SettingsRepository {
    private static final String TAG = "SettingsRepositoryImpl";
    private final DataStore<Preferences> dataStore;
    private final Flow<InterpretationMode> interpretationMode;
    private final Flow<InterpretationSpeed> interpretationSpeed;
    private final Flow<Boolean> isEnvSoundRecognizerEnabled;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @Inject
    public SettingsRepositoryImpl(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DataStore<Preferences> settingsDataStore = AppDataStoreKt.getSettingsDataStore(context);
        this.dataStore = settingsDataStore;
        final Flow flowCatch = FlowKt.catch(settingsDataStore.getData(), new SettingsRepositoryImpl$interpretationMode$1(null));
        this.interpretationMode = new Flow<InterpretationMode>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$special$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$special$$inlined$map$1$2", f = "SettingsRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        String str = (String) ((Preferences) obj).get(SettingsRepositoryImpl.PreferencesKeys.INSTANCE.getINTERPRETATION_MODE());
                        if (str == null) {
                            str = "QUICK";
                        }
                        InterpretationMode interpretationModeValueOf = InterpretationMode.valueOf(str);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(interpretationModeValueOf, anonymousClass1) == coroutine_suspended) {
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
        };
        final Flow flowCatch2 = FlowKt.catch(settingsDataStore.getData(), new SettingsRepositoryImpl$interpretationSpeed$1(null));
        this.interpretationSpeed = new Flow<InterpretationSpeed>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$special$$inlined$map$2

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$special$$inlined$map$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$special$$inlined$map$2$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$special$$inlined$map$2$2", f = "SettingsRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        String str = (String) ((Preferences) obj).get(SettingsRepositoryImpl.PreferencesKeys.INSTANCE.getINTERPRETATION_SPEED());
                        if (str == null) {
                            str = "SuperFast";
                        }
                        InterpretationSpeed interpretationSpeedValueOf = InterpretationSpeed.valueOf(str);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(interpretationSpeedValueOf, anonymousClass1) == coroutine_suspended) {
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
        };
        final Flow flowCatch3 = FlowKt.catch(settingsDataStore.getData(), new AnonymousClass1(null));
        this.isEnvSoundRecognizerEnabled = new Flow<Boolean>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$special$$inlined$map$3

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$special$$inlined$map$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$special$$inlined$map$3$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$special$$inlined$map$3$2", f = "SettingsRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        Boolean bool = (Boolean) ((Preferences) obj).get(SettingsRepositoryImpl.PreferencesKeys.INSTANCE.getENVIRONMENT_SOUND_RECOGNIZER_STATE());
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
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/repository/SettingsRepositoryImpl$PreferencesKeys;", "", "<init>", "()V", "INTERPRETATION_SPEED", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getINTERPRETATION_SPEED", "()Landroidx/datastore/preferences/core/Preferences$Key;", "INTERPRETATION_MODE", "getINTERPRETATION_MODE", "ENVIRONMENT_SOUND_RECOGNIZER_STATE", "", "getENVIRONMENT_SOUND_RECOGNIZER_STATE", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class PreferencesKeys {
        public static final PreferencesKeys INSTANCE = new PreferencesKeys();
        private static final Preferences.Key<String> INTERPRETATION_SPEED = androidx.datastore.preferences.core.PreferencesKeys.stringKey("interpretation_speed");
        private static final Preferences.Key<String> INTERPRETATION_MODE = androidx.datastore.preferences.core.PreferencesKeys.stringKey("interpretation_mode");
        private static final Preferences.Key<Boolean> ENVIRONMENT_SOUND_RECOGNIZER_STATE = androidx.datastore.preferences.core.PreferencesKeys.booleanKey("environment_sound_recognizer_state");

        private PreferencesKeys() {
        }

        public final Preferences.Key<String> getINTERPRETATION_SPEED() {
            return INTERPRETATION_SPEED;
        }

        public final Preferences.Key<String> getINTERPRETATION_MODE() {
            return INTERPRETATION_MODE;
        }

        public final Preferences.Key<Boolean> getENVIRONMENT_SOUND_RECOGNIZER_STATE() {
            return ENVIRONMENT_SOUND_RECOGNIZER_STATE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository
    public Flow<InterpretationMode> getInterpretationMode() {
        return this.interpretationMode;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository
    public Flow<InterpretationSpeed> getInterpretationSpeed() {
        return this.interpretationSpeed;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$isEnvSoundRecognizerEnabled$1, reason: invalid class name */
    /* JADX INFO: compiled from: SettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/datastore/preferences/core/Preferences;", "exception", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$isEnvSoundRecognizerEnabled$1", f = "SettingsRepositoryImpl.kt", i = {0, 0}, l = {59}, m = "invokeSuspend", n = {"$this$catch", "exception"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super Preferences>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
        }

        public final Object invoke(FlowCollector<? super Preferences> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = flowCollector;
            anonymousClass1.L$1 = th;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Log.e(SettingsRepositoryImpl.TAG, "Error reading interpretation speed.", th);
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository
    public Flow<Boolean> isEnvSoundRecognizerEnabled() {
        return this.isEnvSoundRecognizerEnabled;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$setInterpretationMode$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$setInterpretationMode$2", f = "SettingsRepositoryImpl.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
    static final class C01942 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ InterpretationMode $mode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01942(InterpretationMode interpretationMode, Continuation<? super C01942> continuation) {
            super(1, continuation);
            this.$mode = interpretationMode;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SettingsRepositoryImpl.this.new C01942(this.$mode, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$setInterpretationMode$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: SettingsRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$setInterpretationMode$2$1", f = "SettingsRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ InterpretationMode $mode;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(InterpretationMode interpretationMode, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$mode = interpretationMode;
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
                mutablePreferences.set(PreferencesKeys.INSTANCE.getINTERPRETATION_MODE(), this.$mode.name());
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(SettingsRepositoryImpl.this.dataStore, new AnonymousClass1(this.$mode, null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository
    public Object setInterpretationMode(InterpretationMode interpretationMode, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C01942(interpretationMode, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$setInterpretationSpeed$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$setInterpretationSpeed$2", f = "SettingsRepositoryImpl.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    static final class C01952 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ InterpretationSpeed $speed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01952(InterpretationSpeed interpretationSpeed, Continuation<? super C01952> continuation) {
            super(1, continuation);
            this.$speed = interpretationSpeed;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SettingsRepositoryImpl.this.new C01952(this.$speed, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$setInterpretationSpeed$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: SettingsRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$setInterpretationSpeed$2$1", f = "SettingsRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ InterpretationSpeed $speed;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(InterpretationSpeed interpretationSpeed, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$speed = interpretationSpeed;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$speed, continuation);
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
                mutablePreferences.set(PreferencesKeys.INSTANCE.getINTERPRETATION_SPEED(), this.$speed.name());
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(SettingsRepositoryImpl.this.dataStore, new AnonymousClass1(this.$speed, null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository
    public Object setInterpretationSpeed(InterpretationSpeed interpretationSpeed, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C01952(interpretationSpeed, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$setEnvironmentStateRecognizerState$2, reason: invalid class name */
    /* JADX INFO: compiled from: SettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$setEnvironmentStateRecognizerState$2", f = "SettingsRepositoryImpl.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(boolean z, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$state = z;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SettingsRepositoryImpl.this.new AnonymousClass2(this.$state, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$setEnvironmentStateRecognizerState$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: SettingsRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl$setEnvironmentStateRecognizerState$2$1", f = "SettingsRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $state;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(boolean z, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$state = z;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$state, continuation);
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
                mutablePreferences.set(PreferencesKeys.INSTANCE.getENVIRONMENT_SOUND_RECOGNIZER_STATE(), Boxing.boxBoolean(this.$state));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(SettingsRepositoryImpl.this.dataStore, new AnonymousClass1(this.$state, null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository
    public Object setEnvironmentStateRecognizerState(boolean z, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new AnonymousClass2(z, null), continuation, 2, null);
    }

    /* JADX INFO: compiled from: SettingsRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/repository/SettingsRepositoryImpl$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
