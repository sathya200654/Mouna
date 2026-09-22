package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKt;
import androidx.wear.compose.foundation.SwipeToRevealKt;
import com.azure.core.util.tracing.Tracer;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.AppDataStoreKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: SessionRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002*+B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0 2\u0006\u0010\u0010\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010!J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0 2\u0006\u0010#\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010!J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001c0 2\u0006\u0010%\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010!J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001c0 2\u0006\u0010%\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010'J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001c0 H\u0096@¢\u0006\u0002\u0010\u001dJ\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0 H\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0 H\u0096@¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0 H\u0096@¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0 H\u0096@¢\u0006\u0002\u0010\u001dR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013¨\u0006,"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/data/repository/SessionRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", Tracer.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "MIGRATION_COMPLETED_KEY", "", "CUSTOMER_ID_CONSTANT", "token", "Lkotlinx/coroutines/flow/Flow;", "getToken", "()Lkotlinx/coroutines/flow/Flow;", "gmailId", "getGmailId", "deviceId", "getDeviceId", "activeConversationId", "", "getActiveConversationId", "migrateFromSharedPreferences", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureDeviceIdExists", "setToken", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMailId", "mailId", "setDeviceId", "id", "setActiveConversation", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearMailId", "getCustomerId", "PreferencesKeys", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SessionRepositoryImpl implements SessionRepository {
    private static final String TAG = "SessionRepositoryImpl";
    private final String CUSTOMER_ID_CONSTANT;
    private final String MIGRATION_COMPLETED_KEY;
    private final Flow<Long> activeConversationId;
    private final DataStore<Preferences> dataStore;
    private final Flow<String> deviceId;
    private final Flow<String> gmailId;
    private final CoroutineScope scope;
    private final SharedPreferences sharedPreferences;
    private final Flow<String> token;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$ensureDeviceIdExists$1, reason: invalid class name */
    /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl", f = "SessionRepositoryImpl.kt", i = {0, 1, 1}, l = {107, 116}, m = "ensureDeviceIdExists", n = {"currentDeviceId", "currentDeviceId", "spDeviceId"}, s = {"L$0", "L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionRepositoryImpl.this.ensureDeviceIdExists((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$migrateFromSharedPreferences$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl", f = "SessionRepositoryImpl.kt", i = {0, 0, 0}, l = {95}, m = "migrateFromSharedPreferences", n = {"oldToken", "oldGmailId", "oldDeviceId"}, s = {"L$0", "L$1", "L$2"})
    static final class C01791 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C01791(Continuation<? super C01791> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionRepositoryImpl.this.migrateFromSharedPreferences((Continuation) this);
        }
    }

    @Inject
    public SessionRepositoryImpl(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DataStore<Preferences> sessionDataStore = AppDataStoreKt.getSessionDataStore(context);
        this.dataStore = sessionDataStore;
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoggingData", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.scope = CoroutineScope;
        this.MIGRATION_COMPLETED_KEY = "datastore_migration_completed";
        this.CUSTOMER_ID_CONSTANT = "10009";
        final Flow flowCatch = FlowKt.catch(sessionDataStore.getData(), new SessionRepositoryImpl$token$1(null));
        this.token = new Flow<String>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$special$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$special$$inlined$map$1$2", f = "SessionRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        String str = (String) ((Preferences) obj).get(SessionRepositoryImpl.PreferencesKeys.INSTANCE.getTOKEN());
                        if (str == null) {
                            str = "";
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(str, anonymousClass1) == coroutine_suspended) {
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
        final Flow flowCatch2 = FlowKt.catch(sessionDataStore.getData(), new SessionRepositoryImpl$gmailId$1(null));
        this.gmailId = new Flow<String>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$special$$inlined$map$2

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$special$$inlined$map$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$special$$inlined$map$2$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$special$$inlined$map$2$2", f = "SessionRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        String str = (String) ((Preferences) obj).get(SessionRepositoryImpl.PreferencesKeys.INSTANCE.getGMAIL_ID());
                        if (str == null) {
                            str = "";
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(str, anonymousClass1) == coroutine_suspended) {
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
        final Flow flowCatch3 = FlowKt.catch(sessionDataStore.getData(), new SessionRepositoryImpl$deviceId$1(null));
        this.deviceId = new Flow<String>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$special$$inlined$map$3

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$special$$inlined$map$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$special$$inlined$map$3$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$special$$inlined$map$3$2", f = "SessionRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        String str = (String) ((Preferences) obj).get(SessionRepositoryImpl.PreferencesKeys.INSTANCE.getDEVICE_ID());
                        if (str == null) {
                            str = "";
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(str, anonymousClass1) == coroutine_suspended) {
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
        final Flow flowCatch4 = FlowKt.catch(sessionDataStore.getData(), new SessionRepositoryImpl$activeConversationId$1(null));
        this.activeConversationId = new Flow<Long>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$special$$inlined$map$4

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$special$$inlined$map$4$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$special$$inlined$map$4$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$special$$inlined$map$4$2", f = "SessionRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        String str = (String) ((Preferences) obj).get(SessionRepositoryImpl.PreferencesKeys.INSTANCE.getCONVERSATION_ID());
                        Long lBoxLong = str != null ? Boxing.boxLong(Long.parseLong(str)) : null;
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(lBoxLong, anonymousClass1) == coroutine_suspended) {
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
                Object objCollect = flowCatch4.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        if (!Intrinsics.areEqual(sharedPreferences.getString("customerId", ""), "10009")) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("customerId", "10009");
            editorEdit.apply();
        }
        BuildersKt.launch$default(CoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/data/repository/SessionRepositoryImpl$PreferencesKeys;", "", "<init>", "()V", "TOKEN", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getTOKEN", "()Landroidx/datastore/preferences/core/Preferences$Key;", "GMAIL_ID", "getGMAIL_ID", "DEVICE_ID", "getDEVICE_ID", "CONVERSATION_ID", "getCONVERSATION_ID", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class PreferencesKeys {
        public static final PreferencesKeys INSTANCE = new PreferencesKeys();
        private static final Preferences.Key<String> TOKEN = androidx.datastore.preferences.core.PreferencesKeys.stringKey("token");
        private static final Preferences.Key<String> GMAIL_ID = androidx.datastore.preferences.core.PreferencesKeys.stringKey("gmailId");
        private static final Preferences.Key<String> DEVICE_ID = androidx.datastore.preferences.core.PreferencesKeys.stringKey("deviceId");
        private static final Preferences.Key<String> CONVERSATION_ID = androidx.datastore.preferences.core.PreferencesKeys.stringKey("conversationId");

        private PreferencesKeys() {
        }

        public final Preferences.Key<String> getTOKEN() {
            return TOKEN;
        }

        public final Preferences.Key<String> getGMAIL_ID() {
            return GMAIL_ID;
        }

        public final Preferences.Key<String> getDEVICE_ID() {
            return DEVICE_ID;
        }

        public final Preferences.Key<String> getCONVERSATION_ID() {
            return CONVERSATION_ID;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository
    public Flow<String> getToken() {
        return this.token;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository
    public Flow<String> getGmailId() {
        return this.gmailId;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository
    public Flow<String> getDeviceId() {
        return this.deviceId;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository
    public Flow<Long> getActiveConversationId() {
        return this.activeConversationId;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$2, reason: invalid class name */
    /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$2", f = "SessionRepositoryImpl.kt", i = {}, l = {84, 86}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionRepositoryImpl.this.new AnonymousClass2(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
        
            if (r5.this$0.ensureDeviceIdExists((kotlin.coroutines.Continuation) r5) == r0) goto L17;
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
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r6)
                goto L50
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1a:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L42
            L1e:
                kotlin.ResultKt.throwOnFailure(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl.this
                android.content.SharedPreferences r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl.access$getSharedPreferences$p(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl.this
                java.lang.String r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl.access$getMIGRATION_COMPLETED_KEY$p(r1)
                r4 = 0
                boolean r6 = r6.getBoolean(r1, r4)
                if (r6 != 0) goto L42
                com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl.this
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r3
                java.lang.Object r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl.access$migrateFromSharedPreferences(r6, r1)
                if (r6 != r0) goto L42
                goto L4f
            L42:
                com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl.this
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r2
                java.lang.Object r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl.access$ensureDeviceIdExists(r6, r1)
                if (r5 != r0) goto L50
            L4f:
                return r0
            L50:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object migrateFromSharedPreferences(Continuation<? super Unit> continuation) {
        C01791 c01791;
        if (continuation instanceof C01791) {
            c01791 = (C01791) continuation;
            if ((c01791.label & Integer.MIN_VALUE) != 0) {
                c01791.label -= Integer.MIN_VALUE;
            } else {
                c01791 = new C01791(continuation);
            }
        } else {
            c01791 = new C01791(continuation);
        }
        Object obj = c01791.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01791.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String string = this.sharedPreferences.getString("token", "");
            if (string == null) {
                string = "";
            }
            String string2 = this.sharedPreferences.getString("gmailId", "");
            if (string2 == null) {
                string2 = "";
            }
            String string3 = this.sharedPreferences.getString("deviceId", "");
            String str = string3 != null ? string3 : "";
            DataStore<Preferences> dataStore = this.dataStore;
            C01802 c01802 = new C01802(string, string2, str, null);
            c01791.L$0 = SpillingKt.nullOutSpilledVariable(string);
            c01791.L$1 = SpillingKt.nullOutSpilledVariable(string2);
            c01791.L$2 = SpillingKt.nullOutSpilledVariable(str);
            c01791.label = 1;
            if (PreferencesKt.edit(dataStore, c01802, c01791) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(this.MIGRATION_COMPLETED_KEY, true);
        editorEdit.apply();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$migrateFromSharedPreferences$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$migrateFromSharedPreferences$2", f = "SessionRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01802 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $oldDeviceId;
        final /* synthetic */ String $oldGmailId;
        final /* synthetic */ String $oldToken;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01802(String str, String str2, String str3, Continuation<? super C01802> continuation) {
            super(2, continuation);
            this.$oldToken = str;
            this.$oldGmailId = str2;
            this.$oldDeviceId = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c01802 = new C01802(this.$oldToken, this.$oldGmailId, this.$oldDeviceId, continuation);
            c01802.L$0 = obj;
            return c01802;
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
            mutablePreferences.set(PreferencesKeys.INSTANCE.getTOKEN(), this.$oldToken);
            mutablePreferences.set(PreferencesKeys.INSTANCE.getGMAIL_ID(), this.$oldGmailId);
            if (!StringsKt.isBlank(this.$oldDeviceId)) {
                mutablePreferences.set(PreferencesKeys.INSTANCE.getDEVICE_ID(), this.$oldDeviceId);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00af, code lost:
    
        if (setDeviceId(r7, r0) == r1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object ensureDeviceIdExists(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl.ensureDeviceIdExists(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$setToken$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$setToken$2", f = "SessionRepositoryImpl.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    static final class C01842 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01842(String str, Continuation<? super C01842> continuation) {
            super(1, continuation);
            this.$token = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SessionRepositoryImpl.this.new C01842(this.$token, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$setToken$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$setToken$2$1", f = "SessionRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $token;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$token = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$token, continuation);
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
                mutablePreferences.set(PreferencesKeys.INSTANCE.getTOKEN(), this.$token);
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(SessionRepositoryImpl.this.dataStore, new AnonymousClass1(this.$token, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            SharedPreferences sharedPreferences = SessionRepositoryImpl.this.sharedPreferences;
            String str = this.$token;
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("token", str);
            editorEdit.apply();
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository
    public Object setToken(String str, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C01842(str, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$setMailId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$setMailId$2", f = "SessionRepositoryImpl.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
    static final class C01832 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $mailId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01832(String str, Continuation<? super C01832> continuation) {
            super(1, continuation);
            this.$mailId = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SessionRepositoryImpl.this.new C01832(this.$mailId, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$setMailId$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$setMailId$2$1", f = "SessionRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $mailId;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$mailId = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$mailId, continuation);
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
                mutablePreferences.set(PreferencesKeys.INSTANCE.getGMAIL_ID(), this.$mailId);
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(SessionRepositoryImpl.this.dataStore, new AnonymousClass1(this.$mailId, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            SharedPreferences sharedPreferences = SessionRepositoryImpl.this.sharedPreferences;
            String str = this.$mailId;
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("gmailId", str);
            editorEdit.apply();
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository
    public Object setMailId(String str, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C01832(str, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$setDeviceId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$setDeviceId$2", f = "SessionRepositoryImpl.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
    static final class C01822 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01822(String str, Continuation<? super C01822> continuation) {
            super(1, continuation);
            this.$id = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SessionRepositoryImpl.this.new C01822(this.$id, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$setDeviceId$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$setDeviceId$2$1", f = "SessionRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $id;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$id = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$id, continuation);
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
                mutablePreferences.set(PreferencesKeys.INSTANCE.getDEVICE_ID(), this.$id);
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(SessionRepositoryImpl.this.dataStore, new AnonymousClass1(this.$id, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            SharedPreferences sharedPreferences = SessionRepositoryImpl.this.sharedPreferences;
            String str = this.$id;
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("deviceId", str);
            editorEdit.apply();
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository
    public Object setDeviceId(String str, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C01822(str, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$setActiveConversation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$setActiveConversation$2", f = "SessionRepositoryImpl.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
    static final class C01812 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ long $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01812(long j, Continuation<? super C01812> continuation) {
            super(1, continuation);
            this.$id = j;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SessionRepositoryImpl.this.new C01812(this.$id, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$setActiveConversation$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$setActiveConversation$2$1", f = "SessionRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ long $id;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(long j, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$id = j;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$id, continuation);
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
                mutablePreferences.set(PreferencesKeys.INSTANCE.getCONVERSATION_ID(), String.valueOf(this.$id));
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(SessionRepositoryImpl.this.dataStore, new AnonymousClass1(this.$id, null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository
    public Object setActiveConversation(long j, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C01812(j, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$clearMailId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$clearMailId$2", f = "SessionRepositoryImpl.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
    static final class C01752 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C01752(Continuation<? super C01752> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SessionRepositoryImpl.this.new C01752(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$clearMailId$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$clearMailId$2$1", f = "SessionRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
                mutablePreferences.remove(PreferencesKeys.INSTANCE.getGMAIL_ID());
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(SessionRepositoryImpl.this.dataStore, new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            SharedPreferences.Editor editorEdit = SessionRepositoryImpl.this.sharedPreferences.edit();
            editorEdit.remove("gmailId");
            editorEdit.apply();
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository
    public Object clearMailId(Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C01752(null), continuation, 2, null);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository
    public ResponseResource<String> getCustomerId() {
        return new ResponseResource.Success(this.CUSTOMER_ID_CONSTANT);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$getDeviceId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$getDeviceId$2", f = "SessionRepositoryImpl.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {})
    static final class C01762 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
        int label;

        C01762(Continuation<? super C01762> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SessionRepositoryImpl.this.new C01762(continuation);
        }

        public final Object invoke(Continuation<? super String> continuation) {
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
            Object objFirst = FlowKt.first(SessionRepositoryImpl.this.getDeviceId(), (Continuation) this);
            return objFirst == coroutine_suspended ? coroutine_suspended : objFirst;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository
    public Object getDeviceId(Continuation<? super ResponseResource<String>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C01762(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$getGmailId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$getGmailId$2", f = "SessionRepositoryImpl.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
    static final class C01772 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
        int label;

        C01772(Continuation<? super C01772> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SessionRepositoryImpl.this.new C01772(continuation);
        }

        public final Object invoke(Continuation<? super String> continuation) {
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
            Object objFirst = FlowKt.first(SessionRepositoryImpl.this.getGmailId(), (Continuation) this);
            return objFirst == coroutine_suspended ? coroutine_suspended : objFirst;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository
    public Object getGmailId(Continuation<? super ResponseResource<String>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C01772(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$getToken$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.SessionRepositoryImpl$getToken$2", f = "SessionRepositoryImpl.kt", i = {}, l = {183}, m = "invokeSuspend", n = {}, s = {})
    static final class C01782 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
        int label;

        C01782(Continuation<? super C01782> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SessionRepositoryImpl.this.new C01782(continuation);
        }

        public final Object invoke(Continuation<? super String> continuation) {
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
            Object objFirst = FlowKt.first(SessionRepositoryImpl.this.getToken(), (Continuation) this);
            return objFirst == coroutine_suspended ? coroutine_suspended : objFirst;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository
    public Object getToken(Continuation<? super ResponseResource<String>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C01782(null), continuation, 2, null);
    }

    /* JADX INFO: compiled from: SessionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/data/repository/SessionRepositoryImpl$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
