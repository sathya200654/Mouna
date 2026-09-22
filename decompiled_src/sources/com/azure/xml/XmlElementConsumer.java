package com.azure.xml;

import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@FunctionalInterface
public interface XmlElementConsumer {
    void consume(String str, String str2, XmlReader xmlReader) throws XMLStreamException;
}
