package com.azure.core.implementation.util;

import com.azure.core.util.Configuration;
import com.azure.core.util.ConfigurationSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class EnvironmentConfiguration {
    private static final List<String> DEFAULT_CONFIGURATIONS = Arrays.asList(Configuration.PROPERTY_HTTP_PROXY, Configuration.PROPERTY_HTTPS_PROXY, Configuration.PROPERTY_IDENTITY_ENDPOINT, Configuration.PROPERTY_IDENTITY_HEADER, Configuration.PROPERTY_NO_PROXY, Configuration.PROPERTY_MSI_ENDPOINT, Configuration.PROPERTY_MSI_SECRET, Configuration.PROPERTY_AZURE_SUBSCRIPTION_ID, Configuration.PROPERTY_AZURE_USERNAME, Configuration.PROPERTY_AZURE_PASSWORD, Configuration.PROPERTY_AZURE_CLIENT_ID, Configuration.PROPERTY_AZURE_CLIENT_SECRET, Configuration.PROPERTY_AZURE_TENANT_ID, Configuration.PROPERTY_AZURE_CLIENT_CERTIFICATE_PATH, Configuration.PROPERTY_AZURE_CLIENT_CERTIFICATE_PASSWORD, Configuration.PROPERTY_AZURE_IDENTITY_DISABLE_CP1, Configuration.PROPERTY_AZURE_RESOURCE_GROUP, Configuration.PROPERTY_AZURE_CLOUD, Configuration.PROPERTY_AZURE_AUTHORITY_HOST, Configuration.PROPERTY_AZURE_TELEMETRY_DISABLED, Configuration.PROPERTY_AZURE_LOG_LEVEL, Configuration.PROPERTY_AZURE_HTTP_LOG_DETAIL_LEVEL, Configuration.PROPERTY_AZURE_TRACING_DISABLED, Configuration.PROPERTY_AZURE_POD_IDENTITY_TOKEN_URL, Configuration.PROPERTY_AZURE_REGIONAL_AUTHORITY_NAME, Configuration.PROPERTY_AZURE_REQUEST_RETRY_COUNT, Configuration.PROPERTY_AZURE_REQUEST_CONNECT_TIMEOUT, Configuration.PROPERTY_AZURE_REQUEST_WRITE_TIMEOUT, Configuration.PROPERTY_AZURE_REQUEST_RESPONSE_TIMEOUT, Configuration.PROPERTY_AZURE_REQUEST_READ_TIMEOUT);
    private static final EnvironmentConfiguration GLOBAL_CONFIGURATION = new EnvironmentConfiguration();
    private final ConcurrentMap<String, Optional<String>> envConfigurations;
    private final ConcurrentMap<String, String> explicitConfigurations;
    private final ConcurrentMap<String, Optional<String>> sysPropertiesConfigurations;

    private EnvironmentConfiguration() {
        this(EnvironmentVariablesConfigurationSource.GLOBAL_SOURCE, new ConfigurationSource() { // from class: com.azure.core.implementation.util.EnvironmentConfiguration$$ExternalSyntheticLambda0
            @Override // com.azure.core.util.ConfigurationSource
            public final Map getProperties(String str) {
                return Collections.emptyMap();
            }
        });
    }

    public EnvironmentConfiguration(EnvironmentConfiguration environmentConfiguration) {
        this.explicitConfigurations = new ConcurrentHashMap(environmentConfiguration.explicitConfigurations);
        this.envConfigurations = new ConcurrentHashMap(environmentConfiguration.envConfigurations);
        this.sysPropertiesConfigurations = new ConcurrentHashMap(environmentConfiguration.sysPropertiesConfigurations);
    }

    public EnvironmentConfiguration(ConfigurationSource configurationSource, ConfigurationSource configurationSource2) {
        this.explicitConfigurations = new ConcurrentHashMap();
        Map<String, String> properties = (configurationSource2 == null ? EnvironmentVariablesConfigurationSource.GLOBAL_SOURCE : configurationSource2).getProperties(null);
        Objects.requireNonNull(properties, "'environmentConfigurationSource.getProperties(null)' can't be null");
        this.envConfigurations = new ConcurrentHashMap(properties.size());
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            this.envConfigurations.put(entry.getKey(), Optional.ofNullable(entry.getValue()));
        }
        if (configurationSource == null) {
            this.sysPropertiesConfigurations = new ConcurrentHashMap();
            return;
        }
        Map<String, String> properties2 = configurationSource.getProperties(null);
        Objects.requireNonNull(properties2, "'systemPropertiesConfigurationSource.getProperties(null)' can't be null");
        this.sysPropertiesConfigurations = new ConcurrentHashMap(properties2.size());
        for (Map.Entry<String, String> entry2 : properties2.entrySet()) {
            this.sysPropertiesConfigurations.put(entry2.getKey(), Optional.ofNullable(entry2.getValue()));
        }
    }

    public static EnvironmentConfiguration getGlobalConfiguration() {
        return GLOBAL_CONFIGURATION;
    }

    public String getEnvironmentVariable(String str) {
        return getOrLoad(str, this.envConfigurations, false);
    }

    public String getSystemProperty(String str) {
        return getOrLoad(str, this.sysPropertiesConfigurations, true);
    }

    public String get(String str) {
        String str2 = this.explicitConfigurations.get(str);
        if (str2 != null) {
            return str2;
        }
        String systemProperty = getSystemProperty(str);
        return systemProperty != null ? systemProperty : getEnvironmentVariable(str);
    }

    private String getOrLoad(String str, ConcurrentMap<String, Optional<String>> concurrentMap, boolean z) {
        Optional<String> optional = concurrentMap.get(str);
        if (optional != null) {
            return optional.orElse(null);
        }
        String strLoadFromProperties = z ? loadFromProperties(str) : loadFromEnvironment(str);
        concurrentMap.put(str, Optional.ofNullable(strLoadFromProperties));
        return strLoadFromProperties;
    }

    public EnvironmentConfiguration put(String str, String str2) {
        this.explicitConfigurations.put(str, str2);
        return this;
    }

    public String remove(String str) {
        return this.explicitConfigurations.remove(str);
    }

    private String loadFromEnvironment(String str) {
        return System.getenv(str);
    }

    private String loadFromProperties(String str) {
        return System.getProperty(str);
    }

    public static final class EnvironmentVariablesConfigurationSource implements ConfigurationSource {
        public static final ConfigurationSource GLOBAL_SOURCE = new EnvironmentVariablesConfigurationSource();
        private final Map<String, String> configurations = new HashMap();

        private EnvironmentVariablesConfigurationSource() {
            for (String str : EnvironmentConfiguration.DEFAULT_CONFIGURATIONS) {
                String str2 = System.getenv(str);
                if (str2 != null) {
                    this.configurations.put(str, str2);
                }
            }
        }

        @Override // com.azure.core.util.ConfigurationSource
        public Map<String, String> getProperties(String str) {
            return this.configurations;
        }
    }
}
