package com.google.firebase.inappmessaging.display.dagger.multibindings;

import com.google.firebase.inappmessaging.display.dagger.MapKey;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@MapKey
public @interface StringKey {
    String value();
}
