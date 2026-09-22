package com.azure.core.implementation;

import com.azure.core.util.logging.ClientLogger;
import java.lang.invoke.MethodHandle;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class MethodHandleReflectiveInvoker implements ReflectiveInvoker {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) MethodHandleReflectiveInvoker.class);
    private static final Object[] NO_ARGS = new Object[0];
    private final MethodHandle methodHandle;

    MethodHandleReflectiveInvoker(MethodHandle methodHandle) {
        this.methodHandle = methodHandle;
    }

    @Override // com.azure.core.implementation.ReflectiveInvoker
    public Object invokeStatic(Object... objArr) throws Exception {
        try {
            return this.methodHandle.invokeWithArguments(objArr);
        } catch (Throwable th) {
            if (th instanceof Error) {
                throw ((Error) LOGGER.logThrowableAsError((Error) th));
            }
            throw ((Exception) LOGGER.logThrowableAsError((Exception) th));
        }
    }

    @Override // com.azure.core.implementation.ReflectiveInvoker
    public Object invokeWithArguments(Object obj, Object... objArr) throws Exception {
        try {
            return this.methodHandle.invokeWithArguments(createFinalArgs(obj, objArr));
        } catch (Throwable th) {
            if (th instanceof Error) {
                throw ((Error) LOGGER.logThrowableAsError((Error) th));
            }
            throw ((Exception) LOGGER.logThrowableAsError((Exception) th));
        }
    }

    @Override // com.azure.core.implementation.ReflectiveInvoker
    public int getParameterCount() {
        return this.methodHandle.type().parameterCount();
    }

    static Object[] createFinalArgs(Object obj, Object... objArr) {
        if (obj == null && (objArr == null || objArr.length == 0)) {
            return NO_ARGS;
        }
        if (objArr == null || objArr.length == 0) {
            return new Object[]{obj};
        }
        Object[] objArr2 = new Object[objArr.length + 1];
        objArr2[0] = obj;
        System.arraycopy(objArr, 0, objArr2, 1, objArr.length);
        return objArr2;
    }
}
