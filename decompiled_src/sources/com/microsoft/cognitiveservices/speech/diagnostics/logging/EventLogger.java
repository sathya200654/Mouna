package com.microsoft.cognitiveservices.speech.diagnostics.logging;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class EventLogger {
    private static EventHandler eventHandler;
    private static final Object lockObj = new Object();
    private static SafeHandle safeHandle;

    public interface EventHandler {
        void logMessage(String str);
    }

    private EventLogger() {
    }

    public static void setCallback() {
        setCallback(null);
    }

    public static void setCallback(EventHandler eventHandler2) {
        synchronized (lockObj) {
            try {
                if (eventHandler2 != null) {
                    SafeHandle safeHandle2 = new SafeHandle(System.identityHashCode(eventHandler2), SafeHandleType.EventLoggerCallback);
                    safeHandle = safeHandle2;
                    Contracts.throwIfNull(safeHandle2, "safeHandle");
                    eventHandler = eventHandler2;
                    Logger.setEventLoggingCallback(eventHandler2, safeHandle.getValue());
                } else {
                    eventHandler = null;
                    safeHandle = null;
                    Logger.setEventLoggingCallback(null, 0L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setFilters() {
        Logger.setEventLoggingFilters(new String[0]);
    }

    public static void setFilters(String[] strArr) {
        Contracts.throwIfNull(strArr, "filters");
        Logger.setEventLoggingFilters(strArr);
    }

    public static void setLevel(Level level) {
        Contracts.throwIfNull(level, "level");
        Logger.setLevel(Logger.Type.Event, level);
    }
}
