package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.ButtonColors;
import androidx.compose.material.ButtonElevation;
import androidx.compose.material.ButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.perf.util.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CoachStyleSamples.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JG\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015H\u0017¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001d\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lcom/vivekgupta/composecoachmark/coachmark/CanopasStyle;", "Lcom/vivekgupta/composecoachmark/coachmark/CoachStyle;", "()V", "backGroundColor", "Landroidx/compose/ui/graphics/Color;", "getBackGroundColor-0d7_KjU", "()J", "backgroundAlpha", "", "getBackgroundAlpha", "()F", "radius", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "drawCoachButtons", "", "contentScope", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "targetBounds", "Landroidx/compose/ui/geometry/Rect;", "onBack", "Lkotlin/Function0;", "onSkip", "onNext", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "drawCoachShape", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "composecoachmark_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CanopasStyle implements CoachStyle {
    public static final int $stable = Animatable.$stable;
    private final Animatable<Float, AnimationVector1D> radius = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);

    @Override // com.vivekgupta.composecoachmark.coachmark.CoachStyle
    /* JADX INFO: renamed from: getBackgroundAlpha */
    public float getAlpha() {
        return 0.8f;
    }

    @Override // com.vivekgupta.composecoachmark.coachmark.CoachStyle
    /* JADX INFO: renamed from: getBackGroundColor-0d7_KjU, reason: not valid java name */
    public long getColor() {
        return Color.Companion.getBlue-0d7_KjU();
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
        Composer composerStartRestartGroup = composer.startRestartGroup(2068048057);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(drawCoachButtons)P(!1,4!1,3)");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(boxWithConstraintsScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(rect) ? 32 : 16;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(function1) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(function2) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(this) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((373851 & i2) != 74770 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2068048057, i2, -1, "com.vivekgupta.composecoachmark.coachmark.CanopasStyle.drawCoachButtons (CoachStyleSamples.kt:95)");
            }
            EffectsKt.LaunchedEffect(rect, new AnonymousClass1(rect, null), composerStartRestartGroup, ((i2 >> 3) & 14) | 64);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(function1);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CanopasStyle$drawCoachButtons$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2221invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m2221invoke() {
                        function1.invoke();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ButtonKt.Button((Function0) objRememberedValue, boxWithConstraintsScope.align(Modifier.Companion, Alignment.Companion.getBottomStart()), false, (MutableInteractionSource) null, (ButtonElevation) null, (Shape) null, (BorderStroke) null, (ButtonColors) null, (PaddingValues) null, ComposableSingletons$CoachStyleSamplesKt.INSTANCE.m2250getLambda4$composecoachmark_release(), composerStartRestartGroup, 805306368, 508);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(function2);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CanopasStyle$drawCoachButtons$2$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2222invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m2222invoke() {
                        function2.invoke();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            ButtonKt.Button((Function0) objRememberedValue2, boxWithConstraintsScope.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), false, (MutableInteractionSource) null, (ButtonElevation) null, (Shape) null, (BorderStroke) null, (ButtonColors) null, (PaddingValues) null, ComposableSingletons$CoachStyleSamplesKt.INSTANCE.m2251getLambda5$composecoachmark_release(), composer2, 805306368, 508);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CanopasStyle.drawCoachButtons.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i3) {
                CanopasStyle.this.drawCoachButtons(boxWithConstraintsScope, rect, function0, function1, function2, composer3, i | 1);
            }
        });
    }

    @Override // com.vivekgupta.composecoachmark.coachmark.CoachStyle
    public Rect drawCoachShape(Rect targetBounds, DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(targetBounds, "targetBounds");
        Intrinsics.checkNotNullParameter(drawScope, "drawScope");
        DrawScope.drawCircle-VaOC9Bg$default(drawScope, getColor(), ((Number) this.radius.getValue()).floatValue(), targetBounds.getCenter-F1C5BW0(), getAlpha(), (DrawStyle) null, (ColorFilter) null, 0, 112, (Object) null);
        return RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), SizeKt.Size(Size.getWidth-impl(drawScope.getSize-NH-jbRc()), Math.abs(targetBounds.getMaxDimension()) * 3.0f));
    }

    /* JADX INFO: renamed from: com.vivekgupta.composecoachmark.coachmark.CanopasStyle$drawCoachButtons$1, reason: invalid class name */
    /* JADX INFO: compiled from: CoachStyleSamples.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.vivekgupta.composecoachmark.coachmark.CanopasStyle$drawCoachButtons$1", f = "CoachStyleSamples.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Rect $targetBounds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Rect rect, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$targetBounds = rect;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CanopasStyle.this.new AnonymousClass1(this.$targetBounds, continuation);
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
                if (Animatable.animateTo$default(CanopasStyle.this.radius, Boxing.boxFloat(Math.abs(this.$targetBounds.getMaxDimension()) * 3.0f), AnimationSpecKt.tween$default(Constants.MAX_URL_LENGTH, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null), (Object) null, (Function1) null, (Continuation) this, 12, (Object) null) == coroutine_suspended) {
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
