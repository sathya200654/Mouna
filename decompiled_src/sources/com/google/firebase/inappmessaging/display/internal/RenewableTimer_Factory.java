package com.google.firebase.inappmessaging.display.internal;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class RenewableTimer_Factory implements Factory<RenewableTimer> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public RenewableTimer m1966get() {
        return newInstance();
    }

    public static RenewableTimer_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RenewableTimer newInstance() {
        return new RenewableTimer();
    }

    private static final class InstanceHolder {
        private static final RenewableTimer_Factory INSTANCE = new RenewableTimer_Factory();

        private InstanceHolder() {
        }
    }
}
