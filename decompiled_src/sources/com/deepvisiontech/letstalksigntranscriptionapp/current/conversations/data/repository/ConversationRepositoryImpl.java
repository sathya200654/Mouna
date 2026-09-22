package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository;

import androidx.wear.compose.foundation.SwipeToRevealKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.mappers.ConversationMapperKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository;
import com.google.protobuf.DescriptorProtos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ConversationRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00140\u0013H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u0006\u0010\u0016\u001a\u00020\fH\u0016J\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019H\u0096@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/repository/ConversationRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationRepository;", "conversationDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationDao;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationDao;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getIoDispatcher$annotations", "()V", "insertConversationAndGetId", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "conversation", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConversation", "", "getAllConversations", "Lkotlinx/coroutines/flow/Flow;", "", "getConversation", "id", "deleteConversations", "conversations", "", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationRepositoryImpl implements ConversationRepository {
    private static final String TAG = "ConversationRepositoryImpl";
    private final ConversationDao conversationDao;
    private final CoroutineDispatcher ioDispatcher;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private static /* synthetic */ void getIoDispatcher$annotations() {
    }

    @Inject
    public ConversationRepositoryImpl(ConversationDao conversationDao, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(conversationDao, "conversationDao");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.conversationDao = conversationDao;
        this.ioDispatcher = coroutineDispatcher;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationRepositoryImpl$insertConversationAndGetId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationRepositoryImpl$insertConversationAndGetId$2", f = "ConversationRepositoryImpl.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
    static final class C02062 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {
        final /* synthetic */ Conversation $conversation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02062(Conversation conversation, Continuation<? super C02062> continuation) {
            super(1, continuation);
            this.$conversation = conversation;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationRepositoryImpl.this.new C02062(this.$conversation, continuation);
        }

        public final Object invoke(Continuation<? super Long> continuation) {
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
            Object objInsertConversation = ConversationRepositoryImpl.this.conversationDao.insertConversation(ConversationMapperKt.toEntity(this.$conversation), (Continuation) this);
            return objInsertConversation == coroutine_suspended ? coroutine_suspended : objInsertConversation;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository
    public Object insertConversationAndGetId(Conversation conversation, Continuation<? super ResponseResource<Long>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02062(conversation, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationRepositoryImpl$updateConversation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationRepositoryImpl$updateConversation$2", f = "ConversationRepositoryImpl.kt", i = {}, l = {DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
    static final class C02072 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Conversation $conversation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02072(Conversation conversation, Continuation<? super C02072> continuation) {
            super(1, continuation);
            this.$conversation = conversation;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationRepositoryImpl.this.new C02072(this.$conversation, continuation);
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
                if (ConversationRepositoryImpl.this.conversationDao.updateConversation(ConversationMapperKt.toEntity(this.$conversation), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository
    public Object updateConversation(Conversation conversation, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02072(conversation, null), continuation, 2, null);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository
    public Flow<List<Conversation>> getAllConversations() {
        final Flow<List<ConversationEntity>> allConversations = this.conversationDao.getAllConversations();
        return FlowKt.flowOn(new Flow<List<? extends Conversation>>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationRepositoryImpl$getAllConversations$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationRepositoryImpl$getAllConversations$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationRepositoryImpl$getAllConversations$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationRepositoryImpl$getAllConversations$$inlined$map$1$2", f = "ConversationRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        List list = (List) obj;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(ConversationMapperKt.toConversation((ConversationEntity) it.next()));
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(arrayList, anonymousClass1) == coroutine_suspended) {
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
                Object objCollect = allConversations.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, this.ioDispatcher);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository
    public Flow<Conversation> getConversation(long id) {
        final Flow<ConversationEntity> conversation = this.conversationDao.getConversation(id);
        return FlowKt.flowOn(new Flow<Conversation>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationRepositoryImpl$getConversation$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationRepositoryImpl$getConversation$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationRepositoryImpl$getConversation$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationRepositoryImpl$getConversation$$inlined$map$1$2", f = "ConversationRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        Conversation conversation = ConversationMapperKt.toConversation((ConversationEntity) obj);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(conversation, anonymousClass1) == coroutine_suspended) {
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
                Object objCollect = conversation.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, this.ioDispatcher);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationRepositoryImpl$deleteConversations$2, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationRepositoryImpl$deleteConversations$2", f = "ConversationRepositoryImpl.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<Conversation> $conversations;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Set<Conversation> set, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$conversations = set;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationRepositoryImpl.this.new AnonymousClass2(this.$conversations, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ConversationDao conversationDao = ConversationRepositoryImpl.this.conversationDao;
                Set<Conversation> set = this.$conversations;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    arrayList.add(ConversationMapperKt.toEntity((Conversation) it.next()));
                }
                this.label = 1;
                if (conversationDao.deleteConversations(CollectionsKt.toSet(arrayList), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository
    public Object deleteConversations(Set<Conversation> set, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new AnonymousClass2(set, null), continuation, 2, null);
    }

    /* JADX INFO: compiled from: ConversationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/repository/ConversationRepositoryImpl$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
