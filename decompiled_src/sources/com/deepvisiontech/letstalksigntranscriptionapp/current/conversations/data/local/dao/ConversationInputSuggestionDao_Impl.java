package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.typeconverters.CommonTypeConverters;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionCategoryEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionSentenceEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.typeconverter.MessageTypeConverters;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ConversationInputSuggestionDao_Impl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u001aJ\u001e\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0#H\u0016J\u0018\u0010&\u001a\u0004\u0018\u00010\b2\u0006\u0010'\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationInputSuggestionDao_Impl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationInputSuggestionDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfConversationInputSuggestionCategoryEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionCategoryEntity;", "__insertAdapterOfConversationInputSuggestionSentenceEntity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionSentenceEntity;", "__commonTypeConverters", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/local/typeconverters/CommonTypeConverters;", "__deleteAdapterOfConversationInputSuggestionCategoryEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__deleteAdapterOfConversationInputSuggestionSentenceEntity", "__updateAdapterOfConversationInputSuggestionCategoryEntity", "__updateAdapterOfConversationInputSuggestionSentenceEntity", "__messageTypeConverters", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/typeconverter/MessageTypeConverters;", "insertCategory", "", "category", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionCategoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSuggestion", "suggestion", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionSentenceEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCategory", "", "deleteSuggestion", "updateCategory", "updateSuggestion", "insertSuggestionWithCategory", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionCategoryEntity;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionSentenceEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSuggestionsWithCategories", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/SuggestionWithCategoryTuple;", "getCategoryById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSuggestionById", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationInputSuggestionDao_Impl implements ConversationInputSuggestionDao {
    private final CommonTypeConverters __commonTypeConverters;
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<ConversationInputSuggestionCategoryEntity> __deleteAdapterOfConversationInputSuggestionCategoryEntity;
    private final EntityDeleteOrUpdateAdapter<ConversationInputSuggestionSentenceEntity> __deleteAdapterOfConversationInputSuggestionSentenceEntity;
    private final EntityInsertAdapter<ConversationInputSuggestionCategoryEntity> __insertAdapterOfConversationInputSuggestionCategoryEntity;
    private final EntityInsertAdapter<ConversationInputSuggestionSentenceEntity> __insertAdapterOfConversationInputSuggestionSentenceEntity;
    private final MessageTypeConverters __messageTypeConverters;
    private final EntityDeleteOrUpdateAdapter<ConversationInputSuggestionCategoryEntity> __updateAdapterOfConversationInputSuggestionCategoryEntity;
    private final EntityDeleteOrUpdateAdapter<ConversationInputSuggestionSentenceEntity> __updateAdapterOfConversationInputSuggestionSentenceEntity;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public ConversationInputSuggestionDao_Impl(RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter(roomDatabase, "__db");
        this.__commonTypeConverters = new CommonTypeConverters();
        this.__messageTypeConverters = new MessageTypeConverters();
        this.__db = roomDatabase;
        this.__insertAdapterOfConversationInputSuggestionCategoryEntity = new EntityInsertAdapter<ConversationInputSuggestionCategoryEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `conversation_input_suggestion_categories` (`id`,`category_name`) VALUES (nullif(?, 0),?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, ConversationInputSuggestionCategoryEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo21bindLong(1, entity.getId());
                statement.mo23bindText(2, entity.getCategoryName());
            }
        };
        this.__insertAdapterOfConversationInputSuggestionSentenceEntity = new EntityInsertAdapter<ConversationInputSuggestionSentenceEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl.2
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `conversation_input_suggestion_sentences` (`id`,`suggestion_text`,`category_id_fk`,`language_code`) VALUES (nullif(?, 0),?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, ConversationInputSuggestionSentenceEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo21bindLong(1, entity.getId());
                statement.mo23bindText(2, entity.getText());
                statement.mo21bindLong(3, entity.getCategoryId());
                statement.mo23bindText(4, ConversationInputSuggestionDao_Impl.this.__commonTypeConverters.fromLanguageEnum(entity.getSuggestionLanguage()));
            }
        };
        this.__deleteAdapterOfConversationInputSuggestionCategoryEntity = new EntityDeleteOrUpdateAdapter<ConversationInputSuggestionCategoryEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `conversation_input_suggestion_categories` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, ConversationInputSuggestionCategoryEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo21bindLong(1, entity.getId());
            }
        };
        this.__deleteAdapterOfConversationInputSuggestionSentenceEntity = new EntityDeleteOrUpdateAdapter<ConversationInputSuggestionSentenceEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl.4
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `conversation_input_suggestion_sentences` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, ConversationInputSuggestionSentenceEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo21bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfConversationInputSuggestionCategoryEntity = new EntityDeleteOrUpdateAdapter<ConversationInputSuggestionCategoryEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `conversation_input_suggestion_categories` SET `id` = ?,`category_name` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, ConversationInputSuggestionCategoryEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo21bindLong(1, entity.getId());
                statement.mo23bindText(2, entity.getCategoryName());
                statement.mo21bindLong(3, entity.getId());
            }
        };
        this.__updateAdapterOfConversationInputSuggestionSentenceEntity = new EntityDeleteOrUpdateAdapter<ConversationInputSuggestionSentenceEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl.6
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `conversation_input_suggestion_sentences` SET `id` = ?,`suggestion_text` = ?,`category_id_fk` = ?,`language_code` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, ConversationInputSuggestionSentenceEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo21bindLong(1, entity.getId());
                statement.mo23bindText(2, entity.getText());
                statement.mo21bindLong(3, entity.getCategoryId());
                statement.mo23bindText(4, ConversationInputSuggestionDao_Impl.this.__commonTypeConverters.fromLanguageEnum(entity.getSuggestionLanguage()));
                statement.mo21bindLong(5, entity.getId());
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao
    public Object insertCategory(final ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return Long.valueOf(ConversationInputSuggestionDao_Impl.insertCategory$lambda$0(this.f$0, conversationInputSuggestionCategoryEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insertCategory$lambda$0(ConversationInputSuggestionDao_Impl conversationInputSuggestionDao_Impl, ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        return conversationInputSuggestionDao_Impl.__insertAdapterOfConversationInputSuggestionCategoryEntity.insertAndReturnId(sQLiteConnection, conversationInputSuggestionCategoryEntity);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao
    public Object insertSuggestion(final ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Long.valueOf(ConversationInputSuggestionDao_Impl.insertSuggestion$lambda$1(this.f$0, conversationInputSuggestionSentenceEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insertSuggestion$lambda$1(ConversationInputSuggestionDao_Impl conversationInputSuggestionDao_Impl, ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        return conversationInputSuggestionDao_Impl.__insertAdapterOfConversationInputSuggestionSentenceEntity.insertAndReturnId(sQLiteConnection, conversationInputSuggestionSentenceEntity);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao
    public Object deleteCategory(final ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return ConversationInputSuggestionDao_Impl.deleteCategory$lambda$2(this.f$0, conversationInputSuggestionCategoryEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteCategory$lambda$2(ConversationInputSuggestionDao_Impl conversationInputSuggestionDao_Impl, ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        conversationInputSuggestionDao_Impl.__deleteAdapterOfConversationInputSuggestionCategoryEntity.handle(sQLiteConnection, conversationInputSuggestionCategoryEntity);
        return Unit.INSTANCE;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao
    public Object deleteSuggestion(final ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return ConversationInputSuggestionDao_Impl.deleteSuggestion$lambda$3(this.f$0, conversationInputSuggestionSentenceEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteSuggestion$lambda$3(ConversationInputSuggestionDao_Impl conversationInputSuggestionDao_Impl, ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        conversationInputSuggestionDao_Impl.__deleteAdapterOfConversationInputSuggestionSentenceEntity.handle(sQLiteConnection, conversationInputSuggestionSentenceEntity);
        return Unit.INSTANCE;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao
    public Object updateCategory(final ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return ConversationInputSuggestionDao_Impl.updateCategory$lambda$4(this.f$0, conversationInputSuggestionCategoryEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateCategory$lambda$4(ConversationInputSuggestionDao_Impl conversationInputSuggestionDao_Impl, ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        conversationInputSuggestionDao_Impl.__updateAdapterOfConversationInputSuggestionCategoryEntity.handle(sQLiteConnection, conversationInputSuggestionCategoryEntity);
        return Unit.INSTANCE;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao
    public Object updateSuggestion(final ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return ConversationInputSuggestionDao_Impl.updateSuggestion$lambda$5(this.f$0, conversationInputSuggestionSentenceEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateSuggestion$lambda$5(ConversationInputSuggestionDao_Impl conversationInputSuggestionDao_Impl, ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        conversationInputSuggestionDao_Impl.__updateAdapterOfConversationInputSuggestionSentenceEntity.handle(sQLiteConnection, conversationInputSuggestionSentenceEntity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl$insertSuggestionWithCategory$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationInputSuggestionDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl$insertSuggestionWithCategory$2", f = "ConversationInputSuggestionDao_Impl.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
    static final class C01992 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {
        final /* synthetic */ ConversationInputSuggestionCategoryEntity $category;
        final /* synthetic */ ConversationInputSuggestionSentenceEntity $suggestion;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01992(ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity, ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity, Continuation<? super C01992> continuation) {
            super(1, continuation);
            this.$category = conversationInputSuggestionCategoryEntity;
            this.$suggestion = conversationInputSuggestionSentenceEntity;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationInputSuggestionDao_Impl.this.new C01992(this.$category, this.$suggestion, continuation);
        }

        public final Object invoke(Continuation<? super Long> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objInsertSuggestionWithCategory = ConversationInputSuggestionDao_Impl.super.insertSuggestionWithCategory(this.$category, this.$suggestion, (Continuation) this);
            return objInsertSuggestionWithCategory == coroutine_suspended ? coroutine_suspended : objInsertSuggestionWithCategory;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao
    public Object insertSuggestionWithCategory(ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity, ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity, Continuation<? super Long> continuation) {
        return DBUtil.performInTransactionSuspending(this.__db, new C01992(conversationInputSuggestionCategoryEntity, conversationInputSuggestionSentenceEntity, null), continuation);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao
    public Flow<List<SuggestionWithCategoryTuple>> getAllSuggestionsWithCategories() {
        final String str = "\n        SELECT \n            s.*, \n            c.id as cat_id, \n            c.category_name \n        FROM conversation_input_suggestion_sentences s\n        INNER JOIN conversation_input_suggestion_categories c \n        ON s.category_id_fk = c.id\n    ";
        return FlowUtil.createFlow(this.__db, false, new String[]{"conversation_input_suggestion_sentences", "conversation_input_suggestion_categories"}, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return ConversationInputSuggestionDao_Impl.getAllSuggestionsWithCategories$lambda$6(str, this, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllSuggestionsWithCategories$lambda$6(String str, ConversationInputSuggestionDao_Impl conversationInputSuggestionDao_Impl, SQLiteConnection sQLiteConnection) throws Throwable {
        SQLiteStatement sQLiteStatement;
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "suggestion_text");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "category_id_fk");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "language_code");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "cat_id");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "category_name");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                long j = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                int i = columnIndexOrThrow;
                sQLiteStatement = sQLiteStatementPrepare;
                try {
                    arrayList.add(new SuggestionWithCategoryTuple(new ConversationInputSuggestionSentenceEntity(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getLong(columnIndexOrThrow3), conversationInputSuggestionDao_Impl.__messageTypeConverters.toLanguageEnum(sQLiteStatementPrepare.getText(columnIndexOrThrow4))), sQLiteStatementPrepare.getText(columnIndexOrThrow6), j));
                    columnIndexOrThrow = i;
                    sQLiteStatementPrepare = sQLiteStatement;
                } catch (Throwable th) {
                    th = th;
                    sQLiteStatement.close();
                    throw th;
                }
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            sQLiteStatement = sQLiteStatementPrepare;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao
    public Object getCategoryById(final long j, Continuation<? super ConversationInputSuggestionCategoryEntity> continuation) {
        final String str = "SELECT * FROM conversation_input_suggestion_categories WHERE id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return ConversationInputSuggestionDao_Impl.getCategoryById$lambda$7(str, j, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationInputSuggestionCategoryEntity getCategoryById$lambda$7(String str, long j, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo21bindLong(1, j);
            return sQLiteStatementPrepare.step() ? new ConversationInputSuggestionCategoryEntity(sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "category_name"))) : null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao
    public Object deleteSuggestionById(final long j, Continuation<? super Unit> continuation) {
        final String str = "DELETE FROM conversation_input_suggestion_sentences WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return ConversationInputSuggestionDao_Impl.deleteSuggestionById$lambda$8(str, j, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteSuggestionById$lambda$8(String str, long j, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo21bindLong(1, j);
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: compiled from: ConversationInputSuggestionDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationInputSuggestionDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<KClass<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }
    }
}
