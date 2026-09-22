package com.squareup.wire.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImmutableList.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u00022\u00060\u0003j\u0002`\u00042\u00060\u0005j\u0002`\u0006B\u0013\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0096\u0002¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0014¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0016H\u0002R.\u0010\u0007\u001a\"\u0012\f\u0012\n \u000b*\u0004\u0018\u00018\u00008\u00000\nj\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00018\u00008\u0000`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/squareup/wire/internal/ImmutableList;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Ljava/io/Serializable;", "Lcom/squareup/wire/internal/Serializable;", "list", "", "(Ljava/util/List;)V", "Ljava/util/ArrayList;", "kotlin.jvm.PlatformType", "Lkotlin/collections/ArrayList;", "size", "", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "toArray", "", "", "()[Ljava/lang/Object;", "writeReplace", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ImmutableList<T> extends AbstractList<T> implements RandomAccess, Serializable {
    private final ArrayList<T> list;

    public ImmutableList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = new ArrayList<>(list);
    }

    public int getSize() {
        return this.list.size();
    }

    public T get(int index) {
        return this.list.get(index);
    }

    public Object[] toArray() {
        return this.list.toArray(new Object[0]);
    }

    private final Object writeReplace() throws ObjectStreamException {
        List listUnmodifiableList = Collections.unmodifiableList(this.list);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }
}
