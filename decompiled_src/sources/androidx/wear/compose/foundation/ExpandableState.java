package androidx.wear.compose.foundation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: Expandable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B3\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00038G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Landroidx/wear/compose/foundation/ExpandableState;", "", "initiallyExpanded", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "expandAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "collapseAnimationSpec", "(ZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "_expandProgress", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "expandProgress", "getExpandProgress", "()F", "newValue", "expanded", "isExpanded", "()Z", "setExpanded", "(Z)V", "Companion", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExpandableState {
    private final Animatable<Float, AnimationVector1D> _expandProgress;
    private final AnimationSpec<Float> collapseAnimationSpec;
    private final CoroutineScope coroutineScope;
    private final AnimationSpec<Float> expandAnimationSpec;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public ExpandableState(boolean z, CoroutineScope coroutineScope, AnimationSpec<Float> animationSpec, AnimationSpec<Float> animationSpec2) {
        this.coroutineScope = coroutineScope;
        this.expandAnimationSpec = animationSpec;
        this.collapseAnimationSpec = animationSpec2;
        this._expandProgress = AnimatableKt.Animatable$default(z ? 1.0f : 0.0f, 0.0f, 2, (Object) null);
    }

    public final float getExpandProgress() {
        return ((Number) this._expandProgress.getValue()).floatValue();
    }

    public final boolean isExpanded() {
        return ((Number) this._expandProgress.getTargetValue()).floatValue() == 1.0f;
    }

    public final void setExpanded(boolean z) {
        if (isExpanded() != z) {
            BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ExpandableState$expanded$1(z, this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: compiled from: Expandable.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/wear/compose/foundation/ExpandableState$Companion;", "", "()V", "saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/wear/compose/foundation/ExpandableState;", "", "expandAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "collapseAnimationSpec", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/saveable/Saver;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<ExpandableState, Boolean> saver(final AnimationSpec<Float> animationSpec, final AnimationSpec<Float> animationSpec2, Composer composer, int i) {
            ComposerKt.sourceInformationMarkerStart(composer, -278364042, "C(saver)P(1)277@11809L24,280@11926L320:Expandable.kt#m5emhl");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-278364042, i, -1, "androidx.wear.compose.foundation.ExpandableState.Companion.saver (Expandable.kt:276)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, -954363344, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ExpandableState$Companion$saver$1 expandableState$Companion$saver$1 = new Function2<SaverScope, ExpandableState, Boolean>() { // from class: androidx.wear.compose.foundation.ExpandableState$Companion$saver$1
                public final Boolean invoke(SaverScope saverScope, ExpandableState expandableState) {
                    return Boolean.valueOf(expandableState.isExpanded());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composer, -354854867, "CC(remember):Expandable.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(animationSpec) | composer.changedInstance(animationSpec2);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = (Function1) new Function1<Boolean, ExpandableState>() { // from class: androidx.wear.compose.foundation.ExpandableState$Companion$saver$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }

                    public final ExpandableState invoke(boolean z) {
                        return new ExpandableState(z, coroutineScope, animationSpec, animationSpec2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Saver<ExpandableState, Boolean> Saver = SaverKt.Saver(expandableState$Companion$saver$1, (Function1) objRememberedValue2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return Saver;
        }
    }
}
