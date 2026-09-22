package androidx.wear.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: SwipeableV2.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a@\u0010\u0000\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00072\u0006\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a6\u0010\f\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00072\u0006\u0010\r\u001a\u00020\u0003H\u0007\u001aZ\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u0002H\u00102\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u0011H\u0010¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0001¢\u0006\u0002\u0010\u0019\u001a7\u0010\u001a\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00030\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\u001e\u001a%\u0010\u001f\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0010*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00030\u001bH\u0002¢\u0006\u0002\u0010 \u001a%\u0010!\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0010*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00030\u001bH\u0002¢\u0006\u0002\u0010 \u001az\u0010\"\u001a\u00020#\"\u0004\b\u0000\u0010\u0010*\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00100&2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010(28\u0010)\u001a4\u0012\u0013\u0012\u0011H\u0010¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0007\u001aH\u0010-\u001a\u00020#\"\u0004\b\u0000\u0010\u0010*\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u00182\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"fixedPositionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "", "Lkotlin/ParameterName;", "name", "distance", "Lkotlin/ExtensionFunctionType;", "threshold", "Landroidx/compose/ui/unit/Dp;", "fixedPositionalThreshold-0680j_4", "(F)Lkotlin/jvm/functions/Function2;", "fractionalPositionalThreshold", "fraction", "rememberSwipeableV2State", "Landroidx/wear/compose/foundation/SwipeableV2State;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmValueChange", "Lkotlin/Function1;", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/wear/compose/foundation/SwipeableV2State;", "closestAnchor", "", "offset", "searchUpwards", "(Ljava/util/Map;FZ)Ljava/lang/Object;", "maxOrNull", "(Ljava/util/Map;)Ljava/lang/Float;", "minOrNull", "swipeAnchors", "Landroidx/compose/ui/Modifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "possibleValues", "", "anchorChangeHandler", "Landroidx/wear/compose/foundation/AnchorChangeHandler;", "calculateAnchor", "value", "Landroidx/compose/ui/unit/IntSize;", "layoutSize", "swipeableV2", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "compose-foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SwipeableV2Kt {
    public static /* synthetic */ Modifier swipeableV2$default(Modifier modifier, SwipeableV2State swipeableV2State, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = false;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            mutableInteractionSource = null;
        }
        return swipeableV2(modifier, swipeableV2State, orientation, z3, z4, mutableInteractionSource);
    }

    public static final <T> Modifier swipeableV2(Modifier modifier, final SwipeableV2State<T> swipeableV2State, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource) {
        final Orientation orientation2;
        final boolean z3;
        Modifier modifierSemantics$default = Modifier.Companion;
        if (z) {
            orientation2 = orientation;
            z3 = z2;
            modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierSemantics$default, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.foundation.SwipeableV2Kt$swipeableV2$semantics$1

                /* JADX INFO: compiled from: SwipeableV2.kt */
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

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    final SwipeableV2State<T> swipeableV2State2 = swipeableV2State;
                    ScrollAxisRange scrollAxisRange = new ScrollAxisRange(new Function0<Float>() { // from class: androidx.wear.compose.foundation.SwipeableV2Kt$swipeableV2$semantics$1$range$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Float m429invoke() {
                            float maxOffset = 0.0f;
                            if (swipeableV2State2.getMinOffset() != swipeableV2State2.getMaxOffset()) {
                                Float offset = swipeableV2State2.getOffset();
                                maxOffset = (swipeableV2State2.getMaxOffset() - RangesKt.coerceIn(offset != null ? offset.floatValue() : 0.0f, swipeableV2State2.getMinOffset(), swipeableV2State2.getMaxOffset())) / (swipeableV2State2.getMaxOffset() - swipeableV2State2.getMinOffset());
                            }
                            return Float.valueOf(maxOffset);
                        }
                    }, new Function0<Float>() { // from class: androidx.wear.compose.foundation.SwipeableV2Kt$swipeableV2$semantics$1$range$2
                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Float m430invoke() {
                            return Float.valueOf(1.0f);
                        }
                    }, z3);
                    int i = WhenMappings.$EnumSwitchMapping$0[orientation2.ordinal()];
                    if (i == 1) {
                        SemanticsPropertiesKt.setHorizontalScrollAxisRange(semanticsPropertyReceiver, scrollAxisRange);
                    } else {
                        if (i != 2) {
                            return;
                        }
                        SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, scrollAxisRange);
                    }
                }
            }, 1, (Object) null);
        } else {
            orientation2 = orientation;
            z3 = z2;
        }
        swipeableV2State.setOrientation$compose_foundation_release(orientation);
        return DraggableKt.draggable$default(modifier.then(modifierSemantics$default), swipeableV2State.getSwipeDraggableState$compose_foundation_release(), orientation2, z, mutableInteractionSource, swipeableV2State.isAnimationRunning(), (Function3) null, new C01041(swipeableV2State, null), z3, 32, (Object) null);
    }

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.SwipeableV2Kt$swipeableV2$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SwipeableV2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "velocity", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.SwipeableV2Kt$swipeableV2$1", f = "SwipeableV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01041 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
        final /* synthetic */ SwipeableV2State<T> $state;
        /* synthetic */ float F$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01041(SwipeableV2State<T> swipeableV2State, Continuation<? super C01041> continuation) {
            super(3, continuation);
            this.$state = swipeableV2State;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((CoroutineScope) obj, ((Number) obj2).floatValue(), (Continuation<? super Unit>) obj3);
        }

        public final Object invoke(CoroutineScope coroutineScope, float f, Continuation<? super Unit> continuation) {
            C01041 c01041 = new C01041(this.$state, continuation);
            c01041.L$0 = coroutineScope;
            c01041.F$0 = f;
            return c01041.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.wear.compose.foundation.SwipeableV2Kt$swipeableV2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SwipeableV2.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.wear.compose.foundation.SwipeableV2Kt$swipeableV2$1$1", f = "SwipeableV2.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
        static final class C00081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ SwipeableV2State<T> $state;
            final /* synthetic */ float $velocity;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00081(SwipeableV2State<T> swipeableV2State, float f, Continuation<? super C00081> continuation) {
                super(2, continuation);
                this.$state = swipeableV2State;
                this.$velocity = f;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00081(this.$state, this.$velocity, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.$state.settle(this.$velocity, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BuildersKt.launch$default((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new C00081(this.$state, this.F$0, null), 3, (Object) null);
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Modifier swipeAnchors$default(Modifier modifier, SwipeableV2State swipeableV2State, Set set, AnchorChangeHandler anchorChangeHandler, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            anchorChangeHandler = null;
        }
        return swipeAnchors(modifier, swipeableV2State, set, anchorChangeHandler, function2);
    }

    public static final <T> Modifier swipeAnchors(Modifier modifier, final SwipeableV2State<T> swipeableV2State, final Set<? extends T> set, final AnchorChangeHandler<T> anchorChangeHandler, final Function2<? super T, ? super IntSize, Float> function2) {
        return modifier.then(new SwipeAnchorsModifier(new Function1<Density, Unit>() { // from class: androidx.wear.compose.foundation.SwipeableV2Kt.swipeAnchors.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Density) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Density density) {
                swipeableV2State.setDensity$compose_foundation_release(density);
            }
        }, new Function1<IntSize, Unit>() { // from class: androidx.wear.compose.foundation.SwipeableV2Kt.swipeAnchors.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m428invokeozmzZPI(((IntSize) obj).unbox-impl());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
            public final void m428invokeozmzZPI(long j) {
                AnchorChangeHandler<T> anchorChangeHandler2;
                Map anchors$compose_foundation_release = swipeableV2State.getAnchors$compose_foundation_release();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterable iterable = set;
                Function2<T, IntSize, Float> function3 = function2;
                for (Object obj : iterable) {
                    Float f = (Float) function3.invoke(obj, IntSize.box-impl(j));
                    if (f != null) {
                        linkedHashMap.put(obj, f);
                    }
                }
                if (Intrinsics.areEqual(anchors$compose_foundation_release, linkedHashMap)) {
                    return;
                }
                Object targetValue = swipeableV2State.getTargetValue();
                if (!swipeableV2State.updateAnchors$compose_foundation_release(linkedHashMap) || (anchorChangeHandler2 = anchorChangeHandler) == 0) {
                    return;
                }
                anchorChangeHandler2.onAnchorsChanged((T) targetValue, (Map<T, Float>) anchors$compose_foundation_release, linkedHashMap);
            }
        }, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.wear.compose.foundation.SwipeableV2Kt$swipeAnchors$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("swipeAnchors");
                inspectorInfo.getProperties().set(RemoteConfigConstants.ResponseFieldKey.STATE, swipeableV2State);
                inspectorInfo.getProperties().set("possibleValues", set);
                inspectorInfo.getProperties().set("anchorChangeHandler", anchorChangeHandler);
                inspectorInfo.getProperties().set("calculateAnchor", function2);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    public static final <T> SwipeableV2State<T> rememberSwipeableV2State(final T t, final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1466928368, "C(rememberSwipeableV2State)P(2)635@27197L325,627@26824L698:SwipeableV2.kt#m5emhl");
        if ((i2 & 2) != 0) {
            animationSpec = (AnimationSpec) SwipeableV2Defaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<T, Boolean>() { // from class: androidx.wear.compose.foundation.SwipeableV2Kt.rememberSwipeableV2State.1
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Boolean m426invoke(T t2) {
                    return true;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1466928368, i, -1, "androidx.wear.compose.foundation.rememberSwipeableV2State (SwipeableV2.kt:626)");
        }
        Object[] objArr = {t, animationSpec, function1};
        Saver<SwipeableV2State<T>, T> saverM434SavereqLRuRQ = SwipeableV2State.Companion.m434SavereqLRuRQ(animationSpec, function1, SwipeableV2Defaults.INSTANCE.getPositionalThreshold(), SwipeableV2Defaults.INSTANCE.m424getVelocityThresholdD9Ej5fM());
        ComposerKt.sourceInformationMarkerStart(composer, 1406375944, "CC(remember):SwipeableV2.kt#9igjgp");
        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changedInstance(t)) || (i & 6) == 4) | composer.changedInstance(animationSpec) | ((((i & 896) ^ 384) > 256 && composer.changed(function1)) || (i & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = (Function0) new Function0<SwipeableV2State<T>>() { // from class: androidx.wear.compose.foundation.SwipeableV2Kt$rememberSwipeableV2State$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final SwipeableV2State<T> m427invoke() {
                    return new SwipeableV2State<>(t, animationSpec, function1, SwipeableV2Defaults.INSTANCE.getPositionalThreshold(), SwipeableV2Defaults.INSTANCE.m424getVelocityThresholdD9Ej5fM(), null, 32, null);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SwipeableV2State<T> swipeableV2State = (SwipeableV2State) RememberSaveableKt.rememberSaveable(objArr, saverM434SavereqLRuRQ, (String) null, (Function0) objRememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return swipeableV2State;
    }

    /* JADX INFO: renamed from: fixedPositionalThreshold-0680j_4, reason: not valid java name */
    public static final Function2<Density, Float, Float> m425fixedPositionalThreshold0680j_4(final float f) {
        return new Function2<Density, Float, Float>() { // from class: androidx.wear.compose.foundation.SwipeableV2Kt$fixedPositionalThreshold$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((Density) obj, ((Number) obj2).floatValue());
            }

            public final Float invoke(Density density, float f2) {
                return Float.valueOf(density.toPx-0680j_4(f));
            }
        };
    }

    public static final Function2<Density, Float, Float> fractionalPositionalThreshold(final float f) {
        return new Function2<Density, Float, Float>() { // from class: androidx.wear.compose.foundation.SwipeableV2Kt.fractionalPositionalThreshold.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final Float invoke(Density density, float f2) {
                return Float.valueOf(f2 * f);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((Density) obj, ((Number) obj2).floatValue());
            }
        };
    }

    static /* synthetic */ Object closestAnchor$default(Map map, float f, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return closestAnchor(map, f, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T closestAnchor(Map<T, Float> map, float f, boolean z) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException("The anchors were empty when trying to find the closest anchor".toString());
        }
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (it.hasNext()) {
            float fFloatValue = ((Number) ((Map.Entry) next).getValue()).floatValue();
            float f2 = z ? fFloatValue - f : f - fFloatValue;
            if (f2 < 0.0f) {
                f2 = Float.POSITIVE_INFINITY;
            }
            do {
                T next2 = it.next();
                float fFloatValue2 = ((Number) ((Map.Entry) next2).getValue()).floatValue();
                float f3 = z ? fFloatValue2 - f : f - fFloatValue2;
                if (f3 < 0.0f) {
                    f3 = Float.POSITIVE_INFINITY;
                }
                if (Float.compare(f2, f3) > 0) {
                    next = next2;
                    f2 = f3;
                }
            } while (it.hasNext());
        }
        return (T) ((Map.Entry) next).getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float minOrNull(Map<T, Float> map) {
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float maxOrNull(Map<T, Float> map) {
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }
}
