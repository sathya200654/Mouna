package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ConversationDao_Impl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00180\u0017H\u0016J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010\u001a\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationDao_Impl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfConversationEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationEntity;", "__deleteAdapterOfConversationEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfConversationEntity", "insertConversation", "", "conversationEntity", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteConversations", "", "conversations", "", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConversation", "getAllConversations", "Lkotlinx/coroutines/flow/Flow;", "", "getConversation", "id", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationDao_Impl implements ConversationDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<ConversationEntity> __deleteAdapterOfConversationEntity;
    private final EntityInsertAdapter<ConversationEntity> __insertAdapterOfConversationEntity;
    private final EntityDeleteOrUpdateAdapter<ConversationEntity> __updateAdapterOfConversationEntity;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public ConversationDao_Impl(RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter(roomDatabase, "__db");
        this.__db = roomDatabase;
        this.__insertAdapterOfConversationEntity = new EntityInsertAdapter<ConversationEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `conversations` (`id`,`conversation_name`,`time_created`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, ConversationEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo21bindLong(1, entity.getId());
                statement.mo23bindText(2, entity.getConversationName());
                statement.mo21bindLong(3, entity.getTimeCreated());
            }
        };
        this.__deleteAdapterOfConversationEntity = new EntityDeleteOrUpdateAdapter<ConversationEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `conversations` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, ConversationEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo21bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfConversationEntity = new EntityDeleteOrUpdateAdapter<ConversationEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `conversations` SET `id` = ?,`conversation_name` = ?,`time_created` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, ConversationEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo21bindLong(1, entity.getId());
                statement.mo23bindText(2, entity.getConversationName());
                statement.mo21bindLong(3, entity.getTimeCreated());
                statement.mo21bindLong(4, entity.getId());
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao
    public Object insertConversation(final ConversationEntity conversationEntity, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao_Impl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return Long.valueOf(ConversationDao_Impl.insertConversation$lambda$0(this.f$0, conversationEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insertConversation$lambda$0(ConversationDao_Impl conversationDao_Impl, ConversationEntity conversationEntity, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        return conversationDao_Impl.__insertAdapterOfConversationEntity.insertAndReturnId(sQLiteConnection, conversationEntity);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao
    public Object deleteConversations(final Set<ConversationEntity> set, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return ConversationDao_Impl.deleteConversations$lambda$1(this.f$0, set, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteConversations$lambda$1(ConversationDao_Impl conversationDao_Impl, Set set, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        conversationDao_Impl.__deleteAdapterOfConversationEntity.handleMultiple(sQLiteConnection, set);
        return Unit.INSTANCE;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao
    public Object updateConversation(final ConversationEntity conversationEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return ConversationDao_Impl.updateConversation$lambda$2(this.f$0, conversationEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateConversation$lambda$2(ConversationDao_Impl conversationDao_Impl, ConversationEntity conversationEntity, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        conversationDao_Impl.__updateAdapterOfConversationEntity.handle(sQLiteConnection, conversationEntity);
        return Unit.INSTANCE;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao
    public Flow<List<ConversationEntity>> getAllConversations() {
        final String str = "SELECT * FROM conversations";
        return FlowUtil.createFlow(this.__db, false, new String[]{"conversations"}, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return ConversationDao_Impl.getAllConversations$lambda$3(str, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllConversations$lambda$3(String str, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "conversation_name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "time_created");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new ConversationEntity(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getLong(columnIndexOrThrow3)));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao
    public Flow<ConversationEntity> getConversation(final long id) {
        final String str = "SELECT * FROM conversations WHERE id = ?";
        return FlowUtil.createFlow(this.__db, false, new String[]{"conversations"}, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return ConversationDao_Impl.getConversation$lambda$4(str, id, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationEntity getConversation$lambda$4(String str, long j, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo21bindLong(1, j);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "conversation_name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "time_created");
            if (sQLiteStatementPrepare.step()) {
                ConversationEntity conversationEntity = new ConversationEntity(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getLong(columnIndexOrThrow3));
                sQLiteStatementPrepare.close();
                return conversationEntity;
            }
            throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type <com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.`data`.local.entity.ConversationEntity>.".toString());
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: compiled from: ConversationDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
