package androidx.room.util;

import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StatementUtil.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a+\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"getColumnIndexOrThrow", "", "stmt", "Landroidx/sqlite/SQLiteStatement;", "name", "", "columnIndexOfCommon", "getColumnIndex", "wrapMappedColumns", "statement", "columnNames", "", "mapping", "", "(Landroidx/sqlite/SQLiteStatement;[Ljava/lang/String;[I)Landroidx/sqlite/SQLiteStatement;", "room-runtime_release"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/room/util/SQLiteStatementUtil")
final /* synthetic */ class SQLiteStatementUtil__StatementUtilKt {
    public static final int getColumnIndexOrThrow(SQLiteStatement sQLiteStatement, String str) {
        Intrinsics.checkNotNullParameter(sQLiteStatement, "stmt");
        Intrinsics.checkNotNullParameter(str, "name");
        int iColumnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, str);
        if (iColumnIndexOf >= 0) {
            return iColumnIndexOf;
        }
        int columnCount = sQLiteStatement.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i = 0; i < columnCount; i++) {
            arrayList.add(sQLiteStatement.getColumnName(i));
        }
        throw new IllegalArgumentException("Column '" + str + "' does not exist. Available columns: [" + CollectionsKt.joinToString$default(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ']');
    }

    public static final int columnIndexOfCommon(SQLiteStatement sQLiteStatement, String str) {
        Intrinsics.checkNotNullParameter(sQLiteStatement, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (sQLiteStatement instanceof MappedColumnsSQLiteStatementWrapper) {
            return ((MappedColumnsSQLiteStatementWrapper) sQLiteStatement).getColumnIndex(str);
        }
        int columnCount = sQLiteStatement.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            if (Intrinsics.areEqual(str, sQLiteStatement.getColumnName(i))) {
                return i;
            }
        }
        return -1;
    }

    public static final int getColumnIndex(SQLiteStatement sQLiteStatement, String str) {
        Intrinsics.checkNotNullParameter(sQLiteStatement, "stmt");
        Intrinsics.checkNotNullParameter(str, "name");
        return SQLiteStatementUtil.columnIndexOf(sQLiteStatement, str);
    }

    public static final SQLiteStatement wrapMappedColumns(SQLiteStatement sQLiteStatement, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(sQLiteStatement, "statement");
        Intrinsics.checkNotNullParameter(strArr, "columnNames");
        Intrinsics.checkNotNullParameter(iArr, "mapping");
        return new MappedColumnsSQLiteStatementWrapper(sQLiteStatement, strArr, iArr);
    }
}
