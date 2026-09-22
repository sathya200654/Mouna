package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel;

import com.deepvisiontech.letstalksigntranscriptionapp.current.app.domain.usecase.SendSoundEventsUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.LogOutAndClearMailIdUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.network.data.NetworkMonitor;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.usecase.ShowShareAppDialogUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AppViewModel_Factory implements Factory<AppViewModel> {
    private final Provider<EngagementRepository> engagementRepositoryProvider;
    private final Provider<LogOutAndClearMailIdUseCase> logOutAndClearMailIdUseCaseProvider;
    private final Provider<NetworkMonitor> networkMonitorProvider;
    private final Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider;
    private final Provider<SendSoundEventsUseCase> sendSoundEventsUseCaseProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<ShowShareAppDialogUseCase> showShareAppDialogUseCaseProvider;

    private AppViewModel_Factory(Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider, Provider<ShowShareAppDialogUseCase> showShareAppDialogUseCaseProvider, Provider<SendSoundEventsUseCase> sendSoundEventsUseCaseProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<EngagementRepository> engagementRepositoryProvider, Provider<LogOutAndClearMailIdUseCase> logOutAndClearMailIdUseCaseProvider, Provider<NetworkMonitor> networkMonitorProvider) {
        this.personaSurveyRepositoryProvider = personaSurveyRepositoryProvider;
        this.showShareAppDialogUseCaseProvider = showShareAppDialogUseCaseProvider;
        this.sendSoundEventsUseCaseProvider = sendSoundEventsUseCaseProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.engagementRepositoryProvider = engagementRepositoryProvider;
        this.logOutAndClearMailIdUseCaseProvider = logOutAndClearMailIdUseCaseProvider;
        this.networkMonitorProvider = networkMonitorProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public AppViewModel m1354get() {
        return newInstance((PersonaSurveyRepository) this.personaSurveyRepositoryProvider.get(), (ShowShareAppDialogUseCase) this.showShareAppDialogUseCaseProvider.get(), (SendSoundEventsUseCase) this.sendSoundEventsUseCaseProvider.get(), (SettingsRepository) this.settingsRepositoryProvider.get(), (EngagementRepository) this.engagementRepositoryProvider.get(), (LogOutAndClearMailIdUseCase) this.logOutAndClearMailIdUseCaseProvider.get(), (NetworkMonitor) this.networkMonitorProvider.get());
    }

    public static AppViewModel_Factory create(Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider, Provider<ShowShareAppDialogUseCase> showShareAppDialogUseCaseProvider, Provider<SendSoundEventsUseCase> sendSoundEventsUseCaseProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<EngagementRepository> engagementRepositoryProvider, Provider<LogOutAndClearMailIdUseCase> logOutAndClearMailIdUseCaseProvider, Provider<NetworkMonitor> networkMonitorProvider) {
        return new AppViewModel_Factory(personaSurveyRepositoryProvider, showShareAppDialogUseCaseProvider, sendSoundEventsUseCaseProvider, settingsRepositoryProvider, engagementRepositoryProvider, logOutAndClearMailIdUseCaseProvider, networkMonitorProvider);
    }

    public static AppViewModel newInstance(PersonaSurveyRepository personaSurveyRepository, ShowShareAppDialogUseCase showShareAppDialogUseCase, SendSoundEventsUseCase sendSoundEventsUseCase, SettingsRepository settingsRepository, EngagementRepository engagementRepository, LogOutAndClearMailIdUseCase logOutAndClearMailIdUseCase, NetworkMonitor networkMonitor) {
        return new AppViewModel(personaSurveyRepository, showShareAppDialogUseCase, sendSoundEventsUseCase, settingsRepository, engagementRepository, logOutAndClearMailIdUseCase, networkMonitor);
    }
}
