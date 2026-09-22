package androidx.versionedparcelable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface ParcelField {
    String defaultValue() default "";

    int value();
}
