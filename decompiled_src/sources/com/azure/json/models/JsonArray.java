package com.azure.json.models;

import com.azure.json.JsonProviders;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.json.implementation.StringBuilderWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class JsonArray extends JsonElement {
    private final List<JsonElement> elements;

    @Override // com.azure.json.models.JsonElement
    public boolean isArray() {
        return true;
    }

    public JsonArray() {
        this.elements = new LinkedList();
    }

    private JsonArray(List<JsonElement> list) {
        this.elements = list;
    }

    public JsonArray addElement(JsonElement jsonElement) {
        this.elements.add(nullCheck(jsonElement));
        return this;
    }

    public JsonArray addElement(boolean z) {
        this.elements.add(JsonBoolean.getInstance(z));
        return this;
    }

    public JsonArray addElement(Number number) {
        this.elements.add(number == null ? JsonNull.getInstance() : new JsonNumber(number));
        return this;
    }

    public JsonArray addElement(String str) {
        this.elements.add(str == null ? JsonNull.getInstance() : new JsonString(str));
        return this;
    }

    public JsonArray addElement(int i, JsonElement jsonElement) {
        this.elements.add(i, nullCheck(jsonElement));
        return this;
    }

    public JsonArray addElement(int i, boolean z) {
        this.elements.add(i, JsonBoolean.getInstance(z));
        return this;
    }

    public JsonArray addElement(int i, Number number) {
        this.elements.add(i, number == null ? JsonNull.getInstance() : new JsonNumber(number));
        return this;
    }

    public JsonArray addElement(int i, String str) {
        this.elements.add(i, str == null ? JsonNull.getInstance() : new JsonString(str));
        return this;
    }

    public JsonArray setElement(int i, JsonElement jsonElement) {
        this.elements.set(i, nullCheck(jsonElement));
        return this;
    }

    public JsonArray setElement(int i, boolean z) {
        this.elements.set(i, JsonBoolean.getInstance(z));
        return this;
    }

    public JsonArray setElement(int i, Number number) {
        this.elements.set(i, number == null ? JsonNull.getInstance() : new JsonNumber(number));
        return this;
    }

    public JsonArray setElement(int i, String str) {
        this.elements.set(i, str == null ? JsonNull.getInstance() : new JsonString(str));
        return this;
    }

    public JsonElement getElement(int i) throws IndexOutOfBoundsException {
        return this.elements.get(i);
    }

    public JsonElement removeElement(int i) throws IndexOutOfBoundsException {
        return this.elements.remove(i);
    }

    public int size() {
        return this.elements.size();
    }

    @Override // com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        return jsonWriter.writeArray(this.elements, new JsonArray$$ExternalSyntheticLambda0());
    }

    public static JsonArray fromJson(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenCurrentToken = jsonReader.currentToken();
        if (jsonTokenCurrentToken == null) {
            jsonTokenCurrentToken = jsonReader.nextToken();
        }
        if (jsonTokenCurrentToken != JsonToken.START_ARRAY) {
            throw new IllegalStateException("JsonReader is pointing to an invalid token for deserialization. Token was: " + jsonTokenCurrentToken + ".");
        }
        return new JsonArray(jsonReader.readArray(new JsonArray$$ExternalSyntheticLambda1()));
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
