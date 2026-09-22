package com.google.firebase.inappmessaging.display.internal;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class FiamWindowManager_Factory implements Factory<FiamWindowManager> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public FiamWindowManager m1965get() {
        return newInstance();
    }

    public static FiamWindowManager_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FiamWindowManager newInstance() {
        return new FiamWindowManager();
    }

    private static final class InstanceHolder {
        private static final FiamWindowManager_Factory INSTANCE = new FiamWindowManager_Factory();

        private InstanceHolder() {
        }
    }
}
