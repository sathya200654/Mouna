package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.di;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SessionModule_ProvideSessionRepositoryFactory implements Factory<SessionRepository> {
    private final Provider<Context> contextProvider;

    private SessionModule_ProvideSessionRepositoryFactory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SessionRepository m1365get() {
        return provideSessionRepository((Context) this.contextProvider.get());
    }

    public static SessionModule_ProvideSessionRepositoryFactory create(Provider<Context> contextProvider) {
        return new SessionModule_ProvideSessionRepositoryFactory(contextProvider);
    }

    public static SessionRepository provideSessionRepository(Context context) {
        return (SessionRepository) Preconditions.checkNotNullFromProvides(SessionModule.INSTANCE.provideSessionRepository(context));
    }
}
