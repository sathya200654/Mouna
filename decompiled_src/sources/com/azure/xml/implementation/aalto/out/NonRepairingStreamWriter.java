package com.azure.xml.implementation.aalto.out;

import com.azure.xml.implementation.aalto.impl.ErrorConsts;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NonRepairingStreamWriter extends StreamWriterBase {
    public NonRepairingStreamWriter(WriterConfig writerConfig, XmlWriter xmlWriter, WNameTable wNameTable) {
        super(writerConfig, xmlWriter, wNameTable);
    }

    @Override // com.azure.xml.implementation.aalto.out.StreamWriterBase
    public void setDefaultNamespace(String str) {
        this._currElem.setDefaultNsURI(str);
    }

    @Override // com.azure.xml.implementation.aalto.out.StreamWriterBase
    public void _setPrefix(String str, String str2) {
        this._currElem.addPrefix(str, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.StreamWriterBase
    public void writeAttribute(String str, String str2, String str3) throws XMLStreamException {
        WName wNameFindSymbol;
        if (!this._stateStartElementOpen) {
            throwOutputError(ErrorConsts.WERR_ATTR_NO_ELEM);
        }
        if (str == null || str.isEmpty()) {
            wNameFindSymbol = this._symbols.findSymbol(str2);
        } else {
            String explicitPrefix = this._currElem.getExplicitPrefix(str, this._rootNsContext);
            if (explicitPrefix == null) {
                throwOutputError("Unbound namespace URI '" + str + "'");
            }
            wNameFindSymbol = this._symbols.findSymbol(explicitPrefix, str2);
        }
        _writeAttribute(wNameFindSymbol, str3);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.StreamWriterBase
    public void writeAttribute(String str, String str2, String str3, String str4) throws XMLStreamException {
        WName wNameFindSymbol;
        if (!this._stateStartElementOpen) {
            throwOutputError(ErrorConsts.WERR_ATTR_NO_ELEM);
        }
        if (str == null || str.isEmpty()) {
            wNameFindSymbol = this._symbols.findSymbol(str3);
        } else {
            wNameFindSymbol = this._symbols.findSymbol(str, str3);
        }
        _writeAttribute(wNameFindSymbol, str4);
    }

    @Override // com.azure.xml.implementation.aalto.out.StreamWriterBase
    public void writeDefaultNamespace(String str) throws XMLStreamException {
        if (!this._stateStartElementOpen) {
            throwOutputError(ErrorConsts.WERR_NS_NO_ELEM);
        }
        _writeDefaultNamespace(str);
        setDefaultNamespace(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.StreamWriterBase
    public void writeEmptyElement(String str, String str2) throws XMLStreamException {
        WName wNameFindSymbol;
        String prefix = this._currElem.getPrefix(str);
        if (prefix == null) {
            throwOutputError("Unbound namespace URI '" + str + "'");
        }
        if (prefix.isEmpty()) {
            wNameFindSymbol = this._symbols.findSymbol(str2);
            prefix = null;
        } else {
            wNameFindSymbol = this._symbols.findSymbol(prefix, str2);
        }
        _verifyStartElement(prefix, str2);
        _writeStartTag(wNameFindSymbol, true, str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.StreamWriterBase
    public void writeEmptyElement(String str, String str2, String str3) throws XMLStreamException {
        WName wNameFindSymbol;
        _verifyStartElement(str, str2);
        if (str == null || str.isEmpty()) {
            wNameFindSymbol = this._symbols.findSymbol(str2);
        } else {
            wNameFindSymbol = this._symbols.findSymbol(str, str2);
        }
        _writeStartTag(wNameFindSymbol, true, str3);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.StreamWriterBase
    public void writeNamespace(String str, String str2) throws XMLStreamException {
        if (str == null || str.isEmpty()) {
            writeDefaultNamespace(str2);
            return;
        }
        if (!this._stateStartElementOpen) {
            throwOutputError(ErrorConsts.WERR_NS_NO_ELEM);
        }
        _writeNamespace(str, str2);
        setPrefix(str, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.StreamWriterBase
    public void writeStartElement(String str, String str2) throws XMLStreamException {
        WName wNameFindSymbol;
        String prefix = this._currElem.getPrefix(str);
        if (prefix == null) {
            throwOutputError("Unbound namespace URI '" + str + "'");
        }
        if (prefix.isEmpty()) {
            wNameFindSymbol = this._symbols.findSymbol(str2);
            prefix = null;
        } else {
            wNameFindSymbol = this._symbols.findSymbol(prefix, str2);
        }
        _verifyStartElement(prefix, str2);
        _writeStartTag(wNameFindSymbol, false);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.out.StreamWriterBase
    public void writeStartElement(String str, String str2, String str3) throws XMLStreamException {
        WName wNameFindSymbol;
        _verifyStartElement(str, str2);
        if (str == null || str.isEmpty()) {
            wNameFindSymbol = this._symbols.findSymbol(str2);
        } else {
            wNameFindSymbol = this._symbols.findSymbol(str, str2);
        }
        _writeStartTag(wNameFindSymbol, false, str3);
    }
}
