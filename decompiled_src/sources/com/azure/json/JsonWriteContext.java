package com.azure.json;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class JsonWriteContext {
    private final JsonWriteState context;
    private final JsonWriteContext parent;
    public static final JsonWriteContext ROOT = new JsonWriteContext(null, JsonWriteState.ROOT);
    public static final JsonWriteContext COMPLETED = new JsonWriteContext(null, JsonWriteState.COMPLETED);

    private JsonWriteContext(JsonWriteContext jsonWriteContext, JsonWriteState jsonWriteState) {
        this.parent = jsonWriteContext;
        this.context = jsonWriteState;
    }

    public JsonWriteContext getParent() {
        return this.parent;
    }

    public JsonWriteState getWriteState() {
        return this.context;
    }

    public void validateToken(JsonToken jsonToken) {
        if (this.context == JsonWriteState.ROOT) {
            if (jsonToken == JsonToken.END_OBJECT || jsonToken == JsonToken.END_ARRAY || jsonToken == JsonToken.FIELD_NAME) {
                throw new IllegalStateException("Writing context is 'ROOT', only 'START_OBJECT', 'START_ARRAY', 'BOOLEAN', 'NULL', 'NUMBER', or 'STRING' tokens are allowed. Attempted: '" + jsonToken + "'.");
            }
            return;
        }
        if (this.context == JsonWriteState.OBJECT) {
            if (jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY || jsonToken == JsonToken.END_ARRAY || isSimpleValue(jsonToken)) {
                throw new IllegalStateException("Writing context is 'OBJECT', only 'END_OBJECT' and 'FIELD_NAME' tokens are allowed. Attempted: '" + jsonToken + "'.");
            }
            return;
        }
        if (this.context == JsonWriteState.ARRAY) {
            if (jsonToken == JsonToken.END_OBJECT || jsonToken == JsonToken.FIELD_NAME) {
                throw new IllegalStateException("Writing context is 'ARRAY', only 'START_OBJECT', 'START_ARRAY',, 'END_ARRAY', 'BOOLEAN', 'NULL', 'NUMBER', or 'STRING' tokens are allowed. Attempted: '" + jsonToken + "'.");
            }
        } else {
            if (this.context == JsonWriteState.FIELD) {
                if (jsonToken == JsonToken.END_OBJECT || jsonToken == JsonToken.END_ARRAY || jsonToken == JsonToken.FIELD_NAME) {
                    throw new IllegalStateException("Writing context is 'FIELD', only 'START_OBJECT', 'START_ARRAY', 'BOOLEAN', 'NULL', 'NUMBER', or 'STRING' tokens are allowed. Attempted: '" + jsonToken + "'.");
                }
                return;
            }
            throw new IllegalStateException("Writing context is 'COMPLETED', no further tokens are allowed. Attempted: '" + jsonToken + "'.");
        }
    }

    public JsonWriteContext updateContext(JsonToken jsonToken) {
        if (isSimpleValue(jsonToken)) {
            if (this.context == JsonWriteState.ROOT) {
                return COMPLETED;
            }
            if (this.context != JsonWriteState.ARRAY) {
                return this.parent;
            }
        } else {
            if (jsonToken == JsonToken.END_ARRAY || jsonToken == JsonToken.END_OBJECT) {
                JsonWriteContext jsonWriteContext = this.parent;
                if (jsonWriteContext.context == JsonWriteState.ROOT) {
                    return COMPLETED;
                }
                return jsonWriteContext.context == JsonWriteState.FIELD ? jsonWriteContext.parent : jsonWriteContext;
            }
            if (jsonToken == JsonToken.START_OBJECT) {
                return new JsonWriteContext(this, JsonWriteState.OBJECT);
            }
            if (jsonToken == JsonToken.START_ARRAY) {
                return new JsonWriteContext(this, JsonWriteState.ARRAY);
            }
            if (jsonToken == JsonToken.FIELD_NAME) {
                return new JsonWriteContext(this, JsonWriteState.FIELD);
            }
        }
        return this;
    }

    private static boolean isSimpleValue(JsonToken jsonToken) {
        return jsonToken == JsonToken.BOOLEAN || jsonToken == JsonToken.NULL || jsonToken == JsonToken.NUMBER || jsonToken == JsonToken.STRING;
    }
}
