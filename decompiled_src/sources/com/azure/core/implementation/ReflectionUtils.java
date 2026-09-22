package com.azure.core.implementation;

import com.azure.core.util.logging.ClientLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class ReflectionUtils {
    private static final ReflectionUtilsApi INSTANCE;
    private static final ClientLogger LOGGER;

    static {
        ReflectionUtilsApi reflectionUtilsClassic;
        ClientLogger clientLogger = new ClientLogger((Class<?>) ReflectionUtils.class);
        LOGGER = clientLogger;
        try {
            clientLogger.verbose("Attempting to use java.lang.invoke package to handle reflection.");
            reflectionUtilsClassic = new ReflectionUtilsMethodHandle();
            clientLogger.verbose("Successfully used java.lang.invoke package to handle reflection.");
        } catch (LinkageError unused) {
            ClientLogger clientLogger2 = LOGGER;
            clientLogger2.verbose("Failed to use java.lang.invoke package to handle reflection. Falling back to java.lang.reflect package to handle reflection.");
            reflectionUtilsClassic = new ReflectionUtilsClassic();
            clientLogger2.verbose("Successfully used java.lang.reflect package to handle reflection.");
        }
        INSTANCE = reflectionUtilsClassic;
    }

    public static ReflectiveInvoker getMethodInvoker(Class<?> cls, Method method) throws Exception {
        return getMethodInvoker(cls, method, true);
    }

    public static ReflectiveInvoker getMethodInvoker(Class<?> cls, Method method, boolean z) throws Exception {
        if (method == null) {
            throw LOGGER.logExceptionAsError(new NullPointerException("'method' cannot be null."));
        }
        if (cls == null) {
            cls = method.getDeclaringClass();
        }
        return INSTANCE.getMethodInvoker(cls, method, z);
    }

    public static ReflectiveInvoker getConstructorInvoker(Class<?> cls, Constructor<?> constructor) throws Exception {
        return getConstructorInvoker(cls, constructor, true);
    }

    public static ReflectiveInvoker getConstructorInvoker(Class<?> cls, Constructor<?> constructor, boolean z) throws Exception {
        if (constructor == null) {
            throw LOGGER.logExceptionAsError(new NullPointerException("'constructor' cannot be null."));
        }
        if (cls == null) {
            cls = constructor.getDeclaringClass();
        }
        return INSTANCE.getConstructorInvoker(cls, constructor, z);
    }

    public static boolean isModuleBased() {
        return INSTANCE.isModuleBased();
    }

    public static ReflectiveInvoker createNoOpInvoker() {
        return new NoOpReflectiveInvoker();
    }

    private static final class NoOpReflectiveInvoker implements ReflectiveInvoker {
        @Override // com.azure.core.implementation.ReflectiveInvoker
        public int getParameterCount() {
            return 0;
        }

        @Override // com.azure.core.implementation.ReflectiveInvoker
        public Object invokeStatic(Object... objArr) {
            return null;
        }

        @Override // com.azure.core.implementation.ReflectiveInvoker
        public Object invokeWithArguments(Object obj, Object... objArr) {
            return null;
        }

        private NoOpReflectiveInvoker() {
        }
    }

    ReflectionUtils() {
    }
}
