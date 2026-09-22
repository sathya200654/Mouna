package com.azure.core.implementation;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface ReflectiveInvoker {
    int getParameterCount();

    Object invokeStatic(Object... objArr) throws Exception;

    Object invokeWithArguments(Object obj, Object... objArr) throws Exception;
}
