package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.repository.EnvironmentSoundHistoryRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.repository.EnvironmentSoundHistoryRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnvSoundModule.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007¨\u0006\u000b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/di/EnvSoundModule;", "", "<init>", "()V", "provideEnvSoundHistoryDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/daos/EnvironmentSoundHistoryDao;", "db", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/local/LtsRoomDatabase;", "provideEnvSoundHistoryRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/repository/EnvironmentSoundHistoryRepository;", "dao", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class EnvSoundModule {
    public static final int $stable = 0;
    public static final EnvSoundModule INSTANCE = new EnvSoundModule();

    private EnvSoundModule() {
    }

    @Provides
    @Singleton
    public final EnvironmentSoundHistoryDao provideEnvSoundHistoryDao(LtsRoomDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        return db.environmentSoundHistoryDao();
    }

    @Provides
    @Singleton
    public final EnvironmentSoundHistoryRepository provideEnvSoundHistoryRepository(EnvironmentSoundHistoryDao dao) {
        Intrinsics.checkNotNullParameter(dao, "dao");
        return new EnvironmentSoundHistoryRepositoryImpl(dao);
    }
}
