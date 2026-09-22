package androidx.room.util;

import androidx.collection.ArrayMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RelationUtil.android.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001at\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u00042\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0006j\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004`\u00072\u0006\u0010\b\u001a\u00020\t2.\u0010\n\u001a*\u0012 \u0012\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0006j\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004`\u0007\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u001aT\u0010\f\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\r2\u0006\u0010\b\u001a\u00020\t2\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\r\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¨\u0006\u000e"}, d2 = {"recursiveFetchHashMap", "", "K", "", "V", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "isRelationCollection", "", "fetchBlock", "Lkotlin/Function1;", "recursiveFetchArrayMap", "Landroidx/collection/ArrayMap;", "room-runtime_release"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/room/util/RelationUtil")
final /* synthetic */ class RelationUtil__RelationUtil_androidKt {
    public static final <K, V> void recursiveFetchHashMap(HashMap<K, V> map, boolean z, Function1<? super HashMap<K, V>, Unit> function1) {
        int i;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(function1, "fetchBlock");
        HashMap map2 = new HashMap(999);
        Iterator<K> it = map.keySet().iterator();
        loop0: while (true) {
            i = 0;
            do {
                if (!it.hasNext()) {
                    break loop0;
                }
                K next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                if (z) {
                    map2.put(next, map.get(next));
                } else {
                    map2.put(next, null);
                }
                i++;
            } while (i != 999);
            function1.invoke(map2);
            if (!z) {
                map.putAll(map2);
            }
            map2.clear();
        }
        if (i > 0) {
            function1.invoke(map2);
            if (z) {
                return;
            }
            map.putAll(map2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> void recursiveFetchArrayMap(ArrayMap<K, V> arrayMap, boolean z, Function1<? super ArrayMap<K, V>, Unit> function1) {
        Intrinsics.checkNotNullParameter(arrayMap, "map");
        Intrinsics.checkNotNullParameter(function1, "fetchBlock");
        Map arrayMap2 = new ArrayMap(999);
        int size = arrayMap.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (z) {
                arrayMap2.put(arrayMap.keyAt(i), arrayMap.valueAt(i));
            } else {
                arrayMap2.put(arrayMap.keyAt(i), null);
            }
            i++;
            i2++;
            if (i2 == 999) {
                function1.invoke(arrayMap2);
                if (!z) {
                    arrayMap.putAll(arrayMap2);
                }
                arrayMap2.clear();
                i2 = 0;
            }
        }
        if (i2 > 0) {
            function1.invoke(arrayMap2);
            if (z) {
                return;
            }
            arrayMap.putAll(arrayMap2);
        }
    }
}
