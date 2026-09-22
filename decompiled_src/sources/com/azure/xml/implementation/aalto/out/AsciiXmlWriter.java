package com.azure.xml.implementation.aalto.out;

import java.io.IOException;
import java.io.OutputStream;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AsciiXmlWriter extends SingleByteXmlWriter {
    static final int LAST_VALID_CHAR = 127;

    @Override // com.azure.xml.implementation.aalto.out.SingleByteXmlWriter, com.azure.xml.implementation.aalto.out.XmlWriter
    public int getHighestEncodable() {
        return LAST_VALID_CHAR;
    }

    public AsciiXmlWriter(WriterConfig writerConfig, OutputStream outputStream) {
        super(writerConfig, outputStream, OutputCharTypes.getAsciiCharTypes());
    }

    @Override // com.azure.xml.implementation.aalto.out.SingleByteXmlWriter, com.azure.xml.implementation.aalto.out.ByteXmlWriter, com.azure.xml.implementation.aalto.out.XmlWriter
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
            int i4 = i + 1;
            char c = cArr[i];
            if (c > LAST_VALID_CHAR) {
                reportFailedEscaping("raw content", c);
            }
            if (this._outputPtr >= this._outputBufferLen) {
                flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i5 = this._outputPtr;
            this._outputPtr = i5 + 1;
            bArr[i5] = (byte) c;
            i = i4;
        }
    }

    @Override // com.azure.xml.implementation.aalto.out.ByteXmlWriter
    protected WName doConstructName(String str) {
        return new ByteWName(str, getAscii(str));
    }

    @Override // com.azure.xml.implementation.aalto.out.ByteXmlWriter
    protected WName doConstructName(String str, String str2) {
        int length = str.length();
        int i = length + 1;
        byte[] bArr = new byte[str2.length() + i];
        getAscii(str, bArr, 0);
        bArr[length] = 58;
        getAscii(str2, bArr, i);
        return new ByteWName(str, str2, bArr);
    }
}
