package com.azure.json.implementation;

import com.azure.json.JsonOptions;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.implementation.jackson.core.JsonFactory;
import com.azure.json.implementation.jackson.core.JsonParser;
import com.azure.json.implementation.jackson.core.json.JsonReadFeature;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class DefaultJsonReader extends JsonReader {
    private static final JsonFactory FACTORY = JsonFactory.builder().build();
    private JsonToken currentToken;
    private final byte[] jsonBytes;
    private final String jsonString;
    private final boolean jsoncSupported;
    private final boolean nonNumericNumbersSupported;
    private final JsonParser parser;
    private final boolean resetSupported;

    public static JsonReader fromBytes(byte[] bArr, JsonOptions jsonOptions) throws IOException {
        return new DefaultJsonReader(FACTORY.createParser(bArr), true, bArr, null, jsonOptions);
    }

    public static JsonReader fromString(String str, JsonOptions jsonOptions) throws IOException {
        return new DefaultJsonReader(FACTORY.createParser(str), true, null, str, jsonOptions);
    }

    public static JsonReader fromStream(InputStream inputStream, JsonOptions jsonOptions) throws IOException {
        return new DefaultJsonReader(FACTORY.createParser(inputStream), inputStream.markSupported(), null, null, jsonOptions);
    }

    public static JsonReader fromReader(Reader reader, JsonOptions jsonOptions) throws IOException {
        return new DefaultJsonReader(FACTORY.createParser(reader), reader.markSupported(), null, null, jsonOptions);
    }

    private DefaultJsonReader(JsonParser jsonParser, boolean z, byte[] bArr, String str, JsonOptions jsonOptions) {
        this(jsonParser, z, bArr, str, jsonOptions.isNonNumericNumbersSupported(), jsonOptions.isJsoncSupported());
    }

    private DefaultJsonReader(JsonParser jsonParser, boolean z, byte[] bArr, String str, boolean z2, boolean z3) {
        this.parser = jsonParser;
        this.resetSupported = z;
        jsonParser.configure(JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS.mappedFeature(), z2);
        jsonParser.configure(JsonParser.Feature.ALLOW_COMMENTS, z3);
        this.jsonBytes = bArr;
        this.jsonString = str;
        this.nonNumericNumbersSupported = z2;
        this.jsoncSupported = z3;
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
    public double getDouble() throws IOException {
        return this.parser.getDoubleValue();
    }

    @Override // com.azure.json.JsonReader
    public float getFloat() throws IOException {
        return this.parser.getFloatValue();
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
            String remainingFieldsAsJsonObject = readRemainingFieldsAsJsonObject();
            return new DefaultJsonReader(FACTORY.createParser(remainingFieldsAsJsonObject), true, null, remainingFieldsAsJsonObject, this.nonNumericNumbersSupported, this.jsoncSupported);
        }
        throw new IllegalStateException("Cannot buffer a JSON object from a non-object, non-field name starting location. Starting location: " + currentToken());
    }

    @Override // com.azure.json.JsonReader
    public boolean isResetSupported() {
        return this.resetSupported;
    }

    @Override // com.azure.json.JsonReader
    public JsonReader reset() throws IOException {
        if (!this.resetSupported) {
            throw new IllegalStateException("'reset' isn't supported by this JsonReader.");
        }
        byte[] bArr = this.jsonBytes;
        if (bArr != null) {
            return new DefaultJsonReader(FACTORY.createParser(bArr), true, this.jsonBytes, null, this.nonNumericNumbersSupported, this.jsoncSupported);
        }
        return new DefaultJsonReader(FACTORY.createParser(this.jsonString), true, null, this.jsonString, this.nonNumericNumbersSupported, this.jsoncSupported);
    }

    @Override // com.azure.json.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.parser.close();
    }

    private static JsonToken mapToken(com.azure.json.implementation.jackson.core.JsonToken jsonToken, JsonToken jsonToken2) {
        if (jsonToken == null && jsonToken2 == null) {
            return null;
        }
        if (jsonToken == null) {
            return JsonToken.END_DOCUMENT;
        }
        switch (AnonymousClass1.$SwitchMap$com$azure$json$implementation$jackson$core$JsonToken[jsonToken.ordinal()]) {
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
                throw new IllegalStateException("Unsupported token type: '" + jsonToken + "'.");
        }
    }

    /* JADX INFO: renamed from: com.azure.json.implementation.DefaultJsonReader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$azure$json$implementation$jackson$core$JsonToken;

        static {
            int[] iArr = new int[com.azure.json.implementation.jackson.core.JsonToken.values().length];
            $SwitchMap$com$azure$json$implementation$jackson$core$JsonToken = iArr;
            try {
                iArr[com.azure.json.implementation.jackson.core.JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$azure$json$implementation$jackson$core$JsonToken[com.azure.json.implementation.jackson.core.JsonToken.END_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$azure$json$implementation$jackson$core$JsonToken[com.azure.json.implementation.jackson.core.JsonToken.START_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$azure$json$implementation$jackson$core$JsonToken[com.azure.json.implementation.jackson.core.JsonToken.END_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$azure$json$implementation$jackson$core$JsonToken[com.azure.json.implementation.jackson.core.JsonToken.FIELD_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$azure$json$implementation$jackson$core$JsonToken[com.azure.json.implementation.jackson.core.JsonToken.VALUE_STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$azure$json$implementation$jackson$core$JsonToken[com.azure.json.implementation.jackson.core.JsonToken.VALUE_NUMBER_INT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$azure$json$implementation$jackson$core$JsonToken[com.azure.json.implementation.jackson.core.JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$azure$json$implementation$jackson$core$JsonToken[com.azure.json.implementation.jackson.core.JsonToken.VALUE_TRUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$azure$json$implementation$jackson$core$JsonToken[com.azure.json.implementation.jackson.core.JsonToken.VALUE_FALSE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$azure$json$implementation$jackson$core$JsonToken[com.azure.json.implementation.jackson.core.JsonToken.VALUE_NULL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }
}
