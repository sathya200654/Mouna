package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.components;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CalendarMonthKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.RecyclerView;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.utils.DateTimeUtilsKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.Notification;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationCard.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"NotificationCard", "", "modifier", "Landroidx/compose/ui/Modifier;", "notification", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/Notification;", "onNotificationLongPress", "Lkotlin/Function0;", "onNotificationClick", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/Notification;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NotificationCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationCard$lambda$5(Modifier modifier, Notification notification, Function0 function0, Function0 function1, int i, int i2, Composer composer, int i3) {
        NotificationCard(modifier, notification, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void NotificationCard(Modifier modifier, final Notification notification, final Function0<Unit> function0, final Function0<Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier modifier3;
        long j;
        long j2;
        BorderStroke borderStroke;
        Intrinsics.checkNotNullParameter(notification, "notification");
        Intrinsics.checkNotNullParameter(function0, "onNotificationLongPress");
        Intrinsics.checkNotNullParameter(function1, "onNotificationClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-903548121);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotificationCard)P(!2,3)42@1830L6,43@1878L19,44@1929L412,57@2481L1579,36@1618L2442:NotificationCard.kt#sbahtd");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(notification) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903548121, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.components.NotificationCard (NotificationCard.kt:35)");
            }
            Modifier modifier5 = ClickableKt.combinedClickable-hoGz1lA$default(modifier4, false, (String) null, (Role) null, (String) null, function0, (Function0) null, false, (MutableInteractionSource) null, function1, 239, (Object) null);
            Modifier modifier6 = modifier4;
            Shape medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getMedium();
            CardElevation cardElevation = CardDefaults.INSTANCE.cardElevation-aqJV_2Y(Dp.constructor-impl(6), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (CardDefaults.$stable << 18) | 6, 62);
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            if (notification.isSelected()) {
                composerStartRestartGroup.startReplaceGroup(-726330984);
                ComposerKt.sourceInformation(composerStartRestartGroup, "46@2029L11");
                j = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-726328521);
                ComposerKt.sourceInformation(composerStartRestartGroup, "48@2106L11");
                j = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU();
                composerStartRestartGroup.endReplaceGroup();
            }
            if (notification.isSelected()) {
                composerStartRestartGroup.startReplaceGroup(-726324806);
                ComposerKt.sourceInformation(composerStartRestartGroup, "50@2222L11");
                j2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnTertiaryContainer-0d7_KjU();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-726322279);
                ComposerKt.sourceInformation(composerStartRestartGroup, "52@2301L11");
                j2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU();
                composerStartRestartGroup.endReplaceGroup();
            }
            CardColors cardColors = cardDefaults.cardColors-ro_MJ88(j, j2, 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12);
            composer2 = composerStartRestartGroup;
            if (notification.isSelected()) {
                composer2.startReplaceGroup(-726319426);
                ComposerKt.sourceInformation(composer2, "55@2434L11");
                borderStroke = BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl(2), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getSecondary-0d7_KjU());
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1040998858);
                composer2.endReplaceGroup();
                borderStroke = null;
            }
            CardKt.Card(modifier5, medium, cardColors, cardElevation, borderStroke, ComposableLambdaKt.rememberComposableLambda(411246837, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.components.NotificationCardKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationCardKt.NotificationCard$lambda$4(notification, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 196608, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.components.NotificationCardKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return NotificationCardKt.NotificationCard$lambda$5(modifier3, notification, function0, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationCard$lambda$4(Notification notification, ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, "$this$Card");
        ComposerKt.sourceInformation(composer, "C58@2491L1563:NotificationCard.kt#sbahtd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(411246837, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.components.NotificationCard.<anonymous> (NotificationCard.kt:58)");
            }
            Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12));
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1771531234, "C64@2721L10,62@2634L229,79@3212L40,81@3266L778:NotificationCard.kt#sbahtd");
            float f = 4;
            TextKt.Text-Nvy7gAk(notification.getTitle(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(f), 7, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 1572912, 0, 131004);
            Composer composer3 = composer;
            String body = notification.getBody();
            if (body == null) {
                composer3.startReplaceGroup(1771756788);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(1771756789);
                ComposerKt.sourceInformation(composer3, "*72@2997L10,70@2918L266");
                TextKt.Text-Nvy7gAk(body, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(f), 7, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 2, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getLabelLarge(), composer, 48, 24576, 113660);
                composer3 = composer;
                Unit unit = Unit.INSTANCE;
                composer3.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer3, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer3, 54);
            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor2);
            } else {
                composer3.useNode();
            }
            Composer composer4 = Updater.constructor-impl(composer3);
            Updater.set-impl(composer4, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, -1543268035, "C86@3475L555:NotificationCard.kt#sbahtd");
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier2 = Modifier.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer3, 48);
            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifier2);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor3);
            } else {
                composer3.useNode();
            }
            Composer composer5 = Updater.constructor-impl(composer3);
            Updater.set-impl(composer5, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer5, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer5, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, -620342275, "C87@3549L202,92@3772L39,95@3970L10,93@3832L180:NotificationCard.kt#sbahtd");
            IconKt.Icon-ww6aTOc(CalendarMonthKt.getCalendarMonth(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), 0L, composer3, 432, 8);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer3, 6);
            TextKt.Text-Nvy7gAk(DateTimeUtilsKt.convertMillisToLocalDateString(notification.getDateTime()), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodySmall(), composer, 0, 0, 131070);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
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
