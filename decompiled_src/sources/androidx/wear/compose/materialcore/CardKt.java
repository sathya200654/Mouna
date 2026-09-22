package androidx.wear.compose.materialcore;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.grpc.internal.GrpcUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Card.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aù\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u001e\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u001e\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001e\u001a\u008c\u0001\u0010\u001f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"AppCard", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "border", "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "containerPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "ripple", "Landroidx/compose/foundation/Indication;", "appImage", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "appName", "time", "title", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/Indication;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Card", "role", "Landroidx/compose/ui/semantics/Role;", "Card-IFFyuRQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/semantics/Role;Landroidx/compose/foundation/Indication;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "compose-material-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CardKt {
    /* JADX INFO: renamed from: Card-IFFyuRQ, reason: not valid java name */
    public static final void m908CardIFFyuRQ(final Function0<Unit> function0, final Modifier modifier, final BorderStroke borderStroke, final Painter painter, final boolean z, final PaddingValues paddingValues, final Shape shape, final MutableInteractionSource mutableInteractionSource, final Role role, final Indication indication, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function1;
        int i3;
        boolean z2;
        int i4;
        Modifier modifierBorder;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1663785310);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Card)P(7,6!2,4,3,10,5,9:c#ui.semantics.Role,8)99@4515L686:Card.kt#f7tims");
        if ((i & 6) == 0) {
            function1 = function0;
            i3 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            function1 = function0;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(borderStroke) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(painter) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            z2 = z;
            i3 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        } else {
            z2 = z;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(paddingValues) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        }
        if ((100663296 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(role) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(indication) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changedInstance(function3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i3 & 306783379) != 306783378 || (i4 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1663785310, i3, i4, "androidx.wear.compose.materialcore.Card (Card.kt:98)");
            }
            int i5 = i4;
            Modifier modifier2 = ClickableKt.clickable-O2vRcR0$default(PainterModifierKt.paint$default(ClipKt.clip(IntrinsicKt.height(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, (Object) null), IntrinsicSize.Min), shape), painter, false, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 54, (Object) null), mutableInteractionSource, indication, z2, (String) null, role, function1, 8, (Object) null);
            if (borderStroke == null || (modifierBorder = BorderKt.border(Modifier.Companion, borderStroke, shape)) == null) {
                modifierBorder = Modifier.Companion;
            }
            Modifier modifierPadding = PaddingKt.padding(modifier2.then(modifierBorder), paddingValues);
            int i6 = (i5 << 9) & 7168;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding);
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
            Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            function3.invoke(ColumnScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i6 >> 6) & 112) | 6));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.CardKt$Card$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i7) {
                    CardKt.m908CardIFFyuRQ(function0, modifier, borderStroke, painter, z, paddingValues, shape, mutableInteractionSource, role, indication, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    public static final void AppCard(final Function0<Unit> function0, final Modifier modifier, final boolean z, final BorderStroke borderStroke, final PaddingValues paddingValues, final Painter painter, final MutableInteractionSource mutableInteractionSource, final Shape shape, final Indication indication, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function5, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function6, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function7, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z2;
        BorderStroke borderStroke2;
        PaddingValues paddingValues2;
        int i4;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-993820277);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AppCard)P(9,8,6,2,5,3,7,11,10!2,12,13)204@9333L737,193@9012L1058:Card.kt#f7tims");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i & 384) == 0) {
            z2 = z;
            i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        } else {
            z2 = z;
        }
        int i5 = i & 3072;
        int i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
        if (i5 == 0) {
            borderStroke2 = borderStroke;
            i3 |= composerStartRestartGroup.changed(borderStroke2) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        } else {
            borderStroke2 = borderStroke;
        }
        if ((i & 24576) == 0) {
            paddingValues2 = paddingValues;
            i3 |= composerStartRestartGroup.changed(paddingValues2) ? 16384 : 8192;
        } else {
            paddingValues2 = paddingValues;
        }
        if ((i & 196608) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(painter) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(indication) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changedInstance(function4) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function5) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function6) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(function7)) {
                i6 = RecyclerView.ItemAnimator.FLAG_MOVED;
            }
            i4 |= i6;
        }
        int i7 = i4;
        if ((i3 & 306783379) != 306783378 || (i7 & 1171) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-993820277, i3, i7, "androidx.wear.compose.materialcore.AppCard (Card.kt:192)");
            }
            int i8 = i3 >> 3;
            int i9 = i3 << 3;
            composer2 = composerStartRestartGroup;
            Modifier modifier3 = modifier2;
            boolean z3 = z2;
            BorderStroke borderStroke3 = borderStroke2;
            m908CardIFFyuRQ(function0, modifier3, borderStroke3, painter, z3, paddingValues2, shape, mutableInteractionSource, null, indication, ComposableLambdaKt.rememberComposableLambda(1822941799, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.CardKt.AppCard.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((ColumnScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope columnScope, Composer composer3, int i10) {
                    ComposerKt.sourceInformation(composer3, "C205@9343L721:Card.kt#f7tims");
                    if ((i10 & 17) != 16 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1822941799, i10, -1, "androidx.wear.compose.materialcore.AppCard.<anonymous> (Card.kt:205)");
                        }
                        Function3<RowScope, Composer, Integer, Unit> function8 = function6;
                        Function3<ColumnScope, Composer, Integer, Unit> function9 = function7;
                        Function3<RowScope, Composer, Integer, Unit> function10 = function3;
                        Function3<RowScope, Composer, Integer, Unit> function11 = function4;
                        Function3<RowScope, Composer, Integer, Unit> function12 = function5;
                        ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Modifier modifier4 = Modifier.Companion;
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer3, 0);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifier4);
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer composer4 = Updater.constructor-impl(composer3);
                        Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer4.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 1806694340, "C206@9364L436,221@9813L40,222@9866L166,227@10045L9:Card.kt#f7tims");
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default);
                        Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor2);
                        } else {
                            composer3.useNode();
                        }
                        Composer composer5 = Updater.constructor-impl(composer3);
                        Updater.set-impl(composer5, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer5, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (composer5.getInserting() || !Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composer5.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.set-impl(composer5, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                        RowScope rowScope = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -1763337399, "C214@9646L9,215@9672L40:Card.kt#f7tims");
                        composer3.startReplaceGroup(1744233619);
                        ComposerKt.sourceInformation(composer3, "*211@9552L10,212@9583L28");
                        if (function10 != null) {
                            function10.invoke(rowScope, composer3, 6);
                            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), composer3, 6);
                        }
                        composer3.endReplaceGroup();
                        function11.invoke(rowScope, composer3, 6);
                        SpacerKt.Spacer(RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null), composer3, 0);
                        composer3.startReplaceGroup(1744240286);
                        ComposerKt.sourceInformation(composer3, "*218@9762L6");
                        if (function12 != null) {
                            function12.invoke(rowScope, composer3, 6);
                        }
                        composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), composer3, 6);
                        Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer3, 48);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default2);
                        Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor3);
                        } else {
                            composer3.useNode();
                        }
                        Composer composer6 = Updater.constructor-impl(composer3);
                        Updater.set-impl(composer6, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer6, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            composer6.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.set-impl(composer6, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                        function8.invoke(RowScopeInstance.INSTANCE, composer3, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        function9.invoke(columnScope2, composer3, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composer2, (i3 & 14) | 100663296 | (i3 & 112) | (i8 & 896) | ((i3 >> 6) & 7168) | (57344 & (i3 << 6)) | (458752 & i9) | (i8 & 3670016) | (29360128 & i9) | (1879048192 & i9), 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.CardKt.AppCard.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i10) {
                    CardKt.AppCard(function0, modifier, z, borderStroke, paddingValues, painter, mutableInteractionSource, shape, indication, function3, function4, function5, function6, function7, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }
}
