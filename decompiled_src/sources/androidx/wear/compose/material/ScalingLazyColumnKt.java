package androidx.wear.compose.material;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.recyclerview.widget.RecyclerView;
import androidx.wear.compose.foundation.lazy.CombinedPaddingValues;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.grpc.internal.GrpcUtil;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: ScalingLazyColumn.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u009b\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001aC\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\"¢\u0006\u0002\b\u001aH\u0003¢\u0006\u0002\u0010#\u001a\u001a\u0010$\u001a\u00020\u0003*\u00020\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0&H\u0002\u001a\u0082\u0001\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010(*\u00020\u00192\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H(0)2%\b\n\u0010*\u001a\u001f\u0012\u0013\u0012\u0011H(¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020.\u0018\u00010\u001823\b\u0004\u0010/\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u0011H(¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u000100¢\u0006\u0002\b\"¢\u0006\u0002\b\u001aH\u0087\b¢\u0006\u0002\u00101\u001a\u0082\u0001\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010(*\u00020\u00192\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H(022%\b\n\u0010*\u001a\u001f\u0012\u0013\u0012\u0011H(¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020.\u0018\u00010\u001823\b\u0004\u0010/\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u0011H(¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u000100¢\u0006\u0002\b\"¢\u0006\u0002\b\u001aH\u0087\b¢\u0006\u0002\u00103\u001a¬\u0001\u00104\u001a\u00020\u0001\"\u0004\b\u0000\u0010(*\u00020\u00192\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H(0)2:\b\n\u0010*\u001a4\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H(¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020.\u0018\u0001002H\b\u0004\u0010/\u001aB\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H(¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u000105¢\u0006\u0002\b\"¢\u0006\u0002\b\u001aH\u0087\b¢\u0006\u0002\u00106\u001a¬\u0001\u00104\u001a\u00020\u0001\"\u0004\b\u0000\u0010(*\u00020\u00192\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H(022:\b\n\u0010*\u001a4\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H(¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020.\u0018\u0001002H\b\u0004\u0010/\u001aB\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H(¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u000105¢\u0006\u0002\b\"¢\u0006\u0002\b\u001aH\u0087\b¢\u0006\u0002\u00107\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00068²\u0006\n\u00109\u001a\u00020\tX\u008a\u008e\u0002"}, d2 = {"ScalingLazyColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/wear/compose/material/ScalingLazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "scalingParams", "Landroidx/wear/compose/material/ScalingParams;", "anchorType", "Landroidx/wear/compose/material/ScalingLazyListAnchorType;", "autoCentering", "Landroidx/wear/compose/material/AutoCenteringParams;", "content", "Lkotlin/Function1;", "Landroidx/wear/compose/material/ScalingLazyListScope;", "Lkotlin/ExtensionFunctionType;", "ScalingLazyColumn-8g7MjcI", "(Landroidx/compose/ui/Modifier;Landroidx/wear/compose/material/ScalingLazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/wear/compose/material/ScalingParams;ILandroidx/wear/compose/material/AutoCenteringParams;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScalingLazyColumnItemWrapper", "index", "", "itemScope", "Landroidx/wear/compose/material/ScalingLazyListItemScope;", "Landroidx/compose/runtime/Composable;", "(ILandroidx/wear/compose/material/ScalingLazyListState;Landroidx/wear/compose/material/ScalingLazyListItemScope;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "autoCenteringHeight", "getHeight", "Lkotlin/Function0;", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "itemContent", "Lkotlin/Function2;", "(Landroidx/wear/compose/material/ScalingLazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/wear/compose/material/ScalingLazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "Lkotlin/Function3;", "(Landroidx/wear/compose/material/ScalingLazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/wear/compose/material/ScalingLazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "compose-material_release", "initialized"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScalingLazyColumnKt {

    /* JADX INFO: renamed from: androidx.wear.compose.material.ScalingLazyColumnKt$items$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScalingLazyColumn.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class C01321 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C01321(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
            super(1);
            this.$key = function1;
            this.$items = list;
        }

        public final Object invoke(int i) {
            return this.$key.invoke(this.$items.get(i));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.wear.compose.material.ScalingLazyColumnKt$items$2, reason: invalid class name */
    /* JADX INFO: compiled from: ScalingLazyColumn.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Landroidx/wear/compose/material/ScalingLazyListItemScope;", "it", "", "invoke", "(Landroidx/wear/compose/material/ScalingLazyListItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass2 extends Lambda implements Function4<ScalingLazyListItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<ScalingLazyListItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function4<? super ScalingLazyListItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, List<? extends T> list) {
            super(4);
            this.$itemContent = function4;
            this.$items = list;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((ScalingLazyListItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ScalingLazyListItemScope scalingLazyListItemScope, int i, Composer composer, int i2) {
            int i3;
            ComposerKt.sourceInformation(composer, "C119@5482L22:ScalingLazyColumn.kt#gj9v0t");
            if ((i2 & 6) == 0) {
                i3 = (composer.changed(scalingLazyListItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if ((i3 & 147) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1890007392, i3, -1, "androidx.wear.compose.material.items.<anonymous> (ScalingLazyColumn.kt:119)");
            }
            this.$itemContent.invoke(scalingLazyListItemScope, this.$items.get(i), composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    @Deprecated(message = "Was moved to androidx.wear.compose.foundation.lazy package. Please use it instead")
    public static final <T> void items(ScalingLazyListScope scalingLazyListScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function4<? super ScalingLazyListItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        scalingLazyListScope.items(list.size(), function1 != null ? new C01321(function1, list) : null, (Function4) ComposableLambdaKt.composableLambdaInstance(-1890007392, true, new AnonymousClass2(function4, list)));
    }

    public static /* synthetic */ void items$default(ScalingLazyListScope scalingLazyListScope, List list, Function1 function1, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        scalingLazyListScope.items(list.size(), function1 != null ? new C01321(function1, list) : null, (Function4) ComposableLambdaKt.composableLambdaInstance(-1890007392, true, new AnonymousClass2(function4, list)));
    }

    /* JADX INFO: renamed from: androidx.wear.compose.material.ScalingLazyColumnKt$itemsIndexed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScalingLazyColumn.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class C01341 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C01341(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
            super(1);
            this.$key = function2;
            this.$items = list;
        }

        public final Object invoke(int i) {
            return this.$key.invoke(Integer.valueOf(i), this.$items.get(i));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.wear.compose.material.ScalingLazyColumnKt$itemsIndexed$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScalingLazyColumn.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Landroidx/wear/compose/material/ScalingLazyListItemScope;", "it", "", "invoke", "(Landroidx/wear/compose/material/ScalingLazyListItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class C01352 extends Lambda implements Function4<ScalingLazyListItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<ScalingLazyListItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C01352(Function5<? super ScalingLazyListItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, List<? extends T> list) {
            super(4);
            this.$itemContent = function5;
            this.$items = list;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((ScalingLazyListItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ScalingLazyListItemScope scalingLazyListItemScope, int i, Composer composer, int i2) {
            int i3;
            ComposerKt.sourceInformation(composer, "C141@6611L26:ScalingLazyColumn.kt#gj9v0t");
            if ((i2 & 6) == 0) {
                i3 = (composer.changed(scalingLazyListItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if ((i3 & 147) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-140463997, i3, -1, "androidx.wear.compose.material.itemsIndexed.<anonymous> (ScalingLazyColumn.kt:141)");
            }
            this.$itemContent.invoke(scalingLazyListItemScope, Integer.valueOf(i), this.$items.get(i), composer, Integer.valueOf(i3 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    @Deprecated(message = "Was moved to androidx.wear.compose.foundation.lazy package. Please use it instead")
    public static final <T> void itemsIndexed(ScalingLazyListScope scalingLazyListScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function5<? super ScalingLazyListItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        scalingLazyListScope.items(list.size(), function2 != null ? new C01341(function2, list) : null, (Function4) ComposableLambdaKt.composableLambdaInstance(-140463997, true, new C01352(function5, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(ScalingLazyListScope scalingLazyListScope, List list, Function2 function2, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        scalingLazyListScope.items(list.size(), function2 != null ? new C01341(function2, list) : null, (Function4) ComposableLambdaKt.composableLambdaInstance(-140463997, true, new C01352(function5, list)));
    }

    /* JADX INFO: renamed from: androidx.wear.compose.material.ScalingLazyColumnKt$items$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScalingLazyColumn.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class C01333 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C01333(Function1<? super T, ? extends Object> function1, T[] tArr) {
            super(1);
            this.$key = function1;
            this.$items = tArr;
        }

        public final Object invoke(int i) {
            return this.$key.invoke(this.$items[i]);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.wear.compose.material.ScalingLazyColumnKt$items$4, reason: invalid class name */
    /* JADX INFO: compiled from: ScalingLazyColumn.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Landroidx/wear/compose/material/ScalingLazyListItemScope;", "it", "", "invoke", "(Landroidx/wear/compose/material/ScalingLazyListItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass4 extends Lambda implements Function4<ScalingLazyListItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<ScalingLazyListItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(Function4<? super ScalingLazyListItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, T[] tArr) {
            super(4);
            this.$itemContent = function4;
            this.$items = tArr;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((ScalingLazyListItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ScalingLazyListItemScope scalingLazyListItemScope, int i, Composer composer, int i2) {
            int i3;
            ComposerKt.sourceInformation(composer, "C163@7659L22:ScalingLazyColumn.kt#gj9v0t");
            if ((i2 & 6) == 0) {
                i3 = (composer.changed(scalingLazyListItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if ((i3 & 147) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1106665379, i3, -1, "androidx.wear.compose.material.items.<anonymous> (ScalingLazyColumn.kt:163)");
            }
            this.$itemContent.invoke(scalingLazyListItemScope, this.$items[i], composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    @Deprecated(message = "Was moved to androidx.wear.compose.foundation.lazy package. Please use it instead")
    public static final <T> void items(ScalingLazyListScope scalingLazyListScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function4<? super ScalingLazyListItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        scalingLazyListScope.items(tArr.length, function1 != null ? new C01333(function1, tArr) : null, (Function4) ComposableLambdaKt.composableLambdaInstance(-1106665379, true, new AnonymousClass4(function4, tArr)));
    }

    public static /* synthetic */ void items$default(ScalingLazyListScope scalingLazyListScope, Object[] objArr, Function1 function1, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        scalingLazyListScope.items(objArr.length, function1 != null ? new C01333(function1, objArr) : null, (Function4) ComposableLambdaKt.composableLambdaInstance(-1106665379, true, new AnonymousClass4(function4, objArr)));
    }

    /* JADX INFO: renamed from: androidx.wear.compose.material.ScalingLazyColumnKt$itemsIndexed$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScalingLazyColumn.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class C01363 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C01363(Function2<? super Integer, ? super T, ? extends Object> function2, T[] tArr) {
            super(1);
            this.$key = function2;
            this.$items = tArr;
        }

        public final Object invoke(int i) {
            return this.$key.invoke(Integer.valueOf(i), this.$items[i]);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.wear.compose.material.ScalingLazyColumnKt$itemsIndexed$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScalingLazyColumn.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Landroidx/wear/compose/material/ScalingLazyListItemScope;", "it", "", "invoke", "(Landroidx/wear/compose/material/ScalingLazyListItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class C01374 extends Lambda implements Function4<ScalingLazyListItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<ScalingLazyListItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C01374(Function5<? super ScalingLazyListItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, T[] tArr) {
            super(4);
            this.$itemContent = function5;
            this.$items = tArr;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((ScalingLazyListItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ScalingLazyListItemScope scalingLazyListItemScope, int i, Composer composer, int i2) {
            int i3;
            ComposerKt.sourceInformation(composer, "C185@8799L26:ScalingLazyColumn.kt#gj9v0t");
            if ((i2 & 6) == 0) {
                i3 = (composer.changed(scalingLazyListItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if ((i3 & 147) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2048942306, i3, -1, "androidx.wear.compose.material.itemsIndexed.<anonymous> (ScalingLazyColumn.kt:185)");
            }
            this.$itemContent.invoke(scalingLazyListItemScope, Integer.valueOf(i), this.$items[i], composer, Integer.valueOf(i3 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    @Deprecated(message = "Was moved to androidx.wear.compose.foundation.lazy package. Please use it instead")
    public static final <T> void itemsIndexed(ScalingLazyListScope scalingLazyListScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function5<? super ScalingLazyListItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        scalingLazyListScope.items(tArr.length, function2 != null ? new C01363(function2, tArr) : null, (Function4) ComposableLambdaKt.composableLambdaInstance(-2048942306, true, new C01374(function5, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(ScalingLazyListScope scalingLazyListScope, Object[] objArr, Function2 function2, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        scalingLazyListScope.items(objArr.length, function2 != null ? new C01363(function2, objArr) : null, (Function4) ComposableLambdaKt.composableLambdaInstance(-2048942306, true, new C01374(function5, objArr)));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x011c  */
    /* JADX WARN: Code duplicated, block: B:101:0x011f  */
    /* JADX WARN: Code duplicated, block: B:103:0x0123  */
    /* JADX WARN: Code duplicated, block: B:105:0x012d  */
    /* JADX WARN: Code duplicated, block: B:106:0x0130  */
    /* JADX WARN: Code duplicated, block: B:111:0x013d  */
    /* JADX WARN: Code duplicated, block: B:112:0x0146  */
    /* JADX WARN: Code duplicated, block: B:114:0x014a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0154  */
    /* JADX WARN: Code duplicated, block: B:117:0x0157  */
    /* JADX WARN: Code duplicated, block: B:119:0x015c  */
    /* JADX WARN: Code duplicated, block: B:122:0x0166  */
    /* JADX WARN: Code duplicated, block: B:123:0x0169  */
    /* JADX WARN: Code duplicated, block: B:125:0x016d  */
    /* JADX WARN: Code duplicated, block: B:127:0x0175  */
    /* JADX WARN: Code duplicated, block: B:128:0x0178  */
    /* JADX WARN: Code duplicated, block: B:130:0x017d  */
    /* JADX WARN: Code duplicated, block: B:133:0x018f  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:158:0x01f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:159:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:160:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:163:0x0205  */
    /* JADX WARN: Code duplicated, block: B:165:0x020e  */
    /* JADX WARN: Code duplicated, block: B:166:0x021d  */
    /* JADX WARN: Code duplicated, block: B:168:0x0220  */
    /* JADX WARN: Code duplicated, block: B:171:0x0225  */
    /* JADX WARN: Code duplicated, block: B:173:0x0231  */
    /* JADX WARN: Code duplicated, block: B:174:0x0236  */
    /* JADX WARN: Code duplicated, block: B:176:0x0243  */
    /* JADX WARN: Code duplicated, block: B:178:0x0246  */
    /* JADX WARN: Code duplicated, block: B:179:0x024d  */
    /* JADX WARN: Code duplicated, block: B:182:0x0252  */
    /* JADX WARN: Code duplicated, block: B:183:0x025f  */
    /* JADX WARN: Code duplicated, block: B:185:0x0263  */
    /* JADX WARN: Code duplicated, block: B:188:0x0268  */
    /* JADX WARN: Code duplicated, block: B:189:0x0287  */
    /* JADX WARN: Code duplicated, block: B:191:0x028b  */
    /* JADX WARN: Code duplicated, block: B:192:0x0292  */
    /* JADX WARN: Code duplicated, block: B:194:0x0296  */
    /* JADX WARN: Code duplicated, block: B:195:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:198:0x02db  */
    /* JADX WARN: Code duplicated, block: B:201:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:204:0x0342  */
    /* JADX WARN: Code duplicated, block: B:208:0x0361  */
    /* JADX WARN: Code duplicated, block: B:210:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:38:0x006e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:43:0x007d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:82:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:91:0x0102  */
    /* JADX WARN: Code duplicated, block: B:94:0x010d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:97:0x0114  */
    @Deprecated(message = "Was moved to androidx.wear.compose.foundation.lazy package. Please use it instead")
    /* JADX INFO: renamed from: ScalingLazyColumn-8g7MjcI, reason: not valid java name */
    public static final void m751ScalingLazyColumn8g7MjcI(Modifier modifier, ScalingLazyListState scalingLazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, ScalingParams scalingParams, int i, AutoCenteringParams autoCenteringParams, final Function1<? super ScalingLazyListScope, Unit> function1, Composer composer, final int i2, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        ScalingLazyListState scalingLazyListStateRememberScalingLazyListState;
        PaddingValues paddingValues2;
        int i6;
        boolean z3;
        int i7;
        Arrangement.Vertical vertical2;
        int i8;
        Alignment.Horizontal horizontal2;
        int i9;
        int i10;
        boolean z4;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Modifier modifier3;
        PaddingValues paddingValues3;
        Arrangement.Vertical vertical3;
        Alignment.Horizontal centerHorizontally;
        FlingBehavior flingBehavior2;
        ScalingParams scalingParamsScalingParams$default;
        int iM766getItemCenterhvgbs18;
        Modifier modifier4;
        final Arrangement.Vertical vertical4;
        final boolean z5;
        final AutoCenteringParams autoCenteringParams2;
        final PaddingValues paddingValues4;
        final ScalingLazyListState scalingLazyListState2;
        final Alignment.Horizontal horizontal3;
        final FlingBehavior flingBehavior3;
        final ScalingParams scalingParams2;
        final int i19;
        Alignment.Companion companion;
        Alignment.Vertical bottom;
        Object objRememberedValue;
        Composer composer2;
        final Modifier modifier5;
        final ScalingParams scalingParams3;
        final PaddingValues paddingValues5;
        final boolean z6;
        final ScalingLazyListState scalingLazyListState3;
        final Arrangement.Vertical vertical5;
        final int i20;
        final AutoCenteringParams autoCenteringParams3;
        final Alignment.Horizontal horizontal4;
        final FlingBehavior flingBehavior4;
        final boolean z7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i21;
        Composer composerStartRestartGroup = composer.startRestartGroup(741207601);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScalingLazyColumn)P(6,9,3,7,11,5,4,10,8,0:androidx.wear.compose.material.ScalingLazyListAnchorType)342@17077L30,351@17543L15,358@17896L34,359@18007L4570,359@17935L4642:ScalingLazyColumn.kt#gj9v0t");
        int i22 = i4 & 1;
        if (i22 != 0) {
            i5 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            if ((i4 & 2) == 0) {
                scalingLazyListStateRememberScalingLazyListState = scalingLazyListState;
                int i23 = composerStartRestartGroup.changed(scalingLazyListStateRememberScalingLazyListState) ? 32 : 16;
                i5 |= i23;
            } else {
                scalingLazyListStateRememberScalingLazyListState = scalingLazyListState;
            }
            i5 |= i23;
        } else {
            scalingLazyListStateRememberScalingLazyListState = scalingLazyListState;
        }
        int i24 = i4 & 4;
        if (i24 == 0) {
            if ((i2 & 384) == 0) {
                paddingValues2 = paddingValues;
                i5 |= composerStartRestartGroup.changed(paddingValues2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 != 0) {
                if ((i2 & 3072) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i5 |= i7;
                }
                if ((i2 & 24576) == 0) {
                    if ((i4 & 16) == 0) {
                        vertical2 = vertical;
                        int i25 = composerStartRestartGroup.changed(vertical2) ? 16384 : 8192;
                        i5 |= i25;
                    } else {
                        vertical2 = vertical;
                    }
                    i5 |= i25;
                } else {
                    vertical2 = vertical;
                }
                i8 = i4 & 32;
                if (i8 != 0) {
                    i5 |= 196608;
                    horizontal2 = horizontal;
                } else {
                    horizontal2 = horizontal;
                    if ((i2 & 196608) == 0) {
                        if (composerStartRestartGroup.changed(horizontal2)) {
                            i9 = 131072;
                        } else {
                            i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i5 |= i9;
                    }
                }
                if ((i2 & 1572864) != 0) {
                    if ((i4 & 64) == 0 || !composerStartRestartGroup.changed(flingBehavior)) {
                        i21 = 524288;
                    } else {
                        i21 = 1048576;
                    }
                    i5 |= i21;
                }
                i10 = i4 & 128;
                if (i10 != 0) {
                    i5 |= 12582912;
                    z4 = z2;
                } else {
                    z4 = z2;
                    if ((i2 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(z4)) {
                            i11 = 8388608;
                        } else {
                            i11 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        }
                        i5 |= i11;
                    }
                }
                if ((i2 & 100663296) != 0) {
                    i5 |= ((i4 & 256) == 0 || !composerStartRestartGroup.changed(scalingParams)) ? 33554432 : 67108864;
                }
                i12 = i4 & 512;
                if (i12 != 0) {
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(i)) {
                            i13 = 536870912;
                        } else {
                            i13 = 268435456;
                        }
                        i5 |= i13;
                    }
                    i14 = i4 & UserMetadata.MAX_ATTRIBUTE_SIZE;
                    if (i14 != 0) {
                        i15 = i3 | 6;
                    } else if ((i3 & 6) == 0) {
                        if (composerStartRestartGroup.changed(autoCenteringParams)) {
                            i16 = 4;
                        } else {
                            i16 = 2;
                        }
                        i15 = i3 | i16;
                    } else {
                        i15 = i3;
                    }
                    if ((i4 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        i15 |= 48;
                    } else if ((i3 & 48) != 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i17 = 32;
                        } else {
                            i17 = 16;
                        }
                        i15 |= i17;
                    }
                    i18 = i15;
                    if ((i5 & 306783379) == 306783378 || (i18 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i22 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i4 & 2) != 0) {
                                scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i5 &= -113;
                            }
                            if (i24 != 0) {
                                paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                            } else {
                                paddingValues3 = paddingValues2;
                            }
                            if (i6 != 0) {
                                z3 = false;
                            }
                            if ((i4 & 16) != 0) {
                                Arrangement arrangement = Arrangement.INSTANCE;
                                float f = Dp.constructor-impl(4);
                                companion = Alignment.Companion;
                                if (z3) {
                                    bottom = companion.getBottom();
                                } else {
                                    bottom = companion.getTop();
                                }
                                vertical3 = arrangement.spacedBy-D5KLDUw(f, bottom);
                                i5 &= -57345;
                            } else {
                                vertical3 = vertical2;
                            }
                            if (i8 != 0) {
                                centerHorizontally = Alignment.Companion.getCenterHorizontally();
                            } else {
                                centerHorizontally = horizontal2;
                            }
                            if ((i4 & 64) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                                i5 &= -3670017;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z4 = true;
                            }
                            if ((i4 & 256) != 0) {
                                scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                                i5 &= -234881025;
                            } else {
                                scalingParamsScalingParams$default = scalingParams;
                            }
                            if (i12 != 0) {
                                iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                            } else {
                                iM766getItemCenterhvgbs18 = i;
                            }
                            if (i14 != 0) {
                                modifier4 = modifier3;
                                vertical4 = vertical3;
                                z5 = z4;
                                paddingValues4 = paddingValues3;
                                scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                                horizontal3 = centerHorizontally;
                                flingBehavior3 = flingBehavior2;
                                scalingParams2 = scalingParamsScalingParams$default;
                                i19 = iM766getItemCenterhvgbs18;
                                autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                            } else {
                                modifier4 = modifier3;
                                vertical4 = vertical3;
                                z5 = z4;
                                autoCenteringParams2 = autoCenteringParams;
                                paddingValues4 = paddingValues3;
                                scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                                horizontal3 = centerHorizontally;
                                flingBehavior3 = flingBehavior2;
                                scalingParams2 = scalingParamsScalingParams$default;
                                i19 = iM766getItemCenterhvgbs18;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 2) != 0) {
                                i5 &= -113;
                            }
                            if ((i4 & 16) != 0) {
                                i5 &= -57345;
                            }
                            if ((i4 & 64) != 0) {
                                i5 &= -3670017;
                            }
                            if ((i4 & 256) != 0) {
                                i5 &= -234881025;
                            }
                            flingBehavior3 = flingBehavior;
                            scalingParams2 = scalingParams;
                            i19 = i;
                            autoCenteringParams2 = autoCenteringParams;
                            z5 = z4;
                            modifier4 = modifier2;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            vertical4 = vertical2;
                            horizontal3 = horizontal2;
                            paddingValues4 = paddingValues2;
                        }
                        final boolean z8 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(741207601, i5, i18, "androidx.wear.compose.material.ScalingLazyColumn (ScalingLazyColumn.kt:357)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1150553998, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        final MutableState mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, true, ComposableLambdaKt.rememberComposableLambda(-334395385, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i26) {
                                BoxWithConstraintsScope boxWithConstraintsScope2;
                                int i27;
                                int i28;
                                int i29;
                                final MutableState<Boolean> mutableState2;
                                Object obj;
                                ComposerKt.sourceInformation(composer3, "C360@18044L7,361@18103L7,*405@20227L7,411@20433L365,427@21182L1228,407@20248L2162:ScalingLazyColumn.kt#gj9v0t");
                                if ((i26 & 6) == 0) {
                                    boxWithConstraintsScope2 = boxWithConstraintsScope;
                                    i27 = i26 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                                } else {
                                    boxWithConstraintsScope2 = boxWithConstraintsScope;
                                    i27 = i26;
                                }
                                if ((i27 & 19) != 18 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-334395385, i27, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous> (ScalingLazyColumn.kt:360)");
                                    }
                                    CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object objConsume = composer3.consume(localDensity);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Density density = (Density) objConsume;
                                    CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composer3.consume(localLayoutDirection);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                    int iMo586resolveViewportVerticalOffsetBRTryo0 = scalingParams2.mo586resolveViewportVerticalOffsetBRTryo0(boxWithConstraintsScope2.getConstraints-msEJaDk());
                                    PaddingValues paddingValues6 = paddingValues4;
                                    boolean z9 = z8;
                                    final ScalingLazyListState scalingLazyListState4 = scalingLazyListState2;
                                    ScalingParams scalingParams4 = scalingParams2;
                                    Arrangement.Vertical vertical6 = vertical4;
                                    int i30 = i19;
                                    final AutoCenteringParams autoCenteringParams4 = autoCenteringParams2;
                                    Alignment.Horizontal horizontal5 = horizontal3;
                                    FlingBehavior flingBehavior5 = flingBehavior3;
                                    boolean z10 = z5;
                                    final Function1<ScalingLazyListScope, Unit> function2 = function1;
                                    MutableState<Boolean> mutableState3 = mutableState;
                                    float f2 = density.toDp-u2uoSUM(iMo586resolveViewportVerticalOffsetBRTryo0);
                                    CombinedPaddingValues combinedPaddingValues = new CombinedPaddingValues(paddingValues6, f2, null);
                                    if (z9) {
                                        i28 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                                    } else {
                                        i28 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                                    }
                                    if (z9) {
                                        i29 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                                    } else {
                                        i29 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                                    }
                                    int i31 = i29;
                                    final ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl = new ScalingLazyListItemScopeImpl(density, ConstraintsKt.offset-NN6Ew-U(boxWithConstraintsScope.getConstraints-msEJaDk(), -((int) density.toPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues6, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues6, layoutDirection)))), -density.roundToPx-0680j_4(Dp.constructor-impl(paddingValues6.calculateTopPadding-D9Ej5fM() + paddingValues6.calculateBottomPadding-D9Ej5fM()))), null);
                                    scalingLazyListState4.getScalingParams$compose_material_release().setValue(scalingParams4);
                                    scalingLazyListState4.getExtraPaddingPx$compose_material_release().setValue(Integer.valueOf(iMo586resolveViewportVerticalOffsetBRTryo0));
                                    scalingLazyListState4.getBeforeContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i28));
                                    scalingLazyListState4.getAfterContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i31));
                                    scalingLazyListState4.getViewportHeightPx$compose_material_release().setValue(Integer.valueOf(Constraints.getMaxHeight-impl(boxWithConstraintsScope.getConstraints-msEJaDk())));
                                    scalingLazyListState4.getGapBetweenItemsPx$compose_material_release().setValue(Integer.valueOf(density.roundToPx-0680j_4(vertical6.getSpacing-D9Ej5fM())));
                                    scalingLazyListState4.getAnchorType$compose_material_release().setValue(ScalingLazyListAnchorType.m759boximpl(i30));
                                    scalingLazyListState4.getAutoCentering$compose_material_release().setValue(autoCenteringParams4);
                                    scalingLazyListState4.getReverseLayout$compose_material_release().setValue(Boolean.valueOf(z9));
                                    MutableState<Boolean> localInspectionMode$compose_material_release = scalingLazyListState4.getLocalInspectionMode$compose_material_release();
                                    CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object objConsume3 = composer3.consume(localInspectionMode);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    localInspectionMode$compose_material_release.setValue(objConsume3);
                                    Modifier modifierM453verticalNegativePadding3ABfNKs = androidx.wear.compose.foundation.lazy.ScalingLazyColumnKt.m453verticalNegativePadding3ABfNKs(ClipKt.clipToBounds(Modifier.Companion), f2);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -2141668261, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                    boolean zChanged = composer3.changed(scalingLazyListState4);
                                    Object objRememberedValue2 = composer3.rememberedValue();
                                    if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                        mutableState2 = mutableState3;
                                        obj = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                                invoke((LayoutCoordinates) obj2);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(LayoutCoordinates layoutCoordinates) {
                                                ScalingLazyListLayoutInfo layoutInfo = scalingLazyListState4.getLayoutInfo();
                                                if (!ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState2) && (layoutInfo instanceof DefaultScalingLazyListLayoutInfo) && ((DefaultScalingLazyListLayoutInfo) layoutInfo).getReadyForInitialScroll()) {
                                                    ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$2(mutableState2, true);
                                                }
                                            }
                                        };
                                        composer3.updateRememberedValue(obj);
                                    } else {
                                        obj = objRememberedValue2;
                                        mutableState2 = mutableState3;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM453verticalNegativePadding3ABfNKs, (Function1) obj);
                                    LazyListState lazyListState = scalingLazyListState4.getLazyListState();
                                    CombinedPaddingValues combinedPaddingValues2 = combinedPaddingValues;
                                    ComposerKt.sourceInformationMarkerStart(composer3, -2141643430, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                    boolean zChanged2 = composer3.changed(scalingLazyListState4) | composer3.changed(scalingLazyListItemScopeImpl) | composer3.changed(autoCenteringParams4) | composer3.changed(function2);
                                    Object objRememberedValue3 = composer3.rememberedValue();
                                    if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                        objRememberedValue3 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                                invoke((LazyListScope) obj2);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(LazyListScope lazyListScope) {
                                                ScalingLazyListScopeImpl scalingLazyListScopeImpl = new ScalingLazyListScopeImpl(scalingLazyListState4, lazyListScope, scalingLazyListItemScopeImpl);
                                                if (autoCenteringParams4 != null) {
                                                    final ScalingLazyListState scalingLazyListState5 = scalingLazyListState4;
                                                    LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1989951676, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.1
                                                        {
                                                            super(3);
                                                        }

                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                            invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                            ComposerKt.sourceInformation(composer4, "C438@21659L213,437@21612L286:ScalingLazyColumn.kt#gj9v0t");
                                                            if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-1989951676, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:437)");
                                                                }
                                                                ComposerKt.sourceInformationMarkerStart(composer4, 454359168, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                                boolean zChanged3 = composer4.changed(scalingLazyListState5);
                                                                final ScalingLazyListState scalingLazyListState6 = scalingLazyListState5;
                                                                Object objRememberedValue4 = composer4.rememberedValue();
                                                                if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                                    objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$1$1$1
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                        public final Integer m752invoke() {
                                                                            return Integer.valueOf(scalingLazyListState6.getTopAutoCenteringItemSizePx$compose_material_release());
                                                                        }
                                                                    });
                                                                    composer4.updateRememberedValue(objRememberedValue4);
                                                                }
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }), 3, (Object) null);
                                                }
                                                function2.invoke(scalingLazyListScopeImpl);
                                                if (autoCenteringParams4 != null) {
                                                    final ScalingLazyListState scalingLazyListState6 = scalingLazyListState4;
                                                    LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1331448389, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.2
                                                        {
                                                            super(3);
                                                        }

                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                            invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                            ComposerKt.sourceInformation(composer4, "C450@22114L216,449@22067L289:ScalingLazyColumn.kt#gj9v0t");
                                                            if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-1331448389, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:449)");
                                                                }
                                                                ComposerKt.sourceInformationMarkerStart(composer4, 454373731, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                                boolean zChanged3 = composer4.changed(scalingLazyListState6);
                                                                final ScalingLazyListState scalingLazyListState7 = scalingLazyListState6;
                                                                Object objRememberedValue4 = composer4.rememberedValue();
                                                                if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                                    objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$2$1$1
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                        public final Integer m753invoke() {
                                                                            return Integer.valueOf(scalingLazyListState7.getBottomAutoCenteringItemSizePx$compose_material_release());
                                                                        }
                                                                    });
                                                                    composer4.updateRememberedValue(objRememberedValue4);
                                                                }
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }), 3, (Object) null);
                                                }
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue3);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    LazyDslKt.LazyColumn(modifierOnGloballyPositioned, lazyListState, combinedPaddingValues2, z9, vertical6, horizontal5, flingBehavior5, z10, (Function1) objRememberedValue3, composer3, 0, 0);
                                    composer3.startReplaceGroup(-938151751);
                                    ComposerKt.sourceInformation(composer3, "460@22480L67,460@22458L89");
                                    if (ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState2)) {
                                        ComposerKt.sourceInformationMarkerStart(composer3, -2141603055, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                        boolean zChanged3 = composer3.changed(scalingLazyListState4);
                                        ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1 scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = composer3.rememberedValue();
                                        if (zChanged3 || scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue == Composer.Companion.getEmpty()) {
                                            scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = new ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1(scalingLazyListState4, null);
                                            composer3.updateRememberedValue(scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        EffectsKt.LaunchedEffect(scalingLazyListState4, (Function2) scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue, composer3, 0);
                                    }
                                    composer3.endReplaceGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 3456, 2);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        scalingParams3 = scalingParams2;
                        paddingValues5 = paddingValues4;
                        z6 = z8;
                        scalingLazyListState3 = scalingLazyListState2;
                        vertical5 = vertical4;
                        i20 = i19;
                        autoCenteringParams3 = autoCenteringParams2;
                        horizontal4 = horizontal3;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        i20 = i;
                        composer2 = composerStartRestartGroup;
                        modifier5 = modifier2;
                        scalingLazyListState3 = scalingLazyListStateRememberScalingLazyListState;
                        vertical5 = vertical2;
                        horizontal4 = horizontal2;
                        paddingValues5 = paddingValues2;
                        flingBehavior4 = flingBehavior;
                        scalingParams3 = scalingParams;
                        autoCenteringParams3 = autoCenteringParams;
                        z7 = z4;
                        z6 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i26) {
                                ScalingLazyColumnKt.m751ScalingLazyColumn8g7MjcI(modifier5, scalingLazyListState3, paddingValues5, z6, vertical5, horizontal4, flingBehavior4, z7, scalingParams3, i20, autoCenteringParams3, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                            }
                        });
                    }
                }
                i5 |= 805306368;
                i14 = i4 & UserMetadata.MAX_ATTRIBUTE_SIZE;
                if (i14 != 0) {
                    i15 = i3 | 6;
                } else if ((i3 & 6) == 0) {
                    if (composerStartRestartGroup.changed(autoCenteringParams)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i3 | i16;
                } else {
                    i15 = i3;
                }
                if ((i4 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                    i15 |= 48;
                } else if ((i3 & 48) != 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i17 = 32;
                    } else {
                        i17 = 16;
                    }
                    i15 |= i17;
                }
                i18 = i15;
                if ((i5 & 306783379) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i22 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i4 & 2) != 0) {
                            scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        }
                        if (i24 != 0) {
                            paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                        } else {
                            paddingValues3 = paddingValues2;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if ((i4 & 16) != 0) {
                            Arrangement arrangement2 = Arrangement.INSTANCE;
                            float f2 = Dp.constructor-impl(4);
                            companion = Alignment.Companion;
                            if (z3) {
                                bottom = companion.getTop();
                            } else {
                                bottom = companion.getBottom();
                            }
                            vertical3 = arrangement2.spacedBy-D5KLDUw(f2, bottom);
                            i5 &= -57345;
                        } else {
                            vertical3 = vertical2;
                        }
                        if (i8 != 0) {
                            centerHorizontally = Alignment.Companion.getCenterHorizontally();
                        } else {
                            centerHorizontally = horizontal2;
                        }
                        if ((i4 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                            i5 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        }
                        if ((i4 & 256) != 0) {
                            scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                            i5 &= -234881025;
                        } else {
                            scalingParamsScalingParams$default = scalingParams;
                        }
                        if (i12 != 0) {
                            iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                        } else {
                            iM766getItemCenterhvgbs18 = i;
                        }
                        if (i14 != 0) {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                            autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                        } else {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            autoCenteringParams2 = autoCenteringParams;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                        }
                    } else {
                        if (i22 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i4 & 2) != 0) {
                            scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        }
                        if (i24 != 0) {
                            paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                        } else {
                            paddingValues3 = paddingValues2;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if ((i4 & 16) != 0) {
                            Arrangement arrangement3 = Arrangement.INSTANCE;
                            float f3 = Dp.constructor-impl(4);
                            companion = Alignment.Companion;
                            if (z3) {
                                bottom = companion.getTop();
                            } else {
                                bottom = companion.getBottom();
                            }
                            vertical3 = arrangement3.spacedBy-D5KLDUw(f3, bottom);
                            i5 &= -57345;
                        } else {
                            vertical3 = vertical2;
                        }
                        if (i8 != 0) {
                            centerHorizontally = Alignment.Companion.getCenterHorizontally();
                        } else {
                            centerHorizontally = horizontal2;
                        }
                        if ((i4 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                            i5 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        }
                        if ((i4 & 256) != 0) {
                            scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                            i5 &= -234881025;
                        } else {
                            scalingParamsScalingParams$default = scalingParams;
                        }
                        if (i12 != 0) {
                            iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                        } else {
                            iM766getItemCenterhvgbs18 = i;
                        }
                        if (i14 != 0) {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                            autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                        } else {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            autoCenteringParams2 = autoCenteringParams;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                        }
                    }
                    final boolean z9 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(741207601, i5, i18, "androidx.wear.compose.material.ScalingLazyColumn (ScalingLazyColumn.kt:357)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1150553998, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final MutableState<Boolean> mutableState2 = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, true, ComposableLambdaKt.rememberComposableLambda(-334395385, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i26) {
                            BoxWithConstraintsScope boxWithConstraintsScope2;
                            int i27;
                            int i28;
                            int i29;
                            final MutableState<Boolean> mutableState3;
                            Object obj;
                            ComposerKt.sourceInformation(composer3, "C360@18044L7,361@18103L7,*405@20227L7,411@20433L365,427@21182L1228,407@20248L2162:ScalingLazyColumn.kt#gj9v0t");
                            if ((i26 & 6) == 0) {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i27 = i26 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                            } else {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i27 = i26;
                            }
                            if ((i27 & 19) != 18 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-334395385, i27, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous> (ScalingLazyColumn.kt:360)");
                                }
                                CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume = composer3.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Density density = (Density) objConsume;
                                CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composer3.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                int iMo586resolveViewportVerticalOffsetBRTryo0 = scalingParams2.mo586resolveViewportVerticalOffsetBRTryo0(boxWithConstraintsScope2.getConstraints-msEJaDk());
                                PaddingValues paddingValues6 = paddingValues4;
                                boolean z10 = z9;
                                final ScalingLazyListState scalingLazyListState4 = scalingLazyListState2;
                                ScalingParams scalingParams4 = scalingParams2;
                                Arrangement.Vertical vertical6 = vertical4;
                                int i30 = i19;
                                final AutoCenteringParams autoCenteringParams4 = autoCenteringParams2;
                                Alignment.Horizontal horizontal5 = horizontal3;
                                FlingBehavior flingBehavior5 = flingBehavior3;
                                boolean z11 = z5;
                                final Function1<? super ScalingLazyListScope, Unit> function2 = function1;
                                MutableState<Boolean> mutableState4 = mutableState2;
                                float f4 = density.toDp-u2uoSUM(iMo586resolveViewportVerticalOffsetBRTryo0);
                                CombinedPaddingValues combinedPaddingValues = new CombinedPaddingValues(paddingValues6, f4, null);
                                if (z10) {
                                    i28 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                                } else {
                                    i28 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                                }
                                if (z10) {
                                    i29 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                                } else {
                                    i29 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                                }
                                int i31 = i29;
                                final ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl = new ScalingLazyListItemScopeImpl(density, ConstraintsKt.offset-NN6Ew-U(boxWithConstraintsScope.getConstraints-msEJaDk(), -((int) density.toPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues6, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues6, layoutDirection)))), -density.roundToPx-0680j_4(Dp.constructor-impl(paddingValues6.calculateTopPadding-D9Ej5fM() + paddingValues6.calculateBottomPadding-D9Ej5fM()))), null);
                                scalingLazyListState4.getScalingParams$compose_material_release().setValue(scalingParams4);
                                scalingLazyListState4.getExtraPaddingPx$compose_material_release().setValue(Integer.valueOf(iMo586resolveViewportVerticalOffsetBRTryo0));
                                scalingLazyListState4.getBeforeContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i28));
                                scalingLazyListState4.getAfterContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i31));
                                scalingLazyListState4.getViewportHeightPx$compose_material_release().setValue(Integer.valueOf(Constraints.getMaxHeight-impl(boxWithConstraintsScope.getConstraints-msEJaDk())));
                                scalingLazyListState4.getGapBetweenItemsPx$compose_material_release().setValue(Integer.valueOf(density.roundToPx-0680j_4(vertical6.getSpacing-D9Ej5fM())));
                                scalingLazyListState4.getAnchorType$compose_material_release().setValue(ScalingLazyListAnchorType.m759boximpl(i30));
                                scalingLazyListState4.getAutoCentering$compose_material_release().setValue(autoCenteringParams4);
                                scalingLazyListState4.getReverseLayout$compose_material_release().setValue(Boolean.valueOf(z10));
                                MutableState<Boolean> localInspectionMode$compose_material_release = scalingLazyListState4.getLocalInspectionMode$compose_material_release();
                                CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composer3.consume(localInspectionMode);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                localInspectionMode$compose_material_release.setValue(objConsume3);
                                Modifier modifierM453verticalNegativePadding3ABfNKs = androidx.wear.compose.foundation.lazy.ScalingLazyColumnKt.m453verticalNegativePadding3ABfNKs(ClipKt.clipToBounds(Modifier.Companion), f4);
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141668261, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged = composer3.changed(scalingLazyListState4);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                    mutableState3 = mutableState4;
                                    obj = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                            invoke((LayoutCoordinates) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LayoutCoordinates layoutCoordinates) {
                                            ScalingLazyListLayoutInfo layoutInfo = scalingLazyListState4.getLayoutInfo();
                                            if (!ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState3) && (layoutInfo instanceof DefaultScalingLazyListLayoutInfo) && ((DefaultScalingLazyListLayoutInfo) layoutInfo).getReadyForInitialScroll()) {
                                                ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$2(mutableState3, true);
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(obj);
                                } else {
                                    obj = objRememberedValue2;
                                    mutableState3 = mutableState4;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM453verticalNegativePadding3ABfNKs, (Function1) obj);
                                LazyListState lazyListState = scalingLazyListState4.getLazyListState();
                                CombinedPaddingValues combinedPaddingValues2 = combinedPaddingValues;
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141643430, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged2 = composer3.changed(scalingLazyListState4) | composer3.changed(scalingLazyListItemScopeImpl) | composer3.changed(autoCenteringParams4) | composer3.changed(function2);
                                Object objRememberedValue3 = composer3.rememberedValue();
                                if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                    objRememberedValue3 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                            invoke((LazyListScope) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyListScope lazyListScope) {
                                            ScalingLazyListScopeImpl scalingLazyListScopeImpl = new ScalingLazyListScopeImpl(scalingLazyListState4, lazyListScope, scalingLazyListItemScopeImpl);
                                            if (autoCenteringParams4 != null) {
                                                final ScalingLazyListState scalingLazyListState5 = scalingLazyListState4;
                                                LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1989951676, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.1
                                                    {
                                                        super(3);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                        invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                        ComposerKt.sourceInformation(composer4, "C438@21659L213,437@21612L286:ScalingLazyColumn.kt#gj9v0t");
                                                        if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1989951676, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:437)");
                                                            }
                                                            ComposerKt.sourceInformationMarkerStart(composer4, 454359168, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                            boolean zChanged3 = composer4.changed(scalingLazyListState5);
                                                            final ScalingLazyListState scalingLazyListState6 = scalingLazyListState5;
                                                            Object objRememberedValue4 = composer4.rememberedValue();
                                                            if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                                objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$1$1$1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                    public final Integer m752invoke() {
                                                                        return Integer.valueOf(scalingLazyListState6.getTopAutoCenteringItemSizePx$compose_material_release());
                                                                    }
                                                                });
                                                                composer4.updateRememberedValue(objRememberedValue4);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                                            SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), 3, (Object) null);
                                            }
                                            function2.invoke(scalingLazyListScopeImpl);
                                            if (autoCenteringParams4 != null) {
                                                final ScalingLazyListState scalingLazyListState6 = scalingLazyListState4;
                                                LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1331448389, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.2
                                                    {
                                                        super(3);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                        invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                        ComposerKt.sourceInformation(composer4, "C450@22114L216,449@22067L289:ScalingLazyColumn.kt#gj9v0t");
                                                        if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1331448389, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:449)");
                                                            }
                                                            ComposerKt.sourceInformationMarkerStart(composer4, 454373731, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                            boolean zChanged3 = composer4.changed(scalingLazyListState6);
                                                            final ScalingLazyListState scalingLazyListState7 = scalingLazyListState6;
                                                            Object objRememberedValue4 = composer4.rememberedValue();
                                                            if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                                objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$2$1$1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                    public final Integer m753invoke() {
                                                                        return Integer.valueOf(scalingLazyListState7.getBottomAutoCenteringItemSizePx$compose_material_release());
                                                                    }
                                                                });
                                                                composer4.updateRememberedValue(objRememberedValue4);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                                            SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), 3, (Object) null);
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                LazyDslKt.LazyColumn(modifierOnGloballyPositioned, lazyListState, combinedPaddingValues2, z10, vertical6, horizontal5, flingBehavior5, z11, (Function1) objRememberedValue3, composer3, 0, 0);
                                composer3.startReplaceGroup(-938151751);
                                ComposerKt.sourceInformation(composer3, "460@22480L67,460@22458L89");
                                if (ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState3)) {
                                    ComposerKt.sourceInformationMarkerStart(composer3, -2141603055, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                    boolean zChanged3 = composer3.changed(scalingLazyListState4);
                                    ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1 scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = composer3.rememberedValue();
                                    if (zChanged3 || scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue == Composer.Companion.getEmpty()) {
                                        scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = new ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1(scalingLazyListState4, null);
                                        composer3.updateRememberedValue(scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    EffectsKt.LaunchedEffect(scalingLazyListState4, (Function2) scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue, composer3, 0);
                                }
                                composer3.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 3456, 2);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    scalingParams3 = scalingParams2;
                    paddingValues5 = paddingValues4;
                    z6 = z9;
                    scalingLazyListState3 = scalingLazyListState2;
                    vertical5 = vertical4;
                    i20 = i19;
                    autoCenteringParams3 = autoCenteringParams2;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i22 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i4 & 2) != 0) {
                            scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        }
                        if (i24 != 0) {
                            paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                        } else {
                            paddingValues3 = paddingValues2;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if ((i4 & 16) != 0) {
                            Arrangement arrangement4 = Arrangement.INSTANCE;
                            float f4 = Dp.constructor-impl(4);
                            companion = Alignment.Companion;
                            if (z3) {
                                bottom = companion.getTop();
                            } else {
                                bottom = companion.getBottom();
                            }
                            vertical3 = arrangement4.spacedBy-D5KLDUw(f4, bottom);
                            i5 &= -57345;
                        } else {
                            vertical3 = vertical2;
                        }
                        if (i8 != 0) {
                            centerHorizontally = Alignment.Companion.getCenterHorizontally();
                        } else {
                            centerHorizontally = horizontal2;
                        }
                        if ((i4 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                            i5 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        }
                        if ((i4 & 256) != 0) {
                            scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                            i5 &= -234881025;
                        } else {
                            scalingParamsScalingParams$default = scalingParams;
                        }
                        if (i12 != 0) {
                            iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                        } else {
                            iM766getItemCenterhvgbs18 = i;
                        }
                        if (i14 != 0) {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                            autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                        } else {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            autoCenteringParams2 = autoCenteringParams;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                        }
                    } else {
                        if (i22 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i4 & 2) != 0) {
                            scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        }
                        if (i24 != 0) {
                            paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                        } else {
                            paddingValues3 = paddingValues2;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if ((i4 & 16) != 0) {
                            Arrangement arrangement5 = Arrangement.INSTANCE;
                            float f5 = Dp.constructor-impl(4);
                            companion = Alignment.Companion;
                            if (z3) {
                                bottom = companion.getTop();
                            } else {
                                bottom = companion.getBottom();
                            }
                            vertical3 = arrangement5.spacedBy-D5KLDUw(f5, bottom);
                            i5 &= -57345;
                        } else {
                            vertical3 = vertical2;
                        }
                        if (i8 != 0) {
                            centerHorizontally = Alignment.Companion.getCenterHorizontally();
                        } else {
                            centerHorizontally = horizontal2;
                        }
                        if ((i4 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                            i5 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        }
                        if ((i4 & 256) != 0) {
                            scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                            i5 &= -234881025;
                        } else {
                            scalingParamsScalingParams$default = scalingParams;
                        }
                        if (i12 != 0) {
                            iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                        } else {
                            iM766getItemCenterhvgbs18 = i;
                        }
                        if (i14 != 0) {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                            autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                        } else {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            autoCenteringParams2 = autoCenteringParams;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                        }
                    }
                    final boolean z10 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(741207601, i5, i18, "androidx.wear.compose.material.ScalingLazyColumn (ScalingLazyColumn.kt:357)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1150553998, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final MutableState<Boolean> mutableState3 = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, true, ComposableLambdaKt.rememberComposableLambda(-334395385, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i26) {
                            BoxWithConstraintsScope boxWithConstraintsScope2;
                            int i27;
                            int i28;
                            int i29;
                            final MutableState<Boolean> mutableState4;
                            Object obj;
                            ComposerKt.sourceInformation(composer3, "C360@18044L7,361@18103L7,*405@20227L7,411@20433L365,427@21182L1228,407@20248L2162:ScalingLazyColumn.kt#gj9v0t");
                            if ((i26 & 6) == 0) {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i27 = i26 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                            } else {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i27 = i26;
                            }
                            if ((i27 & 19) != 18 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-334395385, i27, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous> (ScalingLazyColumn.kt:360)");
                                }
                                CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume = composer3.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Density density = (Density) objConsume;
                                CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composer3.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                int iMo586resolveViewportVerticalOffsetBRTryo0 = scalingParams2.mo586resolveViewportVerticalOffsetBRTryo0(boxWithConstraintsScope2.getConstraints-msEJaDk());
                                PaddingValues paddingValues6 = paddingValues4;
                                boolean z11 = z10;
                                final ScalingLazyListState scalingLazyListState4 = scalingLazyListState2;
                                ScalingParams scalingParams4 = scalingParams2;
                                Arrangement.Vertical vertical6 = vertical4;
                                int i30 = i19;
                                final AutoCenteringParams autoCenteringParams4 = autoCenteringParams2;
                                Alignment.Horizontal horizontal5 = horizontal3;
                                FlingBehavior flingBehavior5 = flingBehavior3;
                                boolean z12 = z5;
                                final Function1<? super ScalingLazyListScope, Unit> function2 = function1;
                                MutableState<Boolean> mutableState5 = mutableState3;
                                float f6 = density.toDp-u2uoSUM(iMo586resolveViewportVerticalOffsetBRTryo0);
                                CombinedPaddingValues combinedPaddingValues = new CombinedPaddingValues(paddingValues6, f6, null);
                                if (z11) {
                                    i28 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                                } else {
                                    i28 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                                }
                                if (z11) {
                                    i29 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                                } else {
                                    i29 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                                }
                                int i31 = i29;
                                final ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl = new ScalingLazyListItemScopeImpl(density, ConstraintsKt.offset-NN6Ew-U(boxWithConstraintsScope.getConstraints-msEJaDk(), -((int) density.toPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues6, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues6, layoutDirection)))), -density.roundToPx-0680j_4(Dp.constructor-impl(paddingValues6.calculateTopPadding-D9Ej5fM() + paddingValues6.calculateBottomPadding-D9Ej5fM()))), null);
                                scalingLazyListState4.getScalingParams$compose_material_release().setValue(scalingParams4);
                                scalingLazyListState4.getExtraPaddingPx$compose_material_release().setValue(Integer.valueOf(iMo586resolveViewportVerticalOffsetBRTryo0));
                                scalingLazyListState4.getBeforeContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i28));
                                scalingLazyListState4.getAfterContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i31));
                                scalingLazyListState4.getViewportHeightPx$compose_material_release().setValue(Integer.valueOf(Constraints.getMaxHeight-impl(boxWithConstraintsScope.getConstraints-msEJaDk())));
                                scalingLazyListState4.getGapBetweenItemsPx$compose_material_release().setValue(Integer.valueOf(density.roundToPx-0680j_4(vertical6.getSpacing-D9Ej5fM())));
                                scalingLazyListState4.getAnchorType$compose_material_release().setValue(ScalingLazyListAnchorType.m759boximpl(i30));
                                scalingLazyListState4.getAutoCentering$compose_material_release().setValue(autoCenteringParams4);
                                scalingLazyListState4.getReverseLayout$compose_material_release().setValue(Boolean.valueOf(z11));
                                MutableState<Boolean> localInspectionMode$compose_material_release = scalingLazyListState4.getLocalInspectionMode$compose_material_release();
                                CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composer3.consume(localInspectionMode);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                localInspectionMode$compose_material_release.setValue(objConsume3);
                                Modifier modifierM453verticalNegativePadding3ABfNKs = androidx.wear.compose.foundation.lazy.ScalingLazyColumnKt.m453verticalNegativePadding3ABfNKs(ClipKt.clipToBounds(Modifier.Companion), f6);
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141668261, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged = composer3.changed(scalingLazyListState4);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                    mutableState4 = mutableState5;
                                    obj = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                            invoke((LayoutCoordinates) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LayoutCoordinates layoutCoordinates) {
                                            ScalingLazyListLayoutInfo layoutInfo = scalingLazyListState4.getLayoutInfo();
                                            if (!ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState4) && (layoutInfo instanceof DefaultScalingLazyListLayoutInfo) && ((DefaultScalingLazyListLayoutInfo) layoutInfo).getReadyForInitialScroll()) {
                                                ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$2(mutableState4, true);
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(obj);
                                } else {
                                    obj = objRememberedValue2;
                                    mutableState4 = mutableState5;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM453verticalNegativePadding3ABfNKs, (Function1) obj);
                                LazyListState lazyListState = scalingLazyListState4.getLazyListState();
                                CombinedPaddingValues combinedPaddingValues2 = combinedPaddingValues;
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141643430, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged2 = composer3.changed(scalingLazyListState4) | composer3.changed(scalingLazyListItemScopeImpl) | composer3.changed(autoCenteringParams4) | composer3.changed(function2);
                                Object objRememberedValue3 = composer3.rememberedValue();
                                if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                    objRememberedValue3 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                            invoke((LazyListScope) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyListScope lazyListScope) {
                                            ScalingLazyListScopeImpl scalingLazyListScopeImpl = new ScalingLazyListScopeImpl(scalingLazyListState4, lazyListScope, scalingLazyListItemScopeImpl);
                                            if (autoCenteringParams4 != null) {
                                                final ScalingLazyListState scalingLazyListState5 = scalingLazyListState4;
                                                LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1989951676, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.1
                                                    {
                                                        super(3);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                        invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                        ComposerKt.sourceInformation(composer4, "C438@21659L213,437@21612L286:ScalingLazyColumn.kt#gj9v0t");
                                                        if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1989951676, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:437)");
                                                            }
                                                            ComposerKt.sourceInformationMarkerStart(composer4, 454359168, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                            boolean zChanged3 = composer4.changed(scalingLazyListState5);
                                                            final ScalingLazyListState scalingLazyListState6 = scalingLazyListState5;
                                                            Object objRememberedValue4 = composer4.rememberedValue();
                                                            if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                                objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$1$1$1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                    public final Integer m752invoke() {
                                                                        return Integer.valueOf(scalingLazyListState6.getTopAutoCenteringItemSizePx$compose_material_release());
                                                                    }
                                                                });
                                                                composer4.updateRememberedValue(objRememberedValue4);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                                            SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), 3, (Object) null);
                                            }
                                            function2.invoke(scalingLazyListScopeImpl);
                                            if (autoCenteringParams4 != null) {
                                                final ScalingLazyListState scalingLazyListState6 = scalingLazyListState4;
                                                LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1331448389, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.2
                                                    {
                                                        super(3);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                        invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                        ComposerKt.sourceInformation(composer4, "C450@22114L216,449@22067L289:ScalingLazyColumn.kt#gj9v0t");
                                                        if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1331448389, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:449)");
                                                            }
                                                            ComposerKt.sourceInformationMarkerStart(composer4, 454373731, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                            boolean zChanged3 = composer4.changed(scalingLazyListState6);
                                                            final ScalingLazyListState scalingLazyListState7 = scalingLazyListState6;
                                                            Object objRememberedValue4 = composer4.rememberedValue();
                                                            if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                                objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$2$1$1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                    public final Integer m753invoke() {
                                                                        return Integer.valueOf(scalingLazyListState7.getBottomAutoCenteringItemSizePx$compose_material_release());
                                                                    }
                                                                });
                                                                composer4.updateRememberedValue(objRememberedValue4);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                                            SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), 3, (Object) null);
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                LazyDslKt.LazyColumn(modifierOnGloballyPositioned, lazyListState, combinedPaddingValues2, z11, vertical6, horizontal5, flingBehavior5, z12, (Function1) objRememberedValue3, composer3, 0, 0);
                                composer3.startReplaceGroup(-938151751);
                                ComposerKt.sourceInformation(composer3, "460@22480L67,460@22458L89");
                                if (ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState4)) {
                                    ComposerKt.sourceInformationMarkerStart(composer3, -2141603055, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                    boolean zChanged3 = composer3.changed(scalingLazyListState4);
                                    ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1 scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = composer3.rememberedValue();
                                    if (zChanged3 || scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue == Composer.Companion.getEmpty()) {
                                        scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = new ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1(scalingLazyListState4, null);
                                        composer3.updateRememberedValue(scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    EffectsKt.LaunchedEffect(scalingLazyListState4, (Function2) scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue, composer3, 0);
                                }
                                composer3.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 3456, 2);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    scalingParams3 = scalingParams2;
                    paddingValues5 = paddingValues4;
                    z6 = z10;
                    scalingLazyListState3 = scalingLazyListState2;
                    vertical5 = vertical4;
                    i20 = i19;
                    autoCenteringParams3 = autoCenteringParams2;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i26) {
                            ScalingLazyColumnKt.m751ScalingLazyColumn8g7MjcI(modifier5, scalingLazyListState3, paddingValues5, z6, vertical5, horizontal4, flingBehavior4, z7, scalingParams3, i20, autoCenteringParams3, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                        }
                    });
                }
            }
            i5 |= 3072;
            z3 = z;
            if ((i2 & 24576) == 0) {
                if ((i4 & 16) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i5 |= i25;
                } else {
                    vertical2 = vertical;
                }
                i5 |= i25;
            } else {
                vertical2 = vertical;
            }
            i8 = i4 & 32;
            if (i8 != 0) {
                i5 |= 196608;
                horizontal2 = horizontal;
            } else {
                horizontal2 = horizontal;
                if ((i2 & 196608) == 0) {
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i5 |= i9;
                }
            }
            if ((i2 & 1572864) != 0) {
                if ((i4 & 64) == 0) {
                    i21 = 524288;
                } else {
                    i21 = 524288;
                }
                i5 |= i21;
            }
            i10 = i4 & 128;
            if (i10 != 0) {
                i5 |= 12582912;
                z4 = z2;
            } else {
                z4 = z2;
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z4)) {
                        i11 = 8388608;
                    } else {
                        i11 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i5 |= i11;
                }
            }
            if ((i2 & 100663296) != 0) {
                i5 |= ((i4 & 256) == 0 || !composerStartRestartGroup.changed(scalingParams)) ? 33554432 : 67108864;
            }
            i12 = i4 & 512;
            if (i12 != 0) {
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i13 = 536870912;
                    } else {
                        i13 = 268435456;
                    }
                    i5 |= i13;
                }
                i14 = i4 & UserMetadata.MAX_ATTRIBUTE_SIZE;
                if (i14 != 0) {
                    i15 = i3 | 6;
                } else if ((i3 & 6) == 0) {
                    if (composerStartRestartGroup.changed(autoCenteringParams)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i3 | i16;
                } else {
                    i15 = i3;
                }
                if ((i4 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                    i15 |= 48;
                } else if ((i3 & 48) != 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i17 = 32;
                    } else {
                        i17 = 16;
                    }
                    i15 |= i17;
                }
                i18 = i15;
                if ((i5 & 306783379) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i22 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i4 & 2) != 0) {
                            scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        }
                        if (i24 != 0) {
                            paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                        } else {
                            paddingValues3 = paddingValues2;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if ((i4 & 16) != 0) {
                            Arrangement arrangement6 = Arrangement.INSTANCE;
                            float f6 = Dp.constructor-impl(4);
                            companion = Alignment.Companion;
                            if (z3) {
                                bottom = companion.getTop();
                            } else {
                                bottom = companion.getBottom();
                            }
                            vertical3 = arrangement6.spacedBy-D5KLDUw(f6, bottom);
                            i5 &= -57345;
                        } else {
                            vertical3 = vertical2;
                        }
                        if (i8 != 0) {
                            centerHorizontally = Alignment.Companion.getCenterHorizontally();
                        } else {
                            centerHorizontally = horizontal2;
                        }
                        if ((i4 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                            i5 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        }
                        if ((i4 & 256) != 0) {
                            scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                            i5 &= -234881025;
                        } else {
                            scalingParamsScalingParams$default = scalingParams;
                        }
                        if (i12 != 0) {
                            iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                        } else {
                            iM766getItemCenterhvgbs18 = i;
                        }
                        if (i14 != 0) {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                            autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                        } else {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            autoCenteringParams2 = autoCenteringParams;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                        }
                    } else {
                        if (i22 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i4 & 2) != 0) {
                            scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        }
                        if (i24 != 0) {
                            paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                        } else {
                            paddingValues3 = paddingValues2;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if ((i4 & 16) != 0) {
                            Arrangement arrangement7 = Arrangement.INSTANCE;
                            float f7 = Dp.constructor-impl(4);
                            companion = Alignment.Companion;
                            if (z3) {
                                bottom = companion.getTop();
                            } else {
                                bottom = companion.getBottom();
                            }
                            vertical3 = arrangement7.spacedBy-D5KLDUw(f7, bottom);
                            i5 &= -57345;
                        } else {
                            vertical3 = vertical2;
                        }
                        if (i8 != 0) {
                            centerHorizontally = Alignment.Companion.getCenterHorizontally();
                        } else {
                            centerHorizontally = horizontal2;
                        }
                        if ((i4 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                            i5 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        }
                        if ((i4 & 256) != 0) {
                            scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                            i5 &= -234881025;
                        } else {
                            scalingParamsScalingParams$default = scalingParams;
                        }
                        if (i12 != 0) {
                            iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                        } else {
                            iM766getItemCenterhvgbs18 = i;
                        }
                        if (i14 != 0) {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                            autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                        } else {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            autoCenteringParams2 = autoCenteringParams;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                        }
                    }
                    final boolean z11 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(741207601, i5, i18, "androidx.wear.compose.material.ScalingLazyColumn (ScalingLazyColumn.kt:357)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1150553998, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final MutableState<Boolean> mutableState4 = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, true, ComposableLambdaKt.rememberComposableLambda(-334395385, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i26) {
                            BoxWithConstraintsScope boxWithConstraintsScope2;
                            int i27;
                            int i28;
                            int i29;
                            final MutableState<Boolean> mutableState5;
                            Object obj;
                            ComposerKt.sourceInformation(composer3, "C360@18044L7,361@18103L7,*405@20227L7,411@20433L365,427@21182L1228,407@20248L2162:ScalingLazyColumn.kt#gj9v0t");
                            if ((i26 & 6) == 0) {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i27 = i26 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                            } else {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i27 = i26;
                            }
                            if ((i27 & 19) != 18 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-334395385, i27, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous> (ScalingLazyColumn.kt:360)");
                                }
                                CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume = composer3.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Density density = (Density) objConsume;
                                CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composer3.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                int iMo586resolveViewportVerticalOffsetBRTryo0 = scalingParams2.mo586resolveViewportVerticalOffsetBRTryo0(boxWithConstraintsScope2.getConstraints-msEJaDk());
                                PaddingValues paddingValues6 = paddingValues4;
                                boolean z12 = z11;
                                final ScalingLazyListState scalingLazyListState4 = scalingLazyListState2;
                                ScalingParams scalingParams4 = scalingParams2;
                                Arrangement.Vertical vertical6 = vertical4;
                                int i30 = i19;
                                final AutoCenteringParams autoCenteringParams4 = autoCenteringParams2;
                                Alignment.Horizontal horizontal5 = horizontal3;
                                FlingBehavior flingBehavior5 = flingBehavior3;
                                boolean z13 = z5;
                                final Function1<? super ScalingLazyListScope, Unit> function2 = function1;
                                MutableState<Boolean> mutableState6 = mutableState4;
                                float f8 = density.toDp-u2uoSUM(iMo586resolveViewportVerticalOffsetBRTryo0);
                                CombinedPaddingValues combinedPaddingValues = new CombinedPaddingValues(paddingValues6, f8, null);
                                if (z12) {
                                    i28 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                                } else {
                                    i28 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                                }
                                if (z12) {
                                    i29 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                                } else {
                                    i29 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                                }
                                int i31 = i29;
                                final ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl = new ScalingLazyListItemScopeImpl(density, ConstraintsKt.offset-NN6Ew-U(boxWithConstraintsScope.getConstraints-msEJaDk(), -((int) density.toPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues6, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues6, layoutDirection)))), -density.roundToPx-0680j_4(Dp.constructor-impl(paddingValues6.calculateTopPadding-D9Ej5fM() + paddingValues6.calculateBottomPadding-D9Ej5fM()))), null);
                                scalingLazyListState4.getScalingParams$compose_material_release().setValue(scalingParams4);
                                scalingLazyListState4.getExtraPaddingPx$compose_material_release().setValue(Integer.valueOf(iMo586resolveViewportVerticalOffsetBRTryo0));
                                scalingLazyListState4.getBeforeContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i28));
                                scalingLazyListState4.getAfterContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i31));
                                scalingLazyListState4.getViewportHeightPx$compose_material_release().setValue(Integer.valueOf(Constraints.getMaxHeight-impl(boxWithConstraintsScope.getConstraints-msEJaDk())));
                                scalingLazyListState4.getGapBetweenItemsPx$compose_material_release().setValue(Integer.valueOf(density.roundToPx-0680j_4(vertical6.getSpacing-D9Ej5fM())));
                                scalingLazyListState4.getAnchorType$compose_material_release().setValue(ScalingLazyListAnchorType.m759boximpl(i30));
                                scalingLazyListState4.getAutoCentering$compose_material_release().setValue(autoCenteringParams4);
                                scalingLazyListState4.getReverseLayout$compose_material_release().setValue(Boolean.valueOf(z12));
                                MutableState<Boolean> localInspectionMode$compose_material_release = scalingLazyListState4.getLocalInspectionMode$compose_material_release();
                                CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composer3.consume(localInspectionMode);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                localInspectionMode$compose_material_release.setValue(objConsume3);
                                Modifier modifierM453verticalNegativePadding3ABfNKs = androidx.wear.compose.foundation.lazy.ScalingLazyColumnKt.m453verticalNegativePadding3ABfNKs(ClipKt.clipToBounds(Modifier.Companion), f8);
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141668261, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged = composer3.changed(scalingLazyListState4);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                    mutableState5 = mutableState6;
                                    obj = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                            invoke((LayoutCoordinates) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LayoutCoordinates layoutCoordinates) {
                                            ScalingLazyListLayoutInfo layoutInfo = scalingLazyListState4.getLayoutInfo();
                                            if (!ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState5) && (layoutInfo instanceof DefaultScalingLazyListLayoutInfo) && ((DefaultScalingLazyListLayoutInfo) layoutInfo).getReadyForInitialScroll()) {
                                                ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$2(mutableState5, true);
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(obj);
                                } else {
                                    obj = objRememberedValue2;
                                    mutableState5 = mutableState6;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM453verticalNegativePadding3ABfNKs, (Function1) obj);
                                LazyListState lazyListState = scalingLazyListState4.getLazyListState();
                                CombinedPaddingValues combinedPaddingValues2 = combinedPaddingValues;
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141643430, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged2 = composer3.changed(scalingLazyListState4) | composer3.changed(scalingLazyListItemScopeImpl) | composer3.changed(autoCenteringParams4) | composer3.changed(function2);
                                Object objRememberedValue3 = composer3.rememberedValue();
                                if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                    objRememberedValue3 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                            invoke((LazyListScope) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyListScope lazyListScope) {
                                            ScalingLazyListScopeImpl scalingLazyListScopeImpl = new ScalingLazyListScopeImpl(scalingLazyListState4, lazyListScope, scalingLazyListItemScopeImpl);
                                            if (autoCenteringParams4 != null) {
                                                final ScalingLazyListState scalingLazyListState5 = scalingLazyListState4;
                                                LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1989951676, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.1
                                                    {
                                                        super(3);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                        invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                        ComposerKt.sourceInformation(composer4, "C438@21659L213,437@21612L286:ScalingLazyColumn.kt#gj9v0t");
                                                        if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1989951676, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:437)");
                                                            }
                                                            ComposerKt.sourceInformationMarkerStart(composer4, 454359168, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                            boolean zChanged3 = composer4.changed(scalingLazyListState5);
                                                            final ScalingLazyListState scalingLazyListState6 = scalingLazyListState5;
                                                            Object objRememberedValue4 = composer4.rememberedValue();
                                                            if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                                objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$1$1$1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                    public final Integer m752invoke() {
                                                                        return Integer.valueOf(scalingLazyListState6.getTopAutoCenteringItemSizePx$compose_material_release());
                                                                    }
                                                                });
                                                                composer4.updateRememberedValue(objRememberedValue4);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                                            SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), 3, (Object) null);
                                            }
                                            function2.invoke(scalingLazyListScopeImpl);
                                            if (autoCenteringParams4 != null) {
                                                final ScalingLazyListState scalingLazyListState6 = scalingLazyListState4;
                                                LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1331448389, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.2
                                                    {
                                                        super(3);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                        invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                        ComposerKt.sourceInformation(composer4, "C450@22114L216,449@22067L289:ScalingLazyColumn.kt#gj9v0t");
                                                        if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1331448389, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:449)");
                                                            }
                                                            ComposerKt.sourceInformationMarkerStart(composer4, 454373731, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                            boolean zChanged3 = composer4.changed(scalingLazyListState6);
                                                            final ScalingLazyListState scalingLazyListState7 = scalingLazyListState6;
                                                            Object objRememberedValue4 = composer4.rememberedValue();
                                                            if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                                objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$2$1$1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                    public final Integer m753invoke() {
                                                                        return Integer.valueOf(scalingLazyListState7.getBottomAutoCenteringItemSizePx$compose_material_release());
                                                                    }
                                                                });
                                                                composer4.updateRememberedValue(objRememberedValue4);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                                            SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), 3, (Object) null);
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                LazyDslKt.LazyColumn(modifierOnGloballyPositioned, lazyListState, combinedPaddingValues2, z12, vertical6, horizontal5, flingBehavior5, z13, (Function1) objRememberedValue3, composer3, 0, 0);
                                composer3.startReplaceGroup(-938151751);
                                ComposerKt.sourceInformation(composer3, "460@22480L67,460@22458L89");
                                if (ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState5)) {
                                    ComposerKt.sourceInformationMarkerStart(composer3, -2141603055, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                    boolean zChanged3 = composer3.changed(scalingLazyListState4);
                                    ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1 scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = composer3.rememberedValue();
                                    if (zChanged3 || scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue == Composer.Companion.getEmpty()) {
                                        scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = new ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1(scalingLazyListState4, null);
                                        composer3.updateRememberedValue(scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    EffectsKt.LaunchedEffect(scalingLazyListState4, (Function2) scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue, composer3, 0);
                                }
                                composer3.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 3456, 2);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    scalingParams3 = scalingParams2;
                    paddingValues5 = paddingValues4;
                    z6 = z11;
                    scalingLazyListState3 = scalingLazyListState2;
                    vertical5 = vertical4;
                    i20 = i19;
                    autoCenteringParams3 = autoCenteringParams2;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i22 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i4 & 2) != 0) {
                            scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        }
                        if (i24 != 0) {
                            paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                        } else {
                            paddingValues3 = paddingValues2;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if ((i4 & 16) != 0) {
                            Arrangement arrangement8 = Arrangement.INSTANCE;
                            float f8 = Dp.constructor-impl(4);
                            companion = Alignment.Companion;
                            if (z3) {
                                bottom = companion.getTop();
                            } else {
                                bottom = companion.getBottom();
                            }
                            vertical3 = arrangement8.spacedBy-D5KLDUw(f8, bottom);
                            i5 &= -57345;
                        } else {
                            vertical3 = vertical2;
                        }
                        if (i8 != 0) {
                            centerHorizontally = Alignment.Companion.getCenterHorizontally();
                        } else {
                            centerHorizontally = horizontal2;
                        }
                        if ((i4 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                            i5 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        }
                        if ((i4 & 256) != 0) {
                            scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                            i5 &= -234881025;
                        } else {
                            scalingParamsScalingParams$default = scalingParams;
                        }
                        if (i12 != 0) {
                            iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                        } else {
                            iM766getItemCenterhvgbs18 = i;
                        }
                        if (i14 != 0) {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                            autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                        } else {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            autoCenteringParams2 = autoCenteringParams;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                        }
                    } else {
                        if (i22 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i4 & 2) != 0) {
                            scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        }
                        if (i24 != 0) {
                            paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                        } else {
                            paddingValues3 = paddingValues2;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if ((i4 & 16) != 0) {
                            Arrangement arrangement9 = Arrangement.INSTANCE;
                            float f9 = Dp.constructor-impl(4);
                            companion = Alignment.Companion;
                            if (z3) {
                                bottom = companion.getTop();
                            } else {
                                bottom = companion.getBottom();
                            }
                            vertical3 = arrangement9.spacedBy-D5KLDUw(f9, bottom);
                            i5 &= -57345;
                        } else {
                            vertical3 = vertical2;
                        }
                        if (i8 != 0) {
                            centerHorizontally = Alignment.Companion.getCenterHorizontally();
                        } else {
                            centerHorizontally = horizontal2;
                        }
                        if ((i4 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                            i5 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        }
                        if ((i4 & 256) != 0) {
                            scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                            i5 &= -234881025;
                        } else {
                            scalingParamsScalingParams$default = scalingParams;
                        }
                        if (i12 != 0) {
                            iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                        } else {
                            iM766getItemCenterhvgbs18 = i;
                        }
                        if (i14 != 0) {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                            autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                        } else {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            autoCenteringParams2 = autoCenteringParams;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                        }
                    }
                    final boolean z12 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(741207601, i5, i18, "androidx.wear.compose.material.ScalingLazyColumn (ScalingLazyColumn.kt:357)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1150553998, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final MutableState<Boolean> mutableState5 = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, true, ComposableLambdaKt.rememberComposableLambda(-334395385, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i26) {
                            BoxWithConstraintsScope boxWithConstraintsScope2;
                            int i27;
                            int i28;
                            int i29;
                            final MutableState<Boolean> mutableState6;
                            Object obj;
                            ComposerKt.sourceInformation(composer3, "C360@18044L7,361@18103L7,*405@20227L7,411@20433L365,427@21182L1228,407@20248L2162:ScalingLazyColumn.kt#gj9v0t");
                            if ((i26 & 6) == 0) {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i27 = i26 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                            } else {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i27 = i26;
                            }
                            if ((i27 & 19) != 18 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-334395385, i27, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous> (ScalingLazyColumn.kt:360)");
                                }
                                CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume = composer3.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Density density = (Density) objConsume;
                                CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composer3.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                int iMo586resolveViewportVerticalOffsetBRTryo0 = scalingParams2.mo586resolveViewportVerticalOffsetBRTryo0(boxWithConstraintsScope2.getConstraints-msEJaDk());
                                PaddingValues paddingValues6 = paddingValues4;
                                boolean z13 = z12;
                                final ScalingLazyListState scalingLazyListState4 = scalingLazyListState2;
                                ScalingParams scalingParams4 = scalingParams2;
                                Arrangement.Vertical vertical6 = vertical4;
                                int i30 = i19;
                                final AutoCenteringParams autoCenteringParams4 = autoCenteringParams2;
                                Alignment.Horizontal horizontal5 = horizontal3;
                                FlingBehavior flingBehavior5 = flingBehavior3;
                                boolean z14 = z5;
                                final Function1<? super ScalingLazyListScope, Unit> function2 = function1;
                                MutableState<Boolean> mutableState7 = mutableState5;
                                float f10 = density.toDp-u2uoSUM(iMo586resolveViewportVerticalOffsetBRTryo0);
                                CombinedPaddingValues combinedPaddingValues = new CombinedPaddingValues(paddingValues6, f10, null);
                                if (z13) {
                                    i28 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                                } else {
                                    i28 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                                }
                                if (z13) {
                                    i29 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                                } else {
                                    i29 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                                }
                                int i31 = i29;
                                final ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl = new ScalingLazyListItemScopeImpl(density, ConstraintsKt.offset-NN6Ew-U(boxWithConstraintsScope.getConstraints-msEJaDk(), -((int) density.toPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues6, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues6, layoutDirection)))), -density.roundToPx-0680j_4(Dp.constructor-impl(paddingValues6.calculateTopPadding-D9Ej5fM() + paddingValues6.calculateBottomPadding-D9Ej5fM()))), null);
                                scalingLazyListState4.getScalingParams$compose_material_release().setValue(scalingParams4);
                                scalingLazyListState4.getExtraPaddingPx$compose_material_release().setValue(Integer.valueOf(iMo586resolveViewportVerticalOffsetBRTryo0));
                                scalingLazyListState4.getBeforeContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i28));
                                scalingLazyListState4.getAfterContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i31));
                                scalingLazyListState4.getViewportHeightPx$compose_material_release().setValue(Integer.valueOf(Constraints.getMaxHeight-impl(boxWithConstraintsScope.getConstraints-msEJaDk())));
                                scalingLazyListState4.getGapBetweenItemsPx$compose_material_release().setValue(Integer.valueOf(density.roundToPx-0680j_4(vertical6.getSpacing-D9Ej5fM())));
                                scalingLazyListState4.getAnchorType$compose_material_release().setValue(ScalingLazyListAnchorType.m759boximpl(i30));
                                scalingLazyListState4.getAutoCentering$compose_material_release().setValue(autoCenteringParams4);
                                scalingLazyListState4.getReverseLayout$compose_material_release().setValue(Boolean.valueOf(z13));
                                MutableState<Boolean> localInspectionMode$compose_material_release = scalingLazyListState4.getLocalInspectionMode$compose_material_release();
                                CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composer3.consume(localInspectionMode);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                localInspectionMode$compose_material_release.setValue(objConsume3);
                                Modifier modifierM453verticalNegativePadding3ABfNKs = androidx.wear.compose.foundation.lazy.ScalingLazyColumnKt.m453verticalNegativePadding3ABfNKs(ClipKt.clipToBounds(Modifier.Companion), f10);
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141668261, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged = composer3.changed(scalingLazyListState4);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                    mutableState6 = mutableState7;
                                    obj = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                            invoke((LayoutCoordinates) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LayoutCoordinates layoutCoordinates) {
                                            ScalingLazyListLayoutInfo layoutInfo = scalingLazyListState4.getLayoutInfo();
                                            if (!ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState6) && (layoutInfo instanceof DefaultScalingLazyListLayoutInfo) && ((DefaultScalingLazyListLayoutInfo) layoutInfo).getReadyForInitialScroll()) {
                                                ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$2(mutableState6, true);
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(obj);
                                } else {
                                    obj = objRememberedValue2;
                                    mutableState6 = mutableState7;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM453verticalNegativePadding3ABfNKs, (Function1) obj);
                                LazyListState lazyListState = scalingLazyListState4.getLazyListState();
                                CombinedPaddingValues combinedPaddingValues2 = combinedPaddingValues;
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141643430, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged2 = composer3.changed(scalingLazyListState4) | composer3.changed(scalingLazyListItemScopeImpl) | composer3.changed(autoCenteringParams4) | composer3.changed(function2);
                                Object objRememberedValue3 = composer3.rememberedValue();
                                if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                    objRememberedValue3 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                            invoke((LazyListScope) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyListScope lazyListScope) {
                                            ScalingLazyListScopeImpl scalingLazyListScopeImpl = new ScalingLazyListScopeImpl(scalingLazyListState4, lazyListScope, scalingLazyListItemScopeImpl);
                                            if (autoCenteringParams4 != null) {
                                                final ScalingLazyListState scalingLazyListState5 = scalingLazyListState4;
                                                LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1989951676, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.1
                                                    {
                                                        super(3);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                        invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                        ComposerKt.sourceInformation(composer4, "C438@21659L213,437@21612L286:ScalingLazyColumn.kt#gj9v0t");
                                                        if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1989951676, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:437)");
                                                            }
                                                            ComposerKt.sourceInformationMarkerStart(composer4, 454359168, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                            boolean zChanged3 = composer4.changed(scalingLazyListState5);
                                                            final ScalingLazyListState scalingLazyListState6 = scalingLazyListState5;
                                                            Object objRememberedValue4 = composer4.rememberedValue();
                                                            if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                                objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$1$1$1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                    public final Integer m752invoke() {
                                                                        return Integer.valueOf(scalingLazyListState6.getTopAutoCenteringItemSizePx$compose_material_release());
                                                                    }
                                                                });
                                                                composer4.updateRememberedValue(objRememberedValue4);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                                            SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), 3, (Object) null);
                                            }
                                            function2.invoke(scalingLazyListScopeImpl);
                                            if (autoCenteringParams4 != null) {
                                                final ScalingLazyListState scalingLazyListState6 = scalingLazyListState4;
                                                LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1331448389, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.2
                                                    {
                                                        super(3);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                        invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                        ComposerKt.sourceInformation(composer4, "C450@22114L216,449@22067L289:ScalingLazyColumn.kt#gj9v0t");
                                                        if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1331448389, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:449)");
                                                            }
                                                            ComposerKt.sourceInformationMarkerStart(composer4, 454373731, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                            boolean zChanged3 = composer4.changed(scalingLazyListState6);
                                                            final ScalingLazyListState scalingLazyListState7 = scalingLazyListState6;
                                                            Object objRememberedValue4 = composer4.rememberedValue();
                                                            if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                                objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$2$1$1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                    public final Integer m753invoke() {
                                                                        return Integer.valueOf(scalingLazyListState7.getBottomAutoCenteringItemSizePx$compose_material_release());
                                                                    }
                                                                });
                                                                composer4.updateRememberedValue(objRememberedValue4);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                                            SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), 3, (Object) null);
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                LazyDslKt.LazyColumn(modifierOnGloballyPositioned, lazyListState, combinedPaddingValues2, z13, vertical6, horizontal5, flingBehavior5, z14, (Function1) objRememberedValue3, composer3, 0, 0);
                                composer3.startReplaceGroup(-938151751);
                                ComposerKt.sourceInformation(composer3, "460@22480L67,460@22458L89");
                                if (ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState6)) {
                                    ComposerKt.sourceInformationMarkerStart(composer3, -2141603055, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                    boolean zChanged3 = composer3.changed(scalingLazyListState4);
                                    ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1 scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = composer3.rememberedValue();
                                    if (zChanged3 || scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue == Composer.Companion.getEmpty()) {
                                        scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = new ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1(scalingLazyListState4, null);
                                        composer3.updateRememberedValue(scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    EffectsKt.LaunchedEffect(scalingLazyListState4, (Function2) scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue, composer3, 0);
                                }
                                composer3.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 3456, 2);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    scalingParams3 = scalingParams2;
                    paddingValues5 = paddingValues4;
                    z6 = z12;
                    scalingLazyListState3 = scalingLazyListState2;
                    vertical5 = vertical4;
                    i20 = i19;
                    autoCenteringParams3 = autoCenteringParams2;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i26) {
                            ScalingLazyColumnKt.m751ScalingLazyColumn8g7MjcI(modifier5, scalingLazyListState3, paddingValues5, z6, vertical5, horizontal4, flingBehavior4, z7, scalingParams3, i20, autoCenteringParams3, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                        }
                    });
                }
            }
            i5 |= 805306368;
            i14 = i4 & UserMetadata.MAX_ATTRIBUTE_SIZE;
            if (i14 != 0) {
                i15 = i3 | 6;
            } else if ((i3 & 6) == 0) {
                if (composerStartRestartGroup.changed(autoCenteringParams)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i3 | i16;
            } else {
                i15 = i3;
            }
            if ((i4 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                i15 |= 48;
            } else if ((i3 & 48) != 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i17 = 32;
                } else {
                    i17 = 16;
                }
                i15 |= i17;
            }
            i18 = i15;
            if ((i5 & 306783379) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i22 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i4 & 2) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    }
                    if (i24 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues2;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if ((i4 & 16) != 0) {
                        Arrangement arrangement10 = Arrangement.INSTANCE;
                        float f10 = Dp.constructor-impl(4);
                        companion = Alignment.Companion;
                        if (z3) {
                            bottom = companion.getTop();
                        } else {
                            bottom = companion.getBottom();
                        }
                        vertical3 = arrangement10.spacedBy-D5KLDUw(f10, bottom);
                        i5 &= -57345;
                    } else {
                        vertical3 = vertical2;
                    }
                    if (i8 != 0) {
                        centerHorizontally = Alignment.Companion.getCenterHorizontally();
                    } else {
                        centerHorizontally = horizontal2;
                    }
                    if ((i4 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                        i5 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    }
                    if ((i4 & 256) != 0) {
                        scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                        i5 &= -234881025;
                    } else {
                        scalingParamsScalingParams$default = scalingParams;
                    }
                    if (i12 != 0) {
                        iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                    } else {
                        iM766getItemCenterhvgbs18 = i;
                    }
                    if (i14 != 0) {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                        autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                    } else {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        autoCenteringParams2 = autoCenteringParams;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                    }
                } else {
                    if (i22 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i4 & 2) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    }
                    if (i24 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues2;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if ((i4 & 16) != 0) {
                        Arrangement arrangement11 = Arrangement.INSTANCE;
                        float f11 = Dp.constructor-impl(4);
                        companion = Alignment.Companion;
                        if (z3) {
                            bottom = companion.getTop();
                        } else {
                            bottom = companion.getBottom();
                        }
                        vertical3 = arrangement11.spacedBy-D5KLDUw(f11, bottom);
                        i5 &= -57345;
                    } else {
                        vertical3 = vertical2;
                    }
                    if (i8 != 0) {
                        centerHorizontally = Alignment.Companion.getCenterHorizontally();
                    } else {
                        centerHorizontally = horizontal2;
                    }
                    if ((i4 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                        i5 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    }
                    if ((i4 & 256) != 0) {
                        scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                        i5 &= -234881025;
                    } else {
                        scalingParamsScalingParams$default = scalingParams;
                    }
                    if (i12 != 0) {
                        iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                    } else {
                        iM766getItemCenterhvgbs18 = i;
                    }
                    if (i14 != 0) {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                        autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                    } else {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        autoCenteringParams2 = autoCenteringParams;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                    }
                }
                final boolean z13 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(741207601, i5, i18, "androidx.wear.compose.material.ScalingLazyColumn (ScalingLazyColumn.kt:357)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1150553998, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState<Boolean> mutableState6 = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, true, ComposableLambdaKt.rememberComposableLambda(-334395385, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i26) {
                        BoxWithConstraintsScope boxWithConstraintsScope2;
                        int i27;
                        int i28;
                        int i29;
                        final MutableState<Boolean> mutableState7;
                        Object obj;
                        ComposerKt.sourceInformation(composer3, "C360@18044L7,361@18103L7,*405@20227L7,411@20433L365,427@21182L1228,407@20248L2162:ScalingLazyColumn.kt#gj9v0t");
                        if ((i26 & 6) == 0) {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i27 = i26 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                        } else {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i27 = i26;
                        }
                        if ((i27 & 19) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-334395385, i27, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous> (ScalingLazyColumn.kt:360)");
                            }
                            CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume = composer3.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Density density = (Density) objConsume;
                            CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composer3.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                            int iMo586resolveViewportVerticalOffsetBRTryo0 = scalingParams2.mo586resolveViewportVerticalOffsetBRTryo0(boxWithConstraintsScope2.getConstraints-msEJaDk());
                            PaddingValues paddingValues6 = paddingValues4;
                            boolean z14 = z13;
                            final ScalingLazyListState scalingLazyListState4 = scalingLazyListState2;
                            ScalingParams scalingParams4 = scalingParams2;
                            Arrangement.Vertical vertical6 = vertical4;
                            int i30 = i19;
                            final AutoCenteringParams autoCenteringParams4 = autoCenteringParams2;
                            Alignment.Horizontal horizontal5 = horizontal3;
                            FlingBehavior flingBehavior5 = flingBehavior3;
                            boolean z15 = z5;
                            final Function1<? super ScalingLazyListScope, Unit> function2 = function1;
                            MutableState<Boolean> mutableState8 = mutableState6;
                            float f12 = density.toDp-u2uoSUM(iMo586resolveViewportVerticalOffsetBRTryo0);
                            CombinedPaddingValues combinedPaddingValues = new CombinedPaddingValues(paddingValues6, f12, null);
                            if (z14) {
                                i28 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                            } else {
                                i28 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                            }
                            if (z14) {
                                i29 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                            } else {
                                i29 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                            }
                            int i31 = i29;
                            final ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl = new ScalingLazyListItemScopeImpl(density, ConstraintsKt.offset-NN6Ew-U(boxWithConstraintsScope.getConstraints-msEJaDk(), -((int) density.toPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues6, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues6, layoutDirection)))), -density.roundToPx-0680j_4(Dp.constructor-impl(paddingValues6.calculateTopPadding-D9Ej5fM() + paddingValues6.calculateBottomPadding-D9Ej5fM()))), null);
                            scalingLazyListState4.getScalingParams$compose_material_release().setValue(scalingParams4);
                            scalingLazyListState4.getExtraPaddingPx$compose_material_release().setValue(Integer.valueOf(iMo586resolveViewportVerticalOffsetBRTryo0));
                            scalingLazyListState4.getBeforeContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i28));
                            scalingLazyListState4.getAfterContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i31));
                            scalingLazyListState4.getViewportHeightPx$compose_material_release().setValue(Integer.valueOf(Constraints.getMaxHeight-impl(boxWithConstraintsScope.getConstraints-msEJaDk())));
                            scalingLazyListState4.getGapBetweenItemsPx$compose_material_release().setValue(Integer.valueOf(density.roundToPx-0680j_4(vertical6.getSpacing-D9Ej5fM())));
                            scalingLazyListState4.getAnchorType$compose_material_release().setValue(ScalingLazyListAnchorType.m759boximpl(i30));
                            scalingLazyListState4.getAutoCentering$compose_material_release().setValue(autoCenteringParams4);
                            scalingLazyListState4.getReverseLayout$compose_material_release().setValue(Boolean.valueOf(z14));
                            MutableState<Boolean> localInspectionMode$compose_material_release = scalingLazyListState4.getLocalInspectionMode$compose_material_release();
                            CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composer3.consume(localInspectionMode);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            localInspectionMode$compose_material_release.setValue(objConsume3);
                            Modifier modifierM453verticalNegativePadding3ABfNKs = androidx.wear.compose.foundation.lazy.ScalingLazyColumnKt.m453verticalNegativePadding3ABfNKs(ClipKt.clipToBounds(Modifier.Companion), f12);
                            ComposerKt.sourceInformationMarkerStart(composer3, -2141668261, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                            boolean zChanged = composer3.changed(scalingLazyListState4);
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                mutableState7 = mutableState8;
                                obj = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((LayoutCoordinates) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LayoutCoordinates layoutCoordinates) {
                                        ScalingLazyListLayoutInfo layoutInfo = scalingLazyListState4.getLayoutInfo();
                                        if (!ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState7) && (layoutInfo instanceof DefaultScalingLazyListLayoutInfo) && ((DefaultScalingLazyListLayoutInfo) layoutInfo).getReadyForInitialScroll()) {
                                            ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$2(mutableState7, true);
                                        }
                                    }
                                };
                                composer3.updateRememberedValue(obj);
                            } else {
                                obj = objRememberedValue2;
                                mutableState7 = mutableState8;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM453verticalNegativePadding3ABfNKs, (Function1) obj);
                            LazyListState lazyListState = scalingLazyListState4.getLazyListState();
                            CombinedPaddingValues combinedPaddingValues2 = combinedPaddingValues;
                            ComposerKt.sourceInformationMarkerStart(composer3, -2141643430, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                            boolean zChanged2 = composer3.changed(scalingLazyListState4) | composer3.changed(scalingLazyListItemScopeImpl) | composer3.changed(autoCenteringParams4) | composer3.changed(function2);
                            Object objRememberedValue3 = composer3.rememberedValue();
                            if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                objRememberedValue3 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((LazyListScope) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyListScope lazyListScope) {
                                        ScalingLazyListScopeImpl scalingLazyListScopeImpl = new ScalingLazyListScopeImpl(scalingLazyListState4, lazyListScope, scalingLazyListItemScopeImpl);
                                        if (autoCenteringParams4 != null) {
                                            final ScalingLazyListState scalingLazyListState5 = scalingLazyListState4;
                                            LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1989951676, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.1
                                                {
                                                    super(3);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                    invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                    ComposerKt.sourceInformation(composer4, "C438@21659L213,437@21612L286:ScalingLazyColumn.kt#gj9v0t");
                                                    if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1989951676, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:437)");
                                                        }
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 454359168, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                        boolean zChanged3 = composer4.changed(scalingLazyListState5);
                                                        final ScalingLazyListState scalingLazyListState6 = scalingLazyListState5;
                                                        Object objRememberedValue4 = composer4.rememberedValue();
                                                        if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                            objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$1$1$1
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                public final Integer m752invoke() {
                                                                    return Integer.valueOf(scalingLazyListState6.getTopAutoCenteringItemSizePx$compose_material_release());
                                                                }
                                                            });
                                                            composer4.updateRememberedValue(objRememberedValue4);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), 3, (Object) null);
                                        }
                                        function2.invoke(scalingLazyListScopeImpl);
                                        if (autoCenteringParams4 != null) {
                                            final ScalingLazyListState scalingLazyListState6 = scalingLazyListState4;
                                            LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1331448389, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.2
                                                {
                                                    super(3);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                    invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                    ComposerKt.sourceInformation(composer4, "C450@22114L216,449@22067L289:ScalingLazyColumn.kt#gj9v0t");
                                                    if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1331448389, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:449)");
                                                        }
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 454373731, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                        boolean zChanged3 = composer4.changed(scalingLazyListState6);
                                                        final ScalingLazyListState scalingLazyListState7 = scalingLazyListState6;
                                                        Object objRememberedValue4 = composer4.rememberedValue();
                                                        if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                            objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$2$1$1
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                public final Integer m753invoke() {
                                                                    return Integer.valueOf(scalingLazyListState7.getBottomAutoCenteringItemSizePx$compose_material_release());
                                                                }
                                                            });
                                                            composer4.updateRememberedValue(objRememberedValue4);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), 3, (Object) null);
                                        }
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            LazyDslKt.LazyColumn(modifierOnGloballyPositioned, lazyListState, combinedPaddingValues2, z14, vertical6, horizontal5, flingBehavior5, z15, (Function1) objRememberedValue3, composer3, 0, 0);
                            composer3.startReplaceGroup(-938151751);
                            ComposerKt.sourceInformation(composer3, "460@22480L67,460@22458L89");
                            if (ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState7)) {
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141603055, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged3 = composer3.changed(scalingLazyListState4);
                                ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1 scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = composer3.rememberedValue();
                                if (zChanged3 || scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue == Composer.Companion.getEmpty()) {
                                    scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = new ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1(scalingLazyListState4, null);
                                    composer3.updateRememberedValue(scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                EffectsKt.LaunchedEffect(scalingLazyListState4, (Function2) scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue, composer3, 0);
                            }
                            composer3.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 3456, 2);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                scalingParams3 = scalingParams2;
                paddingValues5 = paddingValues4;
                z6 = z13;
                scalingLazyListState3 = scalingLazyListState2;
                vertical5 = vertical4;
                i20 = i19;
                autoCenteringParams3 = autoCenteringParams2;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i22 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i4 & 2) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    }
                    if (i24 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues2;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if ((i4 & 16) != 0) {
                        Arrangement arrangement12 = Arrangement.INSTANCE;
                        float f12 = Dp.constructor-impl(4);
                        companion = Alignment.Companion;
                        if (z3) {
                            bottom = companion.getTop();
                        } else {
                            bottom = companion.getBottom();
                        }
                        vertical3 = arrangement12.spacedBy-D5KLDUw(f12, bottom);
                        i5 &= -57345;
                    } else {
                        vertical3 = vertical2;
                    }
                    if (i8 != 0) {
                        centerHorizontally = Alignment.Companion.getCenterHorizontally();
                    } else {
                        centerHorizontally = horizontal2;
                    }
                    if ((i4 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                        i5 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    }
                    if ((i4 & 256) != 0) {
                        scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                        i5 &= -234881025;
                    } else {
                        scalingParamsScalingParams$default = scalingParams;
                    }
                    if (i12 != 0) {
                        iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                    } else {
                        iM766getItemCenterhvgbs18 = i;
                    }
                    if (i14 != 0) {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                        autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                    } else {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        autoCenteringParams2 = autoCenteringParams;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                    }
                } else {
                    if (i22 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i4 & 2) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    }
                    if (i24 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues2;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if ((i4 & 16) != 0) {
                        Arrangement arrangement13 = Arrangement.INSTANCE;
                        float f13 = Dp.constructor-impl(4);
                        companion = Alignment.Companion;
                        if (z3) {
                            bottom = companion.getTop();
                        } else {
                            bottom = companion.getBottom();
                        }
                        vertical3 = arrangement13.spacedBy-D5KLDUw(f13, bottom);
                        i5 &= -57345;
                    } else {
                        vertical3 = vertical2;
                    }
                    if (i8 != 0) {
                        centerHorizontally = Alignment.Companion.getCenterHorizontally();
                    } else {
                        centerHorizontally = horizontal2;
                    }
                    if ((i4 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                        i5 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    }
                    if ((i4 & 256) != 0) {
                        scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                        i5 &= -234881025;
                    } else {
                        scalingParamsScalingParams$default = scalingParams;
                    }
                    if (i12 != 0) {
                        iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                    } else {
                        iM766getItemCenterhvgbs18 = i;
                    }
                    if (i14 != 0) {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                        autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                    } else {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        autoCenteringParams2 = autoCenteringParams;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                    }
                }
                final boolean z14 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(741207601, i5, i18, "androidx.wear.compose.material.ScalingLazyColumn (ScalingLazyColumn.kt:357)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1150553998, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState<Boolean> mutableState7 = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, true, ComposableLambdaKt.rememberComposableLambda(-334395385, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i26) {
                        BoxWithConstraintsScope boxWithConstraintsScope2;
                        int i27;
                        int i28;
                        int i29;
                        final MutableState<Boolean> mutableState8;
                        Object obj;
                        ComposerKt.sourceInformation(composer3, "C360@18044L7,361@18103L7,*405@20227L7,411@20433L365,427@21182L1228,407@20248L2162:ScalingLazyColumn.kt#gj9v0t");
                        if ((i26 & 6) == 0) {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i27 = i26 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                        } else {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i27 = i26;
                        }
                        if ((i27 & 19) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-334395385, i27, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous> (ScalingLazyColumn.kt:360)");
                            }
                            CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume = composer3.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Density density = (Density) objConsume;
                            CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composer3.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                            int iMo586resolveViewportVerticalOffsetBRTryo0 = scalingParams2.mo586resolveViewportVerticalOffsetBRTryo0(boxWithConstraintsScope2.getConstraints-msEJaDk());
                            PaddingValues paddingValues6 = paddingValues4;
                            boolean z15 = z14;
                            final ScalingLazyListState scalingLazyListState4 = scalingLazyListState2;
                            ScalingParams scalingParams4 = scalingParams2;
                            Arrangement.Vertical vertical6 = vertical4;
                            int i30 = i19;
                            final AutoCenteringParams autoCenteringParams4 = autoCenteringParams2;
                            Alignment.Horizontal horizontal5 = horizontal3;
                            FlingBehavior flingBehavior5 = flingBehavior3;
                            boolean z16 = z5;
                            final Function1<? super ScalingLazyListScope, Unit> function2 = function1;
                            MutableState<Boolean> mutableState9 = mutableState7;
                            float f14 = density.toDp-u2uoSUM(iMo586resolveViewportVerticalOffsetBRTryo0);
                            CombinedPaddingValues combinedPaddingValues = new CombinedPaddingValues(paddingValues6, f14, null);
                            if (z15) {
                                i28 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                            } else {
                                i28 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                            }
                            if (z15) {
                                i29 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                            } else {
                                i29 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                            }
                            int i31 = i29;
                            final ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl = new ScalingLazyListItemScopeImpl(density, ConstraintsKt.offset-NN6Ew-U(boxWithConstraintsScope.getConstraints-msEJaDk(), -((int) density.toPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues6, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues6, layoutDirection)))), -density.roundToPx-0680j_4(Dp.constructor-impl(paddingValues6.calculateTopPadding-D9Ej5fM() + paddingValues6.calculateBottomPadding-D9Ej5fM()))), null);
                            scalingLazyListState4.getScalingParams$compose_material_release().setValue(scalingParams4);
                            scalingLazyListState4.getExtraPaddingPx$compose_material_release().setValue(Integer.valueOf(iMo586resolveViewportVerticalOffsetBRTryo0));
                            scalingLazyListState4.getBeforeContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i28));
                            scalingLazyListState4.getAfterContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i31));
                            scalingLazyListState4.getViewportHeightPx$compose_material_release().setValue(Integer.valueOf(Constraints.getMaxHeight-impl(boxWithConstraintsScope.getConstraints-msEJaDk())));
                            scalingLazyListState4.getGapBetweenItemsPx$compose_material_release().setValue(Integer.valueOf(density.roundToPx-0680j_4(vertical6.getSpacing-D9Ej5fM())));
                            scalingLazyListState4.getAnchorType$compose_material_release().setValue(ScalingLazyListAnchorType.m759boximpl(i30));
                            scalingLazyListState4.getAutoCentering$compose_material_release().setValue(autoCenteringParams4);
                            scalingLazyListState4.getReverseLayout$compose_material_release().setValue(Boolean.valueOf(z15));
                            MutableState<Boolean> localInspectionMode$compose_material_release = scalingLazyListState4.getLocalInspectionMode$compose_material_release();
                            CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composer3.consume(localInspectionMode);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            localInspectionMode$compose_material_release.setValue(objConsume3);
                            Modifier modifierM453verticalNegativePadding3ABfNKs = androidx.wear.compose.foundation.lazy.ScalingLazyColumnKt.m453verticalNegativePadding3ABfNKs(ClipKt.clipToBounds(Modifier.Companion), f14);
                            ComposerKt.sourceInformationMarkerStart(composer3, -2141668261, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                            boolean zChanged = composer3.changed(scalingLazyListState4);
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                mutableState8 = mutableState9;
                                obj = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((LayoutCoordinates) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LayoutCoordinates layoutCoordinates) {
                                        ScalingLazyListLayoutInfo layoutInfo = scalingLazyListState4.getLayoutInfo();
                                        if (!ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState8) && (layoutInfo instanceof DefaultScalingLazyListLayoutInfo) && ((DefaultScalingLazyListLayoutInfo) layoutInfo).getReadyForInitialScroll()) {
                                            ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$2(mutableState8, true);
                                        }
                                    }
                                };
                                composer3.updateRememberedValue(obj);
                            } else {
                                obj = objRememberedValue2;
                                mutableState8 = mutableState9;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM453verticalNegativePadding3ABfNKs, (Function1) obj);
                            LazyListState lazyListState = scalingLazyListState4.getLazyListState();
                            CombinedPaddingValues combinedPaddingValues2 = combinedPaddingValues;
                            ComposerKt.sourceInformationMarkerStart(composer3, -2141643430, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                            boolean zChanged2 = composer3.changed(scalingLazyListState4) | composer3.changed(scalingLazyListItemScopeImpl) | composer3.changed(autoCenteringParams4) | composer3.changed(function2);
                            Object objRememberedValue3 = composer3.rememberedValue();
                            if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                objRememberedValue3 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((LazyListScope) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyListScope lazyListScope) {
                                        ScalingLazyListScopeImpl scalingLazyListScopeImpl = new ScalingLazyListScopeImpl(scalingLazyListState4, lazyListScope, scalingLazyListItemScopeImpl);
                                        if (autoCenteringParams4 != null) {
                                            final ScalingLazyListState scalingLazyListState5 = scalingLazyListState4;
                                            LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1989951676, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.1
                                                {
                                                    super(3);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                    invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                    ComposerKt.sourceInformation(composer4, "C438@21659L213,437@21612L286:ScalingLazyColumn.kt#gj9v0t");
                                                    if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1989951676, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:437)");
                                                        }
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 454359168, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                        boolean zChanged3 = composer4.changed(scalingLazyListState5);
                                                        final ScalingLazyListState scalingLazyListState6 = scalingLazyListState5;
                                                        Object objRememberedValue4 = composer4.rememberedValue();
                                                        if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                            objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$1$1$1
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                public final Integer m752invoke() {
                                                                    return Integer.valueOf(scalingLazyListState6.getTopAutoCenteringItemSizePx$compose_material_release());
                                                                }
                                                            });
                                                            composer4.updateRememberedValue(objRememberedValue4);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), 3, (Object) null);
                                        }
                                        function2.invoke(scalingLazyListScopeImpl);
                                        if (autoCenteringParams4 != null) {
                                            final ScalingLazyListState scalingLazyListState6 = scalingLazyListState4;
                                            LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1331448389, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.2
                                                {
                                                    super(3);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                    invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                    ComposerKt.sourceInformation(composer4, "C450@22114L216,449@22067L289:ScalingLazyColumn.kt#gj9v0t");
                                                    if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1331448389, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:449)");
                                                        }
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 454373731, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                        boolean zChanged3 = composer4.changed(scalingLazyListState6);
                                                        final ScalingLazyListState scalingLazyListState7 = scalingLazyListState6;
                                                        Object objRememberedValue4 = composer4.rememberedValue();
                                                        if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                            objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$2$1$1
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                public final Integer m753invoke() {
                                                                    return Integer.valueOf(scalingLazyListState7.getBottomAutoCenteringItemSizePx$compose_material_release());
                                                                }
                                                            });
                                                            composer4.updateRememberedValue(objRememberedValue4);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), 3, (Object) null);
                                        }
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            LazyDslKt.LazyColumn(modifierOnGloballyPositioned, lazyListState, combinedPaddingValues2, z15, vertical6, horizontal5, flingBehavior5, z16, (Function1) objRememberedValue3, composer3, 0, 0);
                            composer3.startReplaceGroup(-938151751);
                            ComposerKt.sourceInformation(composer3, "460@22480L67,460@22458L89");
                            if (ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState8)) {
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141603055, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged3 = composer3.changed(scalingLazyListState4);
                                ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1 scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = composer3.rememberedValue();
                                if (zChanged3 || scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue == Composer.Companion.getEmpty()) {
                                    scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = new ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1(scalingLazyListState4, null);
                                    composer3.updateRememberedValue(scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                EffectsKt.LaunchedEffect(scalingLazyListState4, (Function2) scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue, composer3, 0);
                            }
                            composer3.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 3456, 2);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                scalingParams3 = scalingParams2;
                paddingValues5 = paddingValues4;
                z6 = z14;
                scalingLazyListState3 = scalingLazyListState2;
                vertical5 = vertical4;
                i20 = i19;
                autoCenteringParams3 = autoCenteringParams2;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i26) {
                        ScalingLazyColumnKt.m751ScalingLazyColumn8g7MjcI(modifier5, scalingLazyListState3, paddingValues5, z6, vertical5, horizontal4, flingBehavior4, z7, scalingParams3, i20, autoCenteringParams3, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                    }
                });
            }
        }
        i5 |= 384;
        paddingValues2 = paddingValues;
        i6 = i4 & 8;
        if (i6 != 0) {
            if ((i2 & 3072) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i5 |= i7;
            }
            if ((i2 & 24576) == 0) {
                if ((i4 & 16) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i5 |= i25;
                } else {
                    vertical2 = vertical;
                }
                i5 |= i25;
            } else {
                vertical2 = vertical;
            }
            i8 = i4 & 32;
            if (i8 != 0) {
                i5 |= 196608;
                horizontal2 = horizontal;
            } else {
                horizontal2 = horizontal;
                if ((i2 & 196608) == 0) {
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i5 |= i9;
                }
            }
            if ((i2 & 1572864) != 0) {
                if ((i4 & 64) == 0) {
                    i21 = 524288;
                } else {
                    i21 = 524288;
                }
                i5 |= i21;
            }
            i10 = i4 & 128;
            if (i10 != 0) {
                i5 |= 12582912;
                z4 = z2;
            } else {
                z4 = z2;
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z4)) {
                        i11 = 8388608;
                    } else {
                        i11 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i5 |= i11;
                }
            }
            if ((i2 & 100663296) != 0) {
                i5 |= ((i4 & 256) == 0 || !composerStartRestartGroup.changed(scalingParams)) ? 33554432 : 67108864;
            }
            i12 = i4 & 512;
            if (i12 != 0) {
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i13 = 536870912;
                    } else {
                        i13 = 268435456;
                    }
                    i5 |= i13;
                }
                i14 = i4 & UserMetadata.MAX_ATTRIBUTE_SIZE;
                if (i14 != 0) {
                    i15 = i3 | 6;
                } else if ((i3 & 6) == 0) {
                    if (composerStartRestartGroup.changed(autoCenteringParams)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i3 | i16;
                } else {
                    i15 = i3;
                }
                if ((i4 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                    i15 |= 48;
                } else if ((i3 & 48) != 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i17 = 32;
                    } else {
                        i17 = 16;
                    }
                    i15 |= i17;
                }
                i18 = i15;
                if ((i5 & 306783379) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i22 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i4 & 2) != 0) {
                            scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        }
                        if (i24 != 0) {
                            paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                        } else {
                            paddingValues3 = paddingValues2;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if ((i4 & 16) != 0) {
                            Arrangement arrangement14 = Arrangement.INSTANCE;
                            float f14 = Dp.constructor-impl(4);
                            companion = Alignment.Companion;
                            if (z3) {
                                bottom = companion.getTop();
                            } else {
                                bottom = companion.getBottom();
                            }
                            vertical3 = arrangement14.spacedBy-D5KLDUw(f14, bottom);
                            i5 &= -57345;
                        } else {
                            vertical3 = vertical2;
                        }
                        if (i8 != 0) {
                            centerHorizontally = Alignment.Companion.getCenterHorizontally();
                        } else {
                            centerHorizontally = horizontal2;
                        }
                        if ((i4 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                            i5 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        }
                        if ((i4 & 256) != 0) {
                            scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                            i5 &= -234881025;
                        } else {
                            scalingParamsScalingParams$default = scalingParams;
                        }
                        if (i12 != 0) {
                            iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                        } else {
                            iM766getItemCenterhvgbs18 = i;
                        }
                        if (i14 != 0) {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                            autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                        } else {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            autoCenteringParams2 = autoCenteringParams;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                        }
                    } else {
                        if (i22 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i4 & 2) != 0) {
                            scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        }
                        if (i24 != 0) {
                            paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                        } else {
                            paddingValues3 = paddingValues2;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if ((i4 & 16) != 0) {
                            Arrangement arrangement15 = Arrangement.INSTANCE;
                            float f15 = Dp.constructor-impl(4);
                            companion = Alignment.Companion;
                            if (z3) {
                                bottom = companion.getTop();
                            } else {
                                bottom = companion.getBottom();
                            }
                            vertical3 = arrangement15.spacedBy-D5KLDUw(f15, bottom);
                            i5 &= -57345;
                        } else {
                            vertical3 = vertical2;
                        }
                        if (i8 != 0) {
                            centerHorizontally = Alignment.Companion.getCenterHorizontally();
                        } else {
                            centerHorizontally = horizontal2;
                        }
                        if ((i4 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                            i5 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        }
                        if ((i4 & 256) != 0) {
                            scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                            i5 &= -234881025;
                        } else {
                            scalingParamsScalingParams$default = scalingParams;
                        }
                        if (i12 != 0) {
                            iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                        } else {
                            iM766getItemCenterhvgbs18 = i;
                        }
                        if (i14 != 0) {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                            autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                        } else {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            autoCenteringParams2 = autoCenteringParams;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                        }
                    }
                    final boolean z15 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(741207601, i5, i18, "androidx.wear.compose.material.ScalingLazyColumn (ScalingLazyColumn.kt:357)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1150553998, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final MutableState<Boolean> mutableState8 = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, true, ComposableLambdaKt.rememberComposableLambda(-334395385, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i26) {
                            BoxWithConstraintsScope boxWithConstraintsScope2;
                            int i27;
                            int i28;
                            int i29;
                            final MutableState<Boolean> mutableState9;
                            Object obj;
                            ComposerKt.sourceInformation(composer3, "C360@18044L7,361@18103L7,*405@20227L7,411@20433L365,427@21182L1228,407@20248L2162:ScalingLazyColumn.kt#gj9v0t");
                            if ((i26 & 6) == 0) {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i27 = i26 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                            } else {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i27 = i26;
                            }
                            if ((i27 & 19) != 18 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-334395385, i27, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous> (ScalingLazyColumn.kt:360)");
                                }
                                CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume = composer3.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Density density = (Density) objConsume;
                                CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composer3.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                int iMo586resolveViewportVerticalOffsetBRTryo0 = scalingParams2.mo586resolveViewportVerticalOffsetBRTryo0(boxWithConstraintsScope2.getConstraints-msEJaDk());
                                PaddingValues paddingValues6 = paddingValues4;
                                boolean z16 = z15;
                                final ScalingLazyListState scalingLazyListState4 = scalingLazyListState2;
                                ScalingParams scalingParams4 = scalingParams2;
                                Arrangement.Vertical vertical6 = vertical4;
                                int i30 = i19;
                                final AutoCenteringParams autoCenteringParams4 = autoCenteringParams2;
                                Alignment.Horizontal horizontal5 = horizontal3;
                                FlingBehavior flingBehavior5 = flingBehavior3;
                                boolean z17 = z5;
                                final Function1<? super ScalingLazyListScope, Unit> function2 = function1;
                                MutableState<Boolean> mutableState10 = mutableState8;
                                float f16 = density.toDp-u2uoSUM(iMo586resolveViewportVerticalOffsetBRTryo0);
                                CombinedPaddingValues combinedPaddingValues = new CombinedPaddingValues(paddingValues6, f16, null);
                                if (z16) {
                                    i28 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                                } else {
                                    i28 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                                }
                                if (z16) {
                                    i29 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                                } else {
                                    i29 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                                }
                                int i31 = i29;
                                final ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl = new ScalingLazyListItemScopeImpl(density, ConstraintsKt.offset-NN6Ew-U(boxWithConstraintsScope.getConstraints-msEJaDk(), -((int) density.toPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues6, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues6, layoutDirection)))), -density.roundToPx-0680j_4(Dp.constructor-impl(paddingValues6.calculateTopPadding-D9Ej5fM() + paddingValues6.calculateBottomPadding-D9Ej5fM()))), null);
                                scalingLazyListState4.getScalingParams$compose_material_release().setValue(scalingParams4);
                                scalingLazyListState4.getExtraPaddingPx$compose_material_release().setValue(Integer.valueOf(iMo586resolveViewportVerticalOffsetBRTryo0));
                                scalingLazyListState4.getBeforeContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i28));
                                scalingLazyListState4.getAfterContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i31));
                                scalingLazyListState4.getViewportHeightPx$compose_material_release().setValue(Integer.valueOf(Constraints.getMaxHeight-impl(boxWithConstraintsScope.getConstraints-msEJaDk())));
                                scalingLazyListState4.getGapBetweenItemsPx$compose_material_release().setValue(Integer.valueOf(density.roundToPx-0680j_4(vertical6.getSpacing-D9Ej5fM())));
                                scalingLazyListState4.getAnchorType$compose_material_release().setValue(ScalingLazyListAnchorType.m759boximpl(i30));
                                scalingLazyListState4.getAutoCentering$compose_material_release().setValue(autoCenteringParams4);
                                scalingLazyListState4.getReverseLayout$compose_material_release().setValue(Boolean.valueOf(z16));
                                MutableState<Boolean> localInspectionMode$compose_material_release = scalingLazyListState4.getLocalInspectionMode$compose_material_release();
                                CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composer3.consume(localInspectionMode);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                localInspectionMode$compose_material_release.setValue(objConsume3);
                                Modifier modifierM453verticalNegativePadding3ABfNKs = androidx.wear.compose.foundation.lazy.ScalingLazyColumnKt.m453verticalNegativePadding3ABfNKs(ClipKt.clipToBounds(Modifier.Companion), f16);
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141668261, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged = composer3.changed(scalingLazyListState4);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                    mutableState9 = mutableState10;
                                    obj = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                            invoke((LayoutCoordinates) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LayoutCoordinates layoutCoordinates) {
                                            ScalingLazyListLayoutInfo layoutInfo = scalingLazyListState4.getLayoutInfo();
                                            if (!ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState9) && (layoutInfo instanceof DefaultScalingLazyListLayoutInfo) && ((DefaultScalingLazyListLayoutInfo) layoutInfo).getReadyForInitialScroll()) {
                                                ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$2(mutableState9, true);
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(obj);
                                } else {
                                    obj = objRememberedValue2;
                                    mutableState9 = mutableState10;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM453verticalNegativePadding3ABfNKs, (Function1) obj);
                                LazyListState lazyListState = scalingLazyListState4.getLazyListState();
                                CombinedPaddingValues combinedPaddingValues2 = combinedPaddingValues;
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141643430, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged2 = composer3.changed(scalingLazyListState4) | composer3.changed(scalingLazyListItemScopeImpl) | composer3.changed(autoCenteringParams4) | composer3.changed(function2);
                                Object objRememberedValue3 = composer3.rememberedValue();
                                if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                    objRememberedValue3 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                            invoke((LazyListScope) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyListScope lazyListScope) {
                                            ScalingLazyListScopeImpl scalingLazyListScopeImpl = new ScalingLazyListScopeImpl(scalingLazyListState4, lazyListScope, scalingLazyListItemScopeImpl);
                                            if (autoCenteringParams4 != null) {
                                                final ScalingLazyListState scalingLazyListState5 = scalingLazyListState4;
                                                LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1989951676, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.1
                                                    {
                                                        super(3);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                        invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                        ComposerKt.sourceInformation(composer4, "C438@21659L213,437@21612L286:ScalingLazyColumn.kt#gj9v0t");
                                                        if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1989951676, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:437)");
                                                            }
                                                            ComposerKt.sourceInformationMarkerStart(composer4, 454359168, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                            boolean zChanged3 = composer4.changed(scalingLazyListState5);
                                                            final ScalingLazyListState scalingLazyListState6 = scalingLazyListState5;
                                                            Object objRememberedValue4 = composer4.rememberedValue();
                                                            if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                                objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$1$1$1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                    public final Integer m752invoke() {
                                                                        return Integer.valueOf(scalingLazyListState6.getTopAutoCenteringItemSizePx$compose_material_release());
                                                                    }
                                                                });
                                                                composer4.updateRememberedValue(objRememberedValue4);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                                            SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), 3, (Object) null);
                                            }
                                            function2.invoke(scalingLazyListScopeImpl);
                                            if (autoCenteringParams4 != null) {
                                                final ScalingLazyListState scalingLazyListState6 = scalingLazyListState4;
                                                LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1331448389, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.2
                                                    {
                                                        super(3);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                        invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                        ComposerKt.sourceInformation(composer4, "C450@22114L216,449@22067L289:ScalingLazyColumn.kt#gj9v0t");
                                                        if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1331448389, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:449)");
                                                            }
                                                            ComposerKt.sourceInformationMarkerStart(composer4, 454373731, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                            boolean zChanged3 = composer4.changed(scalingLazyListState6);
                                                            final ScalingLazyListState scalingLazyListState7 = scalingLazyListState6;
                                                            Object objRememberedValue4 = composer4.rememberedValue();
                                                            if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                                objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$2$1$1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                    public final Integer m753invoke() {
                                                                        return Integer.valueOf(scalingLazyListState7.getBottomAutoCenteringItemSizePx$compose_material_release());
                                                                    }
                                                                });
                                                                composer4.updateRememberedValue(objRememberedValue4);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                                            SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), 3, (Object) null);
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                LazyDslKt.LazyColumn(modifierOnGloballyPositioned, lazyListState, combinedPaddingValues2, z16, vertical6, horizontal5, flingBehavior5, z17, (Function1) objRememberedValue3, composer3, 0, 0);
                                composer3.startReplaceGroup(-938151751);
                                ComposerKt.sourceInformation(composer3, "460@22480L67,460@22458L89");
                                if (ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState9)) {
                                    ComposerKt.sourceInformationMarkerStart(composer3, -2141603055, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                    boolean zChanged3 = composer3.changed(scalingLazyListState4);
                                    ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1 scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = composer3.rememberedValue();
                                    if (zChanged3 || scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue == Composer.Companion.getEmpty()) {
                                        scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = new ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1(scalingLazyListState4, null);
                                        composer3.updateRememberedValue(scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    EffectsKt.LaunchedEffect(scalingLazyListState4, (Function2) scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue, composer3, 0);
                                }
                                composer3.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 3456, 2);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    scalingParams3 = scalingParams2;
                    paddingValues5 = paddingValues4;
                    z6 = z15;
                    scalingLazyListState3 = scalingLazyListState2;
                    vertical5 = vertical4;
                    i20 = i19;
                    autoCenteringParams3 = autoCenteringParams2;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i22 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i4 & 2) != 0) {
                            scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        }
                        if (i24 != 0) {
                            paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                        } else {
                            paddingValues3 = paddingValues2;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if ((i4 & 16) != 0) {
                            Arrangement arrangement16 = Arrangement.INSTANCE;
                            float f16 = Dp.constructor-impl(4);
                            companion = Alignment.Companion;
                            if (z3) {
                                bottom = companion.getTop();
                            } else {
                                bottom = companion.getBottom();
                            }
                            vertical3 = arrangement16.spacedBy-D5KLDUw(f16, bottom);
                            i5 &= -57345;
                        } else {
                            vertical3 = vertical2;
                        }
                        if (i8 != 0) {
                            centerHorizontally = Alignment.Companion.getCenterHorizontally();
                        } else {
                            centerHorizontally = horizontal2;
                        }
                        if ((i4 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                            i5 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        }
                        if ((i4 & 256) != 0) {
                            scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                            i5 &= -234881025;
                        } else {
                            scalingParamsScalingParams$default = scalingParams;
                        }
                        if (i12 != 0) {
                            iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                        } else {
                            iM766getItemCenterhvgbs18 = i;
                        }
                        if (i14 != 0) {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                            autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                        } else {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            autoCenteringParams2 = autoCenteringParams;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                        }
                    } else {
                        if (i22 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i4 & 2) != 0) {
                            scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        }
                        if (i24 != 0) {
                            paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                        } else {
                            paddingValues3 = paddingValues2;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if ((i4 & 16) != 0) {
                            Arrangement arrangement17 = Arrangement.INSTANCE;
                            float f17 = Dp.constructor-impl(4);
                            companion = Alignment.Companion;
                            if (z3) {
                                bottom = companion.getTop();
                            } else {
                                bottom = companion.getBottom();
                            }
                            vertical3 = arrangement17.spacedBy-D5KLDUw(f17, bottom);
                            i5 &= -57345;
                        } else {
                            vertical3 = vertical2;
                        }
                        if (i8 != 0) {
                            centerHorizontally = Alignment.Companion.getCenterHorizontally();
                        } else {
                            centerHorizontally = horizontal2;
                        }
                        if ((i4 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                            i5 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        }
                        if ((i4 & 256) != 0) {
                            scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                            i5 &= -234881025;
                        } else {
                            scalingParamsScalingParams$default = scalingParams;
                        }
                        if (i12 != 0) {
                            iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                        } else {
                            iM766getItemCenterhvgbs18 = i;
                        }
                        if (i14 != 0) {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                            autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                        } else {
                            modifier4 = modifier3;
                            vertical4 = vertical3;
                            z5 = z4;
                            autoCenteringParams2 = autoCenteringParams;
                            paddingValues4 = paddingValues3;
                            scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                            horizontal3 = centerHorizontally;
                            flingBehavior3 = flingBehavior2;
                            scalingParams2 = scalingParamsScalingParams$default;
                            i19 = iM766getItemCenterhvgbs18;
                        }
                    }
                    final boolean z16 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(741207601, i5, i18, "androidx.wear.compose.material.ScalingLazyColumn (ScalingLazyColumn.kt:357)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1150553998, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final MutableState<Boolean> mutableState9 = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, true, ComposableLambdaKt.rememberComposableLambda(-334395385, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i26) {
                            BoxWithConstraintsScope boxWithConstraintsScope2;
                            int i27;
                            int i28;
                            int i29;
                            final MutableState<Boolean> mutableState10;
                            Object obj;
                            ComposerKt.sourceInformation(composer3, "C360@18044L7,361@18103L7,*405@20227L7,411@20433L365,427@21182L1228,407@20248L2162:ScalingLazyColumn.kt#gj9v0t");
                            if ((i26 & 6) == 0) {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i27 = i26 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                            } else {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i27 = i26;
                            }
                            if ((i27 & 19) != 18 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-334395385, i27, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous> (ScalingLazyColumn.kt:360)");
                                }
                                CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume = composer3.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Density density = (Density) objConsume;
                                CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composer3.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                int iMo586resolveViewportVerticalOffsetBRTryo0 = scalingParams2.mo586resolveViewportVerticalOffsetBRTryo0(boxWithConstraintsScope2.getConstraints-msEJaDk());
                                PaddingValues paddingValues6 = paddingValues4;
                                boolean z17 = z16;
                                final ScalingLazyListState scalingLazyListState4 = scalingLazyListState2;
                                ScalingParams scalingParams4 = scalingParams2;
                                Arrangement.Vertical vertical6 = vertical4;
                                int i30 = i19;
                                final AutoCenteringParams autoCenteringParams4 = autoCenteringParams2;
                                Alignment.Horizontal horizontal5 = horizontal3;
                                FlingBehavior flingBehavior5 = flingBehavior3;
                                boolean z18 = z5;
                                final Function1<? super ScalingLazyListScope, Unit> function2 = function1;
                                MutableState<Boolean> mutableState11 = mutableState9;
                                float f18 = density.toDp-u2uoSUM(iMo586resolveViewportVerticalOffsetBRTryo0);
                                CombinedPaddingValues combinedPaddingValues = new CombinedPaddingValues(paddingValues6, f18, null);
                                if (z17) {
                                    i28 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                                } else {
                                    i28 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                                }
                                if (z17) {
                                    i29 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                                } else {
                                    i29 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                                }
                                int i31 = i29;
                                final ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl = new ScalingLazyListItemScopeImpl(density, ConstraintsKt.offset-NN6Ew-U(boxWithConstraintsScope.getConstraints-msEJaDk(), -((int) density.toPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues6, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues6, layoutDirection)))), -density.roundToPx-0680j_4(Dp.constructor-impl(paddingValues6.calculateTopPadding-D9Ej5fM() + paddingValues6.calculateBottomPadding-D9Ej5fM()))), null);
                                scalingLazyListState4.getScalingParams$compose_material_release().setValue(scalingParams4);
                                scalingLazyListState4.getExtraPaddingPx$compose_material_release().setValue(Integer.valueOf(iMo586resolveViewportVerticalOffsetBRTryo0));
                                scalingLazyListState4.getBeforeContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i28));
                                scalingLazyListState4.getAfterContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i31));
                                scalingLazyListState4.getViewportHeightPx$compose_material_release().setValue(Integer.valueOf(Constraints.getMaxHeight-impl(boxWithConstraintsScope.getConstraints-msEJaDk())));
                                scalingLazyListState4.getGapBetweenItemsPx$compose_material_release().setValue(Integer.valueOf(density.roundToPx-0680j_4(vertical6.getSpacing-D9Ej5fM())));
                                scalingLazyListState4.getAnchorType$compose_material_release().setValue(ScalingLazyListAnchorType.m759boximpl(i30));
                                scalingLazyListState4.getAutoCentering$compose_material_release().setValue(autoCenteringParams4);
                                scalingLazyListState4.getReverseLayout$compose_material_release().setValue(Boolean.valueOf(z17));
                                MutableState<Boolean> localInspectionMode$compose_material_release = scalingLazyListState4.getLocalInspectionMode$compose_material_release();
                                CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composer3.consume(localInspectionMode);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                localInspectionMode$compose_material_release.setValue(objConsume3);
                                Modifier modifierM453verticalNegativePadding3ABfNKs = androidx.wear.compose.foundation.lazy.ScalingLazyColumnKt.m453verticalNegativePadding3ABfNKs(ClipKt.clipToBounds(Modifier.Companion), f18);
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141668261, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged = composer3.changed(scalingLazyListState4);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                    mutableState10 = mutableState11;
                                    obj = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                            invoke((LayoutCoordinates) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LayoutCoordinates layoutCoordinates) {
                                            ScalingLazyListLayoutInfo layoutInfo = scalingLazyListState4.getLayoutInfo();
                                            if (!ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState10) && (layoutInfo instanceof DefaultScalingLazyListLayoutInfo) && ((DefaultScalingLazyListLayoutInfo) layoutInfo).getReadyForInitialScroll()) {
                                                ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$2(mutableState10, true);
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(obj);
                                } else {
                                    obj = objRememberedValue2;
                                    mutableState10 = mutableState11;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM453verticalNegativePadding3ABfNKs, (Function1) obj);
                                LazyListState lazyListState = scalingLazyListState4.getLazyListState();
                                CombinedPaddingValues combinedPaddingValues2 = combinedPaddingValues;
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141643430, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged2 = composer3.changed(scalingLazyListState4) | composer3.changed(scalingLazyListItemScopeImpl) | composer3.changed(autoCenteringParams4) | composer3.changed(function2);
                                Object objRememberedValue3 = composer3.rememberedValue();
                                if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                    objRememberedValue3 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                            invoke((LazyListScope) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyListScope lazyListScope) {
                                            ScalingLazyListScopeImpl scalingLazyListScopeImpl = new ScalingLazyListScopeImpl(scalingLazyListState4, lazyListScope, scalingLazyListItemScopeImpl);
                                            if (autoCenteringParams4 != null) {
                                                final ScalingLazyListState scalingLazyListState5 = scalingLazyListState4;
                                                LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1989951676, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.1
                                                    {
                                                        super(3);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                        invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                        ComposerKt.sourceInformation(composer4, "C438@21659L213,437@21612L286:ScalingLazyColumn.kt#gj9v0t");
                                                        if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1989951676, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:437)");
                                                            }
                                                            ComposerKt.sourceInformationMarkerStart(composer4, 454359168, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                            boolean zChanged3 = composer4.changed(scalingLazyListState5);
                                                            final ScalingLazyListState scalingLazyListState6 = scalingLazyListState5;
                                                            Object objRememberedValue4 = composer4.rememberedValue();
                                                            if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                                objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$1$1$1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                    public final Integer m752invoke() {
                                                                        return Integer.valueOf(scalingLazyListState6.getTopAutoCenteringItemSizePx$compose_material_release());
                                                                    }
                                                                });
                                                                composer4.updateRememberedValue(objRememberedValue4);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                                            SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), 3, (Object) null);
                                            }
                                            function2.invoke(scalingLazyListScopeImpl);
                                            if (autoCenteringParams4 != null) {
                                                final ScalingLazyListState scalingLazyListState6 = scalingLazyListState4;
                                                LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1331448389, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.2
                                                    {
                                                        super(3);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                        invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                        ComposerKt.sourceInformation(composer4, "C450@22114L216,449@22067L289:ScalingLazyColumn.kt#gj9v0t");
                                                        if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1331448389, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:449)");
                                                            }
                                                            ComposerKt.sourceInformationMarkerStart(composer4, 454373731, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                            boolean zChanged3 = composer4.changed(scalingLazyListState6);
                                                            final ScalingLazyListState scalingLazyListState7 = scalingLazyListState6;
                                                            Object objRememberedValue4 = composer4.rememberedValue();
                                                            if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                                objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$2$1$1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                    public final Integer m753invoke() {
                                                                        return Integer.valueOf(scalingLazyListState7.getBottomAutoCenteringItemSizePx$compose_material_release());
                                                                    }
                                                                });
                                                                composer4.updateRememberedValue(objRememberedValue4);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                                            SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), 3, (Object) null);
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                LazyDslKt.LazyColumn(modifierOnGloballyPositioned, lazyListState, combinedPaddingValues2, z17, vertical6, horizontal5, flingBehavior5, z18, (Function1) objRememberedValue3, composer3, 0, 0);
                                composer3.startReplaceGroup(-938151751);
                                ComposerKt.sourceInformation(composer3, "460@22480L67,460@22458L89");
                                if (ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState10)) {
                                    ComposerKt.sourceInformationMarkerStart(composer3, -2141603055, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                    boolean zChanged3 = composer3.changed(scalingLazyListState4);
                                    ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1 scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = composer3.rememberedValue();
                                    if (zChanged3 || scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue == Composer.Companion.getEmpty()) {
                                        scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = new ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1(scalingLazyListState4, null);
                                        composer3.updateRememberedValue(scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    EffectsKt.LaunchedEffect(scalingLazyListState4, (Function2) scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue, composer3, 0);
                                }
                                composer3.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 3456, 2);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    scalingParams3 = scalingParams2;
                    paddingValues5 = paddingValues4;
                    z6 = z16;
                    scalingLazyListState3 = scalingLazyListState2;
                    vertical5 = vertical4;
                    i20 = i19;
                    autoCenteringParams3 = autoCenteringParams2;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i26) {
                            ScalingLazyColumnKt.m751ScalingLazyColumn8g7MjcI(modifier5, scalingLazyListState3, paddingValues5, z6, vertical5, horizontal4, flingBehavior4, z7, scalingParams3, i20, autoCenteringParams3, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                        }
                    });
                }
            }
            i5 |= 805306368;
            i14 = i4 & UserMetadata.MAX_ATTRIBUTE_SIZE;
            if (i14 != 0) {
                i15 = i3 | 6;
            } else if ((i3 & 6) == 0) {
                if (composerStartRestartGroup.changed(autoCenteringParams)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i3 | i16;
            } else {
                i15 = i3;
            }
            if ((i4 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                i15 |= 48;
            } else if ((i3 & 48) != 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i17 = 32;
                } else {
                    i17 = 16;
                }
                i15 |= i17;
            }
            i18 = i15;
            if ((i5 & 306783379) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i22 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i4 & 2) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    }
                    if (i24 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues2;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if ((i4 & 16) != 0) {
                        Arrangement arrangement18 = Arrangement.INSTANCE;
                        float f18 = Dp.constructor-impl(4);
                        companion = Alignment.Companion;
                        if (z3) {
                            bottom = companion.getTop();
                        } else {
                            bottom = companion.getBottom();
                        }
                        vertical3 = arrangement18.spacedBy-D5KLDUw(f18, bottom);
                        i5 &= -57345;
                    } else {
                        vertical3 = vertical2;
                    }
                    if (i8 != 0) {
                        centerHorizontally = Alignment.Companion.getCenterHorizontally();
                    } else {
                        centerHorizontally = horizontal2;
                    }
                    if ((i4 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                        i5 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    }
                    if ((i4 & 256) != 0) {
                        scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                        i5 &= -234881025;
                    } else {
                        scalingParamsScalingParams$default = scalingParams;
                    }
                    if (i12 != 0) {
                        iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                    } else {
                        iM766getItemCenterhvgbs18 = i;
                    }
                    if (i14 != 0) {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                        autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                    } else {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        autoCenteringParams2 = autoCenteringParams;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                    }
                } else {
                    if (i22 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i4 & 2) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    }
                    if (i24 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues2;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if ((i4 & 16) != 0) {
                        Arrangement arrangement19 = Arrangement.INSTANCE;
                        float f19 = Dp.constructor-impl(4);
                        companion = Alignment.Companion;
                        if (z3) {
                            bottom = companion.getTop();
                        } else {
                            bottom = companion.getBottom();
                        }
                        vertical3 = arrangement19.spacedBy-D5KLDUw(f19, bottom);
                        i5 &= -57345;
                    } else {
                        vertical3 = vertical2;
                    }
                    if (i8 != 0) {
                        centerHorizontally = Alignment.Companion.getCenterHorizontally();
                    } else {
                        centerHorizontally = horizontal2;
                    }
                    if ((i4 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                        i5 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    }
                    if ((i4 & 256) != 0) {
                        scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                        i5 &= -234881025;
                    } else {
                        scalingParamsScalingParams$default = scalingParams;
                    }
                    if (i12 != 0) {
                        iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                    } else {
                        iM766getItemCenterhvgbs18 = i;
                    }
                    if (i14 != 0) {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                        autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                    } else {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        autoCenteringParams2 = autoCenteringParams;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                    }
                }
                final boolean z17 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(741207601, i5, i18, "androidx.wear.compose.material.ScalingLazyColumn (ScalingLazyColumn.kt:357)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1150553998, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState<Boolean> mutableState10 = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, true, ComposableLambdaKt.rememberComposableLambda(-334395385, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i26) {
                        BoxWithConstraintsScope boxWithConstraintsScope2;
                        int i27;
                        int i28;
                        int i29;
                        final MutableState<Boolean> mutableState11;
                        Object obj;
                        ComposerKt.sourceInformation(composer3, "C360@18044L7,361@18103L7,*405@20227L7,411@20433L365,427@21182L1228,407@20248L2162:ScalingLazyColumn.kt#gj9v0t");
                        if ((i26 & 6) == 0) {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i27 = i26 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                        } else {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i27 = i26;
                        }
                        if ((i27 & 19) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-334395385, i27, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous> (ScalingLazyColumn.kt:360)");
                            }
                            CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume = composer3.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Density density = (Density) objConsume;
                            CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composer3.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                            int iMo586resolveViewportVerticalOffsetBRTryo0 = scalingParams2.mo586resolveViewportVerticalOffsetBRTryo0(boxWithConstraintsScope2.getConstraints-msEJaDk());
                            PaddingValues paddingValues6 = paddingValues4;
                            boolean z18 = z17;
                            final ScalingLazyListState scalingLazyListState4 = scalingLazyListState2;
                            ScalingParams scalingParams4 = scalingParams2;
                            Arrangement.Vertical vertical6 = vertical4;
                            int i30 = i19;
                            final AutoCenteringParams autoCenteringParams4 = autoCenteringParams2;
                            Alignment.Horizontal horizontal5 = horizontal3;
                            FlingBehavior flingBehavior5 = flingBehavior3;
                            boolean z19 = z5;
                            final Function1<? super ScalingLazyListScope, Unit> function2 = function1;
                            MutableState<Boolean> mutableState12 = mutableState10;
                            float f110 = density.toDp-u2uoSUM(iMo586resolveViewportVerticalOffsetBRTryo0);
                            CombinedPaddingValues combinedPaddingValues = new CombinedPaddingValues(paddingValues6, f110, null);
                            if (z18) {
                                i28 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                            } else {
                                i28 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                            }
                            if (z18) {
                                i29 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                            } else {
                                i29 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                            }
                            int i31 = i29;
                            final ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl = new ScalingLazyListItemScopeImpl(density, ConstraintsKt.offset-NN6Ew-U(boxWithConstraintsScope.getConstraints-msEJaDk(), -((int) density.toPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues6, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues6, layoutDirection)))), -density.roundToPx-0680j_4(Dp.constructor-impl(paddingValues6.calculateTopPadding-D9Ej5fM() + paddingValues6.calculateBottomPadding-D9Ej5fM()))), null);
                            scalingLazyListState4.getScalingParams$compose_material_release().setValue(scalingParams4);
                            scalingLazyListState4.getExtraPaddingPx$compose_material_release().setValue(Integer.valueOf(iMo586resolveViewportVerticalOffsetBRTryo0));
                            scalingLazyListState4.getBeforeContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i28));
                            scalingLazyListState4.getAfterContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i31));
                            scalingLazyListState4.getViewportHeightPx$compose_material_release().setValue(Integer.valueOf(Constraints.getMaxHeight-impl(boxWithConstraintsScope.getConstraints-msEJaDk())));
                            scalingLazyListState4.getGapBetweenItemsPx$compose_material_release().setValue(Integer.valueOf(density.roundToPx-0680j_4(vertical6.getSpacing-D9Ej5fM())));
                            scalingLazyListState4.getAnchorType$compose_material_release().setValue(ScalingLazyListAnchorType.m759boximpl(i30));
                            scalingLazyListState4.getAutoCentering$compose_material_release().setValue(autoCenteringParams4);
                            scalingLazyListState4.getReverseLayout$compose_material_release().setValue(Boolean.valueOf(z18));
                            MutableState<Boolean> localInspectionMode$compose_material_release = scalingLazyListState4.getLocalInspectionMode$compose_material_release();
                            CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composer3.consume(localInspectionMode);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            localInspectionMode$compose_material_release.setValue(objConsume3);
                            Modifier modifierM453verticalNegativePadding3ABfNKs = androidx.wear.compose.foundation.lazy.ScalingLazyColumnKt.m453verticalNegativePadding3ABfNKs(ClipKt.clipToBounds(Modifier.Companion), f110);
                            ComposerKt.sourceInformationMarkerStart(composer3, -2141668261, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                            boolean zChanged = composer3.changed(scalingLazyListState4);
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                mutableState11 = mutableState12;
                                obj = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((LayoutCoordinates) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LayoutCoordinates layoutCoordinates) {
                                        ScalingLazyListLayoutInfo layoutInfo = scalingLazyListState4.getLayoutInfo();
                                        if (!ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState11) && (layoutInfo instanceof DefaultScalingLazyListLayoutInfo) && ((DefaultScalingLazyListLayoutInfo) layoutInfo).getReadyForInitialScroll()) {
                                            ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$2(mutableState11, true);
                                        }
                                    }
                                };
                                composer3.updateRememberedValue(obj);
                            } else {
                                obj = objRememberedValue2;
                                mutableState11 = mutableState12;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM453verticalNegativePadding3ABfNKs, (Function1) obj);
                            LazyListState lazyListState = scalingLazyListState4.getLazyListState();
                            CombinedPaddingValues combinedPaddingValues2 = combinedPaddingValues;
                            ComposerKt.sourceInformationMarkerStart(composer3, -2141643430, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                            boolean zChanged2 = composer3.changed(scalingLazyListState4) | composer3.changed(scalingLazyListItemScopeImpl) | composer3.changed(autoCenteringParams4) | composer3.changed(function2);
                            Object objRememberedValue3 = composer3.rememberedValue();
                            if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                objRememberedValue3 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((LazyListScope) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyListScope lazyListScope) {
                                        ScalingLazyListScopeImpl scalingLazyListScopeImpl = new ScalingLazyListScopeImpl(scalingLazyListState4, lazyListScope, scalingLazyListItemScopeImpl);
                                        if (autoCenteringParams4 != null) {
                                            final ScalingLazyListState scalingLazyListState5 = scalingLazyListState4;
                                            LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1989951676, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.1
                                                {
                                                    super(3);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                    invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                    ComposerKt.sourceInformation(composer4, "C438@21659L213,437@21612L286:ScalingLazyColumn.kt#gj9v0t");
                                                    if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1989951676, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:437)");
                                                        }
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 454359168, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                        boolean zChanged3 = composer4.changed(scalingLazyListState5);
                                                        final ScalingLazyListState scalingLazyListState6 = scalingLazyListState5;
                                                        Object objRememberedValue4 = composer4.rememberedValue();
                                                        if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                            objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$1$1$1
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                public final Integer m752invoke() {
                                                                    return Integer.valueOf(scalingLazyListState6.getTopAutoCenteringItemSizePx$compose_material_release());
                                                                }
                                                            });
                                                            composer4.updateRememberedValue(objRememberedValue4);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), 3, (Object) null);
                                        }
                                        function2.invoke(scalingLazyListScopeImpl);
                                        if (autoCenteringParams4 != null) {
                                            final ScalingLazyListState scalingLazyListState6 = scalingLazyListState4;
                                            LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1331448389, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.2
                                                {
                                                    super(3);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                    invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                    ComposerKt.sourceInformation(composer4, "C450@22114L216,449@22067L289:ScalingLazyColumn.kt#gj9v0t");
                                                    if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1331448389, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:449)");
                                                        }
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 454373731, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                        boolean zChanged3 = composer4.changed(scalingLazyListState6);
                                                        final ScalingLazyListState scalingLazyListState7 = scalingLazyListState6;
                                                        Object objRememberedValue4 = composer4.rememberedValue();
                                                        if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                            objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$2$1$1
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                public final Integer m753invoke() {
                                                                    return Integer.valueOf(scalingLazyListState7.getBottomAutoCenteringItemSizePx$compose_material_release());
                                                                }
                                                            });
                                                            composer4.updateRememberedValue(objRememberedValue4);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), 3, (Object) null);
                                        }
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            LazyDslKt.LazyColumn(modifierOnGloballyPositioned, lazyListState, combinedPaddingValues2, z18, vertical6, horizontal5, flingBehavior5, z19, (Function1) objRememberedValue3, composer3, 0, 0);
                            composer3.startReplaceGroup(-938151751);
                            ComposerKt.sourceInformation(composer3, "460@22480L67,460@22458L89");
                            if (ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState11)) {
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141603055, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged3 = composer3.changed(scalingLazyListState4);
                                ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1 scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = composer3.rememberedValue();
                                if (zChanged3 || scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue == Composer.Companion.getEmpty()) {
                                    scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = new ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1(scalingLazyListState4, null);
                                    composer3.updateRememberedValue(scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                EffectsKt.LaunchedEffect(scalingLazyListState4, (Function2) scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue, composer3, 0);
                            }
                            composer3.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 3456, 2);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                scalingParams3 = scalingParams2;
                paddingValues5 = paddingValues4;
                z6 = z17;
                scalingLazyListState3 = scalingLazyListState2;
                vertical5 = vertical4;
                i20 = i19;
                autoCenteringParams3 = autoCenteringParams2;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i22 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i4 & 2) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    }
                    if (i24 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues2;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if ((i4 & 16) != 0) {
                        Arrangement arrangement110 = Arrangement.INSTANCE;
                        float f110 = Dp.constructor-impl(4);
                        companion = Alignment.Companion;
                        if (z3) {
                            bottom = companion.getTop();
                        } else {
                            bottom = companion.getBottom();
                        }
                        vertical3 = arrangement110.spacedBy-D5KLDUw(f110, bottom);
                        i5 &= -57345;
                    } else {
                        vertical3 = vertical2;
                    }
                    if (i8 != 0) {
                        centerHorizontally = Alignment.Companion.getCenterHorizontally();
                    } else {
                        centerHorizontally = horizontal2;
                    }
                    if ((i4 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                        i5 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    }
                    if ((i4 & 256) != 0) {
                        scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                        i5 &= -234881025;
                    } else {
                        scalingParamsScalingParams$default = scalingParams;
                    }
                    if (i12 != 0) {
                        iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                    } else {
                        iM766getItemCenterhvgbs18 = i;
                    }
                    if (i14 != 0) {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                        autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                    } else {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        autoCenteringParams2 = autoCenteringParams;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                    }
                } else {
                    if (i22 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i4 & 2) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    }
                    if (i24 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues2;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if ((i4 & 16) != 0) {
                        Arrangement arrangement111 = Arrangement.INSTANCE;
                        float f111 = Dp.constructor-impl(4);
                        companion = Alignment.Companion;
                        if (z3) {
                            bottom = companion.getTop();
                        } else {
                            bottom = companion.getBottom();
                        }
                        vertical3 = arrangement111.spacedBy-D5KLDUw(f111, bottom);
                        i5 &= -57345;
                    } else {
                        vertical3 = vertical2;
                    }
                    if (i8 != 0) {
                        centerHorizontally = Alignment.Companion.getCenterHorizontally();
                    } else {
                        centerHorizontally = horizontal2;
                    }
                    if ((i4 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                        i5 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    }
                    if ((i4 & 256) != 0) {
                        scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                        i5 &= -234881025;
                    } else {
                        scalingParamsScalingParams$default = scalingParams;
                    }
                    if (i12 != 0) {
                        iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                    } else {
                        iM766getItemCenterhvgbs18 = i;
                    }
                    if (i14 != 0) {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                        autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                    } else {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        autoCenteringParams2 = autoCenteringParams;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                    }
                }
                final boolean z18 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(741207601, i5, i18, "androidx.wear.compose.material.ScalingLazyColumn (ScalingLazyColumn.kt:357)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1150553998, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState<Boolean> mutableState11 = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, true, ComposableLambdaKt.rememberComposableLambda(-334395385, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i26) {
                        BoxWithConstraintsScope boxWithConstraintsScope2;
                        int i27;
                        int i28;
                        int i29;
                        final MutableState<Boolean> mutableState12;
                        Object obj;
                        ComposerKt.sourceInformation(composer3, "C360@18044L7,361@18103L7,*405@20227L7,411@20433L365,427@21182L1228,407@20248L2162:ScalingLazyColumn.kt#gj9v0t");
                        if ((i26 & 6) == 0) {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i27 = i26 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                        } else {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i27 = i26;
                        }
                        if ((i27 & 19) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-334395385, i27, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous> (ScalingLazyColumn.kt:360)");
                            }
                            CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume = composer3.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Density density = (Density) objConsume;
                            CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composer3.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                            int iMo586resolveViewportVerticalOffsetBRTryo0 = scalingParams2.mo586resolveViewportVerticalOffsetBRTryo0(boxWithConstraintsScope2.getConstraints-msEJaDk());
                            PaddingValues paddingValues6 = paddingValues4;
                            boolean z19 = z18;
                            final ScalingLazyListState scalingLazyListState4 = scalingLazyListState2;
                            ScalingParams scalingParams4 = scalingParams2;
                            Arrangement.Vertical vertical6 = vertical4;
                            int i30 = i19;
                            final AutoCenteringParams autoCenteringParams4 = autoCenteringParams2;
                            Alignment.Horizontal horizontal5 = horizontal3;
                            FlingBehavior flingBehavior5 = flingBehavior3;
                            boolean z110 = z5;
                            final Function1<? super ScalingLazyListScope, Unit> function2 = function1;
                            MutableState<Boolean> mutableState13 = mutableState11;
                            float f112 = density.toDp-u2uoSUM(iMo586resolveViewportVerticalOffsetBRTryo0);
                            CombinedPaddingValues combinedPaddingValues = new CombinedPaddingValues(paddingValues6, f112, null);
                            if (z19) {
                                i28 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                            } else {
                                i28 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                            }
                            if (z19) {
                                i29 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                            } else {
                                i29 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                            }
                            int i31 = i29;
                            final ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl = new ScalingLazyListItemScopeImpl(density, ConstraintsKt.offset-NN6Ew-U(boxWithConstraintsScope.getConstraints-msEJaDk(), -((int) density.toPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues6, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues6, layoutDirection)))), -density.roundToPx-0680j_4(Dp.constructor-impl(paddingValues6.calculateTopPadding-D9Ej5fM() + paddingValues6.calculateBottomPadding-D9Ej5fM()))), null);
                            scalingLazyListState4.getScalingParams$compose_material_release().setValue(scalingParams4);
                            scalingLazyListState4.getExtraPaddingPx$compose_material_release().setValue(Integer.valueOf(iMo586resolveViewportVerticalOffsetBRTryo0));
                            scalingLazyListState4.getBeforeContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i28));
                            scalingLazyListState4.getAfterContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i31));
                            scalingLazyListState4.getViewportHeightPx$compose_material_release().setValue(Integer.valueOf(Constraints.getMaxHeight-impl(boxWithConstraintsScope.getConstraints-msEJaDk())));
                            scalingLazyListState4.getGapBetweenItemsPx$compose_material_release().setValue(Integer.valueOf(density.roundToPx-0680j_4(vertical6.getSpacing-D9Ej5fM())));
                            scalingLazyListState4.getAnchorType$compose_material_release().setValue(ScalingLazyListAnchorType.m759boximpl(i30));
                            scalingLazyListState4.getAutoCentering$compose_material_release().setValue(autoCenteringParams4);
                            scalingLazyListState4.getReverseLayout$compose_material_release().setValue(Boolean.valueOf(z19));
                            MutableState<Boolean> localInspectionMode$compose_material_release = scalingLazyListState4.getLocalInspectionMode$compose_material_release();
                            CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composer3.consume(localInspectionMode);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            localInspectionMode$compose_material_release.setValue(objConsume3);
                            Modifier modifierM453verticalNegativePadding3ABfNKs = androidx.wear.compose.foundation.lazy.ScalingLazyColumnKt.m453verticalNegativePadding3ABfNKs(ClipKt.clipToBounds(Modifier.Companion), f112);
                            ComposerKt.sourceInformationMarkerStart(composer3, -2141668261, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                            boolean zChanged = composer3.changed(scalingLazyListState4);
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                mutableState12 = mutableState13;
                                obj = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((LayoutCoordinates) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LayoutCoordinates layoutCoordinates) {
                                        ScalingLazyListLayoutInfo layoutInfo = scalingLazyListState4.getLayoutInfo();
                                        if (!ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState12) && (layoutInfo instanceof DefaultScalingLazyListLayoutInfo) && ((DefaultScalingLazyListLayoutInfo) layoutInfo).getReadyForInitialScroll()) {
                                            ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$2(mutableState12, true);
                                        }
                                    }
                                };
                                composer3.updateRememberedValue(obj);
                            } else {
                                obj = objRememberedValue2;
                                mutableState12 = mutableState13;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM453verticalNegativePadding3ABfNKs, (Function1) obj);
                            LazyListState lazyListState = scalingLazyListState4.getLazyListState();
                            CombinedPaddingValues combinedPaddingValues2 = combinedPaddingValues;
                            ComposerKt.sourceInformationMarkerStart(composer3, -2141643430, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                            boolean zChanged2 = composer3.changed(scalingLazyListState4) | composer3.changed(scalingLazyListItemScopeImpl) | composer3.changed(autoCenteringParams4) | composer3.changed(function2);
                            Object objRememberedValue3 = composer3.rememberedValue();
                            if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                objRememberedValue3 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((LazyListScope) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyListScope lazyListScope) {
                                        ScalingLazyListScopeImpl scalingLazyListScopeImpl = new ScalingLazyListScopeImpl(scalingLazyListState4, lazyListScope, scalingLazyListItemScopeImpl);
                                        if (autoCenteringParams4 != null) {
                                            final ScalingLazyListState scalingLazyListState5 = scalingLazyListState4;
                                            LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1989951676, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.1
                                                {
                                                    super(3);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                    invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                    ComposerKt.sourceInformation(composer4, "C438@21659L213,437@21612L286:ScalingLazyColumn.kt#gj9v0t");
                                                    if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1989951676, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:437)");
                                                        }
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 454359168, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                        boolean zChanged3 = composer4.changed(scalingLazyListState5);
                                                        final ScalingLazyListState scalingLazyListState6 = scalingLazyListState5;
                                                        Object objRememberedValue4 = composer4.rememberedValue();
                                                        if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                            objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$1$1$1
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                public final Integer m752invoke() {
                                                                    return Integer.valueOf(scalingLazyListState6.getTopAutoCenteringItemSizePx$compose_material_release());
                                                                }
                                                            });
                                                            composer4.updateRememberedValue(objRememberedValue4);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), 3, (Object) null);
                                        }
                                        function2.invoke(scalingLazyListScopeImpl);
                                        if (autoCenteringParams4 != null) {
                                            final ScalingLazyListState scalingLazyListState6 = scalingLazyListState4;
                                            LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1331448389, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.2
                                                {
                                                    super(3);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                    invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                    ComposerKt.sourceInformation(composer4, "C450@22114L216,449@22067L289:ScalingLazyColumn.kt#gj9v0t");
                                                    if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1331448389, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:449)");
                                                        }
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 454373731, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                        boolean zChanged3 = composer4.changed(scalingLazyListState6);
                                                        final ScalingLazyListState scalingLazyListState7 = scalingLazyListState6;
                                                        Object objRememberedValue4 = composer4.rememberedValue();
                                                        if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                            objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$2$1$1
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                public final Integer m753invoke() {
                                                                    return Integer.valueOf(scalingLazyListState7.getBottomAutoCenteringItemSizePx$compose_material_release());
                                                                }
                                                            });
                                                            composer4.updateRememberedValue(objRememberedValue4);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), 3, (Object) null);
                                        }
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            LazyDslKt.LazyColumn(modifierOnGloballyPositioned, lazyListState, combinedPaddingValues2, z19, vertical6, horizontal5, flingBehavior5, z110, (Function1) objRememberedValue3, composer3, 0, 0);
                            composer3.startReplaceGroup(-938151751);
                            ComposerKt.sourceInformation(composer3, "460@22480L67,460@22458L89");
                            if (ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState12)) {
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141603055, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged3 = composer3.changed(scalingLazyListState4);
                                ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1 scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = composer3.rememberedValue();
                                if (zChanged3 || scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue == Composer.Companion.getEmpty()) {
                                    scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = new ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1(scalingLazyListState4, null);
                                    composer3.updateRememberedValue(scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                EffectsKt.LaunchedEffect(scalingLazyListState4, (Function2) scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue, composer3, 0);
                            }
                            composer3.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 3456, 2);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                scalingParams3 = scalingParams2;
                paddingValues5 = paddingValues4;
                z6 = z18;
                scalingLazyListState3 = scalingLazyListState2;
                vertical5 = vertical4;
                i20 = i19;
                autoCenteringParams3 = autoCenteringParams2;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i26) {
                        ScalingLazyColumnKt.m751ScalingLazyColumn8g7MjcI(modifier5, scalingLazyListState3, paddingValues5, z6, vertical5, horizontal4, flingBehavior4, z7, scalingParams3, i20, autoCenteringParams3, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                    }
                });
            }
        }
        i5 |= 3072;
        z3 = z;
        if ((i2 & 24576) == 0) {
            if ((i4 & 16) == 0) {
                vertical2 = vertical;
                if (composerStartRestartGroup.changed(vertical2)) {
                }
                i5 |= i25;
            } else {
                vertical2 = vertical;
            }
            i5 |= i25;
        } else {
            vertical2 = vertical;
        }
        i8 = i4 & 32;
        if (i8 != 0) {
            i5 |= 196608;
            horizontal2 = horizontal;
        } else {
            horizontal2 = horizontal;
            if ((i2 & 196608) == 0) {
                if (composerStartRestartGroup.changed(horizontal2)) {
                    i9 = 131072;
                } else {
                    i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i5 |= i9;
            }
        }
        if ((i2 & 1572864) != 0) {
            if ((i4 & 64) == 0) {
                i21 = 524288;
            } else {
                i21 = 524288;
            }
            i5 |= i21;
        }
        i10 = i4 & 128;
        if (i10 != 0) {
            i5 |= 12582912;
            z4 = z2;
        } else {
            z4 = z2;
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z4)) {
                    i11 = 8388608;
                } else {
                    i11 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i5 |= i11;
            }
        }
        if ((i2 & 100663296) != 0) {
            i5 |= ((i4 & 256) == 0 || !composerStartRestartGroup.changed(scalingParams)) ? 33554432 : 67108864;
        }
        i12 = i4 & 512;
        if (i12 != 0) {
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i13 = 536870912;
                } else {
                    i13 = 268435456;
                }
                i5 |= i13;
            }
            i14 = i4 & UserMetadata.MAX_ATTRIBUTE_SIZE;
            if (i14 != 0) {
                i15 = i3 | 6;
            } else if ((i3 & 6) == 0) {
                if (composerStartRestartGroup.changed(autoCenteringParams)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i3 | i16;
            } else {
                i15 = i3;
            }
            if ((i4 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                i15 |= 48;
            } else if ((i3 & 48) != 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i17 = 32;
                } else {
                    i17 = 16;
                }
                i15 |= i17;
            }
            i18 = i15;
            if ((i5 & 306783379) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i22 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i4 & 2) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    }
                    if (i24 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues2;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if ((i4 & 16) != 0) {
                        Arrangement arrangement112 = Arrangement.INSTANCE;
                        float f112 = Dp.constructor-impl(4);
                        companion = Alignment.Companion;
                        if (z3) {
                            bottom = companion.getTop();
                        } else {
                            bottom = companion.getBottom();
                        }
                        vertical3 = arrangement112.spacedBy-D5KLDUw(f112, bottom);
                        i5 &= -57345;
                    } else {
                        vertical3 = vertical2;
                    }
                    if (i8 != 0) {
                        centerHorizontally = Alignment.Companion.getCenterHorizontally();
                    } else {
                        centerHorizontally = horizontal2;
                    }
                    if ((i4 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                        i5 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    }
                    if ((i4 & 256) != 0) {
                        scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                        i5 &= -234881025;
                    } else {
                        scalingParamsScalingParams$default = scalingParams;
                    }
                    if (i12 != 0) {
                        iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                    } else {
                        iM766getItemCenterhvgbs18 = i;
                    }
                    if (i14 != 0) {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                        autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                    } else {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        autoCenteringParams2 = autoCenteringParams;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                    }
                } else {
                    if (i22 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i4 & 2) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    }
                    if (i24 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues2;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if ((i4 & 16) != 0) {
                        Arrangement arrangement113 = Arrangement.INSTANCE;
                        float f113 = Dp.constructor-impl(4);
                        companion = Alignment.Companion;
                        if (z3) {
                            bottom = companion.getTop();
                        } else {
                            bottom = companion.getBottom();
                        }
                        vertical3 = arrangement113.spacedBy-D5KLDUw(f113, bottom);
                        i5 &= -57345;
                    } else {
                        vertical3 = vertical2;
                    }
                    if (i8 != 0) {
                        centerHorizontally = Alignment.Companion.getCenterHorizontally();
                    } else {
                        centerHorizontally = horizontal2;
                    }
                    if ((i4 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                        i5 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    }
                    if ((i4 & 256) != 0) {
                        scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                        i5 &= -234881025;
                    } else {
                        scalingParamsScalingParams$default = scalingParams;
                    }
                    if (i12 != 0) {
                        iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                    } else {
                        iM766getItemCenterhvgbs18 = i;
                    }
                    if (i14 != 0) {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                        autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                    } else {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        autoCenteringParams2 = autoCenteringParams;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                    }
                }
                final boolean z19 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(741207601, i5, i18, "androidx.wear.compose.material.ScalingLazyColumn (ScalingLazyColumn.kt:357)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1150553998, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState<Boolean> mutableState12 = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, true, ComposableLambdaKt.rememberComposableLambda(-334395385, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i26) {
                        BoxWithConstraintsScope boxWithConstraintsScope2;
                        int i27;
                        int i28;
                        int i29;
                        final MutableState<Boolean> mutableState13;
                        Object obj;
                        ComposerKt.sourceInformation(composer3, "C360@18044L7,361@18103L7,*405@20227L7,411@20433L365,427@21182L1228,407@20248L2162:ScalingLazyColumn.kt#gj9v0t");
                        if ((i26 & 6) == 0) {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i27 = i26 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                        } else {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i27 = i26;
                        }
                        if ((i27 & 19) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-334395385, i27, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous> (ScalingLazyColumn.kt:360)");
                            }
                            CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume = composer3.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Density density = (Density) objConsume;
                            CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composer3.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                            int iMo586resolveViewportVerticalOffsetBRTryo0 = scalingParams2.mo586resolveViewportVerticalOffsetBRTryo0(boxWithConstraintsScope2.getConstraints-msEJaDk());
                            PaddingValues paddingValues6 = paddingValues4;
                            boolean z110 = z19;
                            final ScalingLazyListState scalingLazyListState4 = scalingLazyListState2;
                            ScalingParams scalingParams4 = scalingParams2;
                            Arrangement.Vertical vertical6 = vertical4;
                            int i30 = i19;
                            final AutoCenteringParams autoCenteringParams4 = autoCenteringParams2;
                            Alignment.Horizontal horizontal5 = horizontal3;
                            FlingBehavior flingBehavior5 = flingBehavior3;
                            boolean z111 = z5;
                            final Function1<? super ScalingLazyListScope, Unit> function2 = function1;
                            MutableState<Boolean> mutableState14 = mutableState12;
                            float f114 = density.toDp-u2uoSUM(iMo586resolveViewportVerticalOffsetBRTryo0);
                            CombinedPaddingValues combinedPaddingValues = new CombinedPaddingValues(paddingValues6, f114, null);
                            if (z110) {
                                i28 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                            } else {
                                i28 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                            }
                            if (z110) {
                                i29 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                            } else {
                                i29 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                            }
                            int i31 = i29;
                            final ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl = new ScalingLazyListItemScopeImpl(density, ConstraintsKt.offset-NN6Ew-U(boxWithConstraintsScope.getConstraints-msEJaDk(), -((int) density.toPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues6, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues6, layoutDirection)))), -density.roundToPx-0680j_4(Dp.constructor-impl(paddingValues6.calculateTopPadding-D9Ej5fM() + paddingValues6.calculateBottomPadding-D9Ej5fM()))), null);
                            scalingLazyListState4.getScalingParams$compose_material_release().setValue(scalingParams4);
                            scalingLazyListState4.getExtraPaddingPx$compose_material_release().setValue(Integer.valueOf(iMo586resolveViewportVerticalOffsetBRTryo0));
                            scalingLazyListState4.getBeforeContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i28));
                            scalingLazyListState4.getAfterContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i31));
                            scalingLazyListState4.getViewportHeightPx$compose_material_release().setValue(Integer.valueOf(Constraints.getMaxHeight-impl(boxWithConstraintsScope.getConstraints-msEJaDk())));
                            scalingLazyListState4.getGapBetweenItemsPx$compose_material_release().setValue(Integer.valueOf(density.roundToPx-0680j_4(vertical6.getSpacing-D9Ej5fM())));
                            scalingLazyListState4.getAnchorType$compose_material_release().setValue(ScalingLazyListAnchorType.m759boximpl(i30));
                            scalingLazyListState4.getAutoCentering$compose_material_release().setValue(autoCenteringParams4);
                            scalingLazyListState4.getReverseLayout$compose_material_release().setValue(Boolean.valueOf(z110));
                            MutableState<Boolean> localInspectionMode$compose_material_release = scalingLazyListState4.getLocalInspectionMode$compose_material_release();
                            CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composer3.consume(localInspectionMode);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            localInspectionMode$compose_material_release.setValue(objConsume3);
                            Modifier modifierM453verticalNegativePadding3ABfNKs = androidx.wear.compose.foundation.lazy.ScalingLazyColumnKt.m453verticalNegativePadding3ABfNKs(ClipKt.clipToBounds(Modifier.Companion), f114);
                            ComposerKt.sourceInformationMarkerStart(composer3, -2141668261, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                            boolean zChanged = composer3.changed(scalingLazyListState4);
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                mutableState13 = mutableState14;
                                obj = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((LayoutCoordinates) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LayoutCoordinates layoutCoordinates) {
                                        ScalingLazyListLayoutInfo layoutInfo = scalingLazyListState4.getLayoutInfo();
                                        if (!ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState13) && (layoutInfo instanceof DefaultScalingLazyListLayoutInfo) && ((DefaultScalingLazyListLayoutInfo) layoutInfo).getReadyForInitialScroll()) {
                                            ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$2(mutableState13, true);
                                        }
                                    }
                                };
                                composer3.updateRememberedValue(obj);
                            } else {
                                obj = objRememberedValue2;
                                mutableState13 = mutableState14;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM453verticalNegativePadding3ABfNKs, (Function1) obj);
                            LazyListState lazyListState = scalingLazyListState4.getLazyListState();
                            CombinedPaddingValues combinedPaddingValues2 = combinedPaddingValues;
                            ComposerKt.sourceInformationMarkerStart(composer3, -2141643430, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                            boolean zChanged2 = composer3.changed(scalingLazyListState4) | composer3.changed(scalingLazyListItemScopeImpl) | composer3.changed(autoCenteringParams4) | composer3.changed(function2);
                            Object objRememberedValue3 = composer3.rememberedValue();
                            if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                objRememberedValue3 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((LazyListScope) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyListScope lazyListScope) {
                                        ScalingLazyListScopeImpl scalingLazyListScopeImpl = new ScalingLazyListScopeImpl(scalingLazyListState4, lazyListScope, scalingLazyListItemScopeImpl);
                                        if (autoCenteringParams4 != null) {
                                            final ScalingLazyListState scalingLazyListState5 = scalingLazyListState4;
                                            LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1989951676, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.1
                                                {
                                                    super(3);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                    invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                    ComposerKt.sourceInformation(composer4, "C438@21659L213,437@21612L286:ScalingLazyColumn.kt#gj9v0t");
                                                    if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1989951676, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:437)");
                                                        }
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 454359168, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                        boolean zChanged3 = composer4.changed(scalingLazyListState5);
                                                        final ScalingLazyListState scalingLazyListState6 = scalingLazyListState5;
                                                        Object objRememberedValue4 = composer4.rememberedValue();
                                                        if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                            objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$1$1$1
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                public final Integer m752invoke() {
                                                                    return Integer.valueOf(scalingLazyListState6.getTopAutoCenteringItemSizePx$compose_material_release());
                                                                }
                                                            });
                                                            composer4.updateRememberedValue(objRememberedValue4);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), 3, (Object) null);
                                        }
                                        function2.invoke(scalingLazyListScopeImpl);
                                        if (autoCenteringParams4 != null) {
                                            final ScalingLazyListState scalingLazyListState6 = scalingLazyListState4;
                                            LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1331448389, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.2
                                                {
                                                    super(3);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                    invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                    ComposerKt.sourceInformation(composer4, "C450@22114L216,449@22067L289:ScalingLazyColumn.kt#gj9v0t");
                                                    if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1331448389, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:449)");
                                                        }
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 454373731, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                        boolean zChanged3 = composer4.changed(scalingLazyListState6);
                                                        final ScalingLazyListState scalingLazyListState7 = scalingLazyListState6;
                                                        Object objRememberedValue4 = composer4.rememberedValue();
                                                        if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                            objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$2$1$1
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                public final Integer m753invoke() {
                                                                    return Integer.valueOf(scalingLazyListState7.getBottomAutoCenteringItemSizePx$compose_material_release());
                                                                }
                                                            });
                                                            composer4.updateRememberedValue(objRememberedValue4);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), 3, (Object) null);
                                        }
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            LazyDslKt.LazyColumn(modifierOnGloballyPositioned, lazyListState, combinedPaddingValues2, z110, vertical6, horizontal5, flingBehavior5, z111, (Function1) objRememberedValue3, composer3, 0, 0);
                            composer3.startReplaceGroup(-938151751);
                            ComposerKt.sourceInformation(composer3, "460@22480L67,460@22458L89");
                            if (ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState13)) {
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141603055, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged3 = composer3.changed(scalingLazyListState4);
                                ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1 scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = composer3.rememberedValue();
                                if (zChanged3 || scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue == Composer.Companion.getEmpty()) {
                                    scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = new ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1(scalingLazyListState4, null);
                                    composer3.updateRememberedValue(scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                EffectsKt.LaunchedEffect(scalingLazyListState4, (Function2) scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue, composer3, 0);
                            }
                            composer3.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 3456, 2);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                scalingParams3 = scalingParams2;
                paddingValues5 = paddingValues4;
                z6 = z19;
                scalingLazyListState3 = scalingLazyListState2;
                vertical5 = vertical4;
                i20 = i19;
                autoCenteringParams3 = autoCenteringParams2;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i22 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i4 & 2) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    }
                    if (i24 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues2;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if ((i4 & 16) != 0) {
                        Arrangement arrangement114 = Arrangement.INSTANCE;
                        float f114 = Dp.constructor-impl(4);
                        companion = Alignment.Companion;
                        if (z3) {
                            bottom = companion.getTop();
                        } else {
                            bottom = companion.getBottom();
                        }
                        vertical3 = arrangement114.spacedBy-D5KLDUw(f114, bottom);
                        i5 &= -57345;
                    } else {
                        vertical3 = vertical2;
                    }
                    if (i8 != 0) {
                        centerHorizontally = Alignment.Companion.getCenterHorizontally();
                    } else {
                        centerHorizontally = horizontal2;
                    }
                    if ((i4 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                        i5 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    }
                    if ((i4 & 256) != 0) {
                        scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                        i5 &= -234881025;
                    } else {
                        scalingParamsScalingParams$default = scalingParams;
                    }
                    if (i12 != 0) {
                        iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                    } else {
                        iM766getItemCenterhvgbs18 = i;
                    }
                    if (i14 != 0) {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                        autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                    } else {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        autoCenteringParams2 = autoCenteringParams;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                    }
                } else {
                    if (i22 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i4 & 2) != 0) {
                        scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    }
                    if (i24 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues2;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if ((i4 & 16) != 0) {
                        Arrangement arrangement115 = Arrangement.INSTANCE;
                        float f115 = Dp.constructor-impl(4);
                        companion = Alignment.Companion;
                        if (z3) {
                            bottom = companion.getTop();
                        } else {
                            bottom = companion.getBottom();
                        }
                        vertical3 = arrangement115.spacedBy-D5KLDUw(f115, bottom);
                        i5 &= -57345;
                    } else {
                        vertical3 = vertical2;
                    }
                    if (i8 != 0) {
                        centerHorizontally = Alignment.Companion.getCenterHorizontally();
                    } else {
                        centerHorizontally = horizontal2;
                    }
                    if ((i4 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                        i5 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    }
                    if ((i4 & 256) != 0) {
                        scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                        i5 &= -234881025;
                    } else {
                        scalingParamsScalingParams$default = scalingParams;
                    }
                    if (i12 != 0) {
                        iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                    } else {
                        iM766getItemCenterhvgbs18 = i;
                    }
                    if (i14 != 0) {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                        autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                    } else {
                        modifier4 = modifier3;
                        vertical4 = vertical3;
                        z5 = z4;
                        autoCenteringParams2 = autoCenteringParams;
                        paddingValues4 = paddingValues3;
                        scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                        horizontal3 = centerHorizontally;
                        flingBehavior3 = flingBehavior2;
                        scalingParams2 = scalingParamsScalingParams$default;
                        i19 = iM766getItemCenterhvgbs18;
                    }
                }
                final boolean z110 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(741207601, i5, i18, "androidx.wear.compose.material.ScalingLazyColumn (ScalingLazyColumn.kt:357)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1150553998, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState<Boolean> mutableState13 = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, true, ComposableLambdaKt.rememberComposableLambda(-334395385, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i26) {
                        BoxWithConstraintsScope boxWithConstraintsScope2;
                        int i27;
                        int i28;
                        int i29;
                        final MutableState<Boolean> mutableState14;
                        Object obj;
                        ComposerKt.sourceInformation(composer3, "C360@18044L7,361@18103L7,*405@20227L7,411@20433L365,427@21182L1228,407@20248L2162:ScalingLazyColumn.kt#gj9v0t");
                        if ((i26 & 6) == 0) {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i27 = i26 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                        } else {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i27 = i26;
                        }
                        if ((i27 & 19) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-334395385, i27, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous> (ScalingLazyColumn.kt:360)");
                            }
                            CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume = composer3.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Density density = (Density) objConsume;
                            CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composer3.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                            int iMo586resolveViewportVerticalOffsetBRTryo0 = scalingParams2.mo586resolveViewportVerticalOffsetBRTryo0(boxWithConstraintsScope2.getConstraints-msEJaDk());
                            PaddingValues paddingValues6 = paddingValues4;
                            boolean z111 = z110;
                            final ScalingLazyListState scalingLazyListState4 = scalingLazyListState2;
                            ScalingParams scalingParams4 = scalingParams2;
                            Arrangement.Vertical vertical6 = vertical4;
                            int i30 = i19;
                            final AutoCenteringParams autoCenteringParams4 = autoCenteringParams2;
                            Alignment.Horizontal horizontal5 = horizontal3;
                            FlingBehavior flingBehavior5 = flingBehavior3;
                            boolean z112 = z5;
                            final Function1<? super ScalingLazyListScope, Unit> function2 = function1;
                            MutableState<Boolean> mutableState15 = mutableState13;
                            float f116 = density.toDp-u2uoSUM(iMo586resolveViewportVerticalOffsetBRTryo0);
                            CombinedPaddingValues combinedPaddingValues = new CombinedPaddingValues(paddingValues6, f116, null);
                            if (z111) {
                                i28 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                            } else {
                                i28 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                            }
                            if (z111) {
                                i29 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                            } else {
                                i29 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                            }
                            int i31 = i29;
                            final ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl = new ScalingLazyListItemScopeImpl(density, ConstraintsKt.offset-NN6Ew-U(boxWithConstraintsScope.getConstraints-msEJaDk(), -((int) density.toPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues6, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues6, layoutDirection)))), -density.roundToPx-0680j_4(Dp.constructor-impl(paddingValues6.calculateTopPadding-D9Ej5fM() + paddingValues6.calculateBottomPadding-D9Ej5fM()))), null);
                            scalingLazyListState4.getScalingParams$compose_material_release().setValue(scalingParams4);
                            scalingLazyListState4.getExtraPaddingPx$compose_material_release().setValue(Integer.valueOf(iMo586resolveViewportVerticalOffsetBRTryo0));
                            scalingLazyListState4.getBeforeContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i28));
                            scalingLazyListState4.getAfterContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i31));
                            scalingLazyListState4.getViewportHeightPx$compose_material_release().setValue(Integer.valueOf(Constraints.getMaxHeight-impl(boxWithConstraintsScope.getConstraints-msEJaDk())));
                            scalingLazyListState4.getGapBetweenItemsPx$compose_material_release().setValue(Integer.valueOf(density.roundToPx-0680j_4(vertical6.getSpacing-D9Ej5fM())));
                            scalingLazyListState4.getAnchorType$compose_material_release().setValue(ScalingLazyListAnchorType.m759boximpl(i30));
                            scalingLazyListState4.getAutoCentering$compose_material_release().setValue(autoCenteringParams4);
                            scalingLazyListState4.getReverseLayout$compose_material_release().setValue(Boolean.valueOf(z111));
                            MutableState<Boolean> localInspectionMode$compose_material_release = scalingLazyListState4.getLocalInspectionMode$compose_material_release();
                            CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composer3.consume(localInspectionMode);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            localInspectionMode$compose_material_release.setValue(objConsume3);
                            Modifier modifierM453verticalNegativePadding3ABfNKs = androidx.wear.compose.foundation.lazy.ScalingLazyColumnKt.m453verticalNegativePadding3ABfNKs(ClipKt.clipToBounds(Modifier.Companion), f116);
                            ComposerKt.sourceInformationMarkerStart(composer3, -2141668261, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                            boolean zChanged = composer3.changed(scalingLazyListState4);
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                mutableState14 = mutableState15;
                                obj = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((LayoutCoordinates) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LayoutCoordinates layoutCoordinates) {
                                        ScalingLazyListLayoutInfo layoutInfo = scalingLazyListState4.getLayoutInfo();
                                        if (!ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState14) && (layoutInfo instanceof DefaultScalingLazyListLayoutInfo) && ((DefaultScalingLazyListLayoutInfo) layoutInfo).getReadyForInitialScroll()) {
                                            ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$2(mutableState14, true);
                                        }
                                    }
                                };
                                composer3.updateRememberedValue(obj);
                            } else {
                                obj = objRememberedValue2;
                                mutableState14 = mutableState15;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM453verticalNegativePadding3ABfNKs, (Function1) obj);
                            LazyListState lazyListState = scalingLazyListState4.getLazyListState();
                            CombinedPaddingValues combinedPaddingValues2 = combinedPaddingValues;
                            ComposerKt.sourceInformationMarkerStart(composer3, -2141643430, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                            boolean zChanged2 = composer3.changed(scalingLazyListState4) | composer3.changed(scalingLazyListItemScopeImpl) | composer3.changed(autoCenteringParams4) | composer3.changed(function2);
                            Object objRememberedValue3 = composer3.rememberedValue();
                            if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                objRememberedValue3 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((LazyListScope) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyListScope lazyListScope) {
                                        ScalingLazyListScopeImpl scalingLazyListScopeImpl = new ScalingLazyListScopeImpl(scalingLazyListState4, lazyListScope, scalingLazyListItemScopeImpl);
                                        if (autoCenteringParams4 != null) {
                                            final ScalingLazyListState scalingLazyListState5 = scalingLazyListState4;
                                            LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1989951676, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.1
                                                {
                                                    super(3);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                    invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                    ComposerKt.sourceInformation(composer4, "C438@21659L213,437@21612L286:ScalingLazyColumn.kt#gj9v0t");
                                                    if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1989951676, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:437)");
                                                        }
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 454359168, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                        boolean zChanged3 = composer4.changed(scalingLazyListState5);
                                                        final ScalingLazyListState scalingLazyListState6 = scalingLazyListState5;
                                                        Object objRememberedValue4 = composer4.rememberedValue();
                                                        if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                            objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$1$1$1
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                public final Integer m752invoke() {
                                                                    return Integer.valueOf(scalingLazyListState6.getTopAutoCenteringItemSizePx$compose_material_release());
                                                                }
                                                            });
                                                            composer4.updateRememberedValue(objRememberedValue4);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), 3, (Object) null);
                                        }
                                        function2.invoke(scalingLazyListScopeImpl);
                                        if (autoCenteringParams4 != null) {
                                            final ScalingLazyListState scalingLazyListState6 = scalingLazyListState4;
                                            LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1331448389, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.2
                                                {
                                                    super(3);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                    invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                    ComposerKt.sourceInformation(composer4, "C450@22114L216,449@22067L289:ScalingLazyColumn.kt#gj9v0t");
                                                    if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1331448389, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:449)");
                                                        }
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 454373731, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                        boolean zChanged3 = composer4.changed(scalingLazyListState6);
                                                        final ScalingLazyListState scalingLazyListState7 = scalingLazyListState6;
                                                        Object objRememberedValue4 = composer4.rememberedValue();
                                                        if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                            objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$2$1$1
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                                public final Integer m753invoke() {
                                                                    return Integer.valueOf(scalingLazyListState7.getBottomAutoCenteringItemSizePx$compose_material_release());
                                                                }
                                                            });
                                                            composer4.updateRememberedValue(objRememberedValue4);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), 3, (Object) null);
                                        }
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            LazyDslKt.LazyColumn(modifierOnGloballyPositioned, lazyListState, combinedPaddingValues2, z111, vertical6, horizontal5, flingBehavior5, z112, (Function1) objRememberedValue3, composer3, 0, 0);
                            composer3.startReplaceGroup(-938151751);
                            ComposerKt.sourceInformation(composer3, "460@22480L67,460@22458L89");
                            if (ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState14)) {
                                ComposerKt.sourceInformationMarkerStart(composer3, -2141603055, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                boolean zChanged3 = composer3.changed(scalingLazyListState4);
                                ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1 scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = composer3.rememberedValue();
                                if (zChanged3 || scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue == Composer.Companion.getEmpty()) {
                                    scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = new ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1(scalingLazyListState4, null);
                                    composer3.updateRememberedValue(scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                EffectsKt.LaunchedEffect(scalingLazyListState4, (Function2) scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue, composer3, 0);
                            }
                            composer3.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 3456, 2);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                scalingParams3 = scalingParams2;
                paddingValues5 = paddingValues4;
                z6 = z110;
                scalingLazyListState3 = scalingLazyListState2;
                vertical5 = vertical4;
                i20 = i19;
                autoCenteringParams3 = autoCenteringParams2;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i26) {
                        ScalingLazyColumnKt.m751ScalingLazyColumn8g7MjcI(modifier5, scalingLazyListState3, paddingValues5, z6, vertical5, horizontal4, flingBehavior4, z7, scalingParams3, i20, autoCenteringParams3, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                    }
                });
            }
        }
        i5 |= 805306368;
        i14 = i4 & UserMetadata.MAX_ATTRIBUTE_SIZE;
        if (i14 != 0) {
            i15 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            if (composerStartRestartGroup.changed(autoCenteringParams)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i15 = i3 | i16;
        } else {
            i15 = i3;
        }
        if ((i4 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
            i15 |= 48;
        } else if ((i3 & 48) != 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i17 = 32;
            } else {
                i17 = 16;
            }
            i15 |= i17;
        }
        i18 = i15;
        if ((i5 & 306783379) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i22 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i4 & 2) != 0) {
                    scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i5 &= -113;
                }
                if (i24 != 0) {
                    paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                } else {
                    paddingValues3 = paddingValues2;
                }
                if (i6 != 0) {
                    z3 = false;
                }
                if ((i4 & 16) != 0) {
                    Arrangement arrangement116 = Arrangement.INSTANCE;
                    float f116 = Dp.constructor-impl(4);
                    companion = Alignment.Companion;
                    if (z3) {
                        bottom = companion.getTop();
                    } else {
                        bottom = companion.getBottom();
                    }
                    vertical3 = arrangement116.spacedBy-D5KLDUw(f116, bottom);
                    i5 &= -57345;
                } else {
                    vertical3 = vertical2;
                }
                if (i8 != 0) {
                    centerHorizontally = Alignment.Companion.getCenterHorizontally();
                } else {
                    centerHorizontally = horizontal2;
                }
                if ((i4 & 64) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                    i5 &= -3670017;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    z4 = true;
                }
                if ((i4 & 256) != 0) {
                    scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                    i5 &= -234881025;
                } else {
                    scalingParamsScalingParams$default = scalingParams;
                }
                if (i12 != 0) {
                    iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                } else {
                    iM766getItemCenterhvgbs18 = i;
                }
                if (i14 != 0) {
                    modifier4 = modifier3;
                    vertical4 = vertical3;
                    z5 = z4;
                    paddingValues4 = paddingValues3;
                    scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                    horizontal3 = centerHorizontally;
                    flingBehavior3 = flingBehavior2;
                    scalingParams2 = scalingParamsScalingParams$default;
                    i19 = iM766getItemCenterhvgbs18;
                    autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                } else {
                    modifier4 = modifier3;
                    vertical4 = vertical3;
                    z5 = z4;
                    autoCenteringParams2 = autoCenteringParams;
                    paddingValues4 = paddingValues3;
                    scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                    horizontal3 = centerHorizontally;
                    flingBehavior3 = flingBehavior2;
                    scalingParams2 = scalingParamsScalingParams$default;
                    i19 = iM766getItemCenterhvgbs18;
                }
            } else {
                if (i22 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i4 & 2) != 0) {
                    scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i5 &= -113;
                }
                if (i24 != 0) {
                    paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                } else {
                    paddingValues3 = paddingValues2;
                }
                if (i6 != 0) {
                    z3 = false;
                }
                if ((i4 & 16) != 0) {
                    Arrangement arrangement117 = Arrangement.INSTANCE;
                    float f117 = Dp.constructor-impl(4);
                    companion = Alignment.Companion;
                    if (z3) {
                        bottom = companion.getTop();
                    } else {
                        bottom = companion.getBottom();
                    }
                    vertical3 = arrangement117.spacedBy-D5KLDUw(f117, bottom);
                    i5 &= -57345;
                } else {
                    vertical3 = vertical2;
                }
                if (i8 != 0) {
                    centerHorizontally = Alignment.Companion.getCenterHorizontally();
                } else {
                    centerHorizontally = horizontal2;
                }
                if ((i4 & 64) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                    i5 &= -3670017;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    z4 = true;
                }
                if ((i4 & 256) != 0) {
                    scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                    i5 &= -234881025;
                } else {
                    scalingParamsScalingParams$default = scalingParams;
                }
                if (i12 != 0) {
                    iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                } else {
                    iM766getItemCenterhvgbs18 = i;
                }
                if (i14 != 0) {
                    modifier4 = modifier3;
                    vertical4 = vertical3;
                    z5 = z4;
                    paddingValues4 = paddingValues3;
                    scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                    horizontal3 = centerHorizontally;
                    flingBehavior3 = flingBehavior2;
                    scalingParams2 = scalingParamsScalingParams$default;
                    i19 = iM766getItemCenterhvgbs18;
                    autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                } else {
                    modifier4 = modifier3;
                    vertical4 = vertical3;
                    z5 = z4;
                    autoCenteringParams2 = autoCenteringParams;
                    paddingValues4 = paddingValues3;
                    scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                    horizontal3 = centerHorizontally;
                    flingBehavior3 = flingBehavior2;
                    scalingParams2 = scalingParamsScalingParams$default;
                    i19 = iM766getItemCenterhvgbs18;
                }
            }
            final boolean z111 = z3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(741207601, i5, i18, "androidx.wear.compose.material.ScalingLazyColumn (ScalingLazyColumn.kt:357)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1150553998, "CC(remember):ScalingLazyColumn.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState<Boolean> mutableState14 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, true, ComposableLambdaKt.rememberComposableLambda(-334395385, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i26) {
                    BoxWithConstraintsScope boxWithConstraintsScope2;
                    int i27;
                    int i28;
                    int i29;
                    final MutableState<Boolean> mutableState15;
                    Object obj;
                    ComposerKt.sourceInformation(composer3, "C360@18044L7,361@18103L7,*405@20227L7,411@20433L365,427@21182L1228,407@20248L2162:ScalingLazyColumn.kt#gj9v0t");
                    if ((i26 & 6) == 0) {
                        boxWithConstraintsScope2 = boxWithConstraintsScope;
                        i27 = i26 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                    } else {
                        boxWithConstraintsScope2 = boxWithConstraintsScope;
                        i27 = i26;
                    }
                    if ((i27 & 19) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-334395385, i27, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous> (ScalingLazyColumn.kt:360)");
                        }
                        CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume = composer3.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Density density = (Density) objConsume;
                        CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composer3.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                        int iMo586resolveViewportVerticalOffsetBRTryo0 = scalingParams2.mo586resolveViewportVerticalOffsetBRTryo0(boxWithConstraintsScope2.getConstraints-msEJaDk());
                        PaddingValues paddingValues6 = paddingValues4;
                        boolean z112 = z111;
                        final ScalingLazyListState scalingLazyListState4 = scalingLazyListState2;
                        ScalingParams scalingParams4 = scalingParams2;
                        Arrangement.Vertical vertical6 = vertical4;
                        int i30 = i19;
                        final AutoCenteringParams autoCenteringParams4 = autoCenteringParams2;
                        Alignment.Horizontal horizontal5 = horizontal3;
                        FlingBehavior flingBehavior5 = flingBehavior3;
                        boolean z113 = z5;
                        final Function1<? super ScalingLazyListScope, Unit> function2 = function1;
                        MutableState<Boolean> mutableState16 = mutableState14;
                        float f118 = density.toDp-u2uoSUM(iMo586resolveViewportVerticalOffsetBRTryo0);
                        CombinedPaddingValues combinedPaddingValues = new CombinedPaddingValues(paddingValues6, f118, null);
                        if (z112) {
                            i28 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                        } else {
                            i28 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                        }
                        if (z112) {
                            i29 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                        } else {
                            i29 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                        }
                        int i31 = i29;
                        final ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl = new ScalingLazyListItemScopeImpl(density, ConstraintsKt.offset-NN6Ew-U(boxWithConstraintsScope.getConstraints-msEJaDk(), -((int) density.toPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues6, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues6, layoutDirection)))), -density.roundToPx-0680j_4(Dp.constructor-impl(paddingValues6.calculateTopPadding-D9Ej5fM() + paddingValues6.calculateBottomPadding-D9Ej5fM()))), null);
                        scalingLazyListState4.getScalingParams$compose_material_release().setValue(scalingParams4);
                        scalingLazyListState4.getExtraPaddingPx$compose_material_release().setValue(Integer.valueOf(iMo586resolveViewportVerticalOffsetBRTryo0));
                        scalingLazyListState4.getBeforeContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i28));
                        scalingLazyListState4.getAfterContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i31));
                        scalingLazyListState4.getViewportHeightPx$compose_material_release().setValue(Integer.valueOf(Constraints.getMaxHeight-impl(boxWithConstraintsScope.getConstraints-msEJaDk())));
                        scalingLazyListState4.getGapBetweenItemsPx$compose_material_release().setValue(Integer.valueOf(density.roundToPx-0680j_4(vertical6.getSpacing-D9Ej5fM())));
                        scalingLazyListState4.getAnchorType$compose_material_release().setValue(ScalingLazyListAnchorType.m759boximpl(i30));
                        scalingLazyListState4.getAutoCentering$compose_material_release().setValue(autoCenteringParams4);
                        scalingLazyListState4.getReverseLayout$compose_material_release().setValue(Boolean.valueOf(z112));
                        MutableState<Boolean> localInspectionMode$compose_material_release = scalingLazyListState4.getLocalInspectionMode$compose_material_release();
                        CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composer3.consume(localInspectionMode);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        localInspectionMode$compose_material_release.setValue(objConsume3);
                        Modifier modifierM453verticalNegativePadding3ABfNKs = androidx.wear.compose.foundation.lazy.ScalingLazyColumnKt.m453verticalNegativePadding3ABfNKs(ClipKt.clipToBounds(Modifier.Companion), f118);
                        ComposerKt.sourceInformationMarkerStart(composer3, -2141668261, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                        boolean zChanged = composer3.changed(scalingLazyListState4);
                        Object objRememberedValue2 = composer3.rememberedValue();
                        if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                            mutableState15 = mutableState16;
                            obj = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    invoke((LayoutCoordinates) obj2);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LayoutCoordinates layoutCoordinates) {
                                    ScalingLazyListLayoutInfo layoutInfo = scalingLazyListState4.getLayoutInfo();
                                    if (!ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState15) && (layoutInfo instanceof DefaultScalingLazyListLayoutInfo) && ((DefaultScalingLazyListLayoutInfo) layoutInfo).getReadyForInitialScroll()) {
                                        ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$2(mutableState15, true);
                                    }
                                }
                            };
                            composer3.updateRememberedValue(obj);
                        } else {
                            obj = objRememberedValue2;
                            mutableState15 = mutableState16;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM453verticalNegativePadding3ABfNKs, (Function1) obj);
                        LazyListState lazyListState = scalingLazyListState4.getLazyListState();
                        CombinedPaddingValues combinedPaddingValues2 = combinedPaddingValues;
                        ComposerKt.sourceInformationMarkerStart(composer3, -2141643430, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                        boolean zChanged2 = composer3.changed(scalingLazyListState4) | composer3.changed(scalingLazyListItemScopeImpl) | composer3.changed(autoCenteringParams4) | composer3.changed(function2);
                        Object objRememberedValue3 = composer3.rememberedValue();
                        if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                            objRememberedValue3 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    invoke((LazyListScope) obj2);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyListScope lazyListScope) {
                                    ScalingLazyListScopeImpl scalingLazyListScopeImpl = new ScalingLazyListScopeImpl(scalingLazyListState4, lazyListScope, scalingLazyListItemScopeImpl);
                                    if (autoCenteringParams4 != null) {
                                        final ScalingLazyListState scalingLazyListState5 = scalingLazyListState4;
                                        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1989951676, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.1
                                            {
                                                super(3);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                ComposerKt.sourceInformation(composer4, "C438@21659L213,437@21612L286:ScalingLazyColumn.kt#gj9v0t");
                                                if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1989951676, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:437)");
                                                    }
                                                    ComposerKt.sourceInformationMarkerStart(composer4, 454359168, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                    boolean zChanged3 = composer4.changed(scalingLazyListState5);
                                                    final ScalingLazyListState scalingLazyListState6 = scalingLazyListState5;
                                                    Object objRememberedValue4 = composer4.rememberedValue();
                                                    if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                        objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$1$1$1
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                            public final Integer m752invoke() {
                                                                return Integer.valueOf(scalingLazyListState6.getTopAutoCenteringItemSizePx$compose_material_release());
                                                            }
                                                        });
                                                        composer4.updateRememberedValue(objRememberedValue4);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), 3, (Object) null);
                                    }
                                    function2.invoke(scalingLazyListScopeImpl);
                                    if (autoCenteringParams4 != null) {
                                        final ScalingLazyListState scalingLazyListState6 = scalingLazyListState4;
                                        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1331448389, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.2
                                            {
                                                super(3);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                ComposerKt.sourceInformation(composer4, "C450@22114L216,449@22067L289:ScalingLazyColumn.kt#gj9v0t");
                                                if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1331448389, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:449)");
                                                    }
                                                    ComposerKt.sourceInformationMarkerStart(composer4, 454373731, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                    boolean zChanged3 = composer4.changed(scalingLazyListState6);
                                                    final ScalingLazyListState scalingLazyListState7 = scalingLazyListState6;
                                                    Object objRememberedValue4 = composer4.rememberedValue();
                                                    if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                        objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$2$1$1
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                            public final Integer m753invoke() {
                                                                return Integer.valueOf(scalingLazyListState7.getBottomAutoCenteringItemSizePx$compose_material_release());
                                                            }
                                                        });
                                                        composer4.updateRememberedValue(objRememberedValue4);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), 3, (Object) null);
                                    }
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        LazyDslKt.LazyColumn(modifierOnGloballyPositioned, lazyListState, combinedPaddingValues2, z112, vertical6, horizontal5, flingBehavior5, z113, (Function1) objRememberedValue3, composer3, 0, 0);
                        composer3.startReplaceGroup(-938151751);
                        ComposerKt.sourceInformation(composer3, "460@22480L67,460@22458L89");
                        if (ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState15)) {
                            ComposerKt.sourceInformationMarkerStart(composer3, -2141603055, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                            boolean zChanged3 = composer3.changed(scalingLazyListState4);
                            ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1 scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = composer3.rememberedValue();
                            if (zChanged3 || scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue == Composer.Companion.getEmpty()) {
                                scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = new ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1(scalingLazyListState4, null);
                                composer3.updateRememberedValue(scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            EffectsKt.LaunchedEffect(scalingLazyListState4, (Function2) scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue, composer3, 0);
                        }
                        composer3.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 3456, 2);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            scalingParams3 = scalingParams2;
            paddingValues5 = paddingValues4;
            z6 = z111;
            scalingLazyListState3 = scalingLazyListState2;
            vertical5 = vertical4;
            i20 = i19;
            autoCenteringParams3 = autoCenteringParams2;
            horizontal4 = horizontal3;
            flingBehavior4 = flingBehavior3;
            z7 = z5;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i22 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i4 & 2) != 0) {
                    scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i5 &= -113;
                }
                if (i24 != 0) {
                    paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                } else {
                    paddingValues3 = paddingValues2;
                }
                if (i6 != 0) {
                    z3 = false;
                }
                if ((i4 & 16) != 0) {
                    Arrangement arrangement118 = Arrangement.INSTANCE;
                    float f118 = Dp.constructor-impl(4);
                    companion = Alignment.Companion;
                    if (z3) {
                        bottom = companion.getTop();
                    } else {
                        bottom = companion.getBottom();
                    }
                    vertical3 = arrangement118.spacedBy-D5KLDUw(f118, bottom);
                    i5 &= -57345;
                } else {
                    vertical3 = vertical2;
                }
                if (i8 != 0) {
                    centerHorizontally = Alignment.Companion.getCenterHorizontally();
                } else {
                    centerHorizontally = horizontal2;
                }
                if ((i4 & 64) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                    i5 &= -3670017;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    z4 = true;
                }
                if ((i4 & 256) != 0) {
                    scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                    i5 &= -234881025;
                } else {
                    scalingParamsScalingParams$default = scalingParams;
                }
                if (i12 != 0) {
                    iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                } else {
                    iM766getItemCenterhvgbs18 = i;
                }
                if (i14 != 0) {
                    modifier4 = modifier3;
                    vertical4 = vertical3;
                    z5 = z4;
                    paddingValues4 = paddingValues3;
                    scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                    horizontal3 = centerHorizontally;
                    flingBehavior3 = flingBehavior2;
                    scalingParams2 = scalingParamsScalingParams$default;
                    i19 = iM766getItemCenterhvgbs18;
                    autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                } else {
                    modifier4 = modifier3;
                    vertical4 = vertical3;
                    z5 = z4;
                    autoCenteringParams2 = autoCenteringParams;
                    paddingValues4 = paddingValues3;
                    scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                    horizontal3 = centerHorizontally;
                    flingBehavior3 = flingBehavior2;
                    scalingParams2 = scalingParamsScalingParams$default;
                    i19 = iM766getItemCenterhvgbs18;
                }
            } else {
                if (i22 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i4 & 2) != 0) {
                    scalingLazyListStateRememberScalingLazyListState = ScalingLazyListStateKt.rememberScalingLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i5 &= -113;
                }
                if (i24 != 0) {
                    paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                } else {
                    paddingValues3 = paddingValues2;
                }
                if (i6 != 0) {
                    z3 = false;
                }
                if ((i4 & 16) != 0) {
                    Arrangement arrangement119 = Arrangement.INSTANCE;
                    float f119 = Dp.constructor-impl(4);
                    companion = Alignment.Companion;
                    if (z3) {
                        bottom = companion.getTop();
                    } else {
                        bottom = companion.getBottom();
                    }
                    vertical3 = arrangement119.spacedBy-D5KLDUw(f119, bottom);
                    i5 &= -57345;
                } else {
                    vertical3 = vertical2;
                }
                if (i8 != 0) {
                    centerHorizontally = Alignment.Companion.getCenterHorizontally();
                } else {
                    centerHorizontally = horizontal2;
                }
                if ((i4 & 64) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, ScrollableDefaults.$stable);
                    i5 &= -3670017;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    z4 = true;
                }
                if ((i4 & 256) != 0) {
                    scalingParamsScalingParams$default = ScalingLazyColumnDefaults.scalingParams$default(ScalingLazyColumnDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, Constants.MAX_HOST_LENGTH, null);
                    i5 &= -234881025;
                } else {
                    scalingParamsScalingParams$default = scalingParams;
                }
                if (i12 != 0) {
                    iM766getItemCenterhvgbs18 = ScalingLazyListAnchorType.INSTANCE.m766getItemCenterhvgbs18();
                } else {
                    iM766getItemCenterhvgbs18 = i;
                }
                if (i14 != 0) {
                    modifier4 = modifier3;
                    vertical4 = vertical3;
                    z5 = z4;
                    paddingValues4 = paddingValues3;
                    scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                    horizontal3 = centerHorizontally;
                    flingBehavior3 = flingBehavior2;
                    scalingParams2 = scalingParamsScalingParams$default;
                    i19 = iM766getItemCenterhvgbs18;
                    autoCenteringParams2 = new AutoCenteringParams(0, 0, 3, null);
                } else {
                    modifier4 = modifier3;
                    vertical4 = vertical3;
                    z5 = z4;
                    autoCenteringParams2 = autoCenteringParams;
                    paddingValues4 = paddingValues3;
                    scalingLazyListState2 = scalingLazyListStateRememberScalingLazyListState;
                    horizontal3 = centerHorizontally;
                    flingBehavior3 = flingBehavior2;
                    scalingParams2 = scalingParamsScalingParams$default;
                    i19 = iM766getItemCenterhvgbs18;
                }
            }
            final boolean z112 = z3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(741207601, i5, i18, "androidx.wear.compose.material.ScalingLazyColumn (ScalingLazyColumn.kt:357)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1150553998, "CC(remember):ScalingLazyColumn.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState<Boolean> mutableState15 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, true, ComposableLambdaKt.rememberComposableLambda(-334395385, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i26) {
                    BoxWithConstraintsScope boxWithConstraintsScope2;
                    int i27;
                    int i28;
                    int i29;
                    final MutableState<Boolean> mutableState16;
                    Object obj;
                    ComposerKt.sourceInformation(composer3, "C360@18044L7,361@18103L7,*405@20227L7,411@20433L365,427@21182L1228,407@20248L2162:ScalingLazyColumn.kt#gj9v0t");
                    if ((i26 & 6) == 0) {
                        boxWithConstraintsScope2 = boxWithConstraintsScope;
                        i27 = i26 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                    } else {
                        boxWithConstraintsScope2 = boxWithConstraintsScope;
                        i27 = i26;
                    }
                    if ((i27 & 19) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-334395385, i27, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous> (ScalingLazyColumn.kt:360)");
                        }
                        CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume = composer3.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Density density = (Density) objConsume;
                        CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composer3.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                        int iMo586resolveViewportVerticalOffsetBRTryo0 = scalingParams2.mo586resolveViewportVerticalOffsetBRTryo0(boxWithConstraintsScope2.getConstraints-msEJaDk());
                        PaddingValues paddingValues6 = paddingValues4;
                        boolean z113 = z112;
                        final ScalingLazyListState scalingLazyListState4 = scalingLazyListState2;
                        ScalingParams scalingParams4 = scalingParams2;
                        Arrangement.Vertical vertical6 = vertical4;
                        int i30 = i19;
                        final AutoCenteringParams autoCenteringParams4 = autoCenteringParams2;
                        Alignment.Horizontal horizontal5 = horizontal3;
                        FlingBehavior flingBehavior5 = flingBehavior3;
                        boolean z114 = z5;
                        final Function1<? super ScalingLazyListScope, Unit> function2 = function1;
                        MutableState<Boolean> mutableState17 = mutableState15;
                        float f1110 = density.toDp-u2uoSUM(iMo586resolveViewportVerticalOffsetBRTryo0);
                        CombinedPaddingValues combinedPaddingValues = new CombinedPaddingValues(paddingValues6, f1110, null);
                        if (z113) {
                            i28 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                        } else {
                            i28 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                        }
                        if (z113) {
                            i29 = density.roundToPx-0680j_4(paddingValues6.calculateTopPadding-D9Ej5fM());
                        } else {
                            i29 = density.roundToPx-0680j_4(paddingValues6.calculateBottomPadding-D9Ej5fM());
                        }
                        int i31 = i29;
                        final ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl = new ScalingLazyListItemScopeImpl(density, ConstraintsKt.offset-NN6Ew-U(boxWithConstraintsScope.getConstraints-msEJaDk(), -((int) density.toPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues6, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues6, layoutDirection)))), -density.roundToPx-0680j_4(Dp.constructor-impl(paddingValues6.calculateTopPadding-D9Ej5fM() + paddingValues6.calculateBottomPadding-D9Ej5fM()))), null);
                        scalingLazyListState4.getScalingParams$compose_material_release().setValue(scalingParams4);
                        scalingLazyListState4.getExtraPaddingPx$compose_material_release().setValue(Integer.valueOf(iMo586resolveViewportVerticalOffsetBRTryo0));
                        scalingLazyListState4.getBeforeContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i28));
                        scalingLazyListState4.getAfterContentPaddingPx$compose_material_release().setValue(Integer.valueOf(i31));
                        scalingLazyListState4.getViewportHeightPx$compose_material_release().setValue(Integer.valueOf(Constraints.getMaxHeight-impl(boxWithConstraintsScope.getConstraints-msEJaDk())));
                        scalingLazyListState4.getGapBetweenItemsPx$compose_material_release().setValue(Integer.valueOf(density.roundToPx-0680j_4(vertical6.getSpacing-D9Ej5fM())));
                        scalingLazyListState4.getAnchorType$compose_material_release().setValue(ScalingLazyListAnchorType.m759boximpl(i30));
                        scalingLazyListState4.getAutoCentering$compose_material_release().setValue(autoCenteringParams4);
                        scalingLazyListState4.getReverseLayout$compose_material_release().setValue(Boolean.valueOf(z113));
                        MutableState<Boolean> localInspectionMode$compose_material_release = scalingLazyListState4.getLocalInspectionMode$compose_material_release();
                        CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composer3.consume(localInspectionMode);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        localInspectionMode$compose_material_release.setValue(objConsume3);
                        Modifier modifierM453verticalNegativePadding3ABfNKs = androidx.wear.compose.foundation.lazy.ScalingLazyColumnKt.m453verticalNegativePadding3ABfNKs(ClipKt.clipToBounds(Modifier.Companion), f1110);
                        ComposerKt.sourceInformationMarkerStart(composer3, -2141668261, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                        boolean zChanged = composer3.changed(scalingLazyListState4);
                        Object objRememberedValue2 = composer3.rememberedValue();
                        if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                            mutableState16 = mutableState17;
                            obj = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    invoke((LayoutCoordinates) obj2);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LayoutCoordinates layoutCoordinates) {
                                    ScalingLazyListLayoutInfo layoutInfo = scalingLazyListState4.getLayoutInfo();
                                    if (!ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState16) && (layoutInfo instanceof DefaultScalingLazyListLayoutInfo) && ((DefaultScalingLazyListLayoutInfo) layoutInfo).getReadyForInitialScroll()) {
                                        ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$2(mutableState16, true);
                                    }
                                }
                            };
                            composer3.updateRememberedValue(obj);
                        } else {
                            obj = objRememberedValue2;
                            mutableState16 = mutableState17;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM453verticalNegativePadding3ABfNKs, (Function1) obj);
                        LazyListState lazyListState = scalingLazyListState4.getLazyListState();
                        CombinedPaddingValues combinedPaddingValues2 = combinedPaddingValues;
                        ComposerKt.sourceInformationMarkerStart(composer3, -2141643430, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                        boolean zChanged2 = composer3.changed(scalingLazyListState4) | composer3.changed(scalingLazyListItemScopeImpl) | composer3.changed(autoCenteringParams4) | composer3.changed(function2);
                        Object objRememberedValue3 = composer3.rememberedValue();
                        if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                            objRememberedValue3 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    invoke((LazyListScope) obj2);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyListScope lazyListScope) {
                                    ScalingLazyListScopeImpl scalingLazyListScopeImpl = new ScalingLazyListScopeImpl(scalingLazyListState4, lazyListScope, scalingLazyListItemScopeImpl);
                                    if (autoCenteringParams4 != null) {
                                        final ScalingLazyListState scalingLazyListState5 = scalingLazyListState4;
                                        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1989951676, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.1
                                            {
                                                super(3);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                ComposerKt.sourceInformation(composer4, "C438@21659L213,437@21612L286:ScalingLazyColumn.kt#gj9v0t");
                                                if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1989951676, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:437)");
                                                    }
                                                    ComposerKt.sourceInformationMarkerStart(composer4, 454359168, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                    boolean zChanged3 = composer4.changed(scalingLazyListState5);
                                                    final ScalingLazyListState scalingLazyListState6 = scalingLazyListState5;
                                                    Object objRememberedValue4 = composer4.rememberedValue();
                                                    if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                        objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$1$1$1
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                            public final Integer m752invoke() {
                                                                return Integer.valueOf(scalingLazyListState6.getTopAutoCenteringItemSizePx$compose_material_release());
                                                            }
                                                        });
                                                        composer4.updateRememberedValue(objRememberedValue4);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), 3, (Object) null);
                                    }
                                    function2.invoke(scalingLazyListScopeImpl);
                                    if (autoCenteringParams4 != null) {
                                        final ScalingLazyListState scalingLazyListState6 = scalingLazyListState4;
                                        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1331448389, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1.2
                                            {
                                                super(3);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                                invoke((LazyItemScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(LazyItemScope lazyItemScope, Composer composer4, int i32) {
                                                ComposerKt.sourceInformation(composer4, "C450@22114L216,449@22067L289:ScalingLazyColumn.kt#gj9v0t");
                                                if ((i32 & 17) != 16 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1331448389, i32, -1, "androidx.wear.compose.material.ScalingLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ScalingLazyColumn.kt:449)");
                                                    }
                                                    ComposerKt.sourceInformationMarkerStart(composer4, 454373731, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                                                    boolean zChanged3 = composer4.changed(scalingLazyListState6);
                                                    final ScalingLazyListState scalingLazyListState7 = scalingLazyListState6;
                                                    Object objRememberedValue4 = composer4.rememberedValue();
                                                    if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                                        objRememberedValue4 = ScalingLazyColumnKt.autoCenteringHeight(Modifier.Companion, new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$1$1$2$1$2$1$1
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                            public final Integer m753invoke() {
                                                                return Integer.valueOf(scalingLazyListState7.getBottomAutoCenteringItemSizePx$compose_material_release());
                                                            }
                                                        });
                                                        composer4.updateRememberedValue(objRememberedValue4);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    SpacerKt.Spacer((Modifier) objRememberedValue4, composer4, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), 3, (Object) null);
                                    }
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        LazyDslKt.LazyColumn(modifierOnGloballyPositioned, lazyListState, combinedPaddingValues2, z113, vertical6, horizontal5, flingBehavior5, z114, (Function1) objRememberedValue3, composer3, 0, 0);
                        composer3.startReplaceGroup(-938151751);
                        ComposerKt.sourceInformation(composer3, "460@22480L67,460@22458L89");
                        if (ScalingLazyColumnKt.ScalingLazyColumn_8g7MjcI$lambda$1(mutableState16)) {
                            ComposerKt.sourceInformationMarkerStart(composer3, -2141603055, "CC(remember):ScalingLazyColumn.kt#9igjgp");
                            boolean zChanged3 = composer3.changed(scalingLazyListState4);
                            ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1 scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = composer3.rememberedValue();
                            if (zChanged3 || scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue == Composer.Companion.getEmpty()) {
                                scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue = new ScalingLazyColumnKt$ScalingLazyColumn$1$1$3$1(scalingLazyListState4, null);
                                composer3.updateRememberedValue(scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            EffectsKt.LaunchedEffect(scalingLazyListState4, (Function2) scalingLazyColumnKt$ScalingLazyColumn$1$1$3$1RememberedValue, composer3, 0);
                        }
                        composer3.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 3456, 2);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            scalingParams3 = scalingParams2;
            paddingValues5 = paddingValues4;
            z6 = z112;
            scalingLazyListState3 = scalingLazyListState2;
            vertical5 = vertical4;
            i20 = i19;
            autoCenteringParams3 = autoCenteringParams2;
            horizontal4 = horizontal3;
            flingBehavior4 = flingBehavior3;
            z7 = z5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumn$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i26) {
                    ScalingLazyColumnKt.m751ScalingLazyColumn8g7MjcI(modifier5, scalingLazyListState3, paddingValues5, z6, vertical5, horizontal4, flingBehavior4, z7, scalingParams3, i20, autoCenteringParams3, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ScalingLazyColumn_8g7MjcI$lambda$1(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ScalingLazyColumn_8g7MjcI$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ScalingLazyColumnItemWrapper(final int i, final ScalingLazyListState scalingLazyListState, final ScalingLazyListItemScope scalingLazyListItemScope, final Function3<? super ScalingLazyListItemScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1825096345);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScalingLazyColumnItemWrapper)P(1,3,2)672@33005L1384,671@32958L1473:ScalingLazyColumn.kt#gj9v0t");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(scalingLazyListState) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(scalingLazyListItemScope) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i3 & 1171) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1825096345, i3, -1, "androidx.wear.compose.material.ScalingLazyColumnItemWrapper (ScalingLazyColumn.kt:670)");
            }
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -606403688, "CC(remember):ScalingLazyColumn.kt#9igjgp");
            boolean z = ((i3 & 112) == 32) | ((i3 & 14) == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt$ScalingLazyColumnItemWrapper$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GraphicsLayerScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                        ScalingLazyListItemInfo scalingLazyListItemInfo;
                        Object value = scalingLazyListState.getReverseLayout$compose_material_release().getValue();
                        Intrinsics.checkNotNull(value);
                        boolean zBooleanValue = ((Boolean) value).booleanValue();
                        Object value2 = scalingLazyListState.getAnchorType$compose_material_release().getValue();
                        Intrinsics.checkNotNull(value2);
                        int type = ((ScalingLazyListAnchorType) value2).getType();
                        List<ScalingLazyListItemInfo> listInternalVisibleItemInfo = ScalingLazyListStateKt.internalVisibleItemInfo(scalingLazyListState.getLayoutInfo());
                        int i4 = i;
                        int size = listInternalVisibleItemInfo.size();
                        int i5 = 0;
                        while (true) {
                            if (i5 >= size) {
                                scalingLazyListItemInfo = null;
                                break;
                            }
                            scalingLazyListItemInfo = listInternalVisibleItemInfo.get(i5);
                            if (scalingLazyListItemInfo.getIndex() == i4) {
                                break;
                            } else {
                                i5++;
                            }
                        }
                        ScalingLazyListItemInfo scalingLazyListItemInfo2 = scalingLazyListItemInfo;
                        if (scalingLazyListItemInfo2 != null) {
                            graphicsLayerScope.setAlpha(scalingLazyListItemInfo2.getAlpha());
                            graphicsLayerScope.setScaleX(scalingLazyListItemInfo2.getScale());
                            graphicsLayerScope.setScaleY(scalingLazyListItemInfo2.getScale());
                            if (scalingLazyListItemInfo2.getScale() > 0.0f) {
                                float fM757startOffsetnK7FVxM = ScalingLazyColumnMeasureKt.m757startOffsetnK7FVxM(scalingLazyListItemInfo2, type) - ScalingLazyColumnMeasureKt.m758unadjustedStartOffsetnK7FVxM(scalingLazyListItemInfo2, type);
                                if (zBooleanValue) {
                                    fM757startOffsetnK7FVxM = -fM757startOffsetnK7FVxM;
                                }
                                graphicsLayerScope.setTranslationY(fM757startOffsetnK7FVxM);
                                graphicsLayerScope.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, zBooleanValue ? 1.0f : 0.0f));
                            }
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composer2 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1830136607, "C698@34416L9:ScalingLazyColumn.kt#gj9v0t");
            function3.invoke(scalingLazyListItemScope, composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 126));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt.ScalingLazyColumnItemWrapper.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ScalingLazyColumnKt.ScalingLazyColumnItemWrapper(i, scalingLazyListState, scalingLazyListItemScope, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier autoCenteringHeight(Modifier modifier, final Function0<Integer> function0) {
        return LayoutModifierKt.layout(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt.autoCenteringHeight.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m754invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).unbox-impl());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m754invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                int iIntValue = ((Number) function0.invoke()).intValue();
                final Placeable placeable = measurable.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(j, 0, 0, iIntValue, iIntValue, 3, (Object) null));
                return MeasureScope.layout$default(measureScope, placeable.getWidth(), placeable.getHeight(), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnKt.autoCenteringHeight.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Placeable.PlacementScope placementScope) {
                        Placeable.PlacementScope.place-70tqf50$default(placementScope, placeable, IntOffset.Companion.getZero-nOcc-ac(), 0.0f, 2, (Object) null);
                    }
                }, 4, (Object) null);
            }
        });
    }
}
