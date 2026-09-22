package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.LoginAndSaveTokenUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.SetEnvironmentRecognizerStateUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.notificationintent.domain.repository.NotificationIntentManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SetUpViewModel_Factory implements Factory<SetUpViewModel> {
    private final Provider<EngagementRepository> engagementRepositoryProvider;
    private final Provider<LoginAndSaveTokenUseCase> loginAndSaveTokenUseCaseProvider;
    private final Provider<NotificationIntentManager> notificationIntentManagerProvider;
    private final Provider<SetEnvironmentRecognizerStateUseCase> setEnvironmentRecognizerStateUseCaseProvider;

    private SetUpViewModel_Factory(Provider<LoginAndSaveTokenUseCase> loginAndSaveTokenUseCaseProvider, Provider<NotificationIntentManager> notificationIntentManagerProvider, Provider<SetEnvironmentRecognizerStateUseCase> setEnvironmentRecognizerStateUseCaseProvider, Provider<EngagementRepository> engagementRepositoryProvider) {
        this.loginAndSaveTokenUseCaseProvider = loginAndSaveTokenUseCaseProvider;
        this.notificationIntentManagerProvider = notificationIntentManagerProvider;
        this.setEnvironmentRecognizerStateUseCaseProvider = setEnvironmentRecognizerStateUseCaseProvider;
        this.engagementRepositoryProvider = engagementRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SetUpViewModel m1391get() {
        return newInstance((LoginAndSaveTokenUseCase) this.loginAndSaveTokenUseCaseProvider.get(), (NotificationIntentManager) this.notificationIntentManagerProvider.get(), (SetEnvironmentRecognizerStateUseCase) this.setEnvironmentRecognizerStateUseCaseProvider.get(), (EngagementRepository) this.engagementRepositoryProvider.get());
    }

    public static SetUpViewModel_Factory create(Provider<LoginAndSaveTokenUseCase> loginAndSaveTokenUseCaseProvider, Provider<NotificationIntentManager> notificationIntentManagerProvider, Provider<SetEnvironmentRecognizerStateUseCase> setEnvironmentRecognizerStateUseCaseProvider, Provider<EngagementRepository> engagementRepositoryProvider) {
        return new SetUpViewModel_Factory(loginAndSaveTokenUseCaseProvider, notificationIntentManagerProvider, setEnvironmentRecognizerStateUseCaseProvider, engagementRepositoryProvider);
    }

    public static SetUpViewModel newInstance(LoginAndSaveTokenUseCase loginAndSaveTokenUseCase, NotificationIntentManager notificationIntentManager, SetEnvironmentRecognizerStateUseCase setEnvironmentRecognizerStateUseCase, EngagementRepository engagementRepository) {
        return new SetUpViewModel(loginAndSaveTokenUseCase, notificationIntentManager, setEnvironmentRecognizerStateUseCase, engagementRepository);
    }
}
