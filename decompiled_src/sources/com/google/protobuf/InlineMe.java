package com.google.protobuf;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Documented
@interface InlineMe {
    String[] imports() default {};

    String replacement();

    String[] staticImports() default {};
}
