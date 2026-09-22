package com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SettingsRepositoryImpl_Factory implements Factory<SettingsRepositoryImpl> {
    private final Provider<Context> contextProvider;

    private SettingsRepositoryImpl_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SettingsRepositoryImpl m1399get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static SettingsRepositoryImpl_Factory create(Provider<Context> contextProvider) {
        return new SettingsRepositoryImpl_Factory(contextProvider);
    }

    public static SettingsRepositoryImpl newInstance(Context context) {
        return new SettingsRepositoryImpl(context);
    }
}
