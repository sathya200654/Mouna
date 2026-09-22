package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: CoachStyle.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JG\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H'¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H&R\u001b\u0010\u0002\u001a\u00020\u0003X¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Lcom/vivekgupta/composecoachmark/coachmark/CoachStyle;", "", "backGroundColor", "Landroidx/compose/ui/graphics/Color;", "getBackGroundColor-0d7_KjU", "()J", "backgroundAlpha", "", "getBackgroundAlpha", "()F", "drawCoachButtons", "", "contentScope", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "targetBounds", "Landroidx/compose/ui/geometry/Rect;", "onBack", "Lkotlin/Function0;", "onSkip", "onNext", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "drawCoachShape", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "composecoachmark_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CoachStyle {
    void drawCoachButtons(BoxWithConstraintsScope boxWithConstraintsScope, Rect rect, Function0<Unit> function0, Function0<Unit> function1, Function0<Unit> function2, Composer composer, int i);

    Rect drawCoachShape(Rect targetBounds, DrawScope drawScope);

    /* JADX INFO: renamed from: getBackGroundColor-0d7_KjU */
    long mo2220getBackGroundColor0d7_KjU();

    float getBackgroundAlpha();
}
