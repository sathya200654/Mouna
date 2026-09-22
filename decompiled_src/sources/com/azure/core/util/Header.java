package com.azure.core.util;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class Header {
    private volatile String cachedStringValue;
    private final String name;
    private String value;
    private List<String> values;
    private static final String[] EMPTY_HEADER_ARRAY = new String[0];
    private static final AtomicReferenceFieldUpdater<Header, String> CACHED_STRING_VALUE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(Header.class, String.class, "cachedStringValue");

    public Header(String str, String str2) {
        Objects.requireNonNull(str, "'name' cannot be null.");
        this.name = str;
        this.value = str2;
    }

    public Header(String str, String... strArr) {
        Objects.requireNonNull(str, "'name' cannot be null.");
        this.name = str;
        int length = strArr.length;
        if (length == 1) {
            this.value = strArr[0];
        } else if (length != 0) {
            ArrayList arrayList = new ArrayList(Math.max(length + 2, 4));
            this.values = arrayList;
            Collections.addAll(arrayList, strArr);
        }
    }

    public Header(String str, List<String> list) {
        Objects.requireNonNull(str, "'name' cannot be null.");
        this.name = str;
        int size = list.size();
        if (size == 1) {
            this.value = list.get(0);
        } else if (size != 0) {
            ArrayList arrayList = new ArrayList(Math.max(size + 2, 4));
            this.values = arrayList;
            arrayList.addAll(list);
        }
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        String str = this.value;
        if (str != null) {
            return str;
        }
        if (CoreUtils.isNullOrEmpty(this.values)) {
            return "";
        }
        checkCachedStringValue();
        return CACHED_STRING_VALUE_UPDATER.get(this);
    }

    public String[] getValues() {
        String str = this.value;
        if (str != null) {
            return new String[]{str};
        }
        if (!CoreUtils.isNullOrEmpty(this.values)) {
            return (String[]) this.values.toArray(new String[0]);
        }
        return EMPTY_HEADER_ARRAY;
    }

    public List<String> getValuesList() {
        String str = this.value;
        if (str != null) {
            return Collections.singletonList(str);
        }
        if (!CoreUtils.isNullOrEmpty(this.values)) {
            return Collections.unmodifiableList(this.values);
        }
        return Collections.emptyList();
    }

    public void addValue(String str) {
        if (this.value == null && this.values == null) {
            this.value = str;
            return;
        }
        if (this.values == null) {
            ArrayList arrayList = new ArrayList(4);
            this.values = arrayList;
            arrayList.add(this.value);
            this.value = null;
        }
        this.values.add(str);
        CACHED_STRING_VALUE_UPDATER.set(this, null);
    }

    public String toString() {
        if (this.value != null) {
            return this.name + ":" + this.value;
        }
        if (CoreUtils.isNullOrEmpty(this.values)) {
            return "";
        }
        checkCachedStringValue();
        return this.name + ":" + CACHED_STRING_VALUE_UPDATER.get(this);
    }

    private void checkCachedStringValue() {
        AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(CACHED_STRING_VALUE_UPDATER, this, (Object) null, CoreUtils.stringJoin(",", this.values));
    }
}
