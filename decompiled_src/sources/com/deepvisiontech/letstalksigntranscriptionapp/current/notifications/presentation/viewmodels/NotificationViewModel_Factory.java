package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import androidx.lifecycle.SavedStateHandle;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.media.MediaPlayerManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.GetNotificationFlowUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.SubmitNotificationActionUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.SubmitNotificationListActionUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NotificationViewModel_Factory implements Factory<NotificationViewModel> {
    private final Provider<GetNotificationFlowUseCase> getNotificationFlowUseCaseProvider;
    private final Provider<MediaPlayerManager> mediaPlayerManagerProvider;
    private final Provider<SavedStateHandle> savedStateHandleProvider;
    private final Provider<SubmitNotificationActionUseCase> submitNotificationActionUseCaseProvider;
    private final Provider<SubmitNotificationListActionUseCase> submitNotificationListActionUseCaseProvider;

    private NotificationViewModel_Factory(Provider<GetNotificationFlowUseCase> getNotificationFlowUseCaseProvider, Provider<SubmitNotificationActionUseCase> submitNotificationActionUseCaseProvider, Provider<SubmitNotificationListActionUseCase> submitNotificationListActionUseCaseProvider, Provider<MediaPlayerManager> mediaPlayerManagerProvider, Provider<SavedStateHandle> savedStateHandleProvider) {
        this.getNotificationFlowUseCaseProvider = getNotificationFlowUseCaseProvider;
        this.submitNotificationActionUseCaseProvider = submitNotificationActionUseCaseProvider;
        this.submitNotificationListActionUseCaseProvider = submitNotificationListActionUseCaseProvider;
        this.mediaPlayerManagerProvider = mediaPlayerManagerProvider;
        this.savedStateHandleProvider = savedStateHandleProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NotificationViewModel m1771get() {
        return newInstance((GetNotificationFlowUseCase) this.getNotificationFlowUseCaseProvider.get(), (SubmitNotificationActionUseCase) this.submitNotificationActionUseCaseProvider.get(), (SubmitNotificationListActionUseCase) this.submitNotificationListActionUseCaseProvider.get(), (MediaPlayerManager) this.mediaPlayerManagerProvider.get(), (SavedStateHandle) this.savedStateHandleProvider.get());
    }

    public static NotificationViewModel_Factory create(Provider<GetNotificationFlowUseCase> getNotificationFlowUseCaseProvider, Provider<SubmitNotificationActionUseCase> submitNotificationActionUseCaseProvider, Provider<SubmitNotificationListActionUseCase> submitNotificationListActionUseCaseProvider, Provider<MediaPlayerManager> mediaPlayerManagerProvider, Provider<SavedStateHandle> savedStateHandleProvider) {
        return new NotificationViewModel_Factory(getNotificationFlowUseCaseProvider, submitNotificationActionUseCaseProvider, submitNotificationListActionUseCaseProvider, mediaPlayerManagerProvider, savedStateHandleProvider);
    }

    public static NotificationViewModel newInstance(GetNotificationFlowUseCase getNotificationFlowUseCase, SubmitNotificationActionUseCase submitNotificationActionUseCase, SubmitNotificationListActionUseCase submitNotificationListActionUseCase, MediaPlayerManager mediaPlayerManager, SavedStateHandle savedStateHandle) {
        return new NotificationViewModel(getNotificationFlowUseCase, submitNotificationActionUseCase, submitNotificationListActionUseCase, mediaPlayerManager, savedStateHandle);
    }
}
