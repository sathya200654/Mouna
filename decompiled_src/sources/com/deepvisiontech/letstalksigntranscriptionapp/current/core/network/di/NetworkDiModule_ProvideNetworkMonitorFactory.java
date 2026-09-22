package com.deepvisiontech.letstalksigntranscriptionapp.current.core.network.di;

import android.net.ConnectivityManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.network.data.NetworkMonitor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NetworkDiModule_ProvideNetworkMonitorFactory implements Factory<NetworkMonitor> {
    private final Provider<ConnectivityManager> connectivityManagerProvider;

    private NetworkDiModule_ProvideNetworkMonitorFactory(Provider<ConnectivityManager> connectivityManagerProvider) {
        this.connectivityManagerProvider = connectivityManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NetworkMonitor m1691get() {
        return provideNetworkMonitor((ConnectivityManager) this.connectivityManagerProvider.get());
    }

    public static NetworkDiModule_ProvideNetworkMonitorFactory create(Provider<ConnectivityManager> connectivityManagerProvider) {
        return new NetworkDiModule_ProvideNetworkMonitorFactory(connectivityManagerProvider);
    }

    public static NetworkMonitor provideNetworkMonitor(ConnectivityManager connectivityManager) {
        return (NetworkMonitor) Preconditions.checkNotNullFromProvides(NetworkDiModule.INSTANCE.provideNetworkMonitor(connectivityManager));
    }
}
