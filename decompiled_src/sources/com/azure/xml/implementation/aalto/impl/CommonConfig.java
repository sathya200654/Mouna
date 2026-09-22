package com.azure.xml.implementation.aalto.impl;

import com.azure.xml.implementation.stax2.XMLStreamProperties;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class CommonConfig {
    protected static final String IMPL_NAME = "aalto";
    protected static final String IMPL_VERSION = "0.9";
    static final int PROP_IMPL_NAME = 1;
    static final int PROP_IMPL_VERSION = 2;
    static final int PROP_SUPPORTS_XML11 = 3;
    static final int PROP_SUPPORTS_XMLID = 4;
    static final HashMap<String, Integer> sStdProperties;
    protected int _flagMods;
    protected int _flags;

    public abstract String getActualEncoding();

    public abstract String getExternalEncoding();

    static {
        HashMap<String, Integer> map = new HashMap<>(16);
        sStdProperties = map;
        map.put(XMLStreamProperties.XSP_IMPLEMENTATION_NAME, 1);
        map.put(XMLStreamProperties.XSP_IMPLEMENTATION_VERSION, 2);
        map.put(XMLStreamProperties.XSP_SUPPORTS_XML11, 3);
        map.put(XMLStreamProperties.XSP_SUPPORT_XMLID, 4);
        map.put("http://java.sun.com/xml/stream/properties/implementation-name", 1);
    }

    protected CommonConfig(int i, int i2) {
        this._flags = i;
        this._flagMods = i2;
    }

    public Object getProperty(String str, boolean z) {
        Integer num = sStdProperties.get(str);
        if (num != null) {
            int iIntValue = num.intValue();
            if (iIntValue == 1) {
                return IMPL_NAME;
            }
            if (iIntValue == 2) {
                return IMPL_VERSION;
            }
            if (iIntValue == 3) {
                return Boolean.FALSE;
            }
            if (iIntValue == 4) {
                return Boolean.FALSE;
            }
        }
        if (z) {
            throw new IllegalArgumentException("Unrecognized property '" + str + "'");
        }
        return null;
    }

    public boolean isPropertySupported(String str) {
        return sStdProperties.containsKey(str);
    }

    public boolean setProperty(String str, Object obj) {
        if (sStdProperties.get(str) != null) {
            return false;
        }
        throw new IllegalArgumentException("Unrecognized property '" + str + "'");
    }

    protected final boolean hasFlag(int i) {
        return (this._flags & i) != 0;
    }

    protected final void setFlag(int i, boolean z) {
        if (z) {
            this._flags |= i;
        } else {
            this._flags &= ~i;
        }
        this._flagMods = i | this._flagMods;
    }
}
