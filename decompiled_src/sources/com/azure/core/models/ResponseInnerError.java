package com.azure.core.models;

import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.json.ReadValueCallback;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class ResponseInnerError implements JsonSerializable<ResponseInnerError> {

    @JsonProperty("code")
    private String code;

    @JsonProperty("innererror")
    private ResponseInnerError innerError;

    ResponseInnerError() {
    }

    public String getCode() {
        return this.code;
    }

    public ResponseInnerError setCode(String str) {
        this.code = str;
        return this;
    }

    public ResponseInnerError getInnerError() {
        return this.innerError;
    }

    public ResponseInnerError setInnerError(ResponseInnerError responseInnerError) {
        this.innerError = responseInnerError;
        return this;
    }

    @Override // com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        return jsonWriter.writeStartObject().writeStringField("code", this.code).writeJsonField("innererror", this.innerError).writeEndObject();
    }

    public static ResponseInnerError fromJson(JsonReader jsonReader) throws IOException {
        return (ResponseInnerError) jsonReader.readObject(new ReadValueCallback() { // from class: com.azure.core.models.ResponseInnerError$$ExternalSyntheticLambda0
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return ResponseInnerError.lambda$fromJson$0((JsonReader) obj);
            }
        });
    }

    static /* synthetic */ ResponseInnerError lambda$fromJson$0(JsonReader jsonReader) throws IOException {
        ResponseInnerError responseInnerError = new ResponseInnerError();
        while (jsonReader.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonReader.getFieldName();
            jsonReader.nextToken();
            if ("code".equals(fieldName)) {
                responseInnerError.code = jsonReader.getString();
            } else if ("innererror".equals(fieldName)) {
                responseInnerError.innerError = fromJson(jsonReader);
            } else {
                jsonReader.skipChildren();
            }
        }
        return responseInnerError;
    }
}
