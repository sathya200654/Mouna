package com.azure.json.implementation.jackson.core.exc;

import com.azure.json.implementation.jackson.core.JsonGenerator;
import com.azure.json.implementation.jackson.core.JsonLocation;
import com.azure.json.implementation.jackson.core.JsonProcessingException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class StreamWriteException extends JsonProcessingException {
    private static final long serialVersionUID = 2;
    protected transient JsonGenerator _processor;

    protected StreamWriteException(Throwable th, JsonGenerator jsonGenerator) {
        super(th);
        this._processor = jsonGenerator;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected StreamWriteException(String str, JsonGenerator jsonGenerator) {
        super(str, (JsonLocation) null);
        this._processor = jsonGenerator;
    }

    protected StreamWriteException(String str, Throwable th, JsonGenerator jsonGenerator) {
        super(str, null, th);
        this._processor = jsonGenerator;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonProcessingException, com.azure.json.implementation.jackson.core.JacksonException
    public JsonGenerator getProcessor() {
        return this._processor;
    }
}
