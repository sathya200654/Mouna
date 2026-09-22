package com.microsoft.cognitiveservices.speech.util;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
class ConnectivityCallback extends ConnectivityManager.NetworkCallback {
    private boolean m_metered;
    private final HttpClient m_parent;

    ConnectivityCallback(HttpClient httpClient, boolean z) {
        this.m_parent = httpClient;
        this.m_metered = z;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        boolean z = !networkCapabilities.hasCapability(11);
        if (z != this.m_metered) {
            this.m_metered = z;
            this.m_parent.onCostChange(z);
        }
    }
}
