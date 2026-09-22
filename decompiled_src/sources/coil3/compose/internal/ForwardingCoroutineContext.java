package coil3.compose.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ForwardingCoroutineContext.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b!\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H&J\u0014\u0010\b\u001a\u00020\u00012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J\u0011\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0096\u0002J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J<\u0010\u0015\u001a\u0002H\u0016\"\n\b\u0000\u0010\u0016*\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u0002H\u00162\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u0002H\u00160\u0019H\u0096\u0001¢\u0006\u0002\u0010\u001bJ(\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u001a2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u001d0\nH\u0096\u0003¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcoil3/compose/internal/ForwardingCoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "delegate", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "newContext", "old", "new", "minusKey", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "plus", "context", "equals", "", "other", "", "hashCode", "", "toString", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ForwardingCoroutineContext implements CoroutineContext {
    public static final int $stable = 8;
    private final CoroutineContext delegate;

    public <R> R fold(R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        return (R) this.delegate.fold(initial, operation);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) this.delegate.get(key);
    }

    public abstract ForwardingCoroutineContext newContext(CoroutineContext old, CoroutineContext coroutineContext);

    public ForwardingCoroutineContext(CoroutineContext coroutineContext) {
        this.delegate = coroutineContext;
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return newContext(this, this.delegate.minusKey(key));
    }

    public CoroutineContext plus(CoroutineContext context) {
        return newContext(this, this.delegate.plus(context));
    }

    public boolean equals(Object other) {
        return Intrinsics.areEqual(this.delegate, other);
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public String toString() {
        return "ForwardingCoroutineContext(delegate=" + this.delegate + ")";
    }
}
