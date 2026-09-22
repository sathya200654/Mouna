package com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.network.data.NetworkMonitor;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NetworkUnavailableViewModel_Factory implements Factory<NetworkUnavailableViewModel> {
    private final Provider<NetworkMonitor> networkMonitorProvider;
    private final Provider<WebViewManager> webViewManagerProvider;

    private NetworkUnavailableViewModel_Factory(Provider<NetworkMonitor> networkMonitorProvider, Provider<WebViewManager> webViewManagerProvider) {
        this.networkMonitorProvider = networkMonitorProvider;
        this.webViewManagerProvider = webViewManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NetworkUnavailableViewModel m1712get() {
        return newInstance((NetworkMonitor) this.networkMonitorProvider.get(), (WebViewManager) this.webViewManagerProvider.get());
    }

    public static NetworkUnavailableViewModel_Factory create(Provider<NetworkMonitor> networkMonitorProvider, Provider<WebViewManager> webViewManagerProvider) {
        return new NetworkUnavailableViewModel_Factory(networkMonitorProvider, webViewManagerProvider);
    }

    public static NetworkUnavailableViewModel newInstance(NetworkMonitor networkMonitor, WebViewManager webViewManager) {
        return new NetworkUnavailableViewModel(networkMonitor, webViewManager);
    }
}
