package com.azure.core.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConfigurationProperty<T> {
    static final Function<String, String> REDACT_VALUE_SANITIZER = new Function() { // from class: com.azure.core.util.ConfigurationProperty$$ExternalSyntheticLambda0
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ConfigurationProperty.lambda$static$0((String) obj);
        }
    };
    private final List<String> aliases;
    private final Function<String, T> converter;
    private final T defaultValue;
    private final String environmentVariable;
    private final boolean isRequired;
    private final boolean isShared;
    private final String name;
    private final String systemProperty;
    private final Function<String, String> valueSanitizer;

    static /* synthetic */ String lambda$static$0(String str) {
        return "redacted";
    }

    ConfigurationProperty(String str, T t, boolean z, Function<String, T> function, boolean z2, String str2, String str3, String[] strArr, Function<String, String> function2) {
        this.name = (String) Objects.requireNonNull(str, "'name' cannot be null");
        this.converter = (Function) Objects.requireNonNull(function, "'converter' cannot be null");
        this.environmentVariable = str2;
        this.systemProperty = str3;
        this.aliases = strArr == null ? Collections.emptyList() : Arrays.asList(strArr);
        this.defaultValue = t;
        this.isRequired = z;
        this.isShared = z2;
        this.valueSanitizer = function2 == null ? REDACT_VALUE_SANITIZER : function2;
    }

    public boolean isShared() {
        return this.isShared;
    }

    public Function<String, String> getValueSanitizer() {
        return this.valueSanitizer;
    }

    public boolean isRequired() {
        return this.isRequired;
    }

    public String getName() {
        return this.name;
    }

    public Function<String, T> getConverter() {
        return this.converter;
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    public Iterable<String> getAliases() {
        return this.aliases;
    }

    public String getEnvironmentVariableName() {
        return this.environmentVariable;
    }

    public String getSystemPropertyName() {
        return this.systemProperty;
    }
}
