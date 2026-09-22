package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.remote.api.SignPracticeApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SignPracticeModule_ProvideSignPracticeRepositoryFactory implements Factory<SignPracticeRepository> {
    private final Provider<SignPracticeDao> daoProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<SignPracticeApi> signPracticeApiProvider;

    private SignPracticeModule_ProvideSignPracticeRepositoryFactory(Provider<SignPracticeDao> daoProvider, Provider<SignPracticeApi> signPracticeApiProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.daoProvider = daoProvider;
        this.signPracticeApiProvider = signPracticeApiProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SignPracticeRepository m1796get() {
        return provideSignPracticeRepository((SignPracticeDao) this.daoProvider.get(), (SignPracticeApi) this.signPracticeApiProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get());
    }

    public static SignPracticeModule_ProvideSignPracticeRepositoryFactory create(Provider<SignPracticeDao> daoProvider, Provider<SignPracticeApi> signPracticeApiProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new SignPracticeModule_ProvideSignPracticeRepositoryFactory(daoProvider, signPracticeApiProvider, ioDispatcherProvider);
    }

    public static SignPracticeRepository provideSignPracticeRepository(SignPracticeDao dao, SignPracticeApi signPracticeApi, CoroutineDispatcher ioDispatcher) {
        return (SignPracticeRepository) Preconditions.checkNotNullFromProvides(SignPracticeModule.INSTANCE.provideSignPracticeRepository(dao, signPracticeApi, ioDispatcher));
    }
}
