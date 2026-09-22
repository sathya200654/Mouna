package androidx.wear.compose.materialcore;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: RepeatableClickable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class RepeatableClickableKt$repeatableClickable$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ long $incrementalDelay;
    final /* synthetic */ Indication $indication;
    final /* synthetic */ long $initialDelay;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ Function0<Unit> $onRepeatableClick;
    final /* synthetic */ Role $role;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RepeatableClickableKt$repeatableClickable$1(Function0<Unit> function0, Function0<Unit> function1, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, long j, long j2) {
        super(3);
        this.$onRepeatableClick = function0;
        this.$onClick = function1;
        this.$interactionSource = mutableInteractionSource;
        this.$indication = indication;
        this.$enabled = z;
        this.$onClickLabel = str;
        this.$role = role;
        this.$initialDelay = j;
        this.$incrementalDelay = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(1028118630);
        ComposerKt.sourceInformation(composer, "C80@3919L39,81@3985L29,85@4241L34,95@4643L126,102@4808L678:RepeatableClickable.kt#f7tims");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1028118630, i, -1, "androidx.wear.compose.materialcore.repeatableClickable.<anonymous> (RepeatableClickable.kt:80)");
        }
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$onRepeatableClick, composer, 0);
        final State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(this.$onClick, composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1018635668, "CC(remember):RepeatableClickable.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
        Indication indication = this.$indication;
        boolean z = this.$enabled;
        String str = this.$onClickLabel;
        Role role = this.$role;
        ComposerKt.sourceInformationMarkerStart(composer, -1018622712, "CC(remember):RepeatableClickable.kt#9igjgp");
        boolean zChanged = composer.changed(stateRememberUpdatedState2);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.materialcore.RepeatableClickableKt$repeatableClickable$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m914invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m914invoke() {
                    if (!RepeatableClickableKt$repeatableClickable$1.invoke$lambda$3(mutableState)) {
                        RepeatableClickableKt$repeatableClickable$1.invoke$lambda$1(stateRememberUpdatedState2).invoke();
                    }
                    RepeatableClickableKt$repeatableClickable$1.invoke$lambda$4(mutableState, false);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifier2 = ClickableKt.clickable-O2vRcR0(modifier, mutableInteractionSource, indication, z, str, role, (Function0) objRememberedValue2);
        Boolean boolValueOf = Boolean.valueOf(this.$enabled);
        ComposerKt.sourceInformationMarkerStart(composer, -1018616880, "CC(remember):RepeatableClickable.kt#9igjgp");
        boolean zChanged2 = composer.changed(this.$initialDelay) | composer.changed(this.$enabled) | composer.changed(stateRememberUpdatedState) | composer.changed(this.$incrementalDelay);
        long j = this.$initialDelay;
        boolean z2 = this.$enabled;
        long j2 = this.$incrementalDelay;
        RepeatableClickableKt$repeatableClickable$1$2$1 repeatableClickableKt$repeatableClickable$1$2$1RememberedValue = composer.rememberedValue();
        if (zChanged2 || repeatableClickableKt$repeatableClickable$1$2$1RememberedValue == Composer.Companion.getEmpty()) {
            repeatableClickableKt$repeatableClickable$1$2$1RememberedValue = new RepeatableClickableKt$repeatableClickable$1$2$1(mutableState, j, z2, j2, stateRememberUpdatedState, null);
            composer.updateRememberedValue(repeatableClickableKt$repeatableClickable$1$2$1RememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier2, boolValueOf, (Function2) repeatableClickableKt$repeatableClickable$1$2$1RememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierPointerInput;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$3(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> invoke$lambda$0(State<? extends Function0<Unit>> state) {
        return (Function0) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> invoke$lambda$1(State<? extends Function0<Unit>> state) {
        return (Function0) state.getValue();
    }
}
