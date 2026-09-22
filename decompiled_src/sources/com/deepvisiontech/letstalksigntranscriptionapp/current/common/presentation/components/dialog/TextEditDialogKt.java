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
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AlertDialogDefaults;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.messaging.Constants;
import io.grpc.internal.GrpcUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TextEditDialog.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0082\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0013¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u0005X\u008a\u008e\u0002"}, d2 = {"TextEditDialog", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "", Constants.ScionAnalytics.PARAM_LABEL, "confirmButtonLabel", "dismissButtonLabel", "initialText", "maxLines", "", "onDismissRequest", "Lkotlin/Function0;", "onAccept", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_release", "currentText"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TextEditDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextEditDialog$lambda$15(Modifier modifier, String str, String str2, String str3, String str4, String str5, int i, Function0 function0, Function1 function1, int i2, int i3, Composer composer, int i4) {
        TextEditDialog(modifier, str, str2, str3, str4, str5, i, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0149 A[PHI: r4 r5 r7 r10 r11 r12
  0x0149: PHI (r4v11 androidx.compose.ui.Modifier) = (r4v6 androidx.compose.ui.Modifier), (r4v3 androidx.compose.ui.Modifier), (r4v3 androidx.compose.ui.Modifier) binds: [B:129:0x0191, B:110:0x0146, B:111:0x0148] A[DONT_GENERATE, DONT_INLINE]
  0x0149: PHI (r5v29 int) = (r5v21 int), (r5v32 int), (r5v33 int) binds: [B:129:0x0191, B:110:0x0146, B:111:0x0148] A[DONT_GENERATE, DONT_INLINE]
  0x0149: PHI (r7v16 java.lang.String) = (r7v5 java.lang.String), (r7v2 java.lang.String), (r7v2 java.lang.String) binds: [B:129:0x0191, B:110:0x0146, B:111:0x0148] A[DONT_GENERATE, DONT_INLINE]
  0x0149: PHI (r10v9 java.lang.String) = (r10v4 java.lang.String), (r10v2 java.lang.String), (r10v2 java.lang.String) binds: [B:129:0x0191, B:110:0x0146, B:111:0x0148] A[DONT_GENERATE, DONT_INLINE]
  0x0149: PHI (r11v8 java.lang.String) = (r11v4 java.lang.String), (r11v2 java.lang.String), (r11v2 java.lang.String) binds: [B:129:0x0191, B:110:0x0146, B:111:0x0148] A[DONT_GENERATE, DONT_INLINE]
  0x0149: PHI (r12v8 java.lang.String) = (r12v4 java.lang.String), (r12v2 java.lang.String), (r12v2 java.lang.String) binds: [B:129:0x0191, B:110:0x0146, B:111:0x0148] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:114:0x0152 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x0154  */
    /* JADX WARN: Code duplicated, block: B:118:0x015d  */
    /* JADX WARN: Code duplicated, block: B:119:0x0168  */
    /* JADX WARN: Code duplicated, block: B:122:0x016d  */
    /* JADX WARN: Code duplicated, block: B:125:0x017a  */
    /* JADX WARN: Code duplicated, block: B:128:0x0187  */
    /* JADX WARN: Code duplicated, block: B:130:0x0193  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:136:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:137:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:140:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:142:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:145:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:146:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:149:0x0212  */
    /* JADX WARN: Code duplicated, block: B:151:0x021f  */
    /* JADX WARN: Code duplicated, block: B:154:0x022f  */
    /* JADX WARN: Code duplicated, block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:91:0x010e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0110  */
    /* JADX WARN: Code duplicated, block: B:95:0x0119  */
    public static final void TextEditDialog(Modifier modifier, String str, String str2, String str3, String str4, final String str5, int i, final Function0<Unit> function0, final Function1<? super String, Unit> function1, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        String strStringResource;
        String strStringResource2;
        String strStringResource3;
        String strStringResource4;
        int i5;
        boolean z;
        final Modifier modifier3;
        final String str6;
        final String str7;
        final String str8;
        final String str9;
        final int i6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        final String str10;
        final String str11;
        final String str12;
        final int i8;
        boolean z2;
        Object objRememberedValue;
        final boolean z3;
        int i9;
        int i10;
        int i11;
        Intrinsics.checkNotNullParameter(str5, "initialText");
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function1, "onAccept");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2085911955);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextEditDialog)P(5,8,3!4,7)47@2119L31,47@2102L48,50@2237L2536,50@2193L2580:TextEditDialog.kt#mg9ln7");
        int i12 = i3 & 1;
        if (i12 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            if ((i3 & 2) == 0) {
                strStringResource = str;
                int i13 = composerStartRestartGroup.changed(strStringResource) ? 32 : 16;
                i4 |= i13;
            } else {
                strStringResource = str;
            }
            i4 |= i13;
        } else {
            strStringResource = str;
        }
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                strStringResource2 = str2;
                int i14 = composerStartRestartGroup.changed(strStringResource2) ? 256 : 128;
                i4 |= i14;
            } else {
                strStringResource2 = str2;
            }
            i4 |= i14;
        } else {
            strStringResource2 = str2;
        }
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                strStringResource3 = str3;
                if (composerStartRestartGroup.changed(strStringResource3)) {
                    i11 = RecyclerView.ItemAnimator.FLAG_MOVED;
                }
                i4 |= i11;
            } else {
                strStringResource3 = str3;
            }
            i11 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            i4 |= i11;
        } else {
            strStringResource3 = str3;
        }
        if ((i2 & 24576) == 0) {
            if ((i3 & 16) == 0) {
                strStringResource4 = str4;
                int i15 = composerStartRestartGroup.changed(strStringResource4) ? 16384 : 8192;
                i4 |= i15;
            } else {
                strStringResource4 = str4;
            }
            i4 |= i15;
        } else {
            strStringResource4 = str4;
        }
        if ((196608 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(str5) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        int i16 = i3 & 64;
        if (i16 == 0) {
            if ((1572864 & i2) == 0) {
                i5 = i;
                i4 |= composerStartRestartGroup.changed(i5) ? 1048576 : 524288;
            }
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i10 = 8388608;
                } else {
                    i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i4 |= i10;
            }
            if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
                i4 |= i9;
            }
            if ((i4 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "37@1660L50,38@1732L50,39@1817L43,40@1895L46");
                if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i3 & 2) != 0) {
                        i7 = 0;
                        i4 &= -113;
                        strStringResource = StringResources_androidKt.stringResource(R.string.global_dialog_input_title, composerStartRestartGroup, 0);
                    } else {
                        i7 = 0;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                        strStringResource2 = StringResources_androidKt.stringResource(R.string.global_dialog_input_label, composerStartRestartGroup, i7);
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                        strStringResource3 = StringResources_androidKt.stringResource(R.string.global_action_save, composerStartRestartGroup, i7);
                    }
                    if ((i3 & 16) != 0) {
                        strStringResource4 = StringResources_androidKt.stringResource(R.string.global_action_dismiss, composerStartRestartGroup, i7);
                        i4 &= -57345;
                    }
                    if (i16 != 0) {
                        str10 = strStringResource;
                        str11 = strStringResource2;
                        str12 = strStringResource4;
                        i8 = Integer.MAX_VALUE;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2085911955, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialog (TextEditDialog.kt:45)");
                    }
                    Object[] objArr = new Object[0];
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1188355980, "CC(remember):TextEditDialog.kt#9igjgp");
                    if ((458752 & i4) == 131072) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2 || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                return TextEditDialogKt.TextEditDialog$lambda$1$lambda$0(str5);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 0);
                    if (i8 == 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    final String str13 = strStringResource3;
                    final Modifier modifier4 = modifier2;
                    AndroidDialog_androidKt.Dialog(function0, (DialogProperties) null, ComposableLambdaKt.rememberComposableLambda(-67524106, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj, Object obj2) {
                            return TextEditDialogKt.TextEditDialog$lambda$14(modifier4, str10, z3, mutableState, i8, str11, function0, function1, str12, str13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 21) & 14) | 384, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    str6 = str10;
                    i6 = i8;
                    str7 = str11;
                    str9 = str12;
                    str8 = str13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 2) != 0) {
                        i4 &= -113;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                    }
                }
                str10 = strStringResource;
                str11 = strStringResource2;
                str12 = strStringResource4;
                i8 = i5;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2085911955, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialog (TextEditDialog.kt:45)");
                }
                Object[] objArr2 = new Object[0];
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1188355980, "CC(remember):TextEditDialog.kt#9igjgp");
                if ((458752 & i4) == 131072) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            return TextEditDialogKt.TextEditDialog$lambda$1$lambda$0(str5);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            return TextEditDialogKt.TextEditDialog$lambda$1$lambda$0(str5);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) objRememberedValue, composerStartRestartGroup, 0);
                if (i8 == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                final String str14 = strStringResource3;
                final Modifier modifier5 = modifier2;
                AndroidDialog_androidKt.Dialog(function0, (DialogProperties) null, ComposableLambdaKt.rememberComposableLambda(-67524106, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextEditDialogKt.TextEditDialog$lambda$14(modifier5, str10, z3, mutableState2, i8, str11, function0, function1, str12, str14, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 21) & 14) | 384, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                str6 = str10;
                i6 = i8;
                str7 = str11;
                str9 = str12;
                str8 = str14;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                str6 = strStringResource;
                str7 = strStringResource2;
                str8 = strStringResource3;
                str9 = strStringResource4;
                i6 = i5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2) {
                        return TextEditDialogKt.TextEditDialog$lambda$15(modifier3, str6, str7, str8, str9, str5, i6, function0, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 1572864;
        i5 = i;
        if ((i2 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function0)) {
                i10 = 8388608;
            } else {
                i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
            }
            i4 |= i10;
        }
        if ((i2 & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i9 = 67108864;
            } else {
                i9 = 33554432;
            }
            i4 |= i9;
        }
        if ((i4 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "37@1660L50,38@1732L50,39@1817L43,40@1895L46");
            if ((i2 & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i3 & 2) != 0) {
                    i7 = 0;
                    i4 &= -113;
                    strStringResource = StringResources_androidKt.stringResource(R.string.global_dialog_input_title, composerStartRestartGroup, 0);
                } else {
                    i7 = 0;
                }
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                    strStringResource2 = StringResources_androidKt.stringResource(R.string.global_dialog_input_label, composerStartRestartGroup, i7);
                }
                if ((i3 & 8) != 0) {
                    i4 &= -7169;
                    strStringResource3 = StringResources_androidKt.stringResource(R.string.global_action_save, composerStartRestartGroup, i7);
                }
                if ((i3 & 16) != 0) {
                    strStringResource4 = StringResources_androidKt.stringResource(R.string.global_action_dismiss, composerStartRestartGroup, i7);
                    i4 &= -57345;
                }
                if (i16 != 0) {
                    str10 = strStringResource;
                    str11 = strStringResource2;
                    str12 = strStringResource4;
                    i8 = Integer.MAX_VALUE;
                } else {
                    str10 = strStringResource;
                    str11 = strStringResource2;
                    str12 = strStringResource4;
                    i8 = i5;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i3 & 2) != 0) {
                    i7 = 0;
                    i4 &= -113;
                    strStringResource = StringResources_androidKt.stringResource(R.string.global_dialog_input_title, composerStartRestartGroup, 0);
                } else {
                    i7 = 0;
                }
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                    strStringResource2 = StringResources_androidKt.stringResource(R.string.global_dialog_input_label, composerStartRestartGroup, i7);
                }
                if ((i3 & 8) != 0) {
                    i4 &= -7169;
                    strStringResource3 = StringResources_androidKt.stringResource(R.string.global_action_save, composerStartRestartGroup, i7);
                }
                if ((i3 & 16) != 0) {
                    strStringResource4 = StringResources_androidKt.stringResource(R.string.global_action_dismiss, composerStartRestartGroup, i7);
                    i4 &= -57345;
                }
                if (i16 != 0) {
                    str10 = strStringResource;
                    str11 = strStringResource2;
                    str12 = strStringResource4;
                    i8 = Integer.MAX_VALUE;
                } else {
                    str10 = strStringResource;
                    str11 = strStringResource2;
                    str12 = strStringResource4;
                    i8 = i5;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2085911955, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialog (TextEditDialog.kt:45)");
            }
            Object[] objArr3 = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1188355980, "CC(remember):TextEditDialog.kt#9igjgp");
            if ((458752 & i4) == 131072) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        return TextEditDialogKt.TextEditDialog$lambda$1$lambda$0(str5);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        return TextEditDialogKt.TextEditDialog$lambda$1$lambda$0(str5);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState3 = (MutableState) RememberSaveableKt.rememberSaveable(objArr3, (Function0) objRememberedValue, composerStartRestartGroup, 0);
            if (i8 == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            final String str15 = strStringResource3;
            final Modifier modifier6 = modifier2;
            AndroidDialog_androidKt.Dialog(function0, (DialogProperties) null, ComposableLambdaKt.rememberComposableLambda(-67524106, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    return TextEditDialogKt.TextEditDialog$lambda$14(modifier6, str10, z3, mutableState3, i8, str11, function0, function1, str12, str15, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 21) & 14) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
            str6 = str10;
            i6 = i8;
            str7 = str11;
            str9 = str12;
            str8 = str15;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            str6 = strStringResource;
            str7 = strStringResource2;
            str8 = strStringResource3;
            str9 = strStringResource4;
            i6 = i5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    return TextEditDialogKt.TextEditDialog$lambda$15(modifier3, str6, str7, str8, str9, str5, i6, function0, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState TextEditDialog$lambda$1$lambda$0(String str) {
        return SnapshotStateKt.mutableStateOf$default(str, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private static final String TextEditDialog$lambda$2(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextEditDialog$lambda$14$lambda$13(String str, boolean z, final MutableState mutableState, int i, final String str2, Function0 function0, final Function1 function1, final String str3, final String str4, Composer composer, int i2) {
        Modifier modifier;
        ComposerKt.sourceInformation(composer, "C57@2492L2265:TextEditDialog.kt#mg9ln7");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1734679813, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialog.<anonymous>.<anonymous> (TextEditDialog.kt:57)");
            }
            float f = 24;
            Modifier modifier2 = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f));
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier2);
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
            ComposerKt.sourceInformationMarkerStart(composer, -831068666, "C63@2733L10,64@2801L11,61@2651L189,67@2858L41,82@3529L10,83@3593L6,71@3013L20,72@3063L15,69@2917L1040,92@3975L41,94@4034L709:TextEditDialog.kt#mg9ln7");
            TextKt.Text-Nvy7gAk(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getHeadlineSmall(), composer, 0, 0, 131066);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), composer, 6);
            String strTextEditDialog$lambda$2 = TextEditDialog$lambda$2(mutableState);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            if (z) {
                modifier = (Modifier) Modifier.Companion;
            } else {
                modifier = SizeKt.heightIn-VpY3zN4(Modifier.Companion, Dp.constructor-impl(120), Dp.constructor-impl(240));
            }
            Modifier modifierThen = modifierFillMaxWidth$default.then(modifier);
            TextStyle bodyLarge = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge();
            Shape medium = MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable).getMedium();
            int i3 = KeyboardCapitalization.Companion.getSentences-IUNYP9k();
            ImeAction.Companion companion = ImeAction.Companion;
            KeyboardOptions keyboardOptions = new KeyboardOptions(i3, (Boolean) null, 0, z ? companion.getDone-eUduSuo() : companion.getDefault-eUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 118, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart(composer, -303893819, "CC(remember):TextEditDialog.kt#9igjgp");
            boolean zChanged = composer.changed(mutableState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        return TextEditDialogKt.TextEditDialog$lambda$14$lambda$13$lambda$12$lambda$5$lambda$4(mutableState, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            OutlinedTextFieldKt.OutlinedTextField(strTextEditDialog$lambda$2, (Function1) objRememberedValue, modifierThen, false, false, bodyLarge, ComposableLambdaKt.rememberComposableLambda(-1535060597, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    return TextEditDialogKt.TextEditDialog$lambda$14$lambda$13$lambda$12$lambda$6(str2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, z, i, 0, (MutableInteractionSource) null, medium, (TextFieldColors) null, composer, 1572864, 0, 0, 5865368);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer, 6);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
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
            ComposerKt.sourceInformationMarkerStart(composer, 584129856, "C101@4348L72,99@4263L157,105@4442L39,108@4545L25,110@4653L72,107@4503L222:TextEditDialog.kt#mg9ln7");
            ButtonKt.TextButton(function0, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(573597650, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TextEditDialogKt.TextEditDialog$lambda$14$lambda$13$lambda$12$lambda$11$lambda$7(str3, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 510);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 573040814, "CC(remember):TextEditDialog.kt#9igjgp");
            boolean zChanged2 = composer.changed(function1) | composer.changed(mutableState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        return TextEditDialogKt.TextEditDialog$lambda$14$lambda$13$lambda$12$lambda$11$lambda$9$lambda$8(function1, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.Button((Function0) objRememberedValue2, (Modifier) null, !StringsKt.isBlank(TextEditDialog$lambda$2(mutableState)), (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(2106558405, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TextEditDialogKt.TextEditDialog$lambda$14$lambda$13$lambda$12$lambda$11$lambda$10(str4, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 506);
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
    public static final Unit TextEditDialog$lambda$14$lambda$13$lambda$12$lambda$5$lambda$4(MutableState mutableState, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        mutableState.setValue(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextEditDialog$lambda$14$lambda$13$lambda$12$lambda$6(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C72@3065L11:TextEditDialog.kt#mg9ln7");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1535060597, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TextEditDialog.kt:72)");
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextEditDialog$lambda$14$lambda$13$lambda$12$lambda$11$lambda$7(String str, RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C102@4374L24:TextEditDialog.kt#mg9ln7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(573597650, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TextEditDialog.kt:102)");
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextEditDialog$lambda$14$lambda$13$lambda$12$lambda$11$lambda$9$lambda$8(Function1 function1, MutableState mutableState) {
        function1.invoke(TextEditDialog$lambda$2(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextEditDialog$lambda$14$lambda$13$lambda$12$lambda$11$lambda$10(String str, RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$Button");
        ComposerKt.sourceInformation(composer, "C111@4679L24:TextEditDialog.kt#mg9ln7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2106558405, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TextEditDialog.kt:111)");
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextEditDialog$lambda$14(Modifier modifier, final String str, final boolean z, final MutableState mutableState, final int i, final String str2, final Function0 function0, final Function1 function1, final String str3, final String str4, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C53@2359L6,54@2418L14,56@2478L2289,51@2247L2520:TextEditDialog.kt#mg9ln7");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-67524106, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialog.<anonymous> (TextEditDialog.kt:51)");
            }
            SurfaceKt.Surface-T9BRK9s(SizeKt.widthIn-VpY3zN4(modifier, Dp.constructor-impl(280), Dp.constructor-impl(560)), MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable).getExtraLarge(), AlertDialogDefaults.INSTANCE.getContainerColor(composer, AlertDialogDefaults.$stable), 0L, Dp.constructor-impl(6), 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1734679813, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    return TextEditDialogKt.TextEditDialog$lambda$14$lambda$13(str, z, mutableState, i, str2, function0, function1, str3, str4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12607488, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
