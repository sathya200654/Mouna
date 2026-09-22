package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.remote.api.AuthApi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AuthRepositoryImpl_Factory implements Factory<AuthRepositoryImpl> {
    private final Provider<AuthApi> authApiProvider;

    private AuthRepositoryImpl_Factory(Provider<AuthApi> authApiProvider) {
        this.authApiProvider = authApiProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public AuthRepositoryImpl m1358get() {
        return newInstance((AuthApi) this.authApiProvider.get());
    }

    public static AuthRepositoryImpl_Factory create(Provider<AuthApi> authApiProvider) {
        return new AuthRepositoryImpl_Factory(authApiProvider);
    }

    public static AuthRepositoryImpl newInstance(AuthApi authApi) {
        return new AuthRepositoryImpl(authApi);
    }
}
