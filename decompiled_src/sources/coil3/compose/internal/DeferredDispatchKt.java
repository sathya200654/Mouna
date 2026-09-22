package coil3.compose.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: DeferredDispatch.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00022'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b\bH\u0000¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"launchWithDeferredDispatch", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "coil-compose-core_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeferredDispatchKt {
    public static final Job launchWithDeferredDispatch(CoroutineScope coroutineScope, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        CoroutineDispatcher dispatcher = UtilsKt.getDispatcher(coroutineScope.getCoroutineContext());
        if (dispatcher == null || Intrinsics.areEqual(dispatcher, Dispatchers.getUnconfined())) {
            return BuildersKt.launch(coroutineScope, Dispatchers.getUnconfined(), CoroutineStart.UNDISPATCHED, function2);
        }
        return BuildersKt.launch(CoroutineScopeKt.CoroutineScope(new DeferredDispatchCoroutineContext(coroutineScope.getCoroutineContext())), new DeferredDispatchCoroutineDispatcher(dispatcher), CoroutineStart.UNDISPATCHED, function2);
    }
}
