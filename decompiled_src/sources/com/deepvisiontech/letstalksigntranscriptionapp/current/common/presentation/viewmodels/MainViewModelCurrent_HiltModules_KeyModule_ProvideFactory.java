package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels;

import dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class MainViewModelCurrent_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Boolean m1457get() {
        return Boolean.valueOf(provide());
    }

    public static MainViewModelCurrent_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return MainViewModelCurrent_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final MainViewModelCurrent_HiltModules_KeyModule_ProvideFactory INSTANCE = new MainViewModelCurrent_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
