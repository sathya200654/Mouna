package androidx.wear.compose.materialcore;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.grpc.internal.GrpcUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoundButton.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÂ\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072&\u0010\b\u001a\"\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0002\b\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112(\u0010\u0012\u001a$\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00130\t¢\u0006\u0002\b\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\r¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"RoundButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "backgroundColor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/runtime/Composable;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "border", "Landroidx/compose/foundation/BorderStroke;", "buttonSize", "Landroidx/compose/ui/unit/Dp;", "ripple", "Landroidx/compose/foundation/Indication;", "content", "Landroidx/compose/foundation/layout/BoxScope;", "Lkotlin/ExtensionFunctionType;", "RoundButton-gMrHQkA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/Indication;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "compose-material-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RoundButtonKt {
    /* JADX INFO: renamed from: RoundButton-gMrHQkA, reason: not valid java name */
    public static final void m915RoundButtongMrHQkA(final Function0<Unit> function0, final Modifier modifier, final boolean z, final Function3<? super Boolean, ? super Composer, ? super Integer, Color> function3, final MutableInteractionSource mutableInteractionSource, final Shape shape, final Function3<? super Boolean, ? super Composer, ? super Integer, BorderStroke> function4, final float f, final Indication indication, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function5, Composer composer, final int i) {
        int i2;
        Indication indication2;
        Modifier modifierBorder;
        Composer composerStartRestartGroup = composer.startRestartGroup(-579075568);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RoundButton)P(7,6,4!1,5,9!1,2:c#ui.unit.Dp,8)78@3406L15,96@4059L24,79@3426L735:RoundButton.kt#f7tims");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        }
        if ((100663296 & i) == 0) {
            indication2 = indication;
            i2 |= composerStartRestartGroup.changed(indication2) ? 67108864 : 33554432;
        } else {
            indication2 = indication;
        }
        if ((805306368 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function5) ? 536870912 : 268435456;
        }
        if ((306783379 & i2) != 306783378 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-579075568, i2, -1, "androidx.wear.compose.materialcore.RoundButton (RoundButton.kt:77)");
            }
            int i3 = i2 >> 6;
            BorderStroke borderStroke = (BorderStroke) function4.invoke(Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf((i3 & 14) | ((i2 >> 15) & 112)));
            Alignment center = Alignment.Companion.getCenter();
            int i4 = i2;
            Modifier modifier2 = ClickableKt.clickable-O2vRcR0$default(ClipKt.clip(SizeKt.size-3ABfNKs(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.RoundButtonKt$RoundButton$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getButton-o7Vup1c());
                }
            }, 1, (Object) null), f), shape), mutableInteractionSource, indication2, z, (String) null, (Role) null, function0, 24, (Object) null);
            if (borderStroke != null) {
                modifierBorder = BorderKt.border(Modifier.Companion, borderStroke, shape);
            } else {
                modifierBorder = Modifier.Companion;
            }
            Modifier modifier3 = BackgroundKt.background-bw27NRU(modifier2.then(modifierBorder), ((Color) function3.invoke(Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i3 & 126))).unbox-impl(), shape);
            int i5 = ((i4 >> 18) & 7168) | 48;
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
            function5.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i5 >> 6) & 112) | 6));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.RoundButtonKt$RoundButton$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i6) {
                    RoundButtonKt.m915RoundButtongMrHQkA(function0, modifier, z, function3, mutableInteractionSource, shape, function4, f, indication, function5, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
