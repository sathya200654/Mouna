package com.azure.core.util;

import com.azure.core.implementation.ImplUtils;
import com.azure.core.util.tracing.TracerProvider;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class TracingOptions {
    private Set<String> allowedQueryParamNames;
    private boolean isEnabled;
    private final Class<? extends TracerProvider> tracerProvider;
    private static final ConfigurationProperty<Boolean> IS_DISABLED_PROPERTY = ConfigurationPropertyBuilder.ofBoolean("tracing.disabled").environmentVariableName(Configuration.PROPERTY_AZURE_TRACING_DISABLED).shared(true).defaultValue(false).build();
    private static final ConfigurationProperty<String> PROVIDER_NAME_PROPERTY = ConfigurationPropertyBuilder.ofString("tracing.provider.implementation").environmentVariableName(Configuration.PROPERTY_AZURE_TRACING_IMPLEMENTATION).shared(true).build();
    private static final Configuration GLOBAL_CONFIG = Configuration.getGlobalConfiguration();

    public TracingOptions() {
        this(GLOBAL_CONFIG);
    }

    protected TracingOptions(Class<? extends TracerProvider> cls) {
        this.tracerProvider = cls;
        this.isEnabled = !((Boolean) GLOBAL_CONFIG.get(IS_DISABLED_PROPERTY)).booleanValue();
    }

    private TracingOptions(Configuration configuration) {
        this.isEnabled = !((Boolean) configuration.get(IS_DISABLED_PROPERTY)).booleanValue();
        String str = (String) configuration.get(PROVIDER_NAME_PROPERTY);
        this.tracerProvider = str != null ? ImplUtils.getClassByName(str) : null;
    }

    public static TracingOptions fromConfiguration(Configuration configuration) {
        return new TracingOptions(configuration);
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public TracingOptions setEnabled(boolean z) {
        this.isEnabled = z;
        return this;
    }

    public Class<? extends TracerProvider> getTracerProvider() {
        return this.tracerProvider;
    }

    public Set<String> getAllowedTracingQueryParamNames() {
        return this.allowedQueryParamNames;
    }

    public TracingOptions setAllowedTracingQueryParamNames(Set<String> set) {
        this.allowedQueryParamNames = set;
        return this;
    }
}
