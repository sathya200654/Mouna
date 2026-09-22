package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SessionRepositoryImpl_Factory implements Factory<SessionRepositoryImpl> {
    private final Provider<Context> contextProvider;

    private SessionRepositoryImpl_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SessionRepositoryImpl m1360get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static SessionRepositoryImpl_Factory create(Provider<Context> contextProvider) {
        return new SessionRepositoryImpl_Factory(contextProvider);
    }

    public static SessionRepositoryImpl newInstance(Context context) {
        return new SessionRepositoryImpl(context);
    }
}
