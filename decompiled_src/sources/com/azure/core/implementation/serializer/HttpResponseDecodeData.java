package com.azure.core.implementation.serializer;

import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.rest.ResponseBase;
import com.azure.core.implementation.TypeUtil;
import com.azure.core.implementation.http.UnexpectedExceptionInformation;
import com.azure.core.implementation.http.rest.SwaggerMethodParser;
import java.lang.reflect.Type;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface HttpResponseDecodeData {
    Type getReturnType();

    default Type getReturnValueWireType() {
        return null;
    }

    boolean isExpectedResponseStatusCode(int i);

    boolean isHeadersEagerlyConverted();

    default Type getHeadersType() {
        Type returnType = getReturnType();
        if (TypeUtil.isTypeOrSubTypeOf(returnType, Mono.class)) {
            returnType = TypeUtil.getTypeArgument(returnType);
        }
        if (TypeUtil.isTypeOrSubTypeOf(returnType, ResponseBase.class)) {
            return TypeUtil.getTypeArguments(TypeUtil.getSuperType(returnType, ResponseBase.class))[0];
        }
        return null;
    }

    default UnexpectedExceptionInformation getUnexpectedException(int i) {
        return new UnexpectedExceptionInformation(HttpResponseException.class);
    }

    default boolean isReturnTypeDecodeable() {
        return SwaggerMethodParser.isReturnTypeDecodeable(SwaggerMethodParser.unwrapReturnType(getReturnType()));
    }

    default boolean isResponseEagerlyRead() {
        return SwaggerMethodParser.isResponseEagerlyRead(SwaggerMethodParser.unwrapReturnType(getReturnType()));
    }

    default boolean isResponseBodyIgnored() {
        return SwaggerMethodParser.isResponseBodyIgnored(SwaggerMethodParser.unwrapReturnType(getReturnType()));
    }
}
