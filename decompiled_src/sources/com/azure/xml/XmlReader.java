package com.azure.xml;

import com.azure.xml.implementation.aalto.stax.InputFactoryImpl;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.Base64;
import java.util.Objects;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class XmlReader implements AutoCloseable {
    private static final XMLInputFactory XML_INPUT_FACTORY;
    private String currentElementString;
    private XmlToken currentToken;
    private boolean needToReadElementString = true;
    private final XMLStreamReader reader;

    static {
        XMLInputFactory xMLInputFactoryNewInstance = XMLInputFactory.newInstance();
        if ("com.sun.xml.internal.stream.XMLInputFactoryImpl".equals(xMLInputFactoryNewInstance.getClass().getName())) {
            xMLInputFactoryNewInstance = new InputFactoryImpl();
        }
        XML_INPUT_FACTORY = xMLInputFactoryNewInstance;
        xMLInputFactoryNewInstance.setProperty("javax.xml.stream.isSupportingExternalEntities", false);
        xMLInputFactoryNewInstance.setProperty("javax.xml.stream.supportDTD", false);
    }

    public static XmlReader fromBytes(byte[] bArr) throws XMLStreamException {
        Objects.requireNonNull(bArr, "'xml' cannot be null.");
        return fromStream(new ByteArrayInputStream(bArr));
    }

    public static XmlReader fromString(String str) throws XMLStreamException {
        Objects.requireNonNull(str, "'xml' cannot be null.");
        return fromReader(new StringReader(str));
    }

    public static XmlReader fromStream(InputStream inputStream) throws XMLStreamException {
        Objects.requireNonNull(inputStream, "'xml' cannot be null.");
        return new XmlReader(XML_INPUT_FACTORY.createXMLStreamReader(inputStream));
    }

    public static XmlReader fromReader(Reader reader) throws XMLStreamException {
        Objects.requireNonNull(reader, "'xml' cannot be null.");
        return new XmlReader(XML_INPUT_FACTORY.createXMLStreamReader(reader));
    }

    public static XmlReader fromXmlStreamReader(XMLStreamReader xMLStreamReader) {
        return new XmlReader(xMLStreamReader);
    }

    private XmlReader(XMLStreamReader xMLStreamReader) {
        this.reader = (XMLStreamReader) Objects.requireNonNull(xMLStreamReader, "'reader' cannot be null.");
        this.currentToken = convertEventToToken(xMLStreamReader.getEventType());
    }

    public XmlToken currentToken() {
        return this.currentToken;
    }

    public XmlToken nextElement() throws XMLStreamException {
        int next = this.reader.next();
        while (next != 1 && next != 2 && next != 8) {
            next = this.reader.next();
        }
        XmlToken xmlTokenConvertEventToToken = convertEventToToken(next);
        this.currentToken = xmlTokenConvertEventToToken;
        this.needToReadElementString = true;
        this.currentElementString = null;
        return xmlTokenConvertEventToToken;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws XMLStreamException {
        this.reader.close();
    }

    public QName getElementName() {
        return this.reader.getName();
    }

    public String getElementNamespaceUri() {
        String namespaceURI = this.reader.getNamespaceURI();
        return namespaceURI == null ? "" : namespaceURI;
    }

    public String getElementLocalName() {
        return this.reader.getLocalName();
    }

    public boolean elementNameMatches(String str) {
        return elementNameMatches(null, str);
    }

    public boolean elementNameMatches(String str, String str2) {
        return qNameEquals(this.reader.getNamespaceURI(), this.reader.getLocalName(), str, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void processNextElement(XmlElementConsumer xmlElementConsumer) throws XMLStreamException {
        String namespaceURI = this.reader.getNamespaceURI();
        if (namespaceURI == null) {
            namespaceURI = "";
        }
        xmlElementConsumer.consume(namespaceURI, this.reader.getLocalName(), this);
    }

    public String getStringAttribute(String str, String str2) {
        String attributeValue = this.reader.getAttributeValue(str, str2);
        if ("".equals(attributeValue)) {
            return null;
        }
        return attributeValue;
    }

    public byte[] getBinaryAttribute(String str, String str2) {
        String stringAttribute = getStringAttribute(str, str2);
        if (stringAttribute == null || stringAttribute.isEmpty()) {
            return null;
        }
        return Base64.getDecoder().decode(stringAttribute);
    }

    public boolean getBooleanAttribute(String str, String str2) {
        return Boolean.parseBoolean(getStringAttribute(str, str2));
    }

    public double getDoubleAttribute(String str, String str2) {
        return Double.parseDouble(getStringAttribute(str, str2));
    }

    public float getFloatAttribute(String str, String str2) {
        return Float.parseFloat(getStringAttribute(str, str2));
    }

    public int getIntAttribute(String str, String str2) {
        return Integer.parseInt(getStringAttribute(str, str2));
    }

    public long getLongAttribute(String str, String str2) {
        return Long.parseLong(getStringAttribute(str, str2));
    }

    public <T> T getNullableAttribute(String str, String str2, XmlReadValueCallback<String, T> xmlReadValueCallback) throws XMLStreamException {
        String stringAttribute = getStringAttribute(str, str2);
        if (stringAttribute == null) {
            return null;
        }
        return xmlReadValueCallback.read(stringAttribute);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public String getStringElement() throws XMLStreamException {
        if (!this.needToReadElementString) {
            return this.currentElementString;
        }
        int next = this.reader.next();
        String text = null;
        String[] strArr = null;
        int i = 0;
        int length = 0;
        while (next != 2) {
            if (next == 4 || next == 12 || next == 6 || next == 9) {
                int i2 = i + 1;
                if (i2 == 1) {
                    text = this.reader.getText();
                    length = text.length();
                } else {
                    if (i2 == 2) {
                        strArr = new String[4];
                        strArr[0] = text;
                    }
                    if (i2 > strArr.length - 1) {
                        String[] strArr2 = new String[strArr.length * 2];
                        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                        strArr = strArr2;
                    }
                    String text2 = this.reader.getText();
                    strArr[i] = text2;
                    length += text2.length();
                }
                i = i2;
            } else if (next != 3 && next != 5) {
                throw new XMLStreamException("Unexpected event type while reading element value " + next);
            }
            next = this.reader.next();
        }
        if (i == 0) {
            this.currentElementString = null;
        } else if (i == 1) {
            this.currentElementString = text;
        } else {
            StringBuilder sb = new StringBuilder(length);
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(strArr[i3]);
            }
            this.currentElementString = sb.toString();
        }
        this.needToReadElementString = false;
        return this.currentElementString;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public byte[] getBinaryElement() throws XMLStreamException {
        String stringElement = getStringElement();
        if (stringElement == null || stringElement.isEmpty()) {
            return null;
        }
        return Base64.getDecoder().decode(stringElement);
    }

    public boolean getBooleanElement() throws XMLStreamException {
        return Boolean.parseBoolean(getStringElement());
    }

    public double getDoubleElement() throws XMLStreamException {
        return Double.parseDouble(getStringElement());
    }

    public float getFloatElement() throws XMLStreamException {
        return Float.parseFloat(getStringElement());
    }

    public int getIntElement() throws XMLStreamException {
        return Integer.parseInt(getStringElement());
    }

    public long getLongElement() throws XMLStreamException {
        return Long.parseLong(getStringElement());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public <T> T getNullableElement(XmlReadValueCallback<String, T> xmlReadValueCallback) throws XMLStreamException {
        String stringElement = getStringElement();
        if (stringElement == null) {
            return null;
        }
        return xmlReadValueCallback.read(stringElement);
    }

    public <T> T readObject(String str, XmlReadValueCallback<XmlReader, T> xmlReadValueCallback) throws XMLStreamException {
        return (T) readObject(null, str, xmlReadValueCallback);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public <T> T readObject(String str, String str2, XmlReadValueCallback<XmlReader, T> xmlReadValueCallback) throws XMLStreamException {
        if (currentToken() != XmlToken.START_ELEMENT) {
            nextElement();
        }
        if (currentToken() != XmlToken.START_ELEMENT) {
            throw new IllegalStateException("Illegal start of XML deserialization. Expected 'XmlToken.START_ELEMENT' but it was: 'XmlToken." + currentToken() + "'.");
        }
        String localName = this.reader.getLocalName();
        String namespaceURI = this.reader.getNamespaceURI();
        if (!qNameEquals(namespaceURI, localName, str, str2)) {
            throw new IllegalStateException("Expected XML element to be '" + qNameToString(str, str2) + "' but it was: " + qNameToString(namespaceURI, localName) + "'.");
        }
        return xmlReadValueCallback.read(this);
    }

    private static boolean qNameEquals(String str, String str2, String str3, String str4) {
        if (str3 == null) {
            str3 = "";
        }
        if (str == null) {
            str = "";
        }
        return Objects.equals(str2, str4) && Objects.equals(str, str3);
    }

    private static String qNameToString(String str, String str2) {
        return str == null ? str2 : "{" + str + "}" + str2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void skipElement() throws XMLStreamException {
        if (currentToken() != XmlToken.START_ELEMENT) {
            return;
        }
        int i = 1;
        while (i > 0) {
            XmlToken xmlTokenNextElement = nextElement();
            if (xmlTokenNextElement == XmlToken.START_ELEMENT) {
                i++;
            } else if (xmlTokenNextElement != XmlToken.END_ELEMENT) {
                return;
            } else {
                i--;
            }
        }
    }

    private static XmlToken convertEventToToken(int i) {
        if (i == 1) {
            return XmlToken.START_ELEMENT;
        }
        if (i == 2) {
            return XmlToken.END_ELEMENT;
        }
        if (i == 7) {
            return XmlToken.START_DOCUMENT;
        }
        if (i == 8) {
            return XmlToken.END_DOCUMENT;
        }
        throw new IllegalStateException("Unknown/unsupported XMLStreamConstants: " + i);
    }
}
