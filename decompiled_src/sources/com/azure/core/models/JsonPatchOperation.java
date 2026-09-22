package com.azure.core.models;

import androidx.tracing.perfetto.handshake.protocol.RequestKeys;
import com.azure.core.implementation.Option;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.json.ReadValueCallback;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@JsonSerialize(using = JsonPatchOperationSerializer.class)
final class JsonPatchOperation implements JsonSerializable<JsonPatchOperation> {
    private final String from;
    private final JsonPatchOperationKind op;
    private final String path;
    private final Option<String> value;

    JsonPatchOperation(JsonPatchOperationKind jsonPatchOperationKind, String str, String str2, Option<String> option) {
        this.op = jsonPatchOperationKind;
        this.from = str;
        this.path = str2;
        this.value = option;
    }

    JsonPatchOperationKind getOp() {
        return this.op;
    }

    String getFrom() {
        return this.from;
    }

    String getPath() {
        return this.path;
    }

    Option<String> getValue() {
        return this.value;
    }

    public int hashCode() {
        String string = this.op.toString();
        String str = this.from;
        String str2 = this.path;
        Option<String> option = this.value;
        return Objects.hash(string, str, str2, option == null ? null : option.getValue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JsonPatchOperation)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        JsonPatchOperation jsonPatchOperation = (JsonPatchOperation) obj;
        return Objects.equals(this.op, jsonPatchOperation.op) && Objects.equals(this.from, jsonPatchOperation.from) && Objects.equals(this.path, jsonPatchOperation.path) && Objects.equals(this.value, jsonPatchOperation.value);
    }

    public String toString() {
        return buildString(new StringBuilder()).toString();
    }

    StringBuilder buildString(StringBuilder sb) {
        sb.append("{\"op\":\"").append(this.op.toString()).append("\"");
        if (this.from != null) {
            sb.append(",\"from\":\"").append(this.from).append("\"");
        }
        sb.append(",\"path\":\"").append(this.path).append("\"");
        if (this.value.isInitialized()) {
            sb.append(",\"value\":").append(this.value.getValue());
        }
        return sb.append("}");
    }

    @Override // com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject().writeStringField("op", this.op.toString()).writeStringField(Constants.MessagePayloadKeys.FROM, this.from).writeStringField(RequestKeys.KEY_PATH, this.path);
        if (this.value.isInitialized()) {
            if (this.value.getValue() != null) {
                jsonWriter.writeRawField("value", this.value.getValue());
            } else {
                jsonWriter.writeNullField("value");
            }
        }
        return jsonWriter.writeEndObject();
    }

    public static JsonPatchOperation fromJson(JsonReader jsonReader) throws IOException {
        return (JsonPatchOperation) jsonReader.readObject(new ReadValueCallback() { // from class: com.azure.core.models.JsonPatchOperation$$ExternalSyntheticLambda0
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return JsonPatchOperation.lambda$fromJson$0((JsonReader) obj);
            }
        });
    }

    static /* synthetic */ JsonPatchOperation lambda$fromJson$0(JsonReader jsonReader) throws IOException {
        Option optionUninitialized = Option.uninitialized();
        JsonPatchOperationKind jsonPatchOperationKindFromString = null;
        String string = null;
        String string2 = null;
        while (jsonReader.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonReader.getFieldName();
            jsonReader.nextToken();
            if ("op".equals(fieldName)) {
                jsonPatchOperationKindFromString = JsonPatchOperationKind.fromString(jsonReader.getString());
            } else if (Constants.MessagePayloadKeys.FROM.equals(fieldName)) {
                string = jsonReader.getString();
            } else if (RequestKeys.KEY_PATH.equals(fieldName)) {
                string2 = jsonReader.getString();
            } else if ("value".equals(fieldName)) {
                optionUninitialized = Option.of(jsonReader.getString());
            } else {
                jsonReader.skipChildren();
            }
        }
        return new JsonPatchOperation(jsonPatchOperationKindFromString, string, string2, optionUninitialized);
    }
}
