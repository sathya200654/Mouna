package com.microsoft.cognitiveservices.speech.diagnostics.logging;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.StringRef;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
class Logger {

    public enum Type {
        File,
        Memory,
        Event
    }

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    Logger() {
    }

    public static void fileLoggerSetFilters(String[] strArr) {
        Contracts.throwIfNull(strArr, "filters");
        Contracts.throwIfFail(logFileSetFilters(String.join(";", strArr)));
    }

    public static String getMemoryLogLine(long j) {
        StringRef stringRef = new StringRef("");
        Contracts.throwIfFail(logMemoryGetLine(j, stringRef));
        return stringRef.getValue();
    }

    public static long getMemoryLogLineNumNewest() {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(logMemoryGetLineNumNewest(intRef));
        return intRef.getValue();
    }

    public static long getMemoryLogLineNumOldest() {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(logMemoryGetLineNumOldest(intRef));
        return intRef.getValue();
    }

    private static final native long logEventSetCallback(EventLogger.EventHandler eventHandler, long j);

    private static final native long logEventSetFilters(String str);

    private static final native long logFileSetFilters(String str);

    private static final native long logMemoryGetLine(long j, StringRef stringRef);

    private static final native long logMemoryGetLineNumNewest(IntRef intRef);

    private static final native long logMemoryGetLineNumOldest(IntRef intRef);

    private static final native long logMemorySetFilters(String str);

    private static final native long logSetLevel(String str, String str2);

    public static void setEventLoggingCallback(EventLogger.EventHandler eventHandler, long j) {
        Contracts.throwIfFail(logEventSetCallback(eventHandler, j));
    }

    public static void setEventLoggingFilters(String[] strArr) {
        Contracts.throwIfNull(strArr, "filters");
        Contracts.throwIfFail(logEventSetFilters(String.join(";", strArr)));
    }

    public static void setLevel(Type type, Level level) {
        Contracts.throwIfNull(type, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        Contracts.throwIfNull(level, "level");
        Contracts.throwIfFail(logSetLevel(type.name().toLowerCase(), level.name().toLowerCase()));
    }

    public static void setMemoryLoggingFilters(String[] strArr) {
        Contracts.throwIfNull(strArr, "filters");
        Contracts.throwIfFail(logMemorySetFilters(String.join(";", strArr)));
    }
}
