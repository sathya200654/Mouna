package com.azure.json.models;

import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.json.implementation.jackson.core.io.JsonStringEncoder;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class JsonString extends JsonElement {
    private String jsonString;
    private final String value;

    @Override // com.azure.json.models.JsonElement
    public boolean isString() {
        return true;
    }

    public JsonString(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    @Override // com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        return jsonWriter.writeString(this.value);
    }

    public static JsonString fromJson(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenCurrentToken = jsonReader.currentToken();
        if (jsonTokenCurrentToken == null) {
            jsonTokenCurrentToken = jsonReader.nextToken();
        }
        if (jsonTokenCurrentToken != JsonToken.STRING) {
            throw new IllegalStateException("JsonReader is pointing to an invalid token for deserialization. Token was: " + jsonTokenCurrentToken + ".");
        }
        return new JsonString(jsonReader.getString());
    }

    @Override // com.azure.json.JsonSerializable
    public String toJsonString() throws IOException {
        String str = this.jsonString;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(this.value.length() + 32);
        sb.append('\"');
        JsonStringEncoder.getInstance().quoteAsString(this.value, sb);
        sb.append('\"');
        String string = sb.toString();
        this.jsonString = string;
        return string;
    }
}
