package com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import androidx.wear.compose.foundation.SwipeToRevealKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.AppDataStoreKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.utils.DateTimeUtilsKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.time.LocalDate;
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

/* JADX INFO: compiled from: EngagementRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0096@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0016\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0096@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u001f\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010 J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010#\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010 J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010#\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010 R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\rR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\rR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\r¨\u0006&"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/data/repository/EngagementRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "shareAppDialogUsageCount", "Lkotlinx/coroutines/flow/Flow;", "", "getShareAppDialogUsageCount", "()Lkotlinx/coroutines/flow/Flow;", "incrementShareAppDialogUsageCount", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shareAppDialogLastUsageDate", "Ljava/time/LocalDate;", "getShareAppDialogLastUsageDate", "setShareAppDialogLastUsageDate", "date", "(Ljava/time/LocalDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementShareAppDialogDismissCount", "incrementShareAppDialogShareCount", "onBoardingShownState", "", "getOnBoardingShownState", "isEnvSoundRecognitionStateSubmitted", "setOnboardingShownState", RemoteConfigConstants.ResponseFieldKey.STATE, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPersonaSurveySubmitted", "setPersonaSurveySubmitted", "isSubmitted", "setEnvSoundRecognitionSubmittedState", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EngagementRepositoryImpl implements EngagementRepository {
    private static final String TAG = "EngagementRepositoryImpl";
    private final DataStore<Preferences> dataStore;
    private final Flow<Boolean> isEnvSoundRecognitionStateSubmitted;
    private final Flow<Boolean> isPersonaSurveySubmitted;
    private final Flow<Boolean> onBoardingShownState;
    private final Flow<LocalDate> shareAppDialogLastUsageDate;
    private final Flow<Integer> shareAppDialogUsageCount;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Preferences.Key<Integer> SHARE_POPUP_USAGE_COUNT = PreferencesKeys.intKey("share_popup_usage_count");
    private static final Preferences.Key<Integer> SHARE_POPUP_SHARE_COUNT = PreferencesKeys.intKey("share_popup_share_count");
    private static final Preferences.Key<Integer> SHARE_POPUP_DISMISS_COUNT = PreferencesKeys.intKey("share_popup_dismiss_count");
    private static final Preferences.Key<Boolean> IS_PERSONA_SURVEY_SUBMITTED = PreferencesKeys.booleanKey("is_persona_survey_submitted");
    private static final Preferences.Key<String> SHARE_POPUP_LAST_USAGE_DATE = PreferencesKeys.stringKey("share_popup_last_usage_date");
    private static final Preferences.Key<Boolean> ON_BOARDING_SCREEN_SHOWN_STATE = PreferencesKeys.booleanKey("on_boarding_screen_shown_state");
    private static final Preferences.Key<Boolean> ENV_SOUND_RECOGNIZER_WARN_SHOWN_STATE = PreferencesKeys.booleanKey("env_sound_recognizer_warn_shown_state");

    public EngagementRepositoryImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DataStore<Preferences> engagementDataStore = AppDataStoreKt.getEngagementDataStore(context);
        this.dataStore = engagementDataStore;
        final Flow data = engagementDataStore.getData();
        this.shareAppDialogUsageCount = new Flow<Integer>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$1$2", f = "EngagementRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        Integer num = (Integer) ((Preferences) obj).get(EngagementRepositoryImpl.SHARE_POPUP_USAGE_COUNT);
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

            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        final Flow data2 = engagementDataStore.getData();
        this.shareAppDialogLastUsageDate = new Flow<LocalDate>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$2

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$2$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$2$2", f = "EngagementRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        String str = (String) ((Preferences) obj).get(EngagementRepositoryImpl.SHARE_POPUP_LAST_USAGE_DATE);
                        LocalDate localDate = str != null ? LocalDate.parse(str, DateTimeUtilsKt.getDateFormatter()) : null;
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(localDate, anonymousClass1) == coroutine_suspended) {
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
                Object objCollect = data2.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        final Flow data3 = engagementDataStore.getData();
        this.onBoardingShownState = new Flow<Boolean>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$3

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$3$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$3$2", f = "EngagementRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        Boolean boolBoxBoolean = Boxing.boxBoolean(Intrinsics.areEqual(((Preferences) obj).get(EngagementRepositoryImpl.ON_BOARDING_SCREEN_SHOWN_STATE), Boxing.boxBoolean(true)));
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
                Object objCollect = data3.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        final Flow data4 = engagementDataStore.getData();
        this.isEnvSoundRecognitionStateSubmitted = new Flow<Boolean>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$4

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$4$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$4$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$4$2", f = "EngagementRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        Boolean boolBoxBoolean = Boxing.boxBoolean(Intrinsics.areEqual(((Preferences) obj).get(EngagementRepositoryImpl.ENV_SOUND_RECOGNIZER_WARN_SHOWN_STATE), Boxing.boxBoolean(true)));
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
                Object objCollect = data4.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        final Flow data5 = engagementDataStore.getData();
        this.isPersonaSurveySubmitted = new Flow<Boolean>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$5

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$5$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$5$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$special$$inlined$map$5$2", f = "EngagementRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        Boolean bool = (Boolean) ((Preferences) obj).get(EngagementRepositoryImpl.IS_PERSONA_SURVEY_SUBMITTED);
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
                Object objCollect = data5.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository
    public Flow<Integer> getShareAppDialogUsageCount() {
        return this.shareAppDialogUsageCount;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$incrementShareAppDialogUsageCount$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EngagementRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$incrementShareAppDialogUsageCount$2", f = "EngagementRepositoryImpl.kt", i = {}, l = {SignPracticeCreationViewModel.PRACTICE_NAME_MAX_CHAR_LIMIT}, m = "invokeSuspend", n = {}, s = {})
    static final class C02792 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C02792(Continuation<? super C02792> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EngagementRepositoryImpl.this.new C02792(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$incrementShareAppDialogUsageCount$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: EngagementRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$incrementShareAppDialogUsageCount$2$1", f = "EngagementRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    Integer num = (Integer) mutablePreferences.get(EngagementRepositoryImpl.SHARE_POPUP_USAGE_COUNT);
                    mutablePreferences.set(EngagementRepositoryImpl.SHARE_POPUP_USAGE_COUNT, Boxing.boxInt((num != null ? num.intValue() : 0) + 1));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(EngagementRepositoryImpl.this.dataStore, new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository
    public Object incrementShareAppDialogUsageCount(Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02792(null), continuation, 2, null);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository
    public Flow<LocalDate> getShareAppDialogLastUsageDate() {
        return this.shareAppDialogLastUsageDate;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$setShareAppDialogLastUsageDate$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EngagementRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$setShareAppDialogLastUsageDate$2", f = "EngagementRepositoryImpl.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
    static final class C02832 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LocalDate $date;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02832(LocalDate localDate, Continuation<? super C02832> continuation) {
            super(1, continuation);
            this.$date = localDate;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EngagementRepositoryImpl.this.new C02832(this.$date, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$setShareAppDialogLastUsageDate$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: EngagementRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$setShareAppDialogLastUsageDate$2$1", f = "EngagementRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ LocalDate $date;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(LocalDate localDate, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$date = localDate;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$date, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
                return create(mutablePreferences, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutablePreferences.set(EngagementRepositoryImpl.SHARE_POPUP_LAST_USAGE_DATE, this.$date.format(DateTimeUtilsKt.getDateFormatter()));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(EngagementRepositoryImpl.this.dataStore, new AnonymousClass1(this.$date, null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository
    public Object setShareAppDialogLastUsageDate(LocalDate localDate, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02832(localDate, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$incrementShareAppDialogDismissCount$2, reason: invalid class name */
    /* JADX INFO: compiled from: EngagementRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$incrementShareAppDialogDismissCount$2", f = "EngagementRepositoryImpl.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EngagementRepositoryImpl.this.new AnonymousClass2(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$incrementShareAppDialogDismissCount$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: EngagementRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$incrementShareAppDialogDismissCount$2$1", f = "EngagementRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    Integer num = (Integer) mutablePreferences.get(EngagementRepositoryImpl.SHARE_POPUP_SHARE_COUNT);
                    mutablePreferences.set(EngagementRepositoryImpl.SHARE_POPUP_SHARE_COUNT, Boxing.boxInt((num != null ? num.intValue() : 0) + 1));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(EngagementRepositoryImpl.this.dataStore, new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository
    public Object incrementShareAppDialogDismissCount(Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new AnonymousClass2(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$incrementShareAppDialogShareCount$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EngagementRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$incrementShareAppDialogShareCount$2", f = "EngagementRepositoryImpl.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
    static final class C02782 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C02782(Continuation<? super C02782> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EngagementRepositoryImpl.this.new C02782(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$incrementShareAppDialogShareCount$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: EngagementRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$incrementShareAppDialogShareCount$2$1", f = "EngagementRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    Integer num = (Integer) mutablePreferences.get(EngagementRepositoryImpl.SHARE_POPUP_DISMISS_COUNT);
                    mutablePreferences.set(EngagementRepositoryImpl.SHARE_POPUP_DISMISS_COUNT, Boxing.boxInt((num != null ? num.intValue() : 0) + 1));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(EngagementRepositoryImpl.this.dataStore, new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository
    public Object incrementShareAppDialogShareCount(Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02782(null), continuation, 2, null);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository
    public Flow<Boolean> getOnBoardingShownState() {
        return this.onBoardingShownState;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository
    public Flow<Boolean> isEnvSoundRecognitionStateSubmitted() {
        return this.isEnvSoundRecognitionStateSubmitted;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$setOnboardingShownState$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EngagementRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$setOnboardingShownState$2", f = "EngagementRepositoryImpl.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    static final class C02812 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02812(boolean z, Continuation<? super C02812> continuation) {
            super(1, continuation);
            this.$state = z;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EngagementRepositoryImpl.this.new C02812(this.$state, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$setOnboardingShownState$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: EngagementRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$setOnboardingShownState$2$1", f = "EngagementRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutablePreferences.set(EngagementRepositoryImpl.ON_BOARDING_SCREEN_SHOWN_STATE, Boxing.boxBoolean(this.$state));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(EngagementRepositoryImpl.this.dataStore, new AnonymousClass1(this.$state, null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository
    public Object setOnboardingShownState(boolean z, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02812(z, null), continuation, 2, null);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository
    public Flow<Boolean> isPersonaSurveySubmitted() {
        return this.isPersonaSurveySubmitted;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$setPersonaSurveySubmitted$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EngagementRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$setPersonaSurveySubmitted$2", f = "EngagementRepositoryImpl.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    static final class C02822 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isSubmitted;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02822(boolean z, Continuation<? super C02822> continuation) {
            super(1, continuation);
            this.$isSubmitted = z;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EngagementRepositoryImpl.this.new C02822(this.$isSubmitted, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$setPersonaSurveySubmitted$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: EngagementRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$setPersonaSurveySubmitted$2$1", f = "EngagementRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isSubmitted;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(boolean z, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$isSubmitted = z;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$isSubmitted, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
                return create(mutablePreferences, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutablePreferences.set(EngagementRepositoryImpl.IS_PERSONA_SURVEY_SUBMITTED, Boxing.boxBoolean(this.$isSubmitted));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(EngagementRepositoryImpl.this.dataStore, new AnonymousClass1(this.$isSubmitted, null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository
    public Object setPersonaSurveySubmitted(boolean z, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02822(z, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$setEnvSoundRecognitionSubmittedState$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EngagementRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$setEnvSoundRecognitionSubmittedState$2", f = "EngagementRepositoryImpl.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    static final class C02802 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isSubmitted;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02802(boolean z, Continuation<? super C02802> continuation) {
            super(1, continuation);
            this.$isSubmitted = z;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EngagementRepositoryImpl.this.new C02802(this.$isSubmitted, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$setEnvSoundRecognitionSubmittedState$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: EngagementRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl$setEnvSoundRecognitionSubmittedState$2$1", f = "EngagementRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isSubmitted;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(boolean z, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$isSubmitted = z;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$isSubmitted, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
                return create(mutablePreferences, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutablePreferences.set(EngagementRepositoryImpl.ENV_SOUND_RECOGNIZER_WARN_SHOWN_STATE, Boxing.boxBoolean(this.$isSubmitted));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(EngagementRepositoryImpl.this.dataStore, new AnonymousClass1(this.$isSubmitted, null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository
    public Object setEnvSoundRecognitionSubmittedState(boolean z, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02802(z, null), continuation, 2, null);
    }

    /* JADX INFO: compiled from: EngagementRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/data/repository/EngagementRepositoryImpl$Companion;", "", "<init>", "()V", "TAG", "", "SHARE_POPUP_USAGE_COUNT", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "SHARE_POPUP_SHARE_COUNT", "SHARE_POPUP_DISMISS_COUNT", "IS_PERSONA_SURVEY_SUBMITTED", "", "SHARE_POPUP_LAST_USAGE_DATE", "ON_BOARDING_SCREEN_SHOWN_STATE", "ENV_SOUND_RECOGNIZER_WARN_SHOWN_STATE", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
