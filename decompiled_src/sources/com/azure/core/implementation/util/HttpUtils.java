package com.azure.core.implementation.util;

import com.azure.core.util.Configuration;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import java.time.Duration;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HttpUtils {
    public static final String AZURE_EAGERLY_CONVERT_HEADERS = "azure-eagerly-convert-headers";
    public static final String AZURE_EAGERLY_READ_RESPONSE = "azure-eagerly-read-response";
    public static final String AZURE_IGNORE_RESPONSE_BODY = "azure-ignore-response-body";
    public static final String AZURE_RESPONSE_TIMEOUT = "azure-response-timeout";
    private static final Duration DEFAULT_CONNECT_TIMEOUT;
    private static final Duration DEFAULT_READ_TIMEOUT;
    private static final Duration DEFAULT_RESPONSE_TIMEOUT;
    private static final Duration DEFAULT_WRITE_TIMEOUT;
    private static final ClientLogger LOGGER;
    private static final Duration MINIMUM_TIMEOUT;

    static {
        ClientLogger clientLogger = new ClientLogger((Class<?>) HttpUtils.class);
        LOGGER = clientLogger;
        MINIMUM_TIMEOUT = Duration.ofMillis(1L);
        Configuration globalConfiguration = Configuration.getGlobalConfiguration();
        DEFAULT_CONNECT_TIMEOUT = CoreUtils.getDefaultTimeoutFromEnvironment(globalConfiguration, Configuration.PROPERTY_AZURE_REQUEST_CONNECT_TIMEOUT, Duration.ofSeconds(10L), clientLogger);
        DEFAULT_WRITE_TIMEOUT = CoreUtils.getDefaultTimeoutFromEnvironment(globalConfiguration, Configuration.PROPERTY_AZURE_REQUEST_WRITE_TIMEOUT, Duration.ofSeconds(60L), clientLogger);
        DEFAULT_RESPONSE_TIMEOUT = CoreUtils.getDefaultTimeoutFromEnvironment(globalConfiguration, Configuration.PROPERTY_AZURE_REQUEST_RESPONSE_TIMEOUT, Duration.ofSeconds(60L), clientLogger);
        DEFAULT_READ_TIMEOUT = CoreUtils.getDefaultTimeoutFromEnvironment(globalConfiguration, Configuration.PROPERTY_AZURE_REQUEST_READ_TIMEOUT, Duration.ofSeconds(60L), clientLogger);
    }

    public static Duration getDefaultConnectTimeout() {
        return DEFAULT_CONNECT_TIMEOUT;
    }

    public static Duration getDefaultWriteTimeout() {
        return DEFAULT_WRITE_TIMEOUT;
    }

    public static Duration getDefaultResponseTimeout() {
        return DEFAULT_RESPONSE_TIMEOUT;
    }

    public static Duration getDefaultReadTimeout() {
        return DEFAULT_READ_TIMEOUT;
    }

    public static Duration getTimeout(Duration duration, Duration duration2) {
        if (duration == null) {
            return duration2;
        }
        if (duration.isZero() || duration.isNegative()) {
            return Duration.ZERO;
        }
        Duration duration3 = MINIMUM_TIMEOUT;
        return duration.compareTo(duration3) < 0 ? duration3 : duration;
    }

    private HttpUtils() {
    }
}
