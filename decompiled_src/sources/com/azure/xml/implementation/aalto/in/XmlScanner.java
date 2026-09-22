package com.azure.xml.implementation.aalto.in;

import com.azure.xml.implementation.aalto.WFCException;
import com.azure.xml.implementation.aalto.impl.ErrorConsts;
import com.azure.xml.implementation.aalto.impl.IoStreamException;
import com.azure.xml.implementation.aalto.impl.LocationImpl;
import com.azure.xml.implementation.aalto.util.DataUtil;
import com.azure.xml.implementation.aalto.util.TextBuilder;
import com.azure.xml.implementation.aalto.util.XmlChars;
import com.azure.xml.implementation.aalto.util.XmlConsts;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class XmlScanner implements XmlConsts, XMLStreamConstants, NamespaceContext {
    private static final int BIND_CACHE_MASK = 63;
    private static final int BIND_CACHE_SIZE = 64;
    private static final int BIND_MISSES_TO_ACTIVATE_CACHE = 10;
    protected static final int INT_A = 65;
    protected static final int INT_AMP = 38;
    protected static final int INT_APOS = 39;
    protected static final int INT_COLON = 58;
    protected static final int INT_CR = 13;
    protected static final int INT_EQ = 61;
    protected static final int INT_GT = 62;
    protected static final int INT_LF = 10;
    protected static final int INT_LT = 60;
    protected static final int INT_NULL = 0;
    protected static final int INT_QMARK = 63;
    protected static final int INT_QUOTE = 34;
    protected static final int INT_SLASH = 47;
    protected static final int INT_SPACE = 32;
    protected static final int INT_TAB = 9;
    protected static final int MAX_UNICODE_CHAR = 1114111;
    public static final int TOKEN_EOI = -1;
    protected final boolean _cfgCoalescing;
    protected final ReaderConfig _config;
    protected ElementScope _currElem;
    protected char[] _nameBuffer;
    protected NsBinding[] _nsBindings;
    protected long _pastBytesOrChars;
    protected String _publicId;
    protected int _rowStartOffset;
    protected long _startRawOffset;
    protected String _systemId;
    protected final TextBuilder _textBuilder;
    protected final String CDATA_STR = "CDATA[";
    protected int _currToken = 7;
    protected boolean _tokenIncomplete = false;
    protected int _depth = 0;
    protected boolean _entityPending = false;
    protected PName _tokenName = null;
    protected boolean _isEmptyTag = false;
    protected NsDeclaration _lastNsDecl = null;
    protected int _currNsCount = 0;
    protected NsBinding _defaultNs = NsBinding.createDefaultNs();
    protected int _nsBindingCount = 0;
    protected PName[] _nsBindingCache = null;
    protected int _nsBindMisses = 0;
    protected int _attrCount = 0;
    protected long _startRow = -1;
    protected long _startColumn = -1;
    protected final AttributeCollector _attrCollector = new AttributeCollector();
    protected int _currRow = 0;

    protected abstract void _closeSource() throws IOException;

    protected abstract void finishCData() throws XMLStreamException;

    protected abstract void finishCharacters() throws XMLStreamException;

    protected abstract void finishComment() throws XMLStreamException;

    protected abstract void finishDTD(boolean z) throws XMLStreamException;

    protected abstract void finishPI() throws XMLStreamException;

    protected abstract void finishSpace() throws XMLStreamException;

    protected abstract void finishToken() throws XMLStreamException;

    public abstract Location getCurrentLocation();

    protected abstract boolean loadMore() throws XMLStreamException;

    public abstract int nextFromProlog(boolean z) throws XMLStreamException;

    public abstract int nextFromTree() throws XMLStreamException;

    protected abstract void skipCData() throws XMLStreamException;

    protected abstract boolean skipCharacters() throws XMLStreamException;

    protected abstract boolean skipCoalescedText() throws XMLStreamException;

    protected abstract void skipComment() throws XMLStreamException;

    protected abstract void skipPI() throws XMLStreamException;

    protected abstract void skipSpace() throws XMLStreamException;

    protected XmlScanner(ReaderConfig readerConfig) {
        this._config = readerConfig;
        this._cfgCoalescing = readerConfig.willCoalesceText();
        this._textBuilder = TextBuilder.createRecyclableBuffer(readerConfig);
        this._nameBuffer = readerConfig.allocSmallCBuffer(60);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void close(boolean z) throws XMLStreamException {
        _releaseBuffers();
        if (z) {
            try {
                _closeSource();
            } catch (IOException e) {
                throw new IoStreamException(e);
            }
        }
    }

    protected void _releaseBuffers() {
        this._textBuilder.recycle(true);
        char[] cArr = this._nameBuffer;
        if (cArr != null) {
            this._nameBuffer = null;
            this._config.freeSmallCBuffer(cArr);
        }
    }

    public ReaderConfig getConfig() {
        return this._config;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final boolean skipToken() throws XMLStreamException {
        this._tokenIncomplete = false;
        int i = this._currToken;
        if (i == 3) {
            skipPI();
        } else if (i != 4) {
            if (i == 5) {
                skipComment();
            } else if (i == 6) {
                skipSpace();
            } else if (i == 11) {
                finishDTD(false);
            } else if (i == 12) {
                skipCData();
                if (this._cfgCoalescing) {
                    skipCoalescedText();
                    if (this._entityPending) {
                        this._currToken = 9;
                        return true;
                    }
                }
            } else {
                throw new Error("Internal error, unexpected incomplete token type " + ErrorConsts.tokenTypeDesc(this._currToken));
            }
        } else {
            if (skipCharacters()) {
                this._currToken = 9;
                return true;
            }
            if (this._cfgCoalescing && skipCoalescedText()) {
                this._currToken = 9;
                return true;
            }
        }
        return false;
    }

    public final Location getStartLocation() {
        return LocationImpl.fromZeroBased(this._startRawOffset, (int) this._startRow, (int) this._startColumn);
    }

    public final boolean hasEmptyStack() {
        return this._depth == 0;
    }

    public final PName getName() {
        return this._tokenName;
    }

    public final QName getQName() {
        return this._tokenName.constructQName(this._defaultNs);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final String getText() throws XMLStreamException {
        if (this._tokenIncomplete) {
            finishToken();
        }
        return this._textBuilder.contentsAsString();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final int getTextLength() throws XMLStreamException {
        if (this._tokenIncomplete) {
            finishToken();
        }
        return this._textBuilder.size();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final char[] getTextCharacters() throws XMLStreamException {
        if (this._tokenIncomplete) {
            finishToken();
        }
        return this._textBuilder.getTextBuffer();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final int getTextCharacters(int i, char[] cArr, int i2, int i3) throws XMLStreamException {
        if (this._tokenIncomplete) {
            finishToken();
        }
        return this._textBuilder.contentsToArray(i, cArr, i2, i3);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final boolean isTextWhitespace() throws XMLStreamException {
        if (this._tokenIncomplete) {
            finishToken();
        }
        return this._textBuilder.isAllWhitespace();
    }

    public final int getAttrCount() {
        return this._attrCount;
    }

    public final String getAttrLocalName(int i) {
        return this._attrCollector.getName(i).getLocalName();
    }

    public final QName getAttrQName(int i) {
        return this._attrCollector.getQName(i);
    }

    public final String getAttrNsURI(int i) {
        return this._attrCollector.getName(i).getNsUri();
    }

    public final String getAttrPrefix(int i) {
        return this._attrCollector.getName(i).getPrefix();
    }

    public final String getAttrValue(int i) {
        return this._attrCollector.getValue(i);
    }

    public final String getAttrValue(String str, String str2) {
        if (this._attrCount < 1) {
            return null;
        }
        return this._attrCollector.getValue(str, str2);
    }

    public final int getNsCount() {
        if (this._currToken == 1) {
            return this._currNsCount;
        }
        NsDeclaration nsDeclaration = this._lastNsDecl;
        if (nsDeclaration == null) {
            return 0;
        }
        return nsDeclaration.countDeclsOnLevel(this._depth);
    }

    public final String getNamespacePrefix(int i) {
        return findCurrNsDecl(i).getBinding().mPrefix;
    }

    public final String getNamespaceURI(int i) {
        return findCurrNsDecl(i).getBinding().mURI;
    }

    private NsDeclaration findCurrNsDecl(int i) {
        int i2;
        int i3 = this._depth;
        if (this._currToken == 1) {
            i2 = (this._currNsCount - 1) - i;
            i3--;
        } else {
            i2 = i;
        }
        for (NsDeclaration prev = this._lastNsDecl; prev != null && prev.getLevel() == i3; prev = prev.getPrev()) {
            if (i2 == 0) {
                return prev;
            }
            i2--;
        }
        reportInvalidNsIndex(i);
        return null;
    }

    public final String getNamespaceURI() {
        String nsUri = this._tokenName.getNsUri();
        return nsUri == null ? this._defaultNs.mURI : nsUri;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String str) {
        if (str == null) {
            throw new IllegalArgumentException(ErrorConsts.ERR_NULL_ARG);
        }
        if (str.isEmpty()) {
            String str2 = this._defaultNs.mURI;
            return str2 == null ? "" : str2;
        }
        if (str.equals("xml")) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        if (str.equals("xmlns")) {
            return "http://www.w3.org/2000/xmlns/";
        }
        for (NsDeclaration prev = this._lastNsDecl; prev != null; prev = prev.getPrev()) {
            if (prev.hasPrefix(str)) {
                return prev.getCurrNsURI();
            }
        }
        return null;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getPrefix(String str) {
        String prefix;
        if (str == null) {
            throw new IllegalArgumentException(ErrorConsts.ERR_NULL_ARG);
        }
        if (str.equals("http://www.w3.org/XML/1998/namespace")) {
            return "xml";
        }
        if (str.equals("http://www.w3.org/2000/xmlns/")) {
            return "xmlns";
        }
        if (str.equals(this._defaultNs.mURI)) {
            return "";
        }
        for (NsDeclaration prev = this._lastNsDecl; prev != null; prev = prev.getPrev()) {
            if (prev.hasNsURI(str) && (prefix = prev.getPrefix()) != null) {
                for (NsDeclaration prev2 = this._lastNsDecl; prev2 != prev; prev2 = prev2.getPrev()) {
                    if (!prev2.hasPrefix(prefix)) {
                    }
                }
                return prefix;
            }
        }
        return null;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public Iterator<String> getPrefixes(String str) {
        ArrayList arrayList;
        String prefix;
        if (str == null) {
            throw new IllegalArgumentException(ErrorConsts.ERR_NULL_ARG);
        }
        if (str.equals("http://www.w3.org/XML/1998/namespace")) {
            return Collections.singletonList("xml").iterator();
        }
        if (str.equals("http://www.w3.org/2000/xmlns/")) {
            return Collections.singletonList("xmlns").iterator();
        }
        if (str.equals(this._defaultNs.mURI)) {
            arrayList = new ArrayList();
            arrayList.add("");
        } else {
            arrayList = null;
        }
        for (NsDeclaration prev = this._lastNsDecl; prev != null; prev = prev.getPrev()) {
            if (prev.hasNsURI(str) && (prefix = prev.getPrefix()) != null) {
                NsDeclaration prev2 = this._lastNsDecl;
                while (true) {
                    if (prev2 != prev) {
                        if (prev2.hasPrefix(prefix)) {
                            break;
                        }
                        prev2 = prev2.getPrev();
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(prefix);
                        break;
                    }
                }
            }
        }
        if (arrayList == null) {
            return Collections.emptyIterator();
        }
        if (arrayList.size() == 1) {
            return Collections.singletonList((String) arrayList.get(0)).iterator();
        }
        return arrayList.iterator();
    }

    protected final PName bindName(PName pName, String str) {
        PName pName2;
        PName[] pNameArr = this._nsBindingCache;
        if (pNameArr != null && (pName2 = pNameArr[pName.unboundHashCode() & 63]) != null && pName2.unboundEquals(pName)) {
            return pName2;
        }
        int i = this._nsBindingCount;
        for (int i2 = 0; i2 < i; i2++) {
            NsBinding nsBinding = this._nsBindings[i2];
            if (Objects.equals(nsBinding.mPrefix, str)) {
                if (i2 > 0) {
                    NsBinding[] nsBindingArr = this._nsBindings;
                    int i3 = i2 - 1;
                    nsBindingArr[i2] = nsBindingArr[i3];
                    nsBindingArr[i3] = nsBinding;
                }
                PName pNameCreateBoundName = pName.createBoundName(nsBinding);
                if (this._nsBindingCache == null) {
                    int i4 = this._nsBindMisses + 1;
                    this._nsBindMisses = i4;
                    if (i4 < 10) {
                        return pNameCreateBoundName;
                    }
                    this._nsBindingCache = new PName[64];
                }
                this._nsBindingCache[pNameCreateBoundName.unboundHashCode() & 63] = pNameCreateBoundName;
                return pNameCreateBoundName;
            }
        }
        if (Objects.equals(str, "xml")) {
            return pName.createBoundName(NsBinding.XML_BINDING);
        }
        this._nsBindMisses++;
        return pName.createBoundName(createNewBinding(str));
    }

    protected final NsBinding findOrCreateBinding(String str) {
        int i = this._nsBindingCount;
        for (int i2 = 0; i2 < i; i2++) {
            NsBinding nsBinding = this._nsBindings[i2];
            if (Objects.equals(nsBinding.mPrefix, str)) {
                if (i2 > 0) {
                    NsBinding[] nsBindingArr = this._nsBindings;
                    int i3 = i2 - 1;
                    nsBindingArr[i2] = nsBindingArr[i3];
                    nsBindingArr[i3] = nsBinding;
                }
                return nsBinding;
            }
        }
        if (Objects.equals(str, "xml")) {
            return NsBinding.XML_BINDING;
        }
        if (Objects.equals(str, "xmlns")) {
            return NsBinding.XMLNS_BINDING;
        }
        return createNewBinding(str);
    }

    private NsBinding createNewBinding(String str) {
        NsBinding nsBinding = new NsBinding(str);
        int i = this._nsBindingCount;
        if (i == 0) {
            this._nsBindings = new NsBinding[16];
        } else {
            NsBinding[] nsBindingArr = this._nsBindings;
            if (i >= nsBindingArr.length) {
                this._nsBindings = (NsBinding[]) DataUtil.growAnyArrayBy(nsBindingArr, nsBindingArr.length);
            }
        }
        NsBinding[] nsBindingArr2 = this._nsBindings;
        int i2 = this._nsBindingCount;
        nsBindingArr2[i2] = nsBinding;
        this._nsBindingCount = i2 + 1;
        return nsBinding;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void bindNs(PName pName, String str) throws XMLStreamException {
        NsBinding nsBindingFindOrCreateBinding;
        String prefix = pName.getPrefix();
        if (prefix == null) {
            nsBindingFindOrCreateBinding = this._defaultNs;
        } else {
            prefix = pName.getLocalName();
            nsBindingFindOrCreateBinding = findOrCreateBinding(prefix);
            if (nsBindingFindOrCreateBinding.isImmutable()) {
                checkImmutableBinding(prefix, str);
            }
        }
        if (!nsBindingFindOrCreateBinding.isImmutable()) {
            if (Objects.equals(str, "http://www.w3.org/XML/1998/namespace")) {
                reportIllegalNsDecl("xml", "http://www.w3.org/XML/1998/namespace");
            } else if (Objects.equals(str, "http://www.w3.org/2000/xmlns/")) {
                reportIllegalNsDecl("xmlns", "http://www.w3.org/2000/xmlns/");
            }
        }
        NsDeclaration nsDeclaration = this._lastNsDecl;
        if (nsDeclaration != null && nsDeclaration.alreadyDeclared(prefix, this._depth)) {
            reportDuplicateNsDecl(prefix);
        }
        this._lastNsDecl = new NsDeclaration(nsBindingFindOrCreateBinding, str, this._lastNsDecl, this._depth);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void checkImmutableBinding(String str, String str2) throws XMLStreamException {
        if (Objects.equals(str, "xml") && str2.equals("http://www.w3.org/XML/1998/namespace")) {
            return;
        }
        reportIllegalNsDecl(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void loadMoreGuaranteed() throws XMLStreamException {
        if (loadMore()) {
            return;
        }
        reportInputProblem("Unexpected end-of-input when trying to parse " + ErrorConsts.tokenTypeDesc(this._currToken));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void loadMoreGuaranteed(int i) throws XMLStreamException {
        if (loadMore()) {
            return;
        }
        reportInputProblem("Unexpected end-of-input when trying to parse " + ErrorConsts.tokenTypeDesc(i));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void verifyXmlChar(int i) throws XMLStreamException {
        if (i >= 55296) {
            if (i < 57344) {
                reportInvalidXmlChar(i);
            }
            if (i == 65534 || i == 65535) {
                reportInvalidXmlChar(i);
                return;
            }
            return;
        }
        if (i >= 32 || i == 10 || i == 13 || i == 9) {
            return;
        }
        reportInvalidXmlChar(i);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportInputProblem(String str) throws XMLStreamException {
        throw new WFCException(str, getCurrentLocation());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportUnexpandedEntityInAttr(boolean z) throws XMLStreamException {
        reportInputProblem("Unexpanded ENTITY_REFERENCE (" + this._tokenName + ") in " + (z ? "namespace declaration" : "attribute value"));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportPrologUnexpElement(boolean z, int i) throws XMLStreamException {
        if (i < 0) {
            i &= 524287;
        }
        if (i == INT_SLASH) {
            if (z) {
                reportInputProblem("Unexpected end element in prolog: malformed XML document, expected root element");
            }
            reportInputProblem("Unexpected end element in epilog: malformed XML document (unbalanced start/end tags?)");
        }
        if (i < 32) {
            throwUnexpectedChar(i, "Unrecognized directive " + (z ? ErrorConsts.SUFFIX_IN_PROLOG : ErrorConsts.SUFFIX_IN_EPILOG));
        }
        reportInputProblem("Second root element in content: malformed XML document, only one allowed");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportPrologUnexpChar(boolean z, int i, String str) throws XMLStreamException {
        String str2 = z ? ErrorConsts.SUFFIX_IN_PROLOG : ErrorConsts.SUFFIX_IN_EPILOG;
        if (str != null) {
            str2 = str2 + str;
        } else if (i == INT_AMP) {
            throwUnexpectedChar(i, str2 + "; no entities allowed");
        }
        throwUnexpectedChar(i, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportTreeUnexpChar(int i, String str) throws XMLStreamException {
        String str2 = ErrorConsts.SUFFIX_IN_TREE;
        if (str != null) {
            str2 = str2 + str;
        }
        throwUnexpectedChar(i, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportInvalidNameChar(int i, int i2) throws XMLStreamException {
        if (i == INT_COLON) {
            reportInputProblem("Invalid colon in name: at most one colon allowed in element/attribute names, and none in PI target or entity names");
        }
        if (i2 == 0) {
            reportInputProblem("Invalid name start character (0x" + Integer.toHexString(i) + ")");
        }
        reportInputProblem("Invalid name character (0x" + Integer.toHexString(i) + ")");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportInvalidXmlChar(int i) throws XMLStreamException {
        if (i == 0) {
            reportInputProblem("Invalid null character");
        }
        if (i < 32) {
            reportInputProblem("Invalid white space character (0x" + Integer.toHexString(i) + ")");
        }
        reportInputProblem("Invalid xml content character (0x" + Integer.toHexString(i) + ")");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportEofInName() throws XMLStreamException {
        reportInputProblem("Unexpected end-of-input in name (parsing " + ErrorConsts.tokenTypeDesc(this._currToken) + ")");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportMissingPISpace(int i) throws XMLStreamException {
        throwUnexpectedChar(i, ": expected either white space, or closing '?>'");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportDoubleHyphenInComments() throws XMLStreamException {
        reportInputProblem("String '--' not allowed in comment (missing '>'?)");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportMultipleColonsInName() throws XMLStreamException {
        reportInputProblem("Multiple colons not allowed in names");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportEntityOverflow() throws XMLStreamException {
        reportInputProblem("Illegal character entity: value higher than max allowed (0x" + Integer.toHexString(1114111) + ")");
    }

    protected void reportInvalidNsIndex(int i) {
        throw new IndexOutOfBoundsException("Illegal namespace declaration index, " + i + ", current START_ELEMENT/END_ELEMENT has " + getNsCount() + " declarations");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportUnboundPrefix(PName pName, boolean z) throws XMLStreamException {
        reportInputProblem("Unbound namespace prefix '" + pName.getPrefix() + "' (for " + (z ? "attribute" : "element") + " name '" + pName.getPrefixedName() + "')");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportDuplicateNsDecl(String str) throws XMLStreamException {
        if (str == null) {
            reportInputProblem("Duplicate namespace declaration for the default namespace");
        } else {
            reportInputProblem("Duplicate namespace declaration for prefix '" + str + "'");
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportIllegalNsDecl(String str) throws XMLStreamException {
        reportInputProblem("Illegal namespace declaration: can not re-bind prefix '" + str + "'");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportIllegalNsDecl(String str, String str2) throws XMLStreamException {
        reportInputProblem("Illegal namespace declaration: can not bind URI '" + str2 + "' to prefix other than '" + str + "'");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportUnexpectedEndTag(String str) throws XMLStreamException {
        reportInputProblem("Unexpected end tag: expected </" + str + ">");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportIllegalCDataEnd() throws XMLStreamException {
        reportInputProblem("String ']]>' not allowed in textual content, except as the end marker of CDATA section");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void throwUnexpectedChar(int i, String str) throws XMLStreamException {
        if (i < 32 && i != 13 && i != 10 && i != 9) {
            throwInvalidSpace(i);
        }
        reportInputProblem("Unexpected character " + XmlChars.getCharDesc((char) i) + str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void throwNullChar() throws XMLStreamException {
        reportInputProblem("Illegal character (NULL, unicode 0) encountered: not valid in any content");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected char handleInvalidXmlChar(int i) throws XMLStreamException {
        char c = (char) i;
        if (c == 0) {
            throwNullChar();
        }
        reportInputProblem("Illegal XML character (" + XmlChars.getCharDesc(c) + ")");
        return c;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void throwInvalidSpace(int i) throws XMLStreamException {
        char c = (char) i;
        if (c == 0) {
            throwNullChar();
        }
        reportInputProblem("Illegal character (" + XmlChars.getCharDesc(c) + ")");
    }
}
