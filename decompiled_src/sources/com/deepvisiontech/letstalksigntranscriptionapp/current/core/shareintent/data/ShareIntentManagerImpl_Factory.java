package com.deepvisiontech.letstalksigntranscriptionapp.current.core.shareintent.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ShareIntentManagerImpl_Factory implements Factory<ShareIntentManagerImpl> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ShareIntentManagerImpl m1694get() {
        return newInstance();
    }

    public static ShareIntentManagerImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ShareIntentManagerImpl newInstance() {
        return new ShareIntentManagerImpl();
    }

    private static final class InstanceHolder {
        static final ShareIntentManagerImpl_Factory INSTANCE = new ShareIntentManagerImpl_Factory();

        private InstanceHolder() {
        }
    }
}
