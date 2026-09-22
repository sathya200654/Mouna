package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels;

import dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class CredentialViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Boolean m1390get() {
        return Boolean.valueOf(provide());
    }

    public static CredentialViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return CredentialViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final CredentialViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new CredentialViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
