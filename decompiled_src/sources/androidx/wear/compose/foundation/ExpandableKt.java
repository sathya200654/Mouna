package androidx.wear.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.wear.compose.foundation.lazy.ScalingLazyListItemScope;
import androidx.wear.compose.foundation.lazy.ScalingLazyListScope;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Expandable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\b\u001a^\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b2#\b\u0002\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00030\f2\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0010\u001a6\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00120\u0017¢\u0006\u0002\b\u0018¢\u0006\u0002\u0010\u0019\u001aK\u0010\u001a\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00152&\u0010\u0016\u001a\"\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00120\f¢\u0006\u0002\b\u0018¢\u0006\u0002\u0010\u001c\u001aW\u0010\u001d\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u00032&\u0010\u0016\u001a\"\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00120\f¢\u0006\u0002\b\u0018H\u0002¢\u0006\u0002\u0010\u001f\u001ay\u0010 \u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\"¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f21\u0010$\u001a-\u0012\u0004\u0012\u00020&\u0012\u0013\u0012\u00110\"¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00120%¢\u0006\u0002\b\u0018¢\u0006\u0002\b'¢\u0006\u0002\u0010(¨\u0006)"}, d2 = {"rememberExpandableState", "Landroidx/wear/compose/foundation/ExpandableState;", "initiallyExpanded", "", "expandAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "collapseAnimationSpec", "(ZLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/wear/compose/foundation/ExpandableState;", "rememberExpandableStateMapping", "Landroidx/wear/compose/foundation/ExpandableStateMapping;", "T", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "key", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/wear/compose/foundation/ExpandableStateMapping;", "expandableButton", "", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListScope;", RemoteConfigConstants.ResponseFieldKey.STATE, "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/wear/compose/foundation/lazy/ScalingLazyListScope;Landroidx/wear/compose/foundation/ExpandableState;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "expandableItem", "expanded", "(Landroidx/wear/compose/foundation/lazy/ScalingLazyListScope;Landroidx/wear/compose/foundation/ExpandableState;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "expandableItemImpl", "invertProgress", "(Landroidx/wear/compose/foundation/lazy/ScalingLazyListScope;Landroidx/wear/compose/foundation/ExpandableState;Ljava/lang/Object;ZLkotlin/jvm/functions/Function3;)V", "expandableItems", "count", "", "index", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/BoxScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/wear/compose/foundation/lazy/ScalingLazyListScope;Landroidx/wear/compose/foundation/ExpandableState;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "compose-foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExpandableKt {
    public static final ExpandableState rememberExpandableState(final boolean z, final AnimationSpec<Float> animationSpec, final AnimationSpec<Float> animationSpec2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1491120788, "C(rememberExpandableState)P(2,1)58@2416L24,60@2502L130,64@2639L101,59@2452L288:Expandable.kt#m5emhl");
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            animationSpec = ExpandableItemsDefaults.INSTANCE.getExpandAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            animationSpec2 = ExpandableItemsDefaults.INSTANCE.getCollapseAnimationSpec();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1491120788, i, -1, "androidx.wear.compose.foundation.rememberExpandableState (Expandable.kt:57)");
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
        Object[] objArr = new Object[0];
        int i3 = i >> 3;
        Saver<ExpandableState, Boolean> saver = ExpandableState.INSTANCE.saver(animationSpec, animationSpec2, composer, (i3 & 112) | (i3 & 14) | 384);
        ComposerKt.sourceInformationMarkerStart(composer, 850641568, "CC(remember):Expandable.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(coroutineScope) | ((((i & 14) ^ 6) > 4 && composer.changed(z)) || (i & 6) == 4) | composer.changedInstance(animationSpec) | composer.changedInstance(animationSpec2);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = (Function0) new Function0<ExpandableState>() { // from class: androidx.wear.compose.foundation.ExpandableKt$rememberExpandableState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final ExpandableState m372invoke() {
                    return new ExpandableState(z, coroutineScope, animationSpec, animationSpec2);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ExpandableState expandableState = (ExpandableState) RememberSaveableKt.rememberSaveable(objArr, saver, (String) null, (Function0) objRememberedValue2, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return expandableState;
    }

    public static final <T> ExpandableStateMapping<T> rememberExpandableStateMapping(Function1<? super T, Boolean> function1, AnimationSpec<Float> animationSpec, AnimationSpec<Float> animationSpec2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1941804145, "C(rememberExpandableStateMapping)P(2,1)87@3770L24,88@3806L117:Expandable.kt#m5emhl");
        if ((i2 & 1) != 0) {
            function1 = new Function1<T, Boolean>() { // from class: androidx.wear.compose.foundation.ExpandableKt.rememberExpandableStateMapping.1
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Boolean m373invoke(T t) {
                    return false;
                }
            };
        }
        if ((i2 & 2) != 0) {
            animationSpec = ExpandableItemsDefaults.INSTANCE.getExpandAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            animationSpec2 = ExpandableItemsDefaults.INSTANCE.getCollapseAnimationSpec();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1941804145, i, -1, "androidx.wear.compose.foundation.rememberExpandableStateMapping (Expandable.kt:86)");
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
        ComposerKt.sourceInformationMarkerStart(composer, 434017448, "CC(remember):Expandable.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new ExpandableStateMapping(function1, coroutineScope, animationSpec, animationSpec2);
            composer.updateRememberedValue(objRememberedValue2);
        }
        ExpandableStateMapping<T> expandableStateMapping = (ExpandableStateMapping) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return expandableStateMapping;
    }

    public static /* synthetic */ void expandableItems$default(ScalingLazyListScope scalingLazyListScope, ExpandableState expandableState, int i, Function1 function1, Function4 function4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        expandableItems(scalingLazyListScope, expandableState, i, function1, function4);
    }

    public static final void expandableItems(ScalingLazyListScope scalingLazyListScope, ExpandableState expandableState, int i, Function1<? super Integer, ? extends Object> function1, final Function4<? super BoxScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
        for (final int i2 = 0; i2 < i; i2++) {
            final float fCoerceIn = RangesKt.coerceIn((expandableState.getExpandProgress() * i) - ((i - 1) - i2), 0.0f, 1.0f);
            if (fCoerceIn > 0.0f) {
                scalingLazyListScope.item(function1 != null ? function1.invoke(Integer.valueOf(i2)) : null, (Function3) ComposableLambdaKt.composableLambdaInstance(-1091223447, true, new Function3<ScalingLazyListItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.ExpandableKt$expandableItems$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((ScalingLazyListItemScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ScalingLazyListItemScope scalingLazyListItemScope, Composer composer, int i3) {
                        ComposerKt.sourceInformation(composer, "C125@5543L440,122@5385L598:Expandable.kt#m5emhl");
                        if ((i3 & 17) != 16 || !composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1091223447, i3, -1, "androidx.wear.compose.foundation.expandableItems.<anonymous>.<anonymous> (Expandable.kt:122)");
                            }
                            Modifier modifierClipToBounds = ClipKt.clipToBounds(Modifier.Companion);
                            ComposerKt.sourceInformationMarkerStart(composer, -759521043, "CC(remember):Expandable.kt#9igjgp");
                            boolean zChanged = composer.changed(fCoerceIn);
                            final float f = fCoerceIn;
                            MeasurePolicy measurePolicyRememberedValue = composer.rememberedValue();
                            if (zChanged || measurePolicyRememberedValue == Composer.Companion.getEmpty()) {
                                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.ExpandableKt$expandableItems$1$1$1$1
                                    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                    public final MeasureResult m371measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                        final Placeable placeable = ((Measurable) CollectionsKt.first(list)).measure-BRTryo0(j);
                                        int iRoundToInt = MathKt.roundToInt(placeable.getHeight() * f);
                                        int width = placeable.getWidth();
                                        final float f2 = f;
                                        return MeasureScope.layout$default(measureScope, width, iRoundToInt, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.ExpandableKt$expandableItems$1$1$1$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((Placeable.PlacementScope) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Placeable.PlacementScope placementScope) {
                                                Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, 0, MathKt.roundToInt(placeable.getHeight() * (f2 - 1)), 0.0f, (Function1) null, 12, (Object) null);
                                            }
                                        }, 4, (Object) null);
                                    }
                                };
                                composer.updateRememberedValue(measurePolicyRememberedValue);
                            }
                            MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            Function4<BoxScope, Integer, Composer, Integer, Unit> function5 = function4;
                            int i4 = i2;
                            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierClipToBounds);
                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer.startReusableNode();
                            if (composer.getInserting()) {
                                composer.createNode(constructor);
                            } else {
                                composer.useNode();
                            }
                            Composer composer2 = Updater.constructor-impl(composer);
                            Updater.set-impl(composer2, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer, -1624620666, "C124@5481L41:Expandable.kt#m5emhl");
                            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            Modifier modifier = Modifier.Companion;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifier);
                            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer.startReusableNode();
                            if (composer.getInserting()) {
                                composer.createNode(constructor2);
                            } else {
                                composer.useNode();
                            }
                            Composer composer3 = Updater.constructor-impl(composer);
                            Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer, -55420646, "C124@5497L22:Expandable.kt#m5emhl");
                            function5.invoke(boxScope, Integer.valueOf(i4), composer, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer.skipToGroupEnd();
                    }
                }));
            }
        }
    }

    public static /* synthetic */ void expandableItem$default(ScalingLazyListScope scalingLazyListScope, ExpandableState expandableState, Object obj, Function3 function3, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        expandableItem(scalingLazyListScope, expandableState, obj, function3);
    }

    public static final void expandableItem(ScalingLazyListScope scalingLazyListScope, ExpandableState expandableState, Object obj, Function3<? super Boolean, ? super Composer, ? super Integer, Unit> function3) {
        expandableItemImpl$default(scalingLazyListScope, expandableState, obj, false, function3, 4, null);
    }

    public static /* synthetic */ void expandableButton$default(ScalingLazyListScope scalingLazyListScope, ExpandableState expandableState, Object obj, Function2 function2, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        expandableButton(scalingLazyListScope, expandableState, obj, function2);
    }

    public static final void expandableButton(ScalingLazyListScope scalingLazyListScope, ExpandableState expandableState, Object obj, final Function2<? super Composer, ? super Integer, Unit> function2) {
        expandableItemImpl(scalingLazyListScope, expandableState, obj, true, ComposableLambdaKt.composableLambdaInstance(747621844, true, new Function3<Boolean, Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.ExpandableKt.expandableButton.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                invoke(((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z, Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C182@8382L9:Expandable.kt#m5emhl");
                if ((i & 6) == 0) {
                    i |= composer.changed(z) ? 4 : 2;
                }
                if ((i & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(747621844, i, -1, "androidx.wear.compose.foundation.expandableButton.<anonymous> (Expandable.kt:182)");
                }
                if (z) {
                    function2.invoke(composer, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    static /* synthetic */ void expandableItemImpl$default(ScalingLazyListScope scalingLazyListScope, ExpandableState expandableState, Object obj, boolean z, Function3 function3, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        expandableItemImpl(scalingLazyListScope, expandableState, obj, z, function3);
    }

    private static final void expandableItemImpl(ScalingLazyListScope scalingLazyListScope, final ExpandableState expandableState, Object obj, final boolean z, final Function3<? super Boolean, ? super Composer, ? super Integer, Unit> function3) {
        scalingLazyListScope.item(obj, (Function3) ComposableLambdaKt.composableLambdaInstance(512528196, true, new Function3<ScalingLazyListItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.ExpandableKt.expandableItemImpl.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                invoke((ScalingLazyListItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ScalingLazyListItemScope scalingLazyListItemScope, Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C197@8804L959,191@8623L1140:Expandable.kt#m5emhl");
                if ((i & 17) != 16 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(512528196, i, -1, "androidx.wear.compose.foundation.expandableItemImpl.<anonymous> (Expandable.kt:191)");
                    }
                    Function3<Boolean, Composer, Integer, Unit> function4 = function3;
                    Modifier modifierClipToBounds = ClipKt.clipToBounds(Modifier.Companion);
                    ComposerKt.sourceInformationMarkerStart(composer, 389896666, "CC(remember):Expandable.kt#9igjgp");
                    boolean zChanged = composer.changed(z) | composer.changedInstance(expandableState);
                    final boolean z2 = z;
                    final ExpandableState expandableState2 = expandableState;
                    MeasurePolicy measurePolicyRememberedValue = composer.rememberedValue();
                    if (zChanged || measurePolicyRememberedValue == Composer.Companion.getEmpty()) {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.ExpandableKt$expandableItemImpl$1$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m370measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                boolean z3 = z2;
                                ExpandableState expandableState3 = expandableState2;
                                final float expandProgress = z3 ? 1.0f - expandableState3.getExpandProgress() : expandableState3.getExpandProgress();
                                ArrayList arrayList = new ArrayList(list.size());
                                int size = list.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    arrayList.add(list.get(i2).measure-BRTryo0(j));
                                }
                                final ArrayList arrayList2 = arrayList;
                                int iLerp = MathHelpersKt.lerp(((Placeable) arrayList2.get(0)).getWidth(), ((Placeable) arrayList2.get(1)).getWidth(), expandProgress);
                                int iLerp2 = MathHelpersKt.lerp(((Placeable) arrayList2.get(0)).getHeight(), ((Placeable) arrayList2.get(1)).getHeight(), expandProgress);
                                final int width = (iLerp - ((Placeable) arrayList2.get(0)).getWidth()) / 2;
                                final int width2 = (iLerp - ((Placeable) arrayList2.get(1)).getWidth()) / 2;
                                return MeasureScope.layout$default(measureScope, iLerp, iLerp2, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.ExpandableKt$expandableItemImpl$1$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((Placeable.PlacementScope) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        Placeable.PlacementScope placementScope2;
                                        if (expandProgress < 1.0f) {
                                            Placeable placeable = arrayList2.get(0);
                                            int i3 = width;
                                            float f = 1 - expandProgress;
                                            final float f2 = expandProgress;
                                            Function1<GraphicsLayerScope, Unit> function1 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.ExpandableKt.expandableItemImpl.1.2.1.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                                    invoke((GraphicsLayerScope) obj2);
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                                    graphicsLayerScope.setAlpha(1 - f2);
                                                }
                                            };
                                            placementScope2 = placementScope;
                                            placementScope2.placeWithLayer(placeable, i3, 0, f, function1);
                                        } else {
                                            placementScope2 = placementScope;
                                        }
                                        if (expandProgress > 0.0f) {
                                            Placeable placeable2 = arrayList2.get(1);
                                            int i4 = width2;
                                            float f3 = expandProgress;
                                            final float f4 = expandProgress;
                                            placementScope2.placeWithLayer(placeable2, i4, 0, f3, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.foundation.ExpandableKt.expandableItemImpl.1.2.1.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                                    invoke((GraphicsLayerScope) obj2);
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                                    graphicsLayerScope.setAlpha(f4);
                                                }
                                            });
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composer.updateRememberedValue(measurePolicyRememberedValue);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierClipToBounds);
                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor);
                    } else {
                        composer.useNode();
                    }
                    Composer composer2 = Updater.constructor-impl(composer);
                    Updater.set-impl(composer2, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer, 310964109, "C193@8671L22,194@8710L21:Expandable.kt#m5emhl");
                    ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Modifier modifier = Modifier.Companion;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifier);
                    Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor2);
                    } else {
                        composer.useNode();
                    }
                    Composer composer3 = Updater.constructor-impl(composer);
                    Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer, -302057956, "C193@8677L14:Expandable.kt#m5emhl");
                    function4.invoke(false, composer, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Modifier modifier2 = Modifier.Companion;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifier2);
                    Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor3);
                    } else {
                        composer.useNode();
                    }
                    Composer composer4 = Updater.constructor-impl(composer);
                    Updater.set-impl(composer4, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composer4.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer, -302019299, "C194@8716L13:Expandable.kt#m5emhl");
                    function4.invoke(true, composer, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }));
    }
}
