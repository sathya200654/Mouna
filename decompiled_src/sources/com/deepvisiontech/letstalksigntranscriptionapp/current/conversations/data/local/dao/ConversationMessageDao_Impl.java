package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.typeconverters.CommonTypeConverters;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationMessageEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.typeconverter.MessageTypeConverters;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

/* JADX INFO: compiled from: ConversationMessageDao_Impl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0013J\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u001eJ\u001c\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0!0 2\u0006\u0010\"\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationMessageDao_Impl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationMessageDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfConversationMessageEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationMessageEntity;", "__commonTypeConverters", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/local/typeconverters/CommonTypeConverters;", "__messageTypeConverters", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/typeconverter/MessageTypeConverters;", "__deleteAdapterOfConversationMessageEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfConversationMessageEntity", "insertMessage", "", ResponseKeys.KEY_MESSAGE, "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationMessageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMessages", "", "messages", "", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMessage", "insertWithNextSequenceId", "getLastSequenceId", "", "conversationId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllMessagesOfConversation", "Lkotlinx/coroutines/flow/Flow;", "", "id", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationMessageDao_Impl implements ConversationMessageDao {
    private final CommonTypeConverters __commonTypeConverters;
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<ConversationMessageEntity> __deleteAdapterOfConversationMessageEntity;
    private final EntityInsertAdapter<ConversationMessageEntity> __insertAdapterOfConversationMessageEntity;
    private final MessageTypeConverters __messageTypeConverters;
    private final EntityDeleteOrUpdateAdapter<ConversationMessageEntity> __updateAdapterOfConversationMessageEntity;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public ConversationMessageDao_Impl(RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter(roomDatabase, "__db");
        this.__commonTypeConverters = new CommonTypeConverters();
        this.__messageTypeConverters = new MessageTypeConverters();
        this.__db = roomDatabase;
        this.__insertAdapterOfConversationMessageEntity = new EntityInsertAdapter<ConversationMessageEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `conversation_messages` (`id`,`conversation_id_fk`,`user_name`,`message`,`processed_message`,`processed_message_language`,`message_language`,`sign_gloss`,`sequence_id`,`message_input_type`,`message_type`,`is_processed`,`time_created`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, ConversationMessageEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo21bindLong(1, entity.getId());
                statement.mo21bindLong(2, entity.getConversationIdFk());
                statement.mo23bindText(3, entity.getUserName());
                statement.mo23bindText(4, entity.getMessage());
                statement.mo23bindText(5, entity.getProcessedMessage());
                statement.mo23bindText(6, ConversationMessageDao_Impl.this.__commonTypeConverters.fromLanguageEnum(entity.getProcessedMessageLanguage()));
                statement.mo23bindText(7, ConversationMessageDao_Impl.this.__commonTypeConverters.fromLanguageEnum(entity.getMessageLanguage()));
                String signGloss = entity.getSignGloss();
                if (signGloss == null) {
                    statement.mo22bindNull(8);
                } else {
                    statement.mo23bindText(8, signGloss);
                }
                statement.mo21bindLong(9, entity.getSequenceId());
                statement.mo23bindText(10, ConversationMessageDao_Impl.this.__messageTypeConverters.fromMessageInputTypeEnum(entity.getMessageInputType()));
                statement.mo23bindText(11, ConversationMessageDao_Impl.this.__messageTypeConverters.fromMessageTypeEnum(entity.getMessageType()));
                statement.mo21bindLong(12, entity.isProcessed() ? 1L : 0L);
                statement.mo21bindLong(13, entity.getTimeCreated());
            }
        };
        this.__deleteAdapterOfConversationMessageEntity = new EntityDeleteOrUpdateAdapter<ConversationMessageEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `conversation_messages` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, ConversationMessageEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo21bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfConversationMessageEntity = new EntityDeleteOrUpdateAdapter<ConversationMessageEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `conversation_messages` SET `id` = ?,`conversation_id_fk` = ?,`user_name` = ?,`message` = ?,`processed_message` = ?,`processed_message_language` = ?,`message_language` = ?,`sign_gloss` = ?,`sequence_id` = ?,`message_input_type` = ?,`message_type` = ?,`is_processed` = ?,`time_created` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, ConversationMessageEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo21bindLong(1, entity.getId());
                statement.mo21bindLong(2, entity.getConversationIdFk());
                statement.mo23bindText(3, entity.getUserName());
                statement.mo23bindText(4, entity.getMessage());
                statement.mo23bindText(5, entity.getProcessedMessage());
                statement.mo23bindText(6, ConversationMessageDao_Impl.this.__commonTypeConverters.fromLanguageEnum(entity.getProcessedMessageLanguage()));
                statement.mo23bindText(7, ConversationMessageDao_Impl.this.__commonTypeConverters.fromLanguageEnum(entity.getMessageLanguage()));
                String signGloss = entity.getSignGloss();
                if (signGloss == null) {
                    statement.mo22bindNull(8);
                } else {
                    statement.mo23bindText(8, signGloss);
                }
                statement.mo21bindLong(9, entity.getSequenceId());
                statement.mo23bindText(10, ConversationMessageDao_Impl.this.__messageTypeConverters.fromMessageInputTypeEnum(entity.getMessageInputType()));
                statement.mo23bindText(11, ConversationMessageDao_Impl.this.__messageTypeConverters.fromMessageTypeEnum(entity.getMessageType()));
                statement.mo21bindLong(12, entity.isProcessed() ? 1L : 0L);
                statement.mo21bindLong(13, entity.getTimeCreated());
                statement.mo21bindLong(14, entity.getId());
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao
    public Object insertMessage(final ConversationMessageEntity conversationMessageEntity, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Long.valueOf(ConversationMessageDao_Impl.insertMessage$lambda$0(this.f$0, conversationMessageEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insertMessage$lambda$0(ConversationMessageDao_Impl conversationMessageDao_Impl, ConversationMessageEntity conversationMessageEntity, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        return conversationMessageDao_Impl.__insertAdapterOfConversationMessageEntity.insertAndReturnId(sQLiteConnection, conversationMessageEntity);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao
    public Object deleteMessages(final Set<ConversationMessageEntity> set, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return ConversationMessageDao_Impl.deleteMessages$lambda$1(this.f$0, set, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteMessages$lambda$1(ConversationMessageDao_Impl conversationMessageDao_Impl, Set set, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        conversationMessageDao_Impl.__deleteAdapterOfConversationMessageEntity.handleMultiple(sQLiteConnection, set);
        return Unit.INSTANCE;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao
    public Object updateMessage(final ConversationMessageEntity conversationMessageEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return ConversationMessageDao_Impl.updateMessage$lambda$2(this.f$0, conversationMessageEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateMessage$lambda$2(ConversationMessageDao_Impl conversationMessageDao_Impl, ConversationMessageEntity conversationMessageEntity, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        conversationMessageDao_Impl.__updateAdapterOfConversationMessageEntity.handle(sQLiteConnection, conversationMessageEntity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao_Impl$insertWithNextSequenceId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationMessageDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationMessageEntity;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao_Impl$insertWithNextSequenceId$2", f = "ConversationMessageDao_Impl.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
    static final class C02002 extends SuspendLambda implements Function1<Continuation<? super ConversationMessageEntity>, Object> {
        final /* synthetic */ ConversationMessageEntity $message;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02002(ConversationMessageEntity conversationMessageEntity, Continuation<? super C02002> continuation) {
            super(1, continuation);
            this.$message = conversationMessageEntity;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ConversationMessageDao_Impl.this.new C02002(this.$message, continuation);
        }

        public final Object invoke(Continuation<? super ConversationMessageEntity> continuation) {
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
            Object objInsertWithNextSequenceId = ConversationMessageDao_Impl.super.insertWithNextSequenceId(this.$message, (Continuation) this);
            return objInsertWithNextSequenceId == coroutine_suspended ? coroutine_suspended : objInsertWithNextSequenceId;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao
    public Object insertWithNextSequenceId(ConversationMessageEntity conversationMessageEntity, Continuation<? super ConversationMessageEntity> continuation) {
        return DBUtil.performInTransactionSuspending(this.__db, new C02002(conversationMessageEntity, null), continuation);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao
    public Object getLastSequenceId(final long j, Continuation<? super Integer> continuation) {
        final String str = "SELECT MAX(sequence_id) FROM conversation_messages WHERE conversation_id_fk = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao_Impl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return ConversationMessageDao_Impl.getLastSequenceId$lambda$3(str, j, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer getLastSequenceId$lambda$3(String str, long j, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo21bindLong(1, j);
            Integer numValueOf = null;
            if (sQLiteStatementPrepare.step() && !sQLiteStatementPrepare.isNull(0)) {
                numValueOf = Integer.valueOf((int) sQLiteStatementPrepare.getLong(0));
            }
            return numValueOf;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao
    public Flow<List<ConversationMessageEntity>> getAllMessagesOfConversation(final long id) {
        final String str = "SELECT * FROM conversation_messages WHERE conversation_id_fk = ? ORDER BY sequence_id ASC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"conversation_messages"}, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return ConversationMessageDao_Impl.getAllMessagesOfConversation$lambda$4(str, id, this, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllMessagesOfConversation$lambda$4(String str, long j, ConversationMessageDao_Impl conversationMessageDao_Impl, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo21bindLong(1, j);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "conversation_id_fk");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "user_name");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, ResponseKeys.KEY_MESSAGE);
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "processed_message");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "processed_message_language");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "message_language");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sign_gloss");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sequence_id");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "message_input_type");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Constants.MessagePayloadKeys.MESSAGE_TYPE);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "is_processed");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "time_created");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = columnIndexOrThrow;
                int i2 = columnIndexOrThrow2;
                arrayList.add(new ConversationMessageEntity(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getLong(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), conversationMessageDao_Impl.__messageTypeConverters.toLanguageEnum(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), conversationMessageDao_Impl.__messageTypeConverters.toLanguageEnum(sQLiteStatementPrepare.getText(columnIndexOrThrow7)), sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9), conversationMessageDao_Impl.__messageTypeConverters.toMessageInputTypeEnum(sQLiteStatementPrepare.getText(columnIndexOrThrow10)), conversationMessageDao_Impl.__commonTypeConverters.toMessageTypeEnum(sQLiteStatementPrepare.getText(columnIndexOrThrow11)), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow12)) != 0, sQLiteStatementPrepare.getLong(columnIndexOrThrow13)));
                columnIndexOrThrow = i;
                columnIndexOrThrow2 = i2;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: compiled from: ConversationMessageDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationMessageDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
