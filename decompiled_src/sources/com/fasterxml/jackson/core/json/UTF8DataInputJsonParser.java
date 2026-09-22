package com.fasterxml.jackson.core.json;

import androidx.wear.compose.foundation.SwipeToRevealKt;
import com.azure.xml.implementation.aalto.util.XmlConsts;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_18_4_1.FastDoubleMath;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.google.firebase.perf.util.Constants;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class UTF8DataInputJsonParser extends JsonParserBase {
    protected DataInput _inputData;
    protected int _nextByte;
    private int _quad1;
    protected int[] _quadBuffer;
    protected final ByteQuadsCanonicalizer _symbols;
    protected boolean _tokenIncomplete;

    private static final int pad(int i, int i2) {
        return i2 == 4 ? i : i | ((-1) << (i2 << 3));
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected void _closeInput() throws IOException {
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int releaseBuffered(OutputStream outputStream) throws IOException {
        return 0;
    }

    public UTF8DataInputJsonParser(IOContext iOContext, int i, DataInput dataInput, ObjectCodec objectCodec, ByteQuadsCanonicalizer byteQuadsCanonicalizer, int i2) {
        super(iOContext, i, objectCodec);
        this._quadBuffer = new int[16];
        this._symbols = byteQuadsCanonicalizer;
        this._inputData = dataInput;
        this._nextByte = i2;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getInputSource() {
        return this._inputData;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected void _releaseBuffers() throws IOException {
        super._releaseBuffers();
        this._symbols.release();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getText() throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                return _finishAndReturnString();
            }
            return this._textBuffer.contentsAsString();
        }
        return _getText2(this._currToken);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getText(Writer writer) throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.contentsToWriter(writer);
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            String currentName = this._parsingContext.getCurrentName();
            writer.write(currentName);
            return currentName.length();
        }
        if (jsonToken == null) {
            return 0;
        }
        if (jsonToken.isNumeric()) {
            return this._textBuffer.contentsToWriter(writer);
        }
        char[] cArrAsCharArray = jsonToken.asCharArray();
        writer.write(cArrAsCharArray);
        return cArrAsCharArray.length;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString() throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                return _finishAndReturnString();
            }
            return this._textBuffer.contentsAsString();
        }
        if (this._currToken == JsonToken.FIELD_NAME) {
            return currentName();
        }
        return super.getValueAsString(null);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString(String str) throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                return _finishAndReturnString();
            }
            return this._textBuffer.contentsAsString();
        }
        if (this._currToken == JsonToken.FIELD_NAME) {
            return currentName();
        }
        return super.getValueAsString(str);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            if ((this._numTypesValid & 1) == 0) {
                if (this._numTypesValid == 0) {
                    return _parseIntValue();
                }
                if ((this._numTypesValid & 1) == 0) {
                    convertNumberToInt();
                }
            }
            return this._numberInt;
        }
        return super.getValueAsInt(0);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt(int i) throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            if ((this._numTypesValid & 1) == 0) {
                if (this._numTypesValid == 0) {
                    return _parseIntValue();
                }
                if ((this._numTypesValid & 1) == 0) {
                    convertNumberToInt();
                }
            }
            return this._numberInt;
        }
        return super.getValueAsInt(i);
    }

    protected final String _getText2(JsonToken jsonToken) throws IOException {
        if (jsonToken == null) {
            return null;
        }
        int iId = jsonToken.id();
        if (iId == 5) {
            return this._parsingContext.getCurrentName();
        }
        if (iId == 6 || iId == 7 || iId == 8) {
            return this._textBuffer.contentsAsString();
        }
        return jsonToken.asString();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public char[] getTextCharacters() throws IOException {
        if (this._currToken == null) {
            return null;
        }
        int iId = this._currToken.id();
        if (iId == 5) {
            if (!this._nameCopied) {
                String currentName = this._parsingContext.getCurrentName();
                int length = currentName.length();
                if (this._nameCopyBuffer == null) {
                    this._nameCopyBuffer = this._ioContext.allocNameCopyBuffer(length);
                } else if (this._nameCopyBuffer.length < length) {
                    this._nameCopyBuffer = new char[length];
                }
                currentName.getChars(0, length, this._nameCopyBuffer, 0);
                this._nameCopied = true;
            }
            return this._nameCopyBuffer;
        }
        if (iId != 6) {
            if (iId != 7 && iId != 8) {
                return this._currToken.asCharArray();
            }
        } else if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.getTextBuffer();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getTextLength() throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.size();
        }
        if (this._currToken == JsonToken.FIELD_NAME) {
            return this._parsingContext.getCurrentName().length();
        }
        if (this._currToken == null) {
            return 0;
        }
        if (this._currToken.isNumeric()) {
            return this._textBuffer.size();
        }
        return this._currToken.asCharArray().length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
    
        if (r0 != 8) goto L16;
     */
    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getTextOffset() throws java.io.IOException {
        /*
            r3 = this;
            com.fasterxml.jackson.core.JsonToken r0 = r3._currToken
            r1 = 0
            if (r0 == 0) goto L26
            com.fasterxml.jackson.core.JsonToken r0 = r3._currToken
            int r0 = r0.id()
            r2 = 6
            if (r0 == r2) goto L16
            r2 = 7
            if (r0 == r2) goto L1f
            r2 = 8
            if (r0 == r2) goto L1f
            goto L26
        L16:
            boolean r0 = r3._tokenIncomplete
            if (r0 == 0) goto L1f
            r3._tokenIncomplete = r1
            r3._finishString()
        L1f:
            com.fasterxml.jackson.core.util.TextBuffer r3 = r3._textBuffer
            int r3 = r3.getTextOffset()
            return r3
        L26:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8DataInputJsonParser.getTextOffset():int");
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException {
        if (this._currToken != JsonToken.VALUE_STRING && (this._currToken != JsonToken.VALUE_EMBEDDED_OBJECT || this._binaryValue == null)) {
            _reportError("Current token (" + this._currToken + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this._tokenIncomplete) {
            try {
                this._binaryValue = _decodeBase64(base64Variant);
                this._tokenIncomplete = false;
            } catch (IllegalArgumentException e) {
                throw _constructError("Failed to decode VALUE_STRING as base64 (" + base64Variant + "): " + e.getMessage());
            }
        } else if (this._binaryValue == null) {
            ByteArrayBuilder byteArrayBuilder_getByteArrayBuilder = _getByteArrayBuilder();
            _decodeBase64(getText(), byteArrayBuilder_getByteArrayBuilder, base64Variant);
            this._binaryValue = byteArrayBuilder_getByteArrayBuilder.toByteArray();
        }
        return this._binaryValue;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        if (!this._tokenIncomplete || this._currToken != JsonToken.VALUE_STRING) {
            byte[] binaryValue = getBinaryValue(base64Variant);
            outputStream.write(binaryValue);
            return binaryValue.length;
        }
        byte[] bArrAllocBase64Buffer = this._ioContext.allocBase64Buffer();
        try {
            return _readBinary(base64Variant, outputStream, bArrAllocBase64Buffer);
        } finally {
            this._ioContext.releaseBase64Buffer(bArrAllocBase64Buffer);
        }
    }

    protected int _readBinary(Base64Variant base64Variant, OutputStream outputStream, byte[] bArr) throws IOException {
        int length = bArr.length - 3;
        int i = 0;
        int i2 = 0;
        while (true) {
            int unsignedByte = this._inputData.readUnsignedByte();
            if (unsignedByte > 32) {
                int iDecodeBase64Char = base64Variant.decodeBase64Char(unsignedByte);
                if (iDecodeBase64Char < 0) {
                    if (unsignedByte == 34) {
                        break;
                    }
                    iDecodeBase64Char = _decodeBase64Escape(base64Variant, unsignedByte, 0);
                    if (iDecodeBase64Char < 0) {
                        continue;
                    }
                }
                if (i > length) {
                    i2 += i;
                    outputStream.write(bArr, 0, i);
                    i = 0;
                }
                int unsignedByte2 = this._inputData.readUnsignedByte();
                int iDecodeBase64Char2 = base64Variant.decodeBase64Char(unsignedByte2);
                if (iDecodeBase64Char2 < 0) {
                    iDecodeBase64Char2 = _decodeBase64Escape(base64Variant, unsignedByte2, 1);
                }
                int i3 = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
                int unsignedByte3 = this._inputData.readUnsignedByte();
                int iDecodeBase64Char3 = base64Variant.decodeBase64Char(unsignedByte3);
                if (iDecodeBase64Char3 < 0) {
                    if (iDecodeBase64Char3 != -2) {
                        if (unsignedByte3 == 34) {
                            int i4 = i + 1;
                            bArr[i] = (byte) (i3 >> 4);
                            if (base64Variant.requiresPaddingOnRead()) {
                                _handleBase64MissingPadding(base64Variant);
                            }
                            i = i4;
                            break;
                        }
                        iDecodeBase64Char3 = _decodeBase64Escape(base64Variant, unsignedByte3, 2);
                    }
                    if (iDecodeBase64Char3 == -2) {
                        int unsignedByte4 = this._inputData.readUnsignedByte();
                        if (!base64Variant.usesPaddingChar(unsignedByte4) && (unsignedByte4 != 92 || _decodeBase64Escape(base64Variant, unsignedByte4, 3) != -2)) {
                            throw reportInvalidBase64Char(base64Variant, unsignedByte4, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                        bArr[i] = (byte) (i3 >> 4);
                        i++;
                    }
                }
                int i5 = (i3 << 6) | iDecodeBase64Char3;
                int unsignedByte5 = this._inputData.readUnsignedByte();
                int iDecodeBase64Char4 = base64Variant.decodeBase64Char(unsignedByte5);
                if (iDecodeBase64Char4 < 0) {
                    if (iDecodeBase64Char4 != -2) {
                        if (unsignedByte5 == 34) {
                            int i6 = i + 1;
                            bArr[i] = (byte) (i5 >> 10);
                            i += 2;
                            bArr[i6] = (byte) (i5 >> 2);
                            if (!base64Variant.requiresPaddingOnRead()) {
                                break;
                            }
                            _handleBase64MissingPadding(base64Variant);
                            break;
                        }
                        iDecodeBase64Char4 = _decodeBase64Escape(base64Variant, unsignedByte5, 3);
                    }
                    if (iDecodeBase64Char4 == -2) {
                        int i7 = i + 1;
                        bArr[i] = (byte) (i5 >> 10);
                        i += 2;
                        bArr[i7] = (byte) (i5 >> 2);
                    }
                }
                int i8 = (i5 << 6) | iDecodeBase64Char4;
                bArr[i] = (byte) (i8 >> 16);
                int i9 = i + 2;
                bArr[i + 1] = (byte) (i8 >> 8);
                i += 3;
                bArr[i9] = (byte) i8;
            }
        }
        this._tokenIncomplete = false;
        if (i <= 0) {
            return i2;
        }
        int i10 = i2 + i;
        outputStream.write(bArr, 0, i);
        return i10;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public JsonToken nextToken() throws IOException {
        JsonToken jsonToken_handleUnexpectedValue;
        if (this._closed) {
            return null;
        }
        if (this._currToken == JsonToken.FIELD_NAME) {
            return _nextAfterName();
        }
        this._numTypesValid = 0;
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i_skipWSOrEnd = _skipWSOrEnd();
        if (i_skipWSOrEnd < 0) {
            close();
            return _updateTokenToNull();
        }
        this._binaryValue = null;
        this._tokenInputRow = this._currInputRow;
        if ((i_skipWSOrEnd | 32) == 125) {
            _closeScope(i_skipWSOrEnd);
            return this._currToken;
        }
        if (this._parsingContext.expectComma()) {
            if (i_skipWSOrEnd != 44) {
                _reportUnexpectedChar(i_skipWSOrEnd, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
            }
            i_skipWSOrEnd = _skipWS();
            if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0 && (i_skipWSOrEnd | 32) == 125) {
                _closeScope(i_skipWSOrEnd);
                return this._currToken;
            }
        }
        if (!this._parsingContext.inObject()) {
            return _nextTokenNotInObject(i_skipWSOrEnd);
        }
        this._parsingContext.setCurrentName(_parseName(i_skipWSOrEnd));
        _updateToken(JsonToken.FIELD_NAME);
        int i_skipColon = _skipColon();
        if (i_skipColon == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return this._currToken;
        }
        if (i_skipColon != 43) {
            if (i_skipColon == 91) {
                jsonToken_handleUnexpectedValue = JsonToken.START_ARRAY;
            } else if (i_skipColon == 102) {
                _matchToken("false", 1);
                jsonToken_handleUnexpectedValue = JsonToken.VALUE_FALSE;
            } else if (i_skipColon == 110) {
                _matchToken("null", 1);
                jsonToken_handleUnexpectedValue = JsonToken.VALUE_NULL;
            } else if (i_skipColon == 116) {
                _matchToken("true", 1);
                jsonToken_handleUnexpectedValue = JsonToken.VALUE_TRUE;
            } else if (i_skipColon == 123) {
                jsonToken_handleUnexpectedValue = JsonToken.START_OBJECT;
            } else if (i_skipColon == 45) {
                jsonToken_handleUnexpectedValue = _parseNegNumber();
            } else if (i_skipColon == 46) {
                jsonToken_handleUnexpectedValue = _parseFloatThatStartsWithPeriod(false, false);
            } else {
                switch (i_skipColon) {
                    case 48:
                    case 49:
                    case SwipeToRevealKt.SHORT_ANIMATION /* 50 */:
                    case 51:
                    case 52:
                    case FastDoubleMath.DOUBLE_SIGNIFICAND_WIDTH /* 53 */:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        jsonToken_handleUnexpectedValue = _parseUnsignedNumber(i_skipColon);
                        break;
                    default:
                        jsonToken_handleUnexpectedValue = _handleUnexpectedValue(i_skipColon);
                        break;
                }
            }
        } else if (isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
            jsonToken_handleUnexpectedValue = _parsePosNumber();
        } else {
            jsonToken_handleUnexpectedValue = _handleUnexpectedValue(i_skipColon);
        }
        this._nextToken = jsonToken_handleUnexpectedValue;
        return this._currToken;
    }

    private final JsonToken _nextTokenNotInObject(int i) throws IOException {
        if (i == 34) {
            this._tokenIncomplete = true;
            return _updateToken(JsonToken.VALUE_STRING);
        }
        if (i == 43) {
            if (isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
                return _updateToken(_parsePosNumber());
            }
            return _updateToken(_handleUnexpectedValue(i));
        }
        if (i == 91) {
            createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            return _updateToken(JsonToken.START_ARRAY);
        }
        if (i == 102) {
            _matchToken("false", 1);
            return _updateToken(JsonToken.VALUE_FALSE);
        }
        if (i == 110) {
            _matchToken("null", 1);
            return _updateToken(JsonToken.VALUE_NULL);
        }
        if (i == 116) {
            _matchToken("true", 1);
            return _updateToken(JsonToken.VALUE_TRUE);
        }
        if (i == 123) {
            createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            return _updateToken(JsonToken.START_OBJECT);
        }
        if (i == 45) {
            return _updateToken(_parseNegNumber());
        }
        if (i == 46) {
            return _updateToken(_parseFloatThatStartsWithPeriod(false, false));
        }
        switch (i) {
            case 48:
            case 49:
            case SwipeToRevealKt.SHORT_ANIMATION /* 50 */:
            case 51:
            case 52:
            case FastDoubleMath.DOUBLE_SIGNIFICAND_WIDTH /* 53 */:
            case 54:
            case 55:
            case 56:
            case 57:
                return _updateToken(_parseUnsignedNumber(i));
            default:
                return _updateToken(_handleUnexpectedValue(i));
        }
    }

    private final JsonToken _nextAfterName() throws IOException {
        this._nameCopied = false;
        JsonToken jsonToken = this._nextToken;
        this._nextToken = null;
        if (jsonToken == JsonToken.START_ARRAY) {
            createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        return _updateToken(jsonToken);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void finishToken() throws IOException {
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String nextFieldName() throws IOException {
        JsonToken jsonToken_handleUnexpectedValue;
        this._numTypesValid = 0;
        if (this._currToken == JsonToken.FIELD_NAME) {
            _nextAfterName();
            return null;
        }
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i_skipWS = _skipWS();
        this._binaryValue = null;
        this._tokenInputRow = this._currInputRow;
        if ((i_skipWS | 32) == 125) {
            _closeScope(i_skipWS);
            return null;
        }
        if (this._parsingContext.expectComma()) {
            if (i_skipWS != 44) {
                _reportUnexpectedChar(i_skipWS, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
            }
            i_skipWS = _skipWS();
            if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0 && (i_skipWS | 32) == 125) {
                _closeScope(i_skipWS);
                return null;
            }
        }
        if (!this._parsingContext.inObject()) {
            _nextTokenNotInObject(i_skipWS);
            return null;
        }
        String str_parseName = _parseName(i_skipWS);
        this._parsingContext.setCurrentName(str_parseName);
        _updateToken(JsonToken.FIELD_NAME);
        int i_skipColon = _skipColon();
        if (i_skipColon == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return str_parseName;
        }
        if (i_skipColon != 43) {
            if (i_skipColon == 91) {
                jsonToken_handleUnexpectedValue = JsonToken.START_ARRAY;
            } else if (i_skipColon == 102) {
                _matchToken("false", 1);
                jsonToken_handleUnexpectedValue = JsonToken.VALUE_FALSE;
            } else if (i_skipColon == 110) {
                _matchToken("null", 1);
                jsonToken_handleUnexpectedValue = JsonToken.VALUE_NULL;
            } else if (i_skipColon == 116) {
                _matchToken("true", 1);
                jsonToken_handleUnexpectedValue = JsonToken.VALUE_TRUE;
            } else if (i_skipColon == 123) {
                jsonToken_handleUnexpectedValue = JsonToken.START_OBJECT;
            } else if (i_skipColon == 45) {
                jsonToken_handleUnexpectedValue = _parseNegNumber();
            } else {
                if (i_skipColon == 46) {
                    _parseFloatThatStartsWithPeriod(false, false);
                } else {
                    switch (i_skipColon) {
                        case 48:
                        case 49:
                        case SwipeToRevealKt.SHORT_ANIMATION /* 50 */:
                        case 51:
                        case 52:
                        case FastDoubleMath.DOUBLE_SIGNIFICAND_WIDTH /* 53 */:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                            break;
                        default:
                            jsonToken_handleUnexpectedValue = _handleUnexpectedValue(i_skipColon);
                            break;
                    }
                }
                jsonToken_handleUnexpectedValue = _parseUnsignedNumber(i_skipColon);
            }
        } else if (isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
            jsonToken_handleUnexpectedValue = _parsePosNumber();
        } else {
            jsonToken_handleUnexpectedValue = _handleUnexpectedValue(i_skipColon);
        }
        this._nextToken = jsonToken_handleUnexpectedValue;
        return str_parseName;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String nextTextValue() throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken jsonToken = this._nextToken;
            this._nextToken = null;
            _updateToken(jsonToken);
            if (jsonToken == JsonToken.VALUE_STRING) {
                if (this._tokenIncomplete) {
                    this._tokenIncomplete = false;
                    return _finishAndReturnString();
                }
                return this._textBuffer.contentsAsString();
            }
            if (jsonToken == JsonToken.START_ARRAY) {
                createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            } else if (jsonToken == JsonToken.START_OBJECT) {
                createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            }
            return null;
        }
        if (nextToken() == JsonToken.VALUE_STRING) {
            return getText();
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int nextIntValue(int i) throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken jsonToken = this._nextToken;
            this._nextToken = null;
            _updateToken(jsonToken);
            if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
                return getIntValue();
            }
            if (jsonToken == JsonToken.START_ARRAY) {
                createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                return i;
            }
            if (jsonToken == JsonToken.START_OBJECT) {
                createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                return i;
            }
        } else if (nextToken() == JsonToken.VALUE_NUMBER_INT) {
            return getIntValue();
        }
        return i;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long nextLongValue(long j) throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken jsonToken = this._nextToken;
            this._nextToken = null;
            _updateToken(jsonToken);
            if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
                return getLongValue();
            }
            if (jsonToken == JsonToken.START_ARRAY) {
                createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                return j;
            }
            if (jsonToken == JsonToken.START_OBJECT) {
                createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                return j;
            }
        } else if (nextToken() == JsonToken.VALUE_NUMBER_INT) {
            return getLongValue();
        }
        return j;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Boolean nextBooleanValue() throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken jsonToken = this._nextToken;
            this._nextToken = null;
            _updateToken(jsonToken);
            if (jsonToken == JsonToken.VALUE_TRUE) {
                return Boolean.TRUE;
            }
            if (jsonToken == JsonToken.VALUE_FALSE) {
                return Boolean.FALSE;
            }
            if (jsonToken == JsonToken.START_ARRAY) {
                createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            } else if (jsonToken == JsonToken.START_OBJECT) {
                createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            }
            return null;
        }
        JsonToken jsonTokenNextToken = nextToken();
        if (jsonTokenNextToken == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (jsonTokenNextToken == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        return null;
    }

    @Deprecated
    protected final JsonToken _parseFloatThatStartsWithPeriod() throws IOException {
        return _parseFloatThatStartsWithPeriod(false, false);
    }

    protected final JsonToken _parseFloatThatStartsWithPeriod(boolean z, boolean z2) throws IOException {
        if (!isEnabled(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
            return _handleUnexpectedValue(46);
        }
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int i = 0;
        if (z) {
            cArrEmptyAndGetCurrentSegment[0] = '-';
            i = 1;
        }
        return _parseFloat(cArrEmptyAndGetCurrentSegment, i, 46, z, 0);
    }

    protected JsonToken _parseUnsignedNumber(int i) throws IOException {
        int unsignedByte;
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int i2 = 1;
        if (i == 48) {
            unsignedByte = _handleLeadingZeroes();
            if (unsignedByte <= 57 && unsignedByte >= 48) {
                i2 = 0;
            } else {
                if (unsignedByte == 120 || unsignedByte == 88) {
                    return _handleInvalidNumberStart(unsignedByte, false);
                }
                cArrEmptyAndGetCurrentSegment[0] = '0';
            }
        } else {
            cArrEmptyAndGetCurrentSegment[0] = (char) i;
            unsignedByte = this._inputData.readUnsignedByte();
        }
        int unsignedByte2 = unsignedByte;
        char[] cArrFinishCurrentSegment = cArrEmptyAndGetCurrentSegment;
        int i3 = i2;
        int i4 = i3;
        while (unsignedByte2 <= 57 && unsignedByte2 >= 48) {
            i4++;
            if (i3 >= cArrFinishCurrentSegment.length) {
                cArrFinishCurrentSegment = this._textBuffer.finishCurrentSegment();
                i3 = 0;
            }
            cArrFinishCurrentSegment[i3] = (char) unsignedByte2;
            unsignedByte2 = this._inputData.readUnsignedByte();
            i3++;
        }
        if (unsignedByte2 == 46 || (unsignedByte2 | 32) == 101) {
            return _parseFloat(cArrFinishCurrentSegment, i3, unsignedByte2, false, i4);
        }
        this._textBuffer.setCurrentLength(i3);
        this._nextByte = unsignedByte2;
        if (this._parsingContext.inRoot()) {
            _verifyRootSpace();
        }
        return resetInt(false, i4);
    }

    protected final JsonToken _parsePosNumber() throws IOException {
        return _parseSignedNumber(false);
    }

    protected final JsonToken _parseNegNumber() throws IOException {
        return _parseSignedNumber(true);
    }

    private final JsonToken _parseSignedNumber(boolean z) throws IOException {
        int i;
        int unsignedByte;
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        if (z) {
            cArrEmptyAndGetCurrentSegment[0] = '-';
            i = 1;
        } else {
            i = 0;
        }
        int unsignedByte2 = this._inputData.readUnsignedByte();
        int i2 = i + 1;
        cArrEmptyAndGetCurrentSegment[i] = (char) unsignedByte2;
        if (unsignedByte2 <= 48) {
            if (unsignedByte2 != 48) {
                if (unsignedByte2 == 46) {
                    return _parseFloatThatStartsWithPeriod(z, true);
                }
                return _handleInvalidNumberStart(unsignedByte2, z, true);
            }
            unsignedByte = _handleLeadingZeroes();
        } else {
            if (unsignedByte2 > 57) {
                return _handleInvalidNumberStart(unsignedByte2, z, true);
            }
            unsignedByte = this._inputData.readUnsignedByte();
        }
        char[] cArrFinishCurrentSegment = cArrEmptyAndGetCurrentSegment;
        int i3 = 1;
        int unsignedByte3 = unsignedByte;
        int i4 = i2;
        while (unsignedByte3 <= 57 && unsignedByte3 >= 48) {
            i3++;
            if (i4 >= cArrFinishCurrentSegment.length) {
                cArrFinishCurrentSegment = this._textBuffer.finishCurrentSegment();
                i4 = 0;
            }
            cArrFinishCurrentSegment[i4] = (char) unsignedByte3;
            unsignedByte3 = this._inputData.readUnsignedByte();
            i4++;
        }
        if (unsignedByte3 == 46 || (unsignedByte3 | 32) == 101) {
            return _parseFloat(cArrFinishCurrentSegment, i4, unsignedByte3, z, i3);
        }
        this._textBuffer.setCurrentLength(i4);
        this._nextByte = unsignedByte3;
        if (this._parsingContext.inRoot()) {
            _verifyRootSpace();
        }
        return resetInt(z, i3);
    }

    private final int _handleLeadingZeroes() throws IOException {
        int unsignedByte = this._inputData.readUnsignedByte();
        if (unsignedByte >= 48 && unsignedByte <= 57) {
            if ((this._features & FEAT_MASK_LEADING_ZEROS) == 0) {
                reportInvalidNumber("Leading zeroes not allowed");
            }
            while (unsignedByte == 48) {
                unsignedByte = this._inputData.readUnsignedByte();
            }
        }
        return unsignedByte;
    }

    private final JsonToken _parseFloat(char[] cArr, int i, int i2, boolean z, int i3) throws IOException {
        int i4;
        int unsignedByte;
        int i5 = 0;
        if (i2 == 46) {
            if (i >= cArr.length) {
                cArr = this._textBuffer.finishCurrentSegment();
                i = 0;
            }
            cArr[i] = (char) i2;
            i++;
            int i6 = 0;
            while (true) {
                unsignedByte = this._inputData.readUnsignedByte();
                if (unsignedByte < 48 || unsignedByte > 57) {
                    break;
                }
                i6++;
                if (i >= cArr.length) {
                    cArr = this._textBuffer.finishCurrentSegment();
                    i = 0;
                }
                cArr[i] = (char) unsignedByte;
                i++;
            }
            if (i6 == 0 && !isEnabled(JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
                _reportUnexpectedNumberChar(unsignedByte, "Decimal point not followed by a digit");
            }
            i4 = i6;
            i2 = unsignedByte;
        } else {
            i4 = 0;
        }
        if ((i2 | 32) == 101) {
            if (i >= cArr.length) {
                cArr = this._textBuffer.finishCurrentSegment();
                i = 0;
            }
            int i7 = i + 1;
            cArr[i] = (char) i2;
            int unsignedByte2 = this._inputData.readUnsignedByte();
            if (unsignedByte2 == 45 || unsignedByte2 == 43) {
                if (i7 >= cArr.length) {
                    cArr = this._textBuffer.finishCurrentSegment();
                    i7 = 0;
                }
                cArr[i7] = (char) unsignedByte2;
                unsignedByte2 = this._inputData.readUnsignedByte();
                i7++;
            }
            i2 = unsignedByte2;
            i = i7;
            int i8 = 0;
            while (i2 <= 57 && i2 >= 48) {
                i8++;
                if (i >= cArr.length) {
                    cArr = this._textBuffer.finishCurrentSegment();
                    i = 0;
                }
                cArr[i] = (char) i2;
                i2 = this._inputData.readUnsignedByte();
                i++;
            }
            if (i8 == 0) {
                _reportUnexpectedNumberChar(i2, "Exponent indicator not followed by a digit");
            }
            i5 = i8;
        }
        this._nextByte = i2;
        if (this._parsingContext.inRoot()) {
            _verifyRootSpace();
        }
        this._textBuffer.setCurrentLength(i);
        return resetFloat(z, i3, i4, i5);
    }

    private final void _verifyRootSpace() throws IOException {
        int i = this._nextByte;
        if (i <= 32) {
            this._nextByte = -1;
            if (i == 13 || i == 10) {
                this._currInputRow++;
                return;
            }
            return;
        }
        _reportMissingRootWS(i);
    }

    protected final String _parseName(int i) throws IOException {
        if (i != 34) {
            return _handleOddName(i);
        }
        int[] iArr = INPUT_CODES_LATIN1;
        int unsignedByte = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte] != 0) {
            if (unsignedByte == 34) {
                return "";
            }
            return parseName(0, unsignedByte, 0);
        }
        int unsignedByte2 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte2] != 0) {
            if (unsignedByte2 == 34) {
                return findName(unsignedByte, 1);
            }
            return parseName(unsignedByte, unsignedByte2, 1);
        }
        int i2 = (unsignedByte << 8) | unsignedByte2;
        int unsignedByte3 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte3] != 0) {
            if (unsignedByte3 == 34) {
                return findName(i2, 2);
            }
            return parseName(i2, unsignedByte3, 2);
        }
        int i3 = (i2 << 8) | unsignedByte3;
        int unsignedByte4 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte4] != 0) {
            if (unsignedByte4 == 34) {
                return findName(i3, 3);
            }
            return parseName(i3, unsignedByte4, 3);
        }
        int i4 = (i3 << 8) | unsignedByte4;
        int unsignedByte5 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte5] == 0) {
            this._quad1 = i4;
            return _parseMediumName(unsignedByte5);
        }
        if (unsignedByte5 == 34) {
            return findName(i4, 4);
        }
        return parseName(i4, unsignedByte5, 4);
    }

    private final String _parseMediumName(int i) throws IOException {
        int[] iArr = INPUT_CODES_LATIN1;
        int unsignedByte = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte] != 0) {
            if (unsignedByte == 34) {
                return findName(this._quad1, i, 1);
            }
            return parseName(this._quad1, i, unsignedByte, 1);
        }
        int i2 = (i << 8) | unsignedByte;
        int unsignedByte2 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte2] != 0) {
            if (unsignedByte2 == 34) {
                return findName(this._quad1, i2, 2);
            }
            return parseName(this._quad1, i2, unsignedByte2, 2);
        }
        int i3 = (i2 << 8) | unsignedByte2;
        int unsignedByte3 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte3] != 0) {
            if (unsignedByte3 == 34) {
                return findName(this._quad1, i3, 3);
            }
            return parseName(this._quad1, i3, unsignedByte3, 3);
        }
        int i4 = (i3 << 8) | unsignedByte3;
        int unsignedByte4 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte4] == 0) {
            return _parseMediumName2(unsignedByte4, i4);
        }
        if (unsignedByte4 == 34) {
            return findName(this._quad1, i4, 4);
        }
        return parseName(this._quad1, i4, unsignedByte4, 4);
    }

    private final String _parseMediumName2(int i, int i2) throws IOException {
        int[] iArr = INPUT_CODES_LATIN1;
        int unsignedByte = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte] != 0) {
            if (unsignedByte == 34) {
                return findName(this._quad1, i2, i, 1);
            }
            return parseName(this._quad1, i2, i, unsignedByte, 1);
        }
        int i3 = (i << 8) | unsignedByte;
        int unsignedByte2 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte2] != 0) {
            if (unsignedByte2 == 34) {
                return findName(this._quad1, i2, i3, 2);
            }
            return parseName(this._quad1, i2, i3, unsignedByte2, 2);
        }
        int i4 = (i3 << 8) | unsignedByte2;
        int unsignedByte3 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte3] != 0) {
            if (unsignedByte3 == 34) {
                return findName(this._quad1, i2, i4, 3);
            }
            return parseName(this._quad1, i2, i4, unsignedByte3, 3);
        }
        int i5 = (i4 << 8) | unsignedByte3;
        int unsignedByte4 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte4] == 0) {
            return _parseLongName(unsignedByte4, i2, i5);
        }
        if (unsignedByte4 == 34) {
            return findName(this._quad1, i2, i5, 4);
        }
        return parseName(this._quad1, i2, i5, unsignedByte4, 4);
    }

    private final String _parseLongName(int i, int i2, int i3) throws IOException {
        int[] iArr = this._quadBuffer;
        iArr[0] = this._quad1;
        iArr[1] = i2;
        iArr[2] = i3;
        int[] iArr2 = INPUT_CODES_LATIN1;
        int i4 = i;
        int i5 = 3;
        while (true) {
            int unsignedByte = this._inputData.readUnsignedByte();
            if (iArr2[unsignedByte] != 0) {
                if (unsignedByte == 34) {
                    return findName(this._quadBuffer, i5, i4, 1);
                }
                return parseEscapedName(this._quadBuffer, i5, i4, unsignedByte, 1);
            }
            int i6 = (i4 << 8) | unsignedByte;
            int unsignedByte2 = this._inputData.readUnsignedByte();
            if (iArr2[unsignedByte2] != 0) {
                if (unsignedByte2 == 34) {
                    return findName(this._quadBuffer, i5, i6, 2);
                }
                return parseEscapedName(this._quadBuffer, i5, i6, unsignedByte2, 2);
            }
            int i7 = (i6 << 8) | unsignedByte2;
            int unsignedByte3 = this._inputData.readUnsignedByte();
            if (iArr2[unsignedByte3] != 0) {
                if (unsignedByte3 == 34) {
                    return findName(this._quadBuffer, i5, i7, 3);
                }
                return parseEscapedName(this._quadBuffer, i5, i7, unsignedByte3, 3);
            }
            int i8 = (i7 << 8) | unsignedByte3;
            int unsignedByte4 = this._inputData.readUnsignedByte();
            if (iArr2[unsignedByte4] != 0) {
                if (unsignedByte4 == 34) {
                    return findName(this._quadBuffer, i5, i8, 4);
                }
                return parseEscapedName(this._quadBuffer, i5, i8, unsignedByte4, 4);
            }
            int[] iArr3 = this._quadBuffer;
            if (i5 >= iArr3.length) {
                this._quadBuffer = growArrayBy(iArr3, i5);
            }
            this._quadBuffer[i5] = i8;
            i5++;
            i4 = unsignedByte4;
        }
    }

    private final String parseName(int i, int i2, int i3) throws IOException {
        return parseEscapedName(this._quadBuffer, 0, i, i2, i3);
    }

    private final String parseName(int i, int i2, int i3, int i4) throws IOException {
        int[] iArr = this._quadBuffer;
        iArr[0] = i;
        return parseEscapedName(iArr, 1, i2, i3, i4);
    }

    private final String parseName(int i, int i2, int i3, int i4, int i5) throws IOException {
        int[] iArr = this._quadBuffer;
        iArr[0] = i;
        iArr[1] = i2;
        return parseEscapedName(iArr, 2, i3, i4, i5);
    }

    protected final String parseEscapedName(int[] iArr, int i, int i2, int i3, int i4) throws IOException {
        int[] iArr2 = INPUT_CODES_LATIN1;
        while (true) {
            if (iArr2[i3] != 0) {
                if (i3 == 34) {
                    break;
                }
                if (i3 != 92) {
                    _throwUnquotedSpace(i3, "name");
                } else {
                    i3 = _decodeEscaped();
                }
                if (i3 > 127) {
                    int i5 = 0;
                    if (i4 >= 4) {
                        if (i >= iArr.length) {
                            iArr = growArrayBy(iArr, iArr.length);
                            this._quadBuffer = iArr;
                        }
                        iArr[i] = i2;
                        i++;
                        i2 = 0;
                        i4 = 0;
                    }
                    if (i3 < 2048) {
                        i2 = (i2 << 8) | (i3 >> 6) | 192;
                        i4++;
                    } else {
                        int i6 = (i2 << 8) | (i3 >> 12) | 224;
                        int i7 = i4 + 1;
                        if (i7 >= 4) {
                            if (i >= iArr.length) {
                                iArr = growArrayBy(iArr, iArr.length);
                                this._quadBuffer = iArr;
                            }
                            iArr[i] = i6;
                            i++;
                            i7 = 0;
                        } else {
                            i5 = i6;
                        }
                        i2 = (i5 << 8) | ((i3 >> 6) & 63) | 128;
                        i4 = i7 + 1;
                    }
                    i3 = (i3 & 63) | 128;
                }
            }
            if (i4 < 4) {
                i4++;
                i2 = (i2 << 8) | i3;
            } else {
                if (i >= iArr.length) {
                    iArr = growArrayBy(iArr, iArr.length);
                    this._quadBuffer = iArr;
                }
                iArr[i] = i2;
                i2 = i3;
                i++;
                i4 = 1;
            }
            i3 = this._inputData.readUnsignedByte();
        }
        if (i4 > 0) {
            if (i >= iArr.length) {
                iArr = growArrayBy(iArr, iArr.length);
                this._quadBuffer = iArr;
            }
            iArr[i] = pad(i2, i4);
            i++;
        }
        String strFindName = this._symbols.findName(iArr, i);
        return strFindName == null ? addName(iArr, i, i4) : strFindName;
    }

    protected String _handleOddName(int i) throws IOException {
        if (i == 39 && (this._features & FEAT_MASK_ALLOW_SINGLE_QUOTES) != 0) {
            return _parseAposName();
        }
        if ((this._features & FEAT_MASK_ALLOW_UNQUOTED_NAMES) == 0) {
            _reportUnexpectedChar((char) _decodeCharForError(i), "was expecting double-quote to start field name");
        }
        int[] inputCodeUtf8JsNames = CharTypes.getInputCodeUtf8JsNames();
        if (inputCodeUtf8JsNames[i] != 0) {
            _reportUnexpectedChar(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int[] iArrGrowArrayBy = this._quadBuffer;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        do {
            if (i2 < 4) {
                i2++;
                i |= i4 << 8;
            } else {
                if (i3 >= iArrGrowArrayBy.length) {
                    iArrGrowArrayBy = growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                    this._quadBuffer = iArrGrowArrayBy;
                }
                iArrGrowArrayBy[i3] = i4;
                i3++;
                i2 = 1;
            }
            i4 = i;
            i = this._inputData.readUnsignedByte();
        } while (inputCodeUtf8JsNames[i] == 0);
        this._nextByte = i;
        if (i2 > 0) {
            if (i3 >= iArrGrowArrayBy.length) {
                int[] iArrGrowArrayBy2 = growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                this._quadBuffer = iArrGrowArrayBy2;
                iArrGrowArrayBy = iArrGrowArrayBy2;
            }
            iArrGrowArrayBy[i3] = i4;
            i3++;
        }
        String strFindName = this._symbols.findName(iArrGrowArrayBy, i3);
        return strFindName == null ? addName(iArrGrowArrayBy, i3, i2) : strFindName;
    }

    protected String _parseAposName() throws IOException {
        int unsignedByte = this._inputData.readUnsignedByte();
        if (unsignedByte == 39) {
            return "";
        }
        int[] iArrGrowArrayBy = this._quadBuffer;
        int[] iArr = INPUT_CODES_LATIN1;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (unsignedByte != 39) {
            if (unsignedByte != 34 && iArr[unsignedByte] != 0) {
                if (unsignedByte != 92) {
                    _throwUnquotedSpace(unsignedByte, "name");
                } else {
                    unsignedByte = _decodeEscaped();
                }
                if (unsignedByte > 127) {
                    if (i >= 4) {
                        if (i2 >= iArrGrowArrayBy.length) {
                            iArrGrowArrayBy = growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                            this._quadBuffer = iArrGrowArrayBy;
                        }
                        iArrGrowArrayBy[i2] = i3;
                        i3 = 0;
                        i2++;
                        i = 0;
                    }
                    if (unsignedByte < 2048) {
                        i3 = (i3 << 8) | (unsignedByte >> 6) | 192;
                        i++;
                    } else {
                        int i4 = (i3 << 8) | (unsignedByte >> 12) | 224;
                        int i5 = i + 1;
                        if (i5 >= 4) {
                            if (i2 >= iArrGrowArrayBy.length) {
                                iArrGrowArrayBy = growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                                this._quadBuffer = iArrGrowArrayBy;
                            }
                            iArrGrowArrayBy[i2] = i4;
                            i4 = 0;
                            i2++;
                            i5 = 0;
                        }
                        i3 = (i4 << 8) | ((unsignedByte >> 6) & 63) | 128;
                        i = i5 + 1;
                    }
                    unsignedByte = (unsignedByte & 63) | 128;
                }
            }
            if (i < 4) {
                i++;
                unsignedByte |= i3 << 8;
            } else {
                if (i2 >= iArrGrowArrayBy.length) {
                    iArrGrowArrayBy = growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                    this._quadBuffer = iArrGrowArrayBy;
                }
                iArrGrowArrayBy[i2] = i3;
                i2++;
                i = 1;
            }
            i3 = unsignedByte;
            unsignedByte = this._inputData.readUnsignedByte();
        }
        if (i > 0) {
            if (i2 >= iArrGrowArrayBy.length) {
                int[] iArrGrowArrayBy2 = growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                this._quadBuffer = iArrGrowArrayBy2;
                iArrGrowArrayBy = iArrGrowArrayBy2;
            }
            iArrGrowArrayBy[i2] = pad(i3, i);
            i2++;
        }
        String strFindName = this._symbols.findName(iArrGrowArrayBy, i2);
        return strFindName == null ? addName(iArrGrowArrayBy, i2, i) : strFindName;
    }

    private final String findName(int i, int i2) throws JsonParseException, StreamConstraintsException {
        int iPad = pad(i, i2);
        String strFindName = this._symbols.findName(iPad);
        if (strFindName != null) {
            return strFindName;
        }
        int[] iArr = this._quadBuffer;
        iArr[0] = iPad;
        return addName(iArr, 1, i2);
    }

    private final String findName(int i, int i2, int i3) throws JsonParseException, StreamConstraintsException {
        int iPad = pad(i2, i3);
        String strFindName = this._symbols.findName(i, iPad);
        if (strFindName != null) {
            return strFindName;
        }
        int[] iArr = this._quadBuffer;
        iArr[0] = i;
        iArr[1] = iPad;
        return addName(iArr, 2, i3);
    }

    private final String findName(int i, int i2, int i3, int i4) throws JsonParseException, StreamConstraintsException {
        int iPad = pad(i3, i4);
        String strFindName = this._symbols.findName(i, i2, iPad);
        if (strFindName != null) {
            return strFindName;
        }
        int[] iArr = this._quadBuffer;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = pad(iPad, i4);
        return addName(iArr, 3, i4);
    }

    private final String findName(int[] iArr, int i, int i2, int i3) throws JsonParseException, StreamConstraintsException {
        if (i >= iArr.length) {
            iArr = growArrayBy(iArr, iArr.length);
            this._quadBuffer = iArr;
        }
        int i4 = i + 1;
        iArr[i] = pad(i2, i3);
        String strFindName = this._symbols.findName(iArr, i4);
        return strFindName == null ? addName(iArr, i4, i3) : strFindName;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00cd  */
    private final String addName(int[] iArr, int i, int i2) throws JsonParseException, StreamConstraintsException {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = ((i << 2) - 4) + i2;
        int i9 = 3;
        if (i2 < 4) {
            int i10 = i - 1;
            i3 = iArr[i10];
            iArr[i10] = i3 << ((4 - i2) << 3);
        } else {
            i3 = 0;
        }
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int i11 = 0;
        int i12 = 0;
        while (i11 < i8) {
            int i13 = iArr[i11 >> 2] >> ((3 - (i11 & 3)) << i9);
            int i14 = i13 & Constants.MAX_HOST_LENGTH;
            int i15 = i11 + 1;
            if (i14 > 127) {
                i4 = i9;
                if ((i13 & 224) == 192) {
                    i5 = i13 & 31;
                    i6 = 1;
                } else if ((i13 & 240) == 224) {
                    i5 = i13 & 15;
                    i6 = 2;
                } else if ((i13 & 248) == 240) {
                    i5 = i13 & 7;
                    i6 = i4;
                } else {
                    _reportInvalidInitial(i14);
                    i5 = 1;
                    i6 = 1;
                }
                if (i15 + i6 > i8) {
                    _reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
                }
                int i16 = iArr[i15 >> 2] >> ((3 - (i15 & 3)) << 3);
                i15 = i11 + 2;
                if ((i16 & 192) != 128) {
                    _reportInvalidOther(i16);
                }
                int i17 = (i5 << 6) | (i16 & 63);
                if (i6 > 1) {
                    int i18 = iArr[i15 >> 2] >> ((3 - (i15 & 3)) << 3);
                    i15 = i11 + 3;
                    if ((i18 & 192) != 128) {
                        _reportInvalidOther(i18);
                    }
                    int i19 = (i18 & 63) | (i17 << 6);
                    i7 = 2;
                    if (i6 > 2) {
                        int i20 = iArr[i15 >> 2] >> ((3 - (i15 & 3)) << 3);
                        i15 = i11 + 4;
                        if ((i20 & 192) != 128) {
                            _reportInvalidOther(i20 & Constants.MAX_HOST_LENGTH);
                        }
                        i14 = (i19 << 6) | (i20 & 63);
                    } else {
                        i14 = i19;
                    }
                    if (i6 > i7) {
                        int i21 = i14 - ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        if (i12 >= cArrEmptyAndGetCurrentSegment.length) {
                            cArrEmptyAndGetCurrentSegment = this._textBuffer.expandCurrentSegment();
                        }
                        cArrEmptyAndGetCurrentSegment[i12] = (char) ((i21 >> 10) + 55296);
                        i14 = (i21 & FastDoubleMath.DOUBLE_EXPONENT_BIAS) | 56320;
                        i12++;
                    }
                } else {
                    i14 = i17;
                }
                i7 = 2;
                if (i6 > i7) {
                    int i22 = i14 - ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    if (i12 >= cArrEmptyAndGetCurrentSegment.length) {
                        cArrEmptyAndGetCurrentSegment = this._textBuffer.expandCurrentSegment();
                    }
                    cArrEmptyAndGetCurrentSegment[i12] = (char) ((i22 >> 10) + 55296);
                    i14 = (i22 & FastDoubleMath.DOUBLE_EXPONENT_BIAS) | 56320;
                    i12++;
                }
            } else {
                i4 = i9;
            }
            i11 = i15;
            if (i12 >= cArrEmptyAndGetCurrentSegment.length) {
                cArrEmptyAndGetCurrentSegment = this._textBuffer.expandCurrentSegment();
            }
            cArrEmptyAndGetCurrentSegment[i12] = (char) i14;
            i12++;
            i9 = i4;
        }
        String str = new String(cArrEmptyAndGetCurrentSegment, 0, i12);
        if (!this._symbols.isCanonicalizing()) {
            return str;
        }
        if (i2 < 4) {
            iArr[i - 1] = i3;
        }
        return this._symbols.addName(str, iArr, i);
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected void _finishString() throws IOException {
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = INPUT_CODES_UTF8;
        int length = cArrEmptyAndGetCurrentSegment.length;
        int i = 0;
        while (true) {
            int unsignedByte = this._inputData.readUnsignedByte();
            if (iArr[unsignedByte] != 0) {
                if (unsignedByte == 34) {
                    this._textBuffer.setCurrentLength(i);
                    return;
                } else {
                    _finishString2(cArrEmptyAndGetCurrentSegment, i, unsignedByte);
                    return;
                }
            }
            int i2 = i + 1;
            cArrEmptyAndGetCurrentSegment[i] = (char) unsignedByte;
            if (i2 >= length) {
                _finishString2(cArrEmptyAndGetCurrentSegment, i2, this._inputData.readUnsignedByte());
                return;
            }
            i = i2;
        }
    }

    private String _finishAndReturnString() throws IOException {
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = INPUT_CODES_UTF8;
        int length = cArrEmptyAndGetCurrentSegment.length;
        int i = 0;
        while (true) {
            int unsignedByte = this._inputData.readUnsignedByte();
            if (iArr[unsignedByte] != 0) {
                if (unsignedByte == 34) {
                    return this._textBuffer.setCurrentAndReturn(i);
                }
                _finishString2(cArrEmptyAndGetCurrentSegment, i, unsignedByte);
                return this._textBuffer.contentsAsString();
            }
            int i2 = i + 1;
            cArrEmptyAndGetCurrentSegment[i] = (char) unsignedByte;
            if (i2 >= length) {
                _finishString2(cArrEmptyAndGetCurrentSegment, i2, this._inputData.readUnsignedByte());
                return this._textBuffer.contentsAsString();
            }
            i = i2;
        }
    }

    private final void _finishString2(char[] cArr, int i, int i2) throws IOException {
        int[] iArr = INPUT_CODES_UTF8;
        int length = cArr.length;
        while (true) {
            int i3 = iArr[i2];
            int i4 = 0;
            if (i3 == 0) {
                if (i >= length) {
                    cArr = this._textBuffer.finishCurrentSegment();
                    length = cArr.length;
                    i = 0;
                }
                cArr[i] = (char) i2;
                i2 = this._inputData.readUnsignedByte();
                i++;
            } else if (i2 != 34) {
                if (i3 == 1) {
                    i2 = _decodeEscaped();
                } else if (i3 == 2) {
                    i2 = _decodeUtf8_2(i2);
                } else if (i3 == 3) {
                    i2 = _decodeUtf8_3(i2);
                } else if (i3 == 4) {
                    int i_decodeUtf8_4 = _decodeUtf8_4(i2);
                    if (i >= cArr.length) {
                        cArr = this._textBuffer.finishCurrentSegment();
                        length = cArr.length;
                        i = 0;
                    }
                    cArr[i] = (char) ((i_decodeUtf8_4 >> 10) | 55296);
                    i2 = 56320 | (i_decodeUtf8_4 & FastDoubleMath.DOUBLE_EXPONENT_BIAS);
                    i++;
                } else if (i2 < 32) {
                    _throwUnquotedSpace(i2, "string value");
                } else {
                    _reportInvalidChar(i2);
                }
                if (i >= cArr.length) {
                    cArr = this._textBuffer.finishCurrentSegment();
                    length = cArr.length;
                } else {
                    i4 = i;
                }
                i = i4 + 1;
                cArr[i4] = (char) i2;
                i2 = this._inputData.readUnsignedByte();
            } else {
                this._textBuffer.setCurrentLength(i);
                return;
            }
        }
    }

    protected void _skipString() throws IOException {
        this._tokenIncomplete = false;
        int[] iArr = INPUT_CODES_UTF8;
        while (true) {
            int unsignedByte = this._inputData.readUnsignedByte();
            int i = iArr[unsignedByte];
            if (i != 0) {
                if (unsignedByte == 34) {
                    return;
                }
                if (i == 1) {
                    _decodeEscaped();
                } else if (i == 2) {
                    _skipUtf8_2();
                } else if (i == 3) {
                    _skipUtf8_3();
                } else if (i == 4) {
                    _skipUtf8_4();
                } else if (unsignedByte < 32) {
                    _throwUnquotedSpace(unsignedByte, "string value");
                } else {
                    _reportInvalidChar(unsignedByte);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0086  */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001b, code lost:
    
        if (r4 != 44) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        if (r3._parsingContext.inArray() == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
    
        if (r3._parsingContext.inRoot() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        if ((r3._features & com.fasterxml.jackson.core.json.UTF8DataInputJsonParser.FEAT_MASK_ALLOW_MISSING) == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0042, code lost:
    
        r3._nextByte = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        return com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected com.fasterxml.jackson.core.JsonToken _handleUnexpectedValue(int r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 39
            if (r4 == r0) goto L7f
            r0 = 73
            r1 = 1
            if (r4 == r0) goto L66
            r0 = 78
            if (r4 == r0) goto L4d
            r0 = 93
            if (r4 == r0) goto L2a
            r0 = 125(0x7d, float:1.75E-43)
            if (r4 == r0) goto L47
            r0 = 43
            if (r4 == r0) goto L1e
            r0 = 44
            if (r4 == r0) goto L33
            goto L8b
        L1e:
            java.io.DataInput r4 = r3._inputData
            int r4 = r4.readUnsignedByte()
            r0 = 0
            com.fasterxml.jackson.core.JsonToken r3 = r3._handleInvalidNumberStart(r4, r0, r1)
            return r3
        L2a:
            com.fasterxml.jackson.core.json.JsonReadContext r0 = r3._parsingContext
            boolean r0 = r0.inArray()
            if (r0 != 0) goto L33
            goto L8b
        L33:
            com.fasterxml.jackson.core.json.JsonReadContext r0 = r3._parsingContext
            boolean r0 = r0.inRoot()
            if (r0 != 0) goto L47
            int r0 = r3._features
            int r1 = com.fasterxml.jackson.core.json.UTF8DataInputJsonParser.FEAT_MASK_ALLOW_MISSING
            r0 = r0 & r1
            if (r0 == 0) goto L47
            r3._nextByte = r4
            com.fasterxml.jackson.core.JsonToken r3 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            return r3
        L47:
            java.lang.String r0 = "expected a value"
            r3._reportUnexpectedChar(r4, r0)
            goto L7f
        L4d:
            java.lang.String r0 = "NaN"
            r3._matchToken(r0, r1)
            int r1 = r3._features
            int r2 = com.fasterxml.jackson.core.json.UTF8DataInputJsonParser.FEAT_MASK_NON_NUM_NUMBERS
            r1 = r1 & r2
            if (r1 == 0) goto L60
            r1 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            com.fasterxml.jackson.core.JsonToken r3 = r3.resetAsNaN(r0, r1)
            return r3
        L60:
            java.lang.String r0 = "Non-standard token 'NaN': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow"
            r3._reportError(r0)
            goto L8b
        L66:
            java.lang.String r0 = "Infinity"
            r3._matchToken(r0, r1)
            int r1 = r3._features
            int r2 = com.fasterxml.jackson.core.json.UTF8DataInputJsonParser.FEAT_MASK_NON_NUM_NUMBERS
            r1 = r1 & r2
            if (r1 == 0) goto L79
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            com.fasterxml.jackson.core.JsonToken r3 = r3.resetAsNaN(r0, r1)
            return r3
        L79:
            java.lang.String r0 = "Non-standard token 'Infinity': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow"
            r3._reportError(r0)
            goto L8b
        L7f:
            int r0 = r3._features
            int r1 = com.fasterxml.jackson.core.json.UTF8DataInputJsonParser.FEAT_MASK_ALLOW_SINGLE_QUOTES
            r0 = r0 & r1
            if (r0 == 0) goto L8b
            com.fasterxml.jackson.core.JsonToken r3 = r3._handleApos()
            return r3
        L8b:
            boolean r0 = java.lang.Character.isJavaIdentifierStart(r4)
            if (r0 == 0) goto La8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            char r1 = (char) r4
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = r3._validJsonTokenList()
            r3._reportInvalidToken(r4, r0, r1)
        La8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "expected a valid value "
            r0.<init>(r1)
            java.lang.String r1 = r3._validJsonValueList()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3._reportUnexpectedChar(r4, r0)
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8DataInputJsonParser._handleUnexpectedValue(int):com.fasterxml.jackson.core.JsonToken");
    }

    protected JsonToken _handleApos() throws IOException {
        int i;
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = INPUT_CODES_UTF8;
        int i2 = 0;
        while (true) {
            int length = cArrEmptyAndGetCurrentSegment.length;
            if (i2 >= cArrEmptyAndGetCurrentSegment.length) {
                cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                length = cArrEmptyAndGetCurrentSegment.length;
                i2 = 0;
            }
            do {
                int unsignedByte = this._inputData.readUnsignedByte();
                if (unsignedByte != 39) {
                    int i3 = iArr[unsignedByte];
                    if (i3 == 0 || unsignedByte == 34) {
                        i = i2 + 1;
                        cArrEmptyAndGetCurrentSegment[i2] = (char) unsignedByte;
                        i2 = i;
                    } else {
                        if (i3 == 1) {
                            unsignedByte = _decodeEscaped();
                        } else if (i3 == 2) {
                            unsignedByte = _decodeUtf8_2(unsignedByte);
                        } else if (i3 == 3) {
                            unsignedByte = _decodeUtf8_3(unsignedByte);
                        } else if (i3 == 4) {
                            int i_decodeUtf8_4 = _decodeUtf8_4(unsignedByte);
                            int i4 = i2 + 1;
                            cArrEmptyAndGetCurrentSegment[i2] = (char) ((i_decodeUtf8_4 >> 10) | 55296);
                            if (i4 >= cArrEmptyAndGetCurrentSegment.length) {
                                cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                                i2 = 0;
                            } else {
                                i2 = i4;
                            }
                            unsignedByte = 56320 | (i_decodeUtf8_4 & FastDoubleMath.DOUBLE_EXPONENT_BIAS);
                        } else {
                            if (unsignedByte < 32) {
                                _throwUnquotedSpace(unsignedByte, "string value");
                            }
                            _reportInvalidChar(unsignedByte);
                        }
                        if (i2 >= cArrEmptyAndGetCurrentSegment.length) {
                            cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                            i2 = 0;
                        }
                        cArrEmptyAndGetCurrentSegment[i2] = (char) unsignedByte;
                        i2++;
                        break;
                    }
                } else {
                    this._textBuffer.setCurrentLength(i2);
                    return JsonToken.VALUE_STRING;
                }
            } while (i < length);
        }
    }

    protected JsonToken _handleInvalidNumberStart(int i, boolean z) throws IOException {
        return _handleInvalidNumberStart(i, z, false);
    }

    protected JsonToken _handleInvalidNumberStart(int i, boolean z, boolean z2) throws IOException {
        String str;
        while (i == 73) {
            i = this._inputData.readUnsignedByte();
            if (i != 78) {
                if (i != 110) {
                    break;
                }
                str = z ? "-Infinity" : "+Infinity";
            } else {
                str = z ? "-INF" : "+INF";
            }
            _matchToken(str, 3);
            if ((this._features & FEAT_MASK_NON_NUM_NUMBERS) != 0) {
                return resetAsNaN(str, z ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            }
            _reportError("Non-standard token '" + str + "': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow");
        }
        if (!isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) && z2 && !z) {
            _reportUnexpectedNumberChar(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
        }
        _reportUnexpectedNumberChar(i, z ? "expected digit (0-9) to follow minus sign, for valid numeric value" : "expected digit (0-9) for valid numeric value");
        return null;
    }

    protected final void _matchToken(String str, int i) throws IOException {
        int length = str.length();
        do {
            int unsignedByte = this._inputData.readUnsignedByte();
            if (unsignedByte != str.charAt(i)) {
                _reportInvalidToken(unsignedByte, str.substring(0, i));
            }
            i++;
        } while (i < length);
        int unsignedByte2 = this._inputData.readUnsignedByte();
        if (unsignedByte2 >= 48 && unsignedByte2 != 93 && unsignedByte2 != 125) {
            _checkMatchEnd(str, i, unsignedByte2);
        }
        this._nextByte = unsignedByte2;
    }

    private final void _checkMatchEnd(String str, int i, int i2) throws IOException {
        char c_decodeCharForError = (char) _decodeCharForError(i2);
        if (Character.isJavaIdentifierPart(c_decodeCharForError)) {
            _reportInvalidToken(c_decodeCharForError, str.substring(0, i));
        }
    }

    private final int _skipWS() throws IOException {
        int unsignedByte = this._nextByte;
        if (unsignedByte < 0) {
            unsignedByte = this._inputData.readUnsignedByte();
        } else {
            this._nextByte = -1;
        }
        while (unsignedByte <= 32) {
            if (unsignedByte == 13 || unsignedByte == 10) {
                this._currInputRow++;
            }
            unsignedByte = this._inputData.readUnsignedByte();
        }
        return (unsignedByte == 47 || unsignedByte == 35) ? _skipWSComment(unsignedByte) : unsignedByte;
    }

    private final int _skipWSOrEnd() throws IOException {
        int unsignedByte = this._nextByte;
        if (unsignedByte < 0) {
            try {
                unsignedByte = this._inputData.readUnsignedByte();
            } catch (EOFException unused) {
                return _eofAsNextChar();
            }
        } else {
            this._nextByte = -1;
        }
        while (unsignedByte <= 32) {
            if (unsignedByte == 13 || unsignedByte == 10) {
                this._currInputRow++;
            }
            try {
                unsignedByte = this._inputData.readUnsignedByte();
            } catch (EOFException unused2) {
                return _eofAsNextChar();
            }
        }
        return (unsignedByte == 47 || unsignedByte == 35) ? _skipWSComment(unsignedByte) : unsignedByte;
    }

    private final int _skipWSComment(int i) throws IOException {
        while (true) {
            if (i > 32) {
                if (i == 47) {
                    _skipComment();
                } else if (i != 35 || !_skipYAMLComment()) {
                    break;
                }
            } else if (i == 13 || i == 10) {
                this._currInputRow++;
            }
            i = this._inputData.readUnsignedByte();
        }
        return i;
    }

    private final int _skipColon() throws IOException {
        int unsignedByte = this._nextByte;
        if (unsignedByte < 0) {
            unsignedByte = this._inputData.readUnsignedByte();
        } else {
            this._nextByte = -1;
        }
        if (unsignedByte == 58) {
            int unsignedByte2 = this._inputData.readUnsignedByte();
            if (unsignedByte2 > 32) {
                return (unsignedByte2 == 47 || unsignedByte2 == 35) ? _skipColon2(unsignedByte2, true) : unsignedByte2;
            }
            if ((unsignedByte2 == 32 || unsignedByte2 == 9) && (unsignedByte2 = this._inputData.readUnsignedByte()) > 32) {
                return (unsignedByte2 == 47 || unsignedByte2 == 35) ? _skipColon2(unsignedByte2, true) : unsignedByte2;
            }
            return _skipColon2(unsignedByte2, true);
        }
        if (unsignedByte == 32 || unsignedByte == 9) {
            unsignedByte = this._inputData.readUnsignedByte();
        }
        if (unsignedByte == 58) {
            int unsignedByte3 = this._inputData.readUnsignedByte();
            if (unsignedByte3 > 32) {
                return (unsignedByte3 == 47 || unsignedByte3 == 35) ? _skipColon2(unsignedByte3, true) : unsignedByte3;
            }
            if ((unsignedByte3 == 32 || unsignedByte3 == 9) && (unsignedByte3 = this._inputData.readUnsignedByte()) > 32) {
                return (unsignedByte3 == 47 || unsignedByte3 == 35) ? _skipColon2(unsignedByte3, true) : unsignedByte3;
            }
            return _skipColon2(unsignedByte3, true);
        }
        return _skipColon2(unsignedByte, false);
    }

    private final int _skipColon2(int i, boolean z) throws IOException {
        while (true) {
            if (i > 32) {
                if (i == 47) {
                    _skipComment();
                } else if (i != 35 || !_skipYAMLComment()) {
                    if (z) {
                        return i;
                    }
                    if (i != 58) {
                        _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
                    }
                    z = true;
                }
            } else if (i == 13 || i == 10) {
                this._currInputRow++;
            }
            i = this._inputData.readUnsignedByte();
        }
    }

    private final void _skipComment() throws IOException {
        if ((this._features & FEAT_MASK_ALLOW_JAVA_COMMENTS) == 0) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        int unsignedByte = this._inputData.readUnsignedByte();
        if (unsignedByte == 47) {
            _skipLine();
        } else if (unsignedByte == 42) {
            _skipCComment();
        } else {
            _reportUnexpectedChar(unsignedByte, "was expecting either '*' or '/' for a comment");
        }
    }

    private final void _skipCComment() throws IOException {
        int[] inputCodeComment = CharTypes.getInputCodeComment();
        int unsignedByte = this._inputData.readUnsignedByte();
        while (true) {
            int i = inputCodeComment[unsignedByte];
            if (i != 0) {
                if (i == 2) {
                    _skipUtf8_2();
                } else if (i == 3) {
                    _skipUtf8_3();
                } else if (i == 4) {
                    _skipUtf8_4();
                } else if (i == 10 || i == 13) {
                    this._currInputRow++;
                } else if (i == 42) {
                    unsignedByte = this._inputData.readUnsignedByte();
                    if (unsignedByte == 47) {
                        return;
                    }
                } else {
                    _reportInvalidChar(unsignedByte);
                }
            }
            unsignedByte = this._inputData.readUnsignedByte();
        }
    }

    private final boolean _skipYAMLComment() throws IOException {
        if ((this._features & FEAT_MASK_ALLOW_YAML_COMMENTS) == 0) {
            return false;
        }
        _skipLine();
        return true;
    }

    private final void _skipLine() throws IOException {
        int[] inputCodeComment = CharTypes.getInputCodeComment();
        while (true) {
            int unsignedByte = this._inputData.readUnsignedByte();
            int i = inputCodeComment[unsignedByte];
            if (i != 0) {
                if (i == 2) {
                    _skipUtf8_2();
                } else if (i == 3) {
                    _skipUtf8_3();
                } else if (i == 4) {
                    _skipUtf8_4();
                } else if (i == 10 || i == 13) {
                    break;
                } else if (i != 42 && i < 0) {
                    _reportInvalidChar(unsignedByte);
                }
            }
        }
        this._currInputRow++;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected char _decodeEscaped() throws IOException {
        int unsignedByte = this._inputData.readUnsignedByte();
        if (unsignedByte == 34 || unsignedByte == 47 || unsignedByte == 92) {
            return (char) unsignedByte;
        }
        if (unsignedByte == 98) {
            return '\b';
        }
        if (unsignedByte == 102) {
            return '\f';
        }
        if (unsignedByte == 110) {
            return '\n';
        }
        if (unsignedByte == 114) {
            return XmlConsts.CHAR_CR;
        }
        if (unsignedByte == 116) {
            return '\t';
        }
        if (unsignedByte != 117) {
            return _handleUnrecognizedCharacterEscape((char) _decodeCharForError(unsignedByte));
        }
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int unsignedByte2 = this._inputData.readUnsignedByte();
            int iCharToHex = CharTypes.charToHex(unsignedByte2);
            if (iCharToHex < 0) {
                _reportUnexpectedChar(unsignedByte2, "expected a hex-digit for character escape sequence");
            }
            i = (i << 4) | iCharToHex;
        }
        return (char) i;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0038  */
    /* JADX WARN: Code duplicated, block: B:20:0x0044  */
    /* JADX WARN: Code duplicated, block: B:22:0x004e  */
    /* JADX WARN: Code duplicated, block: B:25:0x005a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0064  */
    protected int _decodeCharForError(int i) throws IOException {
        char c;
        int unsignedByte;
        int unsignedByte2;
        int unsignedByte3;
        int i2 = i & Constants.MAX_HOST_LENGTH;
        if (i2 > 127) {
            if ((i & 224) == 192) {
                i2 = i & 31;
            } else {
                if ((i & 240) == 224) {
                    i2 = i & 15;
                    c = 2;
                } else if ((i & 248) == 240) {
                    i2 = i & 7;
                    c = 3;
                } else {
                    _reportInvalidInitial(i & Constants.MAX_HOST_LENGTH);
                }
                unsignedByte = this._inputData.readUnsignedByte();
                if ((unsignedByte & 192) != 128) {
                    _reportInvalidOther(unsignedByte & Constants.MAX_HOST_LENGTH);
                }
                i2 = (i2 << 6) | (unsignedByte & 63);
                if (c > 1) {
                    unsignedByte2 = this._inputData.readUnsignedByte();
                    if ((unsignedByte2 & 192) != 128) {
                        _reportInvalidOther(unsignedByte2 & Constants.MAX_HOST_LENGTH);
                    }
                    i2 = (i2 << 6) | (unsignedByte2 & 63);
                    if (c > 2) {
                        unsignedByte3 = this._inputData.readUnsignedByte();
                        if ((unsignedByte3 & 192) != 128) {
                            _reportInvalidOther(unsignedByte3 & Constants.MAX_HOST_LENGTH);
                        }
                        return (i2 << 6) | (unsignedByte3 & 63);
                    }
                }
            }
            c = 1;
            unsignedByte = this._inputData.readUnsignedByte();
            if ((unsignedByte & 192) != 128) {
                _reportInvalidOther(unsignedByte & Constants.MAX_HOST_LENGTH);
            }
            i2 = (i2 << 6) | (unsignedByte & 63);
            if (c > 1) {
                unsignedByte2 = this._inputData.readUnsignedByte();
                if ((unsignedByte2 & 192) != 128) {
                    _reportInvalidOther(unsignedByte2 & Constants.MAX_HOST_LENGTH);
                }
                i2 = (i2 << 6) | (unsignedByte2 & 63);
                if (c > 2) {
                    unsignedByte3 = this._inputData.readUnsignedByte();
                    if ((unsignedByte3 & 192) != 128) {
                        _reportInvalidOther(unsignedByte3 & Constants.MAX_HOST_LENGTH);
                    }
                    return (i2 << 6) | (unsignedByte3 & 63);
                }
            }
        }
        return i2;
    }

    private final int _decodeUtf8_2(int i) throws IOException {
        int unsignedByte = this._inputData.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            _reportInvalidOther(unsignedByte & Constants.MAX_HOST_LENGTH);
        }
        return ((i & 31) << 6) | (unsignedByte & 63);
    }

    private final int _decodeUtf8_3(int i) throws IOException {
        int i2 = i & 15;
        int unsignedByte = this._inputData.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            _reportInvalidOther(unsignedByte & Constants.MAX_HOST_LENGTH);
        }
        int i3 = (i2 << 6) | (unsignedByte & 63);
        int unsignedByte2 = this._inputData.readUnsignedByte();
        if ((unsignedByte2 & 192) != 128) {
            _reportInvalidOther(unsignedByte2 & Constants.MAX_HOST_LENGTH);
        }
        return (i3 << 6) | (unsignedByte2 & 63);
    }

    private final int _decodeUtf8_4(int i) throws IOException {
        int unsignedByte = this._inputData.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            _reportInvalidOther(unsignedByte & Constants.MAX_HOST_LENGTH);
        }
        int i2 = ((i & 7) << 6) | (unsignedByte & 63);
        int unsignedByte2 = this._inputData.readUnsignedByte();
        if ((unsignedByte2 & 192) != 128) {
            _reportInvalidOther(unsignedByte2 & Constants.MAX_HOST_LENGTH);
        }
        int i3 = (i2 << 6) | (unsignedByte2 & 63);
        int unsignedByte3 = this._inputData.readUnsignedByte();
        if ((unsignedByte3 & 192) != 128) {
            _reportInvalidOther(unsignedByte3 & Constants.MAX_HOST_LENGTH);
        }
        return ((i3 << 6) | (unsignedByte3 & 63)) - ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
    }

    private final void _skipUtf8_2() throws IOException {
        int unsignedByte = this._inputData.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            _reportInvalidOther(unsignedByte & Constants.MAX_HOST_LENGTH);
        }
    }

    private final void _skipUtf8_3() throws IOException {
        int unsignedByte = this._inputData.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            _reportInvalidOther(unsignedByte & Constants.MAX_HOST_LENGTH);
        }
        int unsignedByte2 = this._inputData.readUnsignedByte();
        if ((unsignedByte2 & 192) != 128) {
            _reportInvalidOther(unsignedByte2 & Constants.MAX_HOST_LENGTH);
        }
    }

    private final void _skipUtf8_4() throws IOException {
        int unsignedByte = this._inputData.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            _reportInvalidOther(unsignedByte & Constants.MAX_HOST_LENGTH);
        }
        int unsignedByte2 = this._inputData.readUnsignedByte();
        if ((unsignedByte2 & 192) != 128) {
            _reportInvalidOther(unsignedByte2 & Constants.MAX_HOST_LENGTH);
        }
        int unsignedByte3 = this._inputData.readUnsignedByte();
        if ((unsignedByte3 & 192) != 128) {
            _reportInvalidOther(unsignedByte3 & Constants.MAX_HOST_LENGTH);
        }
    }

    protected void _reportInvalidToken(int i, String str) throws IOException {
        _reportInvalidToken(i, str, _validJsonTokenList());
    }

    protected void _reportInvalidToken(int i, String str, String str2) throws IOException {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            char c_decodeCharForError = (char) _decodeCharForError(i);
            if (Character.isJavaIdentifierPart(c_decodeCharForError)) {
                sb.append(c_decodeCharForError);
                i = this._inputData.readUnsignedByte();
            } else {
                _reportError("Unrecognized token '" + sb.toString() + "': was expecting " + str2);
                return;
            }
        }
    }

    protected void _reportInvalidChar(int i) throws JsonParseException {
        if (i < 32) {
            _throwInvalidSpace(i);
        }
        _reportInvalidInitial(i);
    }

    protected void _reportInvalidInitial(int i) throws JsonParseException {
        _reportError("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    private void _reportInvalidOther(int i) throws JsonParseException {
        _reportError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }

    protected final byte[] _decodeBase64(Base64Variant base64Variant) throws IOException {
        ByteArrayBuilder byteArrayBuilder_getByteArrayBuilder = _getByteArrayBuilder();
        while (true) {
            int unsignedByte = this._inputData.readUnsignedByte();
            if (unsignedByte > 32) {
                int iDecodeBase64Char = base64Variant.decodeBase64Char(unsignedByte);
                if (iDecodeBase64Char < 0) {
                    if (unsignedByte == 34) {
                        return byteArrayBuilder_getByteArrayBuilder.toByteArray();
                    }
                    iDecodeBase64Char = _decodeBase64Escape(base64Variant, unsignedByte, 0);
                    if (iDecodeBase64Char < 0) {
                        continue;
                    }
                }
                int unsignedByte2 = this._inputData.readUnsignedByte();
                int iDecodeBase64Char2 = base64Variant.decodeBase64Char(unsignedByte2);
                if (iDecodeBase64Char2 < 0) {
                    iDecodeBase64Char2 = _decodeBase64Escape(base64Variant, unsignedByte2, 1);
                }
                int i = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
                int unsignedByte3 = this._inputData.readUnsignedByte();
                int iDecodeBase64Char3 = base64Variant.decodeBase64Char(unsignedByte3);
                if (iDecodeBase64Char3 < 0) {
                    if (iDecodeBase64Char3 != -2) {
                        if (unsignedByte3 == 34) {
                            byteArrayBuilder_getByteArrayBuilder.append(i >> 4);
                            if (base64Variant.requiresPaddingOnRead()) {
                                _handleBase64MissingPadding(base64Variant);
                            }
                            return byteArrayBuilder_getByteArrayBuilder.toByteArray();
                        }
                        iDecodeBase64Char3 = _decodeBase64Escape(base64Variant, unsignedByte3, 2);
                    }
                    if (iDecodeBase64Char3 == -2) {
                        int unsignedByte4 = this._inputData.readUnsignedByte();
                        if (!base64Variant.usesPaddingChar(unsignedByte4) && (unsignedByte4 != 92 || _decodeBase64Escape(base64Variant, unsignedByte4, 3) != -2)) {
                            throw reportInvalidBase64Char(base64Variant, unsignedByte4, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                        byteArrayBuilder_getByteArrayBuilder.append(i >> 4);
                    }
                }
                int i2 = (i << 6) | iDecodeBase64Char3;
                int unsignedByte5 = this._inputData.readUnsignedByte();
                int iDecodeBase64Char4 = base64Variant.decodeBase64Char(unsignedByte5);
                if (iDecodeBase64Char4 < 0) {
                    if (iDecodeBase64Char4 != -2) {
                        if (unsignedByte5 == 34) {
                            byteArrayBuilder_getByteArrayBuilder.appendTwoBytes(i2 >> 2);
                            if (base64Variant.requiresPaddingOnRead()) {
                                _handleBase64MissingPadding(base64Variant);
                            }
                            return byteArrayBuilder_getByteArrayBuilder.toByteArray();
                        }
                        iDecodeBase64Char4 = _decodeBase64Escape(base64Variant, unsignedByte5, 3);
                    }
                    if (iDecodeBase64Char4 == -2) {
                        byteArrayBuilder_getByteArrayBuilder.appendTwoBytes(i2 >> 2);
                    }
                }
                byteArrayBuilder_getByteArrayBuilder.appendThreeBytes((i2 << 6) | iDecodeBase64Char4);
            }
        }
    }

    @Override // com.fasterxml.jackson.core.json.JsonParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation currentLocation() {
        return new JsonLocation(_contentReference(), -1L, -1L, this._currInputRow, -1);
    }

    @Override // com.fasterxml.jackson.core.json.JsonParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase
    protected JsonLocation _currentLocationMinusOne() {
        return currentLocation();
    }

    @Override // com.fasterxml.jackson.core.json.JsonParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation currentTokenLocation() {
        return new JsonLocation(_contentReference(), -1L, -1L, this._tokenInputRow, -1);
    }

    private void _closeScope(int i) throws IOException {
        if (i == 93) {
            if (!this._parsingContext.inArray()) {
                _reportMismatchedEndMarker(i, '}');
            }
            this._parsingContext = this._parsingContext.clearAndGetParent();
            _updateToken(JsonToken.END_ARRAY);
        }
        if (i == 125) {
            if (!this._parsingContext.inObject()) {
                _reportMismatchedEndMarker(i, ']');
            }
            this._parsingContext = this._parsingContext.clearAndGetParent();
            _updateToken(JsonToken.END_OBJECT);
        }
    }
}
