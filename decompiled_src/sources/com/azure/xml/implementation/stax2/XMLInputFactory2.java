package com.azure.xml.implementation.stax2;

import javax.xml.stream.XMLInputFactory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class XMLInputFactory2 extends XMLInputFactory implements XMLStreamProperties {
    public static final String P_AUTO_CLOSE_INPUT = "com.azure.xml.implementation.stax2.closeInputSource";
    public static final String P_DTD_OVERRIDE = "com.azure.xml.implementation.stax2.propDtdOverride";
    public static final String P_INTERN_NAMES = "com.azure.xml.implementation.stax2.internNames";
    public static final String P_INTERN_NS_URIS = "com.azure.xml.implementation.stax2.internNsUris";
    public static final String P_LAZY_PARSING = "com.ctc.wstx.lazyParsing";
    public static final String P_PRESERVE_LOCATION = "com.azure.xml.implementation.stax2.preserveLocation";
    public static final String P_REPORT_CDATA = "http://java.sun.com/xml/stream/properties/report-cdata-event";
    public static final String P_REPORT_PROLOG_WHITESPACE = "com.azure.xml.implementation.stax2.reportPrologWhitespace";

    protected XMLInputFactory2() {
    }
}
