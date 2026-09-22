package com.azure.json.implementation.jackson.core;

import com.azure.json.implementation.jackson.core.io.CharacterEscapes;
import com.azure.json.implementation.jackson.core.json.JsonReadFeature;
import com.azure.json.implementation.jackson.core.json.JsonWriteFeature;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class JsonFactoryBuilder extends TSFBuilder<JsonFactory, JsonFactoryBuilder> {
    protected CharacterEscapes _characterEscapes;
    protected char _quoteChar = '\"';
    protected SerializableString _rootValueSeparator = JsonFactory.DEFAULT_ROOT_VALUE_SEPARATOR;
    protected int _maximumNonEscapedChar = 0;

    @Override // com.azure.json.implementation.jackson.core.TSFBuilder
    public JsonFactoryBuilder enable(JsonReadFeature jsonReadFeature) {
        _legacyEnable(jsonReadFeature.mappedFeature());
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.TSFBuilder
    public JsonFactoryBuilder enable(JsonReadFeature jsonReadFeature, JsonReadFeature... jsonReadFeatureArr) {
        _legacyEnable(jsonReadFeature.mappedFeature());
        enable(jsonReadFeature);
        for (JsonReadFeature jsonReadFeature2 : jsonReadFeatureArr) {
            _legacyEnable(jsonReadFeature2.mappedFeature());
        }
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.TSFBuilder
    public JsonFactoryBuilder disable(JsonReadFeature jsonReadFeature) {
        _legacyDisable(jsonReadFeature.mappedFeature());
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.TSFBuilder
    public JsonFactoryBuilder disable(JsonReadFeature jsonReadFeature, JsonReadFeature... jsonReadFeatureArr) {
        _legacyDisable(jsonReadFeature.mappedFeature());
        for (JsonReadFeature jsonReadFeature2 : jsonReadFeatureArr) {
            _legacyEnable(jsonReadFeature2.mappedFeature());
        }
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.TSFBuilder
    public JsonFactoryBuilder configure(JsonReadFeature jsonReadFeature, boolean z) {
        return z ? enable(jsonReadFeature) : disable(jsonReadFeature);
    }

    @Override // com.azure.json.implementation.jackson.core.TSFBuilder
    public JsonFactoryBuilder enable(JsonWriteFeature jsonWriteFeature) {
        JsonGenerator.Feature featureMappedFeature = jsonWriteFeature.mappedFeature();
        if (featureMappedFeature != null) {
            _legacyEnable(featureMappedFeature);
        }
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.TSFBuilder
    public JsonFactoryBuilder enable(JsonWriteFeature jsonWriteFeature, JsonWriteFeature... jsonWriteFeatureArr) {
        _legacyEnable(jsonWriteFeature.mappedFeature());
        for (JsonWriteFeature jsonWriteFeature2 : jsonWriteFeatureArr) {
            _legacyEnable(jsonWriteFeature2.mappedFeature());
        }
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.TSFBuilder
    public JsonFactoryBuilder disable(JsonWriteFeature jsonWriteFeature) {
        _legacyDisable(jsonWriteFeature.mappedFeature());
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.TSFBuilder
    public JsonFactoryBuilder disable(JsonWriteFeature jsonWriteFeature, JsonWriteFeature... jsonWriteFeatureArr) {
        _legacyDisable(jsonWriteFeature.mappedFeature());
        for (JsonWriteFeature jsonWriteFeature2 : jsonWriteFeatureArr) {
            _legacyDisable(jsonWriteFeature2.mappedFeature());
        }
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.TSFBuilder
    public JsonFactoryBuilder configure(JsonWriteFeature jsonWriteFeature, boolean z) {
        return z ? enable(jsonWriteFeature) : disable(jsonWriteFeature);
    }

    @Override // com.azure.json.implementation.jackson.core.TSFBuilder
    public JsonFactory build() {
        return new JsonFactory(this);
    }
}
