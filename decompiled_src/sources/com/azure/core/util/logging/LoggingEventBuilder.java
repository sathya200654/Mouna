package com.azure.core.util.logging;

import com.azure.core.implementation.AccessibleByteArrayOutputStream;
import com.azure.core.implementation.logging.LoggingUtils;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonProviders;
import com.azure.json.JsonWriter;
import com.azure.json.WriteValueCallback;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class LoggingEventBuilder {
    private List<ContextKeyValuePair> context;
    private final Map<String, Object> globalContext;
    private final boolean hasGlobalContext;
    private final boolean isEnabled;
    private final LogLevel level;
    private final Logger logger;
    private static final LoggingEventBuilder NOOP = new LoggingEventBuilder(null, null, null, false);
    private static final byte[] EMPTY_BYTES = new byte[0];

    static LoggingEventBuilder create(Logger logger, LogLevel logLevel, Map<String, Object> map, boolean z) {
        if (z) {
            return new LoggingEventBuilder(logger, logLevel, map, true);
        }
        return NOOP;
    }

    private LoggingEventBuilder(Logger logger, LogLevel logLevel, Map<String, Object> map, boolean z) {
        this.logger = logger;
        this.level = logLevel;
        this.isEnabled = z;
        this.globalContext = map;
        this.hasGlobalContext = !CoreUtils.isNullOrEmpty(map);
    }

    public LoggingEventBuilder addKeyValue(String str, String str2) {
        if (this.isEnabled) {
            addKeyValueInternal(str, str2);
        }
        return this;
    }

    public LoggingEventBuilder addKeyValue(String str, Object obj) {
        if (this.isEnabled) {
            addKeyValueInternal(str, obj);
        }
        return this;
    }

    public LoggingEventBuilder addKeyValue(String str, boolean z) {
        if (this.isEnabled) {
            addKeyValueInternal(str, Boolean.valueOf(z));
        }
        return this;
    }

    public LoggingEventBuilder addKeyValue(String str, long j) {
        if (this.isEnabled) {
            addKeyValueInternal(str, Long.valueOf(j));
        }
        return this;
    }

    public LoggingEventBuilder addKeyValue(String str, Supplier<String> supplier) {
        if (this.isEnabled) {
            if (this.context == null) {
                this.context = new ArrayList();
            }
            this.context.add(new ContextKeyValuePair(str, supplier));
        }
        return this;
    }

    public void log(String str) {
        if (this.isEnabled) {
            performLogging(this.level, getMessageWithContext(str, null), (Throwable) null);
        }
    }

    public void log(Supplier<String> supplier) {
        if (this.isEnabled) {
            performLogging(this.level, getMessageWithContext(supplier != null ? supplier.get() : null, null), (Throwable) null);
        }
    }

    public void log(Supplier<String> supplier, Throwable th) {
        if (this.isEnabled) {
            String str = supplier != null ? supplier.get() : null;
            LogLevel logLevel = this.level;
            String messageWithContext = getMessageWithContext(str, th);
            if (!this.logger.isDebugEnabled()) {
                th = null;
            }
            performLogging(logLevel, messageWithContext, th);
        }
    }

    public void log(String str, Object... objArr) {
        if (this.isEnabled) {
            performLogging(this.level, str, objArr);
        }
    }

    public Throwable log(Throwable th) {
        Objects.requireNonNull(th, "'throwable' cannot be null.");
        if (this.isEnabled) {
            performLogging(this.level, getMessageWithContext(null, th), this.logger.isDebugEnabled() ? th : null);
        }
        return th;
    }

    public RuntimeException log(RuntimeException runtimeException) {
        Objects.requireNonNull(runtimeException, "'runtimeException' cannot be null.");
        if (this.isEnabled) {
            performLogging(this.level, getMessageWithContext(null, runtimeException), this.logger.isDebugEnabled() ? runtimeException : null);
        }
        return runtimeException;
    }

    private String getMessageWithContext(String str, Throwable th) {
        if (str == null) {
            str = "";
        }
        try {
            AccessibleByteArrayOutputStream accessibleByteArrayOutputStream = new AccessibleByteArrayOutputStream();
            try {
                JsonWriter jsonWriterCreateWriter = JsonProviders.createWriter(accessibleByteArrayOutputStream);
                try {
                    jsonWriterCreateWriter.writeStartObject().writeStringField("az.sdk.message", str);
                    if (th != null) {
                        jsonWriterCreateWriter.writeNullableField("exception", th.getMessage(), new WriteValueCallback() { // from class: com.azure.core.util.logging.LoggingEventBuilder$$ExternalSyntheticLambda0
                            @Override // com.azure.json.WriteValueCallback
                            public final void write(Object obj, Object obj2) throws IOException {
                                ((JsonWriter) obj).writeString((String) obj2);
                            }
                        });
                    }
                    if (this.hasGlobalContext) {
                        for (Map.Entry<String, Object> entry : this.globalContext.entrySet()) {
                            jsonWriterCreateWriter.writeUntypedField(entry.getKey(), entry.getValue());
                        }
                    }
                    List<ContextKeyValuePair> list = this.context;
                    if (list != null) {
                        Iterator<ContextKeyValuePair> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().write(jsonWriterCreateWriter);
                        }
                    }
                    jsonWriterCreateWriter.writeEndObject().flush();
                    String string = accessibleByteArrayOutputStream.toString(StandardCharsets.UTF_8);
                    if (jsonWriterCreateWriter != null) {
                        jsonWriterCreateWriter.close();
                    }
                    accessibleByteArrayOutputStream.close();
                    return string;
                } catch (Throwable th2) {
                    if (jsonWriterCreateWriter != null) {
                        try {
                            jsonWriterCreateWriter.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                try {
                    accessibleByteArrayOutputStream.close();
                } catch (Throwable th5) {
                    th4.addSuppressed(th5);
                }
                throw th4;
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void addKeyValueInternal(String str, Object obj) {
        if (this.context == null) {
            this.context = new ArrayList();
        }
        this.context.add(new ContextKeyValuePair(str, obj));
    }

    private void performLogging(LogLevel logLevel, String str, Object... objArr) {
        Throwable th = null;
        if (LoggingUtils.doesArgsHaveThrowable(objArr)) {
            Object obj = objArr[objArr.length - 1];
            th = obj instanceof Throwable ? (Throwable) obj : null;
            if (!this.logger.isDebugEnabled()) {
                objArr = LoggingUtils.removeThrowable(objArr);
            }
        }
        FormattingTuple formattingTupleArrayFormat = MessageFormatter.arrayFormat(str, objArr);
        performLogging(logLevel, getMessageWithContext(formattingTupleArrayFormat.getMessage(), th), formattingTupleArrayFormat.getThrowable());
    }

    /* JADX INFO: renamed from: com.azure.core.util.logging.LoggingEventBuilder$1, reason: invalid class name */
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

    private void performLogging(LogLevel logLevel, String str, Throwable th) {
        int i = AnonymousClass1.$SwitchMap$com$azure$core$util$logging$LogLevel[logLevel.ordinal()];
        if (i == 1) {
            this.logger.debug(str, th);
            return;
        }
        if (i == 2) {
            this.logger.info(str, th);
        } else if (i == 3) {
            this.logger.warn(str, th);
        } else {
            if (i != 4) {
                return;
            }
            this.logger.error(str, th);
        }
    }

    private static final class ContextKeyValuePair {
        private final String key;
        private final Object value;
        private final Supplier<String> valueSupplier;

        ContextKeyValuePair(String str, Object obj) {
            this.key = str;
            this.value = obj;
            this.valueSupplier = null;
        }

        ContextKeyValuePair(String str, Supplier<String> supplier) {
            this.key = str;
            this.value = null;
            this.valueSupplier = supplier;
        }

        public void write(JsonWriter jsonWriter) throws IOException {
            String str = this.key;
            Supplier<String> supplier = this.valueSupplier;
            jsonWriter.writeUntypedField(str, supplier == null ? this.value : supplier.get());
        }
    }
}
