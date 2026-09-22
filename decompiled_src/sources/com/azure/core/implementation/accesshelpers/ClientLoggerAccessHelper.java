package com.azure.core.implementation.accesshelpers;

import com.azure.core.util.logging.ClientLogger;
import java.util.Map;
import org.slf4j.Logger;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ClientLoggerAccessHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static ClientLoggerAccessor accessor;

    public interface ClientLoggerAccessor {
        ClientLogger createClientLogger(Logger logger, Map<String, Object> map);
    }

    public static void setAccessor(ClientLoggerAccessor clientLoggerAccessor) {
        accessor = clientLoggerAccessor;
    }

    public static ClientLogger createClientLogger(Logger logger, Map<String, Object> map) {
        if (accessor == null) {
            new ClientLogger((Class<?>) ClientLoggerAccessHelper.class);
        }
        return accessor.createClientLogger(logger, map);
    }

    private ClientLoggerAccessHelper() {
    }
}
