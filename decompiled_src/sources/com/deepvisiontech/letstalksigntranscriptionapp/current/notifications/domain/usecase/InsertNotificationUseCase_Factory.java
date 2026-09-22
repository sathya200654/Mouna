package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class InsertNotificationUseCase_Factory implements Factory<InsertNotificationUseCase> {
    private final Provider<NotificationRepository> notificationRepositoryProvider;

    private InsertNotificationUseCase_Factory(Provider<NotificationRepository> notificationRepositoryProvider) {
        this.notificationRepositoryProvider = notificationRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public InsertNotificationUseCase m1733get() {
        return newInstance((NotificationRepository) this.notificationRepositoryProvider.get());
    }

    public static InsertNotificationUseCase_Factory create(Provider<NotificationRepository> notificationRepositoryProvider) {
        return new InsertNotificationUseCase_Factory(notificationRepositoryProvider);
    }

    public static InsertNotificationUseCase newInstance(NotificationRepository notificationRepository) {
        return new InsertNotificationUseCase(notificationRepository);
    }
}
