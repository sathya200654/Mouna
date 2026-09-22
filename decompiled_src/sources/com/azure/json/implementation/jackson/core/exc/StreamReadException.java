package com.azure.json.implementation.jackson.core.exc;

import com.azure.json.implementation.jackson.core.JsonLocation;
import com.azure.json.implementation.jackson.core.JsonParser;
import com.azure.json.implementation.jackson.core.JsonProcessingException;
import com.azure.json.implementation.jackson.core.util.RequestPayload;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class StreamReadException extends JsonProcessingException {
    static final long serialVersionUID = 2;
    protected transient JsonParser _processor;
    protected RequestPayload _requestPayload;

    public abstract StreamReadException withRequestPayload(RequestPayload requestPayload);

    protected StreamReadException(JsonParser jsonParser, String str) {
        super(str, jsonParser == null ? null : jsonParser.getCurrentLocation());
        this._processor = jsonParser;
    }

    protected StreamReadException(JsonParser jsonParser, String str, Throwable th) {
        super(str, jsonParser == null ? null : jsonParser.getCurrentLocation(), th);
        this._processor = jsonParser;
    }

    protected StreamReadException(JsonParser jsonParser, String str, JsonLocation jsonLocation) {
        super(str, jsonLocation, null);
        this._processor = jsonParser;
    }

    protected StreamReadException(String str, JsonLocation jsonLocation, Throwable th) {
        super(str, jsonLocation, th);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonProcessingException, com.azure.json.implementation.jackson.core.JacksonException
    public JsonParser getProcessor() {
        return this._processor;
    }

    public RequestPayload getRequestPayload() {
        return this._requestPayload;
    }

    public String getRequestPayloadAsString() {
        RequestPayload requestPayload = this._requestPayload;
        if (requestPayload != null) {
            return requestPayload.toString();
        }
        return null;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        return this._requestPayload != null ? message + "\nRequest payload : " + this._requestPayload : message;
    }
}
