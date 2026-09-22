package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: DraggableFloatingWebView.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class DraggableFloatingWebViewKt$ConversationWebView$4$1 implements PointerInputEventHandler {
    final /* synthetic */ MutableState<IntOffset> $offset$delegate;

    DraggableFloatingWebViewKt$ConversationWebView$4$1(MutableState<IntOffset> mutableState) {
        this.$offset$delegate = mutableState;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final MutableState<IntOffset> mutableState = this.$offset$delegate;
        Object objDetectDragGestures$default = DragGestureDetectorKt.detectDragGestures$default(pointerInputScope, (Function1) null, (Function0) null, (Function0) null, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.DraggableFloatingWebViewKt$ConversationWebView$4$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                return DraggableFloatingWebViewKt$ConversationWebView$4$1.invoke$lambda$0(mutableState, (PointerInputChange) obj, (Offset) obj2);
            }
        }, continuation, 7, (Object) null);
        return objDetectDragGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectDragGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(MutableState mutableState, PointerInputChange pointerInputChange, Offset offset) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "change");
        pointerInputChange.consume();
        DraggableFloatingWebViewKt.ConversationWebView$lambda$2(mutableState, IntOffset.constructor-impl((((long) MathKt.roundToInt(IntOffset.getY-impl(DraggableFloatingWebViewKt.ConversationWebView$lambda$1(mutableState)) + Float.intBitsToFloat((int) (offset.unbox-impl() & 4294967295L)))) & 4294967295L) | (((long) MathKt.roundToInt(IntOffset.getX-impl(DraggableFloatingWebViewKt.ConversationWebView$lambda$1(mutableState)) + Float.intBitsToFloat((int) (offset.unbox-impl() >> 32)))) << 32)));
        return Unit.INSTANCE;
    }
}
