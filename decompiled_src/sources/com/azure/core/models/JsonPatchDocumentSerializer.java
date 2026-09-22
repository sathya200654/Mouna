package com.azure.core.models;

import com.azure.core.util.CoreUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class JsonPatchDocumentSerializer extends JsonSerializer<JsonPatchDocument> {
    private static final SimpleModule MODULE = new SimpleModule().addSerializer(JsonPatchDocument.class, new JsonPatchDocumentSerializer());

    JsonPatchDocumentSerializer() {
    }

    public static SimpleModule getModule() {
        return MODULE;
    }

    public void serialize(JsonPatchDocument jsonPatchDocument, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<JsonPatchOperation> operations = jsonPatchDocument.getOperations();
        if (CoreUtils.isNullOrEmpty(operations)) {
            return;
        }
        jsonGenerator.writeStartArray();
        Iterator<JsonPatchOperation> it = operations.iterator();
        while (it.hasNext()) {
            jsonGenerator.writeObject(it.next());
        }
        jsonGenerator.writeEndArray();
    }
}
