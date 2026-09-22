package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationModule_ProvideConversationInputSuggestionDaoFactory implements Factory<ConversationInputSuggestionDao> {
    private final Provider<LtsRoomDatabase> dbProvider;

    private ConversationModule_ProvideConversationInputSuggestionDaoFactory(Provider<LtsRoomDatabase> dbProvider) {
        this.dbProvider = dbProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationInputSuggestionDao m1471get() {
        return provideConversationInputSuggestionDao((LtsRoomDatabase) this.dbProvider.get());
    }

    public static ConversationModule_ProvideConversationInputSuggestionDaoFactory create(Provider<LtsRoomDatabase> dbProvider) {
        return new ConversationModule_ProvideConversationInputSuggestionDaoFactory(dbProvider);
    }

    public static ConversationInputSuggestionDao provideConversationInputSuggestionDao(LtsRoomDatabase db) {
        return (ConversationInputSuggestionDao) Preconditions.checkNotNullFromProvides(ConversationModule.INSTANCE.provideConversationInputSuggestionDao(db));
    }
}
