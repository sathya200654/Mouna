package androidx.room;

import androidx.sqlite.SQLiteStatement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoomRawQuery.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/room/RoomRawQuery;", "", "sql", "", "onBindStatement", "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteStatement;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getSql", "()Ljava/lang/String;", "bindingFunction", "getBindingFunction", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RoomRawQuery {
    private final Function1<SQLiteStatement, Unit> bindingFunction;
    private final String sql;

    /* JADX WARN: Illegal instructions before constructor call */
    public RoomRawQuery(String str) {
        Intrinsics.checkNotNullParameter(str, "sql");
        Function1 function1 = null;
        this(str, function1, 2, function1);
    }

    public RoomRawQuery(String str, final Function1<? super SQLiteStatement, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "sql");
        Intrinsics.checkNotNullParameter(function1, "onBindStatement");
        this.sql = str;
        this.bindingFunction = new Function1() { // from class: androidx.room.RoomRawQuery$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return RoomRawQuery.bindingFunction$lambda$1(function1, (SQLiteStatement) obj);
            }
        };
    }

    public final String getSql() {
        return this.sql;
    }

    public /* synthetic */ RoomRawQuery(String str, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new Function1() { // from class: androidx.room.RoomRawQuery$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return RoomRawQuery._init_$lambda$0((SQLiteStatement) obj);
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(SQLiteStatement sQLiteStatement) {
        Intrinsics.checkNotNullParameter(sQLiteStatement, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindingFunction$lambda$1(Function1 function1, SQLiteStatement sQLiteStatement) {
        Intrinsics.checkNotNullParameter(sQLiteStatement, "it");
        function1.invoke(new BindOnlySQLiteStatement(sQLiteStatement));
        return Unit.INSTANCE;
    }

    public final Function1<SQLiteStatement, Unit> getBindingFunction() {
        return this.bindingFunction;
    }
}
