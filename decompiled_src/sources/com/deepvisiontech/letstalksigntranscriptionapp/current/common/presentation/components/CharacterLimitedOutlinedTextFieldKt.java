package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.messaging.Constants;
import io.grpc.internal.GrpcUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CharacterLimitedOutlinedTextField.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"CharacterLimitedOutlinedTextField", "", "value", "", "onValueChange", "Lkotlin/Function1;", Constants.ScionAnalytics.PARAM_LABEL, "maxLength", "", "modifier", "Landroidx/compose/ui/Modifier;", "singleLine", "", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;ILandroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CharacterLimitedOutlinedTextFieldKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CharacterLimitedOutlinedTextField$lambda$5(String str, Function1 function1, String str2, int i, Modifier modifier, boolean z, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, int i2, int i3, Composer composer, int i4) {
        CharacterLimitedOutlinedTextField(str, function1, str2, i, modifier, z, keyboardOptions, keyboardActions, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x017e  */
    /* JADX WARN: Code duplicated, block: B:101:0x0182  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:105:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:108:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:109:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:112:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:114:0x0204  */
    /* JADX WARN: Code duplicated, block: B:117:0x0292  */
    /* JADX WARN: Code duplicated, block: B:119:0x029d  */
    /* JADX WARN: Code duplicated, block: B:122:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x008b  */
    /* JADX WARN: Code duplicated, block: B:45:0x008d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0090  */
    /* JADX WARN: Code duplicated, block: B:49:0x0098  */
    /* JADX WARN: Code duplicated, block: B:50:0x009b  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:61:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:81:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:83:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:84:0x0100  */
    /* JADX WARN: Code duplicated, block: B:87:0x0107  */
    /* JADX WARN: Code duplicated, block: B:88:0x010f  */
    /* JADX WARN: Code duplicated, block: B:90:0x0112  */
    /* JADX WARN: Code duplicated, block: B:91:0x011b  */
    /* JADX WARN: Code duplicated, block: B:94:0x0125  */
    /* JADX WARN: Code duplicated, block: B:97:0x0172  */
    public static final void CharacterLimitedOutlinedTextField(final String str, final Function1<? super String, Unit> function1, final String str2, final int i, Modifier modifier, boolean z, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        int i7;
        KeyboardOptions keyboardOptions2;
        int i8;
        int i9;
        int i10;
        boolean z3;
        Composer composer2;
        final KeyboardActions keyboardActions2;
        final KeyboardOptions keyboardOptions3;
        final Modifier modifier3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        boolean z5;
        KeyboardOptions keyboardOptions4;
        KeyboardActions keyboardActions3;
        Function0 constructor;
        boolean z6;
        boolean z7;
        boolean z8;
        Object objRememberedValue;
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Intrinsics.checkNotNullParameter(str2, Constants.ScionAnalytics.PARAM_LABEL);
        Composer composerStartRestartGroup = composer.startRestartGroup(-1300053933);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CharacterLimitedOutlinedTextField)P(7,5,2,3,4,6,1)35@1683L722:CharacterLimitedOutlinedTextField.kt#rnaxq5");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(str2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        int i11 = i3 & 16;
        if (i11 == 0) {
            if ((i2 & 24576) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i5 = i3 & 32;
            if (i5 != 0) {
                if ((196608 & i2) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i6 = 131072;
                    } else {
                        i6 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    i4 |= 1572864;
                    keyboardOptions2 = keyboardOptions;
                } else {
                    keyboardOptions2 = keyboardOptions;
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(keyboardOptions2)) {
                            i8 = 1048576;
                        } else {
                            i8 = 524288;
                        }
                        i4 |= i8;
                    }
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(keyboardActions)) {
                        i10 = 8388608;
                    } else {
                        i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i4 |= i10;
                }
                if ((i4 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    keyboardActions2 = keyboardActions;
                    keyboardOptions3 = keyboardOptions2;
                    modifier3 = modifier2;
                    z4 = z2;
                } else {
                    if (i11 != 0) {
                        modifier4 = (Modifier) Modifier.Companion;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i5 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i7 != 0) {
                        keyboardOptions4 = KeyboardOptions.Companion.getDefault();
                    } else {
                        keyboardOptions4 = keyboardOptions2;
                    }
                    if (i9 != 0) {
                        keyboardActions3 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions3 = keyboardActions;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1300053933, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextField (CharacterLimitedOutlinedTextField.kt:34)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composerStartRestartGroup, 0);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1662440174, "C40@1809L117,45@1948L15,50@2173L216,38@1735L664:CharacterLimitedOutlinedTextField.kt#rnaxq5");
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1331844398, "CC(remember):CharacterLimitedOutlinedTextField.kt#9igjgp");
                    if ((i4 & 7168) == 2048) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if ((i4 & 112) == 32) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = z6 | z7;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z8 || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$4$lambda$1$lambda$0(i, function1, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i12 = i4 >> 3;
                    int i13 = (i12 & 3670016) | (458752 & i12) | 384 | ((i4 << 6) & 29360128);
                    Modifier modifier5 = modifier4;
                    composer2 = composerStartRestartGroup;
                    OutlinedTextFieldKt.OutlinedTextField(str, (Function1) objRememberedValue, modifierFillMaxWidth$default, false, false, (TextStyle) null, ComposableLambdaKt.rememberComposableLambda(-838833213, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$4$lambda$2(str2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(1244983574, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj, Object obj2) {
                            return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$4$lambda$3(str, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), false, (VisualTransformation) null, keyboardOptions4, keyboardActions3, z5, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer2, (i4 & 14) | 1573248, i13, 0, 8155064);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    keyboardOptions3 = keyboardOptions4;
                    keyboardActions2 = keyboardActions3;
                    z4 = z5;
                    modifier3 = modifier5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj, Object obj2) {
                            return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$5(str, function1, str2, i, modifier3, z4, keyboardOptions3, keyboardActions2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 196608;
            z2 = z;
            i7 = i3 & 64;
            if (i7 != 0) {
                i4 |= 1572864;
                keyboardOptions2 = keyboardOptions;
            } else {
                keyboardOptions2 = keyboardOptions;
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(keyboardOptions2)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(keyboardActions)) {
                    i10 = 8388608;
                } else {
                    i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i4 |= i10;
            }
            if ((i4 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                keyboardActions2 = keyboardActions;
                keyboardOptions3 = keyboardOptions2;
                modifier3 = modifier2;
                z4 = z2;
            } else {
                if (i11 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i5 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i7 != 0) {
                    keyboardOptions4 = KeyboardOptions.Companion.getDefault();
                } else {
                    keyboardOptions4 = keyboardOptions2;
                }
                if (i9 != 0) {
                    keyboardActions3 = KeyboardActions.Companion.getDefault();
                } else {
                    keyboardActions3 = keyboardActions;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1300053933, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextField (CharacterLimitedOutlinedTextField.kt:34)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1662440174, "C40@1809L117,45@1948L15,50@2173L216,38@1735L664:CharacterLimitedOutlinedTextField.kt#rnaxq5");
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1331844398, "CC(remember):CharacterLimitedOutlinedTextField.kt#9igjgp");
                if ((i4 & 7168) == 2048) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if ((i4 & 112) == 32) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = z6 | z7;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$4$lambda$1$lambda$0(i, function1, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$4$lambda$1$lambda$0(i, function1, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i14 = i4 >> 3;
                int i15 = (i14 & 3670016) | (458752 & i14) | 384 | ((i4 << 6) & 29360128);
                Modifier modifier6 = modifier4;
                composer2 = composerStartRestartGroup;
                OutlinedTextFieldKt.OutlinedTextField(str, (Function1) objRememberedValue, modifierFillMaxWidth$default2, false, false, (TextStyle) null, ComposableLambdaKt.rememberComposableLambda(-838833213, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$4$lambda$2(str2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(1244983574, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2) {
                        return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$4$lambda$3(str, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), false, (VisualTransformation) null, keyboardOptions4, keyboardActions3, z5, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer2, (i4 & 14) | 1573248, i15, 0, 8155064);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                keyboardOptions3 = keyboardOptions4;
                keyboardActions2 = keyboardActions3;
                z4 = z5;
                modifier3 = modifier6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2) {
                        return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$5(str, function1, str2, i, modifier3, z4, keyboardOptions3, keyboardActions2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        i5 = i3 & 32;
        if (i5 != 0) {
            if ((196608 & i2) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i6 = 131072;
                } else {
                    i6 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i4 |= i6;
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                i4 |= 1572864;
                keyboardOptions2 = keyboardOptions;
            } else {
                keyboardOptions2 = keyboardOptions;
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(keyboardOptions2)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(keyboardActions)) {
                    i10 = 8388608;
                } else {
                    i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i4 |= i10;
            }
            if ((i4 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                keyboardActions2 = keyboardActions;
                keyboardOptions3 = keyboardOptions2;
                modifier3 = modifier2;
                z4 = z2;
            } else {
                if (i11 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i5 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i7 != 0) {
                    keyboardOptions4 = KeyboardOptions.Companion.getDefault();
                } else {
                    keyboardOptions4 = keyboardOptions2;
                }
                if (i9 != 0) {
                    keyboardActions3 = KeyboardActions.Companion.getDefault();
                } else {
                    keyboardActions3 = keyboardActions;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1300053933, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextField (CharacterLimitedOutlinedTextField.kt:34)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
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
                Composer composer5 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer5, measurePolicyColumnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer5, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(composer5, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(composer5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(composer5, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1662440174, "C40@1809L117,45@1948L15,50@2173L216,38@1735L664:CharacterLimitedOutlinedTextField.kt#rnaxq5");
                Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1331844398, "CC(remember):CharacterLimitedOutlinedTextField.kt#9igjgp");
                if ((i4 & 7168) == 2048) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if ((i4 & 112) == 32) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = z6 | z7;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$4$lambda$1$lambda$0(i, function1, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$4$lambda$1$lambda$0(i, function1, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i16 = i4 >> 3;
                int i17 = (i16 & 3670016) | (458752 & i16) | 384 | ((i4 << 6) & 29360128);
                Modifier modifier7 = modifier4;
                composer2 = composerStartRestartGroup;
                OutlinedTextFieldKt.OutlinedTextField(str, (Function1) objRememberedValue, modifierFillMaxWidth$default3, false, false, (TextStyle) null, ComposableLambdaKt.rememberComposableLambda(-838833213, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$4$lambda$2(str2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(1244983574, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2) {
                        return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$4$lambda$3(str, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), false, (VisualTransformation) null, keyboardOptions4, keyboardActions3, z5, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer2, (i4 & 14) | 1573248, i17, 0, 8155064);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                keyboardOptions3 = keyboardOptions4;
                keyboardActions2 = keyboardActions3;
                z4 = z5;
                modifier3 = modifier7;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2) {
                        return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$5(str, function1, str2, i, modifier3, z4, keyboardOptions3, keyboardActions2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 196608;
        z2 = z;
        i7 = i3 & 64;
        if (i7 != 0) {
            i4 |= 1572864;
            keyboardOptions2 = keyboardOptions;
        } else {
            keyboardOptions2 = keyboardOptions;
            if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(keyboardOptions2)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
        }
        i9 = i3 & 128;
        if (i9 != 0) {
            i4 |= 12582912;
        } else if ((i2 & 12582912) == 0) {
            if (composerStartRestartGroup.changed(keyboardActions)) {
                i10 = 8388608;
            } else {
                i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
            }
            i4 |= i10;
        }
        if ((i4 & 4793491) != 4793490) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            keyboardActions2 = keyboardActions;
            keyboardOptions3 = keyboardOptions2;
            modifier3 = modifier2;
            z4 = z2;
        } else {
            if (i11 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i5 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (i7 != 0) {
                keyboardOptions4 = KeyboardOptions.Companion.getDefault();
            } else {
                keyboardOptions4 = keyboardOptions2;
            }
            if (i9 != 0) {
                keyboardActions3 = KeyboardActions.Companion.getDefault();
            } else {
                keyboardActions3 = keyboardActions;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1300053933, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextField (CharacterLimitedOutlinedTextField.kt:34)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
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
            Composer composer6 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer6, measurePolicyColumnMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer6, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer6, Integer.valueOf(iHashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer6, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1662440174, "C40@1809L117,45@1948L15,50@2173L216,38@1735L664:CharacterLimitedOutlinedTextField.kt#rnaxq5");
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1331844398, "CC(remember):CharacterLimitedOutlinedTextField.kt#9igjgp");
            if ((i4 & 7168) == 2048) {
                z6 = true;
            } else {
                z6 = false;
            }
            if ((i4 & 112) == 32) {
                z7 = true;
            } else {
                z7 = false;
            }
            z8 = z6 | z7;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z8) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$4$lambda$1$lambda$0(i, function1, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$4$lambda$1$lambda$0(i, function1, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i18 = i4 >> 3;
            int i19 = (i18 & 3670016) | (458752 & i18) | 384 | ((i4 << 6) & 29360128);
            Modifier modifier8 = modifier4;
            composer2 = composerStartRestartGroup;
            OutlinedTextFieldKt.OutlinedTextField(str, (Function1) objRememberedValue, modifierFillMaxWidth$default4, false, false, (TextStyle) null, ComposableLambdaKt.rememberComposableLambda(-838833213, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$4$lambda$2(str2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(1244983574, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$4$lambda$3(str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), false, (VisualTransformation) null, keyboardOptions4, keyboardActions3, z5, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer2, (i4 & 14) | 1573248, i19, 0, 8155064);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            keyboardOptions3 = keyboardOptions4;
            keyboardActions2 = keyboardActions3;
            z4 = z5;
            modifier3 = modifier8;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    return CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField$lambda$5(str, function1, str2, i, modifier3, z4, keyboardOptions3, keyboardActions2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CharacterLimitedOutlinedTextField$lambda$4$lambda$1$lambda$0(int i, Function1 function1, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        if (str.length() <= i) {
            function1.invoke(str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CharacterLimitedOutlinedTextField$lambda$4$lambda$2(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C45@1950L11:CharacterLimitedOutlinedTextField.kt#rnaxq5");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-838833213, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextField.<anonymous>.<anonymous> (CharacterLimitedOutlinedTextField.kt:45)");
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
    public static final Unit CharacterLimitedOutlinedTextField$lambda$4$lambda$3(String str, int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C51@2191L184:CharacterLimitedOutlinedTextField.kt#rnaxq5");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1244983574, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextField.<anonymous>.<anonymous> (CharacterLimitedOutlinedTextField.kt:51)");
            }
            TextKt.Text-Nvy7gAk(str.length() + " / " + i, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getEnd-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 48, 0, 261116);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
