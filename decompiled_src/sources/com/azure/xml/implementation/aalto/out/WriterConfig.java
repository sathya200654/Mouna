package com.azure.xml.implementation.aalto.out;

import com.azure.xml.implementation.aalto.impl.CommonConfig;
import com.azure.xml.implementation.aalto.util.BufferRecycler;
import com.azure.xml.implementation.stax2.XMLOutputFactory2;
import com.azure.xml.implementation.stax2.XMLStreamProperties;
import java.lang.ref.SoftReference;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class WriterConfig extends CommonConfig {
    private static final String DEFAULT_AUTOMATIC_NS_PREFIX = "ans";
    static final int DEFAULT_FLAGS = 32;
    static final int F_AUTO_CLOSE_OUTPUT = 16;
    static final int F_AUTO_EMPTY_ELEMS = 64;
    static final int F_NS_AWARE = 32;
    static final int F_NS_REPAIRING = 1;
    static final int PROP_AUTO_NS_PREFIX = -2;
    static final ThreadLocal<SoftReference<BufferRecycler>> mRecyclerRef;
    private static final HashMap<String, Integer> sProperties;
    BufferRecycler _currRecycler;
    private String _encoding;
    private final EncodingContext _encodingContext;
    private String _propAutoNsPrefix;

    static {
        HashMap<String, Integer> map = new HashMap<>();
        sProperties = map;
        map.put("javax.xml.stream.isRepairingNamespaces", 1);
        map.put(XMLStreamProperties.XSP_NAMESPACE_AWARE, 32);
        map.put(XMLStreamProperties.XSP_PROBLEM_REPORTER, null);
        map.put(XMLOutputFactory2.P_AUTO_CLOSE_OUTPUT, 16);
        map.put(XMLOutputFactory2.P_AUTOMATIC_EMPTY_ELEMENTS, 64);
        map.put(XMLOutputFactory2.P_AUTOMATIC_NS_PREFIX, -2);
        map.put(XMLOutputFactory2.P_TEXT_ESCAPER, null);
        map.put(XMLOutputFactory2.P_ATTR_VALUE_ESCAPER, null);
        mRecyclerRef = new ThreadLocal<>();
    }

    private WriterConfig(String str, int i, int i2, EncodingContext encodingContext, String str2) {
        super(i, i2);
        this._currRecycler = null;
        this._encoding = str;
        this._encodingContext = encodingContext;
        SoftReference<BufferRecycler> softReference = mRecyclerRef.get();
        if (softReference != null) {
            this._currRecycler = softReference.get();
        }
        this._flags = i;
        this._flagMods = i2;
        this._propAutoNsPrefix = str2;
    }

    public WriterConfig() {
        this(null, 32, 0, new EncodingContext(), DEFAULT_AUTOMATIC_NS_PREFIX);
    }

    public void setActualEncodingIfNotSet(String str) {
        String str2 = this._encoding;
        if (str2 == null || str2.isEmpty()) {
            this._encoding = str;
        }
    }

    public WriterConfig createNonShared() {
        return new WriterConfig(this._encoding, this._flags, this._flagMods, this._encodingContext, this._propAutoNsPrefix);
    }

    @Override // com.azure.xml.implementation.aalto.impl.CommonConfig
    public String getExternalEncoding() {
        return getActualEncoding();
    }

    @Override // com.azure.xml.implementation.aalto.impl.CommonConfig
    public String getActualEncoding() {
        return this._encoding;
    }

    public String getPreferredEncoding() {
        return this._encoding;
    }

    @Override // com.azure.xml.implementation.aalto.impl.CommonConfig
    public Object getProperty(String str, boolean z) {
        HashMap<String, Integer> map = sProperties;
        Integer num = map.get(str);
        if (num == null) {
            if (map.containsKey(str)) {
                return null;
            }
            return super.getProperty(str, z);
        }
        int iIntValue = num.intValue();
        if (iIntValue >= 0) {
            return Boolean.valueOf(hasFlag(iIntValue));
        }
        if (iIntValue == -2) {
            return this._propAutoNsPrefix;
        }
        return null;
    }

    @Override // com.azure.xml.implementation.aalto.impl.CommonConfig
    public boolean setProperty(String str, Object obj) {
        HashMap<String, Integer> map = sProperties;
        Integer num = map.get(str);
        if (num == null) {
            if (map.containsKey(str)) {
                return false;
            }
            return super.setProperty(str, obj);
        }
        int iIntValue = num.intValue();
        if (iIntValue < 0) {
            if (iIntValue != -2) {
                return false;
            }
            this._propAutoNsPrefix = obj.toString();
            return true;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (iIntValue == 32 && !zBooleanValue) {
            return false;
        }
        setFlag(iIntValue, zBooleanValue);
        return true;
    }

    @Override // com.azure.xml.implementation.aalto.impl.CommonConfig
    public boolean isPropertySupported(String str) {
        return sProperties.containsKey(str) || super.isPropertySupported(str);
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
        mRecyclerRef.set(new SoftReference<>(bufferRecycler));
        return bufferRecycler;
    }

    public WNameTable getUtf8Symbols(WNameFactory wNameFactory) {
        return this._encodingContext.getUtf8Symbols(wNameFactory);
    }

    public WNameTable getLatin1Symbols(WNameFactory wNameFactory) {
        return this._encodingContext.getLatin1Symbols(wNameFactory);
    }

    public WNameTable getAsciiSymbols(WNameFactory wNameFactory) {
        return this._encodingContext.getAsciiSymbols(wNameFactory);
    }

    public WNameTable getCharSymbols(WNameFactory wNameFactory) {
        return this._encodingContext.getCharSymbols(wNameFactory);
    }

    static final class EncodingContext {
        WNameTable mAsciiTable;
        WNameTable mCharTable;
        WNameTable mLatin1Table;
        WNameTable mUtf8Table;

        EncodingContext() {
        }

        public synchronized WNameTable getUtf8Symbols(WNameFactory wNameFactory) {
            if (this.mUtf8Table == null) {
                this.mUtf8Table = new WNameTable(64);
            }
            return this.mUtf8Table.createChild(wNameFactory);
        }

        public synchronized WNameTable getLatin1Symbols(WNameFactory wNameFactory) {
            if (this.mLatin1Table == null) {
                this.mLatin1Table = new WNameTable(64);
            }
            return this.mLatin1Table.createChild(wNameFactory);
        }

        public synchronized WNameTable getAsciiSymbols(WNameFactory wNameFactory) {
            if (this.mAsciiTable == null) {
                this.mAsciiTable = new WNameTable(64);
            }
            return this.mAsciiTable.createChild(wNameFactory);
        }

        public synchronized WNameTable getCharSymbols(WNameFactory wNameFactory) {
            if (this.mCharTable == null) {
                this.mCharTable = new WNameTable(64);
            }
            return this.mCharTable.createChild(wNameFactory);
        }
    }
}
