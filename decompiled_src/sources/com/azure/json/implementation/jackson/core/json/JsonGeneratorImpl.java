package com.azure.json.implementation.jackson.core.json;

import com.azure.json.implementation.jackson.core.JsonGenerator;
import com.azure.json.implementation.jackson.core.ObjectCodec;
import com.azure.json.implementation.jackson.core.SerializableString;
import com.azure.json.implementation.jackson.core.StreamWriteCapability;
import com.azure.json.implementation.jackson.core.Version;
import com.azure.json.implementation.jackson.core.base.GeneratorBase;
import com.azure.json.implementation.jackson.core.io.CharTypes;
import com.azure.json.implementation.jackson.core.io.CharacterEscapes;
import com.azure.json.implementation.jackson.core.io.IOContext;
import com.azure.json.implementation.jackson.core.io.SerializedString;
import com.azure.json.implementation.jackson.core.util.JacksonFeatureSet;
import com.azure.json.implementation.jackson.core.util.VersionUtil;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class JsonGeneratorImpl extends GeneratorBase {
    protected boolean _cfgUnqNames;
    protected CharacterEscapes _characterEscapes;
    protected final IOContext _ioContext;
    protected int _maximumNonEscapedChar;
    protected int[] _outputEscapes;
    protected SerializableString _rootValueSeparator;
    protected static final int[] sOutputEscapes = CharTypes.get7BitOutputEscapes();
    protected static final JacksonFeatureSet<StreamWriteCapability> JSON_WRITE_CAPABILITIES = DEFAULT_TEXTUAL_WRITE_CAPABILITIES;

    public JsonGeneratorImpl(IOContext iOContext, int i, ObjectCodec objectCodec) {
        super(i, objectCodec);
        this._outputEscapes = sOutputEscapes;
        this._rootValueSeparator = new SerializedString(" ");
        this._ioContext = iOContext;
        if (JsonGenerator.Feature.ESCAPE_NON_ASCII.enabledIn(i)) {
            this._maximumNonEscapedChar = 127;
        }
        this._cfgUnqNames = !JsonGenerator.Feature.QUOTE_FIELD_NAMES.enabledIn(i);
    }

    @Override // com.azure.json.implementation.jackson.core.base.GeneratorBase, com.azure.json.implementation.jackson.core.JsonGenerator, com.azure.json.implementation.jackson.core.Versioned
    public Version version() {
        return VersionUtil.versionFor(getClass());
    }

    @Override // com.azure.json.implementation.jackson.core.base.GeneratorBase, com.azure.json.implementation.jackson.core.JsonGenerator
    public JsonGenerator enable(JsonGenerator.Feature feature) {
        super.enable(feature);
        if (feature == JsonGenerator.Feature.QUOTE_FIELD_NAMES) {
            this._cfgUnqNames = false;
        }
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.base.GeneratorBase, com.azure.json.implementation.jackson.core.JsonGenerator
    public JsonGenerator disable(JsonGenerator.Feature feature) {
        super.disable(feature);
        if (feature == JsonGenerator.Feature.QUOTE_FIELD_NAMES) {
            this._cfgUnqNames = true;
        }
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.base.GeneratorBase
    protected void _checkStdFeatureChanges(int i, int i2) {
        super._checkStdFeatureChanges(i, i2);
        this._cfgUnqNames = !JsonGenerator.Feature.QUOTE_FIELD_NAMES.enabledIn(i);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public JsonGenerator setHighestNonEscapedChar(int i) {
        this._maximumNonEscapedChar = Math.max(i, 0);
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public int getHighestEscapedChar() {
        return this._maximumNonEscapedChar;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public JsonGenerator setCharacterEscapes(CharacterEscapes characterEscapes) {
        this._characterEscapes = characterEscapes;
        if (characterEscapes == null) {
            this._outputEscapes = sOutputEscapes;
            return this;
        }
        this._outputEscapes = characterEscapes.getEscapeCodesForAscii();
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public CharacterEscapes getCharacterEscapes() {
        return this._characterEscapes;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public JsonGenerator setRootValueSeparator(SerializableString serializableString) {
        this._rootValueSeparator = serializableString;
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonGenerator
    public JacksonFeatureSet<StreamWriteCapability> getWriteCapabilities() {
        return JSON_WRITE_CAPABILITIES;
    }

    protected void _reportCantWriteValueExpectName(String str) throws IOException {
        _reportError(String.format("Can not %s, expecting field name (context: %s)", str, this._writeContext.typeDesc()));
    }
}
