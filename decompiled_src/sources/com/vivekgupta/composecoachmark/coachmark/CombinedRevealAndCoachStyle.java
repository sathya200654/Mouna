package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.ButtonColors;
import androidx.compose.material.ButtonElevation;
import androidx.compose.material.ButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.recyclerview.widget.RecyclerView;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CombinedRevealAndCoachStyle.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0018\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007JG\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u001dH\u0017¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\u0019\u0010%\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u00020\u00048VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Lcom/vivekgupta/composecoachmark/coachmark/CombinedRevealAndCoachStyle;", "Lcom/vivekgupta/composecoachmark/coachmark/CoachStyle;", "Lcom/vivekgupta/composecoachmark/coachmark/RevealEffect;", "color", "Landroidx/compose/ui/graphics/Color;", "alpha", "", "(JFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "backGroundColor", "getBackGroundColor-0d7_KjU", "()J", "backgroundAlpha", "getBackgroundAlpha", "()F", "J", "outerAlphaAnim", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "outerRadius", "radius", "drawCoachButtons", "", "contentScope", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "targetBounds", "Landroidx/compose/ui/geometry/Rect;", "onBack", "Lkotlin/Function0;", "onSkip", "onNext", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "drawCoachShape", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawTargetShape", "enterAnimation", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exitAnimation", "composecoachmark_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CombinedRevealAndCoachStyle implements CoachStyle, RevealEffect {
    public static final int $stable = ((InfiniteRepeatableSpec.$stable | Animatable.$stable) | Animatable.$stable) | Animatable.$stable;
    private final float alpha;
    private final InfiniteRepeatableSpec<Float> animationSpec;
    private final long color;
    private final Animatable<Float, AnimationVector1D> outerAlphaAnim;
    private final Animatable<Float, AnimationVector1D> outerRadius;
    private final Animatable<Float, AnimationVector1D> radius;

    /* JADX INFO: renamed from: com.vivekgupta.composecoachmark.coachmark.CombinedRevealAndCoachStyle$enterAnimation$1, reason: invalid class name */
    /* JADX INFO: compiled from: CombinedRevealAndCoachStyle.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.vivekgupta.composecoachmark.coachmark.CombinedRevealAndCoachStyle", f = "CombinedRevealAndCoachStyle.kt", i = {0, 0, 1, 1, 2, 2, 3}, l = {SignPracticeCreationViewModel.TOPIC_MAX_CHAR_LIMIT, 86, 91, 92, 93}, m = "enterAnimation", n = {"this", "targetBounds", "this", "targetBounds", "this", "targetBounds", "this"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CombinedRevealAndCoachStyle.this.enterAnimation(null, (Continuation) this);
        }
    }

    public /* synthetic */ CombinedRevealAndCoachStyle(long j, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, f);
    }

    private CombinedRevealAndCoachStyle(long j, float f) {
        this.color = j;
        this.alpha = f;
        this.radius = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
        this.outerRadius = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
        this.outerAlphaAnim = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
        this.animationSpec = AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(500, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null), RepeatMode.Restart, 0L, 4, (Object) null);
    }

    @Override // com.vivekgupta.composecoachmark.coachmark.CoachStyle
    /* JADX INFO: renamed from: getBackGroundColor-0d7_KjU, reason: from getter */
    public long getColor() {
        return this.color;
    }

    @Override // com.vivekgupta.composecoachmark.coachmark.CoachStyle
    /* JADX INFO: renamed from: getBackgroundAlpha, reason: from getter */
    public float getAlpha() {
        return this.alpha;
    }

    @Override // com.vivekgupta.composecoachmark.coachmark.CoachStyle
    public void drawCoachButtons(final BoxWithConstraintsScope boxWithConstraintsScope, final Rect rect, final Function0<Unit> function0, final Function0<Unit> function1, final Function0<Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(boxWithConstraintsScope, "contentScope");
        Intrinsics.checkNotNullParameter(rect, "targetBounds");
        Intrinsics.checkNotNullParameter(function0, "onBack");
        Intrinsics.checkNotNullParameter(function1, "onSkip");
        Intrinsics.checkNotNullParameter(function2, "onNext");
        Composer composerStartRestartGroup = composer.startRestartGroup(974500167);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(drawCoachButtons)P(!1,4!1,3)");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(boxWithConstraintsScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(function1) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(function2) ? 16384 : 8192;
        }
        if ((46091 & i2) != 9218 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(974500167, i2, -1, "com.vivekgupta.composecoachmark.coachmark.CombinedRevealAndCoachStyle.drawCoachButtons (CombinedRevealAndCoachStyle.kt:44)");
            }
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(function1);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CombinedRevealAndCoachStyle$drawCoachButtons$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2245invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m2245invoke() {
                        function1.invoke();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ButtonKt.Button((Function0) objRememberedValue, boxWithConstraintsScope.align(Modifier.Companion, Alignment.Companion.getBottomStart()), false, (MutableInteractionSource) null, (ButtonElevation) null, (Shape) null, (BorderStroke) null, (ButtonColors) null, (PaddingValues) null, ComposableSingletons$CombinedRevealAndCoachStyleKt.INSTANCE.m2252getLambda1$composecoachmark_release(), composerStartRestartGroup, 805306368, 508);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(function2);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CombinedRevealAndCoachStyle$drawCoachButtons$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2246invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m2246invoke() {
                        function2.invoke();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            ButtonKt.Button((Function0) objRememberedValue2, boxWithConstraintsScope.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), false, (MutableInteractionSource) null, (ButtonElevation) null, (Shape) null, (BorderStroke) null, (ButtonColors) null, (PaddingValues) null, ComposableSingletons$CombinedRevealAndCoachStyleKt.INSTANCE.m2253getLambda2$composecoachmark_release(), composer2, 805306368, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CombinedRevealAndCoachStyle.drawCoachButtons.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i3) {
                CombinedRevealAndCoachStyle.this.drawCoachButtons(boxWithConstraintsScope, rect, function0, function1, function2, composer3, i | 1);
            }
        });
    }

    @Override // com.vivekgupta.composecoachmark.coachmark.CoachStyle
    public Rect drawCoachShape(Rect targetBounds, DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(targetBounds, "targetBounds");
        Intrinsics.checkNotNullParameter(drawScope, "drawScope");
        DrawScope.drawCircle-VaOC9Bg$default(drawScope, getColor(), ((Number) this.radius.getValue()).floatValue() * 4.0f, targetBounds.getCenter-F1C5BW0(), getAlpha(), (DrawStyle) null, (ColorFilter) null, 0, 112, (Object) null);
        return RectKt.Rect-tz77jQw(Offset.minus-MK-Hz9U(Offset.Companion.getZero-F1C5BW0(), targetBounds.getTopLeft-F1C5BW0()), SizeKt.Size(Size.getWidth-impl(drawScope.getSize-NH-jbRc()), Math.abs(targetBounds.getMaxDimension()) * 3.0f));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0060 A[PHI: r0 r3 r11 r19
  0x0060: PHI (r0v4 androidx.compose.ui.geometry.Rect) = (r0v3 androidx.compose.ui.geometry.Rect), (r0v16 androidx.compose.ui.geometry.Rect) binds: [B:32:0x00e7, B:19:0x0052] A[DONT_GENERATE, DONT_INLINE]
  0x0060: PHI (r3v6 com.vivekgupta.composecoachmark.coachmark.CombinedRevealAndCoachStyle) = 
  (r3v5 com.vivekgupta.composecoachmark.coachmark.CombinedRevealAndCoachStyle)
  (r3v14 com.vivekgupta.composecoachmark.coachmark.CombinedRevealAndCoachStyle)
 binds: [B:32:0x00e7, B:19:0x0052] A[DONT_GENERATE, DONT_INLINE]
  0x0060: PHI (r11v3 java.lang.Object) = (r11v2 java.lang.Object), (r11v6 java.lang.Object) binds: [B:32:0x00e7, B:19:0x0052] A[DONT_GENERATE, DONT_INLINE]
  0x0060: PHI (r19v3 float) = (r11v0 float), (r19v5 float) binds: [B:32:0x00e7, B:19:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x010d A[PHI: r0 r11
  0x010d: PHI (r0v6 com.vivekgupta.composecoachmark.coachmark.CombinedRevealAndCoachStyle) = 
  (r0v5 com.vivekgupta.composecoachmark.coachmark.CombinedRevealAndCoachStyle)
  (r0v18 com.vivekgupta.composecoachmark.coachmark.CombinedRevealAndCoachStyle)
 binds: [B:35:0x010a, B:18:0x0048] A[DONT_GENERATE, DONT_INLINE]
  0x010d: PHI (r11v4 java.lang.Object) = (r11v3 java.lang.Object), (r11v7 java.lang.Object) binds: [B:35:0x010a, B:18:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0125, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r3, r4, r5, (java.lang.Object) null, (kotlin.jvm.functions.Function1) null, r8, 12, (java.lang.Object) null) == r2) goto L39;
     */
    @Override // com.vivekgupta.composecoachmark.coachmark.RevealEffect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object enterAnimation(androidx.compose.ui.geometry.Rect r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivekgupta.composecoachmark.coachmark.CombinedRevealAndCoachStyle.enterAnimation(androidx.compose.ui.geometry.Rect, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.vivekgupta.composecoachmark.coachmark.RevealEffect
    public Rect drawTargetShape(Rect targetBounds, DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(targetBounds, "targetBounds");
        Intrinsics.checkNotNullParameter(drawScope, "drawScope");
        DrawScope.drawCircle-VaOC9Bg$default(drawScope, Color.Companion.getWhite-0d7_KjU(), ((Number) this.radius.getValue()).floatValue(), targetBounds.getCenter-F1C5BW0(), 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.getXor-0nO6VwU(), 56, (Object) null);
        DrawScope.drawCircle-VaOC9Bg$default(drawScope, getColor(), ((Number) this.outerRadius.getValue()).floatValue(), targetBounds.getCenter-F1C5BW0(), ((Number) this.outerAlphaAnim.getValue()).floatValue(), (DrawStyle) null, (ColorFilter) null, 0, 112, (Object) null);
        return RectKt.Rect-tz77jQw(OffsetKt.Offset(targetBounds.getWidth() * 2.0f, targetBounds.getHeight() * 2.0f), Size.times-7Ah8Wj8(targetBounds.getSize-NH-jbRc(), 2.0f));
    }

    @Override // com.vivekgupta.composecoachmark.coachmark.RevealEffect
    public Object exitAnimation(Rect rect, Continuation<? super Unit> continuation) {
        Object objAnimateTo$default = Animatable.animateTo$default(this.radius, Boxing.boxFloat(0.0f), AnimationSpecKt.tween$default(500, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null), (Object) null, (Function1) null, continuation, 12, (Object) null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }
}
