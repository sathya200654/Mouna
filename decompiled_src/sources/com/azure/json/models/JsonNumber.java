package com.azure.json.models;

import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.json.implementation.JsonUtils;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class JsonNumber extends JsonElement {
    private final Number value;

    @Override // com.azure.json.models.JsonElement
    public boolean isNumber() {
        return true;
    }

    JsonNumber(String str) throws IllegalArgumentException {
        this.value = JsonUtils.parseNumber(str);
    }

    public JsonNumber(Number number) {
        this.value = (Number) Objects.requireNonNull(number, "JsonNumber cannot represent a null value.");
    }

    public Number getValue() {
        return this.value;
    }

    @Override // com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        return jsonWriter.writeRawValue(this.value.toString());
    }

    public static JsonNumber fromJson(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenCurrentToken = jsonReader.currentToken();
        if (jsonTokenCurrentToken == null) {
            jsonTokenCurrentToken = jsonReader.nextToken();
        }
        if (jsonTokenCurrentToken != JsonToken.NUMBER) {
            throw new IllegalStateException("JsonReader is pointing to an invalid token for deserialization. Token was: " + jsonTokenCurrentToken + ".");
        }
        return new JsonNumber(jsonReader.getString());
    }

    @Override // com.azure.json.JsonSerializable
    public String toJsonString() throws IOException {
        return this.value.toString();
    }
}
