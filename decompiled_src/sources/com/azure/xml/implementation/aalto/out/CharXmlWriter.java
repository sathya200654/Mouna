package com.azure.xml.implementation.aalto.out;

import com.azure.xml.implementation.aalto.impl.ErrorConsts;
import com.azure.xml.implementation.aalto.util.XmlCharTypes;
import com.azure.xml.implementation.aalto.util.XmlConsts;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.IOException;
import java.io.Writer;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class CharXmlWriter extends XmlWriter {
    static final int DEFAULT_FULL_BUFFER_SIZE = 1000;
    static final int DEFAULT_SMALL_SIZE = 200;
    private Writer _out;
    private char[] _outputBuffer;
    private final int _outputBufferLen;
    private int _outputPtr;
    final XmlCharTypes mCharTypes;
    private final int mEncHighChar;
    private final int mSmallWriteSize;
    private final int mTableCheckEnd;

    public CharXmlWriter(WriterConfig writerConfig, Writer writer) {
        super(writerConfig);
        this._out = writer;
        char[] cArrAllocFullCBuffer = writerConfig.allocFullCBuffer(1000);
        this._outputBuffer = cArrAllocFullCBuffer;
        this._outputBufferLen = cArrAllocFullCBuffer.length;
        this.mSmallWriteSize = 200;
        this._outputPtr = 0;
        int iGuessEncodingBitSize = guessEncodingBitSize(writerConfig);
        int i = iGuessEncodingBitSize < 16 ? 1 << iGuessEncodingBitSize : 65534;
        this.mEncHighChar = i;
        this.mTableCheckEnd = Math.min(256, i);
        this.mCharTypes = iGuessEncodingBitSize < 8 ? OutputCharTypes.getAsciiCharTypes() : OutputCharTypes.getLatin1CharTypes();
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    protected int getOutputPtr() {
        return this._outputPtr;
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public int getHighestEncodable() {
        return this.mEncHighChar;
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter, com.azure.xml.implementation.aalto.out.WNameFactory
    public WName constructName(String str) {
        return new CharWName(str);
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter, com.azure.xml.implementation.aalto.out.WNameFactory
    public WName constructName(String str, String str2) {
        return new CharWName(str, str2);
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void _releaseBuffers() {
        super._releaseBuffers();
        if (this._outputBuffer != null) {
            this._config.freeFullCBuffer(this._outputBuffer);
            this._outputBuffer = null;
        }
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void _closeTarget(boolean z) throws IOException {
        Writer writer = this._out;
        if (writer == null || !z) {
            return;
        }
        writer.close();
        this._out = null;
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void flush() throws IOException {
        if (this._out != null) {
            flushBuffer();
            this._out.flush();
        }
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void writeRaw(char[] cArr, int i, int i2) throws IOException {
        if (this._out == null) {
            return;
        }
        int i3 = this.mSmallWriteSize;
        if (i2 < i3) {
            if (this._outputPtr + i2 > this._outputBufferLen) {
                flushBuffer();
            }
            System.arraycopy(cArr, i, this._outputBuffer, this._outputPtr, i2);
            this._outputPtr += i2;
            return;
        }
        int i4 = this._outputPtr;
        if (i4 > 0) {
            if (i4 < i3) {
                int i5 = i3 - i4;
                System.arraycopy(cArr, i, this._outputBuffer, i4, i5);
                this._outputPtr = i4 + i5;
                i2 -= i5;
                i += i5;
            }
            flushBuffer();
        }
        this._out.write(cArr, i, i2);
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void writeRaw(String str, int i, int i2) throws IOException {
        if (this._out == null) {
            return;
        }
        int i3 = this.mSmallWriteSize;
        if (i2 < i3) {
            if (this._outputPtr + i2 >= this._outputBufferLen) {
                flushBuffer();
            }
            str.getChars(i, i + i2, this._outputBuffer, this._outputPtr);
            this._outputPtr += i2;
            return;
        }
        int i4 = this._outputPtr;
        if (i4 > 0) {
            if (i4 < i3) {
                int i5 = i3 - i4;
                int i6 = i + i5;
                str.getChars(i, i6, this._outputBuffer, i4);
                this._outputPtr = i4 + i5;
                i2 -= i5;
                i = i6;
            }
            flushBuffer();
        }
        this._out.write(str, i, i2);
    }

    public void writeCDataStart() throws IOException {
        fastWriteRaw("<![CDATA[");
    }

    public void writeCDataEnd() throws IOException {
        fastWriteRaw("]]>");
    }

    public void writeCommentStart() throws IOException {
        fastWriteRaw("<!--");
    }

    public void writeCommentEnd() throws IOException {
        fastWriteRaw("-->");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public int writeCData(String str) throws XMLStreamException, IOException {
        writeCDataStart();
        int length = str.length();
        int i = 0;
        while (length > 0) {
            char[] cArr = this._copyBuffer;
            int iMin = Math.min(length, cArr.length);
            int i2 = i + iMin;
            str.getChars(i, i2, cArr, 0);
            int iWriteCDataContents = writeCDataContents(cArr, 0, iMin);
            if (iWriteCDataContents >= 0) {
                return i + iWriteCDataContents;
            }
            length -= iMin;
            i = i2;
        }
        writeCDataEnd();
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x005a  */
    /* JADX WARN: Code duplicated, block: B:50:0x005d A[SYNTHETIC] */
    private int writeCDataContents(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        int i3 = i2 + i;
        int i4 = i;
        while (i4 < i3) {
            int[] iArr = this.mCharTypes.OTHER_CHARS;
            int i5 = this.mTableCheckEnd;
            do {
                char c = cArr[i4];
                if (c < i5 && iArr[c] == 0) {
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    char[] cArr2 = this._outputBuffer;
                    int i6 = this._outputPtr;
                    this._outputPtr = i6 + 1;
                    cArr2[i6] = c;
                    i4++;
                } else {
                    int i7 = i4 + 1;
                    if (c < i5) {
                        int i8 = iArr[c];
                        if (i8 == 1) {
                            reportInvalidChar(c);
                        } else {
                            if (i8 != 2 && i8 != 3) {
                                if (i8 == 4) {
                                    reportFailedEscaping("CDATA block", c);
                                } else if (i8 != 17) {
                                }
                                if (i7 - i >= 3 && cArr[i4 - 1] == ']' && cArr[i4 - 2] == ']') {
                                    writeCDataEnd();
                                    writeCDataStart();
                                }
                            }
                            if (this._outputPtr >= this._outputBufferLen) {
                                flushBuffer();
                            }
                            char[] cArr3 = this._outputBuffer;
                            int i9 = this._outputPtr;
                            this._outputPtr = i9 + 1;
                            cArr3[i9] = c;
                        }
                    } else if (c >= this.mEncHighChar) {
                        reportFailedEscaping("CDATA block", c);
                    }
                    i4 = i7;
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    char[] cArr4 = this._outputBuffer;
                    int i10 = this._outputPtr;
                    this._outputPtr = i10 + 1;
                    cArr4[i10] = c;
                }
            } while (i4 < i3);
            return -1;
        }
        return -1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void writeCharacters(String str) throws XMLStreamException, IOException {
        if (this._out == null) {
            return;
        }
        int length = str.length();
        int i = 0;
        while (length > 0) {
            char[] cArr = this._copyBuffer;
            int iMin = Math.min(length, cArr.length);
            int i2 = i + iMin;
            str.getChars(i, i2, cArr, 0);
            writeCharacters(cArr, 0, iMin);
            length -= iMin;
            i = i2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x004d  */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0027. Please report as an issue. */
    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void writeCharacters(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        if (this._out == null) {
            return;
        }
        int i3 = i2 + i;
        while (i < i3) {
            int[] iArr = this.mCharTypes.TEXT_CHARS;
            int i4 = this.mTableCheckEnd;
            do {
                char c = cArr[i];
                if (c < i4 && iArr[c] == 0) {
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    char[] cArr2 = this._outputBuffer;
                    int i5 = this._outputPtr;
                    this._outputPtr = i5 + 1;
                    cArr2[i5] = c;
                    i++;
                } else {
                    i++;
                    if (c < i4) {
                        int i6 = iArr[c];
                        if (i6 == 1) {
                            reportInvalidChar(c);
                        } else if (i6 != 2) {
                            if (i6 != 4) {
                                switch (i6) {
                                    case 9:
                                    case 10:
                                        break;
                                    case 11:
                                        break;
                                    default:
                                        if (this._outputPtr >= this._outputBufferLen) {
                                            flushBuffer();
                                        }
                                        char[] cArr3 = this._outputBuffer;
                                        int i7 = this._outputPtr;
                                        this._outputPtr = i7 + 1;
                                        cArr3[i7] = c;
                                        break;
                                }
                            }
                            writeAsEntity(c);
                        } else {
                            writeAsEntity(c);
                        }
                        if (i >= i3 || cArr[i] == '>') {
                            writeAsEntity(c);
                        } else {
                            if (this._outputPtr >= this._outputBufferLen) {
                                flushBuffer();
                            }
                            char[] cArr4 = this._outputBuffer;
                            int i8 = this._outputPtr;
                            this._outputPtr = i8 + 1;
                            cArr4[i8] = c;
                        }
                    } else if (c >= this.mEncHighChar) {
                        writeAsEntity(c);
                    } else {
                        if (this._outputPtr >= this._outputBufferLen) {
                            flushBuffer();
                        }
                        char[] cArr5 = this._outputBuffer;
                        int i9 = this._outputPtr;
                        this._outputPtr = i9 + 1;
                        cArr5[i9] = c;
                    }
                }
            } while (i < i3);
            return;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void writeSpace(String str) throws XMLStreamException, IOException {
        if (this._out == null) {
            return;
        }
        int length = str.length();
        int i = 0;
        while (length > 0) {
            char[] cArr = this._copyBuffer;
            int iMin = Math.min(length, cArr.length);
            int i2 = i + iMin;
            str.getChars(i, i2, cArr, 0);
            writeSpace(cArr, 0, iMin);
            length -= iMin;
            i = i2;
        }
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void writeSpace(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        if (this._out == null) {
            return;
        }
        int i3 = i2 + i;
        while (i < i3) {
            int i4 = i + 1;
            char c = cArr[i];
            if (c > ' ') {
                reportNwfContent(ErrorConsts.WERR_SPACE_CONTENT, Integer.valueOf(c), Integer.valueOf(i));
            }
            if (this._outputPtr >= this._outputBufferLen) {
                flushBuffer();
            }
            char[] cArr2 = this._outputBuffer;
            int i5 = this._outputPtr;
            this._outputPtr = i5 + 1;
            cArr2[i5] = c;
            i = i4;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public int writeComment(String str) throws XMLStreamException, IOException {
        if (this._out == null) {
            return -1;
        }
        writeCommentStart();
        int length = str.length();
        int iWriteCommentContents = -1;
        int i = 0;
        while (length > 0) {
            char[] cArr = this._copyBuffer;
            int length2 = cArr.length;
            if (length2 > length) {
                length2 = length;
            }
            int i2 = i + length2;
            str.getChars(i, i2, cArr, 0);
            iWriteCommentContents = writeCommentContents(cArr, 0, length2);
            if (iWriteCommentContents >= 0) {
                break;
            }
            length -= length2;
            i = i2;
        }
        if (iWriteCommentContents >= 0) {
            return i + iWriteCommentContents;
        }
        writeCommentEnd();
        return -1;
    }

    private int writeCommentContents(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        int i3 = i2 + i;
        while (i < i3) {
            int[] iArr = this.mCharTypes.OTHER_CHARS;
            int i4 = this.mTableCheckEnd;
            do {
                char c = cArr[i];
                if (c < i4 && iArr[c] == 0) {
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    char[] cArr2 = this._outputBuffer;
                    int i5 = this._outputPtr;
                    this._outputPtr = i5 + 1;
                    cArr2[i5] = c;
                    i++;
                } else {
                    i++;
                    if (c < i4) {
                        int i6 = iArr[c];
                        if (i6 == 1) {
                            reportInvalidChar(c);
                        } else if (i6 != 2 && i6 != 3) {
                            if (i6 == 4) {
                                reportFailedEscaping("comment", c);
                            } else if (i6 == 13) {
                            }
                            if (i == i3 || cArr[i] == '-') {
                                if (this._outputPtr >= this._outputBufferLen) {
                                    flushBuffer();
                                }
                                char[] cArr3 = this._outputBuffer;
                                int i7 = this._outputPtr;
                                this._outputPtr = i7 + 1;
                                cArr3[i7] = XmlConsts.CHAR_SPACE;
                            }
                        }
                    } else if (c >= this.mEncHighChar) {
                        reportFailedEscaping("comment", c);
                    }
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    char[] cArr4 = this._outputBuffer;
                    int i8 = this._outputPtr;
                    this._outputPtr = i8 + 1;
                    cArr4[i8] = c;
                }
            } while (i < i3);
            return -1;
        }
        return -1;
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void writeDTD(String str) throws IOException {
        writeRaw(str, 0, str.length());
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void writeEntityReference(WName wName) throws IOException {
        fastWriteRaw('&');
        writeName(wName);
        fastWriteRaw(';');
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void writeXmlDeclaration(String str, String str2, String str3) throws IOException {
        fastWriteRaw("<?xml version=\"");
        fastWriteRaw(str);
        fastWriteRaw('\"');
        if (str2 != null && !str2.isEmpty()) {
            fastWriteRaw(" encoding=\"");
            fastWriteRaw(str2);
            fastWriteRaw('\"');
        }
        if (str3 != null) {
            fastWriteRaw(" standalone=\"");
            fastWriteRaw(str3);
            fastWriteRaw('\"');
        }
        fastWriteRaw('?', '>');
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public int writePI(WName wName, String str) throws XMLStreamException, IOException {
        fastWriteRaw('<', '?');
        writeName(wName);
        if (str != null && !str.isEmpty()) {
            int length = str.length();
            fastWriteRaw(XmlConsts.CHAR_SPACE);
            int iWritePIContents = -1;
            int i = 0;
            while (length > 0) {
                char[] cArr = this._copyBuffer;
                int length2 = cArr.length;
                if (length2 > length) {
                    length2 = length;
                }
                int i2 = i + length2;
                str.getChars(i, i2, cArr, 0);
                iWritePIContents = writePIContents(cArr, 0, length2);
                if (iWritePIContents >= 0) {
                    break;
                }
                length -= length2;
                i = i2;
            }
            if (iWritePIContents >= 0) {
                return i + iWritePIContents;
            }
        }
        fastWriteRaw('?', '>');
        return -1;
    }

    private int writePIContents(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        int i3 = i2 + i;
        while (i < i3) {
            int[] iArr = this.mCharTypes.OTHER_CHARS;
            int i4 = this.mTableCheckEnd;
            do {
                char c = cArr[i];
                if (c < i4 && iArr[c] == 0) {
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    char[] cArr2 = this._outputBuffer;
                    int i5 = this._outputPtr;
                    this._outputPtr = i5 + 1;
                    cArr2[i5] = c;
                    i++;
                } else {
                    i++;
                    if (c < i4) {
                        int i6 = iArr[c];
                        if (i6 == 1) {
                            reportInvalidChar(c);
                        } else if (i6 != 2 && i6 != 3) {
                            if (i6 == 4) {
                                reportFailedEscaping("processing instruction", c);
                            } else if (i6 == 12) {
                            }
                            if (i < i3 && cArr[i] == '>') {
                                return i;
                            }
                        }
                    } else if (c >= this.mEncHighChar) {
                        reportFailedEscaping("processing instruction", c);
                    }
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    char[] cArr3 = this._outputBuffer;
                    int i7 = this._outputPtr;
                    this._outputPtr = i7 + 1;
                    cArr3[i7] = c;
                }
            } while (i < i3);
            return -1;
        }
        return -1;
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void writeStartTagStart(WName wName) throws IOException {
        int i = this._outputPtr;
        int iSerializedLength = wName.serializedLength();
        if (i + iSerializedLength + 1 > this._outputBufferLen) {
            if (this._out == null) {
                return;
            }
            flushBuffer();
            if (iSerializedLength >= this._outputBufferLen) {
                this._out.write(60);
                wName.writeChars(this._out);
                return;
            }
            i = this._outputPtr;
        }
        char[] cArr = this._outputBuffer;
        int i2 = i + 1;
        cArr[i] = '<';
        wName.appendChars(cArr, i2);
        this._outputPtr = i2 + iSerializedLength;
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void writeStartTagEnd() throws IOException {
        fastWriteRaw('>');
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void writeStartTagEmptyEnd() throws IOException {
        int i = this._outputPtr;
        if (i + 2 > this._outputBufferLen) {
            if (this._out == null) {
                return;
            }
            flushBuffer();
            i = this._outputPtr;
        }
        char[] cArr = this._outputBuffer;
        cArr[i] = JsonPointer.SEPARATOR;
        cArr[i + 1] = '>';
        this._outputPtr = i + 2;
    }

    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void writeEndTag(WName wName) throws IOException {
        int i = this._outputPtr;
        int iSerializedLength = wName.serializedLength();
        if (i + iSerializedLength + 3 > this._outputBufferLen) {
            flushBuffer();
            if (iSerializedLength + 3 > this._outputBufferLen) {
                this._out.write(60);
                this._out.write(47);
                wName.writeChars(this._out);
                char[] cArr = this._outputBuffer;
                int i2 = this._outputPtr;
                this._outputPtr = i2 + 1;
                cArr[i2] = '>';
                return;
            }
            i = this._outputPtr;
        }
        char[] cArr2 = this._outputBuffer;
        int i3 = i + 1;
        cArr2[i] = '<';
        int i4 = i + 2;
        cArr2[i3] = JsonPointer.SEPARATOR;
        wName.appendChars(cArr2, i4);
        int i5 = i4 + iSerializedLength;
        cArr2[i5] = '>';
        this._outputPtr = i5 + 1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void writeAttribute(WName wName, String str) throws XMLStreamException, IOException {
        if (this._out == null) {
            return;
        }
        fastWriteRaw(XmlConsts.CHAR_SPACE);
        writeName(wName);
        fastWriteRaw('=', '\"');
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            writeAttrValue(str, length);
        }
        fastWriteRaw('\"');
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public void writeAttribute(WName wName, char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        if (this._out == null) {
            return;
        }
        fastWriteRaw(XmlConsts.CHAR_SPACE);
        writeName(wName);
        fastWriteRaw('=', '\"');
        if (i2 > 0) {
            writeAttrValue(cArr, i, i2);
        }
        fastWriteRaw('\"');
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void writeAttrValue(String str, int i) throws XMLStreamException, IOException {
        int i2 = 0;
        while (i > 0) {
            char[] cArr = this._copyBuffer;
            int iMin = Math.min(i, cArr.length);
            int i3 = i2 + iMin;
            str.getChars(i2, i3, cArr, 0);
            writeAttrValue(cArr, 0, iMin);
            i -= iMin;
            i2 = i3;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:56:0x006b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0012 A[SYNTHETIC] */
    private void writeAttrValue(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        if (this._out == null) {
            return;
        }
        if (this._outputPtr + i2 > this._outputBufferLen) {
            writeSplitAttrValue(cArr, i, i2);
            return;
        }
        int i3 = i2 + i;
        while (i < i3) {
            int[] iArr = this.mCharTypes.ATTR_CHARS;
            int i4 = this.mTableCheckEnd;
            do {
                char c = cArr[i];
                if (c < i4 && iArr[c] == 0) {
                    char[] cArr2 = this._outputBuffer;
                    int i5 = this._outputPtr;
                    this._outputPtr = i5 + 1;
                    cArr2[i5] = c;
                    i++;
                } else {
                    i++;
                    if (c < i4) {
                        int i6 = iArr[c];
                        if (i6 == 1) {
                            reportInvalidChar(c);
                        } else if (i6 != 2 && i6 != 3 && i6 != 4 && i6 != 9 && i6 != 10 && i6 != 14) {
                            char[] cArr3 = this._outputBuffer;
                            int i7 = this._outputPtr;
                            this._outputPtr = i7 + 1;
                            cArr3[i7] = c;
                        }
                        writeAsEntity(c);
                        if (i3 - i >= this._outputBufferLen - this._outputPtr) {
                            flushBuffer();
                        }
                    } else if (c < this.mEncHighChar) {
                        char[] cArr4 = this._outputBuffer;
                        int i8 = this._outputPtr;
                        this._outputPtr = i8 + 1;
                        cArr4[i8] = c;
                    } else {
                        writeAsEntity(c);
                        if (i3 - i >= this._outputBufferLen - this._outputPtr) {
                            flushBuffer();
                        }
                    }
                }
            } while (i < i3);
            return;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x004a  */
    private void writeSplitAttrValue(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        int i3 = i2 + i;
        while (i < i3) {
            int[] iArr = this.mCharTypes.ATTR_CHARS;
            int i4 = this.mTableCheckEnd;
            do {
                char c = cArr[i];
                if (c < i4 && iArr[c] == 0) {
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    char[] cArr2 = this._outputBuffer;
                    int i5 = this._outputPtr;
                    this._outputPtr = i5 + 1;
                    cArr2[i5] = c;
                    i++;
                } else {
                    i++;
                    if (c < i4) {
                        int i6 = iArr[c];
                        if (i6 == 1) {
                            reportInvalidChar(c);
                        } else if (i6 == 2 || i6 == 3) {
                            writeAsEntity(c);
                        } else if (i6 != 4 && i6 != 9 && i6 != 10 && i6 != 14) {
                            if (this._outputPtr >= this._outputBufferLen) {
                                flushBuffer();
                            }
                            char[] cArr3 = this._outputBuffer;
                            int i7 = this._outputPtr;
                            this._outputPtr = i7 + 1;
                            cArr3[i7] = c;
                        }
                        writeAsEntity(c);
                    } else if (c >= this.mEncHighChar) {
                        writeAsEntity(c);
                    } else {
                        if (this._outputPtr >= this._outputBufferLen) {
                            flushBuffer();
                        }
                        char[] cArr4 = this._outputBuffer;
                        int i8 = this._outputPtr;
                        this._outputPtr = i8 + 1;
                        cArr4[i8] = c;
                    }
                }
            } while (i < i3);
            return;
        }
    }

    private void flushBuffer() throws IOException {
        int i = this._outputPtr;
        if (i <= 0 || this._out == null) {
            return;
        }
        this._locPastChars += i;
        this._locRowStartOffset -= i;
        this._outputPtr = 0;
        this._out.write(this._outputBuffer, 0, i);
    }

    private void writeName(WName wName) throws IOException {
        int i = this._outputPtr;
        int iSerializedLength = wName.serializedLength();
        if (i + iSerializedLength > this._outputBufferLen) {
            flushBuffer();
            if (iSerializedLength >= this._outputBufferLen) {
                wName.writeChars(this._out);
                return;
            }
            i = this._outputPtr;
        }
        wName.appendChars(this._outputBuffer, i);
        this._outputPtr += iSerializedLength;
    }

    private void fastWriteRaw(char c) throws IOException {
        if (this._outputPtr >= this._outputBufferLen) {
            if (this._out == null) {
                return;
            } else {
                flushBuffer();
            }
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputPtr;
        this._outputPtr = i + 1;
        cArr[i] = c;
    }

    private void fastWriteRaw(char c, char c2) throws IOException {
        if (this._outputPtr + 1 >= this._outputBufferLen) {
            if (this._out == null) {
                return;
            } else {
                flushBuffer();
            }
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputPtr;
        int i2 = i + 1;
        this._outputPtr = i2;
        cArr[i] = c;
        this._outputPtr = i + 2;
        cArr[i2] = c2;
    }

    private void fastWriteRaw(String str) throws IOException {
        int length = str.length();
        int i = this._outputPtr;
        int i2 = i + length;
        int i3 = this._outputBufferLen;
        if (i2 >= i3) {
            if (this._out == null) {
                return;
            }
            if (length > i3) {
                writeRaw(str, 0, str.length());
                return;
            } else {
                flushBuffer();
                i = this._outputPtr;
            }
        }
        str.getChars(0, length, this._outputBuffer, i);
        this._outputPtr = i + length;
    }

    private void writeAsEntity(int i) throws IOException {
        int i2;
        char[] cArr = this._outputBuffer;
        int i3 = this._outputPtr;
        if (i3 + 10 >= cArr.length) {
            flushBuffer();
            i3 = this._outputPtr;
        }
        int i4 = i3 + 1;
        cArr[i3] = '&';
        if (i >= 256) {
            int i5 = i3 + 2;
            cArr[i4] = '#';
            int i6 = i3 + 3;
            cArr[i5] = 'x';
            int i7 = 20;
            int i8 = i6;
            do {
                int i9 = (i >> i7) & 15;
                if (i9 > 0 || i8 != i6) {
                    int i10 = i8 + 1;
                    cArr[i8] = (char) (i9 < 10 ? i9 + 48 : i9 + 87);
                    i8 = i10;
                }
                i7 -= 4;
            } while (i7 > 0);
            int i11 = i & 15;
            i2 = i8 + 1;
            cArr[i8] = (char) (i11 < 10 ? i11 + 48 : i11 + 87);
        } else if (i == 38) {
            cArr[i4] = 'a';
            int i12 = i3 + 3;
            cArr[i3 + 2] = 'm';
            i2 = i3 + 4;
            cArr[i12] = 'p';
        } else if (i == 60) {
            int i13 = i3 + 2;
            cArr[i4] = 'l';
            i2 = i3 + 3;
            cArr[i13] = 't';
        } else if (i == 62) {
            int i14 = i3 + 2;
            cArr[i4] = 'g';
            i2 = i3 + 3;
            cArr[i14] = 't';
        } else if (i == 39) {
            cArr[i4] = 'a';
            cArr[i3 + 2] = 'p';
            int i15 = i3 + 4;
            cArr[i3 + 3] = 'o';
            i2 = i3 + 5;
            cArr[i15] = 's';
        } else if (i == 34) {
            cArr[i4] = 'q';
            cArr[i3 + 2] = 'u';
            int i16 = i3 + 4;
            cArr[i3 + 3] = 'o';
            i2 = i3 + 5;
            cArr[i16] = 't';
        } else {
            cArr[i4] = '#';
            int i17 = i3 + 3;
            cArr[i3 + 2] = 'x';
            if (i >= 16) {
                int i18 = i >> 4;
                int i19 = i3 + 4;
                cArr[i17] = (char) (i18 < 10 ? i18 + 48 : i18 + 87);
                i &= 15;
                i17 = i19;
            }
            i2 = i17 + 1;
            cArr[i17] = (char) (i < 10 ? i + 48 : i + 87);
        }
        cArr[i2] = ';';
        this._outputPtr = i2 + 1;
    }
}
