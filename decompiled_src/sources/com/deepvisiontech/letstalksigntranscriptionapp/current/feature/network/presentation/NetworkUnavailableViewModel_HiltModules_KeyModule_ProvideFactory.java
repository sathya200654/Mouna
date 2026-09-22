package com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NetworkUnavailableViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Boolean m1713get() {
        return Boolean.valueOf(provide());
    }

    public static NetworkUnavailableViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return NetworkUnavailableViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final NetworkUnavailableViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new NetworkUnavailableViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
