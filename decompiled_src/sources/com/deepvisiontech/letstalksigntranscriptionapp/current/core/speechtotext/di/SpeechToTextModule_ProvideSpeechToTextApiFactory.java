package com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.remote.api.SpeechToTextApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SpeechToTextModule_ProvideSpeechToTextApiFactory implements Factory<SpeechToTextApi> {
    private final Provider<Retrofit> retrofitProvider;

    private SpeechToTextModule_ProvideSpeechToTextApiFactory(Provider<Retrofit> retrofitProvider) {
        this.retrofitProvider = retrofitProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SpeechToTextApi m1705get() {
        return provideSpeechToTextApi((Retrofit) this.retrofitProvider.get());
    }

    public static SpeechToTextModule_ProvideSpeechToTextApiFactory create(Provider<Retrofit> retrofitProvider) {
        return new SpeechToTextModule_ProvideSpeechToTextApiFactory(retrofitProvider);
    }

    public static SpeechToTextApi provideSpeechToTextApi(Retrofit retrofit) {
        return (SpeechToTextApi) Preconditions.checkNotNullFromProvides(SpeechToTextModule.INSTANCE.provideSpeechToTextApi(retrofit));
    }
}
