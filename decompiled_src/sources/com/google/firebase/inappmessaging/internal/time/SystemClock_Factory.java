package com.google.firebase.inappmessaging.internal.time;

import com.google.firebase.inappmessaging.dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class SystemClock_Factory implements Factory<SystemClock> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SystemClock m2099get() {
        return newInstance();
    }

    public static SystemClock_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SystemClock newInstance() {
        return new SystemClock();
    }

    private static final class InstanceHolder {
        private static final SystemClock_Factory INSTANCE = new SystemClock_Factory();

        private InstanceHolder() {
        }
    }
}
