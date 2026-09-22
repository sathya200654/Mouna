package androidx.wear.compose.material;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PickerGroup.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B©\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012 \b\u0002\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011\u0012F\u0010\u0012\u001aB\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011¢\u0006\u0002\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#RS\u0010\u0012\u001aB\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R+\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Landroidx/wear/compose/material/PickerGroupItem;", "", "pickerState", "Landroidx/wear/compose/material/PickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentDescription", "", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "onSelected", "Lkotlin/Function0;", "", "readOnlyLabel", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "option", "Lkotlin/Function3;", "Landroidx/wear/compose/material/PickerScope;", "", "Lkotlin/ParameterName;", "name", "optionIndex", "", "pickerSelected", "(Landroidx/wear/compose/material/PickerState;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/ui/focus/FocusRequester;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function5;)V", "getContentDescription", "()Ljava/lang/String;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "getModifier", "()Landroidx/compose/ui/Modifier;", "getOnSelected", "()Lkotlin/jvm/functions/Function0;", "getOption", "()Lkotlin/jvm/functions/Function5;", "Lkotlin/jvm/functions/Function5;", "getPickerState", "()Landroidx/wear/compose/material/PickerState;", "getReadOnlyLabel", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PickerGroupItem {
    public static final int $stable = 0;
    private final String contentDescription;
    private final FocusRequester focusRequester;
    private final Modifier modifier;
    private final Function0<Unit> onSelected;
    private final Function5<PickerScope, Integer, Boolean, Composer, Integer, Unit> option;
    private final PickerState pickerState;
    private final Function3<BoxScope, Composer, Integer, Unit> readOnlyLabel;

    /* JADX WARN: Multi-variable type inference failed */
    public PickerGroupItem(PickerState pickerState, Modifier modifier, String str, FocusRequester focusRequester, Function0<Unit> function0, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Function5<? super PickerScope, ? super Integer, ? super Boolean, ? super Composer, ? super Integer, Unit> function5) {
        this.pickerState = pickerState;
        this.modifier = modifier;
        this.contentDescription = str;
        this.focusRequester = focusRequester;
        this.onSelected = function0;
        this.readOnlyLabel = function3;
        this.option = function5;
    }

    public final PickerState getPickerState() {
        return this.pickerState;
    }

    public /* synthetic */ PickerGroupItem(PickerState pickerState, Modifier modifier, String str, FocusRequester focusRequester, AnonymousClass1 anonymousClass1, Function3 function3, Function5 function5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pickerState, (i & 2) != 0 ? (Modifier) Modifier.Companion : modifier, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : focusRequester, (i & 16) != 0 ? new Function0<Unit>() { // from class: androidx.wear.compose.material.PickerGroupItem.1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m631invoke() {
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m631invoke();
                return Unit.INSTANCE;
            }
        } : anonymousClass1, (i & 32) != 0 ? null : function3, function5);
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final Function0<Unit> getOnSelected() {
        return this.onSelected;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getReadOnlyLabel() {
        return this.readOnlyLabel;
    }

    public final Function5<PickerScope, Integer, Boolean, Composer, Integer, Unit> getOption() {
        return this.option;
    }
}
