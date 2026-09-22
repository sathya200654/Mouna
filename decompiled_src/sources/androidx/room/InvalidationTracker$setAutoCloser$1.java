package androidx.room;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: InvalidationTracker.android.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class InvalidationTracker$setAutoCloser$1 extends FunctionReferenceImpl implements Function0<Unit> {
    InvalidationTracker$setAutoCloser$1(Object obj) {
        super(0, obj, InvalidationTracker.class, "onAutoCloseCallback", "onAutoCloseCallback()V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m4invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m4invoke() {
        ((InvalidationTracker) this.receiver).onAutoCloseCallback();
    }
}
