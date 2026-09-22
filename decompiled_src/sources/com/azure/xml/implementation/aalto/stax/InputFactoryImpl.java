package com.azure.xml.implementation.aalto.stax;

import com.azure.xml.implementation.aalto.in.ByteSourceBootstrapper;
import com.azure.xml.implementation.aalto.in.CharSourceBootstrapper;
import com.azure.xml.implementation.aalto.in.ReaderConfig;
import com.azure.xml.implementation.stax2.XMLInputFactory2;
import java.io.InputStream;
import java.io.Reader;
import javax.xml.stream.EventFilter;
import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLReporter;
import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.XMLEventAllocator;
import javax.xml.transform.Source;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class InputFactoryImpl extends XMLInputFactory2 {
    private XMLEventAllocator _allocator = null;
    final ReaderConfig _config = new ReaderConfig();

    public XMLEventReader createFilteredReader(XMLEventReader xMLEventReader, EventFilter eventFilter) {
        throw new UnsupportedOperationException();
    }

    public XMLStreamReader createFilteredReader(XMLStreamReader xMLStreamReader, StreamFilter streamFilter) {
        throw new UnsupportedOperationException();
    }

    public XMLEventReader createXMLEventReader(InputStream inputStream) {
        throw new UnsupportedOperationException();
    }

    public XMLEventReader createXMLEventReader(InputStream inputStream, String str) {
        throw new UnsupportedOperationException();
    }

    public XMLEventReader createXMLEventReader(Reader reader) {
        throw new UnsupportedOperationException();
    }

    public XMLEventReader createXMLEventReader(Source source) {
        throw new UnsupportedOperationException();
    }

    public XMLEventReader createXMLEventReader(String str, InputStream inputStream) {
        throw new UnsupportedOperationException();
    }

    public XMLEventReader createXMLEventReader(String str, Reader reader) {
        throw new UnsupportedOperationException();
    }

    public XMLEventReader createXMLEventReader(XMLStreamReader xMLStreamReader) {
        throw new UnsupportedOperationException();
    }

    public XMLStreamReader createXMLStreamReader(InputStream inputStream) throws XMLStreamException {
        return constructSR(inputStream, null);
    }

    public XMLStreamReader createXMLStreamReader(InputStream inputStream, String str) throws XMLStreamException {
        return constructSR(inputStream, str);
    }

    public XMLStreamReader createXMLStreamReader(Reader reader) throws XMLStreamException {
        return constructSR(reader);
    }

    public XMLStreamReader createXMLStreamReader(String str, Reader reader) {
        throw new UnsupportedOperationException();
    }

    public XMLStreamReader createXMLStreamReader(Source source) {
        throw new UnsupportedOperationException();
    }

    public XMLStreamReader createXMLStreamReader(String str, InputStream inputStream) {
        throw new UnsupportedOperationException();
    }

    public Object getProperty(String str) {
        return this._config.getProperty(str, true);
    }

    public void setProperty(String str, Object obj) {
        this._config.setProperty(str, obj);
    }

    public XMLEventAllocator getEventAllocator() {
        return this._allocator;
    }

    public XMLReporter getXMLReporter() {
        return this._config.getXMLReporter();
    }

    public XMLResolver getXMLResolver() {
        return this._config.getXMLResolver();
    }

    public boolean isPropertySupported(String str) {
        return this._config.isPropertySupported(str);
    }

    public void setEventAllocator(XMLEventAllocator xMLEventAllocator) {
        this._allocator = xMLEventAllocator;
    }

    public void setXMLReporter(XMLReporter xMLReporter) {
        this._config.setXMLReporter(xMLReporter);
    }

    public void setXMLResolver(XMLResolver xMLResolver) {
        this._config.setXMLResolver(xMLResolver);
    }

    public ReaderConfig getNonSharedConfig(String str) {
        return this._config.createNonShared(str);
    }

    private XMLStreamReader constructSR(InputStream inputStream, String str) throws XMLStreamException {
        return StreamReaderImpl.construct(ByteSourceBootstrapper.construct(getNonSharedConfig(str), inputStream));
    }

    private XMLStreamReader constructSR(Reader reader) throws XMLStreamException {
        return StreamReaderImpl.construct(CharSourceBootstrapper.construct(getNonSharedConfig(null), reader));
    }
}
