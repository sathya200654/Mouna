package com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager;

import android.webkit.RenderProcessGoneDetail;
import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WebViewManagerImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$createWebView$1$1$onRenderProcessGone$1", f = "WebViewManagerImpl.kt", i = {0, 0, 1, 1}, l = {192, 195}, m = "invokeSuspend", n = {"error", ResponseKeys.KEY_MESSAGE, "error", ResponseKeys.KEY_MESSAGE}, s = {"L$0", "L$1", "L$0", "L$1"})
final class WebViewManagerImpl$createWebView$1$1$onRenderProcessGone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RenderProcessGoneDetail $detail;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WebViewManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebViewManagerImpl$createWebView$1$1$onRenderProcessGone$1(RenderProcessGoneDetail renderProcessGoneDetail, WebViewManagerImpl webViewManagerImpl, Continuation<? super WebViewManagerImpl$createWebView$1$1$onRenderProcessGone$1> continuation) {
        super(2, continuation);
        this.$detail = renderProcessGoneDetail;
        this.this$0 = webViewManagerImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewManagerImpl$createWebView$1$1$onRenderProcessGone$1(this.$detail, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a1, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$createWebView$1$1$onRenderProcessGone$1.AnonymousClass1(r8.this$0, null), (kotlin.coroutines.Continuation) r8) == r0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2f
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1b
            java.lang.Object r0 = r8.L$1
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r8 = r8.L$0
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r8 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto La4
        L1b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L23:
            java.lang.Object r1 = r8.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r3 = r8.L$0
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r3 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError) r3
            kotlin.ResultKt.throwOnFailure(r9)
            goto L71
        L2f:
            kotlin.ResultKt.throwOnFailure(r9)
            com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.mappers.WebViewErrorMapper r9 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.mappers.WebViewErrorMapper.INSTANCE
            android.webkit.RenderProcessGoneDetail r1 = r8.$detail
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r9 = r9.mapRenderProcessGone(r1)
            android.webkit.RenderProcessGoneDetail r1 = r8.$detail
            boolean r1 = r1.didCrash()
            if (r1 == 0) goto L45
            java.lang.String r1 = "Avatar renderer crashed."
            goto L47
        L45:
            java.lang.String r1 = "Avatar renderer killed by system."
        L47:
            com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl r4 = r8.this$0
            kotlinx.coroutines.flow.MutableSharedFlow r4 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl.access$get_webViewEvent$p(r4)
            com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewEvent$Error r5 = new com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewEvent$Error
            java.lang.String r6 = " Reloading..."
            java.lang.String r6 = r1.concat(r6)
            r5.<init>(r9, r6)
            r6 = r8
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r8.L$0 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r8.L$1 = r7
            r8.label = r3
            java.lang.Object r3 = r4.emit(r5, r6)
            if (r3 != r0) goto L70
            goto La3
        L70:
            r3 = r9
        L71:
            com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl r9 = r8.this$0
            kotlinx.coroutines.flow.MutableStateFlow r9 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl.access$get_webViewState$p(r9)
            com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewState$Error r4 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewState.Error.INSTANCE
            r9.setValue(r4)
            kotlinx.coroutines.MainCoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r9 = (kotlin.coroutines.CoroutineContext) r9
            com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$createWebView$1$1$onRenderProcessGone$1$1 r4 = new com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$createWebView$1$1$onRenderProcessGone$1$1
            com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl r5 = r8.this$0
            r6 = 0
            r4.<init>(r5, r6)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5 = r8
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r8.L$0 = r3
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r8.L$1 = r1
            r8.label = r2
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r9, r4, r5)
            if (r8 != r0) goto La4
        La3:
            return r0
        La4:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$createWebView$1$1$onRenderProcessGone$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$createWebView$1$1$onRenderProcessGone$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WebViewManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$createWebView$1$1$onRenderProcessGone$1$1", f = "WebViewManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.recreateWebView();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
