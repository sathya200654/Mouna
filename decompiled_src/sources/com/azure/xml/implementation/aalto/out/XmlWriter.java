package com.azure.xml.implementation.aalto.out;

import com.azure.xml.implementation.aalto.impl.ErrorConsts;
import com.azure.xml.implementation.aalto.impl.IoStreamException;
import com.azure.xml.implementation.aalto.util.CharsetNames;
import com.azure.xml.implementation.aalto.util.XmlChars;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Objects;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class XmlWriter extends WNameFactory {
    protected static final int DEFAULT_COPYBUFFER_LEN = 512;
    protected static final int SURR1_FIRST = 55296;
    protected static final int SURR2_FIRST = 56320;
    protected static final int SURR2_LAST = 57343;
    protected final WriterConfig _config;
    protected char[] _copyBuffer;
    protected final int _copyBufferLen;
    protected boolean _xml11 = false;
    protected int _locPastChars = 0;
    protected int _locRowNr = 1;
    protected int _locRowStartOffset = 0;

    public abstract void _closeTarget(boolean z) throws IOException;

    @Override // com.azure.xml.implementation.aalto.out.WNameFactory
    public abstract WName constructName(String str) throws XMLStreamException;

    @Override // com.azure.xml.implementation.aalto.out.WNameFactory
    public abstract WName constructName(String str, String str2) throws XMLStreamException;

    public abstract void flush() throws IOException;

    public abstract int getHighestEncodable();

    protected abstract int getOutputPtr();

    public abstract void writeAttribute(WName wName, String str) throws XMLStreamException, IOException;

    public abstract void writeAttribute(WName wName, char[] cArr, int i, int i2) throws XMLStreamException, IOException;

    public abstract int writeCData(String str) throws XMLStreamException, IOException;

    public abstract void writeCharacters(String str) throws XMLStreamException, IOException;

    public abstract void writeCharacters(char[] cArr, int i, int i2) throws XMLStreamException, IOException;

    public abstract int writeComment(String str) throws XMLStreamException, IOException;

    public abstract void writeDTD(String str) throws XMLStreamException, IOException;

    public abstract void writeEndTag(WName wName) throws XMLStreamException, IOException;

    public abstract void writeEntityReference(WName wName) throws XMLStreamException, IOException;

    public abstract int writePI(WName wName, String str) throws XMLStreamException, IOException;

    public abstract void writeRaw(String str, int i, int i2) throws XMLStreamException, IOException;

    public abstract void writeRaw(char[] cArr, int i, int i2) throws XMLStreamException, IOException;

    public abstract void writeSpace(String str) throws XMLStreamException, IOException;

    public abstract void writeSpace(char[] cArr, int i, int i2) throws XMLStreamException, IOException;

    public abstract void writeStartTagEmptyEnd() throws XMLStreamException, IOException;

    public abstract void writeStartTagEnd() throws XMLStreamException, IOException;

    public abstract void writeStartTagStart(WName wName) throws XMLStreamException, IOException;

    public abstract void writeXmlDeclaration(String str, String str2, String str3) throws XMLStreamException, IOException;

    protected XmlWriter(WriterConfig writerConfig) {
        this._config = writerConfig;
        char[] cArrAllocMediumCBuffer = writerConfig.allocMediumCBuffer(DEFAULT_COPYBUFFER_LEN);
        this._copyBuffer = cArrAllocMediumCBuffer;
        this._copyBufferLen = cArrAllocMediumCBuffer.length;
    }

    public void enableXml11() {
        this._xml11 = true;
    }

    public final void close(boolean z) throws IOException {
        flush();
        _releaseBuffers();
        _closeTarget(z);
    }

    public void _releaseBuffers() {
        char[] cArr = this._copyBuffer;
        if (cArr != null) {
            this._copyBuffer = null;
            this._config.freeMediumCBuffer(cArr);
        }
    }

    public int getRow() {
        return this._locRowNr;
    }

    public int getColumn() {
        return (getOutputPtr() - this._locRowStartOffset) + 1;
    }

    public int getAbsOffset() {
        return this._locPastChars + getOutputPtr();
    }

    public static int guessEncodingBitSize(WriterConfig writerConfig) {
        String preferredEncoding = writerConfig.getPreferredEncoding();
        if (preferredEncoding != null && !preferredEncoding.isEmpty()) {
            String strNormalize = CharsetNames.normalize(preferredEncoding);
            if (Objects.equals(strNormalize, "UTF-8")) {
                return 16;
            }
            if (Objects.equals(strNormalize, CharsetNames.CS_ISO_LATIN1)) {
                return 8;
            }
            if (Objects.equals(strNormalize, CharsetNames.CS_US_ASCII)) {
                return 7;
            }
            if (!Objects.equals(strNormalize, CharsetNames.CS_UTF16) && !Objects.equals(strNormalize, CharsetNames.CS_UTF16BE) && !Objects.equals(strNormalize, CharsetNames.CS_UTF16LE) && !Objects.equals(strNormalize, CharsetNames.CS_UTF32BE) && !Objects.equals(strNormalize, CharsetNames.CS_UTF32LE)) {
                return 8;
            }
        }
        return 16;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportNwfName(String str) throws XMLStreamException {
        throwOutputError(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportNwfContent(String str) throws XMLStreamException {
        throwOutputError(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportNwfContent(String str, Object obj, Object obj2) throws XMLStreamException {
        reportNwfContent(MessageFormat.format(str, obj, obj2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportFailedEscaping(String str, int i) throws XMLStreamException {
        if (i == 65534 || i == 65535 || (i >= 55296 && i <= 57343)) {
            reportInvalidChar(i);
        }
        if (i < 32) {
            reportInvalidChar(i);
        }
        reportNwfContent(MessageFormat.format(ErrorConsts.WERR_NO_ESCAPING, str, Integer.valueOf(i)));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportInvalidChar(int i) throws XMLStreamException {
        try {
            flush();
            if (i == 0) {
                reportNwfContent("Invalid null character in text to output");
            }
            if (i < 32 || (i >= 127 && i <= 159)) {
                String str = "Invalid white space character (0x" + Integer.toHexString(i) + ") in text to output";
                if (this._xml11) {
                    str = str + " (can only be output using character entity)";
                }
                reportNwfContent(str);
            }
            if (i > 1114111) {
                reportNwfContent("Illegal unicode character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 3629");
            }
            if (i >= 55296 && i <= 57343) {
                reportNwfContent("Illegal surrogate pair -- can only be output via character entities (for current encoding), which are not allowed in this content");
            }
            reportNwfContent("Invalid XML character " + XmlChars.getCharDesc(i) + " in text to output");
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void throwOutputError(String str) throws XMLStreamException {
        try {
            flush();
            throw new XMLStreamException(str);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }
}
