package com.azure.core.implementation.http.rest;

import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.Delete;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.FormParam;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.Head;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.Options;
import com.azure.core.annotation.Patch;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.Put;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnValueWireType;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.ContentType;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.rest.Page;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.ResponseBase;
import com.azure.core.http.rest.StreamResponse;
import com.azure.core.implementation.TypeUtil;
import com.azure.core.implementation.http.UnexpectedExceptionInformation;
import com.azure.core.implementation.serializer.HttpResponseDecodeData;
import com.azure.core.util.Base64Url;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.DateTimeRfc1123;
import com.azure.core.util.ExpandableStringEnum;
import com.azure.core.util.UrlBuilder;
import com.azure.core.util.serializer.SerializerAdapter;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class SwaggerMethodParser implements HttpResponseDecodeData {
    private static final List<Class<? extends Annotation>> REQUIRED_HTTP_METHODS = Arrays.asList(Delete.class, Get.class, Head.class, Options.class, Patch.class, Post.class, Put.class);
    private final Integer bodyContentMethodParameterIndex;
    private final String bodyContentType;
    private final Type bodyJavaType;
    private final int contextPosition;
    private UnexpectedExceptionInformation defaultException;
    private Map<Integer, UnexpectedExceptionInformation> exceptionMapping;
    private final BitSet expectedStatusCodes;
    private final List<Substitution> formSubstitutions;
    private final String fullyQualifiedMethodName;
    private final List<HeaderSubstitution> headerSubstitutions;
    private final HttpHeaders headers;
    private final boolean headersEagerlyConverted;
    final List<RangeReplaceSubstitution> hostSubstitutions;
    private final HttpMethod httpMethod;
    private final boolean ignoreResponseBody;
    private final boolean isReactive;
    private final boolean isStreamResponse;
    private final List<RangeReplaceSubstitution> pathSubstitutions;
    private final List<QuerySubstitution> querySubstitutions;
    private final String rawHost;
    private final String relativePath;
    private final int requestOptionsPosition;
    private final boolean responseEagerlyRead;
    private final Type returnType;
    private final boolean returnTypeDecodeable;
    private final Type returnValueWireType;
    private final String spanName;
    private final UnexpectedResponseExceptionType[] unexpectedResponseExceptionTypes;

    public SwaggerMethodParser(Method method) {
        this(SwaggerInterfaceParser.getInstance(method.getDeclaringClass()), method);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0321  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v3, types: [int] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    SwaggerMethodParser(SwaggerInterfaceParser swaggerInterfaceParser, Method method) {
        ?? r8;
        ?? r7;
        boolean z;
        boolean z2;
        this.hostSubstitutions = new ArrayList();
        this.pathSubstitutions = new ArrayList();
        this.querySubstitutions = new ArrayList();
        this.formSubstitutions = new ArrayList();
        this.headerSubstitutions = new ArrayList();
        this.headers = new HttpHeaders();
        this.rawHost = swaggerInterfaceParser.getHost();
        this.fullyQualifiedMethodName = method.getDeclaringClass().getName() + "." + method.getName();
        if (method.isAnnotationPresent(Get.class)) {
            this.httpMethod = HttpMethod.GET;
            this.relativePath = ((Get) method.getAnnotation(Get.class)).value();
        } else if (method.isAnnotationPresent(Put.class)) {
            this.httpMethod = HttpMethod.PUT;
            this.relativePath = ((Put) method.getAnnotation(Put.class)).value();
        } else if (method.isAnnotationPresent(Head.class)) {
            this.httpMethod = HttpMethod.HEAD;
            this.relativePath = ((Head) method.getAnnotation(Head.class)).value();
        } else if (method.isAnnotationPresent(Delete.class)) {
            this.httpMethod = HttpMethod.DELETE;
            this.relativePath = ((Delete) method.getAnnotation(Delete.class)).value();
        } else if (method.isAnnotationPresent(Post.class)) {
            this.httpMethod = HttpMethod.POST;
            this.relativePath = ((Post) method.getAnnotation(Post.class)).value();
        } else if (method.isAnnotationPresent(Patch.class)) {
            this.httpMethod = HttpMethod.PATCH;
            this.relativePath = ((Patch) method.getAnnotation(Patch.class)).value();
        } else if (method.isAnnotationPresent(Options.class)) {
            this.httpMethod = HttpMethod.OPTIONS;
            this.relativePath = ((Options) method.getAnnotation(Options.class)).value();
        } else {
            throw new MissingRequiredAnnotationException(REQUIRED_HTTP_METHODS, method);
        }
        this.returnType = method.getGenericReturnType();
        ReturnValueWireType returnValueWireType = (ReturnValueWireType) method.getAnnotation(ReturnValueWireType.class);
        Integer numValueOf = null;
        boolean z3 = false;
        if (returnValueWireType != null) {
            Class<?> clsValue = returnValueWireType.value();
            if (clsValue == Base64Url.class || clsValue == DateTimeRfc1123.class) {
                this.returnValueWireType = clsValue;
            } else if (TypeUtil.isTypeOrSubTypeOf(clsValue, List.class)) {
                this.returnValueWireType = clsValue.getGenericInterfaces()[0];
            } else if (TypeUtil.isTypeOrSubTypeOf(clsValue, Page.class)) {
                this.returnValueWireType = clsValue;
            } else {
                this.returnValueWireType = null;
            }
        } else {
            this.returnValueWireType = null;
        }
        if (method.isAnnotationPresent(Headers.class)) {
            for (String str : ((Headers) method.getAnnotation(Headers.class)).value()) {
                int iIndexOf = str.indexOf(":");
                if (iIndexOf >= 0) {
                    String strTrim = str.substring(0, iIndexOf).trim();
                    if (!strTrim.isEmpty()) {
                        String strTrim2 = str.substring(iIndexOf + 1).trim();
                        if (!strTrim2.isEmpty()) {
                            if (strTrim2.contains(",")) {
                                this.headers.set(strTrim, Arrays.asList(strTrim2.split(",")));
                            } else {
                                this.headers.set(strTrim, strTrim2);
                            }
                        }
                    }
                }
            }
        }
        ExpectedResponses expectedResponses = (ExpectedResponses) method.getAnnotation(ExpectedResponses.class);
        if (expectedResponses != null && expectedResponses.value().length > 0) {
            this.expectedStatusCodes = new BitSet();
            for (int i : expectedResponses.value()) {
                this.expectedStatusCodes.set(i);
            }
        } else {
            this.expectedStatusCodes = null;
        }
        this.unexpectedResponseExceptionTypes = (UnexpectedResponseExceptionType[]) method.getAnnotationsByType(UnexpectedResponseExceptionType.class);
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        String strValue = null;
        Type type = null;
        int i2 = 0;
        while (true) {
            boolean z4 = true;
            if (i2 >= parameterAnnotations.length) {
                break;
            }
            Annotation[] annotationArr = method.getParameterAnnotations()[i2];
            int length = annotationArr.length;
            for (?? r12 = z3; r12 < length; r12++) {
                Annotation annotation = annotationArr[r12];
                Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
                if (clsAnnotationType.equals(HostParam.class)) {
                    HostParam hostParam = (HostParam) annotation;
                    z = z4;
                    this.hostSubstitutions.addAll(RangeReplaceSubstitution.getRangeReplaceSubstitutions(hostParam.value(), i2, hostParam.encoded() ^ z4, this.rawHost));
                } else {
                    z = z4;
                    if (clsAnnotationType.equals(PathParam.class)) {
                        PathParam pathParam = (PathParam) annotation;
                        this.pathSubstitutions.addAll(RangeReplaceSubstitution.getRangeReplaceSubstitutions(pathParam.value(), i2, !pathParam.encoded(), this.relativePath));
                    } else if (clsAnnotationType.equals(QueryParam.class)) {
                        QueryParam queryParam = (QueryParam) annotation;
                        this.querySubstitutions.add(new QuerySubstitution(queryParam.value(), i2, !queryParam.encoded(), queryParam.multipleQueryParams()));
                        z2 = false;
                    } else if (clsAnnotationType.equals(HeaderParam.class)) {
                        z2 = false;
                        this.headerSubstitutions.add(new HeaderSubstitution(((HeaderParam) annotation).value(), i2, false));
                    } else {
                        z2 = false;
                        if (clsAnnotationType.equals(BodyParam.class)) {
                            numValueOf = Integer.valueOf(i2);
                            strValue = ((BodyParam) annotation).value();
                            type = method.getGenericParameterTypes()[i2];
                        } else if (clsAnnotationType.equals(FormParam.class)) {
                            FormParam formParam = (FormParam) annotation;
                            this.formSubstitutions.add(new Substitution(formParam.value(), i2, !formParam.encoded()));
                            type = String.class;
                            strValue = ContentType.APPLICATION_X_WWW_FORM_URLENCODED;
                        }
                    }
                    z3 = z2;
                    z4 = z;
                }
                z2 = z3;
                z3 = z2;
                z4 = z;
            }
            i2++;
        }
        boolean z5 = z3;
        this.hostSubstitutions.sort(new Comparator() { // from class: com.azure.core.implementation.http.rest.SwaggerMethodParser$$ExternalSyntheticLambda6
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((RangeReplaceSubstitution) obj).compareTo((RangeReplaceSubstitution) obj2);
            }
        });
        this.pathSubstitutions.sort(new Comparator() { // from class: com.azure.core.implementation.http.rest.SwaggerMethodParser$$ExternalSyntheticLambda6
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((RangeReplaceSubstitution) obj).compareTo((RangeReplaceSubstitution) obj2);
            }
        });
        this.bodyContentMethodParameterIndex = numValueOf;
        this.bodyContentType = strValue;
        this.bodyJavaType = type;
        boolean zIsReactiveType = isReactiveType(this.returnType);
        Class<?>[] parameterTypes = method.getParameterTypes();
        ?? r9 = -1;
        ?? r10 = -1;
        ?? r6 = z5;
        while (r6 < parameterTypes.length) {
            Class<?> cls = parameterTypes[r6];
            if (cls == Context.class && r9 == -1) {
                r7 = r6;
            } else {
                r7 = r9;
                r7 = r9;
                r8 = r10;
                r8 = r10;
                if (cls == RequestOptions.class && r10 == -1) {
                    r8 = r6;
                }
            }
            if (zIsReactiveType) {
                r7 = r9;
                r8 = r10;
                r8 = r10;
                zIsReactiveType = true;
            } else {
                r7 = r9;
                if (isReactiveType(cls)) {
                    r7 = r9;
                    r8 = r10;
                    r8 = r10;
                    zIsReactiveType = true;
                } else {
                    r8 = r10;
                    zIsReactiveType = z5;
                }
            }
            r6++;
            r9 = r7;
            r10 = r8;
        }
        this.isReactive = zIsReactiveType;
        if (zIsReactiveType) {
            Type typeArgument = TypeUtil.getTypeArgument(this.returnType);
            this.isStreamResponse = isStreamResponseType(typeArgument);
            this.headersEagerlyConverted = TypeUtil.isTypeOrSubTypeOf(ResponseBase.class, typeArgument);
        } else {
            this.isStreamResponse = isStreamResponseType(this.returnType);
            this.headersEagerlyConverted = TypeUtil.isTypeOrSubTypeOf(ResponseBase.class, this.returnType);
        }
        this.contextPosition = r9 == true ? 1 : 0;
        this.requestOptionsPosition = r10 == true ? 1 : 0;
        Type typeUnwrapReturnType = unwrapReturnType(this.returnType);
        this.returnTypeDecodeable = isReturnTypeDecodeable(typeUnwrapReturnType);
        this.responseEagerlyRead = isResponseEagerlyRead(typeUnwrapReturnType);
        this.ignoreResponseBody = isResponseBodyIgnored(typeUnwrapReturnType);
        this.spanName = swaggerInterfaceParser.getServiceName() + "." + method.getName();
        RestProxyUtils.validateResumeOperationIsNotPresent(method);
    }

    public String getFullyQualifiedMethodName() {
        return this.fullyQualifiedMethodName;
    }

    public HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public void setSchemeAndHost(Object[] objArr, UrlBuilder urlBuilder, SerializerAdapter serializerAdapter) {
        setSchemeAndHost(this.rawHost, this.hostSubstitutions, objArr, urlBuilder, serializerAdapter);
    }

    static void setSchemeAndHost(String str, List<RangeReplaceSubstitution> list, Object[] objArr, UrlBuilder urlBuilder, SerializerAdapter serializerAdapter) {
        String strApplySubstitutions = applySubstitutions(str, list, objArr, serializerAdapter);
        int iIndexOf = strApplySubstitutions.indexOf("://");
        if (iIndexOf == -1) {
            urlBuilder.setHost(strApplySubstitutions);
            return;
        }
        urlBuilder.setScheme(strApplySubstitutions.substring(0, iIndexOf));
        String strSubstring = strApplySubstitutions.substring(iIndexOf + 3);
        if (!CoreUtils.isNullOrEmpty(strSubstring)) {
            urlBuilder.setHost(strSubstring);
        } else {
            urlBuilder.setHost(strApplySubstitutions);
        }
    }

    public String setPath(Object[] objArr, SerializerAdapter serializerAdapter) {
        return applySubstitutions(this.relativePath, this.pathSubstitutions, objArr, serializerAdapter);
    }

    public void setEncodedQueryParameters(Object[] objArr, UrlBuilder urlBuilder, SerializerAdapter serializerAdapter) {
        if (objArr == null) {
            return;
        }
        for (QuerySubstitution querySubstitution : this.querySubstitutions) {
            int methodParameterIndex = querySubstitution.getMethodParameterIndex();
            if (methodParameterIndex >= 0 && methodParameterIndex < objArr.length) {
                Object obj = objArr[querySubstitution.getMethodParameterIndex()];
                if (querySubstitution.mergeParameters() && (obj instanceof List)) {
                    Iterator it = ((List) obj).iterator();
                    while (it.hasNext()) {
                        addSerializedQueryParameter(serializerAdapter, it.next(), querySubstitution.shouldEncode(), urlBuilder, querySubstitution.getUrlParameterName());
                    }
                } else {
                    addSerializedQueryParameter(serializerAdapter, obj, querySubstitution.shouldEncode(), urlBuilder, querySubstitution.getUrlParameterName());
                }
            }
        }
    }

    public void setHeaders(Object[] objArr, HttpHeaders httpHeaders, SerializerAdapter serializerAdapter) {
        httpHeaders.setAllHttpHeaders(this.headers);
        if (objArr == null) {
            return;
        }
        for (HeaderSubstitution headerSubstitution : this.headerSubstitutions) {
            int methodParameterIndex = headerSubstitution.getMethodParameterIndex();
            if (methodParameterIndex >= 0 && methodParameterIndex < objArr.length) {
                Object obj = objArr[headerSubstitution.getMethodParameterIndex()];
                if (obj instanceof Map) {
                    String urlParameterName = headerSubstitution.getUrlParameterName();
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        String str = urlParameterName + ((String) entry.getKey());
                        String strSerialize = serialize(serializerAdapter, entry.getValue());
                        if (strSerialize != null) {
                            httpHeaders.set(str, strSerialize);
                        }
                    }
                } else {
                    String strSerialize2 = serialize(serializerAdapter, obj);
                    if (strSerialize2 != null) {
                        httpHeaders.set(headerSubstitution.getHeaderName(), strSerialize2);
                    }
                }
            }
        }
    }

    public Context setContext(Object[] objArr) {
        int i = this.contextPosition;
        if (i < 0) {
            return Context.NONE;
        }
        Context context = (Context) objArr[i];
        return context != null ? context : Context.NONE;
    }

    public RequestOptions setRequestOptions(Object[] objArr) {
        int i = this.requestOptionsPosition;
        if (i < 0) {
            return null;
        }
        return (RequestOptions) objArr[i];
    }

    @Override // com.azure.core.implementation.serializer.HttpResponseDecodeData
    public boolean isExpectedResponseStatusCode(int i) {
        BitSet bitSet = this.expectedStatusCodes;
        if (bitSet == null) {
            return i < 400;
        }
        return bitSet.get(i);
    }

    @Override // com.azure.core.implementation.serializer.HttpResponseDecodeData
    public UnexpectedExceptionInformation getUnexpectedException(int i) {
        if (this.exceptionMapping == null) {
            this.exceptionMapping = processUnexpectedResponseExceptionTypes();
        }
        return this.exceptionMapping.getOrDefault(Integer.valueOf(i), this.defaultException);
    }

    public Object setBody(final Object[] objArr, final SerializerAdapter serializerAdapter) {
        Integer num = this.bodyContentMethodParameterIndex;
        return (CoreUtils.isNullOrEmpty(this.formSubstitutions) || objArr == null) ? (num == null || objArr == null || num.intValue() < 0 || this.bodyContentMethodParameterIndex.intValue() >= objArr.length) ? null : objArr[this.bodyContentMethodParameterIndex.intValue()] : this.formSubstitutions.stream().map(new Function() { // from class: com.azure.core.implementation.http.rest.SwaggerMethodParser$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Substitution substitution = (Substitution) obj;
                return SwaggerMethodParser.serializeFormData(serializerAdapter, substitution.getUrlParameterName(), objArr[substitution.getMethodParameterIndex()], substitution.shouldEncode());
            }
        }).filter(new SwaggerMethodParser$$ExternalSyntheticLambda5()).collect(Collectors.joining("&"));
    }

    public String getBodyContentType() {
        return this.bodyContentType;
    }

    @Override // com.azure.core.implementation.serializer.HttpResponseDecodeData
    public Type getReturnType() {
        return this.returnType;
    }

    public Type getBodyJavaType() {
        return this.bodyJavaType;
    }

    @Override // com.azure.core.implementation.serializer.HttpResponseDecodeData
    public Type getReturnValueWireType() {
        return this.returnValueWireType;
    }

    private static void addSerializedQueryParameter(SerializerAdapter serializerAdapter, Object obj, boolean z, UrlBuilder urlBuilder, String str) {
        String strSerialize = serialize(serializerAdapter, obj);
        if (strSerialize != null) {
            if (z) {
                strSerialize = UrlEscapers.QUERY_ESCAPER.escape(strSerialize);
            }
            urlBuilder.addQueryParameter(str, strSerialize);
        }
    }

    private static String serialize(SerializerAdapter serializerAdapter, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj.getClass().isPrimitive() || (obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof DateTimeRfc1123)) {
            return String.valueOf(obj);
        }
        if (obj instanceof OffsetDateTime) {
            return ((OffsetDateTime) obj).format(DateTimeFormatter.ISO_INSTANT);
        }
        if ((obj instanceof ExpandableStringEnum) || obj.getClass().isEnum()) {
            String string = obj.toString();
            return string == null ? "null" : string;
        }
        return serializerAdapter.serializeRaw(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String serializeFormData(final SerializerAdapter serializerAdapter, String str, Object obj, final boolean z) {
        if (obj == null) {
            return null;
        }
        final String strEscape = UrlEscapers.FORM_ESCAPER.escape(str);
        if (obj instanceof List) {
            return (String) ((List) obj).stream().map(new Function() { // from class: com.azure.core.implementation.http.rest.SwaggerMethodParser$$ExternalSyntheticLambda7
                @Override // java.util.function.Function
                public final Object apply(Object obj2) {
                    return SwaggerMethodParser.serializeAndEncodeFormValue(serializerAdapter, obj2, z);
                }
            }).filter(new SwaggerMethodParser$$ExternalSyntheticLambda5()).map(new Function() { // from class: com.azure.core.implementation.http.rest.SwaggerMethodParser$$ExternalSyntheticLambda8
                @Override // java.util.function.Function
                public final Object apply(Object obj2) {
                    return SwaggerMethodParser.lambda$serializeFormData$2(strEscape, (String) obj2);
                }
            }).collect(Collectors.joining("&"));
        }
        return strEscape + "=" + serializeAndEncodeFormValue(serializerAdapter, obj, z);
    }

    static /* synthetic */ String lambda$serializeFormData$2(String str, String str2) {
        return str + "=" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String serializeAndEncodeFormValue(SerializerAdapter serializerAdapter, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        String strSerialize = serialize(serializerAdapter, obj);
        return z ? UrlEscapers.FORM_ESCAPER.escape(strSerialize) : strSerialize;
    }

    private static String applySubstitutions(String str, List<RangeReplaceSubstitution> list, Object[] objArr, SerializerAdapter serializerAdapter) {
        if (objArr == null || CoreUtils.isNullOrEmpty(list)) {
            return str;
        }
        int length = str.length();
        ArrayList<Map.Entry> arrayList = new ArrayList(list.size());
        int length2 = length;
        for (RangeReplaceSubstitution rangeReplaceSubstitution : list) {
            int methodParameterIndex = rangeReplaceSubstitution.getMethodParameterIndex();
            if (methodParameterIndex >= 0 && methodParameterIndex < objArr.length) {
                String strSerialize = serialize(serializerAdapter, objArr[methodParameterIndex]);
                if (strSerialize != null && !strSerialize.isEmpty() && rangeReplaceSubstitution.shouldEncode()) {
                    strSerialize = UrlEscapers.PATH_ESCAPER.escape(strSerialize);
                }
                if (strSerialize == null) {
                    strSerialize = "";
                }
                length2 += strSerialize.length() - rangeReplaceSubstitution.getSize();
                arrayList.add(new AbstractMap.SimpleEntry(rangeReplaceSubstitution, strSerialize));
            }
        }
        StringBuilder sb = new StringBuilder(length2);
        int end = 0;
        for (Map.Entry entry : arrayList) {
            if (end < ((RangeReplaceSubstitution) entry.getKey()).getStart()) {
                sb.append((CharSequence) str, end, ((RangeReplaceSubstitution) entry.getKey()).getStart());
            }
            sb.append((String) entry.getValue());
            end = ((RangeReplaceSubstitution) entry.getKey()).getEnd();
        }
        if (end < length) {
            sb.append((CharSequence) str, end, length);
        }
        return sb.toString();
    }

    private Map<Integer, UnexpectedExceptionInformation> processUnexpectedResponseExceptionTypes() {
        HashMap map = new HashMap();
        for (UnexpectedResponseExceptionType unexpectedResponseExceptionType : this.unexpectedResponseExceptionTypes) {
            UnexpectedExceptionInformation unexpectedExceptionInformation = new UnexpectedExceptionInformation(unexpectedResponseExceptionType.value());
            if (unexpectedResponseExceptionType.code().length == 0) {
                this.defaultException = unexpectedExceptionInformation;
            } else {
                for (int i : unexpectedResponseExceptionType.code()) {
                    map.put(Integer.valueOf(i), unexpectedExceptionInformation);
                }
            }
        }
        if (this.defaultException == null) {
            this.defaultException = new UnexpectedExceptionInformation(HttpResponseException.class);
        }
        return map;
    }

    public boolean isReactive() {
        return this.isReactive;
    }

    boolean isReactiveType(Type type) {
        return TypeUtil.isTypeOrSubTypeOf(type, Mono.class) || TypeUtil.isTypeOrSubTypeOf(type, Flux.class) || TypeUtil.isTypeOrSubTypeOf(type, Publisher.class);
    }

    boolean isStreamResponseType(Type type) {
        return TypeUtil.getRawClass(type).equals(StreamResponse.class);
    }

    public boolean isStreamResponse() {
        return this.isStreamResponse;
    }

    @Override // com.azure.core.implementation.serializer.HttpResponseDecodeData
    public boolean isReturnTypeDecodeable() {
        return this.returnTypeDecodeable;
    }

    @Override // com.azure.core.implementation.serializer.HttpResponseDecodeData
    public boolean isResponseEagerlyRead() {
        return this.responseEagerlyRead;
    }

    @Override // com.azure.core.implementation.serializer.HttpResponseDecodeData
    public boolean isResponseBodyIgnored() {
        return this.ignoreResponseBody;
    }

    @Override // com.azure.core.implementation.serializer.HttpResponseDecodeData
    public boolean isHeadersEagerlyConverted() {
        return this.headersEagerlyConverted;
    }

    public String getSpanName() {
        return this.spanName;
    }

    public static boolean isReturnTypeDecodeable(Type type) {
        return (type == null || TypeUtil.isTypeOrSubTypeOf(type, BinaryData.class) || TypeUtil.isTypeOrSubTypeOf(type, byte[].class) || TypeUtil.isTypeOrSubTypeOf(type, ByteBuffer.class) || TypeUtil.isTypeOrSubTypeOf(type, InputStream.class) || TypeUtil.isTypeOrSubTypeOf(type, Void.TYPE) || TypeUtil.isTypeOrSubTypeOf(type, Void.class)) ? false : true;
    }

    public static boolean isResponseBodyIgnored(Type type) {
        if (type == null) {
            return false;
        }
        return TypeUtil.isTypeOrSubTypeOf(type, Void.TYPE) || TypeUtil.isTypeOrSubTypeOf(type, Void.class);
    }

    public static boolean isResponseEagerlyRead(Type type) {
        if (type == null) {
            return false;
        }
        return isReturnTypeDecodeable(type);
    }

    public static Type unwrapReturnType(Type type) {
        if (type == null) {
            return null;
        }
        if (TypeUtil.isTypeOrSubTypeOf(type, ResponseBase.class)) {
            return unwrapReturnType(TypeUtil.getTypeArguments(walkSuperTypesUntil(type, new Predicate() { // from class: com.azure.core.implementation.http.rest.SwaggerMethodParser$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return SwaggerMethodParser.lambda$unwrapReturnType$3((Type) obj);
                }
            }))[1]);
        }
        if (TypeUtil.isTypeOrSubTypeOf(type, Response.class)) {
            return unwrapReturnType(TypeUtil.getTypeArgument(walkSuperTypesUntil(type, new Predicate() { // from class: com.azure.core.implementation.http.rest.SwaggerMethodParser$$ExternalSyntheticLambda1
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return TypeUtil.typeImplementsInterface((Type) obj, Response.class);
                }
            })));
        }
        if (TypeUtil.isTypeOrSubTypeOf(type, Mono.class)) {
            return unwrapReturnType(TypeUtil.getTypeArgument(walkSuperTypesUntil(type, new Predicate() { // from class: com.azure.core.implementation.http.rest.SwaggerMethodParser$$ExternalSyntheticLambda2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return SwaggerMethodParser.lambda$unwrapReturnType$5((Type) obj);
                }
            })));
        }
        return TypeUtil.isTypeOrSubTypeOf(type, Flux.class) ? unwrapReturnType(TypeUtil.getTypeArgument(walkSuperTypesUntil(type, new Predicate() { // from class: com.azure.core.implementation.http.rest.SwaggerMethodParser$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return SwaggerMethodParser.lambda$unwrapReturnType$6((Type) obj);
            }
        }))) : type;
    }

    static /* synthetic */ boolean lambda$unwrapReturnType$3(Type type) {
        return TypeUtil.getRawClass(type) == ResponseBase.class;
    }

    static /* synthetic */ boolean lambda$unwrapReturnType$5(Type type) {
        return TypeUtil.getRawClass(type) == Mono.class;
    }

    static /* synthetic */ boolean lambda$unwrapReturnType$6(Type type) {
        return TypeUtil.getRawClass(type) == Flux.class;
    }

    private static Type walkSuperTypesUntil(Type type, Predicate<Type> predicate) {
        while (!predicate.test(type)) {
            type = TypeUtil.getSuperType(type);
        }
        return type;
    }
}
