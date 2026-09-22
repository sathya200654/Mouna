package com.azure.core.util.logging;

import com.azure.core.implementation.accesshelpers.ClientLoggerAccessHelper;
import com.azure.core.implementation.logging.DefaultLogger;
import com.azure.core.implementation.logging.LoggingUtils;
import com.azure.core.util.CoreUtils;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLogger;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class ClientLogger {
    private final Map<String, Object> globalContext;
    private final boolean hasGlobalContext;
    private final Logger logger;

    static {
        ClientLoggerAccessHelper.setAccessor(new ClientLoggerAccessHelper.ClientLoggerAccessor() { // from class: com.azure.core.util.logging.ClientLogger$$ExternalSyntheticLambda0
            @Override // com.azure.core.implementation.accesshelpers.ClientLoggerAccessHelper.ClientLoggerAccessor
            public final ClientLogger createClientLogger(Logger logger, Map map) {
                return new ClientLogger(logger, (Map<String, Object>) map);
            }
        });
    }

    public ClientLogger(Class<?> cls) {
        this(cls.getName());
    }

    public ClientLogger(String str) {
        this(str, (Map<String, Object>) Collections.emptyMap());
    }

    public ClientLogger(Class<?> cls, Map<String, Object> map) {
        this(cls.getName(), map);
    }

    public ClientLogger(String str, Map<String, Object> map) {
        this(getLogger(str), map);
    }

    private static Logger getLogger(String str) {
        Logger logger = LoggerFactory.getLogger(str);
        return logger instanceof NOPLogger ? new DefaultLogger(str) : logger;
    }

    ClientLogger(Logger logger, Map<String, Object> map) {
        this.logger = logger;
        Map<String, Object> mapUnmodifiableMap = map == null ? null : Collections.unmodifiableMap(map);
        this.globalContext = mapUnmodifiableMap;
        this.hasGlobalContext = !CoreUtils.isNullOrEmpty(mapUnmodifiableMap);
    }

    public void log(LogLevel logLevel, Supplier<String> supplier) {
        log(logLevel, supplier, null);
    }

    public void log(LogLevel logLevel, Supplier<String> supplier, Throwable th) {
        if (supplier == null || !canLogAtLevel(logLevel)) {
            return;
        }
        performDeferredLogging(logLevel, supplier, th);
    }

    public void verbose(String str) {
        if (this.logger.isDebugEnabled()) {
            if (this.hasGlobalContext) {
                atVerbose().log(str);
            } else {
                this.logger.debug(LoggingUtils.removeNewLinesFromLogMessage(str));
            }
        }
    }

    public void verbose(String str, Object... objArr) {
        if (this.logger.isDebugEnabled()) {
            performLogging(LogLevel.VERBOSE, false, str, objArr);
        }
    }

    public void info(String str) {
        if (this.logger.isInfoEnabled()) {
            if (this.hasGlobalContext) {
                atInfo().log(str);
            } else {
                this.logger.info(LoggingUtils.removeNewLinesFromLogMessage(str));
            }
        }
    }

    public void info(String str, Object... objArr) {
        if (this.logger.isInfoEnabled()) {
            performLogging(LogLevel.INFORMATIONAL, false, str, objArr);
        }
    }

    public void warning(String str) {
        if (this.logger.isWarnEnabled()) {
            if (this.hasGlobalContext) {
                atWarning().log(str);
            } else {
                this.logger.warn(LoggingUtils.removeNewLinesFromLogMessage(str));
            }
        }
    }

    public void warning(String str, Object... objArr) {
        if (this.logger.isWarnEnabled()) {
            performLogging(LogLevel.WARNING, false, str, objArr);
        }
    }

    public void error(String str) {
        if (this.logger.isErrorEnabled()) {
            if (this.hasGlobalContext) {
                atError().log(str);
            } else {
                this.logger.error(LoggingUtils.removeNewLinesFromLogMessage(str));
            }
        }
    }

    public void error(String str, Object... objArr) {
        if (this.logger.isErrorEnabled()) {
            performLogging(LogLevel.ERROR, false, str, objArr);
        }
    }

    public RuntimeException logExceptionAsWarning(RuntimeException runtimeException) {
        Objects.requireNonNull(runtimeException, "'runtimeException' cannot be null.");
        return (RuntimeException) logThrowableAsWarning(runtimeException);
    }

    @Deprecated
    public <T extends Throwable> T logThowableAsWarning(T t) {
        Objects.requireNonNull(t, "'throwable' cannot be null.");
        if (!this.logger.isWarnEnabled()) {
            return t;
        }
        performLogging(LogLevel.WARNING, true, t.getMessage(), t);
        return t;
    }

    public <T extends Throwable> T logThrowableAsWarning(T t) {
        Objects.requireNonNull(t, "'throwable' cannot be null.");
        if (this.logger.isWarnEnabled()) {
            performLogging(LogLevel.WARNING, true, t.getMessage(), t);
        }
        return t;
    }

    public RuntimeException logExceptionAsError(RuntimeException runtimeException) {
        Objects.requireNonNull(runtimeException, "'runtimeException' cannot be null.");
        return (RuntimeException) logThrowableAsError(runtimeException);
    }

    public <T extends Throwable> T logThrowableAsError(T t) {
        Objects.requireNonNull(t, "'throwable' cannot be null.");
        if (!this.logger.isErrorEnabled()) {
            return t;
        }
        performLogging(LogLevel.ERROR, true, t.getMessage(), t);
        return t;
    }

    private void performLogging(LogLevel logLevel, boolean z, String str, Object... objArr) {
        if (this.hasGlobalContext) {
            LoggingEventBuilder.create(this.logger, logLevel, this.globalContext, true).log(str, objArr);
            return;
        }
        String message = "";
        if (LoggingUtils.doesArgsHaveThrowable(objArr)) {
            if (!z) {
                Object obj = objArr[objArr.length - 1];
                if (obj instanceof Throwable) {
                    message = ((Throwable) obj).getMessage();
                }
            }
            if (!this.logger.isDebugEnabled()) {
                objArr = LoggingUtils.removeThrowable(objArr);
            }
        }
        String strRemoveNewLinesFromLogMessage = LoggingUtils.removeNewLinesFromLogMessage(str);
        int i = AnonymousClass1.$SwitchMap$com$azure$core$util$logging$LogLevel[logLevel.ordinal()];
        if (i == 1) {
            this.logger.debug(strRemoveNewLinesFromLogMessage, objArr);
            return;
        }
        if (i == 2) {
            this.logger.info(strRemoveNewLinesFromLogMessage, objArr);
            return;
        }
        if (i == 3) {
            if (!CoreUtils.isNullOrEmpty(message)) {
                strRemoveNewLinesFromLogMessage = strRemoveNewLinesFromLogMessage + System.lineSeparator() + message;
            }
            this.logger.warn(strRemoveNewLinesFromLogMessage, objArr);
        } else {
            if (i != 4) {
                return;
            }
            if (!CoreUtils.isNullOrEmpty(message)) {
                strRemoveNewLinesFromLogMessage = strRemoveNewLinesFromLogMessage + System.lineSeparator() + message;
            }
            this.logger.error(strRemoveNewLinesFromLogMessage, objArr);
        }
    }

    /* JADX INFO: renamed from: com.azure.core.util.logging.ClientLogger$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$azure$core$util$logging$LogLevel;

        static {
            int[] iArr = new int[LogLevel.values().length];
            $SwitchMap$com$azure$core$util$logging$LogLevel = iArr;
            try {
                iArr[LogLevel.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$azure$core$util$logging$LogLevel[LogLevel.INFORMATIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$azure$core$util$logging$LogLevel[LogLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$azure$core$util$logging$LogLevel[LogLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void performDeferredLogging(LogLevel logLevel, Supplier<String> supplier, Throwable th) {
        if (this.hasGlobalContext) {
            LoggingEventBuilder.create(this.logger, logLevel, this.globalContext, true).log(supplier, th);
            return;
        }
        String strRemoveNewLinesFromLogMessage = LoggingUtils.removeNewLinesFromLogMessage(supplier.get());
        String message = th != null ? th.getMessage() : "";
        int i = AnonymousClass1.$SwitchMap$com$azure$core$util$logging$LogLevel[logLevel.ordinal()];
        if (i == 1) {
            if (th != null) {
                this.logger.debug(strRemoveNewLinesFromLogMessage, th);
                return;
            } else {
                this.logger.debug(strRemoveNewLinesFromLogMessage);
                return;
            }
        }
        if (i == 2) {
            this.logger.info(strRemoveNewLinesFromLogMessage);
            return;
        }
        if (i == 3) {
            if (!CoreUtils.isNullOrEmpty(message)) {
                strRemoveNewLinesFromLogMessage = strRemoveNewLinesFromLogMessage + System.lineSeparator() + message;
            }
            this.logger.warn(strRemoveNewLinesFromLogMessage);
        } else {
            if (i != 4) {
                return;
            }
            if (!CoreUtils.isNullOrEmpty(message)) {
                strRemoveNewLinesFromLogMessage = strRemoveNewLinesFromLogMessage + System.lineSeparator() + message;
            }
            this.logger.error(strRemoveNewLinesFromLogMessage);
        }
    }

    Object[] evaluateSupplierArgument(Object[] objArr) {
        if (isSupplierLogging(objArr)) {
            objArr[0] = ((Supplier) objArr[0]).get();
        }
        return objArr;
    }

    boolean isSupplierLogging(Object[] objArr) {
        if (objArr.length != 1 || !(objArr[0] instanceof Supplier)) {
            if (objArr.length == 2 && (objArr[0] instanceof Supplier)) {
                Object obj = objArr[1];
                if ((obj instanceof Throwable) || obj == null) {
                }
            }
            return false;
        }
        return true;
    }

    public boolean canLogAtLevel(LogLevel logLevel) {
        if (logLevel == null) {
            return false;
        }
        int i = AnonymousClass1.$SwitchMap$com$azure$core$util$logging$LogLevel[logLevel.ordinal()];
        if (i == 1) {
            return this.logger.isDebugEnabled();
        }
        if (i == 2) {
            return this.logger.isInfoEnabled();
        }
        if (i == 3) {
            return this.logger.isWarnEnabled();
        }
        if (i != 4) {
            return false;
        }
        return this.logger.isErrorEnabled();
    }

    public LoggingEventBuilder atError() {
        return LoggingEventBuilder.create(this.logger, LogLevel.ERROR, this.globalContext, canLogAtLevel(LogLevel.ERROR));
    }

    public LoggingEventBuilder atWarning() {
        return LoggingEventBuilder.create(this.logger, LogLevel.WARNING, this.globalContext, canLogAtLevel(LogLevel.WARNING));
    }

    public LoggingEventBuilder atInfo() {
        return LoggingEventBuilder.create(this.logger, LogLevel.INFORMATIONAL, this.globalContext, canLogAtLevel(LogLevel.INFORMATIONAL));
    }

    public LoggingEventBuilder atVerbose() {
        return LoggingEventBuilder.create(this.logger, LogLevel.VERBOSE, this.globalContext, canLogAtLevel(LogLevel.VERBOSE));
    }

    public LoggingEventBuilder atLevel(LogLevel logLevel) {
        return LoggingEventBuilder.create(this.logger, logLevel, this.globalContext, canLogAtLevel(logLevel));
    }
}
