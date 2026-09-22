package com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.di;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.remote.api.AnalyticsApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.repository.AnalyticsRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.repository.AppUsageRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.repository.AnalyticsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.repository.AppUsageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: AnalyticsModule.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0007¨\u0006\u0014"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/di/AnalyticsModule;", "", "<init>", "()V", "provideAnalyticsApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/remote/api/AnalyticsApi;", "retrofit", "Lretrofit2/Retrofit;", "provideAnalyticsRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/repository/AnalyticsRepository;", "analyticsApi", "provideAnalyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "analyticsRepository", "provideAppUsageRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/repository/AppUsageRepository;", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class AnalyticsModule {
    public static final int $stable = 0;
    public static final AnalyticsModule INSTANCE = new AnalyticsModule();

    private AnalyticsModule() {
    }

    @Provides
    @Singleton
    public final AnalyticsApi provideAnalyticsApi(Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(AnalyticsApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (AnalyticsApi) objCreate;
    }

    @Provides
    @Singleton
    public final AnalyticsRepository provideAnalyticsRepository(AnalyticsApi analyticsApi) {
        Intrinsics.checkNotNullParameter(analyticsApi, "analyticsApi");
        return new AnalyticsRepositoryImpl(analyticsApi);
    }

    @Provides
    @Singleton
    public final AnalyticsManager provideAnalyticsManager(SessionRepository sessionRepository, AnalyticsRepository analyticsRepository) {
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(analyticsRepository, "analyticsRepository");
        return new AnalyticsManager(sessionRepository, analyticsRepository);
    }

    @Provides
    @Singleton
    public final AppUsageRepository provideAppUsageRepository(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new AppUsageRepositoryImpl(context);
    }
}
