package com.azure.core.http.rest;

import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.implementation.http.rest.AsyncRestProxy;
import com.azure.core.implementation.http.rest.RestProxyUtils;
import com.azure.core.implementation.http.rest.SwaggerInterfaceParser;
import com.azure.core.implementation.http.rest.SwaggerMethodParser;
import com.azure.core.implementation.http.rest.SyncRestProxy;
import com.azure.core.util.Configuration;
import com.azure.core.util.Context;
import com.azure.core.util.serializer.SerializerAdapter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class RestProxy implements InvocationHandler {
    private static final boolean GLOBAL_SYNC_PROXY_ENABLED = ((Boolean) Configuration.getGlobalConfiguration().get("AZURE_HTTP_REST_PROXY_SYNC_PROXY_ENABLED", true)).booleanValue();
    private static final String HTTP_REST_PROXY_SYNC_PROXY_ENABLED = "com.azure.core.http.restproxy.syncproxy.enable";
    private final AsyncRestProxy asyncRestProxy;
    private final HttpPipeline httpPipeline;
    private final SwaggerInterfaceParser interfaceParser;
    private final SyncRestProxy syncRestProxy;

    private RestProxy(HttpPipeline httpPipeline, SerializerAdapter serializerAdapter, SwaggerInterfaceParser swaggerInterfaceParser) {
        this.interfaceParser = swaggerInterfaceParser;
        this.asyncRestProxy = new AsyncRestProxy(httpPipeline, serializerAdapter, swaggerInterfaceParser);
        this.syncRestProxy = new SyncRestProxy(httpPipeline, serializerAdapter, swaggerInterfaceParser);
        this.httpPipeline = httpPipeline;
    }

    private SwaggerMethodParser getMethodParser(Method method) {
        return this.interfaceParser.getMethodParser(method);
    }

    public Mono<HttpResponse> send(HttpRequest httpRequest, Context context) {
        return this.httpPipeline.send(httpRequest, context);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        SwaggerMethodParser methodParser = getMethodParser(method);
        RequestOptions requestOptions = methodParser.setRequestOptions(objArr);
        Context context = methodParser.setContext(objArr);
        if (methodParser.isReactive() || isSyncDisabled(context)) {
            return this.asyncRestProxy.invoke(obj, method, requestOptions, requestOptions != null ? requestOptions.getErrorOptions() : null, requestOptions != null ? requestOptions.getRequestCallback() : null, methodParser, methodParser.isReactive(), objArr);
        }
        return this.syncRestProxy.invoke(obj, method, requestOptions, requestOptions != null ? requestOptions.getErrorOptions() : null, requestOptions != null ? requestOptions.getRequestCallback() : null, methodParser, false, objArr);
    }

    private static boolean isSyncDisabled(Context context) {
        return !((Boolean) context.getData(HTTP_REST_PROXY_SYNC_PROXY_ENABLED).orElse(Boolean.valueOf(GLOBAL_SYNC_PROXY_ENABLED))).booleanValue();
    }

    public static <A> A create(Class<A> cls) {
        return (A) create(cls, RestProxyUtils.createDefaultPipeline(), RestProxyUtils.createDefaultSerializer());
    }

    public static <A> A create(Class<A> cls, HttpPipeline httpPipeline) {
        return (A) create(cls, httpPipeline, RestProxyUtils.createDefaultSerializer());
    }

    public static <A> A create(Class<A> cls, HttpPipeline httpPipeline, SerializerAdapter serializerAdapter) {
        return (A) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new RestProxy(httpPipeline, serializerAdapter, SwaggerInterfaceParser.getInstance(cls)));
    }
}
