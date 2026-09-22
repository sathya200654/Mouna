package com.azure.json;

import com.azure.json.implementation.JsonUtils;
import com.azure.json.implementation.jackson.core.io.JsonStringEncoder;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class JsonReader implements Closeable {
    private static final JsonStringEncoder ENCODER = JsonStringEncoder.getInstance();

    public abstract JsonReader bufferObject() throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close() throws IOException;

    public abstract JsonToken currentToken();

    public abstract byte[] getBinary() throws IOException;

    public abstract boolean getBoolean() throws IOException;

    public abstract double getDouble() throws IOException;

    public abstract String getFieldName() throws IOException;

    public abstract float getFloat() throws IOException;

    public abstract int getInt() throws IOException;

    public abstract long getLong() throws IOException;

    public abstract String getString() throws IOException;

    public abstract boolean isResetSupported();

    public abstract JsonToken nextToken() throws IOException;

    public abstract JsonReader reset() throws IOException;

    public abstract void skipChildren() throws IOException;

    public final boolean isStartArrayOrObject() {
        return isStartArrayOrObject(currentToken());
    }

    private static boolean isStartArrayOrObject(JsonToken jsonToken) {
        return jsonToken == JsonToken.START_ARRAY || jsonToken == JsonToken.START_OBJECT;
    }

    public final boolean isEndArrayOrObject() {
        return isEndArrayOrObject(currentToken());
    }

    private static boolean isEndArrayOrObject(JsonToken jsonToken) {
        return jsonToken == JsonToken.END_ARRAY || jsonToken == JsonToken.END_OBJECT;
    }

    public final <T> T getNullable(ReadValueCallback<JsonReader, T> readValueCallback) throws IOException {
        if (currentToken() == JsonToken.NULL) {
            return null;
        }
        return readValueCallback.read(this);
    }

    public final String readChildren() throws IOException {
        return readInternal(new StringBuilder(), true, false).toString();
    }

    public final void readChildren(StringBuilder sb) throws IOException {
        readInternal(sb, true, false);
    }

    public final String readRemainingFieldsAsJsonObject() throws IOException {
        return readInternal(new StringBuilder(), false, true).toString();
    }

    public final void readRemainingFieldsAsJsonObject(StringBuilder sb) throws IOException {
        readInternal(sb, false, true);
    }

    private StringBuilder readInternal(StringBuilder sb, boolean z, boolean z2) throws IOException {
        Objects.requireNonNull(sb, "The 'buffer' used to read the JSON object cannot be null.");
        JsonToken jsonTokenCurrentToken = currentToken();
        if (jsonTokenCurrentToken != JsonToken.START_OBJECT && ((!z || jsonTokenCurrentToken != JsonToken.START_ARRAY) && (!z2 || jsonTokenCurrentToken != JsonToken.FIELD_NAME))) {
            return sb;
        }
        if (jsonTokenCurrentToken == JsonToken.FIELD_NAME) {
            sb.append("{\"");
            ENCODER.quoteAsString(getFieldName(), sb);
            sb.append("\":");
            jsonTokenCurrentToken = nextToken();
        }
        appendJson(sb, jsonTokenCurrentToken);
        int i = 1;
        while (i > 0) {
            JsonToken jsonTokenNextToken = nextToken();
            if (!isStartArrayOrObject(jsonTokenNextToken)) {
                if (!isEndArrayOrObject(jsonTokenNextToken)) {
                    if (jsonTokenNextToken == null) {
                        break;
                    }
                } else {
                    i--;
                }
            } else {
                i++;
            }
            if (!isStartArrayOrObject(jsonTokenCurrentToken) && !isEndArrayOrObject(jsonTokenNextToken) && jsonTokenCurrentToken != JsonToken.FIELD_NAME) {
                sb.append(',');
            }
            appendJson(sb, jsonTokenNextToken);
            jsonTokenCurrentToken = jsonTokenNextToken;
        }
        return sb;
    }

    private void appendJson(StringBuilder sb, JsonToken jsonToken) throws IOException {
        if (jsonToken == JsonToken.FIELD_NAME) {
            sb.append("\"");
            ENCODER.quoteAsString(getFieldName(), sb);
            sb.append("\":");
        } else {
            if (jsonToken == JsonToken.STRING) {
                sb.append("\"");
                ENCODER.quoteAsString(getString(), sb);
                sb.append("\"");
                return;
            }
            sb.append(getText());
        }
    }

    public final <T> T readObject(ReadValueCallback<JsonReader, T> readValueCallback) throws IOException {
        return (T) readMapOrObject(readValueCallback, false);
    }

    public final <T> List<T> readArray(ReadValueCallback<JsonReader, T> readValueCallback) throws IOException {
        JsonToken jsonTokenCurrentToken = currentToken();
        if (jsonTokenCurrentToken == null) {
            jsonTokenCurrentToken = nextToken();
        }
        if (jsonTokenCurrentToken == JsonToken.NULL || jsonTokenCurrentToken == null) {
            return null;
        }
        if (jsonTokenCurrentToken != JsonToken.START_ARRAY) {
            throw new IllegalStateException("Unexpected token to begin array deserialization: " + jsonTokenCurrentToken);
        }
        LinkedList linkedList = new LinkedList();
        while (nextToken() != JsonToken.END_ARRAY) {
            linkedList.add(readValueCallback.read(this));
        }
        return linkedList;
    }

    public final <T> Map<String, T> readMap(final ReadValueCallback<JsonReader, T> readValueCallback) throws IOException {
        return (Map) readMapOrObject(new ReadValueCallback() { // from class: com.azure.json.JsonReader$$ExternalSyntheticLambda0
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return this.f$0.m1300lambda$readMap$0$comazurejsonJsonReader(readValueCallback, (JsonReader) obj);
            }
        }, true);
    }

    /* JADX INFO: renamed from: lambda$readMap$0$com-azure-json-JsonReader, reason: not valid java name */
    /* synthetic */ Map m1300lambda$readMap$0$comazurejsonJsonReader(ReadValueCallback readValueCallback, JsonReader jsonReader) throws IOException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (nextToken() != JsonToken.END_OBJECT) {
            String fieldName = getFieldName();
            nextToken();
            linkedHashMap.put(fieldName, readValueCallback.read(this));
        }
        return linkedHashMap;
    }

    private <T> T readMapOrObject(ReadValueCallback<JsonReader, T> readValueCallback, boolean z) throws IOException {
        JsonToken jsonTokenCurrentToken = currentToken();
        if (jsonTokenCurrentToken == null) {
            jsonTokenCurrentToken = nextToken();
        }
        if (jsonTokenCurrentToken == JsonToken.NULL || jsonTokenCurrentToken == null) {
            return null;
        }
        if (jsonTokenCurrentToken != JsonToken.START_OBJECT) {
            throw new IllegalStateException("Unexpected token to begin " + (z ? "map" : "object") + " deserialization: " + jsonTokenCurrentToken);
        }
        return readValueCallback.read(this);
    }

    public final Object readUntyped() throws IOException {
        JsonToken jsonTokenCurrentToken = currentToken();
        if (jsonTokenCurrentToken == null) {
            jsonTokenCurrentToken = nextToken();
        }
        if (jsonTokenCurrentToken == JsonToken.END_ARRAY || jsonTokenCurrentToken == JsonToken.END_OBJECT || jsonTokenCurrentToken == JsonToken.FIELD_NAME) {
            throw new IllegalStateException("Unexpected token to begin an untyped field: " + jsonTokenCurrentToken);
        }
        return readUntypedHelper(0);
    }

    private Object readUntypedHelper(int i) throws IOException {
        if (i >= 999) {
            throw new IllegalStateException("Untyped object exceeded allowed object nested depth of 1000.");
        }
        JsonToken jsonTokenCurrentToken = currentToken();
        if (jsonTokenCurrentToken == JsonToken.NULL || jsonTokenCurrentToken == null) {
            return null;
        }
        if (jsonTokenCurrentToken == JsonToken.BOOLEAN) {
            return Boolean.valueOf(getBoolean());
        }
        if (jsonTokenCurrentToken == JsonToken.NUMBER) {
            return JsonUtils.parseNumber(getText());
        }
        if (jsonTokenCurrentToken == JsonToken.STRING) {
            return getString();
        }
        if (jsonTokenCurrentToken == JsonToken.START_ARRAY) {
            ArrayList arrayList = new ArrayList();
            while (nextToken() != JsonToken.END_ARRAY) {
                arrayList.add(readUntypedHelper(i + 1));
            }
            return arrayList;
        }
        if (jsonTokenCurrentToken == JsonToken.START_OBJECT) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (nextToken() != JsonToken.END_OBJECT) {
                String fieldName = getFieldName();
                nextToken();
                linkedHashMap.put(fieldName, readUntypedHelper(i + 1));
            }
            return linkedHashMap;
        }
        throw new IllegalStateException("Unknown token type while reading an untyped field: " + jsonTokenCurrentToken);
    }

    public final String getText() throws IOException {
        return getTextInternal(false);
    }

    public String getRawText() throws IOException {
        return getTextInternal(true);
    }

    private String getTextInternal(boolean z) throws IOException {
        JsonToken jsonTokenCurrentToken = currentToken();
        if (jsonTokenCurrentToken == null) {
            throw new IllegalStateException("Current token cannot be null.");
        }
        switch (AnonymousClass1.$SwitchMap$com$azure$json$JsonToken[jsonTokenCurrentToken.ordinal()]) {
            case 1:
                return "{";
            case 2:
                return "}";
            case 3:
                return "[";
            case 4:
                return "]";
            case 5:
                return z ? new String(ENCODER.quoteAsUTF8(getFieldName()), StandardCharsets.UTF_8) : getFieldName();
            case 6:
                return String.valueOf(getBoolean());
            case 7:
                return getString();
            case 8:
                return z ? new String(ENCODER.quoteAsUTF8(getString()), StandardCharsets.UTF_8) : getString();
            case 9:
                return "null";
            default:
                return "";
        }
    }

    /* JADX INFO: renamed from: com.azure.json.JsonReader$1, reason: invalid class name */
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
                $SwitchMap$com$azure$json$JsonToken[JsonToken.END_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$azure$json$JsonToken[JsonToken.START_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$azure$json$JsonToken[JsonToken.END_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$azure$json$JsonToken[JsonToken.FIELD_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$azure$json$JsonToken[JsonToken.BOOLEAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$azure$json$JsonToken[JsonToken.NUMBER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$azure$json$JsonToken[JsonToken.STRING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$azure$json$JsonToken[JsonToken.NULL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }
}
