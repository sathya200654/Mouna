package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import io.grpc.Channel;
import io.grpc.Metadata;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory implements Factory<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> {
    private final Provider<Channel> channelProvider;
    private final Provider<Metadata> metadataProvider;
    private final GrpcClientModule module;

    public GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory(GrpcClientModule grpcClientModule, Provider<Channel> provider, Provider<Metadata> provider2) {
        this.module = grpcClientModule;
        this.channelProvider = provider;
        this.metadataProvider = provider2;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub m2086get() {
        return providesInAppMessagingSdkServingStub(this.module, (Channel) this.channelProvider.get(), (Metadata) this.metadataProvider.get());
    }

    public static GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory create(GrpcClientModule grpcClientModule, Provider<Channel> provider, Provider<Metadata> provider2) {
        return new GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory(grpcClientModule, provider, provider2);
    }

    public static InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub providesInAppMessagingSdkServingStub(GrpcClientModule grpcClientModule, Channel channel, Metadata metadata) {
        return (InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub) Preconditions.checkNotNullFromProvides(grpcClientModule.providesInAppMessagingSdkServingStub(channel, metadata));
    }
}
