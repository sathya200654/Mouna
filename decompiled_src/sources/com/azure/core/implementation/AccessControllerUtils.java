package com.azure.core.implementation;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AccessControllerUtils {
    private static final boolean CAN_BE_USED;

    static {
        boolean z;
        ClassLoader classLoader = AccessControllerUtils.class.getClassLoader();
        try {
            z = true;
            Class.forName("java.security.AccessController", true, classLoader);
            Class.forName("java.security.PrivilegedAction", true, classLoader);
            Class.forName("java.security.PrivilegedExceptionAction", true, classLoader);
        } catch (LinkageError | ReflectiveOperationException unused) {
            z = false;
        }
        CAN_BE_USED = z;
    }

    public static <T> T doPrivileged(final Supplier<T> supplier) {
        if (!CAN_BE_USED) {
            return supplier.get();
        }
        Objects.requireNonNull(supplier);
        return (T) AccessController.doPrivileged(new PrivilegedAction() { // from class: com.azure.core.implementation.AccessControllerUtils$$ExternalSyntheticLambda0
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return supplier.get();
            }
        });
    }

    public static <T> T doPrivilegedException(final Callable<T> callable) throws Exception {
        if (!CAN_BE_USED) {
            return callable.call();
        }
        Objects.requireNonNull(callable);
        return (T) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: com.azure.core.implementation.AccessControllerUtils$$ExternalSyntheticLambda1
            @Override // java.security.PrivilegedExceptionAction
            public final Object run() {
                return callable.call();
            }
        });
    }

    private AccessControllerUtils() {
    }
}
