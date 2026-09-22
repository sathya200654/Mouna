package com.azure.core.util.polling.implementation;

import com.azure.core.implementation.TypeUtil;
import com.azure.core.util.BinaryData;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.function.Function;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class PollingUtils {
    private static final String FORWARD_SLASH = "/";

    public static Mono<BinaryData> serializeResponse(Object obj, ObjectSerializer objectSerializer) {
        if (obj instanceof BinaryData) {
            return Mono.just((BinaryData) obj);
        }
        return BinaryData.fromObjectAsync(obj, objectSerializer);
    }

    public static BinaryData serializeResponseSync(Object obj, ObjectSerializer objectSerializer) {
        if (obj instanceof BinaryData) {
            return (BinaryData) obj;
        }
        return BinaryData.fromObject(obj, objectSerializer);
    }

    public static <T> Mono<T> deserializeResponse(BinaryData binaryData, ObjectSerializer objectSerializer, TypeReference<T> typeReference) {
        if (TypeUtil.isTypeOrSubTypeOf(BinaryData.class, typeReference.getJavaType())) {
            return (Mono<T>) binaryData.toReplayableBinaryDataAsync();
        }
        return binaryData.toObjectAsync(typeReference, objectSerializer);
    }

    public static <T> T deserializeResponseSync(BinaryData binaryData, ObjectSerializer objectSerializer, TypeReference<T> typeReference) {
        if (TypeUtil.isTypeOrSubTypeOf(BinaryData.class, typeReference.getJavaType())) {
            return (T) binaryData.toReplayableBinaryData();
        }
        return (T) binaryData.m1236lambda$toObjectAsync$4$comazurecoreutilBinaryData(typeReference, objectSerializer);
    }

    public static <T> Mono<T> convertResponse(Object obj, final ObjectSerializer objectSerializer, final TypeReference<T> typeReference) {
        if (obj == null) {
            return Mono.empty();
        }
        if (TypeUtil.isTypeOrSubTypeOf(obj.getClass(), typeReference.getJavaType())) {
            return Mono.just(obj);
        }
        return serializeResponse(obj, objectSerializer).flatMap(new Function() { // from class: com.azure.core.util.polling.implementation.PollingUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return PollingUtils.deserializeResponse((BinaryData) obj2, objectSerializer, typeReference);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T convertResponseSync(Object obj, ObjectSerializer objectSerializer, TypeReference<T> typeReference) {
        if (obj == 0) {
            return null;
        }
        return TypeUtil.isTypeOrSubTypeOf(obj.getClass(), typeReference.getJavaType()) ? obj : (T) deserializeResponseSync(serializeResponseSync(obj, objectSerializer), objectSerializer, typeReference);
    }

    public static String getAbsolutePath(String str, String str2, ClientLogger clientLogger) {
        try {
            if (new URI(str).isAbsolute()) {
                return str;
            }
            if (CoreUtils.isNullOrEmpty(str2)) {
                throw clientLogger.logExceptionAsError(new IllegalArgumentException("Relative path requires endpoint to be non-null and non-empty to create an absolute path."));
            }
            if (str2.endsWith("/") && str.startsWith("/")) {
                return str2 + str.substring(1);
            }
            if (!str2.endsWith("/") && !str.startsWith("/")) {
                return str2 + "/" + str;
            }
            return str2 + str;
        } catch (URISyntaxException e) {
            throw clientLogger.logExceptionAsWarning(new IllegalArgumentException("'path' must be a valid URI.", e));
        }
    }

    private PollingUtils() {
    }
}
