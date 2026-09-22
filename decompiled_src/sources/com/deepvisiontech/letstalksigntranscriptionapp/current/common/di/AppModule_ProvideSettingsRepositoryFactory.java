package com.deepvisiontech.letstalksigntranscriptionapp.current.common.di;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AppModule_ProvideSettingsRepositoryFactory implements Factory<SettingsRepository> {
    private final Provider<Context> contextProvider;

    private AppModule_ProvideSettingsRepositoryFactory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SettingsRepository m1408get() {
        return provideSettingsRepository((Context) this.contextProvider.get());
    }

    public static AppModule_ProvideSettingsRepositoryFactory create(Provider<Context> contextProvider) {
        return new AppModule_ProvideSettingsRepositoryFactory(contextProvider);
    }

    public static SettingsRepository provideSettingsRepository(Context context) {
        return (SettingsRepository) Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideSettingsRepository(context));
    }
}
