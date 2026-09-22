package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: RevealEffect.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/vivekgupta/composecoachmark/coachmark/RevealEffect;", "", "drawTargetShape", "Landroidx/compose/ui/geometry/Rect;", "targetBounds", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "enterAnimation", "", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exitAnimation", "composecoachmark_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RevealEffect {
    Rect drawTargetShape(Rect targetBounds, DrawScope drawScope);

    Object enterAnimation(Rect rect, Continuation<? super Unit> continuation);

    Object exitAnimation(Rect rect, Continuation<? super Unit> continuation);
}
