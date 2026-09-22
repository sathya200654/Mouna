package androidx.wear.compose.foundation;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: BasicSwipeToDismissBox.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.foundation.BasicSwipeToDismissBoxKt$edgeSwipeToDismiss$2$nestedPointerInput$1$1", f = "BasicSwipeToDismissBox.kt", i = {}, l = {513}, m = "invokeSuspend", n = {}, s = {})
final class BasicSwipeToDismissBoxKt$edgeSwipeToDismiss$2$nestedPointerInput$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<EdgeSwipeState> $edgeSwipeState;
    final /* synthetic */ float $edgeWidth;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasicSwipeToDismissBoxKt$edgeSwipeToDismiss$2$nestedPointerInput$1$1(MutableState<EdgeSwipeState> mutableState, float f, Continuation<? super BasicSwipeToDismissBoxKt$edgeSwipeToDismiss$2$nestedPointerInput$1$1> continuation) {
        super(2, continuation);
        this.$edgeSwipeState = mutableState;
        this.$edgeWidth = f;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> basicSwipeToDismissBoxKt$edgeSwipeToDismiss$2$nestedPointerInput$1$1 = new BasicSwipeToDismissBoxKt$edgeSwipeToDismiss$2$nestedPointerInput$1$1(this.$edgeSwipeState, this.$edgeWidth, continuation);
        basicSwipeToDismissBoxKt$edgeSwipeToDismiss$2$nestedPointerInput$1$1.L$0 = obj;
        return basicSwipeToDismissBoxKt$edgeSwipeToDismiss$2$nestedPointerInput$1$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return create(pointerInputScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.BasicSwipeToDismissBoxKt$edgeSwipeToDismiss$2$nestedPointerInput$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: BasicSwipeToDismissBox.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.BasicSwipeToDismissBoxKt$edgeSwipeToDismiss$2$nestedPointerInput$1$1$1", f = "BasicSwipeToDismissBox.kt", i = {}, l = {514}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $$this$null;
        final /* synthetic */ MutableState<EdgeSwipeState> $edgeSwipeState;
        final /* synthetic */ float $edgeWidth;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PointerInputScope pointerInputScope, MutableState<EdgeSwipeState> mutableState, float f, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$null = pointerInputScope;
            this.$edgeSwipeState = mutableState;
            this.$edgeWidth = f;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$$this$null, this.$edgeSwipeState, this.$edgeWidth, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.wear.compose.foundation.BasicSwipeToDismissBoxKt$edgeSwipeToDismiss$2$nestedPointerInput$1$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BasicSwipeToDismissBox.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.wear.compose.foundation.BasicSwipeToDismissBoxKt$edgeSwipeToDismiss$2$nestedPointerInput$1$1$1$1", f = "BasicSwipeToDismissBox.kt", i = {0}, l = {516}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
        static final class C00051 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ MutableState<EdgeSwipeState> $edgeSwipeState;
            final /* synthetic */ float $edgeWidth;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.wear.compose.foundation.BasicSwipeToDismissBoxKt$edgeSwipeToDismiss$2$nestedPointerInput$1$1$1$1$WhenMappings */
            /* JADX INFO: compiled from: BasicSwipeToDismissBox.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[EdgeSwipeState.values().length];
                    try {
                        iArr[EdgeSwipeState.SwipeToDismissInProgress.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EdgeSwipeState.WaitingForTouch.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EdgeSwipeState.EdgeClickedWaitingForDirection.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00051(CoroutineScope coroutineScope, MutableState<EdgeSwipeState> mutableState, float f, Continuation<? super C00051> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$edgeSwipeState = mutableState;
                this.$edgeWidth = f;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00051 = new C00051(this.$$this$coroutineScope, this.$edgeSwipeState, this.$edgeWidth, continuation);
                c00051.L$0 = obj;
                return c00051;
            }

            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:11:0x002b  */
            /* JADX WARN: Code duplicated, block: B:13:0x003a A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:16:0x004c  */
            /* JADX WARN: Code duplicated, block: B:18:0x0062  */
            /* JADX WARN: Code duplicated, block: B:28:0x0086  */
            /* JADX WARN: Code duplicated, block: B:30:0x0096  */
            /* JADX WARN: Code duplicated, block: B:31:0x0099  */
            /* JADX WARN: Code duplicated, block: B:35:0x00a4  */
            /* JADX WARN: Code duplicated, block: B:37:0x00ac  */
            /* JADX WARN: Code duplicated, block: B:38:0x00af  */
            /* JADX WARN: Code duplicated, block: B:45:0x00b4 A[SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0038 -> B:14:0x003b). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:13:0x003a
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                /*
                    r11 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r11.label
                    r2 = 1
                    if (r1 == 0) goto L1b
                    if (r1 != r2) goto L13
                    java.lang.Object r1 = r11.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L3b
                L13:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L1b:
                    kotlin.ResultKt.throwOnFailure(r12)
                    java.lang.Object r12 = r11.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
                    r1 = r12
                L23:
                    kotlinx.coroutines.CoroutineScope r12 = r11.$$this$coroutineScope
                    boolean r12 = kotlinx.coroutines.CoroutineScopeKt.isActive(r12)
                    if (r12 == 0) goto Lb7
                    androidx.compose.ui.input.pointer.PointerEventPass r12 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                    r3 = r11
                    kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                    r11.L$0 = r1
                    r11.label = r2
                    java.lang.Object r12 = r1.awaitPointerEvent(r12, r3)
                    if (r12 != r0) goto L3b
                    return r0
                L3b:
                    androidx.compose.ui.input.pointer.PointerEvent r12 = (androidx.compose.ui.input.pointer.PointerEvent) r12
                    java.util.List r12 = r12.getChanges()
                    androidx.compose.runtime.MutableState<androidx.wear.compose.foundation.EdgeSwipeState> r3 = r11.$edgeSwipeState
                    float r4 = r11.$edgeWidth
                    int r5 = r12.size()
                    r6 = 0
                L4a:
                    if (r6 >= r5) goto L23
                    java.lang.Object r7 = r12.get(r6)
                    androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
                    java.lang.Object r8 = r3.getValue()
                    androidx.wear.compose.foundation.EdgeSwipeState r8 = (androidx.wear.compose.foundation.EdgeSwipeState) r8
                    int[] r9 = androidx.wear.compose.foundation.BasicSwipeToDismissBoxKt$edgeSwipeToDismiss$2$nestedPointerInput$1$1.AnonymousClass1.C00051.WhenMappings.$EnumSwitchMapping$0
                    int r8 = r8.ordinal()
                    r8 = r9[r8]
                    if (r8 == r2) goto L86
                    r9 = 2
                    if (r8 == r9) goto L86
                    r9 = 3
                    if (r8 == r9) goto L69
                    goto L9e
                L69:
                    long r8 = r7.getPosition-F1C5BW0()
                    float r8 = androidx.compose.ui.geometry.Offset.getX-impl(r8)
                    long r9 = r7.getPreviousPosition-F1C5BW0()
                    float r9 = androidx.compose.ui.geometry.Offset.getX-impl(r9)
                    int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
                    if (r8 >= 0) goto L80
                    androidx.wear.compose.foundation.EdgeSwipeState r8 = androidx.wear.compose.foundation.EdgeSwipeState.SwipingToPage
                    goto L82
                L80:
                    androidx.wear.compose.foundation.EdgeSwipeState r8 = androidx.wear.compose.foundation.EdgeSwipeState.SwipingToDismiss
                L82:
                    r3.setValue(r8)
                    goto L9e
                L86:
                    long r8 = r7.getPosition-F1C5BW0()
                    float r8 = androidx.compose.ui.geometry.Offset.getX-impl(r8)
                    float r9 = r1.toPx-0680j_4(r4)
                    int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
                    if (r8 >= 0) goto L99
                    androidx.wear.compose.foundation.EdgeSwipeState r8 = androidx.wear.compose.foundation.EdgeSwipeState.EdgeClickedWaitingForDirection
                    goto L9b
                L99:
                    androidx.wear.compose.foundation.EdgeSwipeState r8 = androidx.wear.compose.foundation.EdgeSwipeState.SwipingToPage
                L9b:
                    r3.setValue(r8)
                L9e:
                    boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r7)
                    if (r7 == 0) goto Lb4
                    java.lang.Object r7 = r3.getValue()
                    androidx.wear.compose.foundation.EdgeSwipeState r8 = androidx.wear.compose.foundation.EdgeSwipeState.SwipingToDismiss
                    if (r7 != r8) goto Laf
                    androidx.wear.compose.foundation.EdgeSwipeState r7 = androidx.wear.compose.foundation.EdgeSwipeState.SwipeToDismissInProgress
                    goto Lb1
                Laf:
                    androidx.wear.compose.foundation.EdgeSwipeState r7 = androidx.wear.compose.foundation.EdgeSwipeState.WaitingForTouch
                Lb1:
                    r3.setValue(r7)
                Lb4:
                    int r6 = r6 + 1
                    goto L4a
                Lb7:
                    kotlin.Unit r11 = kotlin.Unit.INSTANCE
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.foundation.BasicSwipeToDismissBoxKt$edgeSwipeToDismiss$2$nestedPointerInput$1$1.AnonymousClass1.C00051.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                this.label = 1;
                if (this.$$this$null.awaitPointerEventScope(new C00051(coroutineScope, this.$edgeSwipeState, this.$edgeWidth, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(new AnonymousClass1((PointerInputScope) this.L$0, this.$edgeSwipeState, this.$edgeWidth, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
