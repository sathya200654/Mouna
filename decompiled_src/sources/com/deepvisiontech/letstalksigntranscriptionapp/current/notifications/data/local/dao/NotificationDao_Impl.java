package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.entity.NotificationEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.typeconverters.NotificationTypeConverters;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.List;
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

/* JADX INFO: compiled from: NotificationDao_Impl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u0017H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0016\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/dao/NotificationDao_Impl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/dao/NotificationDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfNotificationEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/entity/NotificationEntity;", "__notificationTypeConverters", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/typeconverters/NotificationTypeConverters;", "__deleteAdapterOfNotificationEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfNotificationEntity", "insertNotification", "", "notificationEntity", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/entity/NotificationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNotification", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotification", "getAllNotifications", "Lkotlinx/coroutines/flow/Flow;", "getNotificationFlow", "id", "", "getNotification", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotificationDao_Impl implements NotificationDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<NotificationEntity> __deleteAdapterOfNotificationEntity;
    private final EntityInsertAdapter<NotificationEntity> __insertAdapterOfNotificationEntity;
    private final NotificationTypeConverters __notificationTypeConverters;
    private final EntityDeleteOrUpdateAdapter<NotificationEntity> __updateAdapterOfNotificationEntity;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public NotificationDao_Impl(RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter(roomDatabase, "__db");
        this.__notificationTypeConverters = new NotificationTypeConverters();
        this.__db = roomDatabase;
        this.__insertAdapterOfNotificationEntity = new EntityInsertAdapter<NotificationEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `fcm_notifications` (`id`,`notification_title`,`notification_body`,`data`,`read_status`,`notification_date_time`) VALUES (?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, NotificationEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo23bindText(1, entity.getId());
                statement.mo23bindText(2, entity.getTitle());
                String body = entity.getBody();
                if (body == null) {
                    statement.mo22bindNull(3);
                } else {
                    statement.mo23bindText(3, body);
                }
                String strFromNotificationDataListToJson = NotificationDao_Impl.this.__notificationTypeConverters.fromNotificationDataListToJson(entity.getData());
                if (strFromNotificationDataListToJson == null) {
                    statement.mo22bindNull(4);
                } else {
                    statement.mo23bindText(4, strFromNotificationDataListToJson);
                }
                statement.mo21bindLong(5, entity.isRead() ? 1L : 0L);
                statement.mo21bindLong(6, entity.getDateTime());
            }
        };
        this.__deleteAdapterOfNotificationEntity = new EntityDeleteOrUpdateAdapter<NotificationEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `fcm_notifications` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, NotificationEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo23bindText(1, entity.getId());
            }
        };
        this.__updateAdapterOfNotificationEntity = new EntityDeleteOrUpdateAdapter<NotificationEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `fcm_notifications` SET `id` = ?,`notification_title` = ?,`notification_body` = ?,`data` = ?,`read_status` = ?,`notification_date_time` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, NotificationEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo23bindText(1, entity.getId());
                statement.mo23bindText(2, entity.getTitle());
                String body = entity.getBody();
                if (body == null) {
                    statement.mo22bindNull(3);
                } else {
                    statement.mo23bindText(3, body);
                }
                String strFromNotificationDataListToJson = NotificationDao_Impl.this.__notificationTypeConverters.fromNotificationDataListToJson(entity.getData());
                if (strFromNotificationDataListToJson == null) {
                    statement.mo22bindNull(4);
                } else {
                    statement.mo23bindText(4, strFromNotificationDataListToJson);
                }
                statement.mo21bindLong(5, entity.isRead() ? 1L : 0L);
                statement.mo21bindLong(6, entity.getDateTime());
                statement.mo23bindText(7, entity.getId());
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao
    public Object insertNotification(final NotificationEntity notificationEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return NotificationDao_Impl.insertNotification$lambda$0(this.f$0, notificationEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertNotification$lambda$0(NotificationDao_Impl notificationDao_Impl, NotificationEntity notificationEntity, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        notificationDao_Impl.__insertAdapterOfNotificationEntity.insert(sQLiteConnection, notificationEntity);
        return Unit.INSTANCE;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao
    public Object deleteNotification(final List<NotificationEntity> list, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return NotificationDao_Impl.deleteNotification$lambda$1(this.f$0, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteNotification$lambda$1(NotificationDao_Impl notificationDao_Impl, List list, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        notificationDao_Impl.__deleteAdapterOfNotificationEntity.handleMultiple(sQLiteConnection, list);
        return Unit.INSTANCE;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao
    public Object updateNotification(final NotificationEntity notificationEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao_Impl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return NotificationDao_Impl.updateNotification$lambda$2(this.f$0, notificationEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateNotification$lambda$2(NotificationDao_Impl notificationDao_Impl, NotificationEntity notificationEntity, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        notificationDao_Impl.__updateAdapterOfNotificationEntity.handle(sQLiteConnection, notificationEntity);
        return Unit.INSTANCE;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao
    public Flow<List<NotificationEntity>> getAllNotifications() {
        final String str = "SELECT * FROM fcm_notifications ORDER BY notification_date_time DESC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"fcm_notifications"}, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return NotificationDao_Impl.getAllNotifications$lambda$3(str, this, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllNotifications$lambda$3(String str, NotificationDao_Impl notificationDao_Impl, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "notification_title");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "notification_body");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "read_status");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "notification_date_time");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new NotificationEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3), notificationDao_Impl.__notificationTypeConverters.fromJsonToNotificationDataList(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4)), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0, sQLiteStatementPrepare.getLong(columnIndexOrThrow6)));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao
    public Flow<NotificationEntity> getNotificationFlow(final String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        final String str = "SELECT * FROM fcm_notifications WHERE id = ?";
        return FlowUtil.createFlow(this.__db, false, new String[]{"fcm_notifications"}, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return NotificationDao_Impl.getNotificationFlow$lambda$4(str, id, this, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationEntity getNotificationFlow$lambda$4(String str, String str2, NotificationDao_Impl notificationDao_Impl, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        boolean z = true;
        try {
            sQLiteStatementPrepare.mo23bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "notification_title");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "notification_body");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "read_status");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "notification_date_time");
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                List<NotificationData> listFromJsonToNotificationDataList = notificationDao_Impl.__notificationTypeConverters.fromJsonToNotificationDataList(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4));
                if (((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) == 0) {
                    z = false;
                }
                NotificationEntity notificationEntity = new NotificationEntity(text, text2, text3, listFromJsonToNotificationDataList, z, sQLiteStatementPrepare.getLong(columnIndexOrThrow6));
                sQLiteStatementPrepare.close();
                return notificationEntity;
            }
            throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type <com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.`data`.local.entity.NotificationEntity>.".toString());
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao
    public Object getNotification(final String str, Continuation<? super NotificationEntity> continuation) {
        final String str2 = "SELECT * FROM fcm_notifications WHERE id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao_Impl$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return NotificationDao_Impl.getNotification$lambda$5(str2, str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationEntity getNotification$lambda$5(String str, String str2, NotificationDao_Impl notificationDao_Impl, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        boolean z = true;
        try {
            sQLiteStatementPrepare.mo23bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "notification_title");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "notification_body");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "read_status");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "notification_date_time");
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                List<NotificationData> listFromJsonToNotificationDataList = notificationDao_Impl.__notificationTypeConverters.fromJsonToNotificationDataList(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4));
                if (((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) == 0) {
                    z = false;
                }
                NotificationEntity notificationEntity = new NotificationEntity(text, text2, text3, listFromJsonToNotificationDataList, z, sQLiteStatementPrepare.getLong(columnIndexOrThrow6));
                sQLiteStatementPrepare.close();
                return notificationEntity;
            }
            throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type <com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.`data`.local.entity.NotificationEntity>.".toString());
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: compiled from: NotificationDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/dao/NotificationDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
