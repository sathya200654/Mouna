package com.azure.core.implementation.http.rest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class MissingRequiredAnnotationException extends RuntimeException {
    public MissingRequiredAnnotationException(Class<? extends Annotation> cls, Class<?> cls2) {
        super("A " + getAnnotationName(cls) + " annotation must be defined on " + cls2.getName() + ".");
    }

    public MissingRequiredAnnotationException(List<Class<? extends Annotation>> list, Method method) {
        super("Either " + optionsToString(list) + " annotation must be defined on the method " + methodFullName(method) + ".");
    }

    private static String getAnnotationName(Class<? extends Annotation> cls) {
        return cls.getSimpleName();
    }

    private static String optionsToString(List<Class<? extends Annotation>> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (1 <= i) {
                sb.append(", ");
            }
            if (i == size - 1) {
                sb.append("or ");
            }
            sb.append(getAnnotationName(list.get(i)));
        }
        return sb.toString();
    }

    private static String methodFullName(Method method) {
        return method.getDeclaringClass().getName() + "." + method.getName() + "()";
    }
}
