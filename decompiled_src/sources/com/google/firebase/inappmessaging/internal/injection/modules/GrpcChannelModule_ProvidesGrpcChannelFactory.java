package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import io.grpc.Channel;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class GrpcChannelModule_ProvidesGrpcChannelFactory implements Factory<Channel> {
    private final Provider<String> hostProvider;
    private final GrpcChannelModule module;

    public GrpcChannelModule_ProvidesGrpcChannelFactory(GrpcChannelModule grpcChannelModule, Provider<String> provider) {
        this.module = grpcChannelModule;
        this.hostProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Channel m2083get() {
        return providesGrpcChannel(this.module, (String) this.hostProvider.get());
    }

    public static GrpcChannelModule_ProvidesGrpcChannelFactory create(GrpcChannelModule grpcChannelModule, Provider<String> provider) {
        return new GrpcChannelModule_ProvidesGrpcChannelFactory(grpcChannelModule, provider);
    }

    public static Channel providesGrpcChannel(GrpcChannelModule grpcChannelModule, String str) {
        return (Channel) Preconditions.checkNotNullFromProvides(grpcChannelModule.providesGrpcChannel(str));
    }
}
