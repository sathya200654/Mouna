package com.azure.xml.implementation.aalto.stax;

import com.azure.xml.implementation.aalto.out.AsciiXmlWriter;
import com.azure.xml.implementation.aalto.out.CharXmlWriter;
import com.azure.xml.implementation.aalto.out.Latin1XmlWriter;
import com.azure.xml.implementation.aalto.out.NonRepairingStreamWriter;
import com.azure.xml.implementation.aalto.out.Utf8XmlWriter;
import com.azure.xml.implementation.aalto.out.WNameTable;
import com.azure.xml.implementation.aalto.out.WriterConfig;
import com.azure.xml.implementation.aalto.out.XmlWriter;
import com.azure.xml.implementation.aalto.util.CharsetNames;
import com.azure.xml.implementation.stax2.XMLOutputFactory2;
import com.azure.xml.implementation.stax2.XMLStreamWriter2;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class OutputFactoryImpl extends XMLOutputFactory2 {
    private final WriterConfig _config = new WriterConfig();

    public XMLEventWriter createXMLEventWriter(OutputStream outputStream) {
        throw new UnsupportedOperationException();
    }

    public XMLEventWriter createXMLEventWriter(OutputStream outputStream, String str) {
        throw new UnsupportedOperationException();
    }

    public XMLEventWriter createXMLEventWriter(Result result) {
        throw new UnsupportedOperationException();
    }

    public XMLEventWriter createXMLEventWriter(Writer writer) {
        throw new UnsupportedOperationException();
    }

    public XMLStreamWriter createXMLStreamWriter(OutputStream outputStream) throws XMLStreamException {
        return createXMLStreamWriter(outputStream, null);
    }

    public XMLStreamWriter createXMLStreamWriter(OutputStream outputStream, String str) throws XMLStreamException {
        return createSW(outputStream, null, str);
    }

    public XMLStreamWriter createXMLStreamWriter(Result result) {
        throw new UnsupportedOperationException();
    }

    public XMLStreamWriter createXMLStreamWriter(Writer writer) throws XMLStreamException {
        return createSW(null, writer, null);
    }

    public Object getProperty(String str) {
        return this._config.getProperty(str, true);
    }

    public boolean isPropertySupported(String str) {
        return this._config.isPropertySupported(str);
    }

    public void setProperty(String str, Object obj) {
        this._config.setProperty(str, obj);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private XMLStreamWriter2 createSW(OutputStream outputStream, Writer writer, String str) throws XMLStreamException {
        CharXmlWriter charXmlWriter;
        WNameTable charSymbols;
        XmlWriter asciiXmlWriter;
        WriterConfig writerConfigCreateNonShared = this._config.createNonShared();
        if (writer == null) {
            if (str == null) {
                str = "UTF-8";
            } else if (!str.equals("UTF-8") && !str.equals(CharsetNames.CS_ISO_LATIN1) && !str.equals(CharsetNames.CS_US_ASCII)) {
                str = CharsetNames.normalize(str);
            }
            writerConfigCreateNonShared.setActualEncodingIfNotSet(str);
            try {
                if (str.equals("UTF-8")) {
                    asciiXmlWriter = new Utf8XmlWriter(writerConfigCreateNonShared, outputStream);
                    charSymbols = this._config.getUtf8Symbols(asciiXmlWriter);
                } else if (str.equals(CharsetNames.CS_ISO_LATIN1)) {
                    asciiXmlWriter = new Latin1XmlWriter(writerConfigCreateNonShared, outputStream);
                    charSymbols = this._config.getLatin1Symbols(asciiXmlWriter);
                } else if (str.equals(CharsetNames.CS_US_ASCII)) {
                    asciiXmlWriter = new AsciiXmlWriter(writerConfigCreateNonShared, outputStream);
                    charSymbols = this._config.getAsciiSymbols(asciiXmlWriter);
                } else {
                    charXmlWriter = new CharXmlWriter(writerConfigCreateNonShared, new OutputStreamWriter(outputStream, str));
                    charSymbols = this._config.getCharSymbols(charXmlWriter);
                }
                return new NonRepairingStreamWriter(writerConfigCreateNonShared, asciiXmlWriter, charSymbols);
            } catch (IOException e) {
                throw new XMLStreamException(e);
            }
        }
        if (str == null) {
            str = CharsetNames.findEncodingFor(writer);
        }
        if (str != null) {
            writerConfigCreateNonShared.setActualEncodingIfNotSet(str);
        }
        charXmlWriter = new CharXmlWriter(writerConfigCreateNonShared, writer);
        charSymbols = this._config.getCharSymbols(charXmlWriter);
        asciiXmlWriter = charXmlWriter;
        return new NonRepairingStreamWriter(writerConfigCreateNonShared, asciiXmlWriter, charSymbols);
    }
}
