package com.azure.core.implementation.serializer;

import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.rest.Page;
import com.azure.core.http.rest.Response;
import com.azure.core.implementation.ReflectionSerializable;
import com.azure.core.implementation.TypeUtil;
import com.azure.core.util.Base64Url;
import com.azure.core.util.DateTimeRfc1123;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import com.azure.core.util.serializer.SerializerAdapter;
import com.azure.core.util.serializer.SerializerEncoding;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HttpResponseBodyDecoder {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) HttpResponseBodyDecoder.class);

    static Object decodeByteArray(byte[] bArr, HttpResponse httpResponse, SerializerAdapter serializerAdapter, HttpResponseDecodeData httpResponseDecodeData) {
        ensureRequestSet(httpResponse);
        if (httpResponse.getRequest().getHttpMethod() == HttpMethod.HEAD) {
            return null;
        }
        if (isErrorStatus(httpResponse.getStatusCode(), httpResponseDecodeData)) {
            if (bArr != null) {
                try {
                    if (bArr.length != 0) {
                        return deserializeBody(bArr, httpResponseDecodeData.getUnexpectedException(httpResponse.getStatusCode()).getExceptionBodyType(), null, serializerAdapter, SerializerEncoding.fromHeaders(httpResponse.getHeaders()));
                    }
                } catch (MalformedValueException | IOException | IllegalStateException e) {
                    LOGGER.log(LogLevel.WARNING, new Supplier() { // from class: com.azure.core.implementation.serializer.HttpResponseBodyDecoder$$ExternalSyntheticLambda0
                        @Override // java.util.function.Supplier
                        public final Object get() {
                            return HttpResponseBodyDecoder.lambda$decodeByteArray$0();
                        }
                    }, e);
                    return e;
                }
            }
            return null;
        }
        if (!httpResponseDecodeData.isReturnTypeDecodeable()) {
            return null;
        }
        if (bArr == null) {
            bArr = httpResponse.getBodyAsBinaryData().toBytes();
        }
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    return deserializeBody(bArr, extractEntityTypeFromReturnType(httpResponseDecodeData), httpResponseDecodeData.getReturnValueWireType(), serializerAdapter, SerializerEncoding.fromHeaders(httpResponse.getHeaders()));
                }
            } catch (MalformedValueException e2) {
                throw new HttpResponseException("HTTP response has a malformed body.", httpResponse, (Throwable) e2);
            } catch (IOException e3) {
                throw new HttpResponseException("Deserialization Failed.", httpResponse, (Throwable) e3);
            }
        }
        return null;
    }

    static /* synthetic */ String lambda$decodeByteArray$0() {
        return "Failed to deserialize the error entity.";
    }

    static Type decodedType(HttpResponse httpResponse, HttpResponseDecodeData httpResponseDecodeData) {
        ensureRequestSet(httpResponse);
        if (httpResponse.getRequest().getHttpMethod() == HttpMethod.HEAD) {
            return null;
        }
        if (isErrorStatus(httpResponse.getStatusCode(), httpResponseDecodeData)) {
            return httpResponseDecodeData.getUnexpectedException(httpResponse.getStatusCode()).getExceptionBodyType();
        }
        if (httpResponseDecodeData.isReturnTypeDecodeable()) {
            return extractEntityTypeFromReturnType(httpResponseDecodeData);
        }
        return null;
    }

    static boolean isErrorStatus(int i, HttpResponseDecodeData httpResponseDecodeData) {
        return !httpResponseDecodeData.isExpectedResponseStatusCode(i);
    }

    private static Object deserializeBody(byte[] bArr, Type type, Type type2, SerializerAdapter serializerAdapter, SerializerEncoding serializerEncoding) throws IOException {
        if (type2 == null) {
            return deserialize(bArr, type, serializerAdapter, serializerEncoding);
        }
        if (TypeUtil.isTypeOrSubTypeOf(type2, Page.class)) {
            if (type2 == Page.class) {
                type2 = TypeUtil.createParameterizedType(ItemPage.class, type);
            }
            return deserialize(bArr, type2, serializerAdapter, serializerEncoding);
        }
        return convertToResultType(deserialize(bArr, constructWireResponseType(type, type2), serializerAdapter, serializerEncoding), type, type2);
    }

    private static Object deserialize(byte[] bArr, Type type, SerializerAdapter serializerAdapter, SerializerEncoding serializerEncoding) throws IOException {
        Class<?> rawClass = TypeUtil.getRawClass(type);
        if (serializerEncoding == SerializerEncoding.JSON && ReflectionSerializable.supportsJsonSerializable(rawClass)) {
            return ReflectionSerializable.deserializeAsJsonSerializable(rawClass, bArr);
        }
        if (serializerEncoding == SerializerEncoding.XML && ReflectionSerializable.supportsXmlSerializable(rawClass)) {
            return ReflectionSerializable.deserializeAsXmlSerializable(rawClass, bArr);
        }
        return serializerAdapter.deserialize(bArr, type, serializerEncoding);
    }

    private static Type constructWireResponseType(Type type, Type type2) {
        Objects.requireNonNull(type2);
        if (type == byte[].class) {
            return type2 == Base64Url.class ? Base64Url.class : type;
        }
        if (type == OffsetDateTime.class) {
            return type2 == DateTimeRfc1123.class ? DateTimeRfc1123.class : type;
        }
        if (TypeUtil.isTypeOrSubTypeOf(type, List.class)) {
            return TypeUtil.createParameterizedType(((ParameterizedType) type).getRawType(), constructWireResponseType(TypeUtil.getTypeArgument(type), type2));
        }
        if (!TypeUtil.isTypeOrSubTypeOf(type, Map.class)) {
            return type;
        }
        Type[] typeArguments = TypeUtil.getTypeArguments(type);
        return TypeUtil.createParameterizedType(((ParameterizedType) type).getRawType(), typeArguments[0], constructWireResponseType(typeArguments[1], type2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.Map] */
    private static Object convertToResultType(Object obj, Type type, Type type2) {
        if (type == byte[].class) {
            if (type2 == Base64Url.class) {
                return ((Base64Url) obj).decodedBytes();
            }
        } else if (type == OffsetDateTime.class) {
            if (type2 == DateTimeRfc1123.class) {
                return ((DateTimeRfc1123) obj).getDateTime();
            }
        } else {
            if (TypeUtil.isTypeOrSubTypeOf(type, List.class)) {
                Type typeArgument = TypeUtil.getTypeArgument(type);
                List list = (List) obj;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Object obj2 = list.get(i);
                    Object objConvertToResultType = convertToResultType(obj2, typeArgument, type2);
                    if (obj2 != objConvertToResultType) {
                        list.set(i, objConvertToResultType);
                    }
                }
                return list;
            }
            if (TypeUtil.isTypeOrSubTypeOf(type, Map.class)) {
                Type type3 = TypeUtil.getTypeArguments(type)[1];
                obj = (Map) obj;
                for (Map.Entry entry : obj.entrySet()) {
                    Object value = entry.getValue();
                    Object objConvertToResultType2 = convertToResultType(value, type3, type2);
                    if (value != objConvertToResultType2) {
                        obj.put((String) entry.getKey(), objConvertToResultType2);
                    }
                }
            }
        }
        return obj;
    }

    private static Type extractEntityTypeFromReturnType(HttpResponseDecodeData httpResponseDecodeData) {
        Type returnType = httpResponseDecodeData.getReturnType();
        if (TypeUtil.isTypeOrSubTypeOf(returnType, Mono.class)) {
            returnType = TypeUtil.getTypeArgument(returnType);
        }
        return TypeUtil.isTypeOrSubTypeOf(returnType, Response.class) ? TypeUtil.getRestResponseBodyType(returnType) : returnType;
    }

    private static void ensureRequestSet(HttpResponse httpResponse) {
        Objects.requireNonNull(httpResponse.getRequest());
        Objects.requireNonNull(httpResponse.getRequest().getHttpMethod());
    }
}
