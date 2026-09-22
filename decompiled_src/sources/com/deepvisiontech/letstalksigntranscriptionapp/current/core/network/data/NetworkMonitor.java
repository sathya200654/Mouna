package com.deepvisiontech.letstalksigntranscriptionapp.current.core.network.data;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.google.protobuf.DescriptorProtos;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: NetworkMonitor.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/network/data/NetworkMonitor;", "", "connectivityManager", "Landroid/net/ConnectivityManager;", "<init>", "(Landroid/net/ConnectivityManager;)V", "isConnected", "Lkotlinx/coroutines/flow/Flow;", "", "()Lkotlinx/coroutines/flow/Flow;", "isNetworkAvailable", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NetworkMonitor {
    public static final int $stable = 8;
    private final ConnectivityManager connectivityManager;
    private final Flow<Boolean> isConnected;

    public NetworkMonitor(ConnectivityManager connectivityManager) {
        Intrinsics.checkNotNullParameter(connectivityManager, "connectivityManager");
        this.connectivityManager = connectivityManager;
        this.isConnected = FlowKt.distinctUntilChanged(FlowKt.callbackFlow(new AnonymousClass1(null)));
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.network.data.NetworkMonitor$isConnected$1, reason: invalid class name */
    /* JADX INFO: compiled from: NetworkMonitor.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.network.data.NetworkMonitor$isConnected$1", f = "NetworkMonitor.kt", i = {0, 0, 0}, l = {DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER}, m = "invokeSuspend", n = {"$this$callbackFlow", "networkCallback", "networkRequest"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super Boolean>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = NetworkMonitor.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(ProducerScope<? super Boolean> producerScope, Continuation<? super Unit> continuation) {
            return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r8v4, types: [com.deepvisiontech.letstalksigntranscriptionapp.current.core.network.data.NetworkMonitor$isConnected$1$networkCallback$1, java.lang.Object] */
        public final Object invokeSuspend(Object obj) {
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                producerScope.trySend-JP2dKIU(Boxing.boxBoolean(NetworkMonitor.this.isNetworkAvailable()));
                final ?? r8 = new ConnectivityManager.NetworkCallback() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.network.data.NetworkMonitor$isConnected$1$networkCallback$1
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onAvailable(Network network) {
                        Intrinsics.checkNotNullParameter(network, "network");
                        producerScope.trySend-JP2dKIU(true);
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onLost(Network network) {
                        Intrinsics.checkNotNullParameter(network, "network");
                        producerScope.trySend-JP2dKIU(false);
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                        Intrinsics.checkNotNullParameter(network, "network");
                        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
                        producerScope.trySend-JP2dKIU(Boolean.valueOf(networkCapabilities.hasCapability(12)));
                    }
                };
                NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).build();
                NetworkMonitor.this.connectivityManager.registerNetworkCallback(networkRequestBuild, (ConnectivityManager.NetworkCallback) r8);
                final NetworkMonitor networkMonitor = NetworkMonitor.this;
                this.L$0 = SpillingKt.nullOutSpilledVariable(producerScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable((Object) r8);
                this.L$2 = SpillingKt.nullOutSpilledVariable(networkRequestBuild);
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.network.data.NetworkMonitor$isConnected$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return NetworkMonitor.AnonymousClass1.invokeSuspend$lambda$0(networkMonitor, r8);
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(NetworkMonitor networkMonitor, NetworkMonitor$isConnected$1$networkCallback$1 networkMonitor$isConnected$1$networkCallback$1) {
            networkMonitor.connectivityManager.unregisterNetworkCallback(networkMonitor$isConnected$1$networkCallback$1);
            return Unit.INSTANCE;
        }
    }

    public final Flow<Boolean> isConnected() {
        return this.isConnected;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isNetworkAvailable() {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = this.connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = this.connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(12);
    }
}
