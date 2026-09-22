package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface JsonGeneratorDecorator {
    JsonGenerator decorate(JsonFactory jsonFactory, JsonGenerator jsonGenerator);
}
