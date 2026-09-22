package com.azure.json.implementation.jackson.core.exc;

import com.azure.json.implementation.jackson.core.JsonParser;
import com.azure.json.implementation.jackson.core.JsonToken;
import com.azure.json.implementation.jackson.core.util.RequestPayload;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class InputCoercionException extends StreamReadException {
    private static final long serialVersionUID = 1;
    protected final JsonToken _inputType;
    protected final Class<?> _targetType;

    public InputCoercionException(JsonParser jsonParser, String str, JsonToken jsonToken, Class<?> cls) {
        super(jsonParser, str);
        this._inputType = jsonToken;
        this._targetType = cls;
    }

    @Override // com.azure.json.implementation.jackson.core.exc.StreamReadException
    public InputCoercionException withRequestPayload(RequestPayload requestPayload) {
        this._requestPayload = requestPayload;
        return this;
    }
}
