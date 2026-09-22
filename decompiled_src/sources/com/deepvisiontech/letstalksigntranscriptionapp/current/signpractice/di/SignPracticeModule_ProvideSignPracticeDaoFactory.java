package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SignPracticeModule_ProvideSignPracticeDaoFactory implements Factory<SignPracticeDao> {
    private final Provider<LtsRoomDatabase> dbProvider;

    private SignPracticeModule_ProvideSignPracticeDaoFactory(Provider<LtsRoomDatabase> dbProvider) {
        this.dbProvider = dbProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SignPracticeDao m1795get() {
        return provideSignPracticeDao((LtsRoomDatabase) this.dbProvider.get());
    }

    public static SignPracticeModule_ProvideSignPracticeDaoFactory create(Provider<LtsRoomDatabase> dbProvider) {
        return new SignPracticeModule_ProvideSignPracticeDaoFactory(dbProvider);
    }

    public static SignPracticeDao provideSignPracticeDao(LtsRoomDatabase db) {
        return (SignPracticeDao) Preconditions.checkNotNullFromProvides(SignPracticeModule.INSTANCE.provideSignPracticeDao(db));
    }
}
