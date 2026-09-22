package com.azure.core.util;

import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class UserAgentUtil {
    public static final String DEFAULT_USER_AGENT_HEADER = "azsdk-java";
    private static final String INVALID_APPLICATION_ID_SPACE = "'applicationId' cannot contain spaces.";
    private static final int MAX_APP_ID_LENGTH = 24;
    private static final String PLATFORM_INFO_FORMAT = "%s; %s; %s";

    private UserAgentUtil() {
    }

    public static String toUserAgentString(String str, String str2, String str3, Configuration configuration) {
        StringBuilder sb = new StringBuilder();
        if (!CoreUtils.isNullOrEmpty(str)) {
            if (!str.contains(" ")) {
                sb.append(str).append(" ");
            } else {
                throw new IllegalArgumentException(INVALID_APPLICATION_ID_SPACE);
            }
        }
        sb.append("azsdk-java-").append(str2).append(RemoteSettings.FORWARD_SLASH_STRING).append(str3);
        if (!isTelemetryDisabled(configuration)) {
            sb.append(" (").append(getPlatformInfo()).append(")");
        }
        return sb.toString();
    }

    private static String getPlatformInfo() {
        return String.format(PLATFORM_INFO_FORMAT, Configuration.getGlobalConfiguration().get("java.version"), Configuration.getGlobalConfiguration().get("os.name"), Configuration.getGlobalConfiguration().get("os.version"));
    }

    private static boolean isTelemetryDisabled(Configuration configuration) {
        if (configuration == null) {
            return ((Boolean) Configuration.getGlobalConfiguration().get(Configuration.PROPERTY_AZURE_TELEMETRY_DISABLED, false)).booleanValue();
        }
        return ((Boolean) configuration.get(Configuration.PROPERTY_AZURE_TELEMETRY_DISABLED, false)).booleanValue();
    }
}
