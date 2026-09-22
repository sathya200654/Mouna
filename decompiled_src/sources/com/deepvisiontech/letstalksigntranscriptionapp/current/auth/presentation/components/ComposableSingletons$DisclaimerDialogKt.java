package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.TextUnitKt;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisclaimerDialog.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$DisclaimerDialogKt {
    public static final ComposableSingletons$DisclaimerDialogKt INSTANCE = new ComposableSingletons$DisclaimerDialogKt();

    /* JADX INFO: renamed from: lambda$-724757874, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f6lambda$724757874 = ComposableLambdaKt.composableLambdaInstance(-724757874, false, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.ComposableSingletons$DisclaimerDialogKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DisclaimerDialogKt.lambda__724757874$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1203832917 = ComposableLambdaKt.composableLambdaInstance(1203832917, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.ComposableSingletons$DisclaimerDialogKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DisclaimerDialogKt.lambda_1203832917$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-492190442, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f5lambda$492190442 = ComposableLambdaKt.composableLambdaInstance(-492190442, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.ComposableSingletons$DisclaimerDialogKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DisclaimerDialogKt.lambda__492190442$lambda$3((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-492190442$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1372getLambda$492190442$app_release() {
        return f5lambda$492190442;
    }

    /* JADX INFO: renamed from: getLambda$-724757874$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1373getLambda$724757874$app_release() {
        return f6lambda$724757874;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1203832917$app_release() {
        return lambda$1203832917;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1203832917$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C25@910L51,25@898L64:DisclaimerDialog.kt#bv2vsw");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1203832917, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.ComposableSingletons$DisclaimerDialogKt.lambda$1203832917.<anonymous> (DisclaimerDialog.kt:25)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.auth_disclaimer_title_info, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__492190442$lambda$3(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C30@1083L21,28@1003L337:DisclaimerDialog.kt#bv2vsw");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-492190442, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.ComposableSingletons$DisclaimerDialogKt.lambda$-492190442.<anonymous> (DisclaimerDialog.kt:28)");
            }
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(Modifier.Companion, ScrollKt.rememberScrollState(0, composer, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
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
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -433567877, "C33@1171L50,32@1138L188:DisclaimerDialog.kt#bv2vsw");
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.auth_disclaimer_desc_info, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getStart-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 24576, 0, 261102);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__724757874$lambda$0(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C41@1445L41,41@1440L47:DisclaimerDialog.kt#bv2vsw");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-724757874, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.ComposableSingletons$DisclaimerDialogKt.lambda$-724757874.<anonymous> (DisclaimerDialog.kt:41)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_action_ok, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
