package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.WarningKt;
import androidx.compose.material3.AlertDialogDefaults;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.grpc.internal.GrpcUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GenericConfirmationDialog.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aq\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"GenericConfirmationDialog", "", "modifier", "Landroidx/compose/ui/Modifier;", "onDismissRequest", "Lkotlin/Function0;", "onConfirmClick", "title", "", "description", "confirmText", "dismissText", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "isDestructive", "", "properties", "Landroidx/compose/ui/window/DialogProperties;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;ZLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GenericConfirmationDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GenericConfirmationDialog$lambda$8(Modifier modifier, Function0 function0, Function0 function1, String str, String str2, String str3, String str4, ImageVector imageVector, boolean z, DialogProperties dialogProperties, int i, int i2, Composer composer, int i3) {
        GenericConfirmationDialog(modifier, function0, function1, str, str2, str3, str4, imageVector, z, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x014f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:105:0x0151  */
    /* JADX WARN: Code duplicated, block: B:106:0x0156  */
    /* JADX WARN: Code duplicated, block: B:109:0x015b  */
    /* JADX WARN: Code duplicated, block: B:111:0x0169  */
    /* JADX WARN: Code duplicated, block: B:113:0x016c  */
    /* JADX WARN: Code duplicated, block: B:114:0x017c  */
    /* JADX WARN: Code duplicated, block: B:118:0x0189  */
    /* JADX WARN: Code duplicated, block: B:120:0x0194  */
    /* JADX WARN: Code duplicated, block: B:121:0x01af  */
    /* JADX WARN: Code duplicated, block: B:124:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:126:0x0204  */
    /* JADX WARN: Code duplicated, block: B:129:0x0213  */
    /* JADX WARN: Code duplicated, block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:80:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:82:0x0102  */
    /* JADX WARN: Code duplicated, block: B:84:0x010c  */
    /* JADX WARN: Code duplicated, block: B:85:0x010f  */
    /* JADX WARN: Code duplicated, block: B:90:0x0125  */
    /* JADX WARN: Code duplicated, block: B:91:0x0127  */
    /* JADX WARN: Code duplicated, block: B:94:0x0130  */
    /* JADX WARN: Code duplicated, block: B:96:0x013a  */
    public static final void GenericConfirmationDialog(Modifier modifier, final Function0<Unit> function0, final Function0<Unit> function1, final String str, final String str2, final String str3, final String str4, ImageVector imageVector, boolean z, DialogProperties dialogProperties, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        ImageVector warning;
        boolean z2;
        int i4;
        int i5;
        boolean z3;
        Composer composer2;
        final Modifier modifier3;
        final ImageVector imageVector2;
        final DialogProperties dialogProperties2;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        DialogProperties dialogProperties3;
        final Modifier modifier5;
        int i6;
        long j;
        int i7;
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function1, "onConfirmClick");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "confirmText");
        Intrinsics.checkNotNullParameter(str4, "dismissText");
        Composer composerStartRestartGroup = composer.startRestartGroup(111205805);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GenericConfirmationDialog)P(5,7,6,9,1)51@1924L2297,48@1833L2388:GenericConfirmationDialog.kt#mg9ln7");
        int i8 = i2 & 1;
        if (i8 != 0) {
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
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(str2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(str3) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(str4) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            if ((i2 & 128) == 0) {
                warning = imageVector;
                if (composerStartRestartGroup.changed(warning)) {
                    i7 = 8388608;
                }
                i3 |= i7;
            } else {
                warning = imageVector;
            }
            i7 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
            i3 |= i7;
        } else {
            warning = imageVector;
        }
        int i9 = i2 & 256;
        if (i9 == 0) {
            if ((100663296 & i) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
            }
            i4 = i2 & 512;
            if (i4 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i5 = 536870912;
                    } else {
                        i5 = 268435456;
                    }
                    i3 |= i5;
                }
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            modifier4 = (Modifier) Modifier.Companion;
                        } else {
                            modifier4 = modifier2;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                            warning = WarningKt.getWarning(Icons.INSTANCE.getDefault());
                        }
                        if (i9 != 0) {
                            z2 = true;
                        }
                        if (i4 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        modifier5 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                        }
                        dialogProperties3 = dialogProperties;
                        modifier5 = modifier2;
                    }
                    i6 = i3;
                    final ImageVector imageVector3 = warning;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(111205805, i6, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialog (GenericConfirmationDialog.kt:41)");
                    }
                    if (z2) {
                        composerStartRestartGroup.startReplaceGroup(1512768646);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "43@1749L11");
                        j = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getError-0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1512821284);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "45@1802L11");
                        j = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    final long j2 = j;
                    Modifier modifier6 = modifier5;
                    composer2 = composerStartRestartGroup;
                    DialogProperties dialogProperties4 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(570978102, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialogKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            return GenericConfirmationDialogKt.GenericConfirmationDialog$lambda$7(modifier5, imageVector3, j2, str, str2, function0, function1, str4, str3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, ((i6 >> 3) & 14) | 384 | ((i6 >> 24) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    imageVector2 = imageVector3;
                    dialogProperties2 = dialogProperties4;
                    modifier3 = modifier6;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    imageVector2 = warning;
                    dialogProperties2 = dialogProperties;
                }
                z4 = z2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialogKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            return GenericConfirmationDialogKt.GenericConfirmationDialog$lambda$8(modifier3, function0, function1, str, str2, str3, str4, imageVector2, z4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier4 = (Modifier) Modifier.Companion;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                        warning = WarningKt.getWarning(Icons.INSTANCE.getDefault());
                    }
                    if (i9 != 0) {
                        z2 = true;
                    }
                    if (i4 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    modifier5 = modifier4;
                } else {
                    if (i8 != 0) {
                        modifier4 = (Modifier) Modifier.Companion;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                        warning = WarningKt.getWarning(Icons.INSTANCE.getDefault());
                    }
                    if (i9 != 0) {
                        z2 = true;
                    }
                    if (i4 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    modifier5 = modifier4;
                }
                i6 = i3;
                final ImageVector imageVector4 = warning;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(111205805, i6, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialog (GenericConfirmationDialog.kt:41)");
                }
                if (z2) {
                    composerStartRestartGroup.startReplaceGroup(1512768646);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "43@1749L11");
                    j = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getError-0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1512821284);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "45@1802L11");
                    j = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                }
                final long j3 = j;
                Modifier modifier7 = modifier5;
                composer2 = composerStartRestartGroup;
                DialogProperties dialogProperties5 = dialogProperties3;
                AndroidDialog_androidKt.Dialog(function0, dialogProperties5, ComposableLambdaKt.rememberComposableLambda(570978102, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialogKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        return GenericConfirmationDialogKt.GenericConfirmationDialog$lambda$7(modifier5, imageVector4, j3, str, str2, function0, function1, str4, str3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i6 >> 3) & 14) | 384 | ((i6 >> 24) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                imageVector2 = imageVector4;
                dialogProperties2 = dialogProperties5;
                modifier3 = modifier7;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                imageVector2 = warning;
                dialogProperties2 = dialogProperties;
            }
            z4 = z2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialogKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        return GenericConfirmationDialogKt.GenericConfirmationDialog$lambda$8(modifier3, function0, function1, str, str2, str3, str4, imageVector2, z4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 100663296;
        z2 = z;
        i4 = i2 & 512;
        if (i4 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(dialogProperties)) {
                    i5 = 536870912;
                } else {
                    i5 = 268435456;
                }
                i3 |= i5;
            }
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier4 = (Modifier) Modifier.Companion;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                        warning = WarningKt.getWarning(Icons.INSTANCE.getDefault());
                    }
                    if (i9 != 0) {
                        z2 = true;
                    }
                    if (i4 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    modifier5 = modifier4;
                } else {
                    if (i8 != 0) {
                        modifier4 = (Modifier) Modifier.Companion;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                        warning = WarningKt.getWarning(Icons.INSTANCE.getDefault());
                    }
                    if (i9 != 0) {
                        z2 = true;
                    }
                    if (i4 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    modifier5 = modifier4;
                }
                i6 = i3;
                final ImageVector imageVector5 = warning;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(111205805, i6, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialog (GenericConfirmationDialog.kt:41)");
                }
                if (z2) {
                    composerStartRestartGroup.startReplaceGroup(1512768646);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "43@1749L11");
                    j = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getError-0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1512821284);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "45@1802L11");
                    j = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                }
                final long j4 = j;
                Modifier modifier8 = modifier5;
                composer2 = composerStartRestartGroup;
                DialogProperties dialogProperties6 = dialogProperties3;
                AndroidDialog_androidKt.Dialog(function0, dialogProperties6, ComposableLambdaKt.rememberComposableLambda(570978102, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialogKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        return GenericConfirmationDialogKt.GenericConfirmationDialog$lambda$7(modifier5, imageVector5, j4, str, str2, function0, function1, str4, str3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i6 >> 3) & 14) | 384 | ((i6 >> 24) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                imageVector2 = imageVector5;
                dialogProperties2 = dialogProperties6;
                modifier3 = modifier8;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                imageVector2 = warning;
                dialogProperties2 = dialogProperties;
            }
            z4 = z2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialogKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        return GenericConfirmationDialogKt.GenericConfirmationDialog$lambda$8(modifier3, function0, function1, str, str2, str3, str4, imageVector2, z4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 805306368;
        if ((i3 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i2 & 128) != 0) {
                    i3 &= -29360129;
                    warning = WarningKt.getWarning(Icons.INSTANCE.getDefault());
                }
                if (i9 != 0) {
                    z2 = true;
                }
                if (i4 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties;
                }
                modifier5 = modifier4;
            } else {
                if (i8 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i2 & 128) != 0) {
                    i3 &= -29360129;
                    warning = WarningKt.getWarning(Icons.INSTANCE.getDefault());
                }
                if (i9 != 0) {
                    z2 = true;
                }
                if (i4 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties;
                }
                modifier5 = modifier4;
            }
            i6 = i3;
            final ImageVector imageVector6 = warning;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(111205805, i6, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialog (GenericConfirmationDialog.kt:41)");
            }
            if (z2) {
                composerStartRestartGroup.startReplaceGroup(1512768646);
                ComposerKt.sourceInformation(composerStartRestartGroup, "43@1749L11");
                j = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getError-0d7_KjU();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1512821284);
                ComposerKt.sourceInformation(composerStartRestartGroup, "45@1802L11");
                j = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU();
                composerStartRestartGroup.endReplaceGroup();
            }
            final long j5 = j;
            Modifier modifier9 = modifier5;
            composer2 = composerStartRestartGroup;
            DialogProperties dialogProperties7 = dialogProperties3;
            AndroidDialog_androidKt.Dialog(function0, dialogProperties7, ComposableLambdaKt.rememberComposableLambda(570978102, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialogKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    return GenericConfirmationDialogKt.GenericConfirmationDialog$lambda$7(modifier5, imageVector6, j5, str, str2, function0, function1, str4, str3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i6 >> 3) & 14) | 384 | ((i6 >> 24) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            imageVector2 = imageVector6;
            dialogProperties2 = dialogProperties7;
            modifier3 = modifier9;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            imageVector2 = warning;
            dialogProperties2 = dialogProperties;
        }
        z4 = z2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialogKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return GenericConfirmationDialogKt.GenericConfirmationDialog$lambda$8(modifier3, function0, function1, str, str2, str3, str4, imageVector2, z4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GenericConfirmationDialog$lambda$7(Modifier modifier, final ImageVector imageVector, final long j, final String str, final String str2, final Function0 function0, final Function0 function1, final String str3, final String str4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C54@2016L5,55@2063L14,57@2153L2062,52@1934L2281:GenericConfirmationDialog.kt#mg9ln7");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(570978102, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialog.<anonymous> (GenericConfirmationDialog.kt:52)");
            }
            SurfaceKt.Surface-T9BRK9s(modifier, AlertDialogDefaults.INSTANCE.getShape(composer, AlertDialogDefaults.$stable), AlertDialogDefaults.INSTANCE.getContainerColor(composer, AlertDialogDefaults.$stable), 0L, AlertDialogDefaults.INSTANCE.getTonalElevation-D9Ej5fM(), 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(967027259, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialogKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    return GenericConfirmationDialogKt.GenericConfirmationDialog$lambda$7$lambda$6(imageVector, j, str, str2, function0, function1, str3, str4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12582912, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GenericConfirmationDialog$lambda$7$lambda$6(ImageVector imageVector, long j, String str, String str2, final Function0 function0, final Function0 function1, final String str3, final String str4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C58@2167L2038:GenericConfirmationDialog.kt#mg9ln7");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(967027259, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialog.<anonymous>.<anonymous> (GenericConfirmationDialog.kt:58)");
            }
            float f = 24;
            Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f));
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
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -244105399, "C62@2326L202,69@2546L41,73@2687L10,71@2605L215,78@2838L41,82@2985L10,84@3100L11,80@2897L249,87@3164L41,89@3223L968:GenericConfirmationDialog.kt#mg9ln7");
            IconKt.Icon-ww6aTOc(imageVector, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), j, composer, 432, 0);
            float f2 = 16;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), composer, 6);
            TextKt.Text-Nvy7gAk(str, (Modifier) null, j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getHeadlineSmall(), composer, 0, 0, 130042);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), composer, 6);
            TextKt.Text-Nvy7gAk(str2, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 0, 0, 130042);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.Companion.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composer3 = Updater.constructor-impl(composer);
            Updater.set-impl(composer3, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1066626942, "C95@3478L206,93@3393L291,102@3751L119,106@3920L158,110@4101L72,101@3705L468:GenericConfirmationDialog.kt#mg9ln7");
            ButtonKt.TextButton(function0, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-181304046, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialogKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return GenericConfirmationDialogKt.GenericConfirmationDialog$lambda$7$lambda$6$lambda$5$lambda$4$lambda$0(str3, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 510);
            ComposerKt.sourceInformationMarkerStart(composer, 1905266124, "CC(remember):GenericConfirmationDialog.kt#9igjgp");
            boolean zChanged = composer.changed(function1) | composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialogKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        return GenericConfirmationDialogKt.GenericConfirmationDialog$lambda$7$lambda$6$lambda$5$lambda$4$lambda$2$lambda$1(function1, function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) objRememberedValue, (Modifier) null, false, (Shape) null, ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(Color.Companion.getTransparent-0d7_KjU(), j, 0L, 0L, composer, (ButtonDefaults.$stable << 12) | 6, 12), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1537185865, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialogKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return GenericConfirmationDialogKt.GenericConfirmationDialog$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3(str4, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 494);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GenericConfirmationDialog$lambda$7$lambda$6$lambda$5$lambda$4$lambda$0(String str, RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C98@3608L11,96@3504L158:GenericConfirmationDialog.kt#mg9ln7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-181304046, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GenericConfirmationDialog.kt:96)");
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262138);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GenericConfirmationDialog$lambda$7$lambda$6$lambda$5$lambda$4$lambda$2$lambda$1(Function0 function0, Function0 function1) {
        function0.invoke();
        function1.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GenericConfirmationDialog$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3(String str, RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C111@4127L24:GenericConfirmationDialog.kt#mg9ln7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1537185865, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GenericConfirmationDialog.kt:111)");
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
