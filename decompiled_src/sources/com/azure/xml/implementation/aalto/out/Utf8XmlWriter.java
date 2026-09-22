package com.azure.xml.implementation.aalto.out;

import com.azure.xml.implementation.aalto.util.XmlConsts;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class Utf8XmlWriter extends ByteXmlWriter {
    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public int getHighestEncodable() {
        return XmlConsts.MAX_UNICODE_CHAR;
    }

    public Utf8XmlWriter(WriterConfig writerConfig, OutputStream outputStream) {
        super(writerConfig, outputStream, OutputCharTypes.getUtf8CharTypes());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.ByteXmlWriter, com.azure.xml.implementation.aalto.out.XmlWriter
    public void writeRaw(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        if (this._out == null || i2 == 0) {
            return;
        }
        if (this._surrogate != 0) {
            outputSurrogates(this._surrogate, cArr[i]);
            i++;
            i2--;
        }
        int i3 = i2 + i;
        while (i < i3) {
            do {
                char c = cArr[i];
                if (c >= 128) {
                    i++;
                    if (c < 2048) {
                        output2ByteChar(c);
                    } else {
                        i = outputMultiByteChar(c, cArr, i, i3);
                    }
                } else {
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    byte[] bArr = this._outputBuffer;
                    int i4 = this._outputPtr;
                    this._outputPtr = i4 + 1;
                    bArr[i4] = (byte) c;
                    i++;
                }
            } while (i < i3);
            return;
        }
    }

    @Override // com.azure.xml.implementation.aalto.out.ByteXmlWriter
    protected WName doConstructName(String str) {
        return new ByteWName(str, str.getBytes(StandardCharsets.UTF_8));
    }

    @Override // com.azure.xml.implementation.aalto.out.ByteXmlWriter
    protected WName doConstructName(String str, String str2) {
        return new ByteWName(str, str2, (str + ":" + str2).getBytes(StandardCharsets.UTF_8));
    }

    @Override // com.azure.xml.implementation.aalto.out.ByteXmlWriter
    protected void outputSurrogates(int i, int i2) throws XMLStreamException, IOException {
        int iCalcSurrogate = calcSurrogate(i, i2, " in content");
        if (this._outputPtr + 4 > this._outputBufferLen) {
            flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i3 = this._outputPtr;
        this._outputPtr = i3 + 1;
        bArr[i3] = (byte) ((iCalcSurrogate >> 18) | 240);
        byte[] bArr2 = this._outputBuffer;
        int i4 = this._outputPtr;
        this._outputPtr = i4 + 1;
        bArr2[i4] = (byte) (((iCalcSurrogate >> 12) & 63) | 128);
        byte[] bArr3 = this._outputBuffer;
        int i5 = this._outputPtr;
        this._outputPtr = i5 + 1;
        bArr3[i5] = (byte) (((iCalcSurrogate >> 6) & 63) | 128);
        byte[] bArr4 = this._outputBuffer;
        int i6 = this._outputPtr;
        this._outputPtr = i6 + 1;
        bArr4[i6] = (byte) ((iCalcSurrogate & 63) | 128);
    }

    @Override // com.azure.xml.implementation.aalto.out.ByteXmlWriter
    protected void output2ByteChar(int i) throws IOException {
        if (this._outputPtr + 2 > this._outputBufferLen) {
            flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i2 = this._outputPtr;
        this._outputPtr = i2 + 1;
        bArr[i2] = (byte) ((i >> 6) | 192);
        int i3 = this._outputPtr;
        this._outputPtr = i3 + 1;
        bArr[i3] = (byte) ((i & 63) | 128);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.ByteXmlWriter
    protected int outputMultiByteChar(int i, char[] cArr, int i2, int i3) throws XMLStreamException, IOException {
        if (i >= 55296) {
            if (i <= 57343) {
                if (i2 >= i3) {
                    this._surrogate = i;
                    return i2;
                }
                outputSurrogates(i, cArr[i2]);
                return i2 + 1;
            }
            if (i >= 65534) {
                reportInvalidChar(i);
            }
        }
        if (this._outputPtr + 3 > this._outputBufferLen) {
            flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i4 = this._outputPtr;
        this._outputPtr = i4 + 1;
        bArr[i4] = (byte) ((i >> 12) | 224);
        int i5 = this._outputPtr;
        this._outputPtr = i5 + 1;
        bArr[i5] = (byte) (((i >> 6) & 63) | 128);
        int i6 = this._outputPtr;
        this._outputPtr = i6 + 1;
        bArr[i6] = (byte) ((i & 63) | 128);
        return i2;
    }
}
