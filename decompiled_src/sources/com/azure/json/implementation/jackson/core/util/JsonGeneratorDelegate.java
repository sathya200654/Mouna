package com.azure.json.implementation.jackson.core.util;

import com.azure.json.implementation.jackson.core.Base64Variant;
import com.azure.json.implementation.jackson.core.FormatSchema;
import com.azure.json.implementation.jackson.core.JsonGenerator;
import com.azure.json.implementation.jackson.core.JsonParser;
import com.azure.json.implementation.jackson.core.JsonStreamContext;
import com.azure.json.implementation.jackson.core.ObjectCodec;
import com.azure.json.implementation.jackson.core.SerializableString;
import com.azure.json.implementation.jackson.core.StreamWriteCapability;
import com.azure.json.implementation.jackson.core.TreeNode;
import com.azure.json.implementation.jackson.core.Version;
import com.azure.json.implementation.jackson.core.io.CharacterEscapes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class JsonGeneratorDelegate extends JsonGenerator {
    protected JsonGenerator delegate;
    protected boolean delegateCopyMethods;

    public JsonGeneratorDelegate(JsonGenerator jsonGenerator, boolean z) {
        this.delegate = jsonGenerator;
        this.delegateCopyMethods = z;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public ObjectCodec getCodec() {
        return this.delegate.getCodec();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public JsonGenerator setCodec(ObjectCodec objectCodec) {
        this.delegate.setCodec(objectCodec);
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void setSchema(FormatSchema formatSchema) {
        this.delegate.setSchema(formatSchema);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public FormatSchema getSchema() {
        return this.delegate.getSchema();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator, com.azure.json.implementation.jackson.core.Versioned
    public Version version() {
        return this.delegate.version();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public Object getOutputTarget() {
        return this.delegate.getOutputTarget();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public int getOutputBuffered() {
        return this.delegate.getOutputBuffered();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void assignCurrentValue(Object obj) {
        this.delegate.assignCurrentValue(obj);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public Object currentValue() {
        return this.delegate.currentValue();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void setCurrentValue(Object obj) {
        this.delegate.setCurrentValue(obj);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public Object getCurrentValue() {
        return this.delegate.getCurrentValue();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public boolean canUseSchema(FormatSchema formatSchema) {
        return this.delegate.canUseSchema(formatSchema);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public boolean canWriteTypeId() {
        return this.delegate.canWriteTypeId();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public boolean canWriteObjectId() {
        return this.delegate.canWriteObjectId();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public boolean canWriteBinaryNatively() {
        return this.delegate.canWriteBinaryNatively();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public boolean canOmitFields() {
        return this.delegate.canOmitFields();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public boolean canWriteFormattedNumbers() {
        return this.delegate.canWriteFormattedNumbers();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public JacksonFeatureSet<StreamWriteCapability> getWriteCapabilities() {
        return this.delegate.getWriteCapabilities();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public JsonGenerator enable(JsonGenerator.Feature feature) {
        this.delegate.enable(feature);
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public JsonGenerator disable(JsonGenerator.Feature feature) {
        this.delegate.disable(feature);
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public boolean isEnabled(JsonGenerator.Feature feature) {
        return this.delegate.isEnabled(feature);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public int getFeatureMask() {
        return this.delegate.getFeatureMask();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    @Deprecated
    public JsonGenerator setFeatureMask(int i) {
        this.delegate.setFeatureMask(i);
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public JsonGenerator overrideStdFeatures(int i, int i2) {
        this.delegate.overrideStdFeatures(i, i2);
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public JsonGenerator overrideFormatFeatures(int i, int i2) {
        this.delegate.overrideFormatFeatures(i, i2);
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public JsonGenerator setHighestNonEscapedChar(int i) {
        this.delegate.setHighestNonEscapedChar(i);
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public int getHighestEscapedChar() {
        return this.delegate.getHighestEscapedChar();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public CharacterEscapes getCharacterEscapes() {
        return this.delegate.getCharacterEscapes();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public JsonGenerator setCharacterEscapes(CharacterEscapes characterEscapes) {
        this.delegate.setCharacterEscapes(characterEscapes);
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public JsonGenerator setRootValueSeparator(SerializableString serializableString) {
        this.delegate.setRootValueSeparator(serializableString);
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeStartArray() throws IOException {
        this.delegate.writeStartArray();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeStartArray(int i) throws IOException {
        this.delegate.writeStartArray(i);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeStartArray(Object obj) throws IOException {
        this.delegate.writeStartArray(obj);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeStartArray(Object obj, int i) throws IOException {
        this.delegate.writeStartArray(obj, i);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeEndArray() throws IOException {
        this.delegate.writeEndArray();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeStartObject() throws IOException {
        this.delegate.writeStartObject();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeStartObject(Object obj) throws IOException {
        this.delegate.writeStartObject(obj);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeStartObject(Object obj, int i) throws IOException {
        this.delegate.writeStartObject(obj, i);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeEndObject() throws IOException {
        this.delegate.writeEndObject();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeFieldName(String str) throws IOException {
        this.delegate.writeFieldName(str);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeFieldName(SerializableString serializableString) throws IOException {
        this.delegate.writeFieldName(serializableString);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeFieldId(long j) throws IOException {
        this.delegate.writeFieldId(j);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeArray(int[] iArr, int i, int i2) throws IOException {
        this.delegate.writeArray(iArr, i, i2);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeArray(long[] jArr, int i, int i2) throws IOException {
        this.delegate.writeArray(jArr, i, i2);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeArray(double[] dArr, int i, int i2) throws IOException {
        this.delegate.writeArray(dArr, i, i2);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeArray(String[] strArr, int i, int i2) throws IOException {
        this.delegate.writeArray(strArr, i, i2);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeString(String str) throws IOException {
        this.delegate.writeString(str);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeString(Reader reader, int i) throws IOException {
        this.delegate.writeString(reader, i);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeString(char[] cArr, int i, int i2) throws IOException {
        this.delegate.writeString(cArr, i, i2);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeString(SerializableString serializableString) throws IOException {
        this.delegate.writeString(serializableString);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i, int i2) throws IOException {
        this.delegate.writeRawUTF8String(bArr, i, i2);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeUTF8String(byte[] bArr, int i, int i2) throws IOException {
        this.delegate.writeUTF8String(bArr, i, i2);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeRaw(String str) throws IOException {
        this.delegate.writeRaw(str);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeRaw(String str, int i, int i2) throws IOException {
        this.delegate.writeRaw(str, i, i2);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeRaw(SerializableString serializableString) throws IOException {
        this.delegate.writeRaw(serializableString);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeRaw(char[] cArr, int i, int i2) throws IOException {
        this.delegate.writeRaw(cArr, i, i2);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeRaw(char c) throws IOException {
        this.delegate.writeRaw(c);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeRawValue(String str) throws IOException {
        this.delegate.writeRawValue(str);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeRawValue(String str, int i, int i2) throws IOException {
        this.delegate.writeRawValue(str, i, i2);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeRawValue(char[] cArr, int i, int i2) throws IOException {
        this.delegate.writeRawValue(cArr, i, i2);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        this.delegate.writeBinary(base64Variant, bArr, i, i2);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException {
        return this.delegate.writeBinary(base64Variant, inputStream, i);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeNumber(short s) throws IOException {
        this.delegate.writeNumber(s);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeNumber(int i) throws IOException {
        this.delegate.writeNumber(i);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeNumber(long j) throws IOException {
        this.delegate.writeNumber(j);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws IOException {
        this.delegate.writeNumber(bigInteger);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeNumber(double d) throws IOException {
        this.delegate.writeNumber(d);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeNumber(float f) throws IOException {
        this.delegate.writeNumber(f);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) throws IOException {
        this.delegate.writeNumber(bigDecimal);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeNumber(String str) throws UnsupportedOperationException, IOException {
        this.delegate.writeNumber(str);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeNumber(char[] cArr, int i, int i2) throws UnsupportedOperationException, IOException {
        this.delegate.writeNumber(cArr, i, i2);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeBoolean(boolean z) throws IOException {
        this.delegate.writeBoolean(z);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeNull() throws IOException {
        this.delegate.writeNull();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeOmittedField(String str) throws IOException {
        this.delegate.writeOmittedField(str);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeObjectId(Object obj) throws IOException {
        this.delegate.writeObjectId(obj);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeObjectRef(Object obj) throws IOException {
        this.delegate.writeObjectRef(obj);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeTypeId(Object obj) throws IOException {
        this.delegate.writeTypeId(obj);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeEmbeddedObject(Object obj) throws IOException {
        this.delegate.writeEmbeddedObject(obj);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeObject(Object obj) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.writeObject(obj);
            return;
        }
        if (obj == null) {
            writeNull();
            return;
        }
        ObjectCodec codec = getCodec();
        if (codec != null) {
            codec.writeValue(this, obj);
        } else {
            _writeSimpleObject(obj);
        }
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void writeTree(TreeNode treeNode) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.writeTree(treeNode);
            return;
        }
        if (treeNode == null) {
            writeNull();
            return;
        }
        ObjectCodec codec = getCodec();
        if (codec == null) {
            throw new IllegalStateException("No ObjectCodec defined");
        }
        codec.writeTree(this, treeNode);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void copyCurrentEvent(JsonParser jsonParser) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.copyCurrentEvent(jsonParser);
        } else {
            super.copyCurrentEvent(jsonParser);
        }
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public void copyCurrentStructure(JsonParser jsonParser) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.copyCurrentStructure(jsonParser);
        } else {
            super.copyCurrentStructure(jsonParser);
        }
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public JsonStreamContext getOutputContext() {
        return this.delegate.getOutputContext();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public boolean isClosed() {
        return this.delegate.isClosed();
    }

    @Deprecated
    public JsonGenerator getDelegate() {
        return this.delegate;
    }
}
