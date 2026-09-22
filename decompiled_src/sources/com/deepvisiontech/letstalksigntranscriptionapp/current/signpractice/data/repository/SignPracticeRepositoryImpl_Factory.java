package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.remote.api.SignPracticeApi;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SignPracticeRepositoryImpl_Factory implements Factory<SignPracticeRepositoryImpl> {
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<SignPracticeApi> signPracticeApiProvider;
    private final Provider<SignPracticeDao> signPracticeDaoProvider;

    private SignPracticeRepositoryImpl_Factory(Provider<SignPracticeDao> signPracticeDaoProvider, Provider<SignPracticeApi> signPracticeApiProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.signPracticeDaoProvider = signPracticeDaoProvider;
        this.signPracticeApiProvider = signPracticeApiProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SignPracticeRepositoryImpl m1793get() {
        return newInstance((SignPracticeDao) this.signPracticeDaoProvider.get(), (SignPracticeApi) this.signPracticeApiProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get());
    }

    public static SignPracticeRepositoryImpl_Factory create(Provider<SignPracticeDao> signPracticeDaoProvider, Provider<SignPracticeApi> signPracticeApiProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new SignPracticeRepositoryImpl_Factory(signPracticeDaoProvider, signPracticeApiProvider, ioDispatcherProvider);
    }

    public static SignPracticeRepositoryImpl newInstance(SignPracticeDao signPracticeDao, SignPracticeApi signPracticeApi, CoroutineDispatcher ioDispatcher) {
        return new SignPracticeRepositoryImpl(signPracticeDao, signPracticeApi, ioDispatcher);
    }
}
