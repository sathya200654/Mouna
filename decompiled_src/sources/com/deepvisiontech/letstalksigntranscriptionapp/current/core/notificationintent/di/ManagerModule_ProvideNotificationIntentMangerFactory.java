package com.deepvisiontech.letstalksigntranscriptionapp.current.core.notificationintent.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.notificationintent.domain.repository.NotificationIntentManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ManagerModule_ProvideNotificationIntentMangerFactory implements Factory<NotificationIntentManager> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NotificationIntentManager m1693get() {
        return provideNotificationIntentManger();
    }

    public static ManagerModule_ProvideNotificationIntentMangerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static NotificationIntentManager provideNotificationIntentManger() {
        return (NotificationIntentManager) Preconditions.checkNotNullFromProvides(ManagerModule.INSTANCE.provideNotificationIntentManger());
    }

    private static final class InstanceHolder {
        static final ManagerModule_ProvideNotificationIntentMangerFactory INSTANCE = new ManagerModule_ProvideNotificationIntentMangerFactory();

        private InstanceHolder() {
        }
    }
}
