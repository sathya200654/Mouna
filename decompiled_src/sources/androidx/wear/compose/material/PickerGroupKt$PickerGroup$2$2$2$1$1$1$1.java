package androidx.wear.compose.material;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: PickerGroup.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2$1$1$1$1", f = "PickerGroup.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
final class PickerGroupKt$PickerGroup$2$2$2$1$1$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ Function1<Integer, Unit> $onSelected;
    final /* synthetic */ PickerGroupState $pickerGroupState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(PickerGroupState pickerGroupState, int i, Function1<? super Integer, Unit> function1, Continuation<? super PickerGroupKt$PickerGroup$2$2$2$1$1$1$1> continuation) {
        super(2, continuation);
        this.$pickerGroupState = pickerGroupState;
        this.$index = i;
        this.$onSelected = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> pickerGroupKt$PickerGroup$2$2$2$1$1$1$1 = new PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(this.$pickerGroupState, this.$index, this.$onSelected, continuation);
        pickerGroupKt$PickerGroup$2$2$2$1$1$1$1.L$0 = obj;
        return pickerGroupKt$PickerGroup$2$2$2$1$1$1$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return create(pointerInputScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2$1$1$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: PickerGroup.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2$1$1$1$1$1", f = "PickerGroup.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $$this$pointerInput;
        final /* synthetic */ int $index;
        final /* synthetic */ Function1<Integer, Unit> $onSelected;
        final /* synthetic */ PickerGroupState $pickerGroupState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(PointerInputScope pointerInputScope, PickerGroupState pickerGroupState, int i, Function1<? super Integer, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$pointerInput = pointerInputScope;
            this.$pickerGroupState = pickerGroupState;
            this.$index = i;
            this.$onSelected = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$$this$pointerInput, this.$pickerGroupState, this.$index, this.$onSelected, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            do {
                this.label = 1;
            } while (ForEachGestureKt.awaitEachGesture(this.$$this$pointerInput, new C00151(this.$pickerGroupState, this.$index, this.$onSelected, null), (Continuation) this) != coroutine_suspended);
            return coroutine_suspended;
        }

        /* JADX INFO: renamed from: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2$1$1$1$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PickerGroup.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2$1$1$1$1$1$1", f = "PickerGroup.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
        static final class C00151 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $index;
            final /* synthetic */ Function1<Integer, Unit> $onSelected;
            final /* synthetic */ PickerGroupState $pickerGroupState;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00151(PickerGroupState pickerGroupState, int i, Function1<? super Integer, Unit> function1, Continuation<? super C00151> continuation) {
                super(2, continuation);
                this.$pickerGroupState = pickerGroupState;
                this.$index = i;
                this.$onSelected = function1;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00151 = new C00151(this.$pickerGroupState, this.$index, this.$onSelected, continuation);
                c00151.L$0 = obj;
                return c00151;
            }

            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (TapGestureDetectorKt.awaitFirstDown$default((AwaitPointerEventScope) this.L$0, false, (PointerEventPass) null, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$pickerGroupState.setSelectedIndex(this.$index);
                this.$onSelected.invoke(Boxing.boxInt(this.$index));
                return Unit.INSTANCE;
            }
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(new AnonymousClass1((PointerInputScope) this.L$0, this.$pickerGroupState, this.$index, this.$onSelected, null), (Continuation) this) == coroutine_suspended) {
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
