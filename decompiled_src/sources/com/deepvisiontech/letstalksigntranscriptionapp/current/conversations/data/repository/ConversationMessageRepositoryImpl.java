package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import androidx.wear.compose.foundation.SwipeToRevealKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationMessageEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.mappers.ConversationMessageMapperKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationSummaryApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.summary.ConversationArticleSummaryRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.summary.ConversationArticleSummaryResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.summary.ConversationSummaryRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.summary.ConversationSummaryResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.SerializationException;

/* JADX INFO: compiled from: ConversationMessageRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00132\u0006\u0010\u0018\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0015J\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bH\u0096@¢\u0006\u0002\u0010\u001cJD\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00132\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010%J<\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00132\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000b¨\u0006*"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/repository/ConversationMessageRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationMessageRepository;", "conversationMessageDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationMessageDao;", "conversationSummaryApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationSummaryApi;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationMessageDao;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationSummaryApi;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getIoDispatcher$annotations", "()V", "getAllMessagesOfConversation", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "id", "", "insertConversationMessageWithNextSequenceIdAndGetWithId", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "conversationMessage", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConversationMessage", "", ResponseKeys.KEY_MESSAGE, "deleteConversationMessages", "messages", "", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateConversationMessageSummary", "", "deviceId", "gmailId", "customerId", "token", "content", "generatedSummaryWordCount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchArticleSummary", "link", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationMessageRepositoryImpl implements ConversationMessageRepository {
    private static final String TAG = "ConversationMessageRepositoryImpl";
    private final ConversationMessageDao conversationMessageDao;
    private final ConversationSummaryApi conversationSummaryApi;
    private final CoroutineDispatcher ioDispatcher;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private static /* synthetic */ void getIoDispatcher$annotations() {
    }

    @Inject
    public ConversationMessageRepositoryImpl(ConversationMessageDao conversationMessageDao, ConversationSummaryApi conversationSummaryApi, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(conversationMessageDao, "conversationMessageDao");
        Intrinsics.checkNotNullParameter(conversationSummaryApi, "conversationSummaryApi");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.conversationMessageDao = conversationMessageDao;
        this.conversationSummaryApi = conversationSummaryApi;
        this.ioDispatcher = coroutineDispatcher;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository
    public Flow<List<ConversationMessage>> getAllMessagesOfConversation(long id) {
        final Flow<List<ConversationMessageEntity>> allMessagesOfConversation = this.conversationMessageDao.getAllMessagesOfConversation(id);
        return FlowKt.flowOn(new Flow<List<? extends ConversationMessage>>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$getAllMessagesOfConversation$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$getAllMessagesOfConversation$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$getAllMessagesOfConversation$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$getAllMessagesOfConversation$$inlined$map$1$2", f = "ConversationMessageRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                            arrayList.add(ConversationMessageMapperKt.toConversationMessage((ConversationMessageEntity) it.next()));
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
                Object objCollect = allMessagesOfConversation.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, this.ioDispatcher);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$insertConversationMessageWithNextSequenceIdAndGetWithId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationMessageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$insertConversationMessageWithNextSequenceIdAndGetWithId$2", f = "ConversationMessageRepositoryImpl.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    static final class C02042 extends SuspendLambda implements Function1<Continuation<? super ConversationMessage>, Object> {
        final /* synthetic */ ConversationMessage $conversationMessage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02042(ConversationMessage conversationMessage, Continuation<? super C02042> continuation) {
            super(1, continuation);
            this.$conversationMessage = conversationMessage;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationMessageRepositoryImpl.this.new C02042(this.$conversationMessage, continuation);
        }

        public final Object invoke(Continuation<? super ConversationMessage> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ConversationMessageRepositoryImpl.this.conversationMessageDao.insertWithNextSequenceId(ConversationMessageMapperKt.toEntity(this.$conversationMessage), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ConversationMessageMapperKt.toConversationMessage((ConversationMessageEntity) obj);
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository
    public Object insertConversationMessageWithNextSequenceIdAndGetWithId(ConversationMessage conversationMessage, Continuation<? super ResponseResource<ConversationMessage>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02042(conversationMessage, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$updateConversationMessage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationMessageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$updateConversationMessage$2", f = "ConversationMessageRepositoryImpl.kt", i = {}, l = {DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
    static final class C02052 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationMessage $message;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02052(ConversationMessage conversationMessage, Continuation<? super C02052> continuation) {
            super(1, continuation);
            this.$message = conversationMessage;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationMessageRepositoryImpl.this.new C02052(this.$message, continuation);
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
                if (ConversationMessageRepositoryImpl.this.conversationMessageDao.updateMessage(ConversationMessageMapperKt.toEntity(this.$message), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository
    public Object updateConversationMessage(ConversationMessage conversationMessage, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02052(conversationMessage, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$deleteConversationMessages$2, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationMessageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$deleteConversationMessages$2", f = "ConversationMessageRepositoryImpl.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<ConversationMessage> $messages;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Set<ConversationMessage> set, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$messages = set;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationMessageRepositoryImpl.this.new AnonymousClass2(this.$messages, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ConversationMessageDao conversationMessageDao = ConversationMessageRepositoryImpl.this.conversationMessageDao;
                Set<ConversationMessage> set = this.$messages;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    arrayList.add(ConversationMessageMapperKt.toEntity((ConversationMessage) it.next()));
                }
                this.label = 1;
                if (conversationMessageDao.deleteMessages(CollectionsKt.toSet(arrayList), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository
    public Object deleteConversationMessages(Set<ConversationMessage> set, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new AnonymousClass2(set, null), continuation, 2, null);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository
    public Object generateConversationMessageSummary(String str, String str2, String str3, String str4, String str5, String str6, Continuation<? super ResponseResource<String>> continuation) {
        return SafeCall.api$default(SafeCall.INSTANCE, TAG, null, new C02022(str, str2, str3, str4, str5, str6, null), new C02033(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$generateConversationMessageSummary$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationMessageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/summary/ConversationSummaryResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$generateConversationMessageSummary$2", f = "ConversationMessageRepositoryImpl.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    static final class C02022 extends SuspendLambda implements Function1<Continuation<? super ConversationSummaryResponse>, Object> {
        final /* synthetic */ String $content;
        final /* synthetic */ String $customerId;
        final /* synthetic */ String $deviceId;
        final /* synthetic */ String $generatedSummaryWordCount;
        final /* synthetic */ String $gmailId;
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02022(String str, String str2, String str3, String str4, String str5, String str6, Continuation<? super C02022> continuation) {
            super(1, continuation);
            this.$deviceId = str;
            this.$gmailId = str2;
            this.$customerId = str3;
            this.$token = str4;
            this.$content = str5;
            this.$generatedSummaryWordCount = str6;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationMessageRepositoryImpl.this.new C02022(this.$deviceId, this.$gmailId, this.$customerId, this.$token, this.$content, this.$generatedSummaryWordCount, continuation);
        }

        public final Object invoke(Continuation<? super ConversationSummaryResponse> continuation) {
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
            Object objGenerateConversationSummary = ConversationMessageRepositoryImpl.this.conversationSummaryApi.generateConversationSummary(new ConversationSummaryRequest(this.$deviceId, this.$gmailId, this.$customerId, this.$token, this.$content, this.$generatedSummaryWordCount), (Continuation) this);
            return objGenerateConversationSummary == coroutine_suspended ? coroutine_suspended : objGenerateConversationSummary;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$generateConversationMessageSummary$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationMessageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "response", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/summary/ConversationSummaryResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$generateConversationMessageSummary$3", f = "ConversationMessageRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02033 extends SuspendLambda implements Function2<ConversationSummaryResponse, Continuation<? super String>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C02033(Continuation<? super C02033> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c02033 = new C02033(continuation);
            c02033.L$0 = obj;
            return c02033;
        }

        public final Object invoke(ConversationSummaryResponse conversationSummaryResponse, Continuation<? super String> continuation) {
            return create(conversationSummaryResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlinx.serialization.SerializationException */
        public final Object invokeSuspend(Object obj) throws SerializationException {
            JsonObject asJsonObject;
            JsonElement jsonElement;
            JsonObject asJsonObject2;
            JsonElement jsonElement2;
            String asString;
            String strReplace;
            String strReplace$default;
            String string;
            ConversationSummaryResponse conversationSummaryResponse = (ConversationSummaryResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            JsonElement data = conversationSummaryResponse.getData();
            String asString2 = null;
            if (!data.isJsonObject()) {
                data = null;
            }
            if (data != null && (asJsonObject = data.getAsJsonObject()) != null && (jsonElement = asJsonObject.get(ResponseKeys.KEY_MESSAGE)) != null && (asJsonObject2 = jsonElement.getAsJsonObject()) != null && (jsonElement2 = asJsonObject2.get("content")) != null && (asString = jsonElement2.getAsString()) != null && (strReplace = StringsKt.replace(asString, "```json", "", true)) != null && (strReplace$default = StringsKt.replace$default(strReplace, "```", "", false, 4, (Object) null)) != null && (string = StringsKt.trim(strReplace$default).toString()) != null) {
                try {
                    JsonElement jsonElement3 = JsonParser.parseString(string).getAsJsonObject().get("summary");
                    if (jsonElement3 != null) {
                        asString2 = jsonElement3.getAsString();
                    }
                } catch (Exception unused) {
                }
            }
            if (asString2 != null) {
                return asString2;
            }
            throw new SerializationException("Failed to parse summary JSON");
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository
    public Object fetchArticleSummary(String str, String str2, String str3, String str4, String str5, Continuation<? super ResponseResource<String>> continuation) {
        return SafeCall.api$default(SafeCall.INSTANCE, TAG, null, new C02012(str, str2, str3, str4, str5, null), new AnonymousClass3(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$fetchArticleSummary$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationMessageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/summary/ConversationArticleSummaryResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$fetchArticleSummary$2", f = "ConversationMessageRepositoryImpl.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
    static final class C02012 extends SuspendLambda implements Function1<Continuation<? super ConversationArticleSummaryResponse>, Object> {
        final /* synthetic */ String $customerId;
        final /* synthetic */ String $deviceId;
        final /* synthetic */ String $gmailId;
        final /* synthetic */ String $link;
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02012(String str, String str2, String str3, String str4, String str5, Continuation<? super C02012> continuation) {
            super(1, continuation);
            this.$deviceId = str;
            this.$gmailId = str2;
            this.$customerId = str3;
            this.$token = str4;
            this.$link = str5;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationMessageRepositoryImpl.this.new C02012(this.$deviceId, this.$gmailId, this.$customerId, this.$token, this.$link, continuation);
        }

        public final Object invoke(Continuation<? super ConversationArticleSummaryResponse> continuation) {
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
            Object objGenerateArticleSummary = ConversationMessageRepositoryImpl.this.conversationSummaryApi.generateArticleSummary(new ConversationArticleSummaryRequest(this.$deviceId, this.$gmailId, this.$customerId, this.$token, this.$link), (Continuation) this);
            return objGenerateArticleSummary == coroutine_suspended ? coroutine_suspended : objGenerateArticleSummary;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$fetchArticleSummary$3, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationMessageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "response", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/summary/ConversationArticleSummaryResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl$fetchArticleSummary$3", f = "ConversationMessageRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<ConversationArticleSummaryResponse, Continuation<? super String>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        public final Object invoke(ConversationArticleSummaryResponse conversationArticleSummaryResponse, Continuation<? super String> continuation) {
            return create(conversationArticleSummaryResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            ConversationArticleSummaryResponse conversationArticleSummaryResponse = (ConversationArticleSummaryResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return conversationArticleSummaryResponse.getTitle() + "\n\n" + StringsKt.trim(StringsKt.replace$default(StringsKt.replace(conversationArticleSummaryResponse.getData(), "```json", "", true), "```", "", false, 4, (Object) null)).toString();
        }
    }

    /* JADX INFO: compiled from: ConversationMessageRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/repository/ConversationMessageRepositoryImpl$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
