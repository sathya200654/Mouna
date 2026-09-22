package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels;

import dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SetUpViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Boolean m1392get() {
        return Boolean.valueOf(provide());
    }

    public static SetUpViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return SetUpViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final SetUpViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new SetUpViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
