package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.remote.api.AuthApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.AuthRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AuthModule_ProvideAuthRepositoryFactory implements Factory<AuthRepository> {
    private final Provider<AuthApi> authApiProvider;

    private AuthModule_ProvideAuthRepositoryFactory(Provider<AuthApi> authApiProvider) {
        this.authApiProvider = authApiProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public AuthRepository m1362get() {
        return provideAuthRepository((AuthApi) this.authApiProvider.get());
    }

    public static AuthModule_ProvideAuthRepositoryFactory create(Provider<AuthApi> authApiProvider) {
        return new AuthModule_ProvideAuthRepositoryFactory(authApiProvider);
    }

    public static AuthRepository provideAuthRepository(AuthApi authApi) {
        return (AuthRepository) Preconditions.checkNotNullFromProvides(AuthModule.INSTANCE.provideAuthRepository(authApi));
    }
}
