package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonElevation;
import androidx.compose.material.ButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoachStyleSamples.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JG\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0012H\u0017¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001d\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Lcom/vivekgupta/composecoachmark/coachmark/DefaultCoachStyle;", "Lcom/vivekgupta/composecoachmark/coachmark/CoachStyle;", "()V", "backGroundColor", "Landroidx/compose/ui/graphics/Color;", "getBackGroundColor-0d7_KjU", "()J", "backgroundAlpha", "", "getBackgroundAlpha", "()F", "drawCoachButtons", "", "contentScope", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "targetBounds", "Landroidx/compose/ui/geometry/Rect;", "onBack", "Lkotlin/Function0;", "onSkip", "onNext", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "drawCoachShape", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "composecoachmark_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultCoachStyle implements CoachStyle {
    public static final int $stable = 0;

    @Override // com.vivekgupta.composecoachmark.coachmark.CoachStyle
    /* JADX INFO: renamed from: getBackgroundAlpha */
    public float getAlpha() {
        return 0.8f;
    }

    @Override // com.vivekgupta.composecoachmark.coachmark.CoachStyle
    /* JADX INFO: renamed from: getBackGroundColor-0d7_KjU */
    public long getColor() {
        return Color.Companion.getBlack-0d7_KjU();
    }

    @Override // com.vivekgupta.composecoachmark.coachmark.CoachStyle
    public void drawCoachButtons(final BoxWithConstraintsScope boxWithConstraintsScope, final Rect rect, final Function0<Unit> function0, final Function0<Unit> function1, final Function0<Unit> function2, Composer composer, final int i) {
        int i2;
        DefaultCoachStyle defaultCoachStyle;
        Composer composer2;
        Intrinsics.checkNotNullParameter(boxWithConstraintsScope, "contentScope");
        Intrinsics.checkNotNullParameter(rect, "targetBounds");
        Intrinsics.checkNotNullParameter(function0, "onBack");
        Intrinsics.checkNotNullParameter(function1, "onSkip");
        Intrinsics.checkNotNullParameter(function2, "onNext");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1114262963);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(drawCoachButtons)P(!1,4!1,3)");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(boxWithConstraintsScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(function0) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(function1) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(function2) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            defaultCoachStyle = this;
            i2 |= composerStartRestartGroup.changed(defaultCoachStyle) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        } else {
            defaultCoachStyle = this;
        }
        if ((374411 & i2) != 74882 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1114262963, i2, -1, "com.vivekgupta.composecoachmark.coachmark.DefaultCoachStyle.drawCoachButtons (CoachStyleSamples.kt:32)");
            }
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(function1);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.DefaultCoachStyle$drawCoachButtons$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2254invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m2254invoke() {
                        function1.invoke();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ButtonKt.Button((Function0) objRememberedValue, boxWithConstraintsScope.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), false, (MutableInteractionSource) null, (ButtonElevation) null, (Shape) null, (BorderStroke) null, ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(HelperKt.m2258invert8_81llA(defaultCoachStyle.getColor()), getColor(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), (PaddingValues) null, ComposableSingletons$CoachStyleSamplesKt.INSTANCE.m2247getLambda1$composecoachmark_release(), composerStartRestartGroup, 805306368, 380);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(function2);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.DefaultCoachStyle$drawCoachButtons$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2255invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m2255invoke() {
                        function2.invoke();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ButtonKt.Button((Function0) objRememberedValue2, boxWithConstraintsScope.align(Modifier.Companion, Alignment.Companion.getCenterEnd()), false, (MutableInteractionSource) null, (ButtonElevation) null, (Shape) null, (BorderStroke) null, ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(HelperKt.m2258invert8_81llA(getColor()), getColor(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), (PaddingValues) null, ComposableSingletons$CoachStyleSamplesKt.INSTANCE.m2248getLambda2$composecoachmark_release(), composerStartRestartGroup, 805306368, 380);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(function0);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.DefaultCoachStyle$drawCoachButtons$1$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2256invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m2256invoke() {
                        function0.invoke();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ButtonKt.Button((Function0) objRememberedValue3, boxWithConstraintsScope.align(Modifier.Companion, Alignment.Companion.getCenterStart()), false, (MutableInteractionSource) null, (ButtonElevation) null, (Shape) null, (BorderStroke) null, ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(HelperKt.m2258invert8_81llA(getColor()), getColor(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), (PaddingValues) null, ComposableSingletons$CoachStyleSamplesKt.INSTANCE.m2249getLambda3$composecoachmark_release(), composerStartRestartGroup, 805306368, 380);
            composer2 = composerStartRestartGroup;
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.DefaultCoachStyle.drawCoachButtons.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i3) {
                DefaultCoachStyle.this.drawCoachButtons(boxWithConstraintsScope, rect, function0, function1, function2, composer3, i | 1);
            }
        });
    }

    @Override // com.vivekgupta.composecoachmark.coachmark.CoachStyle
    public Rect drawCoachShape(Rect targetBounds, DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(targetBounds, "targetBounds");
        Intrinsics.checkNotNullParameter(drawScope, "drawScope");
        DrawScope.drawRect-n-J9OG0$default(drawScope, Color.copy-wmQWz5c$default(getColor(), getAlpha(), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
        return RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), drawScope.getSize-NH-jbRc());
    }
}
