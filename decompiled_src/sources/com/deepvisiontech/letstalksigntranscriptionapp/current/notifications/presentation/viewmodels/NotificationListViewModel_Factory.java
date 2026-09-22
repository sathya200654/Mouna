package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.DeleteNotificationsUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.GetAllFilteredNotificationsUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NotificationListViewModel_Factory implements Factory<NotificationListViewModel> {
    private final Provider<DeleteNotificationsUseCase> deleteNotificationsUseCaseProvider;
    private final Provider<GetAllFilteredNotificationsUseCase> getAllFilteredNotificationsUseCaseProvider;

    private NotificationListViewModel_Factory(Provider<GetAllFilteredNotificationsUseCase> getAllFilteredNotificationsUseCaseProvider, Provider<DeleteNotificationsUseCase> deleteNotificationsUseCaseProvider) {
        this.getAllFilteredNotificationsUseCaseProvider = getAllFilteredNotificationsUseCaseProvider;
        this.deleteNotificationsUseCaseProvider = deleteNotificationsUseCaseProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NotificationListViewModel m1769get() {
        return newInstance((GetAllFilteredNotificationsUseCase) this.getAllFilteredNotificationsUseCaseProvider.get(), (DeleteNotificationsUseCase) this.deleteNotificationsUseCaseProvider.get());
    }

    public static NotificationListViewModel_Factory create(Provider<GetAllFilteredNotificationsUseCase> getAllFilteredNotificationsUseCaseProvider, Provider<DeleteNotificationsUseCase> deleteNotificationsUseCaseProvider) {
        return new NotificationListViewModel_Factory(getAllFilteredNotificationsUseCaseProvider, deleteNotificationsUseCaseProvider);
    }

    public static NotificationListViewModel newInstance(GetAllFilteredNotificationsUseCase getAllFilteredNotificationsUseCase, DeleteNotificationsUseCase deleteNotificationsUseCase) {
        return new NotificationListViewModel(getAllFilteredNotificationsUseCase, deleteNotificationsUseCase);
    }
}
