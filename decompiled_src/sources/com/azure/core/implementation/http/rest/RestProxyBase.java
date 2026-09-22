package com.azure.core.implementation.http.rest;

import com.azure.core.exception.ClientAuthenticationException;
import com.azure.core.exception.DecodeException;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceExistsException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.exception.TooManyRedirectsException;
import com.azure.core.http.ContentType;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.rest.Page;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.ResponseBase;
import com.azure.core.implementation.TypeUtil;
import com.azure.core.implementation.http.UnexpectedExceptionInformation;
import com.azure.core.implementation.serializer.HttpResponseDecoder;
import com.azure.core.implementation.serializer.MalformedValueException;
import com.azure.core.implementation.util.HttpUtils;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.UrlBuilder;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.serializer.SerializerAdapter;
import com.azure.core.util.tracing.Tracer;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.EnumSet;
import java.util.function.Consumer;
import reactor.core.Exceptions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class RestProxyBase {
    final HttpResponseDecoder decoder;
    final HttpPipeline httpPipeline;
    final SwaggerInterfaceParser interfaceParser;
    final SerializerAdapter serializer;
    protected final Tracer tracer;
    static final String MUST_IMPLEMENT_PAGE_ERROR = "Unable to create PagedResponse<T>. Body must be of a type that implements: " + Page.class;
    static final ResponseConstructorsCache RESPONSE_CONSTRUCTORS_CACHE = new ResponseConstructorsCache();
    private static final ResponseExceptionConstructorCache RESPONSE_EXCEPTION_CONSTRUCTOR_CACHE = new ResponseExceptionConstructorCache();
    static final ClientLogger LOGGER = new ClientLogger((Class<?>) RestProxyBase.class);

    protected abstract Object invoke(Object obj, Method method, RequestOptions requestOptions, EnumSet<ErrorOptions> enumSet, Consumer<HttpRequest> consumer, SwaggerMethodParser swaggerMethodParser, HttpRequest httpRequest, Context context);

    public abstract void updateRequest(RequestDataConfiguration requestDataConfiguration, SerializerAdapter serializerAdapter) throws IOException;

    public RestProxyBase(HttpPipeline httpPipeline, SerializerAdapter serializerAdapter, SwaggerInterfaceParser swaggerInterfaceParser) {
        this.httpPipeline = httpPipeline;
        this.serializer = serializerAdapter;
        this.interfaceParser = swaggerInterfaceParser;
        this.decoder = new HttpResponseDecoder(serializerAdapter);
        this.tracer = httpPipeline.getTracer();
    }

    public final Object invoke(Object obj, Method method, RequestOptions requestOptions, EnumSet<ErrorOptions> enumSet, Consumer<HttpRequest> consumer, SwaggerMethodParser swaggerMethodParser, boolean z, Object[] objArr) {
        try {
            HttpRequest httpRequestCreateHttpRequest = createHttpRequest(swaggerMethodParser, this.serializer, z, objArr);
            Context contextAddData = RestProxyUtils.mergeRequestOptionsContext(swaggerMethodParser.setContext(objArr), requestOptions).addData("caller-method", swaggerMethodParser.getFullyQualifiedMethodName());
            if (swaggerMethodParser.isResponseEagerlyRead()) {
                contextAddData = contextAddData.addData(HttpUtils.AZURE_EAGERLY_READ_RESPONSE, true);
            }
            if (swaggerMethodParser.isResponseBodyIgnored()) {
                contextAddData = contextAddData.addData(HttpUtils.AZURE_IGNORE_RESPONSE_BODY, true);
            }
            if (swaggerMethodParser.isHeadersEagerlyConverted()) {
                contextAddData = contextAddData.addData(HttpUtils.AZURE_EAGERLY_CONVERT_HEADERS, true);
            }
            return invoke(obj, method, requestOptions, enumSet, consumer, swaggerMethodParser, httpRequestCreateHttpRequest, contextAddData);
        } catch (IOException e) {
            if (z) {
                return FluxUtil.monoError(LOGGER, Exceptions.propagate(e));
            }
            throw LOGGER.logExceptionAsError(Exceptions.propagate(e));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Response createResponse(HttpResponseDecoder.HttpDecodedResponse httpDecodedResponse, Type type, Object obj) {
        Class<?> rawClass = TypeUtil.getRawClass(type);
        HttpResponse sourceResponse = httpDecodedResponse.getSourceResponse();
        HttpRequest request = sourceResponse.getRequest();
        int statusCode = sourceResponse.getStatusCode();
        HttpHeaders headers = sourceResponse.getHeaders();
        Object decodedHeaders = httpDecodedResponse.getDecodedHeaders();
        if (rawClass.equals(Response.class)) {
            return (Response) rawClass.cast(new ResponseBase(request, statusCode, headers, obj, decodedHeaders));
        }
        if (rawClass.equals(PagedResponse.class)) {
            if (obj != null && !TypeUtil.isTypeOrSubTypeOf(obj.getClass(), Page.class)) {
                throw LOGGER.logExceptionAsError(new RuntimeException(MUST_IMPLEMENT_PAGE_ERROR));
            }
            if (obj == null) {
                return (Response) rawClass.cast(new PagedResponseBase(request, statusCode, headers, null, null, decodedHeaders));
            }
            return (Response) rawClass.cast(new PagedResponseBase(request, statusCode, headers, (Page) obj, decodedHeaders));
        }
        ResponseConstructorsCache responseConstructorsCache = RESPONSE_CONSTRUCTORS_CACHE;
        return responseConstructorsCache.invoke(responseConstructorsCache.get(rawClass), httpDecodedResponse, obj);
    }

    Context startTracingSpan(SwaggerMethodParser swaggerMethodParser, Context context) {
        if (!isTracingEnabled(context)) {
            return context;
        }
        Object objOrElse = context.getData(Tracer.PARENT_TRACE_CONTEXT_KEY).orElse(null);
        if (objOrElse instanceof Context) {
            context = (Context) objOrElse;
        }
        return this.tracer.start(swaggerMethodParser.getSpanName(), context);
    }

    protected boolean isTracingEnabled(Context context) {
        return this.tracer.isEnabled() && !((Boolean) context.getData(Tracer.DISABLE_TRACING_KEY).orElse(false)).booleanValue();
    }

    HttpRequest createHttpRequest(SwaggerMethodParser swaggerMethodParser, SerializerAdapter serializerAdapter, boolean z, Object[] objArr) throws IOException {
        String path = swaggerMethodParser.setPath(objArr, this.serializer);
        UrlBuilder urlBuilder = UrlBuilder.parse(path);
        if (urlBuilder.getScheme() == null) {
            urlBuilder = new UrlBuilder();
            swaggerMethodParser.setSchemeAndHost(objArr, urlBuilder, this.serializer);
            if (path != null && !path.isEmpty() && !RemoteSettings.FORWARD_SLASH_STRING.equals(path)) {
                String path2 = urlBuilder.getPath();
                if (path2 == null || path2.isEmpty() || RemoteSettings.FORWARD_SLASH_STRING.equals(path2) || path.contains("://")) {
                    urlBuilder.setPath(path);
                } else if (path.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                    urlBuilder.setPath(path2 + path);
                } else {
                    urlBuilder.setPath(path2 + RemoteSettings.FORWARD_SLASH_STRING + path);
                }
            }
        }
        swaggerMethodParser.setEncodedQueryParameters(objArr, urlBuilder, this.serializer);
        HttpRequest httpRequestConfigRequest = configRequest(new HttpRequest(swaggerMethodParser.getHttpMethod(), urlBuilder.toUrl()), swaggerMethodParser, serializerAdapter, z, objArr);
        swaggerMethodParser.setHeaders(objArr, httpRequestConfigRequest.getHeaders(), this.serializer);
        return httpRequestConfigRequest;
    }

    private HttpRequest configRequest(HttpRequest httpRequest, SwaggerMethodParser swaggerMethodParser, SerializerAdapter serializerAdapter, boolean z, Object[] objArr) throws IOException {
        Object body = swaggerMethodParser.setBody(objArr, this.serializer);
        if (body == null) {
            httpRequest.setHeader(HttpHeaderName.CONTENT_LENGTH, "0");
            return httpRequest;
        }
        String bodyContentType = swaggerMethodParser.getBodyContentType();
        if (bodyContentType == null || bodyContentType.isEmpty()) {
            if (!(body instanceof byte[]) && !(body instanceof String)) {
                bodyContentType = ContentType.APPLICATION_JSON;
            } else {
                bodyContentType = ContentType.APPLICATION_OCTET_STREAM;
            }
        }
        httpRequest.setHeader(HttpHeaderName.CONTENT_TYPE, bodyContentType);
        if (body instanceof BinaryData) {
            BinaryData binaryData = (BinaryData) body;
            if (binaryData.getLength() != null) {
                httpRequest.setHeader(HttpHeaderName.CONTENT_LENGTH, binaryData.getLength().toString());
            }
            httpRequest.setBody(binaryData);
            return httpRequest;
        }
        boolean z2 = false;
        for (String str : bodyContentType.split(";")) {
            if (str.trim().equalsIgnoreCase(ContentType.APPLICATION_JSON)) {
                z2 = true;
                break;
            }
        }
        updateRequest(new RequestDataConfiguration(httpRequest, swaggerMethodParser, z2, body), serializerAdapter);
        return httpRequest;
    }

    public static HttpResponseException instantiateUnexpectedException(UnexpectedExceptionInformation unexpectedExceptionInformation, HttpResponse httpResponse, byte[] bArr, Object obj) {
        StringBuilder sbAppend = new StringBuilder("Status code ").append(httpResponse.getStatusCode()).append(", ");
        if (ContentType.APPLICATION_OCTET_STREAM.equalsIgnoreCase(httpResponse.getHeaderValue(HttpHeaderName.CONTENT_TYPE))) {
            sbAppend.append("(").append(httpResponse.getHeaderValue(HttpHeaderName.CONTENT_LENGTH)).append("-byte body)");
        } else if (bArr == null || bArr.length == 0) {
            sbAppend.append("(empty body)");
        } else {
            sbAppend.append('\"').append(new String(bArr, StandardCharsets.UTF_8)).append('\"');
        }
        if ((obj instanceof IOException) || (obj instanceof MalformedValueException) || (obj instanceof IllegalStateException)) {
            return new HttpResponseException(sbAppend.toString(), httpResponse, (Throwable) obj);
        }
        Class<? extends HttpResponseException> exceptionType = unexpectedExceptionInformation.getExceptionType();
        if (exceptionType == HttpResponseException.class) {
            return new HttpResponseException(sbAppend.toString(), httpResponse, obj);
        }
        if (exceptionType == ClientAuthenticationException.class) {
            return new ClientAuthenticationException(sbAppend.toString(), httpResponse, obj);
        }
        if (exceptionType == DecodeException.class) {
            return new DecodeException(sbAppend.toString(), httpResponse, obj);
        }
        if (exceptionType == ResourceExistsException.class) {
            return new ResourceExistsException(sbAppend.toString(), httpResponse, obj);
        }
        if (exceptionType == ResourceModifiedException.class) {
            return new ResourceModifiedException(sbAppend.toString(), httpResponse, obj);
        }
        if (exceptionType == ResourceNotFoundException.class) {
            return new ResourceNotFoundException(sbAppend.toString(), httpResponse, obj);
        }
        if (exceptionType == TooManyRedirectsException.class) {
            return new TooManyRedirectsException(sbAppend.toString(), httpResponse, obj);
        }
        try {
            return ResponseExceptionConstructorCache.invoke(RESPONSE_EXCEPTION_CONSTRUCTOR_CACHE.get(exceptionType, unexpectedExceptionInformation.getExceptionBodyType()), sbAppend.toString(), httpResponse, obj);
        } catch (RuntimeException e) {
            sbAppend.append(". An instance of ").append(exceptionType.getCanonicalName()).append(" couldn't be created.");
            HttpResponseException httpResponseException = new HttpResponseException(sbAppend.toString(), httpResponse, obj);
            httpResponseException.addSuppressed(e);
            return httpResponseException;
        }
    }
}
