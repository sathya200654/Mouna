package com.azure.core.implementation.http.rest;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.rest.Response;
import com.azure.core.implementation.ReflectionUtils;
import com.azure.core.implementation.ReflectiveInvoker;
import com.azure.core.implementation.serializer.HttpResponseDecoder;
import com.azure.core.util.logging.ClientLogger;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ResponseConstructorsCache {
    private static final String FIVE_PARAM_ERROR = "Failed to deserialize 5-parameter response.";
    private static final String FOUR_PARAM_ERROR = "Failed to deserialize 4-parameter response.";
    private static final String INVALID_PARAM_COUNT = "Response constructor with expected parameters not found.";
    private static final String THREE_PARAM_ERROR = "Failed to deserialize 3-parameter response.";
    private static final Map<Class<?>, ReflectiveInvoker> CACHE = new ConcurrentHashMap();
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ResponseConstructorsCache.class);

    public ReflectiveInvoker get(Class<? extends Response<?>> cls) {
        return CACHE.computeIfAbsent(cls, new Function() { // from class: com.azure.core.implementation.http.rest.ResponseConstructorsCache$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ResponseConstructorsCache.locateResponseConstructor((Class) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ReflectiveInvoker locateResponseConstructor(Class<?> cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        Arrays.sort(declaredConstructors, Comparator.comparing(new Function() { // from class: com.azure.core.implementation.http.rest.ResponseConstructorsCache$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((Constructor) obj).getParameterCount());
            }
        }, new Comparator() { // from class: com.azure.core.implementation.http.rest.ResponseConstructorsCache$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ResponseConstructorsCache.lambda$locateResponseConstructor$0((Integer) obj, (Integer) obj2);
            }
        }));
        for (Constructor<?> constructor : declaredConstructors) {
            int parameterCount = constructor.getParameterCount();
            if (parameterCount >= 3 && parameterCount <= 5) {
                try {
                    return ReflectionUtils.getConstructorInvoker(cls, constructor);
                } catch (Exception e) {
                    if (e instanceof RuntimeException) {
                        throw LOGGER.logExceptionAsError((RuntimeException) e);
                    }
                    throw LOGGER.logExceptionAsError(new RuntimeException(e));
                }
            }
        }
        throw LOGGER.logExceptionAsError(new RuntimeException("Cannot find suitable constructor for class " + cls));
    }

    static /* synthetic */ int lambda$locateResponseConstructor$0(Integer num, Integer num2) {
        return num2.intValue() - num.intValue();
    }

    public Response<?> invoke(ReflectiveInvoker reflectiveInvoker, HttpResponseDecoder.HttpDecodedResponse httpDecodedResponse, Object obj) {
        HttpResponse sourceResponse = httpDecodedResponse.getSourceResponse();
        HttpRequest request = sourceResponse.getRequest();
        int statusCode = sourceResponse.getStatusCode();
        HttpHeaders headers = sourceResponse.getHeaders();
        int parameterCount = reflectiveInvoker.getParameterCount();
        if (parameterCount == 3) {
            return constructResponse(reflectiveInvoker, THREE_PARAM_ERROR, request, Integer.valueOf(statusCode), headers);
        }
        if (parameterCount == 4) {
            return constructResponse(reflectiveInvoker, FOUR_PARAM_ERROR, request, Integer.valueOf(statusCode), headers, obj);
        }
        if (parameterCount == 5) {
            return constructResponse(reflectiveInvoker, FIVE_PARAM_ERROR, request, Integer.valueOf(statusCode), headers, obj, httpDecodedResponse.getDecodedHeaders());
        }
        throw LOGGER.logExceptionAsError(new IllegalStateException(INVALID_PARAM_COUNT));
    }

    private static Response<?> constructResponse(ReflectiveInvoker reflectiveInvoker, String str, Object... objArr) {
        try {
            return (Response) reflectiveInvoker.invokeStatic(objArr);
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw LOGGER.logExceptionAsError((RuntimeException) e);
            }
            throw LOGGER.logExceptionAsError(new IllegalStateException(str, e));
        }
    }
}
