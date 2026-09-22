package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.services;

import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.di.ApplicationScope;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository;
import dagger.MembersInjector;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class PushNotificationService_MembersInjector implements MembersInjector<PushNotificationService> {
    private final Provider<CoroutineScope> externalScopeProvider;
    private final Provider<NotificationRepository> notificationRepositoryProvider;

    private PushNotificationService_MembersInjector(Provider<NotificationRepository> notificationRepositoryProvider, Provider<CoroutineScope> externalScopeProvider) {
        this.notificationRepositoryProvider = notificationRepositoryProvider;
        this.externalScopeProvider = externalScopeProvider;
    }

    public static MembersInjector<PushNotificationService> create(Provider<NotificationRepository> notificationRepositoryProvider, Provider<CoroutineScope> externalScopeProvider) {
        return new PushNotificationService_MembersInjector(notificationRepositoryProvider, externalScopeProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PushNotificationService instance) {
        injectNotificationRepository(instance, (NotificationRepository) this.notificationRepositoryProvider.get());
        injectExternalScope(instance, (CoroutineScope) this.externalScopeProvider.get());
    }

    public static void injectNotificationRepository(PushNotificationService instance, NotificationRepository notificationRepository) {
        instance.notificationRepository = notificationRepository;
    }

    @ApplicationScope
    public static void injectExternalScope(PushNotificationService instance, CoroutineScope externalScope) {
        instance.externalScope = externalScope;
    }
}
