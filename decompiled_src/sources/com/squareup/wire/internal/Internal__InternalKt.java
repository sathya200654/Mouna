package com.squareup.wire.internal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.ReverseProtoWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Internal.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001\u001a\u0016\u0010\t\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u000e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f\u001a\u0016\u0010\f\u001a\u00020\r2\u000e\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0011\u001a,\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\u00012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u000fH\u0007\u001a>\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0006\u0010\u0015\u001a\u00020\u00012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0018\u0018\u00010\u0011H\u0007\u001a \u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f\u001a2\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\u001a\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u001a$\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u001aK\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040 \"\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010!\u001a\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%\u001a\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%\u001a\u000e\u0010'\u001a\u00020(2\u0006\u0010$\u001a\u00020%\u001a\u000e\u0010)\u001a\u00020*2\u0006\u0010$\u001a\u00020%\u001a\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%\u001a\u000e\u0010,\u001a\u00020(2\u0006\u0010$\u001a\u00020%\u001a\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%\u001a\u000e\u0010.\u001a\u00020(2\u0006\u0010$\u001a\u00020%\u001a\u000e\u0010/\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%\u001a\u000e\u00100\u001a\u00020(2\u0006\u0010$\u001a\u00020%\u001a\u000e\u00101\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%\u001a\u000e\u00102\u001a\u00020(2\u0006\u0010$\u001a\u00020%\u001a\u001e\u00103\u001a\u00020\r2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001a\u001a\u001e\u00109\u001a\u00020\r2\u0006\u00104\u001a\u00020:2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001a\u001a\u001e\u0010;\u001a\u00020\r2\u0006\u00104\u001a\u00020<2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001a\u001a\u001e\u0010=\u001a\u00020\r2\u0006\u00104\u001a\u00020>2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001a\u001a\u001e\u0010?\u001a\u00020\r2\u0006\u00104\u001a\u00020:2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001a\u001a\u001e\u0010@\u001a\u00020\r2\u0006\u00104\u001a\u00020<2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001a\u001a\u001e\u0010A\u001a\u00020\r2\u0006\u00104\u001a\u00020:2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001a\u001a\u001e\u0010B\u001a\u00020\r2\u0006\u00104\u001a\u00020<2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001a\u001a\u001e\u0010C\u001a\u00020\r2\u0006\u00104\u001a\u00020:2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001a\u001a\u001e\u0010D\u001a\u00020\r2\u0006\u00104\u001a\u00020<2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001a\u001a\u001e\u0010E\u001a\u00020\r2\u0006\u00104\u001a\u00020:2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001a\u001a\u001e\u0010F\u001a\u00020\r2\u0006\u00104\u001a\u00020<2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001a\u001a\u001a\u0010G\u001a\u00020H2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u001a(\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f\u001a:\u0010I\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0006\u0010\u0015\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\u001a:\u0010J\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0006\u0010\u0015\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\u001a!\u0010K\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010L\u001a\u0002H\u0014¢\u0006\u0002\u0010M\u001a'\u0010N\u001a\u00060Oj\u0002`P2\u0016\u0010Q\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040 \"\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010R\u001a\u0012\u0010S\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u0014\u001a\u001e\u0010T\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018\u001a\u000e\u0010U\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u0001\u001a\u0014\u0010U\u001a\u00020\u00012\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f\u001a\u001a\u0010W\u001a\u00020H*\u00060Xj\u0002`Y2\b\u0010Z\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u001a\u0010W\u001a\u00020H*\u00060[j\u0002`\\2\b\u0010Z\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0010\u0010]\u001a\u00020\u001a*\u00060Xj\u0002`YH\u0000\u001a\u0010\u0010]\u001a\u00020\u001a*\u00060[j\u0002`\\H\u0000\u001a1\u0010^\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f\"\u0004\b\u0000\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00140\u000f2\f\u0010_\u001a\b\u0012\u0004\u0012\u0002H\u00140`H\u0007¢\u0006\u0002\ba\u001aC\u0010^\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u00112\f\u0010_\u001a\b\u0012\u0004\u0012\u0002H\u00180`H\u0007¢\u0006\u0002\ba\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\" \u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006b"}, d2 = {"ESCAPED_CHARS", "", "typeName", "Lkotlin/reflect/KClass;", "", "getTypeName$Internal__InternalKt", "(Ljava/lang/Object;)Lkotlin/reflect/KClass;", "boxedOneOfClassName", "oneOfName", "boxedOneOfKeyFieldName", "fieldName", "boxedOneOfKeysFieldName", "checkElementsNotNull", "", "list", "", "map", "", "copyOf", "", "T", "name", "", "K", "V", "countNonNull", "", "a", "b", "c", "d", "rest", "", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)I", "decodePrimitive_double", "", "reader", "Lcom/squareup/wire/ProtoReader;", "decodePrimitive_fixed32", "decodePrimitive_fixed64", "", "decodePrimitive_float", "", "decodePrimitive_int32", "decodePrimitive_int64", "decodePrimitive_sfixed32", "decodePrimitive_sfixed64", "decodePrimitive_sint32", "decodePrimitive_sint64", "decodePrimitive_uint32", "decodePrimitive_uint64", "encodeArray_double", "array", "", "writer", "Lcom/squareup/wire/ReverseProtoWriter;", "tag", "encodeArray_fixed32", "", "encodeArray_fixed64", "", "encodeArray_float", "", "encodeArray_int32", "encodeArray_int64", "encodeArray_sfixed32", "encodeArray_sfixed64", "encodeArray_sint32", "encodeArray_sint64", "encodeArray_uint32", "encodeArray_uint64", "equals", "", "immutableCopyOf", "immutableCopyOfMapWithStructValues", "immutableCopyOfStruct", "value", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "missingRequiredFields", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "args", "([Ljava/lang/Object;)Ljava/lang/IllegalStateException;", "newMutableList", "newMutableMap", "sanitize", "values", "commonEquals", "Ljava/time/Duration;", "Lcom/squareup/wire/Duration;", "other", "Ljava/time/Instant;", "Lcom/squareup/wire/Instant;", "commonHashCode", "redactElements", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "-redactElements", "wire-runtime"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "com/squareup/wire/internal/Internal")
final /* synthetic */ class Internal__InternalKt {
    private static final String ESCAPED_CHARS = ",[]{}\\";

    public static final int countNonNull(Object obj, Object obj2) {
        return (obj != null ? 1 : 0) + (obj2 == null ? 0 : 1);
    }

    public static final int countNonNull(Object obj, Object obj2, Object obj3) {
        return (obj != null ? 1 : 0) + (obj2 != null ? 1 : 0) + (obj3 == null ? 0 : 1);
    }

    public static final <T> List<T> newMutableList() {
        return (List) new MutableOnWriteList(CollectionsKt.emptyList());
    }

    public static final <K, V> Map<K, V> newMutableMap() {
        return new LinkedHashMap();
    }

    @Deprecated(message = "Please regenerate code using wire-compiler version 3.0.0 or higher.", replaceWith = @ReplaceWith(expression = "com.squareup.internal.Internal.copyOf(list)", imports = {}))
    public static final <T> List<T> copyOf(String str, List<? extends T> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNull(list);
        return Internal.copyOf(list);
    }

    public static final <T> List<T> copyOf(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (list == CollectionsKt.emptyList() || (list instanceof ImmutableList)) {
            return (List) new MutableOnWriteList(list);
        }
        return new ArrayList(list);
    }

    @Deprecated(message = "Please regenerate code using wire-compiler version 3.0.0 or higher.", replaceWith = @ReplaceWith(expression = "com.squareup.internal.Internal.copyOf(map)", imports = {}))
    public static final <K, V> Map<K, V> copyOf(String str, Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNull(map);
        return Internal.copyOf(map);
    }

    public static final <K, V> Map<K, V> copyOf(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return new LinkedHashMap(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List, java.util.List<T>] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    public static final <T> List<T> immutableCopyOf(String str, List<? extends T> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "list");
        boolean z = list instanceof MutableOnWriteList;
        ?? mutableList$wire_runtime = list;
        if (z) {
            mutableList$wire_runtime = ((MutableOnWriteList) list).getMutableList$wire_runtime();
        }
        if (((??[int, boolean, OBJECT, ARRAY, byte, short, char]) mutableList$wire_runtime) == CollectionsKt.emptyList() || (((??[OBJECT, ARRAY]) mutableList$wire_runtime) instanceof ImmutableList)) {
            return (List<T>) mutableList$wire_runtime;
        }
        ImmutableList immutableList = new ImmutableList((List) mutableList$wire_runtime);
        if (immutableList.contains(null)) {
            throw new IllegalArgumentException((str + ".contains(null)").toString());
        }
        return (List) immutableList;
    }

    public static final <K, V> Map<K, V> immutableCopyOf(String str, Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(map, "map");
        if (map.isEmpty()) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        Set<K> setKeySet = linkedHashMap.keySet();
        Intrinsics.checkNotNull(setKeySet, "null cannot be cast to non-null type kotlin.collections.Collection<K of com.squareup.wire.internal.Internal__InternalKt.immutableCopyOf?>");
        if (setKeySet.contains(null)) {
            throw new IllegalArgumentException((str + ".containsKey(null)").toString());
        }
        Collection<V> collectionValues = linkedHashMap.values();
        Intrinsics.checkNotNull(collectionValues, "null cannot be cast to non-null type kotlin.collections.Collection<V of com.squareup.wire.internal.Internal__InternalKt.immutableCopyOf?>");
        if (collectionValues.contains(null)) {
            throw new IllegalArgumentException((str + ".containsValue(null)").toString());
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap(...)");
        return mapUnmodifiableMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> immutableCopyOfMapWithStructValues(String str, Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(map, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (key == null) {
                throw new IllegalArgumentException((str + ".containsKey(null)").toString());
            }
            linkedHashMap.put(key, Internal.immutableCopyOfStruct(str, value));
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap(...)");
        Intrinsics.checkNotNull(mapUnmodifiableMap, "null cannot be cast to non-null type kotlin.collections.Map<K of com.squareup.wire.internal.Internal__InternalKt.immutableCopyOfMapWithStructValues, V of com.squareup.wire.internal.Internal__InternalKt.immutableCopyOfMapWithStructValues>");
        return mapUnmodifiableMap;
    }

    public static final <T> T immutableCopyOfStruct(String str, T t) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (t == null || (t instanceof Boolean) || (t instanceof Double) || (t instanceof String)) {
            return t;
        }
        if (t instanceof List) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) t).iterator();
            while (it.hasNext()) {
                arrayList.add(Internal.immutableCopyOfStruct(str, it.next()));
            }
            List listUnmodifiableList = Collections.unmodifiableList(arrayList);
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(...)");
            return (T) listUnmodifiableList;
        }
        if (t instanceof Map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : ((Map) t).entrySet()) {
                linkedHashMap.put(Internal.immutableCopyOfStruct(str, entry.getKey()), Internal.immutableCopyOfStruct(str, entry.getValue()));
            }
            Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
            Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap(...)");
            return (T) mapUnmodifiableMap;
        }
        throw new IllegalArgumentException("struct value " + str + " must be a JSON type (null, Boolean, Double, String, List, or Map) but was " + getTypeName$Internal__InternalKt(t) + ": " + t);
    }

    private static final KClass<? extends Object> getTypeName$Internal__InternalKt(Object obj) {
        return Reflection.getOrCreateKotlinClass(obj.getClass());
    }

    /* JADX INFO: renamed from: -redactElements, reason: not valid java name */
    public static final <T> List<T> m2215redactElements(List<? extends T> list, ProtoAdapter<T> protoAdapter) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(protoAdapter, "adapter");
        List<? extends T> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(protoAdapter.redact(it.next()));
        }
        return arrayList;
    }

    public static final boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && Intrinsics.areEqual(obj, obj2);
        }
        return true;
    }

    public static final IllegalStateException missingRequiredFields(Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, objArr.length - 1, 2);
        String str = "";
        if (progressionLastElement >= 0) {
            while (true) {
                if (objArr[i] == null) {
                    if (sb.length() > 0) {
                        str = "s";
                    }
                    sb.append("\n  ");
                    sb.append(objArr[i + 1]);
                }
                if (i == progressionLastElement) {
                    break;
                }
                i += 2;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        throw new IllegalStateException("Required field" + str + " not set:" + string);
    }

    public static final void checkElementsNotNull(List<?> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == null) {
                throw new NullPointerException("Element at index " + i + " is null");
            }
        }
    }

    public static final void checkElementsNotNull(Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key == null) {
                throw new NullPointerException("map.containsKey(null)");
            }
            if (value == null) {
                throw new NullPointerException("Value for key " + key + " is null");
            }
        }
    }

    public static final int countNonNull(Object obj, Object obj2, Object obj3, Object obj4, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "rest");
        int i = obj != null ? 1 : 0;
        if (obj2 != null) {
            i++;
        }
        if (obj3 != null) {
            i++;
        }
        if (obj4 != null) {
            i++;
        }
        for (Object obj5 : objArr) {
            if (obj5 != null) {
                i++;
            }
        }
        return i;
    }

    public static final String sanitize(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        StringBuilder sb = new StringBuilder(str.length());
        String str2 = str;
        for (int i = 0; i < str2.length(); i++) {
            char cCharAt = str2.charAt(i);
            if (StringsKt.contains$default(ESCAPED_CHARS, cCharAt, false, 2, (Object) null)) {
                sb.append('\\');
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: renamed from: com.squareup.wire.internal.Internal__InternalKt$sanitize$2, reason: invalid class name */
    /* JADX INFO: compiled from: Internal.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReference implements Function1<String, String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        public final String getSignature() {
            return "sanitize(Ljava/lang/String;)Ljava/lang/String;";
        }

        public final String getName() {
            return "sanitize";
        }

        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinPackage(Internal__InternalKt.class, "wire-runtime");
        }

        public final String invoke(String str) {
            Intrinsics.checkNotNullParameter(str, "p0");
            return Internal.sanitize(str);
        }
    }

    public static final String sanitize(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "values");
        return CollectionsKt.joinToString$default(list, (CharSequence) null, "[", "]", 0, (CharSequence) null, AnonymousClass2.INSTANCE, 25, (Object) null);
    }

    public static final String boxedOneOfClassName(String str) {
        Intrinsics.checkNotNullParameter(str, "oneOfName");
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sbAppend = new StringBuilder().append((Object) CharsKt.titlecase(str.charAt(0)));
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return sbAppend.append(strSubstring).toString();
    }

    public static final String boxedOneOfKeyFieldName(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "oneOfName");
        Intrinsics.checkNotNullParameter(str2, "fieldName");
        String upperCase = (str + '_' + str2).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public static final String boxedOneOfKeysFieldName(String str) {
        Intrinsics.checkNotNullParameter(str, "oneOfName");
        String upperCase = (str + "_keys").toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public static final void encodeArray_int32(int[] iArr, ReverseProtoWriter reverseProtoWriter, int i) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (iArr.length == 0) {
            return;
        }
        int byteCount = reverseProtoWriter.getByteCount();
        for (int length = iArr.length - 1; -1 < length; length--) {
            reverseProtoWriter.writeSignedVarint32$wire_runtime(iArr[length]);
        }
        reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
        reverseProtoWriter.writeTag(i, FieldEncoding.LENGTH_DELIMITED);
    }

    public static final void encodeArray_uint32(int[] iArr, ReverseProtoWriter reverseProtoWriter, int i) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (iArr.length == 0) {
            return;
        }
        int byteCount = reverseProtoWriter.getByteCount();
        for (int length = iArr.length - 1; -1 < length; length--) {
            reverseProtoWriter.writeVarint32(iArr[length]);
        }
        reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
        reverseProtoWriter.writeTag(i, FieldEncoding.LENGTH_DELIMITED);
    }

    public static final void encodeArray_sint32(int[] iArr, ReverseProtoWriter reverseProtoWriter, int i) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (iArr.length == 0) {
            return;
        }
        int byteCount = reverseProtoWriter.getByteCount();
        for (int length = iArr.length - 1; -1 < length; length--) {
            reverseProtoWriter.writeVarint32(ProtoWriter.INSTANCE.encodeZigZag32$wire_runtime(iArr[length]));
        }
        reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
        reverseProtoWriter.writeTag(i, FieldEncoding.LENGTH_DELIMITED);
    }

    public static final void encodeArray_fixed32(int[] iArr, ReverseProtoWriter reverseProtoWriter, int i) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (iArr.length == 0) {
            return;
        }
        int byteCount = reverseProtoWriter.getByteCount();
        for (int length = iArr.length - 1; -1 < length; length--) {
            reverseProtoWriter.writeFixed32(iArr[length]);
        }
        reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
        reverseProtoWriter.writeTag(i, FieldEncoding.LENGTH_DELIMITED);
    }

    public static final void encodeArray_sfixed32(int[] iArr, ReverseProtoWriter reverseProtoWriter, int i) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        Internal.encodeArray_fixed32(iArr, reverseProtoWriter, i);
    }

    public static final void encodeArray_int64(long[] jArr, ReverseProtoWriter reverseProtoWriter, int i) {
        Intrinsics.checkNotNullParameter(jArr, "array");
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (jArr.length == 0) {
            return;
        }
        int byteCount = reverseProtoWriter.getByteCount();
        for (int length = jArr.length - 1; -1 < length; length--) {
            reverseProtoWriter.writeVarint64(jArr[length]);
        }
        reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
        reverseProtoWriter.writeTag(i, FieldEncoding.LENGTH_DELIMITED);
    }

    public static final void encodeArray_uint64(long[] jArr, ReverseProtoWriter reverseProtoWriter, int i) {
        Intrinsics.checkNotNullParameter(jArr, "array");
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        Internal.encodeArray_int64(jArr, reverseProtoWriter, i);
    }

    public static final void encodeArray_sint64(long[] jArr, ReverseProtoWriter reverseProtoWriter, int i) {
        Intrinsics.checkNotNullParameter(jArr, "array");
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (jArr.length == 0) {
            return;
        }
        int byteCount = reverseProtoWriter.getByteCount();
        for (int length = jArr.length - 1; -1 < length; length--) {
            reverseProtoWriter.writeVarint64(ProtoWriter.INSTANCE.encodeZigZag64$wire_runtime(jArr[length]));
        }
        reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
        reverseProtoWriter.writeTag(i, FieldEncoding.LENGTH_DELIMITED);
    }

    public static final void encodeArray_fixed64(long[] jArr, ReverseProtoWriter reverseProtoWriter, int i) {
        Intrinsics.checkNotNullParameter(jArr, "array");
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (jArr.length == 0) {
            return;
        }
        int byteCount = reverseProtoWriter.getByteCount();
        for (int length = jArr.length - 1; -1 < length; length--) {
            reverseProtoWriter.writeFixed64(jArr[length]);
        }
        reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
        reverseProtoWriter.writeTag(i, FieldEncoding.LENGTH_DELIMITED);
    }

    public static final void encodeArray_sfixed64(long[] jArr, ReverseProtoWriter reverseProtoWriter, int i) {
        Intrinsics.checkNotNullParameter(jArr, "array");
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        Internal.encodeArray_fixed64(jArr, reverseProtoWriter, i);
    }

    public static final void encodeArray_float(float[] fArr, ReverseProtoWriter reverseProtoWriter, int i) {
        Intrinsics.checkNotNullParameter(fArr, "array");
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (fArr.length == 0) {
            return;
        }
        int byteCount = reverseProtoWriter.getByteCount();
        for (int length = fArr.length - 1; -1 < length; length--) {
            reverseProtoWriter.writeFixed32(Float.floatToIntBits(fArr[length]));
        }
        reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
        reverseProtoWriter.writeTag(i, FieldEncoding.LENGTH_DELIMITED);
    }

    public static final void encodeArray_double(double[] dArr, ReverseProtoWriter reverseProtoWriter, int i) {
        Intrinsics.checkNotNullParameter(dArr, "array");
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (dArr.length == 0) {
            return;
        }
        int byteCount = reverseProtoWriter.getByteCount();
        for (int length = dArr.length - 1; -1 < length; length--) {
            reverseProtoWriter.writeFixed64(Double.doubleToLongBits(dArr[length]));
        }
        reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
        reverseProtoWriter.writeTag(i, FieldEncoding.LENGTH_DELIMITED);
    }

    public static final int decodePrimitive_int32(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        return protoReader.readVarint32();
    }

    public static final int decodePrimitive_uint32(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        return protoReader.readVarint32();
    }

    public static final int decodePrimitive_sint32(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        return ProtoWriter.INSTANCE.decodeZigZag32$wire_runtime(protoReader.readVarint32());
    }

    public static final int decodePrimitive_fixed32(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        return protoReader.readFixed32();
    }

    public static final int decodePrimitive_sfixed32(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        return protoReader.readFixed32();
    }

    public static final long decodePrimitive_int64(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        return protoReader.readVarint64();
    }

    public static final long decodePrimitive_uint64(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        return protoReader.readVarint64();
    }

    public static final long decodePrimitive_sint64(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        return ProtoWriter.INSTANCE.decodeZigZag64$wire_runtime(protoReader.readVarint64());
    }

    public static final long decodePrimitive_fixed64(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        return protoReader.readFixed64();
    }

    public static final long decodePrimitive_sfixed64(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        return protoReader.readFixed64();
    }

    public static final float decodePrimitive_float(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(protoReader.readFixed32());
    }

    public static final double decodePrimitive_double(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        return Double.longBitsToDouble(protoReader.readFixed64());
    }

    public static final boolean commonEquals(Instant instant, Object obj) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        if (instant == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Instant)) {
            return false;
        }
        Instant instant2 = (Instant) obj;
        return instant.getEpochSecond() == instant2.getEpochSecond() && instant.getNano() == instant2.getNano();
    }

    public static final int commonHashCode(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return (Long.hashCode(instant.getEpochSecond()) * 31) + Integer.hashCode(instant.getNano());
    }

    public static final boolean commonEquals(Duration duration, Object obj) {
        Intrinsics.checkNotNullParameter(duration, "<this>");
        if (duration == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Duration)) {
            return false;
        }
        Duration duration2 = (Duration) obj;
        return duration.getSeconds() == duration2.getSeconds() && duration.getNano() == duration2.getNano();
    }

    public static final int commonHashCode(Duration duration) {
        Intrinsics.checkNotNullParameter(duration, "<this>");
        return (Long.hashCode(duration.getSeconds()) * 31) + Integer.hashCode(duration.getNano());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: -redactElements, reason: not valid java name */
    public static final <K, V> Map<K, V> m2216redactElements(Map<K, ? extends V> map, ProtoAdapter<V> protoAdapter) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(protoAdapter, "adapter");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), protoAdapter.redact(entry.getValue()));
        }
        return linkedHashMap;
    }
}
