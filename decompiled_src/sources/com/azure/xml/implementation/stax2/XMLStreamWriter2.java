package com.azure.xml.implementation.stax2;

import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface XMLStreamWriter2 extends XMLStreamWriter {
    Location getLocation();

    void writeRaw(String str) throws XMLStreamException;

    void writeRaw(String str, int i, int i2) throws XMLStreamException;

    void writeRaw(char[] cArr, int i, int i2) throws XMLStreamException;

    void writeSpace(String str) throws XMLStreamException;

    void writeSpace(char[] cArr, int i, int i2) throws XMLStreamException;
}
