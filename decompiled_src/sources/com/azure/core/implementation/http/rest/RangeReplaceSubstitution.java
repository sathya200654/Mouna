package com.azure.core.implementation.http.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class RangeReplaceSubstitution extends Substitution implements Comparable<RangeReplaceSubstitution> {
    private final int end;
    private final int start;

    private RangeReplaceSubstitution(String str, int i, boolean z, int i2, int i3) {
        super(str, i, z);
        this.start = i2;
        this.end = i3;
    }

    public static List<RangeReplaceSubstitution> getRangeReplaceSubstitutions(String str, int i, boolean z, String str2) {
        ArrayList arrayList = new ArrayList();
        String str3 = "{" + str + "}";
        int length = 0;
        while (true) {
            int iIndexOf = str2.indexOf(str3, length);
            if (iIndexOf == -1) {
                return arrayList;
            }
            String str4 = str;
            arrayList.add(new RangeReplaceSubstitution(str4, i, z, iIndexOf, iIndexOf + str3.length()));
            length = iIndexOf + str3.length();
            str = str4;
        }
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public int getSize() {
        return this.end - this.start;
    }

    @Override // java.lang.Comparable
    public int compareTo(RangeReplaceSubstitution rangeReplaceSubstitution) {
        int i = this.start;
        int i2 = rangeReplaceSubstitution.start;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return Integer.compare(this.end, rangeReplaceSubstitution.end);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.start), Integer.valueOf(this.end));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RangeReplaceSubstitution)) {
            return false;
        }
        RangeReplaceSubstitution rangeReplaceSubstitution = (RangeReplaceSubstitution) obj;
        return this.start == rangeReplaceSubstitution.start && this.end == rangeReplaceSubstitution.end;
    }
}
