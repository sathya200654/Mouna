package androidx.wear.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.perf.util.Constants;
import io.grpc.internal.GrpcUtil;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: ToggleButton.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ao\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001ay\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0014\u001a\u008a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"ToggleButton", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/wear/compose/material/ToggleButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/wear/compose/material/ToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "shape", "Landroidx/compose/ui/graphics/Shape;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/wear/compose/material/ToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "role", "Landroidx/compose/ui/semantics/Role;", "ToggleButton-2nuZEAM", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/wear/compose/material/ToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ToggleButtonKt {
    /* JADX WARN: Code duplicated, block: B:101:0x0120  */
    /* JADX WARN: Code duplicated, block: B:102:0x0142  */
    /* JADX WARN: Code duplicated, block: B:104:0x0145  */
    /* JADX WARN: Code duplicated, block: B:106:0x0159  */
    /* JADX WARN: Code duplicated, block: B:108:0x0167  */
    /* JADX WARN: Code duplicated, block: B:112:0x0175  */
    /* JADX WARN: Code duplicated, block: B:115:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:119:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:81:0x00df  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:94:0x0110 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0112  */
    /* JADX WARN: Code duplicated, block: B:97:0x0119  */
    /* JADX WARN: Code duplicated, block: B:98:0x011b  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is provided for backwards compatibility with Compose for Wear OS 1.0.A newer overload is available with an additional shape parameter.")
    public static final /* synthetic */ void ToggleButton(final boolean z, final Function1 function1, Modifier modifier, boolean z2, ToggleButtonColors toggleButtonColors, MutableInteractionSource mutableInteractionSource, final Function3 function3, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        Function1 function2;
        int i4;
        Modifier modifier2;
        int i5;
        int i6;
        boolean z4;
        int i7;
        ToggleButtonColors toggleButtonColorsM856toggleButtonColorsoq7We08;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        int i9;
        int i10;
        boolean z5;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource3;
        boolean z6;
        Modifier modifier3;
        ToggleButtonColors toggleButtonColors2;
        Object objRememberedValue;
        final Modifier modifier4;
        final boolean z7;
        final ToggleButtonColors toggleButtonColors3;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2087705725);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ToggleButton)P(!1,6,5,3!1,4)83@3979L20,84@4051L39,86@4142L177:ToggleButton.kt#gj9v0t");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else if ((i & 6) == 0) {
            z3 = z;
            i3 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
        } else {
            z3 = z;
            i3 = i;
        }
        if ((i2 & 2) == 0) {
            if ((i & 48) == 0) {
                function2 = function1;
                i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                        } else {
                            i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                        }
                        i3 |= i7;
                    }
                    if ((i & 24576) == 0) {
                        if ((i2 & 16) == 0) {
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                            int i11 = composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08) ? 16384 : 8192;
                            i3 |= i11;
                        } else {
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                        }
                        i3 |= i11;
                    } else {
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        if ((196608 & i) == 0) {
                            mutableInteractionSource2 = mutableInteractionSource;
                            if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                                i9 = 131072;
                            } else {
                                i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                            }
                            i3 |= i9;
                        }
                        if ((i2 & 64) != 0) {
                            if ((i & 1572864) == 0) {
                                if (composerStartRestartGroup.changedInstance(function3)) {
                                    i10 = 1048576;
                                } else {
                                    i10 = 524288;
                                }
                                i3 |= i10;
                            }
                            if ((599187 & i3) == 599186 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i4 != 0) {
                                        modifier2 = (Modifier) Modifier.Companion;
                                    }
                                    if (i6 != 0) {
                                        z5 = true;
                                    } else {
                                        z5 = z4;
                                    }
                                    if ((i2 & 16) != 0) {
                                        composer2 = composerStartRestartGroup;
                                        i3 &= -57345;
                                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                    } else {
                                        composer2 = composerStartRestartGroup;
                                    }
                                    if (i8 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                        objRememberedValue = composer2.rememberedValue();
                                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composer2.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    z6 = z5;
                                    modifier3 = modifier2;
                                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    composer2 = composerStartRestartGroup;
                                    z6 = z4;
                                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    modifier3 = modifier2;
                                }
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                                }
                                m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier4 = modifier3;
                                z7 = z6;
                                toggleButtonColors3 = toggleButtonColors2;
                                mutableInteractionSource4 = mutableInteractionSource3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier2;
                                z7 = z4;
                                toggleButtonColors3 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i12) {
                                        ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                            }
                        }
                        i3 |= 1572864;
                        if ((599187 & i3) == 599186) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z7 = z6;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z7 = z6;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i12) {
                                    ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 196608;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i2 & 64) != 0) {
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i3 |= i10;
                        }
                        if ((599187 & i3) == 599186) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z7 = z6;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z7 = z6;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i12) {
                                    ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 1572864;
                    if ((599187 & i3) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i12) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 3072;
                z4 = z2;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                        if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                        }
                        i3 |= i11;
                    } else {
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    }
                    i3 |= i11;
                } else {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 131072;
                        } else {
                            i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 64) != 0) {
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i3 |= i10;
                        }
                        if ((599187 & i3) == 599186) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z7 = z6;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z7 = z6;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i12) {
                                    ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 1572864;
                    if ((599187 & i3) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i12) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 64) != 0) {
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599187 & i3) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i12) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 1572864;
                if ((599187 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i12) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 384;
            modifier2 = modifier;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                        if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                        }
                        i3 |= i11;
                    } else {
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    }
                    i3 |= i11;
                } else {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 131072;
                        } else {
                            i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 64) != 0) {
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i3 |= i10;
                        }
                        if ((599187 & i3) == 599186) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z7 = z6;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z7 = z6;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i12) {
                                    ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 1572864;
                    if ((599187 & i3) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i12) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 64) != 0) {
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599187 & i3) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i12) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 1572864;
                if ((599187 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i12) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z2;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                    }
                    i3 |= i11;
                } else {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                }
                i3 |= i11;
            } else {
                toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i9;
                }
                if ((i2 & 64) != 0) {
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599187 & i3) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i12) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 1572864;
                if ((599187 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i12) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 64) != 0) {
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599187 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i12) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 1572864;
            if ((599187 & i3) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z7 = z6;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z7 = z6;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i12) {
                        ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        function2 = function1;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                if (composerStartRestartGroup.changed(modifier2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                        if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                        }
                        i3 |= i11;
                    } else {
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    }
                    i3 |= i11;
                } else {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 131072;
                        } else {
                            i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 64) != 0) {
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i3 |= i10;
                        }
                        if ((599187 & i3) == 599186) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z7 = z6;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z4;
                                }
                                if ((i2 & 16) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z6 = z5;
                                modifier3 = modifier2;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z7 = z6;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i12) {
                                    ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 1572864;
                    if ((599187 & i3) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i12) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 64) != 0) {
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599187 & i3) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i12) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 1572864;
                if ((599187 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i12) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z2;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                    }
                    i3 |= i11;
                } else {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                }
                i3 |= i11;
            } else {
                toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i9;
                }
                if ((i2 & 64) != 0) {
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599187 & i3) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i12) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 1572864;
                if ((599187 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i12) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 64) != 0) {
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599187 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i12) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 1572864;
            if ((599187 & i3) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z7 = z6;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z7 = z6;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i12) {
                        ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                    }
                    i3 |= i11;
                } else {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                }
                i3 |= i11;
            } else {
                toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i9;
                }
                if ((i2 & 64) != 0) {
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599187 & i3) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z4;
                            }
                            if ((i2 & 16) != 0) {
                                composer2 = composerStartRestartGroup;
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            } else {
                                composer2 = composerStartRestartGroup;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z6 = z5;
                            modifier3 = modifier2;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z7 = z6;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i12) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 1572864;
                if ((599187 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i12) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 64) != 0) {
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599187 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i12) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 1572864;
            if ((599187 & i3) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z7 = z6;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z7 = z6;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i12) {
                        ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        z4 = z2;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                }
                i3 |= i11;
            } else {
                toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
            }
            i3 |= i11;
        } else {
            toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
        }
        i8 = i2 & 32;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i9 = 131072;
                } else {
                    i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i9;
            }
            if ((i2 & 64) != 0) {
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599187 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        if ((i2 & 16) != 0) {
                            composer2 = composerStartRestartGroup;
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            composer2 = composerStartRestartGroup;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composer2.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z6 = z5;
                        modifier3 = modifier2;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z7 = z6;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i12) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 1572864;
            if ((599187 & i3) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z7 = z6;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z7 = z6;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i12) {
                        ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 196608;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 64) != 0) {
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599187 & i3) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z7 = z6;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    if ((i2 & 16) != 0) {
                        composer2 = composerStartRestartGroup;
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z6 = z5;
                    modifier3 = modifier2;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z7 = z6;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i12) {
                        ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 1572864;
        if ((599187 & i3) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z4;
                }
                if ((i2 & 16) != 0) {
                    composer2 = composerStartRestartGroup;
                    i3 &= -57345;
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                } else {
                    composer2 = composerStartRestartGroup;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                    objRememberedValue = composer2.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                z6 = z5;
                modifier3 = modifier2;
                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
            } else {
                if (i4 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z4;
                }
                if ((i2 & 16) != 0) {
                    composer2 = composerStartRestartGroup;
                    i3 &= -57345;
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                } else {
                    composer2 = composerStartRestartGroup;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                    objRememberedValue = composer2.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                z6 = z5;
                modifier3 = modifier2;
                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
            }
            m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            z7 = z6;
            toggleButtonColors3 = toggleButtonColors2;
            mutableInteractionSource4 = mutableInteractionSource3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z4;
                }
                if ((i2 & 16) != 0) {
                    composer2 = composerStartRestartGroup;
                    i3 &= -57345;
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                } else {
                    composer2 = composerStartRestartGroup;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                    objRememberedValue = composer2.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                z6 = z5;
                modifier3 = modifier2;
                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
            } else {
                if (i4 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z4;
                }
                if ((i2 & 16) != 0) {
                    composer2 = composerStartRestartGroup;
                    i3 &= -57345;
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                } else {
                    composer2 = composerStartRestartGroup;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composer2, -534900594, "CC(remember):ToggleButton.kt#9igjgp");
                    objRememberedValue = composer2.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                z6 = z5;
                modifier3 = modifier2;
                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2087705725, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:86)");
            }
            m857ToggleButton2nuZEAM(z3, function2, modifier3, z6, toggleButtonColors2, mutableInteractionSource3, RoundedCornerShapeKt.getCircleShape(), ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (234881024 & (i3 << 6)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            z7 = z6;
            toggleButtonColors3 = toggleButtonColors2;
            mutableInteractionSource4 = mutableInteractionSource3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i12) {
                    ToggleButtonKt.ToggleButton(z, function1, modifier4, z7, toggleButtonColors3, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x013d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x013f  */
    /* JADX WARN: Code duplicated, block: B:111:0x0146  */
    /* JADX WARN: Code duplicated, block: B:114:0x014c  */
    /* JADX WARN: Code duplicated, block: B:116:0x016d  */
    /* JADX WARN: Code duplicated, block: B:118:0x0181  */
    /* JADX WARN: Code duplicated, block: B:120:0x018e  */
    /* JADX WARN: Code duplicated, block: B:123:0x0194  */
    /* JADX WARN: Code duplicated, block: B:124:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:128:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:131:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:135:0x0204  */
    /* JADX WARN: Code duplicated, block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:81:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:92:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:96:0x0111  */
    /* JADX WARN: Code duplicated, block: B:98:0x011e  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is provided for backwards compatibility with Compose for Wear OS 1.1.A newer overload is available with an additional semantic role parameter.")
    public static final /* synthetic */ void ToggleButton(final boolean z, final Function1 function1, Modifier modifier, boolean z2, ToggleButtonColors toggleButtonColors, MutableInteractionSource mutableInteractionSource, Shape shape, final Function3 function3, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        Function1 function2;
        int i4;
        Modifier modifier2;
        int i5;
        int i6;
        boolean z4;
        int i7;
        ToggleButtonColors toggleButtonColorsM856toggleButtonColorsoq7We08;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        int i9;
        Shape shape2;
        int i10;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape3;
        Modifier modifier3;
        boolean z5;
        ToggleButtonColors toggleButtonColors2;
        Object objRememberedValue;
        Composer composer2;
        final Modifier modifier4;
        final boolean z6;
        final ToggleButtonColors toggleButtonColors3;
        final MutableInteractionSource mutableInteractionSource4;
        final Shape shape4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(611085902);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ToggleButton)P(!1,6,5,3!1,4,7)146@7019L20,147@7091L39,150@7214L171:ToggleButton.kt#gj9v0t");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else if ((i & 6) == 0) {
            z3 = z;
            i3 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
        } else {
            z3 = z;
            i3 = i;
        }
        if ((i2 & 2) == 0) {
            if ((i & 48) == 0) {
                function2 = function1;
                i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                        } else {
                            i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                        }
                        i3 |= i7;
                    }
                    if ((i & 24576) == 0) {
                        if ((i2 & 16) == 0) {
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                            int i11 = composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08) ? 16384 : 8192;
                            i3 |= i11;
                        } else {
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                        }
                        i3 |= i11;
                    } else {
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        if ((196608 & i) == 0) {
                            mutableInteractionSource2 = mutableInteractionSource;
                            if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                                i9 = 131072;
                            } else {
                                i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                            }
                            i3 |= i9;
                        }
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                shape2 = shape;
                                int i12 = composerStartRestartGroup.changed(shape2) ? 1048576 : 524288;
                                i3 |= i12;
                            } else {
                                shape2 = shape;
                            }
                            i3 |= i12;
                        } else {
                            shape2 = shape;
                        }
                        if ((i2 & 128) != 0) {
                            if ((i & 12582912) == 0) {
                                if (composerStartRestartGroup.changedInstance(function3)) {
                                    i10 = 8388608;
                                } else {
                                    i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                                }
                                i3 |= i10;
                            }
                            if ((4793491 & i3) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i4 != 0) {
                                        modifier2 = (Modifier) Modifier.Companion;
                                    }
                                    if (i6 != 0) {
                                        z4 = true;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                    }
                                    if (i8 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                    } else {
                                        shape3 = shape;
                                    }
                                    modifier3 = modifier2;
                                    z5 = z4;
                                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                    }
                                    z5 = z4;
                                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    shape3 = shape2;
                                    modifier3 = modifier2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                                }
                                m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                                composer2 = composerStartRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier4 = modifier3;
                                z6 = z5;
                                toggleButtonColors3 = toggleButtonColors2;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                shape4 = shape3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier2;
                                z6 = z4;
                                toggleButtonColors3 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                shape4 = shape2;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i13) {
                                        ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                            }
                        }
                        i3 |= 12582912;
                        if ((4793491 & i3) == 4793490) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z6 = z5;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape4 = shape3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z6 = z5;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape4 = shape3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i13) {
                                    ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 196608;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            shape2 = shape;
                            if (composerStartRestartGroup.changed(shape2)) {
                            }
                            i3 |= i12;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 128) != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i10 = 8388608;
                            } else {
                                i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                            }
                            i3 |= i10;
                        }
                        if ((4793491 & i3) == 4793490) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z6 = z5;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape4 = shape3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z6 = z5;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape4 = shape3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i13) {
                                    ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((4793491 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 3072;
                z4 = z2;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                        if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                        }
                        i3 |= i11;
                    } else {
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    }
                    i3 |= i11;
                } else {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 131072;
                        } else {
                            i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            shape2 = shape;
                            if (composerStartRestartGroup.changed(shape2)) {
                            }
                            i3 |= i12;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 128) != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i10 = 8388608;
                            } else {
                                i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                            }
                            i3 |= i10;
                        }
                        if ((4793491 & i3) == 4793490) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z6 = z5;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape4 = shape3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z6 = z5;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape4 = shape3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i13) {
                                    ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((4793491 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i2 & 128) != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 8388608;
                        } else {
                            i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        }
                        i3 |= i10;
                    }
                    if ((4793491 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((4793491 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 384;
            modifier2 = modifier;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                        if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                        }
                        i3 |= i11;
                    } else {
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    }
                    i3 |= i11;
                } else {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 131072;
                        } else {
                            i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            shape2 = shape;
                            if (composerStartRestartGroup.changed(shape2)) {
                            }
                            i3 |= i12;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 128) != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i10 = 8388608;
                            } else {
                                i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                            }
                            i3 |= i10;
                        }
                        if ((4793491 & i3) == 4793490) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z6 = z5;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape4 = shape3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z6 = z5;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape4 = shape3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i13) {
                                    ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((4793491 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i2 & 128) != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 8388608;
                        } else {
                            i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        }
                        i3 |= i10;
                    }
                    if ((4793491 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((4793491 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z2;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                    }
                    i3 |= i11;
                } else {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                }
                i3 |= i11;
            } else {
                toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i2 & 128) != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 8388608;
                        } else {
                            i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        }
                        i3 |= i10;
                    }
                    if ((4793491 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((4793491 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((i2 & 128) != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 8388608;
                    } else {
                        i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i3 |= i10;
                }
                if ((4793491 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((4793491 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z6 = z5;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z6 = z5;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i13) {
                        ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        function2 = function1;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                if (composerStartRestartGroup.changed(modifier2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                        if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                        }
                        i3 |= i11;
                    } else {
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    }
                    i3 |= i11;
                } else {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 131072;
                        } else {
                            i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            shape2 = shape;
                            if (composerStartRestartGroup.changed(shape2)) {
                            }
                            i3 |= i12;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 128) != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i10 = 8388608;
                            } else {
                                i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                            }
                            i3 |= i10;
                        }
                        if ((4793491 & i3) == 4793490) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z6 = z5;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape4 = shape3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            } else {
                                if (i4 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                                } else {
                                    shape3 = shape;
                                }
                                modifier3 = modifier2;
                                z5 = z4;
                                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                            }
                            m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z6 = z5;
                            toggleButtonColors3 = toggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape4 = shape3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i13) {
                                    ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((4793491 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i2 & 128) != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 8388608;
                        } else {
                            i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        }
                        i3 |= i10;
                    }
                    if ((4793491 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((4793491 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z2;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                    }
                    i3 |= i11;
                } else {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                }
                i3 |= i11;
            } else {
                toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i2 & 128) != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 8388608;
                        } else {
                            i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        }
                        i3 |= i10;
                    }
                    if ((4793491 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((4793491 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((i2 & 128) != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 8388608;
                    } else {
                        i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i3 |= i10;
                }
                if ((4793491 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((4793491 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z6 = z5;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z6 = z5;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i13) {
                        ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                    }
                    i3 |= i11;
                } else {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                }
                i3 |= i11;
            } else {
                toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i2 & 128) != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 8388608;
                        } else {
                            i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        }
                        i3 |= i10;
                    }
                    if ((4793491 & i3) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        } else {
                            if (i4 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            } else {
                                shape3 = shape;
                            }
                            modifier3 = modifier2;
                            z5 = z4;
                            toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                        }
                        m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z6 = z5;
                        toggleButtonColors3 = toggleButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((4793491 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((i2 & 128) != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 8388608;
                    } else {
                        i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i3 |= i10;
                }
                if ((4793491 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((4793491 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z6 = z5;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z6 = z5;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i13) {
                        ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        z4 = z2;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                }
                i3 |= i11;
            } else {
                toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
            }
            i3 |= i11;
        } else {
            toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
        }
        i8 = i2 & 32;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i9 = 131072;
                } else {
                    i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i9;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((i2 & 128) != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 8388608;
                    } else {
                        i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i3 |= i10;
                }
                if ((4793491 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    } else {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        } else {
                            shape3 = shape;
                        }
                        modifier3 = modifier2;
                        z5 = z4;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                    }
                    m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    z6 = z5;
                    toggleButtonColors3 = toggleButtonColors2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((4793491 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z6 = z5;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z6 = z5;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i13) {
                        ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 196608;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            i3 |= i12;
        } else {
            shape2 = shape;
        }
        if ((i2 & 128) != 0) {
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 8388608;
                } else {
                    i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i3 |= i10;
            }
            if ((4793491 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z6 = z5;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                } else {
                    if (i4 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    } else {
                        shape3 = shape;
                    }
                    modifier3 = modifier2;
                    z5 = z4;
                    toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
                }
                m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                z6 = z5;
                toggleButtonColors3 = toggleButtonColors2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i13) {
                        ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 12582912;
        if ((4793491 & i3) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if (i6 != 0) {
                    z4 = true;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                } else {
                    shape3 = shape;
                }
                modifier3 = modifier2;
                z5 = z4;
                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
            } else {
                if (i4 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if (i6 != 0) {
                    z4 = true;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                } else {
                    shape3 = shape;
                }
                modifier3 = modifier2;
                z5 = z4;
                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
            }
            m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            z6 = z5;
            toggleButtonColors3 = toggleButtonColors2;
            mutableInteractionSource4 = mutableInteractionSource3;
            shape4 = shape3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if (i6 != 0) {
                    z4 = true;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                } else {
                    shape3 = shape;
                }
                modifier3 = modifier2;
                z5 = z4;
                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
            } else {
                if (i4 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if (i6 != 0) {
                    z4 = true;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534803314, "CC(remember):ToggleButton.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    shape3 = (Shape) RoundedCornerShapeKt.getCircleShape();
                } else {
                    shape3 = shape;
                }
                modifier3 = modifier2;
                z5 = z4;
                toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(611085902, i3, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:150)");
            }
            m857ToggleButton2nuZEAM(z3, function2, modifier3, z5, toggleButtonColors2, mutableInteractionSource3, shape3, ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c(), function3, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            z6 = z5;
            toggleButtonColors3 = toggleButtonColors2;
            mutableInteractionSource4 = mutableInteractionSource3;
            shape4 = shape3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i13) {
                    ToggleButtonKt.ToggleButton(z, function1, modifier4, z6, toggleButtonColors3, mutableInteractionSource4, shape4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x012e  */
    /* JADX WARN: Code duplicated, block: B:106:0x013c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0152 A[PHI: r3 r5 r8 r9 r12 r13
  0x0152: PHI (r3v40 int) = (r3v26 int), (r3v42 int), (r3v43 int) binds: [B:129:0x0199, B:113:0x014e, B:114:0x0150] A[DONT_GENERATE, DONT_INLINE]
  0x0152: PHI (r5v28 androidx.compose.ui.Modifier) = (r5v3 androidx.compose.ui.Modifier), (r5v2 androidx.compose.ui.Modifier), (r5v2 androidx.compose.ui.Modifier) binds: [B:129:0x0199, B:113:0x014e, B:114:0x0150] A[DONT_GENERATE, DONT_INLINE]
  0x0152: PHI (r8v15 boolean) = (r8v3 boolean), (r8v2 boolean), (r8v2 boolean) binds: [B:129:0x0199, B:113:0x014e, B:114:0x0150] A[DONT_GENERATE, DONT_INLINE]
  0x0152: PHI (r9v12 androidx.wear.compose.material.ToggleButtonColors) = 
  (r9v7 androidx.wear.compose.material.ToggleButtonColors)
  (r9v6 androidx.wear.compose.material.ToggleButtonColors)
  (r9v6 androidx.wear.compose.material.ToggleButtonColors)
 binds: [B:129:0x0199, B:113:0x014e, B:114:0x0150] A[DONT_GENERATE, DONT_INLINE]
  0x0152: PHI (r12v10 androidx.compose.foundation.interaction.MutableInteractionSource) = 
  (r12v4 androidx.compose.foundation.interaction.MutableInteractionSource)
  (r12v3 androidx.compose.foundation.interaction.MutableInteractionSource)
  (r12v3 androidx.compose.foundation.interaction.MutableInteractionSource)
 binds: [B:129:0x0199, B:113:0x014e, B:114:0x0150] A[DONT_GENERATE, DONT_INLINE]
  0x0152: PHI (r13v11 androidx.compose.ui.graphics.Shape) = 
  (r13v7 androidx.compose.ui.graphics.Shape)
  (r13v6 androidx.compose.ui.graphics.Shape)
  (r13v6 androidx.compose.ui.graphics.Shape)
 binds: [B:129:0x0199, B:113:0x014e, B:114:0x0150] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:117:0x015c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:118:0x015e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0165  */
    /* JADX WARN: Code duplicated, block: B:123:0x016a  */
    /* JADX WARN: Code duplicated, block: B:125:0x018b  */
    /* JADX WARN: Code duplicated, block: B:128:0x0190  */
    /* JADX WARN: Code duplicated, block: B:130:0x019b  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:136:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:137:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:140:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:142:0x01db  */
    /* JADX WARN: Code duplicated, block: B:145:0x026c  */
    /* JADX WARN: Code duplicated, block: B:149:0x0281  */
    /* JADX WARN: Code duplicated, block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:55:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00df  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:90:0x0100  */
    /* JADX WARN: Code duplicated, block: B:92:0x0104  */
    /* JADX WARN: Code duplicated, block: B:94:0x010a  */
    /* JADX WARN: Code duplicated, block: B:95:0x010d  */
    /* JADX WARN: Code duplicated, block: B:99:0x0119  */
    /* JADX INFO: renamed from: ToggleButton-2nuZEAM, reason: not valid java name */
    public static final void m857ToggleButton2nuZEAM(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, ToggleButtonColors toggleButtonColors, MutableInteractionSource mutableInteractionSource, Shape shape, int i, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i2, final int i3) {
        int i4;
        Function1<? super Boolean, Unit> function2;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        ToggleButtonColors toggleButtonColorsM856toggleButtonColorsoq7We08;
        int i7;
        MutableInteractionSource mutableInteractionSource2;
        int i8;
        Shape shape2;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z4;
        Shape shape3;
        final int iM852getDefaultRoleo7Vup1c;
        Modifier modifier3;
        boolean z5;
        Object objRememberedValue;
        final boolean z6;
        Composer composer2;
        final Shape shape4;
        final ToggleButtonColors toggleButtonColors2;
        final int i13;
        final Modifier modifier4;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i14;
        Composer composerStartRestartGroup = composer.startRestartGroup(847453268);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ToggleButton)P(!1,6,5,3!1,4,8,7:c#ui.semantics.Role)209@9968L20,218@10341L20,227@10725L32,229@10817L50,230@10895L10,215@10219L730:ToggleButton.kt#gj9v0t");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function2 = function1;
        } else {
            function2 = function1;
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
            }
        }
        int i15 = i3 & 4;
        if (i15 == 0) {
            if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 3072) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i4 |= i6;
                }
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                        int i16 = composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08) ? 16384 : 8192;
                        i4 |= i16;
                    } else {
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    }
                    i4 |= i16;
                } else {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    if ((196608 & i2) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i8 = 131072;
                        } else {
                            i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i4 |= i8;
                    }
                    if ((i2 & 1572864) == 0) {
                        shape2 = shape;
                        if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(shape2)) {
                            i14 = 524288;
                        } else {
                            i14 = 1048576;
                        }
                        i4 |= i14;
                    } else {
                        shape2 = shape;
                    }
                    i9 = i3 & 128;
                    if (i9 != 0) {
                        i4 |= 12582912;
                    } else if ((i2 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(i)) {
                            i10 = 8388608;
                        } else {
                            i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        }
                        i4 |= i10;
                    }
                    if ((i3 & 256) != 0) {
                        i4 |= 100663296;
                    } else if ((i2 & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i4 |= i11;
                    }
                    if ((38347923 & i4) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                                toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                            }
                            if (i7 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                            }
                            if (i9 != 0) {
                                i12 = i4;
                                z4 = z3;
                                shape3 = shape2;
                                iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                                modifier3 = modifier2;
                            }
                            MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                            final ToggleButtonColors toggleButtonColors3 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(847453268, i12, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:214)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534699333, "CC(remember):ToggleButton.kt#9igjgp");
                            if ((29360128 & i12) == 8388608) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z5 || objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((SemanticsPropertyReceiver) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i17 = iM852getDefaultRoleo7Vup1c;
                            int i18 = i12;
                            Modifier modifier5 = modifier3;
                            int i19 = i18 << 6;
                            Shape shape5 = shape3;
                            boolean z7 = z4;
                            androidx.wear.compose.materialcore.ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function2, SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null), z7, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.6
                                {
                                    super(4);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                                }

                                public final State<Color> invoke(boolean z8, boolean z9, Composer composer3, int i20) {
                                    composer3.startReplaceGroup(1265496074);
                                    ComposerKt.sourceInformation(composer3, "CP(1)221@10461L57:ToggleButton.kt#gj9v0t");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1265496074, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:221)");
                                    }
                                    State<Color> stateBackgroundColor = toggleButtonColors3.backgroundColor(z8, z9, composer3, i20 & 126);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return stateBackgroundColor;
                                }
                            }, new Function4<Boolean, Boolean, Composer, Integer, BorderStroke>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.7
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                                }

                                public final BorderStroke invoke(boolean z8, boolean z9, Composer composer3, int i20) {
                                    composer3.startReplaceGroup(-583917890);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-583917890, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:223)");
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return null;
                                }
                            }, ToggleButtonDefaults.INSTANCE.m853getDefaultToggleButtonSizeD9Ej5fM(), mutableInteractionSource4, shape5, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7), ProvidersKt.provideScopeContent(toggleButtonColors3.contentColor(z4, z, composerStartRestartGroup, ((i18 >> 9) & 14) | ((i18 << 3) & 112) | ((i18 >> 6) & 896)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton(), function3), composerStartRestartGroup, (i19 & 234881024) | (i18 & 14) | 1572864 | (i18 & 112) | (i18 & 7168) | (29360128 & i19), 0);
                            mutableInteractionSource2 = mutableInteractionSource4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z7;
                            composer2 = composerStartRestartGroup;
                            shape4 = shape5;
                            toggleButtonColors2 = toggleButtonColors3;
                            i13 = i17;
                            modifier4 = modifier5;
                        }
                        i12 = i4;
                        modifier3 = modifier2;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = i;
                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                        final ToggleButtonColors toggleButtonColors4 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(847453268, i12, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:214)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534699333, "CC(remember):ToggleButton.kt#9igjgp");
                        if ((29360128 & i12) == 8388608) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((SemanticsPropertyReceiver) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((SemanticsPropertyReceiver) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i110 = iM852getDefaultRoleo7Vup1c;
                        int i111 = i12;
                        Modifier modifier6 = modifier3;
                        int i112 = i111 << 6;
                        Shape shape6 = shape3;
                        boolean z8 = z4;
                        androidx.wear.compose.materialcore.ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function2, SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null), z8, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.6
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z9, boolean z10, Composer composer3, int i20) {
                                composer3.startReplaceGroup(1265496074);
                                ComposerKt.sourceInformation(composer3, "CP(1)221@10461L57:ToggleButton.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1265496074, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:221)");
                                }
                                State<Color> stateBackgroundColor = toggleButtonColors4.backgroundColor(z9, z10, composer3, i20 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateBackgroundColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, BorderStroke>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.7
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final BorderStroke invoke(boolean z9, boolean z10, Composer composer3, int i20) {
                                composer3.startReplaceGroup(-583917890);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-583917890, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:223)");
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return null;
                            }
                        }, ToggleButtonDefaults.INSTANCE.m853getDefaultToggleButtonSizeD9Ej5fM(), mutableInteractionSource5, shape6, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7), ProvidersKt.provideScopeContent(toggleButtonColors4.contentColor(z4, z, composerStartRestartGroup, ((i111 >> 9) & 14) | ((i111 << 3) & 112) | ((i111 >> 6) & 896)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton(), function3), composerStartRestartGroup, (i112 & 234881024) | (i111 & 14) | 1572864 | (i111 & 112) | (i111 & 7168) | (29360128 & i112), 0);
                        mutableInteractionSource2 = mutableInteractionSource5;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z8;
                        composer2 = composerStartRestartGroup;
                        shape4 = shape6;
                        toggleButtonColors2 = toggleButtonColors4;
                        i13 = i110;
                        modifier4 = modifier6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        composer2 = composerStartRestartGroup;
                        z6 = z3;
                        toggleButtonColors2 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                        shape4 = shape2;
                        i13 = i;
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                ToggleButtonKt.m857ToggleButton2nuZEAM(z, function1, modifier4, z6, toggleButtonColors2, mutableInteractionSource3, shape4, i13, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                    }
                }
                i4 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 1572864) == 0) {
                    shape2 = shape;
                    if ((i3 & 64) == 0) {
                        i14 = 524288;
                    } else {
                        i14 = 524288;
                    }
                    i4 |= i14;
                } else {
                    shape2 = shape;
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i10 = 8388608;
                    } else {
                        i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i4 |= i10;
                }
                if ((i3 & 256) != 0) {
                    i4 |= 100663296;
                } else if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i4 |= i11;
                }
                if ((38347923 & i4) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) == 0) {
                        if (i15 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i7 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        }
                        if (i9 != 0) {
                            i12 = i4;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                            modifier3 = modifier2;
                        } else {
                            i12 = i4;
                            modifier3 = modifier2;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = i;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i7 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        }
                        if (i9 != 0) {
                            i12 = i4;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                            modifier3 = modifier2;
                        } else {
                            i12 = i4;
                            modifier3 = modifier2;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = i;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource2;
                    final ToggleButtonColors toggleButtonColors5 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(847453268, i12, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:214)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534699333, "CC(remember):ToggleButton.kt#9igjgp");
                    if ((29360128 & i12) == 8388608) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i113 = iM852getDefaultRoleo7Vup1c;
                    int i114 = i12;
                    Modifier modifier7 = modifier3;
                    int i115 = i114 << 6;
                    Shape shape7 = shape3;
                    boolean z9 = z4;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function2, SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null), z9, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.6
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z10, boolean z11, Composer composer3, int i20) {
                            composer3.startReplaceGroup(1265496074);
                            ComposerKt.sourceInformation(composer3, "CP(1)221@10461L57:ToggleButton.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1265496074, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:221)");
                            }
                            State<Color> stateBackgroundColor = toggleButtonColors5.backgroundColor(z10, z11, composer3, i20 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateBackgroundColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, BorderStroke>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.7
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final BorderStroke invoke(boolean z10, boolean z11, Composer composer3, int i20) {
                            composer3.startReplaceGroup(-583917890);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-583917890, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:223)");
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return null;
                        }
                    }, ToggleButtonDefaults.INSTANCE.m853getDefaultToggleButtonSizeD9Ej5fM(), mutableInteractionSource6, shape7, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7), ProvidersKt.provideScopeContent(toggleButtonColors5.contentColor(z4, z, composerStartRestartGroup, ((i114 >> 9) & 14) | ((i114 << 3) & 112) | ((i114 >> 6) & 896)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton(), function3), composerStartRestartGroup, (i115 & 234881024) | (i114 & 14) | 1572864 | (i114 & 112) | (i114 & 7168) | (29360128 & i115), 0);
                    mutableInteractionSource2 = mutableInteractionSource6;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z9;
                    composer2 = composerStartRestartGroup;
                    shape4 = shape7;
                    toggleButtonColors2 = toggleButtonColors5;
                    i13 = i113;
                    modifier4 = modifier7;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) == 0) {
                        if (i15 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i7 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        }
                        if (i9 != 0) {
                            i12 = i4;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                            modifier3 = modifier2;
                        } else {
                            i12 = i4;
                            modifier3 = modifier2;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = i;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i7 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        }
                        if (i9 != 0) {
                            i12 = i4;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                            modifier3 = modifier2;
                        } else {
                            i12 = i4;
                            modifier3 = modifier2;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = i;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource2;
                    final ToggleButtonColors toggleButtonColors6 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(847453268, i12, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:214)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534699333, "CC(remember):ToggleButton.kt#9igjgp");
                    if ((29360128 & i12) == 8388608) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i116 = iM852getDefaultRoleo7Vup1c;
                    int i117 = i12;
                    Modifier modifier8 = modifier3;
                    int i118 = i117 << 6;
                    Shape shape8 = shape3;
                    boolean z10 = z4;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function2, SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null), z10, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.6
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z11, boolean z12, Composer composer3, int i20) {
                            composer3.startReplaceGroup(1265496074);
                            ComposerKt.sourceInformation(composer3, "CP(1)221@10461L57:ToggleButton.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1265496074, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:221)");
                            }
                            State<Color> stateBackgroundColor = toggleButtonColors6.backgroundColor(z11, z12, composer3, i20 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateBackgroundColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, BorderStroke>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.7
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final BorderStroke invoke(boolean z11, boolean z12, Composer composer3, int i20) {
                            composer3.startReplaceGroup(-583917890);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-583917890, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:223)");
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return null;
                        }
                    }, ToggleButtonDefaults.INSTANCE.m853getDefaultToggleButtonSizeD9Ej5fM(), mutableInteractionSource7, shape8, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7), ProvidersKt.provideScopeContent(toggleButtonColors6.contentColor(z4, z, composerStartRestartGroup, ((i117 >> 9) & 14) | ((i117 << 3) & 112) | ((i117 >> 6) & 896)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton(), function3), composerStartRestartGroup, (i118 & 234881024) | (i117 & 14) | 1572864 | (i117 & 112) | (i117 & 7168) | (29360128 & i118), 0);
                    mutableInteractionSource2 = mutableInteractionSource7;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z10;
                    composer2 = composerStartRestartGroup;
                    shape4 = shape8;
                    toggleButtonColors2 = toggleButtonColors6;
                    i13 = i116;
                    modifier4 = modifier8;
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            ToggleButtonKt.m857ToggleButton2nuZEAM(z, function1, modifier4, z6, toggleButtonColors2, mutableInteractionSource3, shape4, i13, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 3072;
            z3 = z2;
            if ((i2 & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                    }
                    i4 |= i16;
                } else {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                }
                i4 |= i16;
            } else {
                toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i8 = 131072;
                    } else {
                        i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i8;
                }
                if ((i2 & 1572864) == 0) {
                    shape2 = shape;
                    if ((i3 & 64) == 0) {
                        i14 = 524288;
                    } else {
                        i14 = 524288;
                    }
                    i4 |= i14;
                } else {
                    shape2 = shape;
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i10 = 8388608;
                    } else {
                        i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i4 |= i10;
                }
                if ((i3 & 256) != 0) {
                    i4 |= 100663296;
                } else if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i4 |= i11;
                }
                if ((38347923 & i4) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) == 0) {
                        if (i15 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i7 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        }
                        if (i9 != 0) {
                            i12 = i4;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                            modifier3 = modifier2;
                        } else {
                            i12 = i4;
                            modifier3 = modifier2;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = i;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i7 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        }
                        if (i9 != 0) {
                            i12 = i4;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                            modifier3 = modifier2;
                        } else {
                            i12 = i4;
                            modifier3 = modifier2;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = i;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource2;
                    final ToggleButtonColors toggleButtonColors7 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(847453268, i12, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:214)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534699333, "CC(remember):ToggleButton.kt#9igjgp");
                    if ((29360128 & i12) == 8388608) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i119 = iM852getDefaultRoleo7Vup1c;
                    int i1110 = i12;
                    Modifier modifier9 = modifier3;
                    int i1111 = i1110 << 6;
                    Shape shape9 = shape3;
                    boolean z11 = z4;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function2, SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null), z11, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.6
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z12, boolean z13, Composer composer3, int i20) {
                            composer3.startReplaceGroup(1265496074);
                            ComposerKt.sourceInformation(composer3, "CP(1)221@10461L57:ToggleButton.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1265496074, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:221)");
                            }
                            State<Color> stateBackgroundColor = toggleButtonColors7.backgroundColor(z12, z13, composer3, i20 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateBackgroundColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, BorderStroke>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.7
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final BorderStroke invoke(boolean z12, boolean z13, Composer composer3, int i20) {
                            composer3.startReplaceGroup(-583917890);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-583917890, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:223)");
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return null;
                        }
                    }, ToggleButtonDefaults.INSTANCE.m853getDefaultToggleButtonSizeD9Ej5fM(), mutableInteractionSource8, shape9, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7), ProvidersKt.provideScopeContent(toggleButtonColors7.contentColor(z4, z, composerStartRestartGroup, ((i1110 >> 9) & 14) | ((i1110 << 3) & 112) | ((i1110 >> 6) & 896)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton(), function3), composerStartRestartGroup, (i1111 & 234881024) | (i1110 & 14) | 1572864 | (i1110 & 112) | (i1110 & 7168) | (29360128 & i1111), 0);
                    mutableInteractionSource2 = mutableInteractionSource8;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z11;
                    composer2 = composerStartRestartGroup;
                    shape4 = shape9;
                    toggleButtonColors2 = toggleButtonColors7;
                    i13 = i119;
                    modifier4 = modifier9;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) == 0) {
                        if (i15 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i7 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        }
                        if (i9 != 0) {
                            i12 = i4;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                            modifier3 = modifier2;
                        } else {
                            i12 = i4;
                            modifier3 = modifier2;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = i;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i7 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        }
                        if (i9 != 0) {
                            i12 = i4;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                            modifier3 = modifier2;
                        } else {
                            i12 = i4;
                            modifier3 = modifier2;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = i;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource2;
                    final ToggleButtonColors toggleButtonColors8 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(847453268, i12, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:214)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534699333, "CC(remember):ToggleButton.kt#9igjgp");
                    if ((29360128 & i12) == 8388608) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i1112 = iM852getDefaultRoleo7Vup1c;
                    int i1113 = i12;
                    Modifier modifier10 = modifier3;
                    int i1114 = i1113 << 6;
                    Shape shape10 = shape3;
                    boolean z12 = z4;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function2, SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null), z12, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.6
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z13, boolean z14, Composer composer3, int i20) {
                            composer3.startReplaceGroup(1265496074);
                            ComposerKt.sourceInformation(composer3, "CP(1)221@10461L57:ToggleButton.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1265496074, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:221)");
                            }
                            State<Color> stateBackgroundColor = toggleButtonColors8.backgroundColor(z13, z14, composer3, i20 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateBackgroundColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, BorderStroke>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.7
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final BorderStroke invoke(boolean z13, boolean z14, Composer composer3, int i20) {
                            composer3.startReplaceGroup(-583917890);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-583917890, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:223)");
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return null;
                        }
                    }, ToggleButtonDefaults.INSTANCE.m853getDefaultToggleButtonSizeD9Ej5fM(), mutableInteractionSource9, shape10, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7), ProvidersKt.provideScopeContent(toggleButtonColors8.contentColor(z4, z, composerStartRestartGroup, ((i1113 >> 9) & 14) | ((i1113 << 3) & 112) | ((i1113 >> 6) & 896)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton(), function3), composerStartRestartGroup, (i1114 & 234881024) | (i1113 & 14) | 1572864 | (i1113 & 112) | (i1113 & 7168) | (29360128 & i1114), 0);
                    mutableInteractionSource2 = mutableInteractionSource9;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z12;
                    composer2 = composerStartRestartGroup;
                    shape4 = shape10;
                    toggleButtonColors2 = toggleButtonColors8;
                    i13 = i1112;
                    modifier4 = modifier10;
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            ToggleButtonKt.m857ToggleButton2nuZEAM(z, function1, modifier4, z6, toggleButtonColors2, mutableInteractionSource3, shape4, i13, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 1572864) == 0) {
                shape2 = shape;
                if ((i3 & 64) == 0) {
                    i14 = 524288;
                } else {
                    i14 = 524288;
                }
                i4 |= i14;
            } else {
                shape2 = shape;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i10 = 8388608;
                } else {
                    i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i4 |= i10;
            }
            if ((i3 & 256) != 0) {
                i4 |= 100663296;
            } else if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i4 |= i11;
            }
            if ((38347923 & i4) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) == 0) {
                    if (i15 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i7 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                        modifier3 = modifier2;
                    } else {
                        i12 = i4;
                        modifier3 = modifier2;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = i;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i7 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                        modifier3 = modifier2;
                    } else {
                        i12 = i4;
                        modifier3 = modifier2;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = i;
                    }
                }
                MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource2;
                final ToggleButtonColors toggleButtonColors9 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(847453268, i12, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:214)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534699333, "CC(remember):ToggleButton.kt#9igjgp");
                if ((29360128 & i12) == 8388608) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i1115 = iM852getDefaultRoleo7Vup1c;
                int i1116 = i12;
                Modifier modifier11 = modifier3;
                int i1117 = i1116 << 6;
                Shape shape11 = shape3;
                boolean z13 = z4;
                androidx.wear.compose.materialcore.ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function2, SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null), z13, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.6
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z14, boolean z15, Composer composer3, int i20) {
                        composer3.startReplaceGroup(1265496074);
                        ComposerKt.sourceInformation(composer3, "CP(1)221@10461L57:ToggleButton.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1265496074, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:221)");
                        }
                        State<Color> stateBackgroundColor = toggleButtonColors9.backgroundColor(z14, z15, composer3, i20 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateBackgroundColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, BorderStroke>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.7
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final BorderStroke invoke(boolean z14, boolean z15, Composer composer3, int i20) {
                        composer3.startReplaceGroup(-583917890);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-583917890, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:223)");
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return null;
                    }
                }, ToggleButtonDefaults.INSTANCE.m853getDefaultToggleButtonSizeD9Ej5fM(), mutableInteractionSource10, shape11, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7), ProvidersKt.provideScopeContent(toggleButtonColors9.contentColor(z4, z, composerStartRestartGroup, ((i1116 >> 9) & 14) | ((i1116 << 3) & 112) | ((i1116 >> 6) & 896)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton(), function3), composerStartRestartGroup, (i1117 & 234881024) | (i1116 & 14) | 1572864 | (i1116 & 112) | (i1116 & 7168) | (29360128 & i1117), 0);
                mutableInteractionSource2 = mutableInteractionSource10;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z13;
                composer2 = composerStartRestartGroup;
                shape4 = shape11;
                toggleButtonColors2 = toggleButtonColors9;
                i13 = i1115;
                modifier4 = modifier11;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) == 0) {
                    if (i15 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i7 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                        modifier3 = modifier2;
                    } else {
                        i12 = i4;
                        modifier3 = modifier2;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = i;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i7 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                        modifier3 = modifier2;
                    } else {
                        i12 = i4;
                        modifier3 = modifier2;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = i;
                    }
                }
                MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource2;
                final ToggleButtonColors toggleButtonColors10 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(847453268, i12, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:214)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534699333, "CC(remember):ToggleButton.kt#9igjgp");
                if ((29360128 & i12) == 8388608) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i1118 = iM852getDefaultRoleo7Vup1c;
                int i1119 = i12;
                Modifier modifier12 = modifier3;
                int i11110 = i1119 << 6;
                Shape shape12 = shape3;
                boolean z14 = z4;
                androidx.wear.compose.materialcore.ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function2, SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null), z14, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.6
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z15, boolean z16, Composer composer3, int i20) {
                        composer3.startReplaceGroup(1265496074);
                        ComposerKt.sourceInformation(composer3, "CP(1)221@10461L57:ToggleButton.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1265496074, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:221)");
                        }
                        State<Color> stateBackgroundColor = toggleButtonColors10.backgroundColor(z15, z16, composer3, i20 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateBackgroundColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, BorderStroke>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.7
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final BorderStroke invoke(boolean z15, boolean z16, Composer composer3, int i20) {
                        composer3.startReplaceGroup(-583917890);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-583917890, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:223)");
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return null;
                    }
                }, ToggleButtonDefaults.INSTANCE.m853getDefaultToggleButtonSizeD9Ej5fM(), mutableInteractionSource11, shape12, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7), ProvidersKt.provideScopeContent(toggleButtonColors10.contentColor(z4, z, composerStartRestartGroup, ((i1119 >> 9) & 14) | ((i1119 << 3) & 112) | ((i1119 >> 6) & 896)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton(), function3), composerStartRestartGroup, (i11110 & 234881024) | (i1119 & 14) | 1572864 | (i1119 & 112) | (i1119 & 7168) | (29360128 & i11110), 0);
                mutableInteractionSource2 = mutableInteractionSource11;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z14;
                composer2 = composerStartRestartGroup;
                shape4 = shape12;
                toggleButtonColors2 = toggleButtonColors10;
                i13 = i1118;
                modifier4 = modifier12;
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        ToggleButtonKt.m857ToggleButton2nuZEAM(z, function1, modifier4, z6, toggleButtonColors2, mutableInteractionSource3, shape4, i13, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i2 & 3072) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i4 |= i6;
            }
            if ((i2 & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                    if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                    }
                    i4 |= i16;
                } else {
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                }
                i4 |= i16;
            } else {
                toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i8 = 131072;
                    } else {
                        i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i8;
                }
                if ((i2 & 1572864) == 0) {
                    shape2 = shape;
                    if ((i3 & 64) == 0) {
                        i14 = 524288;
                    } else {
                        i14 = 524288;
                    }
                    i4 |= i14;
                } else {
                    shape2 = shape;
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i10 = 8388608;
                    } else {
                        i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i4 |= i10;
                }
                if ((i3 & 256) != 0) {
                    i4 |= 100663296;
                } else if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i4 |= i11;
                }
                if ((38347923 & i4) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) == 0) {
                        if (i15 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i7 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        }
                        if (i9 != 0) {
                            i12 = i4;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                            modifier3 = modifier2;
                        } else {
                            i12 = i4;
                            modifier3 = modifier2;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = i;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i7 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        }
                        if (i9 != 0) {
                            i12 = i4;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                            modifier3 = modifier2;
                        } else {
                            i12 = i4;
                            modifier3 = modifier2;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = i;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource2;
                    final ToggleButtonColors toggleButtonColors11 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(847453268, i12, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:214)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534699333, "CC(remember):ToggleButton.kt#9igjgp");
                    if ((29360128 & i12) == 8388608) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i11111 = iM852getDefaultRoleo7Vup1c;
                    int i11112 = i12;
                    Modifier modifier13 = modifier3;
                    int i11113 = i11112 << 6;
                    Shape shape13 = shape3;
                    boolean z15 = z4;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function2, SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null), z15, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.6
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z16, boolean z17, Composer composer3, int i20) {
                            composer3.startReplaceGroup(1265496074);
                            ComposerKt.sourceInformation(composer3, "CP(1)221@10461L57:ToggleButton.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1265496074, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:221)");
                            }
                            State<Color> stateBackgroundColor = toggleButtonColors11.backgroundColor(z16, z17, composer3, i20 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateBackgroundColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, BorderStroke>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.7
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final BorderStroke invoke(boolean z16, boolean z17, Composer composer3, int i20) {
                            composer3.startReplaceGroup(-583917890);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-583917890, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:223)");
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return null;
                        }
                    }, ToggleButtonDefaults.INSTANCE.m853getDefaultToggleButtonSizeD9Ej5fM(), mutableInteractionSource12, shape13, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7), ProvidersKt.provideScopeContent(toggleButtonColors11.contentColor(z4, z, composerStartRestartGroup, ((i11112 >> 9) & 14) | ((i11112 << 3) & 112) | ((i11112 >> 6) & 896)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton(), function3), composerStartRestartGroup, (i11113 & 234881024) | (i11112 & 14) | 1572864 | (i11112 & 112) | (i11112 & 7168) | (29360128 & i11113), 0);
                    mutableInteractionSource2 = mutableInteractionSource12;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z15;
                    composer2 = composerStartRestartGroup;
                    shape4 = shape13;
                    toggleButtonColors2 = toggleButtonColors11;
                    i13 = i11111;
                    modifier4 = modifier13;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) == 0) {
                        if (i15 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i7 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        }
                        if (i9 != 0) {
                            i12 = i4;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                            modifier3 = modifier2;
                        } else {
                            i12 = i4;
                            modifier3 = modifier2;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = i;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                        }
                        if (i7 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        }
                        if (i9 != 0) {
                            i12 = i4;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                            modifier3 = modifier2;
                        } else {
                            i12 = i4;
                            modifier3 = modifier2;
                            z4 = z3;
                            shape3 = shape2;
                            iM852getDefaultRoleo7Vup1c = i;
                        }
                    }
                    MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource2;
                    final ToggleButtonColors toggleButtonColors12 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(847453268, i12, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:214)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534699333, "CC(remember):ToggleButton.kt#9igjgp");
                    if ((29360128 & i12) == 8388608) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i11114 = iM852getDefaultRoleo7Vup1c;
                    int i11115 = i12;
                    Modifier modifier14 = modifier3;
                    int i11116 = i11115 << 6;
                    Shape shape14 = shape3;
                    boolean z16 = z4;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function2, SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null), z16, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.6
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z17, boolean z18, Composer composer3, int i20) {
                            composer3.startReplaceGroup(1265496074);
                            ComposerKt.sourceInformation(composer3, "CP(1)221@10461L57:ToggleButton.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1265496074, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:221)");
                            }
                            State<Color> stateBackgroundColor = toggleButtonColors12.backgroundColor(z17, z18, composer3, i20 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateBackgroundColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, BorderStroke>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.7
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final BorderStroke invoke(boolean z17, boolean z18, Composer composer3, int i20) {
                            composer3.startReplaceGroup(-583917890);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-583917890, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:223)");
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return null;
                        }
                    }, ToggleButtonDefaults.INSTANCE.m853getDefaultToggleButtonSizeD9Ej5fM(), mutableInteractionSource13, shape14, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7), ProvidersKt.provideScopeContent(toggleButtonColors12.contentColor(z4, z, composerStartRestartGroup, ((i11115 >> 9) & 14) | ((i11115 << 3) & 112) | ((i11115 >> 6) & 896)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton(), function3), composerStartRestartGroup, (i11116 & 234881024) | (i11115 & 14) | 1572864 | (i11115 & 112) | (i11115 & 7168) | (29360128 & i11116), 0);
                    mutableInteractionSource2 = mutableInteractionSource13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z16;
                    composer2 = composerStartRestartGroup;
                    shape4 = shape14;
                    toggleButtonColors2 = toggleButtonColors12;
                    i13 = i11114;
                    modifier4 = modifier14;
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            ToggleButtonKt.m857ToggleButton2nuZEAM(z, function1, modifier4, z6, toggleButtonColors2, mutableInteractionSource3, shape4, i13, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 1572864) == 0) {
                shape2 = shape;
                if ((i3 & 64) == 0) {
                    i14 = 524288;
                } else {
                    i14 = 524288;
                }
                i4 |= i14;
            } else {
                shape2 = shape;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i10 = 8388608;
                } else {
                    i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i4 |= i10;
            }
            if ((i3 & 256) != 0) {
                i4 |= 100663296;
            } else if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i4 |= i11;
            }
            if ((38347923 & i4) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) == 0) {
                    if (i15 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i7 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                        modifier3 = modifier2;
                    } else {
                        i12 = i4;
                        modifier3 = modifier2;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = i;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i7 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                        modifier3 = modifier2;
                    } else {
                        i12 = i4;
                        modifier3 = modifier2;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = i;
                    }
                }
                MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource2;
                final ToggleButtonColors toggleButtonColors13 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(847453268, i12, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:214)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534699333, "CC(remember):ToggleButton.kt#9igjgp");
                if ((29360128 & i12) == 8388608) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i11117 = iM852getDefaultRoleo7Vup1c;
                int i11118 = i12;
                Modifier modifier15 = modifier3;
                int i11119 = i11118 << 6;
                Shape shape15 = shape3;
                boolean z17 = z4;
                androidx.wear.compose.materialcore.ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function2, SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null), z17, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.6
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z18, boolean z19, Composer composer3, int i20) {
                        composer3.startReplaceGroup(1265496074);
                        ComposerKt.sourceInformation(composer3, "CP(1)221@10461L57:ToggleButton.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1265496074, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:221)");
                        }
                        State<Color> stateBackgroundColor = toggleButtonColors13.backgroundColor(z18, z19, composer3, i20 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateBackgroundColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, BorderStroke>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.7
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final BorderStroke invoke(boolean z18, boolean z19, Composer composer3, int i20) {
                        composer3.startReplaceGroup(-583917890);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-583917890, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:223)");
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return null;
                    }
                }, ToggleButtonDefaults.INSTANCE.m853getDefaultToggleButtonSizeD9Ej5fM(), mutableInteractionSource14, shape15, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7), ProvidersKt.provideScopeContent(toggleButtonColors13.contentColor(z4, z, composerStartRestartGroup, ((i11118 >> 9) & 14) | ((i11118 << 3) & 112) | ((i11118 >> 6) & 896)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton(), function3), composerStartRestartGroup, (i11119 & 234881024) | (i11118 & 14) | 1572864 | (i11118 & 112) | (i11118 & 7168) | (29360128 & i11119), 0);
                mutableInteractionSource2 = mutableInteractionSource14;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z17;
                composer2 = composerStartRestartGroup;
                shape4 = shape15;
                toggleButtonColors2 = toggleButtonColors13;
                i13 = i11117;
                modifier4 = modifier15;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) == 0) {
                    if (i15 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i7 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                        modifier3 = modifier2;
                    } else {
                        i12 = i4;
                        modifier3 = modifier2;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = i;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i7 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                        modifier3 = modifier2;
                    } else {
                        i12 = i4;
                        modifier3 = modifier2;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = i;
                    }
                }
                MutableInteractionSource mutableInteractionSource15 = mutableInteractionSource2;
                final ToggleButtonColors toggleButtonColors14 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(847453268, i12, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:214)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534699333, "CC(remember):ToggleButton.kt#9igjgp");
                if ((29360128 & i12) == 8388608) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i111110 = iM852getDefaultRoleo7Vup1c;
                int i111111 = i12;
                Modifier modifier16 = modifier3;
                int i111112 = i111111 << 6;
                Shape shape16 = shape3;
                boolean z18 = z4;
                androidx.wear.compose.materialcore.ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function2, SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null), z18, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.6
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z19, boolean z110, Composer composer3, int i20) {
                        composer3.startReplaceGroup(1265496074);
                        ComposerKt.sourceInformation(composer3, "CP(1)221@10461L57:ToggleButton.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1265496074, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:221)");
                        }
                        State<Color> stateBackgroundColor = toggleButtonColors14.backgroundColor(z19, z110, composer3, i20 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateBackgroundColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, BorderStroke>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.7
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final BorderStroke invoke(boolean z19, boolean z110, Composer composer3, int i20) {
                        composer3.startReplaceGroup(-583917890);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-583917890, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:223)");
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return null;
                    }
                }, ToggleButtonDefaults.INSTANCE.m853getDefaultToggleButtonSizeD9Ej5fM(), mutableInteractionSource15, shape16, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7), ProvidersKt.provideScopeContent(toggleButtonColors14.contentColor(z4, z, composerStartRestartGroup, ((i111111 >> 9) & 14) | ((i111111 << 3) & 112) | ((i111111 >> 6) & 896)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton(), function3), composerStartRestartGroup, (i111112 & 234881024) | (i111111 & 14) | 1572864 | (i111111 & 112) | (i111111 & 7168) | (29360128 & i111112), 0);
                mutableInteractionSource2 = mutableInteractionSource15;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z18;
                composer2 = composerStartRestartGroup;
                shape4 = shape16;
                toggleButtonColors2 = toggleButtonColors14;
                i13 = i111110;
                modifier4 = modifier16;
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        ToggleButtonKt.m857ToggleButton2nuZEAM(z, function1, modifier4, z6, toggleButtonColors2, mutableInteractionSource3, shape4, i13, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
            }
        }
        i4 |= 3072;
        z3 = z2;
        if ((i2 & 24576) == 0) {
            if ((i3 & 16) == 0) {
                toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
                if (composerStartRestartGroup.changed(toggleButtonColorsM856toggleButtonColorsoq7We08)) {
                }
                i4 |= i16;
            } else {
                toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
            }
            i4 |= i16;
        } else {
            toggleButtonColorsM856toggleButtonColorsoq7We08 = toggleButtonColors;
        }
        i7 = i3 & 32;
        if (i7 != 0) {
            if ((196608 & i2) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i8 = 131072;
                } else {
                    i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i4 |= i8;
            }
            if ((i2 & 1572864) == 0) {
                shape2 = shape;
                if ((i3 & 64) == 0) {
                    i14 = 524288;
                } else {
                    i14 = 524288;
                }
                i4 |= i14;
            } else {
                shape2 = shape;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i10 = 8388608;
                } else {
                    i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i4 |= i10;
            }
            if ((i3 & 256) != 0) {
                i4 |= 100663296;
            } else if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i4 |= i11;
            }
            if ((38347923 & i4) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) == 0) {
                    if (i15 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i7 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                        modifier3 = modifier2;
                    } else {
                        i12 = i4;
                        modifier3 = modifier2;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = i;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i7 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                        modifier3 = modifier2;
                    } else {
                        i12 = i4;
                        modifier3 = modifier2;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = i;
                    }
                }
                MutableInteractionSource mutableInteractionSource16 = mutableInteractionSource2;
                final ToggleButtonColors toggleButtonColors15 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(847453268, i12, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:214)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534699333, "CC(remember):ToggleButton.kt#9igjgp");
                if ((29360128 & i12) == 8388608) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i111113 = iM852getDefaultRoleo7Vup1c;
                int i111114 = i12;
                Modifier modifier17 = modifier3;
                int i111115 = i111114 << 6;
                Shape shape17 = shape3;
                boolean z19 = z4;
                androidx.wear.compose.materialcore.ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function2, SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null), z19, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.6
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z110, boolean z111, Composer composer3, int i20) {
                        composer3.startReplaceGroup(1265496074);
                        ComposerKt.sourceInformation(composer3, "CP(1)221@10461L57:ToggleButton.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1265496074, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:221)");
                        }
                        State<Color> stateBackgroundColor = toggleButtonColors15.backgroundColor(z110, z111, composer3, i20 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateBackgroundColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, BorderStroke>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.7
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final BorderStroke invoke(boolean z110, boolean z111, Composer composer3, int i20) {
                        composer3.startReplaceGroup(-583917890);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-583917890, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:223)");
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return null;
                    }
                }, ToggleButtonDefaults.INSTANCE.m853getDefaultToggleButtonSizeD9Ej5fM(), mutableInteractionSource16, shape17, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7), ProvidersKt.provideScopeContent(toggleButtonColors15.contentColor(z4, z, composerStartRestartGroup, ((i111114 >> 9) & 14) | ((i111114 << 3) & 112) | ((i111114 >> 6) & 896)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton(), function3), composerStartRestartGroup, (i111115 & 234881024) | (i111114 & 14) | 1572864 | (i111114 & 112) | (i111114 & 7168) | (29360128 & i111115), 0);
                mutableInteractionSource2 = mutableInteractionSource16;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z19;
                composer2 = composerStartRestartGroup;
                shape4 = shape17;
                toggleButtonColors2 = toggleButtonColors15;
                i13 = i111113;
                modifier4 = modifier17;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) == 0) {
                    if (i15 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i7 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                        modifier3 = modifier2;
                    } else {
                        i12 = i4;
                        modifier3 = modifier2;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = i;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                    }
                    if (i7 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    }
                    if (i9 != 0) {
                        i12 = i4;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                        modifier3 = modifier2;
                    } else {
                        i12 = i4;
                        modifier3 = modifier2;
                        z4 = z3;
                        shape3 = shape2;
                        iM852getDefaultRoleo7Vup1c = i;
                    }
                }
                MutableInteractionSource mutableInteractionSource17 = mutableInteractionSource2;
                final ToggleButtonColors toggleButtonColors16 = toggleButtonColorsM856toggleButtonColorsoq7We08;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(847453268, i12, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:214)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534699333, "CC(remember):ToggleButton.kt#9igjgp");
                if ((29360128 & i12) == 8388608) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i111116 = iM852getDefaultRoleo7Vup1c;
                int i111117 = i12;
                Modifier modifier18 = modifier3;
                int i111118 = i111117 << 6;
                Shape shape18 = shape3;
                boolean z110 = z4;
                androidx.wear.compose.materialcore.ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function2, SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null), z110, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.6
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z111, boolean z112, Composer composer3, int i20) {
                        composer3.startReplaceGroup(1265496074);
                        ComposerKt.sourceInformation(composer3, "CP(1)221@10461L57:ToggleButton.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1265496074, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:221)");
                        }
                        State<Color> stateBackgroundColor = toggleButtonColors16.backgroundColor(z111, z112, composer3, i20 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateBackgroundColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, BorderStroke>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.7
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final BorderStroke invoke(boolean z111, boolean z112, Composer composer3, int i20) {
                        composer3.startReplaceGroup(-583917890);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-583917890, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:223)");
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return null;
                    }
                }, ToggleButtonDefaults.INSTANCE.m853getDefaultToggleButtonSizeD9Ej5fM(), mutableInteractionSource17, shape18, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7), ProvidersKt.provideScopeContent(toggleButtonColors16.contentColor(z4, z, composerStartRestartGroup, ((i111117 >> 9) & 14) | ((i111117 << 3) & 112) | ((i111117 >> 6) & 896)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton(), function3), composerStartRestartGroup, (i111118 & 234881024) | (i111117 & 14) | 1572864 | (i111117 & 112) | (i111117 & 7168) | (29360128 & i111118), 0);
                mutableInteractionSource2 = mutableInteractionSource17;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z110;
                composer2 = composerStartRestartGroup;
                shape4 = shape18;
                toggleButtonColors2 = toggleButtonColors16;
                i13 = i111116;
                modifier4 = modifier18;
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        ToggleButtonKt.m857ToggleButton2nuZEAM(z, function1, modifier4, z6, toggleButtonColors2, mutableInteractionSource3, shape4, i13, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
            }
        }
        i4 |= 196608;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 1572864) == 0) {
            shape2 = shape;
            if ((i3 & 64) == 0) {
                i14 = 524288;
            } else {
                i14 = 524288;
            }
            i4 |= i14;
        } else {
            shape2 = shape;
        }
        i9 = i3 & 128;
        if (i9 != 0) {
            i4 |= 12582912;
        } else if ((i2 & 12582912) == 0) {
            if (composerStartRestartGroup.changed(i)) {
                i10 = 8388608;
            } else {
                i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
            }
            i4 |= i10;
        }
        if ((i3 & 256) != 0) {
            i4 |= 100663296;
        } else if ((i2 & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i11 = 67108864;
            } else {
                i11 = 33554432;
            }
            i4 |= i11;
        }
        if ((38347923 & i4) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) == 0) {
                if (i15 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                }
                if (i7 != 0) {
                    mutableInteractionSource2 = null;
                }
                if ((i3 & 64) != 0) {
                    i4 &= -3670017;
                    shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                }
                if (i9 != 0) {
                    i12 = i4;
                    z4 = z3;
                    shape3 = shape2;
                    iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                    modifier3 = modifier2;
                } else {
                    i12 = i4;
                    modifier3 = modifier2;
                    z4 = z3;
                    shape3 = shape2;
                    iM852getDefaultRoleo7Vup1c = i;
                }
            } else {
                if (i15 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                }
                if (i7 != 0) {
                    mutableInteractionSource2 = null;
                }
                if ((i3 & 64) != 0) {
                    i4 &= -3670017;
                    shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                }
                if (i9 != 0) {
                    i12 = i4;
                    z4 = z3;
                    shape3 = shape2;
                    iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                    modifier3 = modifier2;
                } else {
                    i12 = i4;
                    modifier3 = modifier2;
                    z4 = z3;
                    shape3 = shape2;
                    iM852getDefaultRoleo7Vup1c = i;
                }
            }
            MutableInteractionSource mutableInteractionSource18 = mutableInteractionSource2;
            final ToggleButtonColors toggleButtonColors17 = toggleButtonColorsM856toggleButtonColorsoq7We08;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(847453268, i12, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:214)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534699333, "CC(remember):ToggleButton.kt#9igjgp");
            if ((29360128 & i12) == 8388608) {
                z5 = true;
            } else {
                z5 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i111119 = iM852getDefaultRoleo7Vup1c;
            int i1111110 = i12;
            Modifier modifier19 = modifier3;
            int i1111111 = i1111110 << 6;
            Shape shape19 = shape3;
            boolean z111 = z4;
            androidx.wear.compose.materialcore.ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function2, SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null), z111, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.6
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z112, boolean z113, Composer composer3, int i20) {
                    composer3.startReplaceGroup(1265496074);
                    ComposerKt.sourceInformation(composer3, "CP(1)221@10461L57:ToggleButton.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1265496074, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:221)");
                    }
                    State<Color> stateBackgroundColor = toggleButtonColors17.backgroundColor(z112, z113, composer3, i20 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return stateBackgroundColor;
                }
            }, new Function4<Boolean, Boolean, Composer, Integer, BorderStroke>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.7
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final BorderStroke invoke(boolean z112, boolean z113, Composer composer3, int i20) {
                    composer3.startReplaceGroup(-583917890);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-583917890, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:223)");
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return null;
                }
            }, ToggleButtonDefaults.INSTANCE.m853getDefaultToggleButtonSizeD9Ej5fM(), mutableInteractionSource18, shape19, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7), ProvidersKt.provideScopeContent(toggleButtonColors17.contentColor(z4, z, composerStartRestartGroup, ((i1111110 >> 9) & 14) | ((i1111110 << 3) & 112) | ((i1111110 >> 6) & 896)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton(), function3), composerStartRestartGroup, (i1111111 & 234881024) | (i1111110 & 14) | 1572864 | (i1111110 & 112) | (i1111110 & 7168) | (29360128 & i1111111), 0);
            mutableInteractionSource2 = mutableInteractionSource18;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z6 = z111;
            composer2 = composerStartRestartGroup;
            shape4 = shape19;
            toggleButtonColors2 = toggleButtonColors17;
            i13 = i111119;
            modifier4 = modifier19;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) == 0) {
                if (i15 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                }
                if (i7 != 0) {
                    mutableInteractionSource2 = null;
                }
                if ((i3 & 64) != 0) {
                    i4 &= -3670017;
                    shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                }
                if (i9 != 0) {
                    i12 = i4;
                    z4 = z3;
                    shape3 = shape2;
                    iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                    modifier3 = modifier2;
                } else {
                    i12 = i4;
                    modifier3 = modifier2;
                    z4 = z3;
                    shape3 = shape2;
                    iM852getDefaultRoleo7Vup1c = i;
                }
            } else {
                if (i15 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    toggleButtonColorsM856toggleButtonColorsoq7We08 = ToggleButtonDefaults.INSTANCE.m856toggleButtonColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, Constants.MAX_HOST_LENGTH);
                }
                if (i7 != 0) {
                    mutableInteractionSource2 = null;
                }
                if ((i3 & 64) != 0) {
                    i4 &= -3670017;
                    shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                }
                if (i9 != 0) {
                    i12 = i4;
                    z4 = z3;
                    shape3 = shape2;
                    iM852getDefaultRoleo7Vup1c = ToggleButtonDefaults.INSTANCE.m852getDefaultRoleo7Vup1c();
                    modifier3 = modifier2;
                } else {
                    i12 = i4;
                    modifier3 = modifier2;
                    z4 = z3;
                    shape3 = shape2;
                    iM852getDefaultRoleo7Vup1c = i;
                }
            }
            MutableInteractionSource mutableInteractionSource19 = mutableInteractionSource2;
            final ToggleButtonColors toggleButtonColors18 = toggleButtonColorsM856toggleButtonColorsoq7We08;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(847453268, i12, -1, "androidx.wear.compose.material.ToggleButton (ToggleButton.kt:214)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -534699333, "CC(remember):ToggleButton.kt#9igjgp");
            if ((29360128 & i12) == 8388608) {
                z5 = true;
            } else {
                z5 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt$ToggleButton$5$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, iM852getDefaultRoleo7Vup1c);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i1111112 = iM852getDefaultRoleo7Vup1c;
            int i1111113 = i12;
            Modifier modifier110 = modifier3;
            int i1111114 = i1111113 << 6;
            Shape shape110 = shape3;
            boolean z112 = z4;
            androidx.wear.compose.materialcore.ToggleButtonKt.m940ToggleButtonBxUkNYg(z, function2, SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, (Object) null), z112, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.6
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z113, boolean z114, Composer composer3, int i20) {
                    composer3.startReplaceGroup(1265496074);
                    ComposerKt.sourceInformation(composer3, "CP(1)221@10461L57:ToggleButton.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1265496074, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:221)");
                    }
                    State<Color> stateBackgroundColor = toggleButtonColors18.backgroundColor(z113, z114, composer3, i20 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return stateBackgroundColor;
                }
            }, new Function4<Boolean, Boolean, Composer, Integer, BorderStroke>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.7
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final BorderStroke invoke(boolean z113, boolean z114, Composer composer3, int i20) {
                    composer3.startReplaceGroup(-583917890);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-583917890, i20, -1, "androidx.wear.compose.material.ToggleButton.<anonymous> (ToggleButton.kt:223)");
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return null;
                }
            }, ToggleButtonDefaults.INSTANCE.m853getDefaultToggleButtonSizeD9Ej5fM(), mutableInteractionSource19, shape110, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7), ProvidersKt.provideScopeContent(toggleButtonColors18.contentColor(z4, z, composerStartRestartGroup, ((i1111113 >> 9) & 14) | ((i1111113 << 3) & 112) | ((i1111113 >> 6) & 896)), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton(), function3), composerStartRestartGroup, (i1111114 & 234881024) | (i1111113 & 14) | 1572864 | (i1111113 & 112) | (i1111113 & 7168) | (29360128 & i1111114), 0);
            mutableInteractionSource2 = mutableInteractionSource19;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z6 = z112;
            composer2 = composerStartRestartGroup;
            shape4 = shape110;
            toggleButtonColors2 = toggleButtonColors18;
            i13 = i1111112;
            modifier4 = modifier110;
        }
        mutableInteractionSource3 = mutableInteractionSource2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleButtonKt.ToggleButton.8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i20) {
                    ToggleButtonKt.m857ToggleButton2nuZEAM(z, function1, modifier4, z6, toggleButtonColors2, mutableInteractionSource3, shape4, i13, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                }
            });
        }
    }
}
