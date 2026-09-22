package androidx.room;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InvalidationTracker.android.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class InvalidationTracker$implementation$1 extends FunctionReferenceImpl implements Function1<Set<? extends Integer>, Unit> {
    InvalidationTracker$implementation$1(Object obj) {
        super(1, obj, InvalidationTracker.class, "notifyInvalidatedObservers", "notifyInvalidatedObservers(Ljava/util/Set;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Set<Integer>) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Set<Integer> set) {
        Intrinsics.checkNotNullParameter(set, "p0");
        ((InvalidationTracker) this.receiver).notifyInvalidatedObservers(set);
    }
}
