package com.azure.core.implementation.jackson;

import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonOptions;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class JacksonJsonReader extends JsonReader {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) JacksonJsonReader.class);
    private JsonToken currentToken;
    private final byte[] jsonBytes;
    private final JsonOptions jsonOptions;
    private final String jsonString;
    private final JsonParser parser;
    private final boolean resetSupported;

    JacksonJsonReader(JsonParser jsonParser, byte[] bArr, String str, boolean z, JsonOptions jsonOptions) {
        this.parser = (JsonParser) Objects.requireNonNull(jsonParser, "Cannot create a Jackson-based instance of com.azure.json.JsonReader with a null Jackson JsonParser.");
        this.jsonBytes = bArr;
        this.jsonString = str;
        this.resetSupported = z;
        this.jsonOptions = jsonOptions;
        this.currentToken = mapToken(jsonParser.currentToken(), null);
    }

    @Override // com.azure.json.JsonReader
    public JsonToken currentToken() {
        return this.currentToken;
    }

    @Override // com.azure.json.JsonReader
    public JsonToken nextToken() throws IOException {
        JsonToken jsonTokenMapToken = mapToken(this.parser.nextToken(), this.currentToken);
        this.currentToken = jsonTokenMapToken;
        return jsonTokenMapToken;
    }

    @Override // com.azure.json.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.parser.close();
    }

    @Override // com.azure.json.JsonReader
    public byte[] getBinary() throws IOException {
        if (currentToken() == JsonToken.NULL) {
            return null;
        }
        return this.parser.getBinaryValue();
    }

    @Override // com.azure.json.JsonReader
    public boolean getBoolean() throws IOException {
        return this.parser.getBooleanValue();
    }

    @Override // com.azure.json.JsonReader
    public float getFloat() throws IOException {
        return this.parser.getFloatValue();
    }

    @Override // com.azure.json.JsonReader
    public double getDouble() throws IOException {
        return this.parser.getDoubleValue();
    }

    @Override // com.azure.json.JsonReader
    public int getInt() throws IOException {
        return this.parser.getIntValue();
    }

    @Override // com.azure.json.JsonReader
    public long getLong() throws IOException {
        return this.parser.getLongValue();
    }

    @Override // com.azure.json.JsonReader
    public String getString() throws IOException {
        return this.parser.getValueAsString();
    }

    @Override // com.azure.json.JsonReader
    public String getFieldName() throws IOException {
        return this.parser.currentName();
    }

    @Override // com.azure.json.JsonReader
    public void skipChildren() throws IOException {
        this.parser.skipChildren();
    }

    @Override // com.azure.json.JsonReader
    public JsonReader bufferObject() throws IOException {
        JsonToken jsonTokenCurrentToken = currentToken();
        if (jsonTokenCurrentToken == JsonToken.START_OBJECT || jsonTokenCurrentToken == JsonToken.FIELD_NAME) {
            return AzureJsonUtils.createReader(readRemainingFieldsAsJsonObject(), this.jsonOptions);
        }
        throw LOGGER.logExceptionAsError(new IllegalStateException("Cannot buffer a JSON object from a non-object, non-field name starting location. Starting location: " + currentToken()));
    }

    @Override // com.azure.json.JsonReader
    public boolean isResetSupported() {
        return this.resetSupported;
    }

    @Override // com.azure.json.JsonReader
    public JsonReader reset() throws IOException {
        if (!this.resetSupported) {
            throw LOGGER.logExceptionAsError(new IllegalStateException("'reset' isn't supported by this JsonReader."));
        }
        byte[] bArr = this.jsonBytes;
        if (bArr != null) {
            return AzureJsonUtils.createReader(bArr, this.jsonOptions);
        }
        return AzureJsonUtils.createReader(this.jsonString, this.jsonOptions);
    }

    private static JsonToken mapToken(com.fasterxml.jackson.core.JsonToken jsonToken, JsonToken jsonToken2) {
        if (jsonToken == null && jsonToken2 == null) {
            return null;
        }
        if (jsonToken == null) {
            return JsonToken.END_DOCUMENT;
        }
        switch (AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonToken.ordinal()]) {
            case 1:
                return JsonToken.START_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.START_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
                return JsonToken.FIELD_NAME;
            case 6:
                return JsonToken.STRING;
            case 7:
            case 8:
                return JsonToken.NUMBER;
            case 9:
            case 10:
                return JsonToken.BOOLEAN;
            case 11:
                return JsonToken.NULL;
            default:
                throw LOGGER.logExceptionAsError(new IllegalStateException("Unsupported token type: '" + jsonToken + "'."));
        }
    }

    /* JADX INFO: renamed from: com.azure.core.implementation.jackson.JacksonJsonReader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$core$JsonToken;

        static {
            int[] iArr = new int[com.fasterxml.jackson.core.JsonToken.values().length];
            $SwitchMap$com$fasterxml$jackson$core$JsonToken = iArr;
            try {
                iArr[com.fasterxml.jackson.core.JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[com.fasterxml.jackson.core.JsonToken.END_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[com.fasterxml.jackson.core.JsonToken.START_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[com.fasterxml.jackson.core.JsonToken.END_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[com.fasterxml.jackson.core.JsonToken.FIELD_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[com.fasterxml.jackson.core.JsonToken.VALUE_STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[com.fasterxml.jackson.core.JsonToken.VALUE_TRUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[com.fasterxml.jackson.core.JsonToken.VALUE_FALSE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[com.fasterxml.jackson.core.JsonToken.VALUE_NULL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }
}
