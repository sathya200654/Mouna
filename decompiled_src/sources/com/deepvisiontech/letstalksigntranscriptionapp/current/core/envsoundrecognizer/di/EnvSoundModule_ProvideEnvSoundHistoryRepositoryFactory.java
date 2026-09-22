package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.repository.EnvironmentSoundHistoryRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class EnvSoundModule_ProvideEnvSoundHistoryRepositoryFactory implements Factory<EnvironmentSoundHistoryRepository> {
    private final Provider<EnvironmentSoundHistoryDao> daoProvider;

    private EnvSoundModule_ProvideEnvSoundHistoryRepositoryFactory(Provider<EnvironmentSoundHistoryDao> daoProvider) {
        this.daoProvider = daoProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public EnvironmentSoundHistoryRepository m1676get() {
        return provideEnvSoundHistoryRepository((EnvironmentSoundHistoryDao) this.daoProvider.get());
    }

    public static EnvSoundModule_ProvideEnvSoundHistoryRepositoryFactory create(Provider<EnvironmentSoundHistoryDao> daoProvider) {
        return new EnvSoundModule_ProvideEnvSoundHistoryRepositoryFactory(daoProvider);
    }

    public static EnvironmentSoundHistoryRepository provideEnvSoundHistoryRepository(EnvironmentSoundHistoryDao dao) {
        return (EnvironmentSoundHistoryRepository) Preconditions.checkNotNullFromProvides(EnvSoundModule.INSTANCE.provideEnvSoundHistoryRepository(dao));
    }
}
