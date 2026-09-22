package com.azure.json.models;

import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class JsonElement implements JsonSerializable<JsonElement> {
    public boolean isArray() {
        return false;
    }

    public boolean isBoolean() {
        return false;
    }

    public boolean isNull() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean isObject() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    static JsonElement fromJson(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenCurrentToken = jsonReader.currentToken();
        if (jsonTokenCurrentToken == null) {
            jsonTokenCurrentToken = jsonReader.nextToken();
        }
        switch (AnonymousClass1.$SwitchMap$com$azure$json$JsonToken[jsonTokenCurrentToken.ordinal()]) {
            case 1:
                return JsonObject.fromJson(jsonReader);
            case 2:
                return JsonArray.fromJson(jsonReader);
            case 3:
                return new JsonString(jsonReader.getString());
            case 4:
                return new JsonNumber(jsonReader.getString());
            case 5:
                return JsonBoolean.getInstance(jsonReader.getBoolean());
            case 6:
                return JsonNull.getInstance();
            default:
                throw new IllegalStateException("JsonReader is pointing to an invalid token for deserialization. Token was: " + jsonTokenCurrentToken + ".");
        }
    }

    /* JADX INFO: renamed from: com.azure.json.models.JsonElement$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$azure$json$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$azure$json$JsonToken = iArr;
            try {
                iArr[JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$azure$json$JsonToken[JsonToken.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$azure$json$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$azure$json$JsonToken[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$azure$json$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$azure$json$JsonToken[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public JsonArray asArray() {
        return (JsonArray) this;
    }

    public JsonObject asObject() {
        return (JsonObject) this;
    }

    public JsonBoolean asBoolean() {
        return (JsonBoolean) this;
    }

    public JsonNull asNull() {
        return (JsonNull) this;
    }

    public JsonNumber asNumber() {
        return (JsonNumber) this;
    }

    public JsonString asString() {
        return (JsonString) this;
    }
}
