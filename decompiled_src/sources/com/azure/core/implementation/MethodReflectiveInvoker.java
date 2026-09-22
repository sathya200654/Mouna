package com.azure.core.implementation;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class MethodReflectiveInvoker implements ReflectiveInvoker {
    private final Method method;

    MethodReflectiveInvoker(Method method) {
        this.method = method;
    }

    @Override // com.azure.core.implementation.ReflectiveInvoker
    public Object invokeStatic(Object... objArr) throws Exception {
        return this.method.invoke(null, objArr);
    }

    @Override // com.azure.core.implementation.ReflectiveInvoker
    public Object invokeWithArguments(Object obj, Object... objArr) throws Exception {
        return this.method.invoke(obj, objArr);
    }

    @Override // com.azure.core.implementation.ReflectiveInvoker
    public int getParameterCount() {
        return this.method.getParameterCount();
    }
}
