package com.azure.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface HeaderCollection {
    String value();
}
