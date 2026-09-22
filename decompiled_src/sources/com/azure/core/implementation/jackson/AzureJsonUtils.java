package com.azure.core.implementation.jackson;

import com.azure.json.JsonOptions;
import com.azure.json.JsonReader;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class AzureJsonUtils {
    private static final JsonFactory FACTORY = JsonFactory.builder().build();

    static JsonReader createReader(byte[] bArr, JsonOptions jsonOptions) throws IOException {
        Objects.requireNonNull(bArr, "JSON source cannot be null when creating a JsonReader.");
        return new JacksonJsonReader(configureParser(FACTORY.createParser(bArr), jsonOptions), bArr, null, true, jsonOptions);
    }

    static JsonReader createReader(String str, JsonOptions jsonOptions) throws IOException {
        Objects.requireNonNull(str, "JSON source cannot be null when creating a JsonReader.");
        return new JacksonJsonReader(configureParser(FACTORY.createParser(str), jsonOptions), null, str, true, jsonOptions);
    }

    private static JsonParser configureParser(JsonParser jsonParser, JsonOptions jsonOptions) {
        boolean z = false;
        boolean z2 = jsonOptions == null || jsonOptions.isNonNumericNumbersSupported();
        if (jsonOptions != null && jsonOptions.isJsoncSupported()) {
            z = true;
        }
        return jsonParser.configure(JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS.mappedFeature(), z2).configure(JsonParser.Feature.ALLOW_COMMENTS, z);
    }

    static JsonReader createReader(JsonParser jsonParser) {
        return new JacksonJsonReader(jsonParser, null, null, false, null);
    }

    private AzureJsonUtils() {
    }
}
