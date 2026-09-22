package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository;

import androidx.wear.compose.foundation.SwipeToRevealKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.SuggestionWithCategoryTuple;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionCategoryEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionSentenceEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.mappers.ConversationInputSuggestionMapperKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationSuggestionsApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.suggestion.CorrectionSuggestionRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.suggestion.CorrectionSuggestionResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.suggestion.InputSuggestionRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.suggestion.InputSuggestionResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.ConversationSuggestion;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.CorrectionSuggestion;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.SuggestionCategory;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.DescriptorProtos;
import io.grpc.internal.GrpcUtil;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ConversationSuggestionRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0016J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\u0006\u0010\u0018\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0019J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\u0006\u0010\u0013\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011JJ\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\n0\r2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020 H\u0096@¢\u0006\u0002\u0010'J:\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 H\u0096@¢\u0006\u0002\u0010)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/repository/ConversationSuggestionRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/conversationsuggestion/ConversationSuggestionRepository;", "dao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationInputSuggestionDao;", "conversationSuggestionsApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationSuggestionsApi;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationInputSuggestionDao;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationSuggestionsApi;)V", "getAllSuggestions", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;", "insertInputSuggestionCategory", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "category", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertInputSuggestion", "suggestion", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSuggestionWithCategory", "deleteInputSuggestion", "", "suggestionId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteInputSuggestionCategory", "updateInputSuggestion", "updateInputSuggestionCategory", "fetchCorrectionSuggestion", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;", "deviceId", "", "gmailId", "customerId", "token", "inputLang", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "sentence", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPredefinedSuggestions", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationSuggestionRepositoryImpl implements ConversationSuggestionRepository {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "ConversationSuggestionRepositoryImpl";
    private final ConversationSuggestionsApi conversationSuggestionsApi;
    private final ConversationInputSuggestionDao dao;

    @Inject
    public ConversationSuggestionRepositoryImpl(ConversationInputSuggestionDao conversationInputSuggestionDao, ConversationSuggestionsApi conversationSuggestionsApi) {
        Intrinsics.checkNotNullParameter(conversationInputSuggestionDao, "dao");
        Intrinsics.checkNotNullParameter(conversationSuggestionsApi, "conversationSuggestionsApi");
        this.dao = conversationInputSuggestionDao;
        this.conversationSuggestionsApi = conversationSuggestionsApi;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository
    public Flow<List<ConversationSuggestion>> getAllSuggestions() {
        final Flow<List<SuggestionWithCategoryTuple>> allSuggestionsWithCategories = this.dao.getAllSuggestionsWithCategories();
        return FlowKt.flowOn(new Flow<List<? extends ConversationSuggestion>>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$getAllSuggestions$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$getAllSuggestions$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$getAllSuggestions$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$getAllSuggestions$$inlined$map$1$2", f = "ConversationSuggestionRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                            arrayList.add(ConversationInputSuggestionMapperKt.toDomain((SuggestionWithCategoryTuple) it.next()));
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
                Object objCollect = allSuggestionsWithCategories.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, Dispatchers.getIO());
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$insertInputSuggestionCategory$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSuggestionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$insertInputSuggestionCategory$2", f = "ConversationSuggestionRepositoryImpl.kt", i = {}, l = {DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
    static final class C02222 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {
        final /* synthetic */ SuggestionCategory $category;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02222(SuggestionCategory suggestionCategory, Continuation<? super C02222> continuation) {
            super(1, continuation);
            this.$category = suggestionCategory;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationSuggestionRepositoryImpl.this.new C02222(this.$category, continuation);
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
            Object objInsertCategory = ConversationSuggestionRepositoryImpl.this.dao.insertCategory(ConversationInputSuggestionMapperKt.toEntity(this.$category), (Continuation) this);
            return objInsertCategory == coroutine_suspended ? coroutine_suspended : objInsertCategory;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository
    public Object insertInputSuggestionCategory(SuggestionCategory suggestionCategory, Continuation<? super ResponseResource<Long>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02222(suggestionCategory, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$insertInputSuggestion$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSuggestionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$insertInputSuggestion$2", f = "ConversationSuggestionRepositoryImpl.kt", i = {}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "invokeSuspend", n = {}, s = {})
    static final class C02212 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {
        final /* synthetic */ ConversationSuggestion $suggestion;
        int label;
        final /* synthetic */ ConversationSuggestionRepositoryImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02212(ConversationSuggestion conversationSuggestion, ConversationSuggestionRepositoryImpl conversationSuggestionRepositoryImpl, Continuation<? super C02212> continuation) {
            super(1, continuation);
            this.$suggestion = conversationSuggestion;
            this.this$0 = conversationSuggestionRepositoryImpl;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C02212(this.$suggestion, this.this$0, continuation);
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
            if (this.$suggestion.getCategory().getId() != 0) {
                this.label = 1;
                Object objInsertSuggestion = this.this$0.dao.insertSuggestion(ConversationInputSuggestionMapperKt.toEntity(this.$suggestion), (Continuation) this);
                return objInsertSuggestion == coroutine_suspended ? coroutine_suspended : objInsertSuggestion;
            }
            throw new IllegalArgumentException("Category ID cannot be 0 when inserting a suggestion. Insert Category first.");
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository
    public Object insertInputSuggestion(ConversationSuggestion conversationSuggestion, Continuation<? super ResponseResource<Long>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02212(conversationSuggestion, this, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$insertSuggestionWithCategory$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSuggestionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$insertSuggestionWithCategory$2", f = "ConversationSuggestionRepositoryImpl.kt", i = {0, 0}, l = {68}, m = "invokeSuspend", n = {"categoryEntity", "suggestionEntity"}, s = {"L$0", "L$1"})
    static final class C02232 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {
        final /* synthetic */ ConversationSuggestion $suggestion;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ConversationSuggestionRepositoryImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02232(ConversationSuggestion conversationSuggestion, ConversationSuggestionRepositoryImpl conversationSuggestionRepositoryImpl, Continuation<? super C02232> continuation) {
            super(1, continuation);
            this.$suggestion = conversationSuggestion;
            this.this$0 = conversationSuggestionRepositoryImpl;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C02232(this.$suggestion, this.this$0, continuation);
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
            ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity = new ConversationInputSuggestionCategoryEntity(this.$suggestion.getCategory().getId(), this.$suggestion.getCategory().getName());
            ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity = new ConversationInputSuggestionSentenceEntity(this.$suggestion.getId(), this.$suggestion.getText(), this.$suggestion.getCategory().getId(), this.$suggestion.getLanguage());
            this.L$0 = SpillingKt.nullOutSpilledVariable(conversationInputSuggestionCategoryEntity);
            this.L$1 = SpillingKt.nullOutSpilledVariable(conversationInputSuggestionSentenceEntity);
            this.label = 1;
            Object objInsertSuggestionWithCategory = this.this$0.dao.insertSuggestionWithCategory(conversationInputSuggestionCategoryEntity, conversationInputSuggestionSentenceEntity, (Continuation) this);
            return objInsertSuggestionWithCategory == coroutine_suspended ? coroutine_suspended : objInsertSuggestionWithCategory;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository
    public Object insertSuggestionWithCategory(ConversationSuggestion conversationSuggestion, Continuation<? super ResponseResource<Long>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02232(conversationSuggestion, this, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$deleteInputSuggestion$2, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationSuggestionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$deleteInputSuggestion$2", f = "ConversationSuggestionRepositoryImpl.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ long $suggestionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(long j, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$suggestionId = j;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationSuggestionRepositoryImpl.this.new AnonymousClass2(this.$suggestionId, continuation);
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
                if (ConversationSuggestionRepositoryImpl.this.dao.deleteSuggestionById(this.$suggestionId, (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository
    public Object deleteInputSuggestion(long j, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new AnonymousClass2(j, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$deleteInputSuggestionCategory$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSuggestionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$deleteInputSuggestionCategory$2", f = "ConversationSuggestionRepositoryImpl.kt", i = {}, l = {GrpcUtil.DEFAULT_PORT_PLAINTEXT}, m = "invokeSuspend", n = {}, s = {})
    static final class C02172 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ SuggestionCategory $category;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02172(SuggestionCategory suggestionCategory, Continuation<? super C02172> continuation) {
            super(1, continuation);
            this.$category = suggestionCategory;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationSuggestionRepositoryImpl.this.new C02172(this.$category, continuation);
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
                if (ConversationSuggestionRepositoryImpl.this.dao.deleteCategory(ConversationInputSuggestionMapperKt.toEntity(this.$category), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository
    public Object deleteInputSuggestionCategory(SuggestionCategory suggestionCategory, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02172(suggestionCategory, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$updateInputSuggestion$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSuggestionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$updateInputSuggestion$2", f = "ConversationSuggestionRepositoryImpl.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
    static final class C02242 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationSuggestion $suggestion;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02242(ConversationSuggestion conversationSuggestion, Continuation<? super C02242> continuation) {
            super(1, continuation);
            this.$suggestion = conversationSuggestion;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationSuggestionRepositoryImpl.this.new C02242(this.$suggestion, continuation);
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
                if (ConversationSuggestionRepositoryImpl.this.dao.updateSuggestion(ConversationInputSuggestionMapperKt.toEntity(this.$suggestion), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository
    public Object updateInputSuggestion(ConversationSuggestion conversationSuggestion, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02242(conversationSuggestion, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$updateInputSuggestionCategory$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSuggestionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$updateInputSuggestionCategory$2", f = "ConversationSuggestionRepositoryImpl.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
    static final class C02252 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ SuggestionCategory $category;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02252(SuggestionCategory suggestionCategory, Continuation<? super C02252> continuation) {
            super(1, continuation);
            this.$category = suggestionCategory;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationSuggestionRepositoryImpl.this.new C02252(this.$category, continuation);
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
                if (ConversationSuggestionRepositoryImpl.this.dao.updateCategory(ConversationInputSuggestionMapperKt.toEntity(this.$category), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository
    public Object updateInputSuggestionCategory(SuggestionCategory suggestionCategory, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02252(suggestionCategory, null), continuation, 2, null);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository
    public Object fetchCorrectionSuggestion(String str, String str2, String str3, String str4, LanguageEnum languageEnum, String str5, Continuation<? super ResponseResource<? extends List<CorrectionSuggestion>>> continuation) {
        return SafeCall.api$default(SafeCall.INSTANCE, TAG, null, new C02182(str, str2, str3, str4, languageEnum, str5, null), new AnonymousClass3(languageEnum, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$fetchCorrectionSuggestion$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSuggestionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/suggestion/CorrectionSuggestionResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$fetchCorrectionSuggestion$2", f = "ConversationSuggestionRepositoryImpl.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
    static final class C02182 extends SuspendLambda implements Function1<Continuation<? super CorrectionSuggestionResponse>, Object> {
        final /* synthetic */ String $customerId;
        final /* synthetic */ String $deviceId;
        final /* synthetic */ String $gmailId;
        final /* synthetic */ LanguageEnum $inputLang;
        final /* synthetic */ String $sentence;
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02182(String str, String str2, String str3, String str4, LanguageEnum languageEnum, String str5, Continuation<? super C02182> continuation) {
            super(1, continuation);
            this.$deviceId = str;
            this.$gmailId = str2;
            this.$customerId = str3;
            this.$token = str4;
            this.$inputLang = languageEnum;
            this.$sentence = str5;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationSuggestionRepositoryImpl.this.new C02182(this.$deviceId, this.$gmailId, this.$customerId, this.$token, this.$inputLang, this.$sentence, continuation);
        }

        public final Object invoke(Continuation<? super CorrectionSuggestionResponse> continuation) {
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
            Object correctionSuggestions = ConversationSuggestionRepositoryImpl.this.conversationSuggestionsApi.getCorrectionSuggestions(new CorrectionSuggestionRequest(this.$deviceId, this.$gmailId, this.$customerId, this.$token, this.$inputLang.getLanguageCode(), this.$sentence), (Continuation) this);
            return correctionSuggestions == coroutine_suspended ? coroutine_suspended : correctionSuggestions;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$fetchCorrectionSuggestion$3, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationSuggestionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;", "response", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/suggestion/CorrectionSuggestionResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$fetchCorrectionSuggestion$3", f = "ConversationSuggestionRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CorrectionSuggestionResponse, Continuation<? super List<? extends CorrectionSuggestion>>, Object> {
        final /* synthetic */ LanguageEnum $inputLang;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(LanguageEnum languageEnum, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$inputLang = languageEnum;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass3 = new AnonymousClass3(this.$inputLang, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        public final Object invoke(CorrectionSuggestionResponse correctionSuggestionResponse, Continuation<? super List<CorrectionSuggestion>> continuation) {
            return create(correctionSuggestionResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            CorrectionSuggestionResponse correctionSuggestionResponse = (CorrectionSuggestionResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String sentence1 = correctionSuggestionResponse.getSentence1();
            if (sentence1 == null) {
                throw new IllegalStateException("Sentence 1 cannot be null");
            }
            String sentence2 = correctionSuggestionResponse.getSentence2();
            if (sentence2 == null) {
                throw new IllegalStateException("Sentence 2 cannot be null");
            }
            String sentence3 = correctionSuggestionResponse.getSentence3();
            if (sentence3 == null) {
                throw new IllegalStateException("Sentence 3 cannot be null");
            }
            return CollectionsKt.listOf(new CorrectionSuggestion[]{new CorrectionSuggestion(0, sentence1, this.$inputLang), new CorrectionSuggestion(1, sentence2, this.$inputLang), new CorrectionSuggestion(2, sentence3, this.$inputLang)});
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository
    public Object fetchPredefinedSuggestions(String str, String str2, String str3, String str4, Continuation<? super ResponseResource<? extends List<ConversationSuggestion>>> continuation) {
        return SafeCall.api$default(SafeCall.INSTANCE, TAG, null, new C02192(str, str2, str3, str4, null), new C02203(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$fetchPredefinedSuggestions$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSuggestionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/suggestion/InputSuggestionResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$fetchPredefinedSuggestions$2", f = "ConversationSuggestionRepositoryImpl.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
    static final class C02192 extends SuspendLambda implements Function1<Continuation<? super InputSuggestionResponse>, Object> {
        final /* synthetic */ String $customerId;
        final /* synthetic */ String $deviceId;
        final /* synthetic */ String $gmailId;
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02192(String str, String str2, String str3, String str4, Continuation<? super C02192> continuation) {
            super(1, continuation);
            this.$deviceId = str;
            this.$gmailId = str2;
            this.$customerId = str3;
            this.$token = str4;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationSuggestionRepositoryImpl.this.new C02192(this.$deviceId, this.$gmailId, this.$customerId, this.$token, continuation);
        }

        public final Object invoke(Continuation<? super InputSuggestionResponse> continuation) {
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
            Object inputSuggestions = ConversationSuggestionRepositoryImpl.this.conversationSuggestionsApi.getInputSuggestions(new InputSuggestionRequest(this.$deviceId, this.$gmailId, this.$customerId, this.$token), (Continuation) this);
            return inputSuggestions == coroutine_suspended ? coroutine_suspended : inputSuggestions;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$fetchPredefinedSuggestions$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSuggestionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;", "response", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/suggestion/InputSuggestionResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$fetchPredefinedSuggestions$3", f = "ConversationSuggestionRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02203 extends SuspendLambda implements Function2<InputSuggestionResponse, Continuation<? super List<? extends ConversationSuggestion>>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C02203(Continuation<? super C02203> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c02203 = new C02203(continuation);
            c02203.L$0 = obj;
            return c02203;
        }

        public final Object invoke(InputSuggestionResponse inputSuggestionResponse, Continuation<? super List<ConversationSuggestion>> continuation) {
            return create(inputSuggestionResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Map map;
            InputSuggestionResponse inputSuggestionResponse = (InputSuggestionResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            JsonElement data = inputSuggestionResponse.getData();
            if (data == null) {
                throw new IllegalStateException("Response data cannot be null.");
            }
            Type type = new TypeToken<Map<String, ? extends List<? extends String>>>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl$fetchPredefinedSuggestions$3$type$1
            }.getType();
            try {
                if (data.isJsonObject()) {
                    map = (Map) new Gson().fromJson(data, type);
                } else {
                    map = (Map) new Gson().fromJson(data.getAsString(), type);
                }
                Intrinsics.checkNotNull(map);
                if (map.isEmpty()) {
                    throw new IllegalStateException("Parsed input suggestions data is empty.");
                }
                Set setEntrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (Object obj2 : setEntrySet) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Map.Entry entry = (Map.Entry) obj2;
                    SuggestionCategory suggestionCategory = new SuggestionCategory(i, (String) entry.getKey());
                    Iterable iterable = (Iterable) entry.getValue();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                    int i3 = 0;
                    for (Object obj3 : iterable) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        arrayList2.add(new ConversationSuggestion(i3, (String) obj3, LanguageEnum.ENGLISH, suggestionCategory));
                        i3 = i4;
                    }
                    CollectionsKt.addAll(arrayList, arrayList2);
                    i = i2;
                }
                return arrayList;
            } catch (Exception e) {
                throw new IllegalStateException("Failed to parse input suggestions data.", e);
            }
        }
    }

    /* JADX INFO: compiled from: ConversationSuggestionRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/repository/ConversationSuggestionRepositoryImpl$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
