package com.azure.core.util;

import androidx.tracing.perfetto.handshake.protocol.RequestKeys;
import com.azure.core.implementation.util.EnvironmentConfiguration;
import com.azure.core.util.logging.ClientLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class Configuration implements Cloneable {
    public static final String PROPERTY_AZURE_AUTHORITY_HOST = "AZURE_AUTHORITY_HOST";
    public static final String PROPERTY_AZURE_CLIENT_CERTIFICATE_PASSWORD = "AZURE_CLIENT_CERTIFICATE_PASSWORD";
    public static final String PROPERTY_AZURE_CLIENT_CERTIFICATE_PATH = "AZURE_CLIENT_CERTIFICATE_PATH";
    public static final String PROPERTY_AZURE_CLIENT_ID = "AZURE_CLIENT_ID";
    public static final String PROPERTY_AZURE_CLIENT_SECRET = "AZURE_CLIENT_SECRET";
    public static final String PROPERTY_AZURE_CLIENT_SEND_CERTIFICATE_CHAIN = "AZURE_CLIENT_SEND_CERTIFICATE_CHAIN";
    public static final String PROPERTY_AZURE_CLOUD = "AZURE_CLOUD";
    public static final String PROPERTY_AZURE_HTTP_CLIENT_IMPLEMENTATION = "AZURE_HTTP_CLIENT_IMPLEMENTATION";
    public static final String PROPERTY_AZURE_HTTP_LOG_DETAIL_LEVEL = "AZURE_HTTP_LOG_DETAIL_LEVEL";
    public static final String PROPERTY_AZURE_IDENTITY_DISABLE_CP1 = "AZURE_IDENTITY_DISABLE_CP1";
    public static final String PROPERTY_AZURE_LOG_LEVEL = "AZURE_LOG_LEVEL";
    public static final String PROPERTY_AZURE_METRICS_DISABLED = "AZURE_METRICS_DISABLED";
    public static final String PROPERTY_AZURE_METRICS_IMPLEMENTATION = "AZURE_METRICS_IMPLEMENTATION";
    public static final String PROPERTY_AZURE_PASSWORD = "AZURE_PASSWORD";
    public static final String PROPERTY_AZURE_POD_IDENTITY_TOKEN_URL = "AZURE_POD_IDENTITY_TOKEN_URL";
    public static final String PROPERTY_AZURE_REGIONAL_AUTHORITY_NAME = "AZURE_REGIONAL_AUTHORITY_NAME";
    public static final String PROPERTY_AZURE_REQUEST_CONNECT_TIMEOUT = "AZURE_REQUEST_CONNECT_TIMEOUT";
    public static final String PROPERTY_AZURE_REQUEST_READ_TIMEOUT = "AZURE_REQUEST_READ_TIMEOUT";
    public static final String PROPERTY_AZURE_REQUEST_RESPONSE_TIMEOUT = "AZURE_REQUEST_RESPONSE_TIMEOUT";
    public static final String PROPERTY_AZURE_REQUEST_RETRY_COUNT = "AZURE_REQUEST_RETRY_COUNT";
    public static final String PROPERTY_AZURE_REQUEST_WRITE_TIMEOUT = "AZURE_REQUEST_WRITE_TIMEOUT";
    public static final String PROPERTY_AZURE_RESOURCE_GROUP = "AZURE_RESOURCE_GROUP";
    public static final String PROPERTY_AZURE_SUBSCRIPTION_ID = "AZURE_SUBSCRIPTION_ID";
    public static final String PROPERTY_AZURE_TELEMETRY_DISABLED = "AZURE_TELEMETRY_DISABLED";
    public static final String PROPERTY_AZURE_TENANT_ID = "AZURE_TENANT_ID";
    public static final String PROPERTY_AZURE_TRACING_DISABLED = "AZURE_TRACING_DISABLED";
    public static final String PROPERTY_AZURE_TRACING_IMPLEMENTATION = "AZURE_TRACING_IMPLEMENTATION";
    public static final String PROPERTY_AZURE_USERNAME = "AZURE_USERNAME";
    public static final String PROPERTY_HTTPS_PROXY = "HTTPS_PROXY";
    public static final String PROPERTY_HTTP_PROXY = "HTTP_PROXY";
    public static final String PROPERTY_IDENTITY_ENDPOINT = "IDENTITY_ENDPOINT";
    public static final String PROPERTY_IDENTITY_HEADER = "IDENTITY_HEADER";
    public static final String PROPERTY_MSI_ENDPOINT = "MSI_ENDPOINT";
    public static final String PROPERTY_MSI_SECRET = "MSI_SECRET";
    public static final String PROPERTY_NO_PROXY = "NO_PROXY";
    private final Map<String, String> configurations;
    private final EnvironmentConfiguration environmentConfiguration;
    private final boolean isEmpty;
    private final String path;
    private final Configuration sharedConfiguration;
    private static final Configuration GLOBAL_CONFIGURATION = new Configuration();
    public static final Configuration NONE = new NoopConfiguration();
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) Configuration.class);

    @Deprecated
    public Configuration() {
        this((Map<String, String>) Collections.emptyMap(), EnvironmentConfiguration.getGlobalConfiguration(), (String) null, (Configuration) null);
    }

    Configuration(ConfigurationSource configurationSource, EnvironmentConfiguration environmentConfiguration, String str, Configuration configuration) {
        this(readConfigurations(configurationSource, str), environmentConfiguration, str, configuration);
    }

    private Configuration(Map<String, String> map, EnvironmentConfiguration environmentConfiguration, String str, Configuration configuration) {
        this.configurations = map;
        this.isEmpty = map.isEmpty();
        this.environmentConfiguration = (EnvironmentConfiguration) Objects.requireNonNull(environmentConfiguration, "'environmentConfiguration' cannot be null");
        this.path = str;
        this.sharedConfiguration = configuration;
    }

    public static Configuration getGlobalConfiguration() {
        return GLOBAL_CONFIGURATION;
    }

    public String get(String str) {
        return this.environmentConfiguration.get(str);
    }

    public <T> T get(String str, T t) {
        return (T) convertToPrimitiveOrDefault(get(str), t);
    }

    public <T> T get(String str, Function<String, T> function) {
        Objects.requireNonNull(function, "'converter' can't be null");
        return function.apply(get(str));
    }

    @Deprecated
    public Configuration put(String str, String str2) {
        this.environmentConfiguration.put(str, str2);
        return this;
    }

    @Deprecated
    public String remove(String str) {
        return this.environmentConfiguration.remove(str);
    }

    public boolean contains(String str) {
        return get(str) != null;
    }

    @Override // 
    @Deprecated
    /* JADX INFO: renamed from: clone */
    public Configuration mo1237clone() {
        return new Configuration(this.configurations, new EnvironmentConfiguration(this.environmentConfiguration), this.path, this.sharedConfiguration);
    }

    public boolean contains(ConfigurationProperty<?> configurationProperty) {
        Objects.requireNonNull(configurationProperty, "'property' can't be null");
        return getWithFallback(configurationProperty) != null;
    }

    public <T> T get(ConfigurationProperty<T> configurationProperty) {
        Objects.requireNonNull(configurationProperty, "'property' cannot be null");
        String withFallback = getWithFallback(configurationProperty);
        if (withFallback == null) {
            if (configurationProperty.isRequired()) {
                throw LOGGER.atError().addKeyValue("name", configurationProperty.getName()).addKeyValue(RequestKeys.KEY_PATH, this.path).log((RuntimeException) new IllegalArgumentException("Missing required property."));
            }
            return configurationProperty.getDefaultValue();
        }
        try {
            return configurationProperty.getConverter().apply(withFallback);
        } catch (RuntimeException e) {
            throw LOGGER.atError().addKeyValue("name", configurationProperty.getName()).addKeyValue(RequestKeys.KEY_PATH, this.path).addKeyValue("value", configurationProperty.getValueSanitizer().apply(withFallback)).log(e);
        }
    }

    private String getLocalProperty(String str, Iterable<String> iterable, final Function<String, String> function) {
        if (this.isEmpty) {
            return null;
        }
        final String str2 = this.configurations.get(str);
        if (str2 != null) {
            LOGGER.atVerbose().addKeyValue("name", str).addKeyValue(RequestKeys.KEY_PATH, this.path).addKeyValue("value", new Supplier() { // from class: com.azure.core.util.Configuration$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Configuration.lambda$getLocalProperty$0(function, str2);
                }
            }).log("Got property value by name.");
            return str2;
        }
        for (String str3 : iterable) {
            final String str4 = this.configurations.get(str3);
            if (str4 != null) {
                LOGGER.atVerbose().addKeyValue("name", str).addKeyValue(RequestKeys.KEY_PATH, this.path).addKeyValue("alias", str3).addKeyValue("value", new Supplier() { // from class: com.azure.core.util.Configuration$$ExternalSyntheticLambda1
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Configuration.lambda$getLocalProperty$1(function, str4);
                    }
                }).log("Got property value by alias.");
                return str4;
            }
        }
        return null;
    }

    static /* synthetic */ String lambda$getLocalProperty$0(Function function, String str) {
        return (String) function.apply(str);
    }

    static /* synthetic */ String lambda$getLocalProperty$1(Function function, String str) {
        return (String) function.apply(str);
    }

    private String getWithFallback(ConfigurationProperty<?> configurationProperty) {
        Configuration configuration;
        String localProperty;
        String name = configurationProperty.getName();
        if (!CoreUtils.isNullOrEmpty(name)) {
            String localProperty2 = getLocalProperty(name, configurationProperty.getAliases(), configurationProperty.getValueSanitizer());
            if (localProperty2 != null) {
                return localProperty2;
            }
            if (configurationProperty.isShared() && (configuration = this.sharedConfiguration) != null && (localProperty = configuration.getLocalProperty(name, configurationProperty.getAliases(), configurationProperty.getValueSanitizer())) != null) {
                return localProperty;
            }
        }
        return getFromEnvironment(configurationProperty.getSystemPropertyName(), configurationProperty.getEnvironmentVariableName(), configurationProperty.getValueSanitizer());
    }

    String getFromEnvironment(String str, String str2, final Function<String, String> function) {
        final String environmentVariable;
        final String systemProperty;
        if (str != null && (systemProperty = this.environmentConfiguration.getSystemProperty(str)) != null) {
            LOGGER.atVerbose().addKeyValue("systemProperty", str).addKeyValue("value", new Supplier() { // from class: com.azure.core.util.Configuration$$ExternalSyntheticLambda2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Configuration.lambda$getFromEnvironment$2(function, systemProperty);
                }
            }).log("Got property from system property.");
            return systemProperty;
        }
        if (str2 == null || (environmentVariable = this.environmentConfiguration.getEnvironmentVariable(str2)) == null) {
            return null;
        }
        LOGGER.atVerbose().addKeyValue("envVar", str2).addKeyValue("value", new Supplier() { // from class: com.azure.core.util.Configuration$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return Configuration.lambda$getFromEnvironment$3(function, environmentVariable);
            }
        }).log("Got property from environment variable.");
        return environmentVariable;
    }

    static /* synthetic */ String lambda$getFromEnvironment$2(Function function, String str) {
        return (String) function.apply(str);
    }

    static /* synthetic */ String lambda$getFromEnvironment$3(Function function, String str) {
        return (String) function.apply(str);
    }

    private static Map<String, String> readConfigurations(ConfigurationSource configurationSource, String str) {
        Objects.requireNonNull(configurationSource, "'source' cannot be null");
        Map<String, String> properties = configurationSource.getProperties(str);
        if (properties == null || properties.isEmpty()) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            String key = CoreUtils.isNullOrEmpty(str) ? entry.getKey() : entry.getKey().substring(str.length() + 1);
            String value = entry.getValue();
            ClientLogger clientLogger = LOGGER;
            clientLogger.atVerbose().addKeyValue("name", entry.getKey()).log("Got property from configuration source.");
            if (key != null && value != null) {
                map.put(key, value);
            } else {
                clientLogger.atWarning().addKeyValue("name", entry.getKey()).log("Key or value is null, property is ignored.");
            }
        }
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T convertToPrimitiveOrDefault(String str, T t) {
        if (CoreUtils.isNullOrEmpty(str)) {
            return t;
        }
        if (t instanceof Byte) {
            return (T) Byte.valueOf(Byte.parseByte(str));
        }
        if (t instanceof Short) {
            return (T) Short.valueOf(Short.parseShort(str));
        }
        if (t instanceof Integer) {
            return (T) Integer.valueOf(Integer.parseInt(str));
        }
        if (t instanceof Long) {
            return (T) Long.valueOf(Long.parseLong(str));
        }
        if (t instanceof Float) {
            return (T) Float.valueOf(Float.parseFloat(str));
        }
        if (t instanceof Double) {
            return (T) Double.valueOf(Double.parseDouble(str));
        }
        return t instanceof Boolean ? (T) Boolean.valueOf(Boolean.parseBoolean(str)) : str;
    }
}
