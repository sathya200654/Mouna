package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
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
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.window.core.layout.WindowSizeClass;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GoogleSignInButton4.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"GoogleSignInButton", "", "text", "", "loadingText", "isLoading", "", "icon", "Landroidx/compose/ui/graphics/painter/Painter;", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GoogleSignInButton4Kt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GoogleSignInButton$lambda$2(String str, String str2, boolean z, Painter painter, Function0 function0, int i, int i2, Composer composer, int i3) {
        GoogleSignInButton(str, str2, z, painter, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0069  */
    /* JADX WARN: Code duplicated, block: B:32:0x006d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0071  */
    /* JADX WARN: Code duplicated, block: B:35:0x0076  */
    /* JADX WARN: Code duplicated, block: B:37:0x007c  */
    /* JADX WARN: Code duplicated, block: B:38:0x007f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0086  */
    /* JADX WARN: Code duplicated, block: B:44:0x008c  */
    /* JADX WARN: Code duplicated, block: B:45:0x008f  */
    /* JADX WARN: Code duplicated, block: B:49:0x009a  */
    /* JADX WARN: Code duplicated, block: B:50:0x009c  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00db  */
    /* JADX WARN: Code duplicated, block: B:72:0x0182  */
    /* JADX WARN: Code duplicated, block: B:74:0x0189  */
    /* JADX WARN: Code duplicated, block: B:77:0x0195  */
    /* JADX WARN: Code duplicated, block: B:79:? A[RETURN, SYNTHETIC] */
    public static final void GoogleSignInButton(final String str, final String str2, boolean z, Painter painter, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        boolean z3;
        Composer composer2;
        final Painter painter2;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i4;
        int i5;
        int i6;
        boolean zChangedInstance;
        Painter painterPainterResource = painter;
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "loadingText");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1905095195);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GoogleSignInButton)P(4,2,1)40@1636L11,41@1701L11,39@1579L156,48@1884L672,36@1470L1086:GoogleSignInButton4.kt#bv2vsw");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 == 0) {
            if ((i & 384) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) != 0) {
                    i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                } else {
                    if ((i & 4096) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(painterPainterResource);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(painterPainterResource);
                    }
                    if (zChangedInstance) {
                        i6 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                }
                i3 |= i6;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "33@1392L44");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 8) != 0) {
                        painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.google_logo, composerStartRestartGroup, 0);
                        i3 &= -7169;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                }
                i4 = i3;
                final Painter painter3 = painterPainterResource;
                final boolean z5 = z2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1905095195, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.GoogleSignInButton (GoogleSignInButton4.kt:35)");
                }
                ButtonKt.Button(function0, SizeKt.height-3ABfNKs(PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16)), Dp.constructor-impl(50)), !z5, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)), ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-2133627861, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.GoogleSignInButton4Kt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return GoogleSignInButton4Kt.GoogleSignInButton$lambda$1(painter3, z5, str, str2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 12) & 14) | 805306416, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z5;
                painter2 = painter3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                painter2 = painterPainterResource;
                z4 = z2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.GoogleSignInButton4Kt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        return GoogleSignInButton4Kt.GoogleSignInButton$lambda$2(str, str2, z4, painter2, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if ((i2 & 8) != 0) {
                i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            } else {
                if ((i & 4096) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(painterPainterResource);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(painterPainterResource);
                }
                if (zChangedInstance) {
                    i6 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
            }
            i3 |= i6;
        }
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(function0)) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
            i3 |= i5;
        }
        if ((i3 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "33@1392L44");
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    z2 = false;
                }
                if ((i2 & 8) != 0) {
                    painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.google_logo, composerStartRestartGroup, 0);
                    i3 &= -7169;
                }
            } else {
                if (i7 != 0) {
                    z2 = false;
                }
                if ((i2 & 8) != 0) {
                    painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.google_logo, composerStartRestartGroup, 0);
                    i3 &= -7169;
                }
            }
            i4 = i3;
            final Painter painter4 = painterPainterResource;
            final boolean z6 = z2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1905095195, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.GoogleSignInButton (GoogleSignInButton4.kt:35)");
            }
            ButtonKt.Button(function0, SizeKt.height-3ABfNKs(PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16)), Dp.constructor-impl(50)), !z6, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)), ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-2133627861, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.GoogleSignInButton4Kt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return GoogleSignInButton4Kt.GoogleSignInButton$lambda$1(painter4, z6, str, str2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 12) & 14) | 805306416, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z6;
            painter2 = painter4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            painter2 = painterPainterResource;
            z4 = z2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.GoogleSignInButton4Kt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return GoogleSignInButton4Kt.GoogleSignInButton$lambda$2(str, str2, z4, painter2, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GoogleSignInButton$lambda$1(Painter painter, boolean z, String str, String str2, RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$Button");
        ComposerKt.sourceInformation(composer, "C49@1894L656:GoogleSignInButton4.kt#bv2vsw");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2133627861, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.GoogleSignInButton.<anonymous> (GoogleSignInButton4.kt:49)");
            }
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal center = Arrangement.INSTANCE.getCenter();
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
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
            Updater.set-impl(composer2, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1940127123, "C56@2161L89,54@2085L228,61@2326L39,62@2378L162:GoogleSignInButton4.kt#bv2vsw");
            ImageKt.Image(painter, StringResources_androidKt.stringResource(R.string.auth_credentials_cd_signin, composer, 0), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 384, 120);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer, 6);
            TextKt.Text-Nvy7gAk(!z ? str : str2, (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 1597440, 0, 262062);
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
