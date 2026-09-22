package androidx.wear.compose.material;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Picker.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.material.PickerKt$Picker$7$1", f = "Picker.kt", i = {}, l = {346}, m = "invokeSuspend", n = {}, s = {})
final class PickerKt$Picker$7$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $forceScrollWhenReadOnly$delegate;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ PickerState $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PickerKt$Picker$7$1(boolean z, PickerState pickerState, MutableState<Boolean> mutableState, Continuation<? super PickerKt$Picker$7$1> continuation) {
        super(2, continuation);
        this.$readOnly = z;
        this.$state = pickerState;
        this.$forceScrollWhenReadOnly$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PickerKt$Picker$7$1(this.$readOnly, this.$state, this.$forceScrollWhenReadOnly$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$readOnly && PickerKt.Picker_kzdTruM$lambda$3(this.$forceScrollWhenReadOnly$delegate)) {
                PickerState pickerState = this.$state;
                this.label = 1;
                if (pickerState.scrollToOption(pickerState.getSelectedOption(), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        PickerKt.Picker_kzdTruM$lambda$4(this.$forceScrollWhenReadOnly$delegate, false);
        return Unit.INSTANCE;
    }
}
