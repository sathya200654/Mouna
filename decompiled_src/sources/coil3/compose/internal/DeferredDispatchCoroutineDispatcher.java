package coil3.compose.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: DeferredDispatch.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0016J\u001c\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0017J\b\u0010\u001f\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\u0005\u001a\u00020\u0006X\u0082\u0004R%\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcoil3/compose/internal/DeferredDispatchCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "delegate", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "_unconfined", "Lkotlinx/atomicfu/AtomicBoolean;", "<set-?>", "", "unconfined", "getUnconfined", "()Z", "setUnconfined", "(Z)V", "currentDispatcher", "getCurrentDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "isDispatchNeeded", "context", "Lkotlin/coroutines/CoroutineContext;", "limitedParallelism", "parallelism", "", "name", "", "dispatch", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "toString", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class DeferredDispatchCoroutineDispatcher extends CoroutineDispatcher {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _unconfined$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(DeferredDispatchCoroutineDispatcher.class, "_unconfined$volatile");
    private volatile /* synthetic */ int _unconfined$volatile = 1;
    private final CoroutineDispatcher delegate;

    private final /* synthetic */ int get_unconfined$volatile() {
        return this._unconfined$volatile;
    }

    private final /* synthetic */ void set_unconfined$volatile(int i) {
        this._unconfined$volatile = i;
    }

    public DeferredDispatchCoroutineDispatcher(CoroutineDispatcher coroutineDispatcher) {
        this.delegate = coroutineDispatcher;
    }

    public final boolean getUnconfined() {
        return this._unconfined$volatile == 1;
    }

    public final void setUnconfined(boolean z) {
        this._unconfined$volatile = z ? 1 : 0;
    }

    private final CoroutineDispatcher getCurrentDispatcher() {
        return _unconfined$volatile$FU.get(this) == 1 ? Dispatchers.getUnconfined() : this.delegate;
    }

    public boolean isDispatchNeeded(CoroutineContext context) {
        return getCurrentDispatcher().isDispatchNeeded(context);
    }

    public CoroutineDispatcher limitedParallelism(int parallelism, String name) {
        return getCurrentDispatcher().limitedParallelism(parallelism, name);
    }

    public void dispatch(CoroutineContext context, Runnable block) {
        getCurrentDispatcher().dispatch(context, block);
    }

    public void dispatchYield(CoroutineContext context, Runnable block) {
        getCurrentDispatcher().dispatchYield(context, block);
    }

    public String toString() {
        return "DeferredDispatchCoroutineDispatcher(delegate=" + this.delegate + ")";
    }
}
