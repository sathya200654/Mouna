package com.azure.core.util;

import com.azure.core.implementation.ImplUtils;
import com.azure.core.util.metrics.MeterProvider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class MetricsOptions {
    private boolean isEnabled;
    private final Class<? extends MeterProvider> meterProvider;
    private static final ConfigurationProperty<Boolean> IS_DISABLED_PROPERTY = ConfigurationPropertyBuilder.ofBoolean("metrics.disabled").environmentVariableName(Configuration.PROPERTY_AZURE_METRICS_DISABLED).shared(true).defaultValue(false).build();
    private static final ConfigurationProperty<String> PROVIDER_NAME_PROPERTY = ConfigurationPropertyBuilder.ofString("metrics.provider.implementation").environmentVariableName(Configuration.PROPERTY_AZURE_METRICS_IMPLEMENTATION).shared(true).build();
    private static final Configuration GLOBAL_CONFIG = Configuration.getGlobalConfiguration();

    public MetricsOptions() {
        this(GLOBAL_CONFIG);
    }

    protected MetricsOptions(Class<? extends MeterProvider> cls) {
        this.isEnabled = !((Boolean) GLOBAL_CONFIG.get(IS_DISABLED_PROPERTY)).booleanValue();
        this.meterProvider = cls;
    }

    private MetricsOptions(Configuration configuration) {
        this.isEnabled = !((Boolean) configuration.get(IS_DISABLED_PROPERTY)).booleanValue();
        String str = (String) configuration.get(PROVIDER_NAME_PROPERTY);
        this.meterProvider = str != null ? ImplUtils.getClassByName(str) : null;
    }

    public static MetricsOptions fromConfiguration(Configuration configuration) {
        ConfigurationProperty<Boolean> configurationProperty = IS_DISABLED_PROPERTY;
        if (configuration.contains(configurationProperty)) {
            return new MetricsOptions().setEnabled(!((Boolean) configuration.get(configurationProperty)).booleanValue());
        }
        return new MetricsOptions();
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public MetricsOptions setEnabled(boolean z) {
        this.isEnabled = z;
        return this;
    }

    public Class<? extends MeterProvider> getMeterProvider() {
        return this.meterProvider;
    }
}
