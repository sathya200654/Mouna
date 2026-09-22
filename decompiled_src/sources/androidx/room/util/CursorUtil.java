package androidx.room.util;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.MatrixCursor;
import android.util.Log;
import com.azure.core.implementation.SemanticVersion;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CursorUtil.android.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a#\u0010\b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\f\u001a/\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u000e0\u0010H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a)\u0010\u0012\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"copyAndClose", "Landroid/database/Cursor;", "c", "getColumnIndex", "", "name", "", "getColumnIndexOrThrow", "findColumnIndexBySuffix", "cursor", "columnNames", "", "([Ljava/lang/String;Ljava/lang/String;)I", "useCursor", "R", "block", "Lkotlin/Function1;", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "wrapMappedColumns", "mapping", "", "(Landroid/database/Cursor;[Ljava/lang/String;[I)Landroid/database/Cursor;", "room-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CursorUtil {
    private static final int findColumnIndexBySuffix(Cursor cursor, String str) {
        return -1;
    }

    public static final int getColumnIndex(Cursor cursor, String str) {
        Intrinsics.checkNotNullParameter(cursor, "c");
        Intrinsics.checkNotNullParameter(str, "name");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex("`" + str + '`');
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(cursor, str);
    }

    public static final int getColumnIndexOrThrow(Cursor cursor, String str) {
        String strJoinToString$default;
        Intrinsics.checkNotNullParameter(cursor, "c");
        Intrinsics.checkNotNullParameter(str, "name");
        int columnIndex = getColumnIndex(cursor, str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            Intrinsics.checkNotNullExpressionValue(columnNames, "getColumnNames(...)");
            strJoinToString$default = ArraysKt.joinToString$default(columnNames, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        } catch (Exception e) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
            strJoinToString$default = SemanticVersion.UNKNOWN_VERSION;
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + strJoinToString$default);
    }

    public static final int findColumnIndexBySuffix(String[] strArr, String str) {
        Intrinsics.checkNotNullParameter(strArr, "columnNames");
        Intrinsics.checkNotNullParameter(str, "name");
        String str2 = "." + str;
        String str3 = "." + str + '`';
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str4 = strArr[i];
            int i3 = i2 + 1;
            if (str4.length() >= str.length() + 2 && (StringsKt.endsWith$default(str4, str2, false, 2, (Object) null) || (str4.charAt(0) == '`' && StringsKt.endsWith$default(str4, str3, false, 2, (Object) null)))) {
                return i2;
            }
            i++;
            i2 = i3;
        }
        return -1;
    }

    public static final <R> R useCursor(Cursor cursor, Function1<? super Cursor, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        Cursor cursor2 = cursor;
        try {
            R r = (R) function1.invoke(cursor2);
            CloseableKt.closeFinally(cursor2, (Throwable) null);
            return r;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursor2, th);
                throw th2;
            }
        }
    }

    public static final Cursor wrapMappedColumns(Cursor cursor, final String[] strArr, final int[] iArr) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(strArr, "columnNames");
        Intrinsics.checkNotNullParameter(iArr, "mapping");
        if (strArr.length != iArr.length) {
            throw new IllegalStateException("Expected columnNames.length == mapping.length".toString());
        }
        return new CursorWrapper(cursor) { // from class: androidx.room.util.CursorUtil.wrapMappedColumns.2
            @Override // android.database.CursorWrapper, android.database.Cursor
            public int getColumnIndex(String columnName) {
                Intrinsics.checkNotNullParameter(columnName, "columnName");
                String[] strArr2 = strArr;
                int[] iArr2 = iArr;
                int length = strArr2.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    int i3 = i2 + 1;
                    if (StringsKt.equals(strArr2[i], columnName, true)) {
                        return iArr2[i2];
                    }
                    i++;
                    i2 = i3;
                }
                return super.getColumnIndex(columnName);
            }
        };
    }

    public static final Cursor copyAndClose(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "c");
        Cursor cursor2 = cursor;
        try {
            Cursor cursor3 = cursor2;
            MatrixCursor matrixCursor = new MatrixCursor(cursor3.getColumnNames(), cursor3.getCount());
            while (cursor3.moveToNext()) {
                Object[] objArr = new Object[cursor3.getColumnCount()];
                int columnCount = cursor.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    int type = cursor3.getType(i);
                    if (type == 0) {
                        objArr[i] = null;
                    } else if (type == 1) {
                        objArr[i] = Long.valueOf(cursor3.getLong(i));
                    } else if (type == 2) {
                        objArr[i] = Double.valueOf(cursor3.getDouble(i));
                    } else if (type == 3) {
                        objArr[i] = cursor3.getString(i);
                    } else if (type == 4) {
                        objArr[i] = cursor3.getBlob(i);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                matrixCursor.addRow(objArr);
            }
            CloseableKt.closeFinally(cursor2, (Throwable) null);
            return matrixCursor;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursor2, th);
                throw th2;
            }
        }
    }
}
