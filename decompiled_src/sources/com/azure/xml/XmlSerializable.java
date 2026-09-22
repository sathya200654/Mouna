package com.azure.xml;

import com.azure.xml.XmlSerializable;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface XmlSerializable<T extends XmlSerializable<T>> {
    XmlWriter toXml(XmlWriter xmlWriter, String str) throws XMLStreamException;

    default XmlWriter toXml(XmlWriter xmlWriter) throws XMLStreamException {
        return toXml(xmlWriter, null);
    }

    static <T extends XmlSerializable<T>> T fromXml(XmlReader xmlReader) throws XMLStreamException {
        return (T) fromXml(xmlReader, null);
    }

    static <T extends XmlSerializable<T>> T fromXml(XmlReader xmlReader, String str) throws XMLStreamException {
        throw new UnsupportedOperationException("Implementation of XmlSerializable must define this factory method.");
    }
}
