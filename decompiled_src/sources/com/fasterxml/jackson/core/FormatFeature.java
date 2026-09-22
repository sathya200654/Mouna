package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.JacksonFeature;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface FormatFeature extends JacksonFeature {
    @Override // com.fasterxml.jackson.core.util.JacksonFeature
    boolean enabledByDefault();

    @Override // com.fasterxml.jackson.core.util.JacksonFeature
    boolean enabledIn(int i);

    @Override // com.fasterxml.jackson.core.util.JacksonFeature
    int getMask();
}
