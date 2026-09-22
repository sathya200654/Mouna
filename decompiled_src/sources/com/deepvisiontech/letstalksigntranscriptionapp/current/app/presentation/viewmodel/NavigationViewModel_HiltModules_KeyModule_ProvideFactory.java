package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NavigationViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Boolean m1357get() {
        return Boolean.valueOf(provide());
    }

    public static NavigationViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return NavigationViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final NavigationViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new NavigationViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
