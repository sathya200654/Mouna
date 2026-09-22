package com.google.firebase.perf.metrics;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Retention(RetentionPolicy.CLASS)
public @interface AddTrace {
    boolean enabled() default true;

    String name();
}
