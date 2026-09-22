package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationModule_ProvideConversationMessageDaoFactory implements Factory<ConversationMessageDao> {
    private final Provider<LtsRoomDatabase> dbProvider;

    private ConversationModule_ProvideConversationMessageDaoFactory(Provider<LtsRoomDatabase> dbProvider) {
        this.dbProvider = dbProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationMessageDao m1472get() {
        return provideConversationMessageDao((LtsRoomDatabase) this.dbProvider.get());
    }

    public static ConversationModule_ProvideConversationMessageDaoFactory create(Provider<LtsRoomDatabase> dbProvider) {
        return new ConversationModule_ProvideConversationMessageDaoFactory(dbProvider);
    }

    public static ConversationMessageDao provideConversationMessageDao(LtsRoomDatabase db) {
        return (ConversationMessageDao) Preconditions.checkNotNullFromProvides(ConversationModule.INSTANCE.provideConversationMessageDao(db));
    }
}
