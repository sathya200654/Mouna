package com.azure.core.models;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import androidx.window.embedding.EmbeddingCompat;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.json.ReadValueCallback;
import com.azure.json.WriteValueCallback;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ResponseError implements JsonSerializable<ResponseError> {

    @JsonProperty("code")
    private final String code;

    @JsonProperty("details")
    private List<ResponseError> errorDetails;

    @JsonProperty("innererror")
    private ResponseInnerError innerError;

    @JsonProperty(ResponseKeys.KEY_MESSAGE)
    private final String message;

    @JsonProperty("target")
    private String target;

    @JsonCreator
    public ResponseError(@JsonProperty(required = EmbeddingCompat.DEBUG, value = "code") String str, @JsonProperty(required = EmbeddingCompat.DEBUG, value = ResponseKeys.KEY_MESSAGE) String str2) {
        this.code = str;
        this.message = str2;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    String getTarget() {
        return this.target;
    }

    ResponseError setTarget(String str) {
        this.target = str;
        return this;
    }

    ResponseInnerError getInnerError() {
        return this.innerError;
    }

    ResponseError setInnerError(ResponseInnerError responseInnerError) {
        this.innerError = responseInnerError;
        return this;
    }

    List<ResponseError> getErrorDetails() {
        return this.errorDetails;
    }

    ResponseError setErrorDetails(List<ResponseError> list) {
        this.errorDetails = list;
        return this;
    }

    @Override // com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        return jsonWriter.writeStartObject().writeStringField("code", this.code).writeStringField(ResponseKeys.KEY_MESSAGE, this.message).writeStringField("target", this.target).writeJsonField("innererror", this.innerError).writeArrayField("details", this.errorDetails, new WriteValueCallback() { // from class: com.azure.core.models.ResponseError$$ExternalSyntheticLambda2
            @Override // com.azure.json.WriteValueCallback
            public final void write(Object obj, Object obj2) throws IOException {
                ((JsonWriter) obj).writeJson((ResponseError) obj2);
            }
        }).writeEndObject();
    }

    public static ResponseError fromJson(JsonReader jsonReader) throws IOException {
        return (ResponseError) jsonReader.readObject(new ReadValueCallback() { // from class: com.azure.core.models.ResponseError$$ExternalSyntheticLambda0
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return ResponseError.lambda$fromJson$0((JsonReader) obj);
            }
        });
    }

    static /* synthetic */ ResponseError lambda$fromJson$0(JsonReader jsonReader) throws IOException {
        JsonReader jsonReaderBufferObject = jsonReader.bufferObject();
        jsonReaderBufferObject.nextToken();
        while (jsonReaderBufferObject.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonReaderBufferObject.getFieldName();
            jsonReaderBufferObject.nextToken();
            if ("error".equals(fieldName)) {
                return readResponseError(jsonReaderBufferObject);
            }
            jsonReaderBufferObject.skipChildren();
        }
        return readResponseError(jsonReaderBufferObject.reset());
    }

    private static ResponseError readResponseError(JsonReader jsonReader) throws IOException {
        return (ResponseError) jsonReader.readObject(new ReadValueCallback() { // from class: com.azure.core.models.ResponseError$$ExternalSyntheticLambda1
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return ResponseError.lambda$readResponseError$1((JsonReader) obj);
            }
        });
    }

    static /* synthetic */ ResponseError lambda$readResponseError$1(JsonReader jsonReader) throws IOException {
        String string = null;
        String string2 = null;
        ResponseInnerError responseInnerErrorFromJson = null;
        List<ResponseError> array = null;
        boolean z = false;
        boolean z2 = false;
        String string3 = null;
        while (jsonReader.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonReader.getFieldName();
            jsonReader.nextToken();
            if ("code".equalsIgnoreCase(fieldName)) {
                string = jsonReader.getString();
                z = true;
            } else if (ResponseKeys.KEY_MESSAGE.equalsIgnoreCase(fieldName)) {
                string3 = jsonReader.getString();
                z2 = true;
            } else if ("target".equalsIgnoreCase(fieldName)) {
                string2 = jsonReader.getString();
            } else if ("innererror".equalsIgnoreCase(fieldName)) {
                responseInnerErrorFromJson = ResponseInnerError.fromJson(jsonReader);
            } else if ("details".equalsIgnoreCase(fieldName)) {
                array = jsonReader.readArray(new ReadValueCallback() { // from class: com.azure.core.models.ResponseError$$ExternalSyntheticLambda3
                    @Override // com.azure.json.ReadValueCallback
                    public final Object read(Object obj) {
                        return ResponseError.fromJson((JsonReader) obj);
                    }
                });
            } else {
                jsonReader.skipChildren();
            }
        }
        if (!z && !z2) {
            throw new IllegalStateException("Missing required properties: code, message");
        }
        if (!z) {
            throw new IllegalStateException("Missing required property: code");
        }
        if (!z2) {
            throw new IllegalStateException("Missing required property: message");
        }
        return new ResponseError(string, string3).setTarget(string2).setInnerError(responseInnerErrorFromJson).setErrorDetails(array);
    }
}
