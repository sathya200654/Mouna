package com.azure.core.implementation.serializer;

import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.serializer.SerializerAdapter;
import java.io.IOException;
import java.lang.reflect.Type;
import reactor.core.Exceptions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class HttpResponseHeaderDecoder {
    private static final String MALFORMED_HEADERS_MESSAGE = "HTTP response has malformed headers";

    HttpResponseHeaderDecoder() {
    }

    static Object decode(HttpResponse httpResponse, SerializerAdapter serializerAdapter, Type type) {
        if (type == null) {
            return null;
        }
        try {
            return serializerAdapter.deserialize(httpResponse.getHeaders(), type);
        } catch (IOException e) {
            throw Exceptions.propagate(new HttpResponseException(MALFORMED_HEADERS_MESSAGE, httpResponse, (Throwable) e));
        }
    }
}
