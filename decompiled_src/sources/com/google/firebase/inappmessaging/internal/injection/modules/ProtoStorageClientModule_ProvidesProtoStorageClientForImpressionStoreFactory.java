package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory implements Factory<ProtoStorageClient> {
    private final Provider<Application> applicationProvider;
    private final ProtoStorageClientModule module;

    public ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory(ProtoStorageClientModule protoStorageClientModule, Provider<Application> provider) {
        this.module = protoStorageClientModule;
        this.applicationProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ProtoStorageClient m2091get() {
        return providesProtoStorageClientForImpressionStore(this.module, (Application) this.applicationProvider.get());
    }

    public static ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory create(ProtoStorageClientModule protoStorageClientModule, Provider<Application> provider) {
        return new ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory(protoStorageClientModule, provider);
    }

    public static ProtoStorageClient providesProtoStorageClientForImpressionStore(ProtoStorageClientModule protoStorageClientModule, Application application) {
        return (ProtoStorageClient) Preconditions.checkNotNullFromProvides(protoStorageClientModule.providesProtoStorageClientForImpressionStore(application));
    }
}
