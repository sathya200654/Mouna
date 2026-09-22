package androidx.wear.compose.foundation.rotary;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: RotaryScrollable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000eH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Landroidx/wear/compose/foundation/rotary/RotaryInputNode;", "Landroidx/compose/ui/input/rotary/RotaryInputModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "behavior", "Landroidx/wear/compose/foundation/rotary/RotaryScrollableBehavior;", "reverseDirection", "", "(Landroidx/wear/compose/foundation/rotary/RotaryScrollableBehavior;Z)V", "getBehavior", "()Landroidx/wear/compose/foundation/rotary/RotaryScrollableBehavior;", "setBehavior", "(Landroidx/wear/compose/foundation/rotary/RotaryScrollableBehavior;)V", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "flow", "Lkotlinx/coroutines/flow/Flow;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "getReverseDirection", "()Z", "setReverseDirection", "(Z)V", "onAttach", "", "onPreRotaryScrollEvent", "event", "onRotaryScrollEvent", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RotaryInputNode extends Modifier.Node implements RotaryInputModifierNode {
    private RotaryScrollableBehavior behavior;
    private final Channel<RotaryScrollEvent> channel;
    private final Flow<RotaryScrollEvent> flow;
    private boolean reverseDirection;

    public boolean onRotaryScrollEvent(RotaryScrollEvent event) {
        return false;
    }

    public final RotaryScrollableBehavior getBehavior() {
        return this.behavior;
    }

    public final void setBehavior(RotaryScrollableBehavior rotaryScrollableBehavior) {
        this.behavior = rotaryScrollableBehavior;
    }

    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    public final void setReverseDirection(boolean z) {
        this.reverseDirection = z;
    }

    public RotaryInputNode(RotaryScrollableBehavior rotaryScrollableBehavior, boolean z) {
        this.behavior = rotaryScrollableBehavior;
        this.reverseDirection = z;
        ReceiveChannel receiveChannelChannel$default = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.channel = receiveChannelChannel$default;
        this.flow = FlowKt.receiveAsFlow(receiveChannelChannel$default);
    }

    public final Channel<RotaryScrollEvent> getChannel() {
        return this.channel;
    }

    public final Flow<RotaryScrollEvent> getFlow() {
        return this.flow;
    }

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.rotary.RotaryInputNode$onAttach$1, reason: invalid class name */
    /* JADX INFO: compiled from: RotaryScrollable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.rotary.RotaryInputNode$onAttach$1", f = "RotaryScrollable.kt", i = {}, l = {1263}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = RotaryInputNode.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                this.label = 1;
                if (FlowKt.collectLatest(RotaryInputNode.this.getFlow(), new C00121(RotaryInputNode.this, coroutineScope, null), (Continuation) this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.wear.compose.foundation.rotary.RotaryInputNode$onAttach$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: RotaryScrollable.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.wear.compose.foundation.rotary.RotaryInputNode$onAttach$1$1", f = "RotaryScrollable.kt", i = {}, l = {1274}, m = "invokeSuspend", n = {}, s = {})
        static final class C00121 extends SuspendLambda implements Function2<RotaryScrollEvent, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$launch;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ RotaryInputNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00121(RotaryInputNode rotaryInputNode, CoroutineScope coroutineScope, Continuation<? super C00121> continuation) {
                super(2, continuation);
                this.this$0 = rotaryInputNode;
                this.$$this$launch = coroutineScope;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00121 = new C00121(this.this$0, this.$$this$launch, continuation);
                c00121.L$0 = obj;
                return c00121;
            }

            public final Object invoke(RotaryScrollEvent rotaryScrollEvent, Continuation<? super Unit> continuation) {
                return create(rotaryScrollEvent, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Pair pair;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    RotaryScrollEvent rotaryScrollEvent = (RotaryScrollEvent) this.L$0;
                    if (rotaryScrollEvent.getVerticalScrollPixels() != 0.0f) {
                        pair = new Pair(Orientation.Vertical, Boxing.boxFloat(rotaryScrollEvent.getVerticalScrollPixels()));
                    } else {
                        pair = new Pair(Orientation.Horizontal, Boxing.boxFloat(rotaryScrollEvent.getHorizontalScrollPixels()));
                    }
                    Orientation orientation = (Orientation) pair.component1();
                    float fFloatValue = ((Number) pair.component2()).floatValue();
                    RotaryScrollableBehavior behavior = this.this$0.getBehavior();
                    CoroutineScope coroutineScope = this.$$this$launch;
                    RotaryInputNode rotaryInputNode = this.this$0;
                    long uptimeMillis = rotaryScrollEvent.getUptimeMillis();
                    float f = rotaryInputNode.getReverseDirection() ? -1.0f : 1.0f;
                    int inputDeviceId = rotaryScrollEvent.getInputDeviceId();
                    this.label = 1;
                    if (behavior.performScroll(coroutineScope, uptimeMillis, fFloatValue * f, inputDeviceId, orientation, this) == coroutine_suspended) {
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
    }

    public void onAttach() {
        BuildersKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    public boolean onPreRotaryScrollEvent(RotaryScrollEvent event) {
        this.channel.trySend-JP2dKIU(event);
        return true;
    }
}
