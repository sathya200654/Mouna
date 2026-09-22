package com.google.j2objc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Target({ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
public @interface LoopTranslation {

    public enum LoopStyle {
        JAVA_ITERATOR,
        FAST_ENUMERATION
    }

    LoopStyle value();
}
