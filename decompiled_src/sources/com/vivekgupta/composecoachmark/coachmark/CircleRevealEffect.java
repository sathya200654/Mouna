package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel;
import com.google.firebase.perf.util.Constants;
import com.google.protobuf.DescriptorProtos;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RevealEffectSample.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/vivekgupta/composecoachmark/coachmark/CircleRevealEffect;", "Lcom/vivekgupta/composecoachmark/coachmark/RevealEffect;", "()V", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "", "focus", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "radius", "drawTargetShape", "Landroidx/compose/ui/geometry/Rect;", "targetBounds", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "enterAnimation", "", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exitAnimation", "composecoachmark_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CircleRevealEffect implements RevealEffect {
    public static final int $stable = (InfiniteRepeatableSpec.$stable | Animatable.$stable) | Animatable.$stable;
    private final Animatable<Float, AnimationVector1D> radius = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
    private final Animatable<Float, AnimationVector1D> focus = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, (Object) null);
    private final InfiniteRepeatableSpec<Float> animationSpec = AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(Constants.MAX_URL_LENGTH, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null), RepeatMode.Restart, 0, 4, (Object) null);

    /* JADX INFO: renamed from: com.vivekgupta.composecoachmark.coachmark.CircleRevealEffect$enterAnimation$1, reason: invalid class name */
    /* JADX INFO: compiled from: RevealEffectSample.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.vivekgupta.composecoachmark.coachmark.CircleRevealEffect", f = "RevealEffectSample.kt", i = {0, 0, 1, 2}, l = {28, 29, SignPracticeCreationViewModel.PRACTICE_NAME_MAX_CHAR_LIMIT, DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER}, m = "enterAnimation", n = {"this", "targetBounds", "this", "this"}, s = {"L$0", "L$1", "L$0", "L$0"})
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
            return CircleRevealEffect.this.enterAnimation(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.vivekgupta.composecoachmark.coachmark.CircleRevealEffect$exitAnimation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RevealEffectSample.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.vivekgupta.composecoachmark.coachmark.CircleRevealEffect", f = "RevealEffectSample.kt", i = {0}, l = {35, 36}, m = "exitAnimation", n = {"this"}, s = {"L$0"})
    static final class C03361 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C03361(Continuation<? super C03361> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CircleRevealEffect.this.exitAnimation(null, (Continuation) this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00b6 A[PHI: r12
  0x00b6: PHI (r12v3 'this' com.vivekgupta.composecoachmark.coachmark.CircleRevealEffect) = 
  (r12v2 'this' com.vivekgupta.composecoachmark.coachmark.CircleRevealEffect)
  (r12v13 'this' com.vivekgupta.composecoachmark.coachmark.CircleRevealEffect)
 binds: [B:27:0x00b3, B:17:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d0, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, (java.lang.Object) null, (kotlin.jvm.functions.Function1) null, r6, 12, (java.lang.Object) null) == r0) goto L31;
     */
    @Override // com.vivekgupta.composecoachmark.coachmark.RevealEffect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object enterAnimation(androidx.compose.ui.geometry.Rect r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivekgupta.composecoachmark.coachmark.CircleRevealEffect.enterAnimation(androidx.compose.ui.geometry.Rect, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0085, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, (java.lang.Object) null, (kotlin.jvm.functions.Function1) null, r5, 12, (java.lang.Object) null) == r15) goto L21;
     */
    @Override // com.vivekgupta.composecoachmark.coachmark.RevealEffect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object exitAnimation(androidx.compose.ui.geometry.Rect r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r13 = this;
            boolean r14 = r15 instanceof com.vivekgupta.composecoachmark.coachmark.CircleRevealEffect.C03361
            if (r14 == 0) goto L14
            r14 = r15
            com.vivekgupta.composecoachmark.coachmark.CircleRevealEffect$exitAnimation$1 r14 = (com.vivekgupta.composecoachmark.coachmark.CircleRevealEffect.C03361) r14
            int r0 = r14.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L14
            int r15 = r14.label
            int r15 = r15 - r1
            r14.label = r15
            goto L19
        L14:
            com.vivekgupta.composecoachmark.coachmark.CircleRevealEffect$exitAnimation$1 r14 = new com.vivekgupta.composecoachmark.coachmark.CircleRevealEffect$exitAnimation$1
            r14.<init>(r15)
        L19:
            r5 = r14
            java.lang.Object r14 = r5.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r5.label
            r8 = 0
            r9 = 500(0x1f4, float:7.0E-43)
            r10 = 0
            r1 = 1
            r11 = 0
            r12 = 2
            if (r0 == 0) goto L43
            if (r0 == r1) goto L3b
            if (r0 != r12) goto L33
            kotlin.ResultKt.throwOnFailure(r14)
            goto L88
        L33:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3b:
            java.lang.Object r13 = r5.L$0
            com.vivekgupta.composecoachmark.coachmark.CircleRevealEffect r13 = (com.vivekgupta.composecoachmark.coachmark.CircleRevealEffect) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L67
        L43:
            kotlin.ResultKt.throwOnFailure(r14)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r0 = r13.focus
            r14 = r1
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10)
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r9, r8, r2, r12, r11)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r5.L$0 = r13
            r5.label = r14
            r3 = 0
            r4 = 0
            r6 = 12
            r7 = 0
            java.lang.Object r14 = androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r14 != r15) goto L67
            goto L87
        L67:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r0 = r13.radius
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10)
            androidx.compose.animation.core.Easing r13 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r13 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r9, r8, r13, r12, r11)
            r2 = r13
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r5.L$0 = r11
            r5.label = r12
            r3 = 0
            r4 = 0
            r6 = 12
            r7 = 0
            java.lang.Object r13 = androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r13 != r15) goto L88
        L87:
            return r15
        L88:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivekgupta.composecoachmark.coachmark.CircleRevealEffect.exitAnimation(androidx.compose.ui.geometry.Rect, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.vivekgupta.composecoachmark.coachmark.RevealEffect
    public Rect drawTargetShape(Rect targetBounds, DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(targetBounds, "targetBounds");
        Intrinsics.checkNotNullParameter(drawScope, "drawScope");
        DrawScope.drawCircle-VaOC9Bg$default(drawScope, Color.Companion.getWhite-0d7_KjU(), Math.abs(targetBounds.getMaxDimension()) * ((Number) this.focus.getValue()).floatValue() * 2.0f, targetBounds.getCenter-F1C5BW0(), 1 - ((Number) this.focus.getValue()).floatValue(), (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.getOverlay-0nO6VwU(), 48, (Object) null);
        DrawScope.drawCircle-VaOC9Bg$default(drawScope, Color.Companion.getWhite-0d7_KjU(), ((Number) this.radius.getValue()).floatValue(), targetBounds.getCenter-F1C5BW0(), 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.getClear-0nO6VwU(), 56, (Object) null);
        return RectKt.Rect-tz77jQw(OffsetKt.Offset(Offset.getX-impl(targetBounds.getTopLeft-F1C5BW0()) - 40.0f, Offset.getY-impl(targetBounds.getTopLeft-F1C5BW0()) - (targetBounds.getMaxDimension() / 2.0f)), SizeKt.Size(targetBounds.getMaxDimension() + 80.0f, targetBounds.getMaxDimension() + 80.0f));
    }
}
