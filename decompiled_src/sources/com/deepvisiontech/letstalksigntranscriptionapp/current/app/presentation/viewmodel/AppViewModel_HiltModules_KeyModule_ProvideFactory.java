package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AppViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Boolean m1355get() {
        return Boolean.valueOf(provide());
    }

    public static AppViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return AppViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final AppViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new AppViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
