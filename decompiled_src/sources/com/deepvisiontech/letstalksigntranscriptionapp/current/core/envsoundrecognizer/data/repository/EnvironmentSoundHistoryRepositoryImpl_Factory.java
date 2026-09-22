package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class EnvironmentSoundHistoryRepositoryImpl_Factory implements Factory<EnvironmentSoundHistoryRepositoryImpl> {
    private final Provider<EnvironmentSoundHistoryDao> daoProvider;

    private EnvironmentSoundHistoryRepositoryImpl_Factory(Provider<EnvironmentSoundHistoryDao> daoProvider) {
        this.daoProvider = daoProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public EnvironmentSoundHistoryRepositoryImpl m1672get() {
        return newInstance((EnvironmentSoundHistoryDao) this.daoProvider.get());
    }

    public static EnvironmentSoundHistoryRepositoryImpl_Factory create(Provider<EnvironmentSoundHistoryDao> daoProvider) {
        return new EnvironmentSoundHistoryRepositoryImpl_Factory(daoProvider);
    }

    public static EnvironmentSoundHistoryRepositoryImpl newInstance(EnvironmentSoundHistoryDao dao) {
        return new EnvironmentSoundHistoryRepositoryImpl(dao);
    }
}
