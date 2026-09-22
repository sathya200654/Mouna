package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class DeleteNotificationsUseCase_Factory implements Factory<DeleteNotificationsUseCase> {
    private final Provider<NotificationRepository> notificationRepositoryProvider;

    private DeleteNotificationsUseCase_Factory(Provider<NotificationRepository> notificationRepositoryProvider) {
        this.notificationRepositoryProvider = notificationRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DeleteNotificationsUseCase m1730get() {
        return newInstance((NotificationRepository) this.notificationRepositoryProvider.get());
    }

    public static DeleteNotificationsUseCase_Factory create(Provider<NotificationRepository> notificationRepositoryProvider) {
        return new DeleteNotificationsUseCase_Factory(notificationRepositoryProvider);
    }

    public static DeleteNotificationsUseCase newInstance(NotificationRepository notificationRepository) {
        return new DeleteNotificationsUseCase(notificationRepository);
    }
}
