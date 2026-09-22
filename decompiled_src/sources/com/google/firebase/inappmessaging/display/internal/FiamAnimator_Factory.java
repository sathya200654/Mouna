package com.google.firebase.inappmessaging.display.internal;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class FiamAnimator_Factory implements Factory<FiamAnimator> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public FiamAnimator m1963get() {
        return newInstance();
    }

    public static FiamAnimator_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FiamAnimator newInstance() {
        return new FiamAnimator();
    }

    private static final class InstanceHolder {
        private static final FiamAnimator_Factory INSTANCE = new FiamAnimator_Factory();

        private InstanceHolder() {
        }
    }
}
