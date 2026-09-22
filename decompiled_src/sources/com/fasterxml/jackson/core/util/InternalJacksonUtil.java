package com.fasterxml.jackson.core.util;

import com.google.protobuf.Reader;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class InternalJacksonUtil {
    public static int addOverflowSafe(int i, int i2) {
        int i3 = i + i2;
        return i3 < 0 ? Reader.READ_DONE : i3;
    }
}
