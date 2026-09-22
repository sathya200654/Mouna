package com.fasterxml.jackson.core.util;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface JacksonFeature {
    boolean enabledByDefault();

    boolean enabledIn(int i);

    int getMask();
}
