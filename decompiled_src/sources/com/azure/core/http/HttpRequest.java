package com.azure.core.http;

import com.azure.core.implementation.ImplUtils;
import com.azure.core.implementation.util.BinaryDataHelper;
import com.azure.core.implementation.util.FluxByteBufferContent;
import com.azure.core.util.BinaryData;
import com.azure.core.util.logging.ClientLogger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import reactor.core.publisher.Flux;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class HttpRequest {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) HttpRequest.class);
    private BinaryData body;
    private HttpHeaders headers;
    private HttpMethod httpMethod;
    private URL url;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(HttpMethod httpMethod, URL url) {
        this(httpMethod, url, new HttpHeaders(), (BinaryData) null);
    }

    public HttpRequest(HttpMethod httpMethod, String str) {
        this.httpMethod = httpMethod;
        setUrl(str);
        this.headers = new HttpHeaders();
    }

    public HttpRequest(HttpMethod httpMethod, URL url, HttpHeaders httpHeaders) {
        this.httpMethod = httpMethod;
        this.url = url;
        this.headers = httpHeaders;
    }

    public HttpRequest(HttpMethod httpMethod, URL url, HttpHeaders httpHeaders, Flux<ByteBuffer> flux) {
        this.httpMethod = httpMethod;
        this.url = url;
        this.headers = httpHeaders;
        setBody(BinaryDataHelper.createBinaryData(new FluxByteBufferContent(flux)));
    }

    public HttpRequest(HttpMethod httpMethod, URL url, HttpHeaders httpHeaders, BinaryData binaryData) {
        this.httpMethod = httpMethod;
        this.url = url;
        this.headers = httpHeaders;
        setBody(binaryData);
    }

    public HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public HttpRequest setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public URL getUrl() {
        return this.url;
    }

    public HttpRequest setUrl(URL url) {
        this.url = url;
        return this;
    }

    public HttpRequest setUrl(String str) {
        try {
            this.url = ImplUtils.createUrl(str);
            return this;
        } catch (MalformedURLException e) {
            throw LOGGER.logExceptionAsWarning(new IllegalArgumentException("'url' must be a valid URL.", e));
        }
    }

    public HttpHeaders getHeaders() {
        return this.headers;
    }

    public HttpRequest setHeaders(HttpHeaders httpHeaders) {
        this.headers = httpHeaders;
        return this;
    }

    @Deprecated
    public HttpRequest setHeader(String str, String str2) {
        this.headers.set(str, str2);
        return this;
    }

    public HttpRequest setHeader(HttpHeaderName httpHeaderName, String str) {
        this.headers.set(httpHeaderName, str);
        return this;
    }

    public Flux<ByteBuffer> getBody() {
        BinaryData binaryData = this.body;
        if (binaryData == null) {
            return null;
        }
        return binaryData.toFluxByteBuffer();
    }

    public BinaryData getBodyAsBinaryData() {
        return this.body;
    }

    public HttpRequest setBody(String str) {
        return setBody(BinaryData.fromString(str));
    }

    public HttpRequest setBody(byte[] bArr) {
        return setBody(BinaryData.fromBytes(bArr));
    }

    public HttpRequest setBody(Flux<ByteBuffer> flux) {
        if (flux != null) {
            this.body = BinaryDataHelper.createBinaryData(new FluxByteBufferContent(flux));
            return this;
        }
        this.body = null;
        return this;
    }

    public HttpRequest setBody(BinaryData binaryData) {
        this.body = binaryData;
        if (binaryData != null && binaryData.getLength() != null) {
            setContentLength(binaryData.getLength().longValue());
        }
        return this;
    }

    private void setContentLength(long j) {
        this.headers.set(HttpHeaderName.CONTENT_LENGTH, String.valueOf(j));
    }

    public HttpRequest copy() {
        return new HttpRequest(this.httpMethod, this.url, new HttpHeaders(this.headers), this.body);
    }
}
