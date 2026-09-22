package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels;

import dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationSharedViewModel_Factory implements Factory<ConversationSharedViewModel> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationSharedViewModel m1454get() {
        return newInstance();
    }

    public static ConversationSharedViewModel_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ConversationSharedViewModel newInstance() {
        return new ConversationSharedViewModel();
    }

    private static final class InstanceHolder {
        static final ConversationSharedViewModel_Factory INSTANCE = new ConversationSharedViewModel_Factory();

        private InstanceHolder() {
        }
    }
}
