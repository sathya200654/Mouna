package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SignPracticeSessionViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Boolean m1859get() {
        return Boolean.valueOf(provide());
    }

    public static SignPracticeSessionViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return SignPracticeSessionViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final SignPracticeSessionViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new SignPracticeSessionViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
