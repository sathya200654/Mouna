package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: Coach.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0093\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0001¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Coach", "", "modifier", "Landroidx/compose/ui/Modifier;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "coachStyle", "Lcom/vivekgupta/composecoachmark/coachmark/CoachStyle;", "revealEffect", "Lcom/vivekgupta/composecoachmark/coachmark/RevealEffect;", "alignment", "Landroidx/compose/ui/Alignment;", "isForcedAlignment", "", "onBack", "Lkotlin/Function0;", "onSkip", "onNext", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function3;Lcom/vivekgupta/composecoachmark/coachmark/CoachStyle;Lcom/vivekgupta/composecoachmark/coachmark/RevealEffect;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "composecoachmark_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoachKt {
    public static final void Coach(Modifier modifier, final LayoutCoordinates layoutCoordinates, final Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> function3, CoachStyle coachStyle, RevealEffect revealEffect, Alignment alignment, boolean z, Function0<Unit> function0, Function0<Unit> function1, final Function0<Unit> function2, Composer composer, int i, final int i2) {
        final int i3;
        final CoachStyle defaultCoachStyle;
        int i4;
        final RectangleRevealEffect rectangleRevealEffect;
        Composer composer2;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        Intrinsics.checkNotNullParameter(function3, "content");
        Intrinsics.checkNotNullParameter(function2, "onNext");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2019892670);
        Modifier modifier2 = (i2 & 1) != 0 ? (Modifier) Modifier.Companion : modifier;
        if ((i2 & 8) != 0) {
            i3 = i;
            i4 = i3 & (-7169);
            defaultCoachStyle = new DefaultCoachStyle();
        } else {
            i3 = i;
            defaultCoachStyle = coachStyle;
            i4 = i3;
        }
        if ((i2 & 16) != 0) {
            rectangleRevealEffect = new RectangleRevealEffect();
            i4 &= -57345;
        } else {
            rectangleRevealEffect = revealEffect;
        }
        final Alignment bottomCenter = (i2 & 32) != 0 ? Alignment.Companion.getBottomCenter() : alignment;
        final boolean z2 = (i2 & 64) != 0 ? false : z;
        final Function0<Unit> function4 = (i2 & 128) != 0 ? new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachKt.Coach.1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m2224invoke() {
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2224invoke();
                return Unit.INSTANCE;
            }
        } : function0;
        final Function0<Unit> function5 = (i2 & 256) != 0 ? new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachKt.Coach.2
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m2225invoke() {
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2225invoke();
                return Unit.INSTANCE;
            }
        } : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2019892670, i4, -1, "com.vivekgupta.composecoachmark.coachmark.Coach (Coach.kt:32)");
        }
        final Rect rectBoundsInRoot = LayoutCoordinatesKt.boundsInRoot(layoutCoordinates);
        EffectsKt.LaunchedEffect(rectBoundsInRoot, new AnonymousClass3(rectangleRevealEffect, rectBoundsInRoot, null), composerStartRestartGroup, 64);
        composerStartRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
        composerStartRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            objRememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composerStartRestartGroup.endReplaceableGroup();
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), Size.Companion.getZero-NH-jbRc()), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2 = composerStartRestartGroup;
            composer2.updateRememberedValue(objRememberedValue2);
        } else {
            composer2 = composerStartRestartGroup;
        }
        composer2.endReplaceableGroup();
        final MutableState mutableState = (MutableState) objRememberedValue2;
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object objRememberedValue3 = composer2.rememberedValue();
        if (objRememberedValue3 == Composer.Companion.getEmpty()) {
            objRememberedValue3 = SnapshotStateKt.mutableStateOf$default(RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), Size.Companion.getZero-NH-jbRc()), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(objRememberedValue3);
        }
        composer2.endReplaceableGroup();
        final MutableState mutableState2 = (MutableState) objRememberedValue3;
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(GraphicsLayerModifierKt.graphicsLayer-pANQ8Wg$default(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.99f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, (Shape) null, false, (RenderEffect) null, 0L, 0L, 65531, (Object) null), rectBoundsInRoot, new AnonymousClass4(coroutineScope, rectangleRevealEffect, rectBoundsInRoot, function2, null));
        long j = Color.Companion.getTransparent-0d7_KjU();
        final RevealEffect revealEffect2 = rectangleRevealEffect;
        final int i5 = i4;
        final Modifier modifier3 = modifier2;
        final CoachStyle coachStyle2 = defaultCoachStyle;
        final Alignment alignment2 = bottomCenter;
        final Function0<Unit> function6 = function5;
        final boolean z3 = z2;
        final Function0<Unit> function7 = function4;
        Function2 function2ComposableLambda = ComposableLambdaKt.composableLambda(composer2, -371834498, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachKt.Coach.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i6) {
                if ((i6 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-371834498, i6, -1, "com.vivekgupta.composecoachmark.coachmark.Coach.<anonymous> (Coach.kt:69)");
                    }
                    Modifier modifier4 = Modifier.Companion;
                    final CoachStyle coachStyle3 = defaultCoachStyle;
                    final Rect rect = rectBoundsInRoot;
                    final RevealEffect revealEffect3 = revealEffect2;
                    final MutableState<Rect> mutableState3 = mutableState2;
                    final MutableState<Rect> mutableState4 = mutableState;
                    CanvasKt.Canvas(modifier4, new Function1<DrawScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachKt.Coach.5.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((DrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(DrawScope drawScope) {
                            Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
                            CoachKt.Coach$lambda$5(mutableState3, coachStyle3.drawCoachShape(rect, drawScope));
                            CoachKt.Coach$lambda$2(mutableState4, revealEffect3.drawTargetShape(rect, drawScope));
                        }
                    }, composer3, 6);
                    Modifier modifier5 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.Companion.getTransparent-0d7_KjU(), (Shape) null, 2, (Object) null);
                    final CoachStyle coachStyle4 = defaultCoachStyle;
                    final Rect rect2 = rectBoundsInRoot;
                    final int i7 = i5;
                    final Alignment alignment3 = bottomCenter;
                    final boolean z4 = z2;
                    final CoroutineScope coroutineScope2 = coroutineScope;
                    final RevealEffect revealEffect4 = revealEffect2;
                    final Function0<Unit> function8 = function4;
                    final Function0<Unit> function9 = function5;
                    final Function0<Unit> function10 = function2;
                    final MutableState<Rect> mutableState5 = mutableState2;
                    final MutableState<Rect> mutableState6 = mutableState;
                    final Function3<BoxWithConstraintsScope, Composer, Integer, Unit> function11 = function3;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier5, (Alignment) null, false, ComposableLambdaKt.composableLambda(composer3, 1360102760, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachKt.Coach.5.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final BoxWithConstraintsScope boxWithConstraintsScope, Composer composer4, final int i8) {
                            Intrinsics.checkNotNullParameter(boxWithConstraintsScope, "$this$BoxWithConstraints");
                            if ((i8 & 14) == 0) {
                                i8 |= composer4.changed(boxWithConstraintsScope) ? 4 : 2;
                            }
                            if ((i8 & 91) != 18 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1360102760, i8, -1, "com.vivekgupta.composecoachmark.coachmark.Coach.<anonymous>.<anonymous> (Coach.kt:78)");
                                }
                                CoachStyle coachStyle5 = coachStyle4;
                                Rect rect3 = rect2;
                                final CoroutineScope coroutineScope3 = coroutineScope2;
                                final RevealEffect revealEffect5 = revealEffect4;
                                final Rect rect4 = rect2;
                                final Function0<Unit> function12 = function8;
                                Function0<Unit> function13 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachKt.Coach.5.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m2227invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m2227invoke() {
                                        BuildersKt.launch$default(coroutineScope3, (CoroutineContext) null, (CoroutineStart) null, new C00651(revealEffect5, rect4, function12, null), 3, (Object) null);
                                    }

                                    /* JADX INFO: renamed from: com.vivekgupta.composecoachmark.coachmark.CoachKt$Coach$5$2$1$1, reason: invalid class name and collision with other inner class name */
                                    /* JADX INFO: compiled from: Coach.kt */
                                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "com.vivekgupta.composecoachmark.coachmark.CoachKt$Coach$5$2$1$1", f = "Coach.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
                                    static final class C00651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ Rect $bounds;
                                        final /* synthetic */ Function0<Unit> $onBack;
                                        final /* synthetic */ RevealEffect $revealEffect;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        C00651(RevealEffect revealEffect, Rect rect, Function0<Unit> function0, Continuation<? super C00651> continuation) {
                                            super(2, continuation);
                                            this.$revealEffect = revealEffect;
                                            this.$bounds = rect;
                                            this.$onBack = function0;
                                        }

                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new C00651(this.$revealEffect, this.$bounds, this.$onBack, continuation);
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                        }

                                        public final Object invokeSuspend(Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                this.label = 1;
                                                if (this.$revealEffect.exitAnimation(this.$bounds, (Continuation) this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            } else {
                                                if (i != 1) {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                ResultKt.throwOnFailure(obj);
                                            }
                                            this.$onBack.invoke();
                                            return Unit.INSTANCE;
                                        }
                                    }
                                };
                                final CoroutineScope coroutineScope4 = coroutineScope2;
                                final RevealEffect revealEffect6 = revealEffect4;
                                final Rect rect5 = rect2;
                                final Function0<Unit> function14 = function9;
                                Function0<Unit> function15 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachKt.Coach.5.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m2228invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m2228invoke() {
                                        BuildersKt.launch$default(coroutineScope4, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(revealEffect6, rect5, function14, null), 3, (Object) null);
                                    }

                                    /* JADX INFO: renamed from: com.vivekgupta.composecoachmark.coachmark.CoachKt$Coach$5$2$2$1, reason: invalid class name */
                                    /* JADX INFO: compiled from: Coach.kt */
                                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "com.vivekgupta.composecoachmark.coachmark.CoachKt$Coach$5$2$2$1", f = "Coach.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ Rect $bounds;
                                        final /* synthetic */ Function0<Unit> $onSkip;
                                        final /* synthetic */ RevealEffect $revealEffect;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(RevealEffect revealEffect, Rect rect, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$revealEffect = revealEffect;
                                            this.$bounds = rect;
                                            this.$onSkip = function0;
                                        }

                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$revealEffect, this.$bounds, this.$onSkip, continuation);
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                        }

                                        public final Object invokeSuspend(Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                this.label = 1;
                                                if (this.$revealEffect.exitAnimation(this.$bounds, (Continuation) this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            } else {
                                                if (i != 1) {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                ResultKt.throwOnFailure(obj);
                                            }
                                            this.$onSkip.invoke();
                                            return Unit.INSTANCE;
                                        }
                                    }
                                };
                                final CoroutineScope coroutineScope5 = coroutineScope2;
                                final RevealEffect revealEffect7 = revealEffect4;
                                final Rect rect6 = rect2;
                                final Function0<Unit> function16 = function10;
                                coachStyle5.drawCoachButtons(boxWithConstraintsScope, rect3, function13, function15, new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachKt.Coach.5.2.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m2229invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m2229invoke() {
                                        BuildersKt.launch$default(coroutineScope5, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(revealEffect7, rect6, function16, null), 3, (Object) null);
                                    }

                                    /* JADX INFO: renamed from: com.vivekgupta.composecoachmark.coachmark.CoachKt$Coach$5$2$3$1, reason: invalid class name */
                                    /* JADX INFO: compiled from: Coach.kt */
                                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "com.vivekgupta.composecoachmark.coachmark.CoachKt$Coach$5$2$3$1", f = "Coach.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ Rect $bounds;
                                        final /* synthetic */ Function0<Unit> $onNext;
                                        final /* synthetic */ RevealEffect $revealEffect;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(RevealEffect revealEffect, Rect rect, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$revealEffect = revealEffect;
                                            this.$bounds = rect;
                                            this.$onNext = function0;
                                        }

                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$revealEffect, this.$bounds, this.$onNext, continuation);
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                        }

                                        public final Object invokeSuspend(Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                this.label = 1;
                                                if (this.$revealEffect.exitAnimation(this.$bounds, (Continuation) this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            } else {
                                                if (i != 1) {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                ResultKt.throwOnFailure(obj);
                                            }
                                            this.$onNext.invoke();
                                            return Unit.INSTANCE;
                                        }
                                    }
                                }, composer4, (i8 & 14) | ((i7 << 6) & 458752));
                                Rect rectCoach$lambda$4 = CoachKt.Coach$lambda$4(mutableState5);
                                Rect rectCoach$lambda$1 = CoachKt.Coach$lambda$1(mutableState6);
                                Alignment alignment4 = alignment3;
                                boolean z5 = z4;
                                final Function3<BoxWithConstraintsScope, Composer, Integer, Unit> function17 = function11;
                                final int i9 = i7;
                                Function2 function2ComposableLambda2 = ComposableLambdaKt.composableLambda(composer4, 699686995, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachKt.Coach.5.2.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer5, int i10) {
                                        if ((i10 & 11) == 2 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(699686995, i10, -1, "com.vivekgupta.composecoachmark.coachmark.Coach.<anonymous>.<anonymous>.<anonymous> (Coach.kt:107)");
                                        }
                                        function17.invoke(boxWithConstraintsScope, composer5, Integer.valueOf(((i9 >> 3) & 112) | (i8 & 14)));
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                int i10 = i7;
                                NewCoachLayoutKt.NewCoachLayout(rectCoach$lambda$4, rectCoach$lambda$1, alignment4, z5, function2ComposableLambda2, composer4, ((i10 >> 9) & 896) | 24576 | ((i10 >> 9) & 7168), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }), composer3, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        });
        Composer composer3 = composer2;
        SurfaceKt.Surface-F-jzlyU(modifierPointerInput, (Shape) null, j, 0L, (BorderStroke) null, 0.0f, function2ComposableLambda, composer3, 1573248, 58);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachKt.Coach.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer4, int i6) {
                CoachKt.Coach(modifier3, layoutCoordinates, function3, coachStyle2, rectangleRevealEffect, alignment2, z3, function7, function6, function2, composer4, i3 | 1, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect Coach$lambda$1(MutableState<Rect> mutableState) {
        return (Rect) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect Coach$lambda$4(MutableState<Rect> mutableState) {
        return (Rect) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Coach$lambda$2(MutableState<Rect> mutableState, Rect rect) {
        mutableState.setValue(rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Coach$lambda$5(MutableState<Rect> mutableState, Rect rect) {
        mutableState.setValue(rect);
    }

    /* JADX INFO: renamed from: com.vivekgupta.composecoachmark.coachmark.CoachKt$Coach$3, reason: invalid class name */
    /* JADX INFO: compiled from: Coach.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.vivekgupta.composecoachmark.coachmark.CoachKt$Coach$3", f = "Coach.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Rect $bounds;
        final /* synthetic */ RevealEffect $revealEffect;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(RevealEffect revealEffect, Rect rect, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$revealEffect = revealEffect;
            this.$bounds = rect;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$revealEffect, this.$bounds, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$revealEffect.enterAnimation(this.$bounds, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.vivekgupta.composecoachmark.coachmark.CoachKt$Coach$4, reason: invalid class name */
    /* JADX INFO: compiled from: Coach.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.vivekgupta.composecoachmark.coachmark.CoachKt$Coach$4", f = "Coach.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Rect $bounds;
        final /* synthetic */ Function0<Unit> $onNext;
        final /* synthetic */ RevealEffect $revealEffect;
        final /* synthetic */ CoroutineScope $scope;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(CoroutineScope coroutineScope, RevealEffect revealEffect, Rect rect, Function0<Unit> function0, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$scope = coroutineScope;
            this.$revealEffect = revealEffect;
            this.$bounds = rect;
            this.$onNext = function0;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass4 = new AnonymousClass4(this.$scope, this.$revealEffect, this.$bounds, this.$onNext, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return create(pointerInputScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                final CoroutineScope coroutineScope = this.$scope;
                final RevealEffect revealEffect = this.$revealEffect;
                final Rect rect = this.$bounds;
                final Function0<Unit> function0 = this.$onNext;
                this.label = 1;
                if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, (Function1) null, (Function1) null, (Function3) null, new Function1<Offset, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachKt.Coach.4.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        m2226invokek4lQ0M(((Offset) obj2).unbox-impl());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                    public final void m2226invokek4lQ0M(long j) {
                        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C00641(revealEffect, rect, function0, null), 3, (Object) null);
                    }

                    /* JADX INFO: renamed from: com.vivekgupta.composecoachmark.coachmark.CoachKt$Coach$4$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: Coach.kt */
                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "com.vivekgupta.composecoachmark.coachmark.CoachKt$Coach$4$1$1", f = "Coach.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
                    static final class C00641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Rect $bounds;
                        final /* synthetic */ Function0<Unit> $onNext;
                        final /* synthetic */ RevealEffect $revealEffect;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00641(RevealEffect revealEffect, Rect rect, Function0<Unit> function0, Continuation<? super C00641> continuation) {
                            super(2, continuation);
                            this.$revealEffect = revealEffect;
                            this.$bounds = rect;
                            this.$onNext = function0;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C00641(this.$revealEffect, this.$bounds, this.$onNext, continuation);
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$revealEffect.exitAnimation(this.$bounds, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            this.$onNext.invoke();
                            return Unit.INSTANCE;
                        }
                    }
                }, (Continuation) this, 7, (Object) null) == coroutine_suspended) {
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
}
