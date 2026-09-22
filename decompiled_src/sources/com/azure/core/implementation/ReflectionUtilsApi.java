package com.azure.core.implementation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
interface ReflectionUtilsApi {
    ReflectiveInvoker getConstructorInvoker(Class<?> cls, Constructor<?> constructor, boolean z) throws Exception;

    ReflectiveInvoker getMethodInvoker(Class<?> cls, Method method, boolean z) throws Exception;

    boolean isModuleBased();
}
