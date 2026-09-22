package com.azure.json.implementation.jackson.core;

import com.azure.json.implementation.jackson.core.exc.StreamWriteException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class JsonGenerationException extends StreamWriteException {
    private static final long serialVersionUID = 123;

    @Deprecated
    public JsonGenerationException(Throwable th) {
        super(th, (JsonGenerator) null);
    }

    @Deprecated
    public JsonGenerationException(String str) {
        super(str, (JsonGenerator) null);
    }

    @Deprecated
    public JsonGenerationException(String str, Throwable th) {
        super(str, th, null);
    }

    public JsonGenerationException(String str, JsonGenerator jsonGenerator) {
        super(str, jsonGenerator);
        this._processor = jsonGenerator;
    }

    @Override // com.azure.json.implementation.jackson.core.exc.StreamWriteException, com.azure.json.implementation.jackson.core.JsonProcessingException, com.azure.json.implementation.jackson.core.JacksonException
    public JsonGenerator getProcessor() {
        return this._processor;
    }
}
