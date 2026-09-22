package androidx.webkit;

import java.lang.Throwable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface OutcomeReceiverCompat<T, E extends Throwable> {
    default void onError(E e) {
    }

    void onResult(T t);
}
