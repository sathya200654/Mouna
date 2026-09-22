package com.azure.xml.implementation.aalto.stax;

import com.azure.xml.implementation.aalto.UncheckedStreamException;
import com.azure.xml.implementation.aalto.WFCException;
import com.azure.xml.implementation.aalto.impl.ErrorConsts;
import com.azure.xml.implementation.aalto.in.InputBootstrapper;
import com.azure.xml.implementation.aalto.in.PName;
import com.azure.xml.implementation.aalto.in.XmlScanner;
import com.azure.xml.implementation.aalto.util.TextAccumulator;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class StreamReaderImpl implements XMLStreamReader {
    private static final int MASK_GET_ELEMENT_TEXT = 4688;
    private static final int MASK_GET_TEXT = 6768;
    private static final int MASK_GET_TEXT_XXX = 4208;
    static final int STATE_CLOSED = 3;
    static final int STATE_EPILOG = 2;
    static final int STATE_PROLOG = 0;
    static final int STATE_TREE = 1;
    protected int _attrCount;
    protected final boolean _cfgCoalesceText;
    protected PName _currName;
    protected int _currToken = 7;
    protected PName _dtdRootName;
    protected int _parseState;
    protected final XmlScanner _scanner;

    public StreamReaderImpl(XmlScanner xmlScanner) {
        this._scanner = xmlScanner;
        this._cfgCoalesceText = xmlScanner.getConfig().willCoalesceText();
    }

    public static StreamReaderImpl construct(InputBootstrapper inputBootstrapper) throws XMLStreamException {
        return new StreamReaderImpl(inputBootstrapper.bootstrap());
    }

    public final String getCharacterEncodingScheme() {
        return this._scanner.getConfig().getXmlDeclEncoding();
    }

    public final String getEncoding() {
        return this._scanner.getConfig().getActualEncoding();
    }

    public String getVersion() {
        return this._scanner.getConfig().getXmlDeclVersion();
    }

    public final boolean isStandalone() {
        return this._scanner.getConfig().getXmlDeclStandalone() == 1;
    }

    public final boolean standaloneSet() {
        return this._scanner.getConfig().getXmlDeclStandalone() != 0;
    }

    public Object getProperty(String str) {
        if (str.equals("javax.xml.stream.entities")) {
            return Collections.EMPTY_LIST;
        }
        if (str.equals("javax.xml.stream.notations")) {
            return Collections.EMPTY_LIST;
        }
        return this._scanner.getConfig().getProperty(str, false);
    }

    public final int getAttributeCount() {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        return this._attrCount;
    }

    public final String getAttributeLocalName(int i) {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        if (i >= this._attrCount || i < 0) {
            reportInvalidAttrIndex(i);
        }
        return this._scanner.getAttrLocalName(i);
    }

    public final QName getAttributeName(int i) {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        if (i >= this._attrCount || i < 0) {
            reportInvalidAttrIndex(i);
        }
        return this._scanner.getAttrQName(i);
    }

    public final String getAttributeNamespace(int i) {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        if (i >= this._attrCount || i < 0) {
            reportInvalidAttrIndex(i);
        }
        String attrNsURI = this._scanner.getAttrNsURI(i);
        return attrNsURI == null ? "" : attrNsURI;
    }

    public final String getAttributePrefix(int i) {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        if (i >= this._attrCount || i < 0) {
            reportInvalidAttrIndex(i);
        }
        String attrPrefix = this._scanner.getAttrPrefix(i);
        return attrPrefix == null ? "" : attrPrefix;
    }

    public final String getAttributeType(int i) {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        if (i >= this._attrCount || i < 0) {
            reportInvalidAttrIndex(i);
            return "CDATA";
        }
        return "CDATA";
    }

    public final String getAttributeValue(int i) {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        if (i >= this._attrCount || i < 0) {
            reportInvalidAttrIndex(i);
        }
        return this._scanner.getAttrValue(i);
    }

    public final String getAttributeValue(String str, String str2) {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        return this._scanner.getAttrValue(str, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final String getElementText() throws XMLStreamException {
        if (this._currToken != 1) {
            throwWfe(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        while (true) {
            int next = next();
            if (next == 2) {
                return "";
            }
            if (next != 5 && next != 3) {
                if (((1 << next) & MASK_GET_ELEMENT_TEXT) == 0) {
                    _reportNonTextEvent(next);
                }
                String text = this._scanner.getText();
                TextAccumulator textAccumulator = null;
                while (true) {
                    int next2 = next();
                    if (next2 == 2) {
                        break;
                    }
                    if (((1 << next2) & MASK_GET_ELEMENT_TEXT) != 0) {
                        if (textAccumulator == null) {
                            textAccumulator = new TextAccumulator();
                            textAccumulator.addText(text);
                        }
                        textAccumulator.addText(getText());
                    } else if (next2 != 5 && next2 != 3) {
                        _reportNonTextEvent(next2);
                    }
                }
                return textAccumulator == null ? text : textAccumulator.getAndClear();
            }
        }
    }

    public final int getEventType() {
        int i = this._currToken;
        if (i == 12 && this._cfgCoalesceText) {
            return 4;
        }
        return i;
    }

    public final String getLocalName() {
        int i = this._currToken;
        if (i == 1 || i == 2 || i == 9) {
            return this._currName.getLocalName();
        }
        throw new IllegalStateException("Current state not START_ELEMENT, END_ELEMENT or ENTITY_REFERENCE");
    }

    public final QName getName() {
        int i = this._currToken;
        if (i != 1 && i != 2) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_ELEM);
        }
        return this._scanner.getQName();
    }

    public final NamespaceContext getNamespaceContext() {
        return this._scanner;
    }

    public final int getNamespaceCount() {
        int i = this._currToken;
        if (i != 1 && i != 2) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_ELEM);
        }
        return this._scanner.getNsCount();
    }

    public final String getNamespacePrefix(int i) {
        int i2 = this._currToken;
        if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_ELEM);
        }
        String namespacePrefix = this._scanner.getNamespacePrefix(i);
        return namespacePrefix == null ? "" : namespacePrefix;
    }

    public final String getNamespaceURI() {
        int i = this._currToken;
        if (i != 1 && i != 2) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_ELEM);
        }
        String namespaceURI = this._scanner.getNamespaceURI();
        return namespaceURI == null ? "" : namespaceURI;
    }

    public final String getNamespaceURI(int i) {
        int i2 = this._currToken;
        if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_ELEM);
        }
        String namespaceURI = this._scanner.getNamespaceURI(i);
        return namespaceURI == null ? "" : namespaceURI;
    }

    public final String getNamespaceURI(String str) {
        int i = this._currToken;
        if (i != 1 && i != 2) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_ELEM);
        }
        return this._scanner.getNamespaceURI(str);
    }

    public final String getPIData() {
        if (this._currToken != 3) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_PI);
        }
        try {
            return this._scanner.getText();
        } catch (XMLStreamException e) {
            throw UncheckedStreamException.createFrom(e);
        }
    }

    public final String getPITarget() {
        if (this._currToken != 3) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_PI);
        }
        return this._currName.getLocalName();
    }

    public final String getPrefix() {
        int i = this._currToken;
        if (i != 1 && i != 2) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_ELEM);
        }
        String prefix = this._currName.getPrefix();
        return prefix == null ? "" : prefix;
    }

    public final String getText() {
        if (((1 << this._currToken) & MASK_GET_TEXT) == 0) {
            throwNotTextual();
        }
        try {
            return this._scanner.getText();
        } catch (XMLStreamException e) {
            throw UncheckedStreamException.createFrom(e);
        }
    }

    public final char[] getTextCharacters() {
        if (((1 << this._currToken) & MASK_GET_TEXT_XXX) == 0) {
            throwNotTextXxx();
        }
        try {
            return this._scanner.getTextCharacters();
        } catch (XMLStreamException e) {
            throw UncheckedStreamException.createFrom(e);
        }
    }

    public final int getTextCharacters(int i, char[] cArr, int i2, int i3) {
        if (((1 << this._currToken) & MASK_GET_TEXT_XXX) == 0) {
            throwNotTextXxx();
        }
        try {
            return this._scanner.getTextCharacters(i, cArr, i2, i3);
        } catch (XMLStreamException e) {
            throw UncheckedStreamException.createFrom(e);
        }
    }

    public final int getTextLength() {
        if (((1 << this._currToken) & MASK_GET_TEXT_XXX) == 0) {
            throwNotTextXxx();
        }
        try {
            return this._scanner.getTextLength();
        } catch (XMLStreamException e) {
            throw UncheckedStreamException.createFrom(e);
        }
    }

    public final int getTextStart() {
        if (((1 << this._currToken) & MASK_GET_TEXT_XXX) != 0) {
            return 0;
        }
        throwNotTextXxx();
        return 0;
    }

    public final boolean hasName() {
        int i = this._currToken;
        return i == 1 || i == 2;
    }

    public final boolean hasNext() {
        return this._currToken != 8;
    }

    public final boolean hasText() {
        return ((1 << this._currToken) & MASK_GET_TEXT) != 0;
    }

    public final boolean isAttributeSpecified(int i) {
        if (this._currToken == 1) {
            return true;
        }
        throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
    }

    public final boolean isCharacters() {
        return getEventType() == 4;
    }

    public final boolean isEndElement() {
        return this._currToken == 2;
    }

    public final boolean isStartElement() {
        return this._currToken == 1;
    }

    public final boolean isWhiteSpace() {
        int i = this._currToken;
        if (i != 4 && i != 12) {
            return i == 6;
        }
        try {
            return this._scanner.isTextWhitespace();
        } catch (XMLStreamException e) {
            throw UncheckedStreamException.createFrom(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void require(int i, String str, String str2) throws XMLStreamException {
        int i2 = this._currToken;
        if (i2 != i && i2 == 12 && this._cfgCoalesceText) {
            i2 = 4;
        }
        if (i != i2) {
            throwWfe("Expected type " + ErrorConsts.tokenTypeDesc(i) + ", current type " + ErrorConsts.tokenTypeDesc(i2));
        }
        if (str2 != null) {
            if (i2 != 1 && i2 != 2 && i2 != 9) {
                throwWfe("Expected non-null local name, but current token not a START_ELEMENT, END_ELEMENT or ENTITY_REFERENCE (was " + ErrorConsts.tokenTypeDesc(this._currToken) + ")");
            }
            String localName = getLocalName();
            if (!Objects.equals(localName, str2) && !localName.equals(str2)) {
                throwWfe("Expected local name '" + str2 + "'; current local name '" + localName + "'.");
            }
        }
        if (str != null) {
            if (i2 != 1 && i2 != 2) {
                throwWfe("Expected non-null NS URI, but current token not a START_ELEMENT or END_ELEMENT (was " + ErrorConsts.tokenTypeDesc(i2) + ")");
            }
            String namespaceURI = getNamespaceURI();
            if (str.isEmpty()) {
                if (namespaceURI.isEmpty()) {
                    return;
                }
                throwWfe("Expected empty namespace, instead have '" + namespaceURI + "'.");
            } else {
                if (str.equals(namespaceURI)) {
                    return;
                }
                throwWfe("Expected namespace '" + str + "'; have '" + namespaceURI + "'.");
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final int next() throws XMLStreamException {
        int iNextFromProlog;
        int i = this._parseState;
        if (i == 1) {
            int iNextFromTree = this._scanner.nextFromTree();
            if (iNextFromTree == -1) {
                handleTreeEoi();
            }
            this._currToken = iNextFromTree;
            if (iNextFromTree == 12) {
                if (this._cfgCoalesceText) {
                    return 4;
                }
            } else {
                this._currName = this._scanner.getName();
                if (iNextFromTree == 2) {
                    if (this._scanner.hasEmptyStack()) {
                        this._parseState = 2;
                        return iNextFromTree;
                    }
                } else if (iNextFromTree == 1) {
                    this._attrCount = this._scanner.getAttrCount();
                }
            }
            return iNextFromTree;
        }
        if (i == 0) {
            iNextFromProlog = this._scanner.nextFromProlog(true);
            if (iNextFromProlog == 1) {
                this._parseState = 1;
                this._attrCount = this._scanner.getAttrCount();
            } else if (iNextFromProlog == 11) {
                if (this._dtdRootName != null) {
                    throwWfe("Duplicate DOCTYPE declaration");
                }
                this._dtdRootName = this._scanner.getName();
            }
        } else if (i == 2) {
            iNextFromProlog = this._scanner.nextFromProlog(false);
        } else {
            throw new NoSuchElementException();
        }
        if (iNextFromProlog < 0) {
            return handlePrologEoi(this._parseState == 0);
        }
        this._currName = this._scanner.getName();
        this._currToken = iNextFromProlog;
        return iNextFromProlog;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0008. Please report as an issue. */
    public final int nextTag() throws XMLStreamException {
        while (true) {
            int next = next();
            if (next != 12) {
                switch (next) {
                    case 1:
                    case 2:
                        break;
                    case 3:
                    case 5:
                    case 6:
                        break;
                    case 4:
                        break;
                    default:
                        throwWfe("Received event " + ErrorConsts.tokenTypeDesc(next) + ", instead of START_ELEMENT or END_ELEMENT.");
                        break;
                }
                return next;
            }
            if (!isWhiteSpace()) {
                throwWfe("Received non-all-whitespace CHARACTERS or CDATA event in nextTag().");
                throwWfe("Received event " + ErrorConsts.tokenTypeDesc(next) + ", instead of START_ELEMENT or END_ELEMENT.");
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void close() throws XMLStreamException {
        _closeScanner();
    }

    public final Location getLocation() {
        return this._scanner.getStartLocation();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void _reportNonTextEvent(int i) throws XMLStreamException {
        throwWfe("Expected a text token, got " + ErrorConsts.tokenTypeDesc(i) + ".");
    }

    protected Location getLastCharLocation() {
        return this._scanner.getCurrentLocation();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected int handlePrologEoi(boolean z) throws XMLStreamException {
        close();
        if (!z) {
            return 8;
        }
        throwUnexpectedEOI(ErrorConsts.SUFFIX_IN_PROLOG);
        return 8;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void handleTreeEoi() throws XMLStreamException {
        this._currToken = 8;
        throwUnexpectedEOI(ErrorConsts.SUFFIX_IN_TREE);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void throwWfe(String str) throws XMLStreamException {
        throw new WFCException(str, getLastCharLocation());
    }

    private void throwNotTextual() {
        throw new IllegalStateException("Not a textual event (" + ErrorConsts.tokenTypeDesc(this._currToken) + ")");
    }

    private void throwNotTextXxx() {
        throw new IllegalStateException("getTextXxx() methods can not be called on " + ErrorConsts.tokenTypeDesc(this._currToken));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void throwUnexpectedEOI(String str) throws XMLStreamException {
        throwWfe("Unexpected End-of-input" + str);
    }

    protected void reportInvalidAttrIndex(int i) {
        throw new IllegalArgumentException("Illegal attribute index, " + i + ", current START_ELEMENT has " + this._attrCount + " attributes");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void _closeScanner() throws XMLStreamException {
        if (this._parseState != 3) {
            this._parseState = 3;
            if (this._currToken != 8) {
                this._currToken = 8;
            }
        }
        this._scanner.close(false);
    }

    public final String toString() {
        return "[Aalto stream reader, scanner: " + this._scanner + "]";
    }
}
