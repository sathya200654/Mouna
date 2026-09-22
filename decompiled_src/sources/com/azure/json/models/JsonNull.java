package com.azure.json.models;

import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class JsonNull extends JsonElement {
    private static final JsonNull INSTANCE = new JsonNull();

    @Override // com.azure.json.models.JsonElement
    public boolean isNull() {
        return true;
    }

    private JsonNull() {
    }

    public static JsonNull getInstance() {
        return INSTANCE;
    }

    @Override // com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        return jsonWriter.writeNull();
    }

    public static JsonNull fromJson(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenCurrentToken = jsonReader.currentToken();
        if (jsonTokenCurrentToken == null) {
            jsonTokenCurrentToken = jsonReader.nextToken();
        }
        if (jsonTokenCurrentToken != JsonToken.NULL) {
            throw new IllegalStateException("JsonReader is pointing to an invalid token for deserialization. Token was: " + jsonTokenCurrentToken + ".");
        }
        return getInstance();
    }

    @Override // com.azure.json.JsonSerializable
    public String toJsonString() throws IOException {
        return "null";
    }
}
