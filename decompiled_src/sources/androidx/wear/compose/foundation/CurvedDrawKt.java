package androidx.wear.compose.foundation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CurvedDraw.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002¢\u0006\u0002\u0010\u0007\u001aJ\u0010\b\u001a\u00020\t*\u00020\t2*\u0010\n\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\b\b\u0002\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a,\u0010\b\u001a\u00020\t*\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000f\u001a&\u0010\u0010\u001a\u00020\t*\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a4\u0010\u0010\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a+\u0010\u001a\u001a\u00020\t*\u00020\t2\u001d\u0010\u001b\u001a\u0019\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001e0\u001c¢\u0006\u0002\b\u001fH\u0000\u001a+\u0010 \u001a\u00020\t*\u00020\t2\u001d\u0010\u001b\u001a\u0019\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001e0\u001c¢\u0006\u0002\b\u001fH\u0000\u001aJ\u0010!\u001a\u00020\t*\u00020\t2*\u0010\n\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\b\b\u0002\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\b\"\u0010\u000e\u001a,\u0010!\u001a\u00020\t*\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\b\"\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"colorsToColorStops", "", "Lkotlin/Pair;", "", "Landroidx/compose/ui/graphics/Color;", "colors", "", "(Ljava/util/List;)[Lkotlin/Pair;", "angularGradientBackground", "Landroidx/wear/compose/foundation/CurvedModifier;", "colorStops", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "angularGradientBackground-dtTnAaA", "(Landroidx/wear/compose/foundation/CurvedModifier;[Lkotlin/Pair;I)Landroidx/wear/compose/foundation/CurvedModifier;", "(Landroidx/wear/compose/foundation/CurvedModifier;Ljava/util/List;I)Landroidx/wear/compose/foundation/CurvedModifier;", "background", "color", "background-nkY6TQo", "(Landroidx/wear/compose/foundation/CurvedModifier;JI)Landroidx/wear/compose/foundation/CurvedModifier;", "brushProvider", "Lkotlin/Function1;", "Landroidx/wear/compose/foundation/CurvedLayoutInfo;", "Landroidx/compose/ui/graphics/Brush;", "background-qvJQyEo", "(Landroidx/wear/compose/foundation/CurvedModifier;ILkotlin/jvm/functions/Function1;)Landroidx/wear/compose/foundation/CurvedModifier;", "drawAfter", "draw", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawBefore", "radialGradientBackground", "radialGradientBackground-dtTnAaA", "compose-foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CurvedDrawKt {
    /* JADX INFO: renamed from: background-nkY6TQo$default, reason: not valid java name */
    public static /* synthetic */ CurvedModifier m308backgroundnkY6TQo$default(CurvedModifier curvedModifier, long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StrokeCap.Companion.getButt-KaPHkGw();
        }
        return m307backgroundnkY6TQo(curvedModifier, j, i);
    }

    /* JADX INFO: renamed from: background-nkY6TQo, reason: not valid java name */
    public static final CurvedModifier m307backgroundnkY6TQo(CurvedModifier curvedModifier, final long j, int i) {
        return m309backgroundqvJQyEo(curvedModifier, i, new Function1<CurvedLayoutInfo, Brush>() { // from class: androidx.wear.compose.foundation.CurvedDrawKt$background$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Brush invoke(CurvedLayoutInfo curvedLayoutInfo) {
                return new SolidColor(j, (DefaultConstructorMarker) null);
            }
        });
    }

    /* JADX INFO: renamed from: radialGradientBackground-dtTnAaA$default, reason: not valid java name */
    public static /* synthetic */ CurvedModifier m314radialGradientBackgrounddtTnAaA$default(CurvedModifier curvedModifier, Pair[] pairArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StrokeCap.Companion.getButt-KaPHkGw();
        }
        return m312radialGradientBackgrounddtTnAaA(curvedModifier, (Pair<Float, Color>[]) pairArr, i);
    }

    /* JADX INFO: renamed from: radialGradientBackground-dtTnAaA, reason: not valid java name */
    public static final CurvedModifier m312radialGradientBackgrounddtTnAaA(CurvedModifier curvedModifier, final Pair<Float, Color>[] pairArr, int i) {
        return m309backgroundqvJQyEo(curvedModifier, i, new Function1<CurvedLayoutInfo, Brush>() { // from class: androidx.wear.compose.foundation.CurvedDrawKt$radialGradientBackground$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Brush invoke(CurvedLayoutInfo curvedLayoutInfo) {
                float innerRadius = curvedLayoutInfo.getInnerRadius() / curvedLayoutInfo.getOuterRadius();
                Brush.Companion companion = Brush.Companion;
                Pair<Float, Color>[] pairArr2 = pairArr;
                ArrayList arrayList = new ArrayList(pairArr2.length);
                for (Pair<Float, Color> pair : pairArr2) {
                    arrayList.add(TuplesKt.to(Float.valueOf(1.0f - (((Number) pair.component1()).floatValue() * (1.0f - innerRadius))), Color.box-impl(((Color) pair.component2()).unbox-impl())));
                }
                Pair[] pairArr3 = (Pair[]) CollectionsKt.reversed(arrayList).toArray(new Pair[0]);
                return Brush.Companion.radialGradient-P_Vx-Ks$default(companion, (Pair[]) Arrays.copyOf(pairArr3, pairArr3.length), curvedLayoutInfo.getCenterOffset(), curvedLayoutInfo.getOuterRadius(), 0, 8, (Object) null);
            }
        });
    }

    /* JADX INFO: renamed from: radialGradientBackground-dtTnAaA$default, reason: not valid java name */
    public static /* synthetic */ CurvedModifier m313radialGradientBackgrounddtTnAaA$default(CurvedModifier curvedModifier, List list, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StrokeCap.Companion.getButt-KaPHkGw();
        }
        return m311radialGradientBackgrounddtTnAaA(curvedModifier, (List<Color>) list, i);
    }

    /* JADX INFO: renamed from: radialGradientBackground-dtTnAaA, reason: not valid java name */
    public static final CurvedModifier m311radialGradientBackgrounddtTnAaA(CurvedModifier curvedModifier, List<Color> list, int i) {
        Pair<Float, Color>[] pairArrColorsToColorStops = colorsToColorStops(list);
        return m312radialGradientBackgrounddtTnAaA(curvedModifier, (Pair<Float, Color>[]) Arrays.copyOf(pairArrColorsToColorStops, pairArrColorsToColorStops.length), i);
    }

    /* JADX INFO: renamed from: angularGradientBackground-dtTnAaA$default, reason: not valid java name */
    public static /* synthetic */ CurvedModifier m306angularGradientBackgrounddtTnAaA$default(CurvedModifier curvedModifier, Pair[] pairArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StrokeCap.Companion.getButt-KaPHkGw();
        }
        return m304angularGradientBackgrounddtTnAaA(curvedModifier, (Pair<Float, Color>[]) pairArr, i);
    }

    /* JADX INFO: renamed from: angularGradientBackground-dtTnAaA, reason: not valid java name */
    public static final CurvedModifier m304angularGradientBackgrounddtTnAaA(CurvedModifier curvedModifier, final Pair<Float, Color>[] pairArr, int i) {
        return m309backgroundqvJQyEo(curvedModifier, i, new Function1<CurvedLayoutInfo, Brush>() { // from class: androidx.wear.compose.foundation.CurvedDrawKt$angularGradientBackground$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Brush invoke(CurvedLayoutInfo curvedLayoutInfo) {
                Pair<Float, Color>[] pairArr2 = pairArr;
                ArrayList arrayList = new ArrayList(pairArr2.length);
                for (Pair<Float, Color> pair : pairArr2) {
                    arrayList.add(TuplesKt.to(Float.valueOf((curvedLayoutInfo.getStartAngleRadians() + (curvedLayoutInfo.getSweepRadians() * ((Number) pair.component1()).floatValue())) / 6.2831855f), Color.box-impl(((Color) pair.component2()).unbox-impl())));
                }
                List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.wear.compose.foundation.CurvedDrawKt$angularGradientBackground$1$invoke$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues((Float) ((Pair) t).getFirst(), (Float) ((Pair) t2).getFirst());
                    }
                });
                Brush.Companion companion = Brush.Companion;
                Pair[] pairArr3 = (Pair[]) listSortedWith.toArray(new Pair[0]);
                return Brush.Companion.sweepGradient-Uv8p0NA$default(companion, (Pair[]) Arrays.copyOf(pairArr3, pairArr3.length), 0L, 2, (Object) null);
            }
        });
    }

    /* JADX INFO: renamed from: angularGradientBackground-dtTnAaA$default, reason: not valid java name */
    public static /* synthetic */ CurvedModifier m305angularGradientBackgrounddtTnAaA$default(CurvedModifier curvedModifier, List list, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StrokeCap.Companion.getButt-KaPHkGw();
        }
        return m303angularGradientBackgrounddtTnAaA(curvedModifier, (List<Color>) list, i);
    }

    /* JADX INFO: renamed from: angularGradientBackground-dtTnAaA, reason: not valid java name */
    public static final CurvedModifier m303angularGradientBackgrounddtTnAaA(CurvedModifier curvedModifier, List<Color> list, int i) {
        Pair<Float, Color>[] pairArrColorsToColorStops = colorsToColorStops(list);
        return m304angularGradientBackgrounddtTnAaA(curvedModifier, (Pair<Float, Color>[]) Arrays.copyOf(pairArrColorsToColorStops, pairArrColorsToColorStops.length), i);
    }

    private static final Pair<Float, Color>[] colorsToColorStops(List<Color> list) {
        int size = list.size();
        Pair<Float, Color>[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = TuplesKt.to(Float.valueOf(i / (list.size() - 1)), list.get(i));
        }
        return pairArr;
    }

    /* JADX INFO: renamed from: background-qvJQyEo$default, reason: not valid java name */
    public static /* synthetic */ CurvedModifier m310backgroundqvJQyEo$default(CurvedModifier curvedModifier, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = StrokeCap.Companion.getButt-KaPHkGw();
        }
        return m309backgroundqvJQyEo(curvedModifier, i, function1);
    }

    /* JADX INFO: renamed from: background-qvJQyEo, reason: not valid java name */
    public static final CurvedModifier m309backgroundqvJQyEo(CurvedModifier curvedModifier, final int i, final Function1<? super CurvedLayoutInfo, ? extends Brush> function1) {
        return drawBefore(curvedModifier, new Function2<DrawScope, CurvedLayoutInfo, Unit>() { // from class: androidx.wear.compose.foundation.CurvedDrawKt$background$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((DrawScope) obj, (CurvedLayoutInfo) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(DrawScope drawScope, CurvedLayoutInfo curvedLayoutInfo) {
                Function1<CurvedLayoutInfo, Brush> function2 = function1;
                int i2 = i;
                float f = 2;
                float outerRadius = curvedLayoutInfo.getOuterRadius() - (curvedLayoutInfo.getThickness() / f);
                float f2 = f * outerRadius;
                DrawScope.drawArc-illE91I$default(drawScope, (Brush) function2.invoke(curvedLayoutInfo), CurvedLayoutKt.toDegrees(curvedLayoutInfo.getStartAngleRadians()), CurvedLayoutKt.toDegrees(curvedLayoutInfo.getSweepRadians()), false, Offset.minus-MK-Hz9U(curvedLayoutInfo.getCenterOffset(), OffsetKt.Offset(outerRadius, outerRadius)), SizeKt.Size(f2, f2), 0.0f, new Stroke(curvedLayoutInfo.getThickness(), 0.0f, i2, 0, (PathEffect) null, 26, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 832, (Object) null);
            }
        });
    }

    public static final CurvedModifier drawAfter(CurvedModifier curvedModifier, final Function2<? super DrawScope, ? super CurvedLayoutInfo, Unit> function2) {
        return CurvedModifierKt.then(curvedModifier, new Element() { // from class: androidx.wear.compose.foundation.CurvedDrawKt$$ExternalSyntheticLambda0
            @Override // androidx.wear.compose.foundation.Element
            public final CurvedChild wrap(CurvedChild curvedChild) {
                return CurvedDrawKt.drawAfter$lambda$0(function2, curvedChild);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CurvedChild drawAfter$lambda$0(Function2 function2, CurvedChild curvedChild) {
        return new DrawWrapper(curvedChild, function2, false);
    }

    public static final CurvedModifier drawBefore(CurvedModifier curvedModifier, final Function2<? super DrawScope, ? super CurvedLayoutInfo, Unit> function2) {
        return CurvedModifierKt.then(curvedModifier, new Element() { // from class: androidx.wear.compose.foundation.CurvedDrawKt$$ExternalSyntheticLambda1
            @Override // androidx.wear.compose.foundation.Element
            public final CurvedChild wrap(CurvedChild curvedChild) {
                return CurvedDrawKt.drawBefore$lambda$1(function2, curvedChild);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CurvedChild drawBefore$lambda$1(Function2 function2, CurvedChild curvedChild) {
        return new DrawWrapper(curvedChild, function2, true);
    }
}
