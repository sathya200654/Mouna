package com.azure.core.util.serializer;

import com.azure.core.http.HttpHeaders;
import com.azure.core.implementation.AccessControllerUtils;
import com.azure.core.implementation.AccessibleByteArrayOutputStream;
import com.azure.core.implementation.ImplUtils;
import com.azure.core.implementation.ReflectionSerializable;
import com.azure.core.implementation.TypeUtil;
import com.azure.core.implementation.jackson.ObjectMapperShim;
import com.azure.core.util.Configuration;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.DateTimeRfc1123;
import com.azure.core.util.ExpandableStringEnum;
import com.azure.core.util.Header;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import com.azure.json.JsonSerializable;
import com.azure.xml.XmlSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class JacksonAdapter implements SerializerAdapter {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) JacksonAdapter.class);
    private static boolean useAccessHelper = Boolean.parseBoolean(Configuration.getGlobalConfiguration().get("AZURE_JACKSON_ADAPTER_USE_ACCESS_HELPER"));
    private final ObjectMapperShim headerMapper;
    private final ObjectMapperShim mapper;
    private ObjectMapper rawInnerMapper;
    private ObjectMapper rawOuterMapper;

    /* JADX INFO: Access modifiers changed from: private */
    @FunctionalInterface
    interface IOExceptionCallable {
        Object call() throws IOException;
    }

    static /* synthetic */ void lambda$new$0(ObjectMapper objectMapper, ObjectMapper objectMapper2) {
    }

    private enum GlobalXmlMapper {
        XML_MAPPER(ObjectMapperShim.createXmlMapper());

        private final ObjectMapperShim xmlMapper;

        GlobalXmlMapper(ObjectMapperShim objectMapperShim) {
            this.xmlMapper = objectMapperShim;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ObjectMapperShim getXmlMapper() {
            return this.xmlMapper;
        }
    }

    private enum GlobalSerializerAdapter {
        SERIALIZER_ADAPTER(new JacksonAdapter());

        private final SerializerAdapter serializerAdapter;

        GlobalSerializerAdapter(SerializerAdapter serializerAdapter) {
            this.serializerAdapter = serializerAdapter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SerializerAdapter getSerializerAdapter() {
            return this.serializerAdapter;
        }
    }

    public JacksonAdapter() {
        this(new BiConsumer() { // from class: com.azure.core.util.serializer.JacksonAdapter$$ExternalSyntheticLambda3
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                JacksonAdapter.lambda$new$0((ObjectMapper) obj, (ObjectMapper) obj2);
            }
        });
    }

    @Deprecated
    public JacksonAdapter(final BiConsumer<ObjectMapper, ObjectMapper> biConsumer) {
        Objects.requireNonNull(biConsumer, "'configureSerialization' cannot be null.");
        this.headerMapper = ObjectMapperShim.createHeaderMapper();
        this.mapper = ObjectMapperShim.createJsonMapper(ObjectMapperShim.createSimpleMapper(), new BiConsumer() { // from class: com.azure.core.util.serializer.JacksonAdapter$$ExternalSyntheticLambda5
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f$0.m1294lambda$new$1$comazurecoreutilserializerJacksonAdapter(biConsumer, (ObjectMapper) obj, (ObjectMapper) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: captureRawMappersAndConfigure, reason: merged with bridge method [inline-methods] */
    public void m1294lambda$new$1$comazurecoreutilserializerJacksonAdapter(ObjectMapper objectMapper, ObjectMapper objectMapper2, BiConsumer<ObjectMapper, ObjectMapper> biConsumer) {
        this.rawOuterMapper = objectMapper;
        this.rawInnerMapper = objectMapper2;
        biConsumer.accept(objectMapper, objectMapper2);
    }

    @Deprecated
    protected ObjectMapper simpleMapper() {
        return this.rawInnerMapper;
    }

    public static SerializerAdapter createDefaultSerializerAdapter() {
        return GlobalSerializerAdapter.SERIALIZER_ADAPTER.getSerializerAdapter();
    }

    @Deprecated
    public ObjectMapper serializer() {
        return this.rawOuterMapper;
    }

    @Override // com.azure.core.util.serializer.SerializerAdapter
    public String serialize(final Object obj, final SerializerEncoding serializerEncoding) throws IOException {
        if (obj == null) {
            return null;
        }
        return (String) useAccessHelper(new IOExceptionCallable() { // from class: com.azure.core.util.serializer.JacksonAdapter$$ExternalSyntheticLambda4
            @Override // com.azure.core.util.serializer.JacksonAdapter.IOExceptionCallable
            public final Object call() {
                return this.f$0.m1295lambda$serialize$2$comazurecoreutilserializerJacksonAdapter(serializerEncoding, obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$serialize$2$com-azure-core-util-serializer-JacksonAdapter, reason: not valid java name */
    /* synthetic */ Object m1295lambda$serialize$2$comazurecoreutilserializerJacksonAdapter(SerializerEncoding serializerEncoding, Object obj) throws IOException {
        if (serializerEncoding == SerializerEncoding.XML) {
            if (ReflectionSerializable.supportsXmlSerializable(obj.getClass())) {
                return ReflectionSerializable.serializeXmlSerializableToString((XmlSerializable) obj);
            }
            return getXmlMapper().writeValueAsString(obj);
        }
        if (serializerEncoding == SerializerEncoding.TEXT) {
            return obj.toString();
        }
        if (ReflectionSerializable.supportsJsonSerializable(obj.getClass())) {
            return ReflectionSerializable.serializeJsonSerializableToString((JsonSerializable) obj);
        }
        return this.mapper.writeValueAsString(obj);
    }

    @Override // com.azure.core.util.serializer.SerializerAdapter
    public byte[] serializeToBytes(final Object obj, final SerializerEncoding serializerEncoding) throws IOException {
        if (obj == null) {
            return null;
        }
        return (byte[]) useAccessHelper(new IOExceptionCallable() { // from class: com.azure.core.util.serializer.JacksonAdapter$$ExternalSyntheticLambda1
            @Override // com.azure.core.util.serializer.JacksonAdapter.IOExceptionCallable
            public final Object call() {
                return this.f$0.m1299xef2fca28(serializerEncoding, obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$serializeToBytes$3$com-azure-core-util-serializer-JacksonAdapter, reason: not valid java name */
    /* synthetic */ Object m1299xef2fca28(SerializerEncoding serializerEncoding, Object obj) throws IOException {
        if (serializerEncoding == SerializerEncoding.XML) {
            if (ReflectionSerializable.supportsXmlSerializable(obj.getClass())) {
                return ReflectionSerializable.serializeXmlSerializableToBytes((XmlSerializable) obj);
            }
            return getXmlMapper().writeValueAsBytes(obj);
        }
        if (serializerEncoding == SerializerEncoding.TEXT) {
            return obj.toString().getBytes(StandardCharsets.UTF_8);
        }
        if (ReflectionSerializable.supportsJsonSerializable(obj.getClass())) {
            return ReflectionSerializable.serializeJsonSerializableToBytes((JsonSerializable) obj);
        }
        return this.mapper.writeValueAsBytes(obj);
    }

    @Override // com.azure.core.util.serializer.SerializerAdapter
    public void serialize(final Object obj, final SerializerEncoding serializerEncoding, final OutputStream outputStream) throws IOException {
        if (obj == null) {
            return;
        }
        useAccessHelper(new IOExceptionCallable() { // from class: com.azure.core.util.serializer.JacksonAdapter$$ExternalSyntheticLambda0
            @Override // com.azure.core.util.serializer.JacksonAdapter.IOExceptionCallable
            public final Object call() {
                return this.f$0.m1296lambda$serialize$4$comazurecoreutilserializerJacksonAdapter(serializerEncoding, obj, outputStream);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$serialize$4$com-azure-core-util-serializer-JacksonAdapter, reason: not valid java name */
    /* synthetic */ Object m1296lambda$serialize$4$comazurecoreutilserializerJacksonAdapter(SerializerEncoding serializerEncoding, Object obj, OutputStream outputStream) throws IOException {
        if (serializerEncoding == SerializerEncoding.XML) {
            if (ReflectionSerializable.supportsXmlSerializable(obj.getClass())) {
                ReflectionSerializable.serializeXmlSerializableIntoOutputStream((XmlSerializable) obj, outputStream);
                return null;
            }
            getXmlMapper().writeValue(outputStream, obj);
            return null;
        }
        if (serializerEncoding == SerializerEncoding.TEXT) {
            outputStream.write(obj.toString().getBytes(StandardCharsets.UTF_8));
            return null;
        }
        if (ReflectionSerializable.supportsJsonSerializable(obj.getClass())) {
            ReflectionSerializable.serializeJsonSerializableIntoOutputStream((JsonSerializable) obj, outputStream);
            return null;
        }
        this.mapper.writeValue(outputStream, obj);
        return null;
    }

    @Override // com.azure.core.util.serializer.SerializerAdapter
    public String serializeRaw(final Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (String) useAccessHelper(new IOExceptionCallable() { // from class: com.azure.core.util.serializer.JacksonAdapter$$ExternalSyntheticLambda2
                @Override // com.azure.core.util.serializer.JacksonAdapter.IOExceptionCallable
                public final Object call() {
                    return this.f$0.m1298x1c4734e3(obj);
                }
            });
        } catch (IOException e) {
            throw LOGGER.logExceptionAsError(new UncheckedIOException(e));
        }
    }

    /* JADX INFO: renamed from: lambda$serializeRaw$6$com-azure-core-util-serializer-JacksonAdapter, reason: not valid java name */
    /* synthetic */ Object m1298x1c4734e3(final Object obj) throws IOException {
        try {
            return removeLeadingAndTrailingQuotes(serialize(obj, SerializerEncoding.JSON));
        } catch (IOException e) {
            LOGGER.log(LogLevel.WARNING, new Supplier() { // from class: com.azure.core.util.serializer.JacksonAdapter$$ExternalSyntheticLambda7
                @Override // java.util.function.Supplier
                public final Object get() {
                    return JacksonAdapter.lambda$serializeRaw$5(obj);
                }
            }, e);
            return null;
        }
    }

    static /* synthetic */ String lambda$serializeRaw$5(Object obj) {
        return "Failed to serialize " + obj.getClass() + " to JSON.";
    }

    static String removeLeadingAndTrailingQuotes(String str) {
        int length = str.length();
        int i = 0;
        while (i < length && str.charAt(i) == '\"') {
            i++;
        }
        if (i == length) {
            return "";
        }
        int i2 = length - 1;
        while (i2 >= 0 && str.charAt(i2) == '\"') {
            i2--;
        }
        return str.substring(i, i2 + 1);
    }

    /* JADX INFO: renamed from: lambda$serializeList$7$com-azure-core-util-serializer-JacksonAdapter, reason: not valid java name */
    /* synthetic */ Object m1297xcd6c35c0(List list, CollectionFormat collectionFormat) throws IOException {
        return serializeIterable(list, collectionFormat);
    }

    @Override // com.azure.core.util.serializer.SerializerAdapter
    public String serializeList(final List<?> list, final CollectionFormat collectionFormat) {
        try {
            return (String) useAccessHelper(new IOExceptionCallable() { // from class: com.azure.core.util.serializer.JacksonAdapter$$ExternalSyntheticLambda9
                @Override // com.azure.core.util.serializer.JacksonAdapter.IOExceptionCallable
                public final Object call() {
                    return this.f$0.m1297xcd6c35c0(list, collectionFormat);
                }
            });
        } catch (IOException e) {
            throw LOGGER.logExceptionAsError(new UncheckedIOException(e));
        }
    }

    @Override // com.azure.core.util.serializer.SerializerAdapter
    public <T> T deserialize(final String str, final Type type, final SerializerEncoding serializerEncoding) throws IOException {
        if (CoreUtils.isNullOrEmpty(str)) {
            return null;
        }
        return (T) useAccessHelper(new IOExceptionCallable() { // from class: com.azure.core.util.serializer.JacksonAdapter$$ExternalSyntheticLambda10
            @Override // com.azure.core.util.serializer.JacksonAdapter.IOExceptionCallable
            public final Object call() {
                return this.f$0.m1291x78c012a2(serializerEncoding, type, str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$deserialize$8$com-azure-core-util-serializer-JacksonAdapter, reason: not valid java name */
    /* synthetic */ Object m1291x78c012a2(SerializerEncoding serializerEncoding, Type type, String str) throws IOException {
        if (serializerEncoding == SerializerEncoding.XML) {
            Class<?> rawClass = TypeUtil.getRawClass(type);
            if (ReflectionSerializable.supportsXmlSerializable(rawClass)) {
                return ReflectionSerializable.deserializeAsXmlSerializable(rawClass, str.getBytes(StandardCharsets.UTF_8));
            }
            return getXmlMapper().readValue(str, type);
        }
        if (serializerEncoding == SerializerEncoding.TEXT) {
            return deserializeText(str, type);
        }
        Class<?> rawClass2 = TypeUtil.getRawClass(type);
        if (ReflectionSerializable.supportsJsonSerializable(rawClass2)) {
            return ReflectionSerializable.deserializeAsJsonSerializable(rawClass2, str.getBytes(StandardCharsets.UTF_8));
        }
        return this.mapper.readValue(str, type);
    }

    @Override // com.azure.core.util.serializer.SerializerAdapter
    public <T> T deserialize(final byte[] bArr, final Type type, final SerializerEncoding serializerEncoding) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return (T) useAccessHelper(new IOExceptionCallable() { // from class: com.azure.core.util.serializer.JacksonAdapter$$ExternalSyntheticLambda12
            @Override // com.azure.core.util.serializer.JacksonAdapter.IOExceptionCallable
            public final Object call() {
                return this.f$0.m1292xee3a38e3(serializerEncoding, type, bArr);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$deserialize$9$com-azure-core-util-serializer-JacksonAdapter, reason: not valid java name */
    /* synthetic */ Object m1292xee3a38e3(SerializerEncoding serializerEncoding, Type type, byte[] bArr) throws IOException {
        if (serializerEncoding == SerializerEncoding.XML) {
            Class<?> rawClass = TypeUtil.getRawClass(type);
            if (ReflectionSerializable.supportsXmlSerializable(rawClass)) {
                return ReflectionSerializable.deserializeAsXmlSerializable(rawClass, bArr);
            }
            return getXmlMapper().readValue(bArr, type);
        }
        if (serializerEncoding == SerializerEncoding.TEXT) {
            return deserializeText(CoreUtils.bomAwareToString(bArr, null), type);
        }
        Class<?> rawClass2 = TypeUtil.getRawClass(type);
        if (ReflectionSerializable.supportsJsonSerializable(rawClass2)) {
            return ReflectionSerializable.deserializeAsJsonSerializable(rawClass2, bArr);
        }
        return this.mapper.readValue(bArr, type);
    }

    @Override // com.azure.core.util.serializer.SerializerAdapter
    public <T> T deserialize(final InputStream inputStream, final Type type, final SerializerEncoding serializerEncoding) throws IOException {
        if (inputStream == null) {
            return null;
        }
        return (T) useAccessHelper(new IOExceptionCallable() { // from class: com.azure.core.util.serializer.JacksonAdapter$$ExternalSyntheticLambda13
            @Override // com.azure.core.util.serializer.JacksonAdapter.IOExceptionCallable
            public final Object call() {
                return this.f$0.m1289x27ce210d(serializerEncoding, type, inputStream);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$deserialize$10$com-azure-core-util-serializer-JacksonAdapter, reason: not valid java name */
    /* synthetic */ Object m1289x27ce210d(SerializerEncoding serializerEncoding, Type type, InputStream inputStream) throws IOException {
        if (serializerEncoding == SerializerEncoding.XML) {
            Class<?> rawClass = TypeUtil.getRawClass(type);
            if (ReflectionSerializable.supportsXmlSerializable(rawClass)) {
                return ReflectionSerializable.deserializeAsXmlSerializable(rawClass, inputStreamToBytes(inputStream));
            }
            return getXmlMapper().readValue(inputStream, type);
        }
        if (serializerEncoding == SerializerEncoding.TEXT) {
            AccessibleByteArrayOutputStream accessibleByteArrayOutputStream = new AccessibleByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    accessibleByteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return deserializeText(accessibleByteArrayOutputStream.bomAwareToString(null), type);
                }
            }
        } else {
            Class<?> rawClass2 = TypeUtil.getRawClass(type);
            if (ReflectionSerializable.supportsJsonSerializable(rawClass2)) {
                return ReflectionSerializable.deserializeAsJsonSerializable(rawClass2, inputStreamToBytes(inputStream));
            }
            return this.mapper.readValue(inputStream, type);
        }
    }

    private static byte[] inputStreamToBytes(InputStream inputStream) throws IOException {
        AccessibleByteArrayOutputStream accessibleByteArrayOutputStream = new AccessibleByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                accessibleByteArrayOutputStream.write(bArr, 0, i);
            } else {
                return accessibleByteArrayOutputStream.toByteArray();
            }
        }
    }

    private static Object deserializeText(String str, Type type) throws IOException {
        if (type == String.class || type == CharSequence.class) {
            return str;
        }
        if (type == Integer.TYPE || type == Integer.class) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (type == Character.TYPE || type == Character.class) {
            if (CoreUtils.isNullOrEmpty(str)) {
                return null;
            }
            return Character.valueOf(str.charAt(0));
        }
        if (type == Byte.TYPE || type == Byte.class) {
            if (CoreUtils.isNullOrEmpty(str)) {
                return null;
            }
            return Byte.valueOf((byte) str.charAt(0));
        }
        if (type == byte[].class) {
            if (CoreUtils.isNullOrEmpty(str)) {
                return null;
            }
            return str.getBytes(StandardCharsets.UTF_8);
        }
        if (type == Long.TYPE || type == Long.class) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (type == Short.TYPE || type == Short.class) {
            return Short.valueOf(Short.parseShort(str));
        }
        if (type == Float.TYPE || type == Float.class) {
            return Float.valueOf(Float.parseFloat(str));
        }
        if (type == Double.TYPE || type == Double.class) {
            return Double.valueOf(Double.parseDouble(str));
        }
        if (type == Boolean.TYPE || type == Boolean.class) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        if (type == OffsetDateTime.class) {
            return OffsetDateTime.parse(str);
        }
        if (type == DateTimeRfc1123.class) {
            return new DateTimeRfc1123(str);
        }
        if (type == URL.class) {
            try {
                return ImplUtils.createUrl(str);
            } catch (MalformedURLException e) {
                throw new IOException(e);
            }
        }
        if (type == URI.class) {
            return URI.create(str);
        }
        if (type == UUID.class) {
            return UUID.fromString(str);
        }
        if (type == LocalDate.class) {
            return LocalDate.parse(str);
        }
        Class cls = (Class) type;
        if (Enum.class.isAssignableFrom(cls)) {
            return Enum.valueOf(cls, str);
        }
        if (ExpandableStringEnum.class.isAssignableFrom(cls)) {
            try {
                return ((Class) type).getDeclaredMethod("fromString", String.class).invoke(null, str);
            } catch (ReflectiveOperationException e2) {
                throw new IOException(e2);
            }
        }
        throw new IllegalStateException("Unsupported text Content-Type Type: " + type);
    }

    @Override // com.azure.core.util.serializer.SerializerAdapter
    public <T> T deserialize(final HttpHeaders httpHeaders, final Type type) throws IOException {
        return (T) useAccessHelper(new IOExceptionCallable() { // from class: com.azure.core.util.serializer.JacksonAdapter$$ExternalSyntheticLambda11
            @Override // com.azure.core.util.serializer.JacksonAdapter.IOExceptionCallable
            public final Object call() {
                return this.f$0.m1290x9d48474e(httpHeaders, type);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$deserialize$11$com-azure-core-util-serializer-JacksonAdapter, reason: not valid java name */
    /* synthetic */ Object m1290x9d48474e(HttpHeaders httpHeaders, Type type) throws IOException {
        return this.headerMapper.deserialize(httpHeaders, type);
    }

    @Override // com.azure.core.util.serializer.SerializerAdapter
    public <T> T deserializeHeader(final Header header, final Type type) throws IOException {
        return (T) useAccessHelper(new IOExceptionCallable() { // from class: com.azure.core.util.serializer.JacksonAdapter$$ExternalSyntheticLambda6
            @Override // com.azure.core.util.serializer.JacksonAdapter.IOExceptionCallable
            public final Object call() {
                return this.f$0.m1293xa7311402(header, type);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$deserializeHeader$12$com-azure-core-util-serializer-JacksonAdapter, reason: not valid java name */
    /* synthetic */ Object m1293xa7311402(Header header, Type type) throws IOException {
        return this.headerMapper.readValue(header.getValue(), type);
    }

    private ObjectMapperShim getXmlMapper() {
        return GlobalXmlMapper.XML_MAPPER.getXmlMapper();
    }

    private static Object useAccessHelper(final IOExceptionCallable iOExceptionCallable) throws IOException {
        if (useAccessHelper) {
            try {
                Objects.requireNonNull(iOExceptionCallable);
                return AccessControllerUtils.doPrivilegedException(new Callable() { // from class: com.azure.core.util.serializer.JacksonAdapter$$ExternalSyntheticLambda8
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return iOExceptionCallable.call();
                    }
                });
            } catch (Exception e) {
                Throwable cause = e.getCause();
                if (cause instanceof IOException) {
                    throw ((IOException) cause);
                }
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw LOGGER.logExceptionAsError(new RuntimeException(cause));
            }
        }
        return iOExceptionCallable.call();
    }

    static boolean isUseAccessHelper() {
        return useAccessHelper;
    }

    static void setUseAccessHelper(boolean z) {
        useAccessHelper = z;
    }
}
