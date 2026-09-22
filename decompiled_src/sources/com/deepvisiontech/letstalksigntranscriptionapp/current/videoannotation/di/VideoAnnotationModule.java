package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.remote.api.VideoApiService;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.repository.VideoUploadRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.repository.VideoUploadRepository;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: VideoAnnotationModule.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u0007H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/di/VideoAnnotationModule;", "", "<init>", "()V", "VIDEO_API_BASE_URL", "", "provideVideoRetrofit", "Lretrofit2/Retrofit;", "okHttpClient", "Lokhttp3/OkHttpClient;", "provideVideoApiService", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/remote/api/VideoApiService;", "retrofit", "provideVideoUploadRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/domain/repository/VideoUploadRepository;", "videoApiService", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class VideoAnnotationModule {
    public static final int $stable = 0;
    public static final VideoAnnotationModule INSTANCE = new VideoAnnotationModule();
    private static final String VIDEO_API_BASE_URL = "https://video.interpret.letstalksign.org/";

    private VideoAnnotationModule() {
    }

    @Provides
    @Singleton
    @Named("VideoApi")
    public final Retrofit provideVideoRetrofit(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(VIDEO_API_BASE_URL).client(okHttpClient.newBuilder().connectTimeout(60L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).writeTimeout(300L, TimeUnit.SECONDS).build()).addConverterFactory(GsonConverterFactory.create()).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "build(...)");
        return retrofitBuild;
    }

    @Provides
    @Singleton
    public final VideoApiService provideVideoApiService(@Named("VideoApi") Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(VideoApiService.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (VideoApiService) objCreate;
    }

    @Provides
    @Singleton
    public final VideoUploadRepository provideVideoUploadRepository(VideoApiService videoApiService) {
        Intrinsics.checkNotNullParameter(videoApiService, "videoApiService");
        return new VideoUploadRepositoryImpl(videoApiService);
    }
}
