package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: NewCoachLayout.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a-\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"NewCoachLayout", "", "canvasRect", "Landroidx/compose/ui/geometry/Rect;", "targetBound", "alignment", "Landroidx/compose/ui/Alignment;", "isForcedAlignment", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "findOffset", "Landroidx/compose/ui/geometry/Offset;", "contentSize", "Landroidx/compose/ui/unit/IntSize;", "findOffset-JVtK1S4", "(Landroidx/compose/ui/geometry/Rect;JLandroidx/compose/ui/Alignment;)J", "composecoachmark_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NewCoachLayoutKt {
    public static final void NewCoachLayout(final Rect rect, final Rect rect2, Alignment alignment, boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        final Alignment alignment2;
        final Alignment alignment3;
        final boolean z2;
        Intrinsics.checkNotNullParameter(rect, "canvasRect");
        Intrinsics.checkNotNullParameter(rect2, "targetBound");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-569920896);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NewCoachLayout)P(1,4!1,3)");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(rect) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(rect2) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(alignment) ? 256 : 128;
        }
        int i5 = i2 & 8;
        if (i5 != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((57344 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(function2) ? 16384 : 8192;
        }
        if ((i3 & 46811) != 9362 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                alignment = Alignment.Companion.getBottomCenter();
            }
            final boolean z3 = i5 != 0 ? false : z;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-569920896, i, -1, "com.vivekgupta.composecoachmark.coachmark.NewCoachLayout (NewCoachLayout.kt:14)");
            }
            Object[] objArr = {function2, Boolean.valueOf(z3), rect2, alignment, rect};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = false;
            for (int i6 = 0; i6 < 5; i6++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i6]);
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                alignment2 = alignment;
                objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.NewCoachLayoutKt$NewCoachLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return m2262invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m2262invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                        final long jOffset;
                        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                        List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                        Iterator it = listSubcompose.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((Measurable) it.next()).measure-BRTryo0(j));
                        }
                        final ArrayList<Placeable> arrayList2 = arrayList;
                        long jIntSize = IntSize.Companion.getZero-YbymL2g();
                        for (Placeable placeable : arrayList2) {
                            jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                        }
                        if (z3) {
                            jOffset = NewCoachLayoutKt.m2261findOffsetJVtK1S4(rect2, jIntSize, alignment2);
                        } else {
                            Rect rect3 = new Rect(rect2.getLeft(), 0.0f, rect.getRight(), Offset.getY-impl(rect2.getTopRight-F1C5BW0()));
                            Rect rect4 = new Rect(rect.getLeft(), Offset.getY-impl(rect2.getBottomLeft-F1C5BW0()), rect.getRight(), rect.getBottom());
                            if (rect3.getHeight() < rect4.getHeight()) {
                                jOffset = rect4.getTopLeft-F1C5BW0();
                            } else if (IntSize.getHeight-impl(jIntSize) <= rect3.getHeight()) {
                                jOffset = OffsetKt.Offset(0.0f, rect2.getTop() - IntSize.getHeight-impl(jIntSize));
                            } else {
                                jOffset = rect3.getTopLeft-F1C5BW0();
                            }
                        }
                        return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, MathKt.roundToInt(rect.getWidth()), MathKt.roundToInt(rect.getHeight()), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.NewCoachLayoutKt$NewCoachLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                                List<Placeable> list = arrayList2;
                                long j2 = jOffset;
                                Iterator<T> it2 = list.iterator();
                                while (it2.hasNext()) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), 0, (int) Offset.getY-impl(j2), 0.0f, 4, (Object) null);
                                }
                            }
                        }, 4, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                alignment2 = alignment;
            }
            composerStartRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout((Modifier) null, (Function2) objRememberedValue, composerStartRestartGroup, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            alignment3 = alignment2;
            z2 = z3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            alignment3 = alignment;
            z2 = z;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.NewCoachLayoutKt.NewCoachLayout.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i7) {
                NewCoachLayoutKt.NewCoachLayout(rect, rect2, alignment3, z2, function2, composer2, i | 1, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: findOffset-JVtK1S4, reason: not valid java name */
    public static final long m2261findOffsetJVtK1S4(Rect rect, long j, Alignment alignment) {
        if (Intrinsics.areEqual(alignment, Alignment.Companion.getTopStart())) {
            return OffsetKt.Offset(Offset.getX-impl(rect.getTopLeft-F1C5BW0()) - IntSize.getWidth-impl(j), Offset.getY-impl(rect.getTopLeft-F1C5BW0()) - IntSize.getHeight-impl(j));
        }
        if (Intrinsics.areEqual(alignment, Alignment.Companion.getTopCenter())) {
            return OffsetKt.Offset(Offset.getX-impl(rect.getCenter-F1C5BW0()) - (IntSize.getWidth-impl(j) / 2.0f), (Offset.getY-impl(rect.getCenter-F1C5BW0()) - rect.getHeight()) - IntSize.getHeight-impl(j));
        }
        if (Intrinsics.areEqual(alignment, Alignment.Companion.getTopEnd())) {
            return OffsetKt.Offset(Offset.getX-impl(rect.getTopRight-F1C5BW0()), Offset.getY-impl(rect.getTopRight-F1C5BW0()) - IntSize.getHeight-impl(j));
        }
        if (Intrinsics.areEqual(alignment, Alignment.Companion.getCenterStart())) {
            return OffsetKt.Offset((Offset.getX-impl(rect.getCenter-F1C5BW0()) - (rect.getWidth() / 2.0f)) - IntSize.getWidth-impl(j), Offset.getY-impl(rect.getCenter-F1C5BW0()) - (IntSize.getHeight-impl(j) / 2));
        }
        if (Intrinsics.areEqual(alignment, Alignment.Companion.getCenterEnd())) {
            return OffsetKt.Offset(Offset.getX-impl(rect.getCenter-F1C5BW0()) + (rect.getWidth() / 2.0f), Offset.getY-impl(rect.getCenter-F1C5BW0()) - (IntSize.getHeight-impl(j) / 2));
        }
        if (Intrinsics.areEqual(alignment, Alignment.Companion.getCenter())) {
            return OffsetKt.Offset(Offset.getX-impl(rect.getCenter-F1C5BW0()) - (IntSize.getWidth-impl(j) / 2.0f), Offset.getY-impl(rect.getCenter-F1C5BW0()));
        }
        if (Intrinsics.areEqual(alignment, Alignment.Companion.getBottomStart())) {
            return OffsetKt.Offset(Offset.getX-impl(rect.getBottomLeft-F1C5BW0()) - IntSize.getWidth-impl(j), Offset.getY-impl(rect.getBottomLeft-F1C5BW0()));
        }
        if (Intrinsics.areEqual(alignment, Alignment.Companion.getBottomCenter())) {
            return OffsetKt.Offset(Offset.getX-impl(rect.getBottomCenter-F1C5BW0()), Offset.getY-impl(rect.getBottomCenter-F1C5BW0()));
        }
        if (Intrinsics.areEqual(alignment, Alignment.Companion.getBottomEnd())) {
            return OffsetKt.Offset(Offset.getX-impl(rect.getBottomRight-F1C5BW0()), Offset.getY-impl(rect.getBottomRight-F1C5BW0()));
        }
        return OffsetKt.Offset(0.0f, 0.0f);
    }
}
