package com.azure.core.implementation.serializer;

import com.azure.core.http.HttpResponse;
import com.azure.core.util.serializer.SerializerAdapter;
import java.io.Closeable;
import java.util.function.Function;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HttpResponseDecoder {
    private final SerializerAdapter serializer;

    public HttpResponseDecoder(SerializerAdapter serializerAdapter) {
        this.serializer = serializerAdapter;
    }

    public Mono<HttpDecodedResponse> decode(Mono<HttpResponse> mono, final HttpResponseDecodeData httpResponseDecodeData) {
        return mono.map(new Function() { // from class: com.azure.core.implementation.serializer.HttpResponseDecoder$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1213xb8d0ab24(httpResponseDecodeData, (HttpResponse) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$decode$0$com-azure-core-implementation-serializer-HttpResponseDecoder, reason: not valid java name */
    /* synthetic */ HttpDecodedResponse m1213xb8d0ab24(HttpResponseDecodeData httpResponseDecodeData, HttpResponse httpResponse) {
        return new HttpDecodedResponse(httpResponse, this.serializer, httpResponseDecodeData);
    }

    public HttpDecodedResponse decodeSync(HttpResponse httpResponse, HttpResponseDecodeData httpResponseDecodeData) {
        return new HttpDecodedResponse(httpResponse, this.serializer, httpResponseDecodeData);
    }

    public static class HttpDecodedResponse implements Closeable {
        private Object bodyCached;
        private final HttpResponseDecodeData decodeData;
        private Object headersCached;
        private final HttpResponse response;
        private final SerializerAdapter serializer;

        HttpDecodedResponse(HttpResponse httpResponse, SerializerAdapter serializerAdapter, HttpResponseDecodeData httpResponseDecodeData) {
            this.response = httpResponse;
            this.serializer = serializerAdapter;
            this.decodeData = httpResponseDecodeData;
        }

        public HttpResponse getSourceResponse() {
            return this.response;
        }

        public Object getDecodedBody(byte[] bArr) {
            if (this.bodyCached == null) {
                this.bodyCached = HttpResponseBodyDecoder.decodeByteArray(bArr, this.response, this.serializer, this.decodeData);
            }
            return this.bodyCached;
        }

        public Object getDecodedHeaders() {
            if (this.headersCached == null) {
                this.headersCached = HttpResponseHeaderDecoder.decode(this.response, this.serializer, this.decodeData.getHeadersType());
            }
            return this.headersCached;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.response.close();
        }
    }
}
