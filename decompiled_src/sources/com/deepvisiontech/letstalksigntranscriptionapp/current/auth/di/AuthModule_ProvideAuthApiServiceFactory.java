package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.remote.api.AuthApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AuthModule_ProvideAuthApiServiceFactory implements Factory<AuthApi> {
    private final Provider<Retrofit> retrofitProvider;

    private AuthModule_ProvideAuthApiServiceFactory(Provider<Retrofit> retrofitProvider) {
        this.retrofitProvider = retrofitProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public AuthApi m1361get() {
        return provideAuthApiService((Retrofit) this.retrofitProvider.get());
    }

    public static AuthModule_ProvideAuthApiServiceFactory create(Provider<Retrofit> retrofitProvider) {
        return new AuthModule_ProvideAuthApiServiceFactory(retrofitProvider);
    }

    public static AuthApi provideAuthApiService(Retrofit retrofit) {
        return (AuthApi) Preconditions.checkNotNullFromProvides(AuthModule.INSTANCE.provideAuthApiService(retrofit));
    }
}
