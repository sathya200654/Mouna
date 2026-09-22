package com.azure.xml.implementation.aalto.out;

import com.azure.xml.implementation.aalto.impl.ErrorConsts;
import com.azure.xml.implementation.aalto.impl.IoStreamException;
import com.azure.xml.implementation.aalto.impl.LocationImpl;
import com.azure.xml.implementation.aalto.impl.StreamExceptionBase;
import com.azure.xml.implementation.aalto.util.XmlConsts;
import com.azure.xml.implementation.stax2.ri.Stax2WriterImpl;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class StreamWriterBase extends Stax2WriterImpl implements NamespaceContext {
    static final int MAX_POOL_SIZE = 8;
    protected final WriterConfig _config;
    protected NamespaceContext _rootNsContext;
    protected WNameTable _symbols;
    protected final XmlWriter _xmlWriter;
    protected State _state = State.PROLOG;
    protected OutputElement _currElem = OutputElement.createRoot();
    protected boolean _stateAnyOutput = false;
    protected boolean _stateStartElementOpen = false;
    protected boolean _stateEmptyElement = false;
    protected String _dtdRootElemName = null;
    protected OutputElement _outputElemPool = null;
    protected int _poolSize = 0;

    protected enum State {
        PROLOG,
        TREE,
        EPILOG
    }

    protected abstract void _setPrefix(String str, String str2);

    public final NamespaceContext getNamespaceContext() {
        return this;
    }

    public abstract void setDefaultNamespace(String str) throws XMLStreamException;

    public abstract void writeAttribute(String str, String str2, String str3) throws XMLStreamException;

    public abstract void writeAttribute(String str, String str2, String str3, String str4) throws XMLStreamException;

    public abstract void writeDefaultNamespace(String str) throws XMLStreamException;

    public abstract void writeEmptyElement(String str, String str2) throws XMLStreamException;

    public abstract void writeEmptyElement(String str, String str2, String str3) throws XMLStreamException;

    public abstract void writeNamespace(String str, String str2) throws XMLStreamException;

    public abstract void writeStartElement(String str, String str2) throws XMLStreamException;

    public abstract void writeStartElement(String str, String str2, String str3) throws XMLStreamException;

    protected StreamWriterBase(WriterConfig writerConfig, XmlWriter xmlWriter, WNameTable wNameTable) {
        this._config = writerConfig;
        this._xmlWriter = xmlWriter;
        this._symbols = wNameTable;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void close() throws XMLStreamException {
        _finishDocument();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void flush() throws XMLStreamException {
        try {
            this._xmlWriter.flush();
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    public Object getProperty(String str) {
        return this._config.getProperty(str, true);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void setNamespaceContext(NamespaceContext namespaceContext) throws XMLStreamException {
        if (this._state != State.PROLOG) {
            throwOutputError("Called setNamespaceContext() after having already output root element.");
        }
        this._rootNsContext = namespaceContext;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void setPrefix(String str, String str2) throws XMLStreamException {
        str.getClass();
        if (str.isEmpty()) {
            setDefaultNamespace(str2);
            return;
        }
        str2.getClass();
        if (str.equals("xml")) {
            if (!str2.equals("http://www.w3.org/XML/1998/namespace")) {
                throwOutputError(ErrorConsts.ERR_NS_REDECL_XML, str2);
            }
        } else if (str.equals("xmlns")) {
            if (!str2.equals("http://www.w3.org/2000/xmlns/")) {
                throwOutputError(ErrorConsts.ERR_NS_REDECL_XMLNS, str2);
            }
        } else if (str2.equals("http://www.w3.org/XML/1998/namespace")) {
            throwOutputError(ErrorConsts.ERR_NS_REDECL_XML_URI, str);
        } else if (str2.equals("http://www.w3.org/2000/xmlns/")) {
            throwOutputError(ErrorConsts.ERR_NS_REDECL_XMLNS_URI, str);
        }
        if (str2.isEmpty()) {
            throwOutputError(ErrorConsts.ERR_NS_EMPTY);
        }
        _setPrefix(str, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void writeAttribute(String str, String str2) throws XMLStreamException {
        if (!this._stateStartElementOpen) {
            throwOutputError(ErrorConsts.WERR_ATTR_NO_ELEM);
        }
        _writeAttribute(this._symbols.findSymbol(str), str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeCData(String str) throws XMLStreamException {
        _verifyWriteCData();
        try {
            int iWriteCData = this._xmlWriter.writeCData(str);
            if (iWriteCData >= 0) {
                _reportNwfContent(ErrorConsts.WERR_CDATA_CONTENT, Integer.valueOf(iWriteCData));
            }
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeCharacters(char[] cArr, int i, int i2) throws XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        if (inPrologOrEpilog()) {
            writeSpace(cArr, i, i2);
        } else if (i2 > 0) {
            try {
                this._xmlWriter.writeCharacters(cArr, i, i2);
            } catch (IOException e) {
                throw new IoStreamException(e);
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeCharacters(String str) throws XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        if (inPrologOrEpilog()) {
            writeSpace(str);
            return;
        }
        try {
            this._xmlWriter.writeCharacters(str);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeComment(String str) throws XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        try {
            int iWriteComment = this._xmlWriter.writeComment(str);
            if (iWriteComment >= 0) {
                _reportNwfContent(ErrorConsts.WERR_COMMENT_CONTENT, Integer.valueOf(iWriteComment));
            }
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void writeDTD(String str) throws XMLStreamException {
        _verifyWriteDTD();
        this._dtdRootElemName = "";
        try {
            this._xmlWriter.writeDTD(str);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeEmptyElement(String str) throws XMLStreamException {
        _verifyStartElement(null, str);
        _writeStartTag(this._symbols.findSymbol(str), true);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeEndDocument() throws XMLStreamException {
        _finishDocument();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeEndElement() throws XMLStreamException {
        if (this._stateStartElementOpen && this._stateEmptyElement) {
            this._stateEmptyElement = false;
            _closeStartElement(true);
        }
        if (this._state != State.TREE) {
            _reportNwfStructure("No open start element, when trying to write end element");
        }
        OutputElement outputElement = this._currElem;
        this._currElem = outputElement.getParent();
        if (this._poolSize < 8) {
            outputElement.addToPool(this._outputElemPool);
            this._outputElemPool = outputElement;
            this._poolSize++;
        }
        try {
            if (this._stateStartElementOpen) {
                this._stateStartElementOpen = false;
                this._xmlWriter.writeStartTagEmptyEnd();
            } else {
                this._xmlWriter.writeEndTag(outputElement.getName());
            }
            if (this._currElem.isRoot()) {
                this._state = State.EPILOG;
            }
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeEntityRef(String str) throws XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        if (inPrologOrEpilog()) {
            _reportNwfStructure(ErrorConsts.WERR_PROLOG_ENTITY);
        }
        try {
            this._xmlWriter.writeEntityReference(this._symbols.findSymbol(str));
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeProcessingInstruction(String str) throws XMLStreamException {
        writeProcessingInstruction(str, null);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeProcessingInstruction(String str, String str2) throws XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        try {
            int iWritePI = this._xmlWriter.writePI(this._symbols.findSymbol(str), str2);
            if (iWritePI >= 0) {
                _reportNwfContent(ErrorConsts.WERR_PI_CONTENT, Integer.valueOf(iWritePI));
            }
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeStartDocument() throws XMLStreamException {
        String actualEncoding = this._config.getActualEncoding();
        if (actualEncoding == null) {
            this._config.setActualEncodingIfNotSet("UTF-8");
            actualEncoding = "UTF-8";
        }
        _writeStartDocument("1.0", actualEncoding);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeStartDocument(String str) throws XMLStreamException {
        _writeStartDocument(str, this._config.getActualEncoding());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeStartDocument(String str, String str2) throws XMLStreamException {
        _writeStartDocument(str2, str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeStartElement(String str) throws XMLStreamException {
        _verifyStartElement(null, str);
        _writeStartTag(this._symbols.findSymbol(str), false);
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String str) {
        NamespaceContext namespaceContext;
        String namespaceURI = this._currElem.getNamespaceURI(str);
        return (namespaceURI != null || (namespaceContext = this._rootNsContext) == null) ? namespaceURI : namespaceContext.getNamespaceURI(str);
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getPrefix(String str) {
        NamespaceContext namespaceContext;
        String prefix = this._currElem.getPrefix(str);
        return (prefix != null || (namespaceContext = this._rootNsContext) == null) ? prefix : namespaceContext.getPrefix(str);
    }

    @Override // javax.xml.namespace.NamespaceContext
    public Iterator<String> getPrefixes(String str) {
        return this._currElem.getPrefixes(str, this._rootNsContext);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.stax2.ri.Stax2WriterImpl, com.azure.xml.implementation.stax2.XMLStreamWriter2
    public void writeSpace(String str) throws XMLStreamException {
        try {
            this._xmlWriter.writeSpace(str);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.stax2.ri.Stax2WriterImpl, com.azure.xml.implementation.stax2.XMLStreamWriter2
    public void writeSpace(char[] cArr, int i, int i2) throws XMLStreamException {
        try {
            this._xmlWriter.writeSpace(cArr, i, i2);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    @Override // com.azure.xml.implementation.stax2.ri.Stax2WriterImpl, com.azure.xml.implementation.stax2.XMLStreamWriter2
    public Location getLocation() {
        return new LocationImpl(this._xmlWriter.getAbsOffset(), this._xmlWriter.getRow(), this._xmlWriter.getColumn());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.stax2.ri.Stax2WriterImpl, com.azure.xml.implementation.stax2.XMLStreamWriter2
    public void writeRaw(String str) throws XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        try {
            this._xmlWriter.writeRaw(str, 0, str.length());
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.stax2.ri.Stax2WriterImpl, com.azure.xml.implementation.stax2.XMLStreamWriter2
    public void writeRaw(String str, int i, int i2) throws XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        try {
            this._xmlWriter.writeRaw(str, i, i2);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.stax2.ri.Stax2WriterImpl, com.azure.xml.implementation.stax2.XMLStreamWriter2
    public void writeRaw(char[] cArr, int i, int i2) throws XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        try {
            this._xmlWriter.writeRaw(cArr, i, i2);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void _closeStartElement(boolean z) throws XMLStreamException {
        this._stateStartElementOpen = false;
        try {
            if (z) {
                this._xmlWriter.writeStartTagEmptyEnd();
            } else {
                this._xmlWriter.writeStartTagEnd();
            }
            if (z) {
                OutputElement outputElement = this._currElem;
                OutputElement parent = outputElement.getParent();
                this._currElem = parent;
                if (parent.isRoot()) {
                    this._state = State.EPILOG;
                }
                if (this._poolSize < 8) {
                    outputElement.addToPool(this._outputElemPool);
                    this._outputElemPool = outputElement;
                    this._poolSize++;
                }
            }
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    protected final boolean inPrologOrEpilog() {
        return this._state != State.TREE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void _writeAttribute(WName wName, String str) throws XMLStreamException {
        try {
            this._xmlWriter.writeAttribute(wName, str);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void _writeDefaultNamespace(String str) throws XMLStreamException {
        try {
            this._xmlWriter.writeAttribute(this._symbols.findSymbol("xmlns"), str);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void _writeNamespace(String str, String str2) throws XMLStreamException {
        try {
            this._xmlWriter.writeAttribute(this._symbols.findSymbol("xmlns", str), str2);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void _writeStartDocument(String str, String str2) throws XMLStreamException {
        if (this._stateAnyOutput) {
            _reportNwfStructure(ErrorConsts.WERR_DUP_XML_DECL);
        }
        this._stateAnyOutput = true;
        if (str != null && !str.isEmpty() && !str.equals("1.0") && !str.equals(XmlConsts.XML_V_11_STR)) {
            _reportNwfContent("Illegal version argument ('" + str + "'); should only use '1.0' or '1.1'");
        }
        if (str == null || str.isEmpty()) {
            str = "1.0";
        }
        if (XmlConsts.XML_V_11_STR.equals(str)) {
            this._xmlWriter.enableXml11();
        }
        if (str2 != null && !str2.isEmpty()) {
            this._config.setActualEncodingIfNotSet(str2);
        }
        try {
            this._xmlWriter.writeXmlDeclaration(str, str2, null);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void _writeStartTag(WName wName, boolean z) throws XMLStreamException {
        this._stateAnyOutput = true;
        this._stateStartElementOpen = true;
        OutputElement outputElement = this._outputElemPool;
        if (outputElement != null) {
            this._outputElemPool = outputElement.reuseAsChild(this._currElem, wName);
            this._poolSize--;
            this._currElem = outputElement;
        } else {
            this._currElem = this._currElem.createChild(wName);
        }
        try {
            this._xmlWriter.writeStartTagStart(wName);
            this._stateEmptyElement = z;
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void _writeStartTag(WName wName, boolean z, String str) throws XMLStreamException {
        this._stateAnyOutput = true;
        this._stateStartElementOpen = true;
        if (str == null) {
            str = "";
        }
        OutputElement outputElement = this._outputElemPool;
        if (outputElement != null) {
            this._outputElemPool = outputElement.reuseAsChild(this._currElem, wName, str);
            this._poolSize--;
            this._currElem = outputElement;
        } else {
            this._currElem = this._currElem.createChild(wName, str);
        }
        try {
            this._xmlWriter.writeStartTagStart(wName);
            this._stateEmptyElement = z;
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void _verifyStartElement(String str, String str2) throws XMLStreamException {
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
            return;
        }
        if (this._state == State.PROLOG) {
            _verifyRootElement();
        } else if (this._state == State.EPILOG) {
            if (str != null) {
                str2 = str + ":" + str2;
            }
            _reportNwfStructure(ErrorConsts.WERR_PROLOG_SECOND_ROOT, str2);
            this._state = State.TREE;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void _verifyWriteCData() throws XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        if (inPrologOrEpilog()) {
            _reportNwfStructure(ErrorConsts.WERR_PROLOG_CDATA);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void _verifyWriteDTD() throws XMLStreamException {
        if (this._state != State.PROLOG) {
            throw new XMLStreamException("Can not write DOCTYPE declaration (DTD) when not in prolog any more (state " + this._state + "; start element(s) written)");
        }
        if (this._dtdRootElemName != null) {
            throw new XMLStreamException("Trying to write multiple DOCTYPE declarations");
        }
    }

    protected void _verifyRootElement() {
        this._state = State.TREE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void throwOutputError(String str) throws XMLStreamException {
        throw new StreamExceptionBase(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void throwOutputError(String str, Object obj) throws XMLStreamException {
        throwOutputError(MessageFormat.format(str, obj));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void _reportNwfStructure(String str) throws XMLStreamException {
        throwOutputError(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void _reportNwfStructure(String str, Object obj) throws XMLStreamException {
        throwOutputError(str, obj);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void _reportNwfContent(String str) throws XMLStreamException {
        throwOutputError(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void _reportNwfContent(String str, Object obj) throws XMLStreamException {
        throwOutputError(str, obj);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void _finishDocument() throws XMLStreamException {
        if (this._state != State.EPILOG) {
            if (this._state == State.PROLOG) {
                _reportNwfStructure(ErrorConsts.WERR_PROLOG_NO_ROOT);
            }
            if (this._stateStartElementOpen) {
                _closeStartElement(this._stateEmptyElement);
            }
            while (this._state != State.EPILOG) {
                writeEndElement();
            }
        }
        if (this._symbols.maybeDirty()) {
            this._symbols.mergeToParent();
        }
        try {
            this._xmlWriter.close(false);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("[StreamWriter: ").append(getClass()).append(", underlying outputter: ");
        XmlWriter xmlWriter = this._xmlWriter;
        return sbAppend.append(xmlWriter == null ? "NULL" : xmlWriter.toString()).toString();
    }
}
