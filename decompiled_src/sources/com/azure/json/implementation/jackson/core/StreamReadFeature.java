package com.azure.json.implementation.jackson.core;

import com.azure.json.implementation.jackson.core.util.JacksonFeature;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public enum StreamReadFeature implements JacksonFeature {
    AUTO_CLOSE_SOURCE(JsonParser.Feature.AUTO_CLOSE_SOURCE),
    STRICT_DUPLICATE_DETECTION(JsonParser.Feature.STRICT_DUPLICATE_DETECTION),
    IGNORE_UNDEFINED(JsonParser.Feature.IGNORE_UNDEFINED),
    INCLUDE_SOURCE_IN_LOCATION(JsonParser.Feature.INCLUDE_SOURCE_IN_LOCATION);

    private final boolean _defaultState;
    private final JsonParser.Feature _mappedFeature;
    private final int _mask;

    StreamReadFeature(JsonParser.Feature feature) {
        this._mappedFeature = feature;
        this._mask = feature.getMask();
        this._defaultState = feature.enabledByDefault();
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

    public JsonParser.Feature mappedFeature() {
        return this._mappedFeature;
    }
}
