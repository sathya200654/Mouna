package com.azure.core.util;

import com.azure.core.implementation.util.EnvironmentConfiguration;
import com.azure.core.util.logging.ClientLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConfigurationBuilder {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ConfigurationBuilder.class);
    private final EnvironmentConfiguration environmentConfiguration;
    private final MutableConfigurationSource mutableSource;
    private String rootPath;
    private Configuration sharedConfiguration;

    public ConfigurationBuilder() {
        this.mutableSource = new MutableConfigurationSource();
        this.environmentConfiguration = EnvironmentConfiguration.getGlobalConfiguration();
    }

    public ConfigurationBuilder(ConfigurationSource configurationSource) {
        this.mutableSource = new MutableConfigurationSource((ConfigurationSource) Objects.requireNonNull(configurationSource, "'source' cannot be null"));
        this.environmentConfiguration = EnvironmentConfiguration.getGlobalConfiguration();
    }

    public ConfigurationBuilder(ConfigurationSource configurationSource, ConfigurationSource configurationSource2, ConfigurationSource configurationSource3) {
        Objects.requireNonNull(configurationSource, "'source' cannot be null");
        Objects.requireNonNull(configurationSource2, "'systemPropertiesConfigurationSource' cannot be null");
        Objects.requireNonNull(configurationSource3, "'environmentConfigurationSource' cannot be null");
        this.mutableSource = new MutableConfigurationSource(configurationSource);
        this.environmentConfiguration = new EnvironmentConfiguration(configurationSource2, configurationSource3);
    }

    public ConfigurationBuilder putProperty(String str, String str2) {
        Objects.requireNonNull(str, "'name' cannot be null.");
        Objects.requireNonNull(str2, "'value' cannot be null.");
        this.mutableSource.put(str, str2);
        this.environmentConfiguration.put(str, str2);
        this.sharedConfiguration = null;
        return this;
    }

    public ConfigurationBuilder root(String str) {
        this.rootPath = str;
        this.sharedConfiguration = null;
        return this;
    }

    public Configuration build() {
        if (this.sharedConfiguration == null) {
            this.sharedConfiguration = new Configuration(this.mutableSource, this.environmentConfiguration, this.rootPath, (Configuration) null);
        }
        return this.sharedConfiguration;
    }

    public Configuration buildSection(String str) {
        Objects.requireNonNull(str, "'path' cannot be null");
        if (this.sharedConfiguration == null) {
            this.sharedConfiguration = new Configuration(this.mutableSource, this.environmentConfiguration, this.rootPath, (Configuration) null);
        }
        return new Configuration(this.mutableSource, this.environmentConfiguration, getAbsolutePath(this.rootPath, str), this.sharedConfiguration);
    }

    private static String getAbsolutePath(String str, String str2) {
        return CoreUtils.isNullOrEmpty(str) ? str2 : str + "." + str2;
    }

    private static final class MutableConfigurationSource implements ConfigurationSource {
        private Map<String, String> additionalConfigurations;
        private final ConfigurationSource originalSource;

        private MutableConfigurationSource() {
            this((ConfigurationSource) null);
        }

        private MutableConfigurationSource(ConfigurationSource configurationSource) {
            this.originalSource = configurationSource;
            this.additionalConfigurations = null;
        }

        MutableConfigurationSource put(String str, String str2) {
            if (this.additionalConfigurations == null) {
                this.additionalConfigurations = new HashMap();
            }
            if (this.additionalConfigurations.containsKey(str)) {
                ConfigurationBuilder.LOGGER.atWarning().addKeyValue("name", str).log("Property with the same name already exists, value will be overwritten.");
            }
            this.additionalConfigurations.put(str, str2);
            return this;
        }

        @Override // com.azure.core.util.ConfigurationSource
        public Map<String, String> getProperties(String str) {
            ConfigurationSource configurationSource = this.originalSource;
            Map<String, String> mapEmptyMap = configurationSource == null ? Collections.emptyMap() : configurationSource.getProperties(str);
            if (this.additionalConfigurations == null) {
                return mapEmptyMap;
            }
            HashMap map = new HashMap(mapEmptyMap);
            for (Map.Entry<String, String> entry : this.additionalConfigurations.entrySet()) {
                if (map.containsKey(entry.getKey())) {
                    ConfigurationBuilder.LOGGER.atWarning().addKeyValue("name", entry.getKey()).log("Property with the same name already exists, value will be overwritten.");
                }
                if (hasPrefix(entry.getKey(), str)) {
                    map.put(entry.getKey(), entry.getValue());
                }
            }
            return map;
        }

        private static boolean hasPrefix(String str, String str2) {
            if (str2 != null) {
                return str.startsWith(str2) && str.length() > str2.length() && str.charAt(str2.length()) == '.';
            }
            return true;
        }
    }
}
