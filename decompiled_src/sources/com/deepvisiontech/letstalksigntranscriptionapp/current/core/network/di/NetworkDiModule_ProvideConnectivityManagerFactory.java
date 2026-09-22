package com.deepvisiontech.letstalksigntranscriptionapp.current.core.network.di;

import android.content.Context;
import android.net.ConnectivityManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NetworkDiModule_ProvideConnectivityManagerFactory implements Factory<ConnectivityManager> {
    private final Provider<Context> contextProvider;

    private NetworkDiModule_ProvideConnectivityManagerFactory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConnectivityManager m1690get() {
        return provideConnectivityManager((Context) this.contextProvider.get());
    }

    public static NetworkDiModule_ProvideConnectivityManagerFactory create(Provider<Context> contextProvider) {
        return new NetworkDiModule_ProvideConnectivityManagerFactory(contextProvider);
    }

    public static ConnectivityManager provideConnectivityManager(Context context) {
        return (ConnectivityManager) Preconditions.checkNotNullFromProvides(NetworkDiModule.INSTANCE.provideConnectivityManager(context));
    }
}
