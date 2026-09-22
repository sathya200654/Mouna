package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.helpers;

import android.util.Log;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.response.ConversationDataResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.response.ConversationError;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ConversationSafeApiCall.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aJ\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0086@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"safeConversationApiCall", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/response/ConversationDataResponse;", "T", "tag", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "apiCall", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ConversationSafeApiCallKt {
    public static /* synthetic */ Object safeConversationApiCall$default(String str, CoroutineDispatcher coroutineDispatcher, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineDispatcher = Dispatchers.getIO();
        }
        return safeConversationApiCall(str, coroutineDispatcher, function1, continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.helpers.ConversationSafeApiCallKt$safeConversationApiCall$2, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationSafeApiCall.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/response/ConversationDataResponse;", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.helpers.ConversationSafeApiCallKt$safeConversationApiCall$2", f = "ConversationSafeApiCall.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ConversationDataResponse<? extends T>>, Object> {
        final /* synthetic */ Function1<Continuation<? super T>, Object> $apiCall;
        final /* synthetic */ String $tag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Function1<? super Continuation<? super T>, ? extends Object> function1, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$apiCall = function1;
            this.$tag = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2<>(this.$apiCall, this.$tag, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ConversationDataResponse<? extends T>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function1<Continuation<? super T>, Object> function1 = this.$apiCall;
                    this.label = 1;
                    obj = function1.invoke(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return new ConversationDataResponse.Success(obj);
            } catch (IOException e) {
                Log.e(this.$tag, "Network/Disk Error during API call: " + e.getMessage(), e);
                return new ConversationDataResponse.Error(new ConversationError.NetworkError("Connection/Disk Error: " + e.getMessage()));
            } catch (Exception e2) {
                Log.e(this.$tag, "Unknown Exception during API call: " + e2.getMessage(), e2);
                String message = e2.getMessage();
                if (message == null) {
                    message = "Unknown error";
                }
                return new ConversationDataResponse.Error(new ConversationError.UnknownError(message));
            }
        }
    }

    public static final <T> Object safeConversationApiCall(String str, CoroutineDispatcher coroutineDispatcher, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super ConversationDataResponse<? extends T>> continuation) {
        return BuildersKt.withContext((CoroutineContext) coroutineDispatcher, new AnonymousClass2(function1, str, null), continuation);
    }
}
