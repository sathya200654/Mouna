package com.azure.json.implementation.jackson.core.util;

import com.azure.json.implementation.jackson.core.Base64Variant;
import com.azure.json.implementation.jackson.core.FormatSchema;
import com.azure.json.implementation.jackson.core.JsonLocation;
import com.azure.json.implementation.jackson.core.JsonParser;
import com.azure.json.implementation.jackson.core.JsonStreamContext;
import com.azure.json.implementation.jackson.core.JsonToken;
import com.azure.json.implementation.jackson.core.ObjectCodec;
import com.azure.json.implementation.jackson.core.StreamReadCapability;
import com.azure.json.implementation.jackson.core.Version;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class JsonParserDelegate extends JsonParser {
    protected JsonParser delegate;

    public JsonParserDelegate(JsonParser jsonParser) {
        this.delegate = jsonParser;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public void setCodec(ObjectCodec objectCodec) {
        this.delegate.setCodec(objectCodec);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public ObjectCodec getCodec() {
        return this.delegate.getCodec();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JsonParser enable(JsonParser.Feature feature) {
        this.delegate.enable(feature);
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JsonParser disable(JsonParser.Feature feature) {
        this.delegate.disable(feature);
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean isEnabled(JsonParser.Feature feature) {
        return this.delegate.isEnabled(feature);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public int getFeatureMask() {
        return this.delegate.getFeatureMask();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    @Deprecated
    public JsonParser setFeatureMask(int i) {
        this.delegate.setFeatureMask(i);
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JsonParser overrideStdFeatures(int i, int i2) {
        this.delegate.overrideStdFeatures(i, i2);
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JsonParser overrideFormatFeatures(int i, int i2) {
        this.delegate.overrideFormatFeatures(i, i2);
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public FormatSchema getSchema() {
        return this.delegate.getSchema();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public void setSchema(FormatSchema formatSchema) {
        this.delegate.setSchema(formatSchema);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean canUseSchema(FormatSchema formatSchema) {
        return this.delegate.canUseSchema(formatSchema);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser, com.azure.json.implementation.jackson.core.Versioned
    public Version version() {
        return this.delegate.version();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public Object getInputSource() {
        return this.delegate.getInputSource();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean requiresCustomCodec() {
        return this.delegate.requiresCustomCodec();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JacksonFeatureSet<StreamReadCapability> getReadCapabilities() {
        return this.delegate.getReadCapabilities();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean isClosed() {
        return this.delegate.isClosed();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public void clearCurrentToken() {
        this.delegate.clearCurrentToken();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JsonToken getLastClearedToken() {
        return this.delegate.getLastClearedToken();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public void overrideCurrentName(String str) {
        this.delegate.overrideCurrentName(str);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public void assignCurrentValue(Object obj) {
        this.delegate.assignCurrentValue(obj);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public void setCurrentValue(Object obj) {
        this.delegate.setCurrentValue(obj);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JsonStreamContext getParsingContext() {
        return this.delegate.getParsingContext();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JsonToken currentToken() {
        return this.delegate.currentToken();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public int currentTokenId() {
        return this.delegate.currentTokenId();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public String currentName() throws IOException {
        return this.delegate.currentName();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public Object currentValue() {
        return this.delegate.currentValue();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JsonLocation currentLocation() {
        return this.delegate.getCurrentLocation();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JsonLocation currentTokenLocation() {
        return this.delegate.getTokenLocation();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JsonToken getCurrentToken() {
        return this.delegate.getCurrentToken();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    @Deprecated
    public int getCurrentTokenId() {
        return this.delegate.getCurrentTokenId();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public String getCurrentName() throws IOException {
        return this.delegate.getCurrentName();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public Object getCurrentValue() {
        return this.delegate.getCurrentValue();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JsonLocation getCurrentLocation() {
        return this.delegate.getCurrentLocation();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JsonLocation getTokenLocation() {
        return this.delegate.getTokenLocation();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean hasCurrentToken() {
        return this.delegate.hasCurrentToken();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean hasTokenId(int i) {
        return this.delegate.hasTokenId(i);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean hasToken(JsonToken jsonToken) {
        return this.delegate.hasToken(jsonToken);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean isExpectedStartArrayToken() {
        return this.delegate.isExpectedStartArrayToken();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean isExpectedStartObjectToken() {
        return this.delegate.isExpectedStartObjectToken();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean isExpectedNumberIntToken() {
        return this.delegate.isExpectedNumberIntToken();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean isNaN() throws IOException {
        return this.delegate.isNaN();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public String getText() throws IOException {
        return this.delegate.getText();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean hasTextCharacters() {
        return this.delegate.hasTextCharacters();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public char[] getTextCharacters() throws IOException {
        return this.delegate.getTextCharacters();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public int getTextLength() throws IOException {
        return this.delegate.getTextLength();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public int getTextOffset() throws IOException {
        return this.delegate.getTextOffset();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public int getText(Writer writer) throws UnsupportedOperationException, IOException {
        return this.delegate.getText(writer);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public BigInteger getBigIntegerValue() throws IOException {
        return this.delegate.getBigIntegerValue();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean getBooleanValue() throws IOException {
        return this.delegate.getBooleanValue();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public byte getByteValue() throws IOException {
        return this.delegate.getByteValue();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public short getShortValue() throws IOException {
        return this.delegate.getShortValue();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public BigDecimal getDecimalValue() throws IOException {
        return this.delegate.getDecimalValue();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public double getDoubleValue() throws IOException {
        return this.delegate.getDoubleValue();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public float getFloatValue() throws IOException {
        return this.delegate.getFloatValue();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public int getIntValue() throws IOException {
        return this.delegate.getIntValue();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public long getLongValue() throws IOException {
        return this.delegate.getLongValue();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JsonParser.NumberType getNumberType() throws IOException {
        return this.delegate.getNumberType();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public Number getNumberValue() throws IOException {
        return this.delegate.getNumberValue();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public Number getNumberValueExact() throws IOException {
        return this.delegate.getNumberValueExact();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public int getValueAsInt() throws IOException {
        return this.delegate.getValueAsInt();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public int getValueAsInt(int i) throws IOException {
        return this.delegate.getValueAsInt(i);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public long getValueAsLong() throws IOException {
        return this.delegate.getValueAsLong();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public long getValueAsLong(long j) throws IOException {
        return this.delegate.getValueAsLong(j);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public double getValueAsDouble() throws IOException {
        return this.delegate.getValueAsDouble();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public double getValueAsDouble(double d) throws IOException {
        return this.delegate.getValueAsDouble(d);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean getValueAsBoolean() throws IOException {
        return this.delegate.getValueAsBoolean();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean getValueAsBoolean(boolean z) throws IOException {
        return this.delegate.getValueAsBoolean(z);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public String getValueAsString() throws IOException {
        return this.delegate.getValueAsString();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public String getValueAsString(String str) throws IOException {
        return this.delegate.getValueAsString(str);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public Object getEmbeddedObject() throws IOException {
        return this.delegate.getEmbeddedObject();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException {
        return this.delegate.getBinaryValue(base64Variant);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        return this.delegate.readBinaryValue(base64Variant, outputStream);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JsonToken nextToken() throws IOException {
        return this.delegate.nextToken();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JsonToken nextValue() throws IOException {
        return this.delegate.nextValue();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public void finishToken() throws IOException {
        this.delegate.finishToken();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public JsonParser skipChildren() throws IOException {
        this.delegate.skipChildren();
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean canReadObjectId() {
        return this.delegate.canReadObjectId();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public boolean canReadTypeId() {
        return this.delegate.canReadTypeId();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public Object getObjectId() throws IOException {
        return this.delegate.getObjectId();
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public Object getTypeId() throws IOException {
        return this.delegate.getTypeId();
    }
}
