package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationModule_ProvideConversationDaoFactory implements Factory<ConversationDao> {
    private final Provider<LtsRoomDatabase> dbProvider;

    private ConversationModule_ProvideConversationDaoFactory(Provider<LtsRoomDatabase> dbProvider) {
        this.dbProvider = dbProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationDao m1470get() {
        return provideConversationDao((LtsRoomDatabase) this.dbProvider.get());
    }

    public static ConversationModule_ProvideConversationDaoFactory create(Provider<LtsRoomDatabase> dbProvider) {
        return new ConversationModule_ProvideConversationDaoFactory(dbProvider);
    }

    public static ConversationDao provideConversationDao(LtsRoomDatabase db) {
        return (ConversationDao) Preconditions.checkNotNullFromProvides(ConversationModule.INSTANCE.provideConversationDao(db));
    }
}
