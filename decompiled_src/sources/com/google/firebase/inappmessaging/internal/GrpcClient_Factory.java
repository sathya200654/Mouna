package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class GrpcClient_Factory implements Factory<GrpcClient> {
    private final Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> stubProvider;

    public GrpcClient_Factory(Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> provider) {
        this.stubProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public GrpcClient m2009get() {
        return newInstance((InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub) this.stubProvider.get());
    }

    public static GrpcClient_Factory create(Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> provider) {
        return new GrpcClient_Factory(provider);
    }

    public static GrpcClient newInstance(InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub inAppMessagingSdkServingBlockingStub) {
        return new GrpcClient(inAppMessagingSdkServingBlockingStub);
    }
}
