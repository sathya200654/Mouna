package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens;

import android.content.Context;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.BrokenImageKt;
import androidx.compose.material.icons.filled.ImageKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.RecyclerView;
import coil3.compose.SingletonAsyncImageKt;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationResponseType;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageNotificationPage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aG\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"ImageNotificationPage", "", "modifier", "Landroidx/compose/ui/Modifier;", "pageData", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData;", "onSubmitClick", "Lkotlin/Function1;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;", "onCancelClick", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ImageNotificationPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
    public static final Unit ImageNotificationPage$lambda$12(Modifier modifier, NotificationData notificationData, Function1 function1, Function1 function2, int i, int i2, Composer composer, int i3) throws KotlinNothingValueException {
        ImageNotificationPage(modifier, notificationData, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
    public static final void ImageNotificationPage(Modifier modifier, final NotificationData notificationData, final Function1<? super NotificationResponseType, Unit> function1, final Function1<? super NotificationResponseType, Unit> function2, Composer composer, final int i, final int i2) throws KotlinNothingValueException {
        Modifier modifier2;
        int i3;
        final Modifier modifier3;
        int i4;
        String str;
        Intrinsics.checkNotNullParameter(notificationData, "pageData");
        Intrinsics.checkNotNullParameter(function1, "onSubmitClick");
        Intrinsics.checkNotNullParameter(function2, "onCancelClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1203175265);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ImageNotificationPage)P(!1,3,2)37@1745L2814:ImageNotificationPage.kt#om2ogl");
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
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i5 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1203175265, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ImageNotificationPage (ImageNotificationPage.kt:36)");
            }
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
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
            Composer composer2 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1980996858, "C41@1857L1379,78@3246L1307:ImageNotificationPage.kt#om2ogl");
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
            Composer composer3 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1374449885, "C50@2198L10,51@2263L11,48@2111L282,58@2493L10,56@2407L218:ImageNotificationPage.kt#om2ogl");
            float f2 = 4;
            int i6 = i3;
            TextKt.Text-Nvy7gAk(notificationData.getPageTitle(), PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), composerStartRestartGroup, 1572912, 0, 131000);
            TextKt.Text-Nvy7gAk(notificationData.getPageBody(), PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 48, 0, 130044);
            composerStartRestartGroup = composerStartRestartGroup;
            String image = notificationData.getImage();
            if (image == null) {
                composerStartRestartGroup.startReplaceGroup(1374972667);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1374972668);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*65@2751L7,69@2903L50,70@2983L56,64@2677L535");
                CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SingletonAsyncImageKt.m1023AsyncImagex1rPTaM(ImageRequestsKt.crossfade(new ImageRequest.Builder((Context) objConsume).data(image), true).build(), null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(200)), VectorPainterKt.rememberVectorPainter(ImageKt.getImage(Icons.INSTANCE.getDefault()), composerStartRestartGroup, 0), VectorPainterKt.rememberVectorPainter(BrokenImageKt.getBrokenImage(Icons.INSTANCE.getDefault()), composerStartRestartGroup, 0), null, null, null, null, null, ContentScale.Companion.getCrop(), 0.0f, null, 0, false, composerStartRestartGroup, (VectorPainter.$stable << 9) | 432 | (VectorPainter.$stable << 12), 6, 31712);
                composerStartRestartGroup = composerStartRestartGroup;
                Unit unit = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), 0.0f, 1, (Object) null);
            Alignment.Horizontal centerHorizontally3 = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(spaceEvenly, centerHorizontally3, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composer4 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -864735862, "C:ImageNotificationPage.kt#om2ogl");
            final NotificationResponseType primaryAction = notificationData.getPrimaryAction();
            if (primaryAction == null) {
                composerStartRestartGroup.startReplaceGroup(-864725386);
                composerStartRestartGroup.endReplaceGroup();
                str = "CC(remember):ImageNotificationPage.kt#9igjgp";
                i4 = i6;
            } else {
                composerStartRestartGroup.startReplaceGroup(-864725385);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*87@3584L85,91@3782L11,92@3869L11,90@3715L204,94@3938L185,86@3542L581");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2069678610, "CC(remember):ImageNotificationPage.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(notificationData) | ((i6 & 896) == 256);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ImageNotificationPageKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            return ImageNotificationPageKt.ImageNotificationPage$lambda$11$lambda$10$lambda$5$lambda$3$lambda$2(function1, notificationData);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i4 = i6;
                str = "CC(remember):ImageNotificationPage.kt#9igjgp";
                Composer composer5 = composerStartRestartGroup;
                ButtonKt.TextButton((Function0) objRememberedValue, (Modifier) null, false, (Shape) null, ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(741549372, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ImageNotificationPageKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ImageNotificationPageKt.ImageNotificationPage$lambda$11$lambda$10$lambda$5$lambda$4(primaryAction, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer5, 805306368, 494);
                composerStartRestartGroup = composer5;
                Unit unit3 = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            }
            final NotificationResponseType secondaryAction = notificationData.getSecondaryAction();
            if (secondaryAction == null) {
                composerStartRestartGroup.startReplaceGroup(-864081423);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-864081422);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4241L87,107@4347L182,103@4199L330");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1778531431, str);
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(notificationData) | ((i4 & 7168) == 2048);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ImageNotificationPageKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            return ImageNotificationPageKt.ImageNotificationPage$lambda$11$lambda$10$lambda$9$lambda$7$lambda$6(function2, notificationData);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Composer composer6 = composerStartRestartGroup;
                ButtonKt.TextButton((Function0) objRememberedValue2, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(42053811, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ImageNotificationPageKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ImageNotificationPageKt.ImageNotificationPage$lambda$11$lambda$10$lambda$9$lambda$8(secondaryAction, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer6, 805306368, 510);
                composerStartRestartGroup = composer6;
                Unit unit5 = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
                Unit unit6 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ImageNotificationPageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    return ImageNotificationPageKt.ImageNotificationPage$lambda$12(modifier3, notificationData, function1, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageNotificationPage$lambda$11$lambda$10$lambda$5$lambda$3$lambda$2(Function1 function1, NotificationData notificationData) {
        function1.invoke(notificationData.getPrimaryAction());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageNotificationPage$lambda$11$lambda$10$lambda$5$lambda$4(NotificationResponseType notificationResponseType, RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C97@4059L10,95@3960L145:ImageNotificationPage.kt#om2ogl");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(741549372, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ImageNotificationPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ImageNotificationPage.kt:95)");
            }
            TextKt.Text-Nvy7gAk(notificationResponseType.getDisplayText(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getHeadlineSmall(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageNotificationPage$lambda$11$lambda$10$lambda$9$lambda$7$lambda$6(Function1 function1, NotificationData notificationData) {
        function1.invoke(notificationData.getSecondaryAction());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageNotificationPage$lambda$11$lambda$10$lambda$9$lambda$8(NotificationResponseType notificationResponseType, RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C110@4468L10,108@4369L142:ImageNotificationPage.kt#om2ogl");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(42053811, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.ImageNotificationPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ImageNotificationPage.kt:108)");
            }
            TextKt.Text-Nvy7gAk(notificationResponseType.getDisplayText(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
