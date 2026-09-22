package com.google.firebase.perf.config;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
abstract class ConfigurationFlag<T> {
    protected abstract T getDefault();

    String getDeviceCacheFlag() {
        return null;
    }

    String getMetadataFlag() {
        return null;
    }

    String getRemoteConfigFlag() {
        return null;
    }

    ConfigurationFlag() {
    }

    protected T getDefaultOnRcFetchFail() {
        return getDefault();
    }
}
