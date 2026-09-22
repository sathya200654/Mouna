package com.azure.json.implementation.jackson.core;

import com.azure.json.implementation.jackson.core.util.JacksonFeature;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface FormatFeature extends JacksonFeature {
    @Override // com.azure.json.implementation.jackson.core.util.JacksonFeature
    boolean enabledByDefault();

    @Override // com.azure.json.implementation.jackson.core.util.JacksonFeature
    boolean enabledIn(int i);

    @Override // com.azure.json.implementation.jackson.core.util.JacksonFeature
    int getMask();
}
