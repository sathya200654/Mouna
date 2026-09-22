package dagger.hilt.android.lifecycle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Qualifier
@Retention(RetentionPolicy.CLASS)
public @interface ActivityRetainedSavedState {
}
