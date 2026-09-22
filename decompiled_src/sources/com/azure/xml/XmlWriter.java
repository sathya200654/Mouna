package com.azure.xml;

import com.azure.xml.implementation.aalto.stax.OutputFactoryImpl;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class XmlWriter implements AutoCloseable {
    private static final XMLOutputFactory XML_OUTPUT_FACTORY;
    private final XMLStreamWriter writer;

    static {
        XMLOutputFactory xMLOutputFactoryNewInstance = XMLOutputFactory.newInstance();
        if ("com.sun.xml.internal.stream.XMLOutputFactoryImpl".equals(xMLOutputFactoryNewInstance.getClass().getName())) {
            xMLOutputFactoryNewInstance = new OutputFactoryImpl();
        }
        XML_OUTPUT_FACTORY = xMLOutputFactoryNewInstance;
    }

    public static XmlWriter toStream(OutputStream outputStream) throws XMLStreamException {
        Objects.requireNonNull(outputStream, "'xml' cannot be null.");
        return new XmlWriter(XML_OUTPUT_FACTORY.createXMLStreamWriter(outputStream, StandardCharsets.UTF_8.name()));
    }

    public static XmlWriter toWriter(Writer writer) throws XMLStreamException {
        Objects.requireNonNull(writer, "'xml' cannot be null.");
        return new XmlWriter(XML_OUTPUT_FACTORY.createXMLStreamWriter(writer));
    }

    public static XmlWriter fromXmlStreamWriter(XMLStreamWriter xMLStreamWriter) {
        return new XmlWriter(xMLStreamWriter);
    }

    private XmlWriter(XMLStreamWriter xMLStreamWriter) {
        this.writer = (XMLStreamWriter) Objects.requireNonNull(xMLStreamWriter, "'writer' cannot be null.");
    }

    public XmlWriter writeStartDocument() throws XMLStreamException {
        return writeStartDocument("1.0", "UTF-8");
    }

    public XmlWriter writeStartDocument(String str, String str2) throws XMLStreamException {
        this.writer.writeStartDocument(str2, str);
        return this;
    }

    public XmlWriter writeStartElement(String str) throws XMLStreamException {
        return writeStartElement(null, str);
    }

    public XmlWriter writeStartElement(String str, String str2) throws XMLStreamException {
        if (str == null) {
            this.writer.writeStartElement(str2);
            return this;
        }
        this.writer.writeStartElement(str, str2);
        return this;
    }

    public XmlWriter writeStartSelfClosingElement(String str) throws XMLStreamException {
        return writeStartSelfClosingElement(null, str);
    }

    public XmlWriter writeStartSelfClosingElement(String str, String str2) throws XMLStreamException {
        if (str == null) {
            this.writer.writeEmptyElement(str2);
            return this;
        }
        this.writer.writeEmptyElement(str, str2);
        return this;
    }

    public XmlWriter writeEndElement() throws XMLStreamException {
        this.writer.writeEndElement();
        return this;
    }

    public XmlWriter writeNamespace(String str) throws XMLStreamException {
        if (Objects.equals(this.writer.getNamespaceContext().getNamespaceURI(""), str)) {
            return this;
        }
        this.writer.setDefaultNamespace(str);
        this.writer.writeDefaultNamespace(str);
        return this;
    }

    public XmlWriter writeNamespace(String str, String str2) throws XMLStreamException {
        if (str == null || "xmlns".equals(str)) {
            return writeNamespace(str);
        }
        if (Objects.equals(this.writer.getNamespaceContext().getNamespaceURI(str), str2)) {
            return this;
        }
        this.writer.writeNamespace(str, str2);
        return this;
    }

    public XmlWriter writeStringAttribute(String str, String str2) throws XMLStreamException {
        return writeStringAttribute(null, str, str2);
    }

    public XmlWriter writeStringAttribute(String str, String str2, String str3) throws XMLStreamException {
        if (str3 == null) {
            return this;
        }
        if (str == null) {
            this.writer.writeAttribute(str2, str3);
            return this;
        }
        this.writer.writeAttribute(str, str2, str3);
        return this;
    }

    public XmlWriter writeBinaryAttribute(String str, byte[] bArr) throws XMLStreamException {
        return writeBinaryAttribute(null, str, bArr);
    }

    public XmlWriter writeBinaryAttribute(String str, String str2, byte[] bArr) throws XMLStreamException {
        return bArr == null ? this : writeStringAttribute(str, str2, convertBytesToString(bArr));
    }

    public XmlWriter writeBooleanAttribute(String str, boolean z) throws XMLStreamException {
        return writeStringAttribute(str, String.valueOf(z));
    }

    public XmlWriter writeBooleanAttribute(String str, String str2, boolean z) throws XMLStreamException {
        return writeStringAttribute(str, str2, String.valueOf(z));
    }

    public XmlWriter writeBooleanAttribute(String str, Boolean bool) throws XMLStreamException {
        return writeBooleanAttribute((String) null, str, bool);
    }

    public XmlWriter writeBooleanAttribute(String str, String str2, Boolean bool) throws XMLStreamException {
        return bool == null ? this : writeStringAttribute(str, str2, String.valueOf(bool));
    }

    public XmlWriter writeDoubleAttribute(String str, double d) throws XMLStreamException {
        return writeStringAttribute(str, String.valueOf(d));
    }

    public XmlWriter writeDoubleAttribute(String str, String str2, double d) throws XMLStreamException {
        return writeStringAttribute(str, str2, String.valueOf(d));
    }

    public XmlWriter writeFloatAttribute(String str, float f) throws XMLStreamException {
        return writeStringAttribute(str, String.valueOf(f));
    }

    public XmlWriter writeFloatAttribute(String str, String str2, float f) throws XMLStreamException {
        return writeStringAttribute(str, str2, String.valueOf(f));
    }

    public XmlWriter writeIntAttribute(String str, int i) throws XMLStreamException {
        return writeStringAttribute(str, String.valueOf(i));
    }

    public XmlWriter writeIntAttribute(String str, String str2, int i) throws XMLStreamException {
        return writeStringAttribute(str, str2, String.valueOf(i));
    }

    public XmlWriter writeLongAttribute(String str, long j) throws XMLStreamException {
        return writeStringAttribute(str, String.valueOf(j));
    }

    public XmlWriter writeLongAttribute(String str, String str2, long j) throws XMLStreamException {
        return writeStringAttribute(str, str2, String.valueOf(j));
    }

    public XmlWriter writeNumberAttribute(String str, Number number) throws XMLStreamException {
        return writeNumberAttribute(null, str, number);
    }

    public XmlWriter writeNumberAttribute(String str, String str2, Number number) throws XMLStreamException {
        return number == null ? this : writeStringAttribute(str, str2, String.valueOf(number));
    }

    public XmlWriter writeBinaryElement(String str, byte[] bArr) throws XMLStreamException {
        return writeBinaryElement(null, str, bArr);
    }

    public XmlWriter writeBinaryElement(String str, String str2, byte[] bArr) throws XMLStreamException {
        return bArr == null ? this : writeStartElement(str, str2).writeBinary(bArr).writeEndElement();
    }

    public XmlWriter writeBooleanElement(String str, boolean z) throws XMLStreamException {
        return writeBooleanElement((String) null, str, z);
    }

    public XmlWriter writeBooleanElement(String str, String str2, boolean z) throws XMLStreamException {
        return writeStartElement(str, str2).writeBoolean(z).writeEndElement();
    }

    public XmlWriter writeBooleanElement(String str, Boolean bool) throws XMLStreamException {
        return writeBooleanElement((String) null, str, bool);
    }

    public XmlWriter writeBooleanElement(String str, String str2, Boolean bool) throws XMLStreamException {
        return bool == null ? this : writeStartElement(str, str2).writeBoolean(bool.booleanValue()).writeEndElement();
    }

    public XmlWriter writeDoubleElement(String str, double d) throws XMLStreamException {
        return writeDoubleElement(null, str, d);
    }

    public XmlWriter writeDoubleElement(String str, String str2, double d) throws XMLStreamException {
        return writeStartElement(str, str2).writeDouble(d).writeEndElement();
    }

    public XmlWriter writeFloatElement(String str, float f) throws XMLStreamException {
        return writeFloatElement(null, str, f);
    }

    public XmlWriter writeFloatElement(String str, String str2, float f) throws XMLStreamException {
        return writeStartElement(str, str2).writeFloat(f).writeEndElement();
    }

    public XmlWriter writeIntElement(String str, int i) throws XMLStreamException {
        return writeIntElement(null, str, i);
    }

    public XmlWriter writeIntElement(String str, String str2, int i) throws XMLStreamException {
        return writeStartElement(str, str2).writeInt(i).writeEndElement();
    }

    public XmlWriter writeLongElement(String str, long j) throws XMLStreamException {
        return writeLongElement(null, str, j);
    }

    public XmlWriter writeLongElement(String str, String str2, long j) throws XMLStreamException {
        return writeStartElement(str, str2).writeLong(j).writeEndElement();
    }

    public XmlWriter writeNumberElement(String str, Number number) throws XMLStreamException {
        return writeNumberElement(null, str, number);
    }

    public XmlWriter writeNumberElement(String str, String str2, Number number) throws XMLStreamException {
        return number == null ? this : writeStartElement(str, str2).writeNumber(number).writeEndElement();
    }

    public XmlWriter writeStringElement(String str, String str2) throws XMLStreamException {
        return writeStringElement(null, str, str2);
    }

    public XmlWriter writeStringElement(String str, String str2, String str3) throws XMLStreamException {
        return str3 == null ? this : writeStartElement(str, str2).writeString(str3).writeEndElement();
    }

    public XmlWriter writeXml(XmlSerializable<?> xmlSerializable) throws XMLStreamException {
        return writeXml(xmlSerializable, null);
    }

    public XmlWriter writeXml(XmlSerializable<?> xmlSerializable, String str) throws XMLStreamException {
        return xmlSerializable == null ? this : xmlSerializable.toXml(this, str);
    }

    public XmlWriter writeBinary(byte[] bArr) throws XMLStreamException {
        return bArr == null ? this : writeString(convertBytesToString(bArr));
    }

    public XmlWriter writeBoolean(boolean z) throws XMLStreamException {
        return writeString(String.valueOf(z));
    }

    public XmlWriter writeBoolean(Boolean bool) throws XMLStreamException {
        return bool == null ? this : writeString(String.valueOf(bool));
    }

    public XmlWriter writeDouble(double d) throws XMLStreamException {
        return writeString(String.valueOf(d));
    }

    public XmlWriter writeFloat(float f) throws XMLStreamException {
        return writeString(String.valueOf(f));
    }

    public XmlWriter writeInt(int i) throws XMLStreamException {
        return writeString(String.valueOf(i));
    }

    public XmlWriter writeLong(long j) throws XMLStreamException {
        return writeString(String.valueOf(j));
    }

    public XmlWriter writeNumber(Number number) throws XMLStreamException {
        return number == null ? this : writeString(String.valueOf(number));
    }

    public XmlWriter writeString(String str) throws XMLStreamException {
        if (str == null) {
            return this;
        }
        this.writer.writeCharacters(str);
        return this;
    }

    public XmlWriter writeCDataString(String str) throws XMLStreamException {
        if (str == null) {
            return this;
        }
        this.writer.writeCData(str);
        return this;
    }

    public XmlWriter flush() throws XMLStreamException {
        this.writer.flush();
        return this;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws XMLStreamException {
        this.writer.flush();
        this.writer.close();
    }

    private static String convertBytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(bArr);
    }
}
