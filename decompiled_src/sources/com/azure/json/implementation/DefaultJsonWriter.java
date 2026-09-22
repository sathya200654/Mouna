package com.azure.json.implementation;

import com.azure.json.JsonOptions;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriteContext;
import com.azure.json.JsonWriter;
import com.azure.json.implementation.jackson.core.JsonFactory;
import com.azure.json.implementation.jackson.core.JsonGenerator;
import com.azure.json.implementation.jackson.core.json.JsonWriteFeature;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class DefaultJsonWriter extends JsonWriter {
    private static final JsonFactory FACTORY = JsonFactory.builder().build();
    private JsonWriteContext context = JsonWriteContext.ROOT;
    private final JsonGenerator generator;

    public static JsonWriter toStream(OutputStream outputStream, JsonOptions jsonOptions) throws IOException {
        Objects.requireNonNull(outputStream, "'json' cannot be null.");
        return new DefaultJsonWriter(FACTORY.createGenerator(outputStream), jsonOptions);
    }

    public static JsonWriter toWriter(Writer writer, JsonOptions jsonOptions) throws IOException {
        Objects.requireNonNull(writer, "'json' cannot be null.");
        return new DefaultJsonWriter(FACTORY.createGenerator(writer), jsonOptions);
    }

    private DefaultJsonWriter(JsonGenerator jsonGenerator, JsonOptions jsonOptions) {
        this.generator = jsonGenerator;
        jsonGenerator.configure(JsonWriteFeature.WRITE_NAN_AS_STRINGS.mappedFeature(), jsonOptions.isNonNumericNumbersSupported());
    }

    @Override // com.azure.json.JsonWriter
    public JsonWriter flush() throws IOException {
        this.generator.flush();
        return this;
    }

    @Override // com.azure.json.JsonWriter
    public JsonWriter writeStartObject() throws IOException {
        this.context.validateToken(JsonToken.START_OBJECT);
        this.generator.writeStartObject();
        this.context = this.context.updateContext(JsonToken.START_OBJECT);
        return this;
    }

    @Override // com.azure.json.JsonWriter
    public JsonWriter writeEndObject() throws IOException {
        this.context.validateToken(JsonToken.END_OBJECT);
        this.generator.writeEndObject();
        this.context = this.context.updateContext(JsonToken.END_OBJECT);
        return this;
    }

    @Override // com.azure.json.JsonWriter
    public JsonWriter writeStartArray() throws IOException {
        this.context.validateToken(JsonToken.START_ARRAY);
        this.generator.writeStartArray();
        this.context = this.context.updateContext(JsonToken.START_ARRAY);
        return this;
    }

    @Override // com.azure.json.JsonWriter
    public JsonWriter writeEndArray() throws IOException {
        this.context.validateToken(JsonToken.END_ARRAY);
        this.generator.writeEndArray();
        this.context = this.context.updateContext(JsonToken.END_ARRAY);
        return this;
    }

    @Override // com.azure.json.JsonWriter
    public JsonWriter writeFieldName(String str) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        this.context.validateToken(JsonToken.FIELD_NAME);
        this.generator.writeFieldName(str);
        this.context = this.context.updateContext(JsonToken.FIELD_NAME);
        return this;
    }

    @Override // com.azure.json.JsonWriter
    public JsonWriter writeBinary(byte[] bArr) throws IOException {
        this.context.validateToken(JsonToken.STRING);
        if (bArr == null) {
            this.generator.writeNull();
        } else {
            this.generator.writeBinary(bArr);
        }
        this.context = this.context.updateContext(JsonToken.STRING);
        return this;
    }

    @Override // com.azure.json.JsonWriter
    public JsonWriter writeBoolean(boolean z) throws IOException {
        this.context.validateToken(JsonToken.BOOLEAN);
        this.generator.writeBoolean(z);
        this.context = this.context.updateContext(JsonToken.BOOLEAN);
        return this;
    }

    @Override // com.azure.json.JsonWriter
    public JsonWriter writeDouble(double d) throws IOException {
        this.context.validateToken(JsonToken.NUMBER);
        this.generator.writeNumber(d);
        this.context = this.context.updateContext(JsonToken.NUMBER);
        return this;
    }

    @Override // com.azure.json.JsonWriter
    public JsonWriter writeFloat(float f) throws IOException {
        this.context.validateToken(JsonToken.NUMBER);
        this.generator.writeNumber(f);
        this.context = this.context.updateContext(JsonToken.NUMBER);
        return this;
    }

    @Override // com.azure.json.JsonWriter
    public JsonWriter writeInt(int i) throws IOException {
        this.context.validateToken(JsonToken.NUMBER);
        this.generator.writeNumber(i);
        this.context = this.context.updateContext(JsonToken.NUMBER);
        return this;
    }

    @Override // com.azure.json.JsonWriter
    public JsonWriter writeLong(long j) throws IOException {
        this.context.validateToken(JsonToken.NUMBER);
        this.generator.writeNumber(j);
        this.context = this.context.updateContext(JsonToken.NUMBER);
        return this;
    }

    @Override // com.azure.json.JsonWriter
    public JsonWriter writeNull() throws IOException {
        this.context.validateToken(JsonToken.NULL);
        this.generator.writeNull();
        this.context = this.context.updateContext(JsonToken.NULL);
        return this;
    }

    @Override // com.azure.json.JsonWriter
    public JsonWriter writeString(String str) throws IOException {
        this.context.validateToken(JsonToken.STRING);
        this.generator.writeString(str);
        this.context = this.context.updateContext(JsonToken.STRING);
        return this;
    }

    @Override // com.azure.json.JsonWriter
    public JsonWriter writeRawValue(String str) throws IOException {
        Objects.requireNonNull(str, "'value' cannot be null.");
        this.context.validateToken(JsonToken.STRING);
        this.generator.writeRawValue(str);
        this.context = this.context.updateContext(JsonToken.STRING);
        return this;
    }

    @Override // com.azure.json.JsonWriter
    public JsonWriteContext getWriteContext() {
        return this.context;
    }

    @Override // com.azure.json.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.context != JsonWriteContext.COMPLETED) {
            throw new IllegalStateException("Writing of the JSON object must be completed before the writer can be closed. Current writing state is '" + this.context.getWriteState() + "'.");
        }
        this.generator.flush();
        this.generator.close();
    }
}
