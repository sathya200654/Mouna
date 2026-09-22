package com.microsoft.cognitiveservices.speech.diagnostics.logging;

import coil3.util.UtilsKt;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.Contracts;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class SpxTrace {
    private static final int __SPX_TRACE_LEVEL_ERROR = 2;
    private static final int __SPX_TRACE_LEVEL_INFO = 8;
    private static final int __SPX_TRACE_LEVEL_VERBOSE = 16;
    private static final int __SPX_TRACE_LEVEL_WARNING = 4;

    private static class CallerInfo {
        public String fileName;
        public int lineNumber;

        public CallerInfo(String str, int i) {
            this.fileName = str;
            this.lineNumber = i;
        }
    }

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    private SpxTrace() {
    }

    public static void SPX_TRACE_ERROR(String str) {
        CallerInfo callerInfo = getCallerInfo();
        SPX_TRACE_ERROR(str, args(new Object[0]), callerInfo.lineNumber, callerInfo.fileName);
    }

    public static void SPX_TRACE_ERROR(String str, Object[] objArr, int i, String str2) {
        SPX_TRACE_HELPER(2, "SPX_TRACE_ERROR", str, objArr, i, str2);
    }

    private static void SPX_TRACE_HELPER(int i, String str, String str2, Object[] objArr, int i2, String str3) {
        Contracts.throwIfNull(str, "title");
        Contracts.throwIfNull(str2, "format");
        Contracts.throwIfNull(objArr, "args");
        Contracts.throwIfNull(str3, UtilsKt.SCHEME_FILE);
        Contracts.throwIfFail(logTraceString(i, str, str3, i2, String.format(str2, objArr)));
    }

    public static void SPX_TRACE_INFO(String str) {
        CallerInfo callerInfo = getCallerInfo();
        SPX_TRACE_INFO(str, args(new Object[0]), callerInfo.lineNumber, callerInfo.fileName);
    }

    public static void SPX_TRACE_INFO(String str, Object[] objArr, int i, String str2) {
        SPX_TRACE_HELPER(8, "SPX_TRACE_INFO", str, objArr, i, str2);
    }

    public static void SPX_TRACE_VERBOSE(String str) {
        CallerInfo callerInfo = getCallerInfo();
        SPX_TRACE_VERBOSE(str, args(new Object[0]), callerInfo.lineNumber, callerInfo.fileName);
    }

    public static void SPX_TRACE_VERBOSE(String str, Object[] objArr, int i, String str2) {
        SPX_TRACE_HELPER(16, "SPX_TRACE_VERBOSE", str, objArr, i, str2);
    }

    public static void SPX_TRACE_WARNING(String str) {
        CallerInfo callerInfo = getCallerInfo();
        SPX_TRACE_WARNING(str, args(new Object[0]), callerInfo.lineNumber, callerInfo.fileName);
    }

    public static void SPX_TRACE_WARNING(String str, Object[] objArr, int i, String str2) {
        SPX_TRACE_HELPER(4, "SPX_TRACE_WARNING", str, objArr, i, str2);
    }

    private static Object[] args(Object... objArr) {
        return objArr;
    }

    private static CallerInfo getCallerInfo() {
        String str = "";
        int lineNumber = 0;
        try {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
            if (stackTraceElement != null) {
                String fileName = stackTraceElement.getFileName();
                try {
                    lineNumber = stackTraceElement.getLineNumber();
                    if (fileName != null) {
                        str = fileName;
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
        return new CallerInfo(str, lineNumber);
    }

    private static final native long logTraceString(int i, String str, String str2, int i2, String str3);
}
