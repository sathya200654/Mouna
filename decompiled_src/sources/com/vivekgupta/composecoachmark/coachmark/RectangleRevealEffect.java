package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RevealEffectSample.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/vivekgupta/composecoachmark/coachmark/RectangleRevealEffect;", "Lcom/vivekgupta/composecoachmark/coachmark/RevealEffect;", "()V", "rect", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "drawTargetShape", "targetBounds", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "enterAnimation", "", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exitAnimation", "composecoachmark_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RectangleRevealEffect implements RevealEffect {
    public static final int $stable = Animatable.$stable;
    private final Animatable<Rect, AnimationVector4D> rect = new Animatable<>(RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), Size.Companion.getZero-NH-jbRc()), HelperKt.getRectToVector(), (Object) null, (String) null, 12, (DefaultConstructorMarker) null);

    /* JADX INFO: renamed from: com.vivekgupta.composecoachmark.coachmark.RectangleRevealEffect$enterAnimation$1, reason: invalid class name */
    /* JADX INFO: compiled from: RevealEffectSample.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.vivekgupta.composecoachmark.coachmark.RectangleRevealEffect", f = "RevealEffectSample.kt", i = {0, 0}, l = {82, 83}, m = "enterAnimation", n = {"this", "newBound"}, s = {"L$0", "L$1"})
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
            return RectangleRevealEffect.this.enterAnimation(null, (Continuation) this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b9, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r9, (java.lang.Object) null, (kotlin.jvm.functions.Function1) null, r6, 12, (java.lang.Object) null) == r0) goto L22;
     */
    @Override // com.vivekgupta.composecoachmark.coachmark.RevealEffect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object enterAnimation(androidx.compose.ui.geometry.Rect r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.vivekgupta.composecoachmark.coachmark.RectangleRevealEffect.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            com.vivekgupta.composecoachmark.coachmark.RectangleRevealEffect$enterAnimation$1 r0 = (com.vivekgupta.composecoachmark.coachmark.RectangleRevealEffect.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.vivekgupta.composecoachmark.coachmark.RectangleRevealEffect$enterAnimation$1 r0 = new com.vivekgupta.composecoachmark.coachmark.RectangleRevealEffect$enterAnimation$1
            r0.<init>(r11)
        L19:
            r6 = r0
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L45
            if (r1 == r2) goto L37
            if (r1 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lbc
        L2f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L37:
            java.lang.Object r9 = r6.L$1
            androidx.compose.ui.geometry.Rect r9 = (androidx.compose.ui.geometry.Rect) r9
            java.lang.Object r10 = r6.L$0
            com.vivekgupta.composecoachmark.coachmark.RectangleRevealEffect r10 = (com.vivekgupta.composecoachmark.coachmark.RectangleRevealEffect) r10
            kotlin.ResultKt.throwOnFailure(r11)
            r2 = r9
            r9 = r10
            goto L9a
        L45:
            kotlin.ResultKt.throwOnFailure(r11)
            long r4 = r10.getTopLeft-F1C5BW0()
            float r11 = androidx.compose.ui.geometry.Offset.getX-impl(r4)
            r1 = 1112014848(0x42480000, float:50.0)
            float r11 = r11 - r1
            long r4 = r10.getTopLeft-F1C5BW0()
            float r4 = androidx.compose.ui.geometry.Offset.getY-impl(r4)
            float r4 = r4 - r1
            long r4 = androidx.compose.ui.geometry.OffsetKt.Offset(r11, r4)
            long r7 = r10.getSize-NH-jbRc()
            float r11 = androidx.compose.ui.geometry.Size.getHeight-impl(r7)
            r1 = 1120403456(0x42c80000, float:100.0)
            float r11 = r11 + r1
            long r7 = r10.getSize-NH-jbRc()
            float r7 = androidx.compose.ui.geometry.Size.getWidth-impl(r7)
            float r7 = r7 + r1
            long r7 = androidx.compose.ui.geometry.SizeKt.Size(r7, r11)
            androidx.compose.ui.geometry.Rect r11 = androidx.compose.ui.geometry.RectKt.Rect-tz77jQw(r4, r7)
            androidx.compose.animation.core.Animatable<androidx.compose.ui.geometry.Rect, androidx.compose.animation.core.AnimationVector4D> r1 = r9.rect
            long r4 = r10.getCenter-F1C5BW0()
            androidx.compose.ui.geometry.Size$Companion r10 = androidx.compose.ui.geometry.Size.Companion
            long r7 = r10.getZero-NH-jbRc()
            androidx.compose.ui.geometry.Rect r10 = androidx.compose.ui.geometry.RectKt.Rect-tz77jQw(r4, r7)
            r6.L$0 = r9
            r6.L$1 = r11
            r6.label = r2
            java.lang.Object r10 = r1.snapTo(r10, r6)
            if (r10 != r0) goto L99
            goto Lbb
        L99:
            r2 = r11
        L9a:
            androidx.compose.animation.core.Animatable<androidx.compose.ui.geometry.Rect, androidx.compose.animation.core.AnimationVector4D> r1 = r9.rect
            r9 = 0
            androidx.compose.animation.core.Easing r10 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r11 = 500(0x1f4, float:7.0E-43)
            r4 = 0
            androidx.compose.animation.core.TweenSpec r9 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r11, r9, r10, r3, r4)
            androidx.compose.animation.core.AnimationSpec r9 = (androidx.compose.animation.core.AnimationSpec) r9
            r6.L$0 = r4
            r6.L$1 = r4
            r6.label = r3
            r5 = 0
            r7 = 12
            r8 = 0
            r3 = r9
            java.lang.Object r9 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r9 != r0) goto Lbc
        Lbb:
            return r0
        Lbc:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivekgupta.composecoachmark.coachmark.RectangleRevealEffect.enterAnimation(androidx.compose.ui.geometry.Rect, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.vivekgupta.composecoachmark.coachmark.RevealEffect
    public Object exitAnimation(Rect rect, Continuation<? super Unit> continuation) {
        Object objAnimateTo$default = Animatable.animateTo$default(this.rect, RectKt.Rect-tz77jQw(rect.getCenter-F1C5BW0(), Size.Companion.getZero-NH-jbRc()), AnimationSpecKt.tween$default(500, 0, EasingKt.getLinearEasing(), 2, (Object) null), (Object) null, (Function1) null, continuation, 12, (Object) null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }

    @Override // com.vivekgupta.composecoachmark.coachmark.RevealEffect
    public Rect drawTargetShape(Rect targetBounds, DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(targetBounds, "targetBounds");
        Intrinsics.checkNotNullParameter(drawScope, "drawScope");
        Rect rect = RectKt.Rect-tz77jQw(OffsetKt.Offset(Offset.getX-impl(targetBounds.getTopLeft-F1C5BW0()) - 50.0f, Offset.getY-impl(targetBounds.getTopLeft-F1C5BW0()) - 50.0f), SizeKt.Size(Size.getWidth-impl(targetBounds.getSize-NH-jbRc()) + 100.0f, Size.getHeight-impl(targetBounds.getSize-NH-jbRc()) + 100.0f));
        DrawScope.drawRect-n-J9OG0$default(drawScope, Color.Companion.getWhite-0d7_KjU(), ((Rect) this.rect.getValue()).getTopLeft-F1C5BW0(), ((Rect) this.rect.getValue()).getSize-NH-jbRc(), 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.getClear-0nO6VwU(), 56, (Object) null);
        return rect;
    }
}
