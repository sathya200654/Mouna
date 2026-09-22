package com.azure.core.util;

import java.time.Duration;
import java.util.Objects;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConfigurationPropertyBuilder<T> {
    private String[] aliases = EMPTY_ARRAY;
    private final Function<String, T> converter;
    private T defaultValue;
    private String environmentVariableName;
    private final String name;
    private boolean required;
    private boolean shared;
    private String systemPropertyName;
    private Function<String, String> valueSanitizer;
    private static final String[] EMPTY_ARRAY = new String[0];
    private static final Function<String, String> PERMIT_VALUE_SANITIZER = new Function() { // from class: com.azure.core.util.ConfigurationPropertyBuilder$$ExternalSyntheticLambda0
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ConfigurationPropertyBuilder.lambda$static$0((String) obj);
        }
    };
    private static final Function<String, Boolean> CONFIGURATION_PROPERTY_BOOLEAN_CONVERTER = new Function() { // from class: com.azure.core.util.ConfigurationPropertyBuilder$$ExternalSyntheticLambda1
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return Boolean.valueOf((String) obj);
        }
    };
    private static final Function<String, Duration> CONFIGURATION_PROPERTY_DURATION_CONVERTER = new Function() { // from class: com.azure.core.util.ConfigurationPropertyBuilder$$ExternalSyntheticLambda2
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ConfigurationPropertyBuilder.lambda$static$1((String) obj);
        }
    };
    private static final Function<String, Integer> CONFIGURATION_PROPERTY_INTEGER_CONVERTER = new Function() { // from class: com.azure.core.util.ConfigurationPropertyBuilder$$ExternalSyntheticLambda3
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return Integer.valueOf((String) obj);
        }
    };
    private static final Function<String, String> CONFIGURATION_PROPERTY_STRING_CONVERTER = Function.identity();

    static /* synthetic */ String lambda$static$0(String str) {
        return str;
    }

    static /* synthetic */ Duration lambda$static$1(String str) {
        long j = Long.parseLong(str);
        if (j < 0) {
            throw new IllegalArgumentException("Duration can't be negative");
        }
        return Duration.ofMillis(j);
    }

    public static ConfigurationPropertyBuilder<String> ofString(String str) {
        return new ConfigurationPropertyBuilder<>(str, CONFIGURATION_PROPERTY_STRING_CONVERTER);
    }

    public static ConfigurationPropertyBuilder<Integer> ofInteger(String str) {
        return new ConfigurationPropertyBuilder(str, CONFIGURATION_PROPERTY_INTEGER_CONVERTER).logValue(true);
    }

    public static ConfigurationPropertyBuilder<Duration> ofDuration(String str) {
        return new ConfigurationPropertyBuilder(str, CONFIGURATION_PROPERTY_DURATION_CONVERTER).logValue(true);
    }

    public static ConfigurationPropertyBuilder<Boolean> ofBoolean(String str) {
        return new ConfigurationPropertyBuilder(str, CONFIGURATION_PROPERTY_BOOLEAN_CONVERTER).logValue(true);
    }

    public ConfigurationPropertyBuilder(String str, Function<String, T> function) {
        this.name = (String) Objects.requireNonNull(str, "'name' cannot be null");
        this.converter = (Function) Objects.requireNonNull(function, "'converter' cannot be null");
    }

    public ConfigurationPropertyBuilder<T> defaultValue(T t) {
        this.defaultValue = t;
        return this;
    }

    public ConfigurationPropertyBuilder<T> shared(boolean z) {
        this.shared = z;
        return this;
    }

    public ConfigurationPropertyBuilder<T> logValue(boolean z) {
        if (z) {
            this.valueSanitizer = PERMIT_VALUE_SANITIZER;
        }
        return this;
    }

    public ConfigurationPropertyBuilder<T> required(boolean z) {
        this.required = z;
        return this;
    }

    public ConfigurationPropertyBuilder<T> aliases(String... strArr) {
        this.aliases = strArr;
        return this;
    }

    public ConfigurationPropertyBuilder<T> environmentVariableName(String str) {
        this.environmentVariableName = str;
        return this;
    }

    public ConfigurationPropertyBuilder<T> systemPropertyName(String str) {
        this.systemPropertyName = str;
        return this;
    }

    public ConfigurationProperty<T> build() {
        return new ConfigurationProperty<>(this.name, this.defaultValue, this.required, this.converter, this.shared, this.environmentVariableName, this.systemPropertyName, this.aliases, this.valueSanitizer);
    }
}
