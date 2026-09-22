package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ImpressionStorageClient_Factory implements Factory<ImpressionStorageClient> {
    private final Provider<ProtoStorageClient> storageClientProvider;

    public ImpressionStorageClient_Factory(Provider<ProtoStorageClient> provider) {
        this.storageClientProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ImpressionStorageClient m2016get() {
        return newInstance((ProtoStorageClient) this.storageClientProvider.get());
    }

    public static ImpressionStorageClient_Factory create(Provider<ProtoStorageClient> provider) {
        return new ImpressionStorageClient_Factory(provider);
    }

    public static ImpressionStorageClient newInstance(ProtoStorageClient protoStorageClient) {
        return new ImpressionStorageClient(protoStorageClient);
    }
}
