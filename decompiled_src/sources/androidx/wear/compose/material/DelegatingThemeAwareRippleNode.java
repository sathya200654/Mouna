package androidx.wear.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Ripple.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/wear/compose/material/DelegatingThemeAwareRippleNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DelegatingThemeAwareRippleNode extends DelegatingNode implements CompositionLocalConsumerModifierNode {
    public /* synthetic */ DelegatingThemeAwareRippleNode(InteractionSource interactionSource, boolean z, float f, ColorProducer colorProducer, DefaultConstructorMarker defaultConstructorMarker) {
        this(interactionSource, z, f, colorProducer);
    }

    private DelegatingThemeAwareRippleNode(InteractionSource interactionSource, boolean z, float f, final ColorProducer colorProducer) {
        delegate(androidx.compose.material.ripple.RippleKt.createRippleModifierNode-TDGSqEk(interactionSource, z, f, new ColorProducer() { // from class: androidx.wear.compose.material.DelegatingThemeAwareRippleNode.1
            /* JADX INFO: renamed from: invoke-0d7_KjU, reason: not valid java name */
            public final long m591invoke0d7_KjU() {
                long j = colorProducer.invoke-0d7_KjU();
                return j != 16 ? j : RippleDefaults.INSTANCE.m740rippleColorl2rxGTc(((Color) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, ContentColorKt.getLocalContentColor())).unbox-impl());
            }
        }, RippleKt.CalculateRippleAlpha));
    }
}
