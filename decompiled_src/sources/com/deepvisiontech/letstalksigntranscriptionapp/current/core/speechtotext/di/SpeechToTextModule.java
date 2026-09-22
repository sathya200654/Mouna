package com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.remote.api.SpeechToTextApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.repository.SpeechToTextRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.repository.SpeechToTextRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: SpeechToTextModule.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007¨\u0006\u000b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/di/SpeechToTextModule;", "", "<init>", "()V", "provideSpeechToTextApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/remote/api/SpeechToTextApi;", "retrofit", "Lretrofit2/Retrofit;", "provideSpeechToTextRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/repository/SpeechToTextRepository;", "speechToTextApi", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class SpeechToTextModule {
    public static final int $stable = 0;
    public static final SpeechToTextModule INSTANCE = new SpeechToTextModule();

    private SpeechToTextModule() {
    }

    @Provides
    @Singleton
    public final SpeechToTextApi provideSpeechToTextApi(Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(SpeechToTextApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (SpeechToTextApi) objCreate;
    }

    @Provides
    @Singleton
    public final SpeechToTextRepository provideSpeechToTextRepository(SpeechToTextApi speechToTextApi) {
        Intrinsics.checkNotNullParameter(speechToTextApi, "speechToTextApi");
        return new SpeechToTextRepositoryImpl(speechToTextApi);
    }
}
