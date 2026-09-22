package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.entities.EnvironmentSoundHistoryEntity;
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

/* JADX INFO: compiled from: EnvironmentSoundHistoryDao_Impl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f0\u000eH\u0016J\u000e\u0010\u0010\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/daos/EnvironmentSoundHistoryDao_Impl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/daos/EnvironmentSoundHistoryDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfEnvironmentSoundHistoryEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/entities/EnvironmentSoundHistoryEntity;", "insert", "", "entity", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/entities/EnvironmentSoundHistoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHistory", "Lkotlinx/coroutines/flow/Flow;", "", "keepOnlyLast1000", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EnvironmentSoundHistoryDao_Impl implements EnvironmentSoundHistoryDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<EnvironmentSoundHistoryEntity> __insertAdapterOfEnvironmentSoundHistoryEntity;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public EnvironmentSoundHistoryDao_Impl(RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter(roomDatabase, "__db");
        this.__db = roomDatabase;
        this.__insertAdapterOfEnvironmentSoundHistoryEntity = new EntityInsertAdapter<EnvironmentSoundHistoryEntity>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `environment_sound_history` (`id`,`label`,`confidence`,`timestamp`) VALUES (nullif(?, 0),?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, EnvironmentSoundHistoryEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo21bindLong(1, entity.getId());
                statement.mo23bindText(2, entity.getLabel());
                statement.mo20bindDouble(3, entity.getConfidence());
                statement.mo21bindLong(4, entity.getTimestamp());
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao
    public Object insert(final EnvironmentSoundHistoryEntity environmentSoundHistoryEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return EnvironmentSoundHistoryDao_Impl.insert$lambda$0(this.f$0, environmentSoundHistoryEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insert$lambda$0(EnvironmentSoundHistoryDao_Impl environmentSoundHistoryDao_Impl, EnvironmentSoundHistoryEntity environmentSoundHistoryEntity, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        environmentSoundHistoryDao_Impl.__insertAdapterOfEnvironmentSoundHistoryEntity.insert(sQLiteConnection, environmentSoundHistoryEntity);
        return Unit.INSTANCE;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao
    public Flow<List<EnvironmentSoundHistoryEntity>> getHistory() {
        final String str = "SELECT * FROM environment_sound_history ORDER BY timestamp DESC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"environment_sound_history"}, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return EnvironmentSoundHistoryDao_Impl.getHistory$lambda$1(str, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getHistory$lambda$1(String str, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Constants.ScionAnalytics.PARAM_LABEL);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "confidence");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "timestamp");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new EnvironmentSoundHistoryEntity(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), (float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow3), sQLiteStatementPrepare.getLong(columnIndexOrThrow4)));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao
    public Object keepOnlyLast1000(Continuation<? super Unit> continuation) {
        final String str = "DELETE FROM environment_sound_history WHERE id NOT IN (SELECT id FROM environment_sound_history ORDER BY timestamp DESC LIMIT 1000)";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return EnvironmentSoundHistoryDao_Impl.keepOnlyLast1000$lambda$2(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit keepOnlyLast1000$lambda$2(String str, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: compiled from: EnvironmentSoundHistoryDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/daos/EnvironmentSoundHistoryDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
