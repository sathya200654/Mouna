package com.fasterxml.jackson.core.exc;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class StreamConstraintsException extends JsonProcessingException {
    private static final long serialVersionUID = 2;

    public StreamConstraintsException(String str) {
        super(str);
    }

    public StreamConstraintsException(String str, JsonLocation jsonLocation) {
        super(str, jsonLocation);
    }
}
