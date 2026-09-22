package com.azure.xml.implementation.stax2.ri;

import javax.xml.stream.XMLStreamConstants;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class Stax2Util implements XMLStreamConstants {
    private Stax2Util() {
    }

    public static String eventTypeDesc(int i) {
        switch (i) {
            case 1:
                return "START_ELEMENT";
            case 2:
                return "END_ELEMENT";
            case 3:
                return "PROCESSING_INSTRUCTION";
            case 4:
                return "CHARACTERS";
            case 5:
                return "COMMENT";
            case 6:
                return "SPACE";
            case 7:
                return "START_DOCUMENT";
            case 8:
                return "END_DOCUMENT";
            case 9:
                return "ENTITY_REFERENCE";
            case 10:
            default:
                return "[" + i + "]";
            case 11:
                return "DTD";
            case 12:
                return "CDATA";
        }
    }
}
