package com.azure.core.models;

import com.azure.core.implementation.Option;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.serializer.JsonSerializer;
import com.azure.core.util.serializer.JsonSerializerProviders;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonWriter;
import com.azure.json.ReadValueCallback;
import com.azure.json.WriteValueCallback;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class JsonPatchDocument implements JsonSerializable<JsonPatchDocument> {
    private static final Object SERIALIZER_INSTANTIATION_SYNCHRONIZER = new Object();
    private static volatile JsonSerializer defaultSerializer;

    @JsonValue
    private final List<JsonPatchOperation> operations;

    @JsonIgnore
    private final JsonSerializer serializer;

    public JsonPatchDocument() {
        this(null);
    }

    public JsonPatchDocument(JsonSerializer jsonSerializer) {
        this.operations = new ArrayList();
        this.serializer = jsonSerializer;
    }

    List<JsonPatchOperation> getOperations() {
        return new ArrayList(this.operations);
    }

    public JsonPatchDocument appendAdd(String str, Object obj) {
        return appendAddInternal(str, serializeValue(obj));
    }

    public JsonPatchDocument appendAddRaw(String str, String str2) {
        return appendAddInternal(str, Option.of(str2));
    }

    private JsonPatchDocument appendAddInternal(String str, Option<String> option) {
        Objects.requireNonNull(str, "'path' cannot be null.");
        return appendOperation(JsonPatchOperationKind.ADD, null, str, option);
    }

    public JsonPatchDocument appendReplace(String str, Object obj) {
        return appendReplaceInternal(str, serializeValue(obj));
    }

    public JsonPatchDocument appendReplaceRaw(String str, String str2) {
        return appendReplaceInternal(str, Option.of(str2));
    }

    private JsonPatchDocument appendReplaceInternal(String str, Option<String> option) {
        Objects.requireNonNull(str, "'path' cannot be null.");
        return appendOperation(JsonPatchOperationKind.REPLACE, null, str, option);
    }

    public JsonPatchDocument appendCopy(String str, String str2) {
        Objects.requireNonNull(str, "'from' cannot be null.");
        Objects.requireNonNull(str2, "'path' cannot be null.");
        return appendOperation(JsonPatchOperationKind.COPY, str, str2, Option.uninitialized());
    }

    public JsonPatchDocument appendMove(String str, String str2) {
        Objects.requireNonNull(str, "'from' cannot be null.");
        Objects.requireNonNull(str2, "'path' cannot be null.");
        return appendOperation(JsonPatchOperationKind.MOVE, str, str2, Option.uninitialized());
    }

    public JsonPatchDocument appendRemove(String str) {
        Objects.requireNonNull(str, "'path' cannot be null.");
        return appendOperation(JsonPatchOperationKind.REMOVE, null, str, Option.uninitialized());
    }

    public JsonPatchDocument appendTest(String str, Object obj) {
        return appendTestInternal(str, serializeValue(obj));
    }

    public JsonPatchDocument appendTestRaw(String str, String str2) {
        return appendTestInternal(str, Option.of(str2));
    }

    private JsonPatchDocument appendTestInternal(String str, Option<String> option) {
        Objects.requireNonNull(str, "'path' cannot be null.");
        return appendOperation(JsonPatchOperationKind.TEST, null, str, option);
    }

    private Option<String> serializeValue(Object obj) {
        byte[] bArrM1212xb620fd1e;
        if (obj == null) {
            return Option.empty();
        }
        JsonSerializer jsonSerializer = this.serializer;
        if (jsonSerializer == null) {
            if (defaultSerializer == null) {
                synchronized (SERIALIZER_INSTANTIATION_SYNCHRONIZER) {
                    if (defaultSerializer == null) {
                        defaultSerializer = JsonSerializerProviders.createInstance();
                    }
                }
            }
            bArrM1212xb620fd1e = defaultSerializer.m1212xb620fd1e(obj);
        } else {
            bArrM1212xb620fd1e = jsonSerializer.m1212xb620fd1e(obj);
        }
        return Option.of(new String(bArrM1212xb620fd1e, StandardCharsets.UTF_8));
    }

    private JsonPatchDocument appendOperation(JsonPatchOperationKind jsonPatchOperationKind, String str, String str2, Option<String> option) {
        this.operations.add(new JsonPatchOperation(jsonPatchOperationKind, str, str2, option));
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.operations.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            this.operations.get(i).buildString(sb);
        }
        return sb.append("]").toString();
    }

    @Override // com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        return CoreUtils.isNullOrEmpty(this.operations) ? jsonWriter : jsonWriter.writeArray(this.operations, new WriteValueCallback() { // from class: com.azure.core.models.JsonPatchDocument$$ExternalSyntheticLambda0
            @Override // com.azure.json.WriteValueCallback
            public final void write(Object obj, Object obj2) throws IOException {
                ((JsonWriter) obj).writeJson((JsonPatchOperation) obj2);
            }
        });
    }

    public static JsonPatchDocument fromJson(JsonReader jsonReader) throws IOException {
        List array = jsonReader.readArray(new ReadValueCallback() { // from class: com.azure.core.models.JsonPatchDocument$$ExternalSyntheticLambda1
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return JsonPatchOperation.fromJson((JsonReader) obj);
            }
        });
        JsonPatchDocument jsonPatchDocument = new JsonPatchDocument();
        if (array != null) {
            jsonPatchDocument.operations.addAll(array);
        }
        return jsonPatchDocument;
    }
}
