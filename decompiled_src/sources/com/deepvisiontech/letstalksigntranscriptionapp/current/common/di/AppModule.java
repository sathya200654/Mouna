package com.deepvisiontech.letstalksigntranscriptionapp.current.common.di;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.api.LtsTranslationApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.LtsTranslationRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.SettingsRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.LtsTranslationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: AppModule.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0007J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0007J\u0012\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u001b\u001a\u00020\u0015H\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001aH\u0007R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/di/AppModule;", "", "<init>", "()V", "provideIoDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "provideDefaultDispatcher", "provideAppDatabase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/local/LtsRoomDatabase;", "context", "Landroid/content/Context;", "provideSettingsRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/SettingsRepository;", "BASE_URL", "", "provideLoggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "loggingInterceptor", "provideLtsRetrofit", "Lretrofit2/Retrofit;", "okHttpClient", "NOTIFICATION_URL", "provideAnalyticsAndResponseRetrofit", "providesLtsTranslationApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/api/LtsTranslationApi;", "retrofit", "provideLtsTranslationRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/LtsTranslationRepository;", "ltsTranslationApi", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class AppModule {
    public static final int $stable = 0;
    private static final String BASE_URL = "https://lts.lb.gcloud.letstalksign.org/";
    public static final AppModule INSTANCE = new AppModule();
    private static final String NOTIFICATION_URL = "https://lts.kiosk.letstalksign.org/";

    private AppModule() {
    }

    @Provides
    public final CoroutineDispatcher provideIoDispatcher() {
        return Dispatchers.getIO();
    }

    @Provides
    public final CoroutineDispatcher provideDefaultDispatcher() {
        return Dispatchers.getDefault();
    }

    @Provides
    @Singleton
    public final LtsRoomDatabase provideAppDatabase(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return LtsRoomDatabase.INSTANCE.getInstance(context);
    }

    @Provides
    @Singleton
    public final SettingsRepository provideSettingsRepository(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SettingsRepositoryImpl(context);
    }

    @Provides
    @Singleton
    public final HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @Singleton
    public final OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        Intrinsics.checkNotNullParameter(loggingInterceptor, "loggingInterceptor");
        return new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).build();
    }

    @Provides
    @Singleton
    public final Retrofit provideLtsRetrofit(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "build(...)");
        return retrofitBuild;
    }

    @Provides
    @Singleton
    public final Retrofit provideAnalyticsAndResponseRetrofit(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(NOTIFICATION_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "build(...)");
        return retrofitBuild;
    }

    @Provides
    @Singleton
    public final LtsTranslationApi providesLtsTranslationApi(Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(LtsTranslationApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (LtsTranslationApi) objCreate;
    }

    @Provides
    @Singleton
    public final LtsTranslationRepository provideLtsTranslationRepository(LtsTranslationApi ltsTranslationApi) {
        Intrinsics.checkNotNullParameter(ltsTranslationApi, "ltsTranslationApi");
        return new LtsTranslationRepositoryImpl(ltsTranslationApi);
    }
}
