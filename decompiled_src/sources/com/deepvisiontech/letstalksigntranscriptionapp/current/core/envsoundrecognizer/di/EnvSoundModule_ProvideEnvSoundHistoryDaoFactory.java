package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class EnvSoundModule_ProvideEnvSoundHistoryDaoFactory implements Factory<EnvironmentSoundHistoryDao> {
    private final Provider<LtsRoomDatabase> dbProvider;

    private EnvSoundModule_ProvideEnvSoundHistoryDaoFactory(Provider<LtsRoomDatabase> dbProvider) {
        this.dbProvider = dbProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public EnvironmentSoundHistoryDao m1675get() {
        return provideEnvSoundHistoryDao((LtsRoomDatabase) this.dbProvider.get());
    }

    public static EnvSoundModule_ProvideEnvSoundHistoryDaoFactory create(Provider<LtsRoomDatabase> dbProvider) {
        return new EnvSoundModule_ProvideEnvSoundHistoryDaoFactory(dbProvider);
    }

    public static EnvironmentSoundHistoryDao provideEnvSoundHistoryDao(LtsRoomDatabase db) {
        return (EnvironmentSoundHistoryDao) Preconditions.checkNotNullFromProvides(EnvSoundModule.INSTANCE.provideEnvSoundHistoryDao(db));
    }
}
