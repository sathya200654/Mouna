package androidx.wear.compose.materialcore;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u0002H\u00112\u0006\u0010\u0015\u001a\u0002H\u0011H\u0007¢\u0006\u0002\u0010\u0016\u001aß\u0002\u0010\u0017\u001a\u00020\u000b*\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00132`\u0010\"\u001a\\\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110 ¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110'¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010#2`\u0010)\u001a\\\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110 ¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110'¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010#2K\u0010*\u001aG\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110 ¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110'¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010+H\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"InlineSliderButton", "", "enabled", "", "onClick", "Lkotlin/Function0;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "buttonControlSize", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/runtime/Composable;", "InlineSliderButton-hGBTI10", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Alignment;FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "directedValue", "T", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "ltrValue", "rtlValue", "(Landroidx/compose/ui/unit/LayoutDirection;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "drawProgressBar", "selectedBarColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "unselectedBarColor", "barSeparatorColor", "visibleSegments", "", "valueRatio", "", "direction", "drawSelectedProgressBar", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "color", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawScope", "drawUnselectedProgressBar", "drawProgressBarSeparator", "Lkotlin/Function3;", "position", "compose-material-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SliderKt {
    /* JADX INFO: renamed from: InlineSliderButton-hGBTI10, reason: not valid java name */
    public static final void m932InlineSliderButtonhGBTI10(final boolean z, final Function0<Unit> function0, final Alignment alignment, final float f, final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Function0<Unit> function1;
        Composer composerStartRestartGroup = composer.startRestartGroup(1211989041);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InlineSliderButton)P(3,5,2,0:c#ui.unit.Dp,4)51@1837L7,43@1546L417:Slider.kt#f7tims");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            function1 = function0;
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(alignment) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((74899 & i2) != 74898 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1211989041, i2, -1, "androidx.wear.compose.materialcore.InlineSliderButton (Slider.kt:42)");
            }
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, f), 0.0f, 1, (Object) null);
            CompositionLocal localIndication = IndicationKt.getLocalIndication();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localIndication);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function0<Unit> function3 = function1;
            Modifier modifierThen = RepeatableClickableKt.m912repeatableClickableXVZzFYc(modifierFillMaxHeight$default, null, (Indication) objConsume, (376 & 4) != 0 ? true : z, (376 & 8) != 0 ? null : null, (376 & 16) != 0 ? null : null, (376 & 32) != 0 ? 500L : 0L, (376 & 64) != 0 ? 60L : 0L, function3, (376 & 256) != 0 ? function3 : null).then(modifier);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 67793197, "C56@1948L9:Slider.kt#f7tims");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 15) & 14));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.SliderKt$InlineSliderButton$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    SliderKt.m932InlineSliderButtonhGBTI10(z, function0, alignment, f, modifier, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final Modifier drawProgressBar(Modifier modifier, final State<Color> state, final State<Color> state2, final State<Color> state3, final int i, final float f, final LayoutDirection layoutDirection, final Function4<? super Color, ? super Float, ? super LayoutDirection, ? super DrawScope, Unit> function4, final Function4<? super Color, ? super Float, ? super LayoutDirection, ? super DrawScope, Unit> function5, final Function3<? super Color, ? super Float, ? super DrawScope, Unit> function3) {
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SliderKt.drawProgressBar.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                function5.invoke(state2.getValue(), Float.valueOf(f), layoutDirection, contentDrawScope);
                function4.invoke(state.getValue(), Float.valueOf(f), layoutDirection, contentDrawScope);
                for (int i2 = 1; i2 < i; i2++) {
                    function3.invoke(state3.getValue(), Float.valueOf((i2 * Size.getWidth-impl(contentDrawScope.getSize-NH-jbRc())) / i), contentDrawScope);
                }
            }
        });
    }

    public static final <T> T directedValue(LayoutDirection layoutDirection, T t, T t2) {
        return layoutDirection == LayoutDirection.Ltr ? t : t2;
    }
}
