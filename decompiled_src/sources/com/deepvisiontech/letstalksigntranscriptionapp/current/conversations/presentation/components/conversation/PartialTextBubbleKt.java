package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PartialTextBubble.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"PartialTextBubble", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "baseFontSize", "Landroidx/compose/ui/unit/TextUnit;", "PartialTextBubble-a5Y-_hM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PartialTextBubbleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PartialTextBubble_a5Y__hM$lambda$2(String str, Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        m1595PartialTextBubblea5Y_hM(str, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0049  */
    /* JADX WARN: Code duplicated, block: B:24:0x004c  */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    /* JADX WARN: Code duplicated, block: B:29:0x005b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x0073 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:42:0x007d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0088  */
    /* JADX WARN: Code duplicated, block: B:48:0x010f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0115  */
    /* JADX WARN: Code duplicated, block: B:53:0x0121  */
    /* JADX WARN: Code duplicated, block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: PartialTextBubble-a5Y-_hM, reason: not valid java name */
    public static final void m1595PartialTextBubblea5Y_hM(final String str, Modifier modifier, long j, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        long sp;
        int i5;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(str, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-723189782);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PartialTextBubble)P(2,1,0:c#ui.unit.TextUnit)24@906L11,25@978L11,23@843L176,27@1051L6,28@1098L68,31@1173L335,21@770L738:PartialTextBubble.kt#hsonup");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    sp = j;
                    if (composerStartRestartGroup.changed(sp)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i3 & 147) != 146) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j2 = sp;
                } else {
                    if (i6 != 0) {
                        modifier4 = (Modifier) Modifier.Companion;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        sp = TextUnitKt.getSp(16);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-723189782, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.PartialTextBubble (PartialTextBubble.kt:20)");
                    }
                    final long j3 = sp;
                    Modifier modifier5 = modifier4;
                    CardKt.ElevatedCard(modifier5, MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getSmall(), CardDefaults.INSTANCE.elevatedCardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnTertiaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12), CardDefaults.INSTANCE.elevatedCardElevation-aqJV_2Y(Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (CardDefaults.$stable << 18) | 6, 62), ComposableLambdaKt.rememberComposableLambda(-24645681, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.PartialTextBubbleKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PartialTextBubbleKt.PartialTextBubble_a5Y__hM$lambda$1(j3, str, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 24576, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                    j2 = j3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.PartialTextBubbleKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            return PartialTextBubbleKt.PartialTextBubble_a5Y__hM$lambda$2(str, modifier3, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            sp = j;
            if ((i3 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j2 = sp;
            } else {
                if (i6 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    sp = TextUnitKt.getSp(16);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-723189782, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.PartialTextBubble (PartialTextBubble.kt:20)");
                }
                final long j4 = sp;
                Modifier modifier6 = modifier4;
                CardKt.ElevatedCard(modifier6, MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getSmall(), CardDefaults.INSTANCE.elevatedCardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnTertiaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12), CardDefaults.INSTANCE.elevatedCardElevation-aqJV_2Y(Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (CardDefaults.$stable << 18) | 6, 62), ComposableLambdaKt.rememberComposableLambda(-24645681, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.PartialTextBubbleKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PartialTextBubbleKt.PartialTextBubble_a5Y__hM$lambda$1(j4, str, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 24576, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier6;
                j2 = j4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.PartialTextBubbleKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        return PartialTextBubbleKt.PartialTextBubble_a5Y__hM$lambda$2(str, modifier3, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                sp = j;
                if (composerStartRestartGroup.changed(sp)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i3 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j2 = sp;
            } else {
                if (i6 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    sp = TextUnitKt.getSp(16);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-723189782, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.PartialTextBubble (PartialTextBubble.kt:20)");
                }
                final long j5 = sp;
                Modifier modifier7 = modifier4;
                CardKt.ElevatedCard(modifier7, MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getSmall(), CardDefaults.INSTANCE.elevatedCardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnTertiaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12), CardDefaults.INSTANCE.elevatedCardElevation-aqJV_2Y(Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (CardDefaults.$stable << 18) | 6, 62), ComposableLambdaKt.rememberComposableLambda(-24645681, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.PartialTextBubbleKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PartialTextBubbleKt.PartialTextBubble_a5Y__hM$lambda$1(j5, str, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 24576, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier7;
                j2 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.PartialTextBubbleKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        return PartialTextBubbleKt.PartialTextBubble_a5Y__hM$lambda$2(str, modifier3, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        sp = j;
        if ((i3 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j2 = sp;
        } else {
            if (i6 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                sp = TextUnitKt.getSp(16);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-723189782, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.PartialTextBubble (PartialTextBubble.kt:20)");
            }
            final long j6 = sp;
            Modifier modifier8 = modifier4;
            CardKt.ElevatedCard(modifier8, MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getSmall(), CardDefaults.INSTANCE.elevatedCardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnTertiaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12), CardDefaults.INSTANCE.elevatedCardElevation-aqJV_2Y(Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (CardDefaults.$stable << 18) | 6, 62), ComposableLambdaKt.rememberComposableLambda(-24645681, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.PartialTextBubbleKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PartialTextBubbleKt.PartialTextBubble_a5Y__hM$lambda$1(j6, str, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 24576, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier8;
            j2 = j6;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.PartialTextBubbleKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return PartialTextBubbleKt.PartialTextBubble_a5Y__hM$lambda$2(str, modifier3, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PartialTextBubble_a5Y__hM$lambda$1(long j, String str, ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, "$this$ElevatedCard");
        ComposerKt.sourceInformation(composer, "C32@1183L319:PartialTextBubble.kt#hsonup");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-24645681, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.PartialTextBubble.<anonymous> (PartialTextBubble.kt:32)");
            }
            Modifier modifier = PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composer2 = Updater.constructor-impl(composer);
            Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1157043774, "C39@1471L7,35@1292L200:PartialTextBubble.kt#hsonup");
            long sp = TextUnitKt.getSp(TextUnit.getValue-impl(j) * 1.4f);
            CompositionLocal localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.Text-Nvy7gAk(str, (Modifier) null, ((Color) objConsume).unbox-impl(), (TextAutoSize) null, j, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, sp, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 260074);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
