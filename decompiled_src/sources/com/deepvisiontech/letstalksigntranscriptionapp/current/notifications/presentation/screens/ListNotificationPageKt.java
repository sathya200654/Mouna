package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SelectableChipColors;
import androidx.compose.material3.SelectableChipElevation;
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
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationResponseType;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ListNotificationPage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ar\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\fH\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"ListNotificationPage", "", "modifier", "Landroidx/compose/ui/Modifier;", "pageData", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData;", "selectedOptions", "", "", "onSubmitClick", "Lkotlin/Function0;", "onCancelClick", "Lkotlin/Function1;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;", "onOptionSelect", "Lkotlin/ParameterName;", "name", "option", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData;Ljava/util/Set;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ListNotificationPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListNotificationPage$lambda$16(Modifier modifier, NotificationData notificationData, Set set, Function0 function0, Function1 function1, Function1 function2, int i, int i2, Composer composer, int i3) {
        ListNotificationPage(modifier, notificationData, set, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ListNotificationPage(Modifier modifier, final NotificationData notificationData, final Set<String> set, final Function0<Unit> function0, final Function1<? super NotificationResponseType, Unit> function1, final Function1<? super String, Unit> function2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        Composer composer2;
        final Modifier modifier3;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(notificationData, "pageData");
        Intrinsics.checkNotNullParameter(set, "selectedOptions");
        Intrinsics.checkNotNullParameter(function0, "onSubmitClick");
        Intrinsics.checkNotNullParameter(function1, "onCancelClick");
        Intrinsics.checkNotNullParameter(function2, "onOptionSelect");
        Composer composerStartRestartGroup = composer.startRestartGroup(947400001);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ListNotificationPage)P(!1,4,5,3)32@1427L3310:ListNotificationPage.kt#om2ogl");
        int i5 = i2 & 1;
        if (i5 != 0) {
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
            i3 |= composerStartRestartGroup.changedInstance(notificationData) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(set) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        int i6 = i3;
        if ((196608 & i) == 0) {
            i4 = i6 | (composerStartRestartGroup.changedInstance(function2) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES);
        } else {
            i4 = i6;
        }
        if (!composerStartRestartGroup.shouldExecute((i4 & 74899) != 74898, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i5 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(947400001, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ListNotificationPage (ListNotificationPage.kt:31)");
            }
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            int i7 = i4;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1156954164, "C36@1539L1897,86@3446L1285:ListNotificationPage.kt#om2ogl");
            float f = 8;
            Modifier modifierWeight$default = ColumnScope.weight$default(columnScope, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(f), 0.0f, 2, (Object) null), 1.0f, false, 2, (Object) null);
            Alignment.Horizontal centerHorizontally2 = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center, centerHorizontally2, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -64656971, "C45@1880L10,46@1945L11,43@1793L282,53@2175L10,51@2089L218,60@2414L1012,58@2321L1105:ListNotificationPage.kt#om2ogl");
            Modifier modifier5 = modifier4;
            float f2 = 4;
            TextKt.Text-Nvy7gAk(notificationData.getPageTitle(), PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), composerStartRestartGroup, 1572912, 0, 131000);
            TextKt.Text-Nvy7gAk(notificationData.getPageBody(), PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 48, 0, 130044);
            Alignment.Horizontal centerHorizontally3 = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1248992447, "CC(remember):ListNotificationPage.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(notificationData) | composerStartRestartGroup.changedInstance(set) | ((458752 & i7) == 131072);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ListNotificationPageKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return ListNotificationPageKt.ListNotificationPage$lambda$15$lambda$5$lambda$4$lambda$3(notificationData, set, function2, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LazyDslKt.LazyColumn((Modifier) null, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, centerHorizontally3, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) objRememberedValue, composerStartRestartGroup, 196608, 479);
            Composer composer5 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), 0.0f, 1, (Object) null);
            Alignment.Horizontal centerHorizontally4 = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            ComposerKt.sourceInformationMarkerStart(composer5, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(spaceEvenly, centerHorizontally4, composer5, 54);
            ComposerKt.sourceInformationMarkerStart(composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer5, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer5.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer5, modifierFillMaxWidth$default);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer5.startReusableNode();
            if (composer5.getInserting()) {
                composer5.createNode(constructor3);
            } else {
                composer5.useNode();
            }
            Composer composer6 = Updater.constructor-impl(composer5);
            Updater.set-impl(composer6, measurePolicyColumnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer6, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer6, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer6, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer5, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer5, 1357434750, "C:ListNotificationPage.kt#om2ogl");
            final NotificationResponseType primaryAction = notificationData.getPrimaryAction();
            if (primaryAction == null) {
                composer5.startReplaceGroup(1357445226);
                composer5.endReplaceGroup();
                z = true;
                z2 = false;
            } else {
                composer5.startReplaceGroup(1357445227);
                ComposerKt.sourceInformation(composer5, "*95@3784L63,99@3960L11,100@4047L11,98@3893L204,102@4116L185,94@3742L559");
                ComposerKt.sourceInformationMarkerStart(composer5, -1519666438, "CC(remember):ListNotificationPage.kt#9igjgp");
                boolean z3 = (i7 & 7168) == 2048;
                Object objRememberedValue2 = composer5.rememberedValue();
                if (z3 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ListNotificationPageKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            return ListNotificationPageKt.ListNotificationPage$lambda$15$lambda$14$lambda$9$lambda$7$lambda$6(function0);
                        }
                    };
                    composer5.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer5);
                z = true;
                z2 = false;
                ButtonKt.TextButton((Function0) objRememberedValue2, (Modifier) null, false, (Shape) null, ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer5, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composer5, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0L, 0L, composer5, ButtonDefaults.$stable << 12, 12), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-794341794, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ListNotificationPageKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ListNotificationPageKt.ListNotificationPage$lambda$15$lambda$14$lambda$9$lambda$8(primaryAction, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer5, 54), composer5, 805306368, 494);
                composer5 = composer5;
                Unit unit = Unit.INSTANCE;
                composer5.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            final NotificationResponseType secondaryAction = notificationData.getSecondaryAction();
            if (secondaryAction == null) {
                composer5.startReplaceGroup(1358068047);
                composer5.endReplaceGroup();
                composer2 = composer5;
            } else {
                composer5.startReplaceGroup(1358068048);
                ComposerKt.sourceInformation(composer5, "*112@4419L87,115@4525L182,111@4377L330");
                ComposerKt.sourceInformationMarkerStart(composer5, 1700382473, "CC(remember):ListNotificationPage.kt#9igjgp");
                boolean zChangedInstance2 = composer5.changedInstance(notificationData) | ((i7 & 57344) == 16384 ? z : z2);
                Object objRememberedValue3 = composer5.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ListNotificationPageKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            return ListNotificationPageKt.ListNotificationPage$lambda$15$lambda$14$lambda$13$lambda$11$lambda$10(function1, notificationData);
                        }
                    };
                    composer5.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer5);
                composer2 = composer5;
                ButtonKt.TextButton((Function0) objRememberedValue3, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-1520083115, z, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ListNotificationPageKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ListNotificationPageKt.ListNotificationPage$lambda$15$lambda$14$lambda$13$lambda$12(secondaryAction, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer5, 54), composer2, 805306368, 510);
                Unit unit3 = Unit.INSTANCE;
                composer2.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ListNotificationPageKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    return ListNotificationPageKt.ListNotificationPage$lambda$16(modifier3, notificationData, set, function0, function1, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListNotificationPage$lambda$15$lambda$5$lambda$4$lambda$3(NotificationData notificationData, final Set set, final Function1 function1, LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyColumn");
        final List<String> optionsList = notificationData.getOptionsList();
        if (optionsList != null) {
            final ListNotificationPageKt$ListNotificationPage$lambda$15$lambda$5$lambda$4$lambda$3$lambda$2$$inlined$items$default$1 listNotificationPageKt$ListNotificationPage$lambda$15$lambda$5$lambda$4$lambda$3$lambda$2$$inlined$items$default$1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ListNotificationPageKt$ListNotificationPage$lambda$15$lambda$5$lambda$4$lambda$3$lambda$2$$inlined$items$default$1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final Void m1747invoke(String str) {
                    return null;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return m1747invoke((String) obj);
                }
            };
            lazyListScope.items(optionsList.size(), (Function1) null, new Function1<Integer, Object>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ListNotificationPageKt$ListNotificationPage$lambda$15$lambda$5$lambda$4$lambda$3$lambda$2$$inlined$items$default$3
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Object invoke(int i) {
                    return listNotificationPageKt$ListNotificationPage$lambda$15$lambda$5$lambda$4$lambda$3$lambda$2$$inlined$items$default$1.invoke(optionsList.get(i));
                }
            }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ListNotificationPageKt$ListNotificationPage$lambda$15$lambda$5$lambda$4$lambda$3$lambda$2$$inlined$items$default$4
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                    int i3;
                    ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                    if ((i2 & 6) == 0) {
                        i3 = i2 | (composer.changed(lazyItemScope) ? 4 : 2);
                    } else {
                        i3 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        i3 |= composer.changed(i) ? 32 : 16;
                    }
                    if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    final String str = (String) optionsList.get(i);
                    composer.startReplaceGroup(1980155657);
                    ComposerKt.sourceInformation(composer, "C*65@2649L86,68@2773L371,63@2526L846:ListNotificationPage.kt#om2ogl");
                    boolean zContains = set.contains(StringsKt.trim(str).toString());
                    ComposerKt.sourceInformationMarkerStart(composer, 1310805154, "CC(remember):ListNotificationPage.kt#9igjgp");
                    boolean zChanged = composer.changed(function1) | composer.changed(str);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        final Function1 function2 = function1;
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ListNotificationPageKt$ListNotificationPage$1$1$1$1$1$1$1$1
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m1746invoke();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m1746invoke() {
                                function2.invoke(str);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ChipKt.FilterChip(zContains, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(1425991071, true, new Function2<Composer, Integer, Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ListNotificationPageKt$ListNotificationPage$1$1$1$1$1$1$2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i4) {
                            ComposerKt.sourceInformation(composer2, "C71@2922L10,69@2807L307:ListNotificationPage.kt#om2ogl");
                            if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1425991071, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ListNotificationPage.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ListNotificationPage.kt:69)");
                            }
                            TextKt.Text-Nvy7gAk(str, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge(), composer2, 48, 0, 130044);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer, 54), SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(2), 1, (Object) null), Dp.constructor-impl(56)), false, (Function2) null, (Function2) null, (Shape) null, (SelectableChipColors) null, (SelectableChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, composer, 3456, 0, 4080);
                    composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListNotificationPage$lambda$15$lambda$14$lambda$9$lambda$7$lambda$6(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListNotificationPage$lambda$15$lambda$14$lambda$9$lambda$8(NotificationResponseType notificationResponseType, RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C105@4237L10,103@4138L145:ListNotificationPage.kt#om2ogl");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-794341794, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ListNotificationPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ListNotificationPage.kt:103)");
            }
            TextKt.Text-Nvy7gAk(notificationResponseType.getDisplayText(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getHeadlineSmall(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListNotificationPage$lambda$15$lambda$14$lambda$13$lambda$11$lambda$10(Function1 function1, NotificationData notificationData) {
        function1.invoke(notificationData.getSecondaryAction());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListNotificationPage$lambda$15$lambda$14$lambda$13$lambda$12(NotificationResponseType notificationResponseType, RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C118@4646L10,116@4547L142:ListNotificationPage.kt#om2ogl");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520083115, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ListNotificationPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ListNotificationPage.kt:116)");
            }
            TextKt.Text-Nvy7gAk(notificationResponseType.getDisplayText(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
