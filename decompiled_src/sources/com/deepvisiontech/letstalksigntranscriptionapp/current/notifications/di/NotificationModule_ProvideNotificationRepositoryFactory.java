package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.remote.api.NotificationApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NotificationModule_ProvideNotificationRepositoryFactory implements Factory<NotificationRepository> {
    private final Provider<NotificationApi> apiProvider;
    private final Provider<NotificationDao> daoProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;

    private NotificationModule_ProvideNotificationRepositoryFactory(Provider<NotificationDao> daoProvider, Provider<NotificationApi> apiProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.daoProvider = daoProvider;
        this.apiProvider = apiProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NotificationRepository m1725get() {
        return provideNotificationRepository((NotificationDao) this.daoProvider.get(), (NotificationApi) this.apiProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get());
    }

    public static NotificationModule_ProvideNotificationRepositoryFactory create(Provider<NotificationDao> daoProvider, Provider<NotificationApi> apiProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new NotificationModule_ProvideNotificationRepositoryFactory(daoProvider, apiProvider, ioDispatcherProvider);
    }

    public static NotificationRepository provideNotificationRepository(NotificationDao dao, NotificationApi api, CoroutineDispatcher ioDispatcher) {
        return (NotificationRepository) Preconditions.checkNotNullFromProvides(NotificationModule.INSTANCE.provideNotificationRepository(dao, api, ioDispatcher));
    }
}
