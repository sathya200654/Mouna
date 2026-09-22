package com.azure.core.implementation.jackson;

import com.azure.core.implementation.StringBuilderWriter;
import com.azure.core.util.BinaryData;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class BinaryDataDeserializer extends JsonDeserializer<BinaryData> {
    BinaryDataDeserializer() {
    }

    public static SimpleModule getModule() {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(BinaryData.class, new BinaryDataDeserializer());
        return simpleModule;
    }

    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public BinaryData m1193deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
        if (jsonTokenCurrentToken == JsonToken.VALUE_NULL) {
            return null;
        }
        if (jsonTokenCurrentToken.isStructStart()) {
            return BinaryData.fromString(bufferStruct(jsonParser));
        }
        return BinaryData.fromString(jsonParser.getText());
    }

    private static String bufferStruct(JsonParser jsonParser) throws IOException {
        StringBuilder sb = new StringBuilder(128);
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter(sb);
        sb.append(jsonParser.currentToken() == JsonToken.START_OBJECT ? '{' : '[');
        JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
        int i = 1;
        while (i > 0) {
            JsonToken jsonTokenNextToken = jsonParser.nextToken();
            if (!jsonTokenCurrentToken.isStructStart() && !jsonTokenNextToken.isStructEnd() && jsonTokenCurrentToken != JsonToken.FIELD_NAME) {
                sb.append(',');
            }
            switch (AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonTokenNextToken.ordinal()]) {
                case 1:
                case 2:
                    i++;
                    sb.append(jsonTokenNextToken == JsonToken.START_OBJECT ? '{' : '[');
                    break;
                case 3:
                case 4:
                    i--;
                    sb.append(jsonTokenNextToken == JsonToken.END_OBJECT ? '}' : ']');
                    break;
                case 5:
                case 6:
                    sb.append("\"");
                    jsonParser.getText(stringBuilderWriter);
                    sb.append(jsonTokenNextToken == JsonToken.FIELD_NAME ? "\":" : "\"");
                    break;
                default:
                    jsonParser.getText(stringBuilderWriter);
                    break;
            }
            jsonTokenCurrentToken = jsonTokenNextToken;
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: com.azure.core.implementation.jackson.BinaryDataDeserializer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$core$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$fasterxml$jackson$core$JsonToken = iArr;
            try {
                iArr[JsonToken.START_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.START_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.END_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.FIELD_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
