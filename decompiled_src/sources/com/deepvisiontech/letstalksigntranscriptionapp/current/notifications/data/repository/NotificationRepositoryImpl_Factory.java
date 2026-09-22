package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.remote.api.NotificationApi;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NotificationRepositoryImpl_Factory implements Factory<NotificationRepositoryImpl> {
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<NotificationApi> notificationApiProvider;
    private final Provider<NotificationDao> notificationDaoProvider;

    private NotificationRepositoryImpl_Factory(Provider<NotificationDao> notificationDaoProvider, Provider<NotificationApi> notificationApiProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.notificationDaoProvider = notificationDaoProvider;
        this.notificationApiProvider = notificationApiProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NotificationRepositoryImpl m1721get() {
        return newInstance((NotificationDao) this.notificationDaoProvider.get(), (NotificationApi) this.notificationApiProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get());
    }

    public static NotificationRepositoryImpl_Factory create(Provider<NotificationDao> notificationDaoProvider, Provider<NotificationApi> notificationApiProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new NotificationRepositoryImpl_Factory(notificationDaoProvider, notificationApiProvider, ioDispatcherProvider);
    }

    public static NotificationRepositoryImpl newInstance(NotificationDao notificationDao, NotificationApi notificationApi, CoroutineDispatcher ioDispatcher) {
        return new NotificationRepositoryImpl(notificationDao, notificationApi, ioDispatcher);
    }
}
