package coil3.compose.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: compiled from: DeferredDispatch.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcoil3/compose/internal/DeferredDispatchCoroutineContext;", "Lcoil3/compose/internal/ForwardingCoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "newContext", "old", "new", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class DeferredDispatchCoroutineContext extends ForwardingCoroutineContext {
    public DeferredDispatchCoroutineContext(CoroutineContext coroutineContext) {
        super(coroutineContext);
    }

    @Override // coil3.compose.internal.ForwardingCoroutineContext
    public ForwardingCoroutineContext newContext(CoroutineContext old, CoroutineContext coroutineContext) {
        CoroutineDispatcher dispatcher = UtilsKt.getDispatcher(old);
        CoroutineDispatcher dispatcher2 = UtilsKt.getDispatcher(coroutineContext);
        if ((dispatcher instanceof DeferredDispatchCoroutineDispatcher) && !Intrinsics.areEqual(dispatcher, dispatcher2)) {
            ((DeferredDispatchCoroutineDispatcher) dispatcher).setUnconfined(false);
        }
        return new DeferredDispatchCoroutineContext(coroutineContext);
    }
}
