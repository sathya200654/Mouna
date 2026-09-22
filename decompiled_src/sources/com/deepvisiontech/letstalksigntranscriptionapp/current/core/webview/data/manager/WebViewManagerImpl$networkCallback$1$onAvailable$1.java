package com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: WebViewManagerImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$networkCallback$1$onAvailable$1", f = "WebViewManagerImpl.kt", i = {0}, l = {105}, m = "invokeSuspend", n = {RemoteConfigConstants.ResponseFieldKey.STATE}, s = {"L$0"})
final class WebViewManagerImpl$networkCallback$1$onAvailable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ WebViewManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebViewManagerImpl$networkCallback$1$onAvailable$1(WebViewManagerImpl webViewManagerImpl, Continuation<? super WebViewManagerImpl$networkCallback$1$onAvailable$1> continuation) {
        super(2, continuation);
        this.this$0 = webViewManagerImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewManagerImpl$networkCallback$1$onAvailable$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WebViewState webViewState = (WebViewState) this.this$0._webViewState.getValue();
            if ((webViewState instanceof WebViewState.Error) || (webViewState instanceof WebViewState.IsLoading)) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(webViewState);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$networkCallback$1$onAvailable$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WebViewManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$networkCallback$1$onAvailable$1$1", f = "WebViewManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ WebViewManagerImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(WebViewManagerImpl webViewManagerImpl, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = webViewManagerImpl;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.reload();
            return Unit.INSTANCE;
        }
    }
}
