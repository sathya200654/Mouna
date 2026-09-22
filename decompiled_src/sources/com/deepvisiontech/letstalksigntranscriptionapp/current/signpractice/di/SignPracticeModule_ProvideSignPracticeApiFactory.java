package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.remote.api.SignPracticeApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SignPracticeModule_ProvideSignPracticeApiFactory implements Factory<SignPracticeApi> {
    private final Provider<Retrofit> retrofitProvider;

    private SignPracticeModule_ProvideSignPracticeApiFactory(Provider<Retrofit> retrofitProvider) {
        this.retrofitProvider = retrofitProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SignPracticeApi m1794get() {
        return provideSignPracticeApi((Retrofit) this.retrofitProvider.get());
    }

    public static SignPracticeModule_ProvideSignPracticeApiFactory create(Provider<Retrofit> retrofitProvider) {
        return new SignPracticeModule_ProvideSignPracticeApiFactory(retrofitProvider);
    }

    public static SignPracticeApi provideSignPracticeApi(Retrofit retrofit) {
        return (SignPracticeApi) Preconditions.checkNotNullFromProvides(SignPracticeModule.INSTANCE.provideSignPracticeApi(retrofit));
    }
}
