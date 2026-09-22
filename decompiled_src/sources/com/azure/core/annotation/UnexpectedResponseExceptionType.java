package com.azure.core.annotation;

import com.azure.core.exception.HttpResponseException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Target({ElementType.METHOD})
@Repeatable(UnexpectedResponseExceptionTypes.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnexpectedResponseExceptionType {
    int[] code() default {};

    Class<? extends HttpResponseException> value();
}
