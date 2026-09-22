package com.azure.xml.implementation.aalto.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class NsBinder {
    static final int DEFAULT_ARRAY_SIZE = 32;
    String[] _nsStrings;
    int _scopeEnd;
    final int _scopeStart;

    private NsBinder(int i, String[] strArr) {
        this._scopeEnd = i;
        this._scopeStart = i;
        this._nsStrings = strArr;
    }

    public static NsBinder createEmpty() {
        String[] strArr = new String[32];
        strArr[0] = "xml";
        strArr[1] = "http://www.w3.org/XML/1998/namespace";
        strArr[2] = "xmlns";
        strArr[3] = "http://www.w3.org/2000/xmlns/";
        return new NsBinder(4, strArr);
    }

    public NsBinder createChild() {
        return new NsBinder(this._scopeEnd, this._nsStrings);
    }

    public String findUriByPrefix(String str) {
        String[] strArr = this._nsStrings;
        int iHashCode = str.hashCode();
        for (int i = this._scopeEnd - 2; i >= 0; i -= 2) {
            String str2 = strArr[i];
            if (Objects.equals(str2, str) || (str2.hashCode() == iHashCode && str2.equals(str))) {
                return strArr[i + 1];
            }
        }
        return null;
    }

    public String findPrefixByUri(String str) {
        String[] strArr = this._nsStrings;
        int iHashCode = str.hashCode();
        for (int i = this._scopeEnd - 1; i > 0; i -= 2) {
            String str2 = strArr[i];
            if (Objects.equals(str2, str) || (str2.hashCode() == iHashCode && str2.equals(str))) {
                int i2 = i - 1;
                String str3 = strArr[i2];
                if (i < this._scopeStart) {
                    int iHashCode2 = str3.hashCode();
                    int i3 = this._scopeEnd;
                    while (i2 < i3) {
                        String str4 = strArr[i];
                        if (!Objects.equals(str4, str3) && (str4.hashCode() != iHashCode2 || !str4.equals(str3))) {
                            i2 += 2;
                        }
                    }
                }
                return str3;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    public List<String> getPrefixesBoundToUri(String str, List<String> list) {
        String[] strArr = this._nsStrings;
        int iHashCode = str.hashCode();
        int i = this._scopeEnd - 1;
        List arrayList = list;
        while (i > 0) {
            String str2 = strArr[i];
            if (Objects.equals(str2, str) || (str2.hashCode() == iHashCode && str2.equals(str))) {
                int i2 = i - 1;
                String str3 = strArr[i2];
                if (i < this._scopeStart) {
                    int iHashCode2 = str3.hashCode();
                    int i3 = this._scopeEnd;
                    while (true) {
                        if (i2 < i3) {
                            String str4 = strArr[i];
                            if (!Objects.equals(str4, str3) && (str4.hashCode() != iHashCode2 || !str4.equals(str3))) {
                                i2 += 2;
                            }
                        } else {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(str3);
                        }
                    }
                } else {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(str3);
                }
            }
            i -= 2;
            arrayList = arrayList;
        }
        return arrayList;
    }

    public int size() {
        return this._scopeEnd >> 1;
    }

    public int localSize() {
        return (this._scopeEnd - this._scopeStart) >> 1;
    }

    void addMapping(String str, String str2) {
        String[] strArr = this._nsStrings;
        int iHashCode = str.hashCode();
        int i = this._scopeEnd;
        for (int i2 = this._scopeStart; i2 < i; i2 += 2) {
            String str3 = strArr[i2];
            if (Objects.equals(str3, str) || (str3.hashCode() == iHashCode && str3.equals(str))) {
                strArr[i2 + 1] = str2;
                return;
            }
        }
        if (this._scopeEnd >= strArr.length) {
            strArr = (String[]) Arrays.copyOf(strArr, strArr.length << 1);
            this._nsStrings = strArr;
        }
        int i3 = this._scopeEnd;
        int i4 = i3 + 1;
        this._scopeEnd = i4;
        strArr[i3] = str;
        this._scopeEnd = i3 + 2;
        strArr[i4] = str2;
    }

    public String toString() {
        return "[" + getClass() + "; " + size() + " entries; of which " + localSize() + " local]";
    }
}
