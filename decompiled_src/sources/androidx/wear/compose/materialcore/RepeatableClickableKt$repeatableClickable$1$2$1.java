package androidx.wear.compose.materialcore;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: RepeatableClickable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.materialcore.RepeatableClickableKt$repeatableClickable$1$2$1", f = "RepeatableClickable.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
final class RepeatableClickableKt$repeatableClickable$1$2$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Unit>> $currentOnRepeatableClick$delegate;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableState<Boolean> $ignoreOnClick$delegate;
    final /* synthetic */ long $incrementalDelay;
    final /* synthetic */ long $initialDelay;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RepeatableClickableKt$repeatableClickable$1$2$1(MutableState<Boolean> mutableState, long j, boolean z, long j2, State<? extends Function0<Unit>> state, Continuation<? super RepeatableClickableKt$repeatableClickable$1$2$1> continuation) {
        super(2, continuation);
        this.$ignoreOnClick$delegate = mutableState;
        this.$initialDelay = j;
        this.$enabled = z;
        this.$incrementalDelay = j2;
        this.$currentOnRepeatableClick$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> repeatableClickableKt$repeatableClickable$1$2$1 = new RepeatableClickableKt$repeatableClickable$1$2$1(this.$ignoreOnClick$delegate, this.$initialDelay, this.$enabled, this.$incrementalDelay, this.$currentOnRepeatableClick$delegate, continuation);
        repeatableClickableKt$repeatableClickable$1$2$1.L$0 = obj;
        return repeatableClickableKt$repeatableClickable$1$2$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return create(pointerInputScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.wear.compose.materialcore.RepeatableClickableKt$repeatableClickable$1$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: RepeatableClickable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.materialcore.RepeatableClickableKt$repeatableClickable$1$2$1$1", f = "RepeatableClickable.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $$this$pointerInput;
        final /* synthetic */ State<Function0<Unit>> $currentOnRepeatableClick$delegate;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableState<Boolean> $ignoreOnClick$delegate;
        final /* synthetic */ long $incrementalDelay;
        final /* synthetic */ long $initialDelay;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PointerInputScope pointerInputScope, MutableState<Boolean> mutableState, long j, boolean z, long j2, State<? extends Function0<Unit>> state, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$pointerInput = pointerInputScope;
            this.$ignoreOnClick$delegate = mutableState;
            this.$initialDelay = j;
            this.$enabled = z;
            this.$incrementalDelay = j2;
            this.$currentOnRepeatableClick$delegate = state;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$$this$pointerInput, this.$ignoreOnClick$delegate, this.$initialDelay, this.$enabled, this.$incrementalDelay, this.$currentOnRepeatableClick$delegate, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.wear.compose.materialcore.RepeatableClickableKt$repeatableClickable$1$2$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: RepeatableClickable.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.wear.compose.materialcore.RepeatableClickableKt$repeatableClickable$1$2$1$1$1", f = "RepeatableClickable.kt", i = {0, 1}, l = {106, 117}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "repeatingJob"}, s = {"L$0", "L$0"})
        static final class C00301 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ State<Function0<Unit>> $currentOnRepeatableClick$delegate;
            final /* synthetic */ boolean $enabled;
            final /* synthetic */ MutableState<Boolean> $ignoreOnClick$delegate;
            final /* synthetic */ long $incrementalDelay;
            final /* synthetic */ long $initialDelay;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00301(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, long j, boolean z, long j2, State<? extends Function0<Unit>> state, Continuation<? super C00301> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$ignoreOnClick$delegate = mutableState;
                this.$initialDelay = j;
                this.$enabled = z;
                this.$incrementalDelay = j2;
                this.$currentOnRepeatableClick$delegate = state;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00301 = new C00301(this.$$this$coroutineScope, this.$ignoreOnClick$delegate, this.$initialDelay, this.$enabled, this.$incrementalDelay, this.$currentOnRepeatableClick$delegate, continuation);
                c00301.L$0 = obj;
                return c00301;
            }

            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                AwaitPointerEventScope awaitPointerEventScope;
                Job job;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                    this.L$0 = awaitPointerEventScope2;
                    this.label = 1;
                    if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, (PointerEventPass) null, (Continuation) this, 3, (Object) null) != coroutine_suspended) {
                        awaitPointerEventScope = awaitPointerEventScope2;
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    job = (Job) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                return Unit.INSTANCE;
                RepeatableClickableKt$repeatableClickable$1.invoke$lambda$4(this.$ignoreOnClick$delegate, false);
                Job jobLaunch$default = BuildersKt.launch$default(this.$$this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new RepeatableClickableKt$repeatableClickable$1$2$1$1$1$repeatingJob$1(this.$initialDelay, this.$enabled, this.$incrementalDelay, this.$ignoreOnClick$delegate, this.$currentOnRepeatableClick$delegate, null), 3, (Object) null);
                this.L$0 = jobLaunch$default;
                this.label = 2;
                if (TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope, (PointerEventPass) null, (Continuation) this, 1, (Object) null) != coroutine_suspended) {
                    job = jobLaunch$default;
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(this.$$this$pointerInput, new C00301(coroutineScope, this.$ignoreOnClick$delegate, this.$initialDelay, this.$enabled, this.$incrementalDelay, this.$currentOnRepeatableClick$delegate, null), (Continuation) this) == coroutine_suspended) {
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
            if (CoroutineScopeKt.coroutineScope(new AnonymousClass1((PointerInputScope) this.L$0, this.$ignoreOnClick$delegate, this.$initialDelay, this.$enabled, this.$incrementalDelay, this.$currentOnRepeatableClick$delegate, null), (Continuation) this) == coroutine_suspended) {
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
