package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.di;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationOcrApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationSuggestionsApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationSummaryApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationUsageApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationMessageRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSessionRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSuggestionRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationUsageRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: ConversationModule.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0001\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0007J\"\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000b2\b\b\u0001\u0010\u0017\u001a\u00020\u0018H\u0007J\u001c\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0007J\u001c\u0010!\u001a\u00020\"2\b\b\u0001\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0007J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\tH\u0007J\u0012\u0010'\u001a\u00020(2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u001a\u0010)\u001a\u00020*2\b\b\u0001\u0010\u0019\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020(H\u0007¨\u0006,"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/di/ConversationModule;", "", "<init>", "()V", "provideConversationOcrApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationOcrApi;", "retrofit", "Lretrofit2/Retrofit;", "provideConversationSuggestionApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationSuggestionsApi;", "provideConversationSummaryApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationSummaryApi;", "provideConversationDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationDao;", "db", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/local/LtsRoomDatabase;", "provideConversationMessageDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationMessageDao;", "provideConversationInputSuggestionDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationInputSuggestionDao;", "provideConversationRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationRepository;", "conversationDao", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "context", "Landroid/content/Context;", "provideConversationMessageRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationMessageRepository;", "conversationMessageDao", "conversationSummaryApi", "provideConversationSessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSessionRepository;", "provideConversationSettingsRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSettingsRepository;", "provideConversationSuggestionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/conversationsuggestion/ConversationSuggestionRepository;", "dao", "conversationSuggestionsApi", "provideConversationUsageApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationUsageApi;", "provideConversationUsageRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationUsageRepository;", "conversationUsageApi", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class ConversationModule {
    public static final int $stable = 0;
    public static final ConversationModule INSTANCE = new ConversationModule();

    private ConversationModule() {
    }

    @Provides
    @Singleton
    public final ConversationOcrApi provideConversationOcrApi(Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(ConversationOcrApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (ConversationOcrApi) objCreate;
    }

    @Provides
    @Singleton
    public final ConversationSuggestionsApi provideConversationSuggestionApi(Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(ConversationSuggestionsApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (ConversationSuggestionsApi) objCreate;
    }

    @Provides
    @Singleton
    public final ConversationSummaryApi provideConversationSummaryApi(Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(ConversationSummaryApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (ConversationSummaryApi) objCreate;
    }

    @Provides
    @Singleton
    public final ConversationDao provideConversationDao(LtsRoomDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        return db.conversationDao();
    }

    @Provides
    @Singleton
    public final ConversationMessageDao provideConversationMessageDao(LtsRoomDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        return db.conversationMessageDao();
    }

    @Provides
    @Singleton
    public final ConversationInputSuggestionDao provideConversationInputSuggestionDao(LtsRoomDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        return db.conversationInputSuggestionDao();
    }

    @Provides
    @Singleton
    public final ConversationRepository provideConversationRepository(ConversationDao conversationDao, CoroutineDispatcher ioDispatcher, @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(conversationDao, "conversationDao");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(context, "context");
        return new ConversationRepositoryImpl(conversationDao, ioDispatcher);
    }

    @Provides
    @Singleton
    public final ConversationMessageRepository provideConversationMessageRepository(ConversationMessageDao conversationMessageDao, ConversationSummaryApi conversationSummaryApi, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(conversationMessageDao, "conversationMessageDao");
        Intrinsics.checkNotNullParameter(conversationSummaryApi, "conversationSummaryApi");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        return new ConversationMessageRepositoryImpl(conversationMessageDao, conversationSummaryApi, ioDispatcher);
    }

    @Provides
    @Singleton
    public final ConversationSessionRepository provideConversationSessionRepository(CoroutineDispatcher ioDispatcher, @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(context, "context");
        return new ConversationSessionRepositoryImpl(ioDispatcher, context);
    }

    @Provides
    @Singleton
    public final ConversationSettingsRepository provideConversationSettingsRepository(CoroutineDispatcher ioDispatcher, @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(context, "context");
        return new ConversationSettingsRepositoryImpl(ioDispatcher, context);
    }

    @Provides
    @Singleton
    public final ConversationSuggestionRepository provideConversationSuggestionRepository(ConversationInputSuggestionDao dao, ConversationSuggestionsApi conversationSuggestionsApi) {
        Intrinsics.checkNotNullParameter(dao, "dao");
        Intrinsics.checkNotNullParameter(conversationSuggestionsApi, "conversationSuggestionsApi");
        return new ConversationSuggestionRepositoryImpl(dao, conversationSuggestionsApi);
    }

    @Provides
    @Singleton
    public final ConversationUsageApi provideConversationUsageApi(Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(ConversationUsageApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (ConversationUsageApi) objCreate;
    }

    @Provides
    @Singleton
    public final ConversationUsageRepository provideConversationUsageRepository(@ApplicationContext Context context, ConversationUsageApi conversationUsageApi) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(conversationUsageApi, "conversationUsageApi");
        return new ConversationUsageRepositoryImpl(context, conversationUsageApi);
    }
}
