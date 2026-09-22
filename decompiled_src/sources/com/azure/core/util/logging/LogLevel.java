package com.azure.core.util.logging;

import coil3.disk.DiskLruCache;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public enum LogLevel {
    VERBOSE(1, DiskLruCache.VERSION, "verbose", "debug"),
    INFORMATIONAL(2, "2", "info", "information", "informational"),
    WARNING(3, "3", "warn", "warning"),
    ERROR(4, "4", "err", "error"),
    NOT_SET(5, "5");

    private static final HashMap<String, LogLevel> LOG_LEVEL_STRING_MAPPER = new HashMap<>();
    private final String[] allowedLogLevelVariables;
    private final int numericValue;

    static {
        for (LogLevel logLevel : values()) {
            for (String str : logLevel.allowedLogLevelVariables) {
                LOG_LEVEL_STRING_MAPPER.put(str, logLevel);
            }
        }
    }

    LogLevel(int i, String... strArr) {
        this.numericValue = i;
        this.allowedLogLevelVariables = strArr;
    }

    public int getLogLevel() {
        return this.numericValue;
    }

    public static LogLevel fromString(String str) {
        if (str == null) {
            return NOT_SET;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        HashMap<String, LogLevel> map = LOG_LEVEL_STRING_MAPPER;
        if (!map.containsKey(lowerCase)) {
            throw new IllegalArgumentException("We currently do not support the log level you set. LogLevel: " + str);
        }
        return map.get(lowerCase);
    }
}
