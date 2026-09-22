package androidx.wear.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0002\u001a$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0002\u001aZ\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0000\u0010\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\u000e2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122#\b\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0014H\u0007¢\u0006\u0002\u0010\u0019\u001a-\u0010\u001a\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u000e*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u000e0\u001b2\u0006\u0010\u001c\u001a\u0002H\u000eH\u0002¢\u0006\u0002\u0010\u001d\u001a¶\u0001\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0000\u0010\u000e*\u00020\u001f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u000e0\u001b2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u00182\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%28\b\u0002\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(&\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(0\u00072\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010\t\u001a\u00020+H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"computeTarget", "", "offset", "lastValue", "anchors", "", "thresholds", "Lkotlin/Function2;", "velocity", "velocityThreshold", "findBounds", "", "rememberSwipeableState", "Landroidx/wear/compose/material/SwipeableState;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/SwipeableState;", "getOffset", "", RemoteConfigConstants.ResponseFieldKey.STATE, "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Float;", "swipeable", "Landroidx/compose/ui/Modifier;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", Constants.MessagePayloadKeys.FROM, "to", "Landroidx/wear/compose/material/ThresholdConfig;", "resistance", "Landroidx/wear/compose/material/ResistanceConfig;", "Landroidx/compose/ui/unit/Dp;", "swipeable-pPrIpRY", "(Landroidx/compose/ui/Modifier;Landroidx/wear/compose/material/SwipeableState;Ljava/util/Map;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/wear/compose/material/ResistanceConfig;F)Landroidx/compose/ui/Modifier;", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SwipeableKt {
    public static final <T> SwipeableState<T> rememberSwipeableState(final T t, final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -148890656, "C(rememberSwipeableState)P(2)492@19951L178,487@19783L346:Swipeable.kt#gj9v0t");
        if ((i2 & 2) != 0) {
            animationSpec = (AnimationSpec) SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<T, Boolean>() { // from class: androidx.wear.compose.material.SwipeableKt.rememberSwipeableState.1
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Boolean m833invoke(T t2) {
                    return true;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-148890656, i, -1, "androidx.wear.compose.material.rememberSwipeableState (Swipeable.kt:486)");
        }
        Object[] objArr = new Object[0];
        Saver<SwipeableState<T>, T> Saver = SwipeableState.Companion.Saver(animationSpec, function1);
        ComposerKt.sourceInformationMarkerStart(composer, 1104589789, "CC(remember):Swipeable.kt#9igjgp");
        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changedInstance(t)) || (i & 6) == 4) | composer.changedInstance(animationSpec) | ((((i & 896) ^ 384) > 256 && composer.changed(function1)) || (i & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = (Function0) new Function0<SwipeableState<T>>() { // from class: androidx.wear.compose.material.SwipeableKt$rememberSwipeableState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final SwipeableState<T> m834invoke() {
                    return new SwipeableState<>(t, animationSpec, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SwipeableState<T> swipeableState = (SwipeableState) RememberSaveableKt.rememberSaveable(objArr, Saver, (String) null, (Function0) objRememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return swipeableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Float> findBounds(float f, Set<Float> set) {
        Object obj;
        Set<Float> set2 = set;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : set2) {
            if (((Number) obj2).floatValue() <= ((double) f) + 0.001d) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        Object obj3 = null;
        if (!arrayList2.isEmpty()) {
            obj = arrayList2.get(0);
            float fFloatValue = ((Number) obj).floatValue();
            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex) {
                int i = 1;
                while (true) {
                    Object obj4 = arrayList2.get(i);
                    float fFloatValue2 = ((Number) obj4).floatValue();
                    if (Float.compare(fFloatValue, fFloatValue2) < 0) {
                        obj = obj4;
                        fFloatValue = fFloatValue2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        } else {
            obj = null;
        }
        Float f2 = (Float) obj;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj5 : set2) {
            if (((Number) obj5).floatValue() >= ((double) f) - 0.001d) {
                arrayList3.add(obj5);
            }
        }
        ArrayList arrayList4 = arrayList3;
        if (!arrayList4.isEmpty()) {
            Object obj6 = arrayList4.get(0);
            float fFloatValue3 = ((Number) obj6).floatValue();
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList4);
            if (1 <= lastIndex2) {
                int i2 = 1;
                while (true) {
                    Object obj7 = arrayList4.get(i2);
                    float fFloatValue4 = ((Number) obj7).floatValue();
                    if (Float.compare(fFloatValue3, fFloatValue4) > 0) {
                        obj6 = obj7;
                        fFloatValue3 = fFloatValue4;
                    }
                    if (i2 == lastIndex2) {
                        break;
                    }
                    i2++;
                }
            }
            obj3 = obj6;
        }
        Float f3 = (Float) obj3;
        if (f2 == null) {
            return CollectionsKt.listOfNotNull(f3);
        }
        if (f3 == null) {
            return CollectionsKt.listOf(f2);
        }
        return Intrinsics.areEqual(f2, f3) ? CollectionsKt.listOf(Float.valueOf(f)) : CollectionsKt.listOf(new Float[]{f2, f3});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float computeTarget(float f, float f2, Set<Float> set, Function2<? super Float, ? super Float, Float> function2, float f3, float f4) {
        List<Float> listFindBounds = findBounds(f, set);
        int size = listFindBounds.size();
        if (size == 0) {
            return f2;
        }
        if (size == 1) {
            return listFindBounds.get(0).floatValue();
        }
        float fFloatValue = listFindBounds.get(0).floatValue();
        float fFloatValue2 = listFindBounds.get(1).floatValue();
        return (f2 > f ? f3 > (-f4) && f > ((Number) function2.invoke(Float.valueOf(fFloatValue2), Float.valueOf(fFloatValue))).floatValue() : f3 >= f4 || f >= ((Number) function2.invoke(Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2))).floatValue()) ? fFloatValue2 : fFloatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float getOffset(Map<Float, ? extends T> map, T t) {
        T next;
        Iterator<T> it = map.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((Map.Entry) next).getValue(), t));
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (Float) entry.getKey();
        }
        return null;
    }

    /* JADX INFO: renamed from: swipeable-pPrIpRY, reason: not valid java name */
    public static final <T> Modifier m831swipeablepPrIpRY(Modifier modifier, final SwipeableState<T> swipeableState, final Map<Float, ? extends T> map, final Orientation orientation, final boolean z, final boolean z2, final MutableInteractionSource mutableInteractionSource, final Function2<? super T, ? super T, ? extends ThresholdConfig> function2, final ResistanceConfig resistanceConfig, final float f) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.wear.compose.material.SwipeableKt$swipeable-pPrIpRY$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("swipeable");
                inspectorInfo.getProperties().set(RemoteConfigConstants.ResponseFieldKey.STATE, swipeableState);
                inspectorInfo.getProperties().set("anchors", map);
                inspectorInfo.getProperties().set("orientation", orientation);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("reverseDirection", Boolean.valueOf(z2));
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
                inspectorInfo.getProperties().set("thresholds", function2);
                inspectorInfo.getProperties().set("resistance", resistanceConfig);
                inspectorInfo.getProperties().set("velocityThreshold", Dp.box-impl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.SwipeableKt$swipeable$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                Modifier modifierSemantics$default;
                composer.startReplaceGroup(-1616316394);
                ComposerKt.sourceInformation(composer, "C569@23899L7,571@23972L471,571@23941L502,625@26692L55:Swipeable.kt#gj9v0t");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1616316394, i, -1, "androidx.wear.compose.material.swipeable.<anonymous> (Swipeable.kt:563)");
                }
                if (map.isEmpty()) {
                    throw new IllegalArgumentException("You must have at least one anchor.".toString());
                }
                if (CollectionsKt.distinct(map.values()).size() != map.size()) {
                    throw new IllegalArgumentException("You cannot have two anchors mapped to the same state.".toString());
                }
                CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composer.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Density density = (Density) objConsume;
                swipeableState.ensureInit$compose_material_release(map);
                Object obj = map;
                Object obj2 = swipeableState;
                ComposerKt.sourceInformationMarkerStart(composer, 1892735561, "CC(remember):Swipeable.kt#9igjgp");
                boolean zChanged = composer.changed(swipeableState) | composer.changedInstance(map) | composer.changed(resistanceConfig) | composer.changed(function2) | composer.changed(density) | composer.changed(f);
                SwipeableState<T> swipeableState2 = swipeableState;
                Map<Float, T> map2 = map;
                ResistanceConfig resistanceConfig2 = resistanceConfig;
                Function2<T, T, ThresholdConfig> function3 = function2;
                float f2 = f;
                SwipeableKt$swipeable$3$3$1 swipeableKt$swipeable$3$3$1RememberedValue = composer.rememberedValue();
                if (zChanged || swipeableKt$swipeable$3$3$1RememberedValue == Composer.Companion.getEmpty()) {
                    swipeableKt$swipeable$3$3$1RememberedValue = new SwipeableKt$swipeable$3$3$1(swipeableState2, map2, resistanceConfig2, density, function3, f2, null);
                    composer.updateRememberedValue(swipeableKt$swipeable$3$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(obj, obj2, (Function2) swipeableKt$swipeable$3$3$1RememberedValue, composer, 0);
                composer.startReplaceGroup(1892779848);
                ComposerKt.sourceInformation(composer, "595@25384L1031");
                if (z) {
                    Modifier modifier3 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart(composer, 1892781305, "CC(remember):Swipeable.kt#9igjgp");
                    boolean zChanged2 = composer.changed(swipeableState) | composer.changed(z2) | composer.changed(orientation);
                    final boolean z3 = z2;
                    final Orientation orientation2 = orientation;
                    final SwipeableState<T> swipeableState3 = swipeableState;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged2 || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.SwipeableKt$swipeable$3$semantics$1$1

                            /* JADX INFO: compiled from: Swipeable.kt */
                            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[Orientation.values().length];
                                    try {
                                        iArr[Orientation.Horizontal.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[Orientation.Vertical.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                invoke((SemanticsPropertyReceiver) obj3);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                final SwipeableState<T> swipeableState4 = swipeableState3;
                                ScrollAxisRange scrollAxisRange = new ScrollAxisRange(new Function0<Float>() { // from class: androidx.wear.compose.material.SwipeableKt$swipeable$3$semantics$1$1$range$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Float m836invoke() {
                                        float maxBound$compose_material_release;
                                        if (swipeableState4.getMinBound$compose_material_release() == swipeableState4.getMaxBound$compose_material_release()) {
                                            maxBound$compose_material_release = 0.0f;
                                        } else {
                                            maxBound$compose_material_release = (swipeableState4.getMaxBound$compose_material_release() - RangesKt.coerceIn(((Number) swipeableState4.getOffset().getValue()).floatValue(), swipeableState4.getMinBound$compose_material_release(), swipeableState4.getMaxBound$compose_material_release())) / (swipeableState4.getMaxBound$compose_material_release() - swipeableState4.getMinBound$compose_material_release());
                                        }
                                        return Float.valueOf(maxBound$compose_material_release);
                                    }
                                }, new Function0<Float>() { // from class: androidx.wear.compose.material.SwipeableKt$swipeable$3$semantics$1$1$range$2
                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Float m837invoke() {
                                        return Float.valueOf(1.0f);
                                    }
                                }, z3);
                                int i2 = WhenMappings.$EnumSwitchMapping$0[orientation2.ordinal()];
                                if (i2 == 1) {
                                    SemanticsPropertiesKt.setHorizontalScrollAxisRange(semanticsPropertyReceiver, scrollAxisRange);
                                } else {
                                    if (i2 != 2) {
                                        return;
                                    }
                                    SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, scrollAxisRange);
                                }
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null);
                } else {
                    modifierSemantics$default = (Modifier) Modifier.Companion;
                }
                composer.endReplaceGroup();
                Modifier modifierThen = Modifier.Companion.then(modifierSemantics$default);
                boolean zIsAnimationRunning = swipeableState.isAnimationRunning();
                DraggableState draggableState$compose_material_release = swipeableState.getDraggableState$compose_material_release();
                Orientation orientation3 = orientation;
                boolean z4 = z;
                MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                ComposerKt.sourceInformationMarkerStart(composer, 1892822185, "CC(remember):Swipeable.kt#9igjgp");
                boolean zChanged3 = composer.changed(swipeableState);
                SwipeableState<T> swipeableState4 = swipeableState;
                SwipeableKt$swipeable$3$4$1 swipeableKt$swipeable$3$4$1RememberedValue = composer.rememberedValue();
                if (zChanged3 || swipeableKt$swipeable$3$4$1RememberedValue == Composer.Companion.getEmpty()) {
                    swipeableKt$swipeable$3$4$1RememberedValue = new SwipeableKt$swipeable$3$4$1(swipeableState4, null);
                    composer.updateRememberedValue(swipeableKt$swipeable$3$4$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierDraggable$default = DraggableKt.draggable$default(modifierThen, draggableState$compose_material_release, orientation3, z4, mutableInteractionSource2, zIsAnimationRunning, (Function3) null, (Function3) swipeableKt$swipeable$3$4$1RememberedValue, z2, 32, (Object) null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierDraggable$default;
            }
        });
    }
}
