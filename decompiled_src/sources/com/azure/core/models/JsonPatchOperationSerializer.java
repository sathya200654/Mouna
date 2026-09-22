package com.azure.core.models;

import androidx.tracing.perfetto.handshake.protocol.RequestKeys;
import com.azure.core.implementation.Option;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.firebase.messaging.Constants;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class JsonPatchOperationSerializer extends JsonSerializer<JsonPatchOperation> {
    private static final SimpleModule MODULE = new SimpleModule().addSerializer(JsonPatchOperation.class, new JsonPatchOperationSerializer());

    JsonPatchOperationSerializer() {
    }

    public static SimpleModule getModule() {
        return MODULE;
    }

    public void serialize(JsonPatchOperation jsonPatchOperation, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("op", jsonPatchOperation.getOp().toString());
        String from = jsonPatchOperation.getFrom();
        if (from != null) {
            jsonGenerator.writeStringField(Constants.MessagePayloadKeys.FROM, from);
        }
        jsonGenerator.writeStringField(RequestKeys.KEY_PATH, jsonPatchOperation.getPath());
        Option<String> value = jsonPatchOperation.getValue();
        if (value.isInitialized()) {
            String value2 = value.getValue();
            if (value2 != null) {
                jsonGenerator.writeFieldName("value");
                jsonGenerator.writeRawValue(value2);
            } else {
                jsonGenerator.writeNullField("value");
            }
        }
        jsonGenerator.writeEndObject();
    }
}
