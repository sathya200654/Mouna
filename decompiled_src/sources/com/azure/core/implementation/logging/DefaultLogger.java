package com.azure.core.implementation.logging;

import com.azure.core.implementation.StringBuilderWriter;
import com.azure.core.implementation.util.EnvironmentConfiguration;
import com.azure.core.util.Configuration;
import com.azure.core.util.logging.LogLevel;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.InvalidPathException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class DefaultLogger implements Logger {
    private static final String CLOSE_BRACKET = "]";
    public static final String DEBUG = "DEBUG";
    public static final String ERROR = "ERROR";
    private static final String HYPHEN = " - ";
    public static final String INFO = "INFO";
    private static final String OPEN_BRACKET = " [";
    public static final String TRACE = "TRACE";
    public static final String WARN = "WARN";
    private static final String WHITESPACE = " ";
    private final String classPath;
    private final boolean isDebugEnabled;
    private final boolean isErrorEnabled;
    private final boolean isInfoEnabled;
    private final boolean isTraceEnabled;
    private final boolean isWarnEnabled;
    private final PrintStream logLocation;

    public DefaultLogger(Class<?> cls) {
        this(cls.getCanonicalName(), System.out, fromEnvironment());
    }

    public DefaultLogger(String str) {
        this(getClassPathFromClassName(str), System.out, fromEnvironment());
    }

    public DefaultLogger(String str, PrintStream printStream, LogLevel logLevel) {
        this.classPath = getClassPathFromClassName(str);
        int logLevel2 = logLevel.getLogLevel();
        this.isTraceEnabled = LogLevel.VERBOSE.getLogLevel() > logLevel2;
        this.isDebugEnabled = LogLevel.VERBOSE.getLogLevel() >= logLevel2;
        this.isInfoEnabled = LogLevel.INFORMATIONAL.getLogLevel() >= logLevel2;
        this.isWarnEnabled = LogLevel.WARNING.getLogLevel() >= logLevel2;
        this.isErrorEnabled = LogLevel.ERROR.getLogLevel() >= logLevel2;
        this.logLocation = printStream;
    }

    private static String getClassPathFromClassName(String str) {
        try {
            return Class.forName(str).getCanonicalName();
        } catch (ClassNotFoundException | InvalidPathException unused) {
            return str;
        }
    }

    private static LogLevel fromEnvironment() {
        return LogLevel.fromString(EnvironmentConfiguration.getGlobalConfiguration().get(Configuration.PROPERTY_AZURE_LOG_LEVEL));
    }

    public String getName() {
        return this.classPath;
    }

    public boolean isTraceEnabled() {
        return this.isTraceEnabled;
    }

    public void trace(String str) {
        logMessageWithFormat("TRACE", str, new Object[0]);
    }

    public void trace(String str, Object obj) {
        logMessageWithFormat("TRACE", str, obj);
    }

    public void trace(String str, Object obj, Object obj2) {
        logMessageWithFormat("TRACE", str, obj, obj2);
    }

    public void trace(String str, Object... objArr) {
        logMessageWithFormat("TRACE", str, objArr);
    }

    public void trace(String str, Throwable th) {
        log("TRACE", str, th);
    }

    public boolean isTraceEnabled(Marker marker) {
        return isTraceEnabled();
    }

    public void trace(Marker marker, String str) {
        trace(str);
    }

    public void trace(Marker marker, String str, Object obj) {
        trace(str, obj);
    }

    public void trace(Marker marker, String str, Object obj, Object obj2) {
        trace(str, obj, obj2);
    }

    public void trace(Marker marker, String str, Object... objArr) {
        trace(str, objArr);
    }

    public void trace(Marker marker, String str, Throwable th) {
        trace(str, th);
    }

    public boolean isDebugEnabled() {
        return this.isDebugEnabled;
    }

    public void debug(String str) {
        logMessageWithFormat(DEBUG, str, new Object[0]);
    }

    public void debug(String str, Object obj) {
        logMessageWithFormat(DEBUG, str, obj);
    }

    public void debug(String str, Object obj, Object obj2) {
        logMessageWithFormat(DEBUG, str, obj, obj2);
    }

    public void debug(String str, Object... objArr) {
        logMessageWithFormat(DEBUG, str, objArr);
    }

    public void debug(String str, Throwable th) {
        log(DEBUG, str, th);
    }

    public boolean isDebugEnabled(Marker marker) {
        return isDebugEnabled();
    }

    public void debug(Marker marker, String str) {
        debug(str);
    }

    public void debug(Marker marker, String str, Object obj) {
        debug(str, obj);
    }

    public void debug(Marker marker, String str, Object obj, Object obj2) {
        debug(str, obj, obj2);
    }

    public void debug(Marker marker, String str, Object... objArr) {
        debug(str, objArr);
    }

    public void debug(Marker marker, String str, Throwable th) {
        debug(str, th);
    }

    public boolean isInfoEnabled() {
        return this.isInfoEnabled;
    }

    public void info(String str) {
        logMessageWithFormat(INFO, str, new Object[0]);
    }

    public void info(String str, Object obj) {
        logMessageWithFormat(INFO, str, obj);
    }

    public void info(String str, Object obj, Object obj2) {
        logMessageWithFormat(INFO, str, obj, obj2);
    }

    public void info(String str, Object... objArr) {
        logMessageWithFormat(INFO, str, objArr);
    }

    public void info(String str, Throwable th) {
        log(INFO, str, th);
    }

    public boolean isInfoEnabled(Marker marker) {
        return isInfoEnabled();
    }

    public void info(Marker marker, String str) {
        info(str);
    }

    public void info(Marker marker, String str, Object obj) {
        info(str, obj);
    }

    public void info(Marker marker, String str, Object obj, Object obj2) {
        info(str, obj, obj2);
    }

    public void info(Marker marker, String str, Object... objArr) {
        info(str, objArr);
    }

    public void info(Marker marker, String str, Throwable th) {
        info(str, th);
    }

    public boolean isWarnEnabled() {
        return this.isWarnEnabled;
    }

    public void warn(String str) {
        logMessageWithFormat(WARN, str, new Object[0]);
    }

    public void warn(String str, Object obj) {
        logMessageWithFormat(WARN, str, obj);
    }

    public void warn(String str, Object obj, Object obj2) {
        logMessageWithFormat(WARN, str, obj, obj2);
    }

    public void warn(String str, Object... objArr) {
        logMessageWithFormat(WARN, str, objArr);
    }

    public void warn(String str, Throwable th) {
        log(WARN, str, th);
    }

    public boolean isWarnEnabled(Marker marker) {
        return isWarnEnabled();
    }

    public void warn(Marker marker, String str) {
        warn(str);
    }

    public void warn(Marker marker, String str, Object obj) {
        warn(str, obj);
    }

    public void warn(Marker marker, String str, Object obj, Object obj2) {
        warn(str, obj, obj2);
    }

    public void warn(Marker marker, String str, Object... objArr) {
        warn(str, objArr);
    }

    public void warn(Marker marker, String str, Throwable th) {
        warn(str, th);
    }

    public boolean isErrorEnabled() {
        return this.isErrorEnabled;
    }

    public void error(String str, Object obj) {
        logMessageWithFormat(ERROR, str, obj);
    }

    public void error(String str) {
        logMessageWithFormat(ERROR, str, new Object[0]);
    }

    public void error(String str, Object obj, Object obj2) {
        logMessageWithFormat(ERROR, str, obj, obj2);
    }

    public void error(String str, Object... objArr) {
        logMessageWithFormat(ERROR, str, objArr);
    }

    public void error(String str, Throwable th) {
        log(ERROR, str, th);
    }

    public boolean isErrorEnabled(Marker marker) {
        return isErrorEnabled();
    }

    public void error(Marker marker, String str) {
        error(str);
    }

    public void error(Marker marker, String str, Object obj) {
        error(str, obj);
    }

    public void error(Marker marker, String str, Object obj, Object obj2) {
        error(str, obj, obj2);
    }

    public void error(Marker marker, String str, Object... objArr) {
        error(str, objArr);
    }

    public void error(Marker marker, String str, Throwable th) {
        error(str, th);
    }

    private void logMessageWithFormat(String str, String str2, Object... objArr) {
        FormattingTuple formattingTupleArrayFormat = MessageFormatter.arrayFormat(str2, objArr);
        log(str, formattingTupleArrayFormat.getMessage(), formattingTupleArrayFormat.getThrowable());
    }

    private void log(String str, String str2, Throwable th) {
        String formattedDate = getFormattedDate();
        String name = Thread.currentThread().getName();
        StringBuilder sb = new StringBuilder(256);
        sb.append(formattedDate).append(OPEN_BRACKET).append(name).append("] [").append(str).append("] ").append(this.classPath).append(HYPHEN).append(str2).append(System.lineSeparator());
        writeWithThrowable(sb, th);
    }

    private static String getFormattedDate() {
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        int year = localDateTimeNow.getYear();
        int i = year / 1000;
        int i2 = year - (i * 1000);
        int i3 = i2 / 100;
        int i4 = i2 - (i3 * 100);
        int i5 = i4 / 10;
        byte[] bArr = {(byte) (i + 48), (byte) (i3 + 48), (byte) (i5 + 48), (byte) ((i4 - (i5 * 10)) + 48), 45, 0, 0, 45, 0, 0, 32, 0, 0, 58, 0, 0, 58, 0, 0, 46, (byte) (i + 48), (byte) (i + 48), (byte) ((i - (i * 10)) + 48)};
        zeroPad(localDateTimeNow.getMonthValue(), bArr, 5);
        zeroPad(localDateTimeNow.getDayOfMonth(), bArr, 8);
        zeroPad(localDateTimeNow.getHour(), bArr, 11);
        zeroPad(localDateTimeNow.getMinute(), bArr, 14);
        zeroPad(localDateTimeNow.getSecond(), bArr, 17);
        int i6 = localDateTimeNow.get(ChronoField.MILLI_OF_SECOND);
        int i7 = i6 / 100;
        int i8 = i6 - (i7 * 100);
        int i9 = i8 / 10;
        return new String(bArr, StandardCharsets.UTF_8);
    }

    void writeWithThrowable(StringBuilder sb, Throwable th) {
        if (th != null) {
            PrintWriter printWriter = new PrintWriter(new StringBuilderWriter(sb));
            try {
                th.printStackTrace(printWriter);
                printWriter.close();
            } catch (Throwable th2) {
                try {
                    printWriter.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        this.logLocation.print(sb.toString());
    }

    private static void zeroPad(int i, byte[] bArr, int i2) {
        if (i < 10) {
            bArr[i2] = 48;
            bArr[i2 + 1] = (byte) (i + 48);
        } else {
            int i3 = i / 10;
            bArr[i2] = (byte) (i3 + 48);
            bArr[i2 + 1] = (byte) ((i - (i3 * 10)) + 48);
        }
    }
}
