package com.google.gson;

import com.google.gson.stream.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ToNumberStrategy {
    Number readNumber(JsonReader jsonReader) throws IOException;
}
