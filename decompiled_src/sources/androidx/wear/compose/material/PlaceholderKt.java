package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.wear.compose.foundation.ReduceMotion;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Placeholder.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\u0010\u000b\u001a*\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a2\u0010\u0015\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a2\u0010\u001b\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"PLACEHOLDER_RESET_ANIMATION_DURATION", "", "PLACEHOLDER_SHIMMER_DURATION_MS", "PLACEHOLDER_SHIMMER_GAP_BETWEEN_ANIMATION_LOOPS_MS", "PLACEHOLDER_WIPE_OFF_PROGRESSION_ALPHA_DURATION_MS", "PLACEHOLDER_WIPE_OFF_PROGRESSION_DURATION_MS", "rememberPlaceholderState", "Landroidx/wear/compose/material/PlaceholderState;", "isContentReady", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Landroidx/wear/compose/material/PlaceholderState;", "wipeOffBrush", "Landroidx/compose/ui/graphics/Brush;", "color", "Landroidx/compose/ui/graphics/Color;", "offset", "Landroidx/compose/ui/geometry/Offset;", "placeholderState", "wipeOffBrush-qcb84PM", "(JJLandroidx/wear/compose/material/PlaceholderState;)Landroidx/compose/ui/graphics/Brush;", "placeholder", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "placeholder-ww6aTOc", "(Landroidx/compose/ui/Modifier;Landroidx/wear/compose/material/PlaceholderState;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "placeholderShimmer", "placeholderShimmer-ww6aTOc", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlaceholderKt {
    public static final long PLACEHOLDER_RESET_ANIMATION_DURATION = 400;
    public static final long PLACEHOLDER_SHIMMER_DURATION_MS = 800;
    public static final long PLACEHOLDER_SHIMMER_GAP_BETWEEN_ANIMATION_LOOPS_MS = 2000;
    public static final long PLACEHOLDER_WIPE_OFF_PROGRESSION_ALPHA_DURATION_MS = 80;
    public static final long PLACEHOLDER_WIPE_OFF_PROGRESSION_DURATION_MS = 300;

    public static final PlaceholderState rememberPlaceholderState(Function0<Boolean> function0, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 931673861, "C(rememberPlaceholderState)361@16979L7,361@16987L9,362@17021L36,363@17069L145:Placeholder.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(931673861, i, -1, "androidx.wear.compose.material.rememberPlaceholderState (Placeholder.kt:357)");
        }
        composer.startReplaceGroup(1316795058);
        ComposerKt.sourceInformation(composer, "*358@16844L7,359@16870L16,359@16888L15");
        CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float f = ((Density) objConsume).toPx-0680j_4(Dp.constructor-impl(Math.max(ResourcesKt.screenHeightDp(composer, 0), ResourcesKt.screenWidthDp(composer, 0))));
        composer.endReplaceGroup();
        CompositionLocal localReduceMotion = androidx.wear.compose.foundation.CompositionLocalsKt.getLocalReduceMotion();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localReduceMotion);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean zEnabled = ((ReduceMotion) objConsume2).enabled(composer, 0);
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function0, composer, i & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 1316802877, "CC(remember):Placeholder.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new PlaceholderState(stateRememberUpdatedState, f, zEnabled);
            composer.updateRememberedValue(objRememberedValue);
        }
        PlaceholderState placeholderState = (PlaceholderState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return placeholderState;
    }

    /* JADX INFO: renamed from: placeholder-ww6aTOc, reason: not valid java name */
    public static final Modifier m663placeholderww6aTOc(Modifier modifier, PlaceholderState placeholderState, Shape shape, long j, Composer composer, int i, int i2) {
        final PlaceholderState placeholderState2;
        Function1<InspectorInfo, Unit> noInspectorInfo;
        ComposerKt.sourceInformationMarkerStart(composer, -1590215285, "C(placeholder)P(1,2,0:c#ui.graphics.Color)401@18737L6,403@18792L6,404@18869L6:Placeholder.kt#gj9v0t");
        final Shape shape2 = (i2 & 2) != 0 ? (Shape) MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall() : shape;
        final long j2 = (i2 & 4) != 0 ? ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).getSurface()) : j;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1590215285, i, -1, "androidx.wear.compose.material.placeholder (Placeholder.kt:405)");
        }
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            placeholderState2 = placeholderState;
            noInspectorInfo = new Function1<InspectorInfo, Unit>() { // from class: androidx.wear.compose.material.PlaceholderKt$placeholder-ww6aTOc$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((InspectorInfo) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("placeholder");
                    inspectorInfo.getProperties().set("placeholderState", placeholderState2);
                    inspectorInfo.getProperties().set("shape", shape2);
                    inspectorInfo.getProperties().set("color", Color.box-impl(j2));
                }
            };
        } else {
            placeholderState2 = placeholderState;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        Modifier modifier2 = Modifier.Companion;
        Modifier modifierInspectableWrapper = InspectableValueKt.inspectableWrapper(modifier, noInspectorInfo, new PlaceholderModifier(placeholderState2, j2, 0.0f, shape2, 4, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return modifierInspectableWrapper;
    }

    /* JADX INFO: renamed from: placeholderShimmer-ww6aTOc, reason: not valid java name */
    public static final Modifier m664placeholderShimmerww6aTOc(Modifier modifier, final PlaceholderState placeholderState, Shape shape, long j, Composer composer, int i, int i2) {
        Modifier placeholderShimmerModifier;
        ComposerKt.sourceInformationMarkerStart(composer, -126590946, "C(placeholderShimmer)P(1,2,0:c#ui.graphics.Color)453@20980L6,454@21027L6:Placeholder.kt#gj9v0t");
        if ((i2 & 2) != 0) {
            shape = (Shape) MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall();
        }
        final Shape shape2 = shape;
        final long onSurface = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface() : j;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-126590946, i, -1, "androidx.wear.compose.material.placeholderShimmer (Placeholder.kt:455)");
        }
        composer.startReplaceGroup(-2074241603);
        ComposerKt.sourceInformation(composer, "463@21315L7,463@21323L9");
        Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.wear.compose.material.PlaceholderKt$placeholderShimmer-ww6aTOc$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("placeholderShimmer");
                inspectorInfo.getProperties().set("placeholderState", placeholderState);
                inspectorInfo.getProperties().set("shape", shape2);
                inspectorInfo.getProperties().set("color", Color.box-impl(onSurface));
            }
        } : InspectableValueKt.getNoInspectorInfo();
        Modifier modifier2 = Modifier.Companion;
        CompositionLocal localReduceMotion = androidx.wear.compose.foundation.CompositionLocalsKt.getLocalReduceMotion();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localReduceMotion);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (((ReduceMotion) objConsume).enabled(composer, 0)) {
            placeholderShimmerModifier = (Modifier) Modifier.Companion;
        } else {
            placeholderShimmerModifier = new PlaceholderShimmerModifier(placeholderState, onSurface, 0.0f, shape2, 4, null);
        }
        Modifier modifierInspectableWrapper = InspectableValueKt.inspectableWrapper(modifier, noInspectorInfo, placeholderShimmerModifier);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return modifierInspectableWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: wipeOffBrush-qcb84PM, reason: not valid java name */
    public static final Brush m665wipeOffBrushqcb84PM(long j, long j2, PlaceholderState placeholderState) {
        float gradientXYWidth$compose_material_release = placeholderState.getGradientXYWidth$compose_material_release() / 2.0f;
        Brush.Companion companion = Brush.Companion;
        Pair[] pairArr = (Pair[]) CollectionsKt.listOf(new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.box-impl(Color.Companion.getTransparent-0d7_KjU())), TuplesKt.to(Float.valueOf(0.75f), Color.box-impl(j))}).toArray(new Pair[0]);
        return Brush.Companion.linearGradient-mHitzGk$default(companion, (Pair[]) Arrays.copyOf(pairArr, pairArr.length), OffsetKt.Offset((placeholderState.getPlaceholderWipeOffProgression$compose_material_release() - gradientXYWidth$compose_material_release) - Offset.getX-impl(j2), (placeholderState.getPlaceholderWipeOffProgression$compose_material_release() - gradientXYWidth$compose_material_release) - Offset.getY-impl(j2)), OffsetKt.Offset((placeholderState.getPlaceholderWipeOffProgression$compose_material_release() + gradientXYWidth$compose_material_release) - Offset.getX-impl(j2), (placeholderState.getPlaceholderWipeOffProgression$compose_material_release() + gradientXYWidth$compose_material_release) - Offset.getY-impl(j2)), 0, 8, (Object) null);
    }
}
