package com.azure.json.models;

import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class JsonBoolean extends JsonElement {
    private final boolean value;
    private static final JsonBoolean TRUE = new JsonBoolean(true);
    private static final JsonBoolean FALSE = new JsonBoolean(false);

    @Override // com.azure.json.models.JsonElement
    public boolean isBoolean() {
        return true;
    }

    private JsonBoolean(boolean z) {
        this.value = z;
    }

    public static JsonBoolean getInstance(boolean z) {
        return z ? TRUE : FALSE;
    }

    public boolean getValue() {
        return this.value;
    }

    @Override // com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        return jsonWriter.writeBoolean(this.value);
    }

    public static JsonBoolean fromJson(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenCurrentToken = jsonReader.currentToken();
        if (jsonTokenCurrentToken == null) {
            jsonTokenCurrentToken = jsonReader.nextToken();
        }
        if (jsonTokenCurrentToken != JsonToken.BOOLEAN) {
            throw new IllegalStateException("JsonReader is pointing to an invalid token for deserialization. Token was: " + jsonTokenCurrentToken + ".");
        }
        return getInstance(jsonReader.getBoolean());
    }

    @Override // com.azure.json.JsonSerializable
    public String toJsonString() throws IOException {
        return Boolean.toString(this.value);
    }
}
