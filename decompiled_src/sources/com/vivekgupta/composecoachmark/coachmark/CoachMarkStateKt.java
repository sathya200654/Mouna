package com.vivekgupta.composecoachmark.coachmark;

import android.util.Log;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
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
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: CoachMarkState.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\u001aV\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00060\u0011¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001a9\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a9\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"validAlignmentList", "", "Landroidx/compose/ui/Alignment;", "getValidAlignmentList", "()Ljava/util/List;", "CoachLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "canvasSize", "Landroidx/compose/ui/unit/IntSize;", "targetBound", "Landroidx/compose/ui/geometry/Rect;", "alignment", "isForcedAlignment", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "CoachLayout-mqZj4sc", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "findVisiblePositions", "Lkotlin/Pair;", "", "messageBoxSize", "findVisiblePositions-OBdi1-4", "(Landroidx/compose/ui/geometry/Rect;JJ)Lkotlin/Pair;", "returnPositionBasedOnAlignment", "returnPositionBasedOnAlignment-H0pRuoY", "(Landroidx/compose/ui/Alignment;Landroidx/compose/ui/geometry/Rect;J)Lkotlin/Pair;", "composecoachmark_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoachMarkStateKt {
    private static final List<Alignment> validAlignmentList = CollectionsKt.listOf(new Alignment[]{Alignment.Companion.getBottomStart(), Alignment.Companion.getBottomCenter(), Alignment.Companion.getBottomEnd(), Alignment.Companion.getCenterStart(), Alignment.Companion.getCenter(), Alignment.Companion.getCenterEnd(), Alignment.Companion.getTopStart(), Alignment.Companion.getTopCenter(), Alignment.Companion.getTopEnd()});

    /* JADX WARN: Code duplicated, block: B:101:0x015f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:102:0x0160  */
    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Code duplicated, block: B:27:0x005f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0063  */
    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    /* JADX WARN: Code duplicated, block: B:32:0x006c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0073  */
    /* JADX WARN: Code duplicated, block: B:37:0x0076  */
    /* JADX WARN: Code duplicated, block: B:39:0x007a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082  */
    /* JADX WARN: Code duplicated, block: B:42:0x0085  */
    /* JADX WARN: Code duplicated, block: B:47:0x008f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    /* JADX WARN: Code duplicated, block: B:50:0x0098  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:68:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:87:0x011b A[LOOP:0: B:85:0x0118->B:87:0x011b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:90:0x012b  */
    /* JADX WARN: Code duplicated, block: B:94:0x0136  */
    /* JADX WARN: Code duplicated, block: B:97:0x0153  */
    /* JADX INFO: renamed from: CoachLayout-mqZj4sc, reason: not valid java name */
    public static final void m2239CoachLayoutmqZj4sc(Modifier modifier, final long j, final Rect rect, Alignment alignment, boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j2;
        int i4;
        int i5;
        Alignment bottomCenter;
        int i6;
        int i7;
        boolean z2;
        int i8;
        int i9;
        int i10;
        Modifier modifier3;
        final boolean z3;
        Object[] objArr;
        int i11;
        boolean zChanged;
        Object objRememberedValue;
        final Alignment alignment2;
        final Alignment alignment3;
        final Modifier modifier4;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(rect, "targetBound");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2070364377);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CoachLayout)P(4,1:c#ui.unit.IntSize,5!1,3)");
        int i12 = i2 & 1;
        if (i12 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) == 0) {
            if ((i & 112) == 0) {
                j2 = j;
                i3 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
            }
            if ((i2 & 4) != 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                if (composerStartRestartGroup.changed(rect)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
                i3 |= i4;
            }
            i5 = i2 & 8;
            if (i5 != 0) {
                if ((i & 7168) == 0) {
                    bottomCenter = alignment;
                    if (composerStartRestartGroup.changed(bottomCenter)) {
                        i6 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i6;
                }
                i7 = i2 & 16;
                if (i7 != 0) {
                    if ((57344 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i3 |= i8;
                    }
                    if ((i2 & 32) != 0) {
                        if ((458752 & i) == 0) {
                            if (composerStartRestartGroup.changed(function2)) {
                                i9 = 131072;
                            } else {
                                i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                            }
                        }
                        i10 = i3;
                        if ((374491 & i10) == 74898 || !composerStartRestartGroup.getSkipping()) {
                            if (i12 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i5 != 0) {
                                bottomCenter = Alignment.Companion.getBottomCenter();
                            }
                            if (i7 != 0) {
                                z3 = false;
                            } else {
                                z3 = z2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                            }
                            objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                            composerStartRestartGroup.startReplaceableGroup(-568225417);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                            zChanged = false;
                            for (i11 = 0; i11 < 5; i11++) {
                                zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                                final long j3 = j2;
                                alignment2 = bottomCenter;
                                objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                    }

                                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                    public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j4) {
                                        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                        List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                        Iterator it = listSubcompose.iterator();
                                        while (it.hasNext()) {
                                            arrayList.add(((Measurable) it.next()).measure-BRTryo0(j4));
                                        }
                                        final ArrayList<Placeable> arrayList2 = arrayList;
                                        long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                        for (Placeable placeable : arrayList2) {
                                            jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                        }
                                        Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j3) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                        final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                        final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                        return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j3), IntSize.getHeight-impl(j3), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                                float f = fFloatValue;
                                                float f2 = fFloatValue2;
                                                Iterator<T> it2 = list.iterator();
                                                while (it2.hasNext()) {
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                                }
                                            }
                                        }, 4, (Object) null);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                alignment2 = bottomCenter;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            alignment3 = alignment2;
                            modifier4 = modifier3;
                            z4 = z3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            alignment3 = bottomCenter;
                            z4 = z2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i13) {
                                CoachMarkStateKt.m2239CoachLayoutmqZj4sc(modifier4, j, rect, alignment3, z4, function2, composer2, i | 1, i2);
                            }
                        });
                    }
                    i9 = 196608;
                    i3 |= i9;
                    i10 = i3;
                    if ((374491 & i10) == 74898) {
                        if (i12 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            bottomCenter = Alignment.Companion.getBottomCenter();
                        }
                        if (i7 != 0) {
                            z3 = false;
                        } else {
                            z3 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                        }
                        objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                        composerStartRestartGroup.startReplaceableGroup(-568225417);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = false;
                        while (i11 < 5) {
                            zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            final long j4 = j2;
                            alignment2 = bottomCenter;
                            objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j5) {
                                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                    List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                    Iterator it = listSubcompose.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(j5));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                    for (Placeable placeable : arrayList2) {
                                        jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                    }
                                    Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j4) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                    final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                    final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                    return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j4), IntSize.getHeight-impl(j4), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                            float f = fFloatValue;
                                            float f2 = fFloatValue2;
                                            Iterator<T> it2 = list.iterator();
                                            while (it2.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                            }
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final long j5 = j2;
                            alignment2 = bottomCenter;
                            objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j6) {
                                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                    List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                    Iterator it = listSubcompose.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(j6));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                    for (Placeable placeable : arrayList2) {
                                        jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                    }
                                    Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j5) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                    final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                    final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                    return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j5), IntSize.getHeight-impl(j5), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                            float f = fFloatValue;
                                            float f2 = fFloatValue2;
                                            Iterator<T> it2 = list.iterator();
                                            while (it2.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                            }
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        alignment3 = alignment2;
                        modifier4 = modifier3;
                        z4 = z3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            bottomCenter = Alignment.Companion.getBottomCenter();
                        }
                        if (i7 != 0) {
                            z3 = false;
                        } else {
                            z3 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                        }
                        objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                        composerStartRestartGroup.startReplaceableGroup(-568225417);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = false;
                        while (i11 < 5) {
                            zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            final long j6 = j2;
                            alignment2 = bottomCenter;
                            objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j7) {
                                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                    List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                    Iterator it = listSubcompose.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(j7));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                    for (Placeable placeable : arrayList2) {
                                        jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                    }
                                    Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j6) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                    final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                    final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                    return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j6), IntSize.getHeight-impl(j6), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                            float f = fFloatValue;
                                            float f2 = fFloatValue2;
                                            Iterator<T> it2 = list.iterator();
                                            while (it2.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                            }
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final long j7 = j2;
                            alignment2 = bottomCenter;
                            objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j8) {
                                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                    List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                    Iterator it = listSubcompose.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(j8));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                    for (Placeable placeable : arrayList2) {
                                        jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                    }
                                    Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j7) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                    final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                    final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                    return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j7), IntSize.getHeight-impl(j7), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                            float f = fFloatValue;
                                            float f2 = fFloatValue2;
                                            Iterator<T> it2 = list.iterator();
                                            while (it2.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                            }
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        alignment3 = alignment2;
                        modifier4 = modifier3;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            CoachMarkStateKt.m2239CoachLayoutmqZj4sc(modifier4, j, rect, alignment3, z4, function2, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                z2 = z;
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changed(function2)) {
                            i9 = 131072;
                        } else {
                            i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                    }
                    i10 = i3;
                    if ((374491 & i10) == 74898) {
                        if (i12 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            bottomCenter = Alignment.Companion.getBottomCenter();
                        }
                        if (i7 != 0) {
                            z3 = false;
                        } else {
                            z3 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                        }
                        objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                        composerStartRestartGroup.startReplaceableGroup(-568225417);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = false;
                        while (i11 < 5) {
                            zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            final long j8 = j2;
                            alignment2 = bottomCenter;
                            objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j9) {
                                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                    List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                    Iterator it = listSubcompose.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(j9));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                    for (Placeable placeable : arrayList2) {
                                        jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                    }
                                    Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j8) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                    final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                    final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                    return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j8), IntSize.getHeight-impl(j8), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                            float f = fFloatValue;
                                            float f2 = fFloatValue2;
                                            Iterator<T> it2 = list.iterator();
                                            while (it2.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                            }
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final long j9 = j2;
                            alignment2 = bottomCenter;
                            objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j10) {
                                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                    List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                    Iterator it = listSubcompose.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(j10));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                    for (Placeable placeable : arrayList2) {
                                        jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                    }
                                    Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j9) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                    final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                    final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                    return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j9), IntSize.getHeight-impl(j9), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                            float f = fFloatValue;
                                            float f2 = fFloatValue2;
                                            Iterator<T> it2 = list.iterator();
                                            while (it2.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                            }
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        alignment3 = alignment2;
                        modifier4 = modifier3;
                        z4 = z3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            bottomCenter = Alignment.Companion.getBottomCenter();
                        }
                        if (i7 != 0) {
                            z3 = false;
                        } else {
                            z3 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                        }
                        objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                        composerStartRestartGroup.startReplaceableGroup(-568225417);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = false;
                        while (i11 < 5) {
                            zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            final long j10 = j2;
                            alignment2 = bottomCenter;
                            objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j11) {
                                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                    List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                    Iterator it = listSubcompose.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(j11));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                    for (Placeable placeable : arrayList2) {
                                        jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                    }
                                    Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j10) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                    final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                    final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                    return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j10), IntSize.getHeight-impl(j10), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                            float f = fFloatValue;
                                            float f2 = fFloatValue2;
                                            Iterator<T> it2 = list.iterator();
                                            while (it2.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                            }
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final long j11 = j2;
                            alignment2 = bottomCenter;
                            objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j12) {
                                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                    List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                    Iterator it = listSubcompose.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(j12));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                    for (Placeable placeable : arrayList2) {
                                        jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                    }
                                    Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j11) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                    final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                    final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                    return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j11), IntSize.getHeight-impl(j11), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                            float f = fFloatValue;
                                            float f2 = fFloatValue2;
                                            Iterator<T> it2 = list.iterator();
                                            while (it2.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                            }
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        alignment3 = alignment2;
                        modifier4 = modifier3;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            CoachMarkStateKt.m2239CoachLayoutmqZj4sc(modifier4, j, rect, alignment3, z4, function2, composer2, i | 1, i2);
                        }
                    });
                }
                i9 = 196608;
                i3 |= i9;
                i10 = i3;
                if ((374491 & i10) == 74898) {
                    if (i12 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        bottomCenter = Alignment.Companion.getBottomCenter();
                    }
                    if (i7 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                    }
                    objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = false;
                    while (i11 < 5) {
                        zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        final long j12 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j13) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j13));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j12) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j12), IntSize.getHeight-impl(j12), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final long j13 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j14) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j14));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j13) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j13), IntSize.getHeight-impl(j13), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    alignment3 = alignment2;
                    modifier4 = modifier3;
                    z4 = z3;
                } else {
                    if (i12 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        bottomCenter = Alignment.Companion.getBottomCenter();
                    }
                    if (i7 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                    }
                    objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = false;
                    while (i11 < 5) {
                        zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        final long j14 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j15) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j15));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j14) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j14), IntSize.getHeight-impl(j14), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final long j15 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j16) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j16));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j15) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j15), IntSize.getHeight-impl(j15), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    alignment3 = alignment2;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        CoachMarkStateKt.m2239CoachLayoutmqZj4sc(modifier4, j, rect, alignment3, z4, function2, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            bottomCenter = alignment;
            i7 = i2 & 16;
            if (i7 != 0) {
                if ((57344 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changed(function2)) {
                            i9 = 131072;
                        } else {
                            i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                    }
                    i10 = i3;
                    if ((374491 & i10) == 74898) {
                        if (i12 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            bottomCenter = Alignment.Companion.getBottomCenter();
                        }
                        if (i7 != 0) {
                            z3 = false;
                        } else {
                            z3 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                        }
                        objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                        composerStartRestartGroup.startReplaceableGroup(-568225417);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = false;
                        while (i11 < 5) {
                            zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            final long j16 = j2;
                            alignment2 = bottomCenter;
                            objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j17) {
                                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                    List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                    Iterator it = listSubcompose.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(j17));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                    for (Placeable placeable : arrayList2) {
                                        jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                    }
                                    Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j16) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                    final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                    final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                    return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j16), IntSize.getHeight-impl(j16), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                            float f = fFloatValue;
                                            float f2 = fFloatValue2;
                                            Iterator<T> it2 = list.iterator();
                                            while (it2.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                            }
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final long j17 = j2;
                            alignment2 = bottomCenter;
                            objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j18) {
                                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                    List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                    Iterator it = listSubcompose.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(j18));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                    for (Placeable placeable : arrayList2) {
                                        jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                    }
                                    Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j17) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                    final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                    final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                    return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j17), IntSize.getHeight-impl(j17), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                            float f = fFloatValue;
                                            float f2 = fFloatValue2;
                                            Iterator<T> it2 = list.iterator();
                                            while (it2.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                            }
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        alignment3 = alignment2;
                        modifier4 = modifier3;
                        z4 = z3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            bottomCenter = Alignment.Companion.getBottomCenter();
                        }
                        if (i7 != 0) {
                            z3 = false;
                        } else {
                            z3 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                        }
                        objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                        composerStartRestartGroup.startReplaceableGroup(-568225417);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = false;
                        while (i11 < 5) {
                            zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            final long j18 = j2;
                            alignment2 = bottomCenter;
                            objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j19) {
                                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                    List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                    Iterator it = listSubcompose.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(j19));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                    for (Placeable placeable : arrayList2) {
                                        jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                    }
                                    Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j18) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                    final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                    final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                    return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j18), IntSize.getHeight-impl(j18), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                            float f = fFloatValue;
                                            float f2 = fFloatValue2;
                                            Iterator<T> it2 = list.iterator();
                                            while (it2.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                            }
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final long j19 = j2;
                            alignment2 = bottomCenter;
                            objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j110) {
                                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                    List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                    Iterator it = listSubcompose.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(j110));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                    for (Placeable placeable : arrayList2) {
                                        jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                    }
                                    Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j19) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                    final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                    final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                    return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j19), IntSize.getHeight-impl(j19), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                            float f = fFloatValue;
                                            float f2 = fFloatValue2;
                                            Iterator<T> it2 = list.iterator();
                                            while (it2.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                            }
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        alignment3 = alignment2;
                        modifier4 = modifier3;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            CoachMarkStateKt.m2239CoachLayoutmqZj4sc(modifier4, j, rect, alignment3, z4, function2, composer2, i | 1, i2);
                        }
                    });
                }
                i9 = 196608;
                i3 |= i9;
                i10 = i3;
                if ((374491 & i10) == 74898) {
                    if (i12 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        bottomCenter = Alignment.Companion.getBottomCenter();
                    }
                    if (i7 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                    }
                    objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = false;
                    while (i11 < 5) {
                        zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        final long j110 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j111) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j111));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j110) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j110), IntSize.getHeight-impl(j110), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final long j111 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j112) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j112));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j111) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j111), IntSize.getHeight-impl(j111), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    alignment3 = alignment2;
                    modifier4 = modifier3;
                    z4 = z3;
                } else {
                    if (i12 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        bottomCenter = Alignment.Companion.getBottomCenter();
                    }
                    if (i7 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                    }
                    objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = false;
                    while (i11 < 5) {
                        zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        final long j112 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j113) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j113));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j112) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j112), IntSize.getHeight-impl(j112), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final long j113 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j114) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j114));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j113) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j113), IntSize.getHeight-impl(j113), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    alignment3 = alignment2;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        CoachMarkStateKt.m2239CoachLayoutmqZj4sc(modifier4, j, rect, alignment3, z4, function2, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            z2 = z;
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changed(function2)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                }
                i10 = i3;
                if ((374491 & i10) == 74898) {
                    if (i12 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        bottomCenter = Alignment.Companion.getBottomCenter();
                    }
                    if (i7 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                    }
                    objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = false;
                    while (i11 < 5) {
                        zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        final long j114 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j115) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j115));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j114) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j114), IntSize.getHeight-impl(j114), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final long j115 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j116) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j116));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j115) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j115), IntSize.getHeight-impl(j115), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    alignment3 = alignment2;
                    modifier4 = modifier3;
                    z4 = z3;
                } else {
                    if (i12 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        bottomCenter = Alignment.Companion.getBottomCenter();
                    }
                    if (i7 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                    }
                    objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = false;
                    while (i11 < 5) {
                        zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        final long j116 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j117) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j117));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j116) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j116), IntSize.getHeight-impl(j116), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final long j117 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j118) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j118));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j117) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j117), IntSize.getHeight-impl(j117), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    alignment3 = alignment2;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        CoachMarkStateKt.m2239CoachLayoutmqZj4sc(modifier4, j, rect, alignment3, z4, function2, composer2, i | 1, i2);
                    }
                });
            }
            i9 = 196608;
            i3 |= i9;
            i10 = i3;
            if ((374491 & i10) == 74898) {
                if (i12 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    bottomCenter = Alignment.Companion.getBottomCenter();
                }
                if (i7 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                }
                objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = false;
                while (i11 < 5) {
                    zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    final long j118 = j2;
                    alignment2 = bottomCenter;
                    objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j119) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                            List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                            Iterator it = listSubcompose.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).measure-BRTryo0(j119));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            long jIntSize = IntSize.Companion.getZero-YbymL2g();
                            for (Placeable placeable : arrayList2) {
                                jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                            }
                            Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j118) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                            final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                            final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                            return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j118), IntSize.getHeight-impl(j118), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                    float f = fFloatValue;
                                    float f2 = fFloatValue2;
                                    Iterator<T> it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                    }
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final long j119 = j2;
                    alignment2 = bottomCenter;
                    objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j1110) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                            List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                            Iterator it = listSubcompose.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).measure-BRTryo0(j1110));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            long jIntSize = IntSize.Companion.getZero-YbymL2g();
                            for (Placeable placeable : arrayList2) {
                                jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                            }
                            Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j119) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                            final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                            final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                            return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j119), IntSize.getHeight-impl(j119), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                    float f = fFloatValue;
                                    float f2 = fFloatValue2;
                                    Iterator<T> it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                    }
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                alignment3 = alignment2;
                modifier4 = modifier3;
                z4 = z3;
            } else {
                if (i12 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    bottomCenter = Alignment.Companion.getBottomCenter();
                }
                if (i7 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                }
                objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = false;
                while (i11 < 5) {
                    zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    final long j1110 = j2;
                    alignment2 = bottomCenter;
                    objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j1111) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                            List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                            Iterator it = listSubcompose.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).measure-BRTryo0(j1111));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            long jIntSize = IntSize.Companion.getZero-YbymL2g();
                            for (Placeable placeable : arrayList2) {
                                jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                            }
                            Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j1110) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                            final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                            final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                            return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j1110), IntSize.getHeight-impl(j1110), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                    float f = fFloatValue;
                                    float f2 = fFloatValue2;
                                    Iterator<T> it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                    }
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final long j1111 = j2;
                    alignment2 = bottomCenter;
                    objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j1112) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                            List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                            Iterator it = listSubcompose.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).measure-BRTryo0(j1112));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            long jIntSize = IntSize.Companion.getZero-YbymL2g();
                            for (Placeable placeable : arrayList2) {
                                jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                            }
                            Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j1111) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                            final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                            final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                            return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j1111), IntSize.getHeight-impl(j1111), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                    float f = fFloatValue;
                                    float f2 = fFloatValue2;
                                    Iterator<T> it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                    }
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                alignment3 = alignment2;
                modifier4 = modifier3;
                z4 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    CoachMarkStateKt.m2239CoachLayoutmqZj4sc(modifier4, j, rect, alignment3, z4, function2, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        j2 = j;
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            if (composerStartRestartGroup.changed(rect)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        i5 = i2 & 8;
        if (i5 != 0) {
            if ((i & 7168) == 0) {
                bottomCenter = alignment;
                if (composerStartRestartGroup.changed(bottomCenter)) {
                    i6 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i3 |= i6;
            }
            i7 = i2 & 16;
            if (i7 != 0) {
                if ((57344 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changed(function2)) {
                            i9 = 131072;
                        } else {
                            i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                    }
                    i10 = i3;
                    if ((374491 & i10) == 74898) {
                        if (i12 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            bottomCenter = Alignment.Companion.getBottomCenter();
                        }
                        if (i7 != 0) {
                            z3 = false;
                        } else {
                            z3 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                        }
                        objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                        composerStartRestartGroup.startReplaceableGroup(-568225417);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = false;
                        while (i11 < 5) {
                            zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            final long j1112 = j2;
                            alignment2 = bottomCenter;
                            objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j1113) {
                                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                    List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                    Iterator it = listSubcompose.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(j1113));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                    for (Placeable placeable : arrayList2) {
                                        jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                    }
                                    Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j1112) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                    final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                    final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                    return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j1112), IntSize.getHeight-impl(j1112), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                            float f = fFloatValue;
                                            float f2 = fFloatValue2;
                                            Iterator<T> it2 = list.iterator();
                                            while (it2.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                            }
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final long j1113 = j2;
                            alignment2 = bottomCenter;
                            objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j1114) {
                                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                    List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                    Iterator it = listSubcompose.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(j1114));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                    for (Placeable placeable : arrayList2) {
                                        jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                    }
                                    Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j1113) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                    final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                    final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                    return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j1113), IntSize.getHeight-impl(j1113), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                            float f = fFloatValue;
                                            float f2 = fFloatValue2;
                                            Iterator<T> it2 = list.iterator();
                                            while (it2.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                            }
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        alignment3 = alignment2;
                        modifier4 = modifier3;
                        z4 = z3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            bottomCenter = Alignment.Companion.getBottomCenter();
                        }
                        if (i7 != 0) {
                            z3 = false;
                        } else {
                            z3 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                        }
                        objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                        composerStartRestartGroup.startReplaceableGroup(-568225417);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = false;
                        while (i11 < 5) {
                            zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            final long j1114 = j2;
                            alignment2 = bottomCenter;
                            objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j1115) {
                                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                    List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                    Iterator it = listSubcompose.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(j1115));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                    for (Placeable placeable : arrayList2) {
                                        jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                    }
                                    Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j1114) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                    final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                    final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                    return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j1114), IntSize.getHeight-impl(j1114), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                            float f = fFloatValue;
                                            float f2 = fFloatValue2;
                                            Iterator<T> it2 = list.iterator();
                                            while (it2.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                            }
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final long j1115 = j2;
                            alignment2 = bottomCenter;
                            objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j1116) {
                                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                    List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                    Iterator it = listSubcompose.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(j1116));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                    for (Placeable placeable : arrayList2) {
                                        jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                    }
                                    Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j1115) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                    final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                    final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                    return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j1115), IntSize.getHeight-impl(j1115), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                            float f = fFloatValue;
                                            float f2 = fFloatValue2;
                                            Iterator<T> it2 = list.iterator();
                                            while (it2.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                            }
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        alignment3 = alignment2;
                        modifier4 = modifier3;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            CoachMarkStateKt.m2239CoachLayoutmqZj4sc(modifier4, j, rect, alignment3, z4, function2, composer2, i | 1, i2);
                        }
                    });
                }
                i9 = 196608;
                i3 |= i9;
                i10 = i3;
                if ((374491 & i10) == 74898) {
                    if (i12 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        bottomCenter = Alignment.Companion.getBottomCenter();
                    }
                    if (i7 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                    }
                    objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = false;
                    while (i11 < 5) {
                        zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        final long j1116 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j1117) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j1117));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j1116) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j1116), IntSize.getHeight-impl(j1116), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final long j1117 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j1118) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j1118));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j1117) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j1117), IntSize.getHeight-impl(j1117), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    alignment3 = alignment2;
                    modifier4 = modifier3;
                    z4 = z3;
                } else {
                    if (i12 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        bottomCenter = Alignment.Companion.getBottomCenter();
                    }
                    if (i7 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                    }
                    objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = false;
                    while (i11 < 5) {
                        zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        final long j1118 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j1119) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j1119));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j1118) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j1118), IntSize.getHeight-impl(j1118), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final long j1119 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j11110) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j11110));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j1119) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j1119), IntSize.getHeight-impl(j1119), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    alignment3 = alignment2;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        CoachMarkStateKt.m2239CoachLayoutmqZj4sc(modifier4, j, rect, alignment3, z4, function2, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            z2 = z;
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changed(function2)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                }
                i10 = i3;
                if ((374491 & i10) == 74898) {
                    if (i12 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        bottomCenter = Alignment.Companion.getBottomCenter();
                    }
                    if (i7 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                    }
                    objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = false;
                    while (i11 < 5) {
                        zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        final long j11110 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j11111) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j11111));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j11110) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j11110), IntSize.getHeight-impl(j11110), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final long j11111 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j11112) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j11112));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j11111) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j11111), IntSize.getHeight-impl(j11111), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    alignment3 = alignment2;
                    modifier4 = modifier3;
                    z4 = z3;
                } else {
                    if (i12 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        bottomCenter = Alignment.Companion.getBottomCenter();
                    }
                    if (i7 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                    }
                    objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = false;
                    while (i11 < 5) {
                        zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        final long j11112 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j11113) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j11113));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j11112) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j11112), IntSize.getHeight-impl(j11112), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final long j11113 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j11114) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j11114));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j11113) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j11113), IntSize.getHeight-impl(j11113), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    alignment3 = alignment2;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        CoachMarkStateKt.m2239CoachLayoutmqZj4sc(modifier4, j, rect, alignment3, z4, function2, composer2, i | 1, i2);
                    }
                });
            }
            i9 = 196608;
            i3 |= i9;
            i10 = i3;
            if ((374491 & i10) == 74898) {
                if (i12 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    bottomCenter = Alignment.Companion.getBottomCenter();
                }
                if (i7 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                }
                objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = false;
                while (i11 < 5) {
                    zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    final long j11114 = j2;
                    alignment2 = bottomCenter;
                    objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j11115) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                            List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                            Iterator it = listSubcompose.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).measure-BRTryo0(j11115));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            long jIntSize = IntSize.Companion.getZero-YbymL2g();
                            for (Placeable placeable : arrayList2) {
                                jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                            }
                            Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j11114) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                            final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                            final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                            return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j11114), IntSize.getHeight-impl(j11114), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                    float f = fFloatValue;
                                    float f2 = fFloatValue2;
                                    Iterator<T> it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                    }
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final long j11115 = j2;
                    alignment2 = bottomCenter;
                    objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j11116) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                            List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                            Iterator it = listSubcompose.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).measure-BRTryo0(j11116));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            long jIntSize = IntSize.Companion.getZero-YbymL2g();
                            for (Placeable placeable : arrayList2) {
                                jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                            }
                            Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j11115) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                            final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                            final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                            return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j11115), IntSize.getHeight-impl(j11115), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                    float f = fFloatValue;
                                    float f2 = fFloatValue2;
                                    Iterator<T> it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                    }
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                alignment3 = alignment2;
                modifier4 = modifier3;
                z4 = z3;
            } else {
                if (i12 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    bottomCenter = Alignment.Companion.getBottomCenter();
                }
                if (i7 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                }
                objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = false;
                while (i11 < 5) {
                    zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    final long j11116 = j2;
                    alignment2 = bottomCenter;
                    objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j11117) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                            List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                            Iterator it = listSubcompose.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).measure-BRTryo0(j11117));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            long jIntSize = IntSize.Companion.getZero-YbymL2g();
                            for (Placeable placeable : arrayList2) {
                                jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                            }
                            Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j11116) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                            final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                            final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                            return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j11116), IntSize.getHeight-impl(j11116), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                    float f = fFloatValue;
                                    float f2 = fFloatValue2;
                                    Iterator<T> it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                    }
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final long j11117 = j2;
                    alignment2 = bottomCenter;
                    objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j11118) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                            List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                            Iterator it = listSubcompose.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).measure-BRTryo0(j11118));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            long jIntSize = IntSize.Companion.getZero-YbymL2g();
                            for (Placeable placeable : arrayList2) {
                                jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                            }
                            Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j11117) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                            final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                            final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                            return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j11117), IntSize.getHeight-impl(j11117), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                    float f = fFloatValue;
                                    float f2 = fFloatValue2;
                                    Iterator<T> it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                    }
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                alignment3 = alignment2;
                modifier4 = modifier3;
                z4 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    CoachMarkStateKt.m2239CoachLayoutmqZj4sc(modifier4, j, rect, alignment3, z4, function2, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        bottomCenter = alignment;
        i7 = i2 & 16;
        if (i7 != 0) {
            if ((57344 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changed(function2)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                }
                i10 = i3;
                if ((374491 & i10) == 74898) {
                    if (i12 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        bottomCenter = Alignment.Companion.getBottomCenter();
                    }
                    if (i7 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                    }
                    objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = false;
                    while (i11 < 5) {
                        zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        final long j11118 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j11119) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j11119));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j11118) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j11118), IntSize.getHeight-impl(j11118), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final long j11119 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j111110) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j111110));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j11119) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j11119), IntSize.getHeight-impl(j11119), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    alignment3 = alignment2;
                    modifier4 = modifier3;
                    z4 = z3;
                } else {
                    if (i12 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        bottomCenter = Alignment.Companion.getBottomCenter();
                    }
                    if (i7 != 0) {
                        z3 = false;
                    } else {
                        z3 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                    }
                    objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = false;
                    while (i11 < 5) {
                        zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        final long j111110 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j111111) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j111111));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j111110) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j111110), IntSize.getHeight-impl(j111110), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final long j111111 = j2;
                        alignment2 = bottomCenter;
                        objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j111112) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                                List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                                Iterator it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(j111112));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                long jIntSize = IntSize.Companion.getZero-YbymL2g();
                                for (Placeable placeable : arrayList2) {
                                    jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                                }
                                Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j111111) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                                final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                                final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                                return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j111111), IntSize.getHeight-impl(j111111), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                        float f = fFloatValue;
                                        float f2 = fFloatValue2;
                                        Iterator<T> it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                        }
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    alignment3 = alignment2;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        CoachMarkStateKt.m2239CoachLayoutmqZj4sc(modifier4, j, rect, alignment3, z4, function2, composer2, i | 1, i2);
                    }
                });
            }
            i9 = 196608;
            i3 |= i9;
            i10 = i3;
            if ((374491 & i10) == 74898) {
                if (i12 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    bottomCenter = Alignment.Companion.getBottomCenter();
                }
                if (i7 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                }
                objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = false;
                while (i11 < 5) {
                    zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    final long j111112 = j2;
                    alignment2 = bottomCenter;
                    objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j111113) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                            List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                            Iterator it = listSubcompose.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).measure-BRTryo0(j111113));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            long jIntSize = IntSize.Companion.getZero-YbymL2g();
                            for (Placeable placeable : arrayList2) {
                                jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                            }
                            Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j111112) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                            final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                            final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                            return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j111112), IntSize.getHeight-impl(j111112), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                    float f = fFloatValue;
                                    float f2 = fFloatValue2;
                                    Iterator<T> it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                    }
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final long j111113 = j2;
                    alignment2 = bottomCenter;
                    objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j111114) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                            List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                            Iterator it = listSubcompose.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).measure-BRTryo0(j111114));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            long jIntSize = IntSize.Companion.getZero-YbymL2g();
                            for (Placeable placeable : arrayList2) {
                                jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                            }
                            Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j111113) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                            final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                            final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                            return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j111113), IntSize.getHeight-impl(j111113), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                    float f = fFloatValue;
                                    float f2 = fFloatValue2;
                                    Iterator<T> it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                    }
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                alignment3 = alignment2;
                modifier4 = modifier3;
                z4 = z3;
            } else {
                if (i12 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    bottomCenter = Alignment.Companion.getBottomCenter();
                }
                if (i7 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                }
                objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = false;
                while (i11 < 5) {
                    zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    final long j111114 = j2;
                    alignment2 = bottomCenter;
                    objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j111115) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                            List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                            Iterator it = listSubcompose.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).measure-BRTryo0(j111115));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            long jIntSize = IntSize.Companion.getZero-YbymL2g();
                            for (Placeable placeable : arrayList2) {
                                jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                            }
                            Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j111114) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                            final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                            final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                            return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j111114), IntSize.getHeight-impl(j111114), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                    float f = fFloatValue;
                                    float f2 = fFloatValue2;
                                    Iterator<T> it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                    }
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final long j111115 = j2;
                    alignment2 = bottomCenter;
                    objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j111116) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                            List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                            Iterator it = listSubcompose.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).measure-BRTryo0(j111116));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            long jIntSize = IntSize.Companion.getZero-YbymL2g();
                            for (Placeable placeable : arrayList2) {
                                jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                            }
                            Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j111115) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                            final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                            final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                            return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j111115), IntSize.getHeight-impl(j111115), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                    float f = fFloatValue;
                                    float f2 = fFloatValue2;
                                    Iterator<T> it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                    }
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                alignment3 = alignment2;
                modifier4 = modifier3;
                z4 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    CoachMarkStateKt.m2239CoachLayoutmqZj4sc(modifier4, j, rect, alignment3, z4, function2, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        z2 = z;
        if ((i2 & 32) != 0) {
            if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changed(function2)) {
                    i9 = 131072;
                } else {
                    i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
            }
            i10 = i3;
            if ((374491 & i10) == 74898) {
                if (i12 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    bottomCenter = Alignment.Companion.getBottomCenter();
                }
                if (i7 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                }
                objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = false;
                while (i11 < 5) {
                    zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    final long j111116 = j2;
                    alignment2 = bottomCenter;
                    objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j111117) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                            List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                            Iterator it = listSubcompose.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).measure-BRTryo0(j111117));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            long jIntSize = IntSize.Companion.getZero-YbymL2g();
                            for (Placeable placeable : arrayList2) {
                                jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                            }
                            Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j111116) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                            final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                            final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                            return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j111116), IntSize.getHeight-impl(j111116), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                    float f = fFloatValue;
                                    float f2 = fFloatValue2;
                                    Iterator<T> it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                    }
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final long j111117 = j2;
                    alignment2 = bottomCenter;
                    objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j111118) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                            List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                            Iterator it = listSubcompose.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).measure-BRTryo0(j111118));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            long jIntSize = IntSize.Companion.getZero-YbymL2g();
                            for (Placeable placeable : arrayList2) {
                                jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                            }
                            Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j111117) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                            final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                            final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                            return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j111117), IntSize.getHeight-impl(j111117), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                    float f = fFloatValue;
                                    float f2 = fFloatValue2;
                                    Iterator<T> it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                    }
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                alignment3 = alignment2;
                modifier4 = modifier3;
                z4 = z3;
            } else {
                if (i12 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    bottomCenter = Alignment.Companion.getBottomCenter();
                }
                if (i7 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
                }
                objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = false;
                while (i11 < 5) {
                    zChanged |= composerStartRestartGroup.changed(objArr[i11]);
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    final long j111118 = j2;
                    alignment2 = bottomCenter;
                    objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j111119) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                            List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                            Iterator it = listSubcompose.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).measure-BRTryo0(j111119));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            long jIntSize = IntSize.Companion.getZero-YbymL2g();
                            for (Placeable placeable : arrayList2) {
                                jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                            }
                            Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j111118) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                            final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                            final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                            return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j111118), IntSize.getHeight-impl(j111118), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                    float f = fFloatValue;
                                    float f2 = fFloatValue2;
                                    Iterator<T> it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                    }
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final long j111119 = j2;
                    alignment2 = bottomCenter;
                    objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j1111110) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                            List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                            Iterator it = listSubcompose.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Measurable) it.next()).measure-BRTryo0(j1111110));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            long jIntSize = IntSize.Companion.getZero-YbymL2g();
                            for (Placeable placeable : arrayList2) {
                                jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                            }
                            Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j111119) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                            final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                            final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                            return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j111119), IntSize.getHeight-impl(j111119), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                    float f = fFloatValue;
                                    float f2 = fFloatValue2;
                                    Iterator<T> it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                    }
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                alignment3 = alignment2;
                modifier4 = modifier3;
                z4 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    CoachMarkStateKt.m2239CoachLayoutmqZj4sc(modifier4, j, rect, alignment3, z4, function2, composer2, i | 1, i2);
                }
            });
        }
        i9 = 196608;
        i3 |= i9;
        i10 = i3;
        if ((374491 & i10) == 74898) {
            if (i12 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i5 != 0) {
                bottomCenter = Alignment.Companion.getBottomCenter();
            }
            if (i7 != 0) {
                z3 = false;
            } else {
                z3 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
            }
            objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            zChanged = false;
            while (i11 < 5) {
                zChanged |= composerStartRestartGroup.changed(objArr[i11]);
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                final long j1111110 = j2;
                alignment2 = bottomCenter;
                objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j1111111) {
                        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                        List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                        Iterator it = listSubcompose.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((Measurable) it.next()).measure-BRTryo0(j1111111));
                        }
                        final List<? extends Placeable> arrayList2 = arrayList;
                        long jIntSize = IntSize.Companion.getZero-YbymL2g();
                        for (Placeable placeable : arrayList2) {
                            jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                        }
                        Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j1111110) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                        final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                        final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                        return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j1111110), IntSize.getHeight-impl(j1111110), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                float f = fFloatValue;
                                float f2 = fFloatValue2;
                                Iterator<T> it2 = list.iterator();
                                while (it2.hasNext()) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                }
                            }
                        }, 4, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                final long j1111111 = j2;
                alignment2 = bottomCenter;
                objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j1111112) {
                        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                        List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                        Iterator it = listSubcompose.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((Measurable) it.next()).measure-BRTryo0(j1111112));
                        }
                        final List<? extends Placeable> arrayList2 = arrayList;
                        long jIntSize = IntSize.Companion.getZero-YbymL2g();
                        for (Placeable placeable : arrayList2) {
                            jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                        }
                        Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j1111111) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                        final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                        final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                        return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j1111111), IntSize.getHeight-impl(j1111111), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                float f = fFloatValue;
                                float f2 = fFloatValue2;
                                Iterator<T> it2 = list.iterator();
                                while (it2.hasNext()) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                }
                            }
                        }, 4, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            alignment3 = alignment2;
            modifier4 = modifier3;
            z4 = z3;
        } else {
            if (i12 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i5 != 0) {
                bottomCenter = Alignment.Companion.getBottomCenter();
            }
            if (i7 != 0) {
                z3 = false;
            } else {
                z3 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2070364377, i10, -1, "com.vivekgupta.composecoachmark.coachmark.CoachLayout (CoachMarkState.kt:25)");
            }
            objArr = new Object[]{function2, Boolean.valueOf(z3), rect, IntSize.box-impl(j2), bottomCenter};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            zChanged = false;
            while (i11 < 5) {
                zChanged |= composerStartRestartGroup.changed(objArr[i11]);
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                final long j1111112 = j2;
                alignment2 = bottomCenter;
                objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j1111113) {
                        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                        List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                        Iterator it = listSubcompose.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((Measurable) it.next()).measure-BRTryo0(j1111113));
                        }
                        final List<? extends Placeable> arrayList2 = arrayList;
                        long jIntSize = IntSize.Companion.getZero-YbymL2g();
                        for (Placeable placeable : arrayList2) {
                            jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                        }
                        Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j1111112) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                        final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                        final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                        return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j1111112), IntSize.getHeight-impl(j1111112), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                float f = fFloatValue;
                                float f2 = fFloatValue2;
                                Iterator<T> it2 = list.iterator();
                                while (it2.hasNext()) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                }
                            }
                        }, 4, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                final long j1111113 = j2;
                alignment2 = bottomCenter;
                objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return m2244invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m2244invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j1111114) {
                        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                        List listSubcompose = subcomposeMeasureScope.subcompose(Unit.INSTANCE, function2);
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubcompose, 10));
                        Iterator it = listSubcompose.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((Measurable) it.next()).measure-BRTryo0(j1111114));
                        }
                        final List<? extends Placeable> arrayList2 = arrayList;
                        long jIntSize = IntSize.Companion.getZero-YbymL2g();
                        for (Placeable placeable : arrayList2) {
                            jIntSize = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(jIntSize), placeable.getWidth()), Math.max(IntSize.getHeight-impl(jIntSize), placeable.getHeight()));
                        }
                        Pair pairM2242findVisiblePositionsOBdi14 = !z3 ? CoachMarkStateKt.m2242findVisiblePositionsOBdi14(rect, jIntSize, j1111113) : CoachMarkStateKt.m2243returnPositionBasedOnAlignmentH0pRuoY(alignment2, rect, jIntSize);
                        final float fFloatValue = ((Number) pairM2242findVisiblePositionsOBdi14.component1()).floatValue();
                        final float fFloatValue2 = ((Number) pairM2242findVisiblePositionsOBdi14.component2()).floatValue();
                        return MeasureScope.layout$default((MeasureScope) subcomposeMeasureScope, IntSize.getWidth-impl(j1111113), IntSize.getHeight-impl(j1111113), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$1$1.1
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
                                float f = fFloatValue;
                                float f2 = fFloatValue2;
                                Iterator<T> it2 = list.iterator();
                                while (it2.hasNext()) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) it2.next(), MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, (Object) null);
                                }
                            }
                        }, 4, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier3, (Function2) objRememberedValue, composerStartRestartGroup, i10 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            alignment3 = alignment2;
            modifier4 = modifier3;
            z4 = z3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkStateKt$CoachLayout$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i13) {
                CoachMarkStateKt.m2239CoachLayoutmqZj4sc(modifier4, j, rect, alignment3, z4, function2, composer2, i | 1, i2);
            }
        });
    }

    public static final List<Alignment> getValidAlignmentList() {
        return validAlignmentList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: findVisiblePositions-OBdi1-4, reason: not valid java name */
    public static final Pair<Float, Float> m2242findVisiblePositionsOBdi14(Rect rect, long j, long j2) {
        Object next;
        Triple triple;
        Iterator<T> it = validAlignmentList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Alignment alignment = (Alignment) next;
            if (Intrinsics.areEqual(alignment, Alignment.Companion.getTopStart())) {
                triple = new Triple(Float.valueOf(Offset.getX-impl(rect.getTopLeft-F1C5BW0())), Float.valueOf(Offset.getY-impl(rect.getTopLeft-F1C5BW0())), Offset.box-impl(OffsetKt.Offset(IntSize.getWidth-impl(j), IntSize.getHeight-impl(j))));
            } else if (Intrinsics.areEqual(alignment, Alignment.Companion.getTopCenter())) {
                triple = new Triple(Float.valueOf(Offset.getX-impl(rect.getTopCenter-F1C5BW0())), Float.valueOf(Offset.getY-impl(rect.getTopCenter-F1C5BW0())), Offset.box-impl(OffsetKt.Offset(IntSize.getWidth-impl(j) / 2, IntSize.getHeight-impl(j) + 20.0f)));
            } else if (Intrinsics.areEqual(alignment, Alignment.Companion.getTopEnd())) {
                triple = new Triple(Float.valueOf(Offset.getX-impl(rect.getTopRight-F1C5BW0())), Float.valueOf(Offset.getY-impl(rect.getTopRight-F1C5BW0())), Offset.box-impl(OffsetKt.Offset(0.0f, IntSize.getHeight-impl(j))));
            } else if (Intrinsics.areEqual(alignment, Alignment.Companion.getBottomStart())) {
                triple = new Triple(Float.valueOf(Offset.getX-impl(rect.getBottomLeft-F1C5BW0())), Float.valueOf(Offset.getY-impl(rect.getBottomLeft-F1C5BW0())), Offset.box-impl(OffsetKt.Offset(IntSize.getWidth-impl(j), 0.0f)));
            } else {
                if (Intrinsics.areEqual(alignment, Alignment.Companion.getBottomCenter()) ? true : Intrinsics.areEqual(alignment, Alignment.Companion.getCenter())) {
                    triple = new Triple(Float.valueOf(Offset.getX-impl(rect.getBottomCenter-F1C5BW0())), Float.valueOf(Offset.getY-impl(rect.getBottomCenter-F1C5BW0())), Offset.box-impl(OffsetKt.Offset(rect.getWidth() / 2.0f, -20.0f)));
                } else if (Intrinsics.areEqual(alignment, Alignment.Companion.getBottomEnd())) {
                    triple = new Triple(Float.valueOf(Offset.getX-impl(rect.getBottomRight-F1C5BW0())), Float.valueOf(Offset.getY-impl(rect.getBottomRight-F1C5BW0())), Offset.box-impl(OffsetKt.Offset(0.0f, 0.0f)));
                } else if (Intrinsics.areEqual(alignment, Alignment.Companion.getCenterStart())) {
                    triple = new Triple(Float.valueOf(Offset.getX-impl(rect.getCenterLeft-F1C5BW0())), Float.valueOf(Offset.getY-impl(rect.getCenterLeft-F1C5BW0())), Offset.box-impl(OffsetKt.Offset(IntSize.getWidth-impl(j), IntSize.getHeight-impl(j) / 2)));
                } else if (Intrinsics.areEqual(alignment, Alignment.Companion.getCenterEnd())) {
                    triple = new Triple(Float.valueOf(Offset.getX-impl(rect.getCenterRight-F1C5BW0())), Float.valueOf(Offset.getY-impl(rect.getCenterRight-F1C5BW0())), Offset.box-impl(OffsetKt.Offset(0.0f, IntSize.getHeight-impl(j) / 2)));
                } else {
                    triple = new Triple(Float.valueOf(0.0f), Float.valueOf(0.0f), Offset.box-impl(OffsetKt.Offset(0.0f, 0.0f)));
                }
            }
            float fFloatValue = ((Number) triple.component1()).floatValue();
            float fFloatValue2 = ((Number) triple.component2()).floatValue();
            long j3 = ((Offset) triple.component3()).unbox-impl();
            Rect rect2 = RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), IntSizeKt.toSize-ozmzZPI(j2));
            Rect rect3 = RectKt.Rect-tz77jQw(OffsetKt.Offset(fFloatValue - Offset.getX-impl(j3), fFloatValue2 - Offset.getY-impl(j3)), IntSizeKt.toSize-ozmzZPI(j));
            boolean z = rect2.contains-k-4lQ0M(rect3.getTopLeft-F1C5BW0());
            boolean z2 = rect2.contains-k-4lQ0M(rect3.getBottomRight-F1C5BW0());
            Log.d("MyLog", "For Alignment = " + alignment + " isContained = " + z + " and " + z2);
            if (z && z2) {
                break;
            }
        }
        Alignment bottomCenter = (Alignment) next;
        if (bottomCenter == null) {
            Log.d("MyLog", "Valid Alignment is Null");
            bottomCenter = Alignment.Companion.getBottomCenter();
        }
        return m2243returnPositionBasedOnAlignmentH0pRuoY(bottomCenter, rect, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: returnPositionBasedOnAlignment-H0pRuoY, reason: not valid java name */
    public static final Pair<Float, Float> m2243returnPositionBasedOnAlignmentH0pRuoY(Alignment alignment, Rect rect, long j) {
        Triple triple;
        if (Intrinsics.areEqual(alignment, Alignment.Companion.getTopStart())) {
            triple = new Triple(Float.valueOf(Offset.getX-impl(rect.getTopLeft-F1C5BW0())), Float.valueOf(Offset.getY-impl(rect.getTopLeft-F1C5BW0())), Offset.box-impl(OffsetKt.Offset(IntSize.getWidth-impl(j), IntSize.getHeight-impl(j))));
        } else if (Intrinsics.areEqual(alignment, Alignment.Companion.getTopCenter())) {
            triple = new Triple(Float.valueOf(Offset.getX-impl(rect.getTopCenter-F1C5BW0())), Float.valueOf(Offset.getY-impl(rect.getTopCenter-F1C5BW0())), Offset.box-impl(OffsetKt.Offset(IntSize.getWidth-impl(j) / 2, IntSize.getHeight-impl(j) + 20.0f)));
        } else if (Intrinsics.areEqual(alignment, Alignment.Companion.getTopEnd())) {
            triple = new Triple(Float.valueOf(Offset.getX-impl(rect.getTopRight-F1C5BW0())), Float.valueOf(Offset.getY-impl(rect.getTopRight-F1C5BW0())), Offset.box-impl(OffsetKt.Offset(0.0f, IntSize.getHeight-impl(j))));
        } else if (Intrinsics.areEqual(alignment, Alignment.Companion.getBottomStart())) {
            triple = new Triple(Float.valueOf(Offset.getX-impl(rect.getBottomLeft-F1C5BW0())), Float.valueOf(Offset.getY-impl(rect.getBottomLeft-F1C5BW0())), Offset.box-impl(OffsetKt.Offset(IntSize.getWidth-impl(j), 0.0f)));
        } else {
            if (Intrinsics.areEqual(alignment, Alignment.Companion.getBottomCenter()) ? true : Intrinsics.areEqual(alignment, Alignment.Companion.getCenter())) {
                triple = new Triple(Float.valueOf(Offset.getX-impl(rect.getBottomCenter-F1C5BW0())), Float.valueOf(Offset.getY-impl(rect.getBottomCenter-F1C5BW0())), Offset.box-impl(OffsetKt.Offset(rect.getWidth() / 2.0f, -20.0f)));
            } else if (Intrinsics.areEqual(alignment, Alignment.Companion.getBottomEnd())) {
                triple = new Triple(Float.valueOf(Offset.getX-impl(rect.getBottomRight-F1C5BW0())), Float.valueOf(Offset.getY-impl(rect.getBottomRight-F1C5BW0())), Offset.box-impl(OffsetKt.Offset(0.0f, 0.0f)));
            } else if (Intrinsics.areEqual(alignment, Alignment.Companion.getCenterStart())) {
                triple = new Triple(Float.valueOf(Offset.getX-impl(rect.getCenterLeft-F1C5BW0())), Float.valueOf(Offset.getY-impl(rect.getCenterLeft-F1C5BW0())), Offset.box-impl(OffsetKt.Offset(IntSize.getWidth-impl(j), IntSize.getHeight-impl(j) / 2)));
            } else if (Intrinsics.areEqual(alignment, Alignment.Companion.getCenterEnd())) {
                triple = new Triple(Float.valueOf(Offset.getX-impl(rect.getCenterRight-F1C5BW0())), Float.valueOf(Offset.getY-impl(rect.getCenterRight-F1C5BW0())), Offset.box-impl(OffsetKt.Offset(0.0f, IntSize.getHeight-impl(j) / 2)));
            } else {
                triple = new Triple(Float.valueOf(0.0f), Float.valueOf(0.0f), Offset.box-impl(OffsetKt.Offset(0.0f, 0.0f)));
            }
        }
        float fFloatValue = ((Number) triple.component1()).floatValue();
        float fFloatValue2 = ((Number) triple.component2()).floatValue();
        long j2 = ((Offset) triple.component3()).unbox-impl();
        return new Pair<>(Float.valueOf(fFloatValue - Offset.getX-impl(j2)), Float.valueOf(fFloatValue2 - Offset.getY-impl(j2)));
    }
}
