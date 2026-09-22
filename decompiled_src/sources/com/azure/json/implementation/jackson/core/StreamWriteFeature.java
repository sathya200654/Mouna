package com.azure.json.implementation.jackson.core;

import com.azure.json.implementation.jackson.core.util.JacksonFeature;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public enum StreamWriteFeature implements JacksonFeature {
    AUTO_CLOSE_TARGET(JsonGenerator.Feature.AUTO_CLOSE_TARGET),
    AUTO_CLOSE_CONTENT(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT),
    FLUSH_PASSED_TO_STREAM(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM),
    WRITE_BIGDECIMAL_AS_PLAIN(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN),
    STRICT_DUPLICATE_DETECTION(JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION),
    IGNORE_UNKNOWN(JsonGenerator.Feature.IGNORE_UNKNOWN);

    private final boolean _defaultState;
    private final JsonGenerator.Feature _mappedFeature;
    private final int _mask;

    StreamWriteFeature(JsonGenerator.Feature feature) {
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

    public JsonGenerator.Feature mappedFeature() {
        return this._mappedFeature;
    }
}
