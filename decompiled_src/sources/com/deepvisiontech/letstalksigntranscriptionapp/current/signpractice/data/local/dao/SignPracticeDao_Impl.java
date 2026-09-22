package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.typeconverters.CommonTypeConverters;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.typeconverter.MessageTypeConverters;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.entity.SignPracticeEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.typeconverters.SignPracticeTypeConverters;
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

/* JADX INFO: compiled from: SignPracticeDao_Impl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\u00020\u00172\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0018H\u0096@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00180\u001cH\u0016J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\u0006\u0010\u001e\u001a\u00020\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/dao/SignPracticeDao_Impl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/dao/SignPracticeDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfSignPracticeEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/entity/SignPracticeEntity;", "__signPracticeTypeConverters", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/typeconverters/SignPracticeTypeConverters;", "__commonTypeConverters", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/local/typeconverters/CommonTypeConverters;", "__deleteAdapterOfSignPracticeEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfSignPracticeEntity", "__messageTypeConverters", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/typeconverter/MessageTypeConverters;", "insertPractice", "", "practiceEntity", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/entity/SignPracticeEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePractice", "", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePractice", "getAllPractices", "Lkotlinx/coroutines/flow/Flow;", "getPracticeFlow", "id", "getPractice", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SignPracticeDao_Impl implements SignPracticeDao {
    private final CommonTypeConverters __commonTypeConverters;
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<SignPracticeEntity> __deleteAdapterOfSignPracticeEntity;
    private final EntityInsertAdapter<SignPracticeEntity> __insertAdapterOfSignPracticeEntity;
    private final MessageTypeConverters __messageTypeConverters;
    private final SignPracticeTypeConverters __signPracticeTypeConverters;
    private final EntityDeleteOrUpdateAdapter<SignPracticeEntity> __updateAdapterOfSignPracticeEntity;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public SignPracticeDao_Impl(RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter(roomDatabase, "__db");
        this.__signPracticeTypeConverters = new SignPracticeTypeConverters();
        this.__commonTypeConverters = new CommonTypeConverters();
        this.__messageTypeConverters = new MessageTypeConverters();
        this.__db = roomDatabase;
        this.__insertAdapterOfSignPracticeEntity = new EntityInsertAdapter<SignPracticeEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `sign_practice` (`id`,`practice_name`,`domain`,`content`,`topic`,`complexity`,`language`,`type`,`uri`,`opens`,`time_created`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, SignPracticeEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo21bindLong(1, entity.getId());
                statement.mo23bindText(2, entity.getPracticeName());
                statement.mo23bindText(3, entity.getDomain());
                statement.mo23bindText(4, entity.getContent());
                statement.mo23bindText(5, entity.getTopic());
                statement.mo23bindText(6, SignPracticeDao_Impl.this.__signPracticeTypeConverters.fromSignPracticeComplexity(entity.getComplexity()));
                statement.mo23bindText(7, SignPracticeDao_Impl.this.__commonTypeConverters.fromLanguageEnum(entity.getLanguage()));
                statement.mo23bindText(8, SignPracticeDao_Impl.this.__signPracticeTypeConverters.fromSignPracticeType(entity.getType()));
                statement.mo23bindText(9, entity.getUri());
                statement.mo21bindLong(10, entity.getOpens());
                statement.mo21bindLong(11, entity.getTimeCreated());
            }
        };
        this.__deleteAdapterOfSignPracticeEntity = new EntityDeleteOrUpdateAdapter<SignPracticeEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `sign_practice` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, SignPracticeEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo21bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfSignPracticeEntity = new EntityDeleteOrUpdateAdapter<SignPracticeEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `sign_practice` SET `id` = ?,`practice_name` = ?,`domain` = ?,`content` = ?,`topic` = ?,`complexity` = ?,`language` = ?,`type` = ?,`uri` = ?,`opens` = ?,`time_created` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, SignPracticeEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo21bindLong(1, entity.getId());
                statement.mo23bindText(2, entity.getPracticeName());
                statement.mo23bindText(3, entity.getDomain());
                statement.mo23bindText(4, entity.getContent());
                statement.mo23bindText(5, entity.getTopic());
                statement.mo23bindText(6, SignPracticeDao_Impl.this.__signPracticeTypeConverters.fromSignPracticeComplexity(entity.getComplexity()));
                statement.mo23bindText(7, SignPracticeDao_Impl.this.__commonTypeConverters.fromLanguageEnum(entity.getLanguage()));
                statement.mo23bindText(8, SignPracticeDao_Impl.this.__signPracticeTypeConverters.fromSignPracticeType(entity.getType()));
                statement.mo23bindText(9, entity.getUri());
                statement.mo21bindLong(10, entity.getOpens());
                statement.mo21bindLong(11, entity.getTimeCreated());
                statement.mo21bindLong(12, entity.getId());
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao
    public Object insertPractice(final SignPracticeEntity signPracticeEntity, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return Long.valueOf(SignPracticeDao_Impl.insertPractice$lambda$0(this.f$0, signPracticeEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insertPractice$lambda$0(SignPracticeDao_Impl signPracticeDao_Impl, SignPracticeEntity signPracticeEntity, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        return signPracticeDao_Impl.__insertAdapterOfSignPracticeEntity.insertAndReturnId(sQLiteConnection, signPracticeEntity);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao
    public Object deletePractice(final List<SignPracticeEntity> list, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return SignPracticeDao_Impl.deletePractice$lambda$1(this.f$0, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deletePractice$lambda$1(SignPracticeDao_Impl signPracticeDao_Impl, List list, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        signPracticeDao_Impl.__deleteAdapterOfSignPracticeEntity.handleMultiple(sQLiteConnection, list);
        return Unit.INSTANCE;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao
    public Object updatePractice(final SignPracticeEntity signPracticeEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return SignPracticeDao_Impl.updatePractice$lambda$2(this.f$0, signPracticeEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updatePractice$lambda$2(SignPracticeDao_Impl signPracticeDao_Impl, SignPracticeEntity signPracticeEntity, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        signPracticeDao_Impl.__updateAdapterOfSignPracticeEntity.handle(sQLiteConnection, signPracticeEntity);
        return Unit.INSTANCE;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao
    public Flow<List<SignPracticeEntity>> getAllPractices() {
        final String str = "SELECT * FROM sign_practice ORDER BY time_created DESC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"sign_practice"}, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return SignPracticeDao_Impl.getAllPractices$lambda$3(str, this, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllPractices$lambda$3(String str, SignPracticeDao_Impl signPracticeDao_Impl, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "practice_name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "domain");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "topic");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "complexity");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "language");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uri");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "opens");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "time_created");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = columnIndexOrThrow;
                int i2 = columnIndexOrThrow2;
                arrayList.add(new SignPracticeEntity((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), signPracticeDao_Impl.__signPracticeTypeConverters.toSignPracticeComplexity(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), signPracticeDao_Impl.__messageTypeConverters.toLanguageEnum(sQLiteStatementPrepare.getText(columnIndexOrThrow7)), signPracticeDao_Impl.__signPracticeTypeConverters.toSignPracticeType(sQLiteStatementPrepare.getText(columnIndexOrThrow8)), sQLiteStatementPrepare.getText(columnIndexOrThrow9), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10), sQLiteStatementPrepare.getLong(columnIndexOrThrow11)));
                columnIndexOrThrow = i;
                columnIndexOrThrow2 = i2;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao
    public Flow<SignPracticeEntity> getPracticeFlow(final long id) {
        final String str = "SELECT * FROM sign_practice WHERE id = ?";
        return FlowUtil.createFlow(this.__db, false, new String[]{"sign_practice"}, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao_Impl$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return SignPracticeDao_Impl.getPracticeFlow$lambda$4(str, id, this, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignPracticeEntity getPracticeFlow$lambda$4(String str, long j, SignPracticeDao_Impl signPracticeDao_Impl, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo21bindLong(1, j);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "practice_name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "domain");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "topic");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "complexity");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "language");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uri");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "opens");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "time_created");
            if (sQLiteStatementPrepare.step()) {
                SignPracticeEntity signPracticeEntity = new SignPracticeEntity((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), signPracticeDao_Impl.__signPracticeTypeConverters.toSignPracticeComplexity(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), signPracticeDao_Impl.__messageTypeConverters.toLanguageEnum(sQLiteStatementPrepare.getText(columnIndexOrThrow7)), signPracticeDao_Impl.__signPracticeTypeConverters.toSignPracticeType(sQLiteStatementPrepare.getText(columnIndexOrThrow8)), sQLiteStatementPrepare.getText(columnIndexOrThrow9), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10), sQLiteStatementPrepare.getLong(columnIndexOrThrow11));
                sQLiteStatementPrepare.close();
                return signPracticeEntity;
            }
            throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type <com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.`data`.local.entity.SignPracticeEntity>.".toString());
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao
    public SignPracticeEntity getPractice(final long id) {
        final String str = "SELECT * FROM sign_practice WHERE id = ?";
        return (SignPracticeEntity) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao_Impl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return SignPracticeDao_Impl.getPractice$lambda$5(str, id, this, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignPracticeEntity getPractice$lambda$5(String str, long j, SignPracticeDao_Impl signPracticeDao_Impl, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo21bindLong(1, j);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "practice_name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "domain");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "topic");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "complexity");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "language");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uri");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "opens");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "time_created");
            if (sQLiteStatementPrepare.step()) {
                SignPracticeEntity signPracticeEntity = new SignPracticeEntity((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), signPracticeDao_Impl.__signPracticeTypeConverters.toSignPracticeComplexity(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), signPracticeDao_Impl.__messageTypeConverters.toLanguageEnum(sQLiteStatementPrepare.getText(columnIndexOrThrow7)), signPracticeDao_Impl.__signPracticeTypeConverters.toSignPracticeType(sQLiteStatementPrepare.getText(columnIndexOrThrow8)), sQLiteStatementPrepare.getText(columnIndexOrThrow9), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10), sQLiteStatementPrepare.getLong(columnIndexOrThrow11));
                sQLiteStatementPrepare.close();
                return signPracticeEntity;
            }
            throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type <com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.`data`.local.entity.SignPracticeEntity>.".toString());
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: compiled from: SignPracticeDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/dao/SignPracticeDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
