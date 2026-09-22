package com.azure.json.implementation.jackson.core;

import com.azure.json.implementation.jackson.core.util.JacksonFeature;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public enum StreamReadCapability implements JacksonFeature {
    DUPLICATE_PROPERTIES(false),
    SCALARS_AS_OBJECTS(false),
    UNTYPED_SCALARS(false);

    private final boolean _defaultState;
    private final int _mask = 1 << ordinal();

    StreamReadCapability(boolean z) {
        this._defaultState = z;
    }

    @Override // com.azure.json.implementation.jackson.core.util.JacksonFeature
    public boolean enabledByDefault() {
        return this._defaultState;
    }

    @Override // com.azure.json.implementation.jackson.core.util.JacksonFeature
    public boolean enabledIn(int i) {
        return (this._mask & i) != 0;
    }

    @Override // com.azure.json.implementation.jackson.core.util.JacksonFeature
    public int getMask() {
        return this._mask;
    }
}
