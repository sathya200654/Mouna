package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import io.grpc.Metadata;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class GrpcClientModule_ProvidesApiKeyHeadersFactory implements Factory<Metadata> {
    private final GrpcClientModule module;

    public GrpcClientModule_ProvidesApiKeyHeadersFactory(GrpcClientModule grpcClientModule) {
        this.module = grpcClientModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Metadata m2085get() {
        return providesApiKeyHeaders(this.module);
    }

    public static GrpcClientModule_ProvidesApiKeyHeadersFactory create(GrpcClientModule grpcClientModule) {
        return new GrpcClientModule_ProvidesApiKeyHeadersFactory(grpcClientModule);
    }

    public static Metadata providesApiKeyHeaders(GrpcClientModule grpcClientModule) {
        return (Metadata) Preconditions.checkNotNullFromProvides(grpcClientModule.providesApiKeyHeaders());
    }
}
