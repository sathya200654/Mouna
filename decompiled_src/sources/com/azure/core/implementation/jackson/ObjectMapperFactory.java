package com.azure.core.implementation.jackson;

import com.azure.core.implementation.AccessControllerUtils;
import com.azure.core.util.Configuration;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class ObjectMapperFactory {
    private boolean jackson215IsSafe = true;
    final boolean useJackson215;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ObjectMapperFactory.class);
    private static final boolean USE_ACCESS_HELPER = Boolean.parseBoolean(Configuration.getGlobalConfiguration().get("AZURE_JACKSON_ADAPTER_USE_ACCESS_HELPER"));
    public static final ObjectMapperFactory INSTANCE = new ObjectMapperFactory();

    ObjectMapperFactory() {
        this.useJackson215 = PackageVersion.VERSION.getMinorVersion() >= 15 && com.fasterxml.jackson.core.json.PackageVersion.VERSION.getMinorVersion() >= 15;
    }

    public ObjectMapper createJsonMapper(ObjectMapper objectMapper) {
        ObjectMapper objectMapperAttemptJackson215Mutation = attemptJackson215Mutation(initializeMapperBuilder(JsonMapper.builder()).addModule(FlatteningSerializer.getModule(objectMapper)).addModule(FlatteningDeserializer.getModule(objectMapper)).build());
        return attemptJackson215Mutation(initializeMapperBuilder(JsonMapper.builder()).addModule(AdditionalPropertiesSerializer.getModule(objectMapperAttemptJackson215Mutation)).addModule(AdditionalPropertiesDeserializer.getModule(objectMapperAttemptJackson215Mutation)).addModule(FlatteningSerializer.getModule(objectMapper)).addModule(FlatteningDeserializer.getModule(objectMapper)).addModule(JsonSerializableSerializer.getModule()).addModule(JsonSerializableDeserializer.getModule()).addModule(ResponseErrorDeserializer.getModule(objectMapper)).build());
    }

    public ObjectMapper createXmlMapper() {
        return attemptJackson215Mutation(XmlMapperFactory.INSTANCE.createXmlMapper());
    }

    public ObjectMapper createSimpleMapper() {
        return attemptJackson215Mutation(initializeMapperBuilder(JsonMapper.builder()).build());
    }

    public ObjectMapper createDefaultMapper() {
        return attemptJackson215Mutation(new ObjectMapper());
    }

    public ObjectMapper createPrettyPrintMapper() {
        return attemptJackson215Mutation(new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT));
    }

    public ObjectMapper createHeaderMapper() {
        return attemptJackson215Mutation(initializeMapperBuilder(JsonMapper.builder()).enable(new MapperFeature[]{MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES}).addModule(JsonSerializableSerializer.getModule()).addModule(JsonSerializableDeserializer.getModule()).build());
    }

    private ObjectMapper attemptJackson215Mutation(final ObjectMapper objectMapper) {
        if (!this.useJackson215 || !this.jackson215IsSafe) {
            return objectMapper;
        }
        try {
            if (USE_ACCESS_HELPER) {
                try {
                    return (ObjectMapper) AccessControllerUtils.doPrivilegedException(new Callable() { // from class: com.azure.core.implementation.jackson.ObjectMapperFactory$$ExternalSyntheticLambda0
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return JacksonDatabind215.mutateStreamReadConstraints(objectMapper);
                        }
                    });
                } catch (Exception e) {
                    Throwable cause = e.getCause();
                    if (cause instanceof Error) {
                        throw ((Error) LOGGER.logThrowableAsError((Error) cause));
                    }
                    if (cause instanceof RuntimeException) {
                        throw LOGGER.logExceptionAsError((RuntimeException) cause);
                    }
                    throw LOGGER.logExceptionAsError(new RuntimeException(e));
                }
            }
            return JacksonDatabind215.mutateStreamReadConstraints(objectMapper);
        } catch (Throwable th) {
            if (th instanceof LinkageError) {
                this.jackson215IsSafe = false;
                LOGGER.log(LogLevel.VERBOSE, new MemberNameConverterImpl$$ExternalSyntheticLambda0(), th);
            }
            throw th;
        }
    }

    static <S extends MapperBuilder<?, ?>> S initializeMapperBuilder(S s) {
        s.enable(new SerializationFeature[]{SerializationFeature.WRITE_EMPTY_JSON_ARRAYS}).enable(new DeserializationFeature[]{DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT}).enable(new DeserializationFeature[]{DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY}).disable(new SerializationFeature[]{SerializationFeature.WRITE_DATES_AS_TIMESTAMPS}).disable(new SerializationFeature[]{SerializationFeature.FAIL_ON_EMPTY_BEANS}).disable(new DeserializationFeature[]{DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES}).serializationInclusion(JsonInclude.Include.NON_NULL).addModule(new JavaTimeModule()).addModule(BinaryDataSerializer.getModule()).addModule(BinaryDataDeserializer.getModule()).addModule(ByteArraySerializer.getModule()).addModule(Base64UrlSerializer.getModule()).addModule(DateTimeSerializer.getModule()).addModule(DateTimeDeserializer.getModule()).addModule(DateTimeRfc1123Serializer.getModule()).addModule(DurationSerializer.getModule()).addModule(HttpHeadersSerializer.getModule()).addModule(GeoJsonSerializer.getModule()).addModule(GeoJsonDeserializer.getModule()).visibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).visibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE).visibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE).visibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE);
        return s;
    }
}
