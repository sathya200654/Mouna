package androidx.wear.compose.foundation;

import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.SizeTransform;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SwipeToReveal.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a¦\u0001\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152 \b\u0002\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2 \b\u0002\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\n0\u0013¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u0019\u001a2\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001dH\u0007\u001a\b\u0010!\u001a\u00020\"H\u0002\u001a\b\u0010#\u001a\u00020\"H\u0002\u001a\u0088\u0001\u0010$\u001a\u00020\u00152\b\b\u0002\u0010%\u001a\u00020\u001c2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0'2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020)0\f2.\b\u0002\u0010*\u001a(\u0012\u0004\u0012\u00020,\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u001d0+¢\u0006\u0002\b\u000f2\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a[\u00103\u001a\u00020\n*\u0002042\u0006\u00105\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u00106\u001a\u00020\u001d2\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u00020\u001d082\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u00109\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006:²\u0006\n\u0010;\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010<\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010=\u001a\u00020)X\u008a\u0084\u0002"}, d2 = {"FLASH_ANIMATION", "", "QUICK_ANIMATION", "RAPID_ANIMATION", "SHORT_ANIMATION", "STANDARD_IN_OUT", "Landroidx/compose/animation/core/CubicBezierEasing;", "getSTANDARD_IN_OUT", "()Landroidx/compose/animation/core/CubicBezierEasing;", "SwipeToReveal", "", "primaryAction", "Lkotlin/Function1;", "Landroidx/wear/compose/foundation/RevealScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "onFullSwipe", "Lkotlin/Function0;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/wear/compose/foundation/RevealState;", "secondaryAction", "undoAction", "content", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/wear/compose/foundation/RevealState;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "createAnchors", "", "Landroidx/wear/compose/foundation/RevealValue;", "", "coveredAnchor", "revealingAnchor", "revealedAnchor", "fadeInUndo", "Landroidx/compose/animation/ContentTransform;", "fadeOutUndo", "rememberRevealState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmValueChange", "", "positionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ParameterName;", "name", "totalDistance", "anchors", "rememberRevealState-jPjcZH0", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)Landroidx/wear/compose/foundation/RevealState;", "ActionSlot", "Landroidx/compose/foundation/layout/RowScope;", "revealScope", "weight", "opacity", "Landroidx/compose/runtime/State;", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/wear/compose/foundation/RevealScope;Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/State;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "compose-foundation_release", "swipeCompleted", "showSecondaryAction", "hideActions"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SwipeToRevealKt {
    public static final int FLASH_ANIMATION = 100;
    public static final int QUICK_ANIMATION = 250;
    public static final int RAPID_ANIMATION = 200;
    public static final int SHORT_ANIMATION = 50;
    private static final CubicBezierEasing STANDARD_IN_OUT = new CubicBezierEasing(0.2f, 0.0f, 0.0f, 1.0f);

    public static final CubicBezierEasing getSTANDARD_IN_OUT() {
        return STANDARD_IN_OUT;
    }

    public static /* synthetic */ Map createAnchors$default(float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.7f;
        }
        if ((i & 4) != 0) {
            f3 = 1.0f;
        }
        return createAnchors(f, f2, f3);
    }

    public static final Map<RevealValue, Float> createAnchors(float f, float f2, float f3) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(RevealValue.m398boximpl(RevealValue.INSTANCE.m405getCoveredEhNvi2Q()), Float.valueOf(f)), TuplesKt.to(RevealValue.m398boximpl(RevealValue.INSTANCE.m407getRevealingEhNvi2Q()), Float.valueOf(f2)), TuplesKt.to(RevealValue.m398boximpl(RevealValue.INSTANCE.m406getRevealedEhNvi2Q()), Float.valueOf(f3))});
    }

    /* JADX INFO: renamed from: rememberRevealState-jPjcZH0, reason: not valid java name */
    public static final RevealState m416rememberRevealStatejPjcZH0(int i, AnimationSpec<Float> animationSpec, Function1<? super RevealValue, Boolean> function1, Function2<? super Density, ? super Float, Float> function2, Map<RevealValue, Float> map, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -1103568990, "C(rememberRevealState)P(3:androidx.wear.compose.foundation.RevealValue,1,2,4)354@13144L24,355@13202L37,356@13251L404:SwipeToReveal.kt#m5emhl");
        if ((i3 & 1) != 0) {
            i = RevealValue.INSTANCE.m405getCoveredEhNvi2Q();
        }
        int i4 = i;
        if ((i3 & 2) != 0) {
            animationSpec = (AnimationSpec) SwipeToRevealDefaults.INSTANCE.getAnimationSpec$compose_foundation_release();
        }
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i3 & 4) != 0) {
            function1 = new Function1<RevealValue, Boolean>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt$rememberRevealState$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return m423invokeuhL3PpE(((RevealValue) obj).m404unboximpl());
                }

                /* JADX INFO: renamed from: invoke-uhL3PpE, reason: not valid java name */
                public final Boolean m423invokeuhL3PpE(int i5) {
                    return true;
                }
            };
        }
        Function1<? super RevealValue, Boolean> function3 = function1;
        Function2<? super Density, ? super Float, Float> positionalThreshold$compose_foundation_release = (i3 & 8) != 0 ? SwipeToRevealDefaults.INSTANCE.getPositionalThreshold$compose_foundation_release() : function2;
        Map<RevealValue, Float> mapCreateAnchors$default = (i3 & 16) != 0 ? createAnchors$default(0.0f, 0.0f, 0.0f, 7, null) : map;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1103568990, i2, -1, "androidx.wear.compose.foundation.rememberRevealState (SwipeToReveal.kt:353)");
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
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1452548807, "CC(remember):SwipeToReveal.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new NestedScrollDispatcher();
            composer.updateRememberedValue(objRememberedValue2);
        }
        NestedScrollDispatcher nestedScrollDispatcher = (NestedScrollDispatcher) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1452550742, "CC(remember):SwipeToReveal.kt#9igjgp");
        boolean zChanged = ((((i2 & 14) ^ 6) > 4 && composer.changed(i4)) || (i2 & 6) == 4) | composer.changed(animationSpec2);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged || objRememberedValue3 == Composer.Companion.getEmpty()) {
            RevealState revealState = new RevealState(i4, animationSpec2, function3, positionalThreshold$compose_foundation_release, mapCreateAnchors$default, coroutineScope, nestedScrollDispatcher, null);
            composer.updateRememberedValue(revealState);
            objRememberedValue3 = revealState;
        }
        RevealState revealState2 = (RevealState) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return revealState2;
    }

    /* JADX WARN: Failed to calculate best type for var: r16v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r16v2 ??, new type: kotlin.jvm.functions.Function3
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r16v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r16v2 ??, new type: kotlin.jvm.functions.Function3
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r16v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r16v2 ??, new type: kotlin.jvm.functions.Function3
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r40v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r40v0 ??, new type: kotlin.jvm.functions.Function3<? super androidx.wear.compose.foundation.RevealScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r40v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r40v0 ??, new type: kotlin.jvm.functions.Function3<? super androidx.wear.compose.foundation.RevealScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r40v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r40v0 ??, new type: kotlin.jvm.functions.Function3<? super androidx.wear.compose.foundation.RevealScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to set immutable type for var: r40v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r40v0 ??, new type: kotlin.jvm.functions.Function3<? super androidx.wear.compose.foundation.RevealScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to set immutable type for var: r40v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r40v0 ??, new type: kotlin.jvm.functions.Function3<? super androidx.wear.compose.foundation.RevealScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to set immutable type for var: r40v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r40v0 ??, new type: kotlin.jvm.functions.Function3<? super androidx.wear.compose.foundation.RevealScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r16v2 ??, new type: java.lang.Object
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    public static final void SwipeToReveal(kotlin.jvm.functions.Function3<? super androidx.wear.compose.foundation.RevealScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.ui.Modifier r36, kotlin.jvm.functions.Function0<kotlin.Unit> r37, androidx.wear.compose.foundation.RevealState r38, kotlin.jvm.functions.Function3<? super androidx.wear.compose.foundation.RevealScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, kotlin.jvm.functions.Function3<? super androidx.wear.compose.foundation.RevealScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            Method dump skipped, instruction units count: 1554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.foundation.SwipeToRevealKt.SwipeToReveal(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, androidx.wear.compose.foundation.RevealState, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x0137  */
    /* JADX WARN: Code duplicated, block: B:102:0x013d  */
    /* JADX WARN: Code duplicated, block: B:108:0x0149  */
    /* JADX WARN: Code duplicated, block: B:110:0x0151  */
    /* JADX WARN: Code duplicated, block: B:113:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:116:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:117:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:120:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:122:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:125:0x023f  */
    /* JADX WARN: Code duplicated, block: B:129:0x024b  */
    /* JADX WARN: Code duplicated, block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:40:0x0074  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:45:0x0083  */
    /* JADX WARN: Code duplicated, block: B:50:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x009b  */
    /* JADX WARN: Code duplicated, block: B:55:0x009d  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00df  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ef A[PHI: r3 r4 r10
  0x00ef: PHI (r3v23 int) = (r3v19 int), (r3v24 int) binds: [B:93:0x0100, B:84:0x00ee] A[DONT_GENERATE, DONT_INLINE]
  0x00ef: PHI (r4v15 androidx.compose.ui.Modifier) = (r4v11 androidx.compose.ui.Modifier), (r4v17 androidx.compose.ui.Modifier) binds: [B:93:0x0100, B:84:0x00ee] A[DONT_GENERATE, DONT_INLINE]
  0x00ef: PHI (r10v6 float) = (r10v3 float), (r10v2 float) binds: [B:93:0x0100, B:84:0x00ee] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:86:0x00f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:94:0x0102  */
    /* JADX WARN: Code duplicated, block: B:97:0x0112  */
    public static final void ActionSlot(final RowScope rowScope, final RevealScope revealScope, Modifier modifier, float f, State<Float> state, final Function3<? super RevealScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        RowScope rowScope2;
        int i3;
        Modifier modifier2;
        int i4;
        float f2;
        int i5;
        State<Float> state2;
        int i6;
        Modifier modifier3;
        final State<Float> state3;
        boolean z;
        Object objRememberedValue;
        int currentCompositeKeyHash;
        Function0 constructor;
        Composer composer2;
        Function2 setCompositeKeyHash;
        final Modifier modifier4;
        final float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1693672159);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ActionSlot)P(3,1,4,2)661@27078L25,657@26961L261:SwipeToReveal.kt#m5emhl");
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
            i3 |= (i & 64) == 0 ? composerStartRestartGroup.changed(revealScope) : composerStartRestartGroup.changedInstance(revealScope) ? 32 : 16;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 8) == 0) {
                        state2 = state;
                        int i8 = composerStartRestartGroup.changed(state2) ? 16384 : 8192;
                        i3 |= i8;
                    } else {
                        state2 = state;
                    }
                    i3 |= i8;
                } else {
                    state2 = state;
                }
                if ((i2 & 16) != 0) {
                    i3 |= 196608;
                } else if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i6 = 131072;
                    } else {
                        i6 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i6;
                }
                if ((74899 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -57345;
                        }
                        modifier3 = modifier2;
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            f2 = 1.0f;
                        }
                        if ((i2 & 8) != 0) {
                            state3 = (State) PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
                            i3 &= -57345;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1693672159, i3, -1, "androidx.wear.compose.foundation.ActionSlot (SwipeToReveal.kt:656)");
                        }
                        z = true;
                        Modifier modifierWeight$default = RowScope.weight$default(rowScope2, SizeKt.fillMaxHeight$default(modifier3, 0.0f, 1, (Object) null), f2, false, 2, (Object) null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1638287678, "CC(remember):SwipeToReveal.kt#9igjgp");
                        if ((((57344 & i3) ^ 24576) > 16384 || !composerStartRestartGroup.changed(state3)) && (i3 & 24576) != 16384) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z || objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt$ActionSlot$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((GraphicsLayerScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                    graphicsLayerScope.setAlpha(((Number) state3.getValue()).floatValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierWeight$default, (Function1) objRememberedValue);
                        Alignment center = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer);
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
                        Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 878532904, "C:SwipeToReveal.kt#m5emhl");
                        composerStartRestartGroup.startReplaceGroup(28339771);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*665@27197L9");
                        function3.invoke(revealScope, composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 112));
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
                        modifier4 = modifier3;
                    }
                    state3 = state2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1693672159, i3, -1, "androidx.wear.compose.foundation.ActionSlot (SwipeToReveal.kt:656)");
                    }
                    z = true;
                    Modifier modifierWeight$default2 = RowScope.weight$default(rowScope2, SizeKt.fillMaxHeight$default(modifier3, 0.0f, 1, (Object) null), f2, false, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1638287678, "CC(remember):SwipeToReveal.kt#9igjgp");
                    z = ((57344 & i3) ^ 24576) > 16384 ? false : false;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt$ActionSlot$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((GraphicsLayerScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                graphicsLayerScope.setAlpha(((Number) state3.getValue()).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt$ActionSlot$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((GraphicsLayerScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                graphicsLayerScope.setAlpha(((Number) state3.getValue()).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierGraphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(modifierWeight$default2, (Function1) objRememberedValue);
                    Alignment center2 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer2);
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
                    Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting()) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 878532904, "C:SwipeToReveal.kt#m5emhl");
                    composerStartRestartGroup.startReplaceGroup(28339771);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*665@27197L9");
                    function3.invoke(revealScope, composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 112));
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
                    modifier4 = modifier3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier2;
                    state3 = state2;
                }
                f3 = f2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt.ActionSlot.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i9) {
                            SwipeToRevealKt.ActionSlot(rowScope, revealScope, modifier4, f3, state3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            f2 = f;
            if ((i & 24576) == 0) {
                if ((i2 & 8) == 0) {
                    state2 = state;
                    if (composerStartRestartGroup.changed(state2)) {
                    }
                    i3 |= i8;
                } else {
                    state2 = state;
                }
                i3 |= i8;
            } else {
                state2 = state;
            }
            if ((i2 & 16) != 0) {
                i3 |= 196608;
            } else if ((i & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 131072;
                } else {
                    i6 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i6;
            }
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        f2 = 1.0f;
                    }
                    if ((i2 & 8) != 0) {
                        state3 = (State) PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
                        i3 &= -57345;
                    } else {
                        state3 = state2;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        f2 = 1.0f;
                    }
                    if ((i2 & 8) != 0) {
                        state3 = (State) PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
                        i3 &= -57345;
                    } else {
                        state3 = state2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1693672159, i3, -1, "androidx.wear.compose.foundation.ActionSlot (SwipeToReveal.kt:656)");
                }
                z = true;
                Modifier modifierWeight$default3 = RowScope.weight$default(rowScope2, SizeKt.fillMaxHeight$default(modifier3, 0.0f, 1, (Object) null), f2, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1638287678, "CC(remember):SwipeToReveal.kt#9igjgp");
                if (((57344 & i3) ^ 24576) > 16384) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt$ActionSlot$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((GraphicsLayerScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                            graphicsLayerScope.setAlpha(((Number) state3.getValue()).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt$ActionSlot$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((GraphicsLayerScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                            graphicsLayerScope.setAlpha(((Number) state3.getValue()).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierGraphicsLayer3 = GraphicsLayerModifierKt.graphicsLayer(modifierWeight$default3, (Function1) objRememberedValue);
                Alignment center3 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer3);
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting()) {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 878532904, "C:SwipeToReveal.kt#m5emhl");
                composerStartRestartGroup.startReplaceGroup(28339771);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*665@27197L9");
                function3.invoke(revealScope, composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 112));
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
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        f2 = 1.0f;
                    }
                    if ((i2 & 8) != 0) {
                        state3 = (State) PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
                        i3 &= -57345;
                    } else {
                        state3 = state2;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        f2 = 1.0f;
                    }
                    if ((i2 & 8) != 0) {
                        state3 = (State) PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
                        i3 &= -57345;
                    } else {
                        state3 = state2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1693672159, i3, -1, "androidx.wear.compose.foundation.ActionSlot (SwipeToReveal.kt:656)");
                }
                z = true;
                Modifier modifierWeight$default4 = RowScope.weight$default(rowScope2, SizeKt.fillMaxHeight$default(modifier3, 0.0f, 1, (Object) null), f2, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1638287678, "CC(remember):SwipeToReveal.kt#9igjgp");
                if (((57344 & i3) ^ 24576) > 16384) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt$ActionSlot$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((GraphicsLayerScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                            graphicsLayerScope.setAlpha(((Number) state3.getValue()).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt$ActionSlot$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((GraphicsLayerScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                            graphicsLayerScope.setAlpha(((Number) state3.getValue()).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierGraphicsLayer4 = GraphicsLayerModifierKt.graphicsLayer(modifierWeight$default4, (Function1) objRememberedValue);
                Alignment center4 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer4);
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 878532904, "C:SwipeToReveal.kt#m5emhl");
                composerStartRestartGroup.startReplaceGroup(28339771);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*665@27197L9");
                function3.invoke(revealScope, composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 112));
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
                modifier4 = modifier3;
            }
            f3 = f2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt.ActionSlot.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i9) {
                        SwipeToRevealKt.ActionSlot(rowScope, revealScope, modifier4, f3, state3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
                    i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 8) == 0) {
                    state2 = state;
                    if (composerStartRestartGroup.changed(state2)) {
                    }
                    i3 |= i8;
                } else {
                    state2 = state;
                }
                i3 |= i8;
            } else {
                state2 = state;
            }
            if ((i2 & 16) != 0) {
                i3 |= 196608;
            } else if ((i & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 131072;
                } else {
                    i6 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i6;
            }
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        f2 = 1.0f;
                    }
                    if ((i2 & 8) != 0) {
                        state3 = (State) PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
                        i3 &= -57345;
                    } else {
                        state3 = state2;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        f2 = 1.0f;
                    }
                    if ((i2 & 8) != 0) {
                        state3 = (State) PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
                        i3 &= -57345;
                    } else {
                        state3 = state2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1693672159, i3, -1, "androidx.wear.compose.foundation.ActionSlot (SwipeToReveal.kt:656)");
                }
                z = true;
                Modifier modifierWeight$default5 = RowScope.weight$default(rowScope2, SizeKt.fillMaxHeight$default(modifier3, 0.0f, 1, (Object) null), f2, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1638287678, "CC(remember):SwipeToReveal.kt#9igjgp");
                if (((57344 & i3) ^ 24576) > 16384) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt$ActionSlot$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((GraphicsLayerScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                            graphicsLayerScope.setAlpha(((Number) state3.getValue()).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt$ActionSlot$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((GraphicsLayerScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                            graphicsLayerScope.setAlpha(((Number) state3.getValue()).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierGraphicsLayer5 = GraphicsLayerModifierKt.graphicsLayer(modifierWeight$default5, (Function1) objRememberedValue);
                Alignment center5 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(center5, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer5);
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting()) {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope5 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 878532904, "C:SwipeToReveal.kt#m5emhl");
                composerStartRestartGroup.startReplaceGroup(28339771);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*665@27197L9");
                function3.invoke(revealScope, composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 112));
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
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        f2 = 1.0f;
                    }
                    if ((i2 & 8) != 0) {
                        state3 = (State) PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
                        i3 &= -57345;
                    } else {
                        state3 = state2;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        f2 = 1.0f;
                    }
                    if ((i2 & 8) != 0) {
                        state3 = (State) PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
                        i3 &= -57345;
                    } else {
                        state3 = state2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1693672159, i3, -1, "androidx.wear.compose.foundation.ActionSlot (SwipeToReveal.kt:656)");
                }
                z = true;
                Modifier modifierWeight$default6 = RowScope.weight$default(rowScope2, SizeKt.fillMaxHeight$default(modifier3, 0.0f, 1, (Object) null), f2, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1638287678, "CC(remember):SwipeToReveal.kt#9igjgp");
                if (((57344 & i3) ^ 24576) > 16384) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt$ActionSlot$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((GraphicsLayerScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                            graphicsLayerScope.setAlpha(((Number) state3.getValue()).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt$ActionSlot$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((GraphicsLayerScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                            graphicsLayerScope.setAlpha(((Number) state3.getValue()).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierGraphicsLayer6 = GraphicsLayerModifierKt.graphicsLayer(modifierWeight$default6, (Function1) objRememberedValue);
                Alignment center6 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(center6, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer6);
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting()) {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope6 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 878532904, "C:SwipeToReveal.kt#m5emhl");
                composerStartRestartGroup.startReplaceGroup(28339771);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*665@27197L9");
                function3.invoke(revealScope, composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 112));
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
                modifier4 = modifier3;
            }
            f3 = f2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt.ActionSlot.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i9) {
                        SwipeToRevealKt.ActionSlot(rowScope, revealScope, modifier4, f3, state3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        f2 = f;
        if ((i & 24576) == 0) {
            if ((i2 & 8) == 0) {
                state2 = state;
                if (composerStartRestartGroup.changed(state2)) {
                }
                i3 |= i8;
            } else {
                state2 = state;
            }
            i3 |= i8;
        } else {
            state2 = state;
        }
        if ((i2 & 16) != 0) {
            i3 |= 196608;
        } else if ((i & 196608) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i6 = 131072;
            } else {
                i6 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
            }
            i3 |= i6;
        }
        if ((74899 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    f2 = 1.0f;
                }
                if ((i2 & 8) != 0) {
                    state3 = (State) PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
                    i3 &= -57345;
                } else {
                    state3 = state2;
                }
            } else {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    f2 = 1.0f;
                }
                if ((i2 & 8) != 0) {
                    state3 = (State) PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
                    i3 &= -57345;
                } else {
                    state3 = state2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1693672159, i3, -1, "androidx.wear.compose.foundation.ActionSlot (SwipeToReveal.kt:656)");
            }
            z = true;
            Modifier modifierWeight$default7 = RowScope.weight$default(rowScope2, SizeKt.fillMaxHeight$default(modifier3, 0.0f, 1, (Object) null), f2, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1638287678, "CC(remember):SwipeToReveal.kt#9igjgp");
            if (((57344 & i3) ^ 24576) > 16384) {
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z) {
                objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt$ActionSlot$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GraphicsLayerScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                        graphicsLayerScope.setAlpha(((Number) state3.getValue()).floatValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt$ActionSlot$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GraphicsLayerScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                        graphicsLayerScope.setAlpha(((Number) state3.getValue()).floatValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierGraphicsLayer7 = GraphicsLayerModifierKt.graphicsLayer(modifierWeight$default7, (Function1) objRememberedValue);
            Alignment center7 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(center7, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer7);
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
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.Companion.getSetMeasurePolicy());
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope7 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 878532904, "C:SwipeToReveal.kt#m5emhl");
            composerStartRestartGroup.startReplaceGroup(28339771);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*665@27197L9");
            function3.invoke(revealScope, composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 112));
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
            modifier4 = modifier3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    f2 = 1.0f;
                }
                if ((i2 & 8) != 0) {
                    state3 = (State) PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
                    i3 &= -57345;
                } else {
                    state3 = state2;
                }
            } else {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    f2 = 1.0f;
                }
                if ((i2 & 8) != 0) {
                    state3 = (State) PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
                    i3 &= -57345;
                } else {
                    state3 = state2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1693672159, i3, -1, "androidx.wear.compose.foundation.ActionSlot (SwipeToReveal.kt:656)");
            }
            z = true;
            Modifier modifierWeight$default8 = RowScope.weight$default(rowScope2, SizeKt.fillMaxHeight$default(modifier3, 0.0f, 1, (Object) null), f2, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1638287678, "CC(remember):SwipeToReveal.kt#9igjgp");
            if (((57344 & i3) ^ 24576) > 16384) {
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z) {
                objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt$ActionSlot$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GraphicsLayerScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                        graphicsLayerScope.setAlpha(((Number) state3.getValue()).floatValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt$ActionSlot$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GraphicsLayerScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                        graphicsLayerScope.setAlpha(((Number) state3.getValue()).floatValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierGraphicsLayer8 = GraphicsLayerModifierKt.graphicsLayer(modifierWeight$default8, (Function1) objRememberedValue);
            Alignment center8 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(center8, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer8);
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
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer2.getInserting()) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier8, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope8 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 878532904, "C:SwipeToReveal.kt#m5emhl");
            composerStartRestartGroup.startReplaceGroup(28339771);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*665@27197L9");
            function3.invoke(revealScope, composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 112));
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
            modifier4 = modifier3;
        }
        f3 = f2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.SwipeToRevealKt.ActionSlot.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i9) {
                    SwipeToRevealKt.ActionSlot(rowScope, revealScope, modifier4, f3, state3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform fadeInUndo() {
        return new ContentTransform(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween(200, 100, EasingKt.getLinearEasing()), 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.scaleIn-L8ZKh-E$default(AnimationSpecKt.tween(200, 100, STANDARD_IN_OUT), 1.2f, 0L, 4, (Object) null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, EasingKt.getLinearEasing(), 2, (Object) null), 0.0f, 2, (Object) null), 0.0f, (SizeTransform) null, 12, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform fadeOutUndo() {
        return new ContentTransform(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(0, 50, (Easing) null, 4, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(50, 0, EasingKt.getLinearEasing(), 2, (Object) null), 0.0f, 2, (Object) null), 0.0f, (SizeTransform) null, 12, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SwipeToReveal$lambda$17$lambda$6(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SwipeToReveal$lambda$17$lambda$10(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SwipeToReveal$lambda$17$lambda$12(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }
}
