package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.viewmodel;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.repository.EnvironmentSoundHistoryRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class EnvironmentSoundHistoryViewModel_Factory implements Factory<EnvironmentSoundHistoryViewModel> {
    private final Provider<EnvironmentSoundHistoryRepository> repositoryProvider;

    private EnvironmentSoundHistoryViewModel_Factory(Provider<EnvironmentSoundHistoryRepository> repositoryProvider) {
        this.repositoryProvider = repositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public EnvironmentSoundHistoryViewModel m1687get() {
        return newInstance((EnvironmentSoundHistoryRepository) this.repositoryProvider.get());
    }

    public static EnvironmentSoundHistoryViewModel_Factory create(Provider<EnvironmentSoundHistoryRepository> repositoryProvider) {
        return new EnvironmentSoundHistoryViewModel_Factory(repositoryProvider);
    }

    public static EnvironmentSoundHistoryViewModel newInstance(EnvironmentSoundHistoryRepository repository) {
        return new EnvironmentSoundHistoryViewModel(repository);
    }
}
