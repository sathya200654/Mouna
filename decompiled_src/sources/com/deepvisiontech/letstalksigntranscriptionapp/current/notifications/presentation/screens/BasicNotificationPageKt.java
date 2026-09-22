package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.text.TextAutoSize;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BasicNotificationPage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"BasicNotificationPage", "", "pageData", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BasicNotificationPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicNotificationPage$lambda$1(NotificationData notificationData, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BasicNotificationPage(notificationData, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    /* JADX WARN: Code duplicated, block: B:24:0x0050  */
    /* JADX WARN: Code duplicated, block: B:27:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x005b  */
    /* JADX WARN: Code duplicated, block: B:29:0x0060  */
    /* JADX WARN: Code duplicated, block: B:32:0x0067  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:42:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:44:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:47:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    public static final void BasicNotificationPage(final NotificationData notificationData, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        boolean z;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        Function0 constructor;
        Intrinsics.checkNotNullParameter(notificationData, "pageData");
        Composer composerStartRestartGroup = composer.startRestartGroup(-830968215);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicNotificationPage)P(1)20@808L661:BasicNotificationPage.kt#om2ogl");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(notificationData) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i3 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
            } else {
                if (i4 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-830968215, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.BasicNotificationPage (BasicNotificationPage.kt:19)");
                }
                Modifier modifier4 = PaddingKt.padding-VpY3zN4$default(modifier3, Dp.constructor-impl(8), 0.0f, 2, (Object) null);
                Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composer3 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer3, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(composer3, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(composer3, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 603218930, "C27@1076L10,28@1137L11,25@997L258,35@1343L10,33@1265L198:BasicNotificationPage.kt#om2ogl");
                float f = 4;
                Modifier modifier5 = modifier3;
                composer2 = composerStartRestartGroup;
                TextKt.Text-Nvy7gAk(notificationData.getPageTitle(), PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), composer2, 1572912, 0, 131000);
                TextKt.Text-Nvy7gAk(notificationData.getPageBody(), PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 48, 0, 130044);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.BasicNotificationPageKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        return BasicNotificationPageKt.BasicNotificationPage$lambda$1(notificationData, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-830968215, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.BasicNotificationPage (BasicNotificationPage.kt:19)");
            }
            Modifier modifier6 = PaddingKt.padding-VpY3zN4$default(modifier3, Dp.constructor-impl(8), 0.0f, 2, (Object) null);
            Alignment.Horizontal centerHorizontally2 = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical center2 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center2, centerHorizontally2, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier6);
            constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composer4 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 603218930, "C27@1076L10,28@1137L11,25@997L258,35@1343L10,33@1265L198:BasicNotificationPage.kt#om2ogl");
            float f2 = 4;
            Modifier modifier7 = modifier3;
            composer2 = composerStartRestartGroup;
            TextKt.Text-Nvy7gAk(notificationData.getPageTitle(), PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), composer2, 1572912, 0, 131000);
            TextKt.Text-Nvy7gAk(notificationData.getPageBody(), PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 48, 0, 130044);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier7;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.BasicNotificationPageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    return BasicNotificationPageKt.BasicNotificationPage$lambda$1(notificationData, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
