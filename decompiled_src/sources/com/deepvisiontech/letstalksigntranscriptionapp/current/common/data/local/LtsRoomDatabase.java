package com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao;
import com.google.firebase.Firebase;
import com.google.firebase.crashlytics.FirebaseCrashlyticsKt;
import com.google.firebase.messaging.Constants;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AppDatabase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/local/LtsRoomDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "signPracticeDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/dao/SignPracticeDao;", "notificationDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/dao/NotificationDao;", "conversationDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationDao;", "conversationMessageDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationMessageDao;", "conversationInputSuggestionDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationInputSuggestionDao;", "environmentSoundHistoryDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/daos/EnvironmentSoundHistoryDao;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class LtsRoomDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "LTSDatabaseTest.db";
    private static volatile LtsRoomDatabase INSTANCE;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Migration MIGRATION_1_2 = new Migration() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase$Companion$MIGRATION_1_2$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            LtsRoomDatabase.INSTANCE.runLegacyCatchUpMigration(db);
        }
    };
    private static final Migration MIGRATION_2_3 = new Migration() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase$Companion$MIGRATION_2_3$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            LtsRoomDatabase.INSTANCE.runLegacyCatchUpMigration(db);
        }
    };
    private static final Migration MIGRATION_3_4 = new Migration() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase$Companion$MIGRATION_3_4$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            LtsRoomDatabase.INSTANCE.runLegacyCatchUpMigration(db);
        }
    };
    private static final Migration MIGRATION_4_5 = new Migration() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase$Companion$MIGRATION_4_5$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE sessions_new (\n                    id TEXT PRIMARY KEY NOT NULL,\n                    session_name TEXT NOT NULL,\n                    summary TEXT,\n                    summary_date_time TEXT\n                    )");
            db.execSQL("INSERT INTO sessions_new (id, session_name, summary, summary_date_time)\n                    SELECT id, COALESCE(session_name,\"Untitled Session\"), summary, summary_date_time FROM sessions\n                    WHERE id IS NOT NULL");
            db.execSQL("DROP TABLE sessions");
            db.execSQL("ALTER TABLE sessions_new RENAME TO sessions");
            db.execSQL("CREATE TABLE messages_new (\n                    message_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                    session_id_fk TEXT NOT NULL,\n                    user_name TEXT,\n                    message_text TEXT NOT NULL,\n                    message_text_trans TEXT,\n                    message_timestamp TEXT,\n                    sequence_id INTEGER NOT NULL,\n                    type_mode TEXT,\n                    is_interpreted INTEGER,\n                    FOREIGN KEY(session_id_fk) REFERENCES sessions(id) ON DELETE CASCADE\n                    )");
            db.execSQL("INSERT INTO messages_new (message_id, session_id_fk, user_name, message_text, message_text_trans, message_timestamp, sequence_id, type_mode, is_interpreted)\n                    SELECT message_id, session_id_fk, user_name, COALESCE(message_text,\"\"), message_text_trans, message_timestamp, sequence_id, type_mode, is_interpreted\n                    FROM messages\n                    WHERE session_id_fk IS NOT NULL AND sequence_id IS NOT NULL");
            db.execSQL("DROP TABLE messages");
            db.execSQL("ALTER TABLE messages_new RENAME TO messages");
            db.execSQL("CREATE TABLE fcm_notifications_new (\n                    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                    notification_title TEXT,\n                    notification_body TEXT,\n                    read_status INTEGER NOT NULL,\n                    notification_date_time TEXT)");
            db.execSQL("INSERT INTO fcm_notifications_new (id, notification_title, notification_body, read_status, notification_date_time) \n                        SELECT id, notification_title, notification_body, COALESCE(read_status, 0), notification_date_time \n                        FROM fcm_notifications");
            db.execSQL("DROP TABLE fcm_notifications");
            db.execSQL("ALTER TABLE fcm_notifications_new RENAME TO fcm_notifications");
            db.execSQL("CREATE TABLE pre_defined_sentences_cat_new (\n                        definition_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                        category TEXT NOT NULL)");
            db.execSQL("INSERT INTO pre_defined_sentences_cat_new (definition_id, category)\n                        SELECT definition_id, category FROM pre_defined_sentences_cat");
            db.execSQL("DROP TABLE pre_defined_sentences_cat");
            db.execSQL("ALTER TABLE pre_defined_sentences_cat_new RENAME TO pre_defined_sentences_cat");
            db.execSQL("CREATE TABLE pre_defined_sentences_sent_new (\n                    definition_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                    sentence TEXT NOT NULL,\n                    category_id INTEGER NOT NULL,\n                    FOREIGN KEY(category_id) REFERENCES pre_defined_sentences_cat(definition_id) ON DELETE CASCADE\n                    )");
            db.execSQL("INSERT INTO pre_defined_sentences_sent_new (definition_id, sentence, category_id) \n                        SELECT definition_id, sentence, category_id FROM pre_defined_sentences_sent");
            db.execSQL("DROP TABLE pre_defined_sentences_sent");
            db.execSQL("ALTER TABLE pre_defined_sentences_sent_new RENAME TO pre_defined_sentences_sent");
            db.execSQL("CREATE INDEX IF NOT EXISTS index_pre_defined_sentences_sent_category_id ON pre_defined_sentences_sent(category_id)");
        }
    };
    private static final Migration MIGRATION_5_6 = new Migration() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase$Companion$MIGRATION_5_6$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE IF NOT EXISTS sign_practice (\n                    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                    practice_name TEXT NOT NULL,\n                    domain TEXT NOT NULL,\n                    topic TEXT NOT NULL,\n                    content TEXT NOT NULL,\n                    complexity TEXT NOT NULL,\n                    uri TEXT NOT NULL,\n                    language TEXT NOT NULL,\n                    type TEXT NOT NULL,\n                    time_created INTEGER NOT NULL,\n                    opens INTEGER NOT NULL\n                    )");
        }
    };
    private static final Migration MIGRATION_6_7 = new Migration() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase$Companion$MIGRATION_6_7$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("\n                    CREATE TABLE fcm_notifications_new (\n                    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                    notification_title TEXT NOT NULL DEFAULT 'Untitled',\n                    notification_body TEXT,\n                    data TEXT,\n                    read_status INTEGER NOT NULL DEFAULT 0,\n                    notification_date_time INTEGER NOT NULL DEFAULT 0\n                    )");
            db.execSQL("\n                    INSERT INTO fcm_notifications_new (id, notification_title, notification_body, read_status, notification_date_time)\n                    SELECT\n                    id,\n                    COALESCE(notification_title, 'Untitled'),\n                    notification_body,\n                    read_status,\n                    CAST(COALESCE(notification_date_time, '0') AS INTEGER)\n                    FROM fcm_notifications\n                    ");
            db.execSQL("DROP TABLE fcm_notifications");
            db.execSQL("ALTER TABLE fcm_notifications_new RENAME TO fcm_notifications");
        }
    };
    private static final Migration MIGRATION_7_8 = new Migration() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase$Companion$MIGRATION_7_8$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE IF NOT EXISTS conversations (\nid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\nconversation_name TEXT NOT NULL,\ntime_created INTEGER NOT NULL\n)");
        }
    };
    private static final Migration MIGRATION_8_9 = new Migration() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase$Companion$MIGRATION_8_9$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE IF NOT EXISTS `conversation_messages` (\n`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n`conversation_id_fk` INTEGER NOT NULL,\n`user_name` TEXT NOT NULL,\n`message` TEXT NOT NULL,\n`english_message` TEXT NOT NULL,\n`sign_gloss` TEXT,\n`sequence_id` INTEGER NOT NULL DEFAULT 0,\n`message_language` TEXT NOT NULL,\n`message_input_type` TEXT NOT NULL DEFAULT 'TYPED',\n`message_type` TEXT NOT NULL DEFAULT 'INTERPRETATION',\n`is_processed` INTEGER NOT NULL DEFAULT 0,\n`time_created` INTEGER NOT NULL,\nFOREIGN KEY(`conversation_id_fk`) REFERENCES `conversations`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE\n)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_conversation_messages_conversation_id_fk_sequence_id`\nON `conversation_messages` (`conversation_id_fk`, `sequence_id`)");
        }
    };
    private static final Migration MIGRATION_9_10 = new Migration() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase$Companion$MIGRATION_9_10$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("\n                    CREATE TABLE IF NOT EXISTS `conversation_input_suggestion_categories` (\n                    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n                    `category_name` TEXT NOT NULL\n                    )\n                    ");
            db.execSQL("\n                    INSERT INTO conversation_input_suggestion_categories (id, category_name)\n                    SELECT definition_id, category \n                    FROM pre_defined_sentences_cat\n                    ");
            db.execSQL("\n                    CREATE TABLE IF NOT EXISTS `conversation_input_suggestion_sentences` (\n                    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n                    `suggestion_text` TEXT NOT NULL, \n                    `category_id_fk` INTEGER NOT NULL, \n                    `language_code` TEXT NOT NULL DEFAULT 'ENGLISH',\n                    FOREIGN KEY(`category_id_fk`) REFERENCES `conversation_input_suggestion_categories`(`id`) ON DELETE CASCADE\n                    )\n                    ");
            db.execSQL("CREATE INDEX IF NOT EXISTS `index_conversation_input_suggestion_sentences_category_id_fk` ON `conversation_input_suggestion_sentences` (`category_id_fk`)");
            db.execSQL("\n                    INSERT INTO conversation_input_suggestion_sentences (id, suggestion_text, category_id_fk, language_code)\n                    SELECT definition_id, sentence, category_id, 'ENGLISH'\n                    FROM pre_defined_sentences_sent\n                    ");
            db.execSQL("DROP TABLE pre_defined_sentences_sent");
            db.execSQL("DROP TABLE pre_defined_sentences_cat");
        }
    };
    private static final Migration MIGRATION_10_11 = new Migration() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase$Companion$MIGRATION_10_11$1
        private static final double migrate$dynamicThreshold(int i) {
            if (i <= 5) {
                return 1.0d;
            }
            if (i <= 10) {
                return 0.95d;
            }
            if (i <= 25) {
                return 0.9d;
            }
            return i <= 50 ? 0.85d : 0.8d;
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [java.time.ZonedDateTime] */
        private static final Long migrate$parseTimestampStrict(String str) {
            String str2 = str;
            if (str2 != null && !StringsKt.isBlank(str2)) {
                try {
                    return Long.valueOf(LocalDateTime.parse(str).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
                } catch (Exception unused) {
                }
            }
            return null;
        }

        private static final String migrate$detectLanguageForMigration(String str) {
            Object obj;
            try {
                Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("ENGLISH", "A-Za-z"), TuplesKt.to("TAMIL", "\\u0B80-\\u0BFF"), TuplesKt.to("HINDI", "\\u0900-\\u097F"), TuplesKt.to("MARATHI", "\\u0900-\\u097F"), TuplesKt.to("TELUGU", "\\u0C00-\\u0C7F"), TuplesKt.to("KANNADA", "\\u0C80-\\u0CFF"), TuplesKt.to("MALAYALAM", "\\u0D00-\\u0D7F"), TuplesKt.to("GUJARATI", "\\u0A80-\\u0AFF"), TuplesKt.to("PUNJABI", "\\u0A00-\\u0A7F")});
                Regex regex = new Regex("[\\p{P}\\p{S}]");
                String str2 = str;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < str2.length(); i++) {
                    char cCharAt = str2.charAt(i);
                    if (!CharsKt.isWhitespace(cCharAt) && !regex.matches(String.valueOf(cCharAt))) {
                        sb.append(cCharAt);
                    }
                }
                String string = sb.toString();
                if (string.length() == 0) {
                    return "ENGLISH";
                }
                int length = string.length();
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapMapOf.size()));
                for (Object obj2 : mapMapOf.entrySet()) {
                    Object key = ((Map.Entry) obj2).getKey();
                    Regex regex2 = new Regex("[" + ((String) ((Map.Entry) obj2).getValue()) + "\\p{N}]");
                    String str3 = string;
                    int i2 = 0;
                    for (int i3 = 0; i3 < str3.length(); i3++) {
                        if (regex2.matches(String.valueOf(str3.charAt(i3)))) {
                            i2++;
                        }
                    }
                    linkedHashMap.put(key, Double.valueOf(((double) i2) / ((double) length)));
                }
                Iterator it = linkedHashMap.entrySet().iterator();
                if (it.hasNext()) {
                    Object next = it.next();
                    if (it.hasNext()) {
                        double dDoubleValue = ((Number) ((Map.Entry) next).getValue()).doubleValue();
                        do {
                            Object next2 = it.next();
                            double dDoubleValue2 = ((Number) ((Map.Entry) next2).getValue()).doubleValue();
                            if (Double.compare(dDoubleValue, dDoubleValue2) < 0) {
                                next = next2;
                                dDoubleValue = dDoubleValue2;
                            }
                        } while (it.hasNext());
                    }
                    obj = next;
                } else {
                    obj = null;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (entry != null && ((Number) entry.getValue()).doubleValue() >= migrate$dynamicThreshold(str.length())) {
                    return (String) entry.getKey();
                }
            } catch (Exception unused) {
            }
            return "ENGLISH";
        }

        /* JADX WARN: Code duplicated, block: B:101:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:137:0x00a0 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:143:0x008e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:40:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:83:0x01aa  */
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) throws Throwable {
            Cursor cursorQuery;
            Cursor cursorQuery2;
            int i;
            int i2;
            Long l;
            String string;
            String string2;
            String string3;
            String str;
            String str2;
            String str3;
            Pair pair;
            String str4;
            Long lMigrate$parseTimestampStrict;
            Intrinsics.checkNotNullParameter(db, "db");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i3 = 2;
            int i4 = 0;
            int i5 = 5;
            int i6 = 1;
            Cursor cursor = null;
            try {
                cursorQuery = db.query("SELECT id, session_name, summary_date_time FROM sessions");
                while (cursorQuery.moveToNext()) {
                    try {
                        try {
                            try {
                                String string4 = cursorQuery.getString(0);
                                String string5 = cursorQuery.getString(1);
                                String string6 = cursorQuery.getString(2);
                                String str5 = string4;
                                if (str5 != null && !StringsKt.isBlank(str5) && (str4 = string5) != null && !StringsKt.isBlank(str4) && (lMigrate$parseTimestampStrict = migrate$parseTimestampStrict(string6)) != null) {
                                    long jLongValue = lMigrate$parseTimestampStrict.longValue();
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("conversation_name", string5);
                                    contentValues.put("time_created", Long.valueOf(jLongValue));
                                    long jInsert = db.insert("conversations", 5, contentValues);
                                    if (jInsert != -1) {
                                        linkedHashMap.put(string4, Long.valueOf(jInsert));
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Exception unused2) {
                        if (cursorQuery != null) {
                        }
                        cursorQuery2 = db.query("SELECT \nsession_id_fk, user_name, message_text, message_text_trans, \nsequence_id, type_mode, message_timestamp \nFROM messages");
                        while (cursorQuery2.moveToNext()) {
                            try {
                                try {
                                    try {
                                        l = (Long) linkedHashMap.get(cursorQuery2.getString(i4));
                                        if (l != null) {
                                            long jLongValue2 = l.longValue();
                                            string = cursorQuery2.getString(i6);
                                            if (string == null) {
                                                string = "User";
                                            }
                                            string2 = cursorQuery2.getString(i3);
                                            string3 = cursorQuery2.getString(3);
                                            int i7 = cursorQuery2.getInt(4);
                                            String string7 = cursorQuery2.getString(i5);
                                            String string8 = cursorQuery2.getString(6);
                                            str = string3;
                                            string3 = str != null ? string2 : string2;
                                            str3 = string3;
                                            if (str3 != null) {
                                            }
                                            i = i5;
                                            i2 = i6;
                                            i5 = i;
                                            i6 = i2;
                                            i3 = 2;
                                            i4 = 0;
                                        }
                                    } catch (Exception unused3) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    cursor = cursorQuery2;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    throw th;
                                }
                            } catch (Exception unused4) {
                                cursor = cursorQuery2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                        if (cursorQuery2 != null) {
                            cursorQuery2.close();
                        }
                        db.execSQL("DROP TABLE IF EXISTS messages");
                        db.execSQL("DROP TABLE IF EXISTS sessions");
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception unused5) {
                cursorQuery = null;
            } catch (Throwable th3) {
                th = th3;
            }
            try {
                cursorQuery2 = db.query("SELECT \nsession_id_fk, user_name, message_text, message_text_trans, \nsequence_id, type_mode, message_timestamp \nFROM messages");
                while (cursorQuery2.moveToNext()) {
                    l = (Long) linkedHashMap.get(cursorQuery2.getString(i4));
                    if (l != null) {
                        long jLongValue3 = l.longValue();
                        string = cursorQuery2.getString(i6);
                        if (string == null) {
                            string = "User";
                        }
                        string2 = cursorQuery2.getString(i3);
                        string3 = cursorQuery2.getString(3);
                        int i8 = cursorQuery2.getInt(4);
                        String string9 = cursorQuery2.getString(i5);
                        String string10 = cursorQuery2.getString(6);
                        str = string3;
                        if ((str != null || StringsKt.isBlank(str)) && (str2 = string2) != null && !StringsKt.isBlank(str2)) {
                        }
                        str3 = string3;
                        if (str3 != null || StringsKt.isBlank(str3)) {
                            i = i5;
                            i2 = i6;
                        } else {
                            Long lMigrate$parseTimestampStrict2 = migrate$parseTimestampStrict(string10);
                            if (lMigrate$parseTimestampStrict2 != null) {
                                long jLongValue4 = lMigrate$parseTimestampStrict2.longValue();
                                String strMigrate$detectLanguageForMigration = migrate$detectLanguageForMigration(string3);
                                String str6 = string2;
                                if (str6 == null || StringsKt.isBlank(str6)) {
                                    string2 = Intrinsics.areEqual(strMigrate$detectLanguageForMigration, "ENGLISH") ? string3 : "";
                                }
                                i2 = i6;
                                if (Intrinsics.areEqual(string9, "Transcribed")) {
                                    try {
                                        pair = new Pair("INTERPRETATION", "SPOKEN");
                                    } catch (Exception unused6) {
                                        i = 5;
                                    }
                                } else {
                                    pair = Intrinsics.areEqual(string9, "Read Out") ? new Pair("TEXT_TO_SPEECH", "TYPED") : new Pair("INTERPRETATION", "SPOKEN");
                                }
                                String str7 = (String) pair.component1();
                                String str8 = (String) pair.component2();
                                ContentValues contentValues2 = new ContentValues();
                                contentValues2.put("conversation_id_fk", Long.valueOf(jLongValue3));
                                contentValues2.put("user_name", string);
                                contentValues2.put(ResponseKeys.KEY_MESSAGE, string3);
                                contentValues2.put("english_message", string2);
                                contentValues2.put("sign_gloss", (String) null);
                                contentValues2.put("sequence_id", Integer.valueOf(i8));
                                contentValues2.put("message_language", strMigrate$detectLanguageForMigration);
                                contentValues2.put("message_input_type", str8);
                                contentValues2.put(Constants.MessagePayloadKeys.MESSAGE_TYPE, str7);
                                contentValues2.put("is_processed", Integer.valueOf(i2));
                                contentValues2.put("time_created", Long.valueOf(jLongValue4));
                                i = 5;
                                try {
                                    db.insert("conversation_messages", 5, contentValues2);
                                } catch (Exception unused7) {
                                }
                            } else {
                                i3 = 2;
                            }
                        }
                        i5 = i;
                        i6 = i2;
                        i3 = 2;
                        i4 = 0;
                    }
                }
                if (cursorQuery2 != null) {
                    cursorQuery2.close();
                }
            } catch (Exception unused8) {
            } catch (Throwable th4) {
                th = th4;
            }
            try {
                db.execSQL("DROP TABLE IF EXISTS messages");
                db.execSQL("DROP TABLE IF EXISTS sessions");
            } catch (Exception unused9) {
            }
        }
    };
    private static final Migration MIGRATION_11_12 = new Migration() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase$Companion$MIGRATION_11_12$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("\n                    CREATE TABLE fcm_notifications_new (\n                        `id` TEXT NOT NULL PRIMARY KEY,\n                        `notification_title` TEXT NOT NULL DEFAULT 'Untitled',\n                        `notification_body` TEXT,\n                        `data` TEXT,\n                        `read_status` INTEGER NOT NULL DEFAULT 0,\n                        `notification_date_time` INTEGER NOT NULL DEFAULT 0\n                    )\n                ");
            db.execSQL("DROP TABLE fcm_notifications");
            db.execSQL("ALTER TABLE fcm_notifications_new RENAME TO fcm_notifications");
        }
    };
    private static final Migration MIGRATION_12_13 = new Migration() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase$Companion$MIGRATION_12_13$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }
    };
    private static final Migration MIGRATION_13_14 = new Migration() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase$Companion$MIGRATION_13_14$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE IF NOT EXISTS `conversation_messages_new` (\n`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n`conversation_id_fk` INTEGER NOT NULL,\n`user_name` TEXT NOT NULL,\n`message` TEXT NOT NULL,\n`processed_message` TEXT NOT NULL,\n`processed_message_language` TEXT NOT NULL,\n`sign_gloss` TEXT,\n`sequence_id` INTEGER NOT NULL DEFAULT 0,\n`message_language` TEXT NOT NULL,\n`message_input_type` TEXT NOT NULL DEFAULT 'TYPED',\n`message_type` TEXT NOT NULL DEFAULT 'INTERPRETATION',\n`is_processed` INTEGER NOT NULL DEFAULT 0,\n`time_created` INTEGER NOT NULL,\nFOREIGN KEY(`conversation_id_fk`) REFERENCES `conversations`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE\n)");
            db.execSQL("INSERT INTO conversation_messages_new (\nid, conversation_id_fk, user_name, message, \nprocessed_message, processed_message_language, \nsign_gloss, sequence_id, message_language, \nmessage_input_type, message_type, is_processed, time_created\n)\nSELECT \nid, conversation_id_fk, user_name, message, \nenglish_message, 'ENGLISH', \nsign_gloss, sequence_id, message_language, \nmessage_input_type, message_type, is_processed, time_created\nFROM conversation_messages");
            db.execSQL("DROP TABLE conversation_messages");
            db.execSQL("ALTER TABLE conversation_messages_new RENAME TO conversation_messages");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_conversation_messages_conversation_id_fk_sequence_id`\nON `conversation_messages` (`conversation_id_fk`, `sequence_id`)");
        }
    };
    private static final Migration MIGRATION_14_15 = new Migration() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase$Companion$MIGRATION_14_15$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("UPDATE sign_practice SET language = UPPER(language)");
        }
    };
    private static final Migration MIGRATION_15_16 = new Migration() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase$Companion$MIGRATION_15_16$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE IF NOT EXISTS `environment_sound_history` (\n    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    `label` TEXT NOT NULL,\n    `confidence` REAL NOT NULL,\n    `timestamp` INTEGER NOT NULL\n)");
        }
    };

    public abstract ConversationDao conversationDao();

    public abstract ConversationInputSuggestionDao conversationInputSuggestionDao();

    public abstract ConversationMessageDao conversationMessageDao();

    public abstract EnvironmentSoundHistoryDao environmentSoundHistoryDao();

    public abstract NotificationDao notificationDao();

    public abstract SignPracticeDao signPracticeDao();

    /* JADX INFO: compiled from: AppDatabase.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u001a\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u001c\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u001e\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010 \u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013R\u0011\u0010\"\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0013R\u0011\u0010$\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0013R\u0011\u0010&\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0013R\u0011\u0010(\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0013R\u0011\u0010*\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0013R\u0011\u0010,\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0013R\u0011\u0010.\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0013¨\u00060"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/local/LtsRoomDatabase$Companion;", "", "<init>", "()V", "DATABASE_NAME", "", "INSTANCE", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/local/LtsRoomDatabase;", "getInstance", "context", "Landroid/content/Context;", "buildDatabaseWithRecovery", "runLegacyCatchUpMigration", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getMIGRATION_1_2", "()Landroidx/room/migration/Migration;", "MIGRATION_2_3", "getMIGRATION_2_3", "MIGRATION_3_4", "getMIGRATION_3_4", "MIGRATION_4_5", "getMIGRATION_4_5", "MIGRATION_5_6", "getMIGRATION_5_6", "MIGRATION_6_7", "getMIGRATION_6_7", "MIGRATION_7_8", "getMIGRATION_7_8", "MIGRATION_8_9", "getMIGRATION_8_9", "MIGRATION_9_10", "getMIGRATION_9_10", "MIGRATION_10_11", "getMIGRATION_10_11", "MIGRATION_11_12", "getMIGRATION_11_12", "MIGRATION_12_13", "getMIGRATION_12_13", "MIGRATION_13_14", "getMIGRATION_13_14", "MIGRATION_14_15", "getMIGRATION_14_15", "MIGRATION_15_16", "getMIGRATION_15_16", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LtsRoomDatabase getInstance(Context context) {
            LtsRoomDatabase ltsRoomDatabaseBuildDatabaseWithRecovery;
            Intrinsics.checkNotNullParameter(context, "context");
            LtsRoomDatabase ltsRoomDatabase = LtsRoomDatabase.INSTANCE;
            if (ltsRoomDatabase != null) {
                return ltsRoomDatabase;
            }
            synchronized (this) {
                ltsRoomDatabaseBuildDatabaseWithRecovery = LtsRoomDatabase.INSTANCE.buildDatabaseWithRecovery(context);
                Companion companion = LtsRoomDatabase.INSTANCE;
                LtsRoomDatabase.INSTANCE = ltsRoomDatabaseBuildDatabaseWithRecovery;
            }
            return ltsRoomDatabaseBuildDatabaseWithRecovery;
        }

        private final LtsRoomDatabase buildDatabaseWithRecovery(Context context) {
            try {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                return (LtsRoomDatabase) Room.databaseBuilder(applicationContext, LtsRoomDatabase.class, LtsRoomDatabase.DATABASE_NAME).addMigrations(getMIGRATION_1_2(), getMIGRATION_2_3(), getMIGRATION_3_4(), getMIGRATION_4_5(), getMIGRATION_5_6(), getMIGRATION_6_7(), getMIGRATION_7_8(), getMIGRATION_8_9(), getMIGRATION_9_10(), getMIGRATION_10_11(), getMIGRATION_11_12(), getMIGRATION_12_13(), getMIGRATION_13_14(), getMIGRATION_14_15(), getMIGRATION_15_16()).build();
            } catch (Exception e) {
                Exception exc = e;
                FirebaseCrashlyticsKt.getCrashlytics(Firebase.INSTANCE).recordException(exc);
                throw new IllegalStateException("FATAL ERROR: Failed to build or migrate the database. Crashing to prevent data loss.", exc);
            }
        }

        private static final boolean runLegacyCatchUpMigration$columnExists(SupportSQLiteDatabase supportSQLiteDatabase, String str, String str2) {
            boolean z;
            Cursor cursorQuery = supportSQLiteDatabase.query("PRAGMA table_info(" + str + ")");
            while (cursorQuery.moveToNext()) {
                int columnIndex = cursorQuery.getColumnIndex("name");
                if (columnIndex >= 0) {
                    z = true;
                    if (StringsKt.equals(cursorQuery.getString(columnIndex), str2, true)) {
                        cursorQuery.close();
                        return z;
                    }
                }
            }
            z = false;
            cursorQuery.close();
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void runLegacyCatchUpMigration(SupportSQLiteDatabase db) {
            if (!runLegacyCatchUpMigration$columnExists(db, "messages", "type_mode")) {
                db.execSQL("ALTER TABLE messages ADD COLUMN type_mode TEXT");
            }
            if (!runLegacyCatchUpMigration$columnExists(db, "messages", "sequence_id")) {
                db.execSQL("ALTER TABLE messages ADD COLUMN sequence_id INTEGER NOT NULL DEFAULT 0");
            }
            if (!runLegacyCatchUpMigration$columnExists(db, "messages", "is_interpreted")) {
                db.execSQL("ALTER TABLE messages ADD COLUMN is_interpreted INTEGER NOT NULL DEFAULT 1");
            }
            db.execSQL("\n                CREATE TABLE IF NOT EXISTS pre_defined_sentences_cat (\n                definition_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n                category TEXT NOT NULL\n                )");
            db.execSQL("\n                CREATE TABLE IF NOT EXISTS pre_defined_sentences_sent (\n                definition_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n                sentence TEXT NOT NULL, \n                category_id INTEGER NOT NULL, \n                FOREIGN KEY (category_id) REFERENCES pre_defined_sentences_cat(definition_id) ON DELETE CASCADE\n                )");
            db.execSQL("\n                CREATE TABLE IF NOT EXISTS fcm_notifications (\n                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n                notification_title TEXT, \n                notification_body TEXT, \n                read_status INTEGER, \n                notification_date_time TEXT)");
        }

        public final Migration getMIGRATION_1_2() {
            return LtsRoomDatabase.MIGRATION_1_2;
        }

        public final Migration getMIGRATION_2_3() {
            return LtsRoomDatabase.MIGRATION_2_3;
        }

        public final Migration getMIGRATION_3_4() {
            return LtsRoomDatabase.MIGRATION_3_4;
        }

        public final Migration getMIGRATION_4_5() {
            return LtsRoomDatabase.MIGRATION_4_5;
        }

        public final Migration getMIGRATION_5_6() {
            return LtsRoomDatabase.MIGRATION_5_6;
        }

        public final Migration getMIGRATION_6_7() {
            return LtsRoomDatabase.MIGRATION_6_7;
        }

        public final Migration getMIGRATION_7_8() {
            return LtsRoomDatabase.MIGRATION_7_8;
        }

        public final Migration getMIGRATION_8_9() {
            return LtsRoomDatabase.MIGRATION_8_9;
        }

        public final Migration getMIGRATION_9_10() {
            return LtsRoomDatabase.MIGRATION_9_10;
        }

        public final Migration getMIGRATION_10_11() {
            return LtsRoomDatabase.MIGRATION_10_11;
        }

        public final Migration getMIGRATION_11_12() {
            return LtsRoomDatabase.MIGRATION_11_12;
        }

        public final Migration getMIGRATION_12_13() {
            return LtsRoomDatabase.MIGRATION_12_13;
        }

        public final Migration getMIGRATION_13_14() {
            return LtsRoomDatabase.MIGRATION_13_14;
        }

        public final Migration getMIGRATION_14_15() {
            return LtsRoomDatabase.MIGRATION_14_15;
        }

        public final Migration getMIGRATION_15_16() {
            return LtsRoomDatabase.MIGRATION_15_16;
        }
    }
}
