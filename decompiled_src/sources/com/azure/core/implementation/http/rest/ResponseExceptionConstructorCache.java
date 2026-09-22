package com.azure.core.implementation.http.rest;

import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.HttpResponse;
import com.azure.core.implementation.ReflectionUtils;
import com.azure.core.implementation.ReflectiveInvoker;
import com.azure.core.util.logging.ClientLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ResponseExceptionConstructorCache {
    private static final Map<Class<? extends HttpResponseException>, ReflectiveInvoker> CACHE = new ConcurrentHashMap();
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ResponseExceptionConstructorCache.class);

    public ReflectiveInvoker get(Class<? extends HttpResponseException> cls, final Class<?> cls2) {
        return CACHE.computeIfAbsent(cls, new Function() { // from class: com.azure.core.implementation.http.rest.ResponseExceptionConstructorCache$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ResponseExceptionConstructorCache.locateExceptionConstructor((Class) obj, cls2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ReflectiveInvoker locateExceptionConstructor(Class<? extends HttpResponseException> cls, Class<?> cls2) {
        try {
            return ReflectionUtils.getConstructorInvoker(cls, cls.getConstructor(String.class, HttpResponse.class, cls2));
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw LOGGER.logExceptionAsError((RuntimeException) e);
            }
            throw LOGGER.logExceptionAsError(new RuntimeException(e));
        }
    }

    static <T extends HttpResponseException> T invoke(ReflectiveInvoker reflectiveInvoker, String str, HttpResponse httpResponse, Object obj) {
        try {
            return (T) reflectiveInvoker.invokeStatic(str, httpResponse, obj);
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw LOGGER.logExceptionAsError((RuntimeException) e);
            }
            throw LOGGER.logExceptionAsError(new IllegalStateException(str, e));
        }
    }
}
