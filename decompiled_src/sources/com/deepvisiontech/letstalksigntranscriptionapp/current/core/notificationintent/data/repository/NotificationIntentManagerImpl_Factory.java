package com.deepvisiontech.letstalksigntranscriptionapp.current.core.notificationintent.data.repository;

import dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NotificationIntentManagerImpl_Factory implements Factory<NotificationIntentManagerImpl> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NotificationIntentManagerImpl m1692get() {
        return newInstance();
    }

    public static NotificationIntentManagerImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static NotificationIntentManagerImpl newInstance() {
        return new NotificationIntentManagerImpl();
    }

    private static final class InstanceHolder {
        static final NotificationIntentManagerImpl_Factory INSTANCE = new NotificationIntentManagerImpl_Factory();

        private InstanceHolder() {
        }
    }
}
