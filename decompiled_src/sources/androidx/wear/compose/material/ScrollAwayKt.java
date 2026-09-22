package androidx.wear.compose.material;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ScrollAway.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a0\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a%\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\u0002\b\u001aH\u0002\u001a0\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u001c\u001a2\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u001d2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u001e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\b\u0010\u0005\"\u000e\u0010\t\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"maxMotionOut", "", "maxOffset", "Landroidx/compose/ui/unit/Dp;", "getMaxOffset", "()F", "F", "maxScrollOut", "getMaxScrollOut", "minMotionOut", "scrollAway", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "offset", "scrollAway-wH6b6FI", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;F)Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/lazy/LazyListState;", "itemIndex", "", "scrollAway-eqLRuRQ", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;IF)Landroidx/compose/ui/Modifier;", "scrollFn", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/wear/compose/material/ScrollParams;", "Lkotlin/ExtensionFunctionType;", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;", "(Landroidx/compose/ui/Modifier;Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;IF)Landroidx/compose/ui/Modifier;", "Landroidx/wear/compose/material/ScalingLazyListState;", "(Landroidx/compose/ui/Modifier;Landroidx/wear/compose/material/ScalingLazyListState;IF)Landroidx/compose/ui/Modifier;", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScrollAwayKt {
    public static final float maxMotionOut = 0.5f;
    public static final float minMotionOut = 1.0f;
    private static final float maxScrollOut = Dp.constructor-impl(36);
    private static final float maxOffset = Dp.constructor-impl(24);

    /* JADX INFO: renamed from: scrollAway-wH6b6FI, reason: not valid java name */
    public static final Modifier m783scrollAwaywH6b6FI(Modifier modifier, final ScrollState scrollState, final float f) {
        return scrollAway(modifier, new Function1<Density, ScrollParams>() { // from class: androidx.wear.compose.material.ScrollAwayKt.scrollAway.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final ScrollParams invoke(Density density) {
                return new ScrollParams(true, Float.valueOf(scrollState.getValue() - density.toPx-0680j_4(f)));
            }
        });
    }

    /* JADX INFO: renamed from: scrollAway-eqLRuRQ, reason: not valid java name */
    public static final Modifier m777scrollAwayeqLRuRQ(Modifier modifier, final LazyListState lazyListState, final int i, final float f) {
        return scrollAway(modifier, new Function1<Density, ScrollParams>() { // from class: androidx.wear.compose.material.ScrollAwayKt.scrollAway.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final ScrollParams invoke(Density density) {
                Float fValueOf;
                Object obj;
                int i2 = 0;
                boolean z = i < lazyListState.getLayoutInfo().getTotalItemsCount();
                List visibleItemsInfo = lazyListState.getLayoutInfo().getVisibleItemsInfo();
                int i3 = i;
                int size = visibleItemsInfo.size();
                while (true) {
                    fValueOf = null;
                    if (i2 >= size) {
                        obj = null;
                        break;
                    }
                    obj = visibleItemsInfo.get(i2);
                    if (((LazyListItemInfo) obj).getIndex() == i3) {
                        break;
                    }
                    i2++;
                }
                LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) obj;
                if (lazyListItemInfo != null) {
                    fValueOf = Float.valueOf((-lazyListItemInfo.getOffset()) - density.toPx-0680j_4(f));
                }
                return new ScrollParams(z, fValueOf);
            }
        });
    }

    /* JADX INFO: renamed from: scrollAway-eqLRuRQ, reason: not valid java name */
    public static final Modifier m778scrollAwayeqLRuRQ(Modifier modifier, final androidx.wear.compose.foundation.lazy.ScalingLazyListState scalingLazyListState, final int i, final float f) {
        return scrollAway(modifier, new Function1<Density, ScrollParams>() { // from class: androidx.wear.compose.material.ScrollAwayKt.scrollAway.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final ScrollParams invoke(Density density) {
                Float fValueOf;
                androidx.wear.compose.foundation.lazy.ScalingLazyListItemInfo scalingLazyListItemInfo;
                int i2 = 0;
                boolean z = i < scalingLazyListState.getLayoutInfo().getTotalItemsCount();
                List<androidx.wear.compose.foundation.lazy.ScalingLazyListItemInfo> visibleItemsInfo = scalingLazyListState.getLayoutInfo().getVisibleItemsInfo();
                int i3 = i;
                int size = visibleItemsInfo.size();
                while (true) {
                    fValueOf = null;
                    if (i2 >= size) {
                        scalingLazyListItemInfo = null;
                        break;
                    }
                    scalingLazyListItemInfo = visibleItemsInfo.get(i2);
                    if (scalingLazyListItemInfo.getIndex() == i3) {
                        break;
                    }
                    i2++;
                }
                androidx.wear.compose.foundation.lazy.ScalingLazyListItemInfo scalingLazyListItemInfo2 = scalingLazyListItemInfo;
                if (scalingLazyListItemInfo2 != null) {
                    fValueOf = Float.valueOf((-scalingLazyListItemInfo2.getOffset()) - density.toPx-0680j_4(f));
                }
                return new ScrollParams(z, fValueOf);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "This overload is provided for backwards compatibility with Compose for Wear OS 1.1.A newer overload is available which uses ScalingLazyListState from wear.compose.foundation.lazy package")
    /* JADX INFO: renamed from: scrollAway-eqLRuRQ, reason: not valid java name */
    public static final Modifier m779scrollAwayeqLRuRQ(Modifier modifier, final ScalingLazyListState scalingLazyListState, final int i, final float f) {
        return scrollAway(modifier, new Function1<Density, ScrollParams>() { // from class: androidx.wear.compose.material.ScrollAwayKt.scrollAway.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final ScrollParams invoke(Density density) {
                Float fValueOf;
                ScalingLazyListItemInfo scalingLazyListItemInfo;
                int i2 = 0;
                boolean z = i < scalingLazyListState.getLayoutInfo().getTotalItemsCount();
                List<ScalingLazyListItemInfo> visibleItemsInfo = scalingLazyListState.getLayoutInfo().getVisibleItemsInfo();
                int i3 = i;
                int size = visibleItemsInfo.size();
                while (true) {
                    fValueOf = null;
                    if (i2 >= size) {
                        scalingLazyListItemInfo = null;
                        break;
                    }
                    scalingLazyListItemInfo = visibleItemsInfo.get(i2);
                    if (scalingLazyListItemInfo.getIndex() == i3) {
                        break;
                    }
                    i2++;
                }
                ScalingLazyListItemInfo scalingLazyListItemInfo2 = scalingLazyListItemInfo;
                if (scalingLazyListItemInfo2 != null) {
                    fValueOf = Float.valueOf((-scalingLazyListItemInfo2.getOffset()) - density.toPx-0680j_4(f));
                }
                return new ScrollParams(z, fValueOf);
            }
        });
    }

    private static final Modifier scrollAway(Modifier modifier, final Function1<? super Density, ScrollParams> function1) {
        return modifier.then(new LayoutModifier() { // from class: androidx.wear.compose.material.ScrollAwayKt.scrollAway.5
            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
            public MeasureResult m785measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                final Placeable placeable = measurable.measure-BRTryo0(j);
                int width = placeable.getWidth();
                int height = placeable.getHeight();
                final Function1<Density, ScrollParams> function2 = function1;
                return MeasureScope.layout$default(measureScope, width, height, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.material.ScrollAwayKt$scrollAway$5$measure$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Placeable.PlacementScope placementScope) {
                        Placeable placeable2 = placeable;
                        final Function1<Density, ScrollParams> function3 = function2;
                        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable2, 0, 0, 0.0f, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.material.ScrollAwayKt$scrollAway$5$measure$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((GraphicsLayerScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                Pair pair;
                                ScrollParams scrollParams = (ScrollParams) function3.invoke(graphicsLayerScope);
                                boolean valid = scrollParams.getValid();
                                Float fValueOf = Float.valueOf(0.0f);
                                if (!valid) {
                                    pair = TuplesKt.to(Float.valueOf(1.0f), fValueOf);
                                } else if (scrollParams.getYPx() == null) {
                                    pair = TuplesKt.to(fValueOf, fValueOf);
                                } else {
                                    float fCoerceIn = RangesKt.coerceIn(scrollParams.getYPx().floatValue() / graphicsLayerScope.toPx-0680j_4(ScrollAwayKt.getMaxScrollOut()), 0.0f, 1.0f);
                                    pair = TuplesKt.to(Float.valueOf(MathHelpersKt.lerp(1.0f, 0.5f, fCoerceIn)), Float.valueOf(-(graphicsLayerScope.toPx-0680j_4(ScrollAwayKt.getMaxOffset()) * fCoerceIn)));
                                }
                                float fFloatValue = ((Number) pair.component1()).floatValue();
                                float fFloatValue2 = ((Number) pair.component2()).floatValue();
                                graphicsLayerScope.setAlpha(fFloatValue);
                                graphicsLayerScope.setScaleX(fFloatValue);
                                graphicsLayerScope.setScaleY(fFloatValue);
                                graphicsLayerScope.setTranslationY(fFloatValue2);
                                graphicsLayerScope.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, 0.0f));
                            }
                        }, 4, (Object) null);
                    }
                }, 4, (Object) null);
            }
        });
    }

    public static final float getMaxScrollOut() {
        return maxScrollOut;
    }

    public static final float getMaxOffset() {
        return maxOffset;
    }

    /* JADX INFO: renamed from: scrollAway-wH6b6FI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m784scrollAwaywH6b6FI$default(Modifier modifier, ScrollState scrollState, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.constructor-impl(0);
        }
        return m783scrollAwaywH6b6FI(modifier, scrollState, f);
    }

    /* JADX INFO: renamed from: scrollAway-eqLRuRQ$default, reason: not valid java name */
    public static /* synthetic */ Modifier m780scrollAwayeqLRuRQ$default(Modifier modifier, LazyListState lazyListState, int i, float f, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            f = Dp.constructor-impl(0);
        }
        return m777scrollAwayeqLRuRQ(modifier, lazyListState, i, f);
    }

    /* JADX INFO: renamed from: scrollAway-eqLRuRQ$default, reason: not valid java name */
    public static /* synthetic */ Modifier m781scrollAwayeqLRuRQ$default(Modifier modifier, androidx.wear.compose.foundation.lazy.ScalingLazyListState scalingLazyListState, int i, float f, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        if ((i2 & 4) != 0) {
            f = Dp.constructor-impl(0);
        }
        return m778scrollAwayeqLRuRQ(modifier, scalingLazyListState, i, f);
    }

    /* JADX INFO: renamed from: scrollAway-eqLRuRQ$default, reason: not valid java name */
    public static /* synthetic */ Modifier m782scrollAwayeqLRuRQ$default(Modifier modifier, ScalingLazyListState scalingLazyListState, int i, float f, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        if ((i2 & 4) != 0) {
            f = Dp.constructor-impl(0);
        }
        return m779scrollAwayeqLRuRQ(modifier, scalingLazyListState, i, f);
    }
}
