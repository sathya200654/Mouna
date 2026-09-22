package com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local;

import androidx.room.InvalidationTracker;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao_Impl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao_Impl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao_Impl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao_Impl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao_Impl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao_Impl;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: LtsRoomDatabase_Impl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u001a0\u0018H\u0014J\u0016\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u00190\u001cH\u0016J*\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001a2\u001a\u0010 \u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u0019\u0012\u0004\u0012\u00020\u001d0\u0018H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\b\u0010&\u001a\u00020\u0010H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/local/LtsRoomDatabase_Impl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/local/LtsRoomDatabase;", "<init>", "()V", "_signPracticeDao", "Lkotlin/Lazy;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/dao/SignPracticeDao;", "_notificationDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/dao/NotificationDao;", "_conversationDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationDao;", "_conversationMessageDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationMessageDao;", "_conversationInputSuggestionDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationInputSuggestionDao;", "_environmentSoundHistoryDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/daos/EnvironmentSoundHistoryDao;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", "", "getRequiredTypeConverterClasses", "", "Lkotlin/reflect/KClass;", "", "getRequiredAutoMigrationSpecClasses", "", "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "signPracticeDao", "notificationDao", "conversationDao", "conversationMessageDao", "conversationInputSuggestionDao", "environmentSoundHistoryDao", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LtsRoomDatabase_Impl extends LtsRoomDatabase {
    public static final int $stable = 8;
    private final Lazy<SignPracticeDao> _signPracticeDao = LazyKt.lazy(new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase_Impl$$ExternalSyntheticLambda0
        public final Object invoke() {
            return LtsRoomDatabase_Impl._signPracticeDao$lambda$0(this.f$0);
        }
    });
    private final Lazy<NotificationDao> _notificationDao = LazyKt.lazy(new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase_Impl$$ExternalSyntheticLambda1
        public final Object invoke() {
            return LtsRoomDatabase_Impl._notificationDao$lambda$1(this.f$0);
        }
    });
    private final Lazy<ConversationDao> _conversationDao = LazyKt.lazy(new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase_Impl$$ExternalSyntheticLambda2
        public final Object invoke() {
            return LtsRoomDatabase_Impl._conversationDao$lambda$2(this.f$0);
        }
    });
    private final Lazy<ConversationMessageDao> _conversationMessageDao = LazyKt.lazy(new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase_Impl$$ExternalSyntheticLambda3
        public final Object invoke() {
            return LtsRoomDatabase_Impl._conversationMessageDao$lambda$3(this.f$0);
        }
    });
    private final Lazy<ConversationInputSuggestionDao> _conversationInputSuggestionDao = LazyKt.lazy(new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase_Impl$$ExternalSyntheticLambda4
        public final Object invoke() {
            return LtsRoomDatabase_Impl._conversationInputSuggestionDao$lambda$4(this.f$0);
        }
    });
    private final Lazy<EnvironmentSoundHistoryDao> _environmentSoundHistoryDao = LazyKt.lazy(new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase_Impl$$ExternalSyntheticLambda5
        public final Object invoke() {
            return LtsRoomDatabase_Impl._environmentSoundHistoryDao$lambda$5(this.f$0);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignPracticeDao_Impl _signPracticeDao$lambda$0(LtsRoomDatabase_Impl ltsRoomDatabase_Impl) {
        return new SignPracticeDao_Impl(ltsRoomDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationDao_Impl _notificationDao$lambda$1(LtsRoomDatabase_Impl ltsRoomDatabase_Impl) {
        return new NotificationDao_Impl(ltsRoomDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationDao_Impl _conversationDao$lambda$2(LtsRoomDatabase_Impl ltsRoomDatabase_Impl) {
        return new ConversationDao_Impl(ltsRoomDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationMessageDao_Impl _conversationMessageDao$lambda$3(LtsRoomDatabase_Impl ltsRoomDatabase_Impl) {
        return new ConversationMessageDao_Impl(ltsRoomDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationInputSuggestionDao_Impl _conversationInputSuggestionDao$lambda$4(LtsRoomDatabase_Impl ltsRoomDatabase_Impl) {
        return new ConversationInputSuggestionDao_Impl(ltsRoomDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnvironmentSoundHistoryDao_Impl _environmentSoundHistoryDao$lambda$5(LtsRoomDatabase_Impl ltsRoomDatabase_Impl) {
        return new EnvironmentSoundHistoryDao_Impl(ltsRoomDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    public RoomOpenDelegate createOpenDelegate() {
        return new RoomOpenDelegate() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase_Impl$createOpenDelegate$_openDelegate$1
            @Override // androidx.room.RoomOpenDelegate
            public void onCreate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onPostMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            {
                super(16, "80a3bc1fb90e9f71e83026dbba58d328", "dbc1c9c525d9620654783599b671e10d");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void createAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `fcm_notifications` (`id` TEXT NOT NULL, `notification_title` TEXT NOT NULL, `notification_body` TEXT, `data` TEXT, `read_status` INTEGER NOT NULL, `notification_date_time` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `conversations` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `conversation_name` TEXT NOT NULL, `time_created` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `conversation_messages` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `conversation_id_fk` INTEGER NOT NULL, `user_name` TEXT NOT NULL, `message` TEXT NOT NULL, `processed_message` TEXT NOT NULL, `processed_message_language` TEXT NOT NULL, `message_language` TEXT NOT NULL, `sign_gloss` TEXT, `sequence_id` INTEGER NOT NULL, `message_input_type` TEXT NOT NULL, `message_type` TEXT NOT NULL, `is_processed` INTEGER NOT NULL, `time_created` INTEGER NOT NULL, FOREIGN KEY(`conversation_id_fk`) REFERENCES `conversations`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_conversation_messages_conversation_id_fk_sequence_id` ON `conversation_messages` (`conversation_id_fk`, `sequence_id`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `conversation_input_suggestion_categories` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `category_name` TEXT NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `conversation_input_suggestion_sentences` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `suggestion_text` TEXT NOT NULL, `category_id_fk` INTEGER NOT NULL, `language_code` TEXT NOT NULL DEFAULT 'ENGLISH', FOREIGN KEY(`category_id_fk`) REFERENCES `conversation_input_suggestion_categories`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_conversation_input_suggestion_sentences_category_id_fk` ON `conversation_input_suggestion_sentences` (`category_id_fk`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `sign_practice` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `practice_name` TEXT NOT NULL, `domain` TEXT NOT NULL, `content` TEXT NOT NULL, `topic` TEXT NOT NULL, `complexity` TEXT NOT NULL, `language` TEXT NOT NULL, `type` TEXT NOT NULL, `uri` TEXT NOT NULL, `opens` INTEGER NOT NULL, `time_created` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `environment_sound_history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `label` TEXT NOT NULL, `confidence` REAL NOT NULL, `timestamp` INTEGER NOT NULL)");
                SQLite.execSQL(connection, RoomMasterTable.CREATE_QUERY);
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '80a3bc1fb90e9f71e83026dbba58d328')");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void dropAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `fcm_notifications`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `conversations`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `conversation_messages`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `conversation_input_suggestion_categories`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `conversation_input_suggestion_sentences`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `sign_practice`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `environment_sound_history`");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onOpen(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "PRAGMA foreign_keys = ON");
                this.this$0.internalInitInvalidationTracker(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onPreMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                DBUtil.dropFtsSyncTriggers(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                linkedHashMap.put("notification_title", new TableInfo.Column("notification_title", "TEXT", true, 0, null, 1));
                linkedHashMap.put("notification_body", new TableInfo.Column("notification_body", "TEXT", false, 0, null, 1));
                linkedHashMap.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, new TableInfo.Column(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "TEXT", false, 0, null, 1));
                linkedHashMap.put("read_status", new TableInfo.Column("read_status", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("notification_date_time", new TableInfo.Column("notification_date_time", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("fcm_notifications", linkedHashMap, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo2 = TableInfo.INSTANCE.read(connection, "fcm_notifications");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenDelegate.ValidationResult(false, "fcm_notifications(com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.entity.NotificationEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap2.put("conversation_name", new TableInfo.Column("conversation_name", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("time_created", new TableInfo.Column("time_created", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("conversations", linkedHashMap2, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo4 = TableInfo.INSTANCE.read(connection, "conversations");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenDelegate.ValidationResult(false, "conversations(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap3.put("conversation_id_fk", new TableInfo.Column("conversation_id_fk", "INTEGER", true, 0, null, 1));
                linkedHashMap3.put("user_name", new TableInfo.Column("user_name", "TEXT", true, 0, null, 1));
                linkedHashMap3.put(ResponseKeys.KEY_MESSAGE, new TableInfo.Column(ResponseKeys.KEY_MESSAGE, "TEXT", true, 0, null, 1));
                linkedHashMap3.put("processed_message", new TableInfo.Column("processed_message", "TEXT", true, 0, null, 1));
                linkedHashMap3.put("processed_message_language", new TableInfo.Column("processed_message_language", "TEXT", true, 0, null, 1));
                linkedHashMap3.put("message_language", new TableInfo.Column("message_language", "TEXT", true, 0, null, 1));
                linkedHashMap3.put("sign_gloss", new TableInfo.Column("sign_gloss", "TEXT", false, 0, null, 1));
                linkedHashMap3.put("sequence_id", new TableInfo.Column("sequence_id", "INTEGER", true, 0, null, 1));
                linkedHashMap3.put("message_input_type", new TableInfo.Column("message_input_type", "TEXT", true, 0, null, 1));
                linkedHashMap3.put(Constants.MessagePayloadKeys.MESSAGE_TYPE, new TableInfo.Column(Constants.MessagePayloadKeys.MESSAGE_TYPE, "TEXT", true, 0, null, 1));
                linkedHashMap3.put("is_processed", new TableInfo.Column("is_processed", "INTEGER", true, 0, null, 1));
                linkedHashMap3.put("time_created", new TableInfo.Column("time_created", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                linkedHashSet.add(new TableInfo.ForeignKey("conversations", "CASCADE", "NO ACTION", CollectionsKt.listOf("conversation_id_fk"), CollectionsKt.listOf("id")));
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                linkedHashSet2.add(new TableInfo.Index("index_conversation_messages_conversation_id_fk_sequence_id", true, CollectionsKt.listOf(new String[]{"conversation_id_fk", "sequence_id"}), CollectionsKt.listOf(new String[]{"ASC", "ASC"})));
                TableInfo tableInfo5 = new TableInfo("conversation_messages", linkedHashMap3, linkedHashSet, linkedHashSet2);
                TableInfo tableInfo6 = TableInfo.INSTANCE.read(connection, "conversation_messages");
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenDelegate.ValidationResult(false, "conversation_messages(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationMessageEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                linkedHashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap4.put("category_name", new TableInfo.Column("category_name", "TEXT", true, 0, null, 1));
                TableInfo tableInfo7 = new TableInfo("conversation_input_suggestion_categories", linkedHashMap4, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo8 = TableInfo.INSTANCE.read(connection, "conversation_input_suggestion_categories");
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenDelegate.ValidationResult(false, "conversation_input_suggestion_categories(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionCategoryEntity).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                }
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                linkedHashMap5.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap5.put("suggestion_text", new TableInfo.Column("suggestion_text", "TEXT", true, 0, null, 1));
                linkedHashMap5.put("category_id_fk", new TableInfo.Column("category_id_fk", "INTEGER", true, 0, null, 1));
                linkedHashMap5.put("language_code", new TableInfo.Column("language_code", "TEXT", true, 0, "'ENGLISH'", 1));
                LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                linkedHashSet3.add(new TableInfo.ForeignKey("conversation_input_suggestion_categories", "CASCADE", "NO ACTION", CollectionsKt.listOf("category_id_fk"), CollectionsKt.listOf("id")));
                LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                linkedHashSet4.add(new TableInfo.Index("index_conversation_input_suggestion_sentences_category_id_fk", false, CollectionsKt.listOf("category_id_fk"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo9 = new TableInfo("conversation_input_suggestion_sentences", linkedHashMap5, linkedHashSet3, linkedHashSet4);
                TableInfo tableInfo10 = TableInfo.INSTANCE.read(connection, "conversation_input_suggestion_sentences");
                if (!tableInfo9.equals(tableInfo10)) {
                    return new RoomOpenDelegate.ValidationResult(false, "conversation_input_suggestion_sentences(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionSentenceEntity).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
                }
                LinkedHashMap linkedHashMap6 = new LinkedHashMap();
                linkedHashMap6.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap6.put("practice_name", new TableInfo.Column("practice_name", "TEXT", true, 0, null, 1));
                linkedHashMap6.put("domain", new TableInfo.Column("domain", "TEXT", true, 0, null, 1));
                linkedHashMap6.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, 1));
                linkedHashMap6.put("topic", new TableInfo.Column("topic", "TEXT", true, 0, null, 1));
                linkedHashMap6.put("complexity", new TableInfo.Column("complexity", "TEXT", true, 0, null, 1));
                linkedHashMap6.put("language", new TableInfo.Column("language", "TEXT", true, 0, null, 1));
                linkedHashMap6.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, new TableInfo.Column(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "TEXT", true, 0, null, 1));
                linkedHashMap6.put("uri", new TableInfo.Column("uri", "TEXT", true, 0, null, 1));
                linkedHashMap6.put("opens", new TableInfo.Column("opens", "INTEGER", true, 0, null, 1));
                linkedHashMap6.put("time_created", new TableInfo.Column("time_created", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo11 = new TableInfo("sign_practice", linkedHashMap6, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo12 = TableInfo.INSTANCE.read(connection, "sign_practice");
                if (!tableInfo11.equals(tableInfo12)) {
                    return new RoomOpenDelegate.ValidationResult(false, "sign_practice(com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.entity.SignPracticeEntity).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfo12);
                }
                LinkedHashMap linkedHashMap7 = new LinkedHashMap();
                linkedHashMap7.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap7.put(Constants.ScionAnalytics.PARAM_LABEL, new TableInfo.Column(Constants.ScionAnalytics.PARAM_LABEL, "TEXT", true, 0, null, 1));
                linkedHashMap7.put("confidence", new TableInfo.Column("confidence", "REAL", true, 0, null, 1));
                linkedHashMap7.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo13 = new TableInfo("environment_sound_history", linkedHashMap7, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo14 = TableInfo.INSTANCE.read(connection, "environment_sound_history");
                if (!tableInfo13.equals(tableInfo14)) {
                    return new RoomOpenDelegate.ValidationResult(false, "environment_sound_history(com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.entities.EnvironmentSoundHistoryEntity).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfo14);
                }
                return new RoomOpenDelegate.ValidationResult(true, null);
            }
        };
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "fcm_notifications", "conversations", "conversation_messages", "conversation_input_suggestion_categories", "conversation_input_suggestion_sentences", "sign_practice", "environment_sound_history");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.performClear(true, "fcm_notifications", "conversations", "conversation_messages", "conversation_input_suggestion_categories", "conversation_input_suggestion_sentences", "sign_practice", "environment_sound_history");
    }

    @Override // androidx.room.RoomDatabase
    protected Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(SignPracticeDao.class), SignPracticeDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(NotificationDao.class), NotificationDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(ConversationDao.class), ConversationDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(ConversationMessageDao.class), ConversationMessageDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(ConversationInputSuggestionDao.class), ConversationInputSuggestionDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(EnvironmentSoundHistoryDao.class), EnvironmentSoundHistoryDao_Impl.INSTANCE.getRequiredConverters());
        return linkedHashMap;
    }

    @Override // androidx.room.RoomDatabase
    public Set<KClass<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecClasses() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> createAutoMigrations(Map<KClass<? extends AutoMigrationSpec>, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        return new ArrayList();
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase
    public SignPracticeDao signPracticeDao() {
        return (SignPracticeDao) this._signPracticeDao.getValue();
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase
    public NotificationDao notificationDao() {
        return (NotificationDao) this._notificationDao.getValue();
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase
    public ConversationDao conversationDao() {
        return (ConversationDao) this._conversationDao.getValue();
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase
    public ConversationMessageDao conversationMessageDao() {
        return (ConversationMessageDao) this._conversationMessageDao.getValue();
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase
    public ConversationInputSuggestionDao conversationInputSuggestionDao() {
        return (ConversationInputSuggestionDao) this._conversationInputSuggestionDao.getValue();
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase
    public EnvironmentSoundHistoryDao environmentSoundHistoryDao() {
        return (EnvironmentSoundHistoryDao) this._environmentSoundHistoryDao.getValue();
    }
}
