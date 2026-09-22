package com.azure.xml.implementation.aalto.out;

import com.azure.xml.implementation.aalto.util.XmlCharTypes;
import java.io.IOException;
import java.io.OutputStream;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class SingleByteXmlWriter extends ByteXmlWriter {
    @Override // com.azure.xml.implementation.aalto.out.XmlWriter
    public abstract int getHighestEncodable();

    @Override // com.azure.xml.implementation.aalto.out.ByteXmlWriter, com.azure.xml.implementation.aalto.out.XmlWriter
    public abstract void writeRaw(char[] cArr, int i, int i2) throws XMLStreamException, IOException;

    public SingleByteXmlWriter(WriterConfig writerConfig, OutputStream outputStream, XmlCharTypes xmlCharTypes) {
        super(writerConfig, outputStream, xmlCharTypes);
    }

    @Override // com.azure.xml.implementation.aalto.out.ByteXmlWriter
    protected final void output2ByteChar(int i) throws XMLStreamException {
        reportFailedEscaping("content", i);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.ByteXmlWriter
    protected final int outputMultiByteChar(int i, char[] cArr, int i2, int i3) throws XMLStreamException, IOException {
        if (i >= 55296) {
            if (i <= 57343) {
                if (i2 >= i3) {
                    this._surrogate = i;
                    return i2;
                }
                int i4 = i2 + 1;
                outputSurrogates(i, cArr[i2]);
                return i4;
            }
            if (i >= 65534) {
                reportInvalidChar(i);
            }
        }
        writeAsEntity(i);
        return i2;
    }

    @Override // com.azure.xml.implementation.aalto.out.ByteXmlWriter
    protected final void outputSurrogates(int i, int i2) throws XMLStreamException, IOException {
        writeAsEntity(calcSurrogate(i, i2, " in content"));
    }
}
