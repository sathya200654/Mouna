package com.azure.xml.implementation.aalto.in;

import com.azure.xml.implementation.aalto.impl.CommonConfig;
import com.azure.xml.implementation.aalto.util.BufferRecycler;
import com.azure.xml.implementation.aalto.util.CharsetNames;
import com.azure.xml.implementation.aalto.util.UriCanonicalizer;
import com.azure.xml.implementation.aalto.util.XmlCharTypes;
import com.azure.xml.implementation.aalto.util.XmlConsts;
import com.azure.xml.implementation.stax2.XMLInputFactory2;
import com.azure.xml.implementation.stax2.XMLStreamProperties;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Objects;
import javax.xml.stream.XMLReporter;
import javax.xml.stream.XMLResolver;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ReaderConfig extends CommonConfig {
    public static final int DEFAULT_CHAR_BUFFER_LEN = 4000;
    private static final int DEFAULT_FLAGS = 7957;
    public static final int DEFAULT_SMALL_BUFFER_LEN = 60;
    private static final int F_AUTO_CLOSE_INPUT = 8192;
    private static final int F_COALESCING = 2;
    private static final int F_DTD_AWARE = 4;
    private static final int F_DTD_VALIDATING = 8;
    private static final int F_EXPAND_ENTITIES = 16;
    private static final int F_INTERN_NAMES = 512;
    private static final int F_INTERN_NS_URIS = 1024;
    private static final int F_LAZY_PARSING = 256;
    private static final int F_NS_AWARE = 1;
    private static final int F_PRESERVE_LOCATION = 4096;
    private static final int F_REPORT_CDATA = 2048;
    public static final int STANDALONE_NO = 2;
    public static final int STANDALONE_UNKNOWN = 0;
    public static final int STANDALONE_YES = 1;
    static final ThreadLocal<SoftReference<BufferRecycler>> _recyclerRef;
    private static final HashMap<String, Object> sProperties;
    private BufferRecycler _currRecycler;
    private String mActualEncoding;
    private final UriCanonicalizer mCanonicalizer;
    private final EncodingContext mEncCtxt;
    private final String mExtEncoding;
    private XMLReporter mReporter;
    private XMLResolver mResolver;
    private String mXmlDeclEncoding;
    private int mXmlDeclStandalone;
    private String mXmlDeclVersion;

    static {
        HashMap<String, Object> map = new HashMap<>();
        sProperties = map;
        map.put(XMLStreamProperties.XSP_NAMESPACE_AWARE, Boolean.TRUE);
        map.put("javax.xml.stream.isValidating", 8);
        map.put("javax.xml.stream.isCoalescing", 2);
        map.put("javax.xml.stream.isReplacingEntityReferences", 16);
        map.put("javax.xml.stream.isSupportingExternalEntities", Boolean.FALSE);
        map.put("javax.xml.stream.supportDTD", 4);
        map.put(XMLStreamProperties.XSP_PROBLEM_REPORTER, null);
        map.put("javax.xml.stream.resolver", null);
        map.put("javax.xml.stream.allocator", null);
        map.put(XMLInputFactory2.P_LAZY_PARSING, 256);
        map.put(XMLInputFactory2.P_INTERN_NAMES, Integer.valueOf(F_INTERN_NAMES));
        map.put(XMLInputFactory2.P_INTERN_NS_URIS, 1024);
        map.put(XMLInputFactory2.P_AUTO_CLOSE_INPUT, 8192);
        map.put(XMLInputFactory2.P_REPORT_PROLOG_WHITESPACE, Boolean.FALSE);
        map.put(XMLInputFactory2.P_REPORT_CDATA, 2048);
        map.put(XMLInputFactory2.P_PRESERVE_LOCATION, Boolean.TRUE);
        map.put(XMLInputFactory2.P_DTD_OVERRIDE, null);
        _recyclerRef = new ThreadLocal<>();
    }

    private ReaderConfig(String str, EncodingContext encodingContext, int i, int i2, XMLReporter xMLReporter, XMLResolver xMLResolver, UriCanonicalizer uriCanonicalizer) {
        super(i, i2);
        this.mActualEncoding = null;
        this.mXmlDeclVersion = null;
        this.mXmlDeclEncoding = null;
        this.mXmlDeclStandalone = 0;
        this._currRecycler = null;
        this.mExtEncoding = str;
        SoftReference<BufferRecycler> softReference = _recyclerRef.get();
        if (softReference != null) {
            this._currRecycler = softReference.get();
        }
        this.mEncCtxt = encodingContext;
        this._flags = i;
        this._flagMods = i2;
        this.mReporter = xMLReporter;
        this.mResolver = xMLResolver;
        this.mCanonicalizer = uriCanonicalizer;
    }

    public ReaderConfig() {
        this(null, new EncodingContext(), DEFAULT_FLAGS, 0, null, null, new UriCanonicalizer());
    }

    public void setActualEncoding(String str) {
        this.mActualEncoding = str;
    }

    public void setXmlDeclInfo(int i, String str, String str2) {
        if (i == 256) {
            this.mXmlDeclVersion = "1.0";
        } else if (i == 272) {
            this.mXmlDeclVersion = XmlConsts.XML_V_11_STR;
        } else {
            this.mXmlDeclVersion = null;
        }
        this.mXmlDeclEncoding = str;
        if (Objects.equals(str2, XmlConsts.XML_SA_YES)) {
            this.mXmlDeclStandalone = 1;
        } else if (Objects.equals(str2, XmlConsts.XML_SA_NO)) {
            this.mXmlDeclStandalone = 2;
        } else {
            this.mXmlDeclStandalone = 0;
        }
    }

    public void setXMLReporter(XMLReporter xMLReporter) {
        this.mReporter = xMLReporter;
    }

    public void setXMLResolver(XMLResolver xMLResolver) {
        this.mResolver = xMLResolver;
    }

    public ReaderConfig createNonShared(String str) {
        return new ReaderConfig(str, this.mEncCtxt, this._flags, this._flagMods, this.mReporter, this.mResolver, this.mCanonicalizer);
    }

    @Override // com.azure.xml.implementation.aalto.impl.CommonConfig
    public String getExternalEncoding() {
        return this.mExtEncoding;
    }

    @Override // com.azure.xml.implementation.aalto.impl.CommonConfig
    public String getActualEncoding() {
        return this.mActualEncoding;
    }

    @Override // com.azure.xml.implementation.aalto.impl.CommonConfig
    public Object getProperty(String str, boolean z) {
        HashMap<String, Object> map = sProperties;
        Object obj = map.get(str);
        if (obj == null) {
            if (map.containsKey(str)) {
                return null;
            }
            return super.getProperty(str, z);
        }
        if (obj instanceof Boolean) {
            return obj;
        }
        if (!(obj instanceof Integer)) {
            throw new RuntimeException("Internal error: unrecognized property value type: " + obj.getClass().getName());
        }
        return Boolean.valueOf(hasFlag(((Integer) obj).intValue()));
    }

    @Override // com.azure.xml.implementation.aalto.impl.CommonConfig
    public boolean setProperty(String str, Object obj) {
        HashMap<String, Object> map = sProperties;
        Object obj2 = map.get(str);
        if (obj2 == null) {
            if (map.containsKey(str)) {
                return false;
            }
            return super.setProperty(str, obj);
        }
        if (obj2 instanceof Boolean) {
            return false;
        }
        if (!(obj2 instanceof Integer)) {
            throw new RuntimeException("Internal error");
        }
        setFlag(((Integer) obj2).intValue(), ((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.azure.xml.implementation.aalto.impl.CommonConfig
    public boolean isPropertySupported(String str) {
        return sProperties.containsKey(str) || super.isPropertySupported(str);
    }

    public XMLReporter getXMLReporter() {
        return this.mReporter;
    }

    public XMLResolver getXMLResolver() {
        return this.mResolver;
    }

    public boolean willExpandEntities() {
        return hasFlag(16);
    }

    public boolean willCoalesceText() {
        return hasFlag(2);
    }

    public String getXmlDeclVersion() {
        return this.mXmlDeclVersion;
    }

    public String getXmlDeclEncoding() {
        return this.mXmlDeclEncoding;
    }

    public int getXmlDeclStandalone() {
        return this.mXmlDeclStandalone;
    }

    public String canonicalizeURI(char[] cArr, int i) {
        return this.mCanonicalizer.canonicalizeURI(cArr, i);
    }

    public char[] allocSmallCBuffer(int i) {
        char[] smallCBuffer;
        BufferRecycler bufferRecycler = this._currRecycler;
        return (bufferRecycler == null || (smallCBuffer = bufferRecycler.getSmallCBuffer(i)) == null) ? new char[i] : smallCBuffer;
    }

    public void freeSmallCBuffer(char[] cArr) {
        if (this._currRecycler == null) {
            this._currRecycler = createRecycler();
        }
        this._currRecycler.returnSmallCBuffer(cArr);
    }

    public char[] allocMediumCBuffer(int i) {
        char[] mediumCBuffer;
        BufferRecycler bufferRecycler = this._currRecycler;
        return (bufferRecycler == null || (mediumCBuffer = bufferRecycler.getMediumCBuffer(i)) == null) ? new char[i] : mediumCBuffer;
    }

    public void freeMediumCBuffer(char[] cArr) {
        if (this._currRecycler == null) {
            this._currRecycler = createRecycler();
        }
        this._currRecycler.returnMediumCBuffer(cArr);
    }

    public char[] allocFullCBuffer(int i) {
        char[] fullCBuffer;
        BufferRecycler bufferRecycler = this._currRecycler;
        return (bufferRecycler == null || (fullCBuffer = bufferRecycler.getFullCBuffer(i)) == null) ? new char[i] : fullCBuffer;
    }

    public void freeFullCBuffer(char[] cArr) {
        if (this._currRecycler == null) {
            this._currRecycler = createRecycler();
        }
        this._currRecycler.returnFullCBuffer(cArr);
    }

    public byte[] allocFullBBuffer(int i) {
        byte[] fullBBuffer;
        BufferRecycler bufferRecycler = this._currRecycler;
        return (bufferRecycler == null || (fullBBuffer = bufferRecycler.getFullBBuffer(i)) == null) ? new byte[i] : fullBBuffer;
    }

    public void freeFullBBuffer(byte[] bArr) {
        if (this._currRecycler == null) {
            this._currRecycler = createRecycler();
        }
        this._currRecycler.returnFullBBuffer(bArr);
    }

    private BufferRecycler createRecycler() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        _recyclerRef.set(new SoftReference<>(bufferRecycler));
        return bufferRecycler;
    }

    public ByteBasedPNameTable getBBSymbols() {
        if (Objects.equals(this.mActualEncoding, "UTF-8")) {
            return this.mEncCtxt.getUtf8Symbols();
        }
        if (Objects.equals(this.mActualEncoding, CharsetNames.CS_ISO_LATIN1)) {
            return this.mEncCtxt.getLatin1Symbols();
        }
        if (Objects.equals(this.mActualEncoding, CharsetNames.CS_US_ASCII)) {
            return this.mEncCtxt.getAsciiSymbols();
        }
        throw new Error("Internal error, unknown encoding '" + this.mActualEncoding + "'");
    }

    public CharBasedPNameTable getCBSymbols() {
        return this.mEncCtxt.getSymbols();
    }

    public void updateBBSymbols(ByteBasedPNameTable byteBasedPNameTable) {
        if (Objects.equals(this.mActualEncoding, "UTF-8")) {
            this.mEncCtxt.updateUtf8Symbols(byteBasedPNameTable);
        } else if (Objects.equals(this.mActualEncoding, CharsetNames.CS_ISO_LATIN1)) {
            this.mEncCtxt.updateLatin1Symbols(byteBasedPNameTable);
        } else {
            if (Objects.equals(this.mActualEncoding, CharsetNames.CS_US_ASCII)) {
                this.mEncCtxt.updateAsciiSymbols(byteBasedPNameTable);
                return;
            }
            throw new Error("Internal error, unknown encoding '" + this.mActualEncoding + "'");
        }
    }

    public void updateCBSymbols(CharBasedPNameTable charBasedPNameTable) {
        this.mEncCtxt.updateSymbols(charBasedPNameTable);
    }

    public XmlCharTypes getCharTypes() {
        if (Objects.equals(this.mActualEncoding, "UTF-8")) {
            return InputCharTypes.getUtf8CharTypes();
        }
        if (Objects.equals(this.mActualEncoding, CharsetNames.CS_ISO_LATIN1)) {
            return InputCharTypes.getLatin1CharTypes();
        }
        if (Objects.equals(this.mActualEncoding, CharsetNames.CS_US_ASCII)) {
            return InputCharTypes.getAsciiCharTypes();
        }
        throw new Error("Internal error, unknown encoding '" + this.mActualEncoding + "'");
    }

    static final class EncodingContext {
        ByteBasedPNameTable mAsciiTable;
        CharBasedPNameTable mGeneralTable;
        ByteBasedPNameTable mLatin1Table;
        ByteBasedPNameTable mUtf8Table;

        EncodingContext() {
        }

        public synchronized ByteBasedPNameTable getUtf8Symbols() {
            if (this.mUtf8Table == null) {
                this.mUtf8Table = new ByteBasedPNameTable(64);
            }
            return new ByteBasedPNameTable(this.mUtf8Table);
        }

        public synchronized void updateUtf8Symbols(ByteBasedPNameTable byteBasedPNameTable) {
            this.mUtf8Table.mergeFromChild(byteBasedPNameTable);
        }

        public synchronized ByteBasedPNameTable getLatin1Symbols() {
            if (this.mLatin1Table == null) {
                this.mLatin1Table = new ByteBasedPNameTable(64);
            }
            return new ByteBasedPNameTable(this.mLatin1Table);
        }

        public synchronized void updateLatin1Symbols(ByteBasedPNameTable byteBasedPNameTable) {
            this.mLatin1Table.mergeFromChild(byteBasedPNameTable);
        }

        public synchronized ByteBasedPNameTable getAsciiSymbols() {
            if (this.mAsciiTable == null) {
                this.mAsciiTable = new ByteBasedPNameTable(64);
            }
            return new ByteBasedPNameTable(this.mAsciiTable);
        }

        public synchronized void updateAsciiSymbols(ByteBasedPNameTable byteBasedPNameTable) {
            this.mAsciiTable.mergeFromChild(byteBasedPNameTable);
        }

        public synchronized CharBasedPNameTable getSymbols() {
            if (this.mGeneralTable == null) {
                this.mGeneralTable = new CharBasedPNameTable(64);
            }
            return new CharBasedPNameTable(this.mGeneralTable);
        }

        public synchronized void updateSymbols(CharBasedPNameTable charBasedPNameTable) {
            this.mGeneralTable.mergeFromChild(charBasedPNameTable);
        }
    }
}
