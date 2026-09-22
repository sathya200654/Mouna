package com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.wear.compose.foundation.SwipeToRevealKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.utils.ErrorMapper;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.google.flatbuffers.FlexBuffers;
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

/* JADX INFO: compiled from: SafeCall.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jx\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0007*\u00020\b\"\u0004\b\u0001\u0010\u00062\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e2\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0086@¢\u0006\u0002\u0010\u0012JJ\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0000\u0010\u00072\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u001c\u0010\u0014\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eH\u0086@¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/helper/SafeCall;", "", "<init>", "()V", "api", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "R", "T", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ApiContract;", "tag", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "apiCall", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "transform", "Lkotlin/Function2;", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "local", "localCall", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SafeCall {
    public static final int $stable = 0;
    public static final SafeCall INSTANCE = new SafeCall();

    private SafeCall() {
    }

    public static /* synthetic */ Object api$default(SafeCall safeCall, String str, CoroutineDispatcher coroutineDispatcher, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineDispatcher = Dispatchers.getIO();
        }
        return safeCall.api(str, coroutineDispatcher, function1, function2, continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall$api$2, reason: invalid class name */
    /* JADX INFO: compiled from: SafeCall.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall$api$2", f = "SafeCall.kt", i = {1}, l = {22, FlexBuffers.FBT_VECTOR_FLOAT4}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
    static final class AnonymousClass2<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResponseResource<? extends R>>, Object> {
        final /* synthetic */ Function1<Continuation<? super T>, Object> $apiCall;
        final /* synthetic */ String $tag;
        final /* synthetic */ Function2<T, Continuation<? super R>, Object> $transform;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super Continuation<? super T>, ? extends Object> function1, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$apiCall = function1;
            this.$transform = function2;
            this.$tag = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2<>(this.$apiCall, this.$transform, this.$tag, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResponseResource<? extends R>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
        
            if (r7 == r1) goto L23;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.String r0 = "API Logic Fail | Code: "
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r6.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L26
                if (r2 == r4) goto L20
                if (r2 != r3) goto L18
                java.lang.Object r0 = r6.L$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract r0 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract) r0
                kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L24
                goto L53
            L18:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L20:
                kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L24
                goto L34
            L24:
                r7 = move-exception
                goto L83
            L26:
                kotlin.ResultKt.throwOnFailure(r7)
                kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super T>, java.lang.Object> r7 = r6.$apiCall     // Catch: java.lang.Throwable -> L24
                r6.label = r4     // Catch: java.lang.Throwable -> L24
                java.lang.Object r7 = r7.invoke(r6)     // Catch: java.lang.Throwable -> L24
                if (r7 != r1) goto L34
                goto L52
            L34:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract r7 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract) r7     // Catch: java.lang.Throwable -> L24
                java.lang.String r2 = r7.getStatus()     // Catch: java.lang.Throwable -> L24
                java.lang.String r5 = "success"
                boolean r2 = kotlin.text.StringsKt.equals(r2, r5, r4)     // Catch: java.lang.Throwable -> L24
                if (r2 == 0) goto L5b
                kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r0 = r6.$transform     // Catch: java.lang.Throwable -> L24
                java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)     // Catch: java.lang.Throwable -> L24
                r6.L$0 = r2     // Catch: java.lang.Throwable -> L24
                r6.label = r3     // Catch: java.lang.Throwable -> L24
                java.lang.Object r7 = r0.invoke(r7, r6)     // Catch: java.lang.Throwable -> L24
                if (r7 != r1) goto L53
            L52:
                return r1
            L53:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Success r0 = new com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Success     // Catch: java.lang.Throwable -> L24
                r0.<init>(r7)     // Catch: java.lang.Throwable -> L24
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r0 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r0     // Catch: java.lang.Throwable -> L24
                return r0
            L5b:
                java.lang.String r1 = r6.$tag     // Catch: java.lang.Throwable -> L24
                java.lang.String r2 = r7.getErrorCode()     // Catch: java.lang.Throwable -> L24
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24
                r3.<init>(r0)     // Catch: java.lang.Throwable -> L24
                java.lang.StringBuilder r0 = r3.append(r2)     // Catch: java.lang.Throwable -> L24
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L24
                android.util.Log.e(r1, r0)     // Catch: java.lang.Throwable -> L24
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.utils.ErrorMapper r0 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.utils.ErrorMapper.INSTANCE     // Catch: java.lang.Throwable -> L24
                java.lang.String r7 = r7.getErrorCode()     // Catch: java.lang.Throwable -> L24
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r7 = r0.mapCodeToAppError(r7)     // Catch: java.lang.Throwable -> L24
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error r0 = new com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error     // Catch: java.lang.Throwable -> L24
                r0.<init>(r7)     // Catch: java.lang.Throwable -> L24
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r0 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r0     // Catch: java.lang.Throwable -> L24
                return r0
            L83:
                java.lang.String r6 = r6.$tag
                java.lang.String r0 = "API Crash"
                android.util.Log.e(r6, r0, r7)
                boolean r6 = r7 instanceof java.io.IOException
                if (r6 == 0) goto L93
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError$ServiceUnavailable r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError.ServiceUnavailable.INSTANCE
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError) r6
                goto La0
            L93:
                boolean r6 = r7 instanceof kotlinx.serialization.SerializationException
                if (r6 == 0) goto L9c
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError$ParsingError r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError.ParsingError.INSTANCE
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError) r6
                goto La0
            L9c:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError$UnknownError r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError.UnknownError.INSTANCE
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError) r6
            La0:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error r7 = new com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error
                r7.<init>(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r7 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r7
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final <T extends ApiContract, R> Object api(String str, CoroutineDispatcher coroutineDispatcher, Function1<? super Continuation<? super T>, ? extends Object> function1, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super ResponseResource<? extends R>> continuation) {
        return BuildersKt.withContext((CoroutineContext) coroutineDispatcher, new AnonymousClass2(function1, function2, str, null), continuation);
    }

    public static /* synthetic */ Object local$default(SafeCall safeCall, String str, CoroutineDispatcher coroutineDispatcher, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineDispatcher = Dispatchers.getIO();
        }
        return safeCall.local(str, coroutineDispatcher, function1, continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall$local$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SafeCall.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall$local$2", f = "SafeCall.kt", i = {}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "invokeSuspend", n = {}, s = {})
    static final class C01892<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResponseResource<? extends T>>, Object> {
        final /* synthetic */ Function1<Continuation<? super T>, Object> $localCall;
        final /* synthetic */ String $tag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01892(Function1<? super Continuation<? super T>, ? extends Object> function1, String str, Continuation<? super C01892> continuation) {
            super(2, continuation);
            this.$localCall = function1;
            this.$tag = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01892<>(this.$localCall, this.$tag, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResponseResource<? extends T>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            AppError.UnknownError unknownErrorMapIoError;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function1<Continuation<? super T>, Object> function1 = this.$localCall;
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
                return new ResponseResource.Success(obj);
            } catch (Throwable th) {
                Log.e(this.$tag, "Local/DB Exception", th);
                if (th instanceof SQLiteException) {
                    unknownErrorMapIoError = ErrorMapper.INSTANCE.mapDbError(th);
                } else {
                    unknownErrorMapIoError = th instanceof IOException ? ErrorMapper.INSTANCE.mapIoError(th) : AppError.UnknownError.INSTANCE;
                }
                return new ResponseResource.Error(unknownErrorMapIoError);
            }
        }
    }

    public final <T> Object local(String str, CoroutineDispatcher coroutineDispatcher, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super ResponseResource<? extends T>> continuation) {
        return BuildersKt.withContext((CoroutineContext) coroutineDispatcher, new C01892(function1, str, null), continuation);
    }
}
