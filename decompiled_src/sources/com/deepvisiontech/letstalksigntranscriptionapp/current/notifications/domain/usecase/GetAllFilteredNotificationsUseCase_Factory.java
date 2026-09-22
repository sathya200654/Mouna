package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GetAllFilteredNotificationsUseCase_Factory implements Factory<GetAllFilteredNotificationsUseCase> {
    private final Provider<NotificationRepository> notificationRepositoryProvider;

    private GetAllFilteredNotificationsUseCase_Factory(Provider<NotificationRepository> notificationRepositoryProvider) {
        this.notificationRepositoryProvider = notificationRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public GetAllFilteredNotificationsUseCase m1731get() {
        return newInstance((NotificationRepository) this.notificationRepositoryProvider.get());
    }

    public static GetAllFilteredNotificationsUseCase_Factory create(Provider<NotificationRepository> notificationRepositoryProvider) {
        return new GetAllFilteredNotificationsUseCase_Factory(notificationRepositoryProvider);
    }

    public static GetAllFilteredNotificationsUseCase newInstance(NotificationRepository notificationRepository) {
        return new GetAllFilteredNotificationsUseCase(notificationRepository);
    }
}
