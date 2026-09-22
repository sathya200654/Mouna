package com.azure.core.implementation.http;

import com.azure.core.exception.HttpResponseException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class UnexpectedExceptionInformation {
    private static final String EXCEPTION_BODY_METHOD = "getValue";
    private final Class<?> exceptionBodyType;
    private final Class<? extends HttpResponseException> exceptionType;

    public UnexpectedExceptionInformation(Class<? extends HttpResponseException> cls) {
        this.exceptionType = cls;
        Class<?> returnType = Object.class;
        try {
            returnType = cls.getDeclaredMethod(EXCEPTION_BODY_METHOD, new Class[0]).getReturnType();
        } catch (NoSuchMethodException unused) {
        }
        this.exceptionBodyType = returnType;
    }

    public Class<? extends HttpResponseException> getExceptionType() {
        return this.exceptionType;
    }

    public Class<?> getExceptionBodyType() {
        return this.exceptionBodyType;
    }
}
