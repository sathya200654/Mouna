package com.azure.core.implementation.http.rest;

import androidx.camera.core.ImageAnalysis$;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.StreamResponse;
import com.azure.core.implementation.ImplUtils;
import com.azure.core.implementation.ReflectionSerializable;
import com.azure.core.implementation.TypeUtil;
import com.azure.core.implementation.serializer.HttpResponseDecoder;
import com.azure.core.util.Base64Url;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.serializer.SerializerAdapter;
import com.azure.core.util.serializer.SerializerEncoding;
import com.azure.json.JsonSerializable;
import com.azure.xml.XmlSerializable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.EnumSet;
import java.util.function.Consumer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class SyncRestProxy extends RestProxyBase {
    public SyncRestProxy(HttpPipeline httpPipeline, SerializerAdapter serializerAdapter, SwaggerInterfaceParser swaggerInterfaceParser) {
        super(httpPipeline, serializerAdapter, swaggerInterfaceParser);
    }

    HttpResponse send(HttpRequest httpRequest, Context context) {
        return this.httpPipeline.sendSync(httpRequest, context);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:? A[Catch: Exception -> 0x006a, SYNTHETIC, TRY_LEAVE, TryCatch #3 {Exception -> 0x006a, blocks: (B:34:0x0069, B:33:0x0066, B:21:0x0055, B:29:0x0060), top: B:47:0x000b, inners: #1 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.azure.core.util.tracing.Tracer] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.EnumSet, java.util.EnumSet<com.azure.core.implementation.http.rest.ErrorOptions>] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.azure.core.util.Context] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.azure.core.implementation.http.rest.RestProxyBase
    public Object invoke(Object obj, Method method, RequestOptions requestOptions, EnumSet<ErrorOptions> enumSet, Consumer<HttpRequest> consumer, SwaggerMethodParser swaggerMethodParser, HttpRequest httpRequest, Context context) throws Throwable {
        Context context2;
        Throwable th;
        Context contextStartTracingSpan = startTracingSpan(swaggerMethodParser, context);
        try {
            AutoCloseable autoCloseableMakeSpanCurrent = this.tracer.makeSpanCurrent(contextStartTracingSpan);
            try {
                if (requestOptions != null && consumer != null) {
                    try {
                        consumer.accept(httpRequest);
                    } catch (Throwable th2) {
                        th = th2;
                        enumSet = contextStartTracingSpan;
                        if (autoCloseableMakeSpanCurrent != null) {
                            throw th;
                        }
                        try {
                            ImageAnalysis$.ExternalSyntheticBackport0.m(autoCloseableMakeSpanCurrent);
                            throw th;
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                            throw th;
                        }
                    }
                }
                try {
                    if (httpRequest.getBodyAsBinaryData() != null) {
                        httpRequest.setBody(RestProxyUtils.validateLengthSync(httpRequest));
                    }
                    HttpResponseDecoder.HttpDecodedResponse httpDecodedResponseDecodeSync = this.decoder.decodeSync(send(httpRequest, contextStartTracingSpan), swaggerMethodParser);
                    context2 = contextStartTracingSpan;
                    try {
                        Object objHandleRestReturnType = handleRestReturnType(httpDecodedResponseDecodeSync, swaggerMethodParser, swaggerMethodParser.getReturnType(), context2, requestOptions, enumSet);
                        int statusCode = httpDecodedResponseDecodeSync.getSourceResponse().getStatusCode();
                        this.tracer.end(statusCode >= 400 ? String.valueOf(statusCode) : null, (Throwable) null, context2);
                        if (autoCloseableMakeSpanCurrent != null) {
                            ImageAnalysis$.ExternalSyntheticBackport0.m(autoCloseableMakeSpanCurrent);
                        }
                        return objHandleRestReturnType;
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        enumSet = context2;
                        if (autoCloseableMakeSpanCurrent != null) {
                            throw th;
                        }
                        ImageAnalysis$.ExternalSyntheticBackport0.m(autoCloseableMakeSpanCurrent);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    context2 = contextStartTracingSpan;
                }
            } catch (Exception e) {
                e = e;
                Exception exc = e;
                this.tracer.end(null, exc, enumSet);
                ImplUtils.sneakyThrows(exc);
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            enumSet = contextStartTracingSpan;
        }
    }

    private HttpResponseDecoder.HttpDecodedResponse ensureExpectedStatus(HttpResponseDecoder.HttpDecodedResponse httpDecodedResponse, SwaggerMethodParser swaggerMethodParser, RequestOptions requestOptions, EnumSet<ErrorOptions> enumSet) {
        int statusCode = httpDecodedResponse.getSourceResponse().getStatusCode();
        if (swaggerMethodParser.isExpectedResponseStatusCode(statusCode) || (requestOptions != null && enumSet.contains(ErrorOptions.NO_THROW))) {
            return httpDecodedResponse;
        }
        BinaryData bodyAsBinaryData = httpDecodedResponse.getSourceResponse().getBodyAsBinaryData();
        byte[] bytes = bodyAsBinaryData == null ? null : bodyAsBinaryData.toBytes();
        if (bytes == null || bytes.length == 0) {
            throw instantiateUnexpectedException(swaggerMethodParser.getUnexpectedException(statusCode), httpDecodedResponse.getSourceResponse(), null, null);
        }
        throw instantiateUnexpectedException(swaggerMethodParser.getUnexpectedException(statusCode), httpDecodedResponse.getSourceResponse(), bytes, httpDecodedResponse.getDecodedBody(bytes));
    }

    private Object handleRestResponseReturnType(HttpResponseDecoder.HttpDecodedResponse httpDecodedResponse, SwaggerMethodParser swaggerMethodParser, Type type) {
        if (swaggerMethodParser.isStreamResponse()) {
            return new StreamResponse(httpDecodedResponse.getSourceResponse());
        }
        if (TypeUtil.isTypeOrSubTypeOf(type, Response.class)) {
            Type restResponseBodyType = TypeUtil.getRestResponseBodyType(type);
            if (TypeUtil.isTypeOrSubTypeOf(restResponseBodyType, Void.class)) {
                httpDecodedResponse.getSourceResponse().close();
                return createResponse(httpDecodedResponse, type, null);
            }
            Response responseCreateResponse = createResponse(httpDecodedResponse, type, handleBodyReturnType(httpDecodedResponse, swaggerMethodParser, restResponseBodyType));
            return responseCreateResponse == null ? createResponse(httpDecodedResponse, type, null) : responseCreateResponse;
        }
        return handleBodyReturnType(httpDecodedResponse, swaggerMethodParser, type);
    }

    private Object handleBodyReturnType(HttpResponseDecoder.HttpDecodedResponse httpDecodedResponse, SwaggerMethodParser swaggerMethodParser, Type type) {
        int statusCode = httpDecodedResponse.getSourceResponse().getStatusCode();
        HttpMethod httpMethod = swaggerMethodParser.getHttpMethod();
        Type returnValueWireType = swaggerMethodParser.getReturnValueWireType();
        if (httpMethod == HttpMethod.HEAD && (TypeUtil.isTypeOrSubTypeOf(type, Boolean.TYPE) || TypeUtil.isTypeOrSubTypeOf(type, Boolean.class))) {
            return Boolean.valueOf(statusCode / 100 == 2);
        }
        if (TypeUtil.isTypeOrSubTypeOf(type, byte[].class)) {
            BinaryData bodyAsBinaryData = httpDecodedResponse.getSourceResponse().getBodyAsBinaryData();
            byte[] bytes = bodyAsBinaryData != null ? bodyAsBinaryData.toBytes() : null;
            if (returnValueWireType == Base64Url.class) {
                bytes = new Base64Url(bytes).decodedBytes();
            }
            if (bytes == null || bytes.length == 0) {
                return null;
            }
            return bytes;
        }
        if (TypeUtil.isTypeOrSubTypeOf(type, InputStream.class)) {
            return httpDecodedResponse.getSourceResponse().getBodyAsInputStream().block();
        }
        if (TypeUtil.isTypeOrSubTypeOf(type, BinaryData.class)) {
            return httpDecodedResponse.getSourceResponse().getBodyAsBinaryData();
        }
        return httpDecodedResponse.getDecodedBody(null);
    }

    private Object handleRestReturnType(HttpResponseDecoder.HttpDecodedResponse httpDecodedResponse, SwaggerMethodParser swaggerMethodParser, Type type, Context context, RequestOptions requestOptions, EnumSet<ErrorOptions> enumSet) {
        HttpResponseDecoder.HttpDecodedResponse httpDecodedResponseEnsureExpectedStatus = ensureExpectedStatus(httpDecodedResponse, swaggerMethodParser, requestOptions, enumSet);
        if (TypeUtil.isTypeOrSubTypeOf(type, Void.TYPE) || TypeUtil.isTypeOrSubTypeOf(type, Void.class)) {
            httpDecodedResponseEnsureExpectedStatus.close();
            return null;
        }
        return handleRestResponseReturnType(httpDecodedResponse, swaggerMethodParser, type);
    }

    @Override // com.azure.core.implementation.http.rest.RestProxyBase
    public void updateRequest(RequestDataConfiguration requestDataConfiguration, SerializerAdapter serializerAdapter) throws IOException {
        boolean zIsJson = requestDataConfiguration.isJson();
        HttpRequest httpRequest = requestDataConfiguration.getHttpRequest();
        Object bodyContent = requestDataConfiguration.getBodyContent();
        if (bodyContent == null) {
            return;
        }
        if (ReflectionSerializable.supportsJsonSerializable(bodyContent.getClass())) {
            httpRequest.setBody(ReflectionSerializable.serializeJsonSerializableToBytes((JsonSerializable) bodyContent));
            return;
        }
        if (ReflectionSerializable.supportsXmlSerializable(bodyContent.getClass())) {
            httpRequest.setBody(ReflectionSerializable.serializeXmlSerializableToBytes((XmlSerializable) bodyContent));
            return;
        }
        if (zIsJson) {
            httpRequest.setBody(serializerAdapter.serializeToBytes(bodyContent, SerializerEncoding.JSON));
            return;
        }
        if (bodyContent instanceof byte[]) {
            httpRequest.setBody((byte[]) bodyContent);
            return;
        }
        if (bodyContent instanceof String) {
            String str = (String) bodyContent;
            if (str.isEmpty()) {
                return;
            }
            httpRequest.setBody(str);
            return;
        }
        if (bodyContent instanceof ByteBuffer) {
            httpRequest.setBody(BinaryData.fromByteBuffer((ByteBuffer) bodyContent));
        } else if (bodyContent instanceof InputStream) {
            httpRequest.setBody(BinaryData.fromStream((InputStream) bodyContent));
        } else {
            httpRequest.setBody(serializerAdapter.serializeToBytes(bodyContent, SerializerEncoding.fromHeaders(httpRequest.getHeaders())));
        }
    }
}
