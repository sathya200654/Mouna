package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GetNotificationFlowUseCase_Factory implements Factory<GetNotificationFlowUseCase> {
    private final Provider<NotificationRepository> notificationRepositoryProvider;

    private GetNotificationFlowUseCase_Factory(Provider<NotificationRepository> notificationRepositoryProvider) {
        this.notificationRepositoryProvider = notificationRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public GetNotificationFlowUseCase m1732get() {
        return newInstance((NotificationRepository) this.notificationRepositoryProvider.get());
    }

    public static GetNotificationFlowUseCase_Factory create(Provider<NotificationRepository> notificationRepositoryProvider) {
        return new GetNotificationFlowUseCase_Factory(notificationRepositoryProvider);
    }

    public static GetNotificationFlowUseCase newInstance(NotificationRepository notificationRepository) {
        return new GetNotificationFlowUseCase(notificationRepository);
    }
}
