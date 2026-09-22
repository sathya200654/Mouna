package com.azure.core.implementation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class ReflectionUtilsClassic implements ReflectionUtilsApi {
    @Override // com.azure.core.implementation.ReflectionUtilsApi
    public boolean isModuleBased() {
        return false;
    }

    ReflectionUtilsClassic() {
    }

    @Override // com.azure.core.implementation.ReflectionUtilsApi
    public ReflectiveInvoker getMethodInvoker(Class<?> cls, Method method, boolean z) {
        return new MethodReflectiveInvoker(method);
    }

    @Override // com.azure.core.implementation.ReflectionUtilsApi
    public ReflectiveInvoker getConstructorInvoker(Class<?> cls, Constructor<?> constructor, boolean z) {
        return new ConstructorReflectiveInvoker(constructor);
    }
}
