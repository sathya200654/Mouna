package com.azure.xml.implementation.aalto.impl;

import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class StreamExceptionBase extends XMLStreamException {
    final String mMsg;

    public StreamExceptionBase(String str) {
        super(str);
        this.mMsg = str;
    }

    public StreamExceptionBase(Throwable th) {
        super(th.getMessage(), th);
        this.mMsg = th.getMessage();
        if (getCause() == null) {
            initCause(th);
        }
    }

    public StreamExceptionBase(String str, Location location) {
        super(str, location);
        this.mMsg = str;
    }

    public String getMessage() {
        String locationDesc = getLocationDesc();
        if (locationDesc == null) {
            return super.getMessage();
        }
        return this.mMsg + "\n at " + locationDesc;
    }

    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    protected String getLocationDesc() {
        Location location = getLocation();
        if (location == null) {
            return null;
        }
        return location.toString();
    }
}
