package androidx.wear.compose.foundation;

import androidx.core.util.Predicate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: SwipeToReveal.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "revealValue", "Landroidx/wear/compose/foundation/RevealValue;", "invoke-uhL3PpE", "(I)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class RevealState$swipeableState$1 extends Lambda implements Function1<RevealValue, Boolean> {
    final /* synthetic */ Function1<RevealValue, Boolean> $confirmValueChange;
    final /* synthetic */ RevealState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RevealState$swipeableState$1(RevealState revealState, Function1<? super RevealValue, Boolean> function1) {
        super(1);
        this.this$0 = revealState;
        this.$confirmValueChange = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m397invokeuhL3PpE(((RevealValue) obj).m404unboximpl());
    }

    /* JADX INFO: renamed from: invoke-uhL3PpE, reason: not valid java name */
    public final Boolean m397invokeuhL3PpE(int i) {
        RevealState revealState = this.this$0;
        final Function1<RevealValue, Boolean> function1 = this.$confirmValueChange;
        return Boolean.valueOf(revealState.m390confirmValueChangeAndResetTIIb0GA(new Predicate() { // from class: androidx.wear.compose.foundation.RevealState$swipeableState$1$$ExternalSyntheticLambda0
            public final boolean test(Object obj) {
                return RevealState$swipeableState$1.invoke_uhL3PpE$lambda$0(function1, (RevealValue) obj);
            }
        }, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke_uhL3PpE$lambda$0(Function1 function1, RevealValue revealValue) {
        return ((Boolean) function1.invoke(revealValue)).booleanValue();
    }
}
