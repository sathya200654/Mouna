package com.azure.core.implementation;

import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class ConstructorReflectiveInvoker implements ReflectiveInvoker {
    private final Constructor<?> constructor;

    ConstructorReflectiveInvoker(Constructor<?> constructor) {
        this.constructor = constructor;
    }

    @Override // com.azure.core.implementation.ReflectiveInvoker
    public Object invokeStatic(Object... objArr) throws Exception {
        return this.constructor.newInstance(objArr);
    }

    @Override // com.azure.core.implementation.ReflectiveInvoker
    public Object invokeWithArguments(Object obj, Object... objArr) throws Exception {
        return this.constructor.newInstance(MethodHandleReflectiveInvoker.createFinalArgs(objArr, new Object[0]));
    }

    @Override // com.azure.core.implementation.ReflectiveInvoker
    public int getParameterCount() {
        return this.constructor.getParameterCount();
    }
}
