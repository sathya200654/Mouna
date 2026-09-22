package androidx.wear.compose.foundation;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HierarchicalFocusCoordinator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.foundation.HierarchicalFocusCoordinatorKt$FocusComposableImpl$2$1", f = "HierarchicalFocusCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HierarchicalFocusCoordinatorKt$FocusComposableImpl$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusNode $node;
    final /* synthetic */ Function2<CoroutineScope, Boolean, Unit> $onFocusChanged;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HierarchicalFocusCoordinatorKt$FocusComposableImpl$2$1(FocusNode focusNode, Function2<? super CoroutineScope, ? super Boolean, Unit> function2, Continuation<? super HierarchicalFocusCoordinatorKt$FocusComposableImpl$2$1> continuation) {
        super(2, continuation);
        this.$node = focusNode;
        this.$onFocusChanged = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> hierarchicalFocusCoordinatorKt$FocusComposableImpl$2$1 = new HierarchicalFocusCoordinatorKt$FocusComposableImpl$2$1(this.$node, this.$onFocusChanged, continuation);
        hierarchicalFocusCoordinatorKt$FocusComposableImpl$2$1.L$0 = obj;
        return hierarchicalFocusCoordinatorKt$FocusComposableImpl$2$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        if (this.$node.getChildren().isEmpty()) {
            this.$onFocusChanged.invoke(coroutineScope, this.$node.getFocused().getValue());
        }
        return Unit.INSTANCE;
    }
}
