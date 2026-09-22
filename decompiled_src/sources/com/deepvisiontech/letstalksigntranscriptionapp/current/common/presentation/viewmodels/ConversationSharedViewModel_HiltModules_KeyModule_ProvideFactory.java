package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels;

import dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationSharedViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Boolean m1455get() {
        return Boolean.valueOf(provide());
    }

    public static ConversationSharedViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return ConversationSharedViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final ConversationSharedViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new ConversationSharedViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
