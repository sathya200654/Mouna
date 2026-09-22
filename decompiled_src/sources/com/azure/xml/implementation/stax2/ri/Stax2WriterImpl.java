package com.azure.xml.implementation.stax2.ri;

import com.azure.xml.implementation.stax2.XMLStreamWriter2;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class Stax2WriterImpl implements XMLStreamWriter2, XMLStreamConstants {
    @Override // com.azure.xml.implementation.stax2.XMLStreamWriter2
    public abstract Location getLocation();

    @Override // com.azure.xml.implementation.stax2.XMLStreamWriter2
    public abstract void writeRaw(String str, int i, int i2) throws XMLStreamException;

    @Override // com.azure.xml.implementation.stax2.XMLStreamWriter2
    public abstract void writeRaw(char[] cArr, int i, int i2) throws XMLStreamException;

    protected Stax2WriterImpl() {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.stax2.XMLStreamWriter2
    public void writeSpace(String str) throws XMLStreamException {
        writeRaw(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.stax2.XMLStreamWriter2
    public void writeSpace(char[] cArr, int i, int i2) throws XMLStreamException {
        writeRaw(cArr, i, i2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.stax2.XMLStreamWriter2
    public void writeRaw(String str) throws XMLStreamException {
        writeRaw(str, 0, str.length());
    }
}
