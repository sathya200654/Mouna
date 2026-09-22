package com.azure.json.implementation.jackson.core;

import com.azure.json.implementation.jackson.core.exc.StreamReadException;
import com.azure.json.implementation.jackson.core.util.RequestPayload;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class JsonParseException extends StreamReadException {
    private static final long serialVersionUID = 2;

    @Deprecated
    public JsonParseException(String str, JsonLocation jsonLocation) {
        super(str, jsonLocation, (Throwable) null);
    }

    @Deprecated
    public JsonParseException(String str, JsonLocation jsonLocation, Throwable th) {
        super(str, jsonLocation, th);
    }

    public JsonParseException(JsonParser jsonParser, String str) {
        super(jsonParser, str);
    }

    public JsonParseException(JsonParser jsonParser, String str, Throwable th) {
        super(jsonParser, str, th);
    }

    public JsonParseException(JsonParser jsonParser, String str, JsonLocation jsonLocation) {
        super(jsonParser, str, jsonLocation);
    }

    public JsonParseException(JsonParser jsonParser, String str, JsonLocation jsonLocation, Throwable th) {
        super(str, jsonLocation, th);
    }

    @Override // com.azure.json.implementation.jackson.core.exc.StreamReadException
    public JsonParseException withRequestPayload(RequestPayload requestPayload) {
        this._requestPayload = requestPayload;
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.exc.StreamReadException, com.azure.json.implementation.jackson.core.JsonProcessingException, com.azure.json.implementation.jackson.core.JacksonException
    public JsonParser getProcessor() {
        return super.getProcessor();
    }

    @Override // com.azure.json.implementation.jackson.core.exc.StreamReadException
    public RequestPayload getRequestPayload() {
        return super.getRequestPayload();
    }

    @Override // com.azure.json.implementation.jackson.core.exc.StreamReadException
    public String getRequestPayloadAsString() {
        return super.getRequestPayloadAsString();
    }

    @Override // com.azure.json.implementation.jackson.core.exc.StreamReadException, com.azure.json.implementation.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        return super.getMessage();
    }
}
