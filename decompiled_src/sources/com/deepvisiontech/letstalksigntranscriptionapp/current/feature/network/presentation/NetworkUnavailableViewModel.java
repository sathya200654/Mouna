package com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.network.data.NetworkMonitor;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import com.google.protobuf.DescriptorProtos;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: NetworkUnavailableViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/feature/network/presentation/NetworkUnavailableViewModel;", "Landroidx/lifecycle/ViewModel;", "networkMonitor", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/network/data/NetworkMonitor;", "webViewManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/network/data/NetworkMonitor;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;)V", "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/feature/network/presentation/NetworkUnavailableEvent;", "events", "Lkotlinx/coroutines/flow/Flow;", "getEvents", "()Lkotlinx/coroutines/flow/Flow;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NetworkUnavailableViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableSharedFlow<NetworkUnavailableEvent> _events;
    private final Flow<NetworkUnavailableEvent> events;

    @Inject
    public NetworkUnavailableViewModel(NetworkMonitor networkMonitor, WebViewManager webViewManager) {
        Intrinsics.checkNotNullParameter(networkMonitor, "networkMonitor");
        Intrinsics.checkNotNullParameter(webViewManager, "webViewManager");
        MutableSharedFlow<NetworkUnavailableEvent> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._events = mutableSharedFlowMutableSharedFlow$default;
        this.events = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(networkMonitor, webViewManager, this, null), 3, (Object) null);
    }

    public final Flow<NetworkUnavailableEvent> getEvents() {
        return this.events;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.NetworkUnavailableViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: NetworkUnavailableViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.NetworkUnavailableViewModel$1", f = "NetworkUnavailableViewModel.kt", i = {}, l = {DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NetworkMonitor $networkMonitor;
        final /* synthetic */ WebViewManager $webViewManager;
        int label;
        final /* synthetic */ NetworkUnavailableViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NetworkMonitor networkMonitor, WebViewManager webViewManager, NetworkUnavailableViewModel networkUnavailableViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$networkMonitor = networkMonitor;
            this.$webViewManager = webViewManager;
            this.this$0 = networkUnavailableViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$networkMonitor, this.$webViewManager, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<Boolean> flowIsConnected = this.$networkMonitor.isConnected();
                final WebViewManager webViewManager = this.$webViewManager;
                final NetworkUnavailableViewModel networkUnavailableViewModel = this.this$0;
                this.label = 1;
                if (flowIsConnected.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.NetworkUnavailableViewModel.1.1
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        if (z) {
                            webViewManager.reload();
                            Object objEmit = networkUnavailableViewModel._events.emit(NetworkUnavailableEvent.NavigateToAuthGraph.INSTANCE, continuation);
                            return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
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
}
