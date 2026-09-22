package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SubmitNotificationListActionUseCase_Factory implements Factory<SubmitNotificationListActionUseCase> {
    private final Provider<NotificationRepository> notificationRepositoryProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;

    private SubmitNotificationListActionUseCase_Factory(Provider<NotificationRepository> notificationRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider) {
        this.notificationRepositoryProvider = notificationRepositoryProvider;
        this.sessionRepositoryProvider = sessionRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SubmitNotificationListActionUseCase m1735get() {
        return newInstance((NotificationRepository) this.notificationRepositoryProvider.get(), (SessionRepository) this.sessionRepositoryProvider.get());
    }

    public static SubmitNotificationListActionUseCase_Factory create(Provider<NotificationRepository> notificationRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider) {
        return new SubmitNotificationListActionUseCase_Factory(notificationRepositoryProvider, sessionRepositoryProvider);
    }

    public static SubmitNotificationListActionUseCase newInstance(NotificationRepository notificationRepository, SessionRepository sessionRepository) {
        return new SubmitNotificationListActionUseCase(notificationRepository, sessionRepository);
    }
}
