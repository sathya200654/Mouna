package com.bumptech.glide.annotation.compiler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
@interface Index {
    String[] extensions() default {};

    String[] modules() default {};
}
