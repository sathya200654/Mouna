package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NotificationModule_ProvideNotificationDaoFactory implements Factory<NotificationDao> {
    private final Provider<LtsRoomDatabase> dbProvider;

    private NotificationModule_ProvideNotificationDaoFactory(Provider<LtsRoomDatabase> dbProvider) {
        this.dbProvider = dbProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NotificationDao m1724get() {
        return provideNotificationDao((LtsRoomDatabase) this.dbProvider.get());
    }

    public static NotificationModule_ProvideNotificationDaoFactory create(Provider<LtsRoomDatabase> dbProvider) {
        return new NotificationModule_ProvideNotificationDaoFactory(dbProvider);
    }

    public static NotificationDao provideNotificationDao(LtsRoomDatabase db) {
        return (NotificationDao) Preconditions.checkNotNullFromProvides(NotificationModule.INSTANCE.provideNotificationDao(db));
    }
}
