package com.azure.json.models;

import com.azure.json.JsonProviders;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.json.implementation.StringBuilderWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class JsonObject extends JsonElement {
    private final Map<String, JsonElement> properties;

    @Override // com.azure.json.models.JsonElement
    public boolean isObject() {
        return true;
    }

    public JsonObject() {
        this.properties = new LinkedHashMap();
    }

    private JsonObject(Map<String, JsonElement> map) {
        this.properties = map;
    }

    public boolean hasProperty(String str) {
        return this.properties.containsKey(str);
    }

    public JsonElement getProperty(String str) {
        return this.properties.get(str);
    }

    public JsonObject setProperty(String str, JsonElement jsonElement) {
        this.properties.put(str, nullCheck(jsonElement));
        return this;
    }

    public JsonObject setProperty(String str, boolean z) {
        this.properties.put(str, JsonBoolean.getInstance(z));
        return this;
    }

    public JsonObject setProperty(String str, Number number) {
        this.properties.put(str, number == null ? JsonNull.getInstance() : new JsonNumber(number));
        return this;
    }

    public JsonObject setProperty(String str, String str2) {
        this.properties.put(str, str2 == null ? JsonNull.getInstance() : new JsonString(str2));
        return this;
    }

    public JsonElement removeProperty(String str) {
        return this.properties.remove(str);
    }

    public int size() {
        return this.properties.size();
    }

    @Override // com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        return jsonWriter.writeMap(this.properties, new JsonArray$$ExternalSyntheticLambda0());
    }

    public static JsonObject fromJson(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenCurrentToken = jsonReader.currentToken();
        if (jsonTokenCurrentToken == null) {
            jsonTokenCurrentToken = jsonReader.nextToken();
        }
        if (jsonTokenCurrentToken != JsonToken.START_OBJECT) {
            throw new IllegalStateException("JsonReader is pointing to an invalid token for deserialization. Token was: " + jsonTokenCurrentToken + ".");
        }
        return new JsonObject(jsonReader.readMap(new JsonArray$$ExternalSyntheticLambda1()));
    }

    @Override // com.azure.json.JsonSerializable
    public String toJsonString() throws IOException {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        JsonWriter jsonWriterCreateWriter = JsonProviders.createWriter(stringBuilderWriter);
        try {
            toJson(jsonWriterCreateWriter).flush();
            String string = stringBuilderWriter.toString();
            if (jsonWriterCreateWriter != null) {
                jsonWriterCreateWriter.close();
            }
            return string;
        } catch (Throwable th) {
            if (jsonWriterCreateWriter != null) {
                try {
                    jsonWriterCreateWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private static JsonElement nullCheck(JsonElement jsonElement) {
        return (JsonElement) Objects.requireNonNull(jsonElement, "The JsonElement cannot be null. If null must be represented in JSON, use JsonNull.");
    }
}
