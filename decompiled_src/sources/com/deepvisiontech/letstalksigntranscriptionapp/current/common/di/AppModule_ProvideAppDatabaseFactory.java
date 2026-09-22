package com.deepvisiontech.letstalksigntranscriptionapp.current.common.di;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AppModule_ProvideAppDatabaseFactory implements Factory<LtsRoomDatabase> {
    private final Provider<Context> contextProvider;

    private AppModule_ProvideAppDatabaseFactory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public LtsRoomDatabase m1401get() {
        return provideAppDatabase((Context) this.contextProvider.get());
    }

    public static AppModule_ProvideAppDatabaseFactory create(Provider<Context> contextProvider) {
        return new AppModule_ProvideAppDatabaseFactory(contextProvider);
    }

    public static LtsRoomDatabase provideAppDatabase(Context context) {
        return (LtsRoomDatabase) Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAppDatabase(context));
    }
}
