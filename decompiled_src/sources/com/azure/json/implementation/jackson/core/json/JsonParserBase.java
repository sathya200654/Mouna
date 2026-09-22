package com.azure.json.implementation.jackson.core.json;

import com.azure.json.implementation.jackson.core.JsonLocation;
import com.azure.json.implementation.jackson.core.JsonParser;
import com.azure.json.implementation.jackson.core.ObjectCodec;
import com.azure.json.implementation.jackson.core.StreamReadCapability;
import com.azure.json.implementation.jackson.core.base.ParserBase;
import com.azure.json.implementation.jackson.core.io.CharTypes;
import com.azure.json.implementation.jackson.core.io.IOContext;
import com.azure.json.implementation.jackson.core.util.JacksonFeatureSet;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class JsonParserBase extends ParserBase {
    protected ObjectCodec _objectCodec;
    protected static final int FEAT_MASK_TRAILING_COMMA = JsonParser.Feature.ALLOW_TRAILING_COMMA.getMask();
    protected static final int FEAT_MASK_LEADING_ZEROS = JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS.getMask();
    protected static final int FEAT_MASK_NON_NUM_NUMBERS = JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS.getMask();
    protected static final int FEAT_MASK_ALLOW_MISSING = JsonParser.Feature.ALLOW_MISSING_VALUES.getMask();
    protected static final int FEAT_MASK_ALLOW_SINGLE_QUOTES = JsonParser.Feature.ALLOW_SINGLE_QUOTES.getMask();
    protected static final int FEAT_MASK_ALLOW_UNQUOTED_NAMES = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.getMask();
    protected static final int FEAT_MASK_ALLOW_JAVA_COMMENTS = JsonParser.Feature.ALLOW_COMMENTS.getMask();
    protected static final int FEAT_MASK_ALLOW_YAML_COMMENTS = JsonParser.Feature.ALLOW_YAML_COMMENTS.getMask();
    protected static final int[] INPUT_CODES_LATIN1 = CharTypes.getInputCodeLatin1();
    protected static final int[] INPUT_CODES_UTF8 = CharTypes.getInputCodeUtf8();

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public abstract JsonLocation currentLocation();

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public abstract JsonLocation currentTokenLocation();

    protected JsonParserBase(IOContext iOContext, int i, ObjectCodec objectCodec) {
        super(iOContext, i);
        this._objectCodec = objectCodec;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public void setCodec(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonParser
    public final JacksonFeatureSet<StreamReadCapability> getReadCapabilities() {
        return JSON_READ_CAPABILITIES;
    }

    @Override // com.azure.json.implementation.jackson.core.base.ParserBase, com.azure.json.implementation.jackson.core.JsonParser
    @Deprecated
    public final JsonLocation getCurrentLocation() {
        return currentLocation();
    }

    @Override // com.azure.json.implementation.jackson.core.base.ParserBase, com.azure.json.implementation.jackson.core.JsonParser
    @Deprecated
    public final JsonLocation getTokenLocation() {
        return currentTokenLocation();
    }
}
