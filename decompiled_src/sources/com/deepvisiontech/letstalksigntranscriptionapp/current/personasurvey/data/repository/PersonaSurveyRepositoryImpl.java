package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository;

import android.content.Context;
import android.util.Log;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import androidx.wear.compose.foundation.SwipeToRevealKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.AppDataStoreKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.local.stores.PersonaSurveyLocalDataStore;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.remote.api.PersonaSurveyApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.remote.dto.PersonaSurveySubmissionRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.remote.dto.PersonaSurveySubmissionResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Persona;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository;
import com.google.protobuf.DescriptorProtos;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: PersonaSurveyRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\r\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0016J\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fH\u0096@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f2\u0006\u0010\u0015\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fH\u0096@¢\u0006\u0002\u0010\u0012J\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000fH\u0096@¢\u0006\u0002\u0010\u0012J\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a0\u000fH\u0096@¢\u0006\u0002\u0010\u0012J`\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001a2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\u001aH\u0096@¢\u0006\u0002\u0010%R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/data/repository/PersonaSurveyRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/repository/PersonaSurveyRepository;", "context", "Landroid/content/Context;", "personaSurveyApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/data/remote/api/PersonaSurveyApi;", "<init>", "(Landroid/content/Context;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/data/remote/api/PersonaSurveyApi;)V", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "getUserPersona", "Lkotlinx/coroutines/flow/Flow;", "", "getSurveyData", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Persona;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveUserPersonaLocally", "", "personaId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetUserPersonaData", "saveUserRolesLocally", "roleIds", "", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSavedPersonaId", "getSavedRoleIds", "saveUserPersonaInfoToServer", "customerId", "deviceId", "gmailId", "token", "personaName", "roles", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PersonaSurveyRepositoryImpl implements PersonaSurveyRepository {
    public static final String TAG = "PersonaSurveyRepositoryImpl";
    private final DataStore<Preferences> dataStore;
    private final PersonaSurveyApi personaSurveyApi;
    public static final int $stable = 8;
    private static final Preferences.Key<String> PERSONA = PreferencesKeys.stringKey("persona");
    private static final Preferences.Key<Set<String>> ROLES = PreferencesKeys.stringSetKey("roles");

    public PersonaSurveyRepositoryImpl(Context context, PersonaSurveyApi personaSurveyApi) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(personaSurveyApi, "personaSurveyApi");
        this.personaSurveyApi = personaSurveyApi;
        this.dataStore = AppDataStoreKt.getAppUsageDataStore(context);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$getUserPersona$1, reason: invalid class name */
    /* JADX INFO: compiled from: PersonaSurveyRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/datastore/preferences/core/Preferences;", "e", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$getUserPersona$1", f = "PersonaSurveyRepositoryImpl.kt", i = {0, 0}, l = {DescriptorProtos.MethodOptions.IDEMPOTENCY_LEVEL_FIELD_NUMBER}, m = "invokeSuspend", n = {"$this$catch", "e"}, s = {"L$0", "L$1"})
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
                Log.e(PersonaSurveyRepositoryImpl.TAG, "Failed to fetch user persona", th);
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository
    public Flow<String> getUserPersona() {
        final Flow flowCatch = FlowKt.catch(this.dataStore.getData(), new AnonymousClass1(null));
        return new Flow<String>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$getUserPersona$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$getUserPersona$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$getUserPersona$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$getUserPersona$$inlined$map$1$2", f = "PersonaSurveyRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        Object obj3 = ((Preferences) obj).get(PersonaSurveyRepositoryImpl.PERSONA);
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
                Object objCollect = flowCatch.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$getSurveyData$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PersonaSurveyRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Persona;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$getSurveyData$2", f = "PersonaSurveyRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02932 extends SuspendLambda implements Function1<Continuation<? super List<? extends Persona>>, Object> {
        int label;

        C02932(Continuation<? super C02932> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C02932(continuation);
        }

        public final Object invoke(Continuation<? super List<Persona>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PersonaSurveyLocalDataStore.INSTANCE.getPersonaSurveyData();
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository
    public Object getSurveyData(Continuation<? super ResponseResource<? extends List<Persona>>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02932(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$saveUserPersonaLocally$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PersonaSurveyRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$saveUserPersonaLocally$2", f = "PersonaSurveyRepositoryImpl.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    static final class C02962 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $personaId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02962(String str, Continuation<? super C02962> continuation) {
            super(1, continuation);
            this.$personaId = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PersonaSurveyRepositoryImpl.this.new C02962(this.$personaId, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$saveUserPersonaLocally$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: PersonaSurveyRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$saveUserPersonaLocally$2$1", f = "PersonaSurveyRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $personaId;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$personaId = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$personaId, continuation);
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
                    mutablePreferences.set(PersonaSurveyRepositoryImpl.PERSONA, this.$personaId);
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
                if (PreferencesKt.edit(PersonaSurveyRepositoryImpl.this.dataStore, new AnonymousClass1(this.$personaId, null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository
    public Object saveUserPersonaLocally(String str, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02962(str, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$resetUserPersonaData$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PersonaSurveyRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$resetUserPersonaData$2", f = "PersonaSurveyRepositoryImpl.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
    static final class C02942 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C02942(Continuation<? super C02942> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PersonaSurveyRepositoryImpl.this.new C02942(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$resetUserPersonaData$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: PersonaSurveyRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$resetUserPersonaData$2$1", f = "PersonaSurveyRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
                mutablePreferences.clear();
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreferencesKt.edit(PersonaSurveyRepositoryImpl.this.dataStore, new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository
    public Object resetUserPersonaData(Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02942(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$saveUserRolesLocally$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PersonaSurveyRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$saveUserRolesLocally$2", f = "PersonaSurveyRepositoryImpl.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
    static final class C02972 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<String> $roleIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02972(Set<String> set, Continuation<? super C02972> continuation) {
            super(1, continuation);
            this.$roleIds = set;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PersonaSurveyRepositoryImpl.this.new C02972(this.$roleIds, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$saveUserRolesLocally$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: PersonaSurveyRepositoryImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$saveUserRolesLocally$2$1", f = "PersonaSurveyRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ Set<String> $roleIds;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Set<String> set, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$roleIds = set;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$roleIds, continuation);
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
                    mutablePreferences.set(PersonaSurveyRepositoryImpl.ROLES, CollectionsKt.toSet(this.$roleIds));
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
                if (PreferencesKt.edit(PersonaSurveyRepositoryImpl.this.dataStore, new AnonymousClass1(this.$roleIds, null), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository
    public Object saveUserRolesLocally(Set<String> set, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02972(set, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$getSavedPersonaId$2, reason: invalid class name */
    /* JADX INFO: compiled from: PersonaSurveyRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$getSavedPersonaId$2", f = "PersonaSurveyRepositoryImpl.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PersonaSurveyRepositoryImpl.this.new AnonymousClass2(continuation);
        }

        public final Object invoke(Continuation<? super String> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = FlowKt.first(PersonaSurveyRepositoryImpl.this.dataStore.getData(), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((Preferences) obj).get(PersonaSurveyRepositoryImpl.PERSONA);
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository
    public Object getSavedPersonaId(Continuation<? super ResponseResource<String>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new AnonymousClass2(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$getSavedRoleIds$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PersonaSurveyRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$getSavedRoleIds$2", f = "PersonaSurveyRepositoryImpl.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
    static final class C02922 extends SuspendLambda implements Function1<Continuation<? super Set<? extends String>>, Object> {
        int label;

        C02922(Continuation<? super C02922> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PersonaSurveyRepositoryImpl.this.new C02922(continuation);
        }

        public final Object invoke(Continuation<? super Set<String>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = FlowKt.first(PersonaSurveyRepositoryImpl.this.dataStore.getData(), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Set set = (Set) ((Preferences) obj).get(PersonaSurveyRepositoryImpl.ROLES);
            return set == null ? SetsKt.emptySet() : set;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository
    public Object getSavedRoleIds(Continuation<? super ResponseResource<? extends Set<String>>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02922(null), continuation, 2, null);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository
    public Object saveUserPersonaInfoToServer(String str, String str2, String str3, String str4, String str5, String str6, Set<String> set, Set<String> set2, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.api$default(SafeCall.INSTANCE, TAG, null, new C02952(str, str2, str3, str4, str5, str6, set, set2, null), new AnonymousClass3(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$saveUserPersonaInfoToServer$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PersonaSurveyRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/data/remote/dto/PersonaSurveySubmissionResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$saveUserPersonaInfoToServer$2", f = "PersonaSurveyRepositoryImpl.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
    static final class C02952 extends SuspendLambda implements Function1<Continuation<? super PersonaSurveySubmissionResponse>, Object> {
        final /* synthetic */ String $customerId;
        final /* synthetic */ String $deviceId;
        final /* synthetic */ String $gmailId;
        final /* synthetic */ String $personaId;
        final /* synthetic */ String $personaName;
        final /* synthetic */ Set<String> $roleIds;
        final /* synthetic */ Set<String> $roles;
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02952(String str, String str2, String str3, String str4, String str5, String str6, Set<String> set, Set<String> set2, Continuation<? super C02952> continuation) {
            super(1, continuation);
            this.$customerId = str;
            this.$deviceId = str2;
            this.$gmailId = str3;
            this.$token = str4;
            this.$personaId = str5;
            this.$personaName = str6;
            this.$roleIds = set;
            this.$roles = set2;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PersonaSurveyRepositoryImpl.this.new C02952(this.$customerId, this.$deviceId, this.$gmailId, this.$token, this.$personaId, this.$personaName, this.$roleIds, this.$roles, continuation);
        }

        public final Object invoke(Continuation<? super PersonaSurveySubmissionResponse> continuation) {
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
            Object objSubmitPersonaInfo = PersonaSurveyRepositoryImpl.this.personaSurveyApi.submitPersonaInfo(new PersonaSurveySubmissionRequest(this.$customerId, this.$deviceId, this.$gmailId, this.$token, this.$personaId, this.$personaName, this.$roleIds, this.$roles), (Continuation) this);
            return objSubmitPersonaInfo == coroutine_suspended ? coroutine_suspended : objSubmitPersonaInfo;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$saveUserPersonaInfoToServer$3, reason: invalid class name */
    /* JADX INFO: compiled from: PersonaSurveyRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/data/remote/dto/PersonaSurveySubmissionResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl$saveUserPersonaInfoToServer$3", f = "PersonaSurveyRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<PersonaSurveySubmissionResponse, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        public final Object invoke(PersonaSurveySubmissionResponse personaSurveySubmissionResponse, Continuation<? super Unit> continuation) {
            return create(personaSurveySubmissionResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }
}
