package androidx.wear.compose.materialcore;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.messaging.Constants;
import io.grpc.internal.GrpcUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToggleButton.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0084\u0003\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u001e\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0006\u0010\u0013\u001a\u00020\u00142\u001e\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0002\b\f¢\u0006\u0002\b\r2A\u0010\u0016\u001a=\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u0017¢\u0006\u0002\b\f2A\u0010\u001d\u001a=\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u0017¢\u0006\u0002\b\f2\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001aÍ\u0002\u0010*\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f¢\u0006\u0002\b\f2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f¢\u0006\u0002\b\f2\u0006\u0010\u0013\u001a\u00020\u00142\u001e\u0010+\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u001e\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0002\b\f¢\u0006\u0002\b\r2;\u0010,\u001a7\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00140\u0017¢\u0006\u0002\b\f2\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a\u0080\u0002\u0010*\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00072A\u0010\u0016\u001a=\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u0017¢\u0006\u0002\b\f2=\u00104\u001a9\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0006\u0012\u0006\u0012\u0004\u0018\u0001050\u0017¢\u0006\u0002\b\f2\u0006\u00106\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u001c\u00107\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\b\f¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a<\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00012 \b\u0002\u00107\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0002\b\f¢\u0006\u0002\b\rH\u0003ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a^\u0010>\u001a\u00020\u0005*\u00020\u000b2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u001e\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\b\b\u0002\u0010;\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a9\u0010A\u001a\u00020\u0005*\u00020\u000b2\u0006\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u00012\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\u0002\b\fH\u0003ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a\u001d\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140G*\u00020\"H\u0003¢\u0006\u0002\u0010H\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"SPLIT_WIDTH", "Landroidx/compose/ui/unit/Dp;", "F", "TOGGLE_CONTROL_SPACING", "SplitToggleButton", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", Constants.ScionAnalytics.PARAM_LABEL, "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "onClick", "Lkotlin/Function0;", "toggleControl", "Landroidx/compose/foundation/layout/BoxScope;", "selectionControl", "modifier", "Landroidx/compose/ui/Modifier;", "secondaryLabel", "backgroundColor", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "enabled", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "splitBackgroundColor", "checkedInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "clickInteractionSource", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "shape", "Landroidx/compose/ui/graphics/Shape;", "labelSpacerSize", "ripple", "Landroidx/compose/foundation/Indication;", "SplitToggleButton-A819N5k", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/Indication;Landroidx/compose/runtime/Composer;II)V", "ToggleButton", "icon", "background", "interactionSource", "toggleControlWidth", "toggleControlHeight", "toggleControlSpacing", "iconSpacing", "ToggleButton-ULF-Yh8", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function4;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;FFFFFLandroidx/compose/foundation/Indication;Landroidx/compose/runtime/Composer;II)V", "border", "Landroidx/compose/foundation/BorderStroke;", "toggleButtonSize", "content", "ToggleButton-BxUkNYg", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/Indication;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ToggleButtonIcon", "spacerSize", "ToggleButtonIcon--orJrPs", "(FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Labels", "Labels--jt2gSs", "(Landroidx/compose/foundation/layout/RowScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;FLandroidx/compose/runtime/Composer;II)V", "ToggleControl", "width", "height", "ToggleControl-WMci_g0", "(Landroidx/compose/foundation/layout/RowScope;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "splitHorizontally", "Lkotlin/Pair;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/Pair;", "compose-material-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ToggleButtonKt {
    private static final float TOGGLE_CONTROL_SPACING = Dp.constructor-impl(4);
    private static final float SPLIT_WIDTH = Dp.constructor-impl(52);

    /* JADX INFO: renamed from: ToggleButton-BxUkNYg, reason: not valid java name */
    public static final void m940ToggleButtonBxUkNYg(final boolean z, final Function1<? super Boolean, Unit> function1, final Modifier modifier, final boolean z2, final Function4<? super Boolean, ? super Boolean, ? super Composer, ? super Integer, ? extends State<Color>> function4, final Function4<? super Boolean, ? super Boolean, ? super Composer, ? super Integer, BorderStroke> function5, final float f, final MutableInteractionSource mutableInteractionSource, final Shape shape, final Indication indication, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        boolean z3;
        MutableInteractionSource mutableInteractionSource2;
        int i4;
        Modifier modifierBorder;
        Composer composerStartRestartGroup = composer.startRestartGroup(966068085);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ToggleButton)P(2,7,6,4!2,10:c#ui.unit.Dp,5,9,8)105@4870L24,124@5587L33,106@4899L805:ToggleButton.kt#f7tims");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            z3 = z2;
            i3 |= composerStartRestartGroup.changed(z3) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        } else {
            z3 = z2;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function4) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function5) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            mutableInteractionSource2 = mutableInteractionSource;
            i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(indication) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changedInstance(function3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i3 & 306783379) != 306783378 || (i4 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(966068085, i3, i4, "androidx.wear.compose.materialcore.ToggleButton (ToggleButton.kt:103)");
            }
            int i5 = i4;
            int i6 = i3 >> 9;
            int i7 = (i6 & 14) | ((i3 << 3) & 112);
            BorderStroke borderStroke = (BorderStroke) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i7 | (i6 & 896)));
            Alignment center = Alignment.Companion.getCenter();
            int i8 = i3;
            Modifier modifier2 = ToggleableKt.toggleable-O2vRcR0$default(ClipKt.clip(SizeKt.size-3ABfNKs(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.ToggleButtonKt$ToggleButton$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                }
            }, 1, (Object) null), f), shape), z, mutableInteractionSource2, indication, z3, (Role) null, function1, 16, (Object) null);
            if (borderStroke != null) {
                modifierBorder = BorderKt.border(Modifier.Companion, borderStroke, shape);
            } else {
                modifierBorder = Modifier.Companion;
            }
            Modifier modifier3 = BackgroundKt.background-bw27NRU(modifier2.then(modifierBorder), ((Color) ((State) function4.invoke(Boolean.valueOf(z2), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i7 | ((i8 >> 6) & 896)))).getValue()).unbox-impl(), shape);
            int i9 = ((i5 << 9) & 7168) | 48;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composer2 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            function3.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i9 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.ToggleButtonKt$ToggleButton$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i10) {
                    ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function1, modifier, z2, function4, function5, f, mutableInteractionSource, shape, indication, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    /* JADX INFO: renamed from: ToggleButton-ULF-Yh8, reason: not valid java name */
    public static final void m941ToggleButtonULFYh8(final boolean z, Function1<? super Boolean, Unit> function1, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, final Modifier modifier, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function5, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function6, final Function4<? super Boolean, ? super Boolean, ? super Composer, ? super Integer, ? extends Modifier> function7, final boolean z2, final MutableInteractionSource mutableInteractionSource, final PaddingValues paddingValues, final Shape shape, final float f, final float f2, final float f3, float f4, float f5, final Indication indication, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        final Function1<? super Boolean, Unit> function8;
        int i5;
        Composer composer2;
        int i6;
        Modifier modifierSemantics$default;
        float f6;
        float f7;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Composer composer3;
        Composer composerStartRestartGroup = composer.startRestartGroup(943724770);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ToggleButton)P(1,10,7,15,13,9,4,12!1,3,6!1,14,18:c#ui.unit.Dp,16:c#ui.unit.Dp,8:c#ui.unit.Dp,17:c#ui.unit.Dp,5:c#ui.unit.Dp)205@9606L28,201@9484L2063:ToggleButton.kt#f7tims");
        if ((i & 6) == 0) {
            i3 = i | (composerStartRestartGroup.changed(z) ? 4 : 2);
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        int i7 = i & 3072;
        int i8 = RecyclerView.ItemAnimator.FLAG_MOVED;
        if (i7 == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function4) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function5) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function6) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function7) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 536870912 : 268435456;
        }
        int i9 = i3;
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(paddingValues) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(shape) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            if (!composerStartRestartGroup.changed(f)) {
                i8 = 1024;
            }
            i4 |= i8;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(f2) ? 16384 : 8192;
        }
        if ((i2 & 196608) == 0) {
            i4 |= composerStartRestartGroup.changed(f3) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changed(f4) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changed(f5) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changed(indication) ? 67108864 : 33554432;
        }
        int i10 = i4;
        if ((i9 & 306783379) != 306783378 || (38347923 & i10) != 38347922 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(943724770, i9, i10, "androidx.wear.compose.materialcore.ToggleButton (ToggleButton.kt:194)");
            }
            if (!((function2 != null) ^ (function4 != null))) {
                throw new IllegalArgumentException("Provide exactly one of toggleControl/selectionControl".toString());
            }
            Modifier modifierThen = IntrinsicKt.width(ClipKt.clip(modifier, shape), IntrinsicSize.Max).then((Modifier) function7.invoke(Boolean.valueOf(z2), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(((i9 >> 27) & 14) | ((i9 << 3) & 112) | ((i9 >> 18) & 896))));
            composerStartRestartGroup.startReplaceGroup(-341782349);
            ComposerKt.sourceInformation(composerStartRestartGroup, "222@10410L25");
            if (function2 != null) {
                composer2 = composerStartRestartGroup;
                i6 = i10;
                i5 = i9;
                modifierSemantics$default = ToggleableKt.toggleable-O2vRcR0$default(Modifier.Companion, z, mutableInteractionSource, indication, z2, (Role) null, function1, 16, (Object) null);
                function8 = function1;
            } else {
                function8 = function1;
                i5 = i9;
                composer2 = composerStartRestartGroup;
                i6 = i10;
                Modifier modifier2 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(composer2, -341759903, "CC(remember):ToggleButton.kt#9igjgp");
                boolean z3 = (i5 & 112) == 32;
                Object objRememberedValue = composer2.rememberedValue();
                if (z3 || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.materialcore.ToggleButtonKt$ToggleButton$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m948invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m948invoke() {
                            function8.invoke(true);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                modifierSemantics$default = SemanticsModifierKt.semantics$default(SelectableKt.selectable-O2vRcR0$default(modifier2, z, mutableInteractionSource, indication, z2, (Role) null, (Function0) objRememberedValue, 16, (Object) null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.ToggleButtonKt$ToggleButton$5
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getRadioButton-o7Vup1c());
                    }
                }, 1, (Object) null);
            }
            composer2.endReplaceGroup();
            Modifier modifierPadding = PaddingKt.padding(modifierThen.then(modifierSemantics$default), paddingValues);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierPadding);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composer4 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer4, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer4.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1364251403, "C236@11022L92,240@11123L130,245@11262L106,250@11377L164:ToggleButton.kt#f7tims");
            int i11 = i5 >> 15;
            f6 = f5;
            m942ToggleButtonIconorJrPs(f6, function5, composer2, ((i6 >> 21) & 14) | (i11 & 112), 0);
            int i12 = ((i5 >> 3) & 112) | 6 | (i11 & 896);
            int i13 = i6 >> 6;
            m938Labelsjt2gSs(rowScope, function3, function6, f3, composer2, i12 | (i13 & 7168), 0);
            f7 = f4;
            SpacerKt.Spacer(SizeKt.size-3ABfNKs(Modifier.Companion, f7), composer2, 0);
            if (function2 == null) {
                Intrinsics.checkNotNull(function4);
                function9 = function4;
            } else {
                function9 = function2;
            }
            composer3 = composer2;
            m943ToggleControlWMci_g0(rowScope, f, f2, function9, composer3, (i13 & 112) | 6 | (i13 & 896));
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function8 = function1;
            f7 = f4;
            f6 = f5;
            composer3 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final float f8 = f6;
            final float f9 = f7;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.ToggleButtonKt$ToggleButton$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer5, int i14) {
                    ToggleButtonKt.m941ToggleButtonULFYh8(z, function8, function3, function2, function4, modifier, function5, function6, function7, z2, mutableInteractionSource, paddingValues, shape, f, f2, f3, f9, f8, indication, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    /* JADX INFO: renamed from: SplitToggleButton-A819N5k, reason: not valid java name */
    public static final void m939SplitToggleButtonA819N5k(final boolean z, Function1<? super Boolean, Unit> function1, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final Function0<Unit> function0, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function4, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function5, final Modifier modifier, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function6, final Function4<? super Boolean, ? super Boolean, ? super Composer, ? super Integer, ? extends State<Color>> function7, final Function4<? super Boolean, ? super Boolean, ? super Composer, ? super Integer, ? extends State<Color>> function8, final boolean z2, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, final PaddingValues paddingValues, final Shape shape, final float f, final Indication indication, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function2;
        int i4;
        Composer composer2;
        String str;
        int i5;
        Object obj;
        final Function1<? super Boolean, Unit> function9;
        Modifier modifierSemantics$default;
        Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function10;
        Composer composerStartRestartGroup = composer.startRestartGroup(1997837406);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SplitToggleButton)P(1,9,6,10,16,13,8,12!1,15,5!3,14,7:c#ui.unit.Dp)331@15685L19,338@15894L33,333@15710L2838:ToggleButton.kt#f7tims");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function2 = function0;
            i3 |= composerStartRestartGroup.changedInstance(function2) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        } else {
            function2 = function0;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function4) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function5) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function6) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function7) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function8) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(z2) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(paddingValues) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((i2 & 196608) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changed(indication) ? 1048576 : 524288;
        }
        int i6 = i4;
        if ((i3 & 306783379) != 306783378 || (599187 & i6) != 599186 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1997837406, i3, i6, "androidx.wear.compose.materialcore.SplitToggleButton (ToggleButton.kt:330)");
            }
            Pair<Modifier, Modifier> pairSplitHorizontally = splitHorizontally(paddingValues, composerStartRestartGroup, (i6 >> 9) & 14);
            Modifier modifier2 = (Modifier) pairSplitHorizontally.component1();
            Modifier modifier3 = (Modifier) pairSplitHorizontally.component2();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            int i7 = (i6 & 14) | ((i3 << 3) & 112);
            Modifier modifier4 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(IntrinsicKt.width(modifier, IntrinsicSize.Max), shape), ((Color) ((State) function7.invoke(Boolean.valueOf(z2), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i7 | ((i3 >> 18) & 896)))).getValue()).unbox-impl(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            int i8 = i3;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composer3 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer3, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer3, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1480918599, "C340@15951L812,367@16795L73,402@18047L177,398@17931L611:ToggleButton.kt#f7tims");
            Modifier modifierWeight$default = RowScope.weight$default(rowScope, SizeKt.fillMaxHeight$default(SemanticsModifierKt.semantics$default(ClickableKt.clickable-O2vRcR0$default(Modifier.Companion, mutableInteractionSource2, indication, z2, (String) null, (Role) null, function2, 24, (Object) null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.ToggleButtonKt$SplitToggleButton$1$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((SemanticsPropertyReceiver) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getButton-o7Vup1c());
                }
            }, 1, (Object) null), 0.0f, 1, (Object) null).then(modifier2), 1.0f, false, 2, (Object) null);
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composer4 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer4, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer4, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1853912291, "C356@16487L146,361@16646L107:ToggleButton.kt#f7tims");
            m938Labelsjt2gSs(rowScope2, function3, function6, f, composerStartRestartGroup, ((i8 >> 3) & 112) | 6 | ((i8 >> 15) & 896) | ((i6 >> 6) & 7168), 0);
            SpacerKt.Spacer(SizeKt.size-3ABfNKs(Modifier.Companion, TOGGLE_CONTROL_SPACING), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final long j = ((Color) ((State) function8.invoke(Boolean.valueOf(z2), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i7 | ((i8 >> 21) & 896)))).getValue()).unbox-impl();
            composerStartRestartGroup.startReplaceGroup(463442796);
            ComposerKt.sourceInformation(composerStartRestartGroup, "386@17445L25");
            if (function4 != null) {
                composer2 = composerStartRestartGroup;
                str = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                i5 = 1;
                obj = null;
                modifierSemantics$default = ToggleableKt.toggleable-O2vRcR0$default(Modifier.Companion, z, mutableInteractionSource, indication, z2, (Role) null, function1, 16, (Object) null);
                function9 = function1;
            } else {
                composer2 = composerStartRestartGroup;
                str = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                i5 = 1;
                obj = null;
                function9 = function1;
                Modifier modifier5 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(composer2, 463458806, "CC(remember):ToggleButton.kt#9igjgp");
                boolean z3 = (i8 & 112) == 32;
                Object objRememberedValue = composer2.rememberedValue();
                if (z3 || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.materialcore.ToggleButtonKt$SplitToggleButton$1$boxModifier$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m947invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m947invoke() {
                            function9.invoke(true);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                modifierSemantics$default = SemanticsModifierKt.semantics$default(SelectableKt.selectable-O2vRcR0$default(modifier5, z, mutableInteractionSource, indication, z2, (Role) null, (Function0) objRememberedValue, 16, (Object) null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.ToggleButtonKt$SplitToggleButton$1$boxModifier$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((SemanticsPropertyReceiver) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getRadioButton-o7Vup1c());
                    }
                }, 1, (Object) null);
            }
            composer2.endReplaceGroup();
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(modifierSemantics$default, 0.0f, i5, obj);
            ComposerKt.sourceInformationMarkerStart(composer2, 463478222, "CC(remember):ToggleButton.kt#9igjgp");
            boolean zChanged = composer2.changed(j);
            Object objRememberedValue2 = composer2.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.ToggleButtonKt$SplitToggleButton$1$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                        final long j2 = j;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.ToggleButtonKt$SplitToggleButton$1$3$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((ContentDrawScope) obj2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                DrawScope.drawRect-n-J9OG0$default((DrawScope) contentDrawScope, j2, 0L, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
                                contentDrawScope.drawContent();
                            }
                        });
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierThen = SizeKt.wrapContentWidth$default(SizeKt.wrapContentHeight$default(SizeKt.width-3ABfNKs(rowScope.align(DrawModifierKt.drawWithCache(modifierFillMaxHeight$default, (Function1) objRememberedValue2), Alignment.Companion.getCenterVertically()), SPLIT_WIDTH), Alignment.Companion.getCenterVertically(), false, 2, obj), Alignment.Companion.getEnd(), false, 2, obj).then(modifier3);
            if (function4 == null) {
                Intrinsics.checkNotNull(function5);
                function10 = function5;
            } else {
                function10 = function4;
            }
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierThen);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            Composer composer5 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer5, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer5.getInserting() || !Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composer5.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.set-impl(composer5, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            function10.invoke(BoxScopeInstance.INSTANCE, composer2, 6);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function9 = function1;
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.ToggleButtonKt$SplitToggleButton$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer6, int i9) {
                    ToggleButtonKt.m939SplitToggleButtonA819N5k(z, function9, function3, function0, function4, function5, modifier, function6, function7, function8, z2, mutableInteractionSource, mutableInteractionSource2, paddingValues, shape, f, indication, composer6, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ToggleButtonIcon--orJrPs, reason: not valid java name */
    public static final void m942ToggleButtonIconorJrPs(final float f, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1417815252);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ToggleButtonIcon)P(1:c#ui.unit.Dp)424@18708L119,428@18836L44:ToggleButton.kt#f7tims");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i3 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                function3 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1417815252, i3, -1, "androidx.wear.compose.materialcore.ToggleButtonIcon (ToggleButton.kt:422)");
            }
            if (function3 != null) {
                Modifier modifierWrapContentSize$default = SizeKt.wrapContentSize$default(Modifier.Companion, Alignment.Companion.getCenter(), false, 2, (Object) null);
                int i5 = ((i3 << 6) & 7168) | 6;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWrapContentSize$default);
                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composer2 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                function3.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i5 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.size-3ABfNKs(Modifier.Companion, f), composerStartRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.ToggleButtonKt$ToggleButtonIcon$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i6) {
                    ToggleButtonKt.m942ToggleButtonIconorJrPs(f, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x0323  */
    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:62:0x0101  */
    /* JADX WARN: Code duplicated, block: B:63:0x0105  */
    /* JADX WARN: Code duplicated, block: B:66:0x012a  */
    /* JADX WARN: Code duplicated, block: B:68:0x0138  */
    /* JADX WARN: Code duplicated, block: B:71:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:74:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:75:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:78:0x01db  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:83:0x0233  */
    /* JADX WARN: Code duplicated, block: B:85:0x0283  */
    /* JADX WARN: Code duplicated, block: B:88:0x028f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0293  */
    /* JADX WARN: Code duplicated, block: B:92:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:94:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:98:0x0319  */
    /* JADX INFO: renamed from: Labels--jt2gSs, reason: not valid java name */
    public static final void m938Labelsjt2gSs(final RowScope rowScope, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4, float f, Composer composer, final int i, final int i2) {
        RowScope rowScope2;
        int i3;
        float f2;
        float f3;
        int currentCompositeKeyHash;
        Function0 constructor;
        Composer composer2;
        Function2 setCompositeKeyHash;
        int currentCompositeKeyHash2;
        Function0 constructor2;
        Composer composer3;
        Function2 setCompositeKeyHash2;
        final float f4;
        int currentCompositeKeyHash3;
        Function0 constructor3;
        Composer composer4;
        Function2 setCompositeKeyHash3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(2056578635);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Labels)P(!,2:c#ui.unit.Dp)438@19065L224:ToggleButton.kt#f7tims");
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i3 = i | 6;
            rowScope2 = rowScope;
        } else {
            rowScope2 = rowScope;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(rowScope2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 1) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i2 & 2) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function4) ? 256 : 128;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                f2 = f;
                i3 |= composerStartRestartGroup.changed(f2) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                if (i4 != 0) {
                    f3 = Dp.constructor-impl(0);
                } else {
                    f3 = f2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2056578635, i3, -1, "androidx.wear.compose.materialcore.Labels (ToggleButton.kt:437)");
                }
                Modifier modifierWeight$default = RowScope.weight$default(rowScope2, Modifier.Companion, 1.0f, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
                constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composer2 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1744902244, "C439@19116L20:ToggleButton.kt#f7tims");
                int i5 = (i3 << 6) & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Modifier modifier = Modifier.Companion;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composer3 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer3, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                function3.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i5 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.startReplaceGroup(220808394);
                ComposerKt.sourceInformation(composerStartRestartGroup, "441@19187L44,442@19244L29");
                if (function4 != null) {
                    SpacerKt.Spacer(SizeKt.size-3ABfNKs(Modifier.Companion, f3), composerStartRestartGroup, 0);
                    int i6 = (i3 << 3) & 7168;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    Modifier modifier2 = Modifier.Companion;
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                    constructor3 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composer4 = Updater.constructor-impl(composerStartRestartGroup);
                    Updater.set-impl(composer4, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composer4.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                    function4.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i6 >> 6) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f4 = f3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f4 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.ToggleButtonKt$Labels$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer5, int i7) {
                        ToggleButtonKt.m938Labelsjt2gSs(rowScope, function3, function4, f4, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        f2 = f;
        if ((i3 & 1171) == 1170) {
            if (i4 != 0) {
                f3 = Dp.constructor-impl(0);
            } else {
                f3 = f2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2056578635, i3, -1, "androidx.wear.compose.materialcore.Labels (ToggleButton.kt:437)");
            }
            Modifier modifierWeight$default2 = RowScope.weight$default(rowScope2, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default2);
            constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composer2 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer2.getInserting()) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1744902244, "C439@19116L20:ToggleButton.kt#f7tims");
            int i7 = (i3 << 6) & 7168;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Modifier modifier3 = Modifier.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
            constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composer3 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer3, measurePolicyRowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer3.getInserting()) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer3, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            function3.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i7 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.startReplaceGroup(220808394);
            ComposerKt.sourceInformation(composerStartRestartGroup, "441@19187L44,442@19244L29");
            if (function4 != null) {
                SpacerKt.Spacer(SizeKt.size-3ABfNKs(Modifier.Companion, f3), composerStartRestartGroup, 0);
                int i8 = (i3 << 3) & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Modifier modifier4 = Modifier.Companion;
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                constructor3 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composer4 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer4, measurePolicyRowMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer4.getInserting()) {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.set-impl(composer4, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                function4.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i8 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f4 = f3;
        } else {
            if (i4 != 0) {
                f3 = Dp.constructor-impl(0);
            } else {
                f3 = f2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2056578635, i3, -1, "androidx.wear.compose.materialcore.Labels (ToggleButton.kt:437)");
            }
            Modifier modifierWeight$default3 = RowScope.weight$default(rowScope2, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default3);
            constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composer2 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer2.getInserting()) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier7, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1744902244, "C439@19116L20:ToggleButton.kt#f7tims");
            int i9 = (i3 << 6) & 7168;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Modifier modifier5 = Modifier.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier5);
            constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composer3 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer3, measurePolicyRowMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer3.getInserting()) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer3, modifierMaterializeModifier8, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            function3.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i9 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.startReplaceGroup(220808394);
            ComposerKt.sourceInformation(composerStartRestartGroup, "441@19187L44,442@19244L29");
            if (function4 != null) {
                SpacerKt.Spacer(SizeKt.size-3ABfNKs(Modifier.Companion, f3), composerStartRestartGroup, 0);
                int i10 = (i3 << 3) & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Modifier modifier6 = Modifier.Companion;
                MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier6);
                constructor3 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composer4 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer4, measurePolicyRowMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer4.getInserting()) {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.set-impl(composer4, modifierMaterializeModifier9, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                function4.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i10 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f4 = f3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.ToggleButtonKt$Labels$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer5, int i11) {
                    ToggleButtonKt.m938Labelsjt2gSs(rowScope, function3, function4, f4, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ToggleControl-WMci_g0, reason: not valid java name */
    public static final void m943ToggleControlWMci_g0(final RowScope rowScope, final float f, final float f2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(59186541);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ToggleControl)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)453@19416L215:ToggleButton.kt#f7tims");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i2 & 1171) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(59186541, i2, -1, "androidx.wear.compose.materialcore.ToggleControl (ToggleButton.kt:452)");
            }
            Modifier modifierWrapContentWidth$default = SizeKt.wrapContentWidth$default(SizeKt.size-VpY3zN4(rowScope.align(Modifier.Companion, Alignment.Companion.getCenterVertically()), f, f2), Alignment.Companion.getEnd(), false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWrapContentWidth$default);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composer2 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1875911124, "C459@19616L9:ToggleButton.kt#f7tims");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 9) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.ToggleButtonKt$ToggleControl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    ToggleButtonKt.m943ToggleControlWMci_g0(rowScope, f, f2, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final Pair<Modifier, Modifier> splitHorizontally(PaddingValues paddingValues, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 879363280, "C(splitHorizontally)466@19776L7,473@20020L7:ToggleButton.kt#f7tims");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(879363280, i, -1, "androidx.wear.compose.materialcore.splitHorizontally (ToggleButton.kt:465)");
        }
        Modifier modifier = Modifier.Companion;
        CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float f = 0;
        Modifier modifier2 = PaddingKt.padding-qDBjuR0(modifier, PaddingKt.calculateStartPadding(paddingValues, (LayoutDirection) objConsume), paddingValues.calculateTopPadding-D9Ej5fM(), Dp.constructor-impl(f), paddingValues.calculateBottomPadding-D9Ej5fM());
        Modifier modifier3 = Modifier.Companion;
        float f2 = Dp.constructor-impl(f);
        CompositionLocal localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localLayoutDirection2);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Pair<Modifier, Modifier> pair = TuplesKt.to(modifier2, PaddingKt.padding-qDBjuR0(modifier3, f2, paddingValues.calculateTopPadding-D9Ej5fM(), PaddingKt.calculateEndPadding(paddingValues, (LayoutDirection) objConsume2), paddingValues.calculateBottomPadding-D9Ej5fM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return pair;
    }
}
